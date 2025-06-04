package stepDefinitions;

import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FacilityListPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImgaeUpload_SSR1801_OrganizationSearchSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImgaeUpload_SSR1801_OrganizationSearchSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
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

	// *********************WHEN BLOCK*******************************
	@When("the user enters partial site name in upper case in searchbox")
	public void the_user_enters_partial_site_name_in_upper_case_in_searchbox() {
		try {
			fp.enterTextInSearchBox().sendKeys("ABCH");
			logger.info("Step: the user entered partial site name in upper case as ABCH");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user enters valid site name in upper and lower case in search box")
	public void the_user_enters_valid_site_name_in_upper_and_lower_case_in_search_box() {
		try {
			fp.enterTextInSearchBox().sendKeys("BAYSTATE wing");
			logger.info("Step: the user entered valid site name in upper and lower case as BAYSTATE wing");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user enters site name in lower case in searchbox")
	public void the_user_enters_site_name_in_lower_case_in_searchbox() {
		try {
			fp.enterTextInSearchBox().sendKeys("abch");
			logger.info("Step: the user enteredsite lower case as abch");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user hover the cursor on one of site name from the list")
	public void the_user_hover_the_cursor_on_one_of_site_name_from_the_list() {
		try {
			fp.hoverOverSiteName();
			logger.info("Step: the user hover the coursor on one of site name from the list");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clears the search box")
	public void the_user_clears_the_search_box() {
		try {
			fp.clearSearchBox();
			logger.info("Step: the user cleared out searchbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	// *********************THEN BLOCK*******************************
	
	@Then("the list shall display searched uppercase site name")
	public void the_list_shall_display_searched_uppercase_site_name() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			String searchbox = utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath").getAttribute("value");
			Assert.assertTrue(fp.isListDisplayedSearchedSiteName());
			logger.info("Step: List is displayed searched uppercase site name as " +searchbox);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the list shall display searched upper and lower case site name")
	public void the_list_shall_display_searched_upper_and_lower_case_site_name() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			String searchbox = utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath").getAttribute("value");
			Assert.assertTrue(fp.isListDisplayedSearchedSiteName());
			logger.info("Step: List is displayed searched uppercase and lower case site name as " +searchbox);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the list shall display searched lower case site name")
	public void the_list_shall_display_searched_lower_case_site_name() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			String searchbox = utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath").getAttribute("value");
			Assert.assertTrue(fp.isListDisplayedSearchedSiteName());
			logger.info("Step: List is displayed searched lower case site name as " +searchbox);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the site name shall be displayed in green colour")
	public void the_site_name_shall_be_displayed_in_green_colour() {
		try {
			Properties properties = reader.getProperty();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(fp.isSiteNameDisplayedInGreenColour(),properties.getProperty("facility.sitename"));
			logger.info("Step: Site name is displayed in green colour");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	
}
