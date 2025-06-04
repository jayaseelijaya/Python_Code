/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.constant.FirstSegmentConstantLeft;
import com.philips.hsdp.research.p360.syntaxscore.constant.FirstSegmentConstantRight;

/* @author Sunil Kumar */
public class FirstSegmentMapForRight {
	Map<String, Float> segmentWeight;
	Map<String, String> segmentString;
	Map<String, Boolean> selectedSegment;
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();

	/**
	 * This function is used to create map pair for Weighttage and segment
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user
	 *                                        data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * @Param String,float: create map pair for Weighttage and segment
	 * @Param String,String: create map pair for segments and multiply by 2
	 * @return float: it will return Weighttage, that we can call in
	 *         SelectedSegmentsProcessor.
	 */
	public float segmentsMap() {
		selectedSegment = syntaxScoreCodeableConceptCodeValue.getFirstSegment();
		List<String> selectedSegmentkeyList = new ArrayList<>();
		for (Entry<String, Boolean> entry : selectedSegment.entrySet()) {
			if (Boolean.TRUE.equals(entry.getValue())) {
				selectedSegmentkeyList.add(entry.getKey());
			}
		}
		segmentWeight = new HashMap<>();
		segmentWeight.put("1", FirstSegmentConstantRight.R_RCA_PROXIMAL_1);
		segmentWeight.put("2", FirstSegmentConstantRight.R_RCA_MID_2);
		segmentWeight.put("3", FirstSegmentConstantRight.R_RCA_DISTAL_3);
		segmentWeight.put("4", FirstSegmentConstantRight.R_POSTERIOR_DESCENDING_ARTERY_4);
		segmentWeight.put("5", FirstSegmentConstantRight.R_LEFT_MAIN_5);
		segmentWeight.put("6", FirstSegmentConstantRight.R_LAD_PROXIMAL_6);
		segmentWeight.put("7", FirstSegmentConstantRight.R_LAD_MID_7);
		segmentWeight.put("8", FirstSegmentConstantRight.R_LAD_APICAL_8);
		segmentWeight.put("9", FirstSegmentConstantRight.R_FIRST_DIAGONAL_9);
		segmentWeight.put("9a", FirstSegmentConstantRight.R_ADD_FIRST_DIAGONAL_9A);
		segmentWeight.put("10", FirstSegmentConstantRight.R_SECOND_DIAGONAL_10);
		segmentWeight.put("10a", FirstSegmentConstantRight.R_ADD_SECOND_DIAGONAL_10A);
		segmentWeight.put("11", FirstSegmentConstantRight.R_PROXIMAL_CIRCUMFLEX_11);
		segmentWeight.put("12", FirstSegmentConstantRight.R_INTERMEDIATE_ANTEROLATERAL_12);
		segmentWeight.put("12a", FirstSegmentConstantRight.R_OBTUSE_MARGINAL_12A);
		segmentWeight.put("12b", FirstSegmentConstantRight.R_OBTUSE_MARGINAL_12B);
		segmentWeight.put("13", FirstSegmentConstantRight.R_DISTAL_CIRCUMFLEX_13);
		segmentWeight.put("14", FirstSegmentConstantRight.R_LEFT_POSTEROLATERAL_14);
		segmentWeight.put("14a", FirstSegmentConstantRight.R_LEFT_POSTEROLATERALA_14A);
		segmentWeight.put("14b", FirstSegmentConstantRight.R_LEFT_POSTEROLATERALB_14B);
		segmentWeight.put("16", FirstSegmentConstantRight.R_POSTEROLATERAL_BRANCH_FROM_RCA_16);
		segmentWeight.put("16a", FirstSegmentConstantRight.R_POSTEROLATERAL_BRANCH_FROM_RCA_16A);
		segmentWeight.put("16b", FirstSegmentConstantRight.R_POSTEROLATERAL_BRANCH_FROM_RCA_16B);
		segmentWeight.put("16c", FirstSegmentConstantRight.R_POSTEROLATERAL_BRANCH_FROM_RCA_16C);

		float segmentWeightValue = 0.0f;
		for (Map.Entry<String, Float> pair : segmentWeight.entrySet()) {
			for (String str : selectedSegmentkeyList) {
				if (str.equalsIgnoreCase(pair.getKey())) {
					segmentWeightValue = pair.getValue();
				}
			}
		}
		return segmentWeightValue;
	}

	/**
	 * This function is used to create map pair for Weighttage and segment
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user
	 *                                        data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * @Param String,String: create map pair for segments and multiply by 2
	 * @return String: it will return (Segment): 1.0x2, that we can call in
	 *         SelectedSegmentsProcessor.
	 */
	public String segmentsString() {
		selectedSegment = syntaxScoreCodeableConceptCodeValue.getFirstSegment();
		List<String> selectedSegmentkeyList = new ArrayList<>();
		for (Entry<String, Boolean> entry : selectedSegment.entrySet()) {
			if (Boolean.TRUE.equals(entry.getValue())) {
				selectedSegmentkeyList.add(entry.getKey());
			}
		}
		segmentString = new HashMap<>();
		segmentString.put("1", "(Segment 1): 1.0x2 ");
		segmentString.put("2", "(Segment 2): 1.0x2 ");
		segmentString.put("3", "(Segment 3): 1.0x2 ");
		segmentString.put("4", "(Segment 4): 1.0x2 ");
		segmentString.put("5", "(Segment 5): 5.0x2 ");
		segmentString.put("6", "(Segment 6): 3.5x2 ");
		segmentString.put("7", "(Segment 7): 2.5x2 ");
		segmentString.put("8", "(Segment 8): 1.0x2 ");
		segmentString.put("9", "(Segment 9): 1.0x2 ");
		segmentString.put("9a", "(Segment 9a): 1.0x2 ");
		segmentString.put("10", "(Segment 10): 0.5x2 ");
		segmentString.put("10a", "(Segment 10a): 0.5x2 ");
		segmentString.put("11", "(Segment 11): 1.5x2 ");
		segmentString.put("12", "(Segment 12): 1.0x2 ");
		segmentString.put("12a", "(Segment 12a): 1.0x2 ");
		segmentString.put("12b", "(Segment 12b): 1.0x2 ");
		segmentString.put("13", "(Segment 13): 0.5x2 ");
		segmentString.put("14", "(Segment 14): 0.5x2 ");
		segmentString.put("14a", "(Segment 14a): 0.5x2 ");
		segmentString.put("14b", "(Segment 14b): 0.5x2 ");
		segmentString.put("16", "(Segment 16): 0.5x2 ");
		segmentString.put("16a", "(Segment 16a): 0.5x2 ");
		segmentString.put("16b", "(Segment 16b): 0.5x2 ");
		segmentString.put("16c", "(Segment 16c): 0.5x2 ");
		String segmentStringValue = null;
		for (Map.Entry<String, String> pair : segmentString.entrySet()) {
			for (String str : selectedSegmentkeyList) {
				if (str.equalsIgnoreCase(pair.getKey())) {
					segmentStringValue = pair.getValue();
				}
			}
		}
		return segmentStringValue;
	}

	/**
	 * This function is used to create map pair for Weighttage and segment
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user
	 *                                        data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * @Param String,String: create map pair for segments and multiply by 5
	 * @return String: it will return (Segment): 1.0x5, that we can call in
	 *         SelectedSegmentsProcessor.
	 */
	public String segmentsStringForMultiplyFive() {
		selectedSegment = syntaxScoreCodeableConceptCodeValue.getFirstSegment();
		List<String> selectedSegmentkeyList = new ArrayList<>();
		for (Entry<String, Boolean> entry : selectedSegment.entrySet()) {
			if (Boolean.TRUE.equals(entry.getValue())) {
				selectedSegmentkeyList.add(entry.getKey());
			}
		}
		segmentString = new HashMap<>();
		segmentString.put("1", "(Segment 1): 1.0x5 ");
		segmentString.put("2", "(Segment 2): 1.0x5 ");
		segmentString.put("3", "(Segment 3): 1.0x5 ");
		segmentString.put("4", "(Segment 4): 1.0x5 ");
		segmentString.put("5", "(Segment 5): 5.0x5 ");
		segmentString.put("6", "(Segment 6): 3.5x5 ");
		segmentString.put("7", "(Segment 7): 2.5x5 ");
		segmentString.put("8", "(Segment 8): 1.0x5 ");
		segmentString.put("9", "(Segment 9): 1.0x5 ");
		segmentString.put("9a", "(Segment 9a): 1.0x5 ");
		segmentString.put("10", "(Segment 10): 0.5x5 ");
		segmentString.put("10a", "(Segment 10a): 0.5x5 ");
		segmentString.put("11", "(Segment 11): 1.5x5 ");
		segmentString.put("12", "(Segment 12): 1.0x5 ");
		segmentString.put("12a", "(Segment 12a): 1.0x5 ");
		segmentString.put("12b", "(Segment 12b): 1.0x5 ");
		segmentString.put("13", "(Segment 13): 0.5x5 ");
		segmentString.put("14", "(Segment 14): 0.5x5 ");
		segmentString.put("14a", "(Segment 14a): 0.5x5 ");
		segmentString.put("14b", "(Segment 14b): 0.5x5 ");
		segmentString.put("16", "(Segment 16): 0.5x5 ");
		segmentString.put("16a", "(Segment 16a): 0.5x5 ");
		segmentString.put("16b", "(Segment 16b): 0.5x5 ");
		segmentString.put("16c", "(Segment 16c): 0.5x5 ");
		String segmentStringValue = null;
		for (Map.Entry<String, String> pair : segmentString.entrySet()) {
			for (String str : selectedSegmentkeyList) {
				if (str.equalsIgnoreCase(pair.getKey())) {
					segmentStringValue = pair.getValue();
				}
			}
		}
		return segmentStringValue;
	}
}