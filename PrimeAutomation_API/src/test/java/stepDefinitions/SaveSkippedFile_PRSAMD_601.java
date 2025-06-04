package stepDefinitions;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.json.simple.JSONObject;

import utility.CommonUtils;
import utility.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SaveSkippedFile_PRSAMD_601 extends CommonUtils {

	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(SaveSkippedFile_PRSAMD_601.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url is entered to save skipped file information")
	public void base_url_is_entered_to_save_skipped_file_information() throws IOException {
		logger.info("Base_url_is_entered");
		String baseUrl = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseUrl);
		logger.info("Base_url : " + baseUrl);
	}

	// *********************WHEN BLOCK*******************************
	@When("user enters valid {string} {string} and extract testdata from {string} {int} then trigger POST method")
	public void user_enters_valid_and_extract_testdata_from_then_trigger_post_method(String Authorization, String Value,
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		
		Value=passAuthorizationToken(Value);
		_RESPONSE = _RESP_SPEC.header(Authorization, Value).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/imageupload/skippedfile");
		logger.info("API is triggered");
	}

	@When("user enters valid {string} {string} and extract blank testdata from {string} {int} then trigger POST method")
	public void user_enters_valid_and_extract_blank_testdata_from_then_trigger_post_method(String Authorization,
			String Value, String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		
		Value=passAuthorizationToken(Value);
		_RESPONSE = _RESP_SPEC.header(Authorization, Value).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/imageupload/skippedfile");
		logger.info("API is triggered");
	}

	@When("user enters valid {string} {string} and extract invalid testdata from {string} {int} then trigger POST method")
	public void user_enters_valid_and_extract_invalid_testdata_from_then_trigger_post_method(String Authorization,
			String Value, String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		
		Value=passAuthorizationToken(Value);
		_RESPONSE = _RESP_SPEC.header(Authorization, Value).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/imageupload/skippedfile");
		logger.info("API is triggered");
	}

	@When("user enters invalid {string} {string} and extract testdata from {string} {int} then trigger POST method")
	public void user_enters_invalid_and_extract_testdata_from_then_trigger_post_method(String Authorization,
			String Value, String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		
		Value=passAuthorizationToken(Value);
		_RESPONSE = _RESP_SPEC.header(Authorization, Value).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/imageupload/skippedfile");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	@Then("Response Body gets generated with status code as {int}")
	public void response_body_gets_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	@Then("Response Body got generated with status code as {int}")
	public void response_body_got_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	@Then("Response Body get generated with status code as {int}")
	public void response_body_get_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	@Then("Response Body  generated with status code as {int}")
	public void response_body_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	@Then("{string} attribute in Response Message is verified")
	public void attribute_in_response_message_is_verified(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			logger.info("responseMessage is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("responseMessage is validated against response");
		} else {
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
	}

	// function to get the test-data from excel sheet
	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") + "/src/test/resources/TestData/TestCaseData_PRSAMD_601.xlsx",
				SheetName);
		String batchId = testData.get(RowNumber).get("batchId");
		String fileName = testData.get(RowNumber).get("fileName");
		String filePath = testData.get(RowNumber).get("filePath");
		JSONObject payload = new JSONObject();
		payload.put("batchId", batchId);
		payload.put("fileName", fileName);
		payload.put("filePath", filePath);
		return payload;
	}
}
