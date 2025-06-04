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
import pages.FileDashboardPage;
import pages.FileUploadPage;
import pages.HistoryViewScreenPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.UploadFilePage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR3454_OtherActivitiesSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR3454_OtherActivitiesSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	UploadFilePage uploadFile = new UploadFilePage();
	FileUploadPage fileUpload = new FileUploadPage();
	LoginPage login = new LoginPage();
	HistoryViewScreenPage history = new HistoryViewScreenPage();
	SelectedActivityPage selectedActivity = new SelectedActivityPage();

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

	@When("the user clicks upload button and wait for the upload progress bar to load half a way and then logout")
	public void the_user_clicks_upload_button_and_wait_for_the_upload_progress_bar_to_load_half_a_way_and_then_logout() throws IOException, InterruptedException {
		try {
			uploadFile.clickUploadInAlert();
			Thread.sleep(5000);
			login.clickLogoutButton();
			logger.info("Step: the user clicks upload button and wait for the upload progress bar to load half a way and then logout");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("file uploaded is not displayed in history screen")
	public void file_uploaded_is_not_displayed_in_history_screen() throws IOException {
		try {
			Assert.assertTrue(uploadFile.isUploadNotDisplayedInHistoryScreen());
			logger.info("Step: file uploaded is not displayed in history screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("file uploaded is not displayed in upload status screen")
	public void file_uploaded_is_not_displayed_in_upload_status_screen() throws IOException {
		try {
			Assert.assertTrue(uploadFile.isUploadNotDisplayedInUploadStatusScreen());
			logger.info("Step: file uploaded is not displayed in history screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("user waits for upload to complete")
	public void user_waits_for_upload_to_complete() throws IOException, InterruptedException {
		try {
			fileUpload.selectFirstRecordInUploadStatusScreen();
			history.clickUploadStatusViewDetailsButton();
			fileUpload.waitUntilUploadIsFinished();
			selectedActivity.clickOnUploadStatusButton();
			logger.info("Step: file uploaded is not displayed in history screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
