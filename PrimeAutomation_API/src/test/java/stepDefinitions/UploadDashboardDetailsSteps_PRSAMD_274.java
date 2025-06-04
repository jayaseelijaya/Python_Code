package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.CommonUtils;
import utility.ExcelReader;

public class UploadDashboardDetailsSteps_PRSAMD_274 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UploadDashboardDetailsSteps_PRSAMD_274.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url is entered to fetch upload dashboad details")
	public void base_url_is_entered_to_fetch_upload_dashboad_details() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK*******************************
	@When("user enters valid {string} {string} and fetch testdata from {string} {int} and then trigger GET API")
	public void user_enters_valid_and_fetch_testdata_from_and_then_trigger_get_api(String Authorization, String token,
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.queryParams(payload(sheetName, RowNumber)).get("imageupload/dashboard");
		logger.info("API is triggered");
	}

	@When("user enters invalid {string} {string} and fetch testdata from {string} {int} and then trigger GET API")
	public void user_enters_invalid_and_fetch_testdata_from_and_then_trigger_get_api(String Authorization, String token,
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.queryParams(payload(sheetName, RowNumber)).get("imageupload/dashboard");
		logger.info("API is triggered");
	}

	@When("user enters valid {string} {string} {string} and {int} then trigger incorrect URL given for GET API")
	public void user_enters_valid_and_then_trigger_incorrect_url_given_for_get_api(String Authorization, String token,
			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.queryParams(payload(sheetName, RowNumber)).get("imageupload/dashboa");
		logger.info("API is triggered");

	}

	// *********************THEN BLOCK*******************************
	@Then("response body is generated with no dashboard details and status code as {int}")
	public void response_body_is_generated_with_no_dashboard_details_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
		String error_message = getJsonPath(_RESPONSE, "errors");
		logger.info("Error message : " + error_message);
	}

	@Then("response body is generated with dashboard details and status code as {int}")
	public void response_body_is_generated_with_dashboard_details_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("attribute validation of {string} in response body is verified")
	public void attribute_validation_of_in_response_body_is_verified(String keyValue) {
		String message = getJsonPath(_RESPONSE, keyValue);
		expected_value = getJsonPath(_RESPONSE, "totalElements");
		logger.info("responseMessage is : " + expected_value);
		assertEquals(expected_value, message);
		logger.info("totalElements is validated against response");
		expected_value = getJsonPath(_RESPONSE, "dashboardDetails");
		logger.info("Dashboard details are : " + expected_value);
	}

	@Then("response body is generated with error details and status code as {int}")
	public void response_body_is_generated_with_error_details_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as : " + resp);
		String error_message = getJsonPath(_RESPONSE, "error");
		logger.info("Error message : " + error_message);
	}

	/* Function to extract test-data from excel files */
	private HashMap<String, String> payload(String sheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_274.xlsx",
				sheetName);
		String facilityid = testData.get(RowNumber).get("linkedfacilityid");
		String page = testData.get(RowNumber).get("page");
		String limit = testData.get(RowNumber).get("limit");
		String column = testData.get(RowNumber).get("column");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("linkedfacilityid", facilityid);
		map.put("page", page);
		map.put("limit", limit);
		map.put("column", column);
		return map;
	}
}
