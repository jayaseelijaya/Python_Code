/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.hl7.fhir.r4.model.Observation;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/* @author Sunil Kumar */
@Service
public class UploadMultipleFilesService {

	/**
	 * This function is to Upload file of Observation as Multipart file and convert
	 * it in List
	 * 
	 * @param MultipartFile[]                 file :
	 * @param
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user
	 *                                        data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return void
	 */
	public String convert(MultipartFile[] file) throws IOException {
		InputStream inputStream = null;
		FhirContext ctx = FhirContext.forR4();
		String observationXml = null;
		List<String> myList = new ArrayList<>();
		for (MultipartFile file1 : file) {
			inputStream = file1.getInputStream();
			IParser parser = ctx.newXmlParser();
			Observation parsed = parser.parseResource(Observation.class, inputStream);
			observationXml = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(parsed);
			myList.add(observationXml);
		}
		String listString = String.join(", ", myList);
		return Base64.getUrlEncoder().encodeToString(listString.getBytes());
	}

	/**
	 * This function is to Upload file of json segment as Multipart file and convert
	 * it in List
	 * 
	 * @param MultipartFile[]                 file :
	 * @param
	 * @param SyntaxScoreCodeableConceptModel : to get the mapping data from user
	 *                                        data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return void
	 */
	public String convertJson(MultipartFile[] file) throws IOException {
		InputStream inputStream = null;
		String jsonString = null;
		List<String> myList = new ArrayList<>();
		for (MultipartFile file1 : file) {
			inputStream = file1.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonResponse = mapper.readTree(inputStream);
			jsonString = jsonResponse.toString();
			myList.add(jsonString);
		}
		String listString = String.join(", ", myList);
		return Base64.getUrlEncoder().encodeToString(listString.getBytes());
	}
}