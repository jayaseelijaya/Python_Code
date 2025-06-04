package stepDefinitions;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

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

public class DUU_ImageUpload_SSR1722_SelectFolderForUploadSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1722_SelectFolderForUploadSteps.class);
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
			Assert.fail();
			logger.info("TESTCASE HAS FAILED AT THIS STEP");
		}
	}
	@When("the user selects a dataset with invalid files and click on upload button")
	public void the_user_selects_a_dataset_with_invalid_files_and_click_on_upload_button() {
		try {
			
			ufP.uploadFile("invalid");
			logger.info("Step : user selects dataset and click on upload button");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the user is redirected to Image uploading failure screen with")
	public void the_user_is_redirected_to_image_uploading_failure_screen_with(List<Map<String,String>> dt) {
		try {
			logger.info("Step : the user is redirected to Image uploading Failure screen with");
			Assert.assertTrue(fuP.isImageUploadFailureScreenDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on the Start New Upload Button")
	public void the_user_clicks_on_the_start_new_upload_button() {
		try {
			   
	    	   fuP.clickStartNewUpload();
	    	   logger.info("User clicks Start New Upload button in Upload failure Screen");
			   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		   } catch (Exception e) {
			   Assert.fail("Unable to click Start New Upload button");
			   logger.error("Step: Caught Exception:: " + e.toString());
			   exception = e;
		   }
	}

	@When("User selects a dataset with more than 3GB file size")
	public void user_selects_a_dataset_with_more_than_3gb_file_size() {
		try {
			
			ufP.uploadFile("3GbData");
			logger.info("Step : user selects dataset and click on upload button");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects a dataset with valid DICOM files and click on upload button")
	public void the_user_selects_a_dataset_with_valid_dicom_files_and_click_on_upload_button() {
		try {
			
			ufP.uploadFile("same_ePHI");
			logger.info("Step : user selects dataset and click on upload button");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}

	@Then("the record details in the summary dashboard is recorded")
	public void the_record_details_in_the_summary_dashboard_is_recorded() {
		try {
			logger.info("Step : The Details of the uplaoded files is dispalyed as a first record in the File Dashboard Page");
			fP.firstRecordValues();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
		}
}