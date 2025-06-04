/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.utility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Observation.ObservationComponentComponent;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.ResourceType;
import org.springframework.stereotype.Component;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.ParseXmlToDataModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.DiffuseDiseaseProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScoreCalculator;
import com.philips.hsdp.research.p360.syntaxscore.constant.BundleConstants;
import com.philips.hsdp.research.p360.syntaxscore.constant.ObservationProfilesContants;
import com.philips.hsdp.research.p360.syntaxscore.constant.Snomed;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.SyntaxScoreCalForLesionSubScore;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/** @author Raj Kumar */
@Component
public class ParseBundle {

	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	float response;

	/**
	 * Gets all the individual observation out from the bundle
	 * @param bundleString
	 * @param contentType
	 * @return List of Observations
	 */
	public List<Observation> getAllObservation(String bundleString, String contentType) {
		List<Observation> observationList = new ArrayList<>();
		FhirContext ctx = FhirContext.forR4();
		IParser parser;
		parser =  contentType.equalsIgnoreCase(BundleConstants.CONTENT_TYPE_XML) ? ctx.newXmlParser() :
			ctx.newJsonParser();
		Bundle bundle = parser.parseResource(Bundle.class, bundleString);
		List<BundleEntryComponent> entry = bundle.getEntry();
		for (BundleEntryComponent bundleEntryComponent : entry) {
			Observation observationResource;
			ResourceType resourceType = bundleEntryComponent.getResource().getResourceType();
			if(!resourceType.toString().equalsIgnoreCase("Patient")){
				observationResource = (Observation) bundleEntryComponent.getResource();
				observationList.add(observationResource);
			}
		}
		return observationList;
	}

	/**
	 * Gets the Dominance, SubScore Lesion and SubScore Diffusely Diseased observations
	 * @param observationList
	 * @return List of Observations
	 */
	public Map<String, String> getObservationsForSyntaxScore(List<Observation> observationList) {
		String profile = "";
		int lesionNumber = 1;
		String observationString = "";
		Map<String, String> finalObservationList = new HashMap<>();
		FhirContext ctx = FhirContext.forR4();
		for (Observation observation : observationList) {
			profile = observation.getMeta().getProfile().get(0).getValue();
			observationString = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(observation);
			if (profile.replace("\"\"", "").equalsIgnoreCase(ObservationProfilesContants.DOMINANCE_PROFILE)) {
				finalObservationList.put("Dominace", observationString);
			} 
			else if (profile.replace("\"\"", "").equalsIgnoreCase(ObservationProfilesContants.LESION_PROFILE)) {
				finalObservationList.put("LesionSubScore" + lesionNumber, observationString);
				lesionNumber++;
			}
			else if (profile.replace("\"\"", "").equalsIgnoreCase(ObservationProfilesContants.DIFUSED_PROFILE)) {
				finalObservationList.put("DiffusedSubScore", observationString);
			}
		}
		return finalObservationList;
	}

	/**
	 * Gets the hasMember Observations of Lesion
	 * @param lesionObs
	 * @param observationList
	 * @return List of Observations
	 */
	public List<String> getLesionObservation(String lesionObs, List<Observation> observationList) {
		List<String> lesionObservationList = new ArrayList<>();
		FhirContext ctx = FhirContext.forR4();
		IParser parser = ctx.newXmlParser();
		Observation observationResource = parser.parseResource(Observation.class, lesionObs);
		List<Reference> hasMemberList = observationResource.getHasMember();
		List<Reference> fullHasMemberList = new ArrayList<>();
		fullHasMemberList.addAll(hasMemberList);
		fullHasMemberList.addAll(getLesionHasMember(observationList, hasMemberList));
		for (Observation observation : observationList) {
			for (Reference hasMember : fullHasMemberList) {
				if (hasMember.getReference().equalsIgnoreCase(observation.getId())) {
					String observationString = ctx.newXmlParser().setPrettyPrint(true)
							.encodeResourceToString(observation);
					lesionObservationList.add(observationString);
				}
			}
		}
		return lesionObservationList;
	}

	/**
	 * Gets all the HasMember list under Lesion
	 * @param observationList
	 * @param hasMemberList
	 * @return List of HasMember
	 */
	private List<Reference> getLesionHasMember(List<Observation> observationList, List<Reference> hasMemberList) {
		List<Reference> fullHasMemberList = new ArrayList<>();
		for (Observation observation : observationList) {
			for (Reference hasMember : hasMemberList) {
				if (hasMember.getReference().equalsIgnoreCase(observation.getId())) {
					String profile = observation.getMeta().getProfile().get(0).getValue();
					if (profile.equalsIgnoreCase(ObservationProfilesContants.LESION_PROFILE)
							|| profile.equalsIgnoreCase(ObservationProfilesContants.BIFURCATION_PROFILE)
							|| profile.equalsIgnoreCase(ObservationProfilesContants.TO_SUBSCORE_PROFILE)) {
						fullHasMemberList.addAll(observation.getHasMember());
					}
				}
			}
		}
		return fullHasMemberList;
	}

	/**
	 * Gets Bifurcation observation and its HasMember
	 * @param observationList
	 * @return String Observation
	 */
	public String getBifurcationList(List<Observation> observationList) {
		String bifurcationObservation = null;
		List<Reference> hasMemberList = new ArrayList<>();
		FhirContext ctx = FhirContext.forR4();

		for (Observation observation : observationList) {
			String profile = observation.getMeta().getProfile().get(0).getValue();
			if (profile.equalsIgnoreCase(ObservationProfilesContants.BIFURCATION_PROFILE)) {
				hasMemberList = observation.getHasMember();
			}
		}

		for (Observation observation : observationList) {
			for (Reference hasMember : hasMemberList) {
				if (hasMember.getReference().equalsIgnoreCase(observation.getId())) {
					String observationString = ctx.newXmlParser().setPrettyPrint(true)
							.encodeResourceToString(observation);
					bifurcationObservation = observationString;
				}
			}
		}
		return bifurcationObservation;
	}

	/**
	 * Get all the observations under TotalOcclusion
	 * @param lesionObsList
	 * @return List of Observations
	 */
	public List<String> getTOobservationList(List<String> lesionObsList) {
		List<String> totalOcculusionObservationList = new ArrayList<>();
		List<Observation> observationList = new ArrayList<>();
		List<Reference> hasMemberList = new ArrayList<>();
		FhirContext ctx = FhirContext.forR4();
		IParser parser = ctx.newXmlParser();
		for (String observation : lesionObsList) {
			Observation observationResource = parser.parseResource(Observation.class, observation);
			observationList.add(observationResource);
		}

		for (Observation observation : observationList) {
			String profile = observation.getMeta().getProfile().get(0).getValue();
			if (profile.equalsIgnoreCase(ObservationProfilesContants.TO_SUBSCORE_PROFILE)) {
				hasMemberList = observation.getHasMember();
			}
		}

		for (Observation observation : observationList) {
			for (Reference hasMember : hasMemberList) {
				if (hasMember.getReference().equalsIgnoreCase(observation.getId())) {
					String observationString = ctx.newXmlParser().setPrettyPrint(true)
							.encodeResourceToString(observation);
					totalOcculusionObservationList.add(observationString);
				}
			}
		}
		return totalOcculusionObservationList;
	}

	/**
	 * Gets all observations under Diffusely Diseased
	 * @param observationList
	 * @return List of Observations
	 */
	public List<String> getDiffusedObservations(List<Observation> observationList) {
		List<String> diffusedObsList = new ArrayList<>();
		List<Reference> hasMemberList = new ArrayList<>();
		FhirContext ctx = FhirContext.forR4();

		for (Observation observation : observationList) {
			String profile = observation.getMeta().getProfile().get(0).getValue();
			if (profile.equalsIgnoreCase(ObservationProfilesContants.DIFUSED_PROFILE)) {
				hasMemberList = observation.getHasMember();
			}
		}

		for (Observation observation : observationList) {
			for (Reference hasMember : hasMemberList) {
				if (hasMember.getReference().equalsIgnoreCase(observation.getId())) {
					String observationString = ctx.newXmlParser().setPrettyPrint(true)
							.encodeResourceToString(observation);
					diffusedObsList.add(observationString);
				}
			}
		}
		return diffusedObsList;
	}

	/**
	 * Calculates the Lesion SubScore value
	 * @param subScoreLesionObsList
	 * @param lesionNumber
	 * @return String Score
	 */
	public String getLesionScore(List<String> subScoreLesionObsList, int lesionNumber) {
		String listString = String.join(", ", subScoreLesionObsList);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		SyntaxScoreCalForLesionSubScore syntaxScoreFloat = new SyntaxScoreCalForLesionSubScore(encodedString);
		syntaxScoreFloat.createObservation();
		SyntaxScoreCalculator syntaxScoreCalculator = new SyntaxScoreCalculator();
		ParseXmlToDataModel mt = new ParseXmlToDataModel();
		mt.parseDataModel(encodedString, lesionNumber);
		syntaxScoreCalculator.initSyntaxScoreCalculator();
		response = syntaxScoreRequest.getSyntaxScore();
		String responseString = String.valueOf(response);
		syntaxScoreCodeableConceptCodeValue.reset();
		return responseString;
	}

	/**
	 * Calculates the Diffusely Diseased SubScore value
	 * @param subScoreLesionObsList
	 * @param lesionNumber
	 * @return String Score
	 */
	public String getDiffuselyDiseasedScore(List<String> observationsForDiffuselyScore) {
		String listString = String.join(", ", observationsForDiffuselyScore);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		SyntaxScoreCalForLesionSubScore syntaxScoreFloat = new SyntaxScoreCalForLesionSubScore(encodedString);
		syntaxScoreFloat.createObservation();
		SyntaxScore syntaxScoreInstance = SyntaxScore.getInstance();
		ParseXmlToDataModel mt = new ParseXmlToDataModel();
		int lesionNumber = 0;
		mt.parseDataModel(encodedString, lesionNumber);
		DiffuseDiseaseProcessor diffuseDiseaseProcessor = new DiffuseDiseaseProcessor();
		diffuseDiseaseProcessor.process();
		float responseFloat = syntaxScoreInstance.getTempSyntaxScoreDiffuseDisease();
		String responseString = String.valueOf(responseFloat);
		syntaxScoreCodeableConceptCodeValue.reset();
		return responseString;
	}

	/**
	 * Updates the lesion subscore value into the observation
	 * @param observation
	 * @param lesionScore
	 * @return String Observation
	 */
	public String updateLesionSubscore(String observation, String lesionScore) {
		FhirContext ctx = FhirContext.forR4();
		IParser parser = ctx.newXmlParser();
		Observation parsed = parser.parseResource(Observation.class, observation);
		BigDecimal score = BigDecimal.valueOf(Float.valueOf(lesionScore));
		Quantity quantity = new Quantity();
		quantity.setValue(score).setSystem(TerminologyServer.UNIT_OF_MEASURE_URL).setCode(TerminologyServer.SCORE);
		parsed.setValue(quantity);
		return ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(parsed);
	}

	/**
	 * Updates the Diffusely Diseased SubScore value into the observation
	 * @param observation
	 * @param lesionScore
	 * @return String Observation
	 */
	public String updateDiffsuleySubscore(String observation, String diffuselyDiseasedScore) {
		FhirContext ctx = FhirContext.forR4();
		IParser parser = ctx.newXmlParser();
		Observation parsed = parser.parseResource(Observation.class, observation);
		// Value
		BigDecimal diffuselyScore = BigDecimal.valueOf(Float.valueOf(diffuselyDiseasedScore));
		// Component code
		List<ObservationComponentComponent> componentComponents = new ArrayList<>();
		CodeableConcept componenetCode = new CodeableConcept();
		componenetCode.addCoding().setSystem(Snomed.SNOMED_URL).setCode(Snomed.COMPONENT_CODE_DIFFUSELY_DISEASED)
		.setDisplay(Snomed.COMPONENT_DISPLAY_DIFFUSELY_DISEASED);
		ObservationComponentComponent obsComponent = new ObservationComponentComponent();
		obsComponent.setCode(componenetCode);
		// Component Value Quantity
		Quantity quantity = new Quantity();
		quantity.setValue(diffuselyScore).setSystem(TerminologyServer.UNIT_OF_MEASURE_URL)
		.setCode(TerminologyServer.SCORE);
		obsComponent.setValue(quantity);
		componentComponents.add(obsComponent);
		parsed.setComponent(componentComponents);
		return ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(parsed);
	}
	/**
	 * Get patient resource from bundle
	 * @param bundleInput
	 * @param contentType
	 * @return
	 */
	public Patient getPatient(String bundleInput, String contentType) {
		FhirContext ctx = FhirContext.forR4();
		IParser parser;
		parser =  contentType.equalsIgnoreCase(BundleConstants.CONTENT_TYPE_XML) ? ctx.newXmlParser() :
			ctx.newJsonParser();
		Bundle bundle = parser.parseResource(Bundle.class, bundleInput);
		//Patient
		Patient patient = null;
		List<BundleEntryComponent> entry = bundle.getEntry();
		for (BundleEntryComponent bundleEntryComponent : entry) {
			ResourceType resourceType = bundleEntryComponent.getResource().getResourceType();
			if(resourceType.toString().equalsIgnoreCase("Patient")){
				patient = (Patient) bundleEntryComponent.getResource();
			}
		}
		return patient;
	}
}