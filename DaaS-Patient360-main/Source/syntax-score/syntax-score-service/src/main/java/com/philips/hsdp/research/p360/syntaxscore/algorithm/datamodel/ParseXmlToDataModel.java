/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hl7.fhir.r4.model.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.SyntaxScoreCalForLesionSubScore;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/* @Author Sunil Kumar*/
@Service
public class ParseXmlToDataModel {
	
	@Autowired
	SyntaxScoreCalForLesionSubScore lesionObservationList;

	private static final Logger LOG = Logger.getLogger(ParseXmlToDataModel.class.getName());
	SyntaxScoreMappingValue valueUtil = new SyntaxScoreMappingValue();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	DiffuselyDiseasedNarrowedSegModel diffuselyDiseasedNarrowedSegModel = DiffuselyDiseasedNarrowedSegModel
			.getInstance();

	/**
	 * This function is used to parse the data from Observation and map the data in
	 * user data model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          ObservationString : to get list of
	 *                                        observations
	 * @param int                             LesionNumber : to get lesionNumber of
	 *                                        lesion
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * @return void
	 */
	public void parseDataModel(String syntaxScoreString, int lesionNumber){
		FhirContext ctx = FhirContext.forR4();
		int count = 1;
		String question = null;
		String value = null;
		String bodySite = null;
		String bodySiteCode = null;
		String componentCode = null;
		String componentDisplay = null;
		lesionObservationList = new SyntaxScoreCalForLesionSubScore(syntaxScoreString);
		syntaxScoreCodeableConceptCodeValue.setLesionNumber(lesionNumber);
		List<String> syntaxScorefloat = lesionObservationList.createObservation();
		for (String obString : syntaxScorefloat) {
			IParser parser = ctx.newXmlParser();
			Observation parsed = parser.parseResource(Observation.class, obString);
			try {
				value = parsed.getValueCodeableConcept().getCoding().get(0).getDisplay();
				componentCode = parsed.getComponent().get(0).getValueCodeableConcept().getCoding().get(0).getCode();
				componentDisplay = parsed.getComponent().get(0).getValueCodeableConcept().getCoding().get(0)
						.getDisplay();
			}
			catch (Exception e) {
				LOG.info(" index out of bounds");
			}
			try {
				bodySite = parsed.getBodySite().getCoding().get(0).getDisplay();
				bodySiteCode = parsed.getBodySite().getCoding().get(0).getCode();
			} 
			catch (IndexOutOfBoundsException e) {
				LOG.info(" index out of bounds for bodySite ");
				LOG.info(bodySite);
			}
			try {
				question = getQuestion(parsed);
				if(question.equalsIgnoreCase("Aortic bifurcation embolus") && value.equalsIgnoreCase("Present")) {
					String mediaValue = parsed.getComponent().get(0).getValueCodeableConcept().getCoding().get(0).getDisplay();
					syntaxScoreCodeableConceptCodeValue.setBifurcationValue(valueUtil.bifurcationValue(value));
					syntaxScoreCodeableConceptCodeValue.setMedina(valueUtil.medina(mediaValue));
				}
				else if(question.equalsIgnoreCase("Trifurcation") ||  question.equalsIgnoreCase("Trifurcation lesion of coronary artery") && value.equalsIgnoreCase("Present")) {
					String triValue = parsed.getComponent().get(0).getValueCodeableConcept().getCoding().get(0).getCode();
					syntaxScoreCodeableConceptCodeValue.setTrifurcationValue(valueUtil.trifurcationValue(value));
					syntaxScoreCodeableConceptCodeValue.setDiseasedsegment(valueUtil.diseasedsegment(triValue));
				}
				switch (question.replace("\"\"", "")) {
				case "Coronary Artery Dominance":
					syntaxScoreCodeableConceptCodeValue.setSelectedDominance(valueUtil.coronaryArteryDominance(value));
					break;
				case "Left Cardiac Artery Dominance":
					syntaxScoreCodeableConceptCodeValue.setSelectedDominance(valueUtil.coronaryArteryDominance(value));
					break;
				case "Coronary Artery Right Dominance":
					syntaxScoreCodeableConceptCodeValue.setSelectedDominance(valueUtil.coronaryArteryDominance(value));
					break;
				case "Segment":
					syntaxScoreCodeableConceptCodeValue = valueUtil.segments(bodySiteCode);
					break;
				case "FirstSegment":
					syntaxScoreCodeableConceptCodeValue.setTotalOcclusion(valueUtil.totalOcclusion("Yes"));
					syntaxScoreCodeableConceptCodeValue = valueUtil.firstSegment(bodySiteCode);
					break;
				case "Age of total occlusion":
					syntaxScoreCodeableConceptCodeValue.setAgeOfTotalOcclusion(valueUtil.ageOfTotalOcclusion(value));
					break;
				case "Blunt Stump":
					syntaxScoreCodeableConceptCodeValue.setBluntStump(valueUtil.bluntStump(value));
					break;
				case "Bridging":
					syntaxScoreCodeableConceptCodeValue.setBridgingCollaterals(valueUtil.bridgingCollaterals(value));
					break;
				case "FirstSegmentVisualized":
					break;
				case "Sidebranch":
					syntaxScoreCodeableConceptCodeValue.setSideBranchInvolved(valueUtil.sideBranchInvolved(value));
					break;
				case "Coronary ostium stenosis":
					syntaxScoreCodeableConceptCodeValue.setAortoOstialValue(valueUtil.aortoOstialValue(value));
					break;
				case "Arterial tortuosity syndrome":
					syntaxScoreCodeableConceptCodeValue.setSeverTortuosityValue(valueUtil.severTortuosityValue(value));
					break;
				case "Pathologic calcification":
					syntaxScoreCodeableConceptCodeValue
					.setHeavyCalcificationValue(valueUtil.heavyCalcificationValue(value));
					break;
				case "Length":
					syntaxScoreCodeableConceptCodeValue.setLengthGT20mmValue(valueUtil.lengthGT20mmValue(value));
					break;
				case "Thrombus":
					syntaxScoreCodeableConceptCodeValue.setThrombusValue(valueUtil.thrombusValue(value));
					break;
				case "Diffuse disease of coronary artery":
					syntaxScoreCodeableConceptCodeValue
					.setDiffuseDiseaseValue(valueUtil.diffuseDiseaseValue("present"));
					break;
				case "Diffuse disease of coronary artery Envolved":
					syntaxScoreCodeableConceptCodeValue
					.setDiffuseDiseaseValue(valueUtil.diffuseDiseaseValue("present"));
					syntaxScoreCodeableConceptCodeValue = valueUtil.segments(bodySiteCode);
					break;
				case "Aortic bifurcation angulation":
					syntaxScoreCodeableConceptCodeValue
					.setBifurcationAngulation(valueUtil.bifurcationAngulation(value));
					break;
				case "Angular (qualifier value)":
					syntaxScoreCodeableConceptCodeValue
					.setBifurcationAngulation(valueUtil.bifurcationAngulation(value));
					break;
				default:
					LOG.info("no match");
				}
				LOG.log(Level.INFO, "Read file {}", count);
				count++;
			} catch (Exception e) {
				LOG.info(" index out of bounds for question ");
			}
		}
	}

	/**
	 * Gets the question name from the observation
	 * @param parsed
	 * @param value
	 * @return String question
	 */
	private String getQuestion(Observation parsed) {
		String question = null;
		question = parsed.getCode().getCoding().get(0).getDisplay();
		if (question == null) {
			question = parsed.getCode().getCoding().get(0).getCode();
		}
		return question;
	}
}