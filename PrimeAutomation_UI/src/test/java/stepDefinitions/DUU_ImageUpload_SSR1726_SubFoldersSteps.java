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
import pages.SelectedActivityPage;
import pages.UploadFilePage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1726_SubFoldersSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1726_SubFoldersSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FileUploadPage fuP = new FileUploadPage();
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

	@Then("the Site selection screen is displayed with")
	public void the_site_selection_screen_is_displayed_with(List<Map<String,String>> dt) throws IOException, InterruptedException {
		try {
			Assert.assertTrue(fuP.isSiteSelectionScreenDisplayed());
			logger.info("Step : the Site selection screen is displayed with");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the Surgeon selection screen is displayed with")
	public void the_surgeon_selection_screen_is_displayed_with(List<Map<String,String>> dt) throws IOException, InterruptedException {
		try {
			Assert.assertTrue(fuP.isSurgeonSelectionScreenDisplayed());
			logger.info("Step : the Surgeon selection screen is displayed with");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the Application selection screen is displayed with")
	public void the_application_selection_screen_is_displayed_with(List<Map<String,String>> dt) throws IOException, InterruptedException {
		try {
			Assert.assertTrue(fuP.isapplicationSelectionScreenDisplayed());
			for(Map<String,String> component:dt) {
				if(component.get("componenets").contains("highlighted")){
					Assert.assertTrue(fuP.isApplicationSelected());
				}
			}
			logger.info("Step : the Application selection screen is displayed with");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("user clicks on back button in upload screen")
	public void user_clicks_on_back_button_in_upload_screen() throws IOException, InterruptedException {
		try {
			fuP.clickBackBtnInUploadScreen();
			logger.info("Step : user clicks on back button in upload screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("the user clicks on Next button in application selection screen")
	public void the_user_clicks_on_next_button_in_application_selection_screen() throws IOException, InterruptedException {
		try {
			fuP.clickNextBtn();
			logger.info("Step : the user clicks on Next button in application selection screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer")
	public void select_folder_to_upload_pop_up_is_displayed_with_upload_and_cancel_buttons_along_with_folders_in_users_computer() throws IOException, InterruptedException {
		try {
			ufP.selectFolderPopUpIsDisplayed();
			logger.info("Step : Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("the user clicks on cancel button in Select Folder to upload pop-up")
	public void the_user_clicks_on_cancel_button_in_select_folder_to_upload_pop_up() throws IOException, InterruptedException {
		try {
			ufP.clickCancelInSelectFilePopUp();
			logger.info("Step : the user clicks on Next button in application selection screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("user selects dataset with {string} and click on upload button")
	public void user_selects_dataset_with_and_click_on_upload_button(String string) throws IOException, InterruptedException {
		try {
			String folderName = null;
			if(string.equalsIgnoreCase("four patients"))
			{
				folderName = "Subfolder";
			}
			else if(string.equalsIgnoreCase("consists of 2 sub folders with Invalid DICOM files of 2 patients in each sub folder"))
			{
				folderName = "subfolder invalid";
			}
			else if(string.equalsIgnoreCase("size more than 3 GB"))
			{
				folderName = "more than 3gb";
			}
			else if(string.equalsIgnoreCase("non-DICOM file"))
			{
				folderName = "non_dicom";
			}
			else if(string.equalsIgnoreCase("consists of 1 sub folder with Invalid DICOM files"))
			{
				folderName = "subfolder non dicom";
			}
			else if(string.equalsIgnoreCase("an empty folder"))
			{
				folderName = "no image";
			}
			else if(string.equalsIgnoreCase("500 mb"))
			{
				folderName = "more than 500 mb";
			}
			ufP.uploadFile(folderName);
			logger.info("Step : user selects dataset and click on upload button");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("the user is able to view pop-up with Number of files  confirming to upload")
	public void the_user_is_able_to_view_pop_up_with_number_of_files_confirming_to_upload() throws IOException, InterruptedException {
		try {
			ufP.alertIsDisplayed();
			logger.info("Step : the user is able to view pop-up with Number of files  confirming to upload");
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("the user clicks on upload button in the popup and record the time")
	public void the_user_clicks_on_upload_button_in_the_popup_and_record_the_time() throws IOException, InterruptedException {
		try {
			ufP.clickUploadInAlert();
			logger.info("Step : the user clicks on upload button in the popup and record the time");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("the user is redirected to Image uploading screen with")
	public void the_user_is_redirected_to_image_uploading_screen_with(List<Map<String,String>> dt) throws IOException, InterruptedException {
		try {
			Assert.assertTrue(fuP.isImageUploadScreenDisplayed());
			logger.info("Step : the user is redirected to Image uploading screen with");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("the user wait until the file upload is done")
	public void the_user_wait_until_the_file_upload_is_done() throws IOException {
		try {
			fuP.waitUntilUploadIsFinished();
			logger.info("Step : the user wait until the file upload is done");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("upload successful screen is displayed with")
	public void upload_successful_screen_is_displayed_with(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			Assert.assertTrue(fuP.isuploadSuccessDisplayed());
			logger.info("Step : upload successful screen is displayed with");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("Click on Dashboard button in the upload screen")
	public void click_on_dashboard_button_in_the_upload_screen() throws IOException {
		try {
			fuP.clickDasboardBtnInSuccessScreen();
			logger.info("Step : Click on Dashboard button in the upload screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("Record details of {string} patients displayed")
	public void record_details_of_patients_displayed(String string) throws IOException {
		try {
			if(string.contains("four")) {
				fP.logRecordsInSummaryDashboard(4);
			}
			else if(string.contains("first")) {
				fP.logRecordsInSummaryDashboard(1);
			}
			logger.info("Step : Record details of patients displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the details of {string} matches with uploaded files")
	public void the_details_of_four_patients_matches_with_uploaded_files(String string) throws IOException {
		try {
			if(string.contains("four patients")){
				Assert.assertTrue(fP.verify4Patients());
			}
			else if(string.contains("500 mb")){
				Assert.assertTrue(fP.verify500MbPatient());
			}
			logger.info("Step : the details of four patients matches with uploaded files");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen")
	public void date_time_recorded_organization_surgeon_application_and_status_as_uploaded_is_displayed_in_upload_status_screen() throws IOException, ParseException {
		try {
			ufP.checkUploadStatusFirstRecordMatchesLastUpload();
			logger.info("Step : Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("self linked site is default selected and click on Next button")
	public void self_linked_site_is_default_selected_and_click_on_Next_button() throws IOException, InterruptedException {
		try {
			Assert.assertTrue(fuP.isSiteSelected());
			fuP.clickNextBtn();
			logger.info("Step: self linked site is default selected and click on Next button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the Upload failure screen is displayed with")
	public void the_upload_failure_screen_is_displayed_with(List<Map<String,String>> list) throws IOException {
		Assert.assertTrue(fuP.isuploadFailureScreenDisplayed());
		for(Map<String,String> dt:list) {
			if(dt.get("components").equalsIgnoreCase("The selected file(s) may be an invalid DICOM file(s) or missing the following mandatory DICOM tag(s): Patient Name, Date of Birth, or Patient ID")){
				Assert.assertTrue(fuP.errorMessageForInvalidAndMissingTags());
			}
			if(dt.get("components").equalsIgnoreCase("The Name of failed upload file")){
				Assert.assertTrue(fuP.fileNameIsDisplayed());
			}
			if(dt.get("components").equalsIgnoreCase("The total size of the selected file(s) exceeds the limit of 3 GB")){
				Assert.assertTrue(fuP.errorMessageForMoreThan3Gb());
			}
			if(dt.get("components").equalsIgnoreCase("The selected file(s) are not valid DICOM file(s)")){
				Assert.assertTrue(fuP.errorMessageForNonDicomFile());
			}
		}
		logger.info("Step: the Upload failure screen is displayed with");
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	}
	
	@Then("Yellow\\(dot) notification symbol is {string} on left menu for Upload Status screen")
	public void yellow_dot_notification_symbol_is_on_left_menu_for_upload_status_screen(String string) throws IOException {
		if(string.equals("displayed")){
	    	Assert.assertTrue(fuP.isYellowDotForUploadStatusDisplayed());
	    }
	    else {
	    	Assert.assertFalse(fuP.isYellowDotForUploadStatusDisplayed());
	    }
		logger.info("Step: Yellow dot notification symbol is "+string+" on left menu for Upload Status screen");
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	}
	
	@Then("Files uploaded is not displayed")
	public void files_uploaded_is_not_displayed() throws IOException {
		fP.logDisplayedRecords();
		logger.info("Step: Files uploaded is not displayed");
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	}
	@Then("Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen")
	public void date_time_recorded_organization_surgeon_application_and_status_as_failed_is_displayed_in_upload_status_screen() throws IOException, ParseException {
		Assert.assertTrue(ufP.isFailedStatusShown());
		logger.info("Step: Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen");
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	}
	
	@When("the user clicks on upload status from left menu bar")
	public void the_user_clicks_on_upload_status_button_from_left_menu_bar() {
		try {
			saPage.clickOnUploadStatusButton();
			logger.info("Step: the upload status button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
