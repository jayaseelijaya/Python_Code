/**
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner. 
 **/
package com.philips.hsdp.research.fhdl.fhirservice.util;

import java.io.File;
import java.io.IOException;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.r4.model.Patient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import com.philips.research.fhdl.common.iam.HSDPIAMService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.hsdp.research.fhdl.fhirservice.constant.Constants;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.validation.SingleValidationMessage;
import ca.uhn.fhir.validation.ValidationResult;

/*
 * @author Rajeshwar Tondare
 */
@Component
public class FHIRUtility {
	private static final Logger log = LoggerFactory.getLogger(FHIRUtility.class);

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	FHIRValidatorUtil fhirValidatorUtil;

	/**
	 * 
	 * This function is used to verify headers and call validate IAM token method.
	 *
	 * @param String : requestHeaders
	 * @param String : tokenFlag
	 * @return fileName : token
	 */
	public String verifyHeaderAndCallValidateIAMToken(@RequestHeader HttpHeaders requestHeaders, String tokenFlag)
			throws JSONException, IOException {
		if (null != requestHeaders && !requestHeaders.isEmpty()) {
			String authToken = requestHeaders.get("authorization").toString();
			authToken = authToken.replace("[", "").replace("]", "");
			authToken = authToken.replace("Bearer ", "");
			System.setProperty("rabbitMqToken", authToken);
			Object response = HSDPIAMService.validateIAMToken(authToken);
			tokenFlag = String.valueOf(response);
		}
		return tokenFlag;
	}

	/**
	 * 
	 * This function is used to Send message to RMQ.
	 *
	 * @param String : jsonObject
	 *
	 */

	// public void sendMessageToRMQ(ObjectNode jsonObject) {
		// ObjectMapper objMapper = new ObjectMapper();
		// try {
			// String messageData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
			// ConnectionFactory factory = new ConnectionFactory();
			// factory.setHost(System.getProperty("hostname"));
			// factory.setUsername(System.getProperty("admin_username"));
			// factory.setPassword(System.getProperty("admin_password"));
			// factory.setPort(Integer.parseInt(System.getProperty("port")));
			// factory.setVirtualHost(System.getProperty("vhost"));

			// Map<String, Object> headerMap = new HashMap<>();
			// headerMap.put("bearer", System.getProperty("rabbitMqToken"));

			// BasicProperties messageProperties = new BasicProperties.Builder().timestamp(new Date())
					// .contentType("text/plain").userId(System.getProperty("admin_username")).appId("app id: 20")
					// .deliveryMode(1).priority(1).headers(headerMap).clusterId("cluster id: 1").build();

			// try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
				// channel.basicPublish("", Constants.RMQ_QUEUE, messageProperties, messageData.getBytes());
				// log.info("Sent to RMQ");
			// }
		// } catch (Exception e) {
			// log.info(e.getMessage());
		// }
	// }

	/**
	 * 
	 * This function is used to file reading of CADComorbidity.
	 *
	 */
	public String getCADComorbidity() throws JSONException, IOException {
		File resource = new ClassPathResource("CADComorbidityValueSet.valueset.json").getFile();
		String text = new String(Files.readAllBytes(resource.toPath()));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonResponse = mapper.readTree(text);
		String value = jsonResponse.get("compose").toString();
		JSONObject test = new JSONObject(value);
		JSONObject includeValue = test.getJSONObject("include");
		String conceptValue = includeValue.get("concept").toString();

		String res = null;
		JSONArray jsonArray = new JSONArray(conceptValue);
		ArrayList<String> cadCodes = new ArrayList<>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			JSONObject code = jsonObject.getJSONObject("code");
			cadCodes.add(code.get("@value").toString());
		}
		return "'" + String.join("','", cadCodes) + "'";
	}

	public JsonNode convertWithHapi(JsonNode patientResponseDTO, String contentType) throws IOException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		int index = contentType.indexOf("=") + 1;
		String version = contentType.substring(index, index + 3);
		log.info("FHIR Version: {} ", version);
		try {
			ValidationResult validationResult = fhirValidatorUtil.validate(ow.writeValueAsString(patientResponseDTO),
					version);
			if (validationResult.isSuccessful()) {
				log.info("Fhir Validation Successful");
			} else {
				StringBuilder sb = new StringBuilder("Validation Errors : ");
				for (SingleValidationMessage s : validationResult.getMessages()) {
					sb.append("\n").append(s.getMessage());
				}
				return patientResponseDTO;
			}
		} catch (Exception e) {
			log.info("Error in Fhir validation, message {}", e.getMessage());

		}
		if (version.equalsIgnoreCase("3.0")) {
			log.info("Converting from STU3 to R4");
			FhirContext ctx = FhirContext.forDstu3();
			IParser parser = ctx.newJsonParser();
			org.hl7.fhir.dstu3.model.Patient parsed = parser.parseResource(org.hl7.fhir.dstu3.model.Patient.class,
					ow.writeValueAsString(patientResponseDTO));
			org.hl7.fhir.r4.model.Patient output = (org.hl7.fhir.r4.model.Patient) VersionConvertorFactory_30_40
					.convertResource(parsed);
			FhirContext context = FhirContext.forR4();
			IParser iParser = context.newJsonParser();
			String serializedOutput = iParser.encodeResourceToString(output);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonResponse = null;
			try {
				jsonResponse = (serializedOutput != null) ? mapper.readTree(serializedOutput) : null;
			} catch (IOException e) {
				e.printStackTrace();
			}
			log.info("Output: {} ", serializedOutput);
			return jsonResponse;
		} else {
			log.info("Converting from R4 to STU3");
			FhirContext ctx = FhirContext.forR4();
			IParser parser = ctx.newJsonParser();
			Patient parsed = parser.parseResource(Patient.class, ow.writeValueAsString(patientResponseDTO));
			org.hl7.fhir.dstu3.model.Patient output = (org.hl7.fhir.dstu3.model.Patient) VersionConvertorFactory_30_40
					.convertResource(parsed);
			FhirContext context = FhirContext.forDstu3();
			IParser iParser = context.newJsonParser();
			String serializedOutput = iParser.encodeResourceToString(output);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonResponse = null;
			try {
				jsonResponse = (serializedOutput != null) ? mapper.readTree(serializedOutput) : null;
			} catch (IOException e) {
				e.printStackTrace();
			}
			log.info("Output: {} ", serializedOutput);
			return jsonResponse;
		}
	}
}