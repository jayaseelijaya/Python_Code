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

public class FetchClaimantDetailsSteps_PRSAMD_2137 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchClaimantDetailsSteps_PRSAMD_2137.class);

	// *********************GIVEN BLOCK*******************************

	@Given("a user enters the valid URL for fetching claimant details for a caseId")
	public void a_user_enters_the_valid_url_for_fetching_claimant_details_for_a_case_id() 
		throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("HIL_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************

	@When("the user gives a valid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API to fetch claimant details for a caseId")
	public void the_user_gives_a_valid_and_with_valid_test_data_from_and_and_trigger_get_api_to_fetch_claimant_details_for_a_case_id(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/claimantdetails");
		logger.info("API is triggered");
	}

	@When("the user gives a valid {string} and {string} with invalid Test Data from {string} and {int} and trigger GET API to fetch claimant details for a caseId")
	public void the_user_gives_a_valid_and_with_invalid_test_data_from_and_and_trigger_get_api_to_fetch_claimant_details_for_a_case_id(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/claimantdetails");
		logger.info("API is triggered");
	}
	
	@When("the user gives an invalid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API to fetch claimant details for a caseId")
	public void the_user_gives_an_invalid_and_with_valid_test_data_from_and_and_trigger_get_api_to_fetch_claimant_details_for_a_case_id(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/claimantdetails");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************

	@Then("Response is generated with success status code for fetching claimant details for a caseId")
	public void response_is_generated_with_success_status_code_for_fetching_claimant_details_for_a_case_id() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with no data found status code for fetching claimant details for a caseId")
	public void response_is_generated_with_no_data_found_status_code_for_fetching_claimant_details_for_a_case_id() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code for fetching claimant details for a caseId")
	public void response_is_generated_with_unauthorized_status_code_for_fetching_claimant_details_for_a_case_id() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("the attribute {string} is validated for fetching claimant details for a caseId")
	public void the_attribute_is_validated_for_fetching_claimant_details_for_a_case_id(String keyValue) {
	    
		if (keyValue.equalsIgnoreCase("caseId")) {
			String caseId = getJsonPath(_RESPONSE, keyValue);
			String claimantUserName = getJsonPath(_RESPONSE, "claimantUserName");
			String claimantFirstName = getJsonPath(_RESPONSE, "claimantFirstName");
			String claimantLastName = getJsonPath(_RESPONSE, "claimantLastName");
			
			
			expected_value = getJsonPath(_RESPONSE, "caseId");
			
			logger.info("caseId field values are : " + caseId);
			logger.info("claimantUserName field values are : : " + claimantUserName);
			logger.info("claimantFirstName field values are : : " + claimantFirstName);
			logger.info("claimantLastName field values are : : " + claimantLastName);
			
			assertEquals(expected_value, caseId);
			logger.info("Claimant Details values against the response body is verified");
		} 
		else if(keyValue.equalsIgnoreCase("errors"))
		{
			// Verifying the error message against response body
			String error_message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			assertEquals(expected_value, error_message);
			logger.info("Error message : " + error_message);
			logger.info("Error message is validated against response body ");
		}
		
		else if(keyValue.equalsIgnoreCase("errorDetails"))
		{
			// Verifying the error message against response body
			String error_message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errorDetails");
			assertEquals(expected_value, error_message);
			logger.info("Error message : " + error_message);
			logger.info("Error message is validated against response body ");
		}
		
		
	}


//	*********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_2137.xlsx", SheetName);
		String caseId = testData.get(RowNumber).get("caseId");
		
		
		JSONObject payload = new JSONObject();
		payload.put("caseId", caseId);
		
		return payload;
	
	}
}