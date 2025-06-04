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

public class UpdatePatientInformationMICSteps_PRSAMD_5205 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UpdatePatientInformationMICSteps_PRSAMD_5205.class);

	// *********************GIVEN BLOCK*******************************
	
	@Given("a user enters the valid URL for updating patient information in MIC surgeon portal")
	public void a_user_enters_the_valid_url_for_updating_patient_information_in_mic_surgeon_portal() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("MIC_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}


	// *********************WHEN BLOCK*******************************
	
	@When("the user gives a valid {string} and {string} with valid Test Data from {string} and {int} and trigger PUT API to update patient information in MIC surgeon portal")
	public void the_user_gives_a_valid_and_with_valid_test_data_from_and_and_trigger_put_api_to_update_patient_information_in_mic_surgeon_portal(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException  {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
					.body(payload(SheetName, RowNumber)).put("/patient/patientinfo");
		logger.info("API is triggered");
	}
	
	@When("the user gives a valid {string} and {string} with a blank patientId Test Data from {string} and {int} and trigger PUT API to update patient information in MIC surgeon portal")
	public void the_user_gives_a_valid_and_with_a_blank_patient_id_test_data_from_and_and_trigger_put_api_to_update_patient_information_in_mic_surgeon_portal(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException  {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
					.body(payload(SheetName, RowNumber)).put("/patient/patientinfo");
		logger.info("API is triggered");
	}

	@When("the user gives a valid {string} and {string} with an invalid patientId Test Data from {string} and {int} and trigger PUT API to update patient information in MIC surgeon portal")
	public void the_user_gives_a_valid_and_with_an_invalid_patient_id_test_data_from_and_and_trigger_put_api_to_update_patient_information_in_mic_surgeon_portal(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException  {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
					.body(payload(SheetName, RowNumber)).put("/patient/patientinfo");
		logger.info("API is triggered");
	}

	@When("the user gives a valid {string} and {string} with no details of patient Test Data from {string} and {int} and trigger PUT API to update patient information in MIC surgeon portal")
	public void the_user_gives_a_valid_and_with_no_details_of_patient_test_data_from_and_and_trigger_put_api_to_update_patient_information_in_mic_surgeon_portal(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException  {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
					.body(payload(SheetName, RowNumber)).put("/patient/patientinfo");
		logger.info("API is triggered");
	}

	@When("the user gives a invalid {string} and {string} with valid mandatory Test Data from {string} and {int} and trigger PUT API to update patient information in MIC surgeon portal")
	public void the_user_gives_a_invalid_and_with_valid_mandatory_test_data_from_and_and_trigger_put_api_to_update_patient_information_in_mic_surgeon_portal(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException  {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
					.body(payload(SheetName, RowNumber)).put("/patient/patientinfo");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code for updating patient information in MIC surgeon portal")
	public void response_is_generated_with_success_status_code_for_updating_patient_information_in_mic_surgeon_portal() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Status Code is displayed as : 200");
		logger.info("Response body as : " + resp);
	}

	@Then("Response is generated with faliure status code for updating patient information in MIC surgeon portal")
	public void response_is_generated_with_faliure_status_code_for_updating_patient_information_in_mic_surgeon_portal() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		logger.info("Status Code is displayed as : 400");
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorised status code for updating patient information in MIC surgeon portal")
	public void response_is_generated_with_unauthorised_status_code_for_updating_patient_information_in_mic_surgeon_portal() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Status Code is displayed as : 401");
		logger.info("Response body as : " + resp);
	}
	
	@Then("the attribute {string} is validated for updating patient information in MIC surgeon portal")
	public void the_attribute_is_validated_for_updating_patient_information_in_mic_surgeon_portal(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String responseMessage = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			
			logger.info("responseMessage is : " + expected_value);
			assertEquals(expected_value, responseMessage);
			logger.info("The attribute values against the response body is verified");
		}
			
			else {
				String errorMessage = getJsonPath(_RESPONSE, keyValue);
				expected_value = getJsonPath(_RESPONSE, "errorMessage");
				logger.info("Error message : " + expected_value);
				assertEquals(expected_value, errorMessage);
				logger.info("Errors is validated against response");
			}
	}
	
	
	
	// *********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET*******************************
			private HashMap<String, String> payload(String SheetName, Integer RowNumber)
					throws InvalidFormatException, IOException {
				ExcelReader reader = new ExcelReader();
				List<Map<String, String>> testData = reader.getData(
						System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_5205.xlsx",
						SheetName);
				String patientid = testData.get(RowNumber).get("patientid");
				String firstname = testData.get(RowNumber).get("firstname");
				String lastname = testData.get(RowNumber).get("lastname");
				String gender = testData.get(RowNumber).get("gender");
				String mrnid = testData.get(RowNumber).get("mrnid");
				String dob = testData.get(RowNumber).get("dob");
				String note = testData.get(RowNumber).get("note");
				
				JSONObject payload = new JSONObject();
				payload.put("patientid", patientid);
				payload.put("firstname", firstname);
				payload.put("lastname", lastname);
				payload.put("gender", gender);
				payload.put("mrnid", mrnid);
				payload.put("dob", dob);
				payload.put("note", note);
				
			
				return payload;

			}
}