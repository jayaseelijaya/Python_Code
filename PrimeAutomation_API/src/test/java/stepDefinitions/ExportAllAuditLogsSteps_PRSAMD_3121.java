package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import utility.CommonUtils;
import utility.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ExportAllAuditLogsSteps_PRSAMD_3121 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(ExportAllAuditLogsSteps_PRSAMD_3121.class);
	
		// *********************GIVEN BLOCK*******************************
	
	@Given("the base URL is entered for Exporting all functionality in Audit Logs")
	public void the_base_url_is_entered_for_exporting_all_functionality_in_audit_logs() 
		throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
		//  *********************WHEN BLOCK*******************************
	
//	************************************POST API**********************************************
	
	@When("user gives a valid {string} and {string} and {string} {int} and triggers the POST API for Exporting all functionality in Audit Logs")
	public void user_gives_a_valid_and_and_and_triggers_the_post_api_for_exporting_all_functionality_in_audit_logs(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/imageupload/exportall");
		logger.info("API is triggered");
	}
	
	@When("user gives a valid {string} and {string} and invalid test data from {string} {int} and triggers the POST API for Exporting all functionality in Audit Logs")
	public void user_gives_a_valid_and_and_invalid_test_data_from_and_triggers_the_post_api_for_exporting_all_functionality_in_audit_logs(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/imageupload/exportall");
		logger.info("API is triggered");
	}
	
	@When("user gives an invalid {string} and {string} and valid test data from {string} {int} and triggers the POST API for Exporting all functionality in Audit Logs")
	public void user_gives_an_invalid_and_and_valid_test_data_from_and_triggers_the_post_api_for_exporting_all_functionality_in_audit_logs(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/imageupload/exportall");
		logger.info("API is triggered");
	}
	
//	************************************GET API**********************************************

	@When("user gives a valid {string} and {string} and {string} {int} and triggers the GET API for Exporting all functionality in Audit Logs")
	public void user_gives_a_valid_and_and_and_triggers_the_get_api_for_exporting_all_functionality_in_audit_logs(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/exportall");
		logger.info("API is triggered");
	}
	
	@When("user gives a valid {string} and {string} and invalid test data from {string} {int} and triggers the GET API for Exporting all functionality in Audit Logs")
	public void user_gives_a_valid_and_and_invalid_test_data_from_and_triggers_the_get_api_for_exporting_all_functionality_in_audit_logs(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/exportall");
		logger.info("API is triggered");
	}
	
	@When("user gives an invalid {string} and {string} and valid test data from {string} {int} and triggers the GET API for Exporting all functionality in Audit Logs")
	public void user_gives_an_invalid_and_and_valid_test_data_from_and_triggers_the_get_api_for_exporting_all_functionality_in_audit_logs(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/exportall");
		logger.info("API is triggered");
	}
	
		//  *********************THEN BLOCK*******************************
	
//	************************************POST API**********************************************

	@Then("Response is generated with success status code while Exporting all functionality in Audit Logs POST API")
	public void response_is_generated_with_success_status_code_while_exporting_all_functionality_in_audit_logs_post_api() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with failure status code while Exporting all functionality in Audit Logs POST API")
	public void response_is_generated_with_failure_status_code_while_exporting_all_functionality_in_audit_logs_post_api() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorised status code while Exporting all functionality in Audit Logs POST API")
	public void response_is_generated_with_unauthorised_status_code_while_exporting_all_functionality_in_audit_logs_post_api() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}


	@Then("an attribute {string} is verified while Exporting all functionality in Audit Logs POST API")
	public void an_attribute_is_verified_while_exporting_all_functionality_in_audit_logs_post_api(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String responseMessage = getJsonPath(_RESPONSE, keyValue);
			String logFileCreated = getJsonPath(_RESPONSE, "logFileCreated");
			
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			
			logger.info("responseMessage field values are : " + responseMessage);
			logger.info("logFileCreated field values are : : " + logFileCreated);
			
			logger.info("Response Message values against the response body is verified");
		}
		
		else {
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
	}
	
//	************************************GET API**********************************************

	@Then("Response is generated with success status code while Exporting all functionality in Audit Logs GET API")
	public void response_is_generated_with_success_status_code_while_exporting_all_functionality_in_audit_logs_get_api() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with failure status code while Exporting all functionality in Audit Logs GET API")
	public void response_is_generated_with_failure_status_code_while_exporting_all_functionality_in_audit_logs_get_api() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorised status code while Exporting all functionality in Audit Logs GET API")
	public void response_is_generated_with_unauthorised_status_code_while_exporting_all_functionality_in_audit_logs_get_api() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("an attribute {string} is verified while Exporting all functionality in Audit Logs GET API")
	public void an_attribute_is_verified_while_exporting_all_functionality_in_audit_logs_get_api(String keyValue) {
		if (keyValue.equalsIgnoreCase("logfileurl")) {
			String logfileurl = getJsonPath(_RESPONSE, keyValue);
			String updatedDate = getJsonPath(_RESPONSE, "updatedDate");
			
			expected_value = getJsonPath(_RESPONSE, "logfileurl");
			
			logger.info("logfileurl field values are : " + logfileurl);
			logger.info("updatedDate field values are : : " + updatedDate);
			
			logger.info("logfileurl values against the response body is verified");
		}
		
		else {
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
	}
	
	
	// *********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
			private HashMap<String, String> payload(String SheetName, Integer RowNumber)
					throws InvalidFormatException, IOException {
				ExcelReader reader = new ExcelReader();
				List<Map<String, String>> testData = reader.getData(
						System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_3121.xlsx", SheetName);
				String userId = testData.get(RowNumber).get("userId");
				String userFacilityId = testData.get(RowNumber).get("userFacilityId");
				
				
				JSONObject payload = new JSONObject();
				payload.put("userId", userId);
				payload.put("userFacilityId", userFacilityId);
				
				
				
				return payload;
			
			}
	
}