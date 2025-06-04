/*
 * (C) Koninklijke Philips Electronics N.V. 2022
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.processor;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;

/* @author Anuradha Pyla */
@RunWith(MockitoJUnitRunner.class)
class TotalOccluAgeProcessorTest {

	@InjectMocks
	TotalOcclusionAgeProcessor totalOcclusionAgeProcessor;

	@Mock
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest() {
		when(syntaxScoreCodeableConceptCodeValue.getAgeOfTotalOcclusion()).thenReturn(0);
		totalOcclusionAgeProcessor.calculateSyntaxScoreLeftDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getAgeOfTotalOcclusion();

		when(syntaxScoreCodeableConceptCodeValue.getAgeOfTotalOcclusion()).thenReturn(1);
		totalOcclusionAgeProcessor.calculateSyntaxScoreLeftDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getAgeOfTotalOcclusion();

		when(syntaxScoreCodeableConceptCodeValue.getAgeOfTotalOcclusion()).thenReturn(2);
		totalOcclusionAgeProcessor.calculateSyntaxScoreLeftDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getAgeOfTotalOcclusion();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest() {
		when(syntaxScoreCodeableConceptCodeValue.getAgeOfTotalOcclusion()).thenReturn(0);
		totalOcclusionAgeProcessor.calculateSyntaxScoreRightDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getAgeOfTotalOcclusion();

		when(syntaxScoreCodeableConceptCodeValue.getAgeOfTotalOcclusion()).thenReturn(1);
		totalOcclusionAgeProcessor.calculateSyntaxScoreRightDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getAgeOfTotalOcclusion();

		when(syntaxScoreCodeableConceptCodeValue.getAgeOfTotalOcclusion()).thenReturn(2);
		totalOcclusionAgeProcessor.calculateSyntaxScoreRightDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getAgeOfTotalOcclusion();
	}

	@Test
	void processTest() {
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(true);
		totalOcclusionAgeProcessor.process();
	}

	@Test
	void processTestFails() {
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(false);
		when(syntaxScoreCodeableConceptCodeValue.getAgeOfTotalOcclusion()).thenReturn(1);
		totalOcclusionAgeProcessor.process();
	}
}