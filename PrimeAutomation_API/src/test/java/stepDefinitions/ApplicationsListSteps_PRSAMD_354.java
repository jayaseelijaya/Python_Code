package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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

public class ApplicationsListSteps_PRSAMD_354 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(ApplicationsListSteps_PRSAMD_354.class);

	// *********************GIVEN BLOCK*******************************
	@Given("base url is entered to fetch application list details")
	public void base_url_is_entered_to_fetch_application_list_details() throws IOException {
		logger.info("Base_url_is_entered");
		String baseUrl = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseUrl);
		logger.info("Base_url : " + baseUrl);
	}

	// *********************WHEN BLOCK*******************************
	@When("user enters valid {string} {string} {string} {int} and trigger Get method to fetch application list")
	public void user_enters_valid_and_trigger_get_method_to_fetch_application_list(String Authorization, String Token, String SheetName, Integer RowNumber) throws IOException, InvalidFormatException {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).get("/clp/imageupload/applications");
		logger.info("API is triggered");
	}

	@When("user gives invalid {string} {string} and valid test data from  {string} {int} and trigger the Get api to fetch application list")
	public void user_gives_invalid_and_valid_test_data_from_and_trigger_the_get_api_to_fetch_application_list(String Authorization, String Token, String SheetName, Integer RowNumber) throws IOException, InvalidFormatException {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).get("/clp/imageupload/applications");
		logger.info("API is triggered");
	}
	
	@When("user enters valid {string} {string} and invalid parameters from {string} {int} and trigger Get method to fetch application list")
	public void user_enters_valid_and_invalid_parameters_from_and_trigger_get_method_to_fetch_application_list(String Authorization, String Token, String SheetName, Integer RowNumber) throws IOException, InvalidFormatException {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber)).get("/clp/imageupload/applications");
		logger.info("API is triggered");
	}
	

	// *********************THEN BLOCK*******************************
	@Then("response body generated with status code as {int} to fetch application list")
	public void response_body_generated_with_status_code_as_to_fetch_application_list(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("response message body is generated and status code as {int} to fetch application list")
	public void response_message_body_is_generated_and_status_code_as_to_fetch_application_list(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("response message body is generated with status code as {int} to fetch application list")
	public void response_message_body_is_generated_with_status_code_as_to_fetch_application_list(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	@Then("{string} attribute in response message is validated to fetch application list")
	public void attribute_in_response_message_is_validated_to_fetch_application_list(String keyValue) {
		if (keyValue.equalsIgnoreCase("ApplicationDetails")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "ApplicationDetails");
			logger.info("ApplicationDetails is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("Application Details is validated against response");
		} else {
			String errorMessage = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errorMessage");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errorMessage);
			logger.info("Errors is validated against response");
		}
	}
	
	
	// function to get the test-data from excel sheet
		private HashMap<String, String> payload(String sheetName, Integer RowNumber)
				throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testData = reader.getData(
						System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_354.xlsx",
						sheetName);
				String facilityid = testData.get(RowNumber).get("facilityid");
				String surgeonid = testData.get(RowNumber).get("surgeonid");

				JSONObject payload = new JSONObject();
				payload.put("facilityid", facilityid);
				payload.put("surgeonid", surgeonid);
				
			
				return payload;
			}
}
