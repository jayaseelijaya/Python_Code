/*
 * (C) Koninklijke Philips Electronics N.V. 2022
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */
 
package com.philips.hsdp.research.daas.cds.transformation.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.hsdp.research.daas.cds.transformation.constants.Constants;
import com.philips.hsdp.research.daas.cds.transformation.model.CDRResponseModel;
import com.philips.hsdp.research.daas.cds.transformation.model.PatientDTO;
import com.philips.hsdp.research.daas.cds.transformation.service.UpdatePatientDetails;
import com.philips.research.fhdl.common.iam.HSDPIAMService;

/* @author Priyanka M */
@RestController
public class ResponseJsonController {
	@Autowired
	private UpdatePatientDetails updateDetails;
	private static Logger log = LoggerFactory.getLogger(ResponseJsonController.class);
	private String newCdrUrl = System.getProperty("new_cdr_url");
	private String newFinalUrl = newCdrUrl + "/store/fhir/" + System.getProperty("new_cf_org_id");
	private String iamUrl = System.getProperty("iam_auth_url");
	private String iamAuthUsername = System.getProperty("iam_auth_username");
	private String iamAuthPassword = System.getProperty("iam_auth_password");
	private String iamGrantUsername = System.getProperty("iam_grant_username");
	private String iamGrantPassword = System.getProperty("iam_grant_password");
	private String dbUrl = System.getProperty("db_url");
	private String dbUsername = System.getProperty("db_username");
	private String dbPassword = System.getProperty("db_password");
	PatientDTO patientDTO = new PatientDTO();

	/**
	 * This function is used to get data from CDR and load into PostgreSQL database.
	 * 
	 * @param @PostMapping          load data into PostgreSQL
	 * @param @RequestBody(required = false) make body optional in REST API calls
	 *                              when using @RequestBody annotation in Spring
	 * @param CDRResponseModel      cdrResponseModel get input from cdrResponseModel
	 *                              model class
	 * 
	 * @throws JSONException
	 * @throws SQLException
	 * @throws IOException
	 *
	 * @return ResponseEntity<Object> to get response as ok
	 * @return @ResponseBody get http response code ok
	 */
	@PostMapping(path = "/responseJson")
	public @ResponseBody ResponseEntity<Object> executePostgreSQLQuery(
			@RequestBody(required = false) CDRResponseModel cdrResponseModel)
			throws JSONException, SQLException, IOException {
		if (cdrResponseModel != null) {
			FileWriter outputStream = new FileWriter("Performance_Test_Notification.log", true);

			String resourceId = cdrResponseModel.getLogicalId();
			String resourceType = cdrResponseModel.getResourceType();

			SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss:SSSS z");
			Date date = new Date();
			sd.setTimeZone(TimeZone.getTimeZone("IST"));
			String listenDate = sd.format(date);
			outputStream.write(resourceId + ", " + listenDate);
			outputStream.write("\n" + "=============================================================== \n");
			outputStream.close();
			try {
				String accessToken = HSDPIAMService.generateIamToken(iamUrl, iamAuthUsername, iamAuthPassword,
						iamGrantUsername, iamGrantPassword);

				ObjectMapper objMapper = new ObjectMapper();
				ObjectNode jsonObject = objMapper.createObjectNode();
				jsonObject.put("resourceId", cdrResponseModel.logicalId);
				jsonObject.put("resourceType", cdrResponseModel.resourceType);
				resourceType = cdrResponseModel.resourceType;
				patientDTO = updateDetails.updateDetail(accessToken, newFinalUrl, jsonObject, cdrResponseModel);
				String response = patientDTO.getResponse();
				JSONObject object = new JSONObject(response);
				String practitionerResponse = patientDTO.getPractitionerResponse();
				String organizationResponse = patientDTO.getOrganizationResponse();
				String practitionerResponseType = patientDTO.getPractitionerResponseType();
				String organizationResponseType = patientDTO.getOrganizationResponseType();
				String medicationResponse = patientDTO.getMedicationResponse();
				String medicationResponseType = patientDTO.getMedicationResponseType();
				Map<String, JSONObject> hmap = null;
				Map<String, JSONObject> hmapMedicationRequest = null;
				Date date1 = new Date();
				String datetime = formatDateToString(date1, Constants.DATE_FORMAT, "IST");
				String patientId = patientDTO.getPatientId();
				if ((resourceType.equalsIgnoreCase("Encounter")) || (resourceType.equalsIgnoreCase("Practitioner"))
						|| (resourceType.equalsIgnoreCase("Organization"))) {
					hmap = new LinkedHashMap<>();
					hmap.put(resourceType, new JSONObject(response));
					hmap.put(practitionerResponseType, new JSONObject(practitionerResponse));
					hmap.put(organizationResponseType, new JSONObject(organizationResponse));
					for (Map.Entry<String, JSONObject> entry : hmap.entrySet()) {
						connectToDb(patientId, entry.getKey(), entry.getValue(), datetime);
					}
					hmap.clear();
				} else if ((resourceType.equalsIgnoreCase("MedicationRequest"))
						|| (resourceType.equalsIgnoreCase("Medication"))) {
					hmapMedicationRequest = new LinkedHashMap<>();
					hmapMedicationRequest.put(resourceType, new JSONObject(response));
					hmapMedicationRequest.put(medicationResponseType, new JSONObject(medicationResponse));
					for (Map.Entry<String, JSONObject> entry : hmapMedicationRequest.entrySet()) {
						connectToDb(patientId, entry.getKey(), entry.getValue(), datetime);
					}
					hmapMedicationRequest.clear();
				}

				else {
					connectToDb(patientId, resourceType, object, datetime);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}

	/**
	 * This function is used to connect PostgreSQL database.
	 * 
	 * @param String     resourceId
	 * @param String     resourceType
	 * @param JSONObject object
	 * @param String     datetime
	 * 
	 * @throws SQLException
	 *
	 * @return void
	 */
	public void connectToDb(String resourceId, String resourceType, JSONObject object, String datetime)
			throws SQLException {
		// create connection to databases
		Connection conn = null;
		try {
			String dbURL = dbUrl;
			Properties parameters = new Properties();
			parameters.setProperty("username", dbUsername);
			parameters.setProperty("password", dbPassword);
			conn = DriverManager.getConnection(dbURL, parameters);

		} catch (Exception ex) {
			log.error(ex.getMessage());
		}

		try {
			if (conn != null) {

				String insertPatient = "INSERT INTO base_resource(patientid, resourcetype, resourcejson, datetime) VALUES"
						+ "('" + resourceId + "', '" + resourceType + "', '" + object + "', '" + datetime + "')";
				Statement statement = conn.createStatement();
				statement.executeUpdate(insertPatient);
				statement.close();
				conn.close();
				conn.close();
				log.info("data updated..." + object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to get date format.
	 * 
	 * @param Date   date
	 * @param String format
	 * @param String timeZone
	 * 
	 * @return String Date
	 */
	public static String formatDateToString(Date date, String format, String timeZone) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
			timeZone = Calendar.getInstance().getTimeZone().getID();
		}
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		return sdf.format(date);
	}
}