/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.create.bundle;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.Bundle.BundleType;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.PatientService;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.Meta;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/* @author Priyanka M & Ankita S */
public class InputBundle {

	public String createBundle(List<String> obsVariables, String contentType) throws ParseException {
		FhirContext ctx = FhirContext.forR4();
		Bundle bundle = new Bundle();

		// Set ID
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		bundle.setId(randomUUIDString);

		// Set meta
		Meta dominanceMeta = new Meta();
		List<CanonicalType> profile = new ArrayList<>();
		profile.add(new CanonicalType("https://www.fhir.philips.com"));
		dominanceMeta.setProfile(profile);
		bundle.setMeta(dominanceMeta);
		bundle.setType(BundleType.COLLECTION);

		// Set entry
		List<BundleEntryComponent> theEntry = new ArrayList<>();

		// Deserializing Syntaxscore obs and adding it to bundleEntryComponent
		IParser parser = ctx.newXmlParser();

		List<Observation> observationList = new ArrayList<>();
		List<Resource> resource = null;

		// Iterating Observation List
		for (String obsList : obsVariables) {
			Observation obsParsed = parser.parseResource(Observation.class, obsList);
			if (obsParsed.hasContained()) {
				obsParsed.setContained(resource);
			}
			observationList.add(obsParsed);
		}

		// Converting Observation list into bundle
		for (Observation observation : observationList) {
			String id = "";
			List<Reference> referenceList = new ArrayList<>();
			if (observation.hasHasMember()) {
				List<Reference> hasMemberList = observation.getHasMember();
				for (Reference hasMember : hasMemberList) {
					id = hasMember.getReference();
					Reference referenceID = new Reference(id);
					referenceList.add(referenceID);
					observation.setHasMember(referenceList);
				}
			}
		}

		//Get Patient
		PatientService patientService = new PatientService();
		Patient patient = patientService.getPatientInfo();
		Reference reference = new Reference(patient);
		//Add patient to entry
		BundleEntryComponent bundleEntryComponentPt = new BundleEntryComponent();
		bundleEntryComponentPt.setFullUrl(patient.getId());
		bundleEntryComponentPt.setResource(patient);
		theEntry.add(bundleEntryComponentPt);

		for (Observation observation : observationList) {
			BundleEntryComponent bundleEntryComponent = new BundleEntryComponent();
			// adding resource observation
			bundleEntryComponent.setFullUrl(observation.getId());
			observation.setSubject(reference);
			bundleEntryComponent.setResource(observation);
			theEntry.add(bundleEntryComponent);
		}

		bundle.setEntry(theEntry);
		String bundleString = "";
		if (contentType.equalsIgnoreCase("application/fhir+xml; fhirVersion=4.0")) {
			bundleString = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bundle);
		} else {
			bundleString = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(bundle);
		}
		return bundleString;
	}
}