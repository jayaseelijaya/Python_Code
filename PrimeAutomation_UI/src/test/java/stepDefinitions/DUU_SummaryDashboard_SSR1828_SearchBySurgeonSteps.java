package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FacilityListPage;
import pages.FileDashboardPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SummaryDashboard_SSR1828_SearchBySurgeonSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR1828_SearchBySurgeonSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FileDashboardPage dPage = new FileDashboardPage();
	FacilityListPage fp = new FacilityListPage();

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

	@Then("the matching Lisa text as surgeon name list shall be displayed to the user")
	public void the_matching_lisa_text_as_surgeon_name_list_shall_be_displayed_to_the_user() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(dPage.isSearchTextLisaDisplayed());
			logger.info("Step: The search list displayed matching surgeon name text as Lisa");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters xyz text as surgeon name in search box")
	public void the_user_enters_xyz_text_as_surgeon_name_in_search_box() {
		try {
			dPage.enterTextInSearchBox().sendKeys("xyz");
			logger.info("Step: Text in search box entered as xyz");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("notification message should be displayed on dashboard screen")
	public void notification_message_should_be_displayed_on_dashboard_screen() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			String msg = dPage.msgNodata();
			logger.info("Notification message is displayed as : " + msg);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("Enter the {string} in Search bar and click on Search button")
	public void enter_the_in_search_bar_and_click_on_search_button(String string) throws IOException, InterruptedException {
		try {
			String ssname = "Enter the "+string+" in Search bar and click on Search button";
			logger.info("Step : " + ssname);
			dPage.searchValidData(string);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the image upload record details are filtered with searched {string}")
	public void the_image_upload_record_details_are_filtered_with_searched(String string) throws IOException, InterruptedException {
	    try {
	    	String ssname = "the image upload record details are filtered with searched " +string;
			logger.info("Step : " + ssname);
			if(string.equalsIgnoreCase("site name")) {
		    	Assert.assertTrue(dPage.isSiteFilterApplied());
		    }
		    else {
		    	Assert.assertTrue(dPage.isSearchWorking());
		    }
			Thread.sleep(500);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clears the search bar")
	public void the_user_clears_the_search_bar() throws IOException, InterruptedException {
		try {
			logger.info("Step : the user clears the search bar");
			dPage.clearSearchbar();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("Enter invalid {string} in Search bar and click on Search button")
	public void enter_invalid_in_search_bar_and_click_on_search_button(String string) throws IOException, InterruptedException {
		try {
			String ssname = "Enter invalid "+string+" in Search bar and click on Search button";
			logger.info("Step : " + ssname);
			dPage.searchInvalidData(string);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("{string} message is displayed")
	public void message_is_displayed(String string) throws IOException {
		try {
			String ssname = string +" message is displayed";
			logger.info("Step : " + ssname);
			Assert.assertTrue(dPage.isNoDataTextDisplayed());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user selects the site that IC admin belongs to")
	public void user_selects_the_site_that_IC_admin_belongs_to() {
		try {
			fp.selectICAdminSiteFromChooseSite();
			logger.info("Step : user selects the site that IC admin belongs to");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
