/**
  * (C) Koninklijke Philips Electronics N.V. 2021
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  **/
package com.philips.hsdp.research.fhdl.fhirservice.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.philips.hsdp.research.fhdl.fhirservice.model.CompositionFHIRStructureDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.FhirVersionMappingDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ObservationResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.PatientFHIRStructureDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.PatientResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ResponseDTOStu3;
import net.snowflake.client.jdbc.internal.net.minidev.json.parser.ParseException;

/*
 * @author Rajeshwar Tondare
 */
@Repository
public class HiveDAOImpl implements BaseDAO {
	private static final Logger log = LoggerFactory.getLogger(HiveDAOImpl.class);
	private String emrinstancehive = System.getProperty("emr_instance_hive");
	private String hivetablename = System.getProperty("hive_table_name");

	@Override
	public PatientResponseDTO getPatientDataFromHive(String id)
			throws SQLException, JsonProcessingException, ParseException {
		PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			String conStr = emrinstancehive;
			con = DriverManager.getConnection(conStr, "", "");
			stmt = con.createStatement();

			LocalDateTime startDateTime = LocalDateTime.now();
			log.info("####### Hive #######");
			log.info("Start Date time: {} ", startDateTime);
			String query = "select resourcejson from " + hivetablename + "  where id = " + id;
			rs = stmt.executeQuery(query);
			LocalDateTime endDateTime = LocalDateTime.now();
			log.info("End Date time: {} ", endDateTime);
			long diff1 = ChronoUnit.SECONDS.between(startDateTime, endDateTime);
			log.info("Total Execution time (Seconds): {} ", diff1);
			long diff = ChronoUnit.MILLIS.between(startDateTime, endDateTime);
			log.info("Total Execution time (MilliSeconds): {} ", diff);

			String resourceJson = null;
			ObjectMapper mapper = new ObjectMapper();
			while (rs.next()) {
				resourceJson = rs.getString("resourcejson");
				JsonNode jsonResponseForResourceJson = (resourceJson != null) ? mapper.readTree(resourceJson) : null;
				patientResponseDTO.setResourceJson(jsonResponseForResourceJson);
			}
		} catch (SQLException ex) {
			log.info(ex.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
		}
		return patientResponseDTO;
	}

	@Override
	public ResponseDTO getDataForResourceR4(String id, String resourceType) throws SQLException, ParseException {
		return null;
	}

	@Override
	public ResponseDTOStu3 getDataForResourceStu3(String id, String resourceType) throws SQLException, ParseException {
		return null;
	}

	@Override
	public CompositionFHIRStructureDTO getDataForCompositionR4(String patientId, String profile, String cadResponse)
			throws SQLException, ParseException, JSONException,
			IOException, URISyntaxException {
		return null;
	}

	@Override
	public PatientFHIRStructureDTO getDataForPatientSearchSet()
			throws SQLException, JsonProcessingException, ParseException {
		return null;
	}

	@Override
	public CompositionFHIRStructureDTO getDataForCompositionSTU3(String patientId)
			throws SQLException, JsonProcessingException, ParseException {
		return null;
	}

	@Override
	public ResponseDTO getDataForResourceMulti(String id, String patientId, String resourceType, String profile)
			throws SQLException, JsonProcessingException, ParseException {
		return null;
	}

	@Override
	public FhirVersionMappingDTO getFhirVersionMappingStu3(String id, String resourceType, String patientId)
			throws SQLException, JsonProcessingException, ParseException {
		return null;
	}

	@Override
	public ObservationResponseDTO getSearchResultForObservation(String code)
			throws SQLException, JsonProcessingException, ParseException {
		return null;
	}
	
	@Override
	public CompositionFHIRStructureDTO getDataForIPSR4(String patientId, String cadResponse)
			throws SQLException, ParseException, IOException {
		return null;
	}

	@Override
	public CompositionFHIRStructureDTO getDataForCADSummaryComorbiditiesR4(String patientId, String cadResponse)
			throws SQLException, ParseException, IOException {
		return null;
	}

	@Override
	public CompositionFHIRStructureDTO getDataForCADSummaryR4(String patientId, String cadResponse)
			throws SQLException, ParseException, IOException {
		return null;
	}

	@Override
	public ResponseDTO getIPSSummaryDataForResourceR4(String patientId, String resourceType)
			throws SQLException, ParseException {
		return null;
	}
}