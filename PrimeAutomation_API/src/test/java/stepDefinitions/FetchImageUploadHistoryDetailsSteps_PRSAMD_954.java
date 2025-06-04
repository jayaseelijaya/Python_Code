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


public class FetchImageUploadHistoryDetailsSteps_PRSAMD_954 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchImageUploadHistoryDetailsSteps_PRSAMD_954.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the Base URL is entered for fetching the Image Upload History Details")
	public void the_base_url_is_entered_for_fetching_the_image_upload_history_details() throws IOException {
		logger.info("Base URL is Entered");
		String baseURL=getGlobalValue("baseUrl");
		_RESP_SPEC =given().baseUri(baseURL);
		logger.info("Base_URL:" + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************

	@When("the user enters the valid {string} and {string} along with {string} and triggers the POST API")
	public void the_user_enters_the_valid_and_along_with_and_triggers_the_post_api(String Authorization, String Token, String linkedFacilityId) {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(validInvalidCase(linkedFacilityId)).post("imageupload/history");
		logger.info("API is triggered");
		logger.info("LinkedFacilityId given as : " + linkedFacilityId);
	}
	
	@When("the user enters the valid {string} and {string} with search parameter as {string} and triggers the POST API")
	public void the_user_enters_the_valid_and_with_search_parameter_as_and_triggers_the_post_api(String Authorization, String Token, String searchText) {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(searchTestData(searchText)).post("imageupload/history");
		logger.info("API is triggered");
		logger.info("SearchText given as : " + searchText);
	}

	@When("the user enters the valid {string} and {string} with filter parameter as {string} and triggers the POST API")
	public void the_user_enters_the_valid_and_with_filter_parameter_as_and_triggers_the_post_api(String Authorization, String Token, String targetFacilityId) {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(filterTestData(targetFacilityId)).post("imageupload/history");
		logger.info("API is triggered");
		logger.info("targetFacilityId given as : " + targetFacilityId);
	}

	@When("the user enters the valid {string} and {string} with blank  {string} and triggers the POST API")
	public void the_user_enters_the_valid_and_with_blank_and_triggers_the_post_api(String Authorization, String Token, String linkedFacilityId) {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(validInvalidCase(linkedFacilityId)).post("imageupload/history");
		logger.info("API is triggered");
		logger.info("LinkedFacilityId given as : " + linkedFacilityId);
	}
	
	@When("the user enters the invalid {string} and {string} and triggers the POST API")
	public void the_user_enters_the_invalid_and_and_triggers_the_post_api(String Authorization, String Token) {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(InvalidTokenTestData()).post("imageupload/history");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************

	@Then("a response with status code {int} is being generated with filtered\\/searched upload history  details")
	public void a_response_with_status_code_is_being_generated_with_filtered_searched_upload_history_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response with status code {int} is being generated with image upload history error details")
	public void a_response_with_status_code_is_being_generated_with_image_upload_history_error_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response with status code {int}  being generated with image upload history error details")
	public void a_response_with_status_code_being_generated_with_image_upload_history_error_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	
	@Then("{string} attribute  is verified in the response")
	public void attribute_is_verified_in_the_response(String keyValue) {
		if (keyValue.equalsIgnoreCase("historyDetails")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "historyDetails");
			logger.info("historyDetails is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("historyDetails is validated against response");
			
		} else {
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
	}
	
	//****************** Test-data input as per the valid/invalid scenario's ****************************
	
	private static String validInvalidCase(String linkedFacilityId) {
		
		String value= "{\r\n"
				+ "    \"linkedFacilityId\": \""+linkedFacilityId+"\",\r\n"
				+ "    \"searchText\": \"\",\r\n"
				+ "    \"targetFacilityId\": [],\r\n"+ "    \"surgeonId\": [],\r\n"+ "    \"uploadStatus\": [],\r\n"
				+ "    \"uploadId\": [],\r\n"+ "    \"uploaderId\": [],\r\n"+ "    \"fromCreatedDate\": null,\r\n"
				+ "    \"toCreatedDate\": null,\r\n"+ "    \"page\": 0,\r\n"
				+ "    \"limit\": 10,\r\n"+ "    \"column\": null\r\n"+ "}" ;
		
		return value;
		
	}

	
	private static String searchTestData(String searchText) {
		String value = "{\r\n"
				+ "    \"linkedFacilityId\": \"1\",\r\n"
				+ "    \"searchText\": \""+searchText+"\",\r\n"
				+ "    \"targetFacilityId\": [],\r\n"
				+ "    \"surgeonId\": [],\r\n"+ "    \"uploadStatus\": [],\r\n"
				+ "    \"uploadId\": [],\r\n"+ "    \"uploaderId\": [],\r\n"
				+ "    \"fromCreatedDate\": null,\r\n"+ "    \"toCreatedDate\": null,\r\n"+ "    \"page\": 0,\r\n"
				+ "    \"limit\": 10,\r\n"+ "    \"column\": null\r\n"+ "}";
		return value;
	}
	

	private static String filterTestData(String targetFacilityId) {
		String value = "{\r\n"
				+ "    \"linkedFacilityId\": \"1\",\r\n"
				+ "    \"searchText\":\"\",\r\n"
				+ "    \"targetFacilityId\": ["+targetFacilityId+"],\r\n"
				+ "    \"surgeonId\": [],\r\n"+ "    \"uploadStatus\": [],\r\n"
				+ "    \"uploadId\": [],\r\n"+ "    \"uploaderId\": [],\r\n"+ "    \"fromCreatedDate\": null,\r\n"
				+ "    \"toCreatedDate\": null,\r\n"+ "    \"page\": 0,\r\n"+ "    \"limit\": 10,\r\n"
				+ "    \"column\": null\r\n"+ "}";
		return value;
	}

	private static String InvalidTokenTestData() {
		String value = "{\r\n"
				+ "    \"linkedFacilityId\": \"1\",\r\n"+ "    \"searchText\":\"\",\r\n"+ "    \"targetFacilityId\": [],\r\n"
				+ "    \"surgeonId\": [],\r\n"+ "    \"uploadStatus\": [],\r\n"+ "    \"uploadId\": [],\r\n"
				+ "    \"uploaderId\": [],\r\n"+ "    \"fromCreatedDate\": null,\r\n"+ "    \"toCreatedDate\": null,\r\n"
				+ "    \"page\": 0,\r\n"+ "    \"limit\": 10,\r\n"+ "    \"column\": null\r\n"+ "}";
		return value;
	}
	
}