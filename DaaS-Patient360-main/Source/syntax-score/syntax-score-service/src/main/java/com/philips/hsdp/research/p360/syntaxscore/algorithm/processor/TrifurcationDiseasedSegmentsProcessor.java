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
import com.philips.hsdp.research.p360.syntaxscore.constant.TrifurcationConstantLeft;
import com.philips.hsdp.research.p360.syntaxscore.constant.TrifurcationConstantRight;

/* @author Sunil Kumar */
@Service
public class TrifurcationDiseasedSegmentsProcessor extends SyntaxScoreProcessor {
	private static final Logger LOG = Logger.getLogger(TrifurcationDiseasedSegmentsProcessor.class.getName());
	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	float tempSyntaxScore;
	TreeMap<String, Float> totalSyntaxScore;

	/**
	 * This function is used to calculate Syntax score left dominance for
	 * Trifurcation Diseased Segments
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
		if (syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()) {
			switch (syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()) {
			case 0:
				tempSyntaxScore += TrifurcationConstantLeft.L_DISEASED_SEGMENT1;
				totalSyntaxScore.put("Trifurcation 1 diseased segment(s) involved ",
						TrifurcationConstantLeft.L_DISEASED_SEGMENT1);
				break;
			case 1:
				tempSyntaxScore += TrifurcationConstantLeft.L_DISEASED_SEGMENT2;
				totalSyntaxScore.put("Trifurcation 2 diseased segment(s) involved ",
						TrifurcationConstantLeft.L_DISEASED_SEGMENT2);
				break;
			case 2:
				tempSyntaxScore += TrifurcationConstantLeft.L_DISEASED_SEGMENT3;
				totalSyntaxScore.put("Trifurcation 3 diseased segment(s) involved ",
						TrifurcationConstantLeft.L_DISEASED_SEGMENT3);
				break;
			case 3:
				tempSyntaxScore += TrifurcationConstantLeft.L_DISEASED_SEGMENT4;
				totalSyntaxScore.put("Trifurcation 4 diseased segment(s) involved ",
						TrifurcationConstantLeft.L_DISEASED_SEGMENT4);
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
	 * This function is used to calculate Syntax score left dominance for
	 * Trifurcation Diseased Segments
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
		if (syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()) {
			switch (syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()) {
			case 0:
				tempSyntaxScore += TrifurcationConstantRight.R_DISEASED_SEGMENT1;
				totalSyntaxScore.put("Trifurcation 1 diseased segment(s) involved ",
						TrifurcationConstantRight.R_DISEASED_SEGMENT1);
				break;
			case 1:
				tempSyntaxScore += TrifurcationConstantRight.R_DISEASED_SEGMENT2;
				totalSyntaxScore.put("Trifurcation 2 diseased segment(s) involved ",
						TrifurcationConstantRight.R_DISEASED_SEGMENT2);
				break;
			case 2:
				tempSyntaxScore += TrifurcationConstantRight.R_DISEASED_SEGMENT3;
				totalSyntaxScore.put("Trifurcation 3 diseased segment(s) involved ",
						TrifurcationConstantRight.R_DISEASED_SEGMENT3);
				break;
			case 3:
				tempSyntaxScore += TrifurcationConstantRight.R_DISEASED_SEGMENT4;
				totalSyntaxScore.put("Trifurcation 4 diseased segment(s) involved ",
						TrifurcationConstantRight.R_DISEASED_SEGMENT4);
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
	 * calculate Syntax score Left Dominance and Right Dominance for Trifurcation
	 * Diseased Segments
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
		if (syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()) {
			if (syntaxScoreCodeableConceptCodeValue.isSelectedDominance()) {
				calculateSyntaxScoreLeftDominance();
				super.setSkipCurrentProcessor(3);
			} else {
				calculateSyntaxScoreRightDominance();
				super.setSkipCurrentProcessor(4);
			}
		}
		super.process();
	}
}