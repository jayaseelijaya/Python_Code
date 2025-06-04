/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SegmentMapForLeft;
import com.philips.hsdp.research.p360.syntaxscore.constant.FirstSegmentConstantLeft;

/* @author Priyanka Mallick */
@ExtendWith(MockitoExtension.class)
class SegmentMapForLeftTest {

	@InjectMocks
	SegmentMapForLeft segmentMapForLeft;

	Map<String, Float> segmentWeight;
	Map<String, String> segmentString;
	Map<String, Boolean> selectedSegment = new HashMap<>();

	@Test
	void segmentsMapTest() {
		selectedSegment.put("test", true);
		segmentWeight = new HashMap<>();
		segmentWeight.put("1", FirstSegmentConstantLeft.L_RCA_PROXIMAL_1);
		segmentWeight.put("2", FirstSegmentConstantLeft.L_RCA_MID_2);
		segmentWeight.put("3", FirstSegmentConstantLeft.L_RCA_DISTAL_3);
		segmentWeight.put("5", FirstSegmentConstantLeft.L_LEFT_MAIN_5);
		segmentWeight.put("6", FirstSegmentConstantLeft.L_LAD_PROXIMAL_6);
		segmentWeight.put("7", FirstSegmentConstantLeft.L_LAD_MID_7);
		segmentWeight.put("8", FirstSegmentConstantLeft.L_LAD_APICAL_8);
		segmentWeight.put("9", FirstSegmentConstantLeft.L_FIRST_DIAGONAL_9);
		segmentWeight.put("9a", FirstSegmentConstantLeft.L_ADD_FIRST_DIAGONAL_9A);
		segmentWeight.put("10", FirstSegmentConstantLeft.L_SECOND_DIAGONAL_10);
		segmentWeight.put("10a", FirstSegmentConstantLeft.L_ADD_SECOND_DIAGONAL_10A);
		segmentWeight.put("11", FirstSegmentConstantLeft.L_PROXIMAL_CIRCUMFLEX_11);
		segmentWeight.put("12", FirstSegmentConstantLeft.L_INTERMEDIATE_ANTEROLATERAL_12);
		segmentWeight.put("12a", FirstSegmentConstantLeft.L_OBTUSE_MARGINAL_12A);
		segmentWeight.put("12b", FirstSegmentConstantLeft.L_OBTUSE_MARGINAL_12B);
		segmentWeight.put("13", FirstSegmentConstantLeft.L_DISTAL_CIRCUMFLEX_13);
		segmentWeight.put("14", FirstSegmentConstantLeft.L_LEFT_POSTEROLATERAL_14);
		segmentWeight.put("14a", FirstSegmentConstantLeft.L_LEFT_POSTEROLATERALA_14A);
		segmentWeight.put("14b", FirstSegmentConstantLeft.L_LEFT_POSTEROLATERALB_14B);
		segmentWeight.put("15", FirstSegmentConstantLeft.L_POSTERIOR_DESCENDING_15);
		float segmentWeightValue = segmentMapForLeft.segmentsMap();
		assertNotEquals(-1.0f, segmentWeightValue);
	}

	@Test
	void segmentsStringTest() {
		selectedSegment.put("test", true);
		segmentString = new HashMap<>();
		segmentString.put("1", "(Segment 1): 0x2 ");
		segmentString.put("2", "(Segment 2): 0x2 ");
		segmentString.put("3", "(Segment 3): 0x2 ");
		segmentString.put("5", "(Segment 5): 6x2 ");
		segmentString.put("6", "(Segment 6): 3.5x2 ");
		segmentString.put("7", "(Segment 7): 2.5x2 ");
		segmentString.put("8", "(Segment 8): 1.0x2 ");
		segmentString.put("9", "(Segment 9): 1.0x2 ");
		segmentString.put("9a", "(Segment 9a): 1.0x2 ");
		segmentString.put("10", "(Segment 10): 0.5x2 ");
		segmentString.put("10a", "(Segment 10a): 0.5x2 ");
		segmentString.put("11", "(Segment 11): 2.5x2 ");
		segmentString.put("12", "(Segment 12): 1.0x2 ");
		segmentString.put("12a", "(Segment 12a): 1.0x2 ");
		segmentString.put("12b", "(Segment 12b): 1.0x2 ");
		segmentString.put("13", "(Segment 13): 1.5x2 ");
		segmentString.put("14", "(Segment 14): 1.0x2 ");
		segmentString.put("14a", "(Segment 14a): 1.0x2 ");
		segmentString.put("14b", "(Segment 14b): 1.0x2 ");
		segmentString.put("16", "(Segment 15): 1.0x2 ");
		Map<String, Float> segmentStringValue = segmentMapForLeft.segmentsString();
		assertNotEquals("case", segmentStringValue);
	}

}