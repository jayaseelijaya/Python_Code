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
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.UploadFilePage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1809_FeedbackOnUploadProgressSteps {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1809_FeedbackOnUploadProgressSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	UploadFilePage ufP = new UploadFilePage();
	FileDashboardPage fP = new FileDashboardPage();
	SelectedActivityPage saPage = new SelectedActivityPage();

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

	//*************************WHEN**************************************
	@When("user selects valid dicom dataset and clicks on upload button")
	public void user_selects_valid_dicom_dataset_and_clicks_on_upload_button() throws IOException, InterruptedException {
		try {
			ufP.uploadFile("valid");
			logger.info("Step : The user selects valid dataset and clicks on upload button");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects record with uploaded status")
	public void the_user_selects_record_with_uploaded_status() throws IOException, InterruptedException {
		try {
			fP.selectUploadedStatusRecord();
			logger.info("Step : The user selected record with status uploaded");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on view details button")
	public void the_user_clicks_on_view_details_button() throws IOException, InterruptedException {
		try {
			fP.clickonViewDetailsButton();
			logger.info("Step : The user clicked view detials button");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on cancel upload button on upload successful screen")
	public void the_user_clicks_on_cancel_upload_button_on_upload_successful_screen() throws IOException, InterruptedException {
		try {
			fP.clickonCancelButton();
			logger.info("Step : The user clicked cancel upload button on upload screen");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user selects valid dicom dataset of 500MB and clicks on upload button")
	public void user_selects_valid_dicom_dataset_of_500mb_and_clicks_on_upload_button() throws IOException, InterruptedException {
		try {
			ufP.uploadFile("valid500MB");
			logger.info("Step : The user selects valid dataset of 500MB and clicks on upload button");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects record with uploading status")
	public void the_user_selects_record_with_uploading_status() throws IOException, InterruptedException {
		try {
			fP.selectUploadingStatusRecord();
			logger.info("Step : The user selected record with status uploading");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on start new upload button from progress screen")
	public void the_user_clicks_on_start_new_upload_button_from_progress_screen() throws IOException, InterruptedException {
		try {
			fP.clickOnStartNewUploadButton();
			logger.info("Step : The user clicked start new upload button from progress screen");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user selects invalid dicom dataset and clicks on upload button")
	public void user_selects_invalid_dicom_dataset_and_clicks_on_upload_button() throws IOException, InterruptedException {
		try {
			ufP.uploadFile("invalid");
			logger.info("Step : The user selects invalid dataset and clicks on upload button");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user selects valid and non dicom dataset and clicks on upload button")
	public void user_selects_valid_and_non_dicom_dataset_and_clicks_on_upload_button() throws IOException, InterruptedException {
		try {
			ufP.uploadFile("valid_DICOM_non_DICOM");
			logger.info("Step : The user selects invalid dataset and clicks on upload button");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on close button on upload successful screen")
	public void the_user_clicks_on_close_button_on_upload_successful_screen() throws IOException, InterruptedException {
		try {
			fP.clickOnCloseButton();
			logger.info("Step : The close button is clicked on upload successful screen");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	

	
	//*************************THEN**************************************
	
	@Then("Record details of most recent uploaded patient displayed")
	public void record_details_of_most_recent_uploaded_patient_displayed() throws IOException {
		try {
			Assert.assertTrue(fP.mostRecentPatientRecordDetails());
			logger.info("Step : Record details of most recent patients is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the upload status screen shall be displayed")
	public void the_upload_status_screen_shall_be_displayed() throws IOException {
		try {
			Assert.assertTrue(saPage.isUploadStatusHeaderDisplayed());
			logger.info("Step : The upload status screen is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen")
	public void date_time_recorded_organization_surgeon_application_and_status_as_uploading_is_displayed_in_upload_status_screen() throws IOException, ParseException {
		try {
			Thread.sleep(1000);
			Assert.assertTrue(fP.checkUploadingStatusRecordDetails());
			logger.info("Step : Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("Date Time recorded,Organization,Surgeon,Application and Status as Cancelled is displayed in Upload Status screen")
	public void date_time_recorded_organization_surgeon_application_and_status_as_cancelled_is_displayed_in_upload_status_screen() throws IOException, ParseException {
		try {
			
			Assert.assertTrue(fP.checkCancelledStatusRecordDetails());
			logger.info("Step : Date Time recorded,Organization,Surgeon,Application and Status as Cancelled is displayed in Upload Status screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the view details button shall be disabled for cancelled record")
	public void the_view_details_button_shall_be_disabled_for_cancelled_record() throws IOException {
		try {
			Assert.assertFalse(fP.isViewDetailsDisabledForCancelled());
			logger.info("Step : The view details button is disabled for cancelled record");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected files are not valid dicom files text shall be displayed")
	public void the_selected_files_are_not_valid_dicom_files_text_shall_be_displayed() throws IOException {
		try {
			Assert.assertTrue(fP.isInvalidDicomMsgTextDisplayed());
			logger.info("Step : The selected files are not valid dicom files text is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("upload fail screen shall be displayed along with failed message")
	public void upload_fail_screen_shall_be_displayed_along_with_failed_message() throws IOException {
		try {
			Assert.assertTrue(fP.isUploadFailedMessageDisplayed());
			logger.info("Step : The upload failed failed logo are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the yellow progress bar shall be displayed")
	public void the_yellow_progress_bar_shall_be_displayed() throws IOException {
		try {
			Assert.assertTrue(fP.isYellowBarDisplayed());
			logger.info("Step : The yellow bar is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the start new button shall be displayed")
	public void the_start_new_button_shall_be_displayed() throws IOException {
		try {
			Assert.assertTrue(fP.isStartNewButtonDisplayed());
			logger.info("Step : The Start new button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("re-upload button shall be displayed and highlighted in green color")
	public void re_upload_button_shall_be_displayed_and_highlighted_in_green_color() throws IOException {
		try {
			Assert.assertTrue(fP.isReuploadButtonDisplayed());
			logger.info("Step : The Re-upload button is displayed and highlighted in green color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the breadcrumb list of selected site, surgeon and application shall be displayed at top")
	public void the_breadcrumb_list_of_selected_site_surgeon_and_application_shall_be_displayed_at_top() throws IOException {
		try {
			Assert.assertTrue(fP.isBreadcrumbListDisplayed());
			logger.info("Step : The Breadcrumb list of selected site, surgeon and application is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the yellow dot shall be displayed as soon as upload failed")
	public void the_yellow_dot_shall_be_displayed_as_soon_as_upload_failed() throws IOException {
		try {
			Assert.assertTrue(fP.isYellowDotDisplayedForUploadFailed());
			logger.info("Step : The yellow dot is displayed for upload failed status");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the upload success screen shall be displayed")
	public void the_upload_success_screen_shall_be_displayed() throws IOException {
		try {
			Assert.assertTrue(fP.isUploadSuccessScreenDisplayed());
			logger.info("Step : The upload success screen is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the upload successful text shall be displayed with tick mark")
	public void the_upload_successful_text_shall_be_displayed_with_tick_mark() throws IOException {
		try {
			Assert.assertTrue(fP.isUploadSuccessfulTextDisplayed());
			logger.info("Step : The upload successful text is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the text x of y files not uploaded files that are not uploaded may be invalid dicom or missing tags shall be displayed")
	public void the_text_x_of_y_files_not_uploaded_files_that_are_not_uploaded_may_be_invalid_dicom_or_missing_tags_shall_be_displayed() throws IOException {
		try {
			Assert.assertTrue(fP.isInvalidDicomOrMissingTagsTextDisplayed());
			logger.info("Step : The text x of y files not uploaded files that are not uploaded may be invalid dicom or missing tags is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("close, start new upload and dashboard buttons shall be displayed")
	public void close_start_new_upload_and_dashboard_buttons_shall_be_displayed() throws IOException {
		try {
			Assert.assertTrue(fP.isCloseButtonDisplayed());
			Assert.assertTrue(fP.isStartNewButtonDisplayed());
			Assert.assertTrue(fP.isDashboardButtonDisplayed());
			logger.info("Step : The close, start new upload and dashboard buttons are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	

}
