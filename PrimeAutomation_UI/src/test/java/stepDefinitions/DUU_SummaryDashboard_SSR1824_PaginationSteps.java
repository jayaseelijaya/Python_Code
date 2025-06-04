package stepDefinitions;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.HistoryViewScreenPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SummaryDashboard_SSR1824_PaginationSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_History_SSR1832_HistoryViewSearchableByAllFieldsSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FileDashboardPage fdP = new FileDashboardPage();

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
	
	@Then("Show more button shall be displayed")
	public void show_more_button_shall_be_displayed() throws IOException {
		try {
			logger.info("Step: Show more button shall be displayed");
			Assert.assertTrue(fdP.isShowmoreBtnDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName() , LoginPage.driver);
		}
		 catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
		}
	}
	
	@When("the user clicks on show more button")
	public void the_user_clicks_on_show_more_button() {
		try {
			logger.info("Step: the user clicks on show more button");
			fdP.clickShowmoreBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName() , LoginPage.driver);
		}
		 catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
		}
	}
	@Then("more records is loaded in the Upload Dashboard screen")
	public void more_records_is_loaded_in_the_upload_dashboard_screen() throws IOException, InterruptedException {
		try {
			logger.info("Step: more records is loaded in the Upload Dashboard screen");
			Assert.assertTrue(fdP.isMoreRecordsDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName() , LoginPage.driver);
		}
		 catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
		}
	}
	@Then("scroll bar is displayed in green color")
	public void scroll_bar_is_displayed_in_green_color() throws IOException {
		try {
			logger.info("Step: scroll bar is displayed in green color");
			Assert.assertTrue(fdP.getScrollBarColor());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName() , LoginPage.driver);
		}
		 catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
		}
	}
	@Then("the user is able to scroll through the records")
	public void the_user_is_able_to_scroll_through_the_records() throws IOException {
		try {
			logger.info("Step: the user is able to scroll through the records");
			fdP.isRecordsScrollable();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName() , LoginPage.driver);
		}
		 catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
		}
	}
}
