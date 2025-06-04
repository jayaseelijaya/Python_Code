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

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;

import utility.CommonUtils;
import utility.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateReviewTimeSteps_PRSAMD_2434 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UpdateReviewTimeSteps_PRSAMD_2434.class);

	// *********************GIVEN BLOCK*******************************
	
	@Given("a user enters the valid URL for updating Review Time for HIL User")
	public void a_user_enters_the_valid_url_for_updating_review_time_for_hil_user()
			throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("MIC_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("the user gives a valid {string} and {string} with valid Test Data from {string} and {int} and trigger PUT API to update Review Time for HIL User")
	public void the_user_gives_a_valid_and_with_valid_test_data_from_and_and_trigger_put_api_to_update_review_time_for_hil_user(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hospitalservice/reviewtime");

		logger.info("API is triggered");
	}
	
	@When("the user gives a valid {string} and {string} with blank Test Data from {string} and {int} and trigger PUT API to update Review Time for HIL User")
	public void the_user_gives_a_valid_and_with_blank_test_data_from_and_and_trigger_put_api_to_update_review_time_for_hil_user(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hospitalservice/reviewtime");
		logger.info("-------------------------------"+_RESPONSE.toString());
		logger.info("API is triggered");
	}
	

	@When("the user gives a valid {string} and {string} with invalid Test Data from {string} and {int} and trigger PUT API to update Review Time for HIL User")
	public void the_user_gives_a_valid_and_with_invalid_test_data_from_and_and_trigger_put_api_to_update_review_time_for_hil_user(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hospitalservice/reviewtime");
		logger.info("API is triggered");
	}
	
	@When("the user gives an invalid {string} and {string} with valid Test Data from {string} and {int} and trigger PUT API for updating Review Time for HIL User")
	public void the_user_gives_an_invalid_and_with_valid_test_data_from_and_and_trigger_put_api_for_updating_review_time_for_hil_user
	(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hospitalservice/reviewtime");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code for updating Review Time for HIL User")
	public void response_is_generated_with_success_status_code_for_updating_review_time_for_hil_user() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with failure status code for updating Review Time for HIL User")
	public void response_is_generated_with_failure_status_code_for_updating_review_time_for_hil_user() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with no data found status code for updating Review Time for HIL User")
	public void response_is_generated_with_no_data_found_status_code_for_updating_review_time_for_hil_user() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code for updating Review Time for HIL User")
	public void response_is_generated_with_unauthorized_status_code_for_updating_review_time_for_hil_user() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("the attribute {string} is validated for updating Review Time for HIL User")
	public void the_attribute_is_validated_for_updating_review_time_for_hil_user(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			logger.info("Response Message is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("responseMessage is validated against response");
			} 
		else if(keyValue.equalsIgnoreCase("errors")){
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
		
		else if(keyValue.equalsIgnoreCase("errorDetails")){
			String errorDetails = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errorDetails");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errorDetails);
			logger.info("Errors is validated against response");
		}
	}

//	*********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_2434.xlsx", SheetName);
		String caseId = testData.get(RowNumber).get("caseId");
		String reviewTimeInseconds = testData.get(RowNumber).get("reviewTimeInseconds");
		
	
		JSONObject payload = new JSONObject();
		payload.put("caseId", caseId);
		payload.put("reviewTimeInseconds", reviewTimeInseconds);
		
		
		return payload;
	
	}}
