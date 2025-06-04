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
public class AortoOstialObservation extends ILSObservation {
	
	private static final String ILS_PROFILE_AORTHO_OSTIAL = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreAortoOstial";
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	private Observation aortoObservation = new Observation();
	
	public AortoOstialObservation(boolean present) {
		super();
		accessSyntaxScoreModel.present = present;
	}
	
	/**
	 * Generates Aorto Ostial observation
	 * @return XML string
	 */
	public String createObservation() {
		
		// Id
		initializeObservationId(aortoObservation);
		
		// Meta
		createMetaData(aortoObservation, ILS_PROFILE_AORTHO_OSTIAL);

		// Set Observation Status
		setObservationStatus(aortoObservation);

		// Category
		createCodeableConceptCategory(aortoObservation, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);	

		// Code
		createCodeableConcept(aortoObservation, Snomed.SNOMED_URL,
				Snomed.SNOMED_CODE_CORONARY_OSTIUM_STENOSIS,
				Snomed.SNOMED_DISPLAY_CORONARY_OSTIUM_STENOSIS);

		// Subject
		setObservationSubject(aortoObservation);

		// EffectiveDateTime
		setEffectiveDateTime(aortoObservation);

		// Value Code-able Concept
		createValueCodeableConcept(aortoObservation, TerminologyServer.RADLEX_URL,
				accessSyntaxScoreModel.present ? TerminologyServer.RADLEX_PRESENT : TerminologyServer.RADLEX_ABSENT,
						accessSyntaxScoreModel.present ? TerminologyServer.PRESENT : TerminologyServer.ABSENT);

		// Genrate XML
		String aortoObservationXml = generateObservationXML(aortoObservation);

		return aortoObservationXml;
	}
}