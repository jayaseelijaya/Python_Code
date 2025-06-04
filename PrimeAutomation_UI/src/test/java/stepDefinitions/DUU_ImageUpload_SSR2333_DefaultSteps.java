package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApplicationCardsPage;
import pages.FacilityListPage;
import pages.FileDashboardPage;
import pages.FileUploadPage;
import pages.LoginPage;
import pages.UploadFilePage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR2333_DefaultSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR2333_DefaultSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FileUploadPage fuP = new FileUploadPage();
	UploadFilePage ufP = new UploadFilePage();
	FileDashboardPage fP = new FileDashboardPage();
	FacilityListPage flp = new FacilityListPage();
	ApplicationCardsPage ap = new ApplicationCardsPage();

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

	@Then("the Site selection screen is displayed with following components")
	public void the_site_selection_screen_is_displayed_with(List<Map<String, String>> dt)
			throws IOException, InterruptedException {
		try {
			fuP.isSiteDefaultSelectedScreenDisplayed();
			logger.info("Step : Site selection screen components is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("only one site is displayed on facility selection screen")
	public void only_one_site_is_displayed_on_facility_selection_screen() {
		try {
			flp.isOnlyOneSiteDisplayed();
			logger.info("Step : One Site is displayed on facility selection Screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("user click on the site & verifies next button state")
	public void user_click_on_the_site_verifies_next_button_state() {
		try {
			flp.isNextButtonEnabled();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("only one surgeon is displayed on Surgeon selection screen")
	public void only_surgeon_displayed_Surgeon_selection_screen() {
		try {
			flp.isOnlyOneSurgeonDisplayed();
			logger.info("Step : One Surgeon is displayed on Surgeon selection Screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("user clicks on Surgeon & verifies next button state")
	public void user_clicks_on_Surgeon() {
		try {
			flp.isNextBtnEnabled();
			logger.info("Step : Next Button is enabled on Surgeon selection Screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("only one Application card is displayed on application selection screen")
	public void only_one_Application_card_displayed_application_selection_screen() {
		try {
			flp.isOnlyOneApplicationDisplayed();
			logger.info("Step : Only One Application card is displayed on Application selection Screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("user click on the card & verifies next button state")
	public void user_click_on_the_card_verifies_next_button_state() {
		try {
			ap.isNextButtonEnabled();
			logger.info("Step : Next button is in enabled state on Application selection Screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user selects datase with {string} and click on upload button")
	public void user_selects_datase_with_and_click_on_upload_button(String string)
			throws IOException, InterruptedException {
		try {
			logger.info("Step : user selects dataset and click on upload button");
			ufP.uploadFile("valid");
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Record details of {string} dicom folder is displayed")
	public void record_details_of_dicom_folder_displayed(String string) throws IOException {
		try {
			logger.info("Step : Record details of uploaded dicom folder displayed");
			if (string.contains("valid")) {
				fP.logRecordsInSummaryDashboard(1);
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
