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
public class BridgingObservation extends ILSObservation {
	
	private static final String ILS_PROFILE_BRIDGING = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscoreTotalOcclusion/TotalOcclusionBridging";
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	private Observation bridgingObservationObj = new Observation();

	public BridgingObservation(boolean present) {
		super();
		accessSyntaxScoreModel.present = present;
	}

	/**
	 * Generates Bridging observation
	 * @return observation XML string
	 */
	public String createObservation() {
		
		// Id
		initializeObservationId(bridgingObservationObj);

		// Meta
		createMetaData(bridgingObservationObj, ILS_PROFILE_BRIDGING);

		//status
		setObservationStatus(bridgingObservationObj);

		// Category
		createCodeableConceptCategory(bridgingObservationObj, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Code
		createCodeableConcept(bridgingObservationObj, TerminologyServer.CAD_SUMMARY_CODE_URL,
				Snomed.SNOMED_CODE_BRIDGING, Snomed.SNOMED_CODE_BRIDGING);

		// Subject
		setObservationSubject(bridgingObservationObj);

		// EffectiveDateTime
		setEffectiveDateTime(bridgingObservationObj);

		// Value Code-able Concept
		createValueCodeableConcept(bridgingObservationObj, TerminologyServer.RADLEX_URL,
				accessSyntaxScoreModel.present ? TerminologyServer.RADLEX_PRESENT : TerminologyServer.RADLEX_ABSENT,
						accessSyntaxScoreModel.present ? TerminologyServer.PRESENT : TerminologyServer.ABSENT);

		// Genrate XML
		return generateObservationXML(bridgingObservationObj);
	}
}