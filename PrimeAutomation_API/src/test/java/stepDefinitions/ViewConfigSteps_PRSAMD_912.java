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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ViewConfigSteps_PRSAMD_912 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(ViewConfigSteps_PRSAMD_912.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("user enters the base URL to verify user\\/facility specific view configuration")
	public void user_enters_the_base_url_to_verify_user_facility_specific_view_configuration()throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	    
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("user gives valid {string} {string} {string} and trigger the Get api to user\\/facility specific view configuration")
	public void user_gives_valid_and_trigger_the_get_api_to_user_facility_specific_view_configuration(String Authorization, String Token, String userFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams("userFacilityId",userFacilityId).get("/imageupload/viewconfig");
		logger.info("API is triggered");
		
	}
	
	@When("user gives valid {string} {string} and invalid {string} and trigger the Get api to user\\/facility specific view configuration")
	public void user_gives_valid_and_invalid_and_trigger_the_get_api_to_user_facility_specific_view_configuration(String Authorization, String Token, String userFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams("userFacilityId",userFacilityId).get("/imageupload/viewconfig");
		logger.info("API is triggered");
	}
	
	@When("user gives invalid {string} {string} and valid {string} and trigger the Get api to user\\/facility specific view configuration")
	public void user_gives_invalid_and_valid_and_trigger_the_get_api_to_user_facility_specific_view_configuration(String Authorization, String Token, String userFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams("userFacilityId",userFacilityId).get("/imageupload/viewconfig");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("response is generated and status code as {int} to verify user\\/facility specific view configuration")
	public void response_is_generated_and_status_code_as_to_verify_user_facility_specific_view_configuration(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("response generated and status code as {int} to verify user\\/facility specific view configuration")
	public void response_generated_and_status_code_as_to_verify_user_facility_specific_view_configuration(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("response will be generated as {int} status code to verify user\\/facility specific view configuration")
	public void response_will_be_generated_as_status_code_to_verify_user_facility_specific_view_configuration(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("{string} value in response body gets validated to user\\/facility specific view configuration")
	public void value_in_response_body_gets_validated_to_user_facility_specific_view_configuration(String keyValue) {
		if (keyValue.equalsIgnoreCase("facilityId")) {
			String facilityId = getJsonPath(_RESPONSE, keyValue);
			String isFacilityWide = getJsonPath(_RESPONSE, "isFacilityWide");
			String successDays = getJsonPath(_RESPONSE, "successDays");
			String errorDays = getJsonPath(_RESPONSE, "errorDays");
			expected_value = getJsonPath(_RESPONSE, "facilityId");
			logger.info("facilityId field values are : " + facilityId);
			logger.info("isFacilityWide field values are : : " + isFacilityWide);
			logger.info("successDays field values are : : " + successDays);
			logger.info("errorDays field values are : : " + errorDays);
			assertEquals(expected_value, facilityId);
			logger.info("View Configuration values against the response body is verified");
		} else {
			// Verifying the error message against response body
			String error_message = getJsonPath(_RESPONSE, "errors");
			expected_value = getJsonPath(_RESPONSE, "errors");
			assertEquals(expected_value, error_message);
			logger.info("Error message : " + error_message);
			logger.info("Error message is validated against response body ");
		}
		
	}
	
}
	