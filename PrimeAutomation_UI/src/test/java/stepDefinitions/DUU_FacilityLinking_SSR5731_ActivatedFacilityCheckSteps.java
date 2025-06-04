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

public class DUU_FacilityLinking_SSR5731_ActivatedFacilityCheckSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR5731_ActivatedFacilityCheckSteps.class);
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
	
	@Then("user clicks imaging links menu bar button")
	public void user_clicks_imaging_links_menu_button() {
		try {
			ilPage.clickImagingLinksPageButton();
			logger.info("User clicked imaging links button in left menu bar");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not click imaging links button");
			exception = e;
    	}
	}
	
	@Then("User unlinks all facilities for canton health center")
	public void unlink_all_facilities_to_canton_health_center() {
		try {
			ilPage.unlinkAllFacilities();
			logger.info("User unlinked all facilities to canton health center");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to unlink all facilities");
			exception = e;
    	}
	}
	
	@Then("There should be no site in the upload sequence")
	public void check_for_site_in_upload_sequence() {
		try {
			Assert.assertTrue(ilPage.noSiteShownInUpload());
			logger.info("No site found");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Site found, unlinking not functional");
			exception = e;
    	}
	}
	
	@Then("There should be a site shown in the upload sequence")
	public void check_for_a_site_in_upload_sequence() {
		try {
			Assert.assertTrue(ilPage.siteShownInUpload());
			logger.info("Site found");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("No site found");
			exception = e;
    	}
	}
	
	@Then("User links one facilities for canton health center")
	public void user_links_one_facility() {
		try {
			ilPage.linkSiteToCanton();
			logger.info("Site linked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to link site");
			exception = e;
    	}
	}
	
	@Then("all elements are displayed in the left section of the imaging links page")
	public void check_left_side_of_imaging_links_page() {
		try {
			Assert.assertTrue(ilPage.checkAllOrganizationHeader());
			Assert.assertTrue(ilPage.checkLeftTable());
			logger.info("All elements in the left side table are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Not all elements found on left site of imaging links page");
			exception = e;
    	}
	}
	
	@Then("The user clicks on canton health center in the left table")
	public void user_clicks_canton_health_center_in_left_table() {
		try {
			ilPage.clickCantonHealthCenterInLeftTable();
			logger.info("User clicked canton health center in table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click canton health center entry");
			exception = e;
    	}
	}
	
	@Then("the user verifies details under left table")
	public void user_verifies_details_under_left_table() {
		try {
			Assert.assertTrue(ilPage.checkLeftTableInfoFacilityName());
			Assert.assertTrue(ilPage.checkLeftTableInfoAddress());
			Assert.assertTrue(ilPage.checkLeftTableInfoSurgeon());
			Assert.assertTrue(ilPage.checkLeftTableInfoEmail());
			Assert.assertTrue(ilPage.checkLeftTableInfoPhone());
			logger.info("All elements under left side table are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Not all elements under left side table are displayed");
			exception = e;
    	}
	}
	
	@Then("the user checks activate link button")
	public void user_checks_if_activate_link_button_displayed() {
		try {
			Assert.assertTrue(ilPage.checkActivateSiteButton());
			logger.info("Activate Link button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Activate link button is not displayed");
			exception = e;
    	}
	}
	
	@Then("the user check deactivate link button")
	public void user_checks_if_deactivate_link_button_displayed() {
		try {
			Assert.assertTrue(ilPage.checkDeactivateSiteButton());
			logger.info("Deactivate Link button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Deactivate link button is not displayed");
			exception = e;
    	}
	}
	
	@Then("the user verifies details under right table")
	public void user_verifies_details_under_right_table() {
		try {
			Assert.assertTrue(ilPage.checkRightTableInfoFacilityName());
			Assert.assertTrue(ilPage.checkRightTableInfoAddress());
			Assert.assertTrue(ilPage.checkRightTableInfoSurgeon());
			Assert.assertTrue(ilPage.checkRightTableInfoEmail());
			Assert.assertTrue(ilPage.checkRightTableInfoPhone());
			logger.info("All elements under right side table are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Not all elements under right side table are displayed");
			exception = e;
    	}
	}
}