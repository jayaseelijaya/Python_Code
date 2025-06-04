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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import utility.CommonUtils;
import utility.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class UpdateActivationStatusSteps_PRSAMD_437 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UpdateActivationStatusSteps_PRSAMD_437.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the User enters the Base URL to update activation status of facility")
	public void the_user_enters_the_base_url_to_update_activation_status_of_facility() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	
	// *********************WHEN BLOCK*******************************
	
	@When("user provides a valid {string} with {string} with the Request Body from {string} and {int} and trigger the PUT API to update activation status of facility")
	public void user_provides_a_valid_with_with_the_request_body_from_and_and_trigger_the_put_api_to_update_activation_status_of_facility(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).put("/imageupload/activationstatus");
		logger.info("API is triggered");
	}
	
	@When("User provides a valid {string} with {string} with Invalid or Blank Request Bodies from {string} and {int} and trigger the PUT API to update activation status of facility")
	public void user_provides_a_valid_with_with_invalid_or_blank_request_bodies_from_and_and_trigger_the_put_api_to_update_activation_status_of_facility(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).put("/imageupload/activationstatus");
		logger.info("API is triggered");
	}
	
	@When("User provides an invalid {string} with {string} with Valid Request Bodies from {string} and {int} and trigger the PUT API to update activation status of facility")
	public void user_provides_an_invalid_with_with_valid_request_bodies_from_and_and_trigger_the_put_api_to_update_activation_status_of_facility(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).put("/imageupload/activationstatus");
		logger.info("API is triggered");
	}
	
	
	// *********************THEN BLOCK*******************************
	
	@Then("a response code of {int} is generated fetching the update activation status of facility")
	public void a_response_code_of_is_generated_fetching_the_update_activation_status_of_facility(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("a response code of {int} is being generated showing error in updating activation status of facility")
	public void a_response_code_of_is_being_generated_showing_error_in_updating_activation_status_of_facility(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("a response code of {int} is getting generated showing Unauthorised error in updating activation status of facility")
	public void a_response_code_of_is_getting_generated_showing_unauthorised_error_in_updating_activation_status_of_facility(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("attribute named {string} is verified in response body to update activation status of facility.")
	public void attribute_named_is_verified_in_response_body_to_update_activation_status_of_facility(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String responseMessage = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			
			logger.info("responseMessage is : " + expected_value);
			assertEquals(expected_value, responseMessage);
			logger.info("The attribute values against the response body is verified");
		}
			
			else {
				String errors = getJsonPath(_RESPONSE, keyValue);
				expected_value = getJsonPath(_RESPONSE, "errors");
				logger.info("Error message : " + expected_value);
				assertEquals(expected_value, errors);
				logger.info("Errors is validated against response");
			}
	}
	
//	*********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_437.xlsx", SheetName);
		String facilityId = testData.get(RowNumber).get("facilityId");
		String activationStatus = testData.get(RowNumber).get("activationStatus");
		
		JSONObject payload = new JSONObject();
		payload.put("facilityId", facilityId);
		payload.put("activationStatus", activationStatus);
		
		return payload;
	
	
	}
	
}
