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
import java.util.ArrayList;
import java.util.Properties;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.hsdp.research.fhdl.fhirservice.constant.Constants;
import com.philips.hsdp.research.fhdl.fhirservice.model.CompositionDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.CompositionFHIRStructureDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.FhirVersionMappingDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ObservationResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.PatientFHIRStructureDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.PatientResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ResponseDTOStu3;
import net.snowflake.client.jdbc.internal.net.minidev.json.parser.ParseException;

/*
 * @author Priyanka Mallick
 */
@Repository
public class RedshiftDAOImpl implements BaseDAO {
	private static final Logger log = LoggerFactory.getLogger(RedshiftDAOImpl.class);
	private static final String RESOURCE_JSON = "resourceJson";

	private String redshiftUsername = System.getProperty("redshift_username");
	private String redshiftPassword = System.getProperty("redshift_password");
	private String redshiftHostname = System.getProperty("redshift_hostname");
	private String redshiftPort = System.getProperty("redshift_port");
	private String redshiftIpsDbName = System.getProperty("ips_db_name");
	private String redshiftStu3DbName = System.getProperty("stu3_db_name");

	@Override
	public ResponseDTO getDataForResourceR4(String id, String tableName) throws SQLException, ParseException {
		ResponseDTO responseDTO = new ResponseDTO();
		String resourceJson = null;
		ResultSet rs = null;
		Connection con = null;
		Statement statement = null;

		try {
			Properties props = new Properties();
			props.setProperty("user", redshiftUsername);
			props.setProperty("password", redshiftPassword);
			con = DriverManager.getConnection(
					"jdbc:redshift://" + redshiftHostname + ":" + redshiftPort + "/" + redshiftIpsDbName, props);
			statement = con.createStatement();
			statement.executeUpdate("SET enable_case_sensitive_identifier TO true;");

			LocalDateTime startDateTime = LocalDateTime.now();
			log.info("####### Redshift #######");
			log.info("Start Date time: {} ", startDateTime);
			LocalDateTime endDateTime = LocalDateTime.now();
			log.info("End Date time: {} ", endDateTime);
			long diff1 = ChronoUnit.SECONDS.between(startDateTime, endDateTime);
			log.info("Total Execution time (Seconds): {} ", diff1);
			long diff = ChronoUnit.MILLIS.between(startDateTime, endDateTime);
			log.info("Total Execution time (MilliSeconds): {} ", diff);

			String query = "SELECT" + "\"" + RESOURCE_JSON + "\"" + "FROM" + "\"" + tableName + "\"" + " WHERE " + "\""
					+ Constants.ID + "\"" + " = " + "\'" + id + "\'";

			rs = statement.executeQuery(query);
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<JsonNode> resourceList = new ArrayList<>();
			while (rs.next()) {
				resourceJson = rs.getString(RESOURCE_JSON);
				JsonNode jsonResponse = null;
				jsonResponse = (resourceJson != null) ? mapper.readTree(resourceJson) : null;
				resourceList.add(jsonResponse);
			}
			responseDTO.setResource(resourceList);
		} catch (SQLException | IOException e) {
			log.info(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
			if (statement != null) {
				try {
					statement.close();
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
		return responseDTO;
	}

	@Override
	public ResponseDTOStu3 getDataForResourceStu3(String id, String tableName) throws SQLException, ParseException {
		ResponseDTOStu3 responseDTOStu3 = new ResponseDTOStu3();
		String resourceJson = null;
		ResultSet rs = null;
		Connection con = null;
		Statement statement = null;

		try {
			Properties props = new Properties();
			props.setProperty("user", redshiftUsername);
			props.setProperty("password", redshiftPassword);
			con = DriverManager.getConnection(
					"jdbc:redshift://" + redshiftHostname + ":" + redshiftPort + "/" + redshiftStu3DbName, props);
			statement = con.createStatement();
			statement.executeUpdate("SET enable_case_sensitive_identifier TO true;");

			LocalDateTime startDateTime = LocalDateTime.now();
			log.info("####### Redshift #######");
			log.info("####### Start Date time: {} ", startDateTime);
			LocalDateTime endDateTime = LocalDateTime.now();
			log.info("####### End Date time: {} ", endDateTime);
			long diff1 = ChronoUnit.SECONDS.between(startDateTime, endDateTime);
			log.info("Total Execution time (Seconds): {} ", diff1);
			long diff = ChronoUnit.MILLIS.between(startDateTime, endDateTime);
			log.info("Total Execution time (MilliSeconds): {} ", diff);

			String query = "SELECT" + "\"" + RESOURCE_JSON + "\"" + "FROM" + "\"" + tableName + "\"" + " WHERE " + "\""
					+ Constants.ID + "\"" + " = " + "\'" + id + "\'";

			rs = statement.executeQuery(query);
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<JsonNode> resourceList = new ArrayList<>();
			while (rs.next()) {
				resourceJson = rs.getString(RESOURCE_JSON);
				JsonNode jsonResponse = null;
				jsonResponse = (resourceJson != null) ? mapper.readTree(resourceJson) : null;
				resourceList.add(jsonResponse);
			}
			responseDTOStu3.setResource(resourceList);
		} catch (SQLException | IOException e) {
			log.info(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
			if (statement != null) {
				try {
					statement.close();
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
		return responseDTOStu3;
	}

	@Override
	public CompositionFHIRStructureDTO getDataForCompositionR4(String patientId, String profile, String cadResponse)
			throws SQLException, ParseException, JSONException, IOException, URISyntaxException {
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
	public ResponseDTO getDataForResourceMulti(String id, String patientId, String tableName, String profile)
			throws SQLException, JsonProcessingException, ParseException {
		return null;
	}

	@Override
	public FhirVersionMappingDTO getFhirVersionMappingStu3(String id, String tableName, String patientId)
			throws SQLException, JsonProcessingException, ParseException {
		return null;
	}

	@Override
	public ObservationResponseDTO getSearchResultForObservation(String code)
			throws SQLException, JsonProcessingException, ParseException {
		return null;
	}

	@Override
	public PatientResponseDTO getPatientDataFromHive(String id)
			throws SQLException, JsonProcessingException, ParseException {
		return null;
	}

	@Override
	public CompositionFHIRStructureDTO getDataForIPSR4(String patientId, String cadResponse)
			throws SQLException, ParseException, IOException
	 {
		CompositionFHIRStructureDTO compositionFHIRStructureDTO = new CompositionFHIRStructureDTO();
		String resourceJson = null;
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<JsonNode> compositionData = new ArrayList<JsonNode>();
		try {
			Properties props = new Properties();
			props.setProperty("user", redshiftUsername);
			props.setProperty("password", redshiftPassword);
			con = DriverManager.getConnection(
					"jdbc:redshift://" + redshiftHostname + ":" + redshiftPort + "/" + redshiftIpsDbName, props);
			statement = con.createStatement();
			statement.executeUpdate("SET enable_case_sensitive_identifier TO true;");
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT" + " \"" + "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "."
					+ "\"" + Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.PATIENT_TABLE_NAME + "\"" + " WHERE "
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION " + "SELECT" + " \""
					+ "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.OBSERVATION_TABLE_NAME + "\"" + " WHERE "
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION " + "SELECT" + " \""
					+ "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.IMMUNIZATION_TABLE_NAME + "\"" + " WHERE "
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION " + "SELECT" + " \""
					+ "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.ALLERGYINTOLERANCE_TABLE_NAME + "\""
					+ " WHERE " + "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION "
					+ "SELECT" + " \"" + "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "."
					+ "\"" + Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.CONDITION_TABLE_NAME + "\"" + " WHERE "
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\' AND " + " UNION " + "SELECT"
					+ " \"" + "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.ENCOUNTER_TABLE_NAME + "\"" + " WHERE " + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION " + "SELECT" + " \""
					+ "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.ORGANIZATION_TABLE_NAME + "\"" + " WHERE "
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION " + "SELECT" + " \""
					+ "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.PRACTITIONER_TABLE_NAME + "\"" + " WHERE "
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION " + "SELECT" + " \""
					+ "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.MEDICATION_TABLE_NAME + "\"" + " WHERE "
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION " + "SELECT" + " \""
					+ "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.MEDICATIONSTATEMENT_TABLE_NAME + "\""
					+ " WHERE " + "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION "
					+ "SELECT" + " \"" + "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "."
					+ "\"" + Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.MEDICATIONREQUEST_TABLE_NAME + "\""
					+ " WHERE " + "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'");

			rs = statement.executeQuery(sb.toString());
			ObjectMapper mapper = new ObjectMapper();
			CompositionDTO compositionDTO = new CompositionDTO();
			while (rs.next()) {
				resourceJson = rs.getString("resourceJson");
				JsonNode compositionResourceJson = null;
				try {
					compositionResourceJson = (resourceJson != null) ? mapper.readTree(resourceJson) : null;
				} catch (JsonProcessingException e) {
					log.info(e.getMessage());
				}
				compositionDTO.setResourceJson(compositionResourceJson);
				JsonNode compositionResponse = compositionDTO.getResourceJson();
				compositionData.add(compositionResponse);
			}
		} catch (SQLException e) {
			log.info(e.getMessage());
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode mainJsonObject = mapper.createObjectNode();
		mainJsonObject.put("resourceType", "Bundle");
		mainJsonObject.put("Type", "document");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = now.format(format);

		compositionFHIRStructureDTO.setResourceType("Bundle");
		compositionFHIRStructureDTO.setTimestamp(formatDateTime);
		compositionFHIRStructureDTO.setType("document");

		ArrayList<CompositionDTO> compDTO = new ArrayList<>();

		if (compositionData.size() > 0) {
			CompositionDTO compositionDataNew = new CompositionDTO();
			compositionDataNew.setResource(compositionData);
			compDTO.add(compositionDataNew);
		}

		ArrayList<Object> entryData = new ArrayList<Object>();
		entryData.add(compDTO);
		compositionFHIRStructureDTO.setEntry(entryData);
		return compositionFHIRStructureDTO;
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