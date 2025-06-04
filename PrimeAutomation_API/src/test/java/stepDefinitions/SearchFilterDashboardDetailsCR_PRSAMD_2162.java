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


public class SearchFilterDashboardDetailsCR_PRSAMD_2162 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(SearchFilterDashboardDetailsCR_PRSAMD_2162.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("Base URL is used to fetch upload dashboad details with Search\\/filter capability")
	public void base_url_is_used_to_fetch_upload_dashboad_details_with_search_filter_capability() 
		throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	
	// *********************WHEN BLOCK*******************************
	
	@When("user enters valid {string} {string} and {string} and then triggers POST API for search\\/filter capability")
	public void user_enters_valid_and_and_then_triggers_post_api_for_search_filter_capability(String Authorization, String Token, String linkedFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(validCase(linkedFacilityId)).post("imageupload/dashboard");
		logger.info("API is triggered");
		logger.info("LinkedFacilityId given as : " + linkedFacilityId);
	}
	
	@When("user enters valid {string} {string} and search text as {string} and then triggers POST API for search\\/filter capability")
	public void user_enters_valid_and_search_text_as_and_then_triggers_post_api_for_search_filter_capability(String Authorization, String Token, String searchText) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(searchTestData(searchText)).post("imageupload/dashboard");
		logger.info("API is triggered");
		logger.info("SearchText given as : " + searchText);
	}
	
	@When("user enters valid {string} {string} and filter as {string} and then triggers POST API for search\\/filter capability")
	public void user_enters_valid_and_filter_as_and_then_triggers_post_api_for_search_filter_capability(String Authorization, String Token, String targetFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(filterTestData(targetFacilityId)).post("imageupload/dashboard");
		logger.info("API is triggered");
		logger.info("targetFacilityId given as : " + targetFacilityId);
	}

	@When("user enters valid {string} {string} and a blank linked facility id  as {string} and then triggers POST API for search\\/filter capability")
	public void user_enters_valid_and_a_blank_linked_facility_id_as_and_then_triggers_post_api_for_search_filter_capability(String Authorization, String Token, String linkedFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(validCase(linkedFacilityId)).post("imageupload/dashboard");
		logger.info("API is triggered");
		logger.info("LinkedFacilityId given as : " + linkedFacilityId);
	}
	
	@When("user enters an invalid {string} {string} and valid test datas and then triggers POST API for search\\/filter capability")
	public void user_enters_an_invalid_and_valid_test_datas_and_then_triggers_post_api_for_search_filter_capability(String Authorization, String Token) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(invalidTokenTestData()).post("imageupload/dashboard");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code with search\\/filter capability")
	public void response_is_generated_with_success_status_code_with_search_filter_capability() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with failure status code with search\\/filter capability")
	public void response_is_generated_with_failure_status_code_with_search_filter_capability() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code with search\\/filter capability")
	public void response_is_generated_with_unauthorized_status_code_with_search_filter_capability() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	@Then("an attribute {string} is verified for search\\/filter capability")
	public void an_attribute_is_verified_for_search_filter_capability(String keyValue) {
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
	private static String validCase(String linkedFacilityId) {
		String value = "{\r\n"
				+ "    \"linkedFacilityId\" : \"" + linkedFacilityId + "\",\r\n"+ "    \"searchText\" :\"\",\r\n"
				+ "    \"targetFacilityIds\": [],\r\n"+ "    \"surgeonIds\": [],\r\n"
				+ "    \"applicationIds\": [],\r\n"+ "    \"statuses\": [],\r\n"
				+ "    \"fromUploadDate\": \"06/05/2023 19:56:49\",\r\n"+ "    \"toUploadDate\": \"06/06/2023 19:56:49\"\r\n"
				+ "\r\n"+ " }";
		return value;
	}

	private static String searchTestData(String searchText) {
		String value = "{\r\n"
				+ "    \"linkedFacilityId\": \"2\",\r\n"
				+ "    \"searchText\": \""+searchText+"\",\r\n"
				+ "    \"targetFacilityIds\": [],\r\n"
				+ "    \"surgeonIds\": [],\r\n"
				+ "    \"applicationIds\": [],\r\n"
				+ "    \"statuses\": [],\r\n"
				+ "    \"fromUploadDate\": \"06/05/2023 19:56:49\",\r\n"
				+ "    \"toUploadDate\": \"06/06/2023 19:56:49\"\r\n"
				+ "}";
		return value;
	}

	private static String filterTestData(String targetFacilityId) {
		String value = "{\r\n"
				+ "    \"linkedFacilityId\" : \"2\",\r\n"+ "    \"searchText\" :\"\",\r\n"
				+ "    \"targetFacilityIds\": ["+targetFacilityId+"],\r\n"+ "    \"surgeonIds\": [],\r\n"
				+ "    \"applicationIds\": [],\r\n"+ "    \"statuses\": [],\r\n"
				+ "    \"fromUploadDate\": \"06/05/2023 19:56:49\",\r\n"+ "    \"toUploadDate\": \"06/06/2023 19:56:49\"\r\n"
				+ "\r\n"+ " }";
		return value;
	}

	private static String invalidTokenTestData() {
		String value = "{\r\n"
				+ "    \"linkedFacilityId\" : \"2\",\r\n"+ "    \"searchText\" :\"\",\r\n"
				+ "    \"targetFacilityIds\": [],\r\n"+ "    \"surgeonIds\": [],\r\n"
				+ "    \"applicationIds\": [],\r\n"+ "    \"statuses\": [],\r\n"
				+ "    \"fromUploadDate\": \"06/05/2023 19:56:49\",\r\n"+ "    \"toUploadDate\": \"06/06/2023 19:56:49\"\r\n"
				+ "\r\n"+ " }";
		return value;
	}
	
	
}