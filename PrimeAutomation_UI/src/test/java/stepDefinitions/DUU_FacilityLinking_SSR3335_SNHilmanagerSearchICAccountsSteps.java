package stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ImagingLinksPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_FacilityLinking_SSR3335_SNHilmanagerSearchICAccountsSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR3335_SNHilmanagerSearchICAccountsSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	ImagingLinksPage ilPage = new ImagingLinksPage();
	public String rightTableName = "right";
	public String leftTableName = "left";

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
	@When("enter keyword from the IC {string} in {string} in the left search bar and click on search button")
	public void enter_keyword_from_the_ic_in_in_the_left_search_bar_and_click_on_search_button(String string, String string2) throws IOException, InterruptedException {
		try {
			String ssname = "enter keyword from the IC "+string+" in "+string2+" in the left search bar and click search button";
			logger.info("Step: " + ssname);
			//		ilPage.getLeftTableDetails();
			//		ilPage.enterTextInLeftSerachBar(string, string2);
			ilPage.getTableDetails(leftTableName);
			ilPage.enterTextInSearchBar(leftTableName,string, string2);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the imaging centers with similar {string} as the searched keyword is displayed under All organizations table")
	public void the_imaging_centers_with_similar_as_the_searched_keyword_is_displayed_under_all_organizations_table(String string) throws IOException, InterruptedException {
		try {
			String ssname = "IC with similar "+string+" is displayed under All organizations table";
			logger.info("Step: " + ssname);
			//		Assert.assertTrue(ilPage.isLeftSearchWorking());
			Assert.assertTrue(ilPage.isSearchWorking(leftTableName));
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clears the search bar in All organizations")
	public void the_user_clears_the_search_bar_in_all_organizations() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user clears the search bar in All organizations");
			//	   ilPage.clearLEftSearchbar();
			ilPage.clearSearchbar(leftTableName);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user types imaging center {string} in the left search bar and click on search button")
	public void the_user_types_imaging_center_in_the_left_search_bar_and_click_on_search_button(String string) throws IOException, InterruptedException {
		try {
			String ssname = "the user types IC "+string+" in the left search bar and click search button";
			logger.info("Step: " + ssname);
			//		ilPage.enterTextInLeftSerachBar(string, "upper case and lower case");
			ilPage.enterTextInSearchBar(leftTableName,string, "upper case and lower case");
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("enter keyword from the IC {string} in {string} in the right search bar and click on search button")
	public void enter_keyword_from_the_ic_in_in_the_right_search_bar_and_click_on_search_button(String string, String string2) throws IOException, InterruptedException {
		try {
			String ssname = "enter keyword from the IC "+string+" in "+string2+" in the right search bar and click on search button";
			logger.info("Step: " + ssname);
			ilPage.getTableDetails(leftTableName);
			ilPage.enterTextInSearchBar(rightTableName,string, string2);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the imaging centers with similar {string} as the searched keyword is displayed under Available Imaging Facilities table")
	public void the_imaging_centers_with_similar_as_the_searched_keyword_is_displayed_under_available_imaging_facilities_table(String string) throws IOException, InterruptedException {
		try {
			String ssname = "ic with similar "+string+" is displayed under Available Imaging Facilities table";
			logger.info("Step: " + ssname);
			Assert.assertTrue(ilPage.isSearchWorking(rightTableName));
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clears the search bar in Available Imaging Facilities")
	public void the_user_clears_the_search_bar_in_available_imaging_facilities() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user clears the search bar in Available Imaging Facilities");
			ilPage.clearSearchbar(rightTableName);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user types imaging center {string} in the right search bar and click on search button")
	public void the_user_types_imaging_center_in_the_right_search_bar_and_click_on_search_button(String string) throws IOException, InterruptedException {
		try {
			String ssname = "the user types imaging center "+string+" in the right search bar and click on search button";
			logger.info("Step: " + ssname);
			ilPage.enterTextInSearchBar(rightTableName,string, "upper case and lower case");
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
