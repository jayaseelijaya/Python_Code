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


public class FetchFacilityDetailsSteps_PRSAMD_1431 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(FetchFacilityDetailsSteps_PRSAMD_1431.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the User enters the Base URL to fetch facility details")
	public void the_user_enters_the_base_url_to_fetch_facility_details() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("user provides a valid {string} with {string} with the Request Body from {string} and {int} and trigger the POST API to fetch facility details")
	public void user_provides_a_valid_with_with_the_request_body_from_and_and_trigger_the_post_api_to_fetch_facility_details(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload (SheetName,RowNumber)).post("/imageupload/facility");
		logger.info("API is triggered");
		
	}
	
	@When("user provides an invalid {string} with {string} with the valid Request Body from {string} and {int} and trigger the POST API to fetch facility details")
	public void user_provides_an_invalid_with_with_the_valid_request_body_from_and_and_trigger_the_post_api_to_fetch_facility_details(String Authorization, String Token, String SheetName , Integer RowNumber) 
			throws InvalidFormatException, IOException {
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload (SheetName,RowNumber)).post("/imageupload/facility");
		logger.info("API is triggered");
		
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("a response code of {int} is generated fetching the facility details")
	public void a_response_code_of_is_generated_fetching_the_facility_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a response code of {int} is being generated fetching the facility details")
	public void a_response_code_of_is_being_generated_fetching_the_facility_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		logger.info("Response body as : " + resp);
	}

	@Then("attribute named {string} is verified in response body to fetch facility details.")
	public void attribute_named_is_verified_in_response_body_to_fetch_facility_details(String keyValue) {
		if (keyValue.equalsIgnoreCase("facilityId")) {
			String facilityId = getJsonPath(_RESPONSE, keyValue);
			String facilityName = getJsonPath(_RESPONSE, "facilityName");
			String facilityEmail = getJsonPath(_RESPONSE, "facilityEmail");
			String address = getJsonPath(_RESPONSE, "address");
			String zipCode = getJsonPath(_RESPONSE, "zipCode");
			String facilityImageUrl = getJsonPath(_RESPONSE, "facilityImageUrl");
			
			expected_value = getJsonPath(_RESPONSE, "facilityId");
			
			logger.info("facilityId is : " + expected_value);
			logger.info("facilityName is : " + facilityName);
			logger.info("facilityEmail is : " + facilityEmail);
			logger.info("address is : " + address);
			logger.info("zipCode is : " + zipCode);
			logger.info("facilityImageUrl is : " + facilityImageUrl);
			
			assertEquals(expected_value, facilityId);
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
	
	// function to get the test-data from excel sheet
			private HashMap<String, String> payload(String sheetName, Integer RowNumber)
					throws InvalidFormatException, IOException {
				ExcelReader reader = new ExcelReader();
				List<Map<String, String>> testData = reader.getData(
						System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_1431.xlsx",
						sheetName);
				String facilityIds = testData.get(RowNumber).get("facilityIds");
				
	//***********Convert The String format to List of Integers format***********************
				List<Integer> MyList=new ArrayList<Integer>();
				  for(String id:facilityIds.split(","))
					  MyList.add(Integer.parseInt(id));
				
				JSONObject payload = new JSONObject();
				payload.put("facilityIds", MyList);
			
				return payload;
			}
	
}
