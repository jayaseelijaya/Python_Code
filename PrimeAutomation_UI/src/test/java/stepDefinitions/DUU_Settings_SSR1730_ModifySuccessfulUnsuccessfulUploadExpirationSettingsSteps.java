package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuditLogPage;
import pages.FileDashboardPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.SettingsPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_Settings_SSR1730_ModifySuccessfulUnsuccessfulUploadExpirationSettingsSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger
			.getLogger(DUU_Settings_SSR1730_ModifySuccessfulUnsuccessfulUploadExpirationSettingsSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	AuditLogPage alPage = new AuditLogPage();
	SelectedActivityPage saPage = new SelectedActivityPage();
	FileDashboardPage daPage = new FileDashboardPage();
	SettingsPage ssPage = new SettingsPage();

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
	// *********************WHEN BLOCK*******************************

	@When("the user selects {string} date counting back from current date")
	public void the_user_selects_date_counting_back_from_current_date(String string) {
		try {
			ssPage.selectDateBackFromCurrentDate(string);
			logger.info("Step: the user selected " + string + "date counting back from current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user removes date filter")
	public void the_user_removes_date_filter() {
		try {
			ssPage.removeDateFilter();
			logger.info("Step: the date filter is removed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters {string} in successful upload expiration textbox")
	public void the_user_enters_in_successful_upload_expiration_textbox(String string) {
		try {
			ssPage.enterValueInToSuccessfulUploadTextbox(string);
			logger.info("Step: the user entered " + string + "in successful upload expiration textbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters {string} in unsuccessful upload expiration textbox")
	public void the_user_enters_in_unsuccessful_upload_expiration_textbox(String string) {
		try {
			ssPage.enterValueInToUnSuccessfulUploadTextbox(string);
			logger.info("Step: the user entered " + string + "in unsuccessful upload expiration textbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on save button in settings")
	public void the_user_clicks_on_save_button_in_settings() {
		try {
			ssPage.clickOnSaveButton();
			logger.info("Step: Save button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user removes the value from successful upload expiration textbox")
	public void the_user_removes_the_value_from_successful_upload_expiration_textbox() {
		try {
			ssPage.removeTextFromSuccessfulExpiration();
			logger.info("Step: The text is removed from successful upload expiration textbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user removes the value from unsuccessful upload expiration textbox")
	public void the_user_removes_the_value_from_unsuccessful_upload_expiration_textbox() {
		try {
			ssPage.removeTextFromUnsuccessfulExpiration();
			logger.info("Step: The text is removed from successful upload expiration textbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	// *********************THEN BLOCK*******************************
//	@Then("the upload dashboard shall displayed all successful and unsuccessful image upload details from {string} day date counting back from current date")
//	public void the_upload_dashboard_shall_displayed_all_successful_and_unsuccessful_image_upload_details_from_day_date_counting_back_from_current_date(String string) {
//		try {
//			Assert.assertTrue(ssPage.isAllSuccessfulUnsuccessfulUploadDisplayedInUploadDashboard(string));
//			logger.info("Step: all successful and unsuccessful image upload details from "+ string +" day date counting back from current date is displayed in upload dashboard");
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}

	@Then("the value {string} shall be saved in successful upload expiration textbox")
	public void the_value_shall_be_saved_in_successful_upload_expiration_textbox(String string) {
		try {
			Assert.assertEquals(ssPage.isEnteredValueSavedInSuccessfulExpirationTextbox(string), string);
			logger.info("Step: the entered value " + string + " is saved in successful upload expiration textbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the value {string} shall be saved in unsuccessful upload expiration textbox")
	public void the_value_shall_be_saved_in_unsuccessful_upload_expiration_textbox(String string) {
		try {
			Assert.assertEquals(ssPage.isEnteredValueSavedInUnsuccessfulExpirationTextbox(string), string);
			logger.info("Step: the entered value " + string + " is saved in unsuccessful upload expiration textbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the value {string} shall be displayed in successful upload expiration textbox")
	public void the_value_shall_be_displayed_in_successful_upload_expiration_textbox(String string) {
		try {
			Assert.assertEquals(ssPage.isEnteredValueSavedInSuccessfulExpirationTextbox(string), string);
			logger.info("Step: the entered value " + string + " is displayed in successful upload expiration textbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the value {string} shall be displayed in unsuccessful upload expiration textbox")
	public void the_value_shall_be_displayed_in_unsuccessful_upload_expiration_textbox(String string) {
		try {
			Assert.assertEquals(ssPage.isEnteredValueSavedInUnsuccessfulExpirationTextbox(string), string);
			logger.info(
					"Step: the entered value " + string + " is displayed in unsuccessful upload expiration textbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the succcessful upload expiration input box borderline shall be displayed in red color")
	public void the_succcessful_upload_expiration_input_box_borderline_shall_be_displayed_in_red_color() {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(ssPage.isSuccessfulExpirationTextboxDisplayedInRedColor(),
					properties.getProperty("setting.redcolor"));
			logger.info("Step: the successful upload expiration textbox broderline is displayed in read color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the unsucccessful upload expiration input box borderline shall be displayed in red color")
	public void the_unsucccessful_upload_expiration_input_box_borderline_shall_be_displayed_in_red_color() {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(ssPage.isUnsuccessfulExpirationTextboxDisplayedInRedColor(),
					properties.getProperty("setting.redcolor"));
			logger.info("Step: the unsuccessful upload expiration textbox broderline is displayed in read color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the user shall not be allowed to save {string} value")
	public void the_user_shall_not_be_allowed_to_save_value(String string) {
		try {
			Assert.assertFalse(ssPage.notAllowedValues(string));
			logger.info("Step: Save button is not clicked and values other than 1-30 are not allowed to save");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the setting screen shall be displayed with default values")
	public void the_setting_screen_shall_be_displayed_with_default_values() {
		try {
			Assert.assertTrue(ssPage.isDefaultValuesDisplayed());
			logger.info("Step: the setting screen displayed default values as 14");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the upload dashboard shall displayed all successful and unsuccessful image upload details from {string} day date counting back from current date")
	public void the_upload_dashboard_shall_displayed_all_successful_and_unsuccessful_image_upload_details_from_day_date_counting_back_from_current_date(String string) {
		try {
			FileDashboardPage  FDPage = new FileDashboardPage();
			Assert.assertTrue(FDPage.isRecordsDisplayed());
			logger.info("Step: the upload dashboard is displayed all details from " +string+ " days back from current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
