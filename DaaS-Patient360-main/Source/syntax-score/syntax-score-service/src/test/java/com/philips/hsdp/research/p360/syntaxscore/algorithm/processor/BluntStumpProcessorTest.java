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
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;

/* @author Srinivasa Reddy Bijjam */
@RunWith(MockitoJUnitRunner.class)
class BluntStumpProcessorTest {
	@InjectMocks
	BluntStumpProcessor bluntStumpProcessor;

	@Mock
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue;

	@Mock
	SyntaxScore syntaxScoreRequest;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void calculateSyntaxScoreLeftDominance() {
		bluntStumpProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominance() {
		bluntStumpProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void processTestPositive() {
		when(syntaxScoreCodeableConceptCodeValue.isBluntStump()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(true);
		bluntStumpProcessor.process();
	}

	@Test
	void processNegative1() {
		when(syntaxScoreCodeableConceptCodeValue.isBluntStump()).thenReturn(false);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(1);
		bluntStumpProcessor.process();
	}

	@Test
	void processNegative2() {
		when(syntaxScoreCodeableConceptCodeValue.isBluntStump()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(1);
		bluntStumpProcessor.process();
	}
}