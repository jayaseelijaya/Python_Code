package stepDefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.FacilityListPage;
import pages.FileUploadPage;
import pages.LoginPage;
import pages.SettingsPage;
import pages.SurgeonListPage;
import stepDefinitions.CommonSteps;

import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class CommonSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(CommonSteps.class);
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	Utility utility = new Utility();
	UserLoginSteps loginSteps = new UserLoginSteps();
	FacilityListPage fp = new FacilityListPage();
	LoginPage lp = new LoginPage();
	HIL_LoginSteps hilLoginSteps = new HIL_LoginSteps();

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
	@Given("that the user is logged in to Data-Upload Utility Application through chrome {string}")
	public void that_the_user_is_logged_in_to_DataUpload_Utility_application_through_chrome(String user) {{
		try {
			boolean isUserHILManager =user.contains("manager");
			boolean isStaffUser=user.contains("staff");
			loginSteps = new UserLoginSteps();
			loginSteps.chrome_browser_is_opened();
			if(isUserHILManager) {
				hilLoginSteps.HIL_app_url_is_entered();
			}else {
				loginSteps.CLP_app_url_is_entered();
			}
			loginSteps.the_CLP_screen_shall_be_displayed();
			loginSteps.the_user_clicks_on_go_to_login_button();
			loginSteps.the_CLP_Signin_page_shall_be_displayed();
			loginSteps.email_address_is_entered_as(user);
			loginSteps.password_is_entered_by_the_user();
			loginSteps.the_login_button_is_clicked();
			if(isUserHILManager) {
				logger.info("Skipping OTP option for SNN CLP");
			}else {
				loginSteps.the_user_enters_otp();
				loginSteps.the_signin_button_is_clicked();
			}
			loginSteps.the_application_product_page_shall_be_displayed();
			if(isStaffUser) {
				lp.selectSurgeonForStaffUser();
			}
			loginSteps.the_user_clicks_data_upload_launch_button();
//			LoginPage.driver.navigate().refresh();
			Thread.sleep(10000);
			logger.info("Step: User is logged in Data-Upload Utility Application through Chrome");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception " + e.toString());
			exception = e;

		}
	}
}
	
	@Given("that the user is logged in to Data-Upload Utility Application through chrome with minimum screen resolution {string}")
	public void that_the_user_is_logged_in_to_DataUpload_Utility_application_through_chrome_with_minimum_screen_resolution(String user) {{
			try {
				loginSteps = new UserLoginSteps();
				loginSteps.chrome_browser_is_opened();
				loginSteps.CLP_app_url_is_entered();
				loginSteps.the_CLP_screen_shall_be_displayed();
				loginSteps.email_address_is_entered_as(user);
				loginSteps.password_is_entered_by_the_user();
				lp.clickLoginButtonForMinimumScreenResolution();
				logger.info("Step: User is logged in Data-Upload Utility Application through Chrome");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception " + e.toString());
				exception = e;

			}
		}
	}
	@When("the user clicks on Next Button")
	public void the_user_clicks_on_next_button() {
		try {
			fp.clickOnNextButton();
			logger.info("Step: User selected a facility from the list");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Given("a valid file is uploaded")
	public void a_valid_file_is_uploaded() {
			try {
				logger.info("Step: a valid file is uploaded");
				SurgeonListPage sp = new SurgeonListPage();
				FileUploadPage fuPage = new FileUploadPage();
				SettingsPage s = new SettingsPage();
				sp.clickUploadFilesLeftPane();
				sp.clickUploadFileButton();
				fuPage.selectSite(0);
				fuPage.clickNextBtn();
				fuPage.selectSurgeon(0);
				fuPage.clickNextBtn();
				fuPage.selectApplication();
				fuPage.clickNextBtn();
				fuPage.uploadFileFromLocal("valid");
				s.clickFileDashboardButton();
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception " + e.toString());
				exception = e;

			}
	}
}
