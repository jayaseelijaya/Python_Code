package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import utility.CommonUtils;
import utility.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FetchProcedureDetailsSteps_PRSAMD_3133 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchProcedureDetailsSteps_PRSAMD_3133.class);

	// *********************GIVEN BLOCK*******************************

	@Given("a user enters the valid URL for fetching procedure details for Surgeon Portal")
	public void a_user_enters_the_valid_url_for_fetching_procedure_details_for_surgeon_portal() throws IOException {

		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("MIC_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}

	// *********************WHEN BLOCK*******************************
	@When("the user gives a valid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API to fetch procedure details for Surgeon Portal")
	public void the_user_gives_a_valid_and_with_valid_test_data_from_and_and_trigger_get_api_to_fetch_procedure_details_for_surgeon_portal(
			String Authorization, String Token, String SheetName, Integer RowNumber)
			throws IOException, InvalidFormatException {
		String  caseid = payload(SheetName, RowNumber);
		String globalid = caseid.substring(6);
		String cardid = caseid.substring(0,6);
		Token = passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.header("surgeonid", "d5a573ad-01f5-4d68-9f5b-3dd618b3586c")
				.header("lambda", "#1234lambd@_tr1gger4321#")
				.get("/patient/procedure/"+globalid+"/"+caseid);
		logger.info("API is triggered");
	}

	

	@Then("the attribute {string} is validated for fetching procedure details for Surgeon Portal")
	public void the_attribute_is_validated_for_fetching_procedure_details_for_surgeon_portal(String KeyValue) {
		if (KeyValue.equalsIgnoreCase("patientprocedureid")) { 
			String proId = getJsonPath(_RESPONSE, KeyValue);
			String patientprocedureid = getJsonPath(_RESPONSE, "patientprocedureid");
			expected_value = getJsonPath(_RESPONSE, "patientprocedureid");

			logger.info("caseId is : " + expected_value);
			logger.info("patientprocedureid is : " + patientprocedureid);
			assertEquals(expected_value, proId);
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
	
	@When("the user gives an invalid {string} and {string} with valid Test Data from {string} and {int} and trigger GET API to fetch procedure details for Surgeon Portal")
	public void the_user_gives_an_invalid_and_with_valid_test_data_from_and_and_trigger_get_api_to_fetch_procedure_details_for_surgeon_portal(String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		String  caseid = payload(SheetName, RowNumber);
		String globalid = caseid.substring(6);
		String cardid = caseid.substring(0,6);
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.header("surgeonid", "d5a573ad-01f5-4d68-9f5b-3dd618b3586c")
				.header("lambda", "")
				.get("/patient/procedure/"+globalid+"/"+caseid);
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code for fetching procedure details for Surgeon Portal")
	public void response_is_generated_with_success_status_code_for_fetching_procedure_details_for_Surgeon_portal() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code for fetching procedure details for Surgeon Portal")
	public void response_is_generated_with_unauthorized_status_code_for_fetching_procedure_details_for_surgeon_portal1() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + _RESPONSE.getStatusCode());
	}
	private String payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_3133.xlsx",
				SheetName);
		logger.info("Response body as : " + testData);
		String caseId = testData.get(RowNumber).get("caseId");
		String Globalid = testData.get(RowNumber).get("Globalid");
		return caseId + Globalid;
	}
	

}