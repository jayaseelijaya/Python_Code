/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.controller;

import java.text.ParseException;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.PatientService;
import ca.uhn.fhir.context.FhirContext;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/* @author Raj Kumar */
@RestController
@SecurityRequirement(name = "SyntaxScore API")
public class PatientController {
	
	@Autowired
	PatientService patientService;

	/**
	 * This function is used to generate Observation for syntaxscore-patient
	 * @param encodedString2 
	 * 
	 * @inheritDoc : override super class PatientController.
	 * @param String : patientInfoJson
	 * 
	 * @return String patientResource
	 * @throws ParseException 
	 */
	@Hidden
	@PostMapping(value = "/syntaxscore-patient")
	@Operation(summary = "Generate Observation for syntaxscore-patient")
	String getPatient() throws ParseException {
		
		Patient patient = patientService.getPatientInfo();	
		FhirContext ctx = FhirContext.forR4();
		return ctx.newXmlParser().encodeResourceToString(patient);
	}
}