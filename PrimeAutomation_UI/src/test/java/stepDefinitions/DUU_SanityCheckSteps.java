package stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.UploadFilePage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SanityCheckSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SanityCheckSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	LoginPage lp = new LoginPage();
	UploadFilePage uf = new UploadFilePage();
	FileUploadPage fuPage = new FileUploadPage();

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
	
	/**
	 * This method is to check all left navigation menu components to verify role based login for Hospital Admin
	 * 
	 * @param dt
	 */
	@Then("Verify Admin Can View the following components in the left menu bar")
	public void verify_admin_can_view_components(List<Map<String, String>> dt) {
		try {
			LoginPage.driver.switchTo().defaultContent();
			lp = new LoginPage();
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("Dashboard")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath").isDisplayed(),
							"The Dashboard button is not displayed");
					logger.info("The Dashboard button is displayed");

				}
				if (list.get(i).get("components").contains("Upload Files")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.uploadfiles.xpath").isDisplayed(),
							"The Upload Files button is not displayed");
					logger.info("The Upload Files button is displayed");
				}

				if (list.get(i).get("components").contains("Upload Status")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath").isDisplayed(),
							"Upload Status button is not displayed");
					logger.info("Upload Status button is displayed");
				}

				if (list.get(i).get("components").contains("History")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath").isDisplayed(), 
							"History button is not displayed");
					logger.info("History button is displayed");
				}
				if (list.get(i).get("components").contains("Audit Log")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.auditlog.xpath").isDisplayed(), 
							"Audit Log button is not displayed.");
					logger.info("Audit Log Out button is displayed");
				}
				if (list.get(i).get("components").contains("Imaging Links")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath").isDisplayed(), 
							"Imaging Links button is not displayed.");
					logger.info("Imaging Links In button is displayed");
				}
				if (list.get(i).get("components").contains("Help")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.help.xpath").isDisplayed(),
							"Help button is not displayed.");
					logger.info("Help button is displayed");
				}
				if (list.get(i).get("components").contains("Info")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.info.xpath").isDisplayed(),
							"Info button is not displayed.");
					logger.info("Info button is displayed");
				}
				if (list.get(i).get("components").contains("Logout")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.logout.xpath").isDisplayed(), 
							"Logout button is not displayed.");
					logger.info("Logout button is displayed");
				}
				if (list.get(i).get("components").contains("Exit to Apps")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.exittoapp.xpath").isDisplayed(), 
							"Exit to Apps button is not displayed.");
					logger.info("Exit to Apps button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all left menu bar items are displayed");
			exception = e;
		}
	}
	
	/**
	 * This method is to click upload status button in left menu bar
	 * 
	 */
	@Then("The user selects Upload Status button from the left menu bar")
	public void user_selects_upload_status_from_left_menu_bar() {
		try {
			utility.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath").click();
			logger.info("User clicked upload status button from the left menu bar");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Could not select upload status");
			exception = e;
		}
	}
	/**
	 * This method is to check that the upload status header is displayed
	 * 
	 */
	@Then("Upload status header is displayed")
	public void check_upload_status_header() {
		try {
			Assert.assertTrue(utility.initializeElement(LoginPage.driver, "uploadstatus.header.xpath").isDisplayed());
			logger.info("Upload status header is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Upload status header is not displayed");
			exception = e;
		}
	}
	
	/**
	 * This method is to check for an empty upload status table
	 * 
	 */
	@Then("No Data to display text is displayed")
	public void check_upload_status_table() {
		try {
			Assert.assertTrue(utility.initializeElement(LoginPage.driver, "uploadstatus.notable.xpath").isDisplayed());
			logger.info("Upload status page does not have any entries");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Upload status page does have entries");
			exception = e;
		}
	}
	
	/**
	 * The user navigates to the upload files page through the left menu bar
	 */
	@Then("User clicks upload files button in left menu bar navigation")
	public void click_upload_files_menu_bar_button() {
		try {
			LoginPage.driver.switchTo().defaultContent();
			utility.initializeElement(LoginPage.driver, "leftnavigation.uploadfiles.xpath").click();
			logger.info("User clicked upload files menu bar button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("User cannot click upload files menu bar button");
			exception = e;
		}
	}
	/**
	 * This method is to check the header of the upload files page
	 * 
	 */
	@Then("The upload files header is displayed")
	public void check_upload_files_header() {
		try {
			Assert.assertTrue(uf.checkUploadFilesHeader());
			logger.info("Upload files page header is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Upload files page header is not displayed");
			exception = e;
		}
	}
	
	@Then("The site selection screen is displayed with the following components")
	public void site_selection_screen_displayed_with_the_following_components(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("working text")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "facility.txt.header.xpath").isDisplayed(),
							"The working text is not displayed");
					logger.info("The working text is displayed");

				}
				if (list.get(i).get("components").contains("search box")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "facility.search.list.xpath").isDisplayed(),
							"The search box is not displayed");
					logger.info("The search box is displayed");
				}

				if (list.get(i).get("components").contains("search text")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath").isDisplayed(),
							"Search text is not displayed");
					logger.info("Search text is displayed");
				}

				if (list.get(i).get("components").contains("table")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "facility.search.list.first.xpath").isDisplayed(), 
							"Table is not displayed");
					logger.info("Table is displayed");
				}
				if (list.get(i).get("components").contains("back button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "facility.btn.back.xpath").isDisplayed(), 
							"Back button is not displayed.");
					logger.info("Back button is displayed");
				}
				if (list.get(i).get("components").contains("next button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "facility.btn.next.xpath").isDisplayed(), 
							"Next button is not displayed.");
					logger.info("Next button is displayed");
				}
				if (list.get(i).get("components").contains("no site text")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "facility.btn.nofacility.xpath").isDisplayed(),
							"No site text is not displayed.");
					logger.info("No site is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all facility select items are displayed");
			exception = e;
		}
	}
	
	/**
	 * This method is to check all components on the surgeon selection page
	 * 
	 * @param dt
	 */
	@Then("Surgeon screen is displayed with the following components")
	public void surgeon_selection_screen_displayed_with_the_following_components(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("surgeon text")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "surgeon.txt.header.xpath").isDisplayed(),
							"The surgeon text is not displayed");
					logger.info("The surgeon text is displayed");

				}
				if (list.get(i).get("components").contains("search box")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "surgeon.search.bar.xpath").isDisplayed(),
							"The search box is not displayed");
					logger.info("The search box is displayed");
				}

				if (list.get(i).get("components").contains("search text")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath").isDisplayed(),
							"Search text is not displayed");
					logger.info("Search text is displayed");
				}

				if (list.get(i).get("components").contains("table")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "surgeon.table.firstentry.xpath").isDisplayed(), 
							"Table is not displayed");
					logger.info("Table is displayed");
				}
				if (list.get(i).get("components").contains("back button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "surgeon.btn.back.xpath").isDisplayed(), 
							"Back button is not displayed.");
					logger.info("Back button is displayed");
				}
				if (list.get(i).get("components").contains("next button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "surgeon.btn.next.xpath").isDisplayed(), 
							"Next button is not displayed.");
					logger.info("Next button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all surgeon select items are displayed");
			exception = e;
		}
	}
	
	/**
	 * This method is to check the components on the application select page
	 * 
	 * @param dt
	 */
	@Then("Application selection screen is displayed with the following components")
	public void application_selection_screen_displayed_with_the_following_components(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("header")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "application.message.xpath").isDisplayed(),
							"The application header is not displayed");
					logger.info("The application header is displayed");

				}
				if (list.get(i).get("components").contains("table")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "upload.applicationcard.xpath").isDisplayed(), 
							"Table is not displayed");
					logger.info("Table is displayed");
				}
				if (list.get(i).get("components").contains("back button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "applicationcard.back.btn.xpath").isDisplayed(), 
							"Back button is not displayed.");
					logger.info("Back button is displayed");
				}
				if (list.get(i).get("components").contains("next button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "applicationcard.next.btn.xpath").isDisplayed(), 
							"Next button is not displayed.");
					logger.info("Next button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all application select items are displayed");
			exception = e;
		}
	}
	
	/**
	 * This method is to check the components on the upload success page
	 * @param dt
	 */
	@Then("Upload successful screen is displayed with the following components")
	public void upload_success_screen_displayed_with_the_following_components(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("header")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "upload.successpageheader.txt.xpath").isDisplayed(),
							"Header is not displayed");
					logger.info("Header is displayed");

				}
				if (list.get(i).get("components").contains("title")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "upload.successheader.txt.xpath").isDisplayed(),
							"Title is not displayed");
					logger.info("Title is displayed");

				}
				if (list.get(i).get("components").contains("icon")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "upload.success.icon.xpath").isDisplayed(), 
							"Success icon is not displayed");
					logger.info("Success Icon is displayed");
				}
				if (list.get(i).get("components").contains("dashboard button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "upload.success.btn.dashboard.xpath").isDisplayed(), 
							"Dashboard button is not displayed.");
					logger.info("Dashboard button is displayed");
				}
				if (list.get(i).get("components").contains("close button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "upload.success.btn.close.xpath").isDisplayed(), 
							"Close button is not displayed.");
					logger.info("Close button is displayed");
				}
				if (list.get(i).get("components").contains("new upload button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "upload.success.btn.newupload.xpath").isDisplayed(), 
							"New upload button is not displayed.");
					logger.info("New upload button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all upload successful components are displayed");
			exception = e;
		}
	}
	
	/**
	 * This method is to check that the entry is found in the upload status table
	 */
	@Then("Entry is found in upload status table")
	public void check_first_entry_in_upload_status_table() {
		try {
			logger.info(utility.initializeElement(LoginPage.driver, "uploadstatus.firstentry.status.txt.xpath").getText());
			logger.info("Entery is found in upload status table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("First entry not found in upload status page");
			exception = e;
		}
	}
	
	/**
	 * This method is to check for the view details button
	 * 
	 */
	@Then("View details button is displayed at bottom")
	public void check_view_details_button() {
		try {
			utility.initializeElement(LoginPage.driver, "uploadstatus.btn.viewdetails.xpath").isDisplayed();
			logger.info("View details button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("View details button not found");
			exception = e;
		}
	}
	
	/**
	 * This method is to check the history screen for the components
	 * 
	 * @param dt
	 */
	@Then("History screen is displayed with the following components")
	public void History_screen_displayed_with_the_following_components(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("24Hr Check")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").isDisplayed(),
							"24 Hour Check is not displayed");
					logger.info("24 Hour Check is displayed");

				}
				if (list.get(i).get("components").contains("filter menu")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "history.filter.xpath").isDisplayed(), 
							"Filter Menu is not displayed");
					logger.info("Filter Menu is displayed");
				}
				if (list.get(i).get("components").contains("search box")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").isDisplayed(), 
							"Search box is not displayed.");
					logger.info("Search box is displayed");
				}
				if (list.get(i).get("components").contains("search button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "history.btn.search.xpath").isDisplayed(), 
							"Search button is not displayed.");
					logger.info("Search button is displayed");
				}
				if (list.get(i).get("components").contains("table")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "history.table.firstrecord.xpath").isDisplayed(), 
							"Table is not displayed.");
					logger.info("Table is displayed");
				}
				if (list.get(i).get("components").contains("view details btn")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "history.btn.viewdetails.xpath").isDisplayed(), 
							"View details button is not displayed.");
					logger.info("View details button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all history components are displayed");
			exception = e;
		}
	}
	
	/**
	 * This method is to wait 15 minutes
	 */
	@Then("Wait 15 minutes")
	public void wait_15_minutes() {
		try {
			logger.info("Waiting 15 minutes");
			Thread.sleep(15 * 60 * 1000);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	/**
	 * This method is to wait 5 minutes
	 */
	@Then("Wait 5 minutes")
	public void wait_5_minutes() {
		try {
			logger.info("Waiting 5 minutes");
			Thread.sleep(5 * 60 * 1000);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	/**
	 * This method is to upload non dicom files
	 */
	@Then("The user uploads non dicom files")
	public void upload_non_dicom_files() {
		try {
			fuPage.uploadFileFromLocal("non_dicom");
			logger.info("User uploaded non dicom files");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to upload non dicom files");
			exception = e;
		}
	}
	
	/**
	 * This method is to upload invalid dicom files
	 */
	@Then("The user uploads invalid dicom files")
	public void upload_invalid_dicom_files() {
		try {
			fuPage.uploadFileFromLocal("invalid");
			logger.info("User uploaded non dicom files");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to upload non dicom files");
			exception = e;
		}
	}
	
	@Then("Upload failed screen is displayed with the following components")
	public void Upload_failed_screen_displayed_with_the_following_components(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("failed text")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "uploadfailed.header.txt.xpath").isDisplayed(),
							"Failed Text is not displayed");
					logger.info("Failed Text is displayed");

				}
				if (list.get(i).get("components").contains("not dicom text")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "uploadfailed.notdicom.xpath").isDisplayed(), 
							"Non Dicom Text is not displayed");
					logger.info("Non Dicom Text is displayed");
				}
				if (list.get(i).get("components").contains("start new upload btn")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "uploadfailed.startnewupload.btn.xpath").isDisplayed(), 
							"Start new upload button is not displayed.");
					logger.info("Start new upload button is displayed");
				}
				if (list.get(i).get("components").contains("re upload btn")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "uploadfailed.reupload.btn.xpath").isDisplayed(), 
							"Re-Upload button is not displayed.");
					logger.info("Re-Upload button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all upload failed components are displayed");
			exception = e;
		}
	}
	
	@Then("Check first two entries status")
	public void check_first_two_entry_status() {
		try {
			logger.info("First entry status: " + utility.initializeElement(LoginPage.driver, "uploadstatus.firstentry.status.txt.xpath").getText());
			logger.info("Second entry status: " + utility.initializeElement(LoginPage.driver, "uploadstatus.secondentry.status.txt.xpath").getText());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to find first and second entry status");
			exception = e;
		}
	}
	
	@Then("Verify first entry in history page")
	public void verify_first_history_entry() {
		try {
			Assert.assertTrue(utility.initializeElement(LoginPage.driver, "history.firstentrypatientname.txt.xpath").isDisplayed());
			logger.info("First Entry in history table is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to find first entry in history table");
			exception = e;
		}
	}
	
	@Then("Verify first entry in audit log")
	public void verify_first_audit_log_entry() {
		try {
			Assert.assertTrue(utility.initializeElement(LoginPage.driver, "auditlog.table.firstentry.xpath").isDisplayed());
			logger.info("Entry found in audit log table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to find first entry in audit log table");
			exception = e;
		}
	}
	
	@Then("Check upload dashboard first entry status")
	public void check_first_entry_upload_status_in_dashboard() {
		try {
			logger.info(utility.initializeElement(LoginPage.driver, "upload.dashboard.firstentry.status.xpath").isDisplayed());
			logger.info("First entry is processing");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to find first entry status");
			exception = e;
		}
	}
	
	@Then("Check first entry status")
	public void check_first_entry_status() {
		try {
			logger.info("First entry status: " + utility.initializeElement(LoginPage.driver, "uploadstatus.firstentry.status.txt.xpath").getText());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to find first and second entry status");
			exception = e;
		}
	}
	
	/**
	 * This method is used to enter the value 1 into the Successful Uploads Input
	 * box
	 * 
	 * @throws IOException
	 */
	@Then("Enter 1 into successful uploads input box")
	public void enter_value_into_successful_uploads_inputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").sendKeys("1");
		logger.info("User entered 20 into the successful upload input box");
	}
	
	/**
	 * This method is to check that all dates on the dashboard are equal
	 * 
	 * @throws IOException
	 * @return Boolean
	 * 
	 */
	@Then("the upload dashboard will display uploads from only today")
	public void checkAllUploadDates() throws IOException {
		List<WebElement> file = utility.initializeElements(LoginPage.driver,
				"summarydashboard.dateoffileuploaded.list.xpath");
		int size = file.size();
		Boolean bool = true;
		logger.info("Total no. of items : " + size);
		String first = file.get(0).getText();
		if (size >= 1) {
			for (int i = 0; i < file.size() - 1; i++) {
				String second = file.get(i).getText();
				if(!first.equals(second)) {
					logger.info(first + " date does not match " + second + " date");
					bool = false;
					break;
				}
			}
			if(bool == true) {
				logger.info("All dates match");
			}
		}
	}
	
	/**
	 * This method is to check all left navigation menu components to verify role based login for Staff
	 * 
	 * @param dt
	 */
	@Then("Verify Staff Can View the following components in the left menu bar")
	public void verify_staff_can_view_components(List<Map<String, String>> dt) {
		try {
			LoginPage.driver.switchTo().defaultContent();
			lp = new LoginPage();
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("Dashboard")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath").isDisplayed(),
							"The Dashboard button is not displayed");
					logger.info("The Dashboard button is displayed");

				}
				if (list.get(i).get("components").contains("Upload Files")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.uploadfiles.xpath").isDisplayed(),
							"The Upload Files button is not displayed");
					logger.info("The Upload Files button is displayed");
				}

				if (list.get(i).get("components").contains("Upload Status")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath").isDisplayed(),
							"Upload Status button is not displayed");
					logger.info("Upload Status button is displayed");
				}

				if (list.get(i).get("components").contains("History")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath").isDisplayed(), 
							"History button is not displayed");
					logger.info("History button is displayed");
				}
				if (list.get(i).get("components").contains("Audit Log")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.auditlog.xpath").isDisplayed(), 
							"Audit Log button is not displayed.");
					logger.info("Audit Log Out button is displayed");
				}
				if (list.get(i).get("components").contains("Imaging Links")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath").isDisplayed(), 
							"Imaging Links button is not displayed.");
					logger.info("Imaging Links In button is displayed");
				}
				if (list.get(i).get("components").contains("Help")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.help.xpath").isDisplayed(),
							"Help button is not displayed.");
					logger.info("Help button is displayed");
				}
				if (list.get(i).get("components").contains("Info")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.info.xpath").isDisplayed(),
							"Info button is not displayed.");
					logger.info("Info button is displayed");
				}
				if (list.get(i).get("components").contains("Logout")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.logout.xpath").isDisplayed(), 
							"Logout button is not displayed.");
					logger.info("Logout button is displayed");
				}
				if (list.get(i).get("components").contains("Exit to Apps")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.exittoapp.xpath").isDisplayed(), 
							"Exit to Apps button is not displayed.");
					logger.info("Exit to Apps button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all left menu bar items are displayed");
			exception = e;
		}
	}
	
	@Then("wait 2 seconds")
	public void wait_two_seconds() {
		try {
			Thread.sleep(2000);
			logger.info("Waiting 2 seconds");
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	/**
	 * This method is to check all left navigation menu components to verify role based login for HIL Manager
	 * 
	 * @param dt
	 */
	@Then("Verify HIL Manager Can View the following components in the left menu bar")
	public void verify_hil_manager_can_view_components(List<Map<String, String>> dt) {
		try {
			LoginPage.driver.switchTo().defaultContent();
			lp = new LoginPage();
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("Dashboard")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath").isDisplayed(),
							"The Dashboard button is not displayed");
					logger.info("The Dashboard button is displayed");

				}
				if (list.get(i).get("components").contains("Choose site")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.choosesite.xpath").isDisplayed(),
							"The Upload Files button is not displayed");
					logger.info("The Upload Files button is displayed");
				}

				if (list.get(i).get("components").contains("History")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath").isDisplayed(), 
							"History button is not displayed");
					logger.info("History button is displayed");
				}
				if (list.get(i).get("components").contains("Audit Log")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.auditlog.xpath").isDisplayed(), 
							"Audit Log button is not displayed.");
					logger.info("Audit Log Out button is displayed");
				}
				if (list.get(i).get("components").contains("Imaging Links")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath").isDisplayed(), 
							"Imaging Links button is not displayed.");
					logger.info("Imaging Links In button is displayed");
				}
				if (list.get(i).get("components").contains("Help")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.help.xpath").isDisplayed(),
							"Help button is not displayed.");
					logger.info("Help button is displayed");
				}
				if (list.get(i).get("components").contains("Info")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.info.xpath").isDisplayed(),
							"Info button is not displayed.");
					logger.info("Info button is displayed");
				}
				if (list.get(i).get("components").contains("Logout")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.logout.xpath").isDisplayed(), 
							"Logout button is not displayed.");
					logger.info("Logout button is displayed");
				}
				if (list.get(i).get("components").contains("Exit to Apps")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "leftnavigation.exittoapp.xpath").isDisplayed(), 
							"Exit to Apps button is not displayed.");
					logger.info("Exit to Apps button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all left menu bar items are displayed");
			exception = e;
		}
	}
	
	@Then("Verify the following components are displayed in the left imaging links table")
	public void verify_left_table_imaging_links(List<Map<String, String>> dt) {
		try {
			LoginPage.driver.switchTo().defaultContent();
			lp = new LoginPage();
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("All organizations")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "imaginglinks.organizations.header.txt.xpath").isDisplayed(),
							"All organizations header is not displayed");
					logger.info("All organizations header is displayed");

				}
				if (list.get(i).get("components").contains("Search tab")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.search.bar.xpath").isDisplayed(),
							"Search tab is not displayed");
					logger.info("Search tab is displayed");
				}

				if (list.get(i).get("components").contains("Enter keyword, Name of Facility or City")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.search.txt.xpath").isDisplayed(), 
							"Enter keyword, Name of Facility or City is not displayed");
					logger.info("Enter keyword, Name of Facility or City is displayed");
				}
				if (list.get(i).get("components").contains("Search Button")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.search.btn.xpath").isDisplayed(), 
							"Search button is not displayed.");
					logger.info("Search Log Out button is displayed");
				}
				if (list.get(i).get("components").contains("Facility type")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.facilitytype.xpath").isDisplayed(),
							"Facility type is not displayed.");
					logger.info("Facility type is displayed");
				}
				if (list.get(i).get("components").contains("Active status")) {
					assertTrue(utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.first.status.txt.xpath").isDisplayed(), 
							"Active status is not displayed.");
					logger.info("Active status is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all left menu bar items are displayed");
			exception = e;
		}
	}
	
	@Then("The deactivate site button should be disabled")
	public void check_if_deactivate_site_is_disabled() {
		try {
			Thread.sleep(8000);
			Assert.assertFalse(utility.initializeElement(LoginPage.driver, "imaginglinks.deactivatesite.btn.xpath").isEnabled());
			logger.info("Deactivate site is disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Could not find deactivate site button");
			exception = e;
		}
	}
	
	@Then("The deactivate site button should be enabled")
	public void check_if_deactivate_site_is_enabled() {
		try {
			Thread.sleep(8000);
			Assert.assertTrue(utility.initializeElement(LoginPage.driver, "imaginglinks.deactivatesite.btn.xpath").isEnabled());
			logger.info("Deactivate site is enabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Could not find deactivate site button");
			exception = e;
		}
	}
	
	@Then("The create link button should be disabled")
	public void check_if_create_link_button_is_disabled() {
		try {
			Thread.sleep(8000);
			Assert.assertFalse(utility.initializeElement(LoginPage.driver, "imaginglinks.createlink.righttable.btn.xpath").isEnabled());
			logger.info("Create link button is disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Could not find create link button");
			exception = e;
		}
	}
	
	@Then("The create link button should be enabled")
	public void check_if_create_link_button_is_enabled() {
		try {
			Thread.sleep(8000);
			Assert.assertTrue(utility.initializeElement(LoginPage.driver, "imaginglinks.createlink.righttable.btn.xpath").isEnabled());
			logger.info("Create link button is enabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Could not find create link button");
			exception = e;
		}
	}
	
	/**
	 * This method is to select an active facilty from the left table
	 *
	 * @throws IOException
	 */
	@Then("User clicks active facility in left table")
	public void clickActiveFacilityInLeftTable() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath("/html/body/app-root/app-managefacilities/div/div[2]/div[1]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		outer:
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				String text = col.getText();
				if (text.equalsIgnoreCase("Active")) {
					row.click();
					break outer;
				}
			}
		}
	}
	
	/**
	 * This method is to select an inactive facilty from the left table
	 *
	 * @throws IOException
	 */
	@Then("User clicks inactive facility in left table")
	public void clickInactiveFacilityInLeftTable() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath("/html/body/app-root/app-managefacilities/div/div[2]/div[1]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		outer:
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				String text = col.getText();
				if (text.equalsIgnoreCase("Inactive")) {
					row.click();
					break outer;
				}
			}
		}
	}
	
	/**
	 * This method is to select an n/a facilty from the left table
	 *
	 * @throws IOException
	 */
	@Then("User clicks NA facility in left table")
	public void clickNAFacilityInLeftTable() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath("/html/body/app-root/app-managefacilities/div/div[2]/div[1]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		outer:
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(int i = 1; i < cols.size(); i++) {
				String prevText = cols.get(i - 1).getText();
				String text = cols.get(i).getText();
				if (text.equalsIgnoreCase("Na") && !prevText.isBlank() && !prevText.equals(",")) {
					row.click();
					break outer;
				}
			}
		}
	}
}
