package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.CommonUtils;
import utility.PropertiesFileReader;

public class ViewConfigSteps_PRSAMD_216 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(ViewConfigSteps_PRSAMD_216.class);

	// *********************GIVEN BLOCK*******************************
	@Given("user enters base URL")
	public void user_enters_base_url() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK*******************************
	@When("user gives valid {string} {string} {string} and trigger the Get api")
	public void user_gives_valid_and_trigger_the_get_api(String Authorization, String token, String linkedFacilityId) {
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("linkedFacilityId", linkedFacilityId).get("imageupload/viewconfig");
		logger.info("linkedFacilityId given as : " + linkedFacilityId);
		logger.info("API is triggered");
	}

	@When("user gives valid {string} {string} and invalid {string} and trigger the Get api")
	public void user_gives_valid_and_invalid_and_trigger_the_get_api(String Authorization, String token,
			String linkedFacilityId) {
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("linkedFacilityId", linkedFacilityId).get("imageupload/viewconfig");
		logger.info("linkedFacilityId given as : " + linkedFacilityId);
		logger.info("API is triggered");
	}

	@When("user gives invalid {string} {string} and valid {string} and trigger the Get api")
	public void user_gives_invalid_and_valid_and_trigger_the_get_api(String Authorization, String token,
			String linkedFacilityId) {
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("linkedFacilityId", linkedFacilityId).get("imageupload/viewconfig");
		logger.info("linkedFacilityId given as : " + linkedFacilityId);
		logger.info("API is triggered");
	}

	@When("user gives valid {string} {string} and blank {string} and trigger the Get api")
	public void user_gives_valid_and_blank_and_trigger_the_get_api(String Authorization, String token,
			String linkedFacilityId) {
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("linkedFacilityId", linkedFacilityId).get("imageupload/viewconfig");
		logger.info("linkedFacilityId given as : " + linkedFacilityId);
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	@Then("status code will be generated as {int}")
	public void status_code_will_be_generated_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("response will be generated as {int} status code")
	public void response_will_be_generated_as_status_code(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("response generated and status code as {int}")
	public void response_generated_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("response is generated and status code as {int}")
	public void response_is_generated_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("{string} value in response body gets validated")
	public void value_in_response_body_gets_validated(String keyValue) {
		if (keyValue.equalsIgnoreCase("facilityId")) {
			String facilityId = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "facilityId");
			logger.info("facilityId : " + expected_value);
			assertEquals(expected_value, facilityId);
			logger.info("facilityId is validated against response");
		} else {
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
	}
}
