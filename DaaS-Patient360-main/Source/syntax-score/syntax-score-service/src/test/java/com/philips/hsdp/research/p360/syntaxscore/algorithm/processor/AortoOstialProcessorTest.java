/*
 * (C) Koninklijke Philips Electronics N.V. 2022
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.processor;

import static org.mockito.Mockito.when;
import java.util.TreeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;

/* @author Srinivasa Reddy Bijjam  */
@RunWith(MockitoJUnitRunner.class)
class AortoOstialProcessorTest {

	@InjectMocks
	AortoOstialProcessor aortoOstialProcessor;

	@Mock
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue;

	@Mock
	SyntaxScore syntaxScoreRequest;

	@Mock
	TreeMap<String, Float> totalSyntaxScore;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest() {
		float tempSyntaxScore = 0.0f;
		when(syntaxScoreRequest.getSyntaxScore()).thenReturn(tempSyntaxScore);
		when(syntaxScoreRequest.getTotalSyntaxScore()).thenReturn(totalSyntaxScore);
		when(syntaxScoreCodeableConceptCodeValue.isAortoOstialValue()).thenReturn(true);
		aortoOstialProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest1() {
		float tempSyntaxScore = 0.0f;
		when(syntaxScoreRequest.getSyntaxScore()).thenReturn(tempSyntaxScore);
		when(syntaxScoreRequest.getTotalSyntaxScore()).thenReturn(totalSyntaxScore);
		when(syntaxScoreCodeableConceptCodeValue.isAortoOstialValue()).thenReturn(false);
		aortoOstialProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest1() {
		float tempSyntaxScore = 0.0f;
		when(syntaxScoreRequest.getSyntaxScore()).thenReturn(tempSyntaxScore);
		when(syntaxScoreRequest.getTotalSyntaxScore()).thenReturn(totalSyntaxScore);
		when(syntaxScoreCodeableConceptCodeValue.isAortoOstialValue()).thenReturn(true);
		aortoOstialProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest2() {
		float tempSyntaxScore = 0.0f;
		when(syntaxScoreRequest.getSyntaxScore()).thenReturn(tempSyntaxScore);
		when(syntaxScoreRequest.getTotalSyntaxScore()).thenReturn(totalSyntaxScore);
		when(syntaxScoreCodeableConceptCodeValue.isAortoOstialValue()).thenReturn(false);
		aortoOstialProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void processTestPositive() {
		when(syntaxScoreCodeableConceptCodeValue.isAortoOstialValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(true);
		aortoOstialProcessor.process();
	}

	@Test
	void processTestNegative() {
		when(syntaxScoreCodeableConceptCodeValue.isAortoOstialValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(false);
		aortoOstialProcessor.process();
	}
}