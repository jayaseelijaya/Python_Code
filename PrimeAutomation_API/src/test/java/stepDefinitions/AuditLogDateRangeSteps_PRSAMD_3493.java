package stepDefinitions;

import java.util.Scanner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import utility.CommonUtils;
import utility.ExcelReader;
import io.cucumber.core.internal.com.fasterxml.jackson.core.exc.StreamWriteException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.DatabindException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.MappingIterator;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.SerializationFeature;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.Converter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AuditLogDateRangeSteps_PRSAMD_3493 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(AuditLogDateRangeSteps_PRSAMD_3493.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("a user enters the valid URL for fetching Audit logs based on date range selection")
	public void a_user_enters_the_valid_url_for_fetching_audit_logs_based_on_date_range_selection() 
		throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("HIL_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("the user gives a valid {string} and {string} with valid Test Data as {string} {int} and trigger GET API to fetch Audit logs based on date range selection")
	public void the_user_gives_a_valid_and_with_valid_test_data_as_and_trigger_get_api_to_fetch_audit_logs_based_on_date_range_selection(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/logger/exportselectedlog");
		logger.info("API is triggered");
	}

	@When("the user gives an invalid {string} and {string} with valid Test Data as {string} {int} and trigger GET API to fetch Audit logs based on date range selection")
	public void the_user_gives_an_invalid_and_with_valid_test_data_as_and_trigger_get_api_to_fetch_audit_logs_based_on_date_range_selection(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/logger/exportselectedlog");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code for fetching Audit logs based on date range selection {int}")
	public void response_is_generated_with_success_status_code_for_fetching_audit_logs_based_on_date_range_selection(Integer code) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(code).extract().response().asString();
		
		logger.info("Status Code is :" + code);
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorised status code for fetching Audit logs based on date range selection {int}")
	public void response_is_generated_with_unauthorised_status_code_for_fetching_audit_logs_based_on_date_range_selection(Integer code) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(code).extract().response().asString();
		
		logger.info("Status Code is :" + code);
		logger.info("Response body as : " + resp);
	}

	@Then("the attribute {string} is validated for fetching Audit logs based on date range selection")
	public void the_attribute_is_validated_for_fetching_audit_logs_based_on_date_range_selection(String KeyValue) {
		if (KeyValue.equalsIgnoreCase("errors")) {
			String errors = getJsonPath(_RESPONSE, KeyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
	}
	
	// function to get the test-data from excel sheet
	private HashMap<String, String> payload(String sheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
					System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_3493.xlsx",
					sheetName);
			String startDate = testData.get(RowNumber).get("startDate");
			String endDate = testData.get(RowNumber).get("endDate");

			JSONObject payload = new JSONObject();
			payload.put("startDate", startDate);
			payload.put("endDate", endDate);
			
		
			return payload;
		}
}