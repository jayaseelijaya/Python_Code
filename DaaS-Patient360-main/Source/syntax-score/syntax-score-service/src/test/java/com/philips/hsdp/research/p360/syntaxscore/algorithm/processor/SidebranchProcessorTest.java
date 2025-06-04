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
class SidebranchProcessorTest {

	@InjectMocks
	SidebranchProcessor sidebranchProcessor;

	@Mock
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void calculateSyntaxScoreLeftDominanceTest() {
		when(syntaxScoreCodeableConceptCodeValue.getSideBranchInvolved()).thenReturn(1);
		sidebranchProcessor.calculateSyntaxScoreLeftDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getSideBranchInvolved();

		when(syntaxScoreCodeableConceptCodeValue.getSideBranchInvolved()).thenReturn(2);
		sidebranchProcessor.calculateSyntaxScoreLeftDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getSideBranchInvolved();

		when(syntaxScoreCodeableConceptCodeValue.getSideBranchInvolved()).thenReturn(3);
		sidebranchProcessor.calculateSyntaxScoreLeftDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getSideBranchInvolved();
	}

	@Test
	void calculateSyntaxScoreRightDominanceTest() {
		when(syntaxScoreCodeableConceptCodeValue.getSideBranchInvolved()).thenReturn(1);
		sidebranchProcessor.calculateSyntaxScoreRightDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getSideBranchInvolved();

		when(syntaxScoreCodeableConceptCodeValue.getSideBranchInvolved()).thenReturn(2);
		sidebranchProcessor.calculateSyntaxScoreRightDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getSideBranchInvolved();

		when(syntaxScoreCodeableConceptCodeValue.getSideBranchInvolved()).thenReturn(3);
		sidebranchProcessor.calculateSyntaxScoreRightDominance();
		verify(syntaxScoreCodeableConceptCodeValue, atLeastOnce()).getSideBranchInvolved();
	}

	@Test
	void processTest() {
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(true);
		sidebranchProcessor.process();
	}

	@Test
	void processTestFails() {
		when(syntaxScoreCodeableConceptCodeValue.isSelectedDominance()).thenReturn(false);
		sidebranchProcessor.process();
	}
}