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

/* @author Raj Kumar */
public class BluntStumpObservation extends ILSObservation {
	
	private static final String ILS_PROFILE_TO_BLUNT_STUMP = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscoreTotalOcclusion/TotalOcclusionBluntStump";
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	private Observation bluntStumpObservationobj = new Observation();

	public BluntStumpObservation(boolean present) {
		super();
		accessSyntaxScoreModel.present = present;
	}

	/**
	 * Generates BluntStump observation
	 * @return observation XML string
	 */
	public String createObservation() {
		// Id
		initializeObservationId(bluntStumpObservationobj);

		// Meta
		createMetaData(bluntStumpObservationobj, ILS_PROFILE_TO_BLUNT_STUMP);

		// status
		setObservationStatus(bluntStumpObservationobj);

		// Category
		createCodeableConceptCategory(bluntStumpObservationobj, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Code
		createCodeableConcept(bluntStumpObservationobj, TerminologyServer.CAD_SUMMARY_CODE_URL,
				Snomed.SNOMED_CODE_BLUNTSTUMP, Snomed.SNOMED_DISPLAY_BLUNTSTUMP);

		// Subject
		setObservationSubject(bluntStumpObservationobj);

		// EffectiveDateTime
		setEffectiveDateTime(bluntStumpObservationobj);

		// Value Code-able Concept
		createValueCodeableConcept(bluntStumpObservationobj, TerminologyServer.RADLEX_URL,
				accessSyntaxScoreModel.present ? TerminologyServer.RADLEX_PRESENT : TerminologyServer.RADLEX_ABSENT,
						accessSyntaxScoreModel.present ? TerminologyServer.PRESENT : TerminologyServer.ABSENT);

		return generateObservationXML(bluntStumpObservationobj);
	}
}