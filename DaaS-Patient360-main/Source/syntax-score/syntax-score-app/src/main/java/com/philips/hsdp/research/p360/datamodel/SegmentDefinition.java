/*
*  Copyright(C) Koninklijke Philips Electronics N.V. 2022
*
*  All rights are reserved. Reproduction or transmission in whole or in part, in
*  any form or by any means, electronic, mechanical or otherwise, is prohibited
*  without the prior written permission of the copyright owner.
*/

package com.philips.hsdp.research.p360.datamodel;

import com.philips.hsdp.research.p360.datamodel.enums.Dominance;

import java.util.ArrayList;
import java.util.List;

/** @author Raj Kumar */
public class SegmentDefinition {
	private static final String POSTEROLATERAL_FROM_RCA = "Posterolateral from RCA";

	Dominance selectedDominance;

	List<Segment> segments;

	Segment rcaProximal1 = new Segment("1", "RCA proximal",
			"From ostium to one half the distance to the acute margin of the heart.");

	Segment rcaMid2 = new Segment("2", "RCA mid", "From end of first segment to acute margin of heart.");

	Segment rcaDistal3 = new Segment("3", "RCA distal",
			"From the acute margin of the heart to the origin of the posterior descending artery.");

	Segment posteriorDescending4 = new Segment("4", "Posterior descending",
			"Running in the posterioe interventricular groove.");

	Segment leftMain5 = new Segment("5", "Left main",
			"From the ostium of the LCA through bifurcation into left anterior descending and left circumflex branches.");

	Segment ladProximal6 = new Segment("6", "LAD proximal", "Proximal to and including first major septal branch.");

	Segment ladMid7 = new Segment("7", "LAD mid",
			"LAD immediately distal to origin of first septal branch and extending to the point where LAD"
					+ "forms and angle (RAO view). If this angle is not identifiable this segment ends at one half the"
					+ "distance from the first septal to the apex of the heart.");

	Segment ladApical8 = new Segment("8", "LAD apical",
			"Terminal portion of LAD, beginning at the end of previous segment and extending to or beyond the apex.");

	Segment firstDiagonal9 = new Segment("9", "First diagonal", "The first diagonal originating from segment 6 or 7.");

	Segment additionalFirstDiagnal9a = new Segment("9a", "First diagonal a.",
			"Additional first diagonal originating from segment 6 or 7, before segment 8.");

	Segment secondDiagonal10 = new Segment("10", "Second diagonal",
			"Second diagonal originating from segment 8 or the transition between segment 7 and 8.");

	Segment additionalSecondDiagonal10a = new Segment("10a", "Second diagonal a",
			"Additional second diagonal originating from segment 8.");

	Segment proximalCircumflex11 = new Segment("11", "Proximal circumflex",
			"Main stem of circumflex from its origin of left main to and including origin of first obtuse marginal branch.");

	Segment intermediateAnterolateral12 = new Segment("12", "Intermediate/anterolateral",
			"Branch from trifurcating left main other than proximal LAD or LCX. Belongs to the circumflex territory.");

	Segment obtuseMarginal12a = new Segment("12a", "Obtuse marginal a",
			"First side branch of circumflex running in general to the area of obtuse margin of the heart");

	Segment obtuseMarginal12b = new Segment("12b", "Obtuse marginal b",
			"Second additional branch of circumflex running in the same direction as 12.");

	Segment distalCircumflex13 = new Segment("13", "Distal circumflex",
			"The stem of the circumflex distal to the origin of the most distal obtuse marginal branch and running along the posterior left atrioventricular grooves. Caliber may be small or artery absent.");

	Segment leftPosterolateral14 = new Segment("14", "Left posterolateral",
			"Running to the posterolateral surface of the left ventricle. May be absent or a division of obtuse marginal branch.");

	Segment leftPosterolateral14a = new Segment("14a", "Left posterolateral a",
			"Distal from 14 and running in the same direction.");

	Segment leftPosterolateral14b = new Segment("14b", "Left posterolateral b",
			"Distal from 14 and 14 a and running in the same direction.");

	Segment posteroDescending15 = new Segment("15", "Posterior descending",
			"Most distal part of dominant left circumflex when present. Gives origin to septal branches. When this artery is present, segment 4 is usually absent.");

	Segment posterolateralFromRCA16 = new Segment("16", POSTEROLATERAL_FROM_RCA,
			"Posterolateral branch originating from the distal coronary artery distal to the crux.");

	Segment posterolateralFromRCA16a = new Segment("16a", POSTEROLATERAL_FROM_RCA,
			"First posterolateral branch from segment 16");

	Segment posterolateralFromRCA16b = new Segment("16b", POSTEROLATERAL_FROM_RCA,
			"Second posterolateral branch from segment 16.");

	Segment posterolateralFromRCA16c = new Segment("16c", POSTEROLATERAL_FROM_RCA,
			"Third posterolateral branch from segment 16.");

	// Load segment into list per dominance selection
	public SegmentDefinition(Dominance selectedDominance) {
		this.selectedDominance = selectedDominance;
		segments = new ArrayList<>();
		loadSegmentDefinitionList();
	}

	// Adding segments into list
	private void loadSegmentDefinitionList() {
		if (selectedDominance == Dominance.RIGHT) {
			segments.add(rcaProximal1);
			segments.add(rcaMid2);
			segments.add(rcaDistal3);
			segments.add(posteriorDescending4);
			segments.add(leftMain5);
			segments.add(ladProximal6);
			segments.add(ladMid7);
			segments.add(ladApical8);
			segments.add(firstDiagonal9);
			segments.add(additionalFirstDiagnal9a);
			segments.add(secondDiagonal10);
			segments.add(additionalSecondDiagonal10a);
			segments.add(proximalCircumflex11);
			segments.add(intermediateAnterolateral12);
			segments.add(obtuseMarginal12a);
			segments.add(obtuseMarginal12b);
			segments.add(distalCircumflex13);
			segments.add(leftPosterolateral14);
			segments.add(leftPosterolateral14a);
			segments.add(leftPosterolateral14b);
			segments.add(posterolateralFromRCA16);
			segments.add(posterolateralFromRCA16a);
			segments.add(posterolateralFromRCA16b);
			segments.add(posterolateralFromRCA16c);
		} else {
			segments.add(rcaProximal1);
			segments.add(rcaMid2);
			segments.add(rcaDistal3);
			segments.add(leftMain5);
			segments.add(ladProximal6);
			segments.add(ladMid7);
			segments.add(ladApical8);
			segments.add(firstDiagonal9);
			segments.add(additionalFirstDiagnal9a);
			segments.add(secondDiagonal10);
			segments.add(additionalSecondDiagonal10a);
			segments.add(proximalCircumflex11);
			segments.add(intermediateAnterolateral12);
			segments.add(obtuseMarginal12a);
			segments.add(obtuseMarginal12b);
			segments.add(distalCircumflex13);
			segments.add(leftPosterolateral14);
			segments.add(leftPosterolateral14a);
			segments.add(leftPosterolateral14b);
			segments.add(posteroDescending15);
		}
	}

	/**
	 * Get the actual segment Definition list
	 * 
	 * @return segment Definition list
	 */
	public List<Segment> getSegmentDefinition() {
		return segments;
	}

	/**
	 * Finding the Segment using segment number
	 * 
	 * @param selectedDominance
	 * @param segmentNumber
	 * @return segment which is matching the segment number passed
	 */
	public Segment getSegmentBySegmentNumber(Dominance selectedDominance, String segmentNumber) {
		Segment segment = null;
		SegmentDefinition segmentDefinition = new SegmentDefinition(selectedDominance);
		List<Segment> segmentDefList = segmentDefinition.getSegmentDefinition();
		for (Segment segmentMatched : segmentDefList) {
			if (segmentMatched.getNumber().equalsIgnoreCase(segmentNumber)) {
				segment = segmentMatched;
			}
		}
		return segment;
	}
}