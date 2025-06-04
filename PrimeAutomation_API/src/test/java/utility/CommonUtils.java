package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonUtils {
	/**
	 * This method is used to get the values from the property file
	 * 
	 * @return KeyValue
	 * @throws IOException
	 */
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/config/api-config.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

	/**
	 * This method is used to extract the values from json response body as string
	 * 
	 */
	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		if(js.get(key)!=null)
			return js.get(key).toString();
		else 
		return "null";
	}
	
	/**
	 * This method is used to pass the values of the token in the API Automation code
	 * 
	 */
	public static String passAuthorizationToken(String token) throws IOException
	{
		if(token.equals("hosp_admin_token"))
			token =getGlobalValue("hosp_admin_token");
			
		
		else if(token.equals("ic_admin_token"))
			token =getGlobalValue("ic_admin_token");
			
		
		else if(token.equals("surgeon_token"))
			token =getGlobalValue("surgeon_token");
			
			
		else if(token.equals("staff_token"))
			token =getGlobalValue("staff_token");
			
		
		else if(token.equals("ic_technician_token"))
			token =getGlobalValue("ic_technician_token");
			
			
		else if(token.equals("hil_manager_token"))
				token =getGlobalValue("hil_manager_token");
				
		
		else if(token.equals("hil_reviewer_token"))
			token =getGlobalValue("hil_reviewer_token");
		
		else if(token.equals("cloud_support_token"))
			token =getGlobalValue("cloud_support_token"); 
			
		
		else if(token.equals("invalid_token"))
			token =getGlobalValue("invalid_token");
			
		
		else if(token.equals("lambda_token"))
			token =getGlobalValue("lambda_token");
		
		else if(token.equals("procedure_surgeon_token"))
			token =getGlobalValue("procedure_surgeon_token");
		
		else if(token.equals("procedure_staff_token"))
			token =getGlobalValue("procedure_staff_token");
			
		
		return token;
	}
}

/*
 * public static RequestSpecification req; public RequestSpecification
 * requestSpecification() throws IOException { if(req==null) { PrintStream log
 * =new PrintStream(new FileOutputStream("logging.txt")); req=new
 * RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("",
 * "") .addFilter(RequestLoggingFilter.logRequestTo(log))
 * .addFilter(ResponseLoggingFilter.logResponseTo(log))
 * .setContentType(ContentType.JSON).build(); return req; } return req; }
 */
