/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.processor;

import java.util.TreeMap;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;
import com.philips.hsdp.research.p360.syntaxscore.constant.LengthGT20mmConstantLeft;
import com.philips.hsdp.research.p360.syntaxscore.constant.LengthGT20mmConstantRight;

/* @author Sunil Kumar */
@Service
public class LengthGT20mmProcessor extends SyntaxScoreProcessor {
	float tempSyntaxScore;
	TreeMap<String, Float> totalSyntaxScore;
	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();

	/** 
	 * This function is used to calculate Syntax score left dominance for LengthGT20mm
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
		if (syntaxScoreCodeableConceptCodeValue.isLengthGT20mmValue()) {
			tempSyntaxScore += LengthGT20mmConstantLeft.L_LENGTH_GT20MM_VALUE_YES;
			totalSyntaxScore.put("LengthGT20mm ", LengthGT20mmConstantLeft.L_LENGTH_GT20MM_VALUE_YES);
		} else if (!(syntaxScoreCodeableConceptCodeValue.isLengthGT20mmValue())) {
			tempSyntaxScore += LengthGT20mmConstantLeft.L_LENGTH_GT20MM_VALUE_NO;
		}
		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
		syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
	}

	/** 
	 * This function is used to calculate Syntax score left dominance for LengthGT20mm
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
		if (syntaxScoreCodeableConceptCodeValue.isLengthGT20mmValue()) {
			tempSyntaxScore += LengthGT20mmConstantRight.R_LENGTH_GT20MM_VALUE_YES;
			totalSyntaxScore.put("LengthGT20mm ", LengthGT20mmConstantRight.R_LENGTH_GT20MM_VALUE_YES);
		} else if (!(syntaxScoreCodeableConceptCodeValue.isLengthGT20mmValue())) {
			tempSyntaxScore += LengthGT20mmConstantRight.R_LENGTH_GT20MM_VALUE_NO;
		}
		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
		syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
	}

	/**
	 * This function is used to process based on condition applied successfully to
	 * calculate Syntax score Left Dominance and Right Dominance for LengthGT20mm 
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
		if (syntaxScoreCodeableConceptCodeValue.isLengthGT20mmValue() == true) {
			if (syntaxScoreCodeableConceptCodeValue.isSelectedDominance()) {
				calculateSyntaxScoreLeftDominance();
			} else {
				calculateSyntaxScoreRightDominance();
			}
		}
		super.process();
	}
}