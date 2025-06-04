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

public class DUU_ImageUpload_SSR1798_DefaultSurgeonSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1798_DefaultSurgeonSteps.class);
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
	@Given("Chrome Browser is launched")
	public void chrome_browser_is_launched() {
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

	@Given("dataupload utility app url is entered")
	public void dataupload_utility_app_url_is_entered() {
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

	// *********************WHEN BLOCK*******************************
	@When("UserName value entered as {string}")
	public void user_name_value_entered_as(String user) {
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

	@When("Password value is entered by user")
	public void password_value_is_entered_by_user() {
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

	@When("than user clicks on Login Button")
	public void than_user_clicks_on_login_button() {
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

	@When("User clicks on Upload Files button from left panel")
	public void user_clicks_on_upload_files_button_from_left_panel() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.clickUploadFilesLeftPane();
			logger.info("Step : Upload Files button from left panel is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("than User clicks on Upload File")
	public void than_user_clicks_on_upload_file() {
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

	@When("user clicks on facility which has only one surgeon associated")
	public void user_clicks_on_facility_which_has_only_one_surgeon_associated() {
		try {
			lp = new LoginPage();
			fp = new FacilityListPage();
			fp.selectFacilityOneSurgoen();
			logger.info("Step : Facility is selected from the list");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
 
	@When("the user clicks on next button")
	@When("user clicks on Next button which is in enabled state")
	public void user_clicks_on_next_button_which_is_in_enabled_state() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.nextButton();
			logger.info("Step : Next button from Facility Selection Screen is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on facility which has more than one surgeon associated")
	public void user_clicks_on_facility_which_has_more_than_one_surgeon_associated() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.selectFacility();
			logger.info("Step : Facility is selected from the list");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// *********************THEN BLOCK*******************************
	@Then("Homepage is getting displayed")
	public void homepage_is_getting_displayed() {
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

	@Then("Search facility screen is displayed along with back and next button")
	public void search_facility_screen_is_displayed_along_with_back_and_next_button() {
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

	@Then("Surgeon should be selected by-default")
	public void surgeon_should_be_selected_by_default() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.isSurgeonSelected();
			logger.info("Step : Surgeon is selected by-default in Surgeon Selection Screen");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Application is closed")
	public void application_is_closed() {
		try {
			logger.info("Closing the Data Upload Utility Application");
			LoginPage.driver.quit();
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The application is not closed!!!");
			exception = e;
		}
	}

	@Then("No surgeon should be selected by default")
	public void No_surgeon_should_be_selected_by_default() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.getSurgeonText();
			logger.info("Step : No Surgeon is selected by default from the list");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Next button is in disabled state")
	public void Next_button_is_in_disabled_state() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.isNextButtonDisabled();
			logger.info("Step : Next button from Surgeon Selection Screen is disabled");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
