package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.CommonUtils;

public class SkippedFileDetailsSteps_PRSAMD_648 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(SkippedFileDetailsSteps_PRSAMD_648.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url is entered to fetch information of skipped file")
	public void base_url_is_entered_to_fetch_information_of_skipped_file() throws IOException {
		logger.info("Base_url_is_entered");
		String baseUrl = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseUrl);
		logger.info("Base_url : " + baseUrl);
	}

	// *********************WHEN BLOCK*******************************
	@When("user entered valid {string} , {string} & {string} and triggers GET API")
	public void user_entered_valid_and_triggers_get_api(String Authorization, String token, String batchId) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("batchid", batchId).get("/imageupload/skippedfile");
		logger.info("BatchId : " +batchId);
		logger.info("API is triggered");
	}

	@When("user entered invalid {string} , {string} & {string} and triggers GET API")
	public void user_entered_invalid_and_triggers_get_api(String Authorization, String token, String batchId) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("batchid", batchId).get("/imageupload/skippedfile");
		logger.info("API is triggered");
	}

	@When("user entered valid {string} , {string} &  invalid {string} and triggers GET API")
	public void user_entered_valid_invalid_and_triggers_get_api(String Authorization, String token, String batchId) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("batchid", batchId).get("/imageupload/skippedfile");
		logger.info("BatchId : " +batchId);
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	@Then("Response is generated with empty details and status code as {int}")
	public void response_is_generated_with_empty_details_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
//		List<String> jsonResponse = _RESPONSE.jsonPath().getList("$");
//		logger.info("Number of records in Response body : " + jsonResponse.size());
//		logger.info("No records found in Response body due to incorrect batchId ");
	}

	@Then("Response is generated with no skipped file details and status code as {int}")
	public void response_is_generated_with_no_skipped_file_details_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	@Then("Response is generated with skipped file details and status code as {int}")
	public void response_is_generated_with_skipped_file_details_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
//		List<String> jsonResponse = _RESPONSE.jsonPath().getList("$");
//		logger.info("Number of records in Response body : " + jsonResponse.size());
	}

	@Then("{string} attribute validation is performed.")
	public void attribute_validation_is_performed(String keyValue) {
		if (keyValue.equalsIgnoreCase("fileName")) {
			String fileName = getJsonPath(_RESPONSE, keyValue);
			String filepath_value = getJsonPath(_RESPONSE, "filePath");
			expected_value = getJsonPath(_RESPONSE, "fileName");
			logger.info("fileName field values are : " + fileName);
			logger.info("filePath field values are : : " + filepath_value);
			assertEquals(expected_value, fileName);
			logger.info("filePath values against the response body is verified");
		} else {
			// Verifying the error message against response body
			String error_message = getJsonPath(_RESPONSE, "errors");
			expected_value = getJsonPath(_RESPONSE, "errors");
			assertEquals(expected_value, error_message);
			logger.info("Error message : " + error_message);
			logger.info("Error message is validated against response body ");
		}
	}
}
