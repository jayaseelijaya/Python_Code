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
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import net.snowflake.client.jdbc.internal.net.minidev.json.parser.ParseException;
import java.util.Properties;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.hsdp.research.fhdl.fhirservice.config.SnowflakeConfig;
import com.philips.hsdp.research.fhdl.fhirservice.constant.Constants;
import com.philips.hsdp.research.fhdl.fhirservice.model.CompositionDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.CompositionFHIRStructureDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.FhirVersionMappingDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.PatientFHIRStructureDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.PatientResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ObservationResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ResponseDTO;
import com.philips.hsdp.research.fhdl.fhirservice.model.ResponseDTOStu3;
import com.philips.hsdp.research.fhdl.fhirservice.model.SearchParameterRegistryDTO;
import com.philips.hsdp.research.fhdl.fhirservice.util.FHIRUtility;

/*
 * @author Rajeshwar Tondare
 */
@Repository("SnowflakeDAO")
public class SnowflakeDAOImpl implements BaseDAO {
	private static final Logger log = LoggerFactory.getLogger(SnowflakeDAOImpl.class);
	private static final String JSON_FORMAT = "ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'";
	private static final String FROM = " FROM ";
	private static final String RESOURCE_JSON = "resourceJson";
	private static final String SELECT = "SELECT";
	private static final String WHERE = " WHERE ";
	private static final String UNION = " UNION ";
	private static final String RESOURCE_TYPE = "resourceType";
	private static final String BUNDLE = "Bundle";
	private static final String DOCUMENT = "document";
	private static final String DATE_TIME = "dd-MM-yyyy HH:mm:ss";

	@Autowired
	FHIRUtility utility;

	public boolean isSTU3 = false;
	public boolean isR4 = false;

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
		} catch (ClassNotFoundException ex) {
			log.info("Driver not found");
		}
		Properties properties = new Properties();
		properties.put("user", SnowflakeConfig.SNOWFLAKE_USER);
		properties.put("password", SnowflakeConfig.SNOWFLAKE_PASSWORD);
		properties.put("account", SnowflakeConfig.SNOWFLAKE_ACCOUNT);
		properties.put("snowflake_ips_db", SnowflakeConfig.SNOWFLAKE_IPSDB);
		properties.put("schema", SnowflakeConfig.SNOWFLAKE_SCHEMA);
		properties.put("warehouse", SnowflakeConfig.SNOWFLAKE_WAREHOUSE);

		String connectStr = System.getenv(Constants.SF_JDBC_CONNECT_STRING);
		if (connectStr == null) {
			connectStr = SnowflakeConfig.SNOWFLAKE_URL;
		}
		return DriverManager.getConnection(connectStr, properties);
	}

	@Override
	public ResponseDTO getDataForResourceR4(String id, String tableName) throws SQLException, ParseException {
		ResponseDTO responseDTO = new ResponseDTO();
		String resourceJson = null;
		Connection resourceConnection = null;
		Statement resourceStatement = null;
		ResultSet rs = null;
		try {
			resourceConnection = getConnection();
			resourceStatement = resourceConnection.createStatement();
			resourceStatement.executeQuery(JSON_FORMAT);

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * FROM" + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\"" + Constants.SF_SCHEMA + "\""
					+ "." + "\"" + tableName + "\"" + WHERE + "\"" + Constants.ID + "\"" + " = " + "\'" + id + "\'");

			rs = resourceStatement.executeQuery(sb.toString());
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
			if (resourceStatement != null) {
				try {
					resourceStatement.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
		}
		return responseDTO;
	}

	/**
	 * 
	 * This function is used to get IPS Summary Data from warehouse.
	 * 
	 * @param String : patientId
	 * @return String : responseDTO
	 */
	
	@Override
	public ResponseDTO getIPSSummaryDataForResourceR4(String patientId, String tableName)
			throws SQLException, ParseException {
		ResponseDTO responseDTO = new ResponseDTO();
		String resourceJson = null;
		Connection resourceConnection = null;
		Statement resourceStatement = null;
		try {
			resourceConnection = getConnection();
			resourceStatement = resourceConnection.createStatement();
			resourceStatement.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT" + " \"" + "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "."
					+ "\"" + Constants.SF_SCHEMA + "\"" + "." + "\"" + tableName + "\"" + " WHERE " + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'");

			ResultSet rs = resourceStatement.executeQuery(sb.toString());
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<JsonNode> resourceList = new ArrayList<JsonNode>();
			while (rs.next()) {
				resourceJson = rs.getString("resourceJson");
				JsonNode jsonResponse = null;
				jsonResponse = (resourceJson != null) ? mapper.readTree(resourceJson) : null;
				resourceList.add(jsonResponse);
			}
			responseDTO.setResource(resourceList);
		} catch (SQLException | IOException e) {
			log.info(e.getMessage());
		}
		return responseDTO;
	}

	@Override
	public ResponseDTOStu3 getDataForResourceStu3(String id, String tableName) throws SQLException, ParseException {
		ResponseDTOStu3 responseDTOStu3 = new ResponseDTOStu3();
		String resourceJson = null;
		Connection resourceConnection = null;
		Statement resourceStatement = null;
		ResultSet rs = null;
		try {
			resourceConnection = getConnection();
			resourceStatement = resourceConnection.createStatement();
			resourceStatement.executeQuery(JSON_FORMAT);

			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT " + "\"" + RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "."
					+ "\"" + Constants.SF_SCHEMA + "\"" + "." + "\"" + tableName + "\"" + WHERE + "\"" + Constants.ID
					+ "\"" + " = " + "\'" + id + "\'");

			rs = resourceStatement.executeQuery(sb.toString());
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
			if (resourceStatement != null) {
				try {
					resourceStatement.close();
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
		CompositionFHIRStructureDTO compositionFHIRStructureDTO = new CompositionFHIRStructureDTO();

		String resourceJson = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<JsonNode> compositionData = new ArrayList<>();
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeQuery(JSON_FORMAT);

			String cadQuery = "true";
			if (profile != null && profile.equalsIgnoreCase("CAD_PROFILE")) {
				cadQuery += " AND \"" + Constants.IPS_DB_NAME + "\"" + "." + "\"" + Constants.SF_SCHEMA + "\"" + "."
						+ "\"" + Constants.CONDITION_TABLE_NAME + "\"" + "." + "" + Constants.CONDITION_CODE + ""
						+ " IN (" + cadResponse + ")";
			}
			StringBuilder sb = new StringBuilder();
			sb.append(SELECT + " \"" + RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.PATIENT_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.OBSERVATION_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.IMMUNIZATION_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.ALLERGYINTOLERANCE_TABLE_NAME + "\"" + WHERE
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.CONDITION_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\' AND " + cadQuery + UNION + SELECT
					+ " \"" + RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.ENCOUNTER_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.ORGANIZATION_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.PRACTITIONER_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.MEDICATION_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.MEDICATIONSTATEMENT_TABLE_NAME + "\"" + WHERE
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.MEDICATIONREQUEST_TABLE_NAME + "\"" + WHERE
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'");

			rs = statement.executeQuery(sb.toString());
			ObjectMapper mapper = new ObjectMapper();
			while (rs.next()) {
				resourceJson = rs.getString(RESOURCE_JSON);
				JsonNode compositionResourceJson = (resourceJson != null) ? mapper.readTree(resourceJson) : null;
				CompositionDTO compositionDTO = new CompositionDTO();
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
		mainJsonObject.put(RESOURCE_TYPE, BUNDLE);
		mainJsonObject.put("Type", DOCUMENT);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_TIME);
		String formatDateTime = now.format(format);

		compositionFHIRStructureDTO.setResourceType(BUNDLE);
		compositionFHIRStructureDTO.setTimestamp(formatDateTime);
		compositionFHIRStructureDTO.setType(DOCUMENT);

		ArrayList<CompositionDTO> compDTO = new ArrayList<>();

		if (compositionData.size() > 0) {
			CompositionDTO compositionDataNew = new CompositionDTO();
			compositionDataNew.setResource(compositionData);
			compDTO.add(compositionDataNew);
		}

		ArrayList<Object> entryData = new ArrayList<>();
		entryData.add(compDTO);
		compositionFHIRStructureDTO.setEntry(entryData);
		return compositionFHIRStructureDTO;
	}

	@Override
	public CompositionFHIRStructureDTO getDataForCompositionSTU3(String patientId)
			throws SQLException, JsonProcessingException, ParseException {
		CompositionFHIRStructureDTO compositionFHIRStructureDTO = new CompositionFHIRStructureDTO();

		String resourceJson = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<JsonNode> compositionData = new ArrayList<>();
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeQuery(JSON_FORMAT);

			StringBuilder sb = new StringBuilder();
			sb.append(SELECT + " \"" + RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "."
					+ "\"" + Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.PATIENT_TABLE_NAME + "\"" + WHERE
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.OBSERVATION_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.IMMUNIZATION_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.ALLERGYINTOLERANCE_TABLE_NAME + "\"" + WHERE
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.CONDITION_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.ENCOUNTER_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.ORGANIZATION_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.PRACTITIONER_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.MEDICATION_TABLE_NAME + "\"" + WHERE + "\""
					+ Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.MEDICATIONSTATEMENT_TABLE_NAME + "\"" + WHERE
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + UNION + SELECT + " \""
					+ RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3 + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.MEDICATIONREQUEST_TABLE_NAME + "\"" + WHERE
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'");

			rs = statement.executeQuery(sb.toString());
			ObjectMapper mapper = new ObjectMapper();
			CompositionDTO compositionDTO = new CompositionDTO();
			while (rs.next()) {
				resourceJson = rs.getString(RESOURCE_JSON);
				JsonNode compositionResourceJson = (resourceJson != null) ? mapper.readTree(resourceJson) : null;				
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
		mainJsonObject.put(RESOURCE_TYPE, BUNDLE);
		mainJsonObject.put("Type", DOCUMENT);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_TIME);
		String formatDateTime = now.format(format);

		compositionFHIRStructureDTO.setResourceType(BUNDLE);
		compositionFHIRStructureDTO.setTimestamp(formatDateTime);
		compositionFHIRStructureDTO.setType(DOCUMENT);

		ArrayList<CompositionDTO> compDTO = new ArrayList<>();

		if (compositionData.size() > 0) {
			CompositionDTO compositionDataNew = new CompositionDTO();
			compositionDataNew.setResource(compositionData);
			compDTO.add(compositionDataNew);
		}

		ArrayList<Object> entryData = new ArrayList<>();
		entryData.add(compDTO);
		compositionFHIRStructureDTO.setEntry(entryData);
		return compositionFHIRStructureDTO;
	}

	public PatientFHIRStructureDTO getDataForPatientSearchSet()
			throws SQLException, JsonProcessingException, ParseException {

		PatientFHIRStructureDTO patientFHIRStructureDTO = new PatientFHIRStructureDTO();
		String resourceJson = null;
		Connection patientConnection = null;
		Statement patientStatement = null;
		ResultSet rs = null;
		ArrayList<JsonNode> patientData = new ArrayList<>();
		try {
			patientConnection = getConnection();
			patientStatement = patientConnection.createStatement();
			patientStatement.executeQuery(JSON_FORMAT);

			StringBuilder sb = new StringBuilder();
			sb.append(SELECT + "\"" + RESOURCE_JSON + "\"" + "FROM" + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
					+ Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.PATIENT_TABLE_NAME + "\"" + " LIMIT " + 10);

			rs = patientStatement.executeQuery(sb.toString());
			ObjectMapper mapper = new ObjectMapper();
			while (rs.next()) {
				resourceJson = rs.getString(RESOURCE_JSON);
				JsonNode jsonResponseForResourceJson = null;
				try {
					jsonResponseForResourceJson = (resourceJson != null) ? mapper.readTree(resourceJson) : null;
				} catch (IOException e) {
					log.info(e.getMessage());
				}
				PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
				patientResponseDTO.setResourceJson(jsonResponseForResourceJson);
				JsonNode patientResponse = patientResponseDTO.getResourceJson();
				patientData.add(patientResponse);
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
			if (patientStatement != null) {
				try {
					patientStatement.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode mainJsonObject = mapper.createObjectNode();
		mainJsonObject.put(RESOURCE_TYPE, BUNDLE);
		mainJsonObject.put("Type", "searchset");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_TIME);
		String formatDateTime = now.format(format);

		patientFHIRStructureDTO.setResourceType(BUNDLE);
		patientFHIRStructureDTO.setTimestamp(formatDateTime);
		patientFHIRStructureDTO.setType("searchset");

		ArrayList<CompositionDTO> compDTO = new ArrayList<>();

		if (patientData.size() > 0) {
			CompositionDTO patientDataNew = new CompositionDTO();
			patientDataNew.setResource(patientData);
			compDTO.add(patientDataNew);
		}

		ArrayList<Object> entryData = new ArrayList<>();
		entryData.add(compDTO);
		patientFHIRStructureDTO.setEntry(entryData);
		return patientFHIRStructureDTO;
	}

	@Override
	public FhirVersionMappingDTO getFhirVersionMappingStu3(String id, String patientId, String tableName)
			throws SQLException, JsonProcessingException, ParseException {

		FhirVersionMappingDTO fhirVersionMappingDTO = new FhirVersionMappingDTO();
		String resourceType = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeQuery(JSON_FORMAT);

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * FROM" + " \"" + Constants.IPS_DB_NAME + "\"" + "." + "\"" + Constants.SF_SCHEMA + "\""
					+ "." + "\"" + Constants.VERSION_TABLE_NAME + "\"" + WHERE + "\"" + Constants.VERSION_TABLE_NAME
					+ "\"" + "." + "\"" + Constants.ID + "\"" + " = " + "\'" + id + "\';");

			rs = statement.executeQuery(sb.toString());
			while (rs.next()) {
				resourceType = rs.getString(RESOURCE_TYPE);
				id = rs.getString("id");
				isSTU3 = rs.getBoolean("isSTU3");
				isR4 = rs.getBoolean("isR4");

				if (isSTU3) {
					log.info("isSTU3 = " + true);
				} else {
					log.info("isSTU3 = " + false);
				}
				if (isR4) {
					log.info("isR4 = " + true);
				} else {
					log.info("isR4 = " + false);
				}
				fhirVersionMappingDTO.setResourceType(resourceType);
				fhirVersionMappingDTO.setId(id);
				fhirVersionMappingDTO.setIsR4(isR4);
				fhirVersionMappingDTO.setIsSTU3(isSTU3);
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
		return fhirVersionMappingDTO;
	}

	@SuppressWarnings("resource")
	@Override
	public ResponseDTO getDataForResourceMulti(String id, String patientId, String resourceType, String profile)
			throws SQLException, JsonProcessingException, ParseException {

		ResponseDTO responseDTO = new ResponseDTO();
		String resourceJson = null;
		Connection resourceConnection = null;
		Statement resourceStatement = null;
		ResultSet rs = null;
		try {
			resourceConnection = getConnection();
			resourceStatement = resourceConnection.createStatement();
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<JsonNode> resourceList = new ArrayList<>();
			JsonNode jsonResponse = null;
			resourceStatement.executeQuery(JSON_FORMAT);
			if (getFhirVersionMappingStu3(id, patientId, resourceType) != null) {
				if (isSTU3 == true) {
					String query = SELECT + " \"" + RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME_STU3
							+ "\"" + "." + "\"" + Constants.SF_SCHEMA + "\"" + "." + "\"" + resourceType + "\"" + WHERE;

					if (id != null) {
						query += "\"" + resourceType + "\"" + "." + "\"" + Constants.ID + "\"" + " = " + "\'" + id
								+ "\'";
					} else if (patientId != null) {
						query += "\"" + resourceType + "\"" + "." + "\"" + Constants.PATIENTID + "\"" + " = " + "\'"
								+ patientId + "\'";
					}
					rs = resourceStatement.executeQuery(query);
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							log.info(e.getMessage());
						}
					} 
					while (rs.next()) {
						resourceJson = rs.getString(RESOURCE_JSON);
						try {
							jsonResponse = (resourceJson != null) ? mapper.readTree(resourceJson) : null;
						} catch (IOException e) {
							log.info(e.getMessage());
						}
						resourceList.add(jsonResponse);
					}
				}
				
				if (isR4 == true) {
					String query = SELECT + " \"" + RESOURCE_JSON + "\"" + FROM + "\"" + Constants.IPS_DB_NAME + "\""
							+ "." + "\"" + Constants.SF_SCHEMA + "\"" + "." + "\"" + resourceType + "\"" + WHERE;

					if (id != null) {
						query += "\"" + resourceType + "\"" + "." + "\"" + Constants.ID + "\"" + " = " + "\'" + id
								+ "\'";
					} else if (patientId != null) {
						query += "\"" + resourceType + "\"" + "." + "\"" + Constants.PATIENTID + "\"" + " = " + "\'"
								+ patientId + "\'";
					}

					rs = resourceStatement.executeQuery(query);
					while (rs.next()) {
						resourceJson = rs.getString(RESOURCE_JSON);
						try {
							jsonResponse = (resourceJson != null) ? mapper.readTree(resourceJson) : null;
						} catch (IOException e) {
							log.info(e.getMessage());
						}
						resourceList.add(jsonResponse);
					}
				}
			}
			responseDTO.setResource(resourceList);

		} catch (SQLException | JSONException | IOException e) {
			log.info(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
			if (resourceStatement != null) {
				try {
					resourceStatement.close();
				} catch (SQLException e) {
					log.info(e.getMessage());
				}
			}
		}
		return responseDTO;
	}

	@Override
	public ObservationResponseDTO getSearchResultForObservation(String code)
			throws SQLException, JsonProcessingException, ParseException {
		ObservationResponseDTO observationResponseDTO = new ObservationResponseDTO();
		String resourceJson = null;
		Connection connection = null;
		Statement statement = null;
		String path = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			String pathResult = getPath(path);
			statement.executeQuery(JSON_FORMAT);
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT *");
			sb.append(" FROM" + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\"" + Constants.SF_SCHEMA + "\"" + "."
					+ "\"" + Constants.OBSERVATION_TABLE_NAME + "\"" + "as Observation");
			sb.append(WHERE + pathResult + " LIKE " + "\'%" + code + "%\'");
			rs = statement.executeQuery(sb.toString());
			ObjectMapper mapper = new ObjectMapper();
			while (rs.next()) {
				resourceJson = rs.getString(RESOURCE_JSON);
				JsonNode jsonResponseForResourceJson = null;
				jsonResponseForResourceJson = (resourceJson != null) ? mapper.readTree(resourceJson) : null;
				observationResponseDTO.setResourceJson(jsonResponseForResourceJson);
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
		return observationResponseDTO;
	}

	/**
	 * 
	 * This function is used to get path from searchParameterRegistry table.
	 * 
	 * @return String : path
	 */
	
	public String getPath(String path) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		path = null;
		SearchParameterRegistryDTO searchParameterRegistryDTO = new SearchParameterRegistryDTO();
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeQuery(JSON_FORMAT);
			StringBuilder sb = new StringBuilder();
			sb.append(SELECT + "\"" + Constants.PATHS + "\"");
			sb.append(FROM + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\"" + Constants.SF_SCHEMA + "\"" + "." + "\""
					+ Constants.SEARCH_TABLE_NAME + "\"");
			sb.append(WHERE + "\"" + Constants.TABLE_NAME + "\"" + "=" + "\'" + "Observation" + "\'" + "AND" + "\""
					+ Constants.PARAMETER + "\"" + "=" + "\'" + "code" + "\'");
			rs = statement.executeQuery(sb.toString());
			while (rs.next()) {
				path = rs.getString("Paths");
			}
			searchParameterRegistryDTO.setPaths(path);
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
		return searchParameterRegistryDTO.getPaths();
	}

	@Override
	public PatientResponseDTO getPatientDataFromHive(String id)
			throws SQLException, JsonProcessingException, ParseException {
		return null;
	}

	/**
	 * 
	 * This function is used to get IPS Data from warehouse.
	 * 
	 * @param String : patientId
	 * @return String : compositionFHIRStructureDTO
	 */
	
	@Override
	public CompositionFHIRStructureDTO getDataForIPSR4(String patientId, String cadResponse)
			throws SQLException, ParseException, IOException
			 {
		CompositionFHIRStructureDTO compositionFHIRStructureDTO = new CompositionFHIRStructureDTO();

		String resourceJson = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<JsonNode> compositionData = new ArrayList<JsonNode>();
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
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
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION " + "SELECT" + " \""
					+ "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "." + "\""
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

		if (!compositionData.isEmpty()) {
			CompositionDTO compositionDataNew = new CompositionDTO();
			compositionDataNew.setResource(compositionData);
			compDTO.add(compositionDataNew);
		}

		ArrayList<Object> entryData = new ArrayList<Object>();
		entryData.add(compDTO);
		compositionFHIRStructureDTO.setEntry(entryData);
		return compositionFHIRStructureDTO;
	}

	/**
	 * 
	 * This function is used to get CAD Summary Comorbidities Data from warehouse.
	 * 
	 * @param String : patientId
	 * @return String : compositionFHIRStructureDTO
	 */
	
	@Override
	public CompositionFHIRStructureDTO getDataForCADSummaryComorbiditiesR4(String patientId, String cadResponse) 
			throws SQLException, ParseException, IOException {
		CompositionFHIRStructureDTO compositionFHIRStructureDTO = new CompositionFHIRStructureDTO();

		String resourceJson = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<JsonNode> compositionData = new ArrayList<JsonNode>();
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");

			String cadQuery = "true";
			cadQuery += " AND \"" + Constants.IPS_DB_NAME + "\"" + "." + "\"" + Constants.SF_SCHEMA + "\"" + "." + "\""
					+ Constants.CONDITION_TABLE_NAME + "\"" + "." + "" + Constants.CONDITION_CODE + "" + " IN ("
					+ cadResponse + ")";

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT" + " \"" + "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "."
					+ "\"" + Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.CONDITION_TABLE_NAME + "\"" + " WHERE "
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\' AND " + cadQuery);

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

		if (!compositionData.isEmpty()) {
			CompositionDTO compositionDataNew = new CompositionDTO();
			compositionDataNew.setResource(compositionData);
			compDTO.add(compositionDataNew);
		}

		ArrayList<Object> entryData = new ArrayList<Object>();
		entryData.add(compDTO);
		compositionFHIRStructureDTO.setEntry(entryData);
		return compositionFHIRStructureDTO;

	}

	/**
	 * 
	 * This function is used to get CAD Summary Data from warehouse.
	 * 
	 * @param String : patientId
	 * @return String : compositionFHIRStructureDTO
	 */
	
	@Override
	public CompositionFHIRStructureDTO getDataForCADSummaryR4(String patientId, String cadResponse)
			throws SQLException, ParseException, IOException {
		CompositionFHIRStructureDTO compositionFHIRStructureDTO = new CompositionFHIRStructureDTO();

		String resourceJson = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<JsonNode> compositionData = new ArrayList<JsonNode>();
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");

			String cadQuery = "true";
			cadQuery += " AND \"" + Constants.IPS_DB_NAME + "\"" + "." + "\"" + Constants.SF_SCHEMA + "\"" + "." + "\""
					+ Constants.CONDITION_TABLE_NAME + "\"" + "." + "" + Constants.CONDITION_CODE + "" + " IN ("
					+ cadResponse + ")";

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
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\' AND " + cadQuery + " UNION "
					+ "SELECT" + " \"" + "resourceJson" + "\"" + " FROM " + "\"" + Constants.IPS_DB_NAME + "\"" + "."
					+ "\"" + Constants.SF_SCHEMA + "\"" + "." + "\"" + Constants.ENCOUNTER_TABLE_NAME + "\"" + " WHERE "
					+ "\"" + Constants.PATIENTID + "\"" + " = " + "\'" + patientId + "\'" + " UNION " + "SELECT" + " \""
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

		if (!compositionData.isEmpty()) {
			CompositionDTO compositionDataNew = new CompositionDTO();
			compositionDataNew.setResource(compositionData);
			compDTO.add(compositionDataNew);
		}

		ArrayList<Object> entryData = new ArrayList<Object>();
		entryData.add(compDTO);
		compositionFHIRStructureDTO.setEntry(entryData);
		return compositionFHIRStructureDTO;
	}
}