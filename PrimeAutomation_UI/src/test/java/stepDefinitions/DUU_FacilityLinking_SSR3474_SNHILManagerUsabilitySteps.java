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
import pages.ImagingLinksPage;
import pages.LoginPage;
import pages.SettingsPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_FacilityLinking_SSR3474_SNHILManagerUsabilitySteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR3474_SNHILManagerUsabilitySteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	ImagingLinksPage ilPage = new ImagingLinksPage();
	
	
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
	
	@Then("The user selects Canton Health Center in the left table")
	public void user_selects_Canton_Health_Center_in_left_table() {
		try {
			ilPage.selectCantonHealthCenterInLeftTable();
			logger.info("User selected canton health center");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not find canton health center");
			exception = e;
    	}
	}
	
	@Then("The user clicks the activate site button under the left table")
	public void user_clicks_activate_site_button_under_left_table() {
		try {
			ilPage.clickActivateSite();
			logger.info("User clicked activate site button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click activate site button");
			exception = e;
    	}
	}
	
	@Then("The user clicks the deactivate site button under the left table")
	public void user_clicks_deactivate_site_button_under_left_table() {
		try {
			ilPage.clickDeactivateSite();
			logger.info("User clicked deactivate site button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click deactivate site button");
			exception = e;
    	}
	}
	
	@Then("Check pin linked button for hospital admin")
	public void check_pin_linked_button_for_hadmin() {
		try {
			Assert.assertTrue(ilPage.checkPinLinkedHadmin());
			logger.info("Pin Linked button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			LoginPage.driver.switchTo().defaultContent();
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find pin linked button");
			exception = e;
    	}
	}
	
	@Then("Navigate to upload files page")
	public void navigate_to_upload_files_page() {
		try {
			LoginPage.driver.switchTo().defaultContent();
			ilPage.navigateToUploadFilesPage();
			logger.info("Navigated to upload files page");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to navigate to upload files page");
			exception = e;
    	}
	}
	
	@Then("The user clicks create link button under right table")
	public void create_link_under_right_table() {
		try {
			ilPage.clickCreateLinkButtonUnderRightTable();
			logger.info("User created link");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to create link");
			exception = e;
    	}
	}
	
	@Then("The user clicks remove link button under right table")
	public void remove_link_under_right_table() {
		try {
			Thread.sleep(4000);
			ilPage.clickRemoveLinkButtonUnderRightTable();
			logger.info("User removed link");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to remove link");
			exception = e;
    	}
	}
	
	@Then("Hadmin Unlink Selected Facility")
	public void hadmin_unlink_facility() {
		try {
			ilPage.clickRemoveLinkButtonHadmin();
			logger.info("Hadmin has unlinked selected facility");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to remove link");
			exception = e;
    	}
	}
	
	@Then("Hadmin Link Selected Facility")
	public void hadmin_link_facility() {
		try {
			ilPage.clickCreateLinkButtonHadmin();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			logger.info("Hadmin has linked selected facility");
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to link");
			exception = e;
    	}
	}
	
	@Then("SNHIL Manager click pin linked button")
	public void snhil_click_pin_linked_button() {
		try {
			ilPage.clickPinLinkedButton();
			logger.info("User clicked pin linked button in top right");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click pin linked button");
			exception = e;
    	}
	}
	
	@Then("User clicks remove link button in ic admin")
	public void user_clicks_remove_link_button_ic_admin() {
		try {
			ilPage.clickRemoveLinkButton();
			logger.info("IC Admin user clicked remove link button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click remove link button");
			exception = e;
    	}
	}
}