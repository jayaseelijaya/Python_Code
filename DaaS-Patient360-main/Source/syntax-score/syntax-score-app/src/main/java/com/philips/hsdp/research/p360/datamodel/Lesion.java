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
import com.philips.hsdp.research.p360.datamodel.enums.BifurcationMedina;
import com.philips.hsdp.research.p360.datamodel.enums.SideBranchAtTheOriginOfOcclusion;
import com.philips.hsdp.research.p360.datamodel.enums.TriState;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "number", "segments_list", "totalocclusion", "first_totalocclusion_segment_number",
		"is_totalocclusion_age_gt_3months", "blunt_stump", "bridging",
		"first_segment_number_beyond_totalocclusion_visualized", "sidebranch_at_the_origin_of_occlusion",
		"trifurcation", "trifurcation_diseased_segments_involved", "aorto_ostial_lesion", "severe_tortuosity",
		"heavy_calcification", "thrombus", "comments", "bifurcation", "bifurcation_medina",
		"bifurcation_angulation_lt_70", "length_gt_20mm" })

/** @author Raj Kumar */
public class Lesion {

	@JsonProperty("number")
	private Integer number;
	@JsonProperty("segments_list")
	private List<Segments> segmentsList = new ArrayList<Segments>();
	@JsonProperty("totalocclusion")
	private Boolean totalOcclusion;
	@JsonProperty("first_totalocclusion_segment_number")
	private String firstTotalOcclusionSegmentNumber;
	@JsonProperty("is_totalocclusion_age_gt_3months")
	private TriState isTotalOcclusionAgeGt3Months;
	@JsonProperty("blunt_stump")
	private Boolean bluntStump;
	@JsonProperty("bridging")
	private Boolean bridging;
	@JsonProperty("first_segment_number_beyond_totalocclusion_visualized")
	private String firstSegmentNumberBeyondTotalOcclusionVisualized;
	@JsonProperty("sidebranch_at_the_origin_of_occlusion")
	private SideBranchAtTheOriginOfOcclusion sidebranchAtTheOriginOfOcclusion;
	@JsonProperty("trifurcation")
	private Boolean trifurcation;
	@JsonProperty("trifurcation_diseased_segments_involved")
	private Integer trifurcationDiseasedSegmentsInvolved;
	@JsonProperty("aorto_ostial_lesion")
	private Boolean aortoOstialLesion;
	@JsonProperty("severe_tortuosity")
	private Boolean severeTortuosity;
	@JsonProperty("heavy_calcification")
	private Boolean heavyCalcification;
	@JsonProperty("thrombus")
	private Boolean thrombus;
	@JsonProperty("comments")
	private String comments;
	@JsonProperty("bifurcation")
	private Boolean bifurcation;
	@JsonProperty("bifurcation_medina")
	private BifurcationMedina bifurcationMedina;
	@JsonProperty("bifurcation_angulation_lt_70")
	private Boolean bifurcationAngulationLt70;
	@JsonProperty("length_gt_20mm")
	private Boolean lengthGt20mm;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Lesion() {
	}

	/**
	 * 
	 * @param aortoOstialLesion
	 * @param comments
	 * @param totalOcclusion
	 * @param trifurcationDiseasedSegmentsInvolved
	 * @param sidebranchAtTheOriginOfOcclusion
	 * @param lengthGt20mm
	 * @param bluntStump
	 * @param thrombus
	 * @param trifurcation
	 * @param firstTotalocclusionSegmentNumber
	 * @param number
	 * @param bifurcation
	 * @param heavyCalcification
	 * @param firstSegmentNumberBeyondTotalocclusionVisualized
	 * @param severeTortuosity
	 * @param segmentsList
	 * @param bifurcationAngulationLt70
	 * @param bifurcationMedina
	 * @param isTotalOcclusionAgeGt3Months
	 * @param bridging
	 */
	public Lesion(Integer number, List<Segments> segmentsList, Boolean totalOcclusion,
			String firstTotalocclusionSegmentNumber, TriState isTotalOcclusionAgeGt3Months, Boolean bluntStump,
			Boolean bridging, String firstSegmentNumberBeyondTotalocclusionVisualized,
			SideBranchAtTheOriginOfOcclusion sidebranchAtTheOriginOfOcclusion, Boolean trifurcation,
			Integer trifurcationDiseasedSegmentsInvolved, Boolean aortoOstialLesion, Boolean severeTortuosity,
			Boolean heavyCalcification, Boolean thrombus, String comments, Boolean bifurcation,
			BifurcationMedina bifurcationMedina, Boolean bifurcationAngulationLt70, Boolean lengthGt20mm) {
		super();
		this.number = number;
		this.segmentsList = segmentsList;
		this.totalOcclusion = totalOcclusion;
		this.firstTotalOcclusionSegmentNumber = firstTotalocclusionSegmentNumber;
		this.isTotalOcclusionAgeGt3Months = isTotalOcclusionAgeGt3Months;
		this.bluntStump = bluntStump;
		this.bridging = bridging;
		this.firstSegmentNumberBeyondTotalOcclusionVisualized = firstSegmentNumberBeyondTotalocclusionVisualized;
		this.sidebranchAtTheOriginOfOcclusion = sidebranchAtTheOriginOfOcclusion;
		this.trifurcation = trifurcation;
		this.trifurcationDiseasedSegmentsInvolved = trifurcationDiseasedSegmentsInvolved;
		this.aortoOstialLesion = aortoOstialLesion;
		this.severeTortuosity = severeTortuosity;
		this.heavyCalcification = heavyCalcification;
		this.thrombus = thrombus;
		this.comments = comments;
		this.bifurcation = bifurcation;
		this.bifurcationMedina = bifurcationMedina;
		this.bifurcationAngulationLt70 = bifurcationAngulationLt70;
		this.lengthGt20mm = lengthGt20mm;
	}

	@JsonProperty("number")
	public Integer getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(Integer number) {
		this.number = number;
	}

	@JsonProperty("segments_list")
	public List<Segments> getSegmentsList() {
		return segmentsList;
	}

	@JsonProperty("segments_list")
	public void setSegmentsList(List<Segments> segmentsList) {
		this.segmentsList = segmentsList;
	}

	@JsonProperty("totalocclusion")
	public Boolean getTotalOcclusion() {
		return totalOcclusion;
	}

	@JsonProperty("totalocclusion")
	public void setTotalOcclusion(Boolean totalOcclusion) {
		this.totalOcclusion = totalOcclusion;
	}

	@JsonProperty("first_totalocclusion_segment_number")
	public String getFirstTotalOcclusionSegmentNumber() {
		return firstTotalOcclusionSegmentNumber;
	}

	@JsonProperty("first_totalocclusion_segment_number")
	public void setFirstTotalOcclusionSegmentNumber(String firstTotalOcclusionSegmentNumber) {
		this.firstTotalOcclusionSegmentNumber = firstTotalOcclusionSegmentNumber;
	}

	@JsonProperty("is_totalocclusion_age_gt_3months")
	public TriState getIsTotalOcclusionAgeGt3Months() {
		return isTotalOcclusionAgeGt3Months;
	}

	@JsonProperty("is_totalocclusion_age_gt_3months")
	public void setIsTotalOcclusionAgeGt3Months(TriState isTotalOcclusionAgeGt3Months) {
		this.isTotalOcclusionAgeGt3Months = isTotalOcclusionAgeGt3Months;
	}

	@JsonProperty("blunt_stump")
	public Boolean getBluntStump() {
		return bluntStump;
	}

	@JsonProperty("blunt_stump")
	public void setBluntStump(Boolean bluntStump) {
		this.bluntStump = bluntStump;
	}

	@JsonProperty("bridging")
	public Boolean getBridging() {
		return bridging;
	}

	@JsonProperty("bridging")
	public void setBridging(Boolean bridging) {
		this.bridging = bridging;
	}

	@JsonProperty("first_segment_number_beyond_totalocclusion_visualized")
	public String getFirstSegmentNumberBeyondTotalOcclusionVisualized() {
		return firstSegmentNumberBeyondTotalOcclusionVisualized;
	}

	@JsonProperty("first_segment_number_beyond_totalocclusion_visualized")
	public void setFirstSegmentNumberBeyondTotalOcclusionVisualized(
			String firstSegmentNumberBeyondTotalOcclusionVisualized) {
		this.firstSegmentNumberBeyondTotalOcclusionVisualized = firstSegmentNumberBeyondTotalOcclusionVisualized;
	}

	@JsonProperty("sidebranch_at_the_origin_of_occlusion")
	public SideBranchAtTheOriginOfOcclusion getSidebranchAtTheOriginOfOcclusion() {
		return sidebranchAtTheOriginOfOcclusion;
	}

	@JsonProperty("sidebranch_at_the_origin_of_occlusion")
	public void setSidebranchAtTheOriginOfOcclusion(SideBranchAtTheOriginOfOcclusion sidebranchAtTheOriginOfOcclusion) {
		this.sidebranchAtTheOriginOfOcclusion = sidebranchAtTheOriginOfOcclusion;
	}

	@JsonProperty("trifurcation")
	public Boolean getTrifurcation() {
		return trifurcation;
	}

	@JsonProperty("trifurcation")
	public void setTrifurcation(Boolean trifurcation) {
		this.trifurcation = trifurcation;
	}

	@JsonProperty("trifurcation_diseased_segments_involved")
	public Integer getTrifurcationDiseasedSegmentsInvolved() {
		return trifurcationDiseasedSegmentsInvolved;
	}

	@JsonProperty("trifurcation_diseased_segments_involved")
	public void setTrifurcationDiseasedSegmentsInvolved(Integer trifurcationDiseasedSegmentsInvolved) {
		this.trifurcationDiseasedSegmentsInvolved = trifurcationDiseasedSegmentsInvolved;
	}

	@JsonProperty("aorto_ostial_lesion")
	public Boolean getAortoOstialLesion() {
		return aortoOstialLesion;
	}

	@JsonProperty("aorto_ostial_lesion")
	public void setAortoOstialLesion(Boolean aortoOstialLesion) {
		this.aortoOstialLesion = aortoOstialLesion;
	}

	@JsonProperty("severe_tortuosity")
	public Boolean getSevereTortuosity() {
		return severeTortuosity;
	}

	@JsonProperty("severe_tortuosity")
	public void setSevereTortuosity(Boolean severeTortuosity) {
		this.severeTortuosity = severeTortuosity;
	}

	@JsonProperty("heavy_calcification")
	public Boolean getHeavyCalcification() {
		return heavyCalcification;
	}

	@JsonProperty("heavy_calcification")
	public void setHeavyCalcification(Boolean heavyCalcification) {
		this.heavyCalcification = heavyCalcification;
	}

	@JsonProperty("thrombus")
	public Boolean getThrombus() {
		return thrombus;
	}

	@JsonProperty("thrombus")
	public void setThrombus(Boolean thrombus) {
		this.thrombus = thrombus;
	}

	@JsonProperty("comments")
	public String getComments() {
		return comments;
	}

	@JsonProperty("comments")
	public void setComments(String comments) {
		this.comments = comments;
	}

	@JsonProperty("bifurcation")
	public Boolean getBifurcation() {
		return bifurcation;
	}

	@JsonProperty("bifurcation")
	public void setBifurcation(Boolean bifurcation) {
		this.bifurcation = bifurcation;
	}

	@JsonProperty("bifurcation_medina")
	public BifurcationMedina getBifurcationMedina() {
		return bifurcationMedina;
	}

	@JsonProperty("bifurcation_medina")
	public void setBifurcationMedina(BifurcationMedina bifurcationMedina) {
		this.bifurcationMedina = bifurcationMedina;
	}

	@JsonProperty("bifurcation_angulation_lt_70")
	public Boolean getBifurcationAngulationLt70() {
		return bifurcationAngulationLt70;
	}

	@JsonProperty("bifurcation_angulation_lt_70")
	public void setBifurcationAngulationLt70(Boolean bifurcationAngulationLt70) {
		this.bifurcationAngulationLt70 = bifurcationAngulationLt70;
	}

	@JsonProperty("length_gt_20mm")
	public Boolean getLengthGt20mm() {
		return lengthGt20mm;
	}

	@JsonProperty("length_gt_20mm")
	public void setLengthGt20mm(Boolean lengthGt20mm) {
		this.lengthGt20mm = lengthGt20mm;
	}
}