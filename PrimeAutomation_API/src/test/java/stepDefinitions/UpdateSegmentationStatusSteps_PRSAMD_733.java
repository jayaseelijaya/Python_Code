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


public class UpdateSegmentationStatusSteps_PRSAMD_733 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UpdateSegmentationStatusSteps_PRSAMD_733.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the User enters the Base URL to update Segmentation Status")
	public void the_user_enters_the_base_url_to_update_segmentation_status() 
			throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("HIL_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("user provides a valid {string} with {string} with the valid Request body from {string} and {int} and trigger the PUT API to update segmentation status")
	public void user_provides_a_valid_with_with_the_valid_request_body_from_and_and_trigger_the_put_api_to_update_segmentation_status(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hospitalservice/status");
		logger.info("API is triggered");
	}
	
	@When("User provides a valid {string} with {string} with Blank Request Body from {string} and {int} and trigger the PUT API to update segmentation status")
	public void user_provides_a_valid_with_with_blank_request_body_from_and_and_trigger_the_put_api_to_update_segmentation_status(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hospitalservice/status");
		logger.info("API is triggered");
	}
	
	@When("User provides a valid {string} with {string} with Invalid Request Body from {string} and {int} and trigger the PUT API to update segmentation status")
	public void user_provides_a_valid_with_with_invalid_request_body_from_and_and_trigger_the_put_api_to_update_segmentation_status(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hospitalservice/status");
		logger.info("API is triggered");
	}
	
	@When("User provides an invalid {string} with {string} with Valid Request body from {string} and {int} and trigger the PUT API to update segmentation status")
	public void user_provides_an_invalid_with_with_valid_request_body_from_and_and_trigger_the_put_api_to_update_segmentation_status(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/hospitalservice/status");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("a response code of {int} is generated for updating the Segmentation Status")
	public void a_response_code_of_is_generated_for_updating_the_segmentation_status(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response code of {int} gets generated showing error in updating the Segmentation Status")
	public void a_response_code_of_gets_generated_showing_error_in_updating_the_segmentation_status(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response code of {int} is getting generated showing error in updating the Segmentation Status")
	public void a_response_code_of_is_getting_generated_showing_error_in_updating_the_segmentation_status(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response code of {int} is being generated showing Unauthorised error in updating the Segmentation Status")
	public void a_response_code_of_is_being_generated_showing_unauthorised_error_in_updating_the_segmentation_status(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("attribute named {string} is verified in response body to update status.")
	public void attribute_named_is_verified_in_response_body_to_update_status(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			logger.info("Response Message is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("responseMessage is validated against response");
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
						System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_733.xlsx", SheetName);
				String uploadId = testData.get(RowNumber).get("uploadId");
				String status = testData.get(RowNumber).get("status");
				String notes = testData.get(RowNumber).get("notes");
				
				JSONObject payload = new JSONObject();
				payload.put("uploadId", uploadId);
				payload.put("status", status);
				payload.put("notes", notes);
				
				return payload;
			}

}