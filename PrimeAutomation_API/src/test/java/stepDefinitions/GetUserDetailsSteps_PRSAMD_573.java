package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.PropertiesFileReader;

public class GetUserDetailsSteps_PRSAMD_573 {
	RequestSpecification requestBody;
	Response responseBody;
	Properties configData = new Properties();
	PropertiesFileReader configRead = new PropertiesFileReader();
	
	final static Logger logger = Logger.getLogger(GetUserDetailsSteps_PRSAMD_573.class);

	@Given("base url, authorization tokens {string} {string} and request parameter username {string} {string} are available")
	public void base_url_authorization_tokens_and_request_parameter_username_are_available(String auth, String token, String param, String value) throws IOException {
		configData = configRead.getProperty();
		RestAssured.baseURI = configData.getProperty("baseUrl");
		requestBody = RestAssured.given().header(auth, token).queryParam(param, value);
		logger.info("Base url, authorization tokens and request parameter value are available"); 
	}

	@When("get api is triggered to fetch logged in user details")
	public void get_api_is_triggered_to_fetch_logged_in_user_details() {
		responseBody = requestBody.get(configData.getProperty("getUserDetailsEndpoint"));
		logger.info("Get Api is triggered with request url"); 
	}

	@Then("http status code {int} is received when logged in user details is fetched")
	public void http_status_code_is_received_when_logged_in_user_details_is_fetched(Integer expectedStatus) {
		int observedStatus = responseBody.getStatusCode();
		logger.info("Http status code received is: " + observedStatus);
		Assert.assertEquals(observedStatus, expectedStatus);   
	}

	@Then("response body contains all the required parameters for the fetched logged in user")
	public void response_body_contains_all_the_required_parameters_for_the_fetched_logged_in_user() {
		String observedResponse = responseBody.then().extract().response().asString();
		logger.info("Response body received is: " + observedResponse);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("usernameField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("preferredUserNameField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("userRoleField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("adminField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("createdByField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("updatedByField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("userStatusField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("createdDateField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("updatedDateField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("userfirstNameField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("userlastNameField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("userEmailField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("userPhoneField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("profileImageUrlField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("linkedFacilityIdField")), true);
		Assert.assertEquals(observedResponse.contains(configData.getProperty("linkedFacilityNameField")), true);
	}
	
	@Then("verify response body contains unauthorized error message with error code when get API is triggered to fetch logged in user details")
	public void verify_response_body_contains_unauthorized_error_message_with_error_code_when_get_api_is_triggered_to_fetch_logged_in_user_details() {
	    String observedResponse = responseBody.then().extract().response().asString();
	    logger.info("Response body received is: " + observedResponse);
	    Assert.assertEquals(observedResponse.contains(configData.getProperty("unauthorizedErrorCode")), true);
	    Assert.assertEquals(observedResponse.contains(configData.getProperty("unauthorizedErrorMessage")), true);
	}


}
