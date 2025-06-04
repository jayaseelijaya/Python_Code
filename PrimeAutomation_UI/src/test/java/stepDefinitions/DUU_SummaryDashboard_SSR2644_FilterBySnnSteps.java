package stepDefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SummaryDashboard_SSR2644_FilterBySnnSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR2644_FilterBySnnSteps.class);
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

	@When("Which site would you like to view text is displayed")
	public void which_site_would_you_like_to_view_text_is_displayed() {
		try {
			daPage.isWhichSiteTextDisplayed();
			logger.info("Step: Which site would you like to view text ? is displayed ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("Search site text is displayed")
	public void search_site_text_is_displayed() {
		try {
			daPage.isSearchsitetextTextDisplayed();
			logger.info("Step: Search site text is displayed ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("Text Enter Keyword or Name of Site as place holder in Search bar is displayed")
	public void text_enter_keyword_or_name_of_site_as_place_holder_in_search_bar_is_displayed() {
		try {
			daPage.isEnterKeywordTextDisplayed();
			logger.info("Step: Text Enter Keyword or Name of Site as place holder in Search bar is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("list of sites is displayed to user")
	public void list_of_sites_is_displayed_to_user() {
		try {
			daPage.isListDisplayed();
			logger.info("Step: List of sites is displayed to user");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("select button is displayed to user")
	public void select_button_is_displyed_to_user() {
		try {
			daPage.isSelectButtonDisplayed();
			logger.info("Step: Select Button is displayed to user");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user selects facilty which ic admin has selected")
	public void user_selects_facilty_which_ic_admin_has_selected() {
		try {
			daPage.selectICadminFacilityFromChooseSite();
			logger.info("Step: Facility is selected ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records are displayed for the site that ic-admin belongs")
	public void records_are_displayed_for_the_site_that_ic_admin_belongs() {
		try {
			daPage.isrecordDisplayed();
			logger.info("Step: Records are displayed for the site that belongs to ic-admin");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on Choose Site button from left panel")
	public void user_clicks_on_choose_site_button_from_left_panel() {
		try {
			daPage.clickonChooseSite();
			logger.info("Step: Choose site from left panel is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user selects facilty which hospital admin has selected")
	public void user_selects_facilty_which_hospital_admin_has_selected() {
		try {
			daPage.selectHospitaladminFacilityFromChooseSite();
			logger.info("Step: Facility is selected");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records are displayed for the site that hospital-admin belongs")
	public void records_are_displayed_for_the_site_that_hospital_admin_belongs() {
		try {
			daPage.isrecordDisplayed();
			logger.info("Step: Records are displayed for the site that belongs to Hospital-admin");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
