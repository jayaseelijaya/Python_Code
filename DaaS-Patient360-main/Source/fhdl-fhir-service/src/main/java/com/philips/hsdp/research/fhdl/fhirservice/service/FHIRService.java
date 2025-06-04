/**
  * (C) Koninklijke Philips Electronics N.V. 2021
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  **/
package com.philips.hsdp.research.fhdl.fhirservice.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.philips.hsdp.research.fhdl.fhirservice.model.FhirVersionMappingDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ObservationResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.CompositionFHIRStructureDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.PatientFHIRStructureDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.PatientResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ResponseDTOStu3;
import net.snowflake.client.jdbc.internal.net.minidev.json.parser.ParseException;

/*
 * @author Rajeshwar Tondare
 */
@Service
public interface FHIRService {

	public ResponseDTO getDataForResourceR4(String id, String sourceType) throws SQLException, ParseException;
	
	public ResponseDTO getIPSSummaryDataForResourceR4(String patientId, String sourceType) throws SQLException, ParseException;

	public ResponseDTOStu3 getDataForResourceStu3(String id, String sourceType) throws SQLException, ParseException;

	public CompositionFHIRStructureDTO getDataForCompositionR4(String patientId, String profile, String cadResponse)
			throws SQLException, ParseException, JSONException, IOException, URISyntaxException;

	public CompositionFHIRStructureDTO getDataForCompositionSTU3(String patientId)
			throws SQLException, JsonProcessingException, ParseException;
	
	public CompositionFHIRStructureDTO getDataForIPSR4(String patientId, String cadResponse)
			throws SQLException, ParseException, IOException;
	
	public CompositionFHIRStructureDTO getDataForCADSummaryComorbiditiesR4(String patientId, String cadResponse)
			throws SQLException, ParseException, IOException;
	
	public CompositionFHIRStructureDTO getDataForCADSummaryR4(String patientId, String cadResponse)
			throws SQLException, ParseException, IOException;

	public PatientFHIRStructureDTO getDataForPatientSearchset()
			throws SQLException, JsonProcessingException, ParseException;

	public ResponseDTO getDataForResourceMulti(String id, String patientId, String tableName, String profile)
			throws SQLException, JsonProcessingException, ParseException;

	public FhirVersionMappingDTO getFhirVersionMappingStu3(String id, String patientId, String tableName)
			throws SQLException, JsonProcessingException, ParseException;

	public ObservationResponseDTO getSearchResultForObservation(String code)
			throws SQLException, JsonProcessingException, ParseException;

	public PatientResponseDTO getPatientDataFromHive(String id)
			throws SQLException, JSONException, IOException, ParseException;
}