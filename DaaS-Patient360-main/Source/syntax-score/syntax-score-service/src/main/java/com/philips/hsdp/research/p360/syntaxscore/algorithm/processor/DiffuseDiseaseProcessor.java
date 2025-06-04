/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SegmentMapForDiffuselyDiseased;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;

/* @Author Sunil Kumar*/
@Service
public class DiffuseDiseaseProcessor extends SyntaxScoreProcessor {
	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	float tempSyntaxScore;
	TreeMap<String, Float> totalSyntaxScoreDiffuseDisease;
	Map<String, Boolean> diffuselyDiseased;
	Map<String, Boolean> diffuselyDiseasedMap;
	Map<String, Float> segmentStringValueList = new HashMap<>();

	/**
	 * This function is used to calculate Syntax score left dominance for Diffuse
	 * Disease
	 * 
	 * @inheritDoc : override super class SyntaxScoreProcessor.
	 * @param float                           : to generate score in float value
	 * @param treeMap<String,float>           : get and set string and float value
	 *                                        for syntax score in treeMap
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user
	 *                                        data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return void
	 */
	@Override
	public void calculateSyntaxScoreLeftDominance() {
		float tempSyntaxScoreDiffuseDisease = 0.0f;
		SegmentMapForDiffuselyDiseased segmentMapForDiffuselyDiseased = new SegmentMapForDiffuselyDiseased();
		tempSyntaxScore = syntaxScoreRequest.getSyntaxScore();

		totalSyntaxScoreDiffuseDisease = syntaxScoreRequest.getTotalSyntaxScore();
		if (syntaxScoreCodeableConceptCodeValue.isSelectedDominance()) {
			float segmentWeightValue = 0.0f;
			segmentWeightValue = segmentMapForDiffuselyDiseased.segmentsMap();
			segmentStringValueList = segmentMapForDiffuselyDiseased.segmentsString();
			tempSyntaxScore += segmentWeightValue;
			tempSyntaxScoreDiffuseDisease += segmentWeightValue;
			totalSyntaxScoreDiffuseDisease.putAll(segmentStringValueList);

			syntaxScoreRequest.setTempSyntaxScoreDiffuseDisease(tempSyntaxScoreDiffuseDisease);
			syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
			syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScoreDiffuseDisease);
			totalSyntaxScoreDiffuseDisease.put("Sub total diffuse disease/small vessels",
					tempSyntaxScoreDiffuseDisease);
			List<Float> floatSyntaxScoreList = syntaxScoreRequest.getListLesions();
			floatSyntaxScoreList.add(tempSyntaxScoreDiffuseDisease);
		}
	}

	@Override
	public void calculateSyntaxScoreRightDominance() {
		float tempSyntaxScoreDiffuseDisease = 0.0f;
		SegmentMapForDiffuselyDiseased segmentMapForDiffuselyDiseased = new SegmentMapForDiffuselyDiseased();
		tempSyntaxScore = syntaxScoreRequest.getSyntaxScore();

		totalSyntaxScoreDiffuseDisease = syntaxScoreRequest.getTotalSyntaxScore();
		if (!(syntaxScoreCodeableConceptCodeValue.isSelectedDominance())) {
			float segmentWeightValue = 0.0f;
			segmentWeightValue = segmentMapForDiffuselyDiseased.segmentsMap();
			segmentStringValueList = segmentMapForDiffuselyDiseased.segmentsString();
			tempSyntaxScore += segmentWeightValue;
			tempSyntaxScoreDiffuseDisease += segmentWeightValue;
			totalSyntaxScoreDiffuseDisease.putAll(segmentStringValueList);

			syntaxScoreRequest.setTempSyntaxScoreDiffuseDisease(tempSyntaxScoreDiffuseDisease);
			syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
			syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScoreDiffuseDisease);
			totalSyntaxScoreDiffuseDisease.put("Sub total diffuse disease/small vessels",
					tempSyntaxScoreDiffuseDisease);
			List<Float> floatSyntaxScoreList = syntaxScoreRequest.getListLesions();
			floatSyntaxScoreList.add(tempSyntaxScoreDiffuseDisease);
		}
	}
	/**
	 * This function is used to process based on condition applied successfully to
	 * calculate Syntax score Left Dominance and Right Dominance for Diffuse Disease
	 * 
	 * @inheritDoc : override super class SyntaxScoreProcessor.
	 * @param SyntaxScoreCodeableConceptModel : to parse the data from XML and map
	 *                                        the data model
	 * 
	 * @return void : process of calculate function
	 */
	@Override
	public void process() {
		if (syntaxScoreCodeableConceptCodeValue.isSelectedDominance()) {

			calculateSyntaxScoreLeftDominance();
		} else {
			calculateSyntaxScoreRightDominance();
		}
	}
}