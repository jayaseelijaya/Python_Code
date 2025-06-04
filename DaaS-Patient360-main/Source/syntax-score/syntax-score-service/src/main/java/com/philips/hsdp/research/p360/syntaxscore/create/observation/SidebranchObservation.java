/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscore.create.observation;

import org.hl7.fhir.r4.model.Observation;
import com.philips.hsdp.research.p360.syntaxscore.constant.Snomed;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import com.philips.hsdp.research.p360.syntaxscore.create.ils.observation.ILSObservation;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.enums.SideBranchAtTheOriginOfOcclusion;

/* @author Raj Kumar */
public class SidebranchObservation extends ILSObservation {
	
	private static final String ILS_PROFILE_TO_SIDEBRANCH = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscoreTotalOcclusion/TotalOcclusionSidebranch";
	private Observation sidebranchObservationObj = new Observation();
	private SideBranchAtTheOriginOfOcclusion codeValue;

	public SidebranchObservation(SideBranchAtTheOriginOfOcclusion codeValue) {
		super();
		this.codeValue = codeValue;
	}

	/**
	 * Generates  Sidebranch observation
	 * @return observation XML string
	 */
	public String createObservation() {

		// Id
		initializeObservationId(sidebranchObservationObj);

		// Meta
		createMetaData(sidebranchObservationObj, ILS_PROFILE_TO_SIDEBRANCH);

		//Status
		setObservationStatus(sidebranchObservationObj);

		// Code
		createCodeableConcept(sidebranchObservationObj, TerminologyServer.CAD_SUMMARY_CODE_URL,
				Snomed.SNOMED_CODE_SIDE_BRANCH_AT_THE_ORIGIN_OF_OCCULUSION,
				Snomed.SNOMED_CODE_SIDE_BRANCH_AT_THE_ORIGIN_OF_OCCULUSION);

		// Category
		createCodeableConceptCategory(sidebranchObservationObj, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Subject
		setObservationSubject(sidebranchObservationObj);

		// EffectiveDateTime
		setEffectiveDateTime(sidebranchObservationObj);

		// Value Code-able Concept
		String code = null;
		if (this.codeValue.equals(SideBranchAtTheOriginOfOcclusion.NO)) {
			code = "NoSidebranch";
		} else if (this.codeValue.equals(SideBranchAtTheOriginOfOcclusion.YES_ALLSIDEBRANCHES_LT_1_POINT_5_MM)) {
			code = "Less1.5mm";
		} else if (this.codeValue.equals(SideBranchAtTheOriginOfOcclusion.YES_ALLSIDEBRANCHES_GTOREQUAL_1_POINT_5_MM)) {
			code = "Great1.5mm";
		} else if (this.codeValue.equals(SideBranchAtTheOriginOfOcclusion.YES_ALLSIDEBRANCHES_LT_1_POINT_5_MM_AND_GTOREQUAL_1_POINT_5_MM_ARE_INVOLVED)) {
			code = "Both1.5mm";
		}
		
		// Value Code-able Concept
		createValueCodeableConcept(sidebranchObservationObj, TerminologyServer.CAD_SUMMARY_CODE_URL,
				code, this.codeValue.getValue());

		String sidebranchObservationXml = generateObservationXML(sidebranchObservationObj);
		return sidebranchObservationXml;
	}
}