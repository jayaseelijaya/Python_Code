package stepDefinitions;

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
import pages.MultipleFilterPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_AuditLog_SSR1783_AuditLogUserActivitySteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_AuditLog_SSR1783_AuditLogUserActivitySteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	AuditLogPage alPage = new AuditLogPage();
	SelectedActivityPage saPage = new SelectedActivityPage();
	MultipleFilterPage mfPage = new MultipleFilterPage();

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
		@When("the user clicks on recall button")
		public void the_user_clicks_on_recall_button() {
			try {
				alPage.clickOnRecallButton();
				logger.info("Step: the recall button is clicked");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user clicks on acknowedge button")
		public void the_user_clicks_on_acknowedge_button() {
			try {
				alPage.clickOnAcknowledgeButton();
				logger.info("Step: the recall button is clicked");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user changes the value of successful upload")
		public void the_user_changes_the_value_of_successful_upload() {
			try {
				alPage.enterValueinSuccessfulUpload();
				logger.info("Step: the user has changed the value of successful upload as 10");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user changes the value of unsuccessful upload")
		public void the_user_changes_the_value_of_unsuccessful_upload() {
			try {
				alPage.enterValueinUnsuccessfulUpload();
				logger.info("Step: the user has changed the value of unsuccessful upload as 12");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user clicks on gloabl viewing toggle button")
		public void the_user_clicks_on_gloabl_viewing_toggle_button() {
			try {
				alPage.clickOnToggleButton();
				logger.info("Step: the user clicked on toggle button");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user clicks on save button on settings tab")
		public void the_user_clicks_on_save_button_on_settings_tab() {
			try {
				alPage.clickOnSaveButton();
				logger.info("Step: the user clicked on save button");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user removes text in searchbox on dashbaord")
		public void the_user_removes_text_in_searchbox_on_dashbaord() {
			try {
				alPage.removeTextInSearchbox();
				logger.info("Step: the user removed text from searchbox on dashboard");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user selects 24hrs filters on dashboard")
		public void the_user_selects_24hrs_filters_on_dashboard() {
			try {
				alPage.clickOn24hrsFilterOnDashboard();
				logger.info("Step: the 24hrs filter is applied");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("user removes search text from search bar on history")
		public void user_removes_search_text_from_search_bar_On_history() {
			try {
				alPage.removeTextInSearchboxOnHistory();
				logger.info("Step: the user removed text from searchbox on history");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user selects 24hrs filter on audit log")
		public void the_user_selects_24hrs_filter_on_audit_log() {
			try {
				alPage.clickOn24hrsFilterOnDashboard();
				logger.info("Step: the 24hrs filter is applied");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("user removes search text from search bar on auditlog")
		public void user_removes_search_text_from_search_bar_on_auditlog() {
			try {
				alPage.removeTextInSearchboxOnAuditLog();
				logger.info("Step: the user removed text from searchbox on auditlog");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
	
	// *********************THEN BLOCK*******************************
	@Then("the audit log shall display file upload action logs performed by user")
	public void the_audit_log_shall_display_file_upload_action_logs_performed_by_user() {
		try {
			Assert.assertTrue(alPage.isActionPerformedLogsDisplayed());
			logger.info("Step: The audit log dipslyed the upload files action performed by user");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the recall button shall be displayed for uploaded files")
	public void the_recall_button_shall_be_displayed_for_uploaded_files() {
		try {
			Assert.assertTrue(alPage.isRecallButtonDisplayed());
			logger.info("Step: The uploaded files record displayed with recall button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the yellow dot notification shall be disappeared")
	public void the_yellow_dot_notification_shall_be_disappeared() {
		try {
			Assert.assertTrue(alPage.isYellowDotDisappeared());
			logger.info("Step: The yellow dot notification is disappearead");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the image linking tab shall be displayed")
	public void the_image_linking_tab_shall_be_displayed() {
		try {
			Assert.assertTrue(saPage.isImagingLinksHeaderDisplayed());
			logger.info("Step: The yellow dot notification is disappearead");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the dashbaord shall display records based on 24hrs filters")
	public void the_dashbaord_shall_display_records_based_on_24hrs_filters() {
		try {
			Assert.assertTrue(mfPage.isAllItemsDisplayedOnDashboard());
			logger.info("Step: The dashboard displayed records based on 24hrs filters");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
