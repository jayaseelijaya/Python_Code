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


public class UpdateSpecificViewConfigurationSteps_PRSAMD_436 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UpdateSpecificViewConfigurationSteps_PRSAMD_436.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("a user enters the valid URL for updating specific view Configuration")
	public void a_user_enters_the_valid_url_for_updating_specific_view_configuration() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("the user gives a valid {string} and {string} with valid Test Data from {string} and {int} and trigger PUT API to update view Configuration")
	public void the_user_gives_a_valid_and_with_valid_test_data_from_and_and_trigger_put_api_to_update_view_configuration(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).put("/imageupload/viewconfig");
		logger.info("API is triggered");
	    
	}
	
	@When("the user gives a valid {string} and {string} with invalid Test Data for userFacilityId from {string} and {int} and trigger PUT API to update view Configuration")
	public void the_user_gives_a_valid_and_with_invalid_test_data_for_user_facility_id_from_and_and_trigger_put_api_to_update_view_configuration(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).put("/imageupload/viewconfig");
		logger.info("API is triggered");
	}
	
	@When("the user gives a valid {string} and {string} with invalid Test Data for isFacilityWide from {string} and {int} and trigger PUT API to update view Configuration")
	public void the_user_gives_a_valid_and_with_invalid_test_data_for_is_facility_wide_from_and_and_trigger_put_api_to_update_view_configuration(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).put("/imageupload/viewconfig");
		logger.info("API is triggered");
	}

	@When("the user gives a valid {string} and {string} with invalid Test Data for successDays from {string} and {int} and trigger PUT API to update view Configuration")
	public void the_user_gives_a_valid_and_with_invalid_test_data_for_success_days_from_and_and_trigger_put_api_to_update_view_configuration(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).put("/imageupload/viewconfig");
		logger.info("API is triggered");
	}

	@When("the user gives a valid {string} and {string} with invalid Test Data for errorDays from {string} and {int} and trigger PUT API to update view Configuration")
	public void the_user_gives_a_valid_and_with_invalid_test_data_for_error_days_from_and_and_trigger_put_api_to_update_view_configuration(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).put("/imageupload/viewconfig");
		logger.info("API is triggered");
	}

	@When("the user gives an invalid {string} and {string} with valid Test Data from {string} and {int} and trigger PUT API to update view Configuration")
	public void the_user_gives_an_invalid_and_with_valid_test_data_from_and_and_trigger_put_api_to_update_view_configuration(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).put("/imageupload/viewconfig");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("a response of {int} is generated for updating Specific view configuration")
	public void a_response_of_is_generated_for_updating_specific_view_configuration(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("a response of {int} is being generated for updating Specific view configuration")
	public void a_response_of_is_being_generated_for_updating_specific_view_configuration(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("a response of {int} is getting generated for updating Specific view configuration")
	public void a_response_of_is_getting_generated_for_updating_specific_view_configuration(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("the attribute {string} is validated for updating specific view")
	public void the_attribute_is_validated_for_updating_specific_view(String keyValue) {
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
					System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_436.xlsx", SheetName);
			String userFacilityId = testData.get(RowNumber).get("userFacilityId");
			String isFacilityWide = testData.get(RowNumber).get("isFacilityWide");
			String successDays = testData.get(RowNumber).get("successDays");
			String errorDays = testData.get(RowNumber).get("errorDays");
			
			JSONObject payload = new JSONObject();
			payload.put("userFacilityId", userFacilityId);
			if(isFacilityWide =="")
				payload.put("isFacilityWide", isFacilityWide);
			else if(isFacilityWide !="")
				payload.put("isFacilityWide", Integer.parseInt(isFacilityWide));
			payload.put("successDays", successDays);
			payload.put("errorDays", errorDays);
			return payload;
		
		}

}