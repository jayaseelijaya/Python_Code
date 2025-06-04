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
import java.util.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/* @author Sunil Kumar */
@Service
public class UploadSingleObservationService {

	/**
	 * This function is to Upload file of json string as Multipart file and convert
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
	public String convert(MultipartFile file) throws IOException {
		InputStream inputStream = null;
		inputStream = file.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonResponse = mapper.readTree(inputStream);
		String jsonString = jsonResponse.toString();
		return Base64.getUrlEncoder().encodeToString(jsonString.getBytes());
	}
}