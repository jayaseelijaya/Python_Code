package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.FileUploadPage;
import pages.LoginPage;
import pages.UploadFilePage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1724_SinglePatientMultipleImagesSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1724_SinglePatientMultipleImagesSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FileUploadPage fuP = new FileUploadPage();
	UploadFilePage ufP = new UploadFilePage();
	FileDashboardPage fP = new FileDashboardPage();

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

	// *************************WHEN**************************************
	@When("user selects dataset with {string} and clicks on upload button")
	public void user_selects_dataset_with_and_clicks_on_upload_button(String string)
			throws IOException, InterruptedException {
		try {
			logger.info("Step : user selects dataset and click on upload button");
			ufP.uploadFile("Subfolder2Patients");
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user selects 3gb dataset with {string} and clicks on upload button")
	public void user_3gb_selects_dataset_with_and_clicks_on_upload_button(String string)
			throws IOException, InterruptedException {
		try {
			logger.info("Step : user selects dataset and click on upload button");
			ufP.uploadFile("SinglePatientMoreThan3GB");
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// *************************THEN**************************************
	@Then("the upload failure screen shall be displayed with following details")
	public void the_upload_failure_screen_shall_be_displayed_with_following_details(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("detail")
						.contains("Breadcrumb of selected Site name, surgeon name application name")) {
					Assert.assertTrue(
							ufP.isUploadFailureScreenDetailsDisplayed(
									"Breadcrumb of selected Site name, surgeon name application name").isDisplayed(),
							"Breadcrumb of selected Site name, surgeon name application name is not displayed");
					logger.info("Breadcrumb of selected Site name, surgeon name application name is displayed");
				}
				if (list.get(i).get("detail").contains("Failed icon")) {
					assertTrue(ufP.isUploadFailureScreenDetailsDisplayed("Failed icon").isDisplayed(),
							"Failed icon is not displayed.");
					logger.info("Failed icon is displayed.");
				}
				if (list.get(i).get("detail").contains("upload failed text")) {
					Assert.assertTrue(ufP.isUploadFailureScreenDetailsDisplayed("upload failed text").isDisplayed(),
							"upload failed text is not displayed");
					logger.info("upload failed text is displayed.");
				}
				if (list.get(i).get("detail").contains("total size exceeded the limit of 3gb message")) {
					assertTrue(ufP.isUploadFailureScreenDetailsDisplayed("total size exceeded the limit of 3gb message")
							.isDisplayed(), "total size exceeded the limit of 3gb message is not displayed.");
					logger.info("total size exceeded the limit of 3gb message is displayed.");
				}
				if (list.get(i).get("detail").contains("yellow progress bar")) {
					assertTrue(ufP.isUploadFailureScreenDetailsDisplayed("yellow progress bar").isDisplayed(),
							"yellow progress bar is not displayed.");
					logger.info("yellow progress bar is displayed.");
				}
				if (list.get(i).get("detail").contains("start new upload and reupload buttons")) {
					assertTrue(ufP.isUploadFailureScreenDetailsDisplayed("start new upload and reupload buttons")
							.isDisplayed(), "start new upload and reupload buttons is not displayed");
					logger.info("start new upload and reupload buttons is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The Upload failure screen details are not displayed");
			exception = e;
		}
	}
}
