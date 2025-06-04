/**
* (C) Koninklijke Philips Electronics N.V. 2021
*
* All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
* means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
* the copyright owner.
**/
package com.philips.hsdp.research.fhdl.fhirservice.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.services.s3.AmazonS3;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.hsdp.research.fhdl.fhirservice.util.FHIRUtility;
import com.philips.hsdp.research.fhdl.fhirservice.util.FHIRValidatorUtil;
import com.philips.research.fhdl.common.iam.HSDPIAMService;
import ca.uhn.fhir.validation.SingleValidationMessage;
import ca.uhn.fhir.validation.ValidationResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/*
* @author Rajeshwar Tondare
*/
@RestController
@SecurityRequirement(name = "fhir interface api")
public class FhirPostController {

	@Autowired
	FHIRValidatorUtil fhirValidatorUtil;

	@Autowired
	FHIRUtility utility;

	@Autowired
	private AmazonS3 s3ClientLoader;

	private String bucketNameLoader = System.getProperty("s3loader_bucket");
	private static final Logger log = LoggerFactory.getLogger(FhirPostController.class);

	@PostMapping("/Patient")
	@Operation(summary = "Write data to delta lake")
	public ResponseEntity<String> readData(@RequestBody JsonNode requestData,
			@RequestHeader("Authorization") String requestHeaders, @RequestHeader("Content-Type") String contentType,
			HttpServletResponse httpServletResponse) throws JSONException, IOException {
		log.info("####### Fhir POST API - Start Point #######");
		requestHeaders = requestHeaders.replace("Bearer ", "");
		Object response = HSDPIAMService.validateIAMToken(requestHeaders);
		String isValidateToken = String.valueOf(response);
		ObjectMapper mapper = new ObjectMapper();
		ResponseEntity<String> responseEntity = null;
		ObjectNode jsonObject = mapper.createObjectNode();
		if (isValidateToken.equals("true")) {
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			int index = contentType.indexOf("=") + 1;
			String version = contentType.substring(index, index + 3);
			try {
				ValidationResult validationResult = fhirValidatorUtil.validate(ow.writeValueAsString(requestData),
						version);
				if (validationResult.isSuccessful()) {
					log.info("Fhir Validation Successful");
				} else {
					StringBuilder sb = new StringBuilder("Validation Errors : ");
					for (SingleValidationMessage s : validationResult.getMessages()) {
						sb.append("\n").append(s.getMessage());
					}
					return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				log.info("Error in Fhir validation, message {}", e.getMessage());
				return new ResponseEntity<>("Fhir validation failed, error : " + e.getMessage(),
						HttpStatus.EXPECTATION_FAILED);
			}
			try {
				Date dateNow = new Date();
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
				String dateTime = f.format(dateNow);
				SimpleDateFormat fo = new SimpleDateFormat("dd_MM_HH_mm_ss");
				String dateTimeName = fo.format(dateNow);
				String jsonFile = "Patient_" + dateTimeName + ".json";
				String objectName = "cf-delta/fhirJsonDataset/delta/input/fhir" + jsonFile;
				s3ClientLoader.putObject(bucketNameLoader, objectName, ow.writeValueAsString(requestData));

				ObjectNode fhirAddon = requestData.deepCopy();
				jsonObject.put("objectKey", jsonFile);
				jsonObject.put("resourceType", requestData.get("resourceType").asText());
				if (Objects.nonNull(requestData.get("id"))) {
					fhirAddon.put("patientId", requestData.get("id").asText());
					jsonObject.put("patientId", requestData.get("id").asText());
				}
				JsonNode name = requestData.get("name");
				if (Objects.nonNull(name)) {
					StringBuilder actualName = new StringBuilder("");
					if (Objects.nonNull(name.get(0).get("given"))) {
						actualName.append(name.get(0).get("given").get(0).asText());
					}
					if (Objects.nonNull(name.get(0).get("family"))) {
						actualName.append(" " + name.get(0).get("family").asText());
					}
					fhirAddon.put("patientName", actualName.toString());
					jsonObject.put("patientName", actualName.toString());
				}
				String resourceUri = "https://" + bucketNameLoader + ".s3.awsRegion.amazonaws.com/" + objectName;
				fhirAddon.put("resourceUri", resourceUri);
				jsonObject.put("resourceUri", resourceUri);
				fhirAddon.put("resourceJson", requestData.toString());
				fhirAddon.put("sourceResourceCreatedDateTime", dateTime);
				fhirAddon.put("createdDateTime", dateTime);

				String fhirobj = "cf-delta/fhirJsonDataset/delta/input/fhirAddon/" + jsonFile;
				s3ClientLoader.putObject(bucketNameLoader, fhirobj, ow.writeValueAsString(fhirAddon));
				jsonObject.put("resourceFormat", "FHIR-JSON");
				log.info("####### Message sent to RMQ");
				// utility.sendMessageToRMQ(jsonObject);
				responseEntity = new ResponseEntity<>("Data has been added successfully !", HttpStatus.OK);
			} catch (Exception e) {
				responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
				log.debug(e.getMessage());
			}
		} else {
			final String errorMessage = "Exception found, Invalid token!!";
			responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
		}
		return responseEntity;
	}
}