/*
  * (C) Koninklijke Philips Electronics N.V. 2022
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  */

package com.philips.hsdp.research.fhdl.proposition.onboarding.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.glue.AWSGlue;
import com.amazonaws.services.glue.model.CreateRegistryRequest;
import com.amazonaws.services.glue.model.CreateRegistryResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.philips.hsdp.research.fhdl.proposition.onboarding.service.KafkaService;
import com.philips.hsdp.research.fhdl.proposition.onboarding.service.MdmData;
import com.philips.hsdp.research.fhdl.proposition.onboarding.service.ParseJson;
import com.philips.hsdp.research.fhdl.proposition.onboarding.service.S3BucketStorageService;

/* @author Srinivasa Reddy Bijjam*/
@RunWith(MockitoJUnitRunner.class)
class OnBoardingControllerTest {

	@Mock
	ParseJson uploadMultipleFilesService;

	@Mock
	S3BucketStorageService service;

	@Mock
	KafkaService kafkaService;

	@Mock
	private AWSGlue awsGlueClient;

	@Mock
	private DynamoDBMapper dynamoDbMapper;

	@Mock
	CreateRegistryResult createRegistryResult;

	@Mock
	private MdmData mdmData;

	@InjectMocks
	OnBoardingController onBoardingController;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("This Test case is to get the responseData of the loadMessage()")
	void loadMessage_Test()
			throws AmazonServiceException, AmazonClientException, IOException, URISyntaxException, JSONException {
		String inputData = "{\r\n" + "    \"Proposition Name\": \"PD-DID-P3\",\r\n"
				+ "    \"Profile Name\": \"syntaxscore\",\r\n" + "    \"Organization Name\": \"hospital\",\r\n"
				+ "    \"Department Name\": \"cardiology\",\r\n"
				+ "    \"Algorithm Endpoint\": \"https: //www.hospital-a.com/algo/syntaxScore\",\r\n"
				+ "    \"Proposition Tags\": \"orgId, profileName, propositionId\",\r\n"
				+ "    \"Profile Structure File\": \"s3://daas-profile-json/SyntaxScore.structuredefinition.json\"\r\n"
				+ "}";

		String request = "{\r\n" + "    \"propositionName\": \"PD-DID-P3\",\r\n"
				+ "    \"profileName\": \"syntaxscore\",\r\n" + "    \"organizationName\": \"hospital\",\r\n"
				+ "    \"departmentName\": \"cardiology\",\r\n"
				+ "    \"algorithmEndpoint\": \"https: //www.hospital-a.com/algo/syntaxScore\",\r\n"
				+ "    \"propositionTags\": \"orgId, profileName, propositionId\",\r\n"
				+ "    \"profileStructure\": \"s3://daas-profile-json/SyntaxScore.structuredefinition.json\"\r\n" + "}";

		ObjectMapper map = new ObjectMapper();
		JsonNode node = map.readTree(inputData);
		JSONObject convertedObject = new JSONObject(request);
		Mockito.when(uploadMultipleFilesService.convertJson(node)).thenReturn(convertedObject);
		Mockito.when(mdmData.getMdmData()).thenReturn(new HashMap<String, String>());
		Mockito.when(service.getProfileStructureContent(Mockito.anyString())).thenReturn("Test");
		Mockito.when(awsGlueClient.createRegistry(Mockito.any(CreateRegistryRequest.class)))
				.thenReturn(createRegistryResult);
		assertNotNull(onBoardingController.loadMessage(node, "accept"));
	}

	@Test
	@DisplayName("This Test case is to get the indexName of the profileMap")
	void loadMessage_IndexTest()
	throws AmazonServiceException, AmazonClientException, IOException, URISyntaxException, JSONException {
		String inputData = "{\r\n" + "    \"Proposition Name\": \"PD-DID-P3\",\r\n"
				+ "    \"Profile Name\": \"syntaxscore\",\r\n" + "    \"Organization Name\": \"hospital\",\r\n"
				+ "    \"Department Name\": \"cardiology\",\r\n"
				+ "    \"Algorithm Endpoint\": \"https: //www.hospital-a.com/algo/syntaxScore\",\r\n"
				+ "    \"Proposition Tags\": \"orgId, profileName, propositionId\",\r\n"
				+ "    \"Profile Structure File\": \"s3://daas-profile-json/SyntaxScore.structuredefinition.json\"\r\n"
				+ "}";

		String request = "{\r\n" + "    \"propositionName\": \"PD-DID-P3\",\r\n"
				+ "    \"profileName\": \"syntaxscore\",\r\n" + "    \"organizationName\": \"hospital\",\r\n"
				+ "    \"departmentName\": \"cardiology\",\r\n"
				+ "    \"algorithmEndpoint\": \"https: //www.hospital-a.com/algo/syntaxScore\",\r\n"
				+ "    \"propositionTags\": \"orgId, profileName, propositionId\",\r\n"
				+ "    \"profileStructure\": \"s3://daas-profile-json/SyntaxScore.structuredefinition.json\"\r\n" + "}";

		ObjectMapper map = new ObjectMapper();
		JsonNode node = map.readTree(inputData);
		JSONObject convertedObject = new JSONObject(request);
		Mockito.when(uploadMultipleFilesService.convertJson(node)).thenReturn(convertedObject);
		Map<String, String> map1 = new HashMap<>();
		map1.put("profileName", "syntaxscore");

		Mockito.when(mdmData.getMdmData()).thenReturn(map1);
		Mockito.when(service.getProfileStructureContent(Mockito.anyString())).thenReturn("Test");
		Mockito.when(awsGlueClient.createRegistry(Mockito.any(CreateRegistryRequest.class)))
				.thenReturn(createRegistryResult);
		assertNotNull(onBoardingController.loadMessage(node, "accept"));
	}

	@Test
	@DisplayName("This Test case is to store the data into GlueRegistry of the storeSchemaInGlueRegistry()")
	void storeSchemaInGlueRegistry_Test() throws IOException, URISyntaxException {
		String registryName = "syntaxscore";
		String profileStructureUri = "https: //www.hospital-a.com/algo/syntaxScore";
		String schemaName = "cardiology";
		Mockito.when(awsGlueClient.createRegistry(Mockito.any(CreateRegistryRequest.class)))
				.thenReturn(createRegistryResult);
		assertNull(onBoardingController.storeSchemaInGlueRegistry(registryName, profileStructureUri, schemaName));
	}
}