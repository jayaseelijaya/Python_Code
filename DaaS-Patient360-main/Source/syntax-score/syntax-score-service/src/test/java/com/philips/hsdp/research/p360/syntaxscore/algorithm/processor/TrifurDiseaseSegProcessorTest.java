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
class TrifurDiseaseSegProcessorTest {
	@InjectMocks
	TrifurcationDiseasedSegmentsProcessor trifurcationDiseasedSegmentsProcessor;
	@Mock
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest1() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(0);
		trifurcationDiseasedSegmentsProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest2() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(1);
		trifurcationDiseasedSegmentsProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest3() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(2);
		trifurcationDiseasedSegmentsProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest4() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(3);
		trifurcationDiseasedSegmentsProcessor.calculateSyntaxScoreLeftDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest1() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(0);
		trifurcationDiseasedSegmentsProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest2() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(1);
		trifurcationDiseasedSegmentsProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest3() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(2);
		trifurcationDiseasedSegmentsProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest4() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(3);
		trifurcationDiseasedSegmentsProcessor.calculateSyntaxScoreRightDominance();
	}

	@Test
	void processTestPositive() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(true);
		trifurcationDiseasedSegmentsProcessor.process();
	}

	@Test
	void processTestNegative1() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(false);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(1);
		trifurcationDiseasedSegmentsProcessor.process();
	}

	@Test
	void processTestNegative2() {
		when(syntaxScoreCodeableConceptCodeValue.isTrifurcationValue()).thenReturn(true);
		when(syntaxScoreCodeableConceptCodeValue.getDiseasedsegment()).thenReturn(1);
		trifurcationDiseasedSegmentsProcessor.process();
	}
}