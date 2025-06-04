/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscore.create.observation;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Observation.ObservationComponentComponent;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.AccessSyntaxScoreModel;
import com.philips.hsdp.research.p360.syntaxscore.constant.Snomed;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import com.philips.hsdp.research.p360.syntaxscore.create.ils.observation.ILSObservation;
import com.philips.hsdp.research.p360.syntaxscore.datamodel.enums.BifurcationMedina;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/* @author Raj Kumar */
public class BifurcationObservation extends ILSObservation {

	private static final String ILS_PROFILE_BIFURCATION = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreBifurcation";	
	private static final String ILS_BIFURCATION_MEDINA = "https://www.fhir.philips.com/4.0/CodeSystem/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/BifurcationMedinaTypeCodeSystem";
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	private Observation bifurcationObservationobj = new Observation();
	private BifurcationMedina value;
	private String angulationObsEncoded = null;

	public BifurcationObservation(boolean present, BifurcationMedina value, String encodedString) {
		super();
		accessSyntaxScoreModel.present = present;
		this.value = value;
		this.angulationObsEncoded = encodedString;
	}

	/**
	 * Generates Bifurcation observation
	 * @return observation XML string
	 */
	public String createObservation() {

		byte[] decoded = Base64.getUrlDecoder().decode(this.angulationObsEncoded);
		String angulationObs = new String(decoded, StandardCharsets.UTF_8);
		
		List<Resource> resource = new ArrayList<>();
		List<Reference> referenceList = new ArrayList<>();
		FhirContext ctx = FhirContext.forR4();

		if(!angulationObs.equalsIgnoreCase("None")) {
		IParser parser = ctx.newXmlParser();
		Observation observation = parser.parseResource(Observation.class, angulationObs);
		//adding to resource for contained
		resource.add(observation);			
		//adding to reference for hasMember
		Reference reference = new Reference(observation.getId());
		referenceList.add(reference);
		}
		// Id
		initializeObservationId(bifurcationObservationobj);

		// Meta
		createMetaData(bifurcationObservationobj, ILS_PROFILE_BIFURCATION);
		
		//Contained
		bifurcationObservationobj.setContained(resource);

		// Status
		setObservationStatus(bifurcationObservationobj);

		// Category
		createCodeableConceptCategory(bifurcationObservationobj, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Code
		createCodeableConcept(bifurcationObservationobj, Snomed.SNOMED_URL,
				Snomed.SNOMED_CODE_BIFURCATION,
				Snomed.SNOMED_DISPLAY_BIFURCATION);

		// Subject
		setObservationSubject(bifurcationObservationobj);

		// EffectiveDateTime
		setEffectiveDateTime(bifurcationObservationobj);

		// Value Code-able Concept
		createValueCodeableConcept(bifurcationObservationobj, TerminologyServer.RADLEX_URL,
				accessSyntaxScoreModel.present ? TerminologyServer.RADLEX_PRESENT : TerminologyServer.RADLEX_ABSENT,
						accessSyntaxScoreModel.present ? TerminologyServer.PRESENT : TerminologyServer.ABSENT);

		//HasMember
		bifurcationObservationobj.setHasMember(referenceList);
		
		if(accessSyntaxScoreModel.present) {
			//Component code *******
			List<ObservationComponentComponent> componentComponents = new ArrayList<>();
			CodeableConcept componenetCode = new CodeableConcept();
			componenetCode.addCoding().setSystem(Snomed.SNOMED_URL).setCode(Snomed.CODEABLE_CONCEPT_CODE_BIFURCATION_MEDINA)
			.setDisplay(Snomed.CODEABLE_CONCEPT_DISPLAY_BIFURCATION_MEDINA);
			ObservationComponentComponent obsComponent = new ObservationComponentComponent();
			obsComponent.setCode(componenetCode);

			//setting display value
			String code = "";
			switch (this.value.getValue()) {
			case "Medina 1,0,0":
				code = "Type-A";
				break;
			case "Medina 0,1,0":
				code = "Type-B";
				break;
			case "Medina 1,1,0":
				code = "Type-C";
				break;
			case "Medina 1,1,1":
				code = "Type-D";
				break;    
			case "Medina 0,0,1":
				code = "Type-E";
				break; 
			case "Medina 1,0,1":
				code = "Type-F";
				break; 
			case "Medina 0,1,1":
				code = "Type-G";
				break; 
			default:
				System.out.println("no match with Trifrication segment number");
			}
			//Component Value CodeableConcept *******
			CodeableConcept codeableConcept = new CodeableConcept();
			codeableConcept.addCoding().setSystem(ILS_BIFURCATION_MEDINA).setCode(code)
			.setDisplay(this.value.getValue());	
			obsComponent.setValue(codeableConcept);
			componentComponents.add(obsComponent);
			bifurcationObservationobj.setComponent(componentComponents);
		}

		// Generate XML
		String bifurcationObservationXml = generateObservationXML(bifurcationObservationobj);
		return bifurcationObservationXml;
	}

}