/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.create.ils.observation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Meta;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Observation.ObservationComponentComponent;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import com.philips.hsdp.research.p360.syntaxscore.constant.Snomed;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import ca.uhn.fhir.context.FhirContext;

/**
 * 
 * @author Raj Kumar
 *
 */
public abstract class ILSObservation {

	public void initializeObservationId(Observation objObservation) {
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		objObservation.setId(randomUUIDString);
	}

	public void setObservationStatus(Observation objObservation) {
		objObservation.setStatus(Observation.ObservationStatus.REGISTERED);
	}

	public void createMetaData(Observation objObservation, String lesionType) {
		Meta dominanceMeta = new Meta();
		List<CanonicalType> profile = new ArrayList<>();
		profile.add(new CanonicalType(lesionType));
		dominanceMeta.setProfile(profile);
		objObservation.setMeta(dominanceMeta);
	}

	public void createCodeableConcept(Observation objObservation, String codeableConceptSystemUrl,
			String codeableConceptCode, String codeableConceptDisplay) {
		CodeableConcept codeableConcept = new CodeableConcept();
		codeableConcept.addCoding().setSystem(codeableConceptSystemUrl).setCode(codeableConceptCode)
				.setDisplay(codeableConceptDisplay);
		objObservation.setCode(codeableConcept);
	}

	public void createCodeableConceptCategory(Observation objObservation, String codeableConceptSystemCategoryURI,
			String codeableConceptCategoryCode, String codeableConceptCategoryDisplay) {
		ArrayList<CodeableConcept> codeableConcepts = new ArrayList<>();
		CodeableConcept category = new CodeableConcept();
		category.addCoding().setSystem(codeableConceptSystemCategoryURI).setCode(codeableConceptCategoryCode)
				.setDisplay(codeableConceptCategoryDisplay);
		codeableConcepts.add(category);
		objObservation.setCategory(codeableConcepts);
	}

	public void createValueCodeableConcept(Observation objObservation, String codeableConceptURI,
			String codeableConceptCode, String codeableConceptDisplay) {
		CodeableConcept valueConcept = new CodeableConcept();
		valueConcept.addCoding().setSystem(codeableConceptURI).setCode(codeableConceptCode)
				.setDisplay(codeableConceptDisplay);
		objObservation.setValue(valueConcept);
	}

	public void createBodySite(Observation objObservation, String bodySiteURI, String bodySiteCode,
			String bodySiteDisplay) {
		CodeableConcept bodySite = new CodeableConcept();
		bodySite.addCoding().setSystem(bodySiteURI).setCode(bodySiteCode).setDisplay(bodySiteDisplay);
		objObservation.setBodySite(bodySite);
	}

	public void setEffectiveDateTime(Observation objObservation) {
		objObservation.setEffective(DateTimeType.now());
	}

	public void setObservationSubject(Observation objObservation) {
		objObservation.setSubject(new Reference().setReference(Snomed.OBSERVATION_SUBJECT_REFERENCE));
	}

	public String generateObservationXML(Observation objObservation) {
		FhirContext ctx = FhirContext.forR4();
		return ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(objObservation);
	}

	public String generateObservationJSON(Observation objObservation) {
		FhirContext ctx = FhirContext.forR4();
		return ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(objObservation);
	}

	public void createComponentCode(Observation objObservation, String codeURI, String codeCode, String codeDisplay) {
		// Component code
		List<ObservationComponentComponent> componentComponents = new ArrayList<>();
		CodeableConcept componenetCode = new CodeableConcept();
		componenetCode.addCoding().setSystem(codeURI).setCode(codeCode).setDisplay(codeDisplay);
		ObservationComponentComponent obsComponent = new ObservationComponentComponent();
		obsComponent.setCode(componenetCode);

		// Component Value Quantity
		Quantity quantity = new Quantity();
		quantity.setValue(0).setSystem(TerminologyServer.UNIT_OF_MEASURE_URL).setCode(TerminologyServer.SCORE);
		obsComponent.setValue(quantity);
		componentComponents.add(obsComponent);
		objObservation.setComponent(componentComponents);
	}
}