/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/* @author Sunil Kumar*/
@Data
public class SyntaxScoreCodeableConceptModel {
	private static SyntaxScoreCodeableConceptModel instanceModel = null;
	private Integer noSegInvolved = 0;
	private Integer segmentsInvolved = 0;
	private Integer lesionNumber = 0;
	private Integer ageOfTotalOcclusion;
	private boolean bluntStump = false;
	private boolean bridgingCollaterals = false;
	private Integer sideBranchInvolved = 0;
	private boolean trifurcationValue = false;
	private boolean aortoOstialValue = false;
	private boolean severTortuosityValue = false;
	private boolean lengthGT20mmValue = false;
	private boolean heavyCalcificationValue = false;
	private boolean thrombusValue = false;
	private boolean diffuseDiseaseValue = false;
	private Integer diffuseDiseaseNoSegment = 0;
	private Integer diseasedsegment = 0;
	private Integer medina = 0;
	private boolean bifurcationAngulation = false;
	private boolean bifurcationValue = false;
	private boolean totalOcclusion = false;
	private boolean selectedDominance = false;
	private boolean mainArterySegmentSelected = false;
	private Map<String, Boolean> firstSegment;
	private Map<String, Boolean> segment;
	private Map<String, Boolean> diffuselyDiseasedNarrowedSeg;
	private Map<String, Boolean> firstSegmentTOVisualised;
	private Map<String, Boolean> segmentsMap;

	public void reset() {
		noSegInvolved = 0;
		segmentsInvolved = 0;
		lesionNumber = 0;
		ageOfTotalOcclusion = 0;
		bluntStump = false;
		bridgingCollaterals = false;
		sideBranchInvolved = 0;
		trifurcationValue = false;
		aortoOstialValue = false;
		severTortuosityValue = false;
		lengthGT20mmValue = false;
		heavyCalcificationValue = false;
		thrombusValue = false;
		diffuseDiseaseValue = false;
		diffuseDiseaseNoSegment = 0;
		diseasedsegment = 0;
		medina = 0;
		bifurcationAngulation = false;
		bifurcationValue = false;
		totalOcclusion = false;
		selectedDominance = false;
		mainArterySegmentSelected = false;
		firstSegment.clear();
		segment.clear();
		diffuselyDiseasedNarrowedSeg.clear();
		createMap(firstSegment);
		createMap(diffuselyDiseasedNarrowedSeg);
		createMap(segment);
	}

	private Map<String, Boolean> createMap(Map<String, Boolean> segmentMap) {

		segmentMap.put("1", false);
		segmentMap.put("2", false);
		segmentMap.put("3", false);
		segmentMap.put("4", false);
		segmentMap.put("5", false);
		segmentMap.put("6", false);
		segmentMap.put("7", false);
		segmentMap.put("8", false);
		segmentMap.put("9", false);
		segmentMap.put("9a", false);
		segmentMap.put("10", false);
		segmentMap.put("10a", false);
		segmentMap.put("11", false);
		segmentMap.put("12", false);
		segmentMap.put("12a", false);
		segmentMap.put("12b", false);
		segmentMap.put("13", false);
		segmentMap.put("14", false);
		segmentMap.put("14a", false);
		segmentMap.put("14b", false);
		segmentMap.put("15", false);
		segmentMap.put("16", false);
		segmentMap.put("16a", false);
		segmentMap.put("16b", false);
		segmentMap.put("16c", false);
		return segmentMap;
	}

	private SyntaxScoreCodeableConceptModel() {
		firstSegment = new HashMap<>();
		createMap(firstSegment);
		diffuselyDiseasedNarrowedSeg = new HashMap<>();
		createMap(diffuselyDiseasedNarrowedSeg);
		segment = new HashMap<>();
		createMap(segment);
	}

	public static SyntaxScoreCodeableConceptModel getInstance() {
		if (instanceModel == null) {
			instanceModel = new SyntaxScoreCodeableConceptModel();
			return instanceModel;
		}
		return instanceModel;
	}
}