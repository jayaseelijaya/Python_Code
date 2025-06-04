package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import utility.CommonUtils;
import utility.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateSegmentationStatusSteps_PRSAMD_2944 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UpdateSegmentationStatusSteps_PRSAMD_2944.class);

	// *********************GIVEN BLOCK*******************************
	
	@Given("the User enters the Base URL for Updating Segmentation status of patient images from the MIC cloud")
	public void the_user_enters_the_base_url_for_updating_segmentation_status_of_patient_images_from_the_mic_cloud() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("MIC_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}


	// *********************WHEN BLOCK*******************************
	
	@When("user provides a valid {string} with {string} with the valid Request body from {string} and {int} and trigger the PUT API for Updating Segmentation status of patient images from the MIC cloud")
	public void user_provides_a_valid_with_with_the_valid_request_body_from_and_and_trigger_the_put_api_for_updating_segmentation_status_of_patient_images_from_the_mic_cloud(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException   {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
					.body(payload(SheetName, RowNumber)).put("/hospitalservice/status");
		logger.info("API is triggered");
	}
	
	@When("User provides a valid {string} with {string} with Blank Request Body from {string} and {int} and trigger the PUT API for Updating Segmentation status of patient images from the MIC cloud")
	public void user_provides_a_valid_with_with_blank_request_body_from_and_and_trigger_the_put_api_for_updating_segmentation_status_of_patient_images_from_the_mic_cloud(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException  {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
					.body(payload(SheetName, RowNumber)).put("/hospitalservice/status");
		logger.info("API is triggered");
	}
	
	@When("User provides a valid {string} with {string} with Invalid Request Body from {string} and {int} and trigger the PUT API for Updating Segmentation status of patient images from the MIC cloud")
	public void user_provides_a_valid_with_with_invalid_request_body_from_and_and_trigger_the_put_api_for_updating_segmentation_status_of_patient_images_from_the_mic_cloud(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException   {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
					.body(payload(SheetName, RowNumber)).put("/hospitalservice/status");
		logger.info("API is triggered");
	}
	
	@When("User provides an invalid {string} with {string} with Valid Request body from {string} and {int} and trigger the PUT API for Updating Segmentation status of patient images from the MIC cloud")
	public void user_provides_an_invalid_with_with_valid_request_body_from_and_and_trigger_the_put_api_for_updating_segmentation_status_of_patient_images_from_the_mic_cloud(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException   {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
					.body(payload(SheetName, RowNumber)).put("/hospitalservice/status");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("a response is generated with a success status code for Updating Segmentation status of patient images from the MIC cloud")
	public void a_response_is_generated_with_a_success_status_code_for_updating_segmentation_status_of_patient_images_from_the_mic_cloud() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Status Code is displayed as : 200");
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response is generated with a failure status code for Updating Segmentation status of patient images from the MIC cloud")
	public void a_response_is_generated_with_a_failure_status_code_for_updating_segmentation_status_of_patient_images_from_the_mic_cloud() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Status Code is displayed as : 400");
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response is generated with a no data status code for Updating Segmentation status of patient images from the MIC cloud")
	public void a_response_is_generated_with_a_no_data_status_code_for_updating_segmentation_status_of_patient_images_from_the_mic_cloud() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Status Code is displayed as : 404");
		logger.info("Response body as : " + resp);
	}


	@Then("a response is generated with a unauthorised status code for Updating Segmentation status of patient images from the MIC cloud")
	public void a_response_is_generated_with_a_unauthorised_status_code_for_updating_segmentation_status_of_patient_images_from_the_mic_cloud() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Status Code is displayed as : 401");
		logger.info("Response body as : " + resp);
	}


	@Then("attribute named {string} is verified in response body for Updating Segmentation status of patient images from the MIC cloud")
	public void attribute_named_is_verified_in_response_body_for_updating_segmentation_status_of_patient_images_from_the_mic_cloud(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String responseMessage = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			
			logger.info("responseMessage is : " + expected_value);
			assertEquals(expected_value, responseMessage);
			logger.info("The attribute values against the response body is verified");
		}
			
			else {
				String errors = getJsonPath(_RESPONSE, keyValue);
				expected_value = getJsonPath(_RESPONSE, "errors");
				logger.info("Error message : " + expected_value);
				assertEquals(expected_value, errors);
				logger.info("Errors is validated against response");
			}
	}
	
	
	// *********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET*******************************
			private HashMap<String, String> payload(String SheetName, Integer RowNumber)
					throws InvalidFormatException, IOException {
				ExcelReader reader = new ExcelReader();
				List<Map<String, String>> testData = reader.getData(
						System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_2944.xlsx",
						SheetName);
				String uploadId = testData.get(RowNumber).get("uploadId");
				String status = testData.get(RowNumber).get("status");
				String note = testData.get(RowNumber).get("note");
				
				JSONObject payload = new JSONObject();
				payload.put("uploadId", uploadId);
				payload.put("status", status);
				payload.put("note", note);
				
				

				return payload;

			}
}