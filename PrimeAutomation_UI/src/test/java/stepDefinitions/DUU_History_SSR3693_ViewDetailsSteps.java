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
import pages.FileUploadPage;
import pages.HelpInfoPage;
import pages.HistoryViewScreenPage;
import pages.LoginPage;
import pages.SettingsPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_History_SSR3693_ViewDetailsSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_History_SSR3693_ViewDetailsSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	HistoryViewScreenPage hvsPage = new HistoryViewScreenPage();
	FileDashboardPage fdpPage = new FileDashboardPage();
	FileUploadPage fuPage = new FileUploadPage();

	int initialDashboardEntries;
	int firstFilterDashboardEntries;

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
	
	@Then("User clicks on Upload Status button from homepage")
	public void click_upload_status_page() {
		try {
			hvsPage.clickUploadStatusPage();
			logger.info("User clicked on upload status button in left menu");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			Thread.sleep(3000);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not click upload status page button");
			exception = e;
		}
	}
	
	@Then("User clicks first entry in upload status page")
	public void user_clicks_first_entry_in_upload_status_page() {
		try {
			hvsPage.clickFirstEntryInUploadStatusPage();
			logger.info("User clicked first entry in upload status page");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not click first entry in upload status table");
			exception = e;
		}
	}
	
	@Then("User checks upload status most recent entry")
	public void check_upload_status_first_entry() {
		try {
			hvsPage.checkUploadStatusFirstEntryDate();
			logger.info("Checking first entry in upload status table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find first entry in upload status table");
			exception = e;
		}
	}
	
	@Then("User clicks view details button in upload status page")
	public void user_clicks_view_details_button_in_upload_status_page() {
		try {
			hvsPage.clickUploadStatusViewDetailsButton();
			logger.info("User clicked view details button in upload status page");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not click view details button in upload status page");
			exception = e;
		}
	}
	
	@Then("The view details success screen shows the check image")
	public void check_success_screen_check_image() {
		try {
			assertTrue(hvsPage.checkViewDetailsImage());
			logger.info("The check mark image is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find check mark image");
			exception = e;
		}
	}
	
	@Then("The view details success screen shows the successful upload text")
	public void check_success_screen_successful_upload_text() {
		try {
			assertTrue(hvsPage.checkViewDetailsSuccessText());
			logger.info("The successful upload text is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find successful upload text");
			exception = e;
		}
	}
	
	@Then("The view details success screen shows the file count text")
	public void check_success_screen_file_count_text() {
		try {
			assertTrue(hvsPage.checkViewDetailsFileCountText());
			logger.info("The file count text is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				logger.error("Could not find file count text");
				exception = e;
		}
	}
	
	@Then("The view details success screen shows the close button")
	public void check_success_screen_close_button() {
		try {
			assertTrue(hvsPage.checkViewDetailsCloseButton());
			logger.info("The close button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find close button");
			exception = e;
		}
	}
	
	@Then("The view details success screen shows the new upload button")
	public void check_success_screen_new_upload_button() {
		try {
			assertTrue(hvsPage.checkViewDetailsNewUploadButton());
			logger.info("The new upload button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find new upload button");
			exception = e;
		}
	}
	
	@Then("The view details success screen shows the dashboard button")
	public void check_success_screen_dashboard_button() {
		try {
			assertTrue(hvsPage.checkViewDetailsDashboardButton());
			logger.info("The dashboard button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find dashboard button");
			exception = e;
		}
	}
	
	@Then("the user selects a site and click next button")
	public void the_user_selects_a_site_and_click_on_next_button() {
		try {
			logger.info("Step: the user selects a site and click on next button");
			fuPage.selectSite(0);
			fuPage.clickNextBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to select site from list");
			exception = e;
		}
	}
	
	@Then("the user selects a surgeon and click next button")
	public void the_user_selects_a_surgeon_and_click_on_next_button() {
		try {
			logger.info("Step: the user selects a surgeon and click on next button");
			fuPage.selectSurgeon(0);
			fuPage.clickNextBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to select surgeon from list");
			exception = e;
		}
	}
	

	@Then("the user selects an application and click next button")
	public void the_user_selects_an_application_and_click_on_next_button() {
		try {
			logger.info("Step: the user selects an application and click on Next button");
			fuPage.selectApplication();
			fuPage.clickNextBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to select application from list");
			exception = e;
		}
	}
	
	@Then("the user clicks on the first entry in the history page")
	public void user_clicks_first_entry_in_history_page() {
		try {
			hvsPage.clickFirstEntryHistoryTable();
			logger.info("User clicked first entry in history page");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click first entry in history page");
			exception = e;
		}
	}
	
	@Then("the user clicks the view details button in the history page")
	public void user_clicks_view_details_button_in_history_page() {
		try {
			hvsPage.clickViewDetailsButton();
			logger.info("User clicked view details button in history page");
			Thread.sleep(3000);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click view details button in history page");
			exception = e;
		}
	}
	
	@Then("print the id of the entry")
	public void print_id_of_entry() {
		try {
			hvsPage.printIdOfEntry();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find id of the entry");
			exception = e;
		}
	}
	
	@Then("check the total file size of the entry")
	public void check_total_file_size_of_entry() {
		try {
			assertTrue(hvsPage.checkTotalFileSizeOfEntry());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find total file size of entry");
			exception = e;
		}
	}
	
	@Then("print the uploader of the entry")
	public void print_uploader_of_entry() {
		try {
			hvsPage.printUploaderOfEntry();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find uploader of entry");
			exception = e;
		}
	}
	
	@Then("check the patient of the entry")
	public void check_patient_of_entry() {
		try {
			assertTrue(hvsPage.checkPatientOfEntry());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find patient of entry");
			exception = e;
		}
	}
	
	@Then("print the doctor of the entry")
	public void print_doctor_of_entry() {
		try {
			hvsPage.printDoctorOfEntry();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find doctor of entry");
			exception = e;
		}
	}
	
	@Then("print the organization of the entry")
	public void print_organization_of_entry() {
		try {
			hvsPage.printOrganizationOfEntry();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find organization of entry");
			exception = e;
		}
	}
	
	@Then("check the application of the entry")
	public void check_application_of_entry() {
		try {
			assertTrue(hvsPage.checkApplicationOfEntry());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find application of entry");
			exception = e;
		}
	}
	
	@Then("print the upload begin of the entry")
	public void print_upload_begin_of_entry() {
		try {
			hvsPage.printUploadBeginOfEntry();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find upload begin of entry");
			exception = e;
		}
	}
	
	@Then("print the upload end of the entry")
	public void print_upload_end_of_entry() {
		try {
			hvsPage.printUploadEndOfEntry();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find upload end of entry");
			exception = e;
		}
	}
	
	@Then("print the new status of the entry")
	public void print_new_status_of_entry() {
		try {
			hvsPage.printNewStatusOfEntry();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find new status of entry");
			exception = e;
		}
	}
	
	@Then("Upload successful screen is displayed")
	public void check_upload_successful_screen() {
		try {
			assertTrue(hvsPage.checkUploadSuccessfulScreen());
			logger.info("Upload Successful Screen displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Upload successful screen not displayed");
			exception = e;
		}
	}
	
	@Then("the upload id from view details shall be matched with history screen")
	public void the_upload_id_from_view_details_shall_be_matched_with_history_screen() {
		try {
			assertTrue(hvsPage.isUploadIDMatched());
			logger.info("Upload id on history screen is matched with view details popup");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Upload successful screen not displayed");
			exception = e;
		}
	}
	
	@Then("the uploader name from view details shall be matched with history screen")
	public void the_uploader_name_from_view_details_shall_be_matched_with_history_screen() {
		try {
			assertTrue(hvsPage.isUploadNameMatched());
			logger.info("Uploader user name on history screen is matched with view details popup");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Upload successful screen not displayed");
			exception = e;
		}
	}
	
	@Then("the patient from view details shall be matched with history screen")
	public void the_patient_from_view_details_shall_be_matched_with_history_screen() {
		try {
			assertTrue(hvsPage.isPatientNameMatched());
			logger.info("Uploader patient name on history screen is matched with view details popup");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Upload successful screen not displayed");
			exception = e;
		}
	}
	
	@Then("the doctor from view details shall be matched with history screen")
	public void the_doctor_from_view_details_shall_be_matched_with_history_screen() {
		try {
			assertTrue(hvsPage.isDoctorNameMatched());
			logger.info("Uploader doctor name on history screen is matched with view details popup");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Upload successful screen not displayed");
			exception = e;
		}
	}
	
	@Then("the organization from view details shall be matched with history screen")
	public void the_organization_from_view_details_shall_be_matched_with_history_screen() {
		try {
			assertTrue(hvsPage.isHospitalNameMatched());
			logger.info("Uploader organization name on history screen is matched with view details popup");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Upload successful screen not displayed");
			exception = e;
		}
	}
	
	@Then("the new status from view details shall be matched with history screen")
	public void the_new_status_from_view_details_shall_be_matched_with_history_screen() {
		try {
			assertTrue(hvsPage.isStatusMatched());
			logger.info("Uploader status name on history screen is matched with view details popup");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Upload successful screen not displayed");
			exception = e;
		}
	}
}