/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscore.create.observation;

import java.util.ArrayList;
import java.util.List;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Observation.ObservationComponentComponent;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.AccessSyntaxScoreModel;
import com.philips.hsdp.research.p360.syntaxscore.constant.Snomed;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import com.philips.hsdp.research.p360.syntaxscore.create.ils.observation.ILSObservation;

/* @author Raj Kumar */
public class TrifurcationObservation extends ILSObservation {
	
	private static final String ILS_PROFILE_TRIFRICATION = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreTrifurcation";
	private static final String ILS_PROFILE_TRIFRICATION_SEGMENT  = "https://www.fhir.philips.com/4.0/CodeSystem/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/TrifurcationDiseasedSegmentInvolvedCodeSystem";
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	private Observation trifurcationObservationObj = new Observation();	
	private int value;
	
	public TrifurcationObservation(boolean present, int value) {
		super();
		accessSyntaxScoreModel.present = present;
		this.value = value;
	}

	/**
	 * Generates  Trifurcation observation
	 * @return observation XML string
	 */
	public String createObservation() {

		// Id
		initializeObservationId(trifurcationObservationObj);

		// Set Observation Status
		setObservationStatus(trifurcationObservationObj);

		// Meta
		createMetaData(trifurcationObservationObj, ILS_PROFILE_TRIFRICATION);

		// Code
		createCodeableConcept(trifurcationObservationObj, Snomed.SNOMED_URL,
				Snomed.SNOMED_CODE_TRIFURCATION,
				Snomed.SNOMED_DISPLAY_TRIFURCATION);

		// Category
		createCodeableConceptCategory(trifurcationObservationObj, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Subject
		setObservationSubject(trifurcationObservationObj);

		// EffectiveDateTime
		setEffectiveDateTime(trifurcationObservationObj);

		// Value Code-able Concept
		createValueCodeableConcept(trifurcationObservationObj, TerminologyServer.RADLEX_URL,
				accessSyntaxScoreModel.present ? TerminologyServer.RADLEX_PRESENT : TerminologyServer.RADLEX_ABSENT,
						accessSyntaxScoreModel.present ? TerminologyServer.PRESENT : TerminologyServer.ABSENT);

		if(this.value != 0) {
		//Component code 
		List<ObservationComponentComponent> componentComponents = new ArrayList<>();
		CodeableConcept componenetCode = new CodeableConcept();
		componenetCode.addCoding().setSystem(TerminologyServer.NCICB_URL).setCode(TerminologyServer.NCICB_TRIFURCATION_CODE)
		.setDisplay(TerminologyServer.NCICB_TRIFURCATION_DISPLAY);
		ObservationComponentComponent obsComponent = new ObservationComponentComponent();
		obsComponent.setCode(componenetCode);
		
		//setting display value
		String display = "";
		switch (this.value) {
        case 1:
        	display = "1 diseased segment involved";
            break;
        case 2:
        	display = "2 diseased segments involved";
            break;
        case 3:
        	display = "3 diseased segments involved";
            break;
        case 4:
        	display = "4 diseased segments involved";
            break;    
        default:
            System.out.println("no match with Trifrication segment number");
        }
		//Component Value CodeableConcept *******
		CodeableConcept codeableConcept = new CodeableConcept();
		codeableConcept.addCoding().setSystem(ILS_PROFILE_TRIFRICATION_SEGMENT).setCode(Integer.toString(this.value))
		.setDisplay(display);	
		obsComponent.setValue(codeableConcept);
		componentComponents.add(obsComponent);
		trifurcationObservationObj.setComponent(componentComponents);
		}
		
		// Genrate XML
		String trifurcationObservationXml = generateObservationXML(trifurcationObservationObj);
		return trifurcationObservationXml;

	}
}