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


public class GroupFlattenedFilesSteps_PRSAMD_1611 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	RequestSpecification _RESP_SPEC1;
	RequestSpecification _RESP_SPEC2;
	
	static Response _RESPONSE;
	static Response _RESPONSE1;
	static Response _RESPONSE2;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(GroupFlattenedFilesSteps_PRSAMD_1611.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the base URL is entered by the user for grouping of Flattened Files")
	public void the_base_url_is_entered_by_the_user_for_grouping_of_flattened_files() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("user enters a valid {string} and {string} with valid request body to group flattened files and trigger the POST API")
	public void user_enters_a_valid_and_with_valid_request_body_to_group_flattened_files_and_trigger_the_post_api(String Authorization, String Token) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		
		 String baseURL = getGlobalValue("baseUrl");
		 _RESP_SPEC1 = given().baseUri(baseURL);
		 _RESP_SPEC2 = given().baseUri(baseURL);
		 
		String batchIdValue=BatchIDGenerate();
		
		_RESPONSE1 = _RESP_SPEC1.header(Authorization, Token).header("Content-Type", "application/json")
				.body(CreateBatch(batchIdValue)).post("/imageupload/batch");
		
		_RESPONSE2 = _RESP_SPEC2.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("batchId",batchIdValue).multiPart("actualFile",new File("./src/test/resources/testData/TestCaseData_02_PRSAMD_1611"))
				.post("/imageupload/fileupload");
		
		
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(GroupPatient(batchIdValue)).post("/imageupload/groupbypatient");
		logger.info("API is triggered");
	}
	
	@When("user enters a valid {string} and {string} with blank or already grouped batchId from {string} {int} to group flattened files and trigger the POST API")
	public void user_enters_a_valid_and_with_blank_or_already_grouped_batch_id_from_to_group_flattened_files_and_trigger_the_post_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/imageupload/groupbypatient");
		logger.info("API is triggered");
	}

	@When("user enters a valid {string} and {string} with invalid batchId from {string} {int} to group flattened files and trigger the POST API")
	public void user_enters_a_valid_and_with_invalid_batch_id_from_to_group_flattened_files_and_trigger_the_post_api(String Authorization, String Token, String SheetName, Integer RowNumber) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).post("/imageupload/groupbypatient");
		logger.info("API is triggered");
	}
	
	@When("user enters an invalid {string} and {string} with valid batchId to group flattened files and trigger the POST API")
	public void user_enters_an_invalid_and_with_valid_batch_id_to_group_flattened_files_and_trigger_the_post_api(String Authorization, String Token) 
			throws InvalidFormatException, IOException{
		
		Token=passAuthorizationToken(Token);
		
		String baseURL = getGlobalValue("baseUrl");
		 _RESP_SPEC1 = given().baseUri(baseURL);
		 _RESP_SPEC2 = given().baseUri(baseURL);
		 
		String batchIdValue=BatchIDGenerate();
		
		_RESPONSE1 = _RESP_SPEC1.header(Authorization, Token).header("Content-Type", "application/json")
				.body(CreateBatch(batchIdValue)).post("/imageupload/batch");
		
		_RESPONSE2 = _RESP_SPEC2.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("batchId",batchIdValue).multiPart("actualFile",new File("./src/test/resources/testData/TestCaseData_02_PRSAMD_1611"))
				.post("/imageupload/fileupload");
		
		
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(GroupPatient(batchIdValue)).post("/imageupload/groupbypatient");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("a {int} response is generated to group flattened files")
	public void a_response_is_generated_to_group_flattened_files(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("a {int} response gets generated to group flattened files")
	public void a_response_gets_generated_to_group_flattened_files(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}
	
	@Then("a {int} response being generated to group flattened files")
	public void a_response_being_generated_to_group_flattened_files(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
		logger.info("Response body as : " + resp);
	}
	
	@Then("a {int} response is getting generated to group flattened files")
	public void a_response_is_getting_generated_to_group_flattened_files(Integer int1) {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
		//logger.info("Response body as : " + resp);
	}

	
	@Then("an attribute {string} is verified for grouping flattened files")
	public void an_attribute_is_verified_for_grouping_flattened_files(String keyValue) {
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
	
	// *********************GENERATE RANDOM BATCH IDs*******************************
			private static  String BatchIDGenerate() 
			{
				String uuid = UUID.randomUUID().toString();
				logger.info("Batch ID is : "+uuid);
		        return uuid;
			}
			
	// *********************CREATE BATCH*******************************
			private  String CreateBatch(String batchIdValue) throws IOException 
			{
				
				
				String value="{\r\n"
						+ "\"batchId\" : \""+batchIdValue+"\",\r\n"
						+ "\"expectedFileCount\" : 1,\r\n"+ "\"batchSizeKB\" : 512,\r\n"
						+ "\"sourceFacilityId\" :\"4\",\r\n"+ "\"sourceFacilityName\" : \"testsurgeon\",\r\n"
						+ "\"sourceFacilityContactLead\":\"New Contact Lead\",\r\n"+ "\"sourceFacilityEmail\":\"sncloudsupport-ic-test@capgemini.com\",\r\n"
						+ "\"sourceFacilityPhone\":\"8978675645\",\r\n"+ "\"targetFacilityId\" : 1,\r\n"
						+ "\"targetFacilityName\" : \"New Demo\",\r\n"+ "\"targetFacilityContactLead\":\"New Contact Lead\",\r\n"
						+ "\"targetFacilityPhone\":\"9087654321\",\r\n"+ "\"targetFacilityEmail\":\"ic-test-snhilmanager@capgemini.com\",\r\n"
						+ "\"surgeonId\" :\"1001\",\r\n"+ "\"surgeonFirstName\" :\"Dr.Test\",\r\n"
						+ "\"surgeonLastName\" :\"Code\",\r\n"+ "\"applicationId\" : 1,\r\n"
						+ "\"applicationName\" : \"Prime\",\r\n"+ "\"uploaderId\" : \"ic-test-admin@capgemini.com\",\r\n"
						+ "\"uploaderFirstName\" : \"DR.Uploader\",\r\n"+ "\"uploaderLastName\"  :\"Batch\",\r\n"
						+ "\"sourceFacilityAddress\":\"GM road\",\r\n"+ "\"sourceFacilityCity\":\"Pune\",\r\n"
						+ "\"sourceFacilityZipCode\":\"411033\",\r\n"+ "\"sourceFacilityState\":\"Maharashtra\"\r\n"+ "}";
				
				
			return value;
			}
			
			//*********************GROUP PATIENT*******************************
						private  String GroupPatient(String batchIdValue) throws IOException 
						{
							
							
							String value="{\r\n"
									+ "    \"batchId\" :\""+batchIdValue+"\"\r\n"
									+ "}";
							
							
						return value;
						}		
			


				
				
			// *********************FUNCTIONS TO PASS TEST DATA FROM EXCEL SHEET *******************************
				
				
				private HashMap<String, String> payload(String SheetName, Integer RowNumber)
						throws InvalidFormatException, IOException 
				{
					ExcelReader reader = new ExcelReader();
					List<Map<String, String>> testData = reader.getData(
							System.getProperty("user.dir") +"/src/test/resources/testData/TestCaseData_01_PRSAMD_1611.xlsx", SheetName);
					String batchId = testData.get(RowNumber).get("batchId");
					
					JSONObject payload = new JSONObject();
					payload.put("batchId", batchId);
					
					
					return payload;
			}
			
		
}
	