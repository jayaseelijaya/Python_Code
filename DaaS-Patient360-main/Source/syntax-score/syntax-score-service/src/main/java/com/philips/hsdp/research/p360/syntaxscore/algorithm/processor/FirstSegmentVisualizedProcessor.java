/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.AccessSyntaxScoreModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;

/* @author Sunil Kumar */
@Service
public class FirstSegmentVisualizedProcessor extends SyntaxScoreProcessor {
	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	TreeMap<String, Float> totalSyntaxScore;
	float tempSyntaxScore;

	/**
	 * This function is used to calculate Syntax score left dominance for First
	 * Segment Visualized
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
		totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();

		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
	}

	/**
	 * This function is used to check Main Artery Segment for Side branch left
	 * dominance :
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user
	 *                                        data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean : to find main artery from list
	 */
	private boolean isMainArterySegmentSelectedForLeft(
			SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue) {
		boolean isMainArtery = false;

		Map<String, Boolean> segment = syntaxScoreCodeableConceptCodeValue.getSegment();
		List<String> selectedSegmentkeyList = new ArrayList<>();

		// To get all key: value
		for (Entry<String, Boolean> entry : segment.entrySet()) {
			if (Boolean.TRUE.equals(entry.getValue())) {
				selectedSegmentkeyList.add(entry.getKey());
			}
		}
		if ((selectedSegmentkeyList.contains("1")) || (selectedSegmentkeyList.contains("2"))
				|| (selectedSegmentkeyList.contains("5")) || (selectedSegmentkeyList.contains("6"))
				|| (selectedSegmentkeyList.contains("7")) || (selectedSegmentkeyList.contains("11"))
				|| (selectedSegmentkeyList.contains("13"))) {
			isMainArtery = true;
		}
		return isMainArtery;
	}

	/**
	 * This function is used to calculate Syntax score Right dominance for First
	 * Segment Visualized
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
		totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();
		if (isMainArterySegmentSelectedForLeft(syntaxScoreCodeableConceptCodeValue)) {
			syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
			syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
		}
	}

	/**
	 * This function is used to process based on condition applied successfully to
	 * calculate Syntax score Left Dominance and Right Dominance for First Segment
	 * Visualized
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
		if (syntaxScoreCodeableConceptCodeValue.isSelectedDominance()) {
			if (isMainArterySegmentSelectedForLeft(syntaxScoreCodeableConceptCodeValue)) {
				calculateSyntaxScoreLeftDominance();
			}
		} else {
			calculateSyntaxScoreRightDominance();
		}
		super.process();
	}
}