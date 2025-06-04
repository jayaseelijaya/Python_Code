package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.CommonUtils;
import utility.ExcelReader;

public class SavePatientSurgeonLinkingSteps_PRSAMD_2239 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(SavePatientSurgeonLinkingSteps_PRSAMD_2239.class);

	// *********************GIVEN BLOCK*******************************
	
	@Given("the user enters the Base URL for saving Patient - Surgeon linking")
	public void the_user_enters_the_base_url_for_saving_patient_surgeon_linking() 
	throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("MIC_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("a valid {string} and {string} is provided and passing valid {string} for saving Patient - Surgeon linking via. POST API")
	public void a_valid_and_is_provided_and_passing_valid_row_number_for_saving_patient_surgeon_linking_via_post_api(String Authorization, String Token, String uploadIdFolderPath) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("uploadIdFolderPath",uploadIdFolderPath)
				.post("hospitalservice/saveEPHI");
		logger.info("API is triggered");
	}
	
	@When("a valid {string} and {string} is provided and passing invalid or blank {string} for saving Patient - Surgeon linking via. POST API")
	public void a_valid_and_is_provided_and_passing_invalid_or_blank_row_number_for_saving_patient_surgeon_linking_via_post_api(String Authorization, String Token, String uploadIdFolderPath) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("uploadIdFolderPath",uploadIdFolderPath)
				.post("hospitalservice/saveEPHI");
		logger.info("API is triggered");
	}
	
	@When("an invalid {string} and {string} is provided and passing valid {string} for saving Patient - Surgeon linking via. POST API")
	public void an_invalid_and_is_provided_and_passing_valid_row_number_for_saving_patient_surgeon_linking_via_post_api(String Authorization, String Token, String uploadIdFolderPath) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("uploadIdFolderPath",uploadIdFolderPath)
				.post("hospitalservice/saveEPHI");
		logger.info("API is triggered");
	}
	
	
	//**********************THEN BLOCK*******************************
	
	@Then("a {int} response is generated for saving Patient - Surgeon linking")
	public void a_response_is_generated_for_saving_patient_surgeon_linking(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a {int} response gets generated for saving Patient - Surgeon linking")
	public void a_response_gets_generated_for_saving_patient_surgeon_linking(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a {int} response is getting generated for saving Patient - Surgeon linking")
	public void a_response_is_getting_generated_for_saving_patient_surgeon_linking(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("the attribute validation of {string} is performed against the response body for patient surgeon linking")
	public void the_attribute_validation_of_is_performed_against_the_response_body_for_patient_surgeon_linking(String KeyValue) {
		if (KeyValue.equalsIgnoreCase("responseMessage")) {
			String message = getJsonPath(_RESPONSE, KeyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			logger.info("Response Message is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("responseMessage is validated against response");
			} 
		else {
			String errors = getJsonPath(_RESPONSE, KeyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
	}
	
	
}

