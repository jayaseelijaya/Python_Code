/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscore.create.observation;

import org.hl7.fhir.r4.model.Observation;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import com.philips.hsdp.research.p360.syntaxscore.create.ils.observation.ILSObservation;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.enums.Dominance;

/* @author Raj Kumar */
public class DominanceSelectionObservation extends ILSObservation {

	private static final String ILS_DOMINANCE_PROFILE = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/CoronaryArteryDominanceObservation";
	private Dominance selectedDominance;
	private Observation dominanceObservation = new Observation();

	public DominanceSelectionObservation(Dominance selectedDominance) {
		super();
		this.selectedDominance = selectedDominance;
	}

	/**
	 * Generates Dominance Selection observation
	 * @return observation XML string
	 */
	public String createObservation() {

		// Id
		initializeObservationId(dominanceObservation);

		// Meta
		createMetaData(dominanceObservation, ILS_DOMINANCE_PROFILE);

		//status
		setObservationStatus(dominanceObservation);

		// Code
		createCodeableConcept(dominanceObservation, TerminologyServer.NCICB_URL, TerminologyServer.NCI_CODE_DOMINACE,
				TerminologyServer.NCI_DISPLAY_DOMINACE);

		// Category
		createCodeableConceptCategory(dominanceObservation, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Subject
		setObservationSubject(dominanceObservation);

		// EffectiveDateTime
		setEffectiveDateTime(dominanceObservation);

		// Value Code-able Concept	
		String code = this.selectedDominance.equals(Dominance.RIGHT) ? TerminologyServer.NCI_RIGHT_DOMINANCE : TerminologyServer.NCI_LEFT_DOMINANCE;
		String display = this.selectedDominance.equals(Dominance.RIGHT) ? TerminologyServer.NCI_DISPLAY_DOMINANCE_SELECTION_RIGHT : TerminologyServer.NCI_DISPLAY_DOMINANCE_SELECTION_LEFT;	
		createValueCodeableConcept(dominanceObservation,TerminologyServer.NCICB_URL, code, display);

		// Genrate XML
		String dominanceObservationXml = generateObservationXML(dominanceObservation);
		return dominanceObservationXml;
	}
}