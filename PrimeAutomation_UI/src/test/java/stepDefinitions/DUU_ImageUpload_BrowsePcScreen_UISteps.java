
package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
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
import pages.ApplicationCardsPage;
import pages.BrowsePcScreenPage;
import pages.FacilityListPage;
import pages.LoginPage;
import pages.SurgeonListPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_BrowsePcScreen_UISteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_BrowsePcScreen_UISteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	SurgeonListPage sp = new SurgeonListPage();
	FacilityListPage fp = new FacilityListPage();
	ApplicationCardsPage ap = new ApplicationCardsPage();
	BrowsePcScreenPage bpcsPage = new BrowsePcScreenPage();

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
	@When("the user selects a facility from the list")
	public void the_user_selects_a_facility_from_the_list() {
		try {
			fp.selectFacilityFromList();
			logger.info("Step: User selected a facility from the list");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects a surgeon from the list")
	public void the_user_selects_a_surgeon_from_the_list() {
		try {
			sp.selectSurgeonFromList();
			logger.info("Step: User selected a surgeon from the list");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selctes a application card from the list")
	public void the_user_selctes_a_application_card_from_the_list() {
		try {
			ap.selectApplicationFromList();
			logger.info("Step: User selected a application card from the list");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// *********************THEN BLOCK*******************************
	@Then("the surgeon selection screen shall be displayed")
	public void the_surgeon_selection_screen_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(sp.isSurgeonSelectionScreenDisplayed());
			logger.info("Step: Surgeon Selection Screen is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the application card selection screen shall be displayed")
	public void the_application_card_selection_screen_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(ap.isApplicationSelectionScreenDisplayed());
			logger.info("Step: Application Selection Screen is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the browse pc screen shall be displayed")
	public void the_browse_pc_screen_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(bpcsPage.isBrowsePCScreenDisplayed());
			logger.info("Step: Browse PC Screen is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the top center header Facility Surgeon Application shall be displayed")
	public void the_top_center_header_Facility_Surgeon_Application_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(bpcsPage.isTopCenterHeaderDisplayed());
			logger.info("Step: Facility, Surgeon and Application top center header is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the below components shall be displayed on browse pc screen")
	public void the_below_components_shall_be_displayed_on_browse_pc_screen(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				Properties properties = reader.getProperty();
				if (list.get(i).get("screen").contains("select files to upload or drop below")) {
					Assert.assertEquals(
							bpcsPage.isBrowsePcInfoDisplayed("select files to upload or drop below").getText(),
							properties.getProperty("browsepc.title"));
					logger.info("The select files to upload or drop below is displayed.");
				}
				if (list.get(i).get("screen").contains("Back button")) {
					assertTrue(bpcsPage.isBrowsePcInfoDisplayed("Back button").isDisplayed(),
							"The Back button is not displayed.");
					logger.info("The Back button is displayed.");
				}
				if (list.get(i).get("screen").contains("Browse PC button")) {
					assertTrue(bpcsPage.isBrowsePcInfoDisplayed("Browse PC button").isDisplayed(),
							"The Browse PC button is not displayed.");
					logger.info("The Browse PC button is displayed.");
				}
				if (list.get(i).get("screen").contains("Drag and Drop Here")) {
					Assert.assertEquals(bpcsPage.isBrowsePcInfoDisplayed("Drag and Drop Here").getText(),
							properties.getProperty("draganddrop.text"));
					logger.info("The Drag and Drop Here is displayed.");
				}
				if (list.get(i).get("screen").contains("Dotted line box")) {
					assertTrue(bpcsPage.isBrowsePcInfoDisplayed("Dotted line box").isDisplayed(),
							"The Dotted line box is not displayed.");
					logger.info("The Dotted line box is displayed.");
				}
				if (list.get(i).get("screen").contains("Upload Icon")) {
					assertTrue(bpcsPage.isBrowsePcInfoDisplayed("Upload Icon").isDisplayed(),
							"The Upload Icon is not displayed.");
					logger.info("The Upload Icon is displayed.");
				}
				if (list.get(i).get("screen").contains("Browse PC button highlighted")) {
					Assert.assertEquals(
							bpcsPage.isBrowsePcInfoDisplayed("Browse PC button highlighted").getCssValue("color"),
							properties.getProperty("browsepcbutton.color"));
					logger.info("The Browse PC button highlighted is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The browse pc screen components are not displayed");
			exception = e;
		}
	}

}
