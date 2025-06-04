package stepDefinitions;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SummaryDashboard_SSR1830_FilterBySiteSteps {
	

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR1830_FilterBySiteSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SelectedActivityPage sAP = new SelectedActivityPage();
	FileDashboardPage fdP = new FileDashboardPage();

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

	
	@When("Clicks on Site option")
	public void clicks_on_site_option() {
		try {
			fdP = new FileDashboardPage();
			fdP.clickSiteIcon();
			logger.info("Step: Site Icon is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("Selects any site for filtering")
	public void selects_any_site_for_filtering() {
		try {
			fdP = new FileDashboardPage();
			fdP.SelectSite();
			logger.info("Step: Site is selected");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("click on Done button")
	public void click_on_done_button() {
		try {
			fdP = new FileDashboardPage();
			fdP.clickDoneBtn();
			logger.info("Step: Done Button is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("Upload dashboard page should display results with filtered data as per site selection")
	public void upload_dashboard_page_should_display_results_with_filtered_data_as_per_site_selection() {
		try {
			fdP = new FileDashboardPage();
			fdP.isFilterTextACMHDisplayed();
			logger.info("Step: Upload dashboard page displays results with filtered data as per the Site selected");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("user removes the selected site from upload dashboard page")
	public void user_removes_the_selected_site_from_upload_dashboard_page() {
		try {
			fdP = new FileDashboardPage();
			fdP.clickCrossIcon();
			logger.info("Step : X Icon is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("Clicks on Surgeon option")
	public void clicks_on_surgeon_option() {
		try {
			fdP = new FileDashboardPage();
			
			fdP.clickSurgeonIcon();
			logger.info("Step : Surgeon plus icon is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("Selects any surgeon for filtering")
	public void selects_any_surgeon_for_filtering() {
		try {
			fdP = new FileDashboardPage();
			fdP.SelectSurgeon();
			logger.info("Step : Surgeon is selected");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("Upload dashboard page should display results with filtered data as per surgeon selection")
	public void upload_dashboard_page_should_display_results_with_filtered_data_as_per_surgeon_selection() {
		try {
			fdP = new FileDashboardPage();
			fdP.isFilteredSurgeonNameListDisplayed();
			logger.info("Step : Upload dashboard page displays results with filtered data as per the surgeon name");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
