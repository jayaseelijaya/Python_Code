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


public class FetchLinkedUnlinkedFacilitiesSteps_PRSAMD_2169 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchLinkedUnlinkedFacilitiesSteps_PRSAMD_2169.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the user enters the Base URL for fetching linked and optionally unlinked Facilities")
	public void the_user_enters_the_base_url_for_fetching_linked_and_optionally_unlinked_facilities() 
				throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL); 
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("a valid {string} and {string} is provided extracting Test data form {string} {int} for fetching linked and optionally unlinked facilities via. GET API")
	public void a_valid_and_is_provided_extracting_test_data_form_for_fetching_linked_and_optionally_unlinked_facilities_via_get_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/facilitylinking");
		logger.info("API is triggered");
	}
	
	@When("an invalid {string} and {string} is provided extracting Test data form {string} {int} for fetching linked and optionally unlinked facilities via. GET API")
	public void an_invalid_and_is_provided_extracting_test_data_form_for_fetching_linked_and_optionally_unlinked_facilities_via_get_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.queryParams(payload(SheetName, RowNumber)).get("/imageupload/facilitylinking");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("a {int} response is generated for Fetching linked and optionally unlinked Facilities")
	public void a_response_is_generated_for_fetching_linked_and_optionally_unlinked_facilities(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("a {int} response is being generated for Fetching linked and optionally unlinked Facilities")
	public void a_response_is_being_generated_for_fetching_linked_and_optionally_unlinked_facilities(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("the attribute validation of {string} is performed against the response body for facilities list fetching")
	public void the_attribute_validation_of_is_performed_against_the_response_body_for_facilities_list_fetching(String keyValue) {
		if (keyValue.equalsIgnoreCase("facilityLinkingResponses")) {
			String facilityLinkingResponses = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "facilityLinkingResponses");
			
			assertEquals(expected_value, facilityLinkingResponses);
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
	
//	*********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
	private HashMap<String, String> payload(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_2169.xlsx", SheetName);
		String linkedFacilityId = testData.get(RowNumber).get("linkedFacilityId");
		String isUnion = testData.get(RowNumber).get("isUnion");
		String page = testData.get(RowNumber).get("page");
		String limit = testData.get(RowNumber).get("limit");
		String isFileUpload = testData.get(RowNumber).get("isFileUpload");
		String searchText = testData.get(RowNumber).get("searchText");
		
		
		JSONObject payload = new JSONObject();
		
		payload.put("linkedFacilityId", linkedFacilityId);
		payload.put("isUnion", isUnion);
		payload.put("page", page);
		payload.put("limit", limit);
		payload.put("isFileUpload", isFileUpload);
		payload.put("searchText", searchText);
		
		return payload;
	
	}

	
	

}
