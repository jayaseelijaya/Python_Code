//package stepDefinitions;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.BeforeStep;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pages.LoginPage;
//import pages.SurgeonListPage;
//import stepDefinitions.SurgeonListSteps_PRSAMD_263;
//import utility.PropertiesFileReader;
//import utility.ScreenRecording;
//import utility.Screenshot;
//import utility.Utility;
//
//public class SurgeonListSteps_PRSAMD_263 {
//	PropertiesFileReader reader = new PropertiesFileReader();
//	final static Logger logger = Logger.getLogger(SurgeonListSteps_PRSAMD_263.class);
//	Utility utility = new Utility();
//	Exception exception = null;
//	Boolean stepStatus = true;
//	Screenshot screenshot = new Screenshot();
//	String scenarioName;
//	LoginPage lp = new LoginPage();
//	SurgeonListPage loginPage = new SurgeonListPage();
//	public static WebDriver driver;
//
//	@Before
//	public void Recording(Scenario scenario) throws Exception {
//		scenarioName = scenario.getName();
//		ScreenRecording.startRecording(scenarioName);
//	}
//
////	@After
////	public void Recording() throws Exception {
////		ScreenRecording.stopRecording();
////	}
////
////	@Before
////	public void screenshotDirectory(Scenario scenario) throws Exception {
////		scenarioName = scenario.getName();
////		screenshot.createScreenshotDirectory(scenarioName);
////	}
//
//	@BeforeStep
//	public void beforeStep(Scenario scenario) {
//		exception = null;
//	}
//
//	@AfterStep
//	public void afterStep() {
//		String exceptionName = null;
//		if (exception != null) {
//			stepStatus = false;
//			logger.info(
//					"\n******************************STEP FAILED*****************************************************");
//			exceptionName = exception.getClass().getSimpleName();
//			logger.info("Exception Type : " + exceptionName);
//			if (exceptionName.equals("NoSuchElementException")) {
//				logger.info("Element could not be found");
//			} else if (exceptionName.equals("ElementNotSelectableException")) {
//				logger.info("Element could not be not selected");
//			} else if (exceptionName.equals("NoSuchFrameException")) {
//				logger.info("Frame does not exist");
//			} else if (exceptionName.equals("NoSuchWindowException")) {
//				logger.info("Window does not exist");
//			} else if (exceptionName.equals("TimeoutException")) {
//				logger.info("Element could not be found within the specified time");
//			} else if (exceptionName.equals("ConnectionClosedException")) {
//				logger.info("Driver is disconnected");
//			} else if (exceptionName.equals("AssertionError")) {
//				logger.info(exceptionName);
//			} else {
//				logger.info("Exception occured : " + exceptionName);
//			}
//			logger.info("Exception Details below:\n");
//			logger.info(exception.toString());
//			logger.info(
//					"**********************************************************************************************");
//			System.out.println(stepStatus);
//		}
//		if (stepStatus == false) {
//			logger.info("TESTCASE HAS FAILED AT THIS STEP");
//			Assert.fail();
//		}
//	}
//
//	// *********************GIVEN BLOCK*******************************
//	@Given("that the chrome browser is opened")
//	public void that_the_chrome_browser_is_opened() throws IOException, InterruptedException {
//		try {
//			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
//			LoginPage.driver = new ChromeDriver();
//			logger.info("Step: Chrome Browser is opened");
//			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Given("that app url is entered")
//	public void that_hil_app_url_is_entered() throws IOException, InterruptedException {
//		try {
//			Properties properties = reader.getProperty();
//			String url = properties.getProperty("samd.baseURL");
//			LoginPage.driver.navigate().to(url);
//			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//			logger.info("Step: Image Upload application url is entered as [" + url + "]");
//			LoginPage.driver.manage().window().maximize();
//			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	// *********************WHEN BLOCK*******************************
//	@When("the Username is entered as {string}")
//	public void the_username_is_entered(String user) throws IOException, InterruptedException {
//		try {
//			lp= new LoginPage();
//			lp.enterUsername(user);
//			logger.info("Step: Username is entered");
//			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@When("the password is entered")
//	public void the_password_is_entered() throws IOException, InterruptedException {
//		try {
//			Properties properties = reader.getProperty();
//			lp = new LoginPage();
//			lp.enterPassword(properties.getProperty("samd.password"));
//			logger.info("Step: Password is entered");
//			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@When("the login button is clicked")
//	public void the_login_button_is_clicked() throws IOException {
//		try {
//			lp = new LoginPage();
//			lp.clickLoginButton();
//			logger.info("Step: Login button is clicked");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@When("user clicked on upload files button from left menu bar")
//	public void user_clicked_on_upload_files_button_from_left_menu_bar() {
//		try {
//			lp = new LoginPage();
//			loginPage = new SurgeonListPage();
//			loginPage.clickUploadFilesLeftPane();
//			logger.info("Step: Upload Files button from left panel is clicked");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@When("then user click on Upload File")
//	public void then_user_click_on_upload_file() {
//		try {
//			lp = new LoginPage();
//			loginPage = new SurgeonListPage();
//			loginPage.clickUploadFileButton();
//			logger.info("Step: Upload Files button from homescreen is clicked");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	// ********************THEN BLOCK*******************************
//	@Then("the homepage shall be displayed")
//	public void the_homepage_shall_be_displayed() throws IOException {
//		try {
//			lp = new LoginPage();
//			loginPage = new SurgeonListPage();
//			logger.info("Step: HomeScreen is displayed");
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Cought exception:: " + e.toString());
//			Assert.fail("The message is not displayed");
//			exception = e;
//		}
//	}
//
//	@Then("Search facility screen should be displayed and user selects facility from the list")
//	public void search_facility_screen_should_be_displayed_and_user_selects_facility_from_the_list() {
//		try {
//			lp = new LoginPage();
//			loginPage = new SurgeonListPage();
//			loginPage.selectFacility();
//			logger.info("Step: Facility should be selected from the selection screen ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("after selecting facility user click on Next button")
//	public void after_selecting_facility_user_click_on_next_button() {
//		try {
//			lp = new LoginPage();
//			loginPage = new SurgeonListPage();
//			loginPage.nextButton();
//			logger.info("Step: Next button should be clicked after selecting facility ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("Surgoen list associated with the facility is displayed")
//	public void surgoen_list_associated_with_the_facility_is_displayed() throws IOException {
//		try {
//			lp = new LoginPage();
//			loginPage = new SurgeonListPage();
//			Properties properties = reader.getProperty();
//			String expMsg = properties.getProperty("Surgeon.validation");
//			String actualMsg = loginPage.getSurgeonText();
//			Assert.assertEquals(expMsg, actualMsg, "Surgeon list is displayed");
//			logger.info("Surgeon List is matched as per the Facility selected. Actual Surgeon value is [" + actualMsg
//					+ "] and Expected Surgeon value is [" + expMsg + "]");
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Cought exception:: " + e.toString());
//			Assert.fail("Surgeon List is not matched as per the Facility selected");
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//			exception = e;
//		}
//	}
//
//	@Then("the applicaton is closed")
//	public void the_applicaton_is_closed() {
//		try {
//			LoginPage.driver.quit();
//			try {
//				utility.initializeElement(LoginPage.driver, "leftnav.img.snlogo.xpath").isDisplayed();
//				logger.error("Step: Application is not closed");
//				Assert.assertTrue(false, "The application is not closed");
//
//			} catch (Exception e) {
//				logger.info("Step: Application is closed");
//				Assert.assertTrue(true, "The application is closed");
//			}
//
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			Assert.fail("The application is not closed!!!");
//			exception = e;
//		}
//	}
//
//	@Then("Search facility screen should be displayed and user selects facility which doesnt have Surgeon associated")
//	public void search_facility_screen_should_be_displayed_and_user_selects_facility_which_doesnt_have_surgeon_associated() {
//		try {
//			lp = new LoginPage();
//			loginPage = new SurgeonListPage();
//			loginPage.selectUnLinkedFacility();
//			logger.info("Step: Facility should be selected from the screen ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("no surgoen name associated with the facility is displayed along with notification message")
//	public void no_surgoen_name_associated_with_the_facility_is_displayed_along_with_notification_message()
//			throws IOException {
//		try {
//			lp = new LoginPage();
//			loginPage = new SurgeonListPage();
//			Properties properties = reader.getProperty();
//			String expMsg = properties.getProperty("expErrorMsg");
//			String actualMsg = loginPage.verifySurgeonmsg();
//			Assert.assertEquals(expMsg, actualMsg, "Notification message is validated");
//			logger.info("No Surgeon List is found as per the Facility selected ");
//			logger.info("Notification message displayed as : [" + actualMsg + "]");
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Cought exception:: " + e.toString());
//			Assert.fail("Surgeon List is not matched as per the Facility selected");
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//			exception = e;
//		}
//	}
//}
