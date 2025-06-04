package stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
import pages.HILActiveCasePage;
import pages.HILLoginPage;
import pages.HILMyCasesPage;
import pages.HilCaseHistoryPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class HIL_CaseHistory_SSR2409_ViewModeSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HIL_CaseHistory_SSR2409_ViewModeSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HILLoginPage lP = new HILLoginPage();
	HilCaseHistoryPage hcP = new HilCaseHistoryPage();
	

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
	
	@Then("User clicks filter button in Case History Page")
	public void user_clicks_filter_button_case_history_page() {
		try {
			String ssname = "User clicks filter button in case history page";
			logger.info("Step: " + ssname);
			hcP.clickFilterButtonCHPage();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click filter button");
			exception = e;
		}
	}
	
	@Then("User clicks status filter button in Case History Page")
	public void user_clicks_status_filter_button_case_history_page() {
		try {
			String ssname = "User clicks status filter button in case history page";
			logger.info("Step: " + ssname);
			hcP.clickStatusFilterMenuOption();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click status filter button");
			exception = e;
		}
	}
	
	@Then("User clicks approve button in Case History Filter Menu")
	public void user_clicks_approve_button_case_history_filter_menu() {
		try {
			String ssname = "User clicks approve button in case history filter menu";
			logger.info("Step: " + ssname);
			hcP.clickApprovedButtonInCHFilterMenu();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click approve button");
			exception = e;
		}
	}
	
	@Then("User clicks done button in Case History Filter Menu")
	public void user_clicks_done_button_case_history_filter_menu() {
		try {
			String ssname = "User clicks done button in case history filter menu";
			logger.info("Step: " + ssname);
			hcP.clickDoneButtonInCHFilterMenu();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click done button");
			exception = e;
		}
	}
	
	@Then("Check the view button for the first entry is displayed")
	public void check_view_button_first_entry_displayed() {
		try {
			String ssname = "Check the view button for the first entry is displayed";
			logger.info("Step: " + ssname);
			hcP.isCHViewButtonDisplayed();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("View button is not displayed");
			exception = e;
		}
	}
	
	@Then("User clicks view button on first entry in case history page")
	public void user_clicks_view_button_on_first_entry_in_case_history_page() {
		try {
			String ssname = "User clicks view button on first entry in case history page";
			logger.info("Step: " + ssname);
			hcP.clickCHViewButton();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click view button");
			exception = e;
		}
	}
	
	@Then("Wait 5 seconds")
	public void wait_five_seconds() {
		try {
			logger.info("Waiting 5 seconds");
			Thread.sleep(5000);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to wait 5 seconds");
			exception = e;
		}
	}
	
	@Then("the below components shall be disabled in view mode")
	public void the_below_components_shall_be_displayed_on_top_bar_of_pdf_viewer(List<Map<String, String>> dt) {
		try {
			String ssname = "The following components shall be disabled in view mode";
			logger.info("Step: " + ssname);
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("components").contains("lasso")) {
					assertTrue(hcP.isViewModeButtonsDisabled("lasso").isEnabled(),
							"The lasso button is not disabled");
					logger.info("The lasso button is disabled");
				}
				if (list.get(i).get("components").contains("brush")) {
					assertTrue(hcP.isViewModeButtonsDisabled("brush").isEnabled(),
							"The bruh button is not disabled");
					logger.info("The brush button is disabled");
				}
				if (list.get(i).get("components").contains("brush")) {
					assertTrue(hcP.isViewModeButtonsDisabled("brush").isEnabled(),
							"The brush button is not disabled");
					logger.info("The brush button is disabled");
				}
				if (list.get(i).get("components").contains("eraser")) {
					assertTrue(hcP.isViewModeButtonsDisabled("eraser").isEnabled(),
							"The eraser button is not disabled");
					logger.info("The eraser button is disabled");
				}
				if (list.get(i).get("components").contains("approve")) {
					assertTrue(hcP.isViewModeButtonsDisabled("approve").isEnabled(),
							"The approve button is not disabled");
					logger.info("The approve button is disabled");
				}
				if (list.get(i).get("components").contains("save")) {
					assertTrue(hcP.isViewModeButtonsDisabled("save").isEnabled(),
							"The save button is not disabled");
					logger.info("The save button is disabled");
				}
				if (list.get(i).get("components").contains("reject")) {
					assertTrue(hcP.isViewModeButtonsDisabled("reject").isEnabled(),
							"The reject button is not disabled");
					logger.info("The reject button is disabled");
				}
				if (list.get(i).get("components").contains("ctrl z")) {
					assertTrue(hcP.isViewModeButtonsDisabled("ctrl z").isEnabled(),
							"The ctrl z button is not disabled");
					logger.info("The ctrl z button is disabled");
				}
				if (list.get(i).get("components").contains("ctrl y")) {
					assertTrue(hcP.isViewModeButtonsDisabled("ctrl y").isEnabled(),
							"The ctrl y button is not disabled");
					logger.info("The ctrl y button is disabled");
				}
				if (list.get(i).get("components").contains("resent changes")) {
					assertTrue(hcP.isViewModeButtonsDisabled("resent changes").isEnabled(),
							"The reset changes button is not disabled");
					logger.info("The reset changes button is disabled");
				}
			}
			screenshot.screenshot(ssname, LoginPage.driver);
		}  catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Not all components in the View Mode are disabled");
			exception = e;
		}
	}
	
	@Then("Check that all columns are displayed in case history page")
	public void check_case_history_page_columns() {
		try {
			String ssname = "Check that all columns are displayed in case history page";
			logger.info("Step: " + ssname);
			hcP.is9ColumnsDisplayed();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Not all columns are displayed");
			exception = e;
		}
	}
	
	@Then("User clicks clear all filters button in filter menu")
	public void user_clicks_clear_all_filters_button() {
		try {
			String ssname = "User clicks clear all filters button in filter menu";
			logger.info("Step: " + ssname);
			hcP.clickClearAllFiltersButton();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not click clear all filters button");
			exception = e;
		}
	}
	
	@Then("User clicks error status in filter menu")
	public void user_clicks_error_status_filter_menu() {
		try {
			String ssname = "User clicks error status button in filter menu";
			logger.info("Step: " + ssname);
			hcP.clickErrorStatusButtonFilter();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click error status button");
			exception = e;
		}
	}
	
	@Then("Verify view button is not displayed for error entry")
	public void verify_view_button_not_displayed_for_error_entry () {
		try {
			String ssname = "Verify view button is not displayed for error entry";
			logger.info("Step: " + ssname);
			Assert.assertTrue(hcP.checkForNoViewButton());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("View button is displayed");
			exception = e;
		}
	}
	
	@Then("Print completed date of error entry")
	public void print_completed_date_of_error_entry () {
		try {
			String ssname = "Print completed date of error entry";
			logger.info("Step: " + ssname);
			hcP.printCompletedDate();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to print completed date");
			exception = e;
		}
	}
	
	@Then("Print review time of error entry")
	public void print_review_time_of_error_entry() {
		try {
			String ssname = "Print review time of error entry";
			logger.info("Step: " + ssname);
			hcP.printReviewTime();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to print review time");
			exception = e;
		}
	}
	
	@Then("Check the settings button is displayed in top bar")
	public void check_settings_button_displayed_top_bar() {
		try {
			String ssname = "Check the settings button is displayed in the top bar";
			logger.info("Step: " + ssname);
			Assert.assertTrue(hcP.checkForSettingsButtonTopBar());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find settings button in top bar");
			exception = e;
		}
	}
	
	@Then("Check the error icon is displayed for error entry")
	public void check_error_icon_displayed_error_entry () {
		try {
			String ssname = "Check the error icon is displayed for error entry";
			logger.info("Step: " + ssname);
			Assert.assertTrue(hcP.checkForErrorIcon());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find error icon");
			exception = e;
		}
	}
	
	@Then("Check Error Filter Button is Displayed")
	public void check_error_filter_button_is_displayed() {
		try {
			String ssname = "Check error filter button is displayed";
			logger.info("Step: " + ssname);
			Assert.assertTrue(hcP.checkForErrorFilterButton());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check error filter button");
			exception = e;
		}
	}
	
	@Then("User clicks error filter button")
	public void user_clicks_error_filter_button() {
		try {
			String ssname = "User clicks error filter button";
			logger.info("Step: " + ssname);
			hcP.clickErrorFilterButton();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click error filter button");
			exception = e;
		}
	}
	
	@Then("Check for filter button, search button, and search bar")
	public void check_filter_search_components() {
		try {
			String ssname = "Check for filter button, search button, and search bar";
			logger.info("Step: " + ssname);
			Assert.assertTrue(hcP.checkFilterButton());
			Assert.assertTrue(hcP.checkSearchBarCHPage());
			Assert.assertTrue(hcP.checkSearchButtonCHPage());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find all components");
			exception = e;
		}
	}
	
	@Then("Verify sorting arrows are displayed")
	public void verify_sorting_arrows_are_displayed() {
		try {
			String ssname = "Verify sorting arrows are displayed";
			logger.info("Step: " + ssname);
			Assert.assertTrue(hcP.isSortingArrowsDisplayed());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find all sorting arrows");
			exception = e;
		}
	}
	
	@Then("Verify show more button is displayed")
	public void verify_show_more_button_is_displayed() {
		try {
			String ssname = "Verify show more button is displayed";
			logger.info("Step: " + ssname);
			Assert.assertTrue(hcP.checkShowMoreButtonCHPage());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find show more button");
			exception = e;
		}
	}
	
	@Then("User clicks first case audit log button")
	public void user_clicks_first_case_audit_log_button() {
		try {
			String ssname = "User clicks first case audit log button";
			logger.info("Step: " + ssname);
			hcP.clickFirstCaseAuditLog();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click audit log button");
			exception = e;
		}
	}
	
	@Then("Verify format of review time")
	public void verify_format_of_review_time() {
		try {
			String ssname = "Verify format of review time";
			logger.info("Step: " + ssname);
			Assert.assertTrue(hcP.verifyReviewTimeFormat());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to verify format of review time");
			exception = e;
		}
	}
	
	@Then("Verify format of completed Date")
	public void verify_format_of_completed_date() {
		try {
			String ssname = "Verify format of completed date";
			logger.info("Step: " + ssname);
			Assert.assertTrue(hcP.verifyCompletedDateFormat());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to verify format of completed date");
			exception = e;
		}
	}
	
	@Then("Verify format of due Date")
	public void verify_format_of_due_date() {
		try {
			String ssname = "Verify format of completed date";
			logger.info("Step: " + ssname);
			Assert.assertTrue(hcP.verifyDueDateFormat());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to verify format of due date");
			exception = e;
		}
	}
}