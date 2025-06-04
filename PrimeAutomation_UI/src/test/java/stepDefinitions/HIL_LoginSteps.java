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
import pages.HILLoginPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.SurgeonListPage;
import pages.UserInformationPage;
import pages.clpPage;
import utility.PropertiesFileReader;
import utility.ScreenRecording;
import utility.Screenshot;
import utility.Utility;

public class HIL_LoginSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HIL_LoginSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HILLoginPage lp = new HILLoginPage();
	SelectedActivityPage sa = new SelectedActivityPage();
	clpPage clp = new clpPage();
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
	
	@Given("HIL app url is entered")
	public void HIL_app_url_is_entered() {
		try {
			Properties properties = reader.getProperty();
			String url = properties.getProperty("snnclp.baseURL");
			LoginPage.driver.navigate().to(url);
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			logger.info("Step : HIL application url is entered as [" + url + "]");
			LoginPage.driver.manage().window().maximize();
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks go to login button")
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
	
	@When("email address is entered as {string}")
	public void email_address_is_entered_as(String user) throws IOException {
		try {
			Properties properties = reader.getProperty();
			String username =null;
			if(user.equals("ic-test-snn-hil-manager@capgemini.com")||user.equals("ic-test-snhilmanager@capgemini.com")) {
				username = properties.getProperty("hilmanager.username");
				}
			else if(user.equals("ic-test-snn-hil-reviewer@capgemini.com")) {
				username = properties.getProperty("hilreviewer.username");
				}
			lp.enterUserName(username);
			logger.info("Step : Username is entered");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("enter the password")
	public void password_is_entered_by_the_user() {
		try {
			Properties properties = reader.getProperty();
			lp.enterPassword(properties.getProperty("samd.password"));
			logger.info("Step : Password is entered");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	
	
	@Then("the HIL Login button is clicked")
	public void the_HIL_login_button_is_clicked() throws IOException, InterruptedException {
		try {
			lp.clickOnHILLoginButton();
			logger.info("Step : Login button is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks HIL launch button")
	public void the_user_clicks_HIL_launch_button() throws IOException {
		try {
		lp.clickOnHILLaunchButton();
		logger.info("Step : the user clicks HIL launch button");
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	} catch (Exception e) {
		logger.error("Step: Caught exception:: " + e.toString());
		exception = e;
	}
}
	
}
