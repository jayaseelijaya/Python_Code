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


public class FetchLoggedUserDetailsSteps_PRSAMD_1845 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchLoggedUserDetailsSteps_PRSAMD_1845.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("user enters the Base URL to fetch logged in user details")
	public void user_enters_the_base_url_to_fetch_logged_in_user_details() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("user gives a valid {string} and {string} along with a valid userName from {string} {int} and trigger the GET API to fetch logged in user details")
	public void user_gives_a_valid_and_along_with_a_valid_user_name_from_and_trigger_the_get_api_to_fetch_logged_in_user_details(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/loggedinuserdetails");
		logger.info("API is triggered");
	}
	
	@When("user gives a valid {string} and {string} along with an invalid userName from {string} {int} and trigger the GET API to fetch logged in user details")
	public void user_gives_a_valid_and_along_with_an_invalid_user_name_from_and_trigger_the_get_api_to_fetch_logged_in_user_details(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/loggedinuserdetails");
		logger.info("API is triggered");
	}

	@When("user gives an invalid {string} and {string} along with userName from {string} {int}  and trigger the GET API to fetch logged in user details")
	public void user_gives_an_invalid_and_along_with_user_name_from_and_trigger_the_get_api_to_fetch_logged_in_user_details(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/loggedinuserdetails");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("a {int} response is generated showing the logged in user details")
	public void a_response_is_generated_showing_the_logged_in_user_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("a {int} response gets generated showing the logged in user details")
	public void a_response_gets_generated_showing_the_logged_in_user_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	@Then("the response message of {string} is verified for logged in user details")
	public void the_response_message_of_is_verified_for_logged_in_user_details(String keyValue) {
		if (keyValue.equalsIgnoreCase("userName")) {
			String userName = getJsonPath(_RESPONSE, keyValue);
			String userFacilityState = getJsonPath(_RESPONSE, "userFacilityState");
			String userFacilityZipCode = getJsonPath(_RESPONSE, "userFacilityZipCode");
			String userFacilityAddress = getJsonPath(_RESPONSE, "userFacilityAddress");
			String userFacilityCity = getJsonPath(_RESPONSE, "userFacilityCity");
			
			expected_value = getJsonPath(_RESPONSE, "userName");
			
			logger.info("userName field values are : " + userName);
			logger.info("userFacilityState field values are : : " + userFacilityState);
			logger.info("userFacilityZipCode field values are : : " + userFacilityZipCode);
			logger.info("userFacilityAddress field values are : : " + userFacilityAddress);
			logger.info("userFacilityCity field values are : : " + userFacilityCity);
			assertEquals(expected_value, userName);
			logger.info("Logged-in User Details values against the response body is verified");
		} 
		else 
		{
			// Verifying the error message against response body
			String error_message = getJsonPath(_RESPONSE, "errors");
			expected_value = getJsonPath(_RESPONSE, "errors");
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
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_1845.xlsx", SheetName);
		String userName = testData.get(RowNumber).get("userName");
		
		
		JSONObject payload = new JSONObject();
		payload.put("userName", userName);
		
		return payload;
	
	}
}
	