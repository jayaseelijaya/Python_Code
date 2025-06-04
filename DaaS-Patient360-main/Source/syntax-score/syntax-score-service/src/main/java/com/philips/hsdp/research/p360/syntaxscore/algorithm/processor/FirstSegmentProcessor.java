/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.processor;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.FirstSegmentMapForLeft;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.FirstSegmentMapForRight;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;

/* @author Sunil Kumar */
@Service
public class FirstSegmentProcessor extends SyntaxScoreProcessor {
	float tempSyntaxScore;
	TreeMap<String, Float> totalSyntaxScore;
	Map<String, Float> syntaxScoreMap;
	String st = null;
	Map<String, Boolean> selectedSegment;
	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	FirstSegmentMapForRight segmentMapForRight = new FirstSegmentMapForRight();
	FirstSegmentMapForLeft segmentMapForLeft = new FirstSegmentMapForLeft();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	SelectedSegmentsProcessor selectedSegmentsProcessor = new SelectedSegmentsProcessor();

	/**
	 * This function is used to calculate Syntax score left dominance for First
	 * Segment
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
		tempSyntaxScore = syntaxScoreRequest.getSyntaxScore();
		syntaxScoreMap = syntaxScoreRequest.getSyntaxScoreMap();
		totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();
		selectedSegment = syntaxScoreCodeableConceptCodeValue.getFirstSegment();
		if (syntaxScoreCodeableConceptCodeValue.isTotalOcclusion()) {
			String segmentStringValue = null;
			String segmentStringValueForFive = null;
			float segmentWeightValue = 0.0f;
			totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();
			segmentWeightValue = segmentMapForLeft.segmentsMap();
			segmentStringValue = segmentMapForLeft.segmentsString();
			segmentStringValueForFive = segmentMapForLeft.segmentsStringForMultiplyFive();
			tempSyntaxScore -= segmentWeightValue * 2;
			tempSyntaxScore += segmentWeightValue * 5;
			syntaxScoreMap.put(segmentStringValueForFive, segmentWeightValue * 5);
			syntaxScoreMap.remove(segmentStringValue);
		}
		
		if (!(syntaxScoreCodeableConceptCodeValue.isTotalOcclusion())) {
			// skip processor
		}
		totalSyntaxScore.putAll(syntaxScoreMap);
		syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
	}

	/**
	 * This function is used to calculate Syntax score left dominance for First
	 * Segment
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
		tempSyntaxScore = syntaxScoreRequest.getSyntaxScore();
		syntaxScoreMap = syntaxScoreRequest.getSyntaxScoreMap();
		totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();

		if (syntaxScoreCodeableConceptCodeValue.isTotalOcclusion()) {
			String segmentStringValue = null;
			String segmentStringValueForFive = null;
			float segmentWeightValue = 0.0f;
			totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();
			segmentWeightValue = segmentMapForRight.segmentsMap();
			segmentStringValue = segmentMapForRight.segmentsString();
			segmentStringValueForFive = segmentMapForLeft.segmentsStringForMultiplyFive();
			tempSyntaxScore -= segmentWeightValue * 2;
			tempSyntaxScore += segmentWeightValue * 5;
			syntaxScoreMap.put(segmentStringValueForFive, segmentWeightValue * 5);
			syntaxScoreMap.remove(segmentStringValue);

		}
		if (!(syntaxScoreCodeableConceptCodeValue.isTotalOcclusion())) {
			// skip processor
		}

		totalSyntaxScore.putAll(syntaxScoreMap);
		syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
	}

	/**
	 * This function is used to process based on condition applied successfully to
	 * calculate Syntax score Left Dominance and Right Dominance for First Segment
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
			super.process();
			return;
		}
		if (syntaxScoreCodeableConceptCodeValue.isTotalOcclusion()) {
			if (syntaxScoreCodeableConceptCodeValue.isSelectedDominance()) {
				calculateSyntaxScoreLeftDominance();
			} else {
				calculateSyntaxScoreRightDominance();
			}
		}
		super.process();
	}
}