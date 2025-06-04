/*
 * (C) Koninklijke Philips Electronics N.V. 2022
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.daas.cds.transformation.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.hsdp.research.daas.cds.transformation.constants.Constants;
import com.philips.hsdp.research.daas.cds.transformation.model.CDRResponseModel;
import com.philips.hsdp.research.daas.cds.transformation.model.PatientDTO;
import com.philips.hsdp.research.daas.cds.transformation.util.GetPatientDetails;

/* @author Sunil Kumar */
@Component
public class UpdatePatientDetails {
	@Autowired
	GetPatientDetails getPatientDetails;

	private static final Logger log = LoggerFactory.getLogger(UpdatePatientDetails.class);

	/**
	 * This function is used to access token then update and retrieve patient
	 * information.
	 *
	 * @param String           : accessToken grant authentication to access token.
	 * @param String           : cdrUrl to access cdr repository
	 * @param JsonNode         objectNode to add Json object
	 * @param CDRResponseModel CDRResponseModel to map model
	 * @return true if the move is valid, otherwise false
	 * @throws IOException
	 */
	public PatientDTO updateDetail(String accessToken, String cdrUrl, ObjectNode objectNode,
			CDRResponseModel cdrResponseModel) throws IOException {
		PatientDTO patientDTO = new PatientDTO();
		String response = null;
		String result = null;
		String patientJson = null;
		String patientcdrurl = cdrUrl + "/" + cdrResponseModel.resourceType + "/" + cdrResponseModel.logicalId;
		BufferedReader reader = null;
		String contentType = "application/fhir+json;fhirVersion=4.0";
		HttpsURLConnection connection = null;
		try {
			URL url = new URL(patientcdrurl);
			connection = create(url);
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Bearer " + accessToken);
			connection.setRequestProperty("api-version", "1");
			connection.setRequestProperty("content-type", contentType);
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			StringWriter out = new StringWriter(
					connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			response = out.toString();
			String medicationDetails = null;
			String patientId = null;
			String medicationResourceType = null;
			JSONObject object = new JSONObject(response);
			if (cdrResponseModel.resourceType.equalsIgnoreCase("Patient")) {
				patientJson = getPatientDetails.getDetails(patientcdrurl, accessToken, objectNode, cdrResponseModel,
						contentType);
				JSONObject objectJson = new JSONObject(patientJson);
				patientId = objectJson.getString("id");
				patientDTO.setPatientId(patientId);
				patientDTO.setResponse(response);
			} else if (cdrResponseModel.resourceType.equalsIgnoreCase("AllergyIntolerance")
					|| cdrResponseModel.resourceType.equalsIgnoreCase("ImagingStudy")
					|| cdrResponseModel.resourceType.equalsIgnoreCase("Immunization")) {
				JSONObject objectPatient = object.getJSONObject("patient");
				String patientUrl = cdrUrl + "/" + objectPatient.getString("reference");
				patientJson = getPatientDetails.getDetails(patientUrl, accessToken, objectNode, cdrResponseModel,
						contentType);
				JSONObject objectJson = new JSONObject(patientJson);
				patientId = objectJson.getString("id");
				patientDTO.setResponse(response);
				patientDTO.setPatientId(patientId);
			} else if (cdrResponseModel.resourceType.equalsIgnoreCase("Condition")
					|| cdrResponseModel.resourceType.equalsIgnoreCase("Composition")
					|| cdrResponseModel.resourceType.equalsIgnoreCase("MedicationStatement")
					|| cdrResponseModel.resourceType.equalsIgnoreCase("Observation")) {
				JSONObject objectSubject = object.getJSONObject("subject");
				String patientUrl = cdrUrl + "/" + objectSubject.getString("reference");
				result = getPatientDetails.getDetails(patientUrl, accessToken, objectNode, cdrResponseModel,
						contentType);
				JSONObject objectJson = new JSONObject(result);
				patientId = objectJson.getString("id");
				patientDTO.setResponse(response);
				patientDTO.setPatientId(patientId);
			} else if (cdrResponseModel.resourceType.equalsIgnoreCase("Encounter")) {
				JSONObject objectSubject = object.getJSONObject("subject");
				String patientUrl = cdrUrl + "/" + objectSubject.getString("reference");
				result = getPatientDetails.getDetails(patientUrl, accessToken, objectNode, cdrResponseModel,
						contentType);
				JSONObject objectJson = new JSONObject(result);
				patientId = objectJson.getString("id");
				patientDTO.setPatientId(patientId);
				patientDTO.setResponse(response);
				JSONArray array = object.getJSONArray("participant");
				JSONObject object2 = array.getJSONObject(0);
				JSONObject object3 = object2.getJSONObject("individual");
				String practitionerUrl = cdrUrl + "/" + object3.getString("reference");
				String practitionerId = object3.getString("reference");
				practitionerId = practitionerId.replace("Practitioner/", "");
				patientDTO.setPractitionerId(practitionerId);
				String practitionerDetails = getPatientDetails.getDetails(practitionerUrl, accessToken, objectNode,
						cdrResponseModel, contentType);
				JSONObject objectPractitionerDetails = new JSONObject(practitionerDetails);
				String practitionerResourceType = objectPractitionerDetails.getString("resourceType");
				patientDTO.setPractitionerResponseType(practitionerResourceType);
				patientDTO.setPractitionerResponse(practitionerDetails);
				JSONObject objectSubject1 = object.getJSONObject("serviceProvider");
				String organizationUrl = cdrUrl + "/" + objectSubject1.getString("reference");
				String organizationId = objectSubject1.getString("reference");
				organizationId = organizationId.replace("Organization/", "");
				patientDTO.setOrganizationId(organizationId);
				String organizationDetails = getPatientDetails.getDetails(organizationUrl, accessToken, objectNode,
						cdrResponseModel, contentType);
				JSONObject objectOrganizationDetails = new JSONObject(organizationDetails);
				String organizationResourceType = objectOrganizationDetails.getString("resourceType");
				patientDTO.setOrganizationResponseType(organizationResourceType);
				patientDTO.setOrganizationResponse(organizationDetails);
			} else if (cdrResponseModel.resourceType.equalsIgnoreCase("MedicationRequest")) {
				JSONObject objectSubject = object.getJSONObject("subject");
				String patientUrl = cdrUrl + "/" + objectSubject.getString("reference");
				result = getPatientDetails.getDetails(patientUrl, accessToken, objectNode, cdrResponseModel,
						contentType);
				JSONObject objectJson = new JSONObject(result);
				patientId = objectJson.getString("id");
				patientDTO.setPatientId(patientId);
				patientDTO.setResponse(response);
				JSONObject objectSubject1 = object.getJSONObject("medicationReference");
				String medicationUrl = cdrUrl + "/" + objectSubject1.getString("reference");
				medicationDetails = getPatientDetails.getDetails(medicationUrl, accessToken, objectNode,
						cdrResponseModel, contentType);
				JSONObject objectMedicationDetails = new JSONObject(medicationDetails);
				medicationResourceType = objectMedicationDetails.getString("resourceType");
				patientDTO.setMedicationResponseType(medicationResourceType);
				patientDTO.setMedicationResponse(medicationDetails);
			}
			String resourceCreatedDateTime = object.get("meta").toString();
			JSONObject resourceCreatedDateTimeobject = new JSONObject(resourceCreatedDateTime);
			String updatedtime = resourceCreatedDateTimeobject.get("lastUpdated").toString();
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT);
			updatedtime = formatter.format(date);
			objectNode.put("resourceCreatedDateTime", updatedtime);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		reader.close();
		connection.disconnect();
		return patientDTO;
	}

	HttpsURLConnection create(URL url) throws IOException {
		return (HttpsURLConnection) url.openConnection();
	}
}