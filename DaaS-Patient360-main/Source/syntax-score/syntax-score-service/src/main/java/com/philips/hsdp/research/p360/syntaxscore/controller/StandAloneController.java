/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscore.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.BundleService;
import com.philips.hsdp.research.p360.syntaxscore.constant.BundleConstants;
import com.philips.hsdp.research.p360.syntaxscore.create.bundle.OutputBundle;
import com.philips.hsdp.research.p360.syntaxscore.utility.ParseBundle;
import ca.uhn.fhir.context.FhirContext;
import io.swagger.v3.oas.annotations.Operation;

/** @author Raj Kumar */
@RestController
public class StandAloneController {
	
	@Autowired
	BundleService bundleService;

	@Autowired
	ParseBundle parseBundle;
	
	/**
	 * Creates Syntax score bundle of transaction type using the observations from the collection bundle 
	 * @param bundleInput
	 * @param contentType
	 * @param accept
	 * @return Bundle of transaction type
	 * @throws ParseException 
	 */
	@PostMapping(value = "/syntax-score-calculator", headers = {"api-version=1" })
	@Operation(summary = "Generate final syntaxScore observation with Score")
	ResponseEntity<String>  syntaxScoreFromBundle(@RequestBody String bundleInput, @RequestHeader("Content-Type") String contentType, 
			@RequestHeader("Accept") String accept)
	{
			//get all the observations from bundle
			List<Observation> fullObservationList = new ArrayList<>();
			fullObservationList = parseBundle.getAllObservation(bundleInput, contentType);

			//get all the observations from bundle
			Patient patientResource = parseBundle.getPatient(bundleInput, contentType);
			
			//Get Dominance, Lesion subscore, Difussely diseased subscore observation
			Map<String, String> syntaxScoreObsList =  new HashMap<>();
			syntaxScoreObsList = parseBundle.getObservationsForSyntaxScore(fullObservationList);		

			//Service to get final obs list and syntaxScore
			List<String> subScoreObsList = bundleService.getfinalSyntaxScoreObsList(fullObservationList, syntaxScoreObsList);

			//Create Bundle
			OutputBundle syntaxScoreBundle =  new OutputBundle();
			Bundle bundle = syntaxScoreBundle.createBundle(subScoreObsList, fullObservationList, patientResource);
			String bundleString = "";
			FhirContext ctx = FhirContext.forR4();
			if(contentType.equalsIgnoreCase(BundleConstants.CONTENT_TYPE_XML)) {
				bundleString = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bundle);	
			}else {
				bundleString = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(bundle);	
			}
			return new ResponseEntity<>(bundleString, HttpStatus.OK);		
	}
}