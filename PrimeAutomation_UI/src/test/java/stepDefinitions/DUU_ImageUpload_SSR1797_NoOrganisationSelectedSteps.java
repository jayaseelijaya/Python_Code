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
import pages.FacilityListPage;
import pages.LoginPage;
import pages.SurgeonListPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.ScreenRecording;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1797_NoOrganisationSelectedSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1797_NoOrganisationSelectedSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SurgeonListPage sp = new SurgeonListPage();
	FacilityListPage fp = new FacilityListPage();
	public static WebDriver driver;

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
	@Given("chrome browser is launched by user")
	public void chrome_browser_is_launched_by_user() {
		try {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			LoginPage.driver = new ChromeDriver();
			logger.info("Step : Chrome Browser is opened");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Given("dataUpload utility url is entered")
	public void data_upload_utility_url_is_entered() {
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

	@When("email-address is entered as {string}")
	public void email_address_is_entered_as(String user) {
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

	@When("password is entered by user")
	public void password_is_entered_by_user() {
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

	@When("login button is clicked by user")
	public void login_button_is_clicked_by_user() {
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

	@Then("the homepage of the application is displayed")
	public void the_homepage_of_the_application_is_displayed() {
		try {
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

	@When("user clicked on upload files field from left panel")
	public void user_clicked_on_upload_files_field_from_left_panel() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.clickUploadFilesLeftPane();
			logger.info("Step : Upload Files button from left panel is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("click on Upload File from the homescreen")
	public void click_on_upload_file_from_the_homescreen() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.clickUploadFileButton();
			logger.info("Step : Upload Files button from homescreen is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Facility Selection Modal is be displayed to the user")
	public void facility_selection_modal_is_be_displayed_to_the_user() {
		try {
			lp = new LoginPage();
			fp = new FacilityListPage();
			fp.backButtonDisplayed();
			fp.NextButtonDisplayed();
			logger.info("Step: Facility Screen is displayed to the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("no facility should be by-default selected and next button should be in disabled mode")
	public void no_facility_should_be_by_default_selected_and_next_button_should_be_in_disabled_mode() {
		try {
			lp = new LoginPage();
			fp = new FacilityListPage();
			fp.getFacilityListText();
			logger.info("Step : None of the Facility is selected by-default");
			fp.isNextButtonEnabled();
			logger.info("Step : Next button is in disabled mode");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("application will be closed")
	public void application_will_be_closed() {
		try {
			logger.info("Closing the Data Upload Utility Application");
			LoginPage.driver.quit();
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The application is not closed!!!");
			exception = e;
		}
	}

}
