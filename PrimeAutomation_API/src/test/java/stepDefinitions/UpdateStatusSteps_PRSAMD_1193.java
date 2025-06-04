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


public class UpdateStatusSteps_PRSAMD_1193 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UpdateStatusSteps_PRSAMD_1193.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the Base URL is entered to update upload file status")
	public void the_base_url_is_entered_to_update_upload_file_status() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	    
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("the user provides valid {string} with valid {string} extracting test data from {string} {int} and triggers the PUT API")
	public void the_user_provides_valid_with_valid_extracting_test_data_from_and_triggers_the_put_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString( )).put("/imageupload/uploadstatus");
		logger.info("API is triggered");
	}
	
	@When("the user uses valid {string} & valid {string} along with an invalid uploadId in {string} {int} and triggers the PUT API")
	public void the_user_uses_valid_valid_along_with_an_invalid_uploadid_in_and_triggers_the_put_api(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException{
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString( )).put("/imageupload/uploadstatus");
		logger.info("API is triggered");
	}
	
	@When("the user uses a valid {string} & valid {string} along with invalid status in {string} {int} and triggers the PUT API")
	public void the_user_uses_a_valid_valid_along_with_invalid_status_in_and_triggers_the_put_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString( )).put("/imageupload/uploadstatus");
		logger.info("API is triggered");
	}
	
	@When("the user provides an invalid {string} with invalid {string} and test data being extracted from {string} {int}  and triggers the PUT API")
	public void the_user_provides_an_invalid_with_invalid_and_test_data_being_extracted_from_and_triggers_the_put_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString( )).put("/imageupload/uploadstatus");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("a response is generated with {int} Status code depicting update status of Uploaded file")
	public void a_response_is_generated_with_status_code_depicting_update_status_of_uploaded_file(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response is getting generated with {int} Status code depicting update status of Uploaded file")
	public void a_response_is_getting_generated_with_status_code_depicting_update_status_of_uploaded_file(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response  generate with {int} Status code depicting update status of Uploaded file")
	public void a_response_generate_with_status_code_depicting_update_status_of_uploaded_file(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("an attribute {string}  validated against response is verified.")
	public void an_attribute_validated_against_response_is_verified(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			logger.info("responseMessage is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("responseMessage is validated against response");
			} 
		else {
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
	}
	

	// *********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_1193.xlsx", SheetName);
		String uploadId = testData.get(RowNumber).get("uploadId");
		String status = testData.get(RowNumber).get("status");
		String notes = testData.get(RowNumber).get("notes");
		
		JSONObject payload = new JSONObject();
		payload.put("uploadId", uploadId);
		payload.put("status", status);
		payload.put("notes", notes);
		
		return payload;
	
	}
}
