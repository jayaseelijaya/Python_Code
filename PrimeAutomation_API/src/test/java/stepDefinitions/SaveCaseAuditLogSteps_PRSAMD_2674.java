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


public class SaveCaseAuditLogSteps_PRSAMD_2674 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(SaveCaseAuditLogSteps_PRSAMD_2674.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("User provides a base URL for saving case audit log")
	public void user_provides_a_base_url_for_saving_case_audit_log() throws IOException{
		logger.info("Base_url_is_entered");
		String HIL_baseUrl = getGlobalValue("HIL_baseUrl");
		_RESP_SPEC = given().baseUri(HIL_baseUrl);
		logger.info("Base_url : " + HIL_baseUrl);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("a valid {string} and valid {string} is provided with valid test data extracted from {string} {int}  for saving case audit log via. POST API")
	public void a_valid_and_valid_is_provided_with_valid_test_data_extracted_from_for_saving_case_audit_log_via_post_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/logger/auditlog");
		logger.info("API is triggered");
	}

	@When("a valid {string} and valid {string} is provided with invalid test datas extracted from {string} {int}  for saving case audit log via. POST API")
	public void a_valid_and_valid_is_provided_with_invalid_test_datas_extracted_from_for_saving_case_audit_log_via_post_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/logger/auditlog");
		logger.info("API is triggered");
	}
	
	@When("an invalid {string} and invalid {string} is provided with valid test datas extracted from {string} {int}  for saving case audit log via. POST API")
	public void an_invalid_and_invalid_is_provided_with_valid_test_datas_extracted_from_for_saving_case_audit_log_via_post_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/logger/auditlog");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code for saving case audit log")
	public void response_is_generated_with_success_status_code_for_saving_case_audit_log() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with failure status code for saving case audit log")
	public void response_is_generated_with_failure_status_code_for_saving_case_audit_log() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code for saving case audit log")
	public void response_is_generated_with_unauthorized_status_code_for_saving_case_audit_log() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("an attribute of {string} is validated for saving case audit log")
	public void an_attribute_of_is_validated_for_saving_case_audit_log(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			logger.info("responseMessage is : " + expected_value);
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
						System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_2674.xlsx", SheetName);
				String userId = testData.get(RowNumber).get("userId");
				String userName = testData.get(RowNumber).get("userName");
				String userFirstName = testData.get(RowNumber).get("userFirstName");
				String userLastName = testData.get(RowNumber).get("userLastName");
				String action = testData.get(RowNumber).get("action");
				String eventOutCome = testData.get(RowNumber).get("eventOutCome");
				String eventType = testData.get(RowNumber).get("eventType");
				
				JSONObject payload = new JSONObject();
				payload.put("userId", userId);
				payload.put("userName", userName);
				payload.put("userFirstName", userFirstName);
				payload.put("userLastName", userLastName);
				payload.put("action", action);
				payload.put("eventOutCome", eventOutCome);
				payload.put("eventType", eventType);
				
				return payload;
			
			}
		
}