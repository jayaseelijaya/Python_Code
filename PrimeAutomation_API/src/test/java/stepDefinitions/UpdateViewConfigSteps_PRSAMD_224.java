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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.CommonUtils;
import utility.ExcelReader;

public class UpdateViewConfigSteps_PRSAMD_224 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UpdateViewConfigSteps_PRSAMD_224.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url is entered to update view configuration")
	public void base_url_is_entered_to_update_view_configuration() throws IOException {
		logger.info("Base_url_is_entered");
		String baseUrl = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseUrl);
		logger.info("Base_url : " + baseUrl);
	}

	// *********************WHEN BLOCK*******************************
	@When("user enters valid {string} {string} and extract input testdata from {string} {int} then trigger PUT method")
	public void user_enters_valid_and_extract_input_testdata_from_then_trigger_put_method(String Authorization,
			String token, String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(payload(sheetName, RowNumber).toString()).put("/imageupload/viewconfig");
		logger.info("API is triggered");
	}

	@When("user enters valid {string} {string} and extract invalid input testdata from {string} {int} then trigger PUT method")
	public void user_enters_valid_and_extract_invaid_input_testdata_from_then_trigger_put_method(String Authorization,
			String token, String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(payload(sheetName, RowNumber).toString()).put("/imageupload/viewconfig");
		logger.info("API is triggered");
	}

	@When("user enters invalid {string} {string} and extract input testdata from {string} {int} then trigger PUT method")
	public void user_enters_invalid_and_extract_input_testdata_from_then_trigger_put_method(String Authorization,
			String token, String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(payload(sheetName, RowNumber).toString()).put("/imageupload/viewconfig");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	@Then("response body will generate and status code as {int}")
	public void response_body_will_generate_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("response body will generate with status code as {int}")
	public void response_body_will_generate_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("response body will generate status code as {int}")
	public void response_body_will_generate_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("{string} in response message is verified")
	public void in_response_message_is_verified(String keyValue) {
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
	private HashMap<String, String> payload(String sheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_224.xlsx",
				sheetName);
		String facilityId = testData.get(RowNumber).get("facilityId");
		String isFacilityWide = testData.get(RowNumber).get("isFacilityWide");
		JSONObject payload = new JSONObject();
		payload.put("facilityId", facilityId);
		payload.put("isFacilityWide", isFacilityWide);
		return payload;
	}
}