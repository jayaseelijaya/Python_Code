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

public class FacilityDetailsListSteps_PRSAMD_136 extends CommonUtils {

	RequestSpecification _RESP_SPEC;
	final static Logger logger = Logger.getLogger(FacilityDetailsListSteps_PRSAMD_136.class);
	static Response _RESPONSE;
	String resp;
	String expected_value;

	// *********************GIVEN BLOCK*******************************
	@Given("user enter base URL")
	public void user_enter_base_url() throws IOException {
		logger.info("Base_url_is_entered");
		String baseUrl = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseUrl);
		logger.info("Base_url : " + baseUrl);
		}

	// *********************WHEN BLOCK*******************************
	@When("user provides valid {string} {string} and trigger the Get api")
	public void user_provides_valid_and_trigger_the_get_api(String Authorization, String token) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.get("imageupload/facilities");
		logger.info("API got triggered");
	}

	@When("user provides invalid {string} {string} and trigger the Get api")
	public void user_provides_invalid_and_trigger_the_get_api(String Authorization, String token) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.get("imageupload/facilities");
		logger.info("API is triggered");
	}

	@When("user provides invalid {string} {string} and incorrect Url")
	public void user_provides_invalid_and_incorrect_url(String Authorization, String token) throws IOException {
		
		token=passAuthorizationToken(token);
		_RESP_SPEC.header(Authorization, token).header("Content-Type", "application/json");
		_RESPONSE = _RESP_SPEC.get("imageupload/facitis");
	}

	// *********************THEN BLOCK*******************************
	@Then("Response generated with {int} as status code")
	public void response_generated_with_as_status_code(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as :" + resp);
	}

	@Then("response will be generated with status code as {int}")
	public void response_will_be_generated_with_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as :" + resp);
	}

	@Then("response will generate and status code as {int}")
	public void response_will_generate_and_status_code_as(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
//		List<String> jsonResponse = _RESPONSE.jsonPath().getList("$");
//		logger.info("Number of records in Response body : " + jsonResponse.size());
	}

	@Then("{string} in response body gets validated")
	public void in_response_body_gets_validated(String keyValue) {
		// Validating ishospital attribute in the response body
		String status = getJsonPath(_RESPONSE, keyValue);
		expected_value = getJsonPath(_RESPONSE, "isHospital");
		assertEquals(expected_value, status);
		logger.info("isHospital attribute is validated in the Response body");
	}
}
