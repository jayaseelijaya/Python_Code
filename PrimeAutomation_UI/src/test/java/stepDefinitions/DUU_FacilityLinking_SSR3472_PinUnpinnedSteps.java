package stepDefinitions;

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
import pages.ImagingLinksPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.SurgeonListPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_FacilityLinking_SSR3472_PinUnpinnedSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR3472_PinUnpinnedSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
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

	@When("user clicks on toggle")
	public void user_clicks_on_toggle() throws IOException, InterruptedException {
		try {
			ilPage.isRecordsDisplayed();
			logger.info("Step: Toggle button is clicked ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("All linked image centers are displayed above in table")
	public void all_linked_image_centers_are_displayed_above_in_table() {
		try {
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			ilPage.isLinkedRecordsDisplayed();
			logger.info("Step: Linked image centers are displayed above in table followed by unlinked image centers");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("all unlinked image centers are displayed below in the table")
	public void all_unlinked_image_centers_are_displayed_below_in_the_table() {
		try {
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			ilPage.isUnLinkedRecordsDisplayed();
			logger.info("Step: UnLinked image centers are displayed below in table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user turns off the toggle")
	public void user_turns_off_the_toggle() {
		try {
			ilPage.clickOnToggleButton();
			logger.info("Step: Toggle button turns OFF");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("image center list sorted in Alphabet order based on Site column")
	public void image_center_list_sorted_in_alphabet_order_based_on_site_column() {
		try {
			ilPage.isRecordsDisplayed();
			logger.info("Step: Toggle button turns OFF");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on file dashboard page and verifies the header")
	public void user_clicks_on_file_dashboard_page_and_verifies_the_header() {
		try {
			saPage.clickOnDashboardButton();
			saPage.isDashboardHeaderDisplayed();
			logger.info("Step: File dashboard page is displayed to user");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Pin linked centers to top toggle button is displayed as OFF")
	public void pin_linked_centers_to_top_toggle_button_is_displayed_as_off() {
		try {
			ilPage.isToggleButtonDisabled();
			ilPage.isToggleButtonDisplayed();
			logger.info("Step: File dashboard page is displayed to user");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user turns On the toggle")
	public void user_turns_on_the_toggle() {
		try {
			ilPage.clickOnToggleButton();
			logger.info("Step: Toggle button turns ON");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("User clicks pin linked button above right table")
	public void user_clicks_pin_linked_button_above_right_table() {
		try {
			ilPage.clickPinLinkedButtonRightTable();
			logger.info("User clicks pin linked button above right table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click pin linked button above right table");
			exception = e;
		}
	}
	
	@Then("Check pin linked button above right table")
	public void check_pin_linked_button_above_right_table() {
		try {
			Assert.assertTrue(ilPage.checkPinLinkedRightTable());
			logger.info("Pin linked button is displayed above right table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check pin linked button above right table");
			exception = e;
		}
	}
	
	@Then("Check if the imaging links right table is in the correct pinned facility to top order")
	public void check_imaging_links_right_table_correct_pin_linked_order() {
		try {
			Assert.assertTrue(ilPage.checkIfFacilityOrderIsPinnedRightTable());
			logger.info("Right table is in the correct order");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Right table in incorrect order");
			exception = e;
		}
	}
}
