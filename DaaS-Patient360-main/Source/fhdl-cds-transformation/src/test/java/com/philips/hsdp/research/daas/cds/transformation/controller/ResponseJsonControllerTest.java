/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.daas.cds.transformation.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mockStatic;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.philips.hsdp.research.daas.cds.transformation.model.CDRResponseModel;
import com.philips.hsdp.research.daas.cds.transformation.model.PatientDTO;
import com.philips.hsdp.research.daas.cds.transformation.service.UpdatePatientDetails;
import com.philips.research.fhdl.common.iam.HSDPIAMService;

/* @author Srinivasa Reddy Bijjam */
class ResponseJsonControllerTest {

	@Mock
	private UpdatePatientDetails updateDetails;

	@Mock
	private Connection connection;

	@Mock
	private Statement statement;

	@InjectMocks
	ResponseJsonController responseJsonController;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		System.setProperty("cdr_url", "Srinu");
		System.setProperty("new_cdr_url", "Srinu");
		System.setProperty("cf_org_id", "Srinu");
		System.setProperty("new_cf_org_id", "Srinu");
		System.setProperty("iam_auth_url", "Srinu");
		System.setProperty("iam_auth_username", "Srinu");
		System.setProperty("iam_auth_password", "Reddy");
		System.setProperty("iam_grant_username", "Bijjam");
		System.setProperty("iam_grant_password", "1234");
		System.setProperty("db_url", "1234");
		System.setProperty("db_username", "1234");
		System.setProperty("db_password", "1234");
	}

	@Test
	@DisplayName("This Test case is to generate the Iamtoken and here we have given mock data and also checking wheather resourceType is ImagingStudy or not")
	void executePostgreSQLQuery_ImagingStudyTest() throws IOException, JSONException, SQLException {
		try (MockedStatic mocked = mockStatic(HSDPIAMService.class)) {
			mocked.when(() -> HSDPIAMService.generateIamToken("Srinu", "Srinu", "Reddy", "Bijjam", "1234"))
					.thenReturn("Test");
			String responseJson = "{\"patientName\":\"PANKAJ\"}";
			CDRResponseModel cDRResponseModel = new CDRResponseModel();
			cDRResponseModel.setLogicalId("1234");
			cDRResponseModel.setResourceType("ImagingStudy");
			cDRResponseModel.setVersionId("963");
			PatientDTO patientDTO = new PatientDTO();
			patientDTO.setOrganizationId("12345");
			patientDTO.setOrganizationResponse("Test");
			patientDTO.setOrganizationResponseType("Data");
			patientDTO.setPatientId("67883");
			patientDTO.setPractitionerId("78393");
			patientDTO.setPractitionerResponse("text");
			patientDTO.setPractitionerResponseType("response");
			patientDTO.setResponse(responseJson);
			Mockito.when(updateDetails.updateDetail(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
					.thenReturn(patientDTO);
			assertNotNull(responseJsonController.executePostgreSQLQuery(cDRResponseModel));
		}
	}

	@Test
	@DisplayName("This Test case is to check wheather resourceType is Encounter or not")
	void executePostgreSQLQuery_EncounterTest() throws IOException, JSONException, SQLException {
		try (MockedStatic mocked = mockStatic(HSDPIAMService.class)) {
			mocked.when(() -> HSDPIAMService.generateIamToken("Srinu", "Srinu", "Reddy", "Bijjam", "1234"))
					.thenReturn("Test");
			String responseJson = "{\"patientName\":\"PANKAJ1\"}";
			String practitionerResponseType = "{\"practitionerResponseType\":\"PANKAJ2\"}";
			String organizationResponseType = "{\"organizationResponseType\":\"PANKAJ3\"}";
			CDRResponseModel cDRResponseModel = new CDRResponseModel();
			cDRResponseModel.setLogicalId("1234");
			cDRResponseModel.setResourceType("Encounter");
			cDRResponseModel.setVersionId("963");
			PatientDTO patientDTO = new PatientDTO();
			patientDTO.setOrganizationId("12345");
			patientDTO.setOrganizationResponse(organizationResponseType);
			patientDTO.setOrganizationResponseType(organizationResponseType);
			patientDTO.setPatientId("67883");
			patientDTO.setPractitionerId("78393");
			patientDTO.setPractitionerResponse(practitionerResponseType);
			patientDTO.setPractitionerResponseType(practitionerResponseType);
			patientDTO.setResponse(responseJson);
			Mockito.when(updateDetails.updateDetail(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
					.thenReturn(patientDTO);
			assertNotNull(responseJsonController.executePostgreSQLQuery(cDRResponseModel));
		}
	}

	@Test
	@DisplayName("This Test case is to check wheather resourceType is Patient or not")
	void executePostgreSQLQuery_PatientTest() throws IOException, JSONException, SQLException {
		try (MockedStatic mocked = mockStatic(HSDPIAMService.class)) {
			mocked.when(() -> HSDPIAMService.generateIamToken("Srinu", "Srinu", "Reddy", "Bijjam", "1234"))
					.thenReturn("Test");
			String responseJson = "{\"patientName\":\"PANKAJ1\"}";
			String practitionerResponseType = "{\"practitionerResponseType\":\"PANKAJ2\"}";
			String organizationResponseType = "{\"organizationResponseType\":\"PANKAJ3\"}";
			CDRResponseModel cDRResponseModel = new CDRResponseModel();
			cDRResponseModel.setLogicalId("1234");
			cDRResponseModel.setResourceType("Patient");
			cDRResponseModel.setVersionId("963");
			PatientDTO patientDTO = new PatientDTO();
			patientDTO.setOrganizationId("12345");
			patientDTO.setOrganizationResponse(organizationResponseType);
			patientDTO.setOrganizationResponseType(organizationResponseType);
			patientDTO.setPatientId("67883");
			patientDTO.setPractitionerId("78393");
			patientDTO.setPractitionerResponse(practitionerResponseType);
			patientDTO.setPractitionerResponseType(practitionerResponseType);
			patientDTO.setResponse(responseJson);
			Mockito.when(updateDetails.updateDetail(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
					.thenReturn(patientDTO);
			assertNotNull(responseJsonController.executePostgreSQLQuery(cDRResponseModel));
		}
	}

	@Test
	@DisplayName("This Test case is to check wheather resourceType is MedicationRequest or not")
	void executePostgreSQLQuery_MedicationRequestTest() throws IOException, JSONException, SQLException {
		try (MockedStatic mocked = mockStatic(HSDPIAMService.class)) {
			mocked.when(() -> HSDPIAMService.generateIamToken("Srinu", "Srinu", "Reddy", "Bijjam", "1234"))
					.thenReturn("Test");
			String responseJson = "{\"patientName\":\"PANKAJ1\"}";
			String practitionerResponseType = "{\"practitionerResponseType\":\"PANKAJ2\"}";
			String medicationResponseType = "{\"medicationResponseType\":\"PANKAJ3\"}";
			String medicationResponse = "{\"medicationResponse\":\"PANKAJ3\"}";
			CDRResponseModel cDRResponseModel = new CDRResponseModel();
			cDRResponseModel.setLogicalId("1234");
			cDRResponseModel.setResourceType("MedicationRequest");
			cDRResponseModel.setVersionId("963");
			PatientDTO patientDTO = new PatientDTO();
			patientDTO.setOrganizationId("12345");
			patientDTO.setPatientId("67883");
			patientDTO.setPractitionerId("78393");
			patientDTO.setPractitionerResponse(practitionerResponseType);
			patientDTO.setPractitionerResponseType(practitionerResponseType);
			patientDTO.setMedicationResponse(medicationResponse);
			patientDTO.setMedicationResponseType(medicationResponseType);
			patientDTO.setResponse(responseJson);
			Mockito.when(updateDetails.updateDetail(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
					.thenReturn(patientDTO);
			assertNotNull(responseJsonController.executePostgreSQLQuery(cDRResponseModel));
		}
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is Patient or not")
	void connectToDb_PatientTest() throws SQLException {
		try (MockedStatic mocked = mockStatic(DriverManager.class)) {
			mocked.when(() -> DriverManager.getConnection(Mockito.any(), Mockito.any())).thenReturn(connection);
			Mockito.when(connection.createStatement()).thenReturn(statement);
			JSONObject object = new JSONObject();
			responseJsonController.connectToDb("Srinu", "Patient", object, "2022-11-28 11:12:45");
		}
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is Observation or not")
	void connectToDb_ObservationTest() throws SQLException {
		try (MockedStatic mocked = mockStatic(DriverManager.class)) {
			mocked.when(() -> DriverManager.getConnection(Mockito.any(), Mockito.any())).thenReturn(connection);
			Mockito.when(connection.createStatement()).thenReturn(statement);
			JSONObject object = new JSONObject();
			responseJsonController.connectToDb("Srinu", "Observation", object, "2022-11-28 11:12:45");
		}
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is Encounter or not")
	void connectToDb_EncounterTest() throws SQLException {
		try (MockedStatic mocked = mockStatic(DriverManager.class)) {
			mocked.when(() -> DriverManager.getConnection(Mockito.any(), Mockito.any())).thenReturn(connection);
			Mockito.when(connection.createStatement()).thenReturn(statement);
			JSONObject object = new JSONObject();
			responseJsonController.connectToDb("Srinu", "Encounter", object, "2022-11-28 11:12:45");
		}
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is Condition or not")
	void connectToDb_ConditionTest() throws SQLException {
		try (MockedStatic mocked = mockStatic(DriverManager.class)) {
			mocked.when(() -> DriverManager.getConnection(Mockito.any(), Mockito.any())).thenReturn(connection);
			Mockito.when(connection.createStatement()).thenReturn(statement);
			JSONObject object = new JSONObject();
			responseJsonController.connectToDb("Srinu", "Condition", object, "2022-11-28 11:12:45");
		}
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is AllergyIntolerance or not")
	void connectToDb_AllergyIntoleranceTest() throws SQLException {
		try (MockedStatic mocked = mockStatic(DriverManager.class)) {
			mocked.when(() -> DriverManager.getConnection(Mockito.any(), Mockito.any())).thenReturn(connection);
			Mockito.when(connection.createStatement()).thenReturn(statement);
			JSONObject object = new JSONObject();
			responseJsonController.connectToDb("Srinu", "AllergyIntolerance", object, "2022-11-28 11:12:45");
		}
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is Immunization or not")
	void connectToDb_ImmunizationTest() throws SQLException {
		try (MockedStatic mocked = mockStatic(DriverManager.class)) {
			mocked.when(() -> DriverManager.getConnection(Mockito.any(), Mockito.any())).thenReturn(connection);
			Mockito.when(connection.createStatement()).thenReturn(statement);
			JSONObject object = new JSONObject();
			responseJsonController.connectToDb("Srinu", "Immunization", object, "2022-11-28 11:12:45");
		}
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is Organization or not")
	void connectToDb_OrganizationTest() throws SQLException {
		try (MockedStatic mocked = mockStatic(DriverManager.class)) {
			mocked.when(() -> DriverManager.getConnection(Mockito.any(), Mockito.any())).thenReturn(connection);
			Mockito.when(connection.createStatement()).thenReturn(statement);
			JSONObject object = new JSONObject();
			responseJsonController.connectToDb("Srinu", "Organization", object, "2022-11-28 11:12:45");
		}
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is Practitioner or not")
	void connectToDb_PractitionerTest() throws SQLException {
		try (MockedStatic mocked = mockStatic(DriverManager.class)) {
			mocked.when(() -> DriverManager.getConnection(Mockito.any(), Mockito.any())).thenReturn(connection);
			Mockito.when(connection.createStatement()).thenReturn(statement);
			JSONObject object = new JSONObject();
			responseJsonController.connectToDb("Srinu", "Practitioner", object, "2022-11-28 11:12:45");
		}
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is MedicationRequest or not")
	void connectToDb_MedicationRequestTest() throws SQLException {
		try (MockedStatic mocked = mockStatic(DriverManager.class)) {
			mocked.when(() -> DriverManager.getConnection(Mockito.any(), Mockito.any())).thenReturn(connection);
			Mockito.when(connection.createStatement()).thenReturn(statement);
			JSONObject object = new JSONObject();
			responseJsonController.connectToDb("Srinu", "MedicationRequest", object, "2022-11-28 11:12:45");
		}
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is MedicationStatement or not")
	void connectToDb_MedicationStatementTest() throws SQLException {
		try (MockedStatic mocked = mockStatic(DriverManager.class)) {
			mocked.when(() -> DriverManager.getConnection(Mockito.any(), Mockito.any())).thenReturn(connection);
			Mockito.when(connection.createStatement()).thenReturn(statement);
			JSONObject object = new JSONObject();
			responseJsonController.connectToDb("Srinu", "MedicationStatement", object, "2022-11-28 11:12:45");
		}
	}
}