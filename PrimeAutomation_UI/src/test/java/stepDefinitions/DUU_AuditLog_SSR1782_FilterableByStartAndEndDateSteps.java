package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import pages.AuditLogPage;
import pages.FileDashboardPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_AuditLog_SSR1782_FilterableByStartAndEndDateSteps {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_AuditLog_SSR1782_FilterableByStartAndEndDateSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	AuditLogPage alPage = new AuditLogPage();
	SelectedActivityPage saPage = new SelectedActivityPage();
	FileDashboardPage daPage = new FileDashboardPage();

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
	@When("the user clicks on filter button on audit log")
	public void the_user_clicks_on_filter_button_on_audit_log() {
		try {
			alPage.clickOnFilterButton();
			logger.info("Step: the filter button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
//	@When("the user expands date option")
//	public void the_user_expands_date_option() {
//		try {
//			alPage.clickOnDateOption();
//			logger.info("Step: the date option is clicked");
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
	
	@When("the user clicks on date filter option")
	public void the_user_clicks_on_date_filter_option() {
		try {
			//daPage.waitForSpinnerToDisappear();
			alPage.clickOnDateFilterOption();
			logger.info("Step: Date filter option is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on start date button")
	public void the_user_clicks_on_start_date_button() {
		try {
			alPage.clickOnStartDateButton();
			logger.info("Step: the user clicked start date button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects current date as start date")
	public void the_user_selects_current_date_as_start_date() {
		try {
			alPage.selectStartDateFilterAsCurrentDate();
			logger.info("Step: User selected start date filter as Current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects start date less than current date")
	public void the_user_selects_start_date_less_than_current_date() {
		try {
			alPage.selectDateLessThanCurrentDate();
			logger.info("Step: User selected start date less than current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on done button to close the filter option")
	public void the_user_clicks_on_done_button_to_close_the_filter_option() {
		try {
			alPage.clickOnDoneButton();
			logger.info("Step: The done button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on end date button")
	public void the_user_clicks_on_end_date_button() {
		try {
			alPage.clickOnEndDateButton();
			logger.info("Step: the user clicked end date button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects end date as current date")
	public void the_user_selects_end_date_as_current_date() {
		try {
			alPage.selectEndDateFilterAsCurrentDate();
			logger.info("Step: User selected end date filter as Current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects end date less than current date")
	public void the_user_selects_end_date_less_than_current_date() {
		try {
			alPage.selectDateLessThanCurrentDate();
			logger.info("Step: User selected end date less than current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects start date lesser than end date")
	public void the_user_selects_start_date_lesser_than_end_date() {
		try {
			alPage.selectDateLessThanCurrentDate();
			logger.info("Step: User selected start date lesser than end date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects lesser start date than current date")
	public void the_user_selects_lesser_start_date_than_current_date() {
		try {
			alPage.selectStartDateLessThanCurrentDate();
			logger.info("Step: User selected start date days less than current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects greater end date than start date")
	public void the_user_selects_greater_end_date_than_start_date() {
		try {
			alPage.selectDateLessThanCurrentDate();
			logger.info("Step: User selected greater end date than start date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on date column to sort the table")
	public void the_user_clicks_on_date_column_to_sort_the_table() {
		try {
			alPage.clickOnDateColumn();
			logger.info("Step: User clicked on date column to sort the table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects greater date in start date")
	public void the_user_selects_greater_date_in_start_date() {
		try {
			alPage.selectDateLessThanCurrentDate();
			logger.info("Step: User selected greater date in start date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects lesser date in end date")
	public void the_user_selects_lesser_date_in_end_date() {
		try {
			alPage.selectStartDateLessThanCurrentDate();
			logger.info("Step: User can not select lesser end date than start date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects start date greater than current date")
	public void the_user_selects_start_date_greater_than_current_date() {
		try {
			alPage.selectDateGreaterThanCurrentDate();
			logger.info("Step: User can not select greater start date than current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects end date greater than current date")
	public void the_user_selects_end_date_greater_than_current_date() {
		try {
			alPage.selectDateGreaterThanCurrentDate();
			logger.info("Step: User can not select greater end date than current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	// *********************THEN BLOCK*******************************
	@Then("the audit log header text shall be displayed")
	public void the_audit_log_header_text_shall_be_displayed() {
		try {
			Assert.assertTrue(saPage.isAuditLogHeaderDisplayed());
			logger.info("Step: The audit log header text is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the 24hrs filter shall be displayed on audit log")
	public void the_24hrs_filter_shall_be_displayed_on_audit_log() {
		try {
			Assert.assertTrue(alPage.is24HrsFilterOnAuditLogDisplayed());
			logger.info("Step: The 24Hrs filter on audit log is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the filter button shall be displayed on audit log")
	public void the_filter_button_shall_be_displayed_on_audit_log() {
		try {
			Assert.assertTrue(alPage.isFilterBttonOnAuditLogDisplayed());
			logger.info("Step: The filter button on audit log is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the search textbox shall be displayed on audit log")
	public void the_search_textbox_shall_be_displayed_on_audit_log() {
		try {
			Assert.assertTrue(alPage.isSearchboxOnAuditLogDisplayed());
			logger.info("Step: The search box is displayed on audit log");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the search button shall be displayed on audit log")
	public void the_search_button_shall_be_displayed_on_audit_log() {
		try {
			Assert.assertTrue(alPage.isSearchButtonOnAuditLogDisplayed());
			logger.info("Step: The search button is displayed on audit log");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the following audit log table header shall be displayed")
	public void the_following_audit_log_table_header_shall_be_displayed(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				Properties properties = reader.getProperty();
				if (list.get(i).get("header").contains("date")) {
					assertTrue(alPage.isAuditLogTableHeaderDisplayed("date").isDisplayed(),
							"The date header is not displayed.");
					logger.info("The date header is displayed.");
				}
				if (list.get(i).get("header").contains("user")) {
					assertTrue(alPage.isAuditLogTableHeaderDisplayed("user").isDisplayed(),
							"The user header is not displayed.");
					logger.info("The user header is displayed.");
				}
				if (list.get(i).get("header").contains("username")) {
					assertTrue(alPage.isAuditLogTableHeaderDisplayed("username").isDisplayed(),
							"The username header is not displayed.");
					logger.info("The username header is displayed.");
				}
				if (list.get(i).get("header").contains("action")) {
					assertTrue(alPage.isAuditLogTableHeaderDisplayed("action").isDisplayed(),
							"The action header is not displayed.");
					logger.info("The action header is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The audit log table headers are not displayed");
			exception = e;
		}
	}
	
	@Then("the audit log records shall be displayed")
	public void the_audit_log_records_shall_be_displayed() {
		try {
			Assert.assertTrue(alPage.isAuditLogTableRecordsDisplayed());
			logger.info("Step: The audit log records are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the export selected button shall be displayed")
	public void the_export_selected_button_shall_be_displayed() {
		try {
			Assert.assertTrue(alPage.isExportSelectedButtonDisplayed());
			logger.info("Step: The export selected button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the export all button shall be displayed")
	public void the_export_all_button_shall_be_displayed() {
		try {
			Assert.assertTrue(alPage.isExportAllButtonDisplayed());
			logger.info("Step: The export all button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the scrollbar shall be displayed on audit log at right side")
	public void the_scrollbar_shall_be_displayed_on_audit_log_at_right_side() {
		try {
			Assert.assertTrue(alPage.isScrollBarDisplayed());
			logger.info("Step: The scrollbar is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the show more button shall be displayed on audit log")
	public void the_show_more_button_shall_be_displayed_on_audit_log() {
		try {
			Assert.assertTrue(alPage.isShowMoreButtonDisplayed());
			logger.info("Step: The show more button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("end date shall be selected as current date by default")
	public void end_date_shall_be_selected_as_current_date_by_default() {
		try {
			Date date1 = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
			String today = formatter.format(date1);
			Assert.assertEquals(alPage.isEndDateByDefaultAsCurrentDate(), today);
			logger.info("Step: The end date by default is displayed as current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log records shall be filtered as per current date")
	public void the_audit_log_records_shall_be_filtered_as_per_current_date() {
		try {
			
			Assert.assertTrue(alPage.getAuditLogFilteredAsPerCurrentDate());
			logger.info("Step: The audit log records are filtered as per current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the start date shall be displayed as current date")
	public void the_start_date_shall_be_displayed_as_current_date() {
		try {
			Date date1 = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
			String today = formatter.format(date1);
			Assert.assertEquals(alPage.isStartDateAsCurrentDateDisplayed(), today);
			logger.info("Step: The start date is displayed as current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log records shall be filtered as per selected start date")
	public void the_audit_log_records_shall_be_filtered_as_per_selected_start_date() {
		try {
			
			Assert.assertTrue(alPage.getAuditLogFilteredAsPerSelectedDate());
			logger.info("Step: The audit log records are filtered as per selected current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log records shall be filtered as per current date as end date")
	public void the_audit_log_records_shall_be_filtered_as_per_current_date_as_end_date() {
		try {
			
			Assert.assertTrue(alPage.getAuditLogFilteredAsPerCurrentDate());
			logger.info("Step: The audit log records are filtered as per current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the end date shall be displayed as current date")
	public void the_end_date_shall_be_displayed_as_current_date() {
		try {
			Date date1 = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
			String today = formatter.format(date1);
			Assert.assertEquals(alPage.isEndDateAsCurrentDateDisplayed(), today);
			logger.info("Step: The end date is displayed as current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the start date shall display no date if date is not selected")
	public void the_start_date_shall_display_no_date_if_date_is_not_selected() {
		try {
			
			Assert.assertFalse(alPage.isNoDateDisplayedInStartDate());
			logger.info("Step: Start date is displayed as no date selected");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log records shall be filtered as per selected new end date")
	public void the_audit_log_records_shall_be_filtered_as_per_selected_new_end_date() {
		try {
			
			Assert.assertTrue(alPage.getAuditLogFilteredAsPerSelectedDate());
			logger.info("Step: The audit log records are filtered as per selected new end date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log records shall be filtered as per lesser start date and end date")
	public void the_audit_log_records_shall_be_filtered_as_per_lesser_start_date_and_end_date() {
		try {
			
			Assert.assertTrue(alPage.getAuditLogFilteredAsPerSelectedDate());
			logger.info("Step: The audit log records are filtered as per lesser start date and end date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log records shall be filtered as selected end date")
	public void the_audit_log_records_shall_be_filtered_as_selected_end_date() {
		try {
			
			Assert.assertTrue(alPage.getAuditLogFilteredAsPerSelectedDate());
			logger.info("Step: The audit log records are filtered as per selected end date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log records shall be filtered as selected start date")
	public void the_audit_log_records_shall_be_filtered_as_selected_start_date() {
		try {
			
			Assert.assertTrue(alPage.getAuditLogFilteredAsPerSelectedDate());
			logger.info("Step: The audit log records are filtered as per selected end date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the end date shall display no date if date is not selected")
	public void the_end_date_shall_display_no_date_if_date_is_not_selected() {
		try {
			
			Assert.assertFalse(alPage.isNoDateDisplayedInEndDate());
			logger.info("Step: end date is displayed as no date selected");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log records shall be filtered as current start and end date")
	public void the_audit_log_records_shall_be_filtered_as_current_start_and_end_date() {
		try {
			
			Assert.assertTrue(alPage.getAuditLogFilteredAsPerSelectedDate());
			logger.info("Step: The audit log records are filtered as per selected current start and end date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected start date and end date shall be displayed")
	public void the_selected_start_date_and_end_date_shall_be_displayed() {
		try {
			
			Assert.assertTrue(alPage.isSelectedStartEndDateDisplayed());
			logger.info("Step: The selected start and end date are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log records shall be filtered as per selected lesser start and greater end date")
	public void the_audit_log_records_shall_be_filtered_as_per_selected_lesser_start_and_greater_end_date() {
		try {
			
			Assert.assertTrue(alPage.getAuditLogFilteredAsPerSelectedDate());
			logger.info("Step: The audit log records are filtered as per selected lesser start and greater end date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log records shall be sorted in ascending order")
	public void the_audit_log_records_shall_be_sorted_in_ascending_order() {
		try {
			Assert.assertTrue(alPage.isAuditLogSortedInAscendingOrder());
			logger.info("Step: The audit log records are sorted in ascending order");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	
}
