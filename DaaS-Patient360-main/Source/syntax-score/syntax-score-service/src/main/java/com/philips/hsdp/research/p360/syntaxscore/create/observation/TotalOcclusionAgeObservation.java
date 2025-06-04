/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscore.create.observation;

import org.hl7.fhir.r4.model.Observation;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.AccessSyntaxScoreModel;
import com.philips.hsdp.research.p360.syntaxscore.constant.Snomed;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import com.philips.hsdp.research.p360.syntaxscore.create.ils.observation.ILSObservation;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.enums.TriState;

/* @author Raj Kumar */
public class TotalOcclusionAgeObservation extends ILSObservation {
	
	private static final String ILS_PROFILE_TO_AGE = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscoreTotalOcclusion/TotalOcclusionAge";
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	private Observation ageOfTOGt3MonthsObservation = new Observation();
	private TriState codeValue;

	public TotalOcclusionAgeObservation(TriState codeValue) {
		super();
		this.codeValue = codeValue;
	}

	/**
	 * Generates  TotalOcclusionAge observation
	 * @return observation XML string
	 */
	public String createObservation() {

		// Id
		initializeObservationId(ageOfTOGt3MonthsObservation);

		// Meta
		createMetaData(ageOfTOGt3MonthsObservation, ILS_PROFILE_TO_AGE);

		// Set Observation Status
		setObservationStatus(ageOfTOGt3MonthsObservation);

		// Code
		createCodeableConcept(ageOfTOGt3MonthsObservation, TerminologyServer.CAD_SUMMARY_CODE_URL,
				Snomed.SNOMED_CODE_AGE_OF_TO_GT_3_MONTHS,
				Snomed.SNOMED_DISPLAY_AGE_OF_TO_GT_3_MONTHS);

		// Category
		createCodeableConceptCategory(ageOfTOGt3MonthsObservation, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Subject
		setObservationSubject(ageOfTOGt3MonthsObservation);

		// EffectiveDateTime
		setEffectiveDateTime(ageOfTOGt3MonthsObservation);

		// Value Code-able Concept
		String code = null;
		if (this.codeValue.equals(TriState.YES)) {
			code = "Y";
		} else if (this.codeValue.equals(TriState.NO)) {
			code = "N";
		} else if (this.codeValue.equals(TriState.UNKNOWN)) {
			code = "ASKU";
		}
		
		createValueCodeableConcept(ageOfTOGt3MonthsObservation, TerminologyServer.TO_TERIMOLOGY_URL,
				code, this.codeValue.getValue());

		// Genrate XML
		String ageOfTOGt3MonthsObservationXml = generateObservationXML(ageOfTOGt3MonthsObservation);
		return ageOfTOGt3MonthsObservationXml;
	}
}