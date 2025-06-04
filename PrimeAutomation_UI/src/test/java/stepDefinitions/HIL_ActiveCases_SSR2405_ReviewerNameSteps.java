package stepDefinitions;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HILActiveCasePage;
import pages.HILLoginPage;
import pages.HILMyCasesPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class HIL_ActiveCases_SSR2405_ReviewerNameSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HIL_ActiveCases_SSR2405_ReviewerNameSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HILActiveCasePage acP = new HILActiveCasePage();
	HILLoginPage lP = new HILLoginPage();
	HILMyCasesPage mcP = new HILMyCasesPage();

	@BeforeStep
	public void beforeStep(Scenario scenario) {
		exception = null;
	}

	@AfterStep
	public void afterStep() {
		String exceptionName = null;
		if (exception != null) {
			stepStatus = false;
			logger.info(
					"\n******************************STEP FAILED*****************************************************");
			exceptionName = exception.getClass().getSimpleName();
			logger.info("Exception Type : " + exceptionName);
			if (exceptionName.equals("NoSuchElementException")) {
				logger.info("Element could not be found");
			} else if (exceptionName.equals("ElementNotSelectableException")) {
				logger.info("Element could not be not selected");
			} else if (exceptionName.equals("NoSuchFrameException")) {
				logger.info("Frame does not exist");
			} else if (exceptionName.equals("NoSuchWindowException")) {
				logger.info("Window does not exist");
			} else if (exceptionName.equals("TimeoutException")) {
				logger.info("Element could not be found within the specified time");
			} else if (exceptionName.equals("ConnectionClosedException")) {
				logger.info("Driver is disconnected");
			} else if (exceptionName.equals("AssertionError")) {
				logger.info(exceptionName);
			} else {
				logger.info("Exception occured : " + exceptionName);
			}
			logger.info("Exception Details below:\n");
			logger.info(exception.toString());
			logger.info(
					"**********************************************************************************************");
			System.out.println(stepStatus);
		}
		if (stepStatus == false) {
			logger.info("TESTCASE HAS FAILED AT THIS STEP");
			Assert.fail();
		}
	}
	
	@Then("Get first entry status in my cases page")
	public void get_first_entry_status_in_my_cases_page() {
		try {
			String ssname = "Get first entry status in my cases page";
			logger.info("Step: " + ssname);
			acP.printFirstEntryStatusInMyCasesPage();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to get my cases first entry status");
			exception = e;
		}
	}
	
	@Then("Check that audit log icon is not displayed")
	public void check_audit_log_icon_not_displayed() {
		try {
			String ssname = "Check that the audit log icon is not displayed";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.checkAuditLogIconFirstEntryNotDisplayed());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check audit log icon");
			exception = e;
		}
	}
	
	@Then("Check that Edit Date icon is not displayed")
	public void check_edit_date_icon_not_displayed() {
		try {
			String ssname = "Check that the edit date icon is not displayed";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.checkEditDateIconFirstEntryNotDisplayed());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check edit date icon");
			exception = e;
		}
	}
	
	@Then("Check that Settings button is not displayed")
	public void check_settings_button_not_displayed() {
		try {
			String ssname = "Check that Settings button is not displayed";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.checkSettingsButtonTopRightNotDisplayed());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check settings button");
			exception = e;
		}
	}
}