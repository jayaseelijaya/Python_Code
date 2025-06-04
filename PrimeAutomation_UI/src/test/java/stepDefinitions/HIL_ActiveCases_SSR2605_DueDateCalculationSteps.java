package stepDefinitions;

import java.io.IOException;

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
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class HIL_ActiveCases_SSR2605_DueDateCalculationSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HIL_ActiveCases_SSR2605_DueDateCalculationSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HILActiveCasePage acP = new HILActiveCasePage();
	HILLoginPage lP = new HILLoginPage();

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


	@Then("Select a new due date popup is displayed")
	public void select_a_new_due_date_popup_is_displayed_with() throws IOException {
		try{
			logger.info("Step: Select a new due date popup is displayed");
			Assert.assertTrue(acP.verifyNewDueDatePopUp());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	} 
	@When("the user select the case with Created date as current date in created column")
	public void the_user_select_the_case_with_created_date_as_current_date_in_created_column() throws IOException {
		try {
			logger.info("Step: the user select the case with Created date as current date in created column");
			acP.selectCaseIdWithCreatedDateAsCurrentDate();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the due date column of the selected case displays due date as two workdays")
	public void the_due_date_column_of_the_selected_case_displays_due_date_as_two_workdays() throws IOException {
		try {
			logger.info("Step: the due date column of the selected case displays due date as two workdays");
			Assert.assertTrue(acP.isDueDate2WorkingDaysAhead());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user select the case with Created date as current date and click Edit icon of due date")
	public void the_user_select_the_case_with_created_date_as_current_date_and_click_edit_icon_of_due_date() throws IOException {
		try {
			logger.info("Step: the user select the case with Created date as current date and click Edit icon of due date");
			acP.clickEditOfCaseId2();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user changes the due date and time to {string} from current date recorded")
	public void the_user_changes_the_due_date_and_time_to_from_current_date_recorded(String string) throws IOException, InterruptedException {
		try {
			String ssName =  "the user changes the due date and time to "+string+" from current date recorded";
			logger.info("Step: "+ssName);
			acP.changeDueDate(string);
			screenshot.screenshot(ssName, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks cancel button in the new date popup")
	public void the_user_clicks_cancel_button_in_the_new_date_popup() throws IOException {
		try {
			logger.info("Step: the user clicks cancel button in the new date popup");
			acP.clickCancelBtnOfNewDueDatePopup();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("new due date popup is dismissed and changes are not saved")
	public void new_due_date_popup_is_dismissed_and_changes_are_not_saved() throws IOException {
		try {
			logger.info("Step: new due date popup is dismissed and changes are not saved");
			Assert.assertTrue(acP.isNewDueDatePopupDismissed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the time until due displays {string}")
	public void the_time_until_due_displays(String string) throws IOException {
		try {
			String ssName =  "the time until due displays "+string;
			logger.info("Step: "+ssName);
			Assert.assertEquals(acP.getTimeUntilDueOfCaseId2(), string);
			screenshot.screenshot(ssName, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user wait until the Case status changes to overdue")
	public void the_user_wait_until_the_case_status_changes_to_overdue() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user wait until the Case status changes to overdue");
			acP.waitFor5minutesToBecomeOverdue();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("time until due column displays the crossed due time")
	public void time_until_due_column_displays_the_crossed_due_time() throws IOException {
		try {
			logger.info("Step: the user wait until the Case status changes to overdue");
			Assert.assertTrue(acP.isTimeCrossed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the time until due is calculated automatically based on created date and it is displayed as {string}")
	public void the_time_until_due_is_calculated_automatically_based_on_created_date_and_it_is_displayed_as_2days_hrs(String string) throws IOException {
		try {
			String ssName =  "the time until due is calculated automatically based on created date and it is displayed as "+string;
			logger.info("Step: "+ssName);
			Assert.assertEquals(acP.timeUntilDue(),string);
			screenshot.screenshot(ssName, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
