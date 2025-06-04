package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinitions" }, monochrome = true, 
         plugin = {
		//"pretty", "json:target/cucumber-reports/cucumber.json",
		//"html:target/cucumber-reports/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, tags = "@tag1")

public class TestRunner extends AbstractTestNGCucumberTests {


}
