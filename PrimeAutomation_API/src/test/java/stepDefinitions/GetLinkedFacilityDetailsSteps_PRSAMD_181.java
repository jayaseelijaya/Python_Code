package stepDefinitions;

import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.PropertiesFileReader;

public class GetLinkedFacilityDetailsSteps_PRSAMD_181 {
	
	RequestSpecification requestBody;
	Response responseBody;
	PropertiesFileReader configRead = new PropertiesFileReader();
	Properties configData = new Properties();
	
	final static Logger logger = Logger.getLogger(GetLinkedFacilityDetailsSteps_PRSAMD_181.class);
	
	@Given("required base url, authorization {string} {string} are available")
	public void required_base_url_authorization_are_available(String auth, String token) throws IOException {
		configData = configRead.getProperty();
		RestAssured.baseURI = configData.getProperty("baseUrl");
		requestBody = RestAssured.given().header(auth, token);
		System.out.println("Base Url, authorization tokens are available");
		logger.info("Base Url, authorization tokens are available");   
		
	}

	@When("get api is triggered to fetch linked facility details")
	public void get_api_is_triggered_to_fetch_linked_facility_details() {
	    responseBody = requestBody.get(configData.getProperty("getLinkedFacilityDetailsEndpoint"));
	    System.out.println("GET API is triggered with given request");
	    logger.info("GET API is triggered with given request");
	}
	
	@When("get api is triggered with invalid endpoint parameter to fetch linked facility details")
	public void get_api_is_triggered_with_invalid_endpoint_parameter_to_fetch_linked_facility_details() {
	    responseBody = requestBody.get(configData.getProperty("invalidPath"));
	    System.out.println("GET API is triggered with given request");
	    logger.info("GET API is triggered with given request");
	}

	@Then("verify status code {int} is returned for Get API to fetch linked facility details")
	public void verify_status_code_is_returned_for_get_api_to_fetch_linked_facility_details(Integer int1) {
	    int statusCodeValue = responseBody.getStatusCode();
	    System.out.println("HTTP Status code received is " + statusCodeValue);
	    logger.info("HTTP Status code received is " + statusCodeValue);
	    Assert.assertEquals(statusCodeValue, int1);
	}

	@Then("verify response body provides required linked facility details for logged in user")
	public void verify_response_body_provides_required_linked_facility_details_for_logged_in_user() {
	    String responseResult = responseBody.then().extract().response().asString();
	    System.out.println("Response body displayed is " + responseResult);
	    logger.info("Response body displayed is " + responseResult);
	    Assert.assertEquals(responseResult.contains(configData.getProperty("usernameField")), true);
	    Assert.assertEquals(responseResult.contains(configData.getProperty("facilityidField")), true);   
	}
	
	@Then("verify response body contains unauthorized error message with error code for Get API to fetch linked facility details")
	public void verify_response_body_contains_unauthorized_error_message_with_error_code_for_get_api_to_fetch_linked_facility_details() {
	    String responseResult = responseBody.then().extract().response().asString();
	    System.out.println("Response body displayed is " + responseResult);
	    logger.info("Response body displayed is " + responseResult);
	    Assert.assertEquals(responseResult.contains(configData.getProperty("unauthorizedErrorCode")), true);
	    Assert.assertEquals(responseResult.contains(configData.getProperty("unauthorizedErrorMessage")),true); 
	}
	
	@Then("verify response body contains not found error message for Get API to fetch linked facility details")
	public void verify_response_body_contains_not_found_error_message_for_get_api_to_fetch_linked_facility_details() {
	    String responseResult = responseBody.then().extract().response().asString();
	    System.out.println("Response body displayed is " + responseResult);
	    logger.info("Response body displayed is " + responseResult);
	    Assert.assertEquals(responseResult.contains(configData.getProperty("notfoundErrorMessage")),true); 
	}


}
