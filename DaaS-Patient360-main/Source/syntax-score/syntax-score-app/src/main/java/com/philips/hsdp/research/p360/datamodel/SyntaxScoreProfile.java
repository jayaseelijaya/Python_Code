/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.datamodel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.philips.hsdp.research.p360.datamodel.enums.Dominance;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "selected_dominance", "lesion_profile", "diffusely_diseased_narrowed_segment", "score" })

/** @author Raj Kumar */
public class SyntaxScoreProfile {

	@JsonProperty("selected_dominance")
	private Dominance selectedDominance;
	@JsonProperty("lesion_profile")
	private List<LesionProfile> lesionProfile = new ArrayList<LesionProfile>();
	@JsonProperty("diffusely_diseased_narrowed_segment")
	private DiffuselyDiseasedNarrowedSegment diffuselyDiseasedNarrowedSegment;

	@JsonProperty("patient_info")
	private PatientInfo patientInfo;

	@JsonProperty("score")
	private Float score;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public SyntaxScoreProfile() {
	}

	/**
	 * 
	 * @param score
	 * @param diffuselyDiseasedNarrowedSegment
	 * @param lesionProfile
	 * @param selectedDominance
	 */
	public SyntaxScoreProfile(Dominance selectedDominance, List<LesionProfile> lesionProfile,
			DiffuselyDiseasedNarrowedSegment diffuselyDiseasedNarrowedSegment, Float score) {
		super();
		this.selectedDominance = selectedDominance;
		this.lesionProfile = lesionProfile;
		this.diffuselyDiseasedNarrowedSegment = diffuselyDiseasedNarrowedSegment;
		this.score = score;
	}

	@JsonProperty("selected_dominance")
	public Dominance getSelectedDominance() {
		return selectedDominance;
	}

	@JsonProperty("selected_dominance")
	public void setSelectedDominance(Dominance selectedDominance) {
		this.selectedDominance = selectedDominance;
	}

	@JsonProperty("lesion_profile")
	public List<LesionProfile> getLesionProfile() {
		return lesionProfile;
	}

	@JsonProperty("lesion_profile")
	public void setLesionProfile(List<LesionProfile> lesionProfile) {
		this.lesionProfile = lesionProfile;
	}

	@JsonProperty("diffusely_diseased_narrowed_segment")
	public DiffuselyDiseasedNarrowedSegment getDiffuselyDiseasedNarrowedSegment() {
		return diffuselyDiseasedNarrowedSegment;
	}

	@JsonProperty("diffusely_diseased_narrowed_segment")
	public void setDiffuselyDiseasedNarrowedSegment(DiffuselyDiseasedNarrowedSegment diffuselyDiseasedNarrowedSegment) {
		this.diffuselyDiseasedNarrowedSegment = diffuselyDiseasedNarrowedSegment;
	}

	@JsonProperty("patient_info")
	public PatientInfo getPatientInfo() {
		return patientInfo;
	}

	@JsonProperty("patient_info")
	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}

	@JsonProperty("score")
	public Float getScore() {
		return score;
	}

	@JsonProperty("score")
	public void setScore(Float score) {
		this.score = score;
	}
}