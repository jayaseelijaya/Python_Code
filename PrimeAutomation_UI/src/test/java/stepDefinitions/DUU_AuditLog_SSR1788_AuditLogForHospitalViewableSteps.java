package stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuditLogPage;
import pages.FileDashboardPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_AuditLog_SSR1788_AuditLogForHospitalViewableSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_AuditLog_SSR1782_FilterableByStartAndEndDateSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	AuditLogPage alPage = new AuditLogPage();
	SelectedActivityPage saPage = new SelectedActivityPage();
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
	
	
	@Then("the data should download and match excel {string}")
	public void the_data_should_download_and_match_excel(String string) throws IOException {
		try {
			String screenshotName = "the data should download and match excel "+string;
			logger.info("Step: "+ screenshotName);
			 Assert.assertTrue(alPage.checkAllDataInExportAllExcelSheet(string));
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	  
	}
	@Then("the h-admin should not see records of Imaging center from {string}")
	public void the_h_admin_should_not_see_records_of_imaging_center_from(String string) throws IOException, InterruptedException {
		try {
			String screenshotName = "the h-admin should not see records of Imaging center from "+string;
			logger.info("Step: "+ screenshotName);
			Assert.assertTrue(alPage.hospitalAccountsRecordsDisplayed());
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	
	@When("the user unselects the {string} filter")
	public void the_user_unselects_the_filter(String string) throws IOException {
		try {
			String screenshotName = "the user unselects the "+string+" filter";
			logger.info("Step: "+screenshotName);
			alPage.unselectUsernameFilter();
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("the user selects {string} user name and click on done")
	public void the_user_selects_user_name_and_click_on_done(String string) throws IOException {
		try {
			String screenshotName = "the user selects "+string+" user name and click on done";
			logger.info("Step: "+screenshotName);
		    alPage.selectUsernameFilter(string);
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}
	@Then("the list should show the Audit logs for {string}")
	public void the_list_should_show_the_audit_logs_for(String string) throws IOException, InterruptedException {
		try {
			String screenshotName = "the list should show the Audit logs for "+string;
			logger.info("Step: "+screenshotName);
			Assert.assertTrue(alPage.checkUsernameFilterRecords(string));
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	   
	}
}
