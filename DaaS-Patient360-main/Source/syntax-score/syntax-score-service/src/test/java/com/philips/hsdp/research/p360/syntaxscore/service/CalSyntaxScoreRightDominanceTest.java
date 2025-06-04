/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.CalculateSyntaxScoreRightDominance;

/*@author Srinivasa Reddy Bijjam  */
@RunWith(MockitoJUnitRunner.class)
 class CalSyntaxScoreRightDominanceTest {
	@InjectMocks
	CalculateSyntaxScoreRightDominance rightDominance;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	 void getChainOfSyntaxScoreProcessor() {
		rightDominance.getChainOfSyntaxScoreProcessor();
	}
}