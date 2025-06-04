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

public class SurgeonDetailsSteps_PRSAMD_36 extends CommonUtils {

	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(SurgeonDetailsSteps_PRSAMD_36.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url entered")
	public void base_url_is_entered() throws IOException {
		logger.info("Base_url_is_entered");
		String baseUrl = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseUrl);
		logger.info("Base_url : " + baseUrl);
	}

	// *********************WHEN BLOCK *******************************
	@When("user enter valid {string} {string} and trigger the Get api")
	public void user_enters_valid_and_trigger_the_get_api(String Authorization, String token) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("facilityid", "1").get("imageupload/surgeons");
		logger.info("API is triggered");
	}

	@When("user entered invalid {string} {string} and trigger the Get api")
	public void user_enters_invalid_and_trigger_the_get_api(String Authorization, String token) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.queryParam("facilityid", "3").get("imageupload/surgeons");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	@Then("response is generated with status code {int}")
	public void response_is_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
//		List<String> jsonResponse = _RESPONSE.jsonPath().getList("$");
//		logger.info("Number of records in Response body : " + jsonResponse.size());
	}

	@Then("response generated with status code {int}")
	public void response_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	@Then("{string} in response body validated")
	public void in_response_body_is_validated(String keyValue) {
		// Verifying the user status against response body
		if (keyValue.equalsIgnoreCase("userStatus")) {
			String status = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "userStatus");
			assertEquals(expected_value, status);
		} else {
			// Verifying the facilityName against response body
			String facility_name = getJsonPath(_RESPONSE, "facilityName");
			expected_value = getJsonPath(_RESPONSE, "facilityName");
			assertEquals(expected_value, facility_name);
		}
	}
}
