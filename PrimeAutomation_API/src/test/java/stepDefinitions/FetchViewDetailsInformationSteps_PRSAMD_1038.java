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


public class FetchViewDetailsInformationSteps_PRSAMD_1038 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchViewDetailsInformationSteps_PRSAMD_1038.class);
	
	// *********************GIVEN BLOCK*******************************

	@Given("the User enters the Base URL to fetch view details information")
	public void the_user_enters_the_base_url_to_fetch_view_details_information() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************

	@When("user provides a valid {string} with {string} with the Request Parameter from {string} and {int} and trigger the GET API to fetch view details information")
	public void user_provides_a_valid_with_with_the_request_parameter_from_and_and_trigger_the_get_api_to_fetch_view_details_information(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/details");
		logger.info("API is triggered");
	}
	
	@When("User provides a valid {string} with {string} with Invalid or Blank Request Parameter from {string} and {int} and trigger the GET API to fetch view details information")
	public void user_provides_a_valid_with_with_invalid_or_blank_request_parameter_from_and_and_trigger_the_get_api_to_fetch_view_details_information(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/details");
		logger.info("API is triggered");
	}
	
	@When("User provides an invalid {string} with {string} with Valid Request Parameters from {string} and {int} and trigger the GET API to fetch view details information")
	public void user_provides_an_invalid_with_with_valid_request_parameters_from_and_and_trigger_the_get_api_to_fetch_view_details_information(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/details");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	
	@Then("a response code of {int} is generated fetching the view details information")
	public void a_response_code_of_is_generated_fetching_the_view_details_information(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("a response code of {int} is being generated showing error in fetching the view details information")
	public void a_response_code_of_is_being_generated_showing_error_in_fetching_the_view_details_information(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("a response code of {int} is getting generated showing Unauthorised error in fetching the view details information")
	public void a_response_code_of_is_getting_generated_showing_unauthorised_error_in_fetching_the_view_details_information(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("attribute named {string} is verified in response body to fetch view details information.")
	public void attribute_named_is_verified_in_response_body_to_fetch_view_details_information(String keyValue) {
		if (keyValue.equalsIgnoreCase("uploadSizeKB")) {
			String uploadSizeKB = getJsonPath(_RESPONSE, keyValue);
			String userRole = getJsonPath(_RESPONSE, "userRole");
			String batchId = getJsonPath(_RESPONSE, "batchId");
			String uploadId = getJsonPath(_RESPONSE, "uploadId");
			String uploaderFirstName = getJsonPath(_RESPONSE, "uploaderFirstName");
			String uploaderLastName = getJsonPath(_RESPONSE, "uploaderLastName");
			String uploadStartDateTime = getJsonPath(_RESPONSE, "uploadStartDateTime");
			String uploadEndDateTime = getJsonPath(_RESPONSE, "uploadEndDateTime");
			String fileDetailsResponse = getJsonPath(_RESPONSE, "fileDetailsResponse");
			
			expected_value = getJsonPath(_RESPONSE, "uploadSizeKB");
			
			logger.info("uploadSizeKB field values are : " + uploadSizeKB);
			logger.info("userRole field values are : : " + userRole);
			logger.info("batchId field values are : : " + batchId);
			logger.info("uploadId field values are : : " + uploadId);
			logger.info("uploaderFirstName field values are : : " + uploaderFirstName);
			logger.info("uploaderLastName field values are : : " + uploaderLastName);
			logger.info("uploadStartDateTime field values are : : " + uploadStartDateTime);
			logger.info("uploadEndDateTime field values are : : " + uploadEndDateTime);
			logger.info("fileDetailsResponse field values are : : " + fileDetailsResponse);
			
			assertEquals(expected_value, uploadSizeKB);
			logger.info("The view details information on History Dashboard values against the response body is verified");
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
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_1038.xlsx", SheetName);
		String uploadId = testData.get(RowNumber).get("uploadId");
		
		
		JSONObject payload = new JSONObject();
		payload.put("uploadId", uploadId);
		
		return payload;
	
	
	}
}