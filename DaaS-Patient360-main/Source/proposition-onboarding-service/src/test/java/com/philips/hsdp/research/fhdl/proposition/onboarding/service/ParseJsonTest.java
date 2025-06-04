/*
  * (C) Koninklijke Philips Electronics N.V. 2022
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  */

package com.philips.hsdp.research.fhdl.proposition.onboarding.service;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/* @author Srinivasa Reddy Bijjam*/
@RunWith(MockitoJUnitRunner.class)
 class ParseJsonTest {

	@InjectMocks
	ParseJson parseJson;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("This Test case is to convert json data")
	 void convertJson_Test() throws IOException {
		String request = "{\r\n" + "    \"Proposition Name\": \"PD-DID-P3\",\r\n"
				+ "    \"Profile Name\": \"syntaxscore\",\r\n" + "    \"Organization Name\": \"hospital\",\r\n"
				+ "    \"Department Name\": \"cardiology\",\r\n"
				+ "    \"Algorithm Endpoint\": \"https: //www.hospital-a.com/algo/syntaxScore\",\r\n"
				+ "    \"Proposition Tags\": \"orgId, profileName, propositionId\",\r\n"
				+ "    \"Profile Structure File\": \"s3://daas-profile-json/SyntaxScore.structuredefinition.json\"\r\n"
				+ "}";
		ObjectMapper map = new ObjectMapper();
		JsonNode node = map.readTree(request);
		parseJson.convertJson(node);
	}

	@Test
	@DisplayName("This Test case is to generate RandomUUID")
	 void createUUid_Test() {
		parseJson.createUUid();
	}
}