//package stepDefinitions;
//
//import static io.restassured.RestAssured.given;
//
//import static org.junit.Assert.assertEquals;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.apache.log4j.Logger;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.json.simple.JSONObject;
//
//import utility.CommonUtils;
//import utility.ExcelReader;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class UpdateStatusSteps_PRSAMD_6 extends CommonUtils {
//	RequestSpecification _RESP_SPEC;
//	static Response _RESPONSE;
//	String resp;
//	String expected_value;
//	final static Logger logger = Logger.getLogger(UpdateStatusSteps_PRSAMD_6.class);
//
//	// *********************GIVEN BLOCK*******************************
//	@Given("base url is entered to update statuses of uploaded files")
//	public void base_url_is_entered_to_update_statuses_of_uploaded_files() throws IOException {
//		logger.info("Base_url_is_entered");
//		String baseUrl = getGlobalValue("baseUrl");
//		_RESP_SPEC = given().baseUri(baseUrl);
//		logger.info("Base_url : " + baseUrl);
//	}
//
//	// *********************WHEN BLOCK*******************************
//	@When("user enters valid {string} {string} and extract testdata from {string} {int} then trigger PUT method")
//	public void user_enters_valid_and_extract_testdata_from_then_trigger_put_method(String Authorization, String token,
//			String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
//		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
//				.body(payload(sheetName, RowNumber).toString()).put("/imageupload/uploadstatus");
//		logger.info("API is triggered");
//	}
//
//	@When("user enters valid {string} {string} and extract invalid testdata from {string} {int} then trigger PUT method")
//	public void user_enters_valid_and_extract_invalid_testdata_from_then_trigger_put_method(String Authorization,
//			String token, String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
//		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
//				.body(payload(sheetName, RowNumber).toString()).put("/imageupload/uploadstatus");
//		logger.info("API is triggered");
//	}
//
//	@When("user enters invalid {string} {string} and extract valid testdata from {string} {int} then trigger PUT method")
//	public void user_enters_invalid_and_extract_valid_testdata_from_then_trigger_put_method(String Authorization,
//			String token, String sheetName, Integer RowNumber) throws InvalidFormatException, IOException {
//		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
//				.body(payload(sheetName, RowNumber).toString()).put("/imageupload/uploadstatus");
//		logger.info("API is triggered");
//	}
//
//	// *********************THEN BLOCK*******************************
//	@Then("response body generates with status code as {int}")
//	public void response_body_generates_with_status_code_as(Integer int1) {
//		logger.info("Response is generated");
//		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
//	}
//
//	@Then("response body got generated with status code as {int}")
//	public void response_body_got_generated_with_status_code_as(Integer int1) {
//		logger.info("Response is generated");
//		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
//		logger.info("Response body as : " + resp);
//	}
//
//	@Then("response body gets generated with status code as {int}")
//	public void response_body_gets_generated_with_status_code_as(Integer int1) {
//		logger.info("Response is generated");
//		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
//	}
//
//	@Then("{string} attribute in response message is verified")
//	public void attribute_in_response_message_is_validated(String keyValue) {
//		if (keyValue.equalsIgnoreCase("responseMessage")) {
//			String message = getJsonPath(_RESPONSE, keyValue);
//			expected_value = getJsonPath(_RESPONSE, "responseMessage");
//			logger.info("responseMessage is : " + expected_value);
//			assertEquals(expected_value, message);
//			logger.info("responseMessage is validated against response");
//		} else {
//			String errors = getJsonPath(_RESPONSE, keyValue);
//			expected_value = getJsonPath(_RESPONSE, "errors");
//			logger.info("Error message : " + expected_value);
//			assertEquals(expected_value, errors);
//			logger.info("Errors is validated against response");
//		}
//	}
//
//	// function to get the test-data from excel sheet
//	private HashMap<String, String> payload(String sheetName, Integer RowNumber)
//			throws InvalidFormatException, IOException {
//		ExcelReader reader = new ExcelReader();
//		List<Map<String, String>> testData = reader.getData(
//				System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_6.xlsx", sheetName);
//		String uploadId = testData.get(RowNumber).get("uploadId");
//		String status = testData.get(RowNumber).get("status");
//		String notes = testData.get(RowNumber).get("notes");
//		JSONObject payload = new JSONObject();
//		payload.put("uploadId", uploadId);
//		payload.put("status", status);
//		payload.put("notes", notes);
//		return payload;
//	}
//}
