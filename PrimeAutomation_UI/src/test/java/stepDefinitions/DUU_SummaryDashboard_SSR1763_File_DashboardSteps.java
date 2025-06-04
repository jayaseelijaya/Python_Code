
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

public class DUU_SummaryDashboard_SSR1763_File_DashboardSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR1763_File_DashboardSteps.class);
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
	@When("the user enters Lisa text as surgeon name in search box")
	public void the_user_enters_Lisa_text_as_surgeon_name_in_search_box() {
		try {
			daPage.enterTextInSearchBox().sendKeys("Lisa");
			logger.info("Step: Text in search box entered as Lisa");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on search button")
	public void the_user_clicks_on_search_button() {
		try {
			daPage.clickOnSearchButton();
			logger.info("Step: the search button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on filter button")
	public void the_user_clicks_on_filter_button() {
		try {
			daPage.clickOnFilterButton();
			logger.info("Step: the filter button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selcts filter as surgeon name")
	public void the_user_selcts_filter_as_surgeon_name() {
		try {
			daPage.selectFilterAsSurgeonName();
			logger.info("Step: the filter as surgeon name is selected");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user enters Patrick text as patient name in search box")
	public void the_user_enters_patrick_text_as_patient_name_in_search_box() {
		try {
			daPage.enterTextInSearchBar();
			logger.info("Step: Text in search bar is entered as Patrick");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects filter as patient name")
	public void the_user_selects_filter_as_patient_name() {
		try {
			daPage.selectFilterAspatientName();
			logger.info("Step: the filter as patient name is selected");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on Search Button")
	public void the_user_clicks_on_Search_Button() {
		try {
			daPage.clickOnSearchBtn();
			logger.info("Step: the search btn is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on Filter Button")
	public void the_user_clicks_on_Filter_Button() {
		try {
			daPage.clickOnFilterBtn();
			logger.info("Step: the Filter Button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user enters ic-test-admin@capgemini.com email as user name in search box")
	public void the_user_enters_ic_test_admin_capgemini_com_email_as_user_name_in_search_box() {
		try {
			daPage.enterTextInAuditLogSearchBar();
			logger.info("Step: User name email in search bar is entered as ic-test-admin@capgemini.com");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selcts filter as user name")
	public void the_user_selcts_filter_as_user_name() {
		try {
			daPage.selectFilterAsUserName();
			logger.info("Step: the filter as user name is selected");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on Filter button")
	public void the_user_clicks_on_Filter_button() {
		try {
			daPage.clickOnFilterBtnOnAuditLog();
			logger.info("Step: the Filter button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on Search button")
	public void the_user_clicks_on_Search_button() {
		try {
			daPage.clickOnSearchButtonOnAuditLog();
			logger.info("Step: the Search button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	// *********************THEN BLOCK*******************************
	@Then("the dashboard summary shall display list of upload items")
	public void the_dashboard_summary_shall_display_list_of_upload_items() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isDashboardListDisplayed());
			logger.info("Step: Summary dashboard is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the matching Lisa text surgeon name list shall be displayed")
	public void the_matching_Lisa_text_surgeon_name_list_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isSearchTextLisaDisplayed());
			logger.info("Step: The search list displayed matching surgeon name text as Lisa");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the list shall be filtered as selected surgeon name")
	public void the_list_shall_be_filtered_as_selected_surgeon_name() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isFilteredCrnpSurgeonNameListDisplayed());
			logger.info("Step: The filtered list displayed matching surgeon name text as CRNP");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the history tab shall be displayed")
	public void the_history_tab_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(daPage.isHistoryTabDisplayed(), "History");
			logger.info("Step: The History tab button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the matching Patrick text patient name list shall be displayed")
	public void the_matching_patrick_text_patient_name_list_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isSearchTextPatrickDisplayed());
			logger.info("Step: The search list displayed matching patient name text as Patrick");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the list shall be filtered as selected patient name")
	public void the_list_shall_be_filtered_as_selected_patient_name() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isFilteredPatrickPatientNameListDisplayed());
			logger.info("Step: The filtered list displayed matching patient name text as Patrick");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the audit log tab shall be displayed")
	public void the_audit_log_tab_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(daPage.isAuditLogTabDisplayed(), "Audit Log");
			logger.info("Step: The Audit Log tab button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the matching ic-test-admin@capgemini.com email user name list shall be displayed")
	public void the_matching_h_test_admin_capgemini_com_email_user_name_list_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isSearchedUserNameDisplayed());
			logger.info("Step: The search list displayed matching user name text as ic-test-admin@capgemini.com");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the list shall be filtered as selected user name")
	public void the_list_shall_be_filtered_as_selected_user_name() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(daPage.isFilteredUserNameListDisplayed());
			logger.info("Step: The filtered list displayed matching user name text as ic-test-admin@capgemini.com");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
