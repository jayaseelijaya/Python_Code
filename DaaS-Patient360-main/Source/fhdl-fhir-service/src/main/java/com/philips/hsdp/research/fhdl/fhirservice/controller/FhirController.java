/**
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner. 
 **/
package com.philips.hsdp.research.fhdl.fhirservice.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import javax.ws.rs.QueryParam;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.philips.hsdp.research.fhdl.fhirservice.constant.Constants;
import com.philips.hsdp.research.fhdl.fhirservice.model.CompositionFHIRStructureDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ObservationResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.PatientFHIRStructureDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.PatientResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ResponseDTOStu3;
import com.philips.hsdp.research.fhdl.fhirservice.service.FHIRService;
import com.philips.hsdp.research.fhdl.fhirservice.util.FHIRUtility;
import io.swagger.v3.oas.annotations.Operation;
import net.snowflake.client.jdbc.internal.net.minidev.json.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/*
 * @author Rajeshwar Tondare
 */
@RestController
@SecurityRequirement(name = "fhir interface api")
public class FhirController {
	@Autowired
	FHIRService snowflakeFHIRServiceImpl;

	@Autowired
	FHIRService redshiftFHIRServiceImpl;

	@Autowired
	FHIRService prestoFHIRServiceImpl;

	@Autowired
	FHIRService hiveFHIRServiceImpl;

	@Autowired
	FHIRUtility utility;
	private static final Logger log = LoggerFactory.getLogger(FhirController.class);
	private static final String EXCEPTION_MESSAGE = "Exception found, Invalid token!!";
	private static final String SOURCEWARE_HOUSE = "source_warehouse";

	// @GetMapping("/MultiModelR4/Patient/{id}")
	public ResponseEntity<JsonNode> getSnowflakeDataForPatient(@PathVariable String id,
			@RequestHeader("Content-Type") String contentType, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, IOException, SQLException, ParseException {
		String tokenFlag = null;
		JsonNode converterOutput = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			ResponseDTO patientResponseDTO = snowflakeFHIRServiceImpl.getDataForResourceMulti(id, null,
					Constants.PATIENT_TABLE_NAME, null);
			converterOutput = utility.convertWithHapi(patientResponseDTO.getResource().get(0), contentType);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return new ResponseEntity<>(converterOutput, HttpStatus.OK);
	}

	// @GetMapping("/baseSTU3/Patient/{id}")
	public ResponseEntity<JsonNode> getSnowflakeDataR4(@PathVariable String id,
			@RequestHeader("Content-Type") String contentType, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse)
			throws JSONException, IOException, SQLException, ParseException {
		String tokenFlag = null;
		JsonNode converterOutput = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			ResponseDTO patientResponseDTO = snowflakeFHIRServiceImpl.getDataForResourceR4(id,
					Constants.PATIENT_TABLE_NAME);
			converterOutput = utility.convertWithHapi(patientResponseDTO.getResource().get(0), contentType);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return new ResponseEntity<>(converterOutput, HttpStatus.OK);
	}

	// @GetMapping("/baseR4/Patient/{id}")
	public ResponseEntity<JsonNode> getSnowflakeDataStu3(@PathVariable String id,
			@RequestHeader("Content-Type") String contentType, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, IOException, SQLException, ParseException {
		String tokenFlag = null;
		JsonNode converterOutput = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			ResponseDTOStu3 patientResponseDTO = snowflakeFHIRServiceImpl.getDataForResourceStu3(id,
					Constants.PATIENT_TABLE_NAME);
			converterOutput = utility.convertWithHapi(patientResponseDTO.getResource().get(0), contentType);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return new ResponseEntity<>(converterOutput, HttpStatus.OK);
	}

	@GetMapping("/R4/Composition")
	@Operation(summary = "Retrieve Composition in FHIR R4 version")
	public CompositionFHIRStructureDTO getSnowflakeDataForCompositionR4(@QueryParam("patientId") String patientId,
			@QueryParam("profile") String profile, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse)
			throws JSONException, IOException, SQLException, ParseException, URISyntaxException {
		CompositionFHIRStructureDTO compositionDTO = new CompositionFHIRStructureDTO();
		String tokenFlag = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			String cadResponse = utility.getCADComorbidity();
			compositionDTO = snowflakeFHIRServiceImpl.getDataForCompositionR4(patientId, profile, cadResponse);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return compositionDTO;
	}
	
	/**
	 * 
	 * This function is used to get Patient Summary in R4 format from warehouse.
	 *
	 * @param String      : patientId
	 * @param HttpHeaders : requestHeaders
	 * @return JsonNode : resourceJson
	 * @throws IOException 
	 * @throws JSONException 
	 * @throws URISyntaxException 
	 * @throws ParseException 
	 */
	@GetMapping("/R4/PatientSummary/{patientId}")
	@Operation(summary ="Retrieve Patient Summary in FHIR R4 version")
	public CompositionFHIRStructureDTO getDataForIPSR4(@PathVariable String patientId,
			 @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse)
			throws SQLException, ParseException, IOException {
		CompositionFHIRStructureDTO compositionDTO = new CompositionFHIRStructureDTO();
		String tokenFlag = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			String cadResponse = utility.getCADComorbidity();
			compositionDTO = getDataForIPSR4(patientId, cadResponse);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return compositionDTO;
	}
	
	private CompositionFHIRStructureDTO getDataForIPSR4(String patientId, String cadResponse) throws SQLException,ParseException, IOException{
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		return getServiceObject(sourceWarehouse).getDataForIPSR4(patientId,
				cadResponse);
		
	}
	
	/**
	 * 
	 * This function is used to get Patient Summary - Comorbidities in R4 format from warehouse.
	 *
	 * @param String      : patientId
	 * @param HttpHeaders : requestHeaders
	 * @return JsonNode : resourceJson
	 */	
	@GetMapping("/R4/CADSummary/Comorbidities/{patientId}")
	@Operation(summary ="Retrieve CADSummary/Comorbidities in FHIR R4 version")
	public CompositionFHIRStructureDTO getDataForCADSummaryComorbiditiesR4(@PathVariable String patientId,
			 @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse)
			throws SQLException, ParseException, IOException {
		CompositionFHIRStructureDTO compositionDTO = new CompositionFHIRStructureDTO();
		String tokenFlag = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			String cadResponse = utility.getCADComorbidity();
			compositionDTO = getDataForCADSummaryComorbiditiesR4(patientId, cadResponse);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return compositionDTO;
	}
	
	private CompositionFHIRStructureDTO getDataForCADSummaryComorbiditiesR4(String patientId, String cadResponse) throws SQLException, ParseException, IOException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		 return getServiceObject(sourceWarehouse).getDataForCADSummaryComorbiditiesR4(patientId,
				cadResponse);
		
	}
	
	/**
	 * 
	 * This function is used to get CAD Summary in R4 format from warehouse.
	 *
	 * @param String      : patientId
	 * @param HttpHeaders : requestHeaders
	 * @return JsonNode : resourceJson
	 */	
	@GetMapping("/R4/CADSummary/{patientId}")
	@Operation(summary ="Retrieve CADSummary in FHIR R4 version")
	public CompositionFHIRStructureDTO getDataForCADSummaryR4(@PathVariable String patientId,
			 @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse)
			throws SQLException, ParseException, IOException {
		CompositionFHIRStructureDTO compositionDTO = new CompositionFHIRStructureDTO();
		String tokenFlag = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			String cadResponse = utility.getCADComorbidity();
			compositionDTO = getDataForCADSummaryR4(patientId, cadResponse);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return compositionDTO;
	}
	
	private CompositionFHIRStructureDTO getDataForCADSummaryR4(String patientId, String cadResponse) throws SQLException, ParseException, IOException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		return getServiceObject(sourceWarehouse).getDataForCADSummaryR4(patientId,
				cadResponse);
	}

	@GetMapping("/STU3/Composition")
	@Operation(summary = "Retrieve Composition in FHIR STU3 version")
	public CompositionFHIRStructureDTO getSnowflakeDataForCompositionSTU3(@QueryParam("patientId") String patientId,
			@QueryParam("profile") String profile, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse)
			throws JSONException, IOException, SQLException, ParseException {
		CompositionFHIRStructureDTO compositionDTO = new CompositionFHIRStructureDTO();
		String tokenFlag = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			compositionDTO = snowflakeFHIRServiceImpl.getDataForCompositionSTU3(patientId);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return compositionDTO;
	}

	// @GetMapping("/R4/Patient")
	@Operation(summary = "Retrieve Patient resource in FHIR R4 version")
	public PatientFHIRStructureDTO getSnowflakeDataForPatientSearchSet(@RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, IOException, SQLException, ParseException {
		PatientFHIRStructureDTO patientResponseDTO = new PatientFHIRStructureDTO();
		String tokenFlag = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			patientResponseDTO = snowflakeFHIRServiceImpl.getDataForPatientSearchset();
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return patientResponseDTO;
	}

	/**
	 * 
	 * This function is used to get data from Hive data lake.
	 *
	 * @param String      : id
	 * @param HttpHeaders : requestHeaders
	 * @return JsonNode : resourceJson
	 */
	public JsonNode getPatientDataFromHive(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws SQLException, JSONException, IOException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
		String tokenFlag = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			patientResponseDTO = getServiceObject(sourceWarehouse).getPatientDataFromHive(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return patientResponseDTO.getResourceJson();
	}

	private JsonNode getDataForPatientR4(String id) throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO patientResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.PATIENT_TABLE_NAME);
		return patientResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForObservationR4(String id) throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO observationResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.OBSERVATION_TABLE_NAME);
		return observationResponseDTO.getResource().get(0);
	}
	
	private JsonNode getDataForIPSSummaryObservationR4(String patientId, String resourceType, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO observationResponseDTO = getServiceObject(sourceWarehouse).getIPSSummaryDataForResourceR4(patientId,
					Constants.OBSERVATION_TABLE_NAME);
		return observationResponseDTO.getResource().get(0);
	}
	
	private JsonNode getDataForIPSSummaryMedicationR4(String patientId, String resourceType, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO medicationResponseDTO = getServiceObject(sourceWarehouse).getIPSSummaryDataForResourceR4(patientId,
					Constants.MEDICATION_TABLE_NAME);
		return medicationResponseDTO.getResource().get(0);
	}
	
	private JsonNode getDataForIPSSummaryConditionR4(String patientId, String resourceType, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO conditionResponseDTO = getServiceObject(sourceWarehouse).getIPSSummaryDataForResourceR4(patientId,
					Constants.CONDITION_TABLE_NAME);
		return conditionResponseDTO.getResource().get(0);
	}	
	
	private JsonNode getDataForImmunizationR4(String id) throws SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO immunizationResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.IMMUNIZATION_TABLE_NAME);
		return immunizationResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForAllergyintoleranceR4(String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO allergyIntoleranceResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.ALLERGYINTOLERANCE_TABLE_NAME);
		return allergyIntoleranceResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForConditionR4(String id) throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO conditionResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.CONDITION_TABLE_NAME);
		return conditionResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForEncounterR4(String id) throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO encounterResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.ENCOUNTER_TABLE_NAME);
		return encounterResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForOrganizationR4(String id) throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO organizationResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.ORGANIZATION_TABLE_NAME);
		return organizationResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForPractitionerR4(String id) throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO practitionerResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.PRACTITIONER_TABLE_NAME);
		return practitionerResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForMedicationR4(String id) throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO medicationResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.MEDICATION_TABLE_NAME);
		return medicationResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForMedicationStatementR4(String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO medicationstatementResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.MEDICATIONSTATEMENT_TABLE_NAME);
		return medicationstatementResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForMedicationRequestR4(String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTO medicationrequestResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceR4(id,
				Constants.MEDICATIONREQUEST_TABLE_NAME);
		return medicationrequestResponseDTO.getResource().get(0);
	}

	FHIRService getServiceObject(String sourceWarehouse) {
		FHIRService fhirServiceObject = null;

		switch (sourceWarehouse) {
		case "Redshift":
			fhirServiceObject = redshiftFHIRServiceImpl;
			break;
		case "Snowflake":
			fhirServiceObject = snowflakeFHIRServiceImpl;
			break;
		case "delta-presto":
			fhirServiceObject = prestoFHIRServiceImpl;
			break;
		case "delta-hive":
			fhirServiceObject = hiveFHIRServiceImpl;
			break;
		case "hudi-presto":
			fhirServiceObject = prestoFHIRServiceImpl;
			break;
		default:
			fhirServiceObject = redshiftFHIRServiceImpl;
		}
		return fhirServiceObject;
	}

	@GetMapping("/R4/Patient/{id}")
	@Operation(summary = "Retrieve Patient resource in FHIR R4 version")
	public JsonNode getPatientDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForPatientR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}
	
	/**
	 * 
	 * This function is used to get data from warehouse for Observation.
	 *
	 * @param String      : patientId
	 * @param HttpHeaders : requestHeaders
	 * @return JsonNode : resourceJson
	 */	
	@GetMapping("R4/IPSSummary/Observation/{patientId}")
	@Operation(summary ="Retrieve IPSSummary for Observation in FHIR R4 version")
	public JsonNode getIPSSummaryObservationDataR4(@PathVariable String patientId,
			@RequestHeader HttpHeaders requestHeaders, HttpServletResponse httpServletResponse)
			throws SQLException, ParseException, IOException {
		String resourceType = null;
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForIPSSummaryObservationR4(patientId, resourceType, requestHeaders, httpServletResponse);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}	
		return response;
	}
	
	/**
	 * 
	 * This function is used to get data from warehouse for Medication.
	 *
	 * @param String      : patientId
	 * @param HttpHeaders : requestHeaders
	 * @return JsonNode : resourceJson
	 */	
	@GetMapping("R4/IPSSummary/Medication/{patientId}")
	@Operation(summary ="Retrieve IPSSummary for Medication in FHIR R4 version")
	public JsonNode getIPSSummaryMedicationDataR4(@PathVariable String patientId,
			@RequestHeader HttpHeaders requestHeaders, HttpServletResponse httpServletResponse)
			throws SQLException, ParseException, IOException {
		String resourceType = null;
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForIPSSummaryMedicationR4(patientId, resourceType, requestHeaders, httpServletResponse);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}	
		return response;
	}
	
	/**
	 * 
	 * This function is used to get data from warehouse for Condition.
	 *
	 * @param String      : patientId
	 * @param HttpHeaders : requestHeaders
	 * @return JsonNode : resourceJson
	 * @throws IOException 
	 * @throws JSONException 
	 */
	@GetMapping("R4/IPSSummary/Condition/{patientId}")
	@Operation(summary ="Retrieve IPSSummary for Condition in FHIR R4 version")
	public JsonNode getIPSSummaryConditionDataR4(@PathVariable String patientId,
			@RequestHeader HttpHeaders requestHeaders, HttpServletResponse httpServletResponse)
			throws SQLException, ParseException, IOException {
		String resourceType = null;
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForIPSSummaryConditionR4(patientId, resourceType, requestHeaders, httpServletResponse);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}	
		return response;
	}

	@GetMapping("/R4/Observation/{id}")
	@Operation(summary = "Retrieve Observation resource in FHIR R4 version")
	public JsonNode getObservationDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForObservationR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/R4/Immunization/{id}")
	@Operation(summary = "Retrieve Immunization resource in FHIR R4 version")
	public JsonNode getImmunizationDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForImmunizationR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/R4/AllergyIntolerance/{id}")
	@Operation(summary = "Retrieve AllergyIntolerance resource in FHIR R4 version")
	public JsonNode getAllergyIntoleranceDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForAllergyintoleranceR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/R4/Condition/{id}")
	@Operation(summary = "Retrieve Condition resource in FHIR R4 version")
	public JsonNode getConditionDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForConditionR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/R4/Encounter/{id}")
	@Operation(summary = "Retrieve Encounter resource in FHIR R4 version")
	public JsonNode getEncounterDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForEncounterR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/R4/Organization/{id}")
	@Operation(summary = "Retrieve Organization resource in FHIR R4 version")
	public JsonNode getOrganizationDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForOrganizationR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/R4/Practitioner/{id}")
	@Operation(summary = "Retrieve Practitioner resource in FHIR R4 version")
	public JsonNode getPractitionerDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForPractitionerR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/R4/Medication/{id}")
	@Operation(summary = "Retrieve Medication resource in FHIR R4 version")
	public JsonNode getMedicationDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForMedicationR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/R4/MedicationStatement/{id}")
	@Operation(summary = "Retrieve MedicationStatement resource in FHIR R4 version")
	public JsonNode getMedicationStatementDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForMedicationStatementR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/R4/MedicationRequest/{id}")
	@Operation(summary = "Retrieve MedicationRequest resource in FHIR R4 version")
	public JsonNode getMedicationRequestDataR4(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForMedicationRequestR4(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	private JsonNode getDataForPatientStu3(String id) throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 patientResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.PATIENT_TABLE_NAME);
		return patientResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForObservationStu3(String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 observationResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.OBSERVATION_TABLE_NAME);
		return observationResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForImmunizationStu3(@PathVariable String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 immunizationResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.IMMUNIZATION_TABLE_NAME);
		return immunizationResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForAllergyIntoleranceStu3(String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 allergyIntoleranceResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.ALLERGYINTOLERANCE_TABLE_NAME);
		return allergyIntoleranceResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForConditionStu3(@PathVariable String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 conditionResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.CONDITION_TABLE_NAME);
		return conditionResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForEncounterStu3(String id) throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 encounterResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.ENCOUNTER_TABLE_NAME);
		return encounterResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForOrganizationStu3(String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 organizationResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.ORGANIZATION_TABLE_NAME);
		return organizationResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForPractitionerStu3(String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 practitionerResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.PRACTITIONER_TABLE_NAME);
		return practitionerResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForMedicationStu3(@PathVariable String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 medicationResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.MEDICATION_TABLE_NAME);
		return medicationResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForMedicationStatementStu3(String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 medicationstatementResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.MEDICATIONSTATEMENT_TABLE_NAME);
		return medicationstatementResponseDTO.getResource().get(0);
	}

	private JsonNode getDataForMedicationRequestStu3(String id)
			throws JSONException, SQLException, ParseException {
		String sourceWarehouse = System.getProperty(SOURCEWARE_HOUSE);
		ResponseDTOStu3 medicationrequestResponseDTO = getServiceObject(sourceWarehouse).getDataForResourceStu3(id,
				Constants.MEDICATIONREQUEST_TABLE_NAME);
		return medicationrequestResponseDTO.getResource().get(0);
	}

	@GetMapping("/STU3/Patient/{id}")
	@Operation(summary = "Retrieve Patient resource in FHIR STU3 version")
	public JsonNode getPatientDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForPatientStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/STU3/Observation/{id}")
	@Operation(summary = "Retrieve Observation resource in FHIR STU3 version")
	public JsonNode getObservationDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForObservationStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/STU3/Immunization/{id}")
	@Operation(summary = "Retrieve Immunization resource in FHIR STU3 version")
	public JsonNode getImmunizationDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForImmunizationStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/STU3/AllergyIntolerance/{id}")
	@Operation(summary = "Retrieve AllergyIntolerance resource in FHIR STU3 version")
	public JsonNode getAllergyIntoleranceDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForAllergyIntoleranceStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/STU3/Condition/{id}")
	@Operation(summary = "Retrieve Condition resource in FHIR STU3 version")
	public JsonNode getConditionDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForConditionStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/STU3/Encounter/{id}")
	@Operation(summary = "Retrieve Encounter resource in FHIR STU3 version")
	public JsonNode getEncounterDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForEncounterStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/STU3/Organization/{id}")
	@Operation(summary = "Retrieve Organization resource in FHIR STU3 version")
	public JsonNode getOrganizationDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForOrganizationStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/STU3/Practitioner/{id}")
	@Operation(summary = "Retrieve Practitioner resource in FHIR STU3 version")
	public JsonNode getPractitionerDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForPractitionerStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/STU3/Medication/{id}")
	@Operation(summary = "Retrieve Medication resource in FHIR STU3 version")
	public JsonNode getMedicationDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForMedicationStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/STU3/MedicationStatement/{id}")
	@Operation(summary = "Retrieve MedicationStatement resource in FHIR STU3 version")
	public JsonNode getMedicationStatementDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForMedicationStatementStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	@GetMapping("/STU3/MedicationRequest/{id}")
	@Operation(summary = "Retrieve MedicationRequest resource in FHIR STU3 version")
	public JsonNode getMedicationRequestDataStu3(@PathVariable String id, @RequestHeader HttpHeaders requestHeaders,
			HttpServletResponse httpServletResponse) throws JSONException, SQLException, IOException, ParseException {
		String tokenFlag = null;
		JsonNode response = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			response = getDataForMedicationRequestStu3(id);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return response;
	}

	// @GetMapping("/{resourceType}")
	public ObservationResponseDTO getSearchResultForObservation(@RequestParam String code,
			@RequestHeader HttpHeaders requestHeaders, HttpServletResponse httpServletResponse)
			throws JSONException, IOException, SQLException, ParseException {
		ObservationResponseDTO observationResponseDTO = new ObservationResponseDTO();
		String tokenFlag = null;
		tokenFlag = utility.verifyHeaderAndCallValidateIAMToken(requestHeaders, tokenFlag);
		if (tokenFlag.equals("true")) {
			observationResponseDTO = snowflakeFHIRServiceImpl.getSearchResultForObservation(code);
		} else {
			log.error(EXCEPTION_MESSAGE);
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return observationResponseDTO;
	}
}