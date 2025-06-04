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

public class FetchDashboardSurgeonPortalSteps_PRSAMD_3462 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchDashboardSurgeonPortalSteps_PRSAMD_3462.class);

	// *********************GIVEN BLOCK*******************************
	
	@Given("a user enters the valid URL for fetching dashboard - Surgeon Portal in MIC")
	public void a_user_enters_the_valid_url_for_fetching_dashboard_surgeon_portal_in_mic() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("MIC_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK*******************************
	
	@When("the user gives a valid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API to fetch dashboard - Surgeon Portal in MIC")
	public void the_user_gives_a_valid_and_with_valid_test_data_from_and_and_trigger_get_api_to_fetch_dashboard_surgeon_portal_in_mic(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException  {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.header("surgeonid","d5a573ad-01f5-4d68-9f5b-3dd618b3586c").queryParams(payload(SheetName, RowNumber))
				.get("/patient/procedures");
		logger.info("API is triggered");
	}
	
	@When("the user gives a valid {string} and {string} with blank Test Data from {string} and {int} and trigger GET API to fetch dashboard - Surgeon Portal in MIC")
	public void the_user_gives_a_valid_and_with_blank_test_data_from_and_and_trigger_get_api_to_fetch_dashboard_surgeon_portal_in_mic(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException  {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.header("surgeonid","d5a573ad-01f5-4d68-9f5b-3dd618b3586c").queryParams(payload(SheetName, RowNumber))
				.get("/patient/procedures");
		logger.info("API is triggered");
	}

	@When("the user gives a valid {string} and {string} with invalid  Test Data from {string} and {int} and trigger GET API to fetch dashboard - Surgeon Portal in MIC")
	public void the_user_gives_a_valid_and_with_invalid_test_data_from_and_and_trigger_get_api_to_fetch_dashboard_surgeon_portal_in_mic(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException  {
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.header("surgeonid","d5a573ad-01f5-4d68-9f5b-3dd618b3586c").queryParams(payload(SheetName, RowNumber))
				.get("/patient/procedures");
		logger.info("API is triggered");
	}

	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code for fetching dashboard - Surgeon Portal in MIC")
	public void response_is_generated_with_success_status_code_for_fetching_dashboard_surgeon_portal_in_mic() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Status Code is displayed as : 200");
		logger.info("Response body as : " + resp);
	}

	
	@Then("the attribute {string} is validated for fetching dashboard - Surgeon Portal in MIC")
	public void the_attribute_is_validated_for_fetching_dashboard_surgeon_portal_in_mic(String KeyValue) {
		if (KeyValue.equalsIgnoreCase("patientname")) {
			String patientname = getJsonPath(_RESPONSE, KeyValue);
			String patientdob = getJsonPath(_RESPONSE, "patientdob");
			String patientfirstname = getJsonPath(_RESPONSE, "patientfirstname");
			String patientlastname = getJsonPath(_RESPONSE, "patientlastname");
			String caseid = getJsonPath(_RESPONSE, "caseid");
			String mrnid = getJsonPath(_RESPONSE, "mrnid");
			
			expected_value = getJsonPath(_RESPONSE, "patientname");
			
			logger.info("patientname is : " + expected_value);
			logger.info("patientdob is : " + patientdob);
			logger.info("patientfirstname is : " + patientfirstname);
			logger.info("patientlastname is : " + patientlastname);
			logger.info("caseid is : " + caseid);
			logger.info("mrnid is : " + mrnid);
			
			assertEquals(expected_value, patientname);
			logger.info("The attribute values against the response body is verified");
		}
			
			else {
				String errors = getJsonPath(_RESPONSE, KeyValue);
				expected_value = getJsonPath(_RESPONSE, "errorMessage");
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
						System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_3462.xlsx",
						SheetName);
				String pageno = testData.get(RowNumber).get("pageno");
				String column = testData.get(RowNumber).get("column");
				String sortorder = testData.get(RowNumber).get("sortorder");
				String searchstring = testData.get(RowNumber).get("searchstring");
				

				JSONObject payload = new JSONObject();
				payload.put("pageno", pageno);
				payload.put("column", column);
				payload.put("sortorder", sortorder);
				payload.put("searchstring", searchstring);
				

				return payload;

			}
}