package stepDefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DisplayEachRecords;
import pages.FileDashboardPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SummaryDashboard_SSR1826_NodataSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR1826_NodataSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FileDashboardPage daPage = new FileDashboardPage();
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

	@When("user clicks on Hours checkbox filter")
	public void user_clicks_on_hours_checkbox_filter() {
		try {
			daPage.clickTwentyFourHrsCheckbox();
			logger.info("Step: 24 hrs is clicked ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("hrs filter is displayed at top-right of the Upload Dashboard screen")
	public void hrs_filter_is_displayed_at_top_right_of_the_upload_dashboard_screen() {
		try {
			daPage.isTwentyFourHrsCheckboxDisplayed();
			logger.info("Step: 24 hrs filter is displayed at top-right of the Upload Dashboard screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the text No data to display is displayed in upload dashboard screen")
	public void text_No_data_to_display_is_displayed_in_upload_dashboard_screen() {
		try {
			Thread.sleep(4000);
			daPage.msgNodata();
			logger.info("Step:  'No data to display' text is displayed in upload dashboard screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("upload dashboard summary page is displayed to user")
	public void upload_dashboard_summary_page_is_displayed_to_user() {
		try {
			Thread.sleep(1000);
			sap.isDashboardHeaderDisplayed();
			logger.info("Step: Upload dashboard page is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("choose site screen is displayed to user")
	public void choose_site_screen_is_displayed_to_user() {
		try {
			daPage.isChooseSiteScreenDisplayed();
			logger.info("Step: Choose Site Screen is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user selects facilty which has no data associated")
	public void user_selects_facilty_which_has_no_data_associated() {
		try {
			daPage.selectFacilityFromChooseSite();
			logger.info("Step: Facility is selected from Choose Site Screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("click on select button after selecting facility")
	public void click_on_select_button_after_selecting_facility() {
		try {
			daPage.clickselectButton();
			logger.info("Step: Select button is clicked from Choose Site Screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
