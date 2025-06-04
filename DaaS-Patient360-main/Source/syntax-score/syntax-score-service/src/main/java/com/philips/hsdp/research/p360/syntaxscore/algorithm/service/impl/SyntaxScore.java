/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* @author Sunil Kumar */
public class SyntaxScore {
	private static SyntaxScore INSTANCE;
	private float fSyntexScore;
	private float tempSyntaxScoreDiffuseDisease;
	private float lesionSyntaxSubscoreTotalOcclusionObservation;
	public TreeMap<String, Float> totalSyntaxScore;
	public Map<String, Float> syntaxScoreMap;
	List<Float> listLesions;

	public void reset() {
		fSyntexScore = 0.0f;
		tempSyntaxScoreDiffuseDisease = 0.0f;
		lesionSyntaxSubscoreTotalOcclusionObservation = 0.0f;
		totalSyntaxScore.clear();
		syntaxScoreMap.clear();
		listLesions.clear();
	}

	public List<Float> getListLesions() {
		return listLesions;
	}

	public void setListLesions(List<Float> listLesions) {
		this.listLesions = listLesions;
	}

	public Map<String, Float> getSyntaxScoreMap() {
		return syntaxScoreMap;
	}

	public void setSyntaxScoreMap(Map<String, Float> syntaxScoreMap) {
		this.syntaxScoreMap = syntaxScoreMap;
	}

	public float getTempSyntaxScoreDiffuseDisease() {
		return tempSyntaxScoreDiffuseDisease;
	}

	public void setTempSyntaxScoreDiffuseDisease(float tempSyntaxScoreDiffuseDisease) {
		this.tempSyntaxScoreDiffuseDisease = tempSyntaxScoreDiffuseDisease;
	}

	public TreeMap<String, Float> getTotalSyntaxScore() {
		return totalSyntaxScore;
	}

	public void setTotalSyntaxScore(TreeMap<String, Float> totalSyntaxScore) {
		this.totalSyntaxScore = totalSyntaxScore;
	}

	public SyntaxScore() {
		totalSyntaxScore = new TreeMap<>((a, b) -> 1);
		syntaxScoreMap = new HashMap<>();
		listLesions = new ArrayList<>();
	}

	public float getSyntaxScore() {
		return fSyntexScore;
	}

	public void setSyntaxScore(float fl) {
		this.fSyntexScore = fl;
	}

	public float getLesionSyntaxSubscoreTotalOcclusionObservation() {
		return lesionSyntaxSubscoreTotalOcclusionObservation;
	}

	public void setLesionSyntaxSubscoreTotalOcclusionObservation(float lesionSyntaxSubscoreTotalOcclusionObservation) {
		this.lesionSyntaxSubscoreTotalOcclusionObservation = lesionSyntaxSubscoreTotalOcclusionObservation;
	}

	public SyntaxScore(Map<String, Float> lesionSyntaxSubscoreTotalOcclusionObservation) {
		lesionSyntaxSubscoreTotalOcclusionObservation = new HashMap<>();
	}

	public static SyntaxScore getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SyntaxScore();
			return INSTANCE;
		}
		return INSTANCE;
	}
}