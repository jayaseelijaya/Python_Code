
package stepDefinitions;

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
import pages.BrowsePcScreenPage;
import pages.LoginPage;
import pages.UploadFilePage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1722_UploadFilesSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	UploadFilePage ufPage = new UploadFilePage();
	BrowsePcScreenPage bpcsPage = new BrowsePcScreenPage();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1722_UploadFilesSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;

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
	@When("the user clicks on upload files from left menu")
	public void the_user_clicks_on_upload_files_from_left_menu() {
		try {
			ufPage.clickOnUploadFilesFromLeftMenu();
			logger.info("Step: The user clicked on upload files button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on any facility")
	public void the_user_clicks_on_any_facility() {
		try {
			ufPage.clickOnAnyFacility();
			logger.info("Step: The user clicked on any facility");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects a surgeon")
	public void the_user_selects_a_surgeon() {
		try {
			ufPage.selectASurgeon();
			logger.info("Step: The user selected a surgeon");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects a application from the list")
	public void the_user_selects_a_application_from_the_list() {
		try {
			ufPage.selectApplication();
			logger.info("Step: The user selected application ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on Next button")
	public void the_user_clicks_on_Next_button() {
		try {
			ufPage.clickOnNextButton();
			logger.info("Step: The user clciked on next button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on browse pc button")
	public void the_user_clicks_on_browse_pc_button() {
		try {
			ufPage.clickOnBrowsePcButton();
			logger.info("Step: The user clciked browse PC button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// *********************THEN BLOCK*******************************
	@Then("the file dashbaord page shall be displayed")
	public void the_file_dashbaord_page_shall_be_displayed() throws IOException {
		try {
			Properties properties = reader.getProperty();
			String expTitle = properties.getProperty("ddu.title");
			String actualTitle = ufPage.getPageTitle();
			Assert.assertEquals(expTitle, actualTitle);
			logger.info("the " + actualTitle + "dashbaord page displayed ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Cought exception:: " + e.toString());
			Assert.fail("The title of the page not displayed !!!");
			exception = e;
		}
	}

	@Then("the following components shall be displayed on right side")
	public void the_following_components_shall_be_displayed_on_right_side(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("component").contains("Upload file icon")) {
					assertTrue(ufPage.isRightSideInfoDisplayed("Upload file icon").isDisplayed(),
							"The Upload file icon is not displayed.");
					logger.info("The Upload file icon is displayed.");
				}
				if (list.get(i).get("component").contains("Upload file button")) {
					assertTrue(ufPage.isRightSideInfoDisplayed("Upload file button").isDisplayed(),
							"The Upload file button is not displayed.");
					logger.info("The Upload file button is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The right side components are not displayed");
			exception = e;
		}
	}

	@Then("the facility selection modal shall be displayed")
	public void the_facility_selection_modal_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(ufPage.isFacilitySelectionModalDisplayed());
			logger.info("The facility selection modal displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the surgeon selection modal shall be displayed")
	public void the_surgeon_selection_modal_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(ufPage.isSurgeonSelectionModalDisplayed());
			logger.info("The surgeon selection modal displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the user shall be navigated to browse pc screen")
	public void the_user_shall_be_navigated_to_browse_pc_screen() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(bpcsPage.isBrowsePCScreenDisplayed());
			logger.info("The user navigated to browse pc screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the user uploads a valid dicom folder using windows file explorer")
	public void the_user_uploads_valid_dicom_folder_using_windows_file_explorer() {
		try {
			ufPage.uploadUsingWindows();
			logger.info("User uploaded a valid dicom file folder using windows file explorer");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the user uploads an invalid dicom folder using windows file explorer")
	public void the_user_uploads_invalid_dicom_folder_using_windows_file_explorer() {
		try {
			ufPage.uploadInvalidUsingWindows();
			logger.info("User uploaded an invalid dicom file folder using windows file explorer");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the user uploads a non dicom folder using windows file explorer")
	public void the_user_uploads_non_dicom_folder_using_windows_file_explorer() {
		try {
			ufPage.uploadNonDicomUsingWindows();
			logger.info("User uploaded a non dicom file folder using windows file explorer");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
