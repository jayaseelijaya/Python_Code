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


public class FetchCaseID_PRSAMD_2238 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchCaseID_PRSAMD_2238.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("user enters the valid URL for fetching case ID")
	public void user_enters_the_valid_url_for_fetching_case_id() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("MIC_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	
	// *********************WHEN BLOCK*******************************
	
	@When("User enters a valid {string} and {string} with test data from {string} and {int} for fetching case ID from MIC Hospital Microservice")
	public void user_enters_a_valid_and_with_test_data_from_and_for_fetching_case_id_from_mic_hospital_microservice(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hospitalservice/patientcasedetails");
		logger.info("API is triggered");
	}
	
	
	@When("User enters an invalid {string} and {string} with valid  test data from {string} and {int} for fetching case ID from MIC Hospital Microservice")
	public void user_enters_an_invalid_and_with_valid_test_data_from_and_for_fetching_case_id_from_mic_hospital_microservice(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hospitalservice/patientcasedetails");
		logger.info("API is triggered");
	}
	
	
	// *********************THEN BLOCK*******************************
	
	
	@Then("a {int} response status is generated for fetching case ID")
	public void a_response_status_is_generated_for_fetching_case_id(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	

	@Then("a {int} response status gets generated for fetching case ID")
	public void a_response_status_gets_generated_for_fetching_case_id(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	
	@Then("the response body attribute {string} is validated against the response body provided")
	public void the_response_body_attribute_is_validated_against_the_response_body_provided(String KeyValue) {
		if (KeyValue.equalsIgnoreCase("caseId")) {
			String caseId = getJsonPath(_RESPONSE, KeyValue);
			String uploadStatus = getJsonPath(_RESPONSE, "uploadStatus");
			String uploadId = getJsonPath(_RESPONSE, "uploadId");
			String imagingType = getJsonPath(_RESPONSE, "imagingType");
			String rescaleSlope = getJsonPath(_RESPONSE, "rescaleSlope");
			String rescaleIntercept = getJsonPath(_RESPONSE, "rescaleIntercept");
			
			expected_value = getJsonPath(_RESPONSE, "caseId");
			
			logger.info("caseId is : " + expected_value);
			logger.info("uploadStatus is : " + uploadStatus);
			logger.info("uploadId is : " + uploadId);
			logger.info("imagingType is : " + imagingType);
			logger.info("rescaleSlope is : " + rescaleSlope);
			logger.info("rescaleIntercept is : " + rescaleIntercept);
			
			assertEquals(expected_value, caseId);
			logger.info("The attribute values against the response body is verified");
		}
			
			else {
				String errors = getJsonPath(_RESPONSE, KeyValue);
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
						System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_2238.xlsx", SheetName);
				String caseId = testData.get(RowNumber).get("caseId");
				String uploadId = testData.get(RowNumber).get("uploadId");
				
				
				JSONObject payload = new JSONObject();
				payload.put("caseId", caseId);
				payload.put("uploadId", uploadId);
				
				
				return payload;
			
			}
}