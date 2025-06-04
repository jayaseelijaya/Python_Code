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

public class DUU_Settings_SSR3691_VerifySettingsUISteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_Settings_SSR3691_VerifySettingsUISteps.class);
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
	
	@Then("successful uploads text is displayed")
	public void is_successful_uploads_text_displayed() {
		try {
			assertTrue(sp.isSuccessfulUploadDisplayed());
			logger.info("Successful uploads text is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Successful Uploads Text is not displayed");
			exception = e;
    	}
	}
    @Then("unsuccessful uploads text is displayed")
    public void is_unsuccessful_uploads_text_displayed() {
    	try {
    		assertTrue(sp.isUnsuccessfulUploadDisplayed());
    		logger.info("Unsuccessful uploads text is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unsuccessful Uploads Text is not displayed");
			exception = e;
    	}
    }
    
    @Then("global viewing toggle is displayed")
    public void is_global_viewing_toggle_displayed() {
    	try {
    		assertTrue(sp.isGlobalViewToggleDisplayed());
    		logger.info("Global viewing toggle is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Global Viewing Toggle is not displayed");
			exception = e;
    	}
    }
    
    @Then("reset to default button is displayed and enabled")
    public void is_reset_to_default_button_displayed_and_enabled() {
    	try {
    		assertTrue(sp.isResetToDefaultuttonDisplayedAndEnabled());
    		logger.info("Reset to default button is displayed and enabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Reset to default button is not displayed and enabled");
			exception = e;
    	}
    }
    
    @Then("save button is displayed and disabled")
    public void is_save_button_displayed_and_disabled() {
    	try {
    		assertTrue(sp.isSaveButtonDisplayedAndDisabled());
    		logger.info("Save button is displayed and disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Save button is not displayed and disabled");
			exception = e;
    	}
    }
    
    @Then("settings page header is displayed")
    public void is_settings_page_header_displayed() {
    	try {
    		assertTrue(sp.isSettingsPageHeaderDisplayed());
    		logger.info("Settings page header is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Settings page header is not displayed");
			exception = e;
    	}
    }
    
    @Then("cosmetic lines are displayed")
    public void are_cosmetic_lines_displayed_correctly() {
    	try {
    		assertTrue(sp.areCosmeticLinesCorrect());
    		logger.info("Cosmetic lines are displayed correctly");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Cosmetic lines are not displayed correctly");
			exception = e;
    	}
    }
    
    @Then("settings text in left menu bar is green")
    public void is_settings_text_in_left_menu_bar_green() {
    	try {
    		assertTrue(sp.isSettingsTextInLeftMenuBarGreen());
    		logger.info("Settings text in left menu bar is green");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Settings text in left menu bar is not green");
			exception = e;
    	}
    }
    
    @Then("enter 20 into successful upload days input box")
    public void enter_value_into_successful_upload_days_input() {
    	try {
    		sp.enterValueIntoSuccessfulUploadsInputBox();
    		logger.info("User entered 20 into successful upload input box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to enter a number into the successful upload days input box");
			exception = e;
    	}
    }
    
    @Then("enter 20 into unsuccessful upload days input box")
    public void enter_value_into_unsuccessful_upload_days_input() {
    	try {
    		sp.enterValueIntoUnsuccessfulUploadsInputBox();
    		logger.info("User entered 20 into unsuccessful upload input box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to enter a number into the unsuccessful upload days input box");
			exception = e;
    	}
    }
    
    @Then("enter negative number into successful upload days input box")
    public void enter_negative_number_into_successful_uploads_input_box() {
    	try {
    		sp.enterNegativeValueIntoSuccessfulUploadsInputBox();
			logger.info("User entered negative number into successful uploads input box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to enter negative number into successful uploads input box");
			exception = e;
    	}
    }
    
    @Then("enter negative number into unsuccessful upload days input box")
    public void enter_negative_number_into_unsuccessful_uploads_input_box() {
    	try {
    		sp.enterNegativeValueIntoUnsuccessfulUploadsInputBox();
    		logger.info("User entered negative number into unsuccessful uploads input box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to enter negative number into unsuccessful uploads input box");
			exception = e;
    	}
    }
    
    @Then("check successful upload days input box text color")
    public void check_successful_upload_days_input_box_text_color() {
    	try {
    		assertTrue(sp.checkSuccessfulInputBoxColor());
    		logger.info("Successful upload days input text box is red");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Successful upload days input box text is not red");
			exception = e;
    	}
    }
    
    @Then("check unsuccessful upload days input box text color")
    public void check_unsuccessful_upload_days_input_box_text_color() {
    	try {
    		assertTrue(sp.checkUnsuccessfulInputBoxColor());
    		logger.info("Unsuccessful upload days input text box is red");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unsuccessful upload days input box text is not red");
			exception = e;
    	}
    }
    
    @Then("enter no value into successful upload days input box")
    public void enter_nothing_into_successful_upload_input() {
    	try {
    		sp.enterNoValueIntoSuccessfulUploadsInputBox();
    		logger.info("Entered nothing into successful upload input");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to clear successful upload input field");
			exception = e;
    	}
    }
    
    @Then("enter no value into unsuccessful upload days input box")
    public void enter_nothing_into_unsuccessful_upload_input() {
    	try {
    		sp.enterNoValueIntoUnsuccessfulUploadsInputBox();
    		logger.info("Entered nothing into unsuccessful upload input");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to clear unsuccessful upload input field");
			exception = e;
    	}
    }
    
    @Then("enter high number into successful upload days input box")
    public void enter_high_value_into_successful_upload_input() {
    	try {
    		sp.enterHighValueIntoSuccessfulUploadsInputBox();
    		logger.info("Entered high value into successful upload input");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to enter value into successful upload input field");
			exception = e;
    	}
    }
    
    @Then("enter high number into unsuccessful upload days input box")
    public void enter_high_value_into_unsuccessful_upload_input() {
    	try {
    		sp.enterHighValueIntoUnsuccessfulUploadsInputBox();
    		logger.info("Entered high value into unsuccessful upload input");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to enter value into unsuccessful upload input field");
			exception = e;
    	}
    }
    
    @Then("enter special character into successful upload days input box")
    public void enter_special_character_into_successful_upload_days_input() {
    	try {
    		sp.enterSpecialCharacterIntoSuccessfulUploadsInputBox();
    		logger.info("Entered special character into successful upload days input");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to enter value into successful upload input field");
			exception = e;
    	}
    }
    
    @Then("enter special character into unsuccessful upload days input box")
    public void enter_special_character_into_unsuccessful_upload_days_input() {
    	try {
    		sp.enterSpecialCharacterIntoUnsuccessfulUploadsInputBox();
    		logger.info("Entered special character into unsuccessful upload days input");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to enter value into unsuccessful upload input field");
			exception = e;
    	}
    }
}