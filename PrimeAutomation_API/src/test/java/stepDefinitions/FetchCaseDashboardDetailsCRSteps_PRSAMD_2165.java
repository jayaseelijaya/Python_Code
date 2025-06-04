package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.File;
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


public class FetchCaseDashboardDetailsCRSteps_PRSAMD_2165 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchCaseDashboardDetailsCRSteps_PRSAMD_2165.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("Base URL is used to fetch case dashboad details with Search\\/filter capability")
	public void base_url_is_used_to_fetch_case_dashboad_details_with_search_filter_capability() 
		throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("HIL_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************

	@When("user enters valid {string} {string} and source facility id {string} and then triggers POST API for search\\/filter capability to fetch case dashboad details")
	public void user_enters_valid_and_source_facility_id_and_then_triggers_post_api_for_search_filter_capability_to_fetch_case_dashboad_details(String Authorization, String Token, String sourceFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(sourceFacilityIdFilter(sourceFacilityId)).post("hil/casedashboard");
		logger.info("API is triggered");
		logger.info("sourceFacilityId given as : " + sourceFacilityId);
	}


	
	@When("user enters valid {string} {string} and filter as imaging type {string} and then triggers POST API for search\\/filter capability to fetch case dashboad details")
	public void user_enters_valid_and_filter_as_imaging_type_and_then_triggers_post_api_for_search_filter_capability_to_fetch_case_dashboad_details(String Authorization, String Token, String imagingType) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(imagingTypeFilter(imagingType)).post("hil/casedashboard");
		logger.info("API is triggered");
		logger.info("imagingType given as : " + imagingType);
	}

	@When("user enters valid {string} {string} and search text as {string} and then triggers POST API for search\\/filter capability to fetch case dashboad details")
	public void user_enters_valid_and_search_text_as_and_then_triggers_post_api_for_search_filter_capability_to_fetch_case_dashboad_details(String Authorization, String Token, String searchText) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(searchTestData(searchText)).post("hil/casedashboard");
		logger.info("API is triggered");
		logger.info("searchText given as : " + searchText);
	}

	@When("user enters an invalid {string} {string} and valid test datas and then triggers POST API for search\\/filter capability to fetch case dashboad details")
	public void user_enters_an_invalid_and_valid_test_datas_and_then_triggers_post_api_for_search_filter_capability_to_fetch_case_dashboad_details(String Authorization, String Token) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(invalidTokenTestData()).post("hil/casedashboard");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code to fetch case dashboad details")
	public void response_is_generated_with_success_status_code_to_fetch_case_dashboad_details() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code to fetch case dashboad details")
	public void response_is_generated_with_unauthorized_status_code_to_fetch_case_dashboad_details() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("an attribute {string} is verified to fetch case dashboad details")
	public void an_attribute_is_verified_to_fetch_case_dashboad_details(String keyValue) {
		if (keyValue.equalsIgnoreCase("dashboardDetails")) {
			String dashboardDetails = getJsonPath(_RESPONSE, keyValue);
			
			expected_value = getJsonPath(_RESPONSE, "dashboardDetails");
			
		
			logger.info("Dashboard Details field values are : " + dashboardDetails);
			
			assertEquals(expected_value, dashboardDetails);
			logger.info("Dashboard Details values against the response body is verified");
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
	
	
	/* Test-data input as per the valid/invalid scenario's */
	private static String sourceFacilityIdFilter(String sourceFacilityId) {
		String value = "{\r\n"+ "    \"page\": 2,\r\n"+ "    \"limit\": 25,\r\n"+ "    \"column\": null,\r\n"
				+ "    \"searchText\": \"\",\r\n"+ "    \"anatomy\": [],\r\n"
				+ "    \"sourceFacilityId\": ["+sourceFacilityId+"],\r\n"+ "    \"caseStatus\": [],\r\n"
				+ "    \"claimantUserName\": [],\r\n"+ "    \"imagingType\": [],\r\n"
				+ "    \"fromDueDate\": null,\r\n"+ "    \"toDueDate\": null,\r\n"
				+ "    \"fromUpdatedDate\": null,\r\n"+ "    \"toUpdatedDate\": null\r\n"+ "}";
		return value;
	}
	
	private static String imagingTypeFilter(String imagingType) {
		String value = "{\r\n"+ "    \"page\": 2,\r\n"+ "    \"limit\": 25,\r\n"+ "    \"column\": null,\r\n"
				+ "    \"searchText\": \"\",\r\n"+ "    \"anatomy\": [],\r\n"
				+ "    \"sourceFacilityId\": [],\r\n"+ "    \"caseStatus\": [],\r\n"
				+ "    \"claimantUserName\": [],\r\n"+ "    \"imagingType\": [\""+imagingType+"\"],\r\n"
				+ "    \"fromDueDate\": null,\r\n"+ "    \"toDueDate\": null,\r\n"
				+ "    \"fromUpdatedDate\": null,\r\n"+ "    \"toUpdatedDate\": null\r\n"+ "}";
		return value;
	}


	private static String searchTestData(String searchText) {
		String value = "{\r\n"+ "    \"page\": 0,\r\n"+ "    \"limit\": 25,\r\n"+ "    \"column\": null,\r\n"
				+ "    \"searchText\": \""+searchText+"\",\r\n"+ "    \"anatomy\": [],\r\n"
				+ "    \"sourceFacilityId\": [],\r\n"+ "    \"caseStatus\": [],\r\n"
				+ "    \"claimantUserName\": [],\r\n"+ "    \"imagingType\": [],\r\n"
				+ "    \"fromDueDate\": null,\r\n"+ "    \"toDueDate\": null,\r\n"
				+ "    \"fromUpdatedDate\": null,\r\n"+ "    \"toUpdatedDate\": null\r\n"+ "}";
		return value;
	}


	private static String invalidTokenTestData() {
		String value = "{\r\n"+ "    \"page\": 2,\r\n"+ "    \"limit\": 25,\r\n"+ "    \"column\": null,\r\n"
				+ "    \"searchText\": \"\",\r\n"+ "    \"anatomy\": [],\r\n"
				+ "    \"sourceFacilityId\": [],\r\n"+ "    \"caseStatus\": [],\r\n"
				+ "    \"claimantUserName\": [],\r\n"+ "    \"imagingType\": [],\r\n"
				+ "    \"fromDueDate\": null,\r\n"+ "    \"toDueDate\": null,\r\n"
				+ "    \"fromUpdatedDate\": null,\r\n"+ "    \"toUpdatedDate\": null\r\n"+ "}";
		return value;
	}
}

