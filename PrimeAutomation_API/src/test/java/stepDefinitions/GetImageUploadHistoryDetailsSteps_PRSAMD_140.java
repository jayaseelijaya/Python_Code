package stepDefinitions;

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

public class GetImageUploadHistoryDetailsSteps_PRSAMD_140 {
	
	RequestSpecification requestBody;
	Response responseBody;
	PropertiesFileReader configRead = new PropertiesFileReader();
	Properties configData = new Properties();
	
	final static Logger logger = Logger.getLogger(GetImageUploadHistoryDetailsSteps_PRSAMD_140.class);
	
	@Given("required base url, authorization {string} {string} and required Facility ID parameter {string} {string} are available")
	public void required_base_url_authorization_and_required_FacilityID_parameter_are_available(String auth, String token, String param, String value) throws IOException {
		configData = configRead.getProperty();
		RestAssured.baseURI = configData.getProperty("baseUrl");
		requestBody = RestAssured.given().header(auth, token).queryParam(param, value);
		System.out.println("Base Url, authorization tokens and required query parameter are available");
		logger.info("Base Url, authorization tokens and required query parameter are available");
	}

	@When("get api is triggered to fetch image upload history details")
	public void get_api_is_triggered_to_fetch_image_upload_history_details() {
		responseBody = requestBody.get(configData.getProperty("getImageUploadHistoryDetailsEndpoint"));
		System.out.println("Get API is triggered"); 
		logger.info("Get API is triggered");
	}

	@Then("verify status code {int} is returned for Get API to fetch image upload history details")
	public void verify_success_status_code_is_returned_for_get_api_to_fetch_image_upload_history_details(Integer int1) {
		int statusCodeResult = responseBody.getStatusCode();
	    System.out.println("Status code received is " + statusCodeResult);
	    logger.info("Status code received is " + statusCodeResult);
	    Assert.assertEquals(statusCodeResult,int1);
	}

	@Then("verify response body contains all required history details with required specific response")
	public void verify_response_body_contains_all_required_history_details_with_facility_specific_response() {
		String responseResult = responseBody.then().extract().response().asString();
		System.out.println("Get response body received is " + responseResult);
		logger.info("Get response body received is " + responseResult);
		Assert.assertEquals(responseResult.contains(configData.getProperty("dateField")), true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("uuidField")), true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("patientField")), true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("createdField")), true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("surgeonField")), true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("facilityField")), true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("uploadField")), true);
			//need to implement validation for facility or user specific response, ET time zone, pagination & sorting
	}
	
	@Then("verify response body contains unauthorized error message with error code for Get API to fetch image upload history details")
	public void verify_response_body_contains_unauthorized_error_message_with_error_code() {
		String responseResult = responseBody.then().extract().response().asString();
		System.out.println("Get response body received is " + responseResult);
		logger.info("Get response body received is " + responseResult);
		Assert.assertEquals(responseResult.contains(configData.getProperty("unauthorizedErrorCode")),true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("unauthorizedErrorMessage")),true); 
	    
	}

}
