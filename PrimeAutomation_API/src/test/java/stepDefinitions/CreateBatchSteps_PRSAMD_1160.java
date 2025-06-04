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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateBatchSteps_PRSAMD_1160 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(CreateBatchSteps_PRSAMD_1160.class);

	// *********************GIVEN BLOCK*******************************
	@Given("Base URL is entered to create batch")
	public void base_url_is_entered_to_create_batch() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK*******************************
	@When("user enters valid {string} & {string} and trigger the POST API")
	public void user_enters_valid_and_trigger_the_post_api(String Authorization, String token) {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json").body(ValidCase())
				.post("/imageupload/batch");
		logger.info("API is triggered");
	}

	@When("user enters valid {string} & {string} & already present {string} and trigger the POST API")
	public void user_enters_valid_already_present_and_trigger_the_post_api(String Authorization, String token,
			String batchId) {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(AlreadyPresent(batchId)).post("/imageupload/batch");
		logger.info("API is triggered");
		logger.info("Batch ID given as :" + batchId);
	}

	@When("user enters valid {string} & {string} with invalid Request body and trigger the POST API")
	public void user_enters_valid_with_invalid_request_body_and_trigger_the_post_api(String Authorization,
			String token) {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json")
				.body(InvalidParams()).post("/imageupload/batch");
		logger.info("API is triggered");

	}

	@When("user enters invalid {string} & {string} and trigger the POST API")
	public void user_enters_invalid_and_trigger_the_post_api(String Authorization, String token) {
		_RESPONSE = _RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json").body(ValidCase())
				.post("/imageupload/batch");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	@Then("the response body gets generated with create batch success message and status code {int}")
	public void the_response_body_gets_generated_with_create_batch_success_message_and_status_code(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("the response body will generate with create batch error message and status code {int}")
	public void the_response_body_will_generate_with_create_batch_error_message_and_status_code(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("the response body generate the create batch error message with status code {int}")
	public void the_response_body_generate_the_create_batch_error_message_with_status_code(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("attribute validation of {string} is verified")
	public void attribute_validation_of_is_verified(String keyValue) {
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

	// *********************GENERATE RANDOM BATCH IDs*******************************
	private static String BatchGenerate() {
		String uuid = UUID.randomUUID().toString();
		System.out.print("Batch ID is : " + uuid);
		return uuid;
	}

	// *********************FUNCTIONS TO PASS VALUES *******************************
	private static String ValidCase() {
		String value = "{\r\n" + "\"batchId\" : \"" + BatchGenerate() + "\",\r\n" + "\"expectedFileCount\" : 1,\r\n"
				+ "\"batchSizeKB\" : 512,\r\n" + "\"sourceFacilityId\" :1,\r\n"
				+ "\"sourceFacilityName\" : \"Demo Test\",\r\n"
				+ "\"sourceFacilityContactLead\":\"Source Contact Lead\",\r\n"
				+ "\"sourceFacilityEmail\":\"sncloudsupport-ic-test@capgemini.com\",\r\n"
				+ "\"sourceFacilityPhone\":\"8978675645\",\r\n" + "\"targetFacilityId\" : 1,\r\n"
				+ "\"targetFacilityName\" : \"Client Demo\",\r\n"
				+ "\"targetFacilityContactLead\":\"Target Contact Lead\",\r\n"
				+ "\"targetFacilityPhone\":\"9087654321\",\r\n"
				+ "\"targetFacilityEmail\":\"ic-test-snhilmanager@capgemini.com\",\r\n" + "\"surgeonId\" :\"1001\",\r\n"
				+ "\"surgeonFirstName\" :\"Dr.Test\",\r\n" + "\"surgeonLastName\" :\"Code\",\r\n"
				+ "\"applicationId\" : 1,\r\n" + "\"applicationName\" : \"Prime\",\r\n"
				+ "\"uploaderId\" : \"ic-test-admin@capgemini.com\",\r\n"
				+ "\"uploaderFirstName\" : \"DR.Uploader\",\r\n" + "\"uploaderLastName\"  :\"Batch\"\r\n" + "}";
		return value;
	}

	private static String InvalidParams() {
		String value = "{\r\n" + "\"batchId\" : \"" + BatchGenerate() + "\",\r\n" + "\"expectedFileCount\" : \"1\",\r\n"
				+ "\"batchSizeKB\" : 512,\r\n" + "\"sourceFacilityId\" :1,\r\n" + "\"sourceFacilityName\" : \"\",\r\n"
				+ "\"sourceFacilityContactLead\":\"Source Contact Lead\",\r\n"
				+ "\"sourceFacilityEmail\":\"sncloudsupport-ic-test@capgemini.com\",\r\n"
				+ "\"sourceFacilityPhone\":\"8978675645\",\r\n" + "\"targetFacilityId\" : 1,\r\n"
				+ "\"targetFacilityName\" : \"\",\r\n" + "\"targetFacilityContactLead\":\"\",\r\n"
				+ "\"targetFacilityPhone\":\"\",\r\n" + "\"targetFacilityEmail\":\"\",\r\n" + "\"surgeonId\" :\"\",\r\n"
				+ "\"surgeonFirstName\" :\"Dr.Test\",\r\n" + "\"surgeonLastName\" :\"\",\r\n"
				+ "\"applicationId\" : 1,\r\n" + "\"applicationName\" : \"\",\r\n" + "\"uploaderId\" : \"\",\r\n"
				+ "\"uploaderFirstName\" : \"\",\r\n" + "\"uploaderLastName\"  :\"\"\r\n" + "}";
		return value;
	}

	private static String AlreadyPresent(String batchId) {
		String value = "{\r\n" + "\"batchId\" : \"" + batchId + "\",\r\n" + "\"expectedFileCount\" : 1,\r\n"
				+ "\"batchSizeKB\" : 512,\r\n" + "\"sourceFacilityId\" :1,\r\n"
				+ "\"sourceFacilityName\" : \"Demo Test\",\r\n"
				+ "\"sourceFacilityContactLead\":\"Source Contact Lead\",\r\n"
				+ "\"sourceFacilityEmail\":\"sncloudsupport-ic-test@capgemini.com\",\r\n"
				+ "\"sourceFacilityPhone\":\"8978675645\",\r\n" + "\"targetFacilityId\" : 1,\r\n"
				+ "\"targetFacilityName\" : \"Client Demo\",\r\n"
				+ "\"targetFacilityContactLead\":\"Target Contact Lead\",\r\n"
				+ "\"targetFacilityPhone\":\"9087654321\",\r\n"
				+ "\"targetFacilityEmail\":\"ic-test-snhilmanager@capgemini.com\",\r\n" + "\"surgeonId\" :\"1001\",\r\n"
				+ "\"surgeonFirstName\" :\"Dr.Test\",\r\n" + "\"surgeonLastName\" :\"Code\",\r\n"
				+ "\"applicationId\" : 1,\r\n" + "\"applicationName\" : \"Prime\",\r\n"
				+ "\"uploaderId\" : \"ic-test-admin@capgemini.com\",\r\n"
				+ "\"uploaderFirstName\" : \"DR.Uploader\",\r\n" + "\"uploaderLastName\"  :\"Batch\"\r\n" + "}";
		return value;
	}

}