/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.daas.cds.transformation.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.net.ssl.HttpsURLConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.hsdp.research.daas.cds.transformation.model.CDRResponseModel;

/* @author Srinivasa Reddy Bijjam */
@ExtendWith(MockitoExtension.class)
class GetPatientDetailsTest {

	@Mock
	private HttpsURLConnection connection;

	@Spy
	@InjectMocks
	GetPatientDetails getPatientDetails;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("This Test case is to get details of the patient")
	void getDetails_Test() throws IOException {
		CDRResponseModel cdrResponseModel = new CDRResponseModel();
		cdrResponseModel.setLogicalId("1234");
		cdrResponseModel.setResourceType("Patient");
		cdrResponseModel.setVersionId("963");
		String str = "{\"id\": \"cc492386-a556-41d3-aeab-e4987767b478\", \"meta\": {\"versionId\": \"de265b3c-6faa-11ed-a01f-a34fa9702190\", \"lastUpdated\": \"2022-11-29T05:58:38.045789+00:00\"}, \"name\": [{\"use\": \"official\", \"given\": [\"Herman Ball\"]}], \"gender\": \"male\", \"address\": [{\"city\": \"Northbridge\", \"line\": [\"638 Brakus Union Suite 44\"], \"state\": \"Massachusetts\", \"country\": \"US\"}], \"telecom\": [{\"use\": \"home\", \"value\": \"681-171-9051\", \"system\": \"phone\"}], \"birthDate\": \"1999-12-12\", \"identifier\": [{\"system\": \"https://github.com/synthetichealth/synthea\"}], \"resourceType\": \"Patient\", \"communication\": [{\"language\": {\"text\": \"Greek\", \"coding\": [{\"code\": \"el\", \"system\": \"urn:ietf:bcp:47\", \"display\": \"Greek\"}]}}], \"maritalStatus\": {\"text\": \"Never Married\", \"coding\": [{\"code\": \"S\", \"system\": \"http://terminology.hl7.org/CodeSystem/v3-MaritalStatus\", \"display\": \"Never Married\"}]}, \"multipleBirthBoolean\": false}";
		doReturn(connection).when(getPatientDetails).create(any());
		Mockito.when(connection.getInputStream()).thenReturn(new ByteArrayInputStream(str.getBytes()));
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode jsonObject = objMapper.createObjectNode();
		assertNotNull(getPatientDetails.getDetails("https://localhost/Patient/cc492386-a556-41d3-aeab-e4987767b478",
				"1234", jsonObject, cdrResponseModel, "application/fhir+json;fhirVersion=3.0"));
	}
}