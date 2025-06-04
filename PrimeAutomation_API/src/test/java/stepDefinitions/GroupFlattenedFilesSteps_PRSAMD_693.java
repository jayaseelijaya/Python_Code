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

public class GroupFlattenedFilesSteps_PRSAMD_693 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(GroupFlattenedFilesSteps_PRSAMD_693.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url is entered for grouping of flattened files")
	public void base_url_is_entered_for_grouping_of_flattened_files() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK*******************************
	@When("user enters valid {string} & {string} and fetch batchId from {string} {int} and trigger POST api")
	public void user_enters_valid_and_fetch_batch_id_from_and_trigger_post_api(String Authorization, String token,
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(payload(sheetName, RowNumber).toString()).post("/imageupload/groupbypatient");
		logger.info("API is triggered");
	}

	@When("user enters valid {string} & {string} and fetch invalid batchId from {string} {int} and trigger POST api")
	public void user_enters_valid_and_fetch_invalid_batch_id_from_and_trigger_post_api(String Authorization,
			String token, String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(payload(sheetName, RowNumber).toString()).post("/imageupload/groupbypatient");
		logger.info("API is triggered");
	}

	@When("user enters invalid {string} & {string} and fetch valid batchId from {string} {int} and trigger POST api")
	public void user_enters_invalid_and_fetch_valid_batch_id_from_and_trigger_post_api(String Authorization,
			String token, String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(payload(sheetName, RowNumber).toString()).post("/imageupload/groupbypatient");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	@Then("Response would be generated with error messages and status code given as {int}")
	public void response_would_be_generated_with_error_messages_and_status_code_given_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("Response would be generated with error messages stating {int} response code")
	public void response_would_be_generated_with_error_messages_stating_response_code(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("Response would be generated with success message and status code given as {int}")
	public void response_would_be_generated_with_success_message_and_status_code_given_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("{string} field validates in Response")
	public void field_validates_in_response(String keyValue) {
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
				System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_693.xlsx",
				sheetName);
		String batchId = testData.get(RowNumber).get("batchId");
		JSONObject payload = new JSONObject();
		payload.put("batchId", batchId);
		return payload;
	}
}
