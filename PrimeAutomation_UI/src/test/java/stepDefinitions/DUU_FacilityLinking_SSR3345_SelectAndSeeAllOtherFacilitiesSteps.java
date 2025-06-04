package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import pages.ImagingLinksPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_FacilityLinking_SSR3345_SelectAndSeeAllOtherFacilitiesSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR3345_SelectAndSeeAllOtherFacilitiesSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
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

	@Then("All Organizations and Available Imaging Facilities or Available Providers tables with a Search button are displayed")
	public void all_organizations_and_available_imaging_facilities_or_available_providers_tables_with_a_search_button_are_displayed() {
		try {
			logger.info("Step: All Organizations and Available Imaging Facilities or Available Providers tables with a Search button are displayed");
			Assert.assertTrue(ilPage.isLeftTableContentsDisplayed());
			Assert.assertTrue(ilPage.isRightTableContentsDisplayed());
			Assert.assertTrue(ilPage.isRighttableSearchBtnDisplayed());
			Assert.assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("search button").isDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("list of facilities are displayed under All Organizations table")
	public void list_of_facilities_are_displayed_under_all_organizations_table() throws IOException, InterruptedException {
		try {
			logger.info("Step: list of facilities are displayed under All Organizations table");
			Assert.assertTrue(ilPage.isListOfFacilitiesInRightTableDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("Linked facilities with link icon and Unlinked facilities with stroked link icon are displayed")
	public void linked_facilities_with_link_icon_and_unlinked_facilities_with_stroked_link_icon_are_displayed() throws IOException {
		try {
			logger.info("Step: Linked facilities with link icon and Unlinked facilities with stroked link icon are displayed");
			Assert.assertTrue(ilPage.rightTableContentsLinkIconDisplayed());
			Assert.assertTrue(ilPage.rightTableContentsUnlinkIconDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
