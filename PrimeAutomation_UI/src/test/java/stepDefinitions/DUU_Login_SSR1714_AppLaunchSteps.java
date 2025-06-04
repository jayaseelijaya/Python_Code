package stepDefinitions;

import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FileDashboardPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_Login_SSR1714_AppLaunchSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_Login_SSR1714_AppLaunchSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();

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

	@Given("browser is opened by the user")
	public void browser_is_opened_by_the_user() {
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			LoginPage.driver = new ChromeDriver(options);
			logger.info("Step : Chrome Browser is opened");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Given("user enters the DUU URL")
	public void user_enters_the_duu_url() {
		try {
			Properties properties = reader.getProperty();
			String url = properties.getProperty("samd.baseURL");
			LoginPage.driver.navigate().to(url);
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			logger.info("Step : Image Upload application url is entered as [" + url + "]");
			LoginPage.driver.manage().window().maximize();
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Given("user enters the CLP URL")
	public void user_enters_the_clp_url() {
		try {
			Properties properties = reader.getProperty();
			String url = properties.getProperty("clp.baseURL");
			LoginPage.driver.navigate().to(url);
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			logger.info("Step : CLP url is entered as [" + url + "]");
			LoginPage.driver.manage().window().maximize();
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("username is entered as {string}")
	public void username_is_entered_as(String user) {
		try {
			lp = new LoginPage();
			lp.enterUsername(user);
			logger.info("Step : Username is entered");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("Password is entered")
	public void password_is_entered() {
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

	@When("Login button is clicked")
	public void login_button_is_clicked() {
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

	@Then("Upload dashboard page is displayed to the user")
	public void upload_dashboard_page_is_displayed_to_the_user() {
		try {
			lp = new LoginPage();
			String title = LoginPage.driver.getTitle();
			logger.info("Title of the application : " + title);
			logger.info("DUU web Application is launched within 1 minute and can be seen in Extent PDF report");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("DUU Homepage is not loaded ");
			exception = e;
		}
	}
	
	@When("login to clp as {string}")
	public void login_to_clp_as(String user) {
		try {
			logger.info("Step: login to clp as");
			UserLoginSteps loginSteps = new UserLoginSteps();
			HIL_LoginSteps hilLoginSteps = new HIL_LoginSteps();
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
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("click on launch for DUU and verify launch takes less than 1 min")
	public void click_on_launch_for_DUU_verify_less_than_1_min() {
		try {
			UserLoginSteps loginSteps = new UserLoginSteps();
			logger.info("Step: click on launch for DUU and verify launch takes less than 1 min");
			loginSteps.the_user_clicks_data_upload_launch_button();
			long startTime = System.currentTimeMillis();
			WebDriverWait wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(70));
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"menu_item1\"]")));
//			wait.until(ExpectedConditions.visibilityOf(utility.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath")));
			wait.until(ExpectedConditions.titleContains("Data Upload Utility"));
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			logger.info("startTime: " + startTime);
			logger.info("endTime: " + endTime);
			logger.info("totalTime: " + totalTime);
			Assert.assertTrue(totalTime < 1000);
			Thread.sleep(1000);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
