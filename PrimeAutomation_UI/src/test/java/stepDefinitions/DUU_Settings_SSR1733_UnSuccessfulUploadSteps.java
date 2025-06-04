package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.SettingsPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_Settings_SSR1733_UnSuccessfulUploadSteps 
{
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_Settings_SSR1733_UnSuccessfulUploadSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SelectedActivityPage sap = new SelectedActivityPage();
	SettingsPage sp = new SettingsPage();
	FileDashboardPage fp = new FileDashboardPage();

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
			logger.info("**********************************************************************************************");
			System.out.println(stepStatus);
		}
		if (stepStatus == false) {
			logger.info("TESTCASE HAS FAILED AT THIS STEP");
			Assert.fail();
		}
	}
	
	
	@When("user clicks on settings from left panel")
	public void user_clicks_on_settings_from_left_panel() {
		try {
    		sp.clickSettingsPage();
    		logger.info("Step : Settings tab is clicked from left side panel");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not click settings page button from left menu ");
			exception = e;
    	}
	}
	
	@When("settings screen is displayed")
	public void settings_screen_is_displayed() {
		try {
			sap.isSettingsHeaderDisplayed();
			sap.isSettingsHighlighted();
			logger.info("Step : Settings screen is displayed to the user");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user clicks on File dashboard from left panel")
	public void user_clicks_on_file_dashboard_from_left_panel() {
		try {
			sap.clickOnDashboardButton();
			logger.info("Step : File Dashboard screen is displayed to the user");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on clear button to remove selected")
	public void the_user_clicks_on_clear_button_to_remove_selected() {
		try {
			sp.clickOnClearButton();
			logger.info("Step : the user cleared the selected dates");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	
	@Then("records are displayed as per the filtered date range")
	public void records_are_displayed_as_per_the_filtered_date_range() {
		try {
			sp.getTotalDashboardEntries();
			logger.info("Records is displayed as per the filtered range");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Records are not displayed");
			exception = e;
    	}
	}
	
	@Then("the total number of records displayed on dashboard screen")
	public void the_total_number_of_records_displayed_on_dashboard_screen() {
		try {
			sp.recordTotalNumberofDetailsOnDashbaord();
			logger.info("The total number of records displayed on dashbaord screen are recorded");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Records are not displayed");
			exception = e;
    	}
	}
	
	@Then("the error message as Failed to retrieve data contact your administrator shall be displayed")
	public void the_error_message_as_Failed_to_retrieve_data_contact_your_administrator_shall_be_displayed() {
		try {
			assertTrue(sp.isErrorMessageDisplayed());
			logger.info("The error message is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Error message not displayed");
			exception = e;
    	}
	}
	
	@Then("the upload dashboard screen shall display same number of records")
	public void the_upload_dashboard_screen_shall_display_same_number_of_records() {
		try {
			Thread.sleep(10000);
			assertTrue(sp.isDashboardRecordsMatch());
			logger.info("The upload dashboard screen is displayed same number of records as previously recorded");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Records are not same");
			exception = e;
    	}
	}

}
