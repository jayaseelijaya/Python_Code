package stepDefinitions;

import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SurgeonListPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.ScreenRecording;
import utility.Screenshot;
import utility.Utility;

public class DisplayUserInformationSteps_PRSAMD_562 {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DisplayUserInformationSteps_PRSAMD_562.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	UserInformationPage userPage = new UserInformationPage();
	LoginPage loginPage = new LoginPage();
	public static WebDriver driver;
	UserInformationPage up = new UserInformationPage();

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
	@Given("that chrome browser is opened")
	public void that_chrome_browser_is_opened()
	{
		try {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			LoginPage.driver = new ChromeDriver();
			logger.info("Step: Chrome Browser is opened");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) 
		{
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
		
	@Given("application url is entered")
	public void application_url_is_entered() {
		try {
			Properties properties = reader.getProperty();
			String url = properties.getProperty("samd.baseURL");
			LoginPage.driver.navigate().to(url);
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			logger.info("Step: Image Upload application url is entered as [" + url + "]");
			LoginPage.driver.manage().window().maximize();
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	// **********************WHEN BLOCK*******************************
	@When("the username is entered as {string}")
	public void the_username_is_entered_as(String user) {
		try {
			loginPage = new LoginPage();
			loginPage.enterUsername(user);
			logger.info("Step: Username is entered");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("password is entered")
	public void password_is_entered() {
		try {
			Properties properties = reader.getProperty();
			loginPage = new LoginPage();
			loginPage.enterPassword(properties.getProperty("samd.password"));
			logger.info("Step: Password is entered");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("then login button is clicked")
	public void then_login_button_is_clicked() {
		try {
			loginPage = new LoginPage();
			loginPage.clickLoginButton();
			logger.info("Step: Login button is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	// *********************THEN BLOCK*******************************
	@Then("homepage screen shall be displayed")
	public void homepage_screen_shall_be_displayed() {
		try {
			loginPage = new LoginPage();
			logger.info("Step: HomeScreen is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Cought exception:: " + e.toString());
			Assert.fail("The message is not displayed");
			exception = e;
		}
	}
	@Then("user verifies S&N logo on left menu bar")
	public void user_verifies_s_n_logo_on_left_menu_bar() {
		try {
			Thread.sleep(5000);
			loginPage = new LoginPage();
			userPage = new UserInformationPage();
			logger.info("Step: Smith & Nephew Logo should be displayed");
			userPage.isLogoDisplayed();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("user verifies profile picture of the logged-in user on left menu bar")
	public void user_verifies_profile_picture_of_the_logged_in_user_on_left_menu_bar() {
		try {
			Thread.sleep(5000);
			loginPage = new LoginPage();
			userPage = new UserInformationPage();
			logger.info("Step: Profile picture of Logged-in User should be displayed");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			userPage.profilePicture();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("user verifies name of the logged-in user on left menu bar")
	public void user_verifies_name_of_the_logged_in_user_on_left_menu_bar() {
		try {
			loginPage = new LoginPage();
			userPage = new UserInformationPage();
			logger.info("Step: Name of the User Logged-in should be displayed");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			String actualName = userPage.getLoggedUserName();
			logger.info("Name of the Logged-in user is : ["  +actualName+  "]");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("user verifies role of the user logged-in")
	public void user_verifies_role_of_the_user_logged_in() {
		try {
			loginPage = new LoginPage();
			userPage = new UserInformationPage();
			logger.info("Step: Role of the Logged-in user should be displayed");
			String role = userPage.getUserRole();
			logger.info("Role of the Logged-in user is : [" +role+ "]");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("then applicaton should be closed")
	public void then_applicaton_should_be_closed() {
		try {
			LoginPage.driver.quit();
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The application is not closed!!!");
			exception = e;
	    }
    }
	
	@Then("the welcome message shall be displayed")
	public void the_welcome_message_shall_be_displayed() {
		try {
			Thread.sleep(5000);
			loginPage = new LoginPage();
			userPage = new UserInformationPage();
			logger.info("Step: the welcome message shall be displayed");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			userPage.profilePicture();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the list of linked facilities and Remove button is displayed")
	public void the_list_of_linked_facilities_and_remove_button_is_displayed() {
		try {
			Assert.assertTrue(up.isImagingComponentsDisplayed("list of linked facilities").isDisplayed());
			Assert.assertTrue(up.isImagingComponentsDisplayed("remove button").isDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the list of linked facilities and Remove Link and Create Link is displayed")
	public void the_list_of_linked_facilities_and_removelink_createlink_is_displayed() {
		try {
			Assert.assertTrue(up.isImagingComponentsDisplayed("list of linked facilities").isDisplayed());
			Assert.assertTrue(up.isImagingComponentsDisplayed("remove button").isDisplayed());
			Assert.assertTrue(up.isImagingComponentsDisplayed("create button").isDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
