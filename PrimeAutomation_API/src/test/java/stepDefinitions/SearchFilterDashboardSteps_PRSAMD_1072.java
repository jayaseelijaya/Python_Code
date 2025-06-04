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
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.CommonUtils;

public class SearchFilterDashboardSteps_PRSAMD_1072 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(SearchFilterDashboardSteps_PRSAMD_1072.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url is entered to fetch upload dashboad details with Search and filter capability")
	public void base_url_is_entered_to_fetch_upload_dashboad_details_with_search_and_filter_capability()
			throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK*******************************
	@When("user enters valid {string} {string} {string} and then triggers POST api")
	public void user_enters_valid_and_then_triggers_post_api(String Authorization, String token,
			String linkedFacilityId) {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(validCase(linkedFacilityId)).post("imageupload/dashboard");
		logger.info("API is triggered");
		logger.info("LinkedFacilityId given as : " + linkedFacilityId);
	}

	@When("user enters valid {string} {string} and search field as {string} and then triggers POST api")
	public void user_enters_valid_and_search_field_as_and_then_triggers_post_api(String Authorization, String token,
			String searchText) {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(searchTestData(searchText)).post("imageupload/dashboard");
		logger.info("API is triggered");
		logger.info("SearchText given as : " + searchText);
	}

	@When("user enters valid {string} {string} and filter field as {string} and then triggers POST api")
	public void user_enters_valid_and_filter_field_as_and_then_triggers_post_api(String Authorization, String token,
			String targetFacilityId) {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(filterTestData(targetFacilityId)).post("imageupload/dashboard");
		logger.info("API is triggered");
		logger.info("targetFacilityId given as : " + targetFacilityId);
	}

	@When("user enters invalid {string} {string} & took valid testdata and then triggers POST api")
	public void user_enters_invalid_took_valid_testdata_and_then_triggers_post_api(String Authorization, String token) {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(invalidTokenTestData()).post("imageupload/dashboard");
		logger.info("API is triggered");
	}

	@When("user enters valid {string} {string} & blank linkedFacilityId and then triggers POST api")
	public void user_enters_valid_blank_and_then_triggers_post_api(String Authorization, String token) {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(blankLinkedFacilityId()).post("imageupload/dashboard");
		logger.info("API is triggered");
	}

	@When("user enters valid {string} {string} & {string} and then triggers POST api")
	public void user_enters_valid_and_triggers_post_api(String Authorization, String token, String linkedFacilityId) {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(nulldashboarddetails(linkedFacilityId)).post("imageupload/dashboard");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	@Then("response body is generated with filtered\\/searched dashboard details and status code as {int}")
	public void response_body_is_generated_with_filtered_searched_dashboard_details_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("response body is generated with filtered\\/searched dashboard details with status code as {int}")
	public void response_body_is_generated_with_filtered_searched_dashboard_details_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("response body is generated with no filtered\\/searched dashboard details and status code as {int}")
	public void response_body_is_generated_with_no_filtered_searched_dashboard_details_and_status_code_as(
			Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("attribute validation of {string} in Response body is verified")
	public void attribute_validation_of_in_response_body_is_verified(String keyValue) {
		if (keyValue.equalsIgnoreCase("dashboardDetails")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "dashboardDetails");
			assertEquals(expected_value, message);
			logger.info("Dashboard details are : " + expected_value);
			logger.info("dashboardDetails is validated against response");
		} else {
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
	}

	/* Test-data input as per the valid/invalid scenario's */
	private static String validCase(String linkedFacilityId) {
		String value = "{\r\n" + "    \"linkedFacilityId\" : \"" + linkedFacilityId + "\",\r\n"
				+ "    \"searchText\" :\"\",\r\n" + "    \"targetFacilityIds\": [],\r\n" + "    \"surgeonIds\": [],\r\n"
				+ "    \"applicationIds\": [],\r\n" + "    \"statuses\": []\r\n" + "   \r\n" + "    \r\n" + "    \r\n"
				+ "}";
		return value;
	}

	private static String searchTestData(String searchText) {
		String value = "{\r\n" + "    \"linkedFacilityId\" :\"1\",\r\n" + "    \"searchText\" :\"" + searchText
				+ "\",\r\n" + "    \"targetFacilityIds\": [],\r\n" + "    \"surgeonIds\": [],\r\n"
				+ "    \"applicationIds\": [],\r\n" + "    \"statuses\": []\r\n" + "   \r\n" + "    \r\n" + "    \r\n"
				+ "}";
		return value;
	}

	private static String filterTestData(String targetFacilityId) {
		String value = "{\r\n" + "    \"linkedFacilityId\" :\"1\",\r\n" + "    \"searchText\" :\"\",\r\n"
				+ "    \"targetFacilityIds\": [" + targetFacilityId + "],\r\n" + "    \"surgeonIds\": [],\r\n"
				+ "    \"applicationIds\": [],\r\n" + "    \"statuses\": []\r\n" + "   \r\n" + "    \r\n" + "    \r\n"
				+ "}";
		return value;
	}

	private static String invalidTokenTestData() {
		String value = "{\r\n" + "    \"linkedFacilityId\" : \"2\",\r\n" + "    \"searchText\" :\"\",\r\n"
				+ "    \"targetFacilityIds\": [],\r\n" + "    \"surgeonIds\": [\"\"],\r\n"
				+ "    \"applicationIds\": [],   \r\n" + "    \"statuses\": [],\r\n"
				+ "    \"fromUploadDate\": \"\",\r\n" + "    \"toUploadDate\": \"29/04/2022\",\r\n"
				+ "    \"page\" : 0,\r\n" + "    \"limit\" : 10,\r\n" + "    \"column\" :\"createdDate\"\r\n" + "}";
		return value;
	}

	private static String blankLinkedFacilityId() {
		String value = "{\r\n" + "    \"linkedFacilityId\" :\"\",\r\n" + "    \"searchText\" :\"\",\r\n"
				+ "    \"targetFacilityIds\": [],\r\n" + "    \"surgeonIds\": [],\r\n"
				+ "    \"applicationIds\": [],\r\n" + "    \"statuses\": []\r\n" + "   \r\n" + "    \r\n" + "    \r\n"
				+ "}";
		return value;
	}

	private static String nulldashboarddetails(String linkedFacilityId) {
		String value = "{\r\n" + "    \"linkedFacilityId\" :\"" + linkedFacilityId + "\",\r\n"
				+ "    \"searchText\" :\"\",\r\n" + "    \"targetFacilityIds\": [],\r\n" + "    \"surgeonIds\": [],\r\n"
				+ "    \"applicationIds\": [],\r\n" + "    \"statuses\": []\r\n" + "   \r\n" + "    \r\n" + "    \r\n"
				+ "}";
		return value;
	}
}
