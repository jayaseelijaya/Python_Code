
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
import com.philips.hsdp.research.p360.syntaxscore.constant.DiffuseDiseaseConstant;

/*
 * @auther Sunil Kumar  
 */
public class SegmentMapForDiffuselyDiseased {
	List<String> selectedSegmentkeyList = new ArrayList<>();
	String segmentStringValue = null;
	float segmentWeightValue = 0.0f;
	List<String> segmentStringValueList = new ArrayList<>();
	List<Float> segmentWeightValueList = new ArrayList<>();
	Map<String, Float> segmentWeight;
	Map<String, String> segmentString;
	Map<String, Boolean> selectedSegment;
	Map<String, Boolean> diffuselyDiseased;
	String key = "";
	float value = 0.0f;
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	Map<String, Float> finalMap = new HashMap<>();

	/** 
	 * This function is used to create map pair for Weighttage and segment
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user data model- SyntaxScoreCodeableConceptModel
	 * @Param String,float: create map pair for Weighttage and segment
	 * @Param String,String: create map pair for segments and multiply by 2                                        
	 * @return float: it will return Weighttage, that we can call in DiffuseDiseaseProcessor.
	 */
	public float segmentsMap() {
		diffuselyDiseased = syntaxScoreCodeableConceptCodeValue.getSegment();
		for (Entry<String, Boolean> entry : diffuselyDiseased.entrySet()) {
			if (Boolean.TRUE.equals(entry.getValue())) {
				selectedSegmentkeyList.add(entry.getKey());
			}
		}
		segmentWeight = new HashMap<>();
		segmentWeight.put("1", DiffuseDiseaseConstant.RCA_PROXIMA1);
		segmentWeight.put("2", DiffuseDiseaseConstant.RCA_MID_2);
		segmentWeight.put("3", DiffuseDiseaseConstant.RCA_DISTA3);
		segmentWeight.put("5", DiffuseDiseaseConstant.LEFT_MAIN_5);
		segmentWeight.put("4", DiffuseDiseaseConstant.POSTERIODESCENDING_ARTERY_4);
		segmentWeight.put("6", DiffuseDiseaseConstant.LAD_PROXIMA6);
		segmentWeight.put("7", DiffuseDiseaseConstant.LAD_MID_7);
		segmentWeight.put("8", DiffuseDiseaseConstant.LAD_APICA8);
		segmentWeight.put("9", DiffuseDiseaseConstant.FIRST_DIAGONA9);
		segmentWeight.put("9a", DiffuseDiseaseConstant.ADD_FIRST_DIAGONA9A);
		segmentWeight.put("10", DiffuseDiseaseConstant.SECOND_DIAGONA10);
		segmentWeight.put("10a", DiffuseDiseaseConstant.ADD_SECOND_DIAGONA10A);
		segmentWeight.put("11", DiffuseDiseaseConstant.PROXIMACIRCUMFLEX_11);
		segmentWeight.put("12", DiffuseDiseaseConstant.INTERMEDIATE_ANTEROLATERA12);
		segmentWeight.put("12a", DiffuseDiseaseConstant.OBTUSE_MARGINA12A);
		segmentWeight.put("12b", DiffuseDiseaseConstant.OBTUSE_MARGINA12B);
		segmentWeight.put("13", DiffuseDiseaseConstant.DISTACIRCUMFLEX_13);
		segmentWeight.put("14", DiffuseDiseaseConstant.LEFT_POSTEROLATERA14);
		segmentWeight.put("14a", DiffuseDiseaseConstant.LEFT_POSTEROLATERALA_14A);
		segmentWeight.put("14b", DiffuseDiseaseConstant.LEFT_POSTEROLATERALB_14B);
		segmentWeight.put("15", DiffuseDiseaseConstant.POSTERIODESCENDING_15);
		segmentWeight.put("16", DiffuseDiseaseConstant.POSTEROLATERAL_BRANCH_FROM_RCA_16);
		segmentWeight.put("16a", DiffuseDiseaseConstant.POSTEROLATERAL_BRANCH_FROM_RCA_16A);
		segmentWeight.put("16b", DiffuseDiseaseConstant.POSTEROLATERAL_BRANCH_FROM_RCA_16B);
		segmentWeight.put("16c", DiffuseDiseaseConstant.POSTEROLATERAL_BRANCH_FROM_RCA_16C);
		for (Map.Entry<String, Float> pair : segmentWeight.entrySet()) {
			for (String str : selectedSegmentkeyList) {
				if (str.equalsIgnoreCase(pair.getKey())) {
					segmentWeightValueList.add(pair.getValue());
				}
			}
		}
		for (float i : segmentWeightValueList) {
			segmentWeightValue += i;
		}
		return segmentWeightValue;
	}

	/** 
	 * This function is used to create map pair for Weighttage and segment
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user data model- SyntaxScoreCodeableConceptModel
	 * @Param String,String: create map pair for segments                                         
	 * @return String: it will return (Segment): x1, that we can call in DiffuseDiseaseProcessor.
	 */
	public Map<String, Float> segmentsString() {

		diffuselyDiseased = syntaxScoreCodeableConceptCodeValue.getSegment();
		segmentString = new HashMap<>();
		segmentString.put("1", "Segment 1");
		segmentString.put("2", "Segment 2");
		segmentString.put("3", "Segment 3");
		segmentString.put("4", "Segment 4");
		segmentString.put("5", "Segment 5");
		segmentString.put("6", "Segment 6");
		segmentString.put("7", "Segment 7");
		segmentString.put("8", "Segment 8");
		segmentString.put("9", "Segment 9");
		segmentString.put("9a", "Segment 9a");
		segmentString.put("10", "Segment 10");
		segmentString.put("10a", "Segment 10a");
		segmentString.put("11", "Segment 11");
		segmentString.put("12", "Segment 12");
		segmentString.put("12a", "Segment 12a");
		segmentString.put("12b", "Segment 12b");
		segmentString.put("13", "Segment 13");
		segmentString.put("14", "Segment 14");
		segmentString.put("14a", "Segment 14a");
		segmentString.put("14b", "Segment 14b");
		segmentString.put("15", "Segment 15");
		segmentString.put("16", "Segment 16");
		segmentString.put("16a", "Segment 16a");
		segmentString.put("16b", "Segment 16b");
		segmentString.put("16c", "Segment 16c");
		for (Map.Entry<String, String> pair : segmentString.entrySet()) {
			for (Map.Entry<String, Float> pairNew : segmentWeight.entrySet()) {
				for (String str1 : selectedSegmentkeyList) {
					if (str1.equalsIgnoreCase(pair.getKey())) {
						segmentStringValueList.add(pair.getValue());
						segmentWeightValueList.add(pairNew.getValue());
						key = pair.getValue();
						value = pairNew.getValue();
						finalMap.put(key, value);
						if (!"".equals(key)) {
							finalMap.put(key, value);
						}
					}
				}
			}
		}
		return finalMap;
	}
}