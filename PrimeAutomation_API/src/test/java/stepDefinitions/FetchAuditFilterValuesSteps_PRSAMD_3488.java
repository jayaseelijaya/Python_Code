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


public class FetchAuditFilterValuesSteps_PRSAMD_3488 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchAuditFilterValuesSteps_PRSAMD_3488.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the base URL gets entered for Fetching the Audit Log Filter Values")
	public void the_base_url_gets_entered_for_fetching_the_audit_log_filter_values() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************

	@When("user gives a valid {string} and {string} and {string} {int} and triggers the GET API for Fetching the Audit Log Filter Values")
	public void user_gives_a_valid_and_and_and_triggers_the_get_api_for_fetching_the_audit_log_filter_values(String Authorization, String Token , String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/auditlogfiltervalues");
		logger.info("API is triggered");
	}
	
	@When("user gives an invalid {string} and {string} and valid {string} {int} and triggers the GET API for  Fetching the Audit Log Filter Values")
	public void user_gives_an_invalid_and_and_valid_and_triggers_the_get_api_for_fetching_the_audit_log_filter_values(String Authorization, String Token , String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/auditlogfiltervalues");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************

	@Then("Response is generated with success status code while Fetching the Audit Log Filter Values")
	public void response_is_generated_with_success_status_code_while_fetching_the_audit_log_filter_values() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code while Fetching the Audit Log Filter Values")
	public void response_is_generated_with_unauthorized_status_code_while_fetching_the_audit_log_filter_values() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	@Then("an attribute {string} is verified while Fetching the Audit Log Filter Values")
	public void an_attribute_is_verified_while_fetching_the_audit_log_filter_values(String keyValue) {
		if (keyValue.equalsIgnoreCase("filterValues")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "filterValues");
			logger.info("Filter Values are : " + expected_value);
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
	
//	*********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_3488.xlsx", SheetName);
		String userFacilityId = testData.get(RowNumber).get("userFacilityId");
		
		
		JSONObject payload = new JSONObject();
		payload.put("userFacilityId", userFacilityId);
		
		return payload;
	
	}
	
}
	