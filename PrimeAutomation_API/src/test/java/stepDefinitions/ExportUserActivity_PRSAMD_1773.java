package stepDefinitions;

import java.util.Scanner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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
import io.cucumber.core.internal.com.fasterxml.jackson.core.exc.StreamWriteException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.DatabindException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.MappingIterator;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.SerializationFeature;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.Converter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ExportUserActivity_PRSAMD_1773 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	static Response _RESPONSE;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(ExportUserActivity_PRSAMD_1773.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("User enters a valid URL for exporting list of user activities")
	public void user_enters_a_valid_url_for_exporting_list_of_user_activities() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("User gives a valid {string} and {string} and extract valid data from excel {string} and {int} for exporting list of User Activities and triggers the POST API")
	public void user_gives_a_valid_and_and_extract_valid_data_from_excel_and_for_exporting_list_of_user_activities_and_triggers_the_post_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload (SheetName,RowNumber)).post("imageupload/exportlog");
		logger.info("API is triggered");
	}
	
	@When("User provides a valid {string} and {string} and extract invalid userFacilityId data from excel {string} and {int} for exporting list of User Activities and triggers the POST API")
	public void user_provides_a_valid_and_and_extract_invalid_user_facility_id_data_from_excel_and_for_exporting_list_of_user_activities_and_triggers_the_post_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload (SheetName,RowNumber)).post("imageupload/exportlog");
		logger.info("API is triggered");
	}
	
	
	@When("User provides an invalid {string} and {string} and extract valid data from excel {string} and {int} for exporting list of User Activities and triggers the POST API")
	public void user_provides_an_invalid_and_and_extract_valid_data_from_excel_and_for_exporting_list_of_user_activities_and_triggers_the_post_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload (SheetName,RowNumber)).post("imageupload/exportlog");
		logger.info("API is triggered");
	}
	
	
	// *********************THEN BLOCK*******************************
	
	@Then("a response is generated with status code {int} for exporting user activities list")
	public void a_response_is_generated_with_status_code_for_exporting_user_activities_list(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("a response gets generated with status code {int} for exporting user activities list")
	public void a_response_gets_generated_with_status_code_for_exporting_user_activities_list(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	
	@Then("a response generates with status code {int} for exporting user activities list")
	public void a_response_generates_with_status_code_for_exporting_user_activities_list(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		//.info("Response body as : " + resp);
	}
	
	@Then("the attribute {string} is verified")
	public void the_attribute_is_verified(String KeyValue) {

			if (KeyValue.equalsIgnoreCase("errors")) {
				String errors = getJsonPath(_RESPONSE, KeyValue);
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
							System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_1773.xlsx",
							sheetName);
					String actionIds = testData.get(RowNumber).get("actionIds");
					String userFacilityId = testData.get(RowNumber).get("userFacilityId");
					
	//***********Convert The String format to List of Strings format***********************
					List<String> MyList=new ArrayList<String>();
					  for(String id:actionIds.split(","))
						  MyList.add(id);
					
					JSONObject payload = new JSONObject();
					payload.put("actionIds", MyList);
					payload.put("userFacilityId", userFacilityId);
				
					return payload;
				}
		
}