/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import com.philips.hsdp.research.p360.syntaxscore.constant.Snomed;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import com.philips.hsdp.research.p360.syntaxscore.create.ils.observation.ILSObservation;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/* @author Raj Kumar */
public class LesionSubSyntaxScoreObservation extends ILSObservation{
	
	private static final String ILS_PROFILE_LESIONSS = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscore";
	private String lesionObservationlist = null;
	private Observation subsyntaxLesionTotalOcclusionObservation = new Observation();

	public LesionSubSyntaxScoreObservation(String lesionObservationlist) {
		super();
		this.lesionObservationlist = lesionObservationlist;
	}

	/**
	 * Generates  Lesion SubSyntaxScore observation
	 * @return observation XML string
	 */
	public String createObservation(){
		
		byte[] decoded = Base64.getUrlDecoder().decode(this.lesionObservationlist);
		String observationString = new String(decoded, StandardCharsets.UTF_8);
		observationString = observationString.replace(">,", ">\n,");
		
		List<String> myList = new ArrayList<>(Arrays.asList(observationString.split("\\n,")));
		List<Resource> resource = new ArrayList<>();
		List<Reference> referenceList = new ArrayList<>();
		FhirContext ctx = FhirContext.forR4();
		
		for(String obString: myList) {
			IParser parser = ctx.newXmlParser();
			Observation observation = parser.parseResource(Observation.class, obString);
			//adding to resource for contained
			resource.add(observation);			
			//adding to reference for hasMember
			Reference reference = new Reference(observation.getId());
			referenceList.add(reference);
		}

		// Id
		initializeObservationId(subsyntaxLesionTotalOcclusionObservation);

		// Meta
		createMetaData(subsyntaxLesionTotalOcclusionObservation, ILS_PROFILE_LESIONSS);

		//Contained
		subsyntaxLesionTotalOcclusionObservation.setContained(resource);

		//Status
		setObservationStatus(subsyntaxLesionTotalOcclusionObservation);

		// Category
		createCodeableConceptCategory(subsyntaxLesionTotalOcclusionObservation, TerminologyServer.TERIMOLOGY_URL,
				Snomed.CATEGORY_CONCEPT_CODE_LESION_SUBSCORE, Snomed.CATEGORY_DISPLAY_LESION_SUBSCORE);

		// Code
		createCodeableConcept(subsyntaxLesionTotalOcclusionObservation, TerminologyServer.CAD_SUMMARY_CODE_URL,
				Snomed.CODEABLE_CONCEPT_CODE_LESION_SUBSCORE,
				Snomed.CODEABLE_CONCEPT_DISPLAY_LESION_SUBSCORE);

		// Subject
		setObservationSubject(subsyntaxLesionTotalOcclusionObservation);

		// EffectiveDateTime
		setEffectiveDateTime(subsyntaxLesionTotalOcclusionObservation);

		//valuequantity 
		Quantity quantity = new Quantity();
		quantity.setValue(0).setSystem(TerminologyServer.UNIT_OF_MEASURE_URL).setCode(TerminologyServer.SCORE); 
		subsyntaxLesionTotalOcclusionObservation.setValue(quantity);

		//HasMember
		subsyntaxLesionTotalOcclusionObservation.setHasMember(referenceList);
		String subsyntaxScorelesionTOXML = generateObservationXML(subsyntaxLesionTotalOcclusionObservation);
		return subsyntaxScorelesionTOXML;
	}
}