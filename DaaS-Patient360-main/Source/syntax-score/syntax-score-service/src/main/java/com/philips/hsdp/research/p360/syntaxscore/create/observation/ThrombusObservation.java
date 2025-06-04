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
public class ThrombusObservation extends ILSObservation {
	
	private static final String ILS_PROFILE_THROMBUS = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreThrombus";
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	private Observation thrombusObservationObj = new Observation();

	public ThrombusObservation(boolean present) {
		super();
		accessSyntaxScoreModel.present = present;
	}


	/**
	 * Generates Thrombus observation
	 * @return observation XML string
	 */
	public String createObservation() {
		// Id
		initializeObservationId(thrombusObservationObj);

		// Meta
		createMetaData(thrombusObservationObj, ILS_PROFILE_THROMBUS);

		//Status
		setObservationStatus(thrombusObservationObj);

		// Category
		createCodeableConceptCategory(thrombusObservationObj, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Code
		createCodeableConcept(thrombusObservationObj, Snomed.SNOMED_URL,
				Snomed.SNOMED_CODE_THROMBUS,
				Snomed.SNOMED_DISPLAY_THROMBUS);

		// Subject
		setObservationSubject(thrombusObservationObj);

		// EffectiveDateTime
		setEffectiveDateTime(thrombusObservationObj);

		// Value Code-able Concept
		createValueCodeableConcept(thrombusObservationObj,TerminologyServer.RADLEX_URL,
				accessSyntaxScoreModel.present ? TerminologyServer.RADLEX_PRESENT : TerminologyServer.RADLEX_ABSENT,
						accessSyntaxScoreModel.present ? TerminologyServer.PRESENT : TerminologyServer.ABSENT);

		// Genrate XML
		String thrombusXml = generateObservationXML(thrombusObservationObj);
		return thrombusXml;
	}
}