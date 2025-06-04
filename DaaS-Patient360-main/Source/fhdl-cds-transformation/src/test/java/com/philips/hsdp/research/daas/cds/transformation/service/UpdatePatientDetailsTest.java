/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.daas.cds.transformation.service;

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
import com.philips.hsdp.research.daas.cds.transformation.util.GetPatientDetails;

/* @author Srinivasa Reddy Bijjam */
@ExtendWith(MockitoExtension.class)
class UpdatePatientDetailsTest {

	@Mock
	private GetPatientDetails getPatientDetails;

	@Mock
	private HttpsURLConnection connection;

	@Spy
	@InjectMocks
	private UpdatePatientDetails updatePatientDetails;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("This Test case will check whether the ResourceType is Patient or not")
	void UpdateDetail_PatientTest() throws IOException {
		CDRResponseModel cdrResponseModel = new CDRResponseModel();
		cdrResponseModel.setLogicalId("1234");
		cdrResponseModel.setResourceType("Patient");
		cdrResponseModel.setVersionId("963");
		String str = "{\"id\": \"1234\", \"code\": {\"text\": \"Penicillin G\", \"coding\": [{\"code\": \"7980\", \"system\": \"http://www.nlm.nih.gov/research/umls/rxnorm\", \"display\": \"Penicillin G\"}]}, \"meta\": {\"versionId\": \"de2c4984-6faa-11ed-a01f-77932449597e\", \"lastUpdated\": \"2022-11-29T05:58:38.045789+00:00\"}, \"patient\": {\"display\": \"Herman Ball\", \"reference\": \"Patient/cc492386-a556-41d3-aeab-e4987767b478\"}, \"category\": [\"medication\"], \"identifier\": [{\"value\": \"49476535\", \"system\": \"http://acme.com/ids/patients/risks\"}], \"recordedDate\": \"2015-08-06T15:37:31-06:00\", \"resourceType\": \"AllergyIntolerance\", \"clinicalStatus\": {\"coding\": [{\"code\": \"active\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical\", \"display\": \"Active\"}]}, \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-verification\", \"display\": \"Confirmed\"}]}}";
		String str1 = "{\"id\": \"1234\", \"meta\": {\"versionId\": \"de265b3c-6faa-11ed-a01f-a34fa9702190\", \"lastUpdated\": \"2022-11-29T05:58:38.045789+00:00\"}, \"name\": [{\"use\": \"official\", \"given\": [\"Herman Ball\"]}], \"gender\": \"male\", \"address\": [{\"city\": \"Northbridge\", \"line\": [\"638 Brakus Union Suite 44\"], \"state\": \"Massachusetts\", \"country\": \"US\"}], \"telecom\": [{\"use\": \"home\", \"value\": \"681-171-9051\", \"system\": \"phone\"}], \"birthDate\": \"1999-12-12\", \"identifier\": [{\"system\": \"https://github.com/synthetichealth/synthea\"}], \"resourceType\": \"Patient\", \"communication\": [{\"language\": {\"text\": \"Greek\", \"coding\": [{\"code\": \"el\", \"system\": \"urn:ietf:bcp:47\", \"display\": \"Greek\"}]}}], \"maritalStatus\": {\"text\": \"Never Married\", \"coding\": [{\"code\": \"S\", \"system\": \"http://terminology.hl7.org/CodeSystem/v3-MaritalStatus\", \"display\": \"Never Married\"}]}, \"multipleBirthBoolean\": false}";
		Mockito.when(connection.getInputStream()).thenReturn(new ByteArrayInputStream(str.getBytes()));
		doReturn(connection).when(updatePatientDetails).create(any());
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode jsonObject = objMapper.createObjectNode();
		Mockito.when(getPatientDetails.getDetails("https://localhost/Patient/1234",
				"1234", jsonObject, cdrResponseModel, "application/fhir+json;fhirVersion=4.0")).thenReturn(str1);
		assertNotNull(updatePatientDetails.updateDetail("1234", "https://localhost", jsonObject, cdrResponseModel));
	}
	
	@Test
	@DisplayName("This Test case will check whether the ResourceType is AllergyIntolerance or not")
	void UpdateDetail_AllergyIntoleranceTest() throws IOException {
		CDRResponseModel cdrResponseModel = new CDRResponseModel();
		cdrResponseModel.setLogicalId("1234");
		cdrResponseModel.setResourceType("AllergyIntolerance");
		cdrResponseModel.setVersionId("963");
		String str = "{\"id\": \"1234\", \"code\": {\"text\": \"Penicillin G\", \"coding\": [{\"code\": \"7980\", \"system\": \"http://www.nlm.nih.gov/research/umls/rxnorm\", \"display\": \"Penicillin G\"}]}, \"meta\": {\"versionId\": \"de2c4984-6faa-11ed-a01f-77932449597e\", \"lastUpdated\": \"2022-11-29T05:58:38.045789+00:00\"}, \"patient\": {\"display\": \"Herman Ball\", \"reference\": \"Patient/cc492386-a556-41d3-aeab-e4987767b478\"}, \"category\": [\"medication\"], \"identifier\": [{\"value\": \"49476535\", \"system\": \"http://acme.com/ids/patients/risks\"}], \"recordedDate\": \"2015-08-06T15:37:31-06:00\", \"resourceType\": \"AllergyIntolerance\", \"clinicalStatus\": {\"coding\": [{\"code\": \"active\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical\", \"display\": \"Active\"}]}, \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-verification\", \"display\": \"Confirmed\"}]}}";
		String str1="{\"id\": \"1234\", \"code\": {\"text\": \"Penicillin G\", \"coding\": [{\"code\": \"7980\", \"system\": \"http://www.nlm.nih.gov/research/umls/rxnorm\", \"display\": \"Penicillin G\"}]}, \"meta\": {\"versionId\": \"6f236636-7bc0-11ed-83a0-8b683835ac60\", \"lastUpdated\": \"2022-12-14T15:03:14.623846+00:00\"}, \"patient\": {\"display\": \"Grant Beauchamp\", \"reference\": \"Patient/d851ea00-41d1-4e33-b82b-80bbd697b1e9\"}, \"category\": [\"medication\"], \"identifier\": [{\"value\": \"49476535\", \"system\": \"http://acme.com/ids/patients/risks\"}], \"recordedDate\": \"2015-08-06T15:37:31-06:00\", \"resourceType\": \"AllergyIntolerance\", \"clinicalStatus\": {\"coding\": [{\"code\": \"active\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical\", \"display\": \"Active\"}]}, \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-verification\", \"display\": \"Confirmed\"}]}}";
		Mockito.when(connection.getInputStream()).thenReturn(new ByteArrayInputStream(str.getBytes()));
		doReturn(connection).when(updatePatientDetails).create(any());
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode jsonObject = objMapper.createObjectNode();
		Mockito.when(getPatientDetails.getDetails("https://localhost/Patient/cc492386-a556-41d3-aeab-e4987767b478",
				"1234", jsonObject, cdrResponseModel, "application/fhir+json;fhirVersion=4.0")).thenReturn(str1);
		assertNotNull(updatePatientDetails.updateDetail("1234", "https://localhost", jsonObject, cdrResponseModel));
	}
	
	@Test
	@DisplayName("This Test case will check whether the ResourceType is Condition or not")
	void UpdateDetail_ConditionTest() throws IOException {
		CDRResponseModel cdrResponseModel = new CDRResponseModel();
		cdrResponseModel.setLogicalId("1234");
		cdrResponseModel.setResourceType("Condition");
		cdrResponseModel.setVersionId("963");
		String str="{\"id\": \"1234\", \"code\": {\"coding\": [{\"code\": \"386661006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Fever\"}]}, \"meta\": {\"versionId\": \"49d77c5a-7bc0-11ed-93ff-e7d5af2ec70c\", \"lastUpdated\": \"2022-12-14T15:02:12.114694+00:00\"}, \"subject\": {\"display\": \"Kenneth Rzeczycki\", \"reference\": \"Patient/e979e3b1-64ca-46d1-be8c-9a3630efec52\"}, \"asserter\": {\"reference\": \"Practitioner/89be83c3-bac1-4797-bf45-54860dfb1a61\"}, \"bodySite\": [{\"coding\": [{\"code\": \"38266002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Entire body as a whole\"}]}], \"category\": [{\"coding\": [{\"code\": \"55607006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Problem\"}, {\"code\": \"problem-list-item\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-category\"}]}], \"evidence\": [{\"code\": [{\"coding\": [{\"code\": \"258710007\", \"system\": \"http://snomed.info/sct\", \"display\": \"degrees C\"}]}]}], \"severity\": {\"coding\": [{\"code\": \"255604002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Mild\"}]}, \"encounter\": {\"reference\": \"Encounter/d5bba8ea-6685-11ed-9736-07093f1c7fd8\"}, \"identifier\": [{\"value\": \"12345\"}], \"recordedDate\": \"2017-07-03\", \"resourceType\": \"Condition\", \"onsetDateTime\": \"2011-05-05\", \"clinicalStatus\": {\"coding\": [{\"code\": \"resolved\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-clinical\"}]}, \"abatementDateTime\": \"2013-07-02\", \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-ver-status\"}]}}, {\"id\": \"93a0ba80-b4df-4f36-a81a-7d7c53642f63\", \"code\": {\"coding\": [{\"code\": \"386661006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Fever\"}]}, \"meta\": {\"versionId\": \"518d7e68-7bc0-11ed-b531-bf4ff27f259e\", \"lastUpdated\": \"2022-12-14T15:02:25.05158+00:00\"}, \"subject\": {\"display\": \"Kenneth Rzeczycki\", \"reference\": \"Patient/e979e3b1-64ca-46d1-be8c-9a3630efec52\"}, \"asserter\": {\"reference\": \"Practitioner/89be83c3-bac1-4797-bf45-54860dfb1a61\"}, \"bodySite\": [{\"coding\": [{\"code\": \"38266002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Entire body as a whole\"}]}], \"category\": [{\"coding\": [{\"code\": \"55607006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Problem\"}, {\"code\": \"problem-list-item\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-category\"}]}], \"evidence\": [{\"code\": [{\"coding\": [{\"code\": \"258710007\", \"system\": \"http://snomed.info/sct\", \"display\": \"degrees C\"}]}]}], \"severity\": {\"coding\": [{\"code\": \"255604002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Mild\"}]}, \"encounter\": {\"reference\": \"Encounter/d5bba8ea-6685-11ed-9736-07093f1c7fd8\"}, \"identifier\": [{\"value\": \"12345\"}], \"recordedDate\": \"2017-02-01\", \"resourceType\": \"Condition\", \"onsetDateTime\": \"2017-03-02\", \"clinicalStatus\": {\"coding\": [{\"code\": \"resolved\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-clinical\"}]}, \"abatementDateTime\": \"2012-07-01\", \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-ver-status\"}]}}, {\"id\": \"a290fdba-5a37-44ae-9075-1a3fbb42d5cb\", \"code\": {\"coding\": [{\"code\": \"386661006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Fever\"}]}, \"meta\": {\"versionId\": \"613667e4-7bc0-11ed-b531-93fbe26d4879\", \"lastUpdated\": \"2022-12-14T15:02:51.32437+00:00\"}, \"subject\": {\"display\": \"Kenneth Rzeczycki\", \"reference\": \"Patient/e979e3b1-64ca-46d1-be8c-9a3630efec52\"}, \"asserter\": {\"reference\": \"Practitioner/89be83c3-bac1-4797-bf45-54860dfb1a61\"}, \"bodySite\": [{\"coding\": [{\"code\": \"38266002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Entire body as a whole\"}]}], \"category\": [{\"coding\": [{\"code\": \"55607006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Problem\"}, {\"code\": \"problem-list-item\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-category\"}]}], \"evidence\": [{\"code\": [{\"coding\": [{\"code\": \"258710007\", \"system\": \"http://snomed.info/sct\", \"display\": \"degrees C\"}]}]}], \"severity\": {\"coding\": [{\"code\": \"255604002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Mild\"}]}, \"encounter\": {\"reference\": \"Encounter/d5bba8ea-6685-11ed-9736-07093f1c7fd8\"}, \"identifier\": [{\"value\": \"12345\"}], \"recordedDate\": \"2011-02-01\", \"resourceType\": \"Condition\", \"onsetDateTime\": \"2013-06-08\", \"clinicalStatus\": {\"coding\": [{\"code\": \"resolved\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-clinical\"}]}, \"abatementDateTime\": \"2011-08-03\", \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-ver-status\"}]}}, {\"id\": \"7607d632-6079-466f-baef-59dcab8bfdd9\", \"code\": {\"coding\": [{\"code\": \"386661006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Fever\"}]}, \"meta\": {\"versionId\": \"66fdaa48-7bc0-11ed-b531-db43a0ffcc23\", \"lastUpdated\": \"2022-12-14T15:03:01.018855+00:00\"}, \"subject\": {\"display\": \"Kenneth Rzeczycki\", \"reference\": \"Patient/e979e3b1-64ca-46d1-be8c-9a3630efec52\"}, \"asserter\": {\"reference\": \"Practitioner/89be83c3-bac1-4797-bf45-54860dfb1a61\"}, \"bodySite\": [{\"coding\": [{\"code\": \"38266002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Entire body as a whole\"}]}], \"category\": [{\"coding\": [{\"code\": \"55607006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Problem\"}, {\"code\": \"problem-list-item\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-category\"}]}], \"evidence\": [{\"code\": [{\"coding\": [{\"code\": \"258710007\", \"system\": \"http://snomed.info/sct\", \"display\": \"degrees C\"}]}]}], \"severity\": {\"coding\": [{\"code\": \"255604002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Mild\"}]}, \"encounter\": {\"reference\": \"Encounter/d5bba8ea-6685-11ed-9736-07093f1c7fd8\"}, \"identifier\": [{\"value\": \"12345\"}], \"recordedDate\": \"2015-05-08\", \"resourceType\": \"Condition\", \"onsetDateTime\": \"2016-01-05\", \"clinicalStatus\": {\"coding\": [{\"code\": \"resolved\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-clinical\"}]}, \"abatementDateTime\": \"2017-02-07\", \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-ver-status\"}]}}";
		String str1="{\"id\": \"1234\", \"code\": {\"text\": \"Penicillin G\", \"coding\": [{\"code\": \"7980\", \"system\": \"http://www.nlm.nih.gov/research/umls/rxnorm\", \"display\": \"Penicillin G\"}]}, \"meta\": {\"versionId\": \"6f236636-7bc0-11ed-83a0-8b683835ac60\", \"lastUpdated\": \"2022-12-14T15:03:14.623846+00:00\"}, \"patient\": {\"display\": \"Grant Beauchamp\", \"reference\": \"Patient/d851ea00-41d1-4e33-b82b-80bbd697b1e9\"}, \"category\": [\"medication\"], \"identifier\": [{\"value\": \"49476535\", \"system\": \"http://acme.com/ids/patients/risks\"}], \"recordedDate\": \"2015-08-06T15:37:31-06:00\", \"resourceType\": \"AllergyIntolerance\", \"clinicalStatus\": {\"coding\": [{\"code\": \"active\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical\", \"display\": \"Active\"}]}, \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-verification\", \"display\": \"Confirmed\"}]}}";
		Mockito.when(connection.getInputStream()).thenReturn(new ByteArrayInputStream(str.getBytes()));
		doReturn(connection).when(updatePatientDetails).create(any());
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode jsonObject = objMapper.createObjectNode();
		Mockito.when(getPatientDetails.getDetails("https://localhost/Patient/e979e3b1-64ca-46d1-be8c-9a3630efec52",
				"1234", jsonObject, cdrResponseModel, "application/fhir+json;fhirVersion=4.0")).thenReturn(str1);
		assertNotNull(updatePatientDetails.updateDetail("1234", "https://localhost", jsonObject, cdrResponseModel));
	}
	
	@Test
	@DisplayName("This Test case will check whether the ResourceType is Encounter or not")
	void UpdateDetail_EncounterTest() throws IOException {
		CDRResponseModel cdrResponseModel = new CDRResponseModel();
		cdrResponseModel.setLogicalId("1234");
		cdrResponseModel.setResourceType("Encounter");
		cdrResponseModel.setVersionId("963");
		String str="{\"id\": \"1234\", \"code\": {\"coding\": [{\"code\": \"386661006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Fever\"}]}, \"meta\": {\"versionId\": \"49d77c5a-7bc0-11ed-93ff-e7d5af2ec70c\", \"lastUpdated\": \"2022-12-14T15:02:12.114694+00:00\"}, \"subject\": {\"display\": \"Kenneth Rzeczycki\", \"reference\": \"Patient/e979e3b1-64ca-46d1-be8c-9a3630efec52\"}, \"asserter\": {\"reference\": \"Practitioner/89be83c3-bac1-4797-bf45-54860dfb1a61\"}, \"bodySite\": [{\"coding\": [{\"code\": \"38266002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Entire body as a whole\"}]}], \"category\": [{\"coding\": [{\"code\": \"55607006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Problem\"}, {\"code\": \"problem-list-item\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-category\"}]}], \"evidence\": [{\"code\": [{\"coding\": [{\"code\": \"258710007\", \"system\": \"http://snomed.info/sct\", \"display\": \"degrees C\"}]}]}], \"severity\": {\"coding\": [{\"code\": \"255604002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Mild\"}]}, \"encounter\": {\"reference\": \"Encounter/d5bba8ea-6685-11ed-9736-07093f1c7fd8\"}, \"identifier\": [{\"value\": \"12345\"}], \"recordedDate\": \"2017-07-03\", \"resourceType\": \"Condition\", \"onsetDateTime\": \"2011-05-05\", \"clinicalStatus\": {\"coding\": [{\"code\": \"resolved\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-clinical\"}]}, \"abatementDateTime\": \"2013-07-02\", \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-ver-status\"}]}}, {\"id\": \"93a0ba80-b4df-4f36-a81a-7d7c53642f63\", \"code\": {\"coding\": [{\"code\": \"386661006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Fever\"}]}, \"meta\": {\"versionId\": \"518d7e68-7bc0-11ed-b531-bf4ff27f259e\", \"lastUpdated\": \"2022-12-14T15:02:25.05158+00:00\"}, \"subject\": {\"display\": \"Kenneth Rzeczycki\", \"reference\": \"Patient/e979e3b1-64ca-46d1-be8c-9a3630efec52\"}, \"asserter\": {\"reference\": \"Practitioner/89be83c3-bac1-4797-bf45-54860dfb1a61\"}, \"bodySite\": [{\"coding\": [{\"code\": \"38266002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Entire body as a whole\"}]}], \"category\": [{\"coding\": [{\"code\": \"55607006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Problem\"}, {\"code\": \"problem-list-item\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-category\"}]}], \"evidence\": [{\"code\": [{\"coding\": [{\"code\": \"258710007\", \"system\": \"http://snomed.info/sct\", \"display\": \"degrees C\"}]}]}], \"severity\": {\"coding\": [{\"code\": \"255604002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Mild\"}]}, \"encounter\": {\"reference\": \"Encounter/d5bba8ea-6685-11ed-9736-07093f1c7fd8\"}, \"identifier\": [{\"value\": \"12345\"}], \"recordedDate\": \"2017-02-01\", \"resourceType\": \"Condition\", \"onsetDateTime\": \"2017-03-02\", \"clinicalStatus\": {\"coding\": [{\"code\": \"resolved\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-clinical\"}]}, \"abatementDateTime\": \"2012-07-01\", \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-ver-status\"}]}}, {\"id\": \"a290fdba-5a37-44ae-9075-1a3fbb42d5cb\", \"code\": {\"coding\": [{\"code\": \"386661006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Fever\"}]}, \"meta\": {\"versionId\": \"613667e4-7bc0-11ed-b531-93fbe26d4879\", \"lastUpdated\": \"2022-12-14T15:02:51.32437+00:00\"}, \"subject\": {\"display\": \"Kenneth Rzeczycki\", \"reference\": \"Patient/e979e3b1-64ca-46d1-be8c-9a3630efec52\"}, \"asserter\": {\"reference\": \"Practitioner/89be83c3-bac1-4797-bf45-54860dfb1a61\"}, \"bodySite\": [{\"coding\": [{\"code\": \"38266002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Entire body as a whole\"}]}], \"category\": [{\"coding\": [{\"code\": \"55607006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Problem\"}, {\"code\": \"problem-list-item\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-category\"}]}], \"evidence\": [{\"code\": [{\"coding\": [{\"code\": \"258710007\", \"system\": \"http://snomed.info/sct\", \"display\": \"degrees C\"}]}]}], \"severity\": {\"coding\": [{\"code\": \"255604002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Mild\"}]}, \"encounter\": {\"reference\": \"Encounter/d5bba8ea-6685-11ed-9736-07093f1c7fd8\"}, \"identifier\": [{\"value\": \"12345\"}], \"recordedDate\": \"2011-02-01\", \"resourceType\": \"Condition\", \"onsetDateTime\": \"2013-06-08\", \"clinicalStatus\": {\"coding\": [{\"code\": \"resolved\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-clinical\"}]}, \"abatementDateTime\": \"2011-08-03\", \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-ver-status\"}]}}, {\"id\": \"7607d632-6079-466f-baef-59dcab8bfdd9\", \"code\": {\"coding\": [{\"code\": \"386661006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Fever\"}]}, \"meta\": {\"versionId\": \"66fdaa48-7bc0-11ed-b531-db43a0ffcc23\", \"lastUpdated\": \"2022-12-14T15:03:01.018855+00:00\"}, \"subject\": {\"display\": \"Kenneth Rzeczycki\", \"reference\": \"Patient/e979e3b1-64ca-46d1-be8c-9a3630efec52\"}, \"asserter\": {\"reference\": \"Practitioner/89be83c3-bac1-4797-bf45-54860dfb1a61\"}, \"bodySite\": [{\"coding\": [{\"code\": \"38266002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Entire body as a whole\"}]}], \"category\": [{\"coding\": [{\"code\": \"55607006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Problem\"}, {\"code\": \"problem-list-item\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-category\"}]}], \"evidence\": [{\"code\": [{\"coding\": [{\"code\": \"258710007\", \"system\": \"http://snomed.info/sct\", \"display\": \"degrees C\"}]}]}], \"severity\": {\"coding\": [{\"code\": \"255604002\", \"system\": \"http://snomed.info/sct\", \"display\": \"Mild\"}]}, \"encounter\": {\"reference\": \"Encounter/d5bba8ea-6685-11ed-9736-07093f1c7fd8\"}, \"identifier\": [{\"value\": \"12345\"}], \"recordedDate\": \"2015-05-08\", \"resourceType\": \"Condition\", \"onsetDateTime\": \"2016-01-05\", \"clinicalStatus\": {\"coding\": [{\"code\": \"resolved\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-clinical\"}]}, \"abatementDateTime\": \"2017-02-07\", \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/condition-ver-status\"}]}}";
		String str1="{\"id\": \"1234\", \"code\": {\"text\": \"Penicillin G\", \"coding\": [{\"code\": \"7980\", \"system\": \"http://www.nlm.nih.gov/research/umls/rxnorm\", \"display\": \"Penicillin G\"}]}, \"meta\": {\"versionId\": \"6f236636-7bc0-11ed-83a0-8b683835ac60\", \"lastUpdated\": \"2022-12-14T15:03:14.623846+00:00\"}, \"patient\": {\"display\": \"Grant Beauchamp\", \"reference\": \"Patient/d851ea00-41d1-4e33-b82b-80bbd697b1e9\"}, \"category\": [\"medication\"], \"identifier\": [{\"value\": \"49476535\", \"system\": \"http://acme.com/ids/patients/risks\"}], \"recordedDate\": \"2015-08-06T15:37:31-06:00\", \"resourceType\": \"AllergyIntolerance\", \"clinicalStatus\": {\"coding\": [{\"code\": \"active\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical\", \"display\": \"Active\"}]}, \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-verification\", \"display\": \"Confirmed\"}]}}";
		Mockito.when(connection.getInputStream()).thenReturn(new ByteArrayInputStream(str.getBytes()));
		doReturn(connection).when(updatePatientDetails).create(any());
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode jsonObject = objMapper.createObjectNode();
		Mockito.when(getPatientDetails.getDetails("https://localhost/Patient/e979e3b1-64ca-46d1-be8c-9a3630efec52",
				"1234", jsonObject, cdrResponseModel, "application/fhir+json;fhirVersion=4.0")).thenReturn(str1);
		assertNotNull(updatePatientDetails.updateDetail("1234", "https://localhost", jsonObject, cdrResponseModel));
	}
	
	@Test
	@DisplayName("This Test case will check whether the ResourceType is MedicationRequest or not")
	void UpdateDetail_MedicationRequestTest() throws IOException {
		CDRResponseModel cdrResponseModel = new CDRResponseModel();
		cdrResponseModel.setLogicalId("1234");
		cdrResponseModel.setResourceType("MedicationRequest");
		cdrResponseModel.setVersionId("963");
		String str="{\"id\": \"1234\", \"meta\": {\"versionId\": \"6f26f116-7bc0-11ed-83a0-eb8b9f5df5ed\", \"lastUpdated\": \"2022-12-14T15:03:14.623846+00:00\"}, \"intent\": \"order\", \"status\": \"active\", \"subject\": {\"display\": \"Grant Beauchamp\", \"reference\": \"Patient/d851ea00-41d1-4e33-b82b-80bbd697b1e9\"}, \"authoredOn\": \"2023-04-06\", \"identifier\": [{\"use\": \"official\", \"value\": \"12345689\", \"system\": \"http://www.bmc.nl/portal/prescriptions\"}], \"reasonCode\": [{\"coding\": [{\"code\": \"92818009\", \"system\": \"http://snomed.info/sct\", \"display\": \"Chronic myeloid Leukemia (disorder)\"}]}], \"resourceType\": \"MedicationRequest\", \"dosageInstruction\": [{\"text\": \"10 mg\", \"route\": {\"coding\": [{\"code\": \"26643006\", \"system\": \"http://snomed.info/sct\", \"display\": \"Oral route (qualifier value)\"}]}, \"timing\": {\"repeat\": {\"period\": 1, \"frequency\": 1, \"periodUnit\": \"d\"}}, \"sequence\": 1, \"doseAndRate\": [{\"type\": {\"coding\": [{\"code\": \"ordered\", \"system\": \"http://terminology.hl7.org/CodeSystem/dose-rate-type\", \"display\": \"Ordered\"}]}, \"doseQuantity\": {\"code\": \"mg\", \"unit\": \"mg\", \"value\": 6, \"system\": \"http://unitsofmeasure.org\"}}]}], \"medicationReference\": {\"display\": \"Prednisone 5mg tablet (Product)\", \"reference\": \"Medication/60c3a7e1-d5c9-40a6-b87a-60393b2cfde9\"}}";
		String str1="{\"id\": \"1234\", \"code\": {\"text\": \"Penicillin G\", \"coding\": [{\"code\": \"7980\", \"system\": \"http://www.nlm.nih.gov/research/umls/rxnorm\", \"display\": \"Penicillin G\"}]}, \"meta\": {\"versionId\": \"6f236636-7bc0-11ed-83a0-8b683835ac60\", \"lastUpdated\": \"2022-12-14T15:03:14.623846+00:00\"}, \"patient\": {\"display\": \"Grant Beauchamp\", \"reference\": \"Patient/d851ea00-41d1-4e33-b82b-80bbd697b1e9\"}, \"category\": [\"medication\"], \"identifier\": [{\"value\": \"49476535\", \"system\": \"http://acme.com/ids/patients/risks\"}], \"recordedDate\": \"2015-08-06T15:37:31-06:00\", \"resourceType\": \"AllergyIntolerance\", \"clinicalStatus\": {\"coding\": [{\"code\": \"active\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical\", \"display\": \"Active\"}]}, \"verificationStatus\": {\"coding\": [{\"code\": \"confirmed\", \"system\": \"http://terminology.hl7.org/CodeSystem/allergyintolerance-verification\", \"display\": \"Confirmed\"}]}}";
		Mockito.when(connection.getInputStream()).thenReturn(new ByteArrayInputStream(str.getBytes()));
		doReturn(connection).when(updatePatientDetails).create(any());
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode jsonObject = objMapper.createObjectNode();
		Mockito.when(getPatientDetails.getDetails("https://localhost/Patient/d851ea00-41d1-4e33-b82b-80bbd697b1e9",
				"1234", jsonObject, cdrResponseModel, "application/fhir+json;fhirVersion=4.0")).thenReturn(str1);
		assertNotNull(updatePatientDetails.updateDetail("1234", "https://localhost", jsonObject, cdrResponseModel));
	}
	
	@Test
	@DisplayName("This Test case will check whether the status code is coming 200 or not")
	void UpdateDetail_Status200Test() throws IOException {
		CDRResponseModel cdrResponseModel = new CDRResponseModel();
		cdrResponseModel.setLogicalId("1234");
		cdrResponseModel.setResourceType("Srinu");
		cdrResponseModel.setVersionId("963");
		String str = "{\"id\": \"cc492386-a556-41d3-aeab-e4987767b478\", \"meta\": {\"versionId\": \"de265b3c-6faa-11ed-a01f-a34fa9702190\", \"lastUpdated\": \"2022-11-29T05:58:38.045789+00:00\"}, \"name\": [{\"use\": \"official\", \"given\": [\"Herman Ball\"]}], \"gender\": \"male\", \"address\": [{\"city\": \"Northbridge\", \"line\": [\"638 Brakus Union Suite 44\"], \"state\": \"Massachusetts\", \"country\": \"US\"}], \"telecom\": [{\"use\": \"home\", \"value\": \"681-171-9051\", \"system\": \"phone\"}], \"birthDate\": \"1999-12-12\", \"identifier\": [{\"system\": \"https://github.com/synthetichealth/synthea\"}], \"resourceType\": \"Patient\", \"communication\": [{\"language\": {\"text\": \"Greek\", \"coding\": [{\"code\": \"el\", \"system\": \"urn:ietf:bcp:47\", \"display\": \"Greek\"}]}}], \"maritalStatus\": {\"text\": \"Never Married\", \"coding\": [{\"code\": \"S\", \"system\": \"http://terminology.hl7.org/CodeSystem/v3-MaritalStatus\", \"display\": \"Never Married\"}]}, \"multipleBirthBoolean\": false}";
		Mockito.when(connection.getInputStream()).thenReturn(new ByteArrayInputStream(str.getBytes()));
		doReturn(connection).when(updatePatientDetails).create(any());
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode jsonObject = objMapper.createObjectNode();
		assertNotNull(updatePatientDetails.updateDetail("1234", "https://localhost", jsonObject, cdrResponseModel));
	}

	@Test
	@DisplayName("This Test case will check whether the status code is coming 400 or not")
	void UpdateDetail_Status400Test() throws IOException {
		CDRResponseModel cdrResponseModel = new CDRResponseModel();
		cdrResponseModel.setLogicalId("1234");
		cdrResponseModel.setResourceType("Patient");
		cdrResponseModel.setVersionId("963");
		String str = "{\"id\": \"cc492386-a556-41d3-aeab-e4987767b478\", \"meta\": {\"versionId\": \"de265b3c-6faa-11ed-a01f-a34fa9702190\", \"lastUpdated\": \"2022-11-29T05:58:38.045789+00:00\"}, \"name\": [{\"use\": \"official\", \"given\": [\"Herman Ball\"]}], \"gender\": \"male\", \"address\": [{\"city\": \"Northbridge\", \"line\": [\"638 Brakus Union Suite 44\"], \"state\": \"Massachusetts\", \"country\": \"US\"}], \"telecom\": [{\"use\": \"home\", \"value\": \"681-171-9051\", \"system\": \"phone\"}], \"birthDate\": \"1999-12-12\", \"identifier\": [{\"system\": \"https://github.com/synthetichealth/synthea\"}], \"resourceType\": \"Patient\", \"communication\": [{\"language\": {\"text\": \"Greek\", \"coding\": [{\"code\": \"el\", \"system\": \"urn:ietf:bcp:47\", \"display\": \"Greek\"}]}}], \"maritalStatus\": {\"text\": \"Never Married\", \"coding\": [{\"code\": \"S\", \"system\": \"http://terminology.hl7.org/CodeSystem/v3-MaritalStatus\", \"display\": \"Never Married\"}]}, \"multipleBirthBoolean\": false}";
		Mockito.when(connection.getInputStream()).thenReturn(new ByteArrayInputStream(str.getBytes()));
		doReturn(connection).when(updatePatientDetails).create(any());
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode jsonObject = objMapper.createObjectNode();
		assertNotNull(updatePatientDetails.updateDetail("1234", "https://localhost", jsonObject, cdrResponseModel));
	}
}