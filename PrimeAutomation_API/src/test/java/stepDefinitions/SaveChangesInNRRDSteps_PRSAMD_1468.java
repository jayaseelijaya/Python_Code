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

import utility.CommonUtils;
import utility.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SaveChangesInNRRDSteps_PRSAMD_1468 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(SaveChangesInNRRDSteps_PRSAMD_1468.class);

	// *********************GIVEN BLOCK*******************************
	
	@Given("a user enters the valid URL for saving changes in nrrd mask")
	public void a_user_enters_the_valid_url_for_saving_changes_in_nrrd_mask() 
		throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("HIL_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("the user gives a valid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API to save changes in nrrd mask")
	public void the_user_gives_a_valid_and_with_valid_test_data_from_and_and_trigger_get_api_to_save_changes_in_nrrd_mask(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/savedraftsegmentednrrdmask");
		logger.info("API is triggered");
	}
	
	@When("the user gives a valid {string} and {string} with blank Test Data from {string} and {int} and trigger GET API to save changes in nrrd mask")
	public void the_user_gives_a_valid_and_with_blank_test_data_from_and_and_trigger_get_api_to_save_changes_in_nrrd_mask(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/savedraftsegmentednrrdmask");
		logger.info("API is triggered");
	}
	
	@When("the user gives a valid {string} and {string} with invalid Test Data from {string} and {int} and trigger GET API to save changes in nrrd mask")
	public void the_user_gives_a_valid_and_with_invalid_test_data_from_and_and_trigger_get_api_to_save_changes_in_nrrd_mask(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/savedraftsegmentednrrdmask");
		logger.info("API is triggered");
	}
	
	@When("the user gives an invalid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API for saving changes in nrrd mask")
	public void the_user_gives_an_invalid_and_with_valid_test_data_from_and_and_trigger_get_api_for_saving_changes_in_nrrd_mask(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/savedraftsegmentednrrdmask");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code for saving changes in nrrd mask")
	public void response_is_generated_with_success_status_code_for_saving_changes_in_nrrd_mask() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with failure status code for saving changes in nrrd mask")
	public void response_is_generated_with_failure_status_code_for_saving_changes_in_nrrd_mask() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with no data found status code for saving changes in nrrd mask")
	public void response_is_generated_with_no_data_found_status_code_for_saving_changes_in_nrrd_mask() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code for saving changes in nrrd mask")
	public void response_is_generated_with_unauthorized_status_code_for_saving_changes_in_nrrd_mask() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("the attribute {string} is validated for saving changes in nrrd mask")
	public void the_attribute_is_validated_for_saving_changes_in_nrrd_mask(String keyValue) {
		if (keyValue.equalsIgnoreCase("segmentedNrrdMaskUploadLink")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "segmentedNrrdMaskUploadLink");
			logger.info(" segmentedNrrdMaskUploadLink is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("segmentedNrrdMaskUploadLink is validated against response");
			} 
		else {
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
	}
	
//	*********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_1468.xlsx", SheetName);
		String isApproved = testData.get(RowNumber).get("isApproved");
		String isSessionSave = testData.get(RowNumber).get("isSessionSave");
		String caseId = testData.get(RowNumber).get("caseId");
		
		JSONObject payload = new JSONObject();
		payload.put("isApproved", isApproved);
		payload.put("isSessionSave", isSessionSave);
		payload.put("caseId", caseId);
		
		
		return payload;
	
	}
}