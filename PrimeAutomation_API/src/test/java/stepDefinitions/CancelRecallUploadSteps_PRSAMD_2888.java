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


public class CancelRecallUploadSteps_PRSAMD_2888 extends CommonUtils {
	RequestSpecification _RESP_SPEC;
	RequestSpecification _RESP_SPEC1;
	RequestSpecification _RESP_SPEC2;
	RequestSpecification _RESP_SPEC3;
	
	static Response _RESPONSE;
	static Response _RESPONSE1;
	static Response _RESPONSE2;
	static Response _RESPONSE3;
	String resp;
	String expected_value;
	final static Logger logger = Logger.getLogger(CancelRecallUploadSteps_PRSAMD_2888.class);
	
	// *********************GIVEN BLOCK*******************************
	
	@Given("the Base url is entered to cancel\\/recall all the uploads")
	public void the_base_url_is_entered_to_cancel_recall_all_the_uploads() throws IOException{
		logger.info("Base_url_is_entered");
		String baseURL = getGlobalValue("baseUrl");
		_RESP_SPEC = given().baseUri(baseURL);
		logger.info("Base_url : " + baseURL);
	}
	
	// *********************WHEN BLOCK*******************************
	
	@When("user gives valid {string} & {string} and trigger PUT API to cancel\\/recall all the uploads")
	public void user_gives_valid_and_trigger_put_api_to_cancel_recall_all_the_uploads(String Authorization, String Token) 
			throws InvalidFormatException, IOException {
		String baseURL = getGlobalValue("baseUrl");
		
		Token=passAuthorizationToken(Token);
		
		 _RESP_SPEC1 = given().baseUri(baseURL);
		 _RESP_SPEC2 = given().baseUri(baseURL);
		 _RESP_SPEC3 = given().baseUri(baseURL);
		 
		String batchIdValue=BatchIDGenerate();
		
		_RESPONSE1 = _RESP_SPEC1.header(Authorization, Token).header("Content-Type", "application/json")
				.body(CreateBatch(batchIdValue)).post("/imageupload/batch");
		
		_RESPONSE2 = _RESP_SPEC2.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("batchId",batchIdValue).multiPart("actualFile",new File("./src/test/resources/testData/TestCaseData_01_PRSAMD_2888"))
				.post("/imageupload/fileupload");
		
		
		_RESPONSE3 = _RESP_SPEC3.header(Authorization, Token).header("Content-Type", "application/json")
				.body(GroupPatient(batchIdValue)).post("/imageupload/groupbypatient");
		
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(RecallBatch(batchIdValue).toString()).put("/imageupload/recall");
		logger.info("API is triggered");
	}
	
	@When("User gives valid {string} & {string} and fetch testdata from {string} {int} and trigger PUT API to cancel\\/recall all the uploads")
	public void user_gives_valid_and_fetch_testdata_from_and_trigger_put_api_to_cancel_recall_all_the_uploads(String Authorization, String Token,
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/imageupload/recall");
		logger.info("API is triggered");
	}
	
	@When("User gives valid {string} & {string} and fetch invalid batchId testdata from {string} {int} and trigger PUT API to cancel\\/recall all the uploads")
	public void user_gives_valid_and_fetch_invalid_batch_id_testdata_from_and_trigger_put_api_to_cancel_recall_all_the_uploads(String Authorization, String Token,
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		
		Token=passAuthorizationToken(Token);
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(payload(SheetName, RowNumber).toString()).put("/imageupload/recall");
		logger.info("API is triggered");
	}
	
	@When("User gives invalid {string} & {string} and fetch testdata and trigger PUT API to cancel\\/recall all the uploads")
	public void user_gives_invalid_and_fetch_testdata_and_trigger_put_api_to_cancel_recall_all_the_uploads(String Authorization, String Token) 
			throws InvalidFormatException, IOException {
		String baseURL = getGlobalValue("baseUrl");
		
		Token=passAuthorizationToken(Token);
		
		 _RESP_SPEC1 = given().baseUri(baseURL);
		 _RESP_SPEC2 = given().baseUri(baseURL);
		 _RESP_SPEC3 = given().baseUri(baseURL);
		 
		String batchIdValue=BatchIDGenerate();
		
		_RESPONSE1 = _RESP_SPEC1.header(Authorization, Token).header("Content-Type", "application/json")
				.body(CreateBatch(batchIdValue)).post("/imageupload/batch");
		
		_RESPONSE2 = _RESP_SPEC2.header(Authorization, Token).header("Content-Type", "multipart/form-data")
				.multiPart("batchId",batchIdValue).multiPart("actualFile",new File("./src/test/resources/testData/TestCaseData_01_PRSAMD_2888"))
				.post("/imageupload/fileupload");
		
		
		_RESPONSE3 = _RESP_SPEC3.header(Authorization, Token).header("Content-Type", "application/json")
				.body(GroupPatient(batchIdValue)).post("/imageupload/groupbypatient");
		
		_RESPONSE = _RESP_SPEC.header(Authorization, Token).header("Content-Type", "application/json")
				.body(RecallBatch(batchIdValue).toString()).put("/imageupload/recall");
		logger.info("API is triggered");
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("Response is generated with success status code to cancel\\/recall")
	public void response_is_generated_with_success_status_code_to_cancel_recall() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(200).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with failure status code to cancel\\/recall")
	public void response_is_generated_with_failure_status_code_to_cancel_recall() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(400).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with no data found status code to cancel\\/recall")
	public void response_is_generated_with_no_data_found_status_code_to_cancel_recall() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(404).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}
	
	@Then("Response is generated with unauthorized status code  to cancel\\/recall")
	public void response_is_generated_with_unauthorized_status_code_to_cancel_recall() {
		logger.info("Response is generated");
		String resp = _RESPONSE.then().assertThat().statusCode(401).extract().response().asString();
//		logger.info("Response body as : " + resp);
	}

	@Then("{string} field validates in Response body to cancel\\/recall all the uploads")
	public void field_validates_in_response_body_to_cancel_recall_all_the_uploads(String keyValue) {
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
						+ "    \"batchId\" :\""+batchIdValue+"\"\r\n"+ "}";
						
						return value;
					}		
		//*********************RECALL BATCH*******************************
				private  String RecallBatch(String batchIdValue) throws IOException 
					{
								
						String value="{\r\n"+ "    \"batchId\" : \""+batchIdValue+"\",\r\n"
								+ "    \"uploadId\" : \"\"\r\n"+ "}";
						
						return value;
					}
	
	// function to get the test-data from excel sheet
		private HashMap<String, String> payload(String SheetName, Integer RowNumber)
				throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testData = reader.getData(
					System.getProperty("user.dir") + "/src/test/resources/testData/TestCaseData_PRSAMD_2888.xlsx",
					SheetName);
			String batchId = testData.get(RowNumber).get("batchId");
			String uploadId = testData.get(RowNumber).get("uploadId");
			JSONObject payload = new JSONObject();
			payload.put("batchId", batchId);
			payload.put("uploadId", uploadId);
			return payload;
		}

}