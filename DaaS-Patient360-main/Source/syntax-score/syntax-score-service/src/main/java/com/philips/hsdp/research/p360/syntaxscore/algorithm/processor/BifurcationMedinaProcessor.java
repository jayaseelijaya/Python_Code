/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.processor;

import java.util.TreeMap;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;
import com.philips.hsdp.research.p360.syntaxscore.constant.BifurcationConstantLeft;
import com.philips.hsdp.research.p360.syntaxscore.constant.BifurcationConstantRight;

/* @Author Sunil Kumar*/
@Service
public class BifurcationMedinaProcessor extends SyntaxScoreProcessor {
	private static final Logger LOG = Logger.getLogger(BifurcationMedinaProcessor.class.getName());
	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	float tempSyntaxScore;
	TreeMap<String, Float> totalSyntaxScore;

	/**
	 * This function is used to calculate Syntax score left dominance for
	 * Bifurcation Medina
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
		if (syntaxScoreCodeableConceptCodeValue.isBifurcationValue()) {
			switch (syntaxScoreCodeableConceptCodeValue.getMedina()) {
			case 0:
				tempSyntaxScore += BifurcationConstantLeft.L_MEDINA1;
				totalSyntaxScore.put("Bifurcation Type: Medina 1,0,0: ", BifurcationConstantLeft.L_MEDINA1);
				break;
			case 1:
				tempSyntaxScore += BifurcationConstantLeft.L_MEDINA2;
				totalSyntaxScore.put("Bifurcation Type: Medina 0,1,0: ", BifurcationConstantLeft.L_MEDINA2);
				break;
			case 2:
				tempSyntaxScore += BifurcationConstantLeft.L_MEDINA3;
				totalSyntaxScore.put("Bifurcation Type: Medina 1,1,0: ", BifurcationConstantLeft.L_MEDINA3);
				break;
			case 3:
				tempSyntaxScore += BifurcationConstantLeft.L_MEDINA4;
				totalSyntaxScore.put("Bifurcation Type: Medina 1,1,1: ", BifurcationConstantLeft.L_MEDINA4);
				break;
			case 4:
				tempSyntaxScore += BifurcationConstantLeft.L_MEDINA5;
				totalSyntaxScore.put("Bifurcation Type: Medina 0,0,1: ", BifurcationConstantLeft.L_MEDINA5);
				break;
			case 5:
				tempSyntaxScore += BifurcationConstantLeft.L_MEDINA6;
				totalSyntaxScore.put("Bifurcation Type: Medina 1,0,1: ", BifurcationConstantLeft.L_MEDINA6);
				break;
			case 6:
				tempSyntaxScore += BifurcationConstantLeft.L_MEDINA7;
				totalSyntaxScore.put("Bifurcation Type: Medina 0,1,1: ", BifurcationConstantLeft.L_MEDINA7);
				break;
			default:
				LOG.info("InValid ");
				break;
			}
			syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
			syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
		}
	}

	/**
	 * This function is used to calculate Syntax score Right dominance for
	 * Bifurcation Medina
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
		if (syntaxScoreCodeableConceptCodeValue.isBifurcationValue()) {
			switch (syntaxScoreCodeableConceptCodeValue.getMedina()) {
			case 0:
				tempSyntaxScore += BifurcationConstantRight.R_MEDINA1;
				totalSyntaxScore.put("Bifurcation Type: Medina 1,0,0: ", BifurcationConstantRight.R_MEDINA1);
				break;
			case 1:
				tempSyntaxScore += BifurcationConstantRight.R_MEDINA2;
				totalSyntaxScore.put("Bifurcation Type: Medina 0,1,0: ", BifurcationConstantRight.R_MEDINA2);
				break;
			case 2:
				tempSyntaxScore += BifurcationConstantRight.R_MEDINA3;
				totalSyntaxScore.put("Bifurcation Type: Medina 1,1,0: ", BifurcationConstantRight.R_MEDINA3);
				break;
			case 3:
				tempSyntaxScore += BifurcationConstantRight.R_MEDINA4;
				totalSyntaxScore.put("Bifurcation Type: Medina 1,1,1: ", BifurcationConstantRight.R_MEDINA4);
				break;
			case 4:
				tempSyntaxScore += BifurcationConstantRight.R_MEDINA5;
				totalSyntaxScore.put("Bifurcation Type: Medina 0,0,1: ", BifurcationConstantRight.R_MEDINA5);
				break;
			case 5:
				tempSyntaxScore += BifurcationConstantRight.R_MEDINA6;
				totalSyntaxScore.put("Bifurcation Type: Medina 1,0,1: ", BifurcationConstantRight.R_MEDINA6);
				break;
			case 6:
				tempSyntaxScore += BifurcationConstantRight.R_MEDINA7;
				totalSyntaxScore.put("Bifurcation Type: Medina 0,1,1: ", BifurcationConstantRight.R_MEDINA7);
				break;
			default:
				LOG.info("InValid ");
				break;
			}
			syntaxScoreRequest.setSyntaxScore(tempSyntaxScore);
			syntaxScoreRequest.setTotalSyntaxScore(totalSyntaxScore);
		}
	}

	/**
	 * This function is used to process based on condition applied successfully to
	 * calculate Syntax score Left Dominance and Right Dominance for Bifurcation
	 * Medina
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
		if (syntaxScoreCodeableConceptCodeValue.isBifurcationValue()) {
			if (syntaxScoreCodeableConceptCodeValue.isSelectedDominance()) {
				calculateSyntaxScoreLeftDominance();
			} else {
				calculateSyntaxScoreRightDominance();
			}
		}
		super.process();
	}
}