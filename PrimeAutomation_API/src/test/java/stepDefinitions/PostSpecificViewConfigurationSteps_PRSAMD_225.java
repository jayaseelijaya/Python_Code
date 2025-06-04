package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.PropertiesFileReader;

public class PostSpecificViewConfigurationSteps_PRSAMD_225 {
	
	RequestSpecification requestBody;
	Response responseBody;
	PropertiesFileReader configRead = new PropertiesFileReader();
	Properties configData = new Properties();
	
	final static Logger logger = Logger.getLogger(PostSpecificViewConfigurationSteps_PRSAMD_225.class);
	
	@Given("required base url, authorization {string} {string} and content type {string} {string} are available to create specific view configuration")
	public void required_base_url_authorization_and_content_type_are_available_to_create_user_specific_view_configuration(String auth, String token, String content, String type) throws IOException {
		configData = configRead.getProperty();
		RestAssured.baseURI = configData.getProperty("baseUrl");
		requestBody = RestAssured.given().header(auth, token).header(content, type);
	    logger.info("Base Url, authorization tokens are available");  
	}

	@Given("post body is available with facility ID value {int} and with isFacilityWide field set as false")
	public void post_body_is_available_with_unique_facility_ID_value_and_with_is_facility_wide_field_set_as_false(Integer facID) {
	    JSONObject jsonRequestBody = new JSONObject();
	    jsonRequestBody.put("facilityId", facID);
	    jsonRequestBody.put("isFacilityWide", 0);
	    
	    requestBody.body(jsonRequestBody.toJSONString());
	    logger.info("Json request body to post is " + jsonRequestBody.toJSONString());
	}
	
	@Given("post body is available with facility ID value {int} and with isFacilityWide field set as true")
	public void post_body_is_available_with_unique_facility_id_value_and_with_is_facility_wide_field_set_as_true(Integer facID2) {
		JSONObject jsonRequestBody = new JSONObject();
	    jsonRequestBody.put("facilityId", facID2);
	    jsonRequestBody.put("isFacilityWide", 1);
	    
	    requestBody.body(jsonRequestBody.toJSONString());
	    logger.info("Json request body to post is " + jsonRequestBody.toJSONString());   
	}
	
	@Given("post body is available with no mandatory fields")
	public void post_body_is_available_with_no_mandatory_fields() {
		JSONObject jsonRequestBody = new JSONObject();
		jsonRequestBody.put("", "");
		
		requestBody.body(jsonRequestBody.toJSONString());
	    logger.info("Json request body to post is " + jsonRequestBody.toJSONString()); 
	}
	
	@When("post api is triggered to create specific view configuration")
	public void post_api_is_triggered_to_create_user_specific_view_configuration() {
		responseBody = requestBody.post(configData.getProperty("postSpecificViewConfigurationEndpoint"));
		logger.info("Post API is triggered");
	}

	@Then("verify status code {int} is returned for Post API to create specific view configuration")
	public void verify_status_code_is_returned_for_post_api_to_create_user_specific_view_configuration(Integer int1) {
		int statusCodeResult = responseBody.getStatusCode();
	    logger.info("Status code received is " + statusCodeResult);
	    Assert.assertEquals(statusCodeResult,int1);
	}

	@Then("verify response body contains success message with success code for successful creation of view configuration")
	public void verify_response_body_contains_success_message_with_success_code_for_successful_creation_of_view_configuration() {
		String responseResult = responseBody.then().extract().response().asString();
		logger.info("Post response body received is " + responseResult);
		Assert.assertEquals(responseResult.contains(configData.getProperty("viewConfigSuccessCode")),true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("viewConfigSuccessMessage")),true);
	}
	
	@Then("verify response body contains validation error message with error code while creation of view configuration")
	public void verify_response_body_contains_validation_error_message_with_error_code_while_creation_of_view_configuration() {
		String responseResult = responseBody.then().extract().response().asString();
		logger.info("Post response body received is " + responseResult);
		Assert.assertEquals(responseResult.contains(configData.getProperty("viewConfigValidationErrorCode")),true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("viewConfigValidationErrormessage1")),true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("viewConfigValidationErrormessage2")),true);
	}
	
	@Then("verify response body contains error message with error code for configuration creation conflict")
	public void verify_response_body_contains_error_message_with_error_code_for_configuration_creation_conflict() {
		String responseResult = responseBody.then().extract().response().asString();
		logger.info("Post response body received is " + responseResult);
		Assert.assertEquals(responseResult.contains(configData.getProperty("viewConfigExistingErrorCode")),true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("viewConfigExistingErrorMessage")),true);  
	}
	
	@Then("verify response body contains error message with error code for incorrect authorization during view configuration creation")
	public void verify_response_body_contains_error_message_with_error_code_for_incorrect_authorization_during_view_configuration_creation() {
		String responseResult = responseBody.then().extract().response().asString();
		logger.info("Post response body received is " + responseResult);
		Assert.assertEquals(responseResult.contains(configData.getProperty("unauthorizedErrorCode")),true);
		Assert.assertEquals(responseResult.contains(configData.getProperty("unauthorizedErrorMessage")),true);  
	}
	
}
