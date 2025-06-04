package stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.HelpInfoPage;
import pages.LoginPage;
import pages.SettingsPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_Settings_SSR1732_DefaultSettingsSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_Settings_SSR1732_DefaultSettingsSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SettingsPage sp = new SettingsPage();
	
	int initialDashboardEntries;
	int firstFilterDashboardEntries;

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
	
	@Then("reset to default settings")
	public void click_reset_to_default_button() {
		try {
			sp.resetSettingsToDefault();
			logger.info("User reset settings to default");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not reset settings to default");
			exception = e;
    	}
	}
	
	@Then("the entries on the dashboard are within the default 14 day range")
	public void check_dashboard_entries() {
		try {
			assertTrue(sp.checkAllUploadDates());
			logger.info("Checked file dashboard entries to be within date range");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Dashboard entries do not match default settings");
			exception = e;
    	}
	}
	
	@Then("the user clicks the filter button in the top right")
	public void click_filter_button() {
		try {
			sp.clickFilterButton();
			logger.info("User clicked filter button on dashboard");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click filter button on dashboard");
			exception = e;
    	}
	}
	
	@Then("All fields are displayed in filter pop up")
	public void check_filter_fields() {
		try {
			assertTrue(sp.checkFilterFields());
			initialDashboardEntries = sp.getTotalDashboardEntries();
			logger.info("All filter fields are displayed");
			logger.info("Current dashboard entries: " + initialDashboardEntries);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find all filter fields");
			exception = e;
    	}
	}
	
	@Then("click date filter + button")
	public void click_date_filter_button() {
		try {
			sp.clickDateFilterPlusButton();
			logger.info("User clicked date filter + button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click filter + button");
			exception = e;
    	}
	}
	
	@Then("the start and end buttons are displayed")
	public void start_end_buttons_displayed() {
		try {
			assertTrue(sp.checkStartEndButtons());
			logger.info("Start and end buttons are displayed in date filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Start and end buttons are not displayed in date filter");
			exception = e;
    	}
	}

	@Then("user clicks start button in date filter")
	public void click_start_button() {
		try {
			sp.clickStartButton();
			logger.info("User clicked start button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click start button in date filter");
			exception = e;
    	}
	}
	
	@Then("user clicks the date 5 days back from current day")
	public void clicks_five_days_back() {
		try {
			sp.getDaySub5();
			firstFilterDashboardEntries = sp.getTotalDashboardEntries();
			logger.info("User clicks date five days back");
			logger.info("Current dashboard entries: " + firstFilterDashboardEntries);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click date 5 days back");
			exception = e;
    	}
	}
	
	@Then("user clicks done button in filter menu")
	public void click_done_button_filter() {
		try {
			sp.clickDoneButton();
			logger.info("User clicked done button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click done button");
			exception = e;
    	}
	}
	
	@Then("user clears the filter from the top menu bar and checks dashboard entries to default")
	public void user_clear_filter() {
		try {
			sp.clearFilter();
			assertTrue(sp.getTotalDashboardEntries() == initialDashboardEntries);
			logger.info("user cleared filter from top menu bar");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to clear filter");
			exception = e;
    	}
	}
	
	@Then("user enters 5 into successful and unsuccessful text boxes")
	public void enter_five_into_settings_input_boxes() {
		try {
			sp.enterFiveInSettingsInput();
			logger.info("User enters the value 5 into the settings input boxes");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not enter value into settings input boxes");
			exception = e;
    	}
	}
	
	@Then("the records match the number as seen in the filter step")
	public void check_records_against_filter_step() {
		try {
			assertTrue(sp.getTotalDashboardEntries() == firstFilterDashboardEntries);
			logger.info("The values match between the settings step and filter step");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to compare values");
			exception = e;
    	}
	}
	
	@Then("the records match the default settings number")
	public void check_records_against_default_step() {
		try {
			assertTrue(sp.getTotalDashboardEntries() == initialDashboardEntries);
			logger.info("The values match the default settings");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to compare values");
			exception = e;
    	}
	}
}