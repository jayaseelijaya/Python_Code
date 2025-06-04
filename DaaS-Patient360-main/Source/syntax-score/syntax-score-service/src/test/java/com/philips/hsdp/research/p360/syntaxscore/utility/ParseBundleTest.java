/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.utility;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

/** @author Raj Kumar */
@SuppressWarnings("deprecation")
@TestMethodOrder(OrderAnnotation.class)
class ParseBundleTest {
	
	@InjectMocks
	ParseBundle parseBundle;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	String bundleString = "{\"resourceType\":\"Bundle\",\"id\":\"f91c937f-7d5a-4bad-86d3-7616f8a20e54\",\"meta\":{\"profile\":[\"https://www.fhir.philips.com\"]},\"type\":\"transaction\",\"entry\":[{\"fullUrl\":\"Patient/2c6aab56-eddb-4d25-a65f-357d6c24d354\",\"resource\":{\"resourceType\":\"Patient\",\"id\":\"2c6aab56-eddb-4d25-a65f-357d6c24d354\",\"meta\":{\"profile\":[\"https://www.fhir.philips.com/4.0/StructureDefinition/common/resource/general/patient-v1/ILSPatient\",\"http://hl7.org/fhir/StructureDefinition/Patient\"]},\"name\":[{\"use\":\"official\",\"family\":\"Maxie\",\"given\":[\"HershelSchulistGutmann\"]}],\"telecom\":[{\"system\":\"phone\",\"value\":\"(407)898-3663\",\"use\":\"work\",\"rank\":1},{\"system\":\"phone\",\"value\":\"466-500-4296\",\"use\":\"mobile\",\"rank\":2}],\"gender\":\"male\",\"birthDate\":\"1980-08-12\",\"deceasedBoolean\":false,\"address\":[{\"use\":\"home\",\"type\":\"both\",\"text\":\"Apt.95485553MedhurstKey,LakeNoah,ME98346\",\"line\":[\"955BuckridgeCanyon\"],\"city\":\"SouthRaystad\",\"district\":\"SouthRuss\",\"state\":\"NewYork\",\"postalCode\":\"23754\",\"country\":\"Panama\"}]},\"request\":{\"method\":\"POST\",\"url\":\"Patient\"}},{\"fullUrl\":\"Observation/e7717e78-bd3a-472e-b0fc-ce159f849e1a\",\"resource\":{\"resourceType\":\"Observation\",\"id\":\"e7717e78-bd3a-472e-b0fc-ce159f849e1a\",\"meta\":{\"profile\":[\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscore\"]},\"status\":\"registered\",\"category\":[{\"coding\":[{\"system\":\"http://terminology.hl7.org/CodeSystem/observation-category\",\"code\":\"exam\",\"display\":\"Exam\"}]}],\"code\":{\"coding\":[{\"system\":\"https://www.fhir.philips.com/4.0/CodeSystem/cardiology/coronaryArteryDisease/summary-v1/CADSummaryCodeSystem\",\"code\":\"SyntaxScore\",\"display\":\"SyntaxScore\"}]},\"subject\":{\"reference\":\"Patient/2c6aab56-eddb-4d25-a65f-357d6c24d354\"},\"effectiveDateTime\":\"2022-11-28T10:17:19+05:30\",\"valueQuantity\":{\"value\":43.0,\"system\":\"http://unitsofmeasure.org\",\"code\":\"{index}\"},\"hasMember\":[{\"reference\":\"Observation/15f4c4ff-92a4-4a7c-bafa-45849427ef16\"},{\"reference\":\"Observation/eb30dad5-866e-4bf1-9de3-566d42487ef8\"},{\"reference\":\"Observation/916bcabb-eac8-49fa-939e-4d961e7b4098\"},{\"reference\":\"Observation/91fa32cc-1ea8-4009-9a00-6fc281ddcbf7\"},{\"reference\":\"Observation/e8cdcb53-2793-4294-9ccd-21e19bf3bd64\"},{\"reference\":\"Observation/e0ac8b94-22d6-48f4-a2a4-87791bcce271\"},{\"reference\":\"Observation/4cc728d6-7016-49a6-a9aa-9c998d5ad389\"},{\"reference\":\"Observation/619828d0-a6b4-4298-a55b-b767904a8e30\"},{\"reference\":\"Observation/508ab331-b033-4cfe-b750-e53d757eaf47\"},{\"reference\":\"Observation/e2568cd6-7fb4-4f69-b977-f8a6a699216f\"},{\"reference\":\"Observation/d2f7dc5d-6117-4f97-b1cb-c31258610267\"},{\"reference\":\"Observation/0930b0fa-49fe-40b7-b625-a9182614696b\"},{\"reference\":\"Observation/9e96d76d-94e5-4438-8570-543a9d9e4c5a\"},{\"reference\":\"Observation/059ff972-d259-459a-9ac5-1af604be4406\"}]},\"request\":{\"method\":\"POST\",\"url\":\"Observation\"}}]}";
	static List<Observation> resultList;
	static Map<String, String> resultMap;
	String observationsString = "<Observation\r\n"
			+ "				xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "				<id value=\"5deeea04-b8f7-454e-bcf8-9778700c3c49\"/>\r\n"
			+ "				<meta>\r\n"
			+ "					<profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscore\"/>\r\n"
			+ "				</meta>\r\n"
			+ "				<effectiveDateTime value=\"2022-10-14T15:19:20+05:30\"/>\r\n"
			+ "				<valueQuantity>\r\n"
			+ "					<value value=\"7\"/>\r\n"
			+ "					<system value=\"http://unitsofmeasure.org\"/>\r\n"
			+ "					<code value=\"{score}\"/>\r\n"
			+ "				</valueQuantity>\r\n"
			+ "				<hasMember>\r\n"
			+ "					<reference value=\"Observation/62a824e9-b156-4e0e-b5e7-10c4851a5d00\"/>\r\n"
			+ "				</hasMember>\r\n"
			+ "			</Observation>,\r\n"
			+ "            <Observation\r\n"
			+ "				xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "				<id value=\"62a824e9-b156-4e0e-b5e7-10c4851a5d00\"/>\r\n"
			+ "				<meta>\r\n"
			+ "					<profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreThrombus\"/>\r\n"
			+ "				</meta>\r\n"
			+ "			</Observation>,\r\n"
			+ "            <Observation\r\n"
			+ "				xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "				<id value=\"a1fc1020-42c0-4681-9b1b-14e2d6ec59b7\"/>\r\n"
			+ "				<meta>\r\n"
			+ "					<profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscoreTotalOcclusion/LesionSyntaxSubscoreTotalOcclusion\"/>\r\n"
			+ "				</meta>\r\n"
			+ "				<subject>\r\n"
			+ "					<reference value=\"Patient/ils-test-CADPatient\"/>\r\n"
			+ "				</subject>\r\n"
			+ "				<hasMember>\r\n"
			+ "					<reference value=\"Observation/a5053815-d23d-436d-8384-61a85242a5ca\"/>\r\n"
			+ "				</hasMember>\r\n"
			+ "			</Observation>,\r\n"
			+ "            <Observation\r\n"
			+ "				xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "				<id value=\"a5053815-d23d-436d-8384-61a85242a5ca\"/>\r\n"
			+ "				<meta>\r\n"
			+ "					<profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscoreTotalOcclusion/TotalOcclusionBridging\"/>\r\n"
			+ "				</meta>\r\n"
			+ "			</Observation>,\r\n"
			+ "            <Observation\r\n"
			+ "				xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "				<id value=\"72e0d829-ac68-485b-9e60-3e604dda10d5\"/>\r\n"
			+ "				<meta>\r\n"
			+ "					<profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/diffuseDiseaseSmallVesselsSyntaxSubscore/DiffuseDiseaseSmallVesselsSyntaxSubscore\"/>\r\n"
			+ "				</meta>\r\n"
			+ "				<hasMember>\r\n"
			+ "					<reference value=\"Observation/30e15327-6f55-4298-9bfc-ff4211502bca\"/>\r\n"
			+ "				</hasMember>\r\n"
			+ "			</Observation>,\r\n"
			+ "            <Observation\r\n"
			+ "            xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "            <id value=\"30e15327-6f55-4298-9bfc-ff4211502bca\"/>\r\n"
			+ "            <meta>\r\n"
			+ "                <profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreSegment\"/>\r\n"
			+ "            </meta>\r\n"
			+ "        </Observation>";
	
	String observationString = "<Observation xmlns=\"http://hl7.org/fhir\">\r\n"
			+ "   <id value=\"b3917c0c-9949-4d9d-9c5c-d1cd11d6ac4a\"/>\r\n"
			+ "   <meta>\r\n"
			+ "      <profile value=\"https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreBifurcation\"/>\r\n"
			+ "   </meta>\r\n"
			+ "   <status value=\"registered\"/>\r\n"
			+ "   <category>\r\n"
			+ "      <coding>\r\n"
			+ "         <system value=\"http://terminology.hl7.org/CodeSystem/observation-category\"/>\r\n"
			+ "         <code value=\"survey\"/>\r\n"
			+ "         <display value=\"survey\"/>\r\n"
			+ "      </coding>\r\n"
			+ "   </category>\r\n"
			+ "   <code>\r\n"
			+ "      <coding>\r\n"
			+ "         <system value=\"http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl\"/>\r\n"
			+ "         <code value=\"C100086\"/>\r\n"
			+ "         <display value=\"Coronary Artery Dominance\"/>\r\n"
			+ "      </coding>\r\n"
			+ "   </code>\r\n"
			+ "   <subject>\r\n"
			+ "      <reference value=\"Patient/2c6aab56-eddb-4d25-a65f-357d6c24d354\"/>\r\n"
			+ "   </subject>\r\n"
			+ "   <effectiveDateTime value=\"2022-11-28T10:17:13+05:30\"/>\r\n"
			+ "   <valueCodeableConcept>\r\n"
			+ "      <coding>\r\n"
			+ "         <system value=\"http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl\"/>\r\n"
			+ "         <code value=\"C99942\"/>\r\n"
			+ "         <display value=\"Coronary Artery Right Dominance\"/>\r\n"
			+ "      </coding>\r\n"
			+ "   </valueCodeableConcept>\r\n"
			+ "</Observation>";
	
	static List<Observation> observationList = new ArrayList<>();
	FhirContext ctx = FhirContext.forR4();
	IParser parser = ctx.newXmlParser();
	List<String> observationListString = new ArrayList<String>(Arrays.asList(observationsString.split(",")));
	
	@Test
	@Order(1)
	void getAllObservationTest() {
		resultList = parseBundle.getAllObservation(bundleString, "application/fhir+json; fhirVersion=4.0");
		assertEquals(1, resultList.size());
	}
	
	@Test
	@Order(2)
	void getObservationsForSyntaxScoreTest() {
		for(String observation : observationListString) {
			Observation parsed = parser.parseResource(Observation.class, observation);
			observationList.add(parsed);
		}
		resultMap = parseBundle.getObservationsForSyntaxScore(observationList);
		assertEquals(2, resultMap.size());
	}
	
	@Test
	@Order(3)
	void getLesionObservationTest() {
		List<String> result = parseBundle.getLesionObservation(resultMap.get("LesionSubScore1"), resultList);
		assertEquals(0, result.size());
	}
	
	@Test
	@Order(4)
	void getBifurcationListTest() {
		String result = parseBundle.getBifurcationList(observationList);
		assertNull(result);
	}
	
	@Test
	@Order(5)
	void getTOobservationListTest() {
		List<String> result = parseBundle.getTOobservationList(observationListString);
		assertEquals(1, result.size());
	}
	
	@Test
	@Order(6)
	void getDiffusedObservationsTest() {
		List<String> result = parseBundle.getDiffusedObservations(observationList);
		assertEquals(1, result.size());
	}
	
	@Test
	@Order(7)
	void getLesionScoreTest() {
		String result = parseBundle.getLesionScore(observationListString, 1);
		assertEquals("0.0", result);
	}
	
	@Test
	@Order(8)
	void getDiffuselyDiseasedScoreTest() {
		String result = parseBundle.getDiffuselyDiseasedScore(observationListString);
		assertEquals("0.0", result);
	}
	
	@Test
	@Order(9)
	void updateLesionSubscoreTest() {
		String result = parseBundle.updateLesionSubscore(observationString, "12");
		Observation parsed = parser.parseResource(Observation.class, result);
		int value = parsed.getValueQuantity().getValue().intValue();
		assertEquals(12, value);
	}
	
	@Test
	@Order(10)
	void updateDiffsuleySubscoreTest() {
		String result = parseBundle.updateDiffsuleySubscore(observationString, "5");
		Observation parsed = parser.parseResource(Observation.class, result);
		int value = parsed.getComponent().get(0).getValueQuantity().getValue().intValue();
		assertEquals(5, value);
	}
	
	@Test
	@Order(11)
	void getPatientTest() {
		Patient result = parseBundle.getPatient(bundleString, "application/fhir+json; fhirVersion=4.0");
		assertNotNull(result);
	}
}