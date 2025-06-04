/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.InputBundleService;
import com.philips.hsdp.research.p360.syntaxscore.constant.InputBundleConstant;
import com.philips.hsdp.research.p360.syntaxscore.create.bundle.InputBundle;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.Lesion;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.LesionProfile;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.Segment;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.SegmentDefinition;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.Segments;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.SyntaxScoreProfile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/* @author Priyanka M & Ankita S */
@RestController
@SecurityRequirement(name = "SyntaxScore API")
public class InputBundleController {

	private static Logger log = LoggerFactory.getLogger(InputBundleController.class);

	@Autowired
	InputBundleService inputBundleService;

	@PostMapping(value = "/syntaxscore-input-bundle", headers = { "api-version=1" })
	@Operation(summary = "Generate input bundle")
	ResponseEntity<String> getPatient(@RequestBody String jsonString, @RequestHeader("Content-Type") String contentType,
			@RequestHeader("Accept") String accept) throws IOException, ParseException {

		// Convert test data to data model
		ObjectMapper objectMapper = new ObjectMapper();
		SyntaxScoreProfile syntaxScoreProfile = objectMapper.readValue(jsonString, SyntaxScoreProfile.class);

		List<String> syntaxScoreObservationList = new ArrayList<>();
		List<String> obsVariables = new ArrayList<>();

		// 1. Get Dominance observation based on user selection
		String dominanceObservation = inputBundleService.getILSDominanceObservation(syntaxScoreProfile);
		syntaxScoreObservationList.add(dominanceObservation);
		obsVariables.add(dominanceObservation);

		// 2. Segment selection for lesion 'i' : Create LesionSyntaxSubscore for each
		// SegmentDefinition
		SegmentDefinition segmentDefinition = new SegmentDefinition(syntaxScoreProfile.getSelectedDominance());
		List<Segment> segmentDefList = segmentDefinition.getSegmentDefinition();

		HashMap<String, String> lesionSubSyntaxScoreObservation = new HashMap<>();
		List<LesionProfile> lesions = syntaxScoreProfile.getLesionProfile();
		if (lesions != null) {
			lesions.forEach(lesion -> {
				HashMap<String, String> subscoreProfilesForLesions = new HashMap<>();
				Lesion lesionObj = lesion.getLesion();
				List<Segments> segments = lesionObj.getSegmentsList();
				try {
					// selectedSegmentObservation
					for (Segments segment : segments) {
						String selectedSegmentObservationXml = inputBundleService
								.getILSSelectedSegmentsObservation(segment.getSegment());
						obsVariables.add(selectedSegmentObservationXml);
						subscoreProfilesForLesions.put("selectedSegmentsObservationLesion" + lesionObj.getNumber()
						+ "Segment" + segment.getSegment().getNumber(), selectedSegmentObservationXml);
					}

					// TotalOcclusionObservation
					Map<String, String> syntaxSubScoretotalOcclusion = new HashMap<>();

					// first_totalocclusion_segment_number Observation
					String firstTOsegmentNumberObservation = inputBundleService
							.createfirstTOsegmentNumberObservation(lesionObj, segmentDefList);
					obsVariables.add(firstTOsegmentNumberObservation);
					syntaxSubScoretotalOcclusion.put("firstTOsegmentNumberObservation" + lesionObj.getNumber(),
							firstTOsegmentNumberObservation);

					// AgeOfTOGt3MonthsObservation
					String ageOfTOGt3MonthsObservation = inputBundleService
							.createAgeOfTOGt3MonthsObservation(lesionObj);
					obsVariables.add(ageOfTOGt3MonthsObservation);
					syntaxSubScoretotalOcclusion.put("ageOfTOGt3MonthsObservation" + lesionObj.getNumber(),
							ageOfTOGt3MonthsObservation);

					// BluntStumpObservation
					String bluntStumpObservation = inputBundleService.createBluntStumpObservation(lesionObj);
					obsVariables.add(bluntStumpObservation);
					syntaxSubScoretotalOcclusion.put("bluntStumpObservation" + lesionObj.getNumber(),
							bluntStumpObservation);

					// bridgingObservation
					String bridgingObservation = inputBundleService.createBridgingObservation(lesionObj);
					obsVariables.add(bridgingObservation);
					syntaxSubScoretotalOcclusion.put("bridgingObservation" + lesionObj.getNumber(),
							bridgingObservation);

					// first_segment_number_beyond_totalocclusion_visualized Observation
					String firstSegmentTOVisualized = inputBundleService.createfirstSegmentTOVisualized(lesionObj,
							segmentDefList);
					obsVariables.add(firstSegmentTOVisualized);
					syntaxSubScoretotalOcclusion.put("firstSegmentTOVisualized" + lesionObj.getNumber(),
							firstSegmentTOVisualized);

					// SidebranchObservation
					String sidebranchObservation = inputBundleService.createSidebranchObservation(lesionObj);
					obsVariables.add(sidebranchObservation);
					syntaxSubScoretotalOcclusion.put("sidebranchObservation" + lesionObj.getNumber(),
							sidebranchObservation);

					// Writing totalOcclusion observation as file
					syntaxSubScoretotalOcclusion.values().removeAll(Collections.singleton(""));

					// lesionSyntaxSubscoreTotalOcclusionObservation
					String lesionSyntaxSubscoreTotalOcclusionObservation = inputBundleService
							.createLesionSubscoreTOobservation(syntaxSubScoretotalOcclusion, lesionObj);
					obsVariables.add(lesionSyntaxSubscoreTotalOcclusionObservation);
					subscoreProfilesForLesions.put(InputBundleConstant.SYNTAXSCORETO + lesionObj.getNumber(),
							lesionSyntaxSubscoreTotalOcclusionObservation);

					// trifurcationObservation *******
					String trifurcationObservation = inputBundleService.createtrifurcationObservation(lesionObj);
					obsVariables.add(trifurcationObservation);
					subscoreProfilesForLesions.put("trifurcationObservation" + lesionObj.getNumber(),
							trifurcationObservation);

					// bifurcationObservation *********** new one as per the new profile updates
					// bifurcationAngulationLt70Observation
					String bifurcationAngulationLt70Observation = inputBundleService
							.createBifurcationAngulationObservation(lesionObj);
					obsVariables.add(bifurcationAngulationLt70Observation);

					// bifurcationObservation final observations
					String bifurcationObservation = inputBundleService.createBifurcationObservation(lesionObj,
							bifurcationAngulationLt70Observation);
					obsVariables.add(bifurcationObservation);
					subscoreProfilesForLesions.put("bifurcationObservation" + lesionObj.getNumber(),
							bifurcationObservation);

					// AortoOstialObservation
					String aortoOstialObservation = inputBundleService.createAortoOstialObservation(lesionObj);
					obsVariables.add(aortoOstialObservation);
					subscoreProfilesForLesions.put("AortoOstialObservation" + lesionObj.getNumber(),
							aortoOstialObservation);

					// severeTortuosityObservation
					String severeTortuosityObservation = inputBundleService
							.createSevereTortuosityObservation(lesionObj);
					obsVariables.add(severeTortuosityObservation);
					subscoreProfilesForLesions.put("severeTortuosityObservation" + lesionObj.getNumber(),
							severeTortuosityObservation);

					// lengthObservation
					String lengthObservation = inputBundleService.createLengthObservation(lesionObj);
					obsVariables.add(lengthObservation);
					subscoreProfilesForLesions.put("lengthObservation" + lesionObj.getNumber(), lengthObservation);

					// heavyCalcificationObservation
					String heavyCalcificationObservation = inputBundleService
							.createHeavyCalcificationObservation(lesionObj);
					obsVariables.add(heavyCalcificationObservation);
					subscoreProfilesForLesions.put("heavyCalcificationObservation" + lesionObj.getNumber(),
							heavyCalcificationObservation);

					// thrombusObservation
					String thrombusObservation = inputBundleService.createThrombusObservation(lesionObj);
					obsVariables.add(thrombusObservation);
					subscoreProfilesForLesions.put("thrombusObservation" + lesionObj.getNumber(), thrombusObservation);

					// Writing individual observation as file
					subscoreProfilesForLesions.values().removeAll(Collections.singleton(""));

					// LesionSyntaxSubscoreObservation
					List<String> lesionObservationlist = new ArrayList<>(subscoreProfilesForLesions.values());
					lesionObservationlist.removeAll(Collections.singleton(""));
					String lesionSyntaxSubscoreObservation = inputBundleService
							.getLesionSyntaxSubscoreObservation(lesionObservationlist, lesionObj.getNumber());
					obsVariables.add(lesionSyntaxSubscoreObservation);
					lesionSubSyntaxScoreObservation.put("lesionSyntaxSubscoreObservation" + lesionObj.getNumber(),
							lesionSyntaxSubscoreObservation);
					syntaxScoreObservationList.add(lesionSyntaxSubscoreObservation);
					log.info("lesionSyntaxSubscoreObservation created for lesion" + lesionObj.getNumber());
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			});
		}

		// 3. Create SubScore for 'Diffusely diseased and narrow segments' subscore
		HashMap<String, String> diffuseDiseaseSubSyntaxScoreObservation = new HashMap<>();

		// diffuselyDiseasedSegmentList Observation
		inputBundleService.createDiffuselyDiseasedSegmentList(syntaxScoreProfile, segmentDefList,
				diffuseDiseaseSubSyntaxScoreObservation);
		List<String> diseaseSegmentsObservationlist = new ArrayList<>(diffuseDiseaseSubSyntaxScoreObservation.values());
		obsVariables.addAll(diseaseSegmentsObservationlist);

		// Subscore diffuseDiseaseSubSyntaxScoreObservation *********
		String subsyntaxScoreDiffuselydiseasedXML = "";
		try {
			subsyntaxScoreDiffuselydiseasedXML = inputBundleService.getILSSubSyntaxScoreDiffusedDiseasedObservation(
					syntaxScoreProfile.getDiffuselyDiseasedNarrowedSegment(), diseaseSegmentsObservationlist);
			obsVariables.add(subsyntaxScoreDiffuselydiseasedXML);
			syntaxScoreObservationList.add(subsyntaxScoreDiffuselydiseasedXML);
			log.info("SubSyntaxScore DiffuseDiseased Observation created");
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		obsVariables.removeAll(Collections.singleton(null));
		obsVariables.removeAll(Collections.singleton(""));
		InputBundle inputBundle = new InputBundle();
		String bundleString = inputBundle.createBundle(obsVariables, contentType);
		log.info(" *** Completed *** ");
		return new ResponseEntity<>(bundleString, HttpStatus.OK);
	}
}