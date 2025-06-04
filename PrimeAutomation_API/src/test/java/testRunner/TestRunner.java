package testRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinitions" }, monochrome = true, plugin = {
		"pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, publish = true, tags = "" )

public class TestRunner extends AbstractTestNGCucumberTests {

	final static Logger logger = Logger.getLogger(TestRunner.class);
	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.setProperty("currenttime", dateFormat.format(timestamp));
	}

	@BeforeClass
	public void setUpClass() {
		logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Started new test execution>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@AfterClass
	public void tearDownClass()
	{/*
	
		 * if (_RESPONSE==null) { System.out.println("Response: No response received.");
		 * }else { scn.write("Response: " + _RESPONSE.asString()); }
		 */
	
		logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Completed test execution>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}
