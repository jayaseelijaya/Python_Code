/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.processor;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;

/* @author Srinivasa Reddy Bijjam */
@RunWith(MockitoJUnitRunner.class)
class BifurcationProcessorTest {
	@InjectMocks
	BifurcationProcessor bifurcationProcessor;

	@Mock
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void calculateSyntaxScoreLeftDominance() {
		bifurcationProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominance() {
		bifurcationProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void processTest1() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(true);
		bifurcationProcessor.process();
	}

	@Test
	void processTest2() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(false);
		bifurcationProcessor.process();
	}

	@Test
	void processTest3() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(false);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(false);
		bifurcationProcessor.process();
	}
}