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
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;
import com.philips.hsdp.research.p360.syntaxscore.constant.SideBranchConstantLeft;
import com.philips.hsdp.research.p360.syntaxscore.constant.SideBranchConstantRight;

/* @author Sunil Kumar */
@Service
public class SidebranchProcessor extends SyntaxScoreProcessor {
	int selectedOcclussion;
	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	float tempSyntaxScore;
	TreeMap<String, Float> totalSyntaxScore;

	/** 
	 * This function is used to calculate Syntax score left dominance for Side branch
	 * 
	 * @inheritDoc : override super class SyntaxScoreProcessor.
	 * @param float                           : to generate score in float value
	 * @param treeMap<String,float>           : get and set string and float value for syntax score in treeMap
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user data model- SyntaxScoreCodeableConceptModel
	 *                                        
	 * @return void
	 */
	@Override
	public void calculateSyntaxScoreLeftDominance() {

		tempSyntaxScore = syntaxScoreRequest.getSyntaxScore();
		totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();
		selectedOcclussion = syntaxScoreCodeableConceptCodeValue.getSideBranchInvolved();

		if (selectedOcclussion == 1) {
			tempSyntaxScore += SideBranchConstantLeft.L_YES_ALLSIDEBRANCHS_LT_1_POINT_5_MM;
			totalSyntaxScore.put("Yes, all sidebranches Lt 1.5mm ",
					SideBranchConstantLeft.L_YES_ALLSIDEBRANCHS_LT_1_POINT_5_MM);
		} else if (selectedOcclussion == 2) {
			tempSyntaxScore += SideBranchConstantLeft.L_YES_ALLSIDEBRANCHES_GTOREQUAL_1_POINT_5_MM;
			totalSyntaxScore.put("Yes, all sidebranches Gt Or Equal 1.5mm ",
					SideBranchConstantLeft.L_YES_ALLSIDEBRANCHES_GTOREQUAL_1_POINT_5_MM);
		} else if (selectedOcclussion == 3) {
			tempSyntaxScore += SideBranchConstantLeft.L_YES_ALLSIDEBRANCHES_LT_1_POINT_5_MM_AND_GTOREQUAL_1_POINT_5_MM_ARE_INVOLVED;
			totalSyntaxScore.put("Yes, both sidebranches Lt 1.5 mm And GtOrEqual 1.5mm are involved ",
					SideBranchConstantLeft.L_YES_ALLSIDEBRANCHES_LT_1_POINT_5_MM_AND_GTOREQUAL_1_POINT_5_MM_ARE_INVOLVED);
		}
		// if selectedSegment contain main artery ..
		if ((selectedOcclussion == 0) || (selectedOcclussion == 1)
				&& IsMainArterySegmentSelectedForLeft(syntaxScoreCodeableConceptCodeValue)) {

			// is should be go for Aoroto astial
			super.setSkipCurrentProcessor(5);

			// if selected Segment doesn't contain main artery and select 1 &2
		} else if ((selectedOcclussion == 0) || (selectedOcclussion == 1)) {
			// it should go to Severe tourosity
			super.setSkipCurrentProcessor(6);
			// if selected segment is 3 and 4 then
		} else if ((selectedOcclussion == 2) || (selectedOcclussion == 3)) {
			// it should be go to trifurcation
			// No action
		}
		storeTotalOcclutionValue(tempSyntaxScore);
		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
		syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
	}

	public void storeTotalOcclutionValue(float tempSyntaxScore) {
		syntaxScoreRequest.setLesionSyntaxSubscoreTotalOcclusionObservation(tempSyntaxScore);
	}

	/** 
	 * This function is used to check Main Artery Segment for Side branch left dominance
	 *                           : 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user data model- SyntaxScoreCodeableConceptModel
	 *                                        
	 * @return boolean : to find main artery from list
	 */
	private boolean IsMainArterySegmentSelectedForLeft(
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
	 * This function is used to calculate Syntax score Right dominance for Side branch
	 * 
	 * @inheritDoc : override super class SyntaxScoreProcessor.
	 * @param float                           : to generate score in float value
	 * @param treeMap<String,float>           : get and set string and float value for syntax score in treeMap
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user data model- SyntaxScoreCodeableConceptModel
	 *                                        
	 * @return void
	 */
	@Override
	public void calculateSyntaxScoreRightDominance() {

		tempSyntaxScore = syntaxScoreRequest.getSyntaxScore();
		totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();
		selectedOcclussion = syntaxScoreCodeableConceptCodeValue.getSideBranchInvolved();
		if (selectedOcclussion == 1) {
			tempSyntaxScore += SideBranchConstantRight.L_YES_ALLSIDEBRANCH_LT_THAN_1_POINT_5_MM;
			totalSyntaxScore.put("Yes, all sidebranches Lt 1.5mm ",
					SideBranchConstantRight.L_YES_ALLSIDEBRANCH_LT_THAN_1_POINT_5_MM);
		} else if (selectedOcclussion == 2) {
			tempSyntaxScore += SideBranchConstantRight.YES_ALLSIDEBRANCHES_GTOREQUALS_1_PT_5_MM;
			totalSyntaxScore.put("Yes, all sidebranches Gt Or Equal 1.5mm ",
					SideBranchConstantRight.YES_ALLSIDEBRANCHES_GTOREQUALS_1_PT_5_MM);
		} else if (selectedOcclussion == 3) {
			tempSyntaxScore += SideBranchConstantRight.YES_ALLSIDEBRANCH_LT_THAN_1_PT_5_MMAND_GTOREQUAL_1_PT_5_MM;
			totalSyntaxScore.put("Yes, both sidebranches Lt 1.5 mm And GtOrEqual 1.5mm are involved ",
					SideBranchConstantRight.YES_ALLSIDEBRANCH_LT_THAN_1_PT_5_MMAND_GTOREQUAL_1_PT_5_MM);
		}
		// if selectedSegment contain main artery ..
		if ((selectedOcclussion == 0) || (selectedOcclussion == 1)
				&& IsMainArterySegmentSelectedForRight(syntaxScoreCodeableConceptCodeValue)) {

			// is should be go for Aoroto astial
			super.setSkipCurrentProcessor(5);

			// if selected Segment doesn't contain main artery and select 1 &2
		} else if ((selectedOcclussion == 0) || (selectedOcclussion == 1)) {
			// it should go to Severe tourosity
			super.setSkipCurrentProcessor(6);
			// if selected segment is 3 and 4 then
		} else if ((selectedOcclussion == 2) || (selectedOcclussion == 3)) {
			// it should be go to trifurcation
			// No action
		}

		storeTotalOcclutionValue(tempSyntaxScore);
		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
		syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
	}
	/** 
	 * This function is used to check Main Artery Segment for Side branch Right dominance
	 *                           : 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user data model- SyntaxScoreCodeableConceptModel
	 *                                        
	 * @return boolean : to find main artery from list
	 */
	private boolean IsMainArterySegmentSelectedForRight(
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
				|| (selectedSegmentkeyList.contains("3")) || (selectedSegmentkeyList.contains("5"))
				|| (selectedSegmentkeyList.contains("6")) || (selectedSegmentkeyList.contains("7"))
				|| (selectedSegmentkeyList.contains("11")) || (selectedSegmentkeyList.contains("13"))) {
			isMainArtery = true;
		}
		return isMainArtery;
	}

	/**
	 * This function is used to process based on condition applied successfully to
	 * calculate Syntax score Left Dominance and Right Dominance for Side branch 
	 * 
	 * @inheritDoc     : override super class SyntaxScoreProcessor.
	 * @param SyntaxScoreCodeableConceptModel : to parse the data from XML and map the data model
	 *   
	 * @return skip current processor and it will go to next processor by using super abstract class - SyntaxScoreProcessor                                       
	 * @return void    : process of calculate function
	 */
	@Override
	public void process() {
		if (isCurrentProcessorSkipped()) {
			super.process();
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