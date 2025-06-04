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

public class Fetch3DModelFromUpdatedMaskSteps_PRSAMD_2306 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(Fetch3DModelFromUpdatedMaskSteps_PRSAMD_2306.class);

	// *********************GIVEN BLOCK*******************************
	
	@Given("a user enters the valid URL for fetching new 3D model from updated mask without saving")
	public void a_user_enters_the_valid_url_for_fetching_new_3d_model_from_updated_mask_without_saving() 
		throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("HIL_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("the user gives a valid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API to fetch new 3D model from updated mask without saving")
	public void the_user_gives_a_valid_and_with_valid_test_data_from_and_and_trigger_get_api_to_fetch_new_3d_model_from_updated_mask_without_saving(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/draftbonemodel");
		logger.info("API is triggered");
	}
	
	@When("the user gives a valid {string} and {string} with invalid Test Data from {string} and {int} and trigger GET API to fetch new 3D model from updated mask without saving")
	public void the_user_gives_a_valid_and_with_invalid_test_data_from_and_and_trigger_get_api_to_fetch_new_3d_model_from_updated_mask_without_saving(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/draftbonemodel");
		logger.info("API is triggered");
	}
	
	@When("the user gives an invalid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API to fetch new 3D model from updated mask without saving")
	public void the_user_gives_an_invalid_and_with_valid_test_data_from_and_and_trigger_get_api_to_fetch_new_3d_model_from_updated_mask_without_saving(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/hil/draftbonemodel");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code for fetching new 3D model from updated mask without saving")
	public void response_is_generated_with_success_status_code_for_fetching_new_3d_model_from_updated_mask_without_saving() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with no data found status code for fetching new 3D model from updated mask without saving")
	public void response_is_generated_with_no_data_found_status_code_for_fetching_new_3d_model_from_updated_mask_without_saving() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code for fetching new 3D model from updated mask without saving")
	public void response_is_generated_with_unauthorized_status_code_for_fetching_new_3d_model_from_updated_mask_without_saving() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("the attribute {string} is validated for fetching new 3D model from updated mask without saving")
	public void the_attribute_is_validated_for_fetching_new_3d_model_from_updated_mask_without_saving(String keyValue) {
	    
		if (keyValue.equalsIgnoreCase("draft3DBoneModelLink")) {
			String draft3DBoneModelLink = getJsonPath(_RESPONSE, keyValue);
			String draft3DBoneModelStatus = getJsonPath(_RESPONSE, "draft3DBoneModelStatus");
			String isFileAvailable = getJsonPath(_RESPONSE, "isFileAvailable");
			String responseStatus = getJsonPath(_RESPONSE, "responseStatus");
			
			
			expected_value = getJsonPath(_RESPONSE, "draft3DBoneModelLink");
			
			logger.info("draft3DBoneModelLink field values are : " + draft3DBoneModelLink);
			logger.info("draft3DBoneModelStatus field values are : : " + draft3DBoneModelStatus);
			logger.info("isFileAvailable field values are : : " + isFileAvailable);
			logger.info("responseStatus field values are : : " + responseStatus);
			
			assertEquals(expected_value, draft3DBoneModelLink);
			logger.info("Draft 3D Bone Model Link Details values against the response body is verified");
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
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_2306.xlsx", SheetName);
		String caseId = testData.get(RowNumber).get("caseId");
		
		
		JSONObject payload = new JSONObject();
		payload.put("caseId", caseId);
		
		return payload;
	
	}
	
}