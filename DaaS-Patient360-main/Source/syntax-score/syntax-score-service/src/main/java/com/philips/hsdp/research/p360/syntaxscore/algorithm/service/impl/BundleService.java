/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hl7.fhir.r4.model.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.constant.BundleConstants;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.BundleSyntaxScoreObservation;
import com.philips.hsdp.research.p360.syntaxscore.utility.ParseBundle;

/* @author Raj Kumar */
@Service
public class BundleService {

	@Autowired
	ParseBundle parseBundle;

	public List<String> getfinalSyntaxScoreObsList(List<Observation> observationList, Map<String, String> syntaxScoreObsMap) {
		Map<String, List<String>> subScoreTOobservationList =  new HashMap<>();
		Map<String, List<String>> subScoreLesionObsList =  new HashMap<>();
		//Get Lesion observation list
		for (Map.Entry<String, String> entry : syntaxScoreObsMap.entrySet()) {
			if(!entry.getKey().equalsIgnoreCase(BundleConstants.DOMINANCE) && !entry.getKey().equalsIgnoreCase(BundleConstants.DIFUSELY_SUBSCORE)) {
				//get observations under lesion and bifurcation
				subScoreLesionObsList.put(entry.getKey(), parseBundle.getLesionObservation(entry.getValue(), observationList));
			}
		}
		for (Map.Entry<String, List<String>> entry : subScoreLesionObsList.entrySet()) {
			//Get Total occulation observationList
			subScoreTOobservationList.put(entry.getKey(), parseBundle.getTOobservationList(entry.getValue()));
		}
		//Get Diffusely Diseased observationList
		List<String> subScoreDiffuselyDiseasedList = parseBundle.getDiffusedObservations(observationList);
		//Score of Lesion & update score to lesion
		List<String> finalSyntaxScoreObsList =  new ArrayList<>();
		double lesionSubScore = 0;
		for (Map.Entry<String, List<String>> entry : subScoreLesionObsList.entrySet()) {
			if(!entry.getKey().equalsIgnoreCase(BundleConstants.DOMINANCE) && !entry.getKey().equalsIgnoreCase(BundleConstants.DIFUSELY_SUBSCORE)) {
				int noOfLesion = Character.getNumericValue(entry.getKey().charAt(entry.getKey().length() - 1));
				List<String> observationsForLesionScore =  new ArrayList<>();
				observationsForLesionScore.addAll(entry.getValue());
				observationsForLesionScore.add(syntaxScoreObsMap.get(BundleConstants.DOMINANCE));
				String lesionScore = parseBundle.getLesionScore(observationsForLesionScore, noOfLesion);
				lesionSubScore = Double.parseDouble(lesionScore) + lesionSubScore;
				//Update SCore to lesion observation
				finalSyntaxScoreObsList.add(parseBundle.updateLesionSubscore(syntaxScoreObsMap.get(entry.getKey()), lesionScore));
			}
		}	
		//Score of Diffusely Diseased:
		List<String> observationsForDiffuselyScore =  new ArrayList<>();
		observationsForDiffuselyScore.addAll(subScoreDiffuselyDiseasedList);
		observationsForDiffuselyScore.add(syntaxScoreObsMap.get(BundleConstants.DIFUSELY_SUBSCORE));
		observationsForDiffuselyScore.add(syntaxScoreObsMap.get(BundleConstants.DOMINANCE));
		observationsForDiffuselyScore.removeAll(Collections.singleton(null));
		String diffuselyDiseasedScore = parseBundle.getDiffuselyDiseasedScore(observationsForDiffuselyScore);
		//Update Score to diffusely diseased subscore obervation
		finalSyntaxScoreObsList.add(parseBundle.updateDiffsuleySubscore(syntaxScoreObsMap.get(BundleConstants.DIFUSELY_SUBSCORE), diffuselyDiseasedScore));

		//Final Syntax Score 
		double finalSyntaxScore = lesionSubScore + Double.parseDouble(diffuselyDiseasedScore);

		//Final SyntaxScoreObsList
		finalSyntaxScoreObsList.add(syntaxScoreObsMap.get(BundleConstants.DOMINANCE));

		finalSyntaxScoreObsList.removeAll(Collections.singleton(null));
		String listString = String.join(", ", finalSyntaxScoreObsList);
		String encodedString = Base64.getUrlEncoder().encodeToString(listString.getBytes());
		BundleSyntaxScoreObservation syntaxScoreObservation = new BundleSyntaxScoreObservation(encodedString, finalSyntaxScore);
		String syntaxScoreObs = syntaxScoreObservation.createObservation();
		List<String> subScoreObsList =  new ArrayList<>();
		subScoreObsList.add(syntaxScoreObs);
		subScoreObsList.addAll(finalSyntaxScoreObsList);
		return subScoreObsList;
	}
}	