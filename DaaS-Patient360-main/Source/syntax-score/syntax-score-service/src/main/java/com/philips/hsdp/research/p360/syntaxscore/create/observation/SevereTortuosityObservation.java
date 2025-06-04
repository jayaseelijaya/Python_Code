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
public class SevereTortuosityObservation extends ILSObservation{
	
	private static final String ILS_PROFILE_SEVERE_TORTUOSITY = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreSevereTortuosity";
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	Observation severeTortuosityObservationObj = new Observation();

	public SevereTortuosityObservation(boolean present) {
		super();
		accessSyntaxScoreModel.present = present;
	}

	/**
	 * Generates Severe Tortuosity observation
	 * @return observation XML string
	 */
	public String createObservation() {

		// Id
		initializeObservationId(severeTortuosityObservationObj);

		// Meta
		createMetaData(severeTortuosityObservationObj, ILS_PROFILE_SEVERE_TORTUOSITY);

		//Status
		setObservationStatus(severeTortuosityObservationObj);

		// Category
		createCodeableConceptCategory(severeTortuosityObservationObj, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Code
		createCodeableConcept(severeTortuosityObservationObj, Snomed.SNOMED_URL,
				Snomed.SNOMED_CODE_ARTERIAL_TORTUOSITY_SYNDROME,
				Snomed.SNOMED_DISPLAY_ARTERIAL_TORTUOSITY_SYNDROME);

		// Subject
		setObservationSubject(severeTortuosityObservationObj);

		// EffectiveDateTime
		setEffectiveDateTime(severeTortuosityObservationObj);

		// Value Code-able Concept
		createValueCodeableConcept(severeTortuosityObservationObj, TerminologyServer.RADLEX_URL,
				accessSyntaxScoreModel.present ? TerminologyServer.RADLEX_PRESENT : TerminologyServer.RADLEX_ABSENT,
						accessSyntaxScoreModel.present ? TerminologyServer.PRESENT : TerminologyServer.ABSENT);

		// Genrate XML
		String severeTortuosityXml = generateObservationXML(severeTortuosityObservationObj);
		return severeTortuosityXml;
	}
}