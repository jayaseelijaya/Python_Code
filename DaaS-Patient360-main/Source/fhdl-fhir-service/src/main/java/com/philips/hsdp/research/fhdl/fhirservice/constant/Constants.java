/**
  * (C) Koninklijke Philips Electronics N.V. 2021
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  **/
package com.philips.hsdp.research.fhdl.fhirservice.constant;

import java.util.Arrays;
import java.util.List;

/*
 * @author Rajeshwar Tondare
 */
public class Constants {
	// public static final String RMQ_QUEUE = "fhdl.queue";
	// public static final String RMQ_EXCHANGE = "fhdl.exchange";
	// public static final String RMQ_BINDING_KEY = "fhdl.bindkey";
	public static final List<String> VAULT_KEYS = Arrays.asList("fhdl-common-credentials", "fhdl-s3-credentials");
	public static final String SF_JDBC_CONNECT_STRING = "SF_JDBC_CONNECT_STRING";
	public static final String SF_SCHEMA = "PUBLIC";
	public static final String SF_STAGE_NAME = "sf_fhdl_stage";
	public static final String SF_FORMAT = "json_format";
	public static final String SNOWFLAKES_DRIVER_NAME = "net.snowflake.client.jdbc.SnowflakeDriver";
	public static final String IPS_DB_NAME = "fhdl_ips";
	public static final String IPS_DB_NAME_STU3 = "fhdl_ips_stu3";
	public static final String AMBULATORY_DB_NAME = "Ambulatory";
	public static final String PATIENT_TABLE_NAME = "Patient";
	public static final String OBSERVATION_TABLE_NAME = "Observation";
	public static final String IMMUNIZATION_TABLE_NAME = "Immunization";
	public static final String ALLERGYINTOLERANCE_TABLE_NAME = "AllergyIntolerance";
	public static final String CONDITION_TABLE_NAME = "Condition";
	public static final String ENCOUNTER_TABLE_NAME = "Encounter";
	public static final String ORGANIZATION_TABLE_NAME = "Organization";
	public static final String PRACTITIONER_TABLE_NAME = "Practitioner";
	public static final String MEDICATION_TABLE_NAME = "Medication";
	public static final String MEDICATIONSTATEMENT_TABLE_NAME = "MedicationStatement";
	public static final String MEDICATIONREQUEST_TABLE_NAME = "MedicationRequest";
	public static final String ID = "id";
	public static final String PATIENTID = "patientId";
	public static final String CONDITION_CODE = "\"code\":\"coding\"[0]:\"code\"";
	public static final String CODE = "code";
	public static final String TABLE_NAME = "tableName";
	public static final String PARAMETER = "parameter";
	public static final String PATHS ="Paths";
	public static final String SEARCH_TABLE_NAME ="searchParameterRegistry_old";
	public static final String VERSION_TABLE_NAME = "fhirVersionMapping";
	
	private Constants() {
		throw new IllegalStateException("Constants class. Cannot instantiate.");
	}
}