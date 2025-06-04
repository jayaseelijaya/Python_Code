package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.CommonUtils;
import utility.PropertiesFileReader;

public class FacilityDetailsSteps_PRSAMD_35 extends CommonUtils {

	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FacilityDetailsSteps_PRSAMD_35.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url is entered")
	public void base_url_is_entered() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK*******************************
	@When("user enters valid {string} {string} and trigger the Get api")
	public void user_enters_valid_and_trigger_the_get_api(String Authorization, String token) throws IOException {
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.get("imageupload/facilities");
		logger.info("API is triggered");
	}

	@When("user enters invalid {string} {string} and trigger the Get api")
	public void user_enters_invalid_and_trigger_the_get_api(String Authorization, String token) throws IOException {
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.get("imageupload/facilities");
		logger.info("API is triggered");
	}

	@When("user enters invalid {string} {string} and incorrect Url")
	public void user_enters_invalid_and_incorrect_url(String Authorization, String token) {
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.get("imageupload/facilitiesssss");
	}

	// *********************THEN BLOCK*******************************

	@Then("response is generated with status code as {int}")
	public void response_is_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
		List<String> jsonResponse = _RESPONSE.jsonPath().getList("$");
		logger.info("Number of records in Response body : " + jsonResponse.size());
	}

	@Then("response generated with status code as {int}")
	public void response_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as :" + resp);
	}

	@Then("Response generated with status code as {int}")
	public void Response_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as :" + resp);
	}

	@Then("{string} in response body is validated")
	public void in_response_body_is_validated(String keyValue) {
		// Verifying the status against response body
		if (keyValue.equalsIgnoreCase("status")) {
			String status = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "status");
			System.out.println(status);
			System.out.println(expected_value);
			assertEquals(expected_value, status);
		} else {
			// Verifying the facilityId and isHospital against response body
			String facility_id = getJsonPath(_RESPONSE, "facilityId");
			expected_value = getJsonPath(_RESPONSE, "facilityId");
			// String isHospital = getJsonPath(_RESPONSE, "isHospital");
			assertEquals(expected_value, facility_id);
			// assertTrue(resp.contains(isHospital));
		}
	}
}