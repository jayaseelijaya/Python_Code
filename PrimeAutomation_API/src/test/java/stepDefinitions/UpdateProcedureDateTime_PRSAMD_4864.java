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
import java.util.UUID;

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

public class UpdateProcedureDateTime_PRSAMD_4864 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(UpdateProcedureDateTime_PRSAMD_4864.class);

	// *********************GIVEN BLOCK*******************************
	@Given("the user enters the Base URL to update procedure datetime for surgeon portal")
	public void the_user_enters_the_base_url_to_update_procedure_datetime_for_surgeon_portal() throws IOException {
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("MIC_baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);

	}
	
	
	// *********************WHEN BLOCK*******************************
	@When("user provides a valid {string} with {string} with the Request Body from {string} and {int} and trigger the PUT API to update procedure datetime for surgeon portal")
	public void user_provides_a_valid_with_with_the_request_body_from_and_and_trigger_the_put_api_to_update_procedure_datetime_for_surgeon_portal(
			String Authorization, String Token, String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		Token = passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.header("surgeonId", "98e1ea76-bd4f-4a9c-a709-6235ae2c736e")
				.body(payload(SheetName, RowNumber).toString()).put("/patient/procedure");
		logger.info("API is triggered" + _RESPONSE.asString());
	}

	@When("the user gives a Valid {string} and  {string} with Invalid global id Test Data from {string} and {int} and trigger PUT API to update procedure datetime for Surgeon Portal")
	public void the_user_gives_a_valid_and_with_invalid_global_id_test_data_from_and_and_trigger_put_api_to_update_procedure_datetime_for_surgeon_portal(
			String Authorization, String Token, String SheetName, Integer RowNumber)
			throws IOException, InvalidFormatException {
		Token = passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.header("surgeonId", "98e1ea76-bd4f-4a9c-a709-6235ae2c736e")
				.body(payload(SheetName, RowNumber).toString()).put("/patient/procedure");
		logger.info("API is triggered" + _RESPONSE.asString());
	}

	@When("the user gives a invalid {string} and  {string} with with the Request Body Test Data from {string} and {int} and trigger PUT API to update procedure datetime for Surgeon Portal")
	public void the_user_gives_a_invalid_and_with_with_the_request_body_test_data_from_and_and_trigger_put_api_to_update_procedure_datetime_for_surgeon_portal(
			String Authorization, String Token, String SheetName, Integer RowNumber)
			throws IOException, InvalidFormatException {
		Token = passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.header("surgeonId", "98e1ea76-bd4f-4a9c-a709-6235ae2c736e")
				.body(payload(SheetName, RowNumber).toString()).put("/patient/procedure");
		logger.info("API is triggered" + _RESPONSE.asString());
	}
	
	
	// *********************THEN BLOCK*******************************

	@Then("a response code is generated for update procedure date and time")
	public void a_response_code_of_is_generated_for_update_procedure_date_and_time() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(202).extract().response().asString();
		logger.info("Status code is displayed as : 202");
		logger.info("Response body as : " + resp);
	}

	@Then("attribute named {string} is verified in response body to update procedure date and time")
	public void attribute_named_is_verified_in_response_body_to_update_procedure_date_and_time(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			logger.info("responseMessage is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("responseMessage is validated against response");
		} else {
			String errors = getJsonPath(_RESPONSE, keyValue);
			System.out.print(errors);
			expected_value = getJsonPath(_RESPONSE, "errorMessage");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}

	}

	@Then("Response is generated status code and patient procedure details not found to update procedure datetime")
	public void response_is_generated_with_status_code_and_patient_procedure_details_not_found_to_update_procedure_datetime() {
		logger.info("Response is generated");
		String respinvaliddata = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Status code is displayed as : 404");
		logger.info("Response body as : " + respinvaliddata);

	}

	@Then("Response is generated status code with unauthorized message")
	public void response_is_generated_with_status_code_with_unauthorized_message() {
		logger.info("Response is generated for invalid token");
		String respinvalidtoken = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Status code is displayed as : 401");
		logger.info("Response body as : " + respinvalidtoken);

	}

	// *********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET*******************************

	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_4864.xlsx",
				SheetName);
		String globalid = testData.get(RowNumber).get("gpid");
		String date = testData.get(RowNumber).get("Date");
		String time = testData.get(RowNumber).get("Time");
		String surgeonname = testData.get(RowNumber).get("surgeonname");
		String procedureid = testData.get(RowNumber).get("procedureid");
		String camerasetupname = testData.get(RowNumber).get("camerasetupname");
		String lockstatus = testData.get(RowNumber).get("lockstatus");
		String surgeonid = testData.get(RowNumber).get("surgeonid");
		String type = testData.get(RowNumber).get("type");
		
		JSONObject payload = new JSONObject();
		payload.put("gpid", globalid);
		Map<String, Object> produceduredatetime = new LinkedHashMap<String, Object>();
		produceduredatetime.put("Date", date);
		produceduredatetime.put("Time", time);
		produceduredatetime.put("surgeonname", surgeonname);
		produceduredatetime.put("procedureid", procedureid);
		produceduredatetime.put("camerasetupname", camerasetupname);
		produceduredatetime.put("lockstatus", lockstatus);
		produceduredatetime.put("surgeonid", surgeonid);
		produceduredatetime.put("type", type);
		payload.put("procedureinfo", produceduredatetime);
		logger.info(payload);
		return payload;

	}
}
