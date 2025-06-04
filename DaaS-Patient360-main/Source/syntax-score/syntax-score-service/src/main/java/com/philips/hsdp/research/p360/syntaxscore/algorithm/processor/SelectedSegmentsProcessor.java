/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SegmentMapForLeft;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SegmentMapForRight;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;
import com.philips.hsdp.research.p360.syntaxscore.constant.FirstSegmentConstantLeft;

/* @author Sunil Kumar */
@Service
public class SelectedSegmentsProcessor extends SyntaxScoreProcessor {
	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	SegmentMapForLeft segmentMapForLeft = new SegmentMapForLeft();
	SegmentMapForRight segmentMapForRight = new SegmentMapForRight();
	float tempSyntaxScore;
	TreeMap<String, Float> totalSyntaxScore;
	Map<String, Float> syntaxScoreMap;
	Map<String, Boolean> selectedSegment;
	Map<String, Float> segmentWeight;
	Map<String, String> segmentString;

	/**
	 * This function is used to calculate Syntax score left dominance for Selected
	 * Segments
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
		Map<String, Float> segmentStringValue = null;
		float segmentWeightValue = 0.0f;
		syntaxScoreMap = new HashMap<>();
		totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();
		totalSyntaxScore.put("Lesion " + syntaxScoreCodeableConceptCodeValue.getLesionNumber(),
				FirstSegmentConstantLeft.L_LESION);
		tempSyntaxScore = 0.0f;
		segmentWeightValue = segmentMapForLeft.segmentsMap();
		segmentStringValue = segmentMapForLeft.segmentsString();
		tempSyntaxScore += segmentWeightValue * 2;
		syntaxScoreMap.putAll(segmentStringValue);
		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
		syntaxScoreRequest.setSyntaxScoreMap(syntaxScoreMap);
		syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
	}

	/**
	 * This function is used to calculate Syntax score left dominance for Selected
	 * Segments
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
	public void calculateSyntaxScoreRightDominance() {
		Map<String, Float> segmentStringValue = null;
		float segmentWeightValue = 0.0f;
		syntaxScoreMap = new HashMap<>();
		totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();
		totalSyntaxScore.put("Lesion " + syntaxScoreCodeableConceptCodeValue.getLesionNumber(),
				FirstSegmentConstantLeft.L_LESION);
		tempSyntaxScore = 0.0f;
		segmentWeightValue = segmentMapForRight.segmentsMap();
		segmentStringValue = segmentMapForRight.segmentsString();
		tempSyntaxScore += segmentWeightValue * 2;
		syntaxScoreMap.putAll(segmentStringValue);
		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
		syntaxScoreRequest.setSyntaxScoreMap(syntaxScoreMap);
		syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
	}

	/**
	 * This function is used to process based on condition applied successfully to
	 * calculate Syntax score Left Dominance and Right Dominance for Selected
	 * Segments
	 * 
	 * @inheritDoc : override super class SyntaxScoreProcessor.
	 * @param SyntaxScoreCodeableConceptModel : to parse the data from XML and map
	 *                                        the data model
	 * 
	 * @return skip current processor and it will go to next processor by using
	 *         super abstract class - SyntaxScoreProcessor
	 * @return void : process of calculate function
	 */
	@Override
	public void process() {
		if (isCurrentProcessorSkipped()) {
			return;
		}
		if (syntaxScoreCodeableConceptCodeValue.isSelectedDominance()) {
			calculateSyntaxScoreLeftDominance();
		} else {
			calculateSyntaxScoreRightDominance();
		}
		super.process();
	}
}