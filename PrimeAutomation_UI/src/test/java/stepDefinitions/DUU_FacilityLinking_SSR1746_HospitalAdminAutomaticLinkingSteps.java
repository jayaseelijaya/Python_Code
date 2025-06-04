package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import pages.FacilityListPage;
import pages.ImagingLinksPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.SurgeonListPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_FacilityLinking_SSR1746_HospitalAdminAutomaticLinkingSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR1746_HospitalAdminAutomaticLinkingSteps.class);
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
	//public static WebDriver driver;
	
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
	// *********************THEN BLOCK*******************************
	
	@Then("the right side header shall be displayed as Create or Modify Links")
	public void the_right_side_header_shall_be_displayed_as_Create_or_Modify_Links() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(saPage.isImagingLinksHeaderDisplayed());
			logger.info("Step: Imaging links header is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the following elements shall be displayed at left section of imaging link screen")
	public void the_following_elements_shall_be_displayed_at_left_section_of_imaging_link_screen(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("elements").contains("all organizations")) {
					Assert.assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("all organizations").isDisplayed(),
							"All organizations title is not displayed.");
					logger.info("All organizations title is displayed.");
				}
				if (list.get(i).get("elements").contains("search tab")) {
					assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("search tab").isDisplayed(),
							"search tab is not displayed.");
					logger.info("search tab is displayed.");
				}
				if (list.get(i).get("elements").contains("search button")) {
					assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("search button").isDisplayed(),
							"search button is not displayed.");
					logger.info("search button is displayed.");
				}
				if (list.get(i).get("elements").contains("name of facilities")) {
					Assert.assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("name of facilities").isDisplayed(),
							"name of facilities column is displayed.");
					logger.info("name of facilities column is displayed.");
				}
				if (list.get(i).get("elements").contains("facilities type")) {
					assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("facilities type").isDisplayed(),
							"facilities type column is not displayed.");
					logger.info("facilities type column is displayed.");
				}
				if (list.get(i).get("elements").contains("citystate")) {
					assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("citystate").isDisplayed(),
							"citystate column is not displayed.");
					logger.info("citystate column is displayed.");
				}
				if (list.get(i).get("elements").contains("status")) {
					Assert.assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("status").isDisplayed(),
							"status column is displayed.");
					logger.info("status column is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The imaging link screen elements are not displayed");
			exception = e;
		}
	}
	
	@Then("Search for hospital")
	public void search_for_hospital() {
		try {
			logger.info("Hospital entered into search bar");
			fp.searchForHospital();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to search for hopsital");
			exception = e;
		}
	}
	
	@Then("User clicks create link button")
	public void user_clicks_create_link_button() {
		try {
			logger.info("User creates link");
			ilPage.clickCreateLinkButton();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to create link");
			exception = e;
		}
	}
}
