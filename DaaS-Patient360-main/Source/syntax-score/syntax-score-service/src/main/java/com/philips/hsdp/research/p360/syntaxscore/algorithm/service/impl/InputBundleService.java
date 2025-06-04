/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.philips.hsdp.research.p360.syntaxscore.constant.InputBundleConstant;
import com.philips.hsdp.research.p360.syntaxscore.controller.RestClient;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.DiffuselyDiseasedNarrowedSegment;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.Lesion;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.Segment;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.SyntaxScoreProfile;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.enums.BifurcationMedina;

/* @author Sunil K & Raj K */
@Service
public class InputBundleService {

	private static Logger log = LoggerFactory.getLogger(InputBundleService.class);

	/**
	 * Create DiffuselyDiseasedSegmentList Observation and adds it to the
	 * diffuseDiseased list
	 * 
	 * @param syntaxScoreProfile
	 * @param segmentDefList
	 * @param diffuseDiseaseSubSyntaxScoreObservation
	 */
	public void createDiffuselyDiseasedSegmentList(SyntaxScoreProfile syntaxScoreProfile, List<Segment> segmentDefList,
			Map<String, String> diffuseDiseaseSubSyntaxScoreObservation) {
		List<String> diffusedsegList = syntaxScoreProfile.getDiffuselyDiseasedNarrowedSegment()
				.getDiffuselyDiseasedNarrowedSegmentList();
		segmentDefList.forEach(segment -> {
			for (String diffusedSegNumber : diffusedsegList)
				if (segment.getNumber().equalsIgnoreCase(diffusedSegNumber)) {
					String diffuselySegmentList;
					try {
						diffuselySegmentList = getILSDiffusedSegmentObservation(segment);
						diffuseDiseaseSubSyntaxScoreObservation.put("diffuselySegmentList" + segment.getNumber(),
								diffuselySegmentList);
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				}
		});
	}

	public String createThrombusObservation(Lesion lesionObj) throws IOException {
		String thrombusObservation = "";
		if (lesionObj.getThrombus() != null) {
			thrombusObservation = getILSThrombusObservation(lesionObj);
		}
		return thrombusObservation;
	}

	public String createHeavyCalcificationObservation(Lesion lesionObj) throws IOException {
		String heavyCalcificationObservation = "";
		if (lesionObj.getHeavyCalcification() != null) {
			heavyCalcificationObservation = getILSHeavyCalcificationObservation(lesionObj);
		}
		return heavyCalcificationObservation;
	}

	public String createLengthObservation(Lesion lesionObj) throws IOException {
		String lengthObservation = "";
		if (lesionObj.getLengthGt20mm() != null) {
			lengthObservation = getILSLengthObservation(lesionObj);
		}
		return lengthObservation;
	}

	public String createSevereTortuosityObservation(Lesion lesionObj) throws IOException {
		String severeTortuosityObservation = "";
		if (lesionObj.getSevereTortuosity() != null) {
			severeTortuosityObservation = getILSSevereTortuosityObservation(lesionObj);
		}
		return severeTortuosityObservation;
	}

	public String createAortoOstialObservation(Lesion lesionObj) throws IOException {
		String aortoOstialObservation = "";
		if (lesionObj.getAortoOstialLesion() != null) {
			aortoOstialObservation = getILSAortoOstialObservation(lesionObj);
		}
		return aortoOstialObservation;
	}

	public String createBifurcationObservation(Lesion lesionObj, String bifurcationAngulationLt70Observation)
			throws IOException {
		String bifurcationObservation = "";
		String bifurcationAngulationLt70Obs = "";
		if (lesionObj.getBifurcation() != null) {
			bifurcationAngulationLt70Obs = bifurcationAngulationLt70Observation;
			bifurcationObservation = getILSBifurcationObservation(lesionObj, bifurcationAngulationLt70Obs);
		}
		return bifurcationObservation;
	}

	public String createBifurcationAngulationObservation(Lesion lesionObj) throws IOException {
		String bifurcationAngulationLt70Observation = "";
		if (lesionObj.getBifurcationMedina() != null) {
			bifurcationAngulationLt70Observation = getILSBifurcationAngulationLt70Observation(lesionObj);
		}
		return bifurcationAngulationLt70Observation;
	}

	public String createtrifurcationObservation(Lesion lesionObj) throws IOException {
		String trifurcationObservation = "";
		if (lesionObj.getTrifurcation() != null) {
			trifurcationObservation = getILSTrifurcationObservation(lesionObj);
		}
		return trifurcationObservation;
	}

	public String createLesionSubscoreTOobservation(Map<String, String> syntaxSubScoretotalOcclusion, Lesion lesionObj)
			throws IOException {
		String lesionSyntaxSubscoreTotalOcclusionObservation = "";
		List<String> toOcclusionObservations = new ArrayList<>(syntaxSubScoretotalOcclusion.values());
		if (syntaxSubScoretotalOcclusion.size() != 0 && !syntaxSubScoretotalOcclusion.isEmpty()) {
			lesionSyntaxSubscoreTotalOcclusionObservation = syntaxSubScoretotalOcclusionObservation(
					toOcclusionObservations, lesionObj.getTotalOcclusion());
		}
		return lesionSyntaxSubscoreTotalOcclusionObservation;
	}

	public String createSidebranchObservation(Lesion lesionObj) throws IOException {
		String sidebranchObservation = "";
		if (lesionObj.getSidebranchAtTheOriginOfOcclusion() != null) {
			sidebranchObservation = getILSSidebranchObservation(lesionObj);
		}
		return sidebranchObservation;
	}

	public String createfirstSegmentTOVisualized(Lesion lesionObj, List<Segment> segmentDefList) throws IOException {
		String firstSegmentTOVisualized = "";
		Segment segmentForTOVisualized = new Segment();
		if (lesionObj.getFirstSegmentNumberBeyondTotalOcclusionVisualized() != null
				&& (!lesionObj.getFirstSegmentNumberBeyondTotalOcclusionVisualized().isEmpty())
				&& !lesionObj.getFirstSegmentNumberBeyondTotalOcclusionVisualized().equalsIgnoreCase("None")) {
			for (Segment segmentInDef : segmentDefList) {
				if (segmentInDef.getNumber()
						.equalsIgnoreCase(lesionObj.getFirstSegmentNumberBeyondTotalOcclusionVisualized())) {
					segmentForTOVisualized = segmentInDef;
				}
			}
			firstSegmentTOVisualized = getILSfirstSegmentTOVisualizedObservation(segmentForTOVisualized);
		}
		return firstSegmentTOVisualized;
	}

	public String createBridgingObservation(Lesion lesionObj) throws IOException {
		String bridgingObservation = "";
		if (lesionObj.getBridging() != null) {
			bridgingObservation = getILSBridgingObservation(lesionObj);
		}
		return bridgingObservation;
	}

	public String createBluntStumpObservation(Lesion lesionObj) throws IOException {
		String bluntStumpObservation = "";
		if (lesionObj.getBluntStump() != null) {
			bluntStumpObservation = getILSBluntStumpObservation(lesionObj);
		}
		return bluntStumpObservation;
	}

	public String createAgeOfTOGt3MonthsObservation(Lesion lesionObj) throws IOException {
		String ageOfTOGt3MonthsObservation = "";
		if (lesionObj.getIsTotalOcclusionAgeGt3Months() != null) {
			ageOfTOGt3MonthsObservation = getILSAgeOfTOGt3MonthsObservation(lesionObj);
		}
		return ageOfTOGt3MonthsObservation;
	}

	public String createfirstTOsegmentNumberObservation(Lesion lesionObj, List<Segment> segmentDefList)
			throws IOException {
		String firstTOsegmentNumberObservation = "";
		Segment segmentForFirstTO = null;
		if (lesionObj.getFirstTotalOcclusionSegmentNumber() != null) {
			for (Segment segmentInDef : segmentDefList) {
				if (segmentInDef.getNumber().equalsIgnoreCase(lesionObj.getFirstTotalOcclusionSegmentNumber()))
					segmentForFirstTO = segmentInDef;
			}
			firstTOsegmentNumberObservation = getILSfirstTOsegmentNumberObservation(segmentForFirstTO);
		}
		return firstTOsegmentNumberObservation;
	}

	/**
	 * Makes a rest call to generate SyntaxScore observation
	 * 
	 * @param syntaxScoreObservationList
	 * @return String Observation xml
	 * @throws IOException
	 */
	public String getILSSyntaxScoreObservation(List<String> syntaxScoreObservationList) throws IOException {
		String listString = String.join(", ", syntaxScoreObservationList);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response = RestClient
				.post(new URL(InputBundleConstant.HOSTNAME + "/syntaxscore-app?observationList=" + encodedString));
		String syntaxScoreObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			syntaxScoreObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "SyntaxScoreObservationXml");
		}
		return syntaxScoreObservationXml;
	}

	/**
	 * Makes a rest call to generate SubSyntaxScoreDiffusedDiseased observation
	 * 
	 * @param diffuselyDiseasedNarrowedSegment
	 * @param diffuseDiseaseObservationlist
	 * @return String Observation xml
	 * @throws IOException
	 */
	public String getILSSubSyntaxScoreDiffusedDiseasedObservation(
			DiffuselyDiseasedNarrowedSegment diffuselyDiseasedNarrowedSegment,
			List<String> diffuseDiseaseObservationlist) throws IOException {
		String subScorediffusedObservationXml = "";

		String listString = String.join(", ", diffuseDiseaseObservationlist);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response = RestClient.post(
				new URL(InputBundleConstant.HOSTNAME + "/subsyntax-score-diffuselydiseased-app?diffuselydiseasedString="
						+ encodedString + "&present=" + diffuselyDiseasedNarrowedSegment.getPresent()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			subScorediffusedObservationXml = response.getEntity().toString();

		} else {
			handleException(response, InputBundleConstant.DOMINANCE);
		}
		return subScorediffusedObservationXml;
	}

	/**
	 * Makes a rest call to generate LesionSyntaxSubscore observation
	 * 
	 * @param lesionObservationlist, lesionNumber
	 * @return String Observation xml
	 * @throws IOException
	 */
	public String getLesionSyntaxSubscoreObservation(List<String> lesionObservationlist, int lesionNumber)
			throws IOException {
		String listString = String.join(", ", lesionObservationlist);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response = RestClient
				.post(new URL(InputBundleConstant.HOSTNAME + "/subsyntax-score-lesion-app?lesionObservationlist="
						+ encodedString + InputBundleConstant.LESION_NUMBER + lesionNumber));
		String lesionObservationlistXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			lesionObservationlistXml = response.getEntity().toString();
		} else {
			handleException(response, InputBundleConstant.DOMINANCE);
		}
		return lesionObservationlistXml;
	}

	/**
	 * Makes a rest call to generate SubScoretotalOcclusion observation
	 * 
	 * @param syntaxSubScoretotalOcclusion, lesionNumber
	 * @return String Observation xml
	 * @throws IOException
	 */
	private String syntaxSubScoretotalOcclusionObservation(List<String> syntaxSubScoretotalOcclusion, Boolean present)
			throws IOException {
		String listString = String.join(", ", syntaxSubScoretotalOcclusion);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response = RestClient.post(new URL(InputBundleConstant.HOSTNAME
				+ "/subsyntax-score-totalOcculation-app?toObservationList=" + encodedString + "&present=" + present));
		String syntaxSubScoretotalOcclusionXmlNew = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			syntaxSubScoretotalOcclusionXmlNew = response.getEntity().toString();
		} else {
			handleException(response, InputBundleConstant.DOMINANCE);
		}
		return syntaxSubScoretotalOcclusionXmlNew;
	}

	/**
	 * Makes rest call to generate Bifurcation AngulationLt70 observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSBifurcationAngulationLt70Observation(Lesion lesion) throws IOException {
		Response response;
		String bifurcationAngulationLt70ObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/bifurcation_angulation_lt_70_deg?present="
				+ lesion.getBifurcationAngulationLt70() + InputBundleConstant.LESION_NUMBER + lesion.getNumber()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			bifurcationAngulationLt70ObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "Bifurcation Angulation Lt 70");
		}
		return bifurcationAngulationLt70ObservationXml;
	}

	/**
	 * Makes rest call to generate firstSegment ToatalOcculusion Visualized
	 * observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSfirstSegmentTOVisualizedObservation(Segment segmentForTOVisualized) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String patientInfoJson = mapper.writeValueAsString(segmentForTOVisualized);
		String encodedString = Base64.getUrlEncoder().encodeToString(patientInfoJson.getBytes());
		Response response = RestClient.post(new URL(InputBundleConstant.HOSTNAME
				+ "/total-occlusion-first-segment-visualized?segmentString=" + encodedString));
		String firstSegmentTOVisualizedObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			firstSegmentTOVisualizedObservationXml = response.getEntity().toString();
		} else {
			handleException(response, InputBundleConstant.DOMINANCE);
		}
		return firstSegmentTOVisualizedObservationXml;
	}

	/**
	 * Makes rest call to generate ToatalOcculusion segmentNumber observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSfirstTOsegmentNumberObservation(Segment segment) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String patientInfoJson = mapper.writeValueAsString(segment);
		String encodedString = Base64.getUrlEncoder().encodeToString(patientInfoJson.getBytes());
		Response response = RestClient.post(new URL(InputBundleConstant.HOSTNAME
				+ "/first-segment-number-of-total-occlusion-app?segmentString=" + encodedString));
		String firstTOsegmentNumberObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			firstTOsegmentNumberObservationXml = response.getEntity().toString();
		} else {
			handleException(response, InputBundleConstant.DOMINANCE);
		}
		return firstTOsegmentNumberObservationXml;
	}

	/**
	 * Makes rest call to generate Diffused Segment list observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSDiffusedSegmentObservation(Segment segment) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String patientInfoJson = mapper.writeValueAsString(segment);
		String encodedString = Base64.getUrlEncoder().encodeToString(patientInfoJson.getBytes());
		Response response = RestClient.post(new URL(InputBundleConstant.HOSTNAME
				+ "/diffusly-diseased-narrowed-segments-list-app?segmentString=" + encodedString));
		String diffusedSegmentObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			diffusedSegmentObservationXml = response.getEntity().toString();
		} else {
			handleException(response, InputBundleConstant.DOMINANCE);
		}
		return diffusedSegmentObservationXml;
	}

	/**
	 * Makes rest call to generate Dominance observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	public String getILSDominanceObservation(SyntaxScoreProfile syntaxScoreProfile) throws IOException {
		Response response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/dominance?selectedDominance="
				+ syntaxScoreProfile.getSelectedDominance()));
		String dominanceObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			dominanceObservationXml = response.getEntity().toString();
		} else {
			handleException(response, InputBundleConstant.DOMINANCE);
		}

		return dominanceObservationXml;
	}

	/**
	 * Makes rest call to generate Aorto Ostial observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSAortoOstialObservation(Lesion lesion) throws IOException {
		Response response;
		String aortoObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/aorto-ostial?present="
				+ lesion.getAortoOstialLesion() + InputBundleConstant.LESION_NUMBER + lesion.getNumber()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			aortoObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "Aorto");
		}
		return aortoObservationXml;
	}

	/**
	 * Makes rest call to generate Bifurcation observation
	 * 
	 * @param lesion
	 * @param bifurcationAngulationObs
	 * @return String observation xml
	 * @throws IOException
	 */
	// Bifurcation ##########
	private String getILSBifurcationObservation(Lesion lesion, String bifurcationAngulationObs) throws IOException {
		Response response;
		BifurcationMedina medinaValue = Boolean.TRUE.equals(lesion.getBifurcation()) ? lesion.getBifurcationMedina()
				: BifurcationMedina.NULL;
		String inputAgulationObs = Boolean.TRUE.equals(lesion.getBifurcation()) && bifurcationAngulationObs != null
				? bifurcationAngulationObs
				: "None";
		String encodedString = Base64.getUrlEncoder().encodeToString(inputAgulationObs.getBytes());
		String bifurcationObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/bifurcation?present="
				+ lesion.getBifurcation() + "&value=" + medinaValue + "&encodedString=" + encodedString));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			bifurcationObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "Bifurcation");
		}
		return bifurcationObservationXml;
	}

	/**
	 * Makes rest call to generate BluntStump observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSBluntStumpObservation(Lesion lesion) throws IOException {
		Response response;
		String bluntStumpObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/blunt-stump?present="
				+ lesion.getBluntStump() + InputBundleConstant.LESION_NUMBER + lesion.getNumber()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			bluntStumpObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "BluntStump");
		}
		return bluntStumpObservationXml;
	}

	/**
	 * Makes rest call to generate Bridging observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSBridgingObservation(Lesion lesion) throws IOException {
		Response response;
		String bridgingObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/bridging?present=" + lesion.getBridging()
				+ InputBundleConstant.LESION_NUMBER + lesion.getNumber()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			bridgingObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "Bridging");
		}
		return bridgingObservationXml;
	}

	/**
	 * Makes rest call to generate Heavy Calcification observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSHeavyCalcificationObservation(Lesion lesion) throws IOException {
		Response response;
		String heavyCalcificationObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/heavy-calcification?present="
				+ lesion.getHeavyCalcification() + InputBundleConstant.LESION_NUMBER + lesion.getNumber()));

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			heavyCalcificationObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "HeavyCalcification");
		}
		return heavyCalcificationObservationXml;
	}

	/**
	 * Makes rest call to generate Length observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSLengthObservation(Lesion lesion) throws IOException {
		Response response;
		String lengthObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/lengthGt20mm?present="
				+ lesion.getLengthGt20mm() + InputBundleConstant.LESION_NUMBER + lesion.getNumber()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			lengthObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "LengthGt20mm");
		}
		return lengthObservationXml;
	}

	/**
	 * Makes rest call to generate Severe Tortuosity observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSSevereTortuosityObservation(Lesion lesion) throws IOException {
		Response response;
		String severeTortuosityObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/severe-tortuosity?present="
				+ lesion.getSevereTortuosity() + InputBundleConstant.LESION_NUMBER + lesion.getNumber()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			severeTortuosityObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "SevereTortuosity");
		}
		return severeTortuosityObservationXml;
	}

	/**
	 * Makes rest call to generate Side branch observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSSidebranchObservation(Lesion lesion) throws IOException {
		Response response;
		String sidebranchObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME
				+ "/sidebranch-at-the-origin-of-occlusion?codeValue=" + lesion.getSidebranchAtTheOriginOfOcclusion()
				+ InputBundleConstant.LESION_NUMBER + lesion.getNumber()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			sidebranchObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "Sidebranch");
		}
		return sidebranchObservationXml;
	}

	/**
	 * Makes rest call to generate Thrombus observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSThrombusObservation(Lesion lesion) throws IOException {
		Response response;
		String thrombusObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/thrombus?present=" + lesion.getThrombus()
				+ InputBundleConstant.LESION_NUMBER + lesion.getNumber()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			thrombusObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "Thrombus");
		}
		return thrombusObservationXml;
	}

	/**
	 * Makes rest call to generate Age of total occlusion observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSAgeOfTOGt3MonthsObservation(Lesion lesion) throws IOException {
		Response response;
		String ageOfTOGt3MonthsObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME
				+ "/age-of-total-occlusion-gt-3months?codeValue=" + lesion.getIsTotalOcclusionAgeGt3Months()
				+ InputBundleConstant.LESION_NUMBER + lesion.getNumber()));

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			ageOfTOGt3MonthsObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "AgeOfTOGt3Months");
		}
		return ageOfTOGt3MonthsObservationXml;
	}

	/**
	 * Makes rest call to generate Trifurcation observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private String getILSTrifurcationObservation(Lesion lesion) throws IOException {
		Response response;
		int value = lesion.getTrifurcationDiseasedSegmentsInvolved() == null ? 0
				: lesion.getTrifurcationDiseasedSegmentsInvolved();
		String trifurcationObservationXml = "";
		response = RestClient.post(new URL(InputBundleConstant.HOSTNAME + "/trifurcation?present="
				+ lesion.getTrifurcation() + "&value=" + value));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			trifurcationObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "TotalOcclusion");
		}
		return trifurcationObservationXml;
	}

	/**
	 * Makes rest call to generate Selected Segments observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	public String getILSSelectedSegmentsObservation(Segment segment) throws IOException {
		Response response;
		ObjectMapper ow = new ObjectMapper();
		String segmentsInfoJson = ow.writeValueAsString(segment);
		String encodedString = new String(
				Base64.getEncoder().encode(segmentsInfoJson.getBytes(StandardCharsets.UTF_8)));
		String selectedSegmentsObservationXml = "";
		response = RestClient.post(new URL(
				InputBundleConstant.HOSTNAME + "/segments-diseased-for-lesion-app?segmentString=" + encodedString));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			selectedSegmentsObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "SelectedSegments");
		}
		return selectedSegmentsObservationXml;
	}

	/**
	 * Handles exception
	 * 
	 * @param response
	 * @param resource
	 * @throws IOException
	 */
	private void handleException(Response response, String resource) throws IOException {
		log.info("Response: " + response.getStatus() + " " + response.getStatusInfo().getReasonPhrase() + " "
				+ response.getEntity());
		throw new IOException("Failed to get " + resource + " observation. Response: " + response.getStatus());
	}
}