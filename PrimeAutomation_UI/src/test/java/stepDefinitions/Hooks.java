package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.ScreenRecording;
import utility.Screenshot;

public class Hooks {

	PropertiesFileReader reader = new PropertiesFileReader();
	Screenshot screenshot = new Screenshot();
	String scenarioName;

	@Before
	public void Recording(Scenario scenario) throws Exception {
		scenarioName = scenario.getName();
		ScreenRecording.startRecording(scenarioName);
	}

	@After(order = 1)
	public void TakeScreenshotOnFailure(Scenario scenario) throws InterruptedException {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) LoginPage.driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "Screenshot for Failed Step");
		}
	}

	@AfterStep(order = 0)
	public void TakeScreenshotForEachStep(Scenario scenario) throws InterruptedException {
		TakesScreenshot ts = (TakesScreenshot) LoginPage.driver;
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", "screenshot");
	}

	@After
	public void Recording() throws Exception {
		ScreenRecording.stopRecording();
	}

	@Before
	public void screenshotDirectory(Scenario scenario) throws Exception {
		scenarioName = scenario.getName();
		screenshot.createScreenshotDirectory(scenarioName);
	}

	final static Logger logger = Logger.getLogger(Hooks.class);

	@After
	public void afterScenarioFinish() throws Exception {
		logger.info(
				"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Completed test execution>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//LoginPage.driver.quit();
	}

	@Before
	public void beforeScenarioStart() throws Exception {
		logger.info(
				"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Started new test execution>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

	}

}
