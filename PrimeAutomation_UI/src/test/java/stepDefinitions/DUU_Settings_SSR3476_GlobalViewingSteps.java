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

public class DUU_Settings_SSR3476_GlobalViewingSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_Settings_SSR3476_GlobalViewingSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SettingsPage sp = new SettingsPage();

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
	
    @When("click settings page button from left menu")
    public void user_clicks_settings_page_button_from_left_menu() {
    	try {
    		sp.clickSettingsPage();
    		logger.info("User clicked left menu settings page button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not click settings page button from left menu ");
			exception = e;
    	}
    }
    
    @Then("disable global view setting")
    public void disable_global_view_setting() {
    	try {
    		sp.setGlobalViewSettingToDefault();
    		logger.info("Global view setting is default");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to set global view setting to default ");
			exception = e;
    	}
    }
    
    @Then("the user clicks file dashboard in left menu")
    public void click_file_dashboard() {
    	try {
    		sp.clickFileDashboardButton();
    		logger.info("User clicks file dashboard button in left menu bar");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			Thread.sleep(2000);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click file dashboard button");
			exception = e;
    	}
    }
    
	@Then("the user is able to view image upload records in dashboard")
	public void user_is_able_to_view_image_upload_records_in_dashboard() {
		try {
			assertTrue(sp.verifyFileUploadInDashboard());
			logger.info("User is able to view image upload record in dashboard");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to view image upload record in dashboard");
			exception = e;
    	}
	}

    @Then("the user clicks history in left menu")
    public void click_history_button() {
    	try {
    		sp.clickHistoryButton();
    		logger.info("User clicks history button from left menu bar");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			Thread.sleep(2000);
    	}  catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click history button");
			exception = e;
    	}
    }
    
	@Then("the user is able to view image upload records in history")
	public void user_is_able_to_view_image_upload_records_in_history() {
		try {
			assertTrue(sp.verifyFileUploadInHistoryPage());
			logger.info("User is able to view image upload record in history");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to view image upload record in history");
			exception = e;
    	}
	}
	
	@Then("turn on global view setting")
	public void user_turns_on_global_view_setting () {
		try {
			sp.turnOnGlobalViewSetting();
			logger.info("User turned on global view setting");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to turn on global view setting");
			exception = e;
    	}
	}
	
	@Then("upload successful screen is displayed")
	public void check_if_upload_successful_screen_is_displayed() {
		try {
			assertTrue(sp.checkUploadSuccessfulScreen());
			logger.info("Upload successful screen is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Upload successful screen is not displayed");
			exception = e;
    	}
	}

}