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

/* @author Srinivasa Reddy Bijjams */
@RunWith(MockitoJUnitRunner.class)
class BifurcationMedinaProcessorTest {
	@InjectMocks
	BifurcationMedinaProcessor bifurcationMedinaProcessor;
	@Mock
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest1() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(0);
		bifurcationMedinaProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest2() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(1);
		bifurcationMedinaProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest3() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(2);
		bifurcationMedinaProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest4() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(3);
		bifurcationMedinaProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest5() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(4);
		bifurcationMedinaProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest6() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(5);
		bifurcationMedinaProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest7() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(6);
		bifurcationMedinaProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest1() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(0);
		bifurcationMedinaProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest2() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(1);
		bifurcationMedinaProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest3() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(2);
		bifurcationMedinaProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest4() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(3);
		bifurcationMedinaProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest5() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(4);
		bifurcationMedinaProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest6() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(5);
		bifurcationMedinaProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest7() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getMedina()).thenReturn(6);
		bifurcationMedinaProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void processTestPositive() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(true);
		bifurcationMedinaProcessor.process();
	}

	@Test
	void processTestNegative() {
		when(syntaxScoreCodeableConceptCodeValue.isBifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(false);
		bifurcationMedinaProcessor.process();
	}
}