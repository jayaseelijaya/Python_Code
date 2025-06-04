package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FacilityListPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.SurgeonListPage;
import pages.UserInformationPage;
import pages.clpPage;
import utility.PropertiesFileReader;
import utility.RetrieveOTP;
import utility.ScreenRecording;
import utility.Screenshot;
import utility.Utility;

public class UserLoginSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(UserLoginSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SelectedActivityPage sa = new SelectedActivityPage();
	clpPage clp = new clpPage();
	RetrieveOTP retrieveOTP = new RetrieveOTP();
	public static String parentWindowId;
	public static WebDriver driver;
	clpPage clP = new clpPage();

//	@Before
//	public void Recording(Scenario scenario) throws Exception {
//		scenarioName = scenario.getName();
//		ScreenRecording.startRecording(scenarioName);
//	}
//
//	@After
//	public void Recording() throws Exception {
//		ScreenRecording.stopRecording();
//	}
//
//	@Before
//	public void screenshotDirectory(Scenario scenario) throws Exception {
//		scenarioName = scenario.getName();
//		screenshot.createScreenshotDirectory(scenarioName);
//	}

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
	@Given("Chrome Browser is opened")
	public void chrome_browser_is_opened() {
		try {
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--remote-allow-origins=*");
			//System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			options.setBrowserVersion("116");
			LoginPage.driver = new ChromeDriver(options);
			logger.info("Step : Chrome Browser is opened");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Given("CLP app url is entered")
	public void CLP_app_url_is_entered() {
		try {
			Properties properties = reader.getProperty();
			String url = properties.getProperty("clp.baseURL");
			LoginPage.driver.navigate().to(url);
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			logger.info("Step : CLP application url is entered as [" + url + "]");
			LoginPage.driver.manage().window().maximize();
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the CLP screen shall be displayed")
	public void the_CLP_screen_shall_be_displayed() {
		try {
			lp = new LoginPage();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(lp.snLogoDisplayed());
			logger.info("Step: CLP Login and Register Screen is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on go to login button")
	public void the_user_clicks_on_go_to_login_button() {
		try {
			lp.clickOnGoToLoginBtn();
			logger.info("Step: the user is clicked go to login button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the CLP Signin page shall be displayed")
	public void the_CLP_Signin_page_shall_be_displayed() {
		try {
			Thread.sleep(1000);
			lp = new LoginPage();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(LoginPage.driver.getTitle(), "Signin");
			logger.info("Step: CLP Signin Page is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("Email-Address is entered as {string}")
	public void email_address_is_entered_as(String user) {
		try {
			Properties properties = reader.getProperty();
			String username =null;
			if(user.equals("ic-test-admin@capgemini.com")) {
			username = properties.getProperty("icadmin.username");
			}
			if(user.equals("ic-test-hospital-admin@capgemini.com")||user.equals("h-test-admin@capgemini.com")) {
				username = properties.getProperty("hospitaladmin.username");
				}
			else if(user.equals("ic-test-tech@capgemini.com")||user.equals("ic-test-user@capgemini.com")||user.equals("ic-test-tech1@capgemini.com")) {
			username = properties.getProperty("tech.username");
			}
			else if(user.equals("ic-test-tech2@capgemini.com")) {
				username = properties.getProperty("tech2.username");
				}
			else if(user.equals("ic-test-surgeon@capgemini.com")) {
				username = properties.getProperty("surgeon.username");
				}
			else if(user.equals("ic-test-supportstaff@capgemini.com")|| user.equals("ic-test-staff@capgemini.com")) {
				username = properties.getProperty("supportstaff.username");
				}
			else if(user.equals("ic-test-snn-hil-manager@capgemini.com")||user.equals("ic-test-snhilmanager@capgemini.com")) {
				username = properties.getProperty("hilmanager.username");
				}
			else if(user.equals("ic-test-snn-hil-reviewer@capgemini.com")) {
				username = properties.getProperty("hilreviewer.username");
				}
			else if(user.equalsIgnoreCase("hadmin with no surgeon")) {
				username = properties.getProperty("hadmin.withoutSurgeon.username");
			}
			lp = new LoginPage();
			lp.enterUsername(username);
			logger.info("Step : Username is entered");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@When("Password is entered by the user")
	public void password_is_entered_by_the_user() {
		try {
			Properties properties = reader.getProperty();
			lp = new LoginPage();
			lp.enterPassword(properties.getProperty("samd.password"));
			logger.info("Step : Password is entered");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("the Login button is clicked")
	public void the_login_button_is_clicked() {
		try {
			lp = new LoginPage();
			lp.clickLoginButton();
			logger.info("Step : Login button is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user enters otp")
	public void the_user_enters_otp() {
		try {
			lp = new LoginPage();
			Properties properties = reader.getProperty();
			String Value = properties.getProperty("clp.automated2FAcode");
			Boolean otpOption = Boolean.valueOf(Value);
			if (otpOption) {
				retrieveOTP.readOtp();
				lp.getOTP().sendKeys(RetrieveOTP.OTP);
				logger.info("Step: The OTP is entered");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} else {
				logger.info("Step: The OTP is entered");
				Thread.sleep(30000);
//				loginPage.enterOTP();
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			}
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the signin button is clicked")
	public void the_signin_button_is_clicked() {
		try {
			lp = new LoginPage();
			lp.clickOnSigninButton();
			logger.info("Step : Signin button is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the application product page shall be displayed")
	public void the_application_product_page_shall_be_displayed() {
		try {
			Thread.sleep(10000);
			lp = new LoginPage();
                        lp.clickOnApplicationTab();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(lp.isApplicationsDisplayed(), "Applications");
			logger.info("Step: Applications Page is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks data upload launch button")
	public void the_user_clicks_data_upload_launch_button() throws IOException {
		try {
		lp.clickOnDataUploadLaunchButton();
		Thread.sleep(10000);
		logger.info("Step : the user clicked Data Upload button");
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	} catch (Exception e) {
		logger.error("Step: Caught exception:: " + e.toString());
		exception = e;
	}
}
	@When("the user click on Exit Apps at the bottom of the left menu panel")
	public void the_user_click_on_exit_apps_at_the_bottom_of_the_left_menu_panel() throws IOException {
		try {
		sa.clickOnExitToAppButton();
		logger.info("Step : the user click on Exit Apps at the bottom of the left menu panel");
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	} catch (Exception e) {
		logger.error("Step: Caught exception:: " + e.toString());
		exception = e;
	}
}
	
	@Then("the Application access screen is displayed")
	public void the_application_access_screen_is_displayed() {
		try {
			logger.info("Step : the Application access screen is displayed");
			Assert.assertEquals(lp.isApplicationsDisplayed(), "Applications");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user clicks on Logout icon from left panel")
	public void user_clicks_on_logout_icon_from_left_panel() {
		try {
			lp = new LoginPage();
			lp.clickLogoutButton();
			logger.info("Step: Logout button is clicked by the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("user is logout from the application.")
	public void user_is_logout_from_the_application() {
		try {
			lp = new LoginPage();
			lp.signInPageValidation();
			logger.info("Step: User is logout from the DUU Application");
			Assert.assertTrue(clp.isClpPageDisplayed());
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Given("SNN HIL Manager CLP app url is entered")
	public void SNN_HIL_Manager_CLP_app_url_is_entered() {
		try {
			Properties properties = reader.getProperty();
			String url = properties.getProperty("snnclp.baseURL");
			LoginPage.driver.navigate().to(url);
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			logger.info("Step : CLP application url is entered as [" + url + "]");
			LoginPage.driver.manage().window().maximize();
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the snn hil manager user clicks data upload launch button")
	public void the_snn_hil_manager_clicks_data_upload_launch_button() throws IOException {
		try {
			logger.info("Step : the user clicked Data Upload Button");
			UserLoginSteps loginSteps = new UserLoginSteps();
			loginSteps.the_user_clicks_data_upload_launch_button();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
