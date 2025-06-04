/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.create.bundle;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/** @author Raj Kumar */
@SuppressWarnings("deprecation")
class BundleTest {

	@InjectMocks
	InputBundle inputBundle;

	@InjectMocks
	OutputBundle outputBundle;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}

	String observationsString = "<Observation\r\n"
			+ "				xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "				<id value=\"5deeea04-b8f7-454e-bcf8-9778700c3c49\"/>\r\n"
			+ "				<meta>\r\n"
			+ "					<profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscore\"/>\r\n"
			+ "				</meta>\r\n"
			+ "				<effectiveDateTime value=\"2022-10-14T15:19:20+05:30\"/>\r\n"
			+ "				<valueQuantity>\r\n"
			+ "					<value value=\"7\"/>\r\n"
			+ "					<system value=\"http://unitsofmeasure.org\"/>\r\n"
			+ "					<code value=\"{score}\"/>\r\n"
			+ "				</valueQuantity>\r\n"
			+ "				<hasMember>\r\n"
			+ "					<reference value=\"Observation/62a824e9-b156-4e0e-b5e7-10c4851a5d00\"/>\r\n"
			+ "				</hasMember>\r\n"
			+ "			</Observation>,\r\n"
			+ "            <Observation\r\n"
			+ "				xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "				<id value=\"62a824e9-b156-4e0e-b5e7-10c4851a5d00\"/>\r\n"
			+ "				<meta>\r\n"
			+ "					<profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreThrombus\"/>\r\n"
			+ "				</meta>\r\n"
			+ "			</Observation>,\r\n"
			+ "            <Observation\r\n"
			+ "				xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "				<id value=\"a1fc1020-42c0-4681-9b1b-14e2d6ec59b7\"/>\r\n"
			+ "				<meta>\r\n"
			+ "					<profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscoreTotalOcclusion/LesionSyntaxSubscoreTotalOcclusion\"/>\r\n"
			+ "				</meta>\r\n"
			+ "				<subject>\r\n"
			+ "					<reference value=\"Patient/ils-test-CADPatient\"/>\r\n"
			+ "				</subject>\r\n"
			+ "				<hasMember>\r\n"
			+ "					<reference value=\"Observation/a5053815-d23d-436d-8384-61a85242a5ca\"/>\r\n"
			+ "				</hasMember>\r\n"
			+ "			</Observation>,\r\n"
			+ "            <Observation\r\n"
			+ "				xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "				<id value=\"a5053815-d23d-436d-8384-61a85242a5ca\"/>\r\n"
			+ "				<meta>\r\n"
			+ "					<profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscoreTotalOcclusion/TotalOcclusionBridging\"/>\r\n"
			+ "				</meta>\r\n"
			+ "			</Observation>,\r\n"
			+ "            <Observation\r\n"
			+ "				xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "				<id value=\"72e0d829-ac68-485b-9e60-3e604dda10d5\"/>\r\n"
			+ "				<meta>\r\n"
			+ "					<profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/diffuseDiseaseSmallVesselsSyntaxSubscore/DiffuseDiseaseSmallVesselsSyntaxSubscore\"/>\r\n"
			+ "				</meta>\r\n"
			+ "				<hasMember>\r\n"
			+ "					<reference value=\"Observation/30e15327-6f55-4298-9bfc-ff4211502bca\"/>\r\n"
			+ "				</hasMember>\r\n"
			+ "			</Observation>,\r\n"
			+ "            <Observation\r\n"
			+ "            xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "            <id value=\"30e15327-6f55-4298-9bfc-ff4211502bca\"/>\r\n"
			+ "            <meta>\r\n"
			+ "                <profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreSegment\"/>\r\n"
			+ "            </meta>\r\n"
			+ "        </Observation>";

	List<String> observationListString = new ArrayList<String>(Arrays.asList(observationsString.split(",")));

	@Test
	void createBundleInputTest() throws ParseException {
		String result = inputBundle.createBundle(observationListString, "application/fhir+json; fhirVersion=4.0");
		assertNotNull(result);
	}

	@Test
	void createBundleOutputTest() {
		List<Observation> observationList = new ArrayList<>();
		FhirContext ctx = FhirContext.forR4();
		IParser parser = ctx.newXmlParser();
		for(String observation : observationListString) {
			Observation parsed = parser.parseResource(Observation.class, observation);
			observationList.add(parsed);
		}

		String patientString = "{\"resourceType\":\"Patient\",\"id\":\"b9613196-2ba4-4699-bd7e-1a3457634cc8\",\"meta\":{\"profile\":[\"https://www.fhir.philips.com/4.0/StructureDefinition/common/resource/general/patient-v1/ILSPatient\",\"http://hl7.org/fhir/StructureDefinition/Patient\"]},\"name\":[{\"use\":\"official\",\"family\":\"Romana\",\"given\":[\"ErleneGloverCrona\"]}],\"telecom\":[{\"system\":\"phone\",\"value\":\"767-031-9524\",\"use\":\"work\",\"rank\":1},{\"system\":\"phone\",\"value\":\"641-705-1601\",\"use\":\"mobile\",\"rank\":2}],\"gender\":\"male\"}";
		parser = ctx.newJsonParser();
		Patient parsedPatient = parser.parseResource(Patient.class, patientString);
		Bundle result = outputBundle.createBundle(observationListString, observationList, parsedPatient);
		assertEquals("Patient/b9613196-2ba4-4699-bd7e-1a3457634cc8", result.getEntry().get(0).getResource().getId());
	}
}