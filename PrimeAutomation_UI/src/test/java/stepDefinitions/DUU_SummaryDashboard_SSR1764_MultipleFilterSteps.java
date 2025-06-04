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
import pages.LoginPage;
import pages.MultipleFilterPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SummaryDashboard_SSR1764_MultipleFilterSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR1764_MultipleFilterSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	MultipleFilterPage mfPage = new MultipleFilterPage();

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
	@When("the user selects date filter on summary dashboard")
	public void the_user_selects_date_filter_on_summary_dashboard() {
		try {
			mfPage.selectsDateFilterOnDashboard();
			logger.info("Step: User selected date filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects surgeon filter on summary dashboard")
	public void the_user_selects_surgeon_filter_on_summary_dashboard() {
		try {
			mfPage.selectsSurgeonFilterOnDashboard();
			logger.info("Step: User selected surgeon filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects site filter on summary dashboard")
	public void the_user_selects_site_filter_on_summary_dashboard() {
		try {
			mfPage.selectsSiteFilterOnDashboard();
			logger.info("Step: User selected site filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on Done button")
	public void the_user_clicks_on_Done_button() {
		try {
			mfPage.clicksOnDoneButton();
			logger.info("Step: Done button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects application filter on summary dashboard")
	public void the_user_selects_application_filter_on_summary_dashboard() {
		try {
			mfPage.selectsApplicationFilterOnDashboard();
			logger.info("Step: User selected application filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user removes the filter")
	public void the_user_removes_the_filter() {
		try {
			mfPage.removeFilters();
			logger.info("Step: Filters are removed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects uploader filter on history page")
	public void the_user_selects_uploader_filter_on_history_page() {
		try {
			mfPage.selectsUploaderFilterOnHistory();
			logger.info("Step: User selected uploader filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects patient filter on history page")
	public void the_user_selects_patient_filter_on_history_page() {
		try {
			mfPage.selectsPatientFilterOnHistory();
			logger.info("Step: User selected patient filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects surgeon filter on history page")
	public void the_user_selects_surgeon_filter_on_history_page() {
		try {
			mfPage.selectsSurgeonFilterOnDashboard();
			logger.info("Step: User selected surgeon filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects site filter on history page")
	public void the_user_selects_site_filter_on_history_page() {
		try {
			mfPage.selectsSiteFilterOnDashboard();
			logger.info("Step: User selected site filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects date filter on audit log")
	public void the_user_selects_date_filter_on_audit_log() {
		try {
			mfPage.selectsDateFilterOnDashboard();
			logger.info("Step: User selected date filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects username filter on audit log")
	public void the_user_selects_username_filter_on_audit_log() {
		try {
			mfPage.selectsUsernameFilterOnDashboard();
			logger.info("Step: User selected username filter");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on audit log filter button")
	public void the_user_clicks_on_audit_log_filter_button() {
		try {
			mfPage.clickOnFilterButton();
			logger.info("Step: Filter button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	// *********************THEN BLOCK*******************************
		@Then("the summary dashboard shall display multiple filtered list")
		public void the_summary_dashboard_shall_display_multiple_filtered_list() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(mfPage.isMultiFilterListDisplayed());
				logger.info("Step: Summary dashboard displayed multiple filter list");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the history page shall display multiple filtered list")
		public void the_history_page_shall_display_multiple_filtered_list() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(mfPage.isMultiFilterListDisplayedOnHistory());
				logger.info("Step: History page displayed multiple filter list");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("history shall display all items without filter")
		public void history_shall_display_all_items_without_filter() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(mfPage.isAllItemsDisplayedOnHisotry());
				logger.info("Step: History page displayed all list without any filter");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the audit log shall display multiple filtered list")
		public void the_audit_log_shall_display_multiple_filtered_list() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(mfPage.isMultiFilterListDisplayedOnHistory());
				logger.info("Step: Audit log displayed multiple filter list");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("audit log shall display all items without filter")
		public void audit_log_shall_display_all_items_without_filter() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(mfPage.isAllItemsDisplayedOnHisotry());
				logger.info("Step: Audit log page displayed all list without any filter");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("summary dashboard shall display all items without filter")
		public void summary_dashboard_shall_display_all_items_without_filter() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(mfPage.isAllItemsDisplayedOnDashboard());
				logger.info("Step: Summary Dashboard displayed all list without any filter");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
}
