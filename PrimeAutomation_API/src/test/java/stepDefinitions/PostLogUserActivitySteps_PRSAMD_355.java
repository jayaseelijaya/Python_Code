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


public class PostLogUserActivitySteps_PRSAMD_355 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(PostLogUserActivitySteps_PRSAMD_355.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("User provides a base URL for log user Activities")
	public void user_provides_a_base_url_for_log_user_activities() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("a valid {string} and valid {string} is provided with valid test data extracted from {string} {int}  for log User activities and POST API is triggered")
	public void a_valid_and_valid_is_provided_with_valid_test_data_extracted_from_for_log_user_activities_and_post_api_is_triggered(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException{
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/imageupload/auditlog");
		logger.info("API is triggered");
	}

	@When("a Valid {string} and Valid {string} is provided with invalid test data extracted from {string} {int} for log User activities and POST API is triggered")
	public void a_valid_and_valid_is_provided_with_invalid_test_data_extracted_from_for_log_user_activities_and_post_api_is_triggered(String Authorization, String Token, String SheetName, Integer RowNumber)  
			throws InvalidFormatException, IOException{
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString( )).post("/imageupload/auditlog");
		logger.info("API is triggered");
	}
	
	@When("an invalid {string} and invalid {string} is provided with test data extracted from {string} {int} for log User activities and POST API is triggered")
	public void an_invalid_and_invalid_is_provided_with_test_data_extracted_from_for_log_user_activities_and_post_api_is_triggered(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString( )).post("/imageupload/auditlog");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("a response of {int} is generated for log User activities")
	public void a_response_of_is_generated_for_log_user_activities(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response of {int} is being generated for log User activities")
	public void a_response_of_is_being_generated_for_log_user_activities(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response of {int} gets generated for log User activities")
	public void a_response_of_gets_generated_for_log_user_activities(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("an attribute of {string} is validated for log user activities")
	public void an_attribute_of_is_validated_for_log_user_activities(String keyValue) {
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
					System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_355.xlsx", SheetName);
			String userFacilityId = testData.get(RowNumber).get("userFacilityId");
			String userFirstName = testData.get(RowNumber).get("userFirstName");
			String userLastName = testData.get(RowNumber).get("userLastName");
			String userName = testData.get(RowNumber).get("userName");
			String action = testData.get(RowNumber).get("action");
			String eventOutCome = testData.get(RowNumber).get("eventOutCome");
			
			JSONObject payload = new JSONObject();
			payload.put("userFacilityId", userFacilityId);
			payload.put("userFirstName", userFirstName);
			payload.put("userLastName", userLastName);
			payload.put("userName", userName);
			payload.put("action", action);
			payload.put("eventOutCome", eventOutCome);
			
			return payload;
		
		}
	

}