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

/*
 * @author Sunil Kumar   
 */
public class SegmentMapForLeft {
	Map<String, Float> segmentWeight;
	Map<String, String> segmentString;
	Map<String, Boolean> selectedSegment;
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	Map<String, Float> finalMap = new HashMap<>();

	/** 
	 * This function is used to create map pair for Weighttage and segment
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user data model- SyntaxScoreCodeableConceptModel
	 * @Param String,float: create map pair for Weighttage and segment
	 * @Param String,String: create map pair for segments and multiply by 2                                        
	 * @return float: it will return Weighttage, that we can call in SelectedSegmentsProcessor.
	 */
	public float segmentsMap() {
		selectedSegment = syntaxScoreCodeableConceptCodeValue.getSegment();
		List<String> selectedSegmentkeyList = new ArrayList<>();
		for (Entry<String, Boolean> entry : selectedSegment.entrySet()) {
			if (Boolean.TRUE.equals(entry.getValue())) {
				selectedSegmentkeyList.add(entry.getKey());
			}
		}
		segmentWeight = new HashMap<>();
		segmentWeight.put("1", FirstSegmentConstantLeft.L_RCA_PROXIMAL_1);
		segmentWeight.put("2", FirstSegmentConstantLeft.L_RCA_MID_2);
		segmentWeight.put("3", FirstSegmentConstantLeft.L_RCA_DISTAL_3);
		segmentWeight.put("5", FirstSegmentConstantLeft.L_LEFT_MAIN_5);
		segmentWeight.put("6", FirstSegmentConstantLeft.L_LAD_PROXIMAL_6);
		segmentWeight.put("7", FirstSegmentConstantLeft.L_LAD_MID_7);
		segmentWeight.put("8", FirstSegmentConstantLeft.L_LAD_APICAL_8);
		segmentWeight.put("9", FirstSegmentConstantLeft.L_FIRST_DIAGONAL_9);
		segmentWeight.put("9a", FirstSegmentConstantLeft.L_ADD_FIRST_DIAGONAL_9A);
		segmentWeight.put("10", FirstSegmentConstantLeft.L_SECOND_DIAGONAL_10);
		segmentWeight.put("10a", FirstSegmentConstantLeft.L_ADD_SECOND_DIAGONAL_10A);
		segmentWeight.put("11", FirstSegmentConstantLeft.L_PROXIMAL_CIRCUMFLEX_11);
		segmentWeight.put("12", FirstSegmentConstantLeft.L_INTERMEDIATE_ANTEROLATERAL_12);
		segmentWeight.put("12a", FirstSegmentConstantLeft.L_OBTUSE_MARGINAL_12A);
		segmentWeight.put("12b", FirstSegmentConstantLeft.L_OBTUSE_MARGINAL_12B);
		segmentWeight.put("13", FirstSegmentConstantLeft.L_DISTAL_CIRCUMFLEX_13);
		segmentWeight.put("14", FirstSegmentConstantLeft.L_LEFT_POSTEROLATERAL_14);
		segmentWeight.put("14a", FirstSegmentConstantLeft.L_LEFT_POSTEROLATERALA_14A);
		segmentWeight.put("14b", FirstSegmentConstantLeft.L_LEFT_POSTEROLATERALB_14B);
		segmentWeight.put("15", FirstSegmentConstantLeft.L_POSTERIOR_DESCENDING_15);

		float segmentWeightValue = 0.0f;
		for (Map.Entry<String, Float> pair : segmentWeight.entrySet()) {
			for (String str : selectedSegmentkeyList) {
				if (str.equalsIgnoreCase(pair.getKey())) {
					segmentWeightValue += pair.getValue();
				}
			}
		}
		return segmentWeightValue;
	}

	/** 
	 * This function is used to create map pair for Weighttage and segment
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user data model- SyntaxScoreCodeableConceptModel
	 * @Param String,String: create map pair for segments and multiply by 2                                        
	 * @return String: it will return (Segment): 1.0x2, that we can call in SelectedSegmentsProcessor.
	 */
	public Map<String, Float> segmentsString() {
		selectedSegment = syntaxScoreCodeableConceptCodeValue.getSegment();
		List<String> selectedSegmentkeyList = new ArrayList<>();
		for (Entry<String, Boolean> entry : selectedSegment.entrySet()) {
			if (Boolean.TRUE.equals(entry.getValue())) {
				selectedSegmentkeyList.add(entry.getKey());
			}
		}
		segmentString = new HashMap<>();
		segmentString.put("1", "(Segment 1): 0x2 ");
		segmentString.put("2", "(Segment 2): 0x2 ");
		segmentString.put("3", "(Segment 3): 0x2 ");
		segmentString.put("5", "(Segment 5): 6x2 ");
		segmentString.put("6", "(Segment 6): 3.5x2 ");
		segmentString.put("7", "(Segment 7): 2.5x2 ");
		segmentString.put("8", "(Segment 8): 1.0x2 ");
		segmentString.put("9", "(Segment 9): 1.0x2 ");
		segmentString.put("9a", "(Segment 9a): 1.0x2 ");
		segmentString.put("10", "(Segment 10): 0.5x2 ");
		segmentString.put("10a", "(Segment 10a): 0.5x2 ");
		segmentString.put("11", "(Segment 11): 2.5x2 ");
		segmentString.put("12", "(Segment 12): 1.0x2 ");
		segmentString.put("12a", "(Segment 12a): 1.0x2 ");
		segmentString.put("12b", "(Segment 12b): 1.0x2 ");
		segmentString.put("13", "(Segment 13): 1.5x2 ");
		segmentString.put("14", "(Segment 14): 1.0x2 ");
		segmentString.put("14a", "(Segment 14a): 1.0x2 ");
		segmentString.put("14b", "(Segment 14b): 1.0x2 ");
		segmentString.put("15", "(Segment 15): 1.0x2 ");		
		for (Map.Entry<String, String> pair : segmentString.entrySet()) {
			for (String str : selectedSegmentkeyList) {
				if (str.equalsIgnoreCase(pair.getKey())) {
					finalMap.put(pair.getValue(), segmentWeight.get(str)*2);
				}
			}
		}
		return finalMap;
	}
}
