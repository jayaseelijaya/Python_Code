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

public class UploadStatusSteps_PRSAMD_600 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UploadStatusSteps_PRSAMD_600.class);

	@Given("base url is entered to fetch status details of uploaded files")
	public void base_url_is_entered_to_fetch_status_details_of_uploaded_files() throws IOException {
		logger.info("Base_url_is_entered");
		String baseUrl = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseUrl);
		logger.info("Base_url : " + baseUrl);
	}

	@When("user enters valid {string} , {string} & uploadId as {string} and triggers GET API")
	public void user_enters_valid_upload_id_as_and_triggers_get_api(String Authorization, String token,
			String uploadId) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("uploadId", uploadId).get("/imageupload/uploadstatus");
		logger.info("uploadId : " + uploadId);
		logger.info("API is triggered");
	}

	@When("user enters invalid {string} , {string} & uploadId as {string} and triggers GET API")
	public void user_enters_invalid_upload_id_as_and_triggers_get_api(String Authorization, String token,
			String uploadId) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("uploadId", uploadId).get("/imageupload/uploadstatus");
		logger.info("uploadId : " + uploadId);
		logger.info("API is triggered");
	}

	@When("user enters valid {string} , {string} & incorrect uploadId as {string} and triggers GET API")
	public void user_enters_valid_incorrect_upload_id_as_and_triggers_get_api(String Authorization, String token,
			String uploadId) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("uploadId", uploadId).get("/imageupload/uploadstatus");
		logger.info("uploadId : " + uploadId);
		logger.info("API is triggered");
	}

	@Then("Response is generated with empty file details and status code as {int}")
	public void response_is_generated_with_empty_file_details_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	@Then("Response is generated with upload file details and status code as {int}")
	public void response_is_generated_with_upload_file_details_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	@Then("Response is not generated with upload file details and status code as {int}")
	public void response_is_not_generated_with_upload_file_details_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	@Then("{string} attribute validation is performed against response messsage.")
	public void attribute_validation_is_performed_against_response_messsage(String keyValue) {
		if (keyValue.equalsIgnoreCase("updatedby")) {
			String updatedby = getJsonPath(_RESPONSE, keyValue);
			String expected_value = getJsonPath(_RESPONSE, "updatedby");
			logger.info("Updatedby : " + updatedby);
			assertEquals(expected_value, updatedby);
			logger.info("updatedby values against the response body is verified");
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
