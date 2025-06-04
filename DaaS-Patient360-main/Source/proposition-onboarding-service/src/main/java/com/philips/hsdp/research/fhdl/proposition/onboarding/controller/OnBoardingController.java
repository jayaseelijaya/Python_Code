/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.fhdl.proposition.onboarding.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.glue.AWSGlue;
import com.amazonaws.services.glue.model.AWSGlueException;
import com.amazonaws.services.glue.model.CreateRegistryRequest;
import com.amazonaws.services.glue.model.CreateRegistryResult;
import com.amazonaws.services.glue.model.CreateSchemaRequest;
import com.amazonaws.services.glue.model.GetRegistryRequest;
import com.amazonaws.services.glue.model.RegisterSchemaVersionRequest;
import com.amazonaws.services.glue.model.RegistryId;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.philips.hsdp.research.fhdl.proposition.onboarding.model.ResourceInfo;
import com.philips.hsdp.research.fhdl.proposition.onboarding.model.ResourceTopicRequest;
import com.philips.hsdp.research.fhdl.proposition.onboarding.service.KafkaService;
import com.philips.hsdp.research.fhdl.proposition.onboarding.service.MdmData;
import com.philips.hsdp.research.fhdl.proposition.onboarding.service.ParseJson;
import com.philips.hsdp.research.fhdl.proposition.onboarding.service.S3BucketStorageService;

/* @author Sunil Kumar */
@RestController
public class OnBoardingController {
	@Autowired
	ParseJson uploadMultipleFilesService;

	@Autowired
	S3BucketStorageService service;

	@Autowired
	KafkaService kafkaService;

	@Autowired
	private AWSGlue awsGlueClient;

	@Autowired
	private MdmData mdmData;

	@Autowired
	private DynamoDBMapper dynamoDbMapper;

	private static final Logger log = LoggerFactory.getLogger(OnBoardingController.class);

	/**
	 * This function is to convert the json data in map and store it in dynamo db.
	 * 
	 * @param @RequestBody JsonNode : request parameter json String
	 * 
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 * @throws AmazonClientException
	 * @throws AmazonServiceException
	 * @throws URISyntaxException
	 */
	@PostMapping(path = "/register_proposition", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> loadMessage(@RequestBody JsonNode message, @RequestHeader("Accept") String accept)
			throws IOException, AmazonServiceException, AmazonClientException, URISyntaxException, JSONException {

		ResourceInfo resourceInfo = new ResourceInfo();
		String jsonData = "{" + "\"message\"" + ":" + "\"Invalid input\"" + "}";

		JSONObject responseData = uploadMultipleFilesService.convertJson(message);
		String response = responseData.toString();
		if (!response.equalsIgnoreCase(jsonData)) {
			String onboardingProfilesInputData = responseData.toString();
			Gson gson = new Gson();
			Type typeOfHashMap = new TypeToken<Map<String, String>>() {
			}.getType();

			Map<String, String> newMap = gson.fromJson(onboardingProfilesInputData, typeOfHashMap);
			String indexName = responseData.getString("profileName");
			Map<String, String> profileMap = mdmData.getMdmData();
			if (profileMap.containsValue(indexName) || (indexName == null)) {
				String jsonProfile = "{" + " \"message\" " + ":" + " \"profile is already exist.\" " + "}";
				return new ResponseEntity<>(jsonProfile, HttpStatus.BAD_REQUEST);
			} else {
				resourceInfo.setAlgorithmEndpoint(newMap.get("algorithmEndpoint"));
				resourceInfo.setProfileName(newMap.get("profileName"));
				resourceInfo.setPropositionName(newMap.get("propositionName"));
				resourceInfo.setOrganizationName(newMap.get("organizationName"));
				resourceInfo.setDepartmentName(newMap.get("departmentName"));
				resourceInfo.setPropositionTags(newMap.get("propositionTags"));
				resourceInfo.setProfileStructure(newMap.get("profileStructure"));
				String baseTopicName = String.join(".", resourceInfo.getOrganizationName(),
						resourceInfo.getDepartmentName());
				String requestTopicName = String.join(".", resourceInfo.getOrganizationName(),
						resourceInfo.getDepartmentName(), resourceInfo.getProfileName());
				String resultTopicName = String.join(".", resourceInfo.getOrganizationName(),
						resourceInfo.getDepartmentName(), resourceInfo.getProfileName(), "result");
				resourceInfo.setBaseTopicName(baseTopicName);
				resourceInfo.setRequestTopicName(requestTopicName);
				resourceInfo.setResultTopicName(resultTopicName);
				try {
					kafkaService.createTopic(ResourceTopicRequest.builder().deptName(resourceInfo.getDepartmentName())
							.orgName(resourceInfo.getOrganizationName()).profileName(resourceInfo.getProfileName())
							.build());
				} catch (Exception e) {
					String jsonProfile = "{" + " \"message\" " + ":" + " \"topic already exists\" " + "}";
					return new ResponseEntity<>(jsonProfile, HttpStatus.BAD_REQUEST);
				}
				String registryArn = null;
				try {
					registryArn = storeSchemaInGlueRegistry(resourceInfo.getPropositionName(),
							resourceInfo.getProfileStructure(), resourceInfo.getProfileName());
				} catch (AmazonS3Exception e) {
					String jsonProfile = "{" + " \"message\" " + ":"
							+ " \"invalid file name supplied, please try again.\" " + "}";
					return new ResponseEntity<>(jsonProfile, HttpStatus.BAD_REQUEST);
				}
				if (registryArn == null) {
					String jsonProfile = "{" + " \"message\" " + ":" + " \"registry is already exist in the system.\" "
							+ "}";
					return new ResponseEntity<>(jsonProfile, HttpStatus.BAD_REQUEST);
				} else {
					resourceInfo.setRegistryArn(registryArn);
					Date dNow = new Date();
					String createdDateTime;
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					createdDateTime = simpleDateFormat.format(dNow);
					resourceInfo.setCreatedDateTime(createdDateTime);
					UUID uuid = UUID.randomUUID();
					String propositionId = uuid.toString();
					resourceInfo.setPropositionId(propositionId);
					String orgId = null;
					orgId = uploadMultipleFilesService.createUUid();
					resourceInfo.setOrganizationId(orgId);
					resourceInfo.setResourceCreatedDateTime(newMap.get("resourceCreatedDateTime"));
					dynamoDbMapper.save(resourceInfo);
					log.info("Index has been created into DynamoDB");
					String messageReturn = "{" + " \"message\" " + ":" + " \"proposition created successfully\" " + ","
							+ " \"proposition_details\" " + ":" + "{" + " \"proposition_id\" " + ":" + " \""
							+ propositionId + "\" " + "," + " \"org_id\" " + ":" + " \"" + orgId + "\" " + "}" + "}";
					return new ResponseEntity<>(messageReturn, HttpStatus.CREATED);
				}
			}
		} else {
			String jsondata = "{" + " \"Message\" " + ":" + " \"Invalid input\" " + "}";
			return new ResponseEntity<>(jsondata, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This function is to store schema in glue registry.
	 * 
	 * return String : registryArn
	 * 
	 * @throws URISyntaxException
	 */
	public String storeSchemaInGlueRegistry(String registryName, String profileStructureUri, String schemaName)
			throws IOException, URISyntaxException {
		String responseData = service.getProfileStructureContent(profileStructureUri);
		String registryArn = null;
		try {
			CreateRegistryRequest req = new CreateRegistryRequest();
			req.setRegistryName(registryName);
			CreateRegistryResult createRegistry = awsGlueClient.createRegistry(req);
			registryArn = createRegistry.getRegistryArn();
			RegisterSchemaVersionRequest registerSchemaVersionRequest = new RegisterSchemaVersionRequest();
			registerSchemaVersionRequest.withSchemaDefinition(responseData);
			RegistryId registryId = new RegistryId();
			registryId.withRegistryArn(registryArn);
			GetRegistryRequest getRegistryRequest = new GetRegistryRequest();
			getRegistryRequest.setRegistryId(registryId);
			awsGlueClient.getRegistry(getRegistryRequest);
			CreateSchemaRequest schemaRequest = new CreateSchemaRequest();
			schemaRequest.setSchemaName(schemaName);
			schemaRequest.setDescription(schemaName);
			String uri = profileStructureUri;
			String extension = uri.substring(uri.lastIndexOf("."));
			extension = extension.replace(".", "");
			extension = extension.toUpperCase();
			schemaRequest.setDataFormat(extension);
			schemaRequest.withCompatibility("BACKWARD");
			schemaRequest.withRegistryId(registryId);
			schemaRequest.withSchemaDefinition(responseData);
			awsGlueClient.createSchema(schemaRequest);
			log.info("##############Success#############");
		} catch (AWSGlueException e) {
			log.info(e.getMessage());
		}
		return registryArn;
	}
}