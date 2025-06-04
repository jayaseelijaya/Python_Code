/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscoreapp;

import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.philips.hsdp.research.p360.config.Config;
import com.philips.hsdp.research.p360.datamodel.DiffuselyDiseasedNarrowedSegment;
import com.philips.hsdp.research.p360.datamodel.Lesion;
import com.philips.hsdp.research.p360.datamodel.LesionProfile;
import com.philips.hsdp.research.p360.datamodel.PatientInfo;
import com.philips.hsdp.research.p360.datamodel.Segment;
import com.philips.hsdp.research.p360.datamodel.SegmentDefinition;
import com.philips.hsdp.research.p360.datamodel.Segments;
import com.philips.hsdp.research.p360.datamodel.SyntaxScoreProfile;
import com.philips.hsdp.research.p360.datamodel.enums.BifurcationMedina;

import jakarta.ws.rs.core.Response;

/** @author Raj Kumar */
public class SyntaxScoreApp {

	private static final Logger LOG = Logger.getLogger(SyntaxScoreApp.class.getName());
	private static final String SLASH = "//";
	private static final String SYNTAXSCORETO = "SyntaxSubScoretotalOcclusion";
	private static final String LESION_NUMBER = "&lesionNumber=";
	private static final String LOCATION = "C://SyntaxScore//output//";
	private static final String DOMINANCE = "Dominance";
	private static final String CALCULATE_TO_SUBSYNTAX_SCORE = "calculateTotalOculutionSubSyntaxScore";

	public static void main(String[] args) throws IOException, ParseException {

		// Read the test data
		ClassPathResource resource = new ClassPathResource("SyntaxScore_LeftDominance_3.json");

		InputStream inputStream = resource.getInputStream();
		byte[] syntaxScoreProfileTestJson = inputStream.readAllBytes();
		String json = new String(syntaxScoreProfileTestJson, StandardCharsets.UTF_8);

		// Convert test data to data model
		ObjectMapper objectMapper = new ObjectMapper();
		SyntaxScoreProfile syntaxScoreProfile = objectMapper.readValue(json, SyntaxScoreProfile.class);

		// Create Output folder
		List<String> pathList = new ArrayList<>();
		pathList = createOuputFolder();
		List<String> syntaxScoreObservationList = new ArrayList<>();

		// 1. Get PatientResource for which SyntaxScore is created
		String patientObservation = getILSPatientResource();
		String patientObservationPath = pathList.get(2) + "//PatientResource.xml";
		createFile(patientObservationPath, patientObservation);

		// 2. Get Dominance observation based on user selection
		String dominanceObservation = getILSDominanceObservation(syntaxScoreProfile);
		syntaxScoreObservationList.add(dominanceObservation);
		String dominancePath = pathList.get(2) + "//dominanceObservation.xml";
		createFile(dominancePath, dominanceObservation);

		// 3. Segment selection for lesion 'i' : Create LesionSyntaxSubscore for each
		// SegmentDefinition
		SegmentDefinition segmentDefinition = new SegmentDefinition(syntaxScoreProfile.getSelectedDominance());
		List<Segment> segmentDefList = segmentDefinition.getSegmentDefinition();

		HashMap<String, String> lesionSubSyntaxScoreObservation = new HashMap<>();
		List<LesionProfile> lesions = syntaxScoreProfile.getLesionProfile();
		String lesionSubscorePath = pathList.get(0);
		String observationPath = pathList.get(1);
		if (lesions != null) {
			lesions.forEach(lesion -> {
				HashMap<String, String> subscoreProfilesForLesions = new HashMap<>();
				Lesion lesionObj = lesion.getLesion();
				List<Segments> segments = lesionObj.getSegmentsList();
				try {
					// selectedSegmentObservation
					for (Segments segment : segments) {
						String selectedSegmentObservationXml = getILSSelectedSegmentsObservation(segment.getSegment());
						subscoreProfilesForLesions.put("selectedSegmentsObservationLesion" + lesionObj.getNumber()
								+ "Segment" + segment.getSegment().getNumber(), selectedSegmentObservationXml);
					}

					// TotalOcclusionObservation
					Map<String, String> syntaxSubScoretotalOcclusion = new HashMap<>();
					// first_totalocclusion_segment_number Observation
					String firstTOsegmentNumberObservation = createfirstTOsegmentNumberObservation(lesionObj,
							segmentDefList);
					syntaxSubScoretotalOcclusion.put("firstTOsegmentNumberObservation" + lesionObj.getNumber(),
							firstTOsegmentNumberObservation);

					// AgeOfTOGt3MonthsObservation
					String ageOfTOGt3MonthsObservation = createAgeOfTOGt3MonthsObservation(lesionObj);
					syntaxSubScoretotalOcclusion.put("ageOfTOGt3MonthsObservation" + lesionObj.getNumber(),
							ageOfTOGt3MonthsObservation);

					// BluntStumpObservation
					String bluntStumpObservation = createBluntStumpObservation(lesionObj);
					syntaxSubScoretotalOcclusion.put("bluntStumpObservation" + lesionObj.getNumber(),
							bluntStumpObservation);

					// bridgingObservation
					String bridgingObservation = createBridgingObservation(lesionObj);
					syntaxSubScoretotalOcclusion.put("bridgingObservation" + lesionObj.getNumber(),
							bridgingObservation);

					// first_segment_number_beyond_totalocclusion_visualized Observation
					String firstSegmentTOVisualized = createfirstSegmentTOVisualized(lesionObj, segmentDefList);
					syntaxSubScoretotalOcclusion.put("firstSegmentTOVisualized" + lesionObj.getNumber(),
							firstSegmentTOVisualized);

					// SidebranchObservation
					String sidebranchObservation = createSidebranchObservation(lesionObj);
					syntaxSubScoretotalOcclusion.put("sidebranchObservation" + lesionObj.getNumber(),
							sidebranchObservation);

					// Writing totalOcclusion observation as file
					syntaxSubScoretotalOcclusion.values().removeAll(Collections.singleton(""));
					writeObservationAsFile(syntaxSubScoretotalOcclusion, observationPath);

					// lesionSyntaxSubscoreTotalOcclusionObservation
					String lesionSyntaxSubscoreTotalOcclusionObservation = createLesionSubscoreTOobservation(
							syntaxSubScoretotalOcclusion, lesionObj);
					subscoreProfilesForLesions.put(SYNTAXSCORETO + lesionObj.getNumber(),
							lesionSyntaxSubscoreTotalOcclusionObservation);

					// trifurcationObservation
					String trifurcationObservation = createtrifurcationObservation(lesionObj);
					subscoreProfilesForLesions.put("trifurcationObservation" + lesionObj.getNumber(),
							trifurcationObservation);

					// bifurcationAngulationLt70Observation
					String bifurcationAngulationLt70Observation = createBifurcationAngulationObservation(lesionObj);
					subscoreProfilesForLesions.put("bifurcationAngulationLt70Observation" + lesionObj.getNumber(),
							bifurcationAngulationLt70Observation);

					// bifurcationObservation final observations
					String bifurcationObservation = createBifurcationObservation(lesionObj,
							bifurcationAngulationLt70Observation);
					subscoreProfilesForLesions.put("bifurcationObservation" + lesionObj.getNumber(),
							bifurcationObservation);

					// AortoOstialObservation
					String aortoOstialObservation = createAortoOstialObservation(lesionObj);
					subscoreProfilesForLesions.put("AortoOstialObservation" + lesionObj.getNumber(),
							aortoOstialObservation);

					// severeTortuosityObservation
					String severeTortuosityObservation = createSevereTortuosityObservation(lesionObj);
					subscoreProfilesForLesions.put("severeTortuosityObservation" + lesionObj.getNumber(),
							severeTortuosityObservation);

					// lengthObservation
					String lengthObservation = createLengthObservation(lesionObj);
					subscoreProfilesForLesions.put("lengthObservation" + lesionObj.getNumber(), lengthObservation);

					// heavyCalcificationObservation
					String heavyCalcificationObservation = createHeavyCalcificationObservation(lesionObj);
					subscoreProfilesForLesions.put("heavyCalcificationObservation" + lesionObj.getNumber(),
							heavyCalcificationObservation);

					// thrombusObservation
					String thrombusObservation = createThrombusObservation(lesionObj);
					subscoreProfilesForLesions.put("thrombusObservation" + lesionObj.getNumber(), thrombusObservation);

					// Writing individual observation as file
					subscoreProfilesForLesions.values().removeAll(Collections.singleton(""));
					writeObservationAsFile(subscoreProfilesForLesions, observationPath);

					// LesionSyntaxSubscoreObservation
					List<String> lesionObservationlist = new ArrayList<>(subscoreProfilesForLesions.values());
					lesionObservationlist.removeAll(Collections.singleton(""));
					String lesionSyntaxSubscoreObservation = getLesionSyntaxSubscoreObservation(lesionObservationlist,
							lesionObj.getNumber());
					lesionSubSyntaxScoreObservation.put("lesionSyntaxSubscoreObservation" + lesionObj.getNumber(),
							lesionSyntaxSubscoreObservation);
					syntaxScoreObservationList.add(lesionSyntaxSubscoreObservation);
					LOG.info("lesionSyntaxSubscoreObservation created for lesion" + lesionObj.getNumber());

					// Calculate syntaxSubScoretotalOcclusion
					List<String> syntaxSubScoretotalOcclusionList = new ArrayList<>(
							syntaxSubScoretotalOcclusion.values());
					// calculateLesionSubSyntaxScore
					String calculateLesionSubSyntaxScore = null;
					subscoreProfilesForLesions.remove(SYNTAXSCORETO + lesionObj.getNumber());
					List<String> lesionObservationlistNew = new ArrayList<>(subscoreProfilesForLesions.values());
					lesionObservationlistNew.addAll(syntaxSubScoretotalOcclusionList);
					calculateLesionSubSyntaxScore = getILSCalculateLesionSubSyntaxScoreObservation(
							lesionObservationlistNew, dominanceObservation, lesionObj);

					// writting file for lesionSubscore- LesionSyntaxSubscoreObservation
					String path = lesionSubscorePath + SLASH + "lesionSubSyntaxScoreObservation" + lesionObj.getNumber()
							+ ".xml";
					String valueString = lesionSyntaxSubscoreObservation;
					createFile(path, valueString);

					// calculate lesionSubSyntaxScoreTotalOcclusionScore
					if (lesionObj.getTotalOcclusion() != null && lesionObj.getTotalOcclusion().booleanValue()) {
						String lesionSubSyntaxScoreTotalOcclusionObservation = null;
						lesionSubSyntaxScoreTotalOcclusionObservation = getILSCalculateTotalOccultionSubSyntaxScoreObservation(
								syntaxSubScoretotalOcclusionList);
						String pathTotalOcclution = observationPath + SLASH + "totalocclutionSubSyntaxScoreObservation"
								+ lesionObj.getNumber() + ".xml"; // this is creating incorrect observation
						String valueStringTotalOcclution = lesionSubSyntaxScoreTotalOcclusionObservation;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}

		// 4. Create SubScore for 'Diffusely diseased and narrow segments' subscore
		HashMap<String, String> diffuseDiseaseSubSyntaxScoreObservation = new HashMap<>();

		// diffuselyDiseasedSegmentList Observation
		createDiffuselyDiseasedSegmentList(syntaxScoreProfile, segmentDefList, diffuseDiseaseSubSyntaxScoreObservation);

		// Writting DiffuselyDiseasedNarrowedSegmentListObservation as a file.
		writeObservationAsFile(diffuseDiseaseSubSyntaxScoreObservation, observationPath);

		// Subscore diffuseDiseaseSubSyntaxScoreObservation *********
		String difussedDieseSmallVesselSubSyntaxScore = null;
		List<String> diffuseDiseaseObservationlist = new ArrayList<>(diffuseDiseaseSubSyntaxScoreObservation.values());
		List<String> diseaseSegmentsObservationlist = new ArrayList<>(diffuseDiseaseSubSyntaxScoreObservation.values());
		String subsyntaxScoreDiffuselydiseasedXML = "";
		try {
			subsyntaxScoreDiffuselydiseasedXML = getILSSubSyntaxScoreDiffusedDiseasedObservation(
					syntaxScoreProfile.getDiffuselyDiseasedNarrowedSegment(), diseaseSegmentsObservationlist);
			syntaxScoreObservationList.add(subsyntaxScoreDiffuselydiseasedXML);
			LOG.info("SubSyntaxScore DiffuseDiseased Observation created");

			// Calculating difussedDieseSmallVesselSubSyntaxScore
			difussedDieseSmallVesselSubSyntaxScore = getILSCalculateDifussedDieseSmallVesselSubSyntaxScoreObservation(
					diffuseDiseaseObservationlist, dominanceObservation);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Writing subsyntaxScoreDiffuselydiseasedXML as file
		String path = pathList.get(0) + "//DiffuseDiseaseSmallVesselsSyntaxSubscore.xml";
		String valueString = subsyntaxScoreDiffuselydiseasedXML;
		createFile(path, valueString);

		// 5. Calculate score
		// calculate syntaxScoreTotalScore
		String calculateSyntaxScore = null;
		try {
			calculateSyntaxScore = getILSCalculateSyntaxScoreObservation(syntaxScoreObservationList);
			LOG.info("SyntaxScore Observation created");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 6. Get SyntaxScore Observation
		// SyntaxScoreObservation final
		String syntaxScoreXML = "";
		try {
			syntaxScoreXML = getILSSyntaxScoreObservation(syntaxScoreObservationList);
			LOG.info("SyntaxScore Observation created");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Writing SyntaxScoreXML as file
		String syntaxScorepath = pathList.get(2) + "//SyntaxScore.xml";
		String syntaxScoreXmlvalue = syntaxScoreXML;
		createFile(syntaxScorepath, syntaxScoreXmlvalue);

		// SyntaxScore summary message box
		String resultValue = syntaxScoreSummary();
		JTextArea textArea = new JTextArea(resultValue);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		JOptionPane.showMessageDialog(null, scrollPane, "Syntax Score Summary", JOptionPane.INFORMATION_MESSAGE);

		LOG.info(" *** Completed *** ");

		// 7. Stitch together all the Observations according to the ILS profile and
		// create a TRASACTIONAL bundle
		// Note: SyntaxScore {score}
		// |---DominanceObservation
		// |---LesionSyntaxSubscore'1'
		// |---.......
		// |---LesionSyntaxSubscore'N'
		// |___DiffuselyDiseasedAndNarrowSegmentsSubScore
		// |___PatientResource

		// 8. Post the bundle to CDR
	}

	/**
	 * Create DiffuselyDiseasedSegmentList Observation and adds it to the
	 * diffuseDiseased list
	 * 
	 * @param syntaxScoreProfile
	 * @param Observation                             xml
	 * @param diffuseDiseaseSubSyntaxScoreObservation
	 */
	private static void createDiffuselyDiseasedSegmentList(SyntaxScoreProfile syntaxScoreProfile,
			List<Segment> segmentDefList, HashMap<String, String> diffuseDiseaseSubSyntaxScoreObservation) {
		if (!syntaxScoreProfile.getDiffuselyDiseasedNarrowedSegment().getDiffuselyDiseasedNarrowedSegmentList()
				.isEmpty()) {
			List<String> diffusedsegList = syntaxScoreProfile.getDiffuselyDiseasedNarrowedSegment()
					.getDiffuselyDiseasedNarrowedSegmentList();
			segmentDefList.forEach(segment -> {
				for (String diffusedSegNumber : diffusedsegList)
					if (segment.getNumber().equalsIgnoreCase(diffusedSegNumber)) {
						try {
							String diffuselySegmentList = getILSDiffusedSegmentObservation(segment);
							diffuseDiseaseSubSyntaxScoreObservation.put("diffuselySegmentList" + segment.getNumber(),
									diffuselySegmentList);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			});
		}
	}

	/**
	 * Create Thrombus Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createThrombusObservation(Lesion lesionObj) throws IOException {
		String thrombusObservation = "";
		if (lesionObj.getThrombus() != null) {
			thrombusObservation = getILSThrombusObservation(lesionObj);
		}
		return thrombusObservation;
	}

	/**
	 * Create Heavy Calcification Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createHeavyCalcificationObservation(Lesion lesionObj) throws IOException {
		String heavyCalcificationObservation = "";
		if (lesionObj.getHeavyCalcification() != null) {
			heavyCalcificationObservation = getILSHeavyCalcificationObservation(lesionObj);
		}
		return heavyCalcificationObservation;
	}

	/**
	 * Create Length Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createLengthObservation(Lesion lesionObj) throws IOException {
		String lengthObservation = "";
		if (lesionObj.getLengthGt20mm() != null) {
			lengthObservation = getILSLengthObservation(lesionObj);
		}
		return lengthObservation;
	}

	/**
	 * Create SevereTortuosity Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createSevereTortuosityObservation(Lesion lesionObj) throws IOException {
		String severeTortuosityObservation = "";
		if (lesionObj.getSevereTortuosity() != null) {
			severeTortuosityObservation = getILSSevereTortuosityObservation(lesionObj);
		}
		return severeTortuosityObservation;
	}

	/**
	 * Create AortoOstial Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createAortoOstialObservation(Lesion lesionObj) throws IOException {
		String aortoOstialObservation = "";
		if (lesionObj.getAortoOstialLesion() != null) {
			aortoOstialObservation = getILSAortoOstialObservation(lesionObj);
		}
		return aortoOstialObservation;
	}

	/**
	 * Create Bifurcation Observation
	 * 
	 * @param lesionObj, bifurcationAngulationLt70Observation
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createBifurcationObservation(Lesion lesionObj, String bifurcationAngulationLt70Observation)
			throws IOException {
		String bifurcationObservation = "";
		String bifurcationAngulationLt70Obs = "";
		if (lesionObj.getBifurcation() != null) {
			bifurcationAngulationLt70Obs = bifurcationAngulationLt70Observation;
			bifurcationObservation = getILSBifurcationObservation(lesionObj, bifurcationAngulationLt70Obs);
		}
		return bifurcationObservation;
	}

	/**
	 * Create Bifurcation Angulation Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createBifurcationAngulationObservation(Lesion lesionObj) throws IOException {
		String bifurcationAngulationLt70Observation = "";
		if (lesionObj.getBifurcationMedina() != null) {
			bifurcationAngulationLt70Observation = getILSBifurcationAngulationLt70Observation(lesionObj);
		}
		return bifurcationAngulationLt70Observation;
	}

	/**
	 * Create trifurcation Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createtrifurcationObservation(Lesion lesionObj) throws IOException {
		String trifurcationObservation = "";
		if (lesionObj.getTrifurcation() != null) {
			trifurcationObservation = getILSTrifurcationObservation(lesionObj);
		}
		return trifurcationObservation;
	}

	/**
	 * Create LesionSubscoreTO Observation
	 * 
	 * @param lesionObj, syntaxSubScoretotalOcclusion
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createLesionSubscoreTOobservation(Map<String, String> syntaxSubScoretotalOcclusion,
			Lesion lesionObj) throws IOException {
		String lesionSyntaxSubscoreTotalOcclusionObservation = "";
		List<String> toOcclusionObservations = new ArrayList<>(syntaxSubScoretotalOcclusion.values());
		if (syntaxSubScoretotalOcclusion.size() != 0 && !syntaxSubScoretotalOcclusion.isEmpty()) {
			lesionSyntaxSubscoreTotalOcclusionObservation = syntaxSubScoretotalOcclusionObservation(
					toOcclusionObservations, lesionObj.getTotalOcclusion());
			LOG.info("SyntaxSubScoretotalOcclusion created for lesion" + lesionObj.getNumber());
		}
		return lesionSyntaxSubscoreTotalOcclusionObservation;
	}

	/**
	 * Writes observations as file
	 * 
	 * @param syntaxSubScoretotalOcclusion, observationPath
	 * @throws IOException
	 */
	private static void writeObservationAsFile(Map<String, String> syntaxSubScoretotalOcclusion, String observationPath)
			throws IOException {
		for (Map.Entry<String, String> pair : syntaxSubScoretotalOcclusion.entrySet()) {
			String path = observationPath + SLASH + pair.getKey() + ".xml";
			String valueString = pair.getValue();
			createFile(path, valueString);
		}
	}

	/**
	 * Create Sidebranch Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createSidebranchObservation(Lesion lesionObj) throws IOException {
		String sidebranchObservation = "";
		if (lesionObj.getSidebranchAtTheOriginOfOcclusion() != null) {
			sidebranchObservation = getILSSidebranchObservation(lesionObj);
		}
		return sidebranchObservation;
	}

	/**
	 * Creates firstSegmentTOVisualized Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createfirstSegmentTOVisualized(Lesion lesionObj, List<Segment> segmentDefList)
			throws IOException {
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

	/**
	 * Creates Bridging Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createBridgingObservation(Lesion lesionObj) throws IOException {
		String bridgingObservation = "";
		if (lesionObj.getBridging() != null) {
			bridgingObservation = getILSBridgingObservation(lesionObj);
		}
		return bridgingObservation;
	}

	/**
	 * Creates BluntStump Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createBluntStumpObservation(Lesion lesionObj) throws IOException {
		String bluntStumpObservation = "";
		if (lesionObj.getBluntStump() != null) {
			bluntStumpObservation = getILSBluntStumpObservation(lesionObj);
		}
		return bluntStumpObservation;
	}

	/**
	 * Creates Age Of TotalOcculsion Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createAgeOfTOGt3MonthsObservation(Lesion lesionObj) throws IOException {
		String ageOfTOGt3MonthsObservation = "";
		if (lesionObj.getIsTotalOcclusionAgeGt3Months() != null) {
			ageOfTOGt3MonthsObservation = getILSAgeOfTOGt3MonthsObservation(lesionObj);
		}
		return ageOfTOGt3MonthsObservation;
	}

	/**
	 * Creates firstTOsegment Observation
	 * 
	 * @param lesionObj
	 * @return Observation xml
	 * @throws IOException
	 */
	private static String createfirstTOsegmentNumberObservation(Lesion lesionObj, List<Segment> segmentDefList)
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
	private static String getILSSyntaxScoreObservation(List<String> syntaxScoreObservationList) throws IOException {
		String listString = String.join(", ", syntaxScoreObservationList);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response = RestClient
				.post(new URL(Config.HOSTNAME + "/syntaxscore-app?observationList=" + encodedString));
		String syntaxScoreObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			syntaxScoreObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "SyntaxScoreObservationXml");
		}
		return syntaxScoreObservationXml;
	}

	/**
	 * Makes a rest call to Calculate final SyntaxScore observation
	 * 
	 * @return String Observation xml
	 * @throws IOException
	 */
	private static String getILSCalculateSyntaxScoreObservation(List<String> syntaxScoreObservationList)
			throws IOException {
		String listString = String.join(", ", syntaxScoreObservationList);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response;
		String calculateTotalSyntaxScoreString = null;
		response = RestClient.post(new URL(Config.HOSTNAME + "/syntax-score-value?observationList=" + encodedString));

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			calculateTotalSyntaxScoreString = response.getEntity().toString();
		} else {
			handleException(response, CALCULATE_TO_SUBSYNTAX_SCORE);

		}
		return calculateTotalSyntaxScoreString;
	}

	/**
	 * Makes a rest call to generate SubSyntaxScoreDiffusedDiseased observation
	 * 
	 * @param diffuselyDiseasedNarrowedSegment
	 * @param diffuseDiseaseObservationlist
	 * @return String Observation xml
	 * @throws IOException
	 */
	private static String getILSSubSyntaxScoreDiffusedDiseasedObservation(
			DiffuselyDiseasedNarrowedSegment diffuselyDiseasedNarrowedSegment,
			List<String> diffuseDiseaseObservationlist) throws IOException {
		String subScorediffusedObservationXml = "";

		String listString = String.join(", ", diffuseDiseaseObservationlist);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response = RestClient
				.post(new URL(Config.HOSTNAME + "/subsyntax-score-diffuselydiseased-app?diffuselydiseasedString="
						+ encodedString + "&present=" + diffuselyDiseasedNarrowedSegment.getPresent()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			subScorediffusedObservationXml = response.getEntity().toString();

		} else {
			handleException(response, DOMINANCE);
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
	private static String getLesionSyntaxSubscoreObservation(List<String> lesionObservationlist, int lesionNumber)
			throws IOException {
		String listString = String.join(", ", lesionObservationlist);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response = RestClient.post(new URL(Config.HOSTNAME
				+ "/subsyntax-score-lesion-app?lesionObservationlist=" + encodedString + LESION_NUMBER + lesionNumber));
		String lesionObservationlistXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			lesionObservationlistXml = response.getEntity().toString();
		} else {
			handleException(response, DOMINANCE);
		}
		return lesionObservationlistXml;
	}

	/**
	 * Makes a rest call to calculate LesionSubSyntaxScore
	 * 
	 * @param dominanceObservation, lesion
	 * @return float LesionSubSyntaxScore value
	 * @throws IOException
	 */
	private static String getILSCalculateLesionSubSyntaxScoreObservation(List<String> lesionObservationlist,
			String dominanceObservation, Lesion lesion) throws IOException {
		lesionObservationlist.add(dominanceObservation);
		String listString = String.join(", ", lesionObservationlist);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response;
		String calculateLesionSubSyntaxScore = null;
		response = RestClient.post(new URL(Config.HOSTNAME + "/score-calculator-app?syntaxScoreString=" + encodedString
				+ LESION_NUMBER + lesion.getNumber()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {

			calculateLesionSubSyntaxScore = response.getEntity().toString();
		} else {
			handleException(response, CALCULATE_TO_SUBSYNTAX_SCORE);
		}

		return calculateLesionSubSyntaxScore;
	}

	/**
	 * Makes a rest call to generate SubScoretotalOcclusion observation
	 * 
	 * @param syntaxSubScoretotalOcclusion, lesionNumber
	 * @return String Observation xml
	 * @throws IOException
	 */
	private static String syntaxSubScoretotalOcclusionObservation(List<String> syntaxSubScoretotalOcclusion,
			Boolean present) throws IOException {
		String listString = String.join(", ", syntaxSubScoretotalOcclusion);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response = RestClient.post(new URL(Config.HOSTNAME
				+ "/subsyntax-score-totalOcculation-app?toObservationList=" + encodedString + "&present=" + present));
		String syntaxSubScoretotalOcclusionXmlNew = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			syntaxSubScoretotalOcclusionXmlNew = response.getEntity().toString();
		} else {
			handleException(response, DOMINANCE);
		}
		return syntaxSubScoretotalOcclusionXmlNew;
	}

	/**
	 * Makes a rest call to Calculate TotalOccultion SubSyntaxScore
	 * 
	 * @return float TotalOccultion SubSyntaxScore value
	 * @throws IOException
	 */
	private static String getILSCalculateTotalOccultionSubSyntaxScoreObservation(
			List<String> syntaxSubScoretotalOcclusion) throws IOException {
		String listString = String.join(", ", syntaxSubScoretotalOcclusion);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response;
		String calculateTotalOculutionSubSyntaxScore = null;

		response = RestClient.post(
				new URL(Config.HOSTNAME + "/score-calculator-totalOcclusion-app?toObservationList=" + encodedString));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			calculateTotalOculutionSubSyntaxScore = response.getEntity().toString();
		} else {
			handleException(response, CALCULATE_TO_SUBSYNTAX_SCORE);
		}
		return calculateTotalOculutionSubSyntaxScore;
	}

	/**
	 * Makes rest call to Calculate DifussedDieseSmallVessel SubSyntaxScore
	 * 
	 * @param diffuseDiseaseObservationlist
	 * @param diffuselyDiseasedSegment
	 * @return float DifussedDieseSmallVessel SubSyntaxScore value
	 * @throws IOException
	 */
	private static String getILSCalculateDifussedDieseSmallVesselSubSyntaxScoreObservation(
			List<String> diffuseDiseaseObservationlist, String dominanceObservation) throws IOException {
		diffuseDiseaseObservationlist.add(dominanceObservation);
		String listString = String.join(", ", diffuseDiseaseObservationlist);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		Response response;
		String calculateDifussedSubSyntaxScore = null;
		response = RestClient.post(
				new URL(Config.HOSTNAME + "/difussed-vessel-score-calculator-app?syntaxScoreString=" + encodedString));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			calculateDifussedSubSyntaxScore = response.getEntity().toString();

		} else {
			handleException(response, "calculateDifussedSubSyntaxScore");
		}
		return calculateDifussedSubSyntaxScore;
	}

	/**
	 * Makes rest call to generate the Syntax score summary
	 * 
	 * @return score summExceptionary in JSON string
	 * @throws IOException
	 */
	private static String syntaxScoreSummary() throws IOException {
		Response response = RestClient.post(new URL(Config.HOSTNAME + "/syntaxScore-summary-app"));
		String resultString = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			resultString = response.getEntity().toString();
		} else {
			handleException(response, "resultString");
		}
		String encodedString = resultString.replace("\n", "");
		byte[] decoded = Base64.getUrlDecoder().decode(encodedString);
		String mapValue = new String(decoded, StandardCharsets.UTF_8);

		mapValue = mapValue.replace("\\{", "").replace("\\}", "").replace("-1.0,", "").replace(":", " : ");
		return mapValue;
	}

	/**
	 * Creates file in the specified path
	 * 
	 * @param path
	 * @param value
	 * @throws IOException
	 */
	private static void createFile(String path, String value) throws IOException {
		FileWriter fw = new FileWriter(path);
		fw.write(value);
		fw.close();
	}

	/**
	 * Makes rest call to generate Bifurcation AngulationLt70 observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private static String getILSBifurcationAngulationLt70Observation(Lesion lesion) throws IOException {
		Response response;
		String bifurcationAngulationLt70ObservationXml = "";
		response = RestClient.post(new URL(Config.HOSTNAME + "/bifurcation_angulation_lt_70_deg?present="
				+ lesion.getBifurcationAngulationLt70() + LESION_NUMBER + lesion.getNumber()));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			bifurcationAngulationLt70ObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "Bifurcation Angulation Lt 70");
		}
		return bifurcationAngulationLt70ObservationXml;
	}

	/**
	 * Generates new output directory and path
	 * 
	 * @return
	 */
	private static List<String> createOuputFolder() {
		int i = 1;
		List<String> pathList = new ArrayList<>();
		// SubscorePath
		File subsyntaxScoreDir = new File(LOCATION + i + "//SubsyntaxScore//");
		File observationDir = new File(LOCATION + i + "//Observations//");
		File syntaxScoreDir = new File(LOCATION + i + "//SyntaxScore//");

		for (i = 1; subsyntaxScoreDir.exists(); i++) {
			subsyntaxScoreDir = new File(LOCATION + i + "//SubsyntaxScore//");
			observationDir = new File(LOCATION + i + "//Observations//");
			syntaxScoreDir = new File(LOCATION + i + "//SyntaxScore//");
		}
		subsyntaxScoreDir.mkdirs();
		pathList.add(subsyntaxScoreDir.getPath());
		observationDir.mkdirs();
		pathList.add(observationDir.getPath());
		syntaxScoreDir.mkdirs();
		pathList.add(syntaxScoreDir.getPath());
		return pathList;
	}

	/**
	 * Makes rest call to generate firstSegment ToatalOcculusion Visualized
	 * observation
	 * 
	 * @param lesion
	 * @return String observation xml
	 * @throws IOException
	 */
	private static String getILSfirstSegmentTOVisualizedObservation(Segment segmentForTOVisualized) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String patientInfoJson = mapper.writeValueAsString(segmentForTOVisualized);
		String encodedString = Base64.getUrlEncoder().encodeToString(patientInfoJson.getBytes());
		Response response = RestClient.post(
				new URL(Config.HOSTNAME + "/total-occlusion-first-segment-visualized?segmentString=" + encodedString));
		String firstSegmentTOVisualizedObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			firstSegmentTOVisualizedObservationXml = response.getEntity().toString();
		} else {
			handleException(response, DOMINANCE);
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
	private static String getILSfirstTOsegmentNumberObservation(Segment segment) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String patientInfoJson = mapper.writeValueAsString(segment);
		String encodedString = Base64.getUrlEncoder().encodeToString(patientInfoJson.getBytes());
		Response response = RestClient.post(new URL(
				Config.HOSTNAME + "/first-segment-number-of-total-occlusion-app?segmentString=" + encodedString));
		String firstTOsegmentNumberObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			firstTOsegmentNumberObservationXml = response.getEntity().toString();
		} else {
			handleException(response, DOMINANCE);
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
	private static String getILSDiffusedSegmentObservation(Segment segment) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String patientInfoJson = mapper.writeValueAsString(segment);
		String encodedString = Base64.getUrlEncoder().encodeToString(patientInfoJson.getBytes());
		Response response = RestClient.post(new URL(
				Config.HOSTNAME + "/diffusly-diseased-narrowed-segments-list-app?segmentString=" + encodedString));
		String diffusedSegmentObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			diffusedSegmentObservationXml = response.getEntity().toString();
		} else {
			handleException(response, DOMINANCE);
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
	private static String getILSDominanceObservation(SyntaxScoreProfile syntaxScoreProfile) throws IOException {
		Response response = RestClient.post(
				new URL(Config.HOSTNAME + "/dominance?selectedDominance=" + syntaxScoreProfile.getSelectedDominance()));
		String dominanceObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			dominanceObservationXml = response.getEntity().toString();
		} else {
			handleException(response, DOMINANCE);
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
	private static String getILSAortoOstialObservation(Lesion lesion) throws IOException {
		Response response;
		String aortoObservationXml = "";
		response = RestClient.post(new URL(Config.HOSTNAME + "/aorto-ostial?present=" + lesion.getAortoOstialLesion()
				+ LESION_NUMBER + lesion.getNumber()));
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
	private static String getILSBifurcationObservation(Lesion lesion, String bifurcationAngulationObs)
			throws IOException {
		Response response;
		BifurcationMedina medinaValue = Boolean.TRUE.equals(lesion.getBifurcation()) ? lesion.getBifurcationMedina()
				: null;
		String inputAgulationObs = Boolean.TRUE.equals(lesion.getBifurcation()) && bifurcationAngulationObs != null
				? bifurcationAngulationObs
				: "None";
		String encodedString = Base64.getUrlEncoder().encodeToString(inputAgulationObs.getBytes());
		String bifurcationObservationXml = "";
		response = RestClient.post(new URL(Config.HOSTNAME + "/bifurcation?present=" + lesion.getBifurcation()
				+ "&value=" + medinaValue + "&encodedString=" + encodedString));
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
	private static String getILSBluntStumpObservation(Lesion lesion) throws IOException {
		Response response;
		String bluntStumpObservationXml = "";
		response = RestClient.post(new URL(Config.HOSTNAME + "/blunt-stump?present=" + lesion.getBluntStump()
				+ LESION_NUMBER + lesion.getNumber()));
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
	private static String getILSBridgingObservation(Lesion lesion) throws IOException {
		Response response;
		String bridgingObservationXml = "";
		response = RestClient.post(new URL(
				Config.HOSTNAME + "/bridging?present=" + lesion.getBridging() + LESION_NUMBER + lesion.getNumber()));
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
	private static String getILSHeavyCalcificationObservation(Lesion lesion) throws IOException {
		Response response;
		String heavyCalcificationObservationXml = "";
		response = RestClient.post(new URL(Config.HOSTNAME + "/heavy-calcification?present="
				+ lesion.getHeavyCalcification() + LESION_NUMBER + lesion.getNumber()));

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
	private static String getILSLengthObservation(Lesion lesion) throws IOException {
		Response response;
		String lengthObservationXml = "";
		response = RestClient.post(new URL(Config.HOSTNAME + "/lengthGt20mm?present=" + lesion.getLengthGt20mm()
				+ LESION_NUMBER + lesion.getNumber()));
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
	private static String getILSSevereTortuosityObservation(Lesion lesion) throws IOException {
		Response response;
		String severeTortuosityObservationXml = "";
		response = RestClient.post(new URL(Config.HOSTNAME + "/severe-tortuosity?present="
				+ lesion.getSevereTortuosity() + LESION_NUMBER + lesion.getNumber()));
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
	private static String getILSSidebranchObservation(Lesion lesion) throws IOException {
		Response response;
		String sidebranchObservationXml = "";
		response = RestClient.post(new URL(Config.HOSTNAME + "/sidebranch-at-the-origin-of-occlusion?codeValue="
				+ lesion.getSidebranchAtTheOriginOfOcclusion() + LESION_NUMBER + lesion.getNumber()));
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
	private static String getILSThrombusObservation(Lesion lesion) throws IOException {
		Response response;
		String thrombusObservationXml = "";
		response = RestClient.post(new URL(
				Config.HOSTNAME + "/thrombus?present=" + lesion.getThrombus() + LESION_NUMBER + lesion.getNumber()));
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
	private static String getILSAgeOfTOGt3MonthsObservation(Lesion lesion) throws IOException {
		Response response;
		String ageOfTOGt3MonthsObservationXml = "";
		response = RestClient.post(new URL(Config.HOSTNAME + "/age-of-total-occlusion-gt-3months?codeValue="
				+ lesion.getIsTotalOcclusionAgeGt3Months() + LESION_NUMBER + lesion.getNumber()));

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
	private static String getILSTrifurcationObservation(Lesion lesion) throws IOException {
		Response response;
		int value = lesion.getTrifurcationDiseasedSegmentsInvolved() == null ? 0
				: lesion.getTrifurcationDiseasedSegmentsInvolved();
		String trifurcationObservationXml = "";
		response = RestClient.post(
				new URL(Config.HOSTNAME + "/trifurcation?present=" + lesion.getTrifurcation() + "&value=" + value));
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
	private static String getILSSelectedSegmentsObservation(Segment segment) throws IOException {
		Response response;
		ObjectMapper ow = new ObjectMapper();
		String segmentsInfoJson = ow.writeValueAsString(segment);
		String encodedString = new String(
				Base64.getEncoder().encode(segmentsInfoJson.getBytes(StandardCharsets.UTF_8)));
		String selectedSegmentsObservationXml = "";
		response = RestClient
				.post(new URL(Config.HOSTNAME + "/segments-diseased-for-lesion-app?segmentString=" + encodedString));
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			selectedSegmentsObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "SelectedSegments");
		}
		return selectedSegmentsObservationXml;
	}

	/**
	 * Makes rest call to generate Patient Resource
	 * 
	 * @param lesion
	 * @return String Patient Resource xml
	 * @throws IOException
	 */
	private static String getILSPatientResource() throws IOException, ParseException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Date birthDay = dateFormatter.parse("12-08-1980");
		PatientInfo patientInfo = new PatientInfo("John Doe", null, birthDay);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String patientInfoJson = ow.writeValueAsString(patientInfo);

		String encodedString = Base64.getEncoder().encodeToString(patientInfoJson.getBytes());
		Response response = RestClient
				.post(new URL(Config.HOSTNAME + "/syntaxscore-patient?patientInfoJson=" + encodedString));
		String patientObservationXml = "";
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			patientObservationXml = response.getEntity().toString();
		} else {
			handleException(response, "Patient");
		}
		return patientObservationXml;
	}

	/**
	 * Handles exception
	 * 
	 * @param response
	 * @param resource
	 * @throws IOException
	 */
	private static void handleException(Response response, String resource) throws IOException {
		LOG.info("Response: " + response.getStatus() + " " + response.getStatusInfo().getReasonPhrase() + " "
				+ response.getEntity());
		throw new IOException("Failed to get " + resource + " observation. Response: " + response.getStatus());
	}
}