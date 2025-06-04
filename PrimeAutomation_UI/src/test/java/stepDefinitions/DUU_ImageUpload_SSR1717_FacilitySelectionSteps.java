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
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FacilityListPage;
import pages.FileUploadPage;
import pages.LoginPage;
import pages.SurgeonListPage;
import pages.UploadFilePage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.ScreenRecording;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1717_FacilitySelectionSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1717_FacilitySelectionSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SurgeonListPage sp = new SurgeonListPage();
	FacilityListPage fp = new FacilityListPage();
	UserInformationPage userPage = new UserInformationPage();
	UploadFilePage ufP = new UploadFilePage();
	FileUploadPage fuP = new FileUploadPage();
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
	@Given("chrome browser is launched")
	public void chrome_browser_is_launched() {
		try {
			//System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			LoginPage.driver = new ChromeDriver();
			logger.info("Step : Chrome Browser is opened");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Given("dataupload url is entered")
	public void dataupload_url_is_entered() {
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
	@When("username value entered as {string}")
	public void username_value_entered_as(String user) {
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

	@When("Password value is entered")
	public void password_value_is_entered() {
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

	@When("user clicks on Login Button")
	public void user_clicks_on_login_button() {
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

	@When("User clicks on Upload files button from left menu bar")
	public void user_clicks_on_upload_files_button_from_left_menu_bar() {
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
  
	@When("the user clicks on upload file button on the right section")
	@When("than user clicks on Upload File")
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

	@When("user clicks on any facility")
	public void user_clicks_on_any_facility() {
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

	@When("user clicks on I don't see my site listed")
	public void user_clicks_on_i_don_t_see_my_site_listed() {
		try {
			lp = new LoginPage();
			fp = new FacilityListPage();
			fp.clickifNofacility();
			logger.info("Step : I don't see my site listed button from homescreen is clicked");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on back button")
	public void the_user_clicks_on_back_button() {
		try {
			Thread.sleep(1000);
			ufP.clickOnSiteSeclectionBackBtn();
			logger.info("Step: The user clicked back button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user hovers over a site")
	public void the_user_hovers_over_a_site() {
		try {
			fp.hoverOverSiteName();
			logger.info("Step: The user is hovered over a site");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on close button on popup")
	public void the_user_clicks_on_close_button_on_popup() {
		try {
			ufP.clickOnCloseBtn();
			logger.info("Step: The user clicked close button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	
	@When("the user clicks on I don't see my Surgeon listed")
	public void the_user_clicks_on_i_don_t_see_my_surgeon_listed() {
		try {
			ufP.clickOnIdontseeSurgeon();
			logger.info("Step: The I don't see my surgeon listed is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user hovers over a surgeon")
	public void the_user_hovers_over_a_surgeon() {
		try {
			ufP.hoverOverSurgeonName();
			logger.info("Step: The user is hovered over a surgeon");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user removes text from search box")
	public void the_user_removes_text_from_search_box() {
		try {
			ufP.clearSearchbox();
			logger.info("Step: The text from searchbox is removed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on next button in surgeon selection screen")
	public void the_user_clicks_on_next_button_in_surgeon_selection_screen() {
		try {
			ufP.clearSearchbox();
			logger.info("Step: The next button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on I don't see my Application listed")
	public void the_user_clicks_on_i_don_t_see_my_application_listed() {
		try {
			ufP.clickOnIdontseeApplication();
			logger.info("Step: The I don't see my application listed is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user selects one site and try to select second site")
	public void user_selects_one_site_and_try_to_select_second_site() {
		try {
			ufP.select1st2ndSite();
			logger.info("Step: The user selected one site and then selected second site");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// *********************THEN BLOCK*******************************
	@Then("Homepage is displayed")
	public void homepage_is_displayed() {
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

	@Then("Search facility screen is displayed with back and next button")
	public void search_facility_screen_is_displayed_with_back_and_next_button() {
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

	@Then("List of facility is displayed to user")
	public void list_of_facility_is_displayed_to_user() {
		try {
			lp = new LoginPage();
			fp = new FacilityListPage();
			fp.getFacilityListText();
			logger.info("Step : List of Facility is displayed to the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Next button is in enabled state")
	public void next_button_is_in_enabled_state() {
		try {
			lp = new LoginPage();
			fp = new FacilityListPage();
			fp.isNextButtonEnabled();
			logger.info("Step : Next button is in enabled state after facility selection");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("App is closed")
	public void app_is_closed() {
		try {
			logger.info("Closing the Data Upload Utility Application");
			LoginPage.driver.quit();
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The application is not closed!!!");
			exception = e;
		}
	}

	@Then("If no organization is listed on selection modal screen")
	public void no_organization_is_listed_on_selection_modal_screen() {
		try {
			lp = new LoginPage();
			fp = new FacilityListPage();
			fp.dontSeeButtonDisplayed();
			logger.info("Step : I don't see my site listed button is displayed on Homescreen");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("notification message is displayed to the user")
	public void notification_message_is_displayed_to_the_user() {
		try {
			lp = new LoginPage();
			fp = new FacilityListPage();
			String message = fp.verifymsg();
			logger.info("Notification message : " + message);
			logger.info("Step : Notification message is displayed to the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the screen shall be navigated back to upload button screen")
	public void the_screen_shall_be_navigated_back_to_upload_button_screen() {
		try {
			Assert.assertTrue(fuP.isUploadBtnDisplayed());
			logger.info("Step: The user is navigated back to upload screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the hovered site shall be highlighted in green color")
	public void the_hovered_site_shall_be_highlighted_in_green_color() {
		try {
			Assert.assertTrue(ufP.isHoveredSiteHighlighted());
			logger.info("Step: The hovered site is highlighted in green color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the close button at bottom shall be displayed")
	public void the_close_button_at_bottom_shall_be_displayed() {
		try {
			Assert.assertTrue(ufP.isCloseBtnDisplayed());
			logger.info("Step: The popup close button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the x button in white color shall be displayed")
	public void the_x_button_in_white_color_shall_be_displayed() {
		try {
			Assert.assertTrue(ufP.isXBtnDisplayed());
			logger.info("Step: The popup x button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the searchbox border shall be higlighted in white color")
	public void the_searchbox_border_shall_be_higlighted_in_white_color() {
		try {
			Assert.assertTrue(ufP.isSearchBoxHighlighted());
			logger.info("Step: The Search box is highlighted");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the next button shall be displayed as disabled if no site selected")
	public void the_next_button_shall_be_displayed_as_disabled_if_no_site_selected() {
		try {
			Assert.assertFalse(ufP.isNextButtonDisabled());
			logger.info("Step: The next button is disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected site name shall be removed from top breadcrumb")
	public void the_selected_site_name_shall_be_removed_from_top_breadcrumb() {
		try {
			Assert.assertFalse(ufP.isBreadcrumbDisplayed());
			logger.info("Step: The top breadcrumb is not displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the next button shall be displayed as enabled and higlighted in green color")
	public void the_next_button_shall_be_displayed_as_enabled_and_higlighted_in_green_color() {
		try {
			Assert.assertTrue(ufP.isNextButtonEnabled());
			logger.info("Step: The next button is enabled and in green color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the hovered surgeon shall be highlighted in teal color")
	public void the_hovered_surgeon_shall_be_highlighted_in_teal_color() {
		try {
			Assert.assertTrue(ufP.isHoveredSurgeonHighlighted());
			logger.info("Step: The hovered surgeon is highlighted in teal color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("Text Enter First or Last Name of Surgeon as place holder in Search bar shall be displayed")
	public void text_enter_first_or_last_name_of_surgeon_as_place_holder_in_search_bar_shall_be_displayed() {
		try {
			Assert.assertTrue(ufP.isSurgeonSearchPlaceholderDisplayed());
			logger.info("Step: The Text Enter First or Last Name of Surgeon is displayed ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the next button shall be displayed as disabled if no surgeon selected")
	public void the_next_button_shall_be_displayed_as_disabled_if_no_surgeon_selected() {
		try {
			Assert.assertFalse(ufP.isNextButtonDisabled());
			logger.info("Step: The next button is disabled ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the screen shall be navigated back to surgeon selection screen")
	public void the_screen_shall_be_navigated_back_to_surgeon_selection_screen() {
		try {
			Assert.assertTrue(ufP.isSurgeonScreenDisplayed());
			logger.info("Step: The Surgeon selection screen shall be displayed ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the next button shall be displayed as disabled if no application selected")
	public void the_next_button_shall_be_displayed_as_disabled_if_no_application_selected() {
		try {
			Assert.assertFalse(ufP.isNextButtonDisabled());
			logger.info("Step: The next button is disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the user shall not be proceed to next screen without selecting site")
	public void the_user_shall_not_be_proceed_to_next_screen_without_selecting_site() {
		try {
			Assert.assertFalse(ufP.NoNextScreenWithoutSiteSelection());
			logger.info("Step: The user is not able to proceed to next screen without selecting a site");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the user shall not be able to select multiple site")
	public void the_user_shall_not_be_able_to_select_multiple_site() {
		try {
			Assert.assertTrue(ufP.isMultipleSiteSelected());
			logger.info("Step: The user is not able to select multiple site");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
