package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.File;
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UploadDICOMImagesSteps_PRSAMD_797 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UploadDICOMImagesSteps_PRSAMD_797.class);

	// *********************GIVEN BLOCK*******************************

	@Given("the Base URL is entered for uploading DICOM Images in AWS S3")
	public void the_base_url_is_entered_for_uploading_dicom_images_in_aws_s3() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK********************************

	@When("User enter a valid {string} & {string} with valid {string} triggering the POST API")
	public void user_enter_a_valid_with_valid_triggering_the_post_api(String Authorization, String Token,
			String batchId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("batchId", batchId)
				.multiPart("actualFile", new File("./src/test/resources/testData/TestCaseData_PRSAMD_797"))
				.post("/imageupload/fileupload");
		logger.info("API is triggered");
	}

	@When("User enter a valid {string} & {string} along with blank {string} triggering the POST API")
	public void user_enter_a_valid_along_with_blank_triggering_the_post_api(String Authorization, String Token,
			String batchId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("batchId", batchId)
				.multiPart("actualFile", new File("./src/test/resources/testData/TestCaseData_PRSAMD_797"))
				.post("/imageupload/fileupload");
		logger.info("API is triggered");
	}

	@When("User enter a valid {string} & {string} with an invalid {string} triggering the POST API")
	public void user_enter_a_valid_with_an_invalid_triggering_the_post_api(String Authorization, String Token,
			String batchId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("batchId", batchId)
				.multiPart("actualFile", new File("./src/test/resources/testData/TestCaseData_PRSAMD_797"))
				.post("/imageupload/fileupload");
		logger.info("API is triggered");
	}

	@When("the user enters the invalid {string} and {string} also with {string} and triggers the POST API")
	public void the_user_enters_the_invalid_and_also_with_and_triggers_the_post_api(String Authorization, String Token,
			String batchId) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("batchId", batchId)
				.multiPart("actualFile", new File("./src/test/resources/testData/TestCaseData_PRSAMD_797"))
				.post("/imageupload/fileupload");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK********************************

	@Then("a {int} response code is generated with file upload success message")
	public void a_response_code_is_generated_with_file_upload_success_message(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	@Then("a {int} response code is generated with file or batchId invalid message")
	public void a_response_code_is_generated_with_file_or_batch_id_invalid_message(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	@Then("a {int} response code is generated with batchId not found invalid message")
	public void a_response_code_is_generated_with_batch_id_not_found_invalid_message(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("a response with status code {int}  being generated with Unauthorised error details")
	public void a_response_with_status_code_being_generated_with_unauthorised_error_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	@Then("the attribute {string} shown in response is verified")
	public void the_attribute_shown_in_response_is_verified(String keyValue) {
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
}