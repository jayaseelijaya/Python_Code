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

public class HIL_ActiveCases_SSR1056_AscendingOrderOfDueDateSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HIL_ActiveCases_SSR1056_AscendingOrderOfDueDateSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HILActiveCasePage acP = new HILActiveCasePage();
	HILLoginPage lP = new HILLoginPage();
	HILMyCasesPage mcP = new HILMyCasesPage();

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

	@Then("list of cases with table of {int} columns is displayed in {string} screen")
	public void list_of_cases_with_table_of_columns_is_displayed_in_screen(Integer int1, String string, io.cucumber.datatable.DataTable dataTable) throws IOException {
		try{
			String ssname = "list of cases with table of 10 columns is displayed in "+string+" screen";
			logger.info("Step: " + ssname);
			if(string.equalsIgnoreCase("Active Cases")){
				Assert.assertTrue(acP.isColumnHeadersDisplayed());
				Assert.assertTrue(acP.is10ColumnsDisplayed());
			}
			if(string.equalsIgnoreCase("Case History")){
				Assert.assertTrue(mcP.isColumnHeadersDisplayed());
				Assert.assertTrue(mcP.is8ColumnsDisplayed());
			}
			else {
				Assert.assertTrue(mcP.isColumnHeadersDisplayed());
				Assert.assertTrue(mcP.is8ColumnsDisplayed());
			}
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the records are sorted in {string} order of due date by default")
	public void the_records_are_sorted_in_ascending_order_of_due_date_by_default(String string) throws IOException {
		try{
			String ssname = "the records are sorted in "+string+" order of due date by default";
			logger.info("Step: " + ssname);
			Assert.assertTrue(acP.isDueDateSorting(string));
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the records are sorted in {string} order of due date by default in My cases screen")
	public void the_records_are_sorted_in_ascending_order_of_due_date_in_mycases(String string) throws IOException {
		try{
			String ssname = "the records are sorted in "+string+" order of due date by default in My cases screen";
			logger.info("Step: " + ssname);
			Assert.assertTrue(mcP.isDueDateSorting(string));
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("clicks on the {string} arrow of {string} column")
	public void clicks_on_the_arrow_of_column(String string, String string2) throws IOException {
		try{
			String ssname = "clicks on the "+string+" arrow of "+string2+" column";
			logger.info("Step: " + ssname);
			acP.clickDueDateHeaderArrow();
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the {string} is sorted in {string} order")
	public void the_is_sorted_in_order(String string, String string2) throws IOException {
		try{
			String ssname = "the "+string+" is sorted in "+string2+" order";
			logger.info("Step: " + ssname);
			if(string.equalsIgnoreCase("Due Date"))
			{Assert.assertTrue(acP.isDueDateSorting(string2));}
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user select an unclaimed case and click on Claim button")
	public void the_user_select_an_unclaimed_case_and_click_on_claim_button() throws IOException {
		try{
			logger.info("Step: the user select an unclaimed case and click on Claim button");
			acP.clickClaimButton();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the selected case file is claimed for S&N HIL reviewer and status is changed to {string}")
	public void the_selected_case_file_is_claimed_for_s_n_hil_reviewer_and_status_is_changed_to(String string) throws IOException, InterruptedException {
		try{
			String ssname = "the selected case file is claimed for S&N HIL reviewer and status is changed to "+string;
			logger.info("Step: " + ssname);
			String actual = acP.getStatusOfRecordSelectedRecord();
			if(string.equalsIgnoreCase("Overdue / Unclaimed")) {
				Assert.assertEquals(actual, "Overdue / Unclaimed");
			}
			else {
				Assert.assertNotEquals(actual, "Overdue / Unclaimed");
			}
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("View option in column {int} on selected case is changed to {string}")
	public void view_option_in_column_on_selected_case_is_changed_to(Integer int1, String string) throws IOException {
		try{
			String ssname = "View option in column 10 on selected case is changed to "+string;
			logger.info("Step: " + ssname);
			String actual = acP.checkVieworOpenButton();
			Assert.assertEquals(actual, string);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Claim option in column {int} is changed to {string}")
	public void claim_option_in_column_is_changed_to(Integer int1, String string) throws IOException {
		try{
			String ssname = "Claim option in column 9 is changed to "+string;
			logger.info("Step: " + ssname);
			Assert.assertEquals(acP.checkClaimUnclaimorUnassignButton(), string);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@When("the user selects another unclaimed case and click on Claim button")
	public void the_user_selects_another_unclaimed_case_and_click_on_claim_button() throws IOException {
		try{
			logger.info("Step: the user selects another unclaimed case and click on Claim button");
			acP.clickClaimButton();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on My Cases at top left")
	public void the_user_clicks_on_my_cases_at_top_left() throws IOException {
		try{
			logger.info("Step: the user clicks on My Cases at top left");
			acP.clickMyCases();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("My Cases screen is displayed")
	public void my_cases_screen_is_displayed() throws IOException {
		try{
			logger.info("Step: My Cases screen is displayed");
			acP.isMyCasesScreenDisplayed();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("claimed record from above steps are displayed")
	public void claimed_record_from_above_steps_are_displayed() throws IOException {
		try{
			logger.info("Step: claimed record from above steps are displayed");
			Assert.assertTrue(acP.isPreviouslyClaimedrecordsDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("verify Due Date and time format and time zone")
	public void verify_due_date_and_time_format_and_time_zone() throws IOException, ParseException {
		try{
			logger.info("Step: verify Due Date and time format and time zone");
			Assert.assertTrue(acP.checkDateTimeFormat());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("fonts and toggleable arrow in white color")
	public void fonts_and_toggleable_arrow_in_white_color() throws IOException {
		try{
			logger.info("Step: fonts and toggleable arrow in white color");
			Assert.assertTrue(acP.fontsAndArrowWhiteColor());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects an unclaimed case and click Edit icon of due date")
	public void the_user_selects_an_unclaimed_case_and_click_edit_icon_of_due_date() throws IOException {
		try{
			logger.info("Step: the user selects an unclaimed case and click Edit icon of due date");
			acP.clickEditButton();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Select a new due date popup is displayed with")
	public void select_a_new_due_date_popup_is_displayed_with(io.cucumber.datatable.DataTable dataTable) throws IOException {
		try{
			logger.info("Step: Select a new due date popup is displayed with");
			Assert.assertTrue(acP.verifyNewDueDatePopUp());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks Submit button in the new date popup")
	public void the_user_clicks_submit_button_in_the_new_date_popup() throws IOException {
		try{
			logger.info("Step: the user clicks Submit button in the new date popup");
			acP.clickNewDueDateSubmitBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the changed date and time is reflected in  the selected Case ID")
	public void the_changed_date_and_time_is_reflected_in_the_selected_case_id() throws IOException {
		try{
			logger.info("Step: the changed date and time is reflected in  the selected Case ID");
			Assert.assertTrue(acP.duedateChangedAfterEdit());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the Active cases screen is displayed with list of records")
	public void the_active_cases_screen_is_displayed_with_list_of_records() throws IOException {
		try{
			logger.info("Step: the Active cases screen is displayed with list of records");
			Assert.assertTrue(acP.activeCasesScreenIsDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("the Due date text is vertically centered alligned with the dates displayed in their column")
	public void the_due_date_text_is_vertically_centered_alligned_with_the_dates_displayed_in_their_column() throws IOException {
		try{
			logger.info("Step: the Due date text is vertically centered alligned with the dates displayed in their column");
			Assert.assertTrue(acP.duedateHEaderTextIsDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}


}
