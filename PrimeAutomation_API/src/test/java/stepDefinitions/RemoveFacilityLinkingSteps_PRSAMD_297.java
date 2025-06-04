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

public class RemoveFacilityLinkingSteps_PRSAMD_297 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(RemoveFacilityLinkingSteps_PRSAMD_297.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url is entered to remove linking")
	public void base_url_is_entered_to_remove_linking() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK*******************************
	@When("user enters valid {string} {string} and fetch testdata from {string} {int} and trigger PUT method")
	public void user_enters_valid_and_fetch_testdata_from_and_trigger_put_method(String Authorization, String token,
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(payload(sheetName, RowNumber).toString()).put("/imageupload/facilitylinking");
		logger.info("API is triggered");
	}

	@When("user enters valid {string} {string} and fetch testdata from {string} {int} and triggered PUT method")
	public void user_enters_valid_and_fetch_testdata_from_and_triggered_put_method(String Authorization, String token,
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(payload(sheetName, RowNumber).toString()).put("/imageupload/facilitylinking");
		logger.info("API is triggered");
	}

	@When("user enters invalid {string} {string} and fetch testdata from {string} {int} and triggered PUT method")
	public void user_enters_invalid_and_fetch_testdata_from_and_triggered_put_method(String Authorization, String token,
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(payload(sheetName, RowNumber).toString()).put("/imageupload/facilitylinking");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	@Then("response body will generate with error message and status code as {int}")
	public void response_body_will_generate_with_error_message_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("response body will generate with success message and status code as {int}")
	public void response_body_will_generate_with_success_message_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("response body will be generated with status code as {int} and error message")
	public void response_body_will_be_generated_with_status_code_as_and_error_message(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("{string} validates in response message.")
	public void validates_in_response_message(String keyValue) {
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
				System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_297.xlsx",
				sheetName);
		String sourceFacilityId = testData.get(RowNumber).get("sourceFacilityId");
		String targetFacilityId = testData.get(RowNumber).get("targetFacilityId");
		JSONObject payload = new JSONObject();
		payload.put("sourceFacilityId", sourceFacilityId);
		payload.put("targetFacilityId", targetFacilityId);
		return payload;
	}
}
