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

public class HIL_ActiveCases_SSR2606_DefaultDateSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HIL_ActiveCases_SSR2606_DefaultDateSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HILLoginPage lP = new HILLoginPage();
	HILActiveCasePage acP = new HILActiveCasePage();
	String timeUntilDue = "";
	

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
	
	@Then("User clicks filter button in top menu bar of Active Cases Page")
	public void user_clicks_filter_button_top_bar_acp() {
		try {
			String ssname = "User clicks filter button in top menu bar of Active Cases Page";
			logger.info("Step: " + ssname);
			acP.clickFilterButtonACP();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click filter button");
			exception = e;
		}
	}
	
	@Then("User clicks Status button in the filter menu of active cases page")
	public void user_clicks_status_button_filter_menu_acp() {
		try {
			String ssname = "User clicks Status button in the filter menu of active cases page";
			logger.info("Step: " + ssname);
			acP.clickStatusButtonACP();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click status button");
			exception = e;
		}
	}
	
	@Then("User clicks new status button in the filter menu of active cases page")
	public void user_clicks_new_status_button_filter_menu_acp() {
		try {
			String ssname = "User clicks new status button in the filter menu of active cases page";
			logger.info("Step: " + ssname);
			acP.clickNewStatusButtonACP();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click new status button");
			exception = e;
		}
	}
	
	@Then("User clicks done button in the filter menu of active cases page")
	public void user_clicks_done_button_filter_menu_acp() {
		try {
			String ssname = "User clicks done button in the filter menu of active cases page";
			logger.info("Step: " + ssname);
			acP.clickDoneButtonFilterMenuACP();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click done button");
			exception = e;
		}
	}
	
	@Then("Verify the difference between created date and due date")
	public void verify_difference_between_created_and_due_date() {
		try {
			String ssname = "Verify the difference between created date and due date";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.checkCreatedAgainstDueDate());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to verify difference between dates");
			exception = e;
		}
	}
	
	@Then("Get difference between Created and Due date against Time Until Due Value")
	public void get_difference_between_created_and_due_date() {
		try {
			String ssname = "Get difference between Created and Due date against Time Until Due Value";
			logger.info("Step: " + ssname);
			acP.getCreatedDueDateDifference();
			acP.printTimeUntilDueValue();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to get difference between dates");
			exception = e;
		}
	}
	
	@Then("Reviewer user clicks status button in filter menu")
	public void reviewer_user_clicks_status_button_in_filter_menu() {
		try {
			String ssname = "Reviewer user clicks status button in filter menu";
			logger.info("Step: " + ssname);
			acP.clickStatusButtonReviewer();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click status button");
			exception = e;
		}
	}
	
	@Then("Reviewer user clicks new status button in filter menu")
	public void reviewer_user_clicks_new_status_button_in_filter_menu() {
		try {
			String ssname = "Reviewer user clicks new status button in filter menu";
			logger.info("Step: " + ssname);
			acP.clickNewStatusButtonReviewer();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click new status button");
			exception = e;
		}
	}
	
	@Then("Reviewer user clicks done button in filter menu")
	public void reviewer_user_clicks_done_button_in_filter_menu() {
		try {
			String ssname = "Reviewer user clicks done button in filter menu";
			logger.info("Step: " + ssname);
			acP.clickDoneButtonReviewer();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click done button");
			exception = e;
		}
	}
	
	@Then("Wait 4 seconds")
	public void wait_four_seconds() {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to wait four seconds");
			exception = e;
		}
	}
	
	@Then("User clicks edit date button on first entry")
	public void user_clicks_edit_date_button_on_first_entry() {
		try {
			String ssname = "User clicks edit date button on first entry";
			logger.info("Step: " + ssname);
			acP.clickEditDateButton();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click edit date button");
			exception = e;
		}
	}
	
	@Then("Check if new date header is displayed")
	public void check_if_new_date_header_is_displayed() {
		try {
			String ssname = "Check if new date header is displayed";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.checkIfNewDateHeaderIsDisplayed());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check for new date header");
			exception = e;
		}
	}
	
	@Then("User selects the date one after the current day")
	public void user_selects_one_day_after_current_day() {
		try {
			String ssname = "User selects the date one after the current day";
			logger.info("Step: " + ssname);
			acP.clickDayAfterCurrentDay();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to select day after current day");
			exception = e;
		}
	}
	
	@Then("User clicks submit button in edit date page")
	public void user_clicks_submit_button_in_edit_page() {
		try {
			String ssname = "User clicks submit button in edit date page";
			logger.info("Step: " + ssname);
			acP.clickSubmitButtonEditDatePopUp();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click submit button");
			exception = e;
		}
	}
	
	@Then("Get Time Until Due Value")
	public void get_time_until_due_value() {
		try {
			String ssname = "User clicks submit button in edit date page";
			logger.info("Step: " + ssname);
			timeUntilDue = acP.getTimeUntilDue();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click submit button");
			exception = e;
		}
	}
	
	@Then("Compare original time until due date to current time until due date")
	public void compare_time_until_due_dates() {
		try {
			String ssname = "User clicks submit button in edit date page";
			logger.info("Step: " + ssname);
			logger.info("Original time until due time " + timeUntilDue);
			logger.info("Current time until due time " + acP.getTimeUntilDue());
			timeUntilDue = acP.getTimeUntilDue();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click submit button");
			exception = e;
		}
	}
	
	@Then("User selects the date two after the current day")
	public void user_selects_two_day_after_current_day() {
		try {
			String ssname = "User selects the date two after the current day";
			logger.info("Step: " + ssname);
			acP.clickTwoDaysAfterCurrentDay();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to select two days after current day");
			exception = e;
		}
	}
	
	@Then("User clicks PM button")
	public void user_clicks_pm_button() {
		try {
			String ssname = "User clicks PM button";
			logger.info("Step: " + ssname);
			acP.clickPMButton();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click PM button");
			exception = e;
		}
	}
	
	@Then("User clicks cancel button")
	public void user_click_cancel_button() {
		try {
			String ssname = "User clicks cancel button";
			logger.info("Step: " + ssname);
			acP.clickCancelButton();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click cancel button");
			exception = e;
		}
	}
	
	@Then("User selects the date five after the current day")
	public void user_selects_five_day_after_current_day() {
		try {
			String ssname = "User selects the date five after the current day";
			logger.info("Step: " + ssname);
			acP.clickFiveDaysAfterCurrentDay();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to select five days after current day");
			exception = e;
		}
	}
	
	@Then("User selects the current date")
	public void user_selects_current_date() {
		try {
			String ssname = "User selects the current date";
			logger.info("Step: " + ssname);
			acP.clickCurrentDate();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to select the current date");
			exception = e;
		}
	}
	
	@Then("Check for Overdue Status")
	public void check_for_overdue_status() {
		try {
			String ssname = "Check for overdue status";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.checkOverdueStatus());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check for overdue status");
			exception = e;
		}
	}
}