/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl;

import org.springframework.stereotype.Component;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.SyntaxScoreProcessor;

/* @author Sunil Kumar */
@Component
public class SyntaxScoreCalculator {

	/**
	 * This function is used to initiate the chain and to call the process method
	 * for left and right dominance.
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user
	 *                                        data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return void
	 */
	public void initSyntaxScoreCalculator() {
		SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel
				.getInstance();
		CalculateSyntaxScoreLeftDominance calculateSyntaxScoreLeftDominance = new CalculateSyntaxScoreLeftDominance();
		CalculateSyntaxScoreRightDominance calculateSyntaxScoreRightDominance = new CalculateSyntaxScoreRightDominance();
		if (syntaxScoreCodeableConceptCodeValue.isSelectedDominance()) {
			SyntaxScoreProcessor syntaxScoreProcessor = calculateSyntaxScoreLeftDominance
					.getChainOfSyntaxScoreProcessor();
			syntaxScoreProcessor.process();
		} else {
			SyntaxScoreProcessor syntaxScoreProcessor = calculateSyntaxScoreRightDominance
					.getChainOfSyntaxScoreProcessor();
			syntaxScoreProcessor.process();
		}
	}
}