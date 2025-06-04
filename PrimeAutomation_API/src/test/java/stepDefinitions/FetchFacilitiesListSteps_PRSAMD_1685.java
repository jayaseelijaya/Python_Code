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


public class FetchFacilitiesListSteps_PRSAMD_1685 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchFacilitiesListSteps_PRSAMD_1685.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the user enters the Base URL for fetching Facilities")
	public void the_user_enters_the_base_url_for_fetching_facilities() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("a valid {string} and {string} is provided extracting Test data form {string} {int} for fetching facilities via. GET API")
	public void a_valid_and_is_provided_extracting_test_data_form_for_fetching_facilities_via_get_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/facilities");
		logger.info("API is triggered");
	}

	
	@When("an invalid {string} and {string} is provided extracting Test data form {string} {int} for fetching facilities via. GET API")
	public void an_invalid_and_is_provided_extracting_test_data_form_for_fetching_facilities_via_get_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/facilities");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	

	@Then("a {int} response is generated for Fetching Facilities")
	public void a_response_is_generated_for_fetching_facilities(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("a {int} response is being generated for Fetching Facilities")
	public void a_response_is_being_generated_for_fetching_facilities(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	@Then("the attribute validation of {string} is performed against the response body")
	public void the_attribute_validation_of_is_performed_against_the_response_body(String keyValue) {
		if (keyValue.equalsIgnoreCase("facilityId")) {
			String facilityId = getJsonPath(_RESPONSE, keyValue);
			String facilityName = getJsonPath(_RESPONSE, "facilityName");
			String address = getJsonPath(_RESPONSE, "address");
			String city = getJsonPath(_RESPONSE, "city");
			String state = getJsonPath(_RESPONSE, "state");
			
			expected_value = getJsonPath(_RESPONSE, "facilityId");
			
			logger.info("facilityId field values are : " + facilityId);
			logger.info("facilityName field values are : : " + facilityName);
			logger.info("address field values are : : " + address);
			logger.info("city field values are : : " + city);
			logger.info("state field values are : : " + state);
			assertEquals(expected_value, facilityId);
			logger.info("List of Facilities and optionally source Facilities values against the response body is verified");
		} 
	}

	
//	*********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_1685.xlsx", SheetName);
		String facilityType = testData.get(RowNumber).get("facilityType");
		
		
		JSONObject payload = new JSONObject();
		payload.put("facilityType", facilityType);
		
		return payload;
	
	}
	
}