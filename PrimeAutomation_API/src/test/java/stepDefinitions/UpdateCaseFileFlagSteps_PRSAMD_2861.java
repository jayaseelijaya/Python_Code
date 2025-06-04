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


public class UpdateCaseFileFlagSteps_PRSAMD_2861 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UpdateCaseFileFlagSteps_PRSAMD_2861.class);
	
		// *********************GIVEN BLOCK*******************************
	
	@Given("the base URL is entered for updating case file flag by PUT API")
	public void the_base_url_is_entered_for_updating_case_file_flag_by_put_api() 
		throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("HIL_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
		// *********************WHEN BLOCK*******************************
	
	@When("user gives a valid {string} and {string} and {string} {int} and triggers the PUT API for updating case file flag")
	public void user_gives_a_valid_and_and_and_triggers_the_put_api_for_updating_case_file_flag(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hil/caseflag");
		logger.info("API is triggered");
	}
	
	@When("user gives a valid {string} and {string} and invalid test data from {string} {int} and triggers the PUT API for updating case file flag")
	public void user_gives_a_valid_and_and_invalid_test_data_from_and_triggers_the_put_api_for_updating_case_file_flag(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hil/caseflag");
		logger.info("API is triggered");
	}

	@When("user gives an invalid {string} and {string} and valid test data from {string} {int} and triggers the PUT API for updating case file flag")
	public void user_gives_an_invalid_and_and_valid_test_data_from_and_triggers_the_put_api_for_updating_case_file_flag(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hil/caseflag");
		logger.info("API is triggered");
	}
	
		// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code while updating case file flag PUT API")
	public void response_is_generated_with_success_status_code_while_updating_case_file_flag_put_api() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with no data found status code while updating case file flag PUT API")
	public void response_is_generated_with_no_data_found_status_code_while_updating_case_file_flag_put_api() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorised status code while updating case file flag PUT API")
	public void response_is_generated_with_unauthorised_status_code_while_updating_case_file_flag_put_api() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("an attribute {string} is verified while updating case file flag PUT API")
	public void an_attribute_is_verified_while_updating_case_file_flag_put_api(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			logger.info("responseMessage is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("responseMessage is validated against response");
			} 
		else if (keyValue.equalsIgnoreCase("errors")){
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
		
		else if (keyValue.equalsIgnoreCase("errorDetails")){
			String errorDetails = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errorDetails");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errorDetails);
			logger.info("Errors Details is validated against response");
		}
	}
	
	
	// *********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_2861.xlsx", SheetName);
		String caseId = testData.get(RowNumber).get("caseId");
		String isBaseDicomFileAvailable = testData.get(RowNumber).get("isBaseDicomFileAvailable");
		String isCaseFileAvailable = testData.get(RowNumber).get("isCaseFileAvailable");
		String isSegmentedNrrdFileAvailable = testData.get(RowNumber).get("isSegmentedNrrdFileAvailable");
		String isCaseReportAvailable = testData.get(RowNumber).get("isCaseReportAvailable");
		
		JSONObject payload = new JSONObject();
		payload.put("caseId", caseId);
		payload.put("isBaseDicomFileAvailable", isBaseDicomFileAvailable);
		payload.put("isCaseFileAvailable", isCaseFileAvailable);
		payload.put("isSegmentedNrrdFileAvailable", isSegmentedNrrdFileAvailable);
		payload.put("isCaseReportAvailable", isCaseReportAvailable);
		
		
		return payload;
	
	}

}