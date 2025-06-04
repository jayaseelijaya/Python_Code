package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
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
import pages.FacilityListPage;
import pages.ImagingLinksPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.SurgeonListPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_FacilityLinking_SSR3342_DeactivateSiteSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR3342_DeactivateSiteSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SurgeonListPage sp = new SurgeonListPage();
	FacilityListPage fp = new FacilityListPage();
	UserInformationPage userPage = new UserInformationPage();
	SelectedActivityPage saPage = new SelectedActivityPage();
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

	@Then("Verify all organizations are displayed in the left table")
	public void check_organizations_in_left_table() {
		try {
			ilPage.checkLeftTableOrganizations();
			logger.info("All organizations are displayed in the left table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to verify organizations in left table");
			exception = e;
		}
	}

	@Then("User seelects an active facility from the left table")
	public void user_selects_active_facility_from_left_table() {
		try {
			ilPage.clickActiveFacilityInLeftTable();
			logger.info("User selected an active facility from the left table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to select active facility from left table");
			exception = e;
		}
	}

	@Then("Verify activate site button should be disabled")
	public void check_activate_site_button_under_left_table() {
		try {
			Assert.assertFalse(ilPage.checkActivateSiteButtonUnderLeftTable());
			logger.info("Activate site button is disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to verify activate site button");
			exception = e;
		}
	}

	@Then("Verify deactivate site button should be enabled")
	public void check_deactivate_site_button_under_left_table() {
		try {
			Assert.assertTrue(ilPage.checkDeactivateSiteButtonUnderLeftTable());
			logger.info("Deactivate site button is enabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to verify deactivate site button");
			exception = e;
		}
	}

	@Then("User clicks deactivate site button under left table")
	public void user_clicks_deactivate_site_button_under_left_table() {
		try {
			ilPage.clickDeactivateSiteButtonUnderLeftTable();
			logger.info("User clicked deactivate site button under left table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click deactivate site button");
			exception = e;
		}
	}

	@Then("Verify the site that was just deactivated, is inactive")
	public void check_deactivated_site_left_table() {
		try {
		Assert.assertFalse(ilPage.checkDeactivateSiteButtonUnderLeftTable());
		logger.info("Site has been deactivated");
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Site has not been deactivated");
			exception = e;
		}
	}
}
