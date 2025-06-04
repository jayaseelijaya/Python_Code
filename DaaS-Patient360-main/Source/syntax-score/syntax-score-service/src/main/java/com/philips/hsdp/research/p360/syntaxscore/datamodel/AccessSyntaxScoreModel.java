/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.datamodel;

import java.util.HashMap;
import java.util.Map;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.enums.Dominance;
import lombok.Data;

/* @author Sunil Kumar */
@Data
public class AccessSyntaxScoreModel {

	private static AccessSyntaxScoreModel INSTANCE;
	public boolean present;
	public int lesionNumber;
	public Dominance selectedDominance;
	public DiffuselyDiseasedNarrowedSegment diffuselyDiseasedNarrowedSegment;
	public PatientInfo patientInfo;
	public Float score;
	public String segmentNumber;
	public String codeValue;
	public int segmentsInvolved;
	private Map<String, Boolean> firstSegmentTOVisualised;

	AccessSyntaxScoreModel() {
		this.firstSegmentTOVisualised = new HashMap<>();
		this.firstSegmentTOVisualised.put("None", false);
		this.firstSegmentTOVisualised.put("1", false);
		this.firstSegmentTOVisualised.put("2", false);
		this.firstSegmentTOVisualised.put("3", false);
		this.firstSegmentTOVisualised.put("4", false);
		this.firstSegmentTOVisualised.put("5", false);
		this.firstSegmentTOVisualised.put("6", false);
		this.firstSegmentTOVisualised.put("7", false);
		this.firstSegmentTOVisualised.put("8", false);
		this.firstSegmentTOVisualised.put("9", false);
		this.firstSegmentTOVisualised.put("10", false);
		this.firstSegmentTOVisualised.put("11", false);
		this.firstSegmentTOVisualised.put("12", false);
		this.firstSegmentTOVisualised.put("13", false);
		this.firstSegmentTOVisualised.put("14", false);
		this.firstSegmentTOVisualised.put("15", false);
	}

	public static AccessSyntaxScoreModel getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AccessSyntaxScoreModel();
			return INSTANCE;
		}
		return INSTANCE;
	}
}