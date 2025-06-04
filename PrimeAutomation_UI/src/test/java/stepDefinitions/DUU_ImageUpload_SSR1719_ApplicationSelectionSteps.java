package stepDefinitions;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApplicationCardsPage;
import pages.FacilityListPage;
import pages.LoginPage;
import pages.SurgeonListPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1719_ApplicationSelectionSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1719_ApplicationSelectionSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SurgeonListPage sp = new SurgeonListPage();
	FacilityListPage fp = new FacilityListPage();
	ApplicationCardsPage ap = new ApplicationCardsPage();
	public static WebDriver driver;

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

	// *********************GIVEN BLOCK*******************************
	@Given("Homepage is displayed to the user")
	public void homepage_is_displayed_to_the_user() {
		try {
			Thread.sleep(20000);
			lp = new LoginPage();
			String title = LoginPage.driver.getTitle();
			logger.info("Title of the application : " + title);
			logger.info("Step: Homepage is displayed to the user ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Homepage is not loaded ");
			exception = e;
		}
	}

	// *********************WHEN BLOCK*******************************
	@When("Clicks on Upload Button")
	public void clicks_on_upload_button() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.clickUploadFileButton();
			logger.info("Step : Upload button from homescreen is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on Next button after surgeon selection")
	public void clicks_on_Next_button_after_surgeon_selection() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.NextBtnSurgeon();
			logger.info("Step : Next button from Surgeon Selection Screen is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user select's one application card from the list")
	public void user_select_s_one_application_card_from_the_list() {
		try {
			lp = new LoginPage();
			ap = new ApplicationCardsPage();
			ap.isNextButtonEnabled();
			logger.info("Step: Next Button is in disbaled mode if no card is selected by the user");
			ap.selectAppCard();
			logger.info("Step: Application Card is selected by the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user selects one card from the list")
	public void user_selects_one_card_from_the_list() {
		try {
			ap.selectFirstAppCard();
			logger.info("Step: One application Card is selected by the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects one more card from the list")
	public void the_user_selects_one_more_card_from_the_list() {
		try {
			ap.selectSecondAppCard();
			logger.info("Step: 2nd application Card is selected by the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// *********************THEN BLOCK*******************************
	@Then("user clicks on surgeon which has application card associated")
	public void user_clicks_on_surgeon_which_has_application_card_associate_() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.selectSurgeonAppCards();
			logger.info("Step : Surgeon is selected which has application card associated");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Application Selection Modal screen is displayed to user along with back and next button")
	public void application_selection_modal_screen_is_displayed_to_user_along_with_back_and_next_button() {
		try {
			lp = new LoginPage();
			ap = new ApplicationCardsPage();
			ap.backButtonDisplayed();
			ap.NextButtonDisplayed();
			logger.info("Step: Application Card Selection Screen is displayed to the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Next button should be in enabled state and clickable to begin with data upload workflow")
	public void next_button_should_be_in_enabled_state_and_clickable_to_begin_with_data_upload_workflow() {
		try {
			lp = new LoginPage();
			ap = new ApplicationCardsPage();
			ap.isNextButtonEnabled();
			logger.info("Step: Next Button is in Enabled mode and clickable to begin with data upload workflow");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("user is not able to begin with data upload workflow if Application card is not selected")
	public void user_not_able_begin_with_data_upload_workflow() {
		try {
			lp = new LoginPage();
			ap = new ApplicationCardsPage();
			ap.isNextButtonEnabled();
			logger.info("Step: Next Button is in disabled mode and non-clickable to begin with data upload workflow");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("no application shall be displayed as selected by default if more than one record available")
	public void no_application_shall_be_displayed_as_selected_by_default_if_more_than_one_record_available() {
		try {
			ap.isNoCardSelectedByDefault();
			logger.info("Step: No card is selected by default if more than one record");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("carousel arrow on left and right shall be displayed")
	public void carousel_arrow_on_left_and_right_shall_be_displayed() {
		try {
			ap.isLeftRightArrowsDisplayed();
			logger.info("Step: Carousel arrow on left and right side is displayed");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the previously selected card shall be unselected")
	public void the_previously_selected_card_shall_be_unselected() {
		try {
			ap.isPrevioslySelectedCardUnselected();
			logger.info("Step: User can not select more than one card");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	
}
