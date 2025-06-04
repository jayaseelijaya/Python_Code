/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.controller;

import java.text.ParseException;
import org.hl7.fhir.r4.model.Patient;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.PatientService;

/** @author Raj Kumar */
@SuppressWarnings("deprecation")
@TestMethodOrder(OrderAnnotation.class)
class PatientControllerTest {
	
	@InjectMocks
	PatientController controller;
	
	@InjectMocks
	PatientService patientService;
	
	@Mock
	PatientService service;
	
	static Patient patient;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Order(1) 
	void getPatientInfoTest() throws ParseException  {
		patient = patientService.getPatientInfo();
		Assert.assertNotNull(patient);
	}
	
	@Test
	@Order(2) 
	void getPatientTest() throws ParseException  {
        Mockito.when(service.getPatientInfo()).thenReturn(patient);
		String results = controller.getPatient();
		Assert.assertNotNull(results);
	}
}