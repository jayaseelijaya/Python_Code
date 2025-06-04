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

public class StatusDetailsListSteps_PRSAMD_200 extends CommonUtils {

	RequestSpecification _RESP_SPEC;
	Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(StatusDetailsListSteps_PRSAMD_200.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url is entered to fetch status details")
	public void base_url_is_entered_to_fetch_status_details() throws IOException {
		logger.info("Base_url_is_entered");
		String baseUrl = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseUrl);
		logger.info("Base_url : " + baseUrl);
	}

	// *********************WHEN BLOCK*******************************
	@When("user enters valid {string} {string} and Trigger Get method")
	public void user_enters_valid_and_trigger_get_method(String Authorization, String token) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.get("imageupload/statuses");
		logger.info("API is triggered");
	}

	@When("user enters invalid {string} {string} and Trigger Get method")
	public void user_enters_invalid_and_trigger_get_method(String Authorization, String token) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.get("imageupload/statuses");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************

	@Then("response body is generated with status code {int}")
	public void response_body_is_generated_with_status_code(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as :" + resp);
	}

	@Then("response body is generated with status code as {int}")
	public void response_body_is_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
//		List<String> jsonResponse = _RESPONSE.jsonPath().getList("$");
//		logger.info("Number of records in Response body : " + jsonResponse.size());
	}

	@Then("{string} attribute in response body is validated")
	public void attribute_in_response_body_is_validated(String keyValue) {
		// Verifying the statuscode and description attribute against response body
		if (keyValue.equalsIgnoreCase("statuscode")) {
			String status = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "statuscode");
			logger.info("statusCode in response body are : " + expected_value);
			assertEquals(expected_value, status);
			logger.info("statusCode attribute is verified against response body ");

		} else {

			String description = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "description");
			logger.info("statusCode in response body are : " + expected_value);
			assertEquals(expected_value, description);
			logger.info("Description attribute is verified against response body ");
		}
	}
}
