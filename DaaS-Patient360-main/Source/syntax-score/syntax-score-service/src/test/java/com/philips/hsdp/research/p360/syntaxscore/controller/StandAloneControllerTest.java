/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.controller;

import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.text.ParseException;
import org.hl7.fhir.r4.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.BundleService;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.InputBundleService;
import com.philips.hsdp.research.p360.syntaxscore.create.bundle.OutputBundle;
import com.philips.hsdp.research.p360.syntaxscore.utility.ParseBundle;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/** @author Raj Kumar */
@SuppressWarnings("deprecation")
@TestMethodOrder(OrderAnnotation.class)
class StandAloneControllerTest {

	@InjectMocks
	InputBundleController inputBundleController;

	@InjectMocks
	StandAloneController standAloneController;

	@Mock
	BundleService bundleService;

	@Mock
	ParseBundle parseBundle;

	@Mock
	OutputBundle outputBundle;

	@Mock
	InputBundleService inputBundleService;

	static ResponseEntity<String> result;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@Order(1)
	void getPatientTest() throws IOException, ParseException {
		String jsonString = "{\"selected_dominance\":\"RIGHT\",\"lesion_profile\":[{\"lesion\":{\"number\":1,\"segments_list\":[{\"segment\":{\"number\":\"12\",\"name\":\"Intermediate/anterolateral\",\"description\":\"\"}}],\"totalocclusion\":true,\"first_totalocclusion_segment_number\":\"12\",\"is_totalocclusion_age_gt_3months\":\"YES\",\"blunt_stump\":false,\"bridging\":true,\"sidebranch_at_the_origin_of_occlusion\":\"NO\",\"severe_tortuosity\":true,\"heavy_calcification\":true,\"thrombus\":true,\"comments\":\"\"}}],\"diffusely_diseased_narrowed_segment\":{\"present\":true,\"diffusely_diseased_narrowed_segment_list\":[\"12b\"]}}";
		result = inputBundleController.getPatient(jsonString, "application/fhir+json; fhirVersion=4.0", "application/fhir+json; fhirVersion=4.0");
		assertNotNull(result);
	}

	@Test
	@Order(2)
	void syntaxScoreFromBundleTest() {
		String patientString = "{\"resourceType\":\"Patient\",\"id\":\"2c6aab56-eddb-4d25-a65f-357d6c24d354\",\"meta\":{\"profile\":[\"https://www.fhir.philips.com/4.0/StructureDefinition/common/resource/general/patient-v1/ILSPatient\",\"http://hl7.org/fhir/StructureDefinition/Patient\"]},\"name\":[{\"use\":\"official\",\"family\":\"Maxie\",\"given\":[\"HershelSchulistGutmann\"]}],\"telecom\":[{\"system\":\"phone\",\"value\":\"(407)898-3663\",\"use\":\"work\",\"rank\":1},{\"system\":\"phone\",\"value\":\"466-500-4296\",\"use\":\"mobile\",\"rank\":2}],\"gender\":\"male\",\"birthDate\":\"1980-08-12\"}";
		FhirContext ctx = FhirContext.forR4();
		IParser parser = ctx.newJsonParser();
		Patient patient = parser.parseResource(Patient.class, patientString);
		Mockito.when(parseBundle.getPatient(result.getBody(), "application/fhir+json; fhirVersion=4.0")).thenReturn(patient);
		ResponseEntity<String> bundle =	standAloneController.syntaxScoreFromBundle(result.getBody(), "application/fhir+json; fhirVersion=4.0", "application/fhir+json; fhirVersion=4.0");
		assertNotNull(bundle);	
	}

	@Test
	@Order(3)
	void syntaxScoreFromBundleXmlTest() {
		String patientString = "{\"resourceType\":\"Patient\",\"id\":\"2c6aab56-eddb-4d25-a65f-357d6c24d354\",\"meta\":{\"profile\":[\"https://www.fhir.philips.com/4.0/StructureDefinition/common/resource/general/patient-v1/ILSPatient\",\"http://hl7.org/fhir/StructureDefinition/Patient\"]},\"name\":[{\"use\":\"official\",\"family\":\"Maxie\",\"given\":[\"HershelSchulistGutmann\"]}],\"telecom\":[{\"system\":\"phone\",\"value\":\"(407)898-3663\",\"use\":\"work\",\"rank\":1},{\"system\":\"phone\",\"value\":\"466-500-4296\",\"use\":\"mobile\",\"rank\":2}],\"gender\":\"male\",\"birthDate\":\"1980-08-12\"}";
		FhirContext ctx = FhirContext.forR4();
		IParser parser = ctx.newJsonParser();
		Patient patient = parser.parseResource(Patient.class, patientString);
		Mockito.when(parseBundle.getPatient(result.getBody(), "application/fhir+xml; fhirVersion=4.0")).thenReturn(patient);
		ResponseEntity<String> bundle =	standAloneController.syntaxScoreFromBundle(result.getBody(), "application/fhir+xml; fhirVersion=4.0", "application/fhir+json; fhirVersion=4.0");
		assertNotNull(bundle);	
	}
}