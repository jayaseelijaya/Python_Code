/**
  * (C) Koninklijke Philips Electronics N.V. 2021
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  **/
package com.philips.hsdp.research.fhdl.fhirservice.config;

/*
 * @author Rajeshwar Tondare
 */
public class SnowflakeConfig {
	  private SnowflakeConfig() {
		   throw new IllegalStateException("Config class");
		   }
	public static final String SNOWFLAKE_USER = System.getProperty("snowflake_user");
	public static final String SNOWFLAKE_PASSWORD = System.getProperty("snowflake_password");
	public static final String SNOWFLAKE_ACCOUNT = System.getProperty("snowflake_account");
	public static final String SNOWFLAKE_IPSDB = System.getProperty("snowflake_ips_db");
	public static final Object SNOWFLAKE_IPSDB_STUS3 = System.getProperty("snowflake_ips_db_stu3");
	public static final String SNOWFLAKE_SCHEMA = System.getProperty("snowflake_schema");
	public static final String SNOWFLAKE_WAREHOUSE = System.getProperty("snowflake_warehouse");
	public static final String SNOWFLAKE_URL = System.getProperty("snowflake_conn_url");
	public static final String SNOWFLAKE_AMBULATORY_DB = System.getProperty("snowflake_Ambulatory_db");
}