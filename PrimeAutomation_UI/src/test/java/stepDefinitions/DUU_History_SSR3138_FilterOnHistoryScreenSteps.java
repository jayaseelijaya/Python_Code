package stepDefinitions;

import static org.testng.Assert.assertTrue;

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
import pages.HistoryViewScreenPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_History_SSR3138_FilterOnHistoryScreenSteps {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_History_SSR3138_FilterOnHistoryScreenSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HistoryViewScreenPage hvsPage = new HistoryViewScreenPage();

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
	@When("the user clicks on date filter option on history page")
	public void the_user_clicks_on_date_filter_option_on_history_page() {
		try {
			hvsPage.clickOnDateFilter();
			logger.info("Step: The user clicked on date filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects two days back from current date as start date")
	public void the_user_selects_days_back_from_current_date_as_start_date() {
		try {
			hvsPage.selectStartDateTwoDaysBackFromCurrentDate();
			logger.info("Step: User selected start date 2 days back from current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on + for uploader filter")
	public void the_user_clicks_on_for_uploader_filter() {
		try {
			hvsPage.clickOnUploaderFilter();
			logger.info("Step: The user clicked on + for uploader filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects any uploader name")
	public void the_user_selects_any_uploader_name() {
		try {
			hvsPage.selectAnyOption();
			logger.info("Step: The user selected an uploader");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on + for patient filter")
	public void the_user_clicks_on_for_patient_filter() {
		try {
			hvsPage.clickOnPatient();
			logger.info("Step: The user clicked on patient");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on x to remove the filters")
	public void the_user_clicks_on_x_to_remove_the_filters() {
		try {
			hvsPage.clickOnXToRemoveFilter();
			logger.info("Step: The user clicked on x to remove the filters");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user click on + for surgeon")
	public void the_user_click_on_for_surgeon() {
		try {
			hvsPage.clickOnSurgeonFilter();
			logger.info("Step: The user clicked on surgeon filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user deselects patient name")
	public void the_user_deselects_patient_name() {
		try {
			hvsPage.deselectPatientName();
			logger.info("Step: The user deselected patient name");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects any patient name")
	public void the_user_selects_any_patient_name() {
		try {
			hvsPage.selectAnyOption();
			logger.info("Step: The user selected an uploader");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects any surgeon name")
	public void the_user_selects_any_surgeon_name() {
		try {
			hvsPage.selectAnyOption();
			logger.info("Step: The user selected a surgeon");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user deselects surgeon name")
	public void the_user_deselects_surgeon_name() {
		try {
			hvsPage.deselectSurgeonName();
			logger.info("Step: The user deselected surgeon name");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user click on + for site")
	public void the_user_click_on_for_site() {
		try {
			hvsPage.clickOnSiteFilter();
			logger.info("Step: The user clicked on site filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects any site name")
	public void the_user_selects_any_site_name() {
		try {
			hvsPage.selectAnyOption();
			logger.info("Step: The user selected a site");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user click on + for file status")
	public void the_user_click_on_for_file_status() {
		try {
			hvsPage.clickOnFileStatusFilter();
			logger.info("Step: The user clicked on file status filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects any file status")
	public void the_user_selects_any_file_status() {
		try {
			hvsPage.selectAnyFileStatus();
			logger.info("Step: The user selected a file staus");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	// *********************THEN BLOCK*******************************
	@Then("the filter by options shall be displayed with + as below")
	public void the_filter_by_options_shall_be_displayed_with_as_below(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("option").contains("date")) {
					Assert.assertTrue(hvsPage.isFilterOptionsDisplayed("date").isDisplayed(), 
							"date filter option is not displayed");
					logger.info("date filter option is displayed");
				}
				if (list.get(i).get("option").contains("uploader")) {
					assertTrue(hvsPage.isFilterOptionsDisplayed("uploader").isDisplayed(),
							"uploader filter option is not displayed.");
					logger.info("uploader filter option is displayed.");
				}
				if (list.get(i).get("option").contains("patient")) {
					assertTrue(hvsPage.isFilterOptionsDisplayed("patient").isDisplayed(),
							"patient filter option is not displayed.");
					logger.info("patient filter option is displayed.");
				}
				if (list.get(i).get("option").contains("surgeon")) {
					Assert.assertTrue(hvsPage.isFilterOptionsDisplayed("surgeon").isDisplayed(),
							"surgeon filter option is not displayed");
					logger.info("surgeon filter option is displayed.");
				}
				if (list.get(i).get("option").contains("site")) {
					Assert.assertTrue(hvsPage.isFilterOptionsDisplayed("site").isDisplayed(),
							"site filter option is not displayed");
					logger.info("site filter option is displayed.");
				}
				if (list.get(i).get("option").contains("file status")) {
					assertTrue(hvsPage.isFilterOptionsDisplayed("file status").isDisplayed(),
							"file status filter option is not displayed.");
					logger.info("file status filter option is displayed.");
				}
				if (list.get(i).get("option").contains("done")) {
					assertTrue(
							hvsPage.isFilterOptionsDisplayed("done").isDisplayed(),
							"done button is not displayed");
					logger.info("done button displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The filter options are not displayed");
			exception = e;
		}
	}
	
	@Then("the start and end boxes shall be displayed")
	public void the_start_and_end_boxes_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isStartAndEndBoxesDisplayed());
			logger.info("Step: Start and end boxes are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the dates shall be selected in start and end date")
	public void the_dates_shall_be_selected_in_start_and_end_date() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.selectedStartEndDateDisplayed());
			logger.info("Step: Start and end dates are selected");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected date shall be displayed on the top of history screen")
	public void the_selected_date_shall_be_displayed_on_the_top_of_history_screen() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isSelectedFilterAtTopDisplayed());
			logger.info("Step: Selected date is displayed on the top of history screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected patient name shall be displayed on the top of history screen")
	public void the_selected_patient_name_shall_be_displayed_on_the_top_of_history_screen() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isSelectedFilterAtTopDisplayed());
			logger.info("Step: Selected patient is displayed on the top of history screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the history record table shall be filtered out as per selected date")
	public void the_history_record_table_shall_be_filtered_out_as_per_selected_date() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isHistoryRecordFiltered());
			logger.info("Step: The history record is filtered out as per selected date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the uploader names shall be displayed")
	public void the_uploader_names_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isOptionNamesDisplayed());
			logger.info("Step: The uploader names are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected uploader name and date shall be displayed on the top of history screen")
	public void the_selected_uploader_name_and_date_shall_be_displayed_on_the_top_of_history_screen() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isSelectedFilterAtTopDisplayed());
			logger.info("Step: Selected uploader name and date is displayed on the top of history screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the history record table shall be filtered out as per selected uploader name and dates")
	public void the_history_record_table_shall_be_filtered_out_as_per_selected_uploader_name_and_dates() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isHistoryRecordFiltered());
			logger.info("Step: The history record is filtered out as per selected uploader name and dates");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected filter shall be removed")
	public void the_selected_filter_shall_be_removed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertFalse(hvsPage.isFilterRemoved());
			logger.info("Step: Selected filter is removed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the history record table shall be filtered out as per selected patient name")
	public void the_history_record_table_shall_be_filtered_out_as_per_selected_patient_name() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isHistoryRecordFiltered());
			logger.info("Step: The history record is filtered out as per selected patient");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the surgeon names shall be displayed")
	public void the_surgeon_names_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isOptionNamesDisplayed());
			logger.info("Step: The surgeon names are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected surgeon name shall be displayed on the top of history screen")
	public void the_selected_surgeon_name_shall_be_displayed_on_the_top_of_history_screen() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isSelectedFilterAtTopDisplayed());
			logger.info("Step: Selected surgeon name is displayed on the top of history screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the history record table shall be filtered out as per selected surgeon name")
	public void the_history_record_table_shall_be_filtered_out_as_per_selected_surgeon_name() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isHistoryRecordFiltered());
			logger.info("Step: The history record is filtered out as per selected surgeon name");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the site and file status names shall be displayed")
	public void the_site_and_file_status_names_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isOptionNamesDisplayed());
			logger.info("Step: The site and file status names are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected site and file status name shall be displayed on the top of history screen")
	public void the_selected_site_and_file_status_name_shall_be_displayed_on_the_top_of_history_screen() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isSelectedFilterAtTopDisplayed());
			logger.info("Step: Selected site and file status name is displayed on the top of history screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the history record table shall be filtered out as per selected site and file status name")
	public void the_history_record_table_shall_be_filtered_out_as_per_site_and_file_status_name() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isHistoryRecordFiltered());
			logger.info("Step: The history record is filtered out as per selected site and file name");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	
	
	

}
