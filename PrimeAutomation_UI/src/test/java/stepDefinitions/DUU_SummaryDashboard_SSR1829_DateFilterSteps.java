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
import pages.FileDashboardPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SummaryDashboard_SSR1829_DateFilterSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR1829_DateFilterSteps.class);
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
	@When("the user clicks on date filter menu option")
	public void the_user_clicks_on_date_filter_menu_option() {
		try {
			daPage.clickOnDateFiltermenu();
			logger.info("Step: the date filter is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on start button")
	public void the_user_clicks_on_start_button() {
		try {
			daPage.clickOnStartButton();
			logger.info("Step: the start button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects a start date from the date picker table")
	public void the_user_selects_a_start_date_from_the_date_picker_table() {
		try {
			daPage.selectStartDate();
			logger.info("Step: the user selected a start date from date picker");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on end button")
	public void the_user_clicks_on_end_button() {
		try {
			daPage.clickOnEndButton();
			logger.info("Step: the end button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects a end date from the date picker table")
	public void the_user_selects_a_end_date_from_the_date_picker_table() {
		try {
			daPage.selectEndDate();
			logger.info("Step: the user selected a End date from date picker");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on done button")
	public void the_user_clicks_on_done_button() {
		try {
			daPage.clickOnDoneButton();
			logger.info("Step: done button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	
	// *********************THEN BLOCK*******************************
	@Then("the filter button shall be displayed")
	public void the_filter_button_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isFilterButtonDisplayed());
			logger.info("Step: Filter button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the following filter menu shall be displayed")
	public void the_following_filter_menu_shall_be_displayed(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("menu").contains("filter by")) {
					assertTrue(daPage.isFilterMenuDisplayed("filter by").isDisplayed(),
							"The filter by option is not displayed.");
					logger.info("The filter by option is displayed.");
				}
				if (list.get(i).get("menu").contains("date")) {
					assertTrue(daPage.isFilterMenuDisplayed("date").isDisplayed(),
							"The date option is not displayed.");
					logger.info("The date option is displayed.");
				}
				if (list.get(i).get("menu").contains("surgeon")) {
					assertTrue(daPage.isFilterMenuDisplayed("surgeon").isDisplayed(),
							"The surgeon option is not displayed.");
					logger.info("The surgeon option is displayed.");
				}
				if (list.get(i).get("menu").contains("site")) {
					assertTrue(daPage.isFilterMenuDisplayed("site").isDisplayed(),
							"The site option is not displayed.");
					logger.info("The site option is displayed.");
				}
				if (list.get(i).get("menu").contains("application")) {
					assertTrue(daPage.isFilterMenuDisplayed("application").isDisplayed(),
							"The application option is not displayed.");
					logger.info("The application option is displayed.");
				}
				if (list.get(i).get("menu").contains("file status")) {
					assertTrue(daPage.isFilterMenuDisplayed("file status").isDisplayed(),
							"The file status option is not displayed.");
					logger.info("The file status option is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The browse pc screen components are not displayed");
			exception = e;
		}
	}
	
	@Then("the start button and end button shall be displayed")
	public void the_start_button_and_end_button_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isStartEndButtonDisplayed());
			logger.info("Step: Start and End buttons are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the start date picker table shall be diaplsyed")
	public void the_start_date_picker_table_shall_be_diaplsyed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isStartDateTableDisplayed());
			logger.info("Step: Start date picker table is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected start date shall be displayed")
	public void the_selected_start_date_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isSelectedStartDateDisplayed());
			logger.info("Step: Selected Start date is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the end date picker table shall be displayed")
	public void the_end_date_picker_table_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isEndDateTableDisplayed());
			logger.info("Step: End date picker table is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected end date shall be displayed")
	public void the_selected_end_date_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isSelectedEndDateDisplayed());
			logger.info("Step: Selected End date is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the dashboard summary shall be filtered based on selected date")
	public void the_dashboard_summary_shall_be_filtered_based_on_selected_date() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isDashboardFilteredBasedOnDate());
			logger.info("Step: the summary dashboard is filtered based on selected date");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the calender shall be displayed all dates in greyed out")
	public void the_calender_shall_be_displayed_all_dates_in_greyed_out() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isCalendarDateGreyedOut());
			logger.info("Step: the calender is displayed all dates in greyed out.");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the only current date shall be selectable")
	public void the_only_current_date_shall_be_selectable() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isOnlyCurrentDateSelectableDate());
			logger.info("Step: the current date is only selectable date.");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
