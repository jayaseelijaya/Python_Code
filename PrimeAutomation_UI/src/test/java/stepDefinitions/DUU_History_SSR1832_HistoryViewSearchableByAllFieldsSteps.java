package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
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
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_History_SSR1832_HistoryViewSearchableByAllFieldsSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_History_SSR1832_HistoryViewSearchableByAllFieldsSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HistoryViewScreenPage hvsPage = new HistoryViewScreenPage();
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
	// *********************WHEN BLOCK*******************************

	@When("the user clicks on search button in history page")
	public void the_user_clicks_on_search_button_in_history_page() {
		try {
			hvsPage.clickOnSearchButtonInHistory();
			logger.info("Step: search button is clicked");
			utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").getAttribute("value");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects 24hrs filter checkbox")
	public void the_user_selects_24hrs_filter_checkbox() {
		try {
			hvsPage.select24HrsCheckboxFilter();
			logger.info("Step: 24hrs checkbox filter is selected");
			utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").getAttribute("value");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters a patient first name in search box")
	public void the_user_enters_a_patient_first_name_in_search_box() {
		try {
			hvsPage.enterPatientNameInSearchBox();
			logger.info("Step: The patient first name is entered in the search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on Search Button on history page")
	public void the_user_clicks_on_Search_Button_on_history_page() {
		try {
			hvsPage.clickOnSearchButtonOnHistoryPage();
			logger.info("Step: The Search button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on filter button in history page")
	public void the_user_clicks_on_filter_button_in_history_page() {
		try {
			hvsPage.clickOnFilterButtonOnHistoryPage();
			logger.info("Step: The filter button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters current date in the search box")
	public void the_user_enters_current_date_in_the_search_box() {
		try {
			hvsPage.enterCurrentDateInSearchBox();
			logger.info("Step: Current date is entered in searchbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters any upload id in the search box")
	public void the_user_enters_any_upload_id_in_the_search_box() {
		try {
			hvsPage.enterUploadIdInSearchBox();
			logger.info("Step: Upload Id is entered in the search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters any data which is not present in history record in the search box")
	public void the_user_enters_any_data_which_is_not_present_in_history_record_in_the_search_box() {
		try {
			hvsPage.enterAnyDataNotPresentInTable();
			logger.info("Step: data is entered which is not present in table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user removes text in searchbox")
	public void the_user_removes_text_in_searchbox() {
		try {
			hvsPage.removeTextInSearchBox();
			logger.info("Step: The text is removed from search box");
			LoginPage.driver.navigate().refresh();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user removes upload user text from searchbox")
	public void the_user_removes_upload_user_text_in_searchbox() {
		try {
			hvsPage.removeTextInSearchBox();
			logger.info("Step: The upload user text is removed from search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user removes text from searchbox & click on hours quick filter")
	public void user_removes_text_from_searchbox_click_on_hours_quick_filter() throws IOException {
		try {
			utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").clear();
			hvsPage.select24HrsCheckboxFilter();
			logger.info("Step: Text is removed from search box and 24 hours quick filter is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// *********************THEN BLOCK*******************************
	@Then("the search button shall be dipslayed at top right")
	public void the_search_button_shall_be_dipslayed_at_top_right() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isSearchButtonDisplayed());
			logger.info("Step: Search button is displayed at top right in history page");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the below table header shall be displayed on history page")
	public void the_below_table_header_shall_be_displayed_on_history_page(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				Properties properties = reader.getProperty();
				if (list.get(i).get("header").contains("date")) {
					Assert.assertTrue(hvsPage.isHistoryPageHeaderDisplayed("date").isDisplayed(),
							"date header is not displayed.");
					logger.info("date header is displayed.");
				}
				if (list.get(i).get("header").contains("upload id")) {
					assertTrue(hvsPage.isHistoryPageHeaderDisplayed("upload id").isDisplayed(),
							"The upload id header is not displayed.");
					logger.info("The upload id header is displayed.");
				}
				if (list.get(i).get("header").contains("upload user")) {
					assertTrue(hvsPage.isHistoryPageHeaderDisplayed("upload user").isDisplayed(),
							"The upload user header is not displayed.");
					logger.info("upload user header is displayed.");
				}
				if (list.get(i).get("header").contains("patient")) {
					Assert.assertTrue(hvsPage.isHistoryPageHeaderDisplayed("patient").isDisplayed(),
							"The patient header is displayed.");
					logger.info("The patient header is displayed.");
				}
				if (list.get(i).get("header").contains("doctor")) {
					assertTrue(hvsPage.isHistoryPageHeaderDisplayed("doctor").isDisplayed(),
							"The doctor header is not displayed.");
					logger.info("The doctor header is displayed.");
				}
				if (list.get(i).get("header").contains("hospital")) {
					assertTrue(hvsPage.isHistoryPageHeaderDisplayed("hospital").isDisplayed(),
							"The hospital header is not displayed.");
					logger.info("The hospital header is displayed.");
				}
				if (list.get(i).get("header").contains("status")) {
					Assert.assertTrue(hvsPage.isHistoryPageHeaderDisplayed("status").isDisplayed(),
							"The status header is displayed.");
					logger.info("The status header is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The history page headers are not displayed");
			exception = e;
		}
	}

	@Then("the table shall display records based on 24hrs filter")
	public void the_table_shall_display_records_based_on_24hrs_filter() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.get24HrsFilteredRecords());
			logger.info("Step: the table displayed 24hrs filtered records");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the entered patient record shall be displayed in 24hrs filter")
	public void the_entered_patient_record_shall_be_displayed_in_24hrs_filter() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.get24HrsFilteredRecordsBasedOnSearchedPatientName());
			logger.info("Step: the entered patient name is displayed in 24hrs filtered records");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the 24hrs checkbox filter shall be removed automatically")
	public void the_24hrs_checkbox_filter_shall_be_removed_automatically() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertFalse(hvsPage.is24HrsCheckboxRemoved());
			logger.info("Step: the 24hrs checkbox filter is removed automatically");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the entered patient details shall be displayed within the selected date")
	public void the_entered_patient_details_shall_be_displayed_within_the_selected_date() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.getEnteredPatientNameWithinSelectedDate());
			logger.info("Step: the entered patient details is displayed within selected date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the selected filter shall be displayed at top left section")
	public void the_selected_filter_shall_be_displayed_at_top_left_section() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isSelectedFilterDisplayed());
			logger.info("Step: Selected filter is dispalyed at top left of the screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the records shall be filtered based on applied previous filters")
	public void the_records_shall_be_filtered_based_on_applied_previous_filters() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.getRecordsBasedOnAppliedFilters());
			logger.info("Step: the record is displayed based on applied filters");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the history view shall be displayed as no data to display")
	public void the_history_view_shall_be_displayed_as_no_data_to_display() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isHistoryViewDisplayedNoDataToDisplay());
			logger.info("Step: the history view displayed no data to display");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the history view table shall be displayed")
	public void the_history_view_table_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isHistoryViewTableDisplayed());
			logger.info("Step: the history view table is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the history view shall be filterable as per uploader first name entered")
	public void the_history_view_shall_be_filterable_as_per_uploader_first_name_entered() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isHistoryViewFilteredAsPerEnteredUploaderName());
			logger.info("Step: the history view is filtered as per entered uploader first name");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("History label at the top left side is highlighted in white color")
	public void History_label_at_the_top_side_highlighted_white_color() {
		try {
			Properties properties = reader.getProperty();
			// hvsPage.isHistoryHeaderHighlighted();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// Assert.assertEquals(hvsPage.isHistoryViewFilteredAsPerEnteredSurgeonName());

			Assert.assertEquals(hvsPage.isHistoryHeaderHighlighted(), properties.getProperty("white.color"));
			logger.info("Step: History Label at the top left side is highlighted in white color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("hours checkbox is displayed")
	public void hours_checkbox_is_displayed() {
		try {

			hvsPage.isHoursChexkboxDisplayed();
			logger.info("Step: 24 Hours checkbox is displayed at the top panel");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Filter option is displayed")
	public void filter_option_is_displayed() {
		try {
			hvsPage.isFilterBtnDisplayed();
			logger.info("Step: Filter Option is displayed at the top panel");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Search Box is displayed")
	public void search_box_is_displayed() {
		try {
			hvsPage.isSearchBoxDisplayed();
			logger.info("Step: Search Box is displayed at the top panel");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Search Button is displayed")
	public void search_button_is_displayed() {
		try {
			hvsPage.isSearchButtonDisplayed();
			logger.info("Step: Search Button is displayed at the top panel");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Record entry text is displayed at the top")
	public void record_entry_text_is_displayed_at_the_top() {
		try {
			hvsPage.recordEntryPage();
			logger.info("Step: Record Entry text is displayed in History Page");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("View Details button in disabled mode is displayed")
	public void view_details_button_in_disabled_mode_is_displayed() {
		try {
			hvsPage.isViewDetailsdisabled();
			logger.info("Step: View Details button is displayed  & in disabled mode");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Show More button is displayed")
	public void show_more_button_is_displayed() {
		try {
			hvsPage.isShowMoreBtnDisplayed();
			logger.info("Step: Show More button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("list of history records are displayed to user")
	public void list_of_history_records_are_displayed_to_user() {
		try {
			hvsPage.isHistoryRecordsDisplayed();
			logger.info("Step: List of records in History page is displayed to user");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("user removes the filter from screen")
	public void user_removes_the_filter_from_screen() {
		try {
			hvsPage.removeFilter();
			logger.info("Step: Filter is removed from History page");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enter any upload user name in search box from the history screen")
	public void the_user_enter_any_upload_user_name_in_search_box_from_the_history_screen() {
		try {
			hvsPage.enterUploadUserInSearchBox();
			logger.info("Step: Upload user name is entered in search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on Filter Option")
	public void the_user_clicks_on_filter_option() {
		try {
			hvsPage.clickOnFilterButtonOnHistoryPage();
			logger.info("Step: Filter button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("click on uploader icon & selects another uploader name")
	public void click_on_uploader_icon_selects_another_uploader_name() {
		try {
			hvsPage.clickOnFilterPlusIcon();
			logger.info("Filter button is clicked");
			hvsPage.SelectUploaderfromFilter();
			logger.info("Step: Uploader is selected from filter option");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("click on Done button from the filter option")
	public void click_on_done_button_from_the_filter_option() {
		try {
			hvsPage.clickOnDoneBtn();
			logger.info("Step: Done button from the filter option is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("clicks on file status & selects any status")
	public void clicks_on_file_status_selects_any_status() {
		try {
			hvsPage.clickFileStatusOnFilter();
			logger.info("File Status from filter is clicked");
			hvsPage.SelectFileStatusfromFilter();
			logger.info("Step: File status is selected from filter option");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("clicks on site option & selects any site")
	public void clicks_on_site_option_selects_any_site() {
		try {
			hvsPage.clickSiteOnFilter();
			logger.info("Site from filter is clicked");
			hvsPage.SelectSitefromFilter();
			logger.info("Step: Site is selected from filter option");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("clicks on uploader option & selects any uploader")
	public void clicks_on_uploader_option_selects_any_uploader() {
		try {
			hvsPage.clickOnFilterPlusIcon();
			logger.info("Uploader from filter option is clicked");
			hvsPage.SelectUploaderfromFilter();
			logger.info("Step: Uploader is selected from filter option");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
