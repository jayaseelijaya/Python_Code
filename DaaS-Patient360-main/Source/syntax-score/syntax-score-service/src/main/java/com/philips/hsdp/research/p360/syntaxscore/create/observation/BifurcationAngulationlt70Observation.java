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

/** @author Raj Kumar */
public class BifurcationAngulationlt70Observation extends ILSObservation {

	private static final String ILS_PROFILE_BIFRICATION_ANGULATION = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/BifurcationAngulation";	
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	private Observation bifurcationAngulationltObservation = new Observation();
	
	public BifurcationAngulationlt70Observation(boolean present) {
		super();
		accessSyntaxScoreModel.present = present;
	}
	
	/**
	 * Generates BifurcationAngulation observation
	 * @return observation XML string
	 */
	public String createObservation() {

		// Id
		initializeObservationId(bifurcationAngulationltObservation);

		// Status
		setObservationStatus(bifurcationAngulationltObservation);

		// Meta
		createMetaData(bifurcationAngulationltObservation,ILS_PROFILE_BIFRICATION_ANGULATION);

		// Code
		createCodeableConcept(bifurcationAngulationltObservation, Snomed.SNOMED_URL,
				Snomed.SNOMED_CODE_BIFURCATION_ANGULATION , Snomed.SNOMED_DISPLAY_BIFURCATION_ANGULATION);

		// Category
		createCodeableConceptCategory(bifurcationAngulationltObservation, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Subject
		setObservationSubject(bifurcationAngulationltObservation);

		// EffectiveDateTime
		setEffectiveDateTime(bifurcationAngulationltObservation);

		// Value Code-able Concept
		createValueCodeableConcept(bifurcationAngulationltObservation, TerminologyServer.RADLEX_URL,
				accessSyntaxScoreModel.present ? TerminologyServer.RADLEX_PRESENT : TerminologyServer.RADLEX_ABSENT,
						accessSyntaxScoreModel.present ? TerminologyServer.PRESENT : TerminologyServer.ABSENT);

		// Generate XML
		String bifurcationAngulationlt70ObservationXml = generateObservationXML(bifurcationAngulationltObservation);

		return bifurcationAngulationlt70ObservationXml;
	}
}