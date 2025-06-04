/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent;
import org.hl7.fhir.r4.model.Bundle.BundleType;
import org.hl7.fhir.r4.model.Bundle.HTTPVerb;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.Meta;
import org.hl7.fhir.r4.model.Observation;

import com.philips.hsdp.research.p360.syntaxscore.constant.ObservationProfilesContants;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/** @author Raj Kumar */
public class OutputBundle {
	private static final Logger LOG = Logger.getLogger(OutputBundle.class.getName());

	/**
	 * Generates bundle of transaction type
	 * @param subScoreObsList
	 * @param observationList
	 * @return
	 */
	public Bundle createBundle(List<String> subScoreObsList, List<Observation> observationList) {
		FhirContext ctx = FhirContext.forR4();
		Bundle bundle = new Bundle();

		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		bundle.setId(randomUUIDString);

		Meta dominanceMeta = new Meta();
		List<CanonicalType> profile = new ArrayList<>();
		profile.add(new CanonicalType("https://www.fhir.philips.com"));
		dominanceMeta.setProfile(profile);
		bundle.setMeta(dominanceMeta);

		bundle.setType(BundleType.TRANSACTION);

		List<BundleEntryComponent> theEntry = new ArrayList<>();
		BundleEntryRequestComponent bundleEntryRequestComponent = new BundleEntryRequestComponent();

		//Deserializing Syntaxscore obs and adding it to bundleEntryComponent
		IParser parser = ctx.newXmlParser();
		List<Observation> parsedList = new ArrayList<>();
		for(String observation : subScoreObsList) {
			Observation parsedObs = parser.parseResource(Observation.class, observation);
			parsedList.add(parsedObs);
		}
		
		for(Observation observation : observationList) {
			String profileUrl = observation.getMeta().getProfile().get(0).getValue();
			if(!profileUrl.equalsIgnoreCase(ObservationProfilesContants.LESION_PROFILE) && !profileUrl.equalsIgnoreCase(ObservationProfilesContants.DIFUSED_PROFILE)
					&& !profileUrl.equalsIgnoreCase(ObservationProfilesContants.DOMINANCE_PROFILE)) {
				parsedList.add(observation);
			}
		}
		BundleEntryComponent bundleEntryComponent = new BundleEntryComponent();

		//For request-method
		HTTPVerb value = HTTPVerb.POST;
		bundleEntryRequestComponent.setMethod(value);
		bundleEntryRequestComponent.setUrl("Observation");
		bundleEntryComponent.setRequest(bundleEntryRequestComponent);
		for (Observation observation : parsedList) {
			BundleEntryComponent bundleEntryComp = new BundleEntryComponent();
			//adding resource observation
			bundleEntryComp.setFullUrl(observation.getId());
			bundleEntryComp.setResource(observation);
			//For request-method
			bundleEntryComp.setRequest(bundleEntryRequestComponent);
			theEntry.add(bundleEntryComp);
		}
		bundle.setEntry(theEntry);
		LOG.info("**bundle created**");
		return bundle;
	}
}