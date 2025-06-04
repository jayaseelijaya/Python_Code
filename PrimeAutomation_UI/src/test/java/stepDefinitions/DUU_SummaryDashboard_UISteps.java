package stepDefinitions;

import java.time.Duration;
import java.util.Properties;

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

public class DUU_SummaryDashboard_UISteps {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_UISteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FileDashboardPage daPage = new FileDashboardPage();
	SelectedActivityPage saPage = new SelectedActivityPage();
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
	@When("the user selects multiple filters")
	public void the_user_selects_multiple_filters() {
		try {
			daPage.selectMultipleFilters();
			logger.info("Step: Multiple filter is selected");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	// *********************THEN BLOCK*******************************
		@Then("the file dashboard on left menu panel shall be highlighted")
		public void the_file_dashboard_on_left_menu_panel_shall_be_highlighted() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(saPage.isDashboardHighlighted(),properties.getProperty("selectedtab.color"));
				logger.info("Step: File dashbaord on left menu panel is highlighted");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the header text as upload dashboard shall be displayed")
		public void the_header_text_as_upload_dashboard_shall_be_displayed() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(saPage.isDashboardHeaderDisplayed());
				logger.info("Step: the header text as upload dashboard is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the list of records shall be displayed in the table")
		public void the_list_of_records_shall_be_displayed_in_the_table() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(daPage.isRecordsDisplayedInDescendingOrder());
				logger.info("Step: the list of records in the table is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the processing checkbox shall be displayed")
		public void the_processing_checkbox_shall_be_displayed() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(daPage.isProcessingCheckboxDisplayed());
				logger.info("Step: the processing checkbox is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the processing checkbox shall have circled arrow in grey colour")
		public void the_processing_checkbox_shall_have_circled_arrow_in_grey_colour() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(daPage.getProcessingCheckboxColor(),properties.getProperty("processing.color"));
				logger.info("Step: the processing checkbox circled arrow is in grey colour");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the uploaded checkbox shall be displayed")
		public void the_uploaded_checkbox_shall_be_displayed() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(daPage.isUploadedCheckboxDisplayed());
				logger.info("Step: the uploaded checkbox is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the uploaded checkbox shall have tick mark icon in white colour")
		public void the_uploaded_checkbox_shall_have_tick_mark_icon_in_white_colour() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(daPage.getUploadedCheckboxTickMarkColor(),properties.getProperty("uploaded.color"));
				logger.info("Step: the uploaded checkbox tick mark is in white colour");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the complete checkbox shall be displayed")
		public void the_complete_checkbox_shall_be_displayed() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(daPage.isCompleteCheckboxDisplayed());
				logger.info("Step: the complete checkbox is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the complete checkbox shall have tick mark icon in green colour")
		public void the_complete_checkbox_shall_have_tick_mark_icon_in_green_colour() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(daPage.getCompleteCheckboxTickMarkColor(),properties.getProperty("complete.color"));
				logger.info("Step: the complete checkbox tick mark is in green colour");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the error checkbox shall be displayed")
		public void the_error_checkbox_shall_be_displayed() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(daPage.isErrorCheckboxDisplayed());
				logger.info("Step: the error checkbox is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the error checkbox shall have exclamation mark icon in yellow colour")
		public void the_error_checkbox_shall_have_exclamation_mark_icon_in_yellow_colour() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(daPage.getErrorCheckboxTickMarkColor(),properties.getProperty("error.color"));
				logger.info("Step: the error checkbox tick mark is in yellow colour");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the 24hrs checkbox shall be displayed")
		public void the_24hrs_checkbox_shall_be_displayed() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(daPage.isTwentyFourHrsCheckboxDisplayed());
				logger.info("Step: the 24Hrs checkbox is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the 24hrs checkbox shall have icon in white colour")
		public void the_24hrs_checkbox_shall_have_icon_in_white_colour() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(daPage.getTwentyFourHrsCheckboxTickMarkColor(),properties.getProperty("twentyfourhrs.color"));
				logger.info("Step: the 24Hrs checkbox is in white colour");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the filter button shall have three lines icon in white colour")
		public void the_filter_button_shall_have_lines_icon_in_white_colour() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(daPage.getFilterButtonIconColor(),properties.getProperty("filter.color"));
				logger.info("Step: the filter button icon is in white colour");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the search box shall have icon in white colour")
		public void the_search_box_shall_have_icon_in_white_colour() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(daPage.getSearchboxIconColor(),properties.getProperty("searchbox.color"));
				logger.info("Step: the searchbox icon is in white colour");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the search button shall be displayed")
		public void the_search_button_shall_be_displayed() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(daPage.isSearchButtonDisplayed());
				logger.info("Step: the search button is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the search button shall be displayed in green colour")
		public void the_search_button_shall_be_displayed_in_green_colour() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(daPage.getSearchButtonTextColor(),properties.getProperty("searchbutton.color"));
				logger.info("Step: the search button text is in black colour");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the Searchbox shall be displayed")
		public void the_searchbox_shall_be_displayed() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(daPage.isSearchBoxDisplayed());
				logger.info("Step: the search box is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the done button shall be displayed in green colour")
		public void the_done_button_shall_be_displayed_in_green_colour() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(daPage.getDoneButtonColor(),properties.getProperty("donebutton.color"));
				logger.info("Step: the done button is in green colour");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the selected filters shall be displayed on top left corner")
		public void the_selected_filters_shall_be_displayed_on_top_left_corner() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(daPage.isSelectedFiltersDisplayed());
				logger.info("Step: the selected filters are displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("selected filter shall have icon as X")
		public void selected_filter_shall_have_icon_as_x() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(daPage.isSelectedFiltersXIconDisplayed());
				logger.info("Step: the selected filters X icon are displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
	

}
