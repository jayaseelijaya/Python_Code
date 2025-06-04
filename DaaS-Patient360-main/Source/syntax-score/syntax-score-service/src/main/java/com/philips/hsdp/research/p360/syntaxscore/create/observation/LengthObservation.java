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
public class LengthObservation extends ILSObservation  {

	private static final String ILS_PROFILE_LENGTH = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreLength";
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	private Observation lengthObservationObj = new Observation();
	
	public LengthObservation(boolean present) {
		super();
		accessSyntaxScoreModel.present = present;		
	}

	/**
	 * Generates Length observation
	 * @return observation XML string
	 */
	public String createObservation() {
		
		// Id
		initializeObservationId(lengthObservationObj);

		// Meta
		createMetaData(lengthObservationObj, ILS_PROFILE_LENGTH);
		
		//status
		setObservationStatus(lengthObservationObj);

		// Code
		createCodeableConcept(lengthObservationObj, Snomed.SNOMED_URL,
				Snomed.SNOMED_LENGTH,
				Snomed.SNOMED_DISPLAY_LENGTH);

		// Category
		createCodeableConceptCategory(lengthObservationObj, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Subject
		setObservationSubject(lengthObservationObj);

		// EffectiveDateTime
		setEffectiveDateTime(lengthObservationObj);

		// Value Code-able Concept
		String code = accessSyntaxScoreModel.present ? TerminologyServer.RADLEX_PRESENT : TerminologyServer.RADLEX_ABSENT;
		createValueCodeableConcept(lengthObservationObj, TerminologyServer.RADLEX_URL,
				code, accessSyntaxScoreModel.present ? TerminologyServer.PRESENT : TerminologyServer.ABSENT);

		// Genrate XML
		String lengthXml = generateObservationXML(lengthObservationObj);
		return lengthXml;
	}
}