package stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FacilityListPage;
import pages.HILLoginPage;
import pages.LoginPage;

import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class HIL_CommonSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HIL_CommonSteps.class);
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	Utility utility = new Utility();
	UserLoginSteps loginSteps = new UserLoginSteps();
	LoginPage lp = new LoginPage();
	HIL_LoginSteps hilLoginSteps = new HIL_LoginSteps();
	HILLoginPage hilLp = new HILLoginPage();

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
	// ***********Given Block************
	@Given("that the user is logged in to HIL Application through chrome {string}")
	public void that_the_user_is_logged_in_to_HIL_application_through_chrome(String user) {{
			try {
				loginSteps.chrome_browser_is_opened();
				hilLoginSteps.HIL_app_url_is_entered();
				hilLoginSteps.the_user_clicks_on_go_to_login_button();
				hilLoginSteps.email_address_is_entered_as(user);
				hilLoginSteps.password_is_entered_by_the_user();
				hilLoginSteps.the_HIL_login_button_is_clicked();
				hilLoginSteps.the_user_clicks_HIL_launch_button();
				try {
					Thread.sleep(3000);
				}
				finally{
					logger.debug("@@@@@");
				}
				logger.info("Step: User is logged in HIL Application through Chrome");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception " + e.toString());
				exception = e;

			}
		}
	}
	
	@When("the user clicks on Logout button at top right section")
	public void the_user_clicks_on_logout_button_at_top_right_section() throws IOException, InterruptedException {
		try{
			logger.info("Step: the user clicks on Logout button at top right section");
			hilLp.clickLogoutButton();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the user is logged out successfully and navigated to CLP login screen")
	public void the_user_is_logged_out_successfully_and_navigated_to_clp_login_screen() {
		try{
			logger.info("Step: the user is logged out successfully and navigated to CLP login screen");
			Assert.assertTrue(hilLp.isUserloggedOut());
			logger.info("User logged out");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
