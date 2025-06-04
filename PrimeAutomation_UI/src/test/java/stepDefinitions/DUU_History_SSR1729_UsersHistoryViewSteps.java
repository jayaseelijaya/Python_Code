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

public class DUU_History_SSR1729_UsersHistoryViewSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_History_SSR1729_UsersHistoryViewSteps.class);
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
	@When("the user unchecks 24hrs filter checkbox")
	public void the_user_unchecks_24hrs_filter_checkbox() {
		try {
			hvsPage.uncheck24HrsCheckboxFilter();
			logger.info("Step: 24hrs checkbox filter is unchecked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on filter button on history page")
	public void the_user_clicks_on_filter_button_on_history_page() {
		try {
			hvsPage.clickOnFilterButtonOnHistoryPage();
			logger.info("The filter button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	// *********************THEN BLOCK*******************************
	@Then("the scroll bar shall be displayed at the left side")
	public void the_scroll_bar_shall_be_displayed_at_the_left_side() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isScrollBarDisplayed());
			logger.info("Step: the scroll bar is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the scroll bar shall be displayed in green colour")
	public void the_scroll_bar_shall_be_displayed_in_green_colour() {
		try {
			Properties properties = reader.getProperty();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(hvsPage.isScrollbarDisplayedInGreenColour(),properties.getProperty("history.scrollbar"));
			logger.info("Step: the scroll bar is displayed in green colour");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the view details button shall be displayed at the left side of the screen")
	public void the_view_details_button_shall_be_displayed_at_the_left_side_of_the_screen() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isViewDetailsButtonDisplayed());
			logger.info("Step: the view details button is displayed at left side");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the 24hrs filter checkbox shall be displayed")
	public void the_24hrs_filter_checkbox_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.is24HrsCheckboxDisplayed());
			logger.info("Step: the 24hrs checkbox is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the 24hrs checkbox shall be highlighted in green colour")
	public void the_24hrs_checkbox_shall_be_highlighted_in_green_colour() {
		try {
			Properties properties = reader.getProperty();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(hvsPage.is24HrsCheckboxHighlightedInGreenColour(),properties.getProperty("history.24hrscheckbox"));
			logger.info("Step: the 24hrs checkbox is highlighted in green colour");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the search bar shall be displayed")
	public void the_search_bar_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isSearchBarDisplayed());
			logger.info("Step: the searchbar is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the search button shall be displayed on history screen")
	public void the_search_button_shall_be_displayed_on_history_screen() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isSearchButtonDisplayed());
			logger.info("Step: the search button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the uploaded files details shall be displayed as below")
	public void the_uploaded_files_details_shall_be_displayed_as_below(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("details").contains("Date of upload")) {
					Assert.assertTrue(hvsPage.isUploadFilesDetailsDisplayed("Date of upload").isDisplayed(), 
							"Date of upload is not displayed");
					logger.info("Date of upload is displayed");
				}
//				if (list.get(i).get("details").contains("site")) {
//					assertTrue(hvsPage.isUploadFilesDetailsDisplayed("site").isDisplayed(),
//							"site is not displayed.");
//					logger.info("site is displayed.");
//				}
				if (list.get(i).get("details").contains("Surgeon")) {
					assertTrue(hvsPage.isUploadFilesDetailsDisplayed("Surgeon").isDisplayed(),
							"Surgeon is not displayed.");
					logger.info("Surgeon is displayed.");
				}
				if (list.get(i).get("details").contains("Patient name")) {
					Assert.assertTrue(hvsPage.isUploadFilesDetailsDisplayed("Patient name").isDisplayed(),
							"Patient name is not displayed");
					logger.info("Patient name is displayed.");
				}
				if (list.get(i).get("details").contains("Application")) {
					assertTrue(hvsPage.isUploadFilesDetailsDisplayed("Application").isDisplayed(),
							"Application is not displayed.");
					logger.info("Application is displayed.");
				}
				if (list.get(i).get("details").contains("No. of files uploaded")) {
					assertTrue(hvsPage.isUploadFilesDetailsDisplayed("No. of files uploaded").isDisplayed(),
							"No. of files uploaded is not displayed.");
					logger.info("No. of files uploaded is displayed.");
				}
				if (list.get(i).get("details").contains("Status of image uploaded")) {
					assertTrue(
							hvsPage.isUploadFilesDetailsDisplayed("Status of image uploaded").isDisplayed(),
							"Status of image uploaded is not displayed");
					logger.info("Status of image uploaded is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The Upload dashboard details are not displayed");
			exception = e;
		}
	}
	
	@Then("the history screen shall display uploaded details at the top")
	public void the_history_screen_shall_display_uploaded_details_at_the_top() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hvsPage.isNewUploadedDetailsDisplayedAtTop());
			logger.info("Step: the history screen displayed uploaded details at the top");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the details of uploaded record shall be displayed as below")
	public void the_details_of_uploaded_record_shall_be_displayed_as_below(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("record").contains("date")) {
					Assert.assertTrue(hvsPage.isUploadedRecordDetailsDisplayed("date").isDisplayed(), 
							"date is not displayed");
					logger.info("date is displayed");
				}
				if (list.get(i).get("record").contains("upload id")) {
					assertTrue(hvsPage.isUploadedRecordDetailsDisplayed("upload id").isDisplayed(),
							"upload id is not displayed.");
					logger.info("upload id is displayed.");
				}
				if (list.get(i).get("record").contains("upload user")) {
					assertTrue(hvsPage.isUploadedRecordDetailsDisplayed("upload user").isDisplayed(),
							"upload user is not displayed.");
					logger.info("upload user is displayed.");
				}
				if (list.get(i).get("record").contains("patient")) {
					Assert.assertTrue(hvsPage.isUploadedRecordDetailsDisplayed("patient").isDisplayed(),
							"Patient name is not displayed");
					logger.info("Patient name is displayed.");
				}
				if (list.get(i).get("record").contains("doctor")) {
					assertTrue(hvsPage.isUploadedRecordDetailsDisplayed("doctor").isDisplayed(),
							"doctor is not displayed.");
					logger.info("doctor is displayed.");
				}
				if (list.get(i).get("record").contains("hospital")) {
					assertTrue(hvsPage.isUploadedRecordDetailsDisplayed("hospital").isDisplayed(),
							"hospital is not displayed.");
					logger.info("hospital is displayed.");
				}
				if (list.get(i).get("record").contains("status")) {
					assertTrue(
							hvsPage.isUploadedRecordDetailsDisplayed("status").isDisplayed(),
							"status is not displayed");
					logger.info("status is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The details of uploaded records are not displayed");
			exception = e;
		}
	}
	
	@Then("the View Details button is in enabled mode")
	public void the_view_details_button_is_in_enabled_mode() {
		try {
			hvsPage.isViewDetailsEnabled();
			logger.info("Step: View Details button is displayed  & in enabled mode");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the filter block gets removed")
	public void the_filter_block_gets_removed() {
		try {
			if(hvsPage.checkFilterBlockVisible()==false);
			logger.info("Step: Filter Block is not Visible");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
