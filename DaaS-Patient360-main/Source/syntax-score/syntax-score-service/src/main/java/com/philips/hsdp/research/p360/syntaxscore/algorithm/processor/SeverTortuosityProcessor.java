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
import com.philips.hsdp.research.p360.syntaxscore.constant.SeverTortuosityConstantLeft;
import com.philips.hsdp.research.p360.syntaxscore.constant.SeverTortuosityConstantRight;

/* @author Sunil Kumar */
@Service
public class SeverTortuosityProcessor extends SyntaxScoreProcessor {
	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	float tempSyntaxScore;
	TreeMap<String, Float> totalSyntaxScore;

	/** 
	 * This function is used to calculate Syntax score left dominance for Severe Tortuosity
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
		if (syntaxScoreCodeableConceptCodeValue.isSeverTortuosityValue()) {
			tempSyntaxScore += SeverTortuosityConstantLeft.L_SEVERTORTUOSITY_VALUE_YES;
			totalSyntaxScore.put("Severe Tortuosity ", SeverTortuosityConstantLeft.L_SEVERTORTUOSITY_VALUE_YES);
		} else if (!(syntaxScoreCodeableConceptCodeValue.isSeverTortuosityValue())) {
			tempSyntaxScore += SeverTortuosityConstantLeft.L_SEVERTORTUOSITY_VALUE_NO;
		}
		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
		syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
	}

	/** 
	 * This function is used to calculate Syntax score Right dominance for Severe Tortuosity
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
		if (syntaxScoreCodeableConceptCodeValue.isSeverTortuosityValue()) {
			tempSyntaxScore += SeverTortuosityConstantRight.R_SEVERTORTUOSITY_VALUE_YES;
			totalSyntaxScore.put("Severe Tortuosity ", SeverTortuosityConstantRight.R_SEVERTORTUOSITY_VALUE_YES);
		} else if (!(syntaxScoreCodeableConceptCodeValue.isSeverTortuosityValue())) {
			tempSyntaxScore += SeverTortuosityConstantRight.R_SEVERTORTUOSITY_VALUE_NO;
		}
		syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
		syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
	}

	/**
	 * This function is used to process based on condition applied successfully to
	 * calculate Syntax score Left Dominance and Right Dominance for Severe Tortuosity 
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
		if (syntaxScoreCodeableConceptCodeValue.isSeverTortuosityValue()) {
			if (syntaxScoreCodeableConceptCodeValue.isSelectedDominance()) {
				calculateSyntaxScoreLeftDominance();
			} else {
				calculateSyntaxScoreRightDominance();
			}
		}
		super.process();
	}
}