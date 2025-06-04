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
import pages.HistoryViewScreenPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_AuditLog_SSR1763_AccessScreenSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_AuditLog_SSR1763_AccessScreenSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FileDashboardPage fp = new FileDashboardPage();
	HistoryViewScreenPage hp = new HistoryViewScreenPage();

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

	@Then("upload records are displayed in the page")
	public void upload_records_are_displayed_in_the_page() {
		try {
			fp.isRecordsDisplayed();
			logger.info("Step : Records are displayed in the upload dashboard page");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records are displayed on history screen")
	public void records_are_displayed_in_the_History_screen() {
		try {
			hp.isHistoryRecordsDisplayed();
			logger.info("Step : Records are displayed in the History page");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on filter button from upload dashboard page")
	public void user_clicks_filter_button() {
		try {
			fp.clickFilterButton();
			logger.info("Step : Filter Button is clicked in the upload dashboard page");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on filter button from History page")
	public void user_clicks_filter_button_history_page() {
		try {
			hp.clickOnFilterButtonOnHistoryPage();
			logger.info("Step : Filter Button is clicked in the History page");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user removes the filter from the upload dashboard page")
	public void user_removes_the_filter_from_the_upload_dashboard_page() {
		try {
			fp.clickCrossIcon();
			logger.info("Step : X Icon is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user removes the filter from the history page")
	public void user_removes_the_filter_from_the_history_page() {
		try {
			fp.clickCrossIcon();
			logger.info("Step : X Icon is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("clicks on quick filter")
	public void clicks_on_quick_filter() {
		try {
			fp.clickcheckBox();
			logger.info("Step : 24 Hours quick filter is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on hrs quick filter")
	public void user_clicks_on_hrs_quick_filter() {

		try {
			hp.removeTextInSearchBox();
			hp.clickOnSearchButtonOnHistoryPage();
			hp.select24HrsCheckboxFilter();
			logger.info("Step : 24 Hours quick filter is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on Show more button")
	public void user_clicks_on_Show_more_button() {
		try {
			fp.clickShowmore();
			logger.info("Step : Show more button is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

//	@When("user click on Processing quick filer")
//	public void user_click_on_processing_quick_filer() {
//		try {
//			fp.clickcheckBox();
//			Thread.sleep(2000);
//			fp.clickProcessingcheckBox();
//			logger.info("Step : Processing quick filter is clicked");
//			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}

	@When("user clicks on History from left panel")
	public void user_click_on_History_button() {
		try {
			hp.clickOnHistory();
			Thread.sleep(2000);
			logger.info("Step : History button is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("selects any surgeon for filtering from upload dashboard page")
	public void user_clicks_surgeon_for_filtering() {
		try {
			fp.selectFilterAsSurgeonName();
			logger.info("Step : Surgeon is selected from filter in the upload dashboard page");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("selects any patient for filtering from History page")
	public void user_clicks_patient_for_filtering_History_page() {
		try {
			fp.selectFilterAspatientName();
			logger.info("Step : Patient is selected from filter in the History page");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user selects one record from the list")
	public void user_selects_one_record_from_the_list() {
		try {
			hp.clickRecord();
			logger.info("Step : One record is clicked from history screen");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("clicks on View Details")
	public void clicks_on_view_details() {
		try {	
			hp.clickViewDetails();
			logger.info("Step : View Details Button is clicked from history screen");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Record entry page is displayed to the user")
	public void record_entry_page_is_displayed_to_the_user() {
		try {
			hp.recordEntryPage();
			logger.info("Step : Record entry page is displayed to the user");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}