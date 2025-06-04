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


public class SearchFilterHistoryDashboardDetails_PRSAMD_2163 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(SearchFilterHistoryDashboardDetails_PRSAMD_2163.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("Base URL  is entered for fetching image upload history details list with search and filter functionality")
	public void base_url_is_entered_for_fetching_image_upload_history_details_list_with_search_and_filter_functionality() 
		throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("user enters the valid {string} {string} and {string} and then triggering POST API for fetching image upload history details list with search and filter functionality")
	public void user_enters_the_valid_and_and_then_triggering_post_api_for_fetching_image_upload_history_details_list_with_search_and_filter_functionality(String Authorization, String Token, String linkedFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(validCase(linkedFacilityId)).post("imageupload/history");
		logger.info("API is triggered");
		logger.info("LinkedFacilityId given as : " + linkedFacilityId);
	}
	
	@When("user enters the valid {string} {string} along with search parameter {string} and then triggering POST API for fetching image upload history details list with search and filter functionality")
	public void user_enters_the_valid_along_with_search_parameter_and_then_triggering_post_api_for_fetching_image_upload_history_details_list_with_search_and_filter_functionality(String Authorization, String Token, String searchText) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(searchTestData(searchText)).post("imageupload/history");
		logger.info("API is triggered");
		logger.info("SearchText given as : " + searchText);
	}

	@When("user enters valid {string} {string} and filter as {string} and then triggers POST API for fetching image upload history details list with search and filter functionality")
	public void user_enters_valid_and_filter_as_and_then_triggers_post_api_for_fetching_image_upload_history_details_list_with_search_and_filter_functionality(String Authorization, String Token, String targetFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(filterTestData(targetFacilityId)).post("imageupload/history");
		logger.info("API is triggered");
		logger.info("targetFacilityId given as : " + targetFacilityId);
	}

	@When("user enters the valid {string} {string} along with blank {string} and then triggering POST API fetching image upload history details list with search and filter functionality")
	public void user_enters_the_valid_along_with_blank_and_then_triggering_post_api_fetching_image_upload_history_details_list_with_search_and_filter_functionality(String Authorization, String Token, String linkedFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(validCase(linkedFacilityId)).post("imageupload/history");
		logger.info("API is triggered");
		logger.info("LinkedFacilityId given as : " + linkedFacilityId);
	}
	
	@When("user enters an invalid {string} {string} along with valid request body and then triggering POST API for fetching image upload history details list with search and filter functionality")
	public void user_enters_an_invalid_along_with_valid_request_body_and_then_triggering_post_api_for_fetching_image_upload_history_details_list_with_search_and_filter_functionality(String Authorization, String Token) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(invalidTokenTestData()).post("imageupload/history");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code for fetching image upload history details list with search and filter functionality")
	public void response_is_generated_with_success_status_code_for_fetching_image_upload_history_details_list_with_search_and_filter_functionality() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with failure status code for fetching image upload history details list with search and filter functionality")
	public void response_is_generated_with_failure_status_code_for_fetching_image_upload_history_details_list_with_search_and_filter_functionality() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorised status code for fetching image upload history details list with search and filter functionality")
	public void response_is_generated_with_unauthorised_status_code_for_fetching_image_upload_history_details_list_with_search_and_filter_functionality() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	@Then("an attribute validation {string} in Response body is being verified fetching image upload history details list with search and filter functionality")
	public void an_attribute_validation_in_response_body_is_being_verified_fetching_image_upload_history_details_list_with_search_and_filter_functionality(String keyValue) {
		if (keyValue.equalsIgnoreCase("historyDetails")) {
			String historyDetails = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "historyDetails");
			logger.info("History Dashboard Details field values are : " + historyDetails);
			
			assertEquals(expected_value, historyDetails);
			logger.info("History Dashboard Details values against the response body is verified");
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
				+ "    \"linkedFacilityId\": \""+linkedFacilityId+"\",\r\n"+ "    \"searchText\": \"\",\r\n"
				+ "    \"targetFacilityId\": [],\r\n"+ "    \"surgeonId\": [],\r\n"+ "    \"uploadStatus\": [],\r\n"
				+ "    \"uploadId\":[],\r\n"+ "    \"uploaderId\":[],\r\n"+ "    \"fromCreatedDate\": \"05/07/2023 21:15:47\",\r\n"
				+ "    \"toCreatedDate\": \"06/07/2023 21:15:47\",\r\n"+ "    \"page\":0,\r\n"
				+ "    \"limit\":10,\r\n"+ "    \"column\":null\r\n"+ "}";
		return value;
	}

	private static String searchTestData(String searchText) {
		String value = "{\r\n"+ "    \"linkedFacilityId\": \"1\",\r\n"
				+ "    \"searchText\": \""+searchText+"\",\r\n"+ "    \"targetFacilityId\": [],\r\n"
				+ "    \"surgeonId\": [],\r\n"+ "    \"uploadStatus\": [],\r\n"
				+ "    \"uploadId\":[],\r\n"+ "    \"uploaderId\":[],\r\n"
				+ "    \"fromCreatedDate\": \"05/07/2023 21:15:47\",\r\n"+ "    \"toCreatedDate\": \"06/07/2023 21:15:47\",\r\n"
				+ "    \"page\":0,\r\n"+ "    \"limit\":10,\r\n"+ "    \"column\":null\r\n"+ "}";
		return value;
	}

	private static String filterTestData(String targetFacilityId) {
		String value = "{\r\n"+ "    \"linkedFacilityId\": \"1\",\r\n"+ "    \"searchText\": \"\",\r\n"
				+ "    \"targetFacilityId\": ["+targetFacilityId+"],\r\n"+ "    \"surgeonId\": [],\r\n"
				+ "    \"uploadStatus\": [],\r\n"+ "    \"uploadId\":[],\r\n"
				+ "    \"uploaderId\":[],\r\n"+ "    \"fromCreatedDate\": \"05/07/2023 21:15:47\",\r\n"
				+ "    \"toCreatedDate\": \"06/07/2023 21:15:47\",\r\n"+ "    \"page\":0,\r\n"
				+ "    \"limit\":10,\r\n"+ "    \"column\":null\r\n"+ "}";
		return value;
	}

	private static String invalidTokenTestData() {
		String value = "{\r\n"+ "    \"linkedFacilityId\": \"1\",\r\n"+ "    \"searchText\": \"\",\r\n"
				+ "    \"targetFacilityId\": [],\r\n"+ "    \"surgeonId\": [],\r\n"
				+ "    \"uploadStatus\": [],\r\n"+ "    \"uploadId\":[],\r\n"+ "    \"uploaderId\":[],\r\n"
				+ "    \"fromCreatedDate\": \"05/07/2023 21:15:47\",\r\n"+ "    \"toCreatedDate\": \"06/07/2023 21:15:47\",\r\n"
				+ "    \"page\":0,\r\n"+ "    \"limit\":10,\r\n"+ "    \"column\":null\r\n"+ "}";
		return value;
	}
	

}