package stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
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
import pages.HistoryViewScreenPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_History_SSR1836_FileStatusSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_History_SSR1836_FileStatusSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FileDashboardPage daPage = new FileDashboardPage();
	HistoryViewScreenPage hp = new HistoryViewScreenPage();
	SelectedActivityPage sap = new SelectedActivityPage();

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
	@When("User clicks on History button from homepage")
	public void user_clicks_on_history_button_from_homepage() {
		try {
			hp.clickOnHistory();
			logger.info("Step: History Button is clicked from left panel");
			hp.isHistoryHeaderDisplayed();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// *********************THEN BLOCK*******************************
	@Then("below components should be displayed")
	public void below_components_should_be_displayed(List<Map<String, String>> dt) {
		try {

			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("coloumn").contains("Date")) {
					assertTrue(hp.isHistoryColoumnsDisplayed("Date").isDisplayed(), "Date coloumn is not displayed");
					logger.info("Date Coloumn is displayed");
				}
				if (list.get(i).get("coloumn").contains("Upload ID")) {
					assertTrue(hp.isHistoryColoumnsDisplayed("Upload ID").isDisplayed(),
							"Upload ID coloumn is not displayed");
					logger.info("Upload ID Coloumn is displayed");
				}
				if (list.get(i).get("coloumn").contains("Upload User")) {
					assertTrue(hp.isHistoryColoumnsDisplayed("Upload User").isDisplayed(),
							"Upload User coloumn is not displayed");
					logger.info("Upload User Coloumn is displayed");
				}
				if (list.get(i).get("coloumn").contains("Patient")) {
					assertTrue(hp.isHistoryColoumnsDisplayed("Patient").isDisplayed(),
							"Patient coloumn is not displayed");
					logger.info("Patient Coloumn is displayed");
				}

				if (list.get(i).get("coloumn").contains("Doctor")) {
					assertTrue(hp.isHistoryColoumnsDisplayed("Doctor").isDisplayed(),
							"Doctor coloumn is not displayed");
					logger.info("Doctor Coloumn is displayed");
				}
				if (list.get(i).get("coloumn").contains("Hospital")) {
					assertTrue(hp.isHistoryColoumnsDisplayed("Hospital").isDisplayed(),
							"Hospital coloumn is not displayed");
					logger.info("Hospital Coloumn is displayed");
				}

				if (list.get(i).get("coloumn").contains("Status")) {
					assertTrue(hp.isHistoryColoumnsDisplayed("Status").isDisplayed(),
							"Status coloumn is not displayed");
					logger.info("Status Coloumn is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("History components are not displayed");
			exception = e;
		}
	}

	@Then("File status is displayed under Status coloumn to the user.")
	public void uploaded_status_is_displayed_under_status_coloumn_to_the_user() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hp.isHistoryRecordsDisplayed());
			logger.info("Step: File status is displayed on History records");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the File upload screen is displayed")
	public void the_File_upload_screen_is_displayed() {
		try {
			logger.info("Step: the File upload screen is displayed");
			Assert.assertTrue(sap.isDashboardHeaderDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the records are displayed in tabular format with")
	public void the_records_are_displayed_in_tabular_format_with(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try{
			logger.info("Step: the records are displayed in tabular format with");
			Assert.assertTrue(daPage.records_are_in_tabular_format());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the Record uploaded is displayed at the top of the Upload dashboard screen with {string} status")
	public void the_record_uploaded_is_displayed_at_the_top_of_the_upload_dashboard_screen_with_status(String string) throws IOException {
		try{
			String ssname = "the Record uploaded is displayed at the top of the Upload dashboard screen with "+string+" status";
			logger.info("Step: "+ ssname);
			Properties properties = reader.getProperty();
			Assert.assertTrue(daPage.verifyMostRecentUploadinFileDashboard(0,properties.getProperty("available.site1.surgeon1"),properties.getProperty("validdicom1.patientname"),properties.getProperty("available.application1")));
			Assert.assertEquals(daPage.getUploadStatusIconTitle(), string);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("on mouse hover on Uploaded icon system should display the Uploaded status name")
	public void on_mouse_hover_on_uploaded_icon_system_should_display_the_uploaded_status_name() throws IOException, InterruptedException {
	    try{
	    	logger.info("Step: on mouse hover on Uploaded icon system should display the Uploaded status name");
	    	Assert.assertTrue(daPage.mouseHoverOnUploadIcon());
	    	screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("history screen is displayed")
	public void history_screen_is_displayed() throws IOException {
		try {
			logger.info("Step: history screen is displayed");
			Assert.assertTrue(hp.isHistoryPageHeaderDisplayed("date").isDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		} 
	}

	@Then("the status {string} is displayed under Status column for the record uploaded")
	public void the_status_is_displayed_under_status_column_for_the_record_uploaded(String string) throws IOException, InterruptedException {
		try{
			String ssname = "the status "+string+" is displayed under Status column for the record uploaded";
			logger.info("Step: "+ ssname);
			Assert.assertEquals(hp.uploadStatusInHistory(), string);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the recall button is displayed for the recently uploaded record")
	public void the_recall_button_is_displayed_for_the_recently_uploaded_record() throws IOException, InterruptedException {
		try{
			logger.info("Step: the recall button is displayed for the recently uploaded record");
			Thread.sleep(30000);
			Assert.assertTrue(daPage.isRecallBtnDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		} 
	}
	
	@When("the user clicks recall button")
	public void the_user_clicks_recall_button() throws IOException {
		try {
			logger.info("Step: the user clicks recall button");
			daPage.clickRecallBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		} 
	}

	@Then("confirmation pop up for recall is displayed")
	public void confirmation_pop_up_for_recall_is_displayed() throws IOException {
		try {
			logger.info("Step: confirmation pop up for recall is displayed");
			Assert.assertTrue(daPage.isRecallpopupDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		} 
	}

	@When("the user clicks on confirm button in recall popup")
	public void the_user_clicks_on_confirm_button_in_recall_popup() throws IOException {
		try {
			logger.info("Step: the user clicks on confirm button in recall popup");
			daPage.clickRecallConfirmBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		} 
	}

	@Then("the record uploaded is disappeared from upload dashboard screen")
	public void the_record_uploaded_is_disappeared_from_upload_dashboard_screen() throws IOException {
		try {
			logger.info("Step: the record uploaded is disappeared from upload dashboard screen");
			Assert.assertFalse(daPage.isRecallBtnDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		} 
	}

	@Then("record the uploadId of the file uploaded")
	public void record_the_uploadid_of_the_file_uploaded() throws IOException {
		try {
			
			hp.printUploadId();
			logger.info("Step: the uploadId is viewed and saved");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		} 
	}

}
