package stepDefinitions;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.openqa.selenium.devtools.v85.css.CSS;

import utility.CommonUtils;
import utility.ExcelReader;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.SerializationFeature;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class FetchFilterValuesClaimantSteps_PRSAMD_1508 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchFilterValuesClaimantSteps_PRSAMD_1508.class);
	
	// *********************GIVEN BLOCK*******************************

	@Given("a user enters the valid URL for fetching filter values for claimant")
	public void a_user_enters_the_valid_url_for_fetching_filter_values_for_claimant() 
		throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("HIL_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************

	@When("the user gives a valid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API to fetch filter values for claimant")
	public void the_user_gives_a_valid_and_with_valid_test_data_from_and_and_trigger_get_api_to_fetch_filter_values_for_claimant(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/filtervaluesclaimant");
		logger.info("API is triggered");
	}
	
	@When("the user gives a valid {string} and {string} with invalid Test Data from {string} and {int} and trigger GET API to fetch filter values for claimant")
	public void the_user_gives_a_valid_and_with_invalid_test_data_from_and_and_trigger_get_api_to_fetch_filter_values_for_claimant(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/filtervaluesclaimant");
		logger.info("API is triggered");
	}
	
	@When("the user gives an invalid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API to fetch filter values for claimant")
	public void the_user_gives_an_invalid_and_with_valid_test_data_from_and_and_trigger_get_api_to_fetch_filter_values_for_claimant(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/filtervaluesclaimant");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************

	@Then("Response is generated with success status code for fetching filter values for claimant")
	public void response_is_generated_with_success_status_code_for_fetching_filter_values_for_claimant() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with failure status code for fetching filter values for claimant")
	public void response_is_generated_with_failure_status_code_for_fetching_filter_values_for_claimant() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code for fetching filter values for claimant")
	public void response_is_generated_with_unauthorized_status_code_for_fetching_filter_values_for_claimant() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}


	@Then("the attribute {string} is validated for fetching filter values for claimant")
	public void the_attribute_is_validated_for_fetching_filter_values_for_claimant(String keyValue) {
		if (keyValue.equalsIgnoreCase("claimantUserName")) {
			String claimantUserName = getJsonPath(_RESPONSE, keyValue);
			String claimantFirstName = getJsonPath(_RESPONSE, "claimantFirstName");
			String claimantLastName = getJsonPath(_RESPONSE, "claimantLastName");
			
			expected_value = getJsonPath(_RESPONSE, "claimantUserName");
			
			logger.info("claimantUserName is : " + expected_value);
			logger.info("claimantFirstName is : " + claimantFirstName);
			logger.info("claimantLastName is : " + claimantLastName);
			
			assertEquals(expected_value, claimantUserName);
			logger.info("The attribute values against the response body is verified");
		}
			
			else if (keyValue.equalsIgnoreCase("errors"))
			{
				String errors = getJsonPath(_RESPONSE, keyValue);
				expected_value = getJsonPath(_RESPONSE, "errors");
				logger.info("Error message : " + expected_value);
				assertEquals(expected_value, errors);
				logger.info("Errors is validated against response");
			}
		
			else if (keyValue.equalsIgnoreCase("errorDetails"))
			{
				String errorDetails = getJsonPath(_RESPONSE, keyValue);
				expected_value = getJsonPath(_RESPONSE, "errorDetails");
				logger.info("Error message : " + expected_value);
				assertEquals(expected_value, errorDetails);
				logger.info("Errors is validated against response");
			}
	}
	

	// function to get the test-data from excel sheet
			private HashMap<String, String> payload(String sheetName, Integer RowNumber)
					throws InvalidFormatException, IOException {
				ExcelReader reader = new ExcelReader();
				List<Map<String, String>> testData = reader.getData(
							System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_1508.xlsx",
							sheetName);
					String statuscodes = testData.get(RowNumber).get("statuscodes");
					String casecategory = testData.get(RowNumber).get("casecategory");
	
					JSONObject payload = new JSONObject();
					payload.put("statuscodes", statuscodes);
					payload.put("casecategory", casecategory);
				
					return payload;
				}
}