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
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SummaryDashboard_SSR1727_RecallFunctionalitySteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR1727_RecallFunctionalitySteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SelectedActivityPage sp = new SelectedActivityPage();
	HelpInfoPage hp = new HelpInfoPage();
	FileDashboardPage fdp = new FileDashboardPage();

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

	@Then("check for recall button on first entry")
	public void check_for_recall_button_on_dashboard() {
		try {
			assertTrue(fdp.isRecallBtnDisplayed());
			logger.info("Recall button found");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Recall button not found");
			exception = e;
		}
	}

	@Then("check for white uploaded check mark")
	public void check_for_white_uploaded_check_mark() {
		try {
			String color = fdp.getUploadedCheckboxTickMarkColor();
			logger.info("Check mark color: " + color);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find check mark");
			exception = e;
		}
	}

	@Then("Check for entry in upload status page")
	public void check_entry_in_upload_status_page() {
		try {
			assertTrue(fdp.checkEntryInUploadStatusPage());
			logger.info("Entry found in upload status page");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find entry");
			exception = e;
		}
	}

	@Then("Check Status in first entry")
	public void check_status_in_first_entry() {
		try {
			assertTrue(fdp.checkFirstEntryStatus());
			logger.info("Status is uplaoded");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find entry");
			exception = e;
		}
	}

	@Then("the user clicks upload status in left menu")
	public void user_clicks_upload_status_in_left_menu() {
		try {
			fdp.clickUploadStatus();
			logger.info("User clicked upload status in left menu bar");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click upload status in left menu bar");
			exception = e;
		}
	}

	@Then("check the status of the entry in the history page")
	public void check_status_of_entry_in_history_page() {
		try {
			fdp.printHistoryFirstEntryStatus();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find entry");
			exception = e;
		}
	}

	@Then("the user clicks the recall button")
	public void the_user_clicks_the_recall_button() {
		try {
			fdp.clickRecallBtn();
			fdp.clickRecallConfirmBtn();
			logger.info("User clicked recall button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click recall button");
			exception = e;
		}
	}

	@Then("check upload status page after recall")
	public void check_upload_status_after_recall() {
		try {
			fdp.checkUploadStatusAfterRecall();
			logger.info("If there is an entry after recall, it should be a different date, check above");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check status");
			exception = e;
		}
	}

	@Then("the user clicks the recall button then cancels")
	public void the_user_clicks_the_recall_button_then_cancels() {
		try {
			fdp.clickRecallBtn();
			fdp.clickRecallPopUpCancelButton();
			logger.info("User clicked recall button then canceled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click recall button or cancel button");
			exception = e;
		}
	}

	@Then("the recall button is no longer displayed")
	public void the_recall_button_is_no_longer_displayed() {
		try {
			Assert.assertTrue(fdp.checkRecallNotDisplayed());
			logger.info("Recall button is no longer displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Recall button is displayed");
			exception = e;
		}
	}
}
