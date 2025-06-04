/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.UploadMultipleFilesService;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.UploadSingleObservationService;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.AortoOstialObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.BifurcationAngulationlt70Observation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.BifurcationObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.BluntStumpObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.BridgingObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.DiffuselyDiseasedSegmentListObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.DominanceSelectionObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.FirstTotalocclusionSegment;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.HeavyCalcificationObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.LengthObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.SelectedSegmentObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.SevereTortuosityObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.SidebranchObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.ThrombusObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.TotalOcclusionAgeObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.TotalOcclusionFirstSegmentVisualized;
import com.philips.hsdp.research.p360.syntaxscore.create.observation.TrifurcationObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.DiffuseDiseaseSubSyntaxScoreObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.LesionSubSyntaxScoreObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.SyntaxScoreObservation;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.TotalOcclusionSubSyntaxScoreObservation;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.enums.BifurcationMedina;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.enums.Dominance;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.enums.SideBranchAtTheOriginOfOcclusion;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.enums.TriState;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * 
 * @author Sunil
 * @author Raj Kumar
 *
 */
@RestController
@SecurityRequirement(name = "SyntaxScore API")
public class SyntaxScoreObservationController {
	
	/**
	 * This function is used to Generate Observation for
	 * segments-diseased-for-lesion
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@Hidden
	@PostMapping(value = "/segments-diseased-for-lesion-app")
	@Operation(summary = "Generate Observation for segments-diseased-for-lesion")
	String selectedSegments(String segmentString) throws JsonProcessingException, UnsupportedEncodingException {
		SelectedSegmentObservation selectedSegmentObservation = new SelectedSegmentObservation(segmentString);
		return selectedSegmentObservation.createObservation();
	}
	/**
	 * This function is used to Generate Observation for
	 * segments-diseased-for-lesion
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * @param @RequestParam MultipartFile : to Upload multiple files
	 * @return String observation
	 * @throws IOException 
	 */
	@PostMapping(value = "/segments-diseased-for-lesion", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "Generate Observation for segments-diseased-for-lesion")
	String selectedSegments(@RequestParam MultipartFile file) throws IOException {
		UploadSingleObservationService uploadSingleObservationService = new UploadSingleObservationService();
		String syntaxScoreObservation = uploadSingleObservationService.convert(file);
		SelectedSegmentObservation selectedSegmentObservation = new SelectedSegmentObservation(syntaxScoreObservation);
		return selectedSegmentObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for
	 * first-segment-number-of-total-occlusion
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * @param @RequestParam MultipartFile : to Upload multiple files
	 * @return String observation
	 */
	@Hidden
	@PostMapping(value = "/first-segment-number-of-total-occlusion-app")
	@Operation(summary = "Generate Observation for first-segment-number-of-total-occlusion")
	String firstSegmentNumberOfTotalOcclusion(String segmentString)
			throws JsonProcessingException, UnsupportedEncodingException {
		FirstTotalocclusionSegment firstTotalocclusionSegment = new FirstTotalocclusionSegment(segmentString);
		return firstTotalocclusionSegment.createObservation();
	}
	
	/**
	 * This function is used to Generate Observation for
	 * first-segment-number-of-total-occlusion
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 * @throws IOException 
	 */
	@PostMapping(value = "/first-segment-number-of-total-occlusion", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "Generate Observation for first-segment-number-of-total-occlusion")
	String firstSegmentNumberOfTotalOcclusion(@RequestParam MultipartFile file) throws IOException {
		UploadSingleObservationService uploadSingleObservationService = new UploadSingleObservationService();
		String syntaxScoreObservation = uploadSingleObservationService.convert(file);
		FirstTotalocclusionSegment firstTotalocclusionSegment = new FirstTotalocclusionSegment(syntaxScoreObservation);
		return firstTotalocclusionSegment.createObservation();
	}

	/**
	 * This function is used to Generate Observation for
	 * age-of-total-occlusion-gt-3months
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/age-of-total-occlusion-gt-3months")
	@Operation(summary = "Generate Observation for age-of-total-occlusion-gt-3months")
	public String ageOfTOGt3Months(TriState codeValue, int lesionNumber) {
		TotalOcclusionAgeObservation totalOcclusionAgeObservation = new TotalOcclusionAgeObservation(codeValue);
		return totalOcclusionAgeObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for blunt-stump
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/blunt-stump")
	@Operation(summary = "Generate Observation for blunt-stump")
	public String bluntStump(boolean present, int lesionNumber) {
		BluntStumpObservation bluntStumpObservation = new BluntStumpObservation(present);
		return bluntStumpObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for bridging
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/bridging")
	@Operation(summary = "Generate Observation for bridging")
	public String bridging(boolean present, int lesionNumber) {
		BridgingObservation bridgingObservation = new BridgingObservation(present);
		return bridgingObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for
	 * sidebranch-at-the-origin-of-occlusion
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/sidebranch-at-the-origin-of-occlusion")
	@Operation(summary = "Generate Observation for sidebranch-at-the-origin-of-occlusion")
	String sideBranchAtTheOriginOfOcclusion(SideBranchAtTheOriginOfOcclusion codeValue, int lesionNumber) {
		SidebranchObservation sidebranchObservation = new SidebranchObservation(codeValue);
		return sidebranchObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for trifurcation
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/trifurcation")
	@Operation(summary = "Generate Observation for trifurcation")
	String trifurcation(boolean present, int value) {
		TrifurcationObservation trifurcationObservation = new TrifurcationObservation(present, value);
		return trifurcationObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for bifurcation
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/bifurcation")
	@Operation(summary = "Generate Observation for bifurcation")
	public String bifurcationOstial(boolean present, BifurcationMedina value, String encodedString) {
		BifurcationObservation bifurcationObservation = new BifurcationObservation(present, value, encodedString);
		return bifurcationObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for
	 * bifurcation_angulation_lt_70_deg
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/bifurcation_angulation_lt_70_deg")
	@Operation(summary = "Generate Observation for bifurcation_angulation_lt_70_deg")
	public String bifurcationAngulationLt70(boolean present, int lesionNumber) {
		BifurcationAngulationlt70Observation bifurcationAngulationlt70Observation = new BifurcationAngulationlt70Observation(
				present);
		return bifurcationAngulationlt70Observation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for aorto-ostial
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/aorto-ostial")
	@Operation(summary = "Generate Observation for aorto-ostial")
	public String aortoOstial(boolean present, int lesionNumber) {
		AortoOstialObservation aortoOstialObservation = new AortoOstialObservation(present);
		return aortoOstialObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for severe-tortuosity
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/severe-tortuosity")
	@Operation(summary = "Generate Observation for severe-tortuosity")
	String severeTortuosity(boolean present, int lesionNumber) {
		SevereTortuosityObservation severeTortuosityObservation = new SevereTortuosityObservation(present);
		return severeTortuosityObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for dominance
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/dominance")
	@Operation(summary = "Generate Observation for dominance")
	public String selectedDominance(Dominance selectedDominance) {
		DominanceSelectionObservation dominanceSelectionObservation = new DominanceSelectionObservation(
				selectedDominance);
		return dominanceSelectionObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for lengthGt20mm
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/lengthGt20mm")
	@Operation(summary = "Generate Observation for lengthGt20mm")
	String lengthGt20mm(boolean present, int lesionNumber) {
		LengthObservation lengthObservation = new LengthObservation(present);
		return lengthObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for heavy-calcification
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/heavy-calcification")
	@Operation(summary = "Generate Observation for heavy-calcification")
	String heavyCalcification(boolean present, int lesionNumber) {
		HeavyCalcificationObservation heavyCalcificationObservation = new HeavyCalcificationObservation(present);
		return heavyCalcificationObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for thrombus
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@PostMapping(value = "/thrombus")
	@Operation(summary = "Generate Observation for thrombus")
	String thrombusOstial(boolean present, int lesionNumber) {

		ThrombusObservation thrombusObservation = new ThrombusObservation(present);
		return thrombusObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for
	 * diffusely-diseased-narrowed-segment
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
//	@PostMapping(value = "/diffusely-diseased-narrowed-segment")
//	@Operation(summary = "Generate Observation for diffusely-diseased-narrowed-segment")
//	String diffuselyDiseasedAndNarrowedSegment(boolean present) {
//		DiffuselyDiseasedObservation diffuselyDiseasedObservation = new DiffuselyDiseasedObservation(present);
//		return diffuselyDiseasedObservation.createObservation();
//	}

	/**
	 * This function is used to Generate Observation for
	 * diffusly-diseased-narrowed-segments-list
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@Hidden
	@PostMapping(value = "/diffusly-diseased-narrowed-segments-list-app")
	@Operation(summary = "Generate Observation for diffusly-diseased-narrowed-segments-list")
	String segments(String segmentString) throws JsonProcessingException, UnsupportedEncodingException {
		DiffuselyDiseasedSegmentListObservation diffuselyDiseasedSegmentListObservation = new DiffuselyDiseasedSegmentListObservation(
				segmentString);
		return diffuselyDiseasedSegmentListObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for
	 * diffusly-diseased-narrowed-segments-list
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * @param @RequestParam MultipartFile : to Upload file
	 * @return String observation
	 * @throws IOException
	 */
	@PostMapping(value = "/diffusly-diseased-narrowed-segments-list", consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "Generate Observation for diffusly-diseased-narrowed-segments-list")
	String segments(@RequestPart(required = true) MultipartFile file) throws IOException {
		UploadSingleObservationService uploadSingleObservationService = new UploadSingleObservationService();
		String syntaxScoreObservation = uploadSingleObservationService.convert(file);
		DiffuselyDiseasedSegmentListObservation diffuselyDiseasedSegmentListObservation = new DiffuselyDiseasedSegmentListObservation(
				syntaxScoreObservation);
		return diffuselyDiseasedSegmentListObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for
	 * subsyntax-score-diffuselydiseased
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@Hidden
	@PostMapping(value = "/subsyntax-score-diffuselydiseased-app")
	@Operation(summary = "Generate Observation for subsyntax-score-diffuselydiseased")
	String subsyntaxScoreDiffuselydiseased(boolean present, String diffuselydiseasedString) {
		DiffuseDiseaseSubSyntaxScoreObservation diffuseDiseaseSubSyntaxScoreObservation = new DiffuseDiseaseSubSyntaxScoreObservation(
				present, diffuselydiseasedString);
		return diffuseDiseaseSubSyntaxScoreObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for subsyntax-score-lesion
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * @param @RequestParam MultipartFile : to Upload multiple files
	 * @return String observation
	 */
	@PostMapping(value = "/subsyntax-score-diffuselydiseased", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "Generate Observation for subsyntax-score-diffuselydiseased")
	String subsyntaxScoreDiffuselydiseased(@RequestPart(required = true) MultipartFile[] file, boolean present)
			throws IOException {
		UploadMultipleFilesService xmlToJsonConverterService = new UploadMultipleFilesService();
		String syntaxScoreObservation = xmlToJsonConverterService.convert(file);
		DiffuseDiseaseSubSyntaxScoreObservation diffuseDiseaseSubSyntaxScoreObservation = new DiffuseDiseaseSubSyntaxScoreObservation(
				present, syntaxScoreObservation);
		return diffuseDiseaseSubSyntaxScoreObservation.createObservation();
	}

	@Hidden
	@PostMapping(value = "/subsyntax-score-lesion-app")
	@Operation(summary = "Generate Observation for subsyntax-score-lesion")
	String lesionTotalOcclusionSubSyntaxScore(String lesionObservationlist, int lesionNumber) {
		LesionSubSyntaxScoreObservation lesionTotalOcclusionSubSyntaxScoreObservation = new LesionSubSyntaxScoreObservation(
				lesionObservationlist);
		return lesionTotalOcclusionSubSyntaxScoreObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for subsyntax-score-lesion
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	@PostMapping(value = "/subsyntax-score-lesion", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "Generate Observation for subsyntax-score-lesion")
	String lesionTotalOcclusionSubSyntaxScore(@RequestPart(required = true) MultipartFile[] file, int lesionNumber) throws IOException {
		UploadMultipleFilesService xmlToJsonConverterService = new UploadMultipleFilesService();
		String syntaxScoreObservationXml = xmlToJsonConverterService.convert(file);
		LesionSubSyntaxScoreObservation lesionTotalOcclusionSubSyntaxScoreObservation = new LesionSubSyntaxScoreObservation(
				syntaxScoreObservationXml);
		
		return lesionTotalOcclusionSubSyntaxScoreObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for
	 * subsyntax-score-totalOcculation-new
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@Hidden
	@PostMapping(value = "/subsyntax-score-totalOcculation-app")
	@Operation(summary = "Generate Observation for subsyntax-score-totalOcculation-new")
	String lesionSyntaxSubscoreTotalOcclusion(String toObservationList, boolean present) {
		TotalOcclusionSubSyntaxScoreObservation lesionSyntaxSubscoreTotalOcclusion = new TotalOcclusionSubSyntaxScoreObservation(
				present, toObservationList);
		return lesionSyntaxSubscoreTotalOcclusion.createObservation();
	}

	/**
	 * This function is used to Generate Observation for
	 * subsyntax-score-totalOcculation
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * @param @RequestParam MultipartFile : to Upload multiple files
	 * @return String observation
	 * @throws IOException
	 */
	@PostMapping(value = "/subsyntax-score-totalOcclusion", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "Generate Observation for subsyntax-score-totalOcculation")
	String lesionSyntaxSubscoreTotalOcclusion(@RequestPart(required = true) MultipartFile[] file, boolean present) throws IOException {
		UploadMultipleFilesService xmlToJsonConverterService = new UploadMultipleFilesService();
		String observationXml = xmlToJsonConverterService.convert(file);
		TotalOcclusionSubSyntaxScoreObservation lesionSyntaxSubscoreTotalOcclusion = new TotalOcclusionSubSyntaxScoreObservation(
				present, observationXml);
		return lesionSyntaxSubscoreTotalOcclusion.createObservation();
	}

	/**
	 * This function is used to Generate Observation for syntaxscore
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@Hidden
	@PostMapping(value = "/syntaxscore-app")
	@Operation(summary = "Generate Observation for syntaxscore")
	public String syntaxScore(String observationList) {
		SyntaxScoreObservation syntaxScoreObservation = new SyntaxScoreObservation(observationList);
		return syntaxScoreObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for syntaxscore
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * @param @RequestParam MultipartFile : to Upload multiple files
	 * @return String observation
	 */
	
	@PostMapping(value = "/syntaxscore-observation", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "Generate Observation for syntaxscore")
	public String syntaxScore(@RequestPart(required = true) MultipartFile[] file)
			throws IOException {
		UploadMultipleFilesService xmlToJsonConverterService = new UploadMultipleFilesService();
		String observationXml = xmlToJsonConverterService.convert(file);
		SyntaxScoreObservation syntaxScoreObservation = new SyntaxScoreObservation(observationXml);
		return syntaxScoreObservation.createObservation();
	}

	/**
	 * This function is used to Generate Observation for
	 * total-occlusion-first-segment-visualized
	 * 
	 * @inheritDoc : override super class SyntaxScoreObservationController.
	 * 
	 * @return String observation
	 */
	@Hidden
	@PostMapping(value = "/total-occlusion-first-segment-visualized")
	@Operation(summary = "Generate Observation for total-occlusion-first-segment-visualized")
	String totalOcclusionFirstSegmentVisualized(String segmentString)
			throws JsonProcessingException, UnsupportedEncodingException {
		TotalOcclusionFirstSegmentVisualized totalOcclusionFirstSegmentVisualized = new TotalOcclusionFirstSegmentVisualized(
				segmentString);
		return totalOcclusionFirstSegmentVisualized.createObservation();
	}
}