package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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


public class SpecificViewConfigurationSteps_PRSAMD_568 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(SpecificViewConfigurationSteps_PRSAMD_568.class);
	
	// *********************GIVEN BLOCK*******************************
	@Given("User enters the Base URL for Creating Specific View Configuration")
	public void user_enters_the_base_url_for_creating_specific_view_configuration() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	    
	}
		
	// *********************WHEN BLOCK*******************************
		
	@When("User gives a valid {string} with {string} along with userFacilityId and {string} triggering the POST API")
	public void user_gives_a_valid_with_along_with_user_facility_id_and_triggering_the_post_api(String Authorization, String Token, String isFacilityWide) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(ValidCase(isFacilityWide)).post("/imageupload/viewconfig");
		logger.info("API is triggered");
		
	}
	
	@When("User provides a valid {string} & {string} and pull Test Data from {string} {int} triggering the POST API")
	public void user_provides_a_valid_and_pull_test_data_from_triggering_the_post_api( String Authorization, String Token, String SheetName,Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName,RowNumber)).post("/imageupload/viewconfig");
		logger.info("API is triggered");
	}
	
	@When("User give  a valid {string} & {string} and pull already existing Configuration Test Data from {string} {int} triggering the POST API")
	public void user_give_a_valid_and_pull_already_existing_configuration_test_data_from_triggering_the_post_api(String Authorization, String Token, String SheetName,Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName,RowNumber)).post("/imageupload/viewconfig");
		logger.info("API is triggered");
	}
	
	@When("User gives an invalid {string} with {string} along with userFacilityId and {string} triggering the POST API")
	public void user_gives_an_invalid_with_along_with_user_facility_id_and_triggering_the_post_api(String Authorization, String Token, String isFacilityWide) throws IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(ValidCase(isFacilityWide)).post("/imageupload/viewconfig");
		logger.info("API is triggered");
	}

	 
	// *********************THEN BLOCK*******************************
	
	@Then("{int} response gets generated depicting Specific View Configuration Details")
	public void response_gets_generated_depicting_specific_view_configuration_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("{int} response is generated showing the Specific View Configuration Details")
	public void response_is_generated_showing_the_specific_view_configuration_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("{int} response is getting generated showing the Specific View Configuration Details")
	public void response_is_getting_generated_showing_the_specific_view_configuration_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(409).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("{int} response must get generated depicting Specific View Configuration Details")
	public void response_must_get_generated_depicting_specific_view_configuration_details(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("{string} attribute is verified by the User")
	public void attribute_is_verified_by_the_user(String keyValue) {
		if (keyValue.equalsIgnoreCase("responseMessage")) {
			String message = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "responseMessage");
			logger.info("responseMessage is : " + expected_value);
			assertEquals(expected_value, message);
			logger.info("responseMessage is validated against response");
		} else {
			String errors = getJsonPath(_RESPONSE, keyValue);
			expected_value = getJsonPath(_RESPONSE, "errors");
			logger.info("Error message : " + expected_value);
			assertEquals(expected_value, errors);
			logger.info("Errors is validated against response");
		}
		
	}
	
	// *********************GENERATE RANDOM USER FACILITY IDs*******************************
		private static  Integer userfacilityidGenerator() {
			Random ran = new Random();
	        int nxt = ran.nextInt(99999);
	        
	        return nxt;
	  }
		
	// *********************FUNCTIONS TO PASS VALUES ***************************************
		private static String ValidCase(String isFacilityWide) {		
			String value= "{\r\n"
					+ "  \"userFacilityId\": \"" +userfacilityidGenerator()+ "\",\r\n"
					+ "  \"isFacilityWide\": \"" +isFacilityWide+ "\" \r\n"+ "}";
			
			return value;
		}
		
		
	
	// *********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
	
	
		private HashMap<String, String> payload(String SheetName, Integer RowNumber)
				throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testData = reader.getData(
					System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_PRSAMD_568.xlsx", SheetName);
			String userFacilityId = testData.get(RowNumber).get("userFacilityId");
			String isFacilityWide = testData.get(RowNumber).get("isFacilityWide");
			
			
			JSONObject payload = new JSONObject();
			payload.put("userFacilityId", userFacilityId);
			
			if(isFacilityWide =="")
			payload.put("isFacilityWide", isFacilityWide);
			else
			payload.put("isFacilityWide", Integer.parseInt(isFacilityWide));
			
			
			return payload;
		}
		
}
		
