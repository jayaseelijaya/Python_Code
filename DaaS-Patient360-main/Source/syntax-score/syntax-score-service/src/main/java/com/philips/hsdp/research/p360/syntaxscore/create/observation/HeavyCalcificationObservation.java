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
public class HeavyCalcificationObservation extends ILSObservation {
	
	private static final String ILS_PROFILE_HEAVY_CALCI = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreHeavyCalcification";
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	private Observation heavyCalcificationObservationObj = new Observation();

	public HeavyCalcificationObservation(boolean present) {
		super();
		accessSyntaxScoreModel.present = present;
	}

	/**
	 * Generates First Heavy Calcification observation
	 * @return observation XML string
	 */
	public String createObservation() {

		// Id
		initializeObservationId(heavyCalcificationObservationObj);

		// Meta
		createMetaData(heavyCalcificationObservationObj, ILS_PROFILE_HEAVY_CALCI);

		//status
		setObservationStatus(heavyCalcificationObservationObj);

		// Code
		createCodeableConcept(heavyCalcificationObservationObj, Snomed.SNOMED_URL,
				Snomed.SNOMED_CODE_PATHOLOGIC_CALCIFICATION,
				Snomed.SNOMED_DISPLAY_PATHOLOGIC_CALCIFICATION);

		// Category
		createCodeableConceptCategory(heavyCalcificationObservationObj, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Subject
		setObservationSubject(heavyCalcificationObservationObj);

		// EffectiveDateTime
		setEffectiveDateTime(heavyCalcificationObservationObj);

		// Value Code-able Concept
		String code = accessSyntaxScoreModel.present ? TerminologyServer.RADLEX_PRESENT : TerminologyServer.RADLEX_ABSENT;
		createValueCodeableConcept(heavyCalcificationObservationObj, TerminologyServer.RADLEX_URL,
				code, accessSyntaxScoreModel.present ? TerminologyServer.PRESENT : TerminologyServer.ABSENT);


		// Genrate XML
		String heavyCalcificationXml = generateObservationXML(heavyCalcificationObservationObj);
		return heavyCalcificationXml;
	}
}