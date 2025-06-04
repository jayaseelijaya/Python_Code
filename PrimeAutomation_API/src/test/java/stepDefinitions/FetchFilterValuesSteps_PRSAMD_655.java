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


public class FetchFilterValuesSteps_PRSAMD_655 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchFilterValuesSteps_PRSAMD_655.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("The Base URL is entered to fetch dashboard filter values")
	public void the_base_url_is_entered_to_fetch_dashboard_filter_values() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("user provides a valid {string} with {string} with the Request Parameter from {string} and {int} and trigger the GET API to fetch dashboard filter values")
	public void user_provides_a_valid_with_with_the_request_parameter_from_and_and_trigger_the_get_api_to_fetch_dashboard_filter_values(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/filtervalues");
		logger.info("API is triggered");
	}
	
	@When("user provides an invalid {string} with {string} with the Request Parameter from {string} and {int} and trigger the GET API to fetch dashboard filter values")
	public void user_provides_an_invalid_with_with_the_request_parameter_from_and_and_trigger_the_get_api_to_fetch_dashboard_filter_values(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/filtervalues");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	
	@Then("a {int} response is generated to fetch dashboard filter values")
	public void a_response_is_generated_to_fetch_dashboard_filter_values(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("a {int} response gets generated to fetch dashboard filter values")
	public void a_response_gets_generated_to_fetch_dashboard_filter_values(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	
	@Then("an attribute {string} is verified to filter dashboard details")
	public void an_attribute_is_verified_to_filter_dashboard_details(String keyValue) {
		if (keyValue.equalsIgnoreCase("facilityFilterResponse")) {
			String facilityFilterResponse = getJsonPath(_RESPONSE, keyValue);
			String applicationFilterResponse = getJsonPath(_RESPONSE, "applicationFilterResponse");
			String surgeonFilterResponse = getJsonPath(_RESPONSE, "surgeonFilterResponse");
			String uploaderFilterResponse = getJsonPath(_RESPONSE, "uploaderFilterResponse");
			String patientFilterResponse = getJsonPath(_RESPONSE, "patientFilterResponse");
			String statusFilterResponse = getJsonPath(_RESPONSE, "statusFilterResponse");
			
			expected_value = getJsonPath(_RESPONSE, "facilityFilterResponse");
			
			logger.info("facilityFilterResponse field values are : " + facilityFilterResponse);
			logger.info("applicationFilterResponse field values are : : " + applicationFilterResponse);
			logger.info("surgeonFilterResponse field values are : : " + surgeonFilterResponse);
			logger.info("uploaderFilterResponse field values are : : " + uploaderFilterResponse);
			logger.info("patientFilterResponse field values are : : " + patientFilterResponse);
			logger.info("statusFilterResponse field values are : : " + statusFilterResponse);
			
			assertEquals(expected_value, facilityFilterResponse);
			logger.info("The Dashboard Filter values against the response body is verified");
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
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_655.xlsx", SheetName);
		String sourceFacilityId = testData.get(RowNumber).get("sourceFacilityId");
		
		
		JSONObject payload = new JSONObject();
		payload.put("sourceFacilityId", sourceFacilityId);
		
		return payload;
	
	
	}

}