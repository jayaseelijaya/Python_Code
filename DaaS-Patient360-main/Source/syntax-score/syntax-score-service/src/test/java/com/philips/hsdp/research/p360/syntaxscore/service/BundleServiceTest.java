/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hl7.fhir.r4.model.Observation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.BundleService;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.BundleSyntaxScoreObservation;
import com.philips.hsdp.research.p360.syntaxscore.utility.ParseBundle;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/** @author Raj Kumar */
@SuppressWarnings("deprecation")
class BundleServiceTest {

	@InjectMocks
	BundleService bundleService;

	@Mock
	ParseBundle parseBundle;
	
	@Mock
	BundleSyntaxScoreObservation bundleSyntaxScoreObservation;
	
	String observationString = "<Observation xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "   <id value=\"b3917c0c-9949-4d9d-9c5c-d1cd11d6ac4a\"/>\r\n"
			+ "   <meta>\r\n"
			+ "      <profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/CoronaryArteryDominanceObservation\"/>\r\n"
			+ "   </meta>\r\n"
			+ "   <status value=\"registered\"/>\r\n"
			+ "   <category>\r\n"
			+ "      <coding>\r\n"
			+ "         <system value=\"http://terminology.hl7.org/CodeSystem/observation-category\"/>\r\n"
			+ "         <code value=\"survey\"/>\r\n"
			+ "         <display value=\"survey\"/>\r\n"
			+ "      </coding>\r\n"
			+ "   </category>\r\n"
			+ "   <code>\r\n"
			+ "      <coding>\r\n"
			+ "         <system value=\"http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl\"/>\r\n"
			+ "         <code value=\"C100086\"/>\r\n"
			+ "         <display value=\"Coronary Artery Dominance\"/>\r\n"
			+ "      </coding>\r\n"
			+ "   </code>\r\n"
			+ "   <subject>\r\n"
			+ "      <reference value=\"Patient/2c6aab56-eddb-4d25-a65f-357d6c24d354\"/>\r\n"
			+ "   </subject>\r\n"
			+ "   <effectiveDateTime value=\"2022-11-28T10:17:13+05:30\"/>\r\n"
			+ "   <valueCodeableConcept>\r\n"
			+ "      <coding>\r\n"
			+ "         <system value=\"http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl\"/>\r\n"
			+ "         <code value=\"C99942\"/>\r\n"
			+ "         <display value=\"Coronary Artery Right Dominance\"/>\r\n"
			+ "      </coding>\r\n"
			+ "   </valueCodeableConcept>\r\n"
			+ "</Observation>";

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getfinalSyntaxScoreObsListTest() {
		List<Observation> observationList = new ArrayList<>();
		List<String> observationListString = new ArrayList<>();
		Map<String, String> syntaxScoreObsMap = new HashMap<>();
		syntaxScoreObsMap.put("Dominace", observationString);
		FhirContext ctx = FhirContext.forR4();
		IParser parser = ctx.newXmlParser();
		Observation parsed = parser.parseResource(Observation.class, observationString);
		observationList.add(parsed);
		observationListString.add(observationString);
        Mockito.when(parseBundle.getDiffuselyDiseasedScore(observationListString)).thenReturn("10");
        Mockito.when(bundleSyntaxScoreObservation.createObservation()).thenReturn(observationString);
        List<String> finalObservationList = bundleService.getfinalSyntaxScoreObsList(observationList, syntaxScoreObsMap);
        assertEquals(2, finalObservationList.size());
	}
}