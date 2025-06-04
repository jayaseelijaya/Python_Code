/*
 * (C) Koninklijke Philips Electronics N.V. 2022
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.daas.cds.transformation.util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.hsdp.research.daas.cds.transformation.model.CDRResponseModel;

/* @author Sunil Kumar */
@Component
public class GetPatientDetails {
	private static final Logger log = LoggerFactory.getLogger(GetPatientDetails.class);
	public static final String GIVEN = "given";
	public static final String FAMILY = "family";

	/**
	 * This function is used to get data from CDR.
	 * 
	 * @param String           patientUrl CDR URL
	 * @param String           accessToken get access token from IAM service
	 * @param ObjectNode       objectNode add data in objectNode
	 * @param CDRResponseModel cdrResponseModel get input from cdrResponseModel
	 *                         model class
	 * @param String           contentType
	 * 
	 * @throws IOException
	 *
	 * @return String : get data in String
	 */
	public String getDetails(String patientUrl, String accessToken, ObjectNode objectNode,
			CDRResponseModel cdrResponseModel, String contentType) throws IOException {
		BufferedReader reader = null;
		String patientFullName = null;
		String response = null;
		String resourceType = null;
		String patientId = null;
		HttpsURLConnection connection = null;
		try {
			URL url = new URL(patientUrl);
			connection = create(url);
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Bearer " + accessToken);
			connection.setRequestProperty("api-version", "1");
			connection.setRequestProperty("Content-Type", contentType);
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			StringWriter out = new StringWriter(
					connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			response = out.toString();
			JSONObject object = new JSONObject(response);
			resourceType = object.get("resourceType").toString();
			JSONArray array = new JSONArray();
			if ((!"Bundle".equals(resourceType)) && (!"Practitioner".equals(resourceType))
					&& (!"Organization".equals(resourceType)) && (!"Medication".equals(resourceType))) {
				array = object.getJSONArray("name");
				patientId = object.getString("id");
				JSONObject object2 = array.getJSONObject(0);
				String paitentName = "";
				if (!object2.isNull(GIVEN)) {
					JSONArray array1 = object2.getJSONArray(GIVEN);
					paitentName = (String) array1.get(0);
				}
				String familyName = "";
				if (!object2.isNull(FAMILY)) {
					String family = object2.getString(FAMILY);
					familyName = family.toString();
				}
				patientFullName = paitentName + " " + familyName;
				objectNode.put("patientName", patientFullName.trim());
				objectNode.put("patientId", object.getString("id"));
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}

		FileWriter outputStream = new FileWriter("Performance_Test_GetCall.log", true);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss:SSSS z");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		String listenDate = sd.format(date);
		outputStream.write(patientId + ", " + listenDate);
		outputStream.write("\n" + "=============================================================== \n");
		outputStream.close();
		return response;
	}

	public HttpsURLConnection create(URL url) throws IOException {
		return (HttpsURLConnection) url.openConnection();
	}
}