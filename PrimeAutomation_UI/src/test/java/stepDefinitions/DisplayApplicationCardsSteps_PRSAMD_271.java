//package stepDefinitions;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.BeforeStep;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import pages.ApplicationCardsPage;
//import pages.LoginPage;
//import pages.SurgeonListPage;
//import pages.UserInformationPage;
//import utility.PropertiesFileReader;
//import utility.ScreenRecording;
//import utility.Screenshot;
//import utility.Utility;
//
//public class DisplayApplicationCardsSteps_PRSAMD_271 {
//
//	PropertiesFileReader reader = new PropertiesFileReader();
//	final static Logger logger = Logger.getLogger(DisplayApplicationCardsSteps_PRSAMD_271.class);
//	Utility utility = new Utility();
//	Exception exception = null;
//	Boolean stepStatus = true;
//	Screenshot screenshot = new Screenshot();
//	String scenarioName;
//	LoginPage lp = new LoginPage();
//	UserInformationPage up = new UserInformationPage();
//	SurgeonListPage sp = new SurgeonListPage();
//	ApplicationCardsPage aP = new ApplicationCardsPage();
//	public static WebDriver driver;
//
////	@Before
////	public void Recording(Scenario scenario) throws Exception {
////		scenarioName = scenario.getName();
////		ScreenRecording.startRecording(scenarioName);
////	}
////
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
////	@Given("chrome browser is opened")
////	public void chrome_browser_is_opened() throws IOException, InterruptedException {
////		try {
////			//System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
////			WebDriverManager.chromedriver().setup();
////			LoginPage.driver = new ChromeDriver();
////			logger.info("Step: Chrome Browser is opened");
////			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
////			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
////		} catch (Exception e) {
////			logger.error("Step: Caught exception:: " + e.toString());
////			exception = e;
////		}
////	}
//
//	@Given("Application url is entered")
//	public void application_url_is_opened() throws IOException, InterruptedException {
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
//	@When("username is entered as {string}")
//	public void username_is_entered_as(String user) throws IOException, InterruptedException {
//		try {
//			lp = new LoginPage();
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
//	@When("Password is entered")
//	public void password_is_entered() throws IOException, InterruptedException {
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
//	@When("Login button is clicked")
//	public void login_button_is_clicked() throws IOException {
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
//	//@When("user clicked on Upload files button from left menu bar")
//	public void user_clicked_on_upload_files_button_from_left_menu_bar() {
//		try {
//			lp = new LoginPage();
//			sp = new SurgeonListPage();
//			sp.clickUploadFilesLeftPane();
//			logger.info("Step: Upload Files button from left panel is clicked");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@When("then user clicks on Upload File")
//	public void then_user_clicks_on_upload_file() {
//		try {
//			lp = new LoginPage();
//			sp = new SurgeonListPage();
//			sp.clickUploadFileButton();
//			logger.info("Step: Upload Files button from homescreen is clicked");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	// *********************THEN BLOCK*******************************
//	@Then("Search facility screen is displayed and user selects facility from the list")
//	public void search_facility_screen_is_displayed_and_user_selects_facility_from_the_list() {
//		try {
//			lp = new LoginPage();
//			aP = new ApplicationCardsPage();
//			aP.selectfacility();
//			logger.info("Step: Facility is selected from the selection screen ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("the homescreen is displayed")
//	public void the_homescreen_is_displayed() {
//		try {
//			lp = new LoginPage();
//			up = new UserInformationPage();
//			logger.info("Step: HomeScreen is displayed");
//			logger.info("Step: Role of the Logged-in user should be displayed");
//			String role = up.getUserRole();
//			logger.info("Name of the Logged-in user is : [" +role+ "]");
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Cought exception:: " + e.toString());
//			Assert.fail("The message is not displayed");
//			exception = e;
//		}
//	}
//
//	@Then("once facility is selected user clicks on Next button")
//	public void once_facility_is_selected_user_clicks_on_next_button() {
//		try {
//			lp = new LoginPage();
//			sp = new SurgeonListPage();
//			sp.nextButton();
//			logger.info("Step: Next button is clicked after selecting facility ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("Surgoen list associated with the facility is displayed and user selects surgeon")
//	public void surgoen_list_associated_with_the_facility_is_displayed_and_user_selects_surgeon() {
//		try {
//			lp = new LoginPage();
//			aP = new ApplicationCardsPage();
//			sp = new SurgeonListPage();
//			aP.selectSurgeon();
//			logger.info("Step: Surgeon is selected from the selection screen ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			aP.clickNext();
//			logger.info("Step: Next button is clicked after selecting surgeon ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("application card should is displayed as per the selected surgeon")
//	public void application_card_should_is_displayed_as_per_the_selected_surgeon()
//			throws IOException, InterruptedException {
//		try {
//			lp = new LoginPage();
//			aP = new ApplicationCardsPage();
//			aP.applicationcardText();
//			logger.info("Step: Application Cards is displayed as per selected Surgeon ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//		aP.clickBack();
//		logger.info("Step: Back button is clicked from the application card selection screen ");
//		aP.selectsecondSurgeon();
//		logger.info("Step: Surgeon is selected from the selection screen ");
//		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//		aP.clickNext();
//		logger.info("Step: Next button is clicked after selecting surgeon ");
//		aP.applicationcardText();
//		logger.info("Step: Application Cards is displayed as per selected Surgeon ");
//	}
//
//	@Then("user selects surgeon which deosn't have application cards and click on Next")
//	public void user_selects_surgeon_which_deosn_t_have_application_cards_and_click_on_next() {
//		try {
//			lp = new LoginPage();
//			aP = new ApplicationCardsPage();
//			sp = new SurgeonListPage();
//			aP.noSurgeon();
//			logger.info("Step: Surgeon is selected from the selection screen ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			aP.clickNext();
//			logger.info("Step: Next button is clicked after selecting surgeon ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("application card should not be displayed with notification message")
//	public void application_card_should_not_be_displayed_with_notification_message() {
//		try {
//			lp = new LoginPage();
//			aP = new ApplicationCardsPage();
//			logger.info("Step: Application Cards is not displayed as per selected Surgeon ");
//			String message = aP.getMessage();
//			logger.info("Notification message :  [" + message + "]");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("user selects facility from the list")
//	public void user_selects_facility_from_the_list() {
//		try {
//			lp = new LoginPage();
//			aP = new ApplicationCardsPage();
//			sp = new SurgeonListPage();
//			aP.moreAppCardFacility();
//			logger.info("Step: Facility is selected from the selection screen ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("user selects surgeon which have more than Nine application cards")
//	public void user_selects_surgeon_which_have_more_than_nine_application_cards_and_click_on_next() {
//		try {
//			lp = new LoginPage();
//			aP = new ApplicationCardsPage();
//			sp = new SurgeonListPage();
//			aP.moreAppCardSurgeon();
//			logger.info("Step: Surgeon is selected from the selection screen ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("more than nine application card is displayed")
//	public void more_than_nine_application_card_is_displayed() {
//		try {
//			lp = new LoginPage();
//			aP = new ApplicationCardsPage();
//			aP.applicationcardText();
//			aP.clickforward();
//			logger.info("Step: Forward button is in enabled state to view remaining application cards ");
//			logger.info("Step: Application Cards is displayed as per selected Surgeon ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("clicked next button")
//	public void clicked_next() {
//		try {
//			lp = new LoginPage();
//			aP = new ApplicationCardsPage();
//			aP.clickNext();
//			logger.info("Step: Application Cards is displayed as per selected Surgeon ");
//			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			exception = e;
//		}
//	}
//
//	@Then("applicaton is closed")
//	public void applicaton_is_closed() {
//		try {
//			LoginPage.driver.quit();
//		} catch (Exception e) {
//			logger.error("Step: Caught exception:: " + e.toString());
//			Assert.fail("The application is not closed!!!");
//			exception = e;
//		}
//	}
//}
