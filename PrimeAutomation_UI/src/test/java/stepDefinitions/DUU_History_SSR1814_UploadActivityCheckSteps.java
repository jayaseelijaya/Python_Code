package stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.HelpInfoPage;
import pages.HistoryViewScreenPage;
import pages.LoginPage;
import pages.SettingsPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_History_SSR1814_UploadActivityCheckSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_History_SSR1814_UploadActivityCheckSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	HistoryViewScreenPage hvsPage = new HistoryViewScreenPage();
	FileDashboardPage fdpPage = new FileDashboardPage();

	int initialDashboardEntries;
	int firstFilterDashboardEntries;

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

	@Then("the uploaded entry is shown on the upload dashboard")
	public void check_upload_entry_on_dashboard() {
		try {
			hvsPage.getDateOfFirstEntryOnDashboard();
			logger.info("Upload date of most recent entry in dashboard shown above");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find first upload on dashboard");
			exception = e;
    	}
	}

	@Then("the uploaded entry is shown in the history page table")
	public void check_upload_entry_on_history_page() {
		try {
			hvsPage.getDateOfFirstEntryOnHistoryPage();
			logger.info("Upload date of most recent entry in history page shown above");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find first upload on history page");
			exception = e;
    	}
	}

	@Then("the uploaded entry is not shown on the upload dashboard")
	public void check_upload_entry_not_on_dashboard() {
		try {
			hvsPage.getDateOfFirstEntryOnDashboard();
			logger.info("Upload date of most recent entry in dashboard shown above");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find upload on dashboard");
			exception = e;
    	}
	}

	@Then("the uploaded entry is not shown in the history page table")
	public void check_upload_entry_not_on_history_page() {
		try {
			hvsPage.getDateOfFirstEntryOnHistoryPage();
			logger.info("Upload date of most recent entry in history page shown above");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find upload on history page");
			exception = e;
    	}
	}
}