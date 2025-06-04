package stepDefinitions;

import java.io.IOException;
import java.text.ParseException;

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

public class HIL_ActiveCases_SSR1691_CaseStatusSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HIL_ActiveCases_SSR1691_CaseStatusSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HILActiveCasePage acP = new HILActiveCasePage();
	HILLoginPage lP = new HILLoginPage();
	HILMyCasesPage mcP = new HILMyCasesPage();
	String caseID = "";

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
	
	@Then("Save case id of first entry")
	public void save_case_id_of_first_entry() {
		try {
			String ssname = "Save case id of first entry";
			logger.info("Step: " + ssname);
			caseID = acP.getFirstEntryCaseID();
			logger.info("Case ID: " + caseID);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to get case id of first entry");
			exception = e;
		}
	}
	
	@Then("User clicks unassign button on first entry")
	public void user_clicks_unassign_button_on_first_entry() {
		try {
			String ssname = "User clicks unnasign button on first entry";
			logger.info("Step: " + ssname);
			acP.clickUnassignButtonOnFirstEntry();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click unnasign button on first entry");
			exception = e;
		}
	}
	
	@Then("User clicks claim button on first entry")
	public void user_clicks_claim_button_on_first_entry() {
		try {
			String ssname = "User clicks claim button on first entry";
			logger.info("Step: " + ssname);
			acP.clickClaimButtonOnFirstEntry();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click claim button on first entry");
			exception = e;
		}
	}
	
	@Then("User clicks open button on first entry")
	public void user_clicks_open_button_on_first_entry () {
		try {
			String ssname = "User clicks open button on first entry";
			logger.info("Step: " + ssname);
			acP.clickOpenButtonOnFirstEntry();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click open button on first entry");
			exception = e;
		}
	}
	
	@Then("Wait 10 seconds")
	public void wait_10_seconds() {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to wait 10 seconds");
			exception = e;
		}
	}
	
	@Then("User clicks reject button")
	public void user_clicks_reject_button() {
		try {
			String ssname = "User clicks reject button";
			logger.info("Step: " + ssname);
			acP.clickRejectButton();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click reject button");
			exception = e;
		}
	}
	
	@Then("User enters text into reject pop up text box")
	public void user_sends_text_into_text_box() {
		try {
			String ssname = "User sends text into text box";
			logger.info("Step: " + ssname);
			acP.sendKeysIntoRejectPopUp();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to send text into text box");
			exception = e;
		}
	}
	
	@Then("User clicks reject button in reject pop up")
	public void user_clicks_reject_button_in_reject_pop_up() {
		try {
			String ssname = "User clicks reject button in reject pop up";
			logger.info("Step: " + ssname);
			acP.clickRejectButtonInRejectPopUp();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click reject button in reject pop up");
			exception = e;
		}
	}
	
	@Then("User clicks exit button in bottom right panel")
	public void user_clicks_exit_button_in_bottom_right_panel () {
		try {
			String ssname = "User clicks exit button in bottom right panel";
			logger.info("Step: " + ssname);
			acP.clickExitButton();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click exit button in bottom right panel");
			exception = e;
		}
	}
	
	@Then("Check first entry status in table")
	public void check_first_entry_status_in_table() {
		try {
			String ssname = "Check first entry status";
			logger.info("Step: " + ssname);
			acP.getFirstEntryStatus();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check first entry status");
			exception = e;
		}
	}
	
	@Then("Check first entry ID against previous check")
	public void check_first_entry_id_against_previous_check() {
		try {
			String ssname = "Check first entry id against previous check";
			logger.info("Step: " + ssname);
			String newId = acP.getFirstEntryCaseID();
			logger.info("New First Case ID: " + newId);
			logger.info("Original First Case ID: " + caseID);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to compare first entry id");
			exception = e;
		}
	}
	
	@Then("Refresh active cases table")
	public void refresh_active_cases_table() {
		try {
			String ssname = "Refresh active cases table";
			logger.info("Step: " + ssname);
			acP.clickCaseHistoryButtonInTop();
			Thread.sleep(2000);
			acP.clickActiveCasesButtonInTop();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to refresh active cases table");
			exception = e;
		}
	}
	
	@Then("User clicks axial view in HIL Page")
	public void user_clicks_axial_view_in_hil_page() {
		try {
			String ssname = "User clicks axial view in hil page";
			logger.info("Step: " + ssname);
			acP.clickAxialView();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click axial view");
			exception = e;
		}
	}
	
	@Then("User clicks sliders to get 100 percent on sliders")
	public void user_clicks_sliders() {
		try {
			String ssname = "User clicks Sliders";
			logger.info("Step: " + ssname);
			acP.clickSlidersToAchieve100Percent();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click sliders");
			exception = e;
		}
	}
	
	@Then("User clicks approve in bottom right panel")
	public void user_clicks_approve_in_bottom_right_panel() {
		try {
			String ssname = "User clicks approve button in bottom right panel";
			logger.info("Step: " + ssname);
			acP.clickApproveButton();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click approve button");
			exception = e;
		}
	}
	
	@Then("User clicks approve button in approve button pop up")
	public void user_clicks_approve_button_in_approve_button_pop_up() {
		try {
			String ssname = "User clicks approve button in approve button pop up";
			logger.info("Step: " + ssname);
			acP.clickApproveButtonInApproveButtonPopUp();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click approve button in approve button pop up");
			exception = e;
		}
	}
	
	@Then("Print first entry status")
	public void print_first_entry_status() {
		try {
			String ssname = "Print first entry status";
			logger.info("Step: " + ssname);
			acP.printFirstEntryStatus();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to print first entry status");
			exception = e;
		}
	}
	
	@Then("User clicks my cases page button")
	public void user_clicks_my_cases_page_button() {
		try {
			String ssname = "User clicks my cases page button";
			logger.info("Step: " + ssname);
			acP.clickMyCasesPageButton();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click my cases page button");
			exception = e;
		}
	}
	
	@Then("Check first entry ID against active cases")
	public void check_first_entry_id_against_active_cases() {
		try {
			String ssname = "Check first entry id against active cases";
			logger.info("Step: " + ssname);
			String newId = acP.getFirstEntryIDMCPage();
			logger.info("New First Case ID: " + newId);
			logger.info("Original First Case ID: " + caseID);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to compare first entry id");
			exception = e;
		}
	}
	
	@Then("Verify first entry has claim button")
	public void verify_first_entry_claim_button() {
		try {
			String ssname = "Verify first entry claim button";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.verifyClaimButton());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check for claim button");
			exception = e;
		}
	}
	
	@Then("Verify first entry has unassign button")
	public void verify_first_entry_unassign_button() {
		try {
			String ssname = "Verify first entry unassign button";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.verifyUnassignButton());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check for unassign button");
			exception = e;
		}
	}
	
	@Then("Verify first entry has view button")
	public void verify_first_entry_view_button() {
		try {
			String ssname = "Verify first entry View button";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.verifyViewButton());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check for View button");
			exception = e;
		}
	}
	
	@Then("Verify first entry has open button")
	public void verify_first_entry_open_button() {
		try {
			String ssname = "Verify first entry open button";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.verifyOpenButton());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check for open button");
			exception = e;
		}
	}
	
	@Then("User clicks case history button")
	public void user_clicks_case_history_button_in_top_menu_bar() {
		try {
			String ssname = "User clicks case history button in top menu bar";
			logger.info("Step: " + ssname);
			acP.clickCaseHistoryButtonInTop();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click case history button");
			exception = e;
		}
	}
	
	@Then("Print first entry status in case history page")
	public void print_first_entry_status_in_case_history_page() {
		try {
			String ssname = "Print first entry status in case history page";
			logger.info("Step: " + ssname);
			acP.printFirstEntryStatusCHPage();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to print first entry status in case history page");
			exception = e;
		}
	}
}