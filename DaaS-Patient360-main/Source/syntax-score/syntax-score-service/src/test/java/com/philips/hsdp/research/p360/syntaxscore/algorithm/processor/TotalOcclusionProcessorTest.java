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
class TotalOcclusionProcessorTest {
	@InjectMocks
	TotalOcclusionProcessor totalOcclusionProcessor;

	@Mock
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest() {
		when(syntaxScoreCodeableConceptCodeValue.isTotalOcclusion()).thenReturn(true);
		totalOcclusionProcessor.calculateSyntaxScoreLeftDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).isTotalOcclusion();

		when(syntaxScoreCodeableConceptCodeValue.isTotalOcclusion()).thenReturn(false);
		totalOcclusionProcessor.calculateSyntaxScoreLeftDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).isTotalOcclusion();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest() {
		when(syntaxScoreCodeableConceptCodeValue.isTotalOcclusion()).thenReturn(true);
		totalOcclusionProcessor.calculateSyntaxScoreRightDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).isTotalOcclusion();

		when(syntaxScoreCodeableConceptCodeValue.isTotalOcclusion()).thenReturn(false);
		totalOcclusionProcessor.calculateSyntaxScoreRightDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).isTotalOcclusion();
	}

	@Test
	void processTestPositive() {
		when(syntaxScoreCodeableConceptCodeValue.isTotalOcclusion()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(true);
		totalOcclusionProcessor.process();
	}

	@Test
	void processTestNegative() {
		when(syntaxScoreCodeableConceptCodeValue.isTotalOcclusion()).thenReturn(false);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(false);
		totalOcclusionProcessor.process();
	}
}