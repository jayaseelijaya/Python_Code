package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileUploadPage;
import pages.LoginPage;
import pages.SettingsPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUploadSettings_SSS1728_AdminModifyViewUserSpecificDetailsSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger
			.getLogger(DUU_ImageUploadSettings_SSS1728_AdminModifyViewUserSpecificDetailsSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage loginPage = new LoginPage();
	public static WebDriver driver;
	FileUploadPage fuPage = new FileUploadPage();
	SettingsPage sp = new SettingsPage();

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

	// **********************Given*********************************
	@Given("the setting for Unsuccessful Uploads Expiration should set to {string} days")
	public void the_setting_for_unsuccessful_uploads_expiration_should_set_to_days(String string) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// **********************When*********************************
	@When("the user selects a site and click on next button")
	public void the_user_selects_a_site_and_click_on_next_button() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user selects a site and click on next button");
			fuPage.selectSite(0);
			Assert.assertTrue(fuPage.isSiteSelected());
			fuPage.clickNextBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects a surgeon and click on next button")
	public void the_user_selects_a_surgeon_and_click_on_next_button() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user selects a surgeon and click on next button");
			fuPage.selectSurgeon(0);
			Assert.assertTrue(fuPage.isSurgeonSelected());
			fuPage.clickNextBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects an application and click on Next button")
	public void the_user_selects_an_application_and_click_on_next_button() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user selects an application and click on Next button");
			fuPage.selectApplication();
			fuPage.clickNextBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@When("the user clicks on Browse PC button and select a valid DICOM file and upload")
	public void the_user_clicks_on_browse_pc_button_and_select_a_valid_dicom_file_and_upload() throws IOException {
		try {
			logger.info("Step: the user clicks on Browse PC button and select a valid DICOM file and upload");
			fuPage.uploadFileFromLocal("valid");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// **********************Then*********************************
	@Then("the Global viewing toggle button is disabled by default")
	public void the_global_viewing_toggle_button_is_disabled_by_default() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the upload icon and Upload button are displayed")
	public void the_upload_icon_and_upload_button_are_displayed() throws IOException, InterruptedException {
		try {
			logger.info("Step: the upload icon and Upload button are displayed");
			Assert.assertTrue(fuPage.isUploadBtnDisplayed());
			Assert.assertTrue(fuPage.isUploadIconDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the Site selection screen is displayed")
	public void the_site_selection_screen_is_displayed() throws IOException, InterruptedException {
		try {
			logger.info("Step: the Site selection screen is displayed");
			Assert.assertTrue(fuPage.isSiteSelectionScreenDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the Site is selected")
	public void the_site_is_selected() throws IOException {
		try {
			logger.info("Step: the Site is selected");
			Assert.assertTrue(fuPage.isSelectionHeaderDisplyed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the Surgeon selection screen is displayed")
	public void the_surgeon_selection_screen_is_displayed() throws IOException, InterruptedException {
		try {
			logger.info("Step: the Surgeon selection screen is displayed");
			Assert.assertTrue(fuPage.isSurgeonSelectionScreenDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the Surgeon is selected")
	public void the_surgeon_is_selected() {
		try {
			logger.info("Step: the Surgeon is selected");
			Assert.assertTrue(fuPage.isSelectionHeaderDisplyed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the Application selection screen is displayed")
	public void the_application_selection_screen_is_displayed() throws IOException, InterruptedException {
		try {
			logger.info("Step: the Application selection screen is displayed");
			Assert.assertTrue(fuPage.isapplicationSelectionScreenDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the Upload screen is displayed with drag drop area, Back and Browse PC button")
	public void the_upload_screen_is_displayed_with_drag_drop_area_back_and_browse_pc_button()
			throws IOException, InterruptedException {
		try {
			logger.info("Step: the Upload screen is displayed with drag drop area, Back and Browse PC button");
			Assert.assertTrue(fuPage.uploadScreenDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the Upload successful screen is displayed")
	public void the_upload_successful_screen_is_displayed() {
		try {
			logger.info("Step: the Upload successful screen is displayed");
			Assert.assertTrue(fuPage.isuploadSuccessDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("an input box with {string} is displayed")
	public void an_input_box_with_is_displayed(String string) {
		try {
			String ssname = "an input box with " + string + " is displayed";
			logger.info("Step: " + ssname);
			if (string.equalsIgnoreCase("Successful Uploads Expiration")) {
				assertTrue(sp.isSuccessfulUploadDisplayed());
			} else {
				assertTrue(sp.isUnsuccessfulUploadDisplayed());
			}
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("{string} text is displayed")
	public void text_is_displayed(String string) throws IOException {
		try {
			String ssname = string + " text is displayed";
			logger.info("Step: " + ssname);
			assertTrue(sp.numberofdaysTextIsDisplayed());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the global settings is toggled on")
	public void the_global_settings_is_toggled_on() throws IOException {
		try {
			logger.info("Step: the global settings is toggled on");
			assertTrue(sp.isGlobalViewingOn());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the successful and unsuccessful records uploaded by hospital users within {int} days is only displayed")
	public void the_successful_and_unsuccessful_records_uploaded_by_hospital_users_within_days_is_only_displayed(
			Integer int1) throws IOException, InterruptedException {
		try {
			String ssname = "the successful and unsuccessful records uploaded by hospital users within " + int1
					+ " days is only displayed";
			logger.info("Step: " + ssname);
			assertTrue(sp.checkAllUploadDatesdisplayed(int1));
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the successful and unsuccessful records uploaded by ic users within {int} days is only displayed")
	public void the_successful_and_unsuccessful_records_uploaded_by_ic_users_within_days_is_only_displayed(Integer int1)
			throws IOException, InterruptedException {
		try {
			String ssname = "the successful and unsuccessful records uploaded by ic users within " + int1
					+ " days is only displayed";
			logger.info("Step: " + ssname);
			assertTrue(sp.checkAllUploadDatesdisplayed(int1));
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the successful expiration unsuccessful expiration and global viewing shall be separated by line in grey color")
	public void the_successful_expiration_unsuccessful_expiration_and_global_viewing_shall_be_separated_by_line_in_grey_color()
			throws IOException, InterruptedException {
		try {
			assertTrue(sp.isGreyLineSepratesSettings());
			logger.info("The successful, unsuccessful expiration and global viewing are seperated by grey line");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the setting header shall be displayed in white color")
	public void the_setting_header_shall_be_displayed_in_white_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isSettingsHeaderDisplayedInWhiteColor(), properties.getProperty("white.color"));
			logger.info("The settings header is displayed in white color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the successful uploads textbox shall be displayed in green color")
	public void the_successful_uploads_textbox_shall_be_displayed_in_green_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isSuccessfulUploadTextboxDisplayedInGreenColor(), properties.getProperty("green.color"));
			logger.info("The successful uploads textbox is displayed in green color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the successful uploads expiration text shall be displayed in white color")
	public void the_successful_uploads_expiration_text_shall_be_displayed_in_white_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isSuccessfulUploadExpirationTextDisplayedInWhiteColor(), properties.getProperty("white.color"));
			logger.info("The successful uploads expiration text is displayed in white color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the number of days image uploads are shown on the dashboard before being archived text shall be displayed in white color")
	public void the_number_of_days_image_uploads_are_shown_on_the_dashboard_before_being_archived_text_shall_be_displayed_in_white_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isTextBoxDescriptionDisplayedInWhiteColor(), properties.getProperty("white.color"));
			logger.info("The number of days image uploads are shown on the dashboard before being archived text is displayed in white color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the enterered value in upload successful textbox is displayed in green color")
	public void the_enterered_value_in_upload_successful_textbox_is_displayed_in_green_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isSuccessfulUploadTextBoxValueInGreenColor(), properties.getProperty("green.color"));
			logger.info("The successful upload textbox value is displayed in green color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the unsuccessful uploads textbox is displayed in green color")
	public void the_unsuccessful_uploads_textbox_is_displayed_in_green_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isUnsuccessfulUploadTextboxDisplayedInGreenColor(), properties.getProperty("green.color"));
			logger.info("The unsuccessful uploads textbox is displayed in green color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the unsuccessful uploads expiration text shall be displayed in white color")
	public void the_unsuccessful_uploads_expiration_text_shall_be_displayed_in_white_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isUnsuccessfulUploadExpirationTextDisplayedInWhiteColor(), properties.getProperty("white.color"));
			logger.info("The unsuccessful uploads expiration text is displayed in white color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the enterered value in upload unsuccessful textbox is displayed in green color")
	public void the_enterered_value_in_upload_unsuccessful_textbox_is_displayed_in_green_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isUnsuccessfulUploadTextBoxValueInGreenColor(), properties.getProperty("green.color"));
			logger.info("The unsuccessful upload textbox value is displayed in green color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the save button is displayed in white color")
	public void the_save_button_is_displayed_in_white_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isSavebuttonColorDisplayedInWhiteColor(), properties.getProperty("white.color"));
			logger.info("The save button is displayed in white color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("reset to default button is displayed in white color")
	public void reset_to_default_button_is_displayed_in_white_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isResetToDefaultButtonColorDisplayed(), properties.getProperty("white.color"));
			logger.info("The reset to default button is displayed in white color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the successful upload expiration shall be displayed as {int}")
	public void the_successful_upload_expiration_shall_be_displayed_as(Integer value) throws IOException, InterruptedException {
		try {
			Assert.assertEquals(sp.getSuccessfulUploadValue(value), value);
			logger.info("The successful upload expiration is displayed as " +value);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the unsuccessful upload expiration shall be displayed as {int}")
	public void the_unsuccessful_upload_expiration_shall_be_displayed_as(Integer value) throws IOException, InterruptedException {
		try {
			Thread.sleep(1000);
			Assert.assertEquals(sp.getUnsuccessfulUploadValue(value), value);
			logger.info("The unsuccessful upload expiration is displayed as " +value);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the global viewing shall be toggled on")
	public void the_global_viewing_shall_be_toggled_on() throws IOException, InterruptedException {
		try {
			Assert.assertTrue(sp.isGlobalViewingToggledOn());
			logger.info("The global viewing is toggled on");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the save button shall be in disabled")
	public void the_save_button_shall_be_in_disabled() throws IOException, InterruptedException {
		try {
			Assert.assertFalse(sp.isSaveButtonDiabled());
			logger.info("The Save button is in disabled state");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the global viewing text shall be displayed in white color")
	public void the_global_viewing_text_shall_be_displayed_in_white_color() throws IOException, InterruptedException {
		try {
			Properties properties = reader.getProperty();
			Assert.assertEquals(sp.isGlobalViewingTextInWhiteColor(), properties.getProperty("white.color"));
			logger.info("The gloabl viewing text is displayed in white color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
