package stepDefinitions;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SummaryDashboard_SSR1834_EndDateCurrentDateSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR1834_EndDateCurrentDateSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
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
	@When("the user selects current date as end date from the date picker table")
	public void the_user_selects_current_date_as_end_date_from_the_date_picker_table() {
		try {
			daPage.selectsEndDateFilterAsCurrentDateOnDashboard();
			logger.info("Step: User selected End date filter as Current date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected end date as current date shall be displayed")
	public void the_selected_end_date_as_current_date_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isSelectedCurrentDateAsEndDateDisplayed());
			logger.info("Step: Selected current date as end date is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the filter button is displayed in the top right")
	public void the_filter_button_is_displayed() {
		try {
			Assert.assertTrue(daPage.isFilterButtonDisplayed());
			logger.info("Filter button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find filter button");
			exception = e;
		}
	}
	
 	@Then("the user clicks the filter button")
 	public void user_clicks_filter_button_in_dashboard() {
 		try {
 			daPage.clickFilterButton();
 			logger.info("The User clicked the filter button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
 		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click filter button");
			exception = e;
		}
 	}
 	
 	@Then("the user clicks the plus button on the date filter")
 	public void user_clicks_plus_button_on_date_filter() {
 		try {
 			daPage.clickOnDateFiltermenu();
 			logger.info("User clicked plus button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
 		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click plus button");
			exception = e;
		}
 	}
 	
 	@Then("the user clicks the end button in the date filter")
 	public void user_clicks_end_button_in_date_filter() {
 		try {
 			daPage.clickOnEndButton();
 			logger.info("User clicked end date button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
 		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click end date button");
			exception = e;
		}
 	}
 	
 	@Then("verify all dates after the current date are not enabled")
 	public void verify_all_dates_after_current_date_are_disabled() {
 		try {
 			Assert.assertTrue(daPage.checkSubsequentDates());
 			logger.info("All dates after current date are disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
 		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("All dates after the current date are not disabled");
			exception = e;
		}
 	}
}
