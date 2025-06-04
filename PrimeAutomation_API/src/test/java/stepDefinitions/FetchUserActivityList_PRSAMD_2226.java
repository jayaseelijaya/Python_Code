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


public class FetchUserActivityList_PRSAMD_2226 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchUserActivityList_PRSAMD_2226.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the base URL gets entered for fetching user activity")
	public void the_base_url_gets_entered_for_fetching_user_activity() 
	throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK*******************************
	
	@When("user gives a valid {string} and {string} and {string} and triggers the POST API for fetching user activity list")
	public void user_gives_a_valid_and_and_and_triggers_the_post_api_for_fetching_user_activity_list(String Authorization, String Token, String userFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(validCase(userFacilityId)).post("imageupload/fetchauditlog");
		logger.info("API is triggered");
		logger.info("UserFacilityId given as : " + userFacilityId);
	}
	
	@When("user enters a valid {string} and {string} and search Text as {string} and triggers the POST API for fetching user activity list")
	public void user_enters_a_valid_and_and_search_text_as_and_triggers_the_post_api_for_fetching_user_activity_list(String Authorization, String Token, String searchText) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(searchTestData(searchText)).post("imageupload/fetchauditlog");
		logger.info("API is triggered");
		logger.info("SearchText given as : " + searchText);
	}

	@When("user gives a valid {string} and {string} and filter field as {string} and triggers the POST API for fetching user activity list")
	public void user_gives_a_valid_and_and_filter_field_as_and_triggers_the_post_api_for_fetching_user_activity_list(String Authorization, String Token, String fromActionDate) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(filterTestData(fromActionDate)).post("imageupload/fetchauditlog");
		logger.info("API is triggered");
		logger.info("From Action Date given as : " + fromActionDate);
	}

	@When("user gives a valid {string} and {string}, user facility id {string} and username {string} and triggers the POST API for fetching user activity list")
	public void user_gives_a_valid_and_user_facility_id_and_username_and_triggers_the_post_api_for_fetching_user_activity_list(String Authorization, String Token, String userFacilityId, String userName) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(ManagerAdmin(userFacilityId,userName)).post("imageupload/fetchauditlog");
		logger.info("API is triggered");
		logger.info("UserFacilityId given as : " + userFacilityId);
		logger.info("UserName given as : " + userName);
	}

	@When("user gives a valid {string} and {string} along with user facility id {string} and username {string} and triggers the POST API for fetching user activity list")
	public void user_gives_a_valid_and_along_with_user_facility_id_and_username_and_triggers_the_post_api_for_fetching_user_activity_list(String Authorization, String Token, String userFacilityId, String userName) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(ManagerAdmin(userFacilityId,userName)).post("imageupload/fetchauditlog");
		logger.info("API is triggered");
		logger.info("UserFacilityId given as : " + userFacilityId);
		logger.info("UserName given as : " + userName);
	}

	@When("user gives a valid {string} and {string} and blank or invalid {string} and triggers the POST API for fetching user activity list")
	public void user_gives_a_valid_and_and_blank_or_invalid_and_triggers_the_post_api_for_fetching_user_activity_list(String Authorization, String Token, String userFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(validCase(userFacilityId)).post("imageupload/fetchauditlog");
		logger.info("API is triggered");
		logger.info("userFacilityId given as : " + userFacilityId);
	}
	
	@When("user gives an invalid {string} and {string} and valid {string} and triggers the POST API for fetching user activity list")
	public void user_gives_an_invalid_and_and_valid_and_triggers_the_post_api_for_fetching_user_activity_list(String Authorization, String Token, String userFacilityId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(invalidTokenTestData()).post("imageupload/fetchauditlog");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code for fetching user activity list")
	public void response_is_generated_with_success_status_code_for_fetching_user_activity_list() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with failure status code for fetching user activity list")
	public void response_is_generated_with_failure_status_code_for_fetching_user_activity_list() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code for fetching user activity list")
	public void response_is_generated_with_unauthorized_status_code_for_fetching_user_activity_list() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	@Then("an attribute {string} is verified while fetching user activity")
	public void an_attribute_is_verified_while_fetching_user_activity(String keyValue) {
		if (keyValue.equalsIgnoreCase("auditLogResponseList")) {
			String auditLogResponseList = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "auditLogResponseList");
			logger.info("Audit Log Response List Details field values are : " + auditLogResponseList);
			
			assertEquals(expected_value, auditLogResponseList);
			logger.info("Audit Log Response List Details values against the response body is verified");
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
	private static String validCase(String userFacilityId) {
		String value = "{\r\n"+ "    \"userFacilityId\" : \""+userFacilityId+"\",\r\n"
				+ "    \"searchText\" : \"\",\r\n"+ "    \"userName\" :[],\r\n"
				+ "    \"fromActionDate\" :null,\r\n"+ "    \"toActionDate\"  :null,\r\n"+ "    \"pageno\" :0,\r\n"
				+ "    \"limit\" : 10,\r\n"+ "    \"column\" : \"EventDate\"\r\n"+ "\r\n"+ "}";
		return value;
	}

	private static String searchTestData(String searchText) {
		String value = "{\r\n"+ "    \"userFacilityId\" : \"2\",\r\n"
				+ "    \"searchText\" : \""+searchText+"\",\r\n"+ "    \"userName\" :[],\r\n"
				+ "    \"fromActionDate\" :null,\r\n"+ "    \"toActionDate\"  :null,\r\n"
				+ "    \"pageno\" :0,\r\n"+ "    \"limit\" : 10,\r\n"+ "    \"column\" : \"EventDate\"\r\n"
				+ "\r\n"+ "}";
		return value;
	}

	private static String filterTestData(String fromActionDate) {
		String value = "{\r\n"+ "    \"userFacilityId\" : \"2\",\r\n"+ "    \"searchText\" : \"\",\r\n"
				+ "    \"userName\" :[],\r\n"+ "    \"fromActionDate\" :\""+fromActionDate+"\",\r\n"
				+ "    \"toActionDate\"  :null,\r\n"+ "    \"pageno\" :0,\r\n"+ "    \"limit\" : 10,\r\n"
				+ "    \"column\" : \"EventDate\"\r\n"+ "\r\n"+ "}";
		return value;
	}
	
	private static String ManagerAdmin(String userFacilityId, String userName) {
		String value = "{\r\n"+ "    \"userFacilityId\" : \""+userFacilityId+"\",\r\n"+ "    \"searchText\" : \"\",\r\n"
				+ "    \"userName\" :[\""+userName+"\"],\r\n"+ "    \"fromActionDate\" :null,\r\n"
				+ "    \"toActionDate\"  :null,\r\n"+ "    \"pageno\" :0,\r\n"
				+ "    \"limit\" : 10,\r\n"+ "    \"column\" : \"EventDate\"\r\n"+ "\r\n"+ "}";
		return value;
	}

	private static String invalidTokenTestData() {
		String value = "{\r\n"+ "    \"userFacilityId\" : \"2\",\r\n"+ "    \"searchText\" : \"\",\r\n"
				+ "    \"userName\" :[],\r\n"+ "    \"fromActionDate\" :null,\r\n"
				+ "    \"toActionDate\"  :null,\r\n"+ "    \"pageno\" :0,\r\n"+ "    \"limit\" : 10,\r\n"
				+ "    \"column\" : \"EventDate\"\r\n"+ "\r\n"+ "}";
		return value;
	}
	
}