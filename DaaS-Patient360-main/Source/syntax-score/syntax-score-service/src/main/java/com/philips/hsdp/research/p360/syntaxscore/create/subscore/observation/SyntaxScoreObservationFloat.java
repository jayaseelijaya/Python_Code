/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.constant.Snomed;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import com.philips.hsdp.research.p360.syntaxscore.controller.SyntaxScoreCalculateController;
import com.philips.hsdp.research.p360.syntaxscore.create.ils.observation.ILSObservation;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/* @author Raj Kumar */
@Service
public class SyntaxScoreObservationFloat extends ILSObservation {
	
	private static final String ILS_PROFILE_SYNTAXSCORE = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/SyntaxScore";
	private String observationlist = null;
	private Observation syntaxScoreObservationobj = new Observation();
	public SyntaxScoreObservationFloat() {}
	public SyntaxScoreObservationFloat(String observationlist) {
		this.observationlist = observationlist;
	}

	/**
	 * Generates  SyntaxScore observation
	 * @return observation XML string
	 */
	public String createObservation() {
		byte[] decoded = Base64.getUrlDecoder().decode(this.observationlist);
		String observationString = new String(decoded, StandardCharsets.UTF_8);

		observationString = observationString.replace(">,", ">\n,");
		List<String> myList = new ArrayList<>(Arrays.asList(observationString.split("\\n,")));
		List<Resource> resource = new ArrayList<>();
		List<Reference> referenceList = new ArrayList<>();
		FhirContext ctx = FhirContext.forR4();

		for (String obString : myList) {
			IParser parser = ctx.newXmlParser();
			Observation observation = parser.parseResource(Observation.class, obString);
			// adding to resource for contained
			resource.add(observation);
			// adding to reference for hasMember
			Reference reference = new Reference(observation.getId());
			referenceList.add(reference);
		}

		// Id
		initializeObservationId(syntaxScoreObservationobj);

		// Meta
		createMetaData(syntaxScoreObservationobj, ILS_PROFILE_SYNTAXSCORE);

		// Contained
		syntaxScoreObservationobj.setContained(resource);

		// Status
		setObservationStatus(syntaxScoreObservationobj);

		// Category
		createCodeableConceptCategory(syntaxScoreObservationobj, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Code
		createCodeableConcept(syntaxScoreObservationobj, TerminologyServer.CAD_SUMMARY_CODE_URL,
				Snomed.CODEABLE_CONCEPT_CODE_LESION_SUBSCORE,
				Snomed.CODEABLE_CONCEPT_DISPLAY_LESION_SUBSCORE);

		// Subject
		setObservationSubject(syntaxScoreObservationobj);

		// EffectiveDateTime
		setEffectiveDateTime(syntaxScoreObservationobj);

		// valuequantity
		Quantity quantity = new Quantity();
		SyntaxScoreCalculateController syntaxScoreCalculateController = new SyntaxScoreCalculateController();
		String st= syntaxScoreCalculateController.syntaxScoreObservation();
		BigDecimal score = new BigDecimal(st);
		quantity.setValue(score).setSystem(TerminologyServer.UNIT_OF_MEASURE_URL).setCode(TerminologyServer.SCORE);
		syntaxScoreObservationobj.setValue(quantity);

		// BodySite
		createBodySite(syntaxScoreObservationobj, Snomed.SNOMED_URL,
				Snomed.SNOMED_CODE_SYNATX_SCORE,
				Snomed.SNOMED_DISPLAY_SYNTAXSCORE);

		// HasMember
		syntaxScoreObservationobj.setHasMember(referenceList);

		String subsyntaxScorelesionTOXML = generateObservationXML(syntaxScoreObservationobj);

		return subsyntaxScorelesionTOXML;
	}
}