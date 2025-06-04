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

/* @author Srinivasa Reddy Bijjam */
@RunWith(MockitoJUnitRunner.class)
class FirstSegVisualizedProcessorTest {

	@InjectMocks
	FirstSegmentVisualizedProcessor firstSegmentVisualizedProcessor;

	@Mock
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest() {
		when(syntaxScoreCodeableConceptCodeValue.getFirstSegmentTOVisualised()).thenReturn(null);
		firstSegmentVisualizedProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest() {
		when(syntaxScoreCodeableConceptCodeValue.getFirstSegmentTOVisualised()).thenReturn(null);
		firstSegmentVisualizedProcessor.calculateSyntaxScoreRightDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getSegment();
	}

	@Test
	void processTestPositive() {
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(true);
		firstSegmentVisualizedProcessor.process();
	}

	@Test
	void processTestNegative() {
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(false);
		firstSegmentVisualizedProcessor.process();
	}
}