package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
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
import pages.FileUploadPage;
import pages.LoginPage;
import pages.SurgeonListPage;
import utility.PropertiesFileReader;
import utility.ScreenRecording;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1718_SurgeonSelectionSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1718_SurgeonSelectionSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SurgeonListPage sp = new SurgeonListPage();
	FacilityListPage fp = new FacilityListPage();
	public static WebDriver driver;
	FileUploadPage fuP = new FileUploadPage();

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

	@When("User clicks on facility which has surgeon associated")
	public void user_clicks_on_facility_which_has_surgeon_associated() {
		try {
			lp = new LoginPage();
			fp = new FacilityListPage();
			fp.selectFacilityListedSurgeon();
			logger.info("Step : Facility is selected from the list which has surgeon associated");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("surgeon list should be display as per the selected facility")
	public void surgeon_list_should_be_display_as_selet_default() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.getSurgeonText();
			logger.info("Step : Surgeon associated list is displayed to the user");
			sp.isNextButtonDisabled();
			logger.info("Step : Next Button is in disabled mode if surgeon is not selected");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("user clicks on any of the surgeon listed")
	public void user_clicks_on_any_of_the_surgeon_listed() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.selectSurgeon();
			logger.info("Step : Surgeon is selected from the list displayed to the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Next button should be in enabled mode after selecting surgeon")
	public void next_button_should_be_in_enabled_mode_after_selecting_surgeon() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.isNextButtonDisabled();
			logger.info("Step : Next Button is in enabled mode after surgeon selection");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			sp.NextBtnSurgeon();
			logger.info("Step : Next Button is Clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("User clicks on facility which has no surgeon associated")
	public void user_clicks_on_facility_which_has_no_surgeon_associated() {
		try {
			lp = new LoginPage();
			fp = new FacilityListPage();
			fp.selectfacilitynoSurgeon();
			logger.info("Step : Facility is selected from the list which has no surgeon associated");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("notification message should be displayed to the user")
	public void notification_message_should_be_displayed_to_the_user() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			String message = sp.verifySurgeonmsg();
			logger.info("Notification message : " + message);
			logger.info("Step : Notification message is displayed to the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Back button should be in enabled mode & clickable")
	public void back_button_should_be_in_enabled_mode_clickable() {
		try {
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.isBackButtonEnabled();
			logger.info("Step : Back Button is in enabled mode & clickable ");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Next button should be in disabled mode & non-clickable")
	public void next_button_should_be_in_disabled_mode_non_clickable() {
		try {
			logger.info("Step : Next Button is in disabled mode if no surgeon is present");
			lp = new LoginPage();
			sp = new SurgeonListPage();
			sp.isNextButtonDisabled();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("user is not able to proceed with data upload if no surgeon selected")
	public void user_is_not_able_to_proceed_with_data_upload_if_no_surgeon_selected() {

		try {
			sp = new SurgeonListPage();
			logger.info("No Surgeon is selected from the surgeon selection screen");
			sp.isNextButtonDisabled();
			logger.info("Step : Next Button is in disabled mode if no surgeon is selected from the list");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Given("Record the list of sites")
	public void record_the_list_of_sites() {
		try {
			logger.info("Step :Record the list of sites");
			Properties properties = reader.getProperty();
			logger.info("Available Sites:");
			logger.info(properties.getProperty("available.site1"));
			logger.info(properties.getProperty("available.site2"));
			logger.info(properties.getProperty("available.site3"));
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Given("Record the self linked site")
	public void record_the_self_linked_site() {
		try {
			logger.info("Step :Record the self linked site");
			Properties properties = reader.getProperty();
			logger.info("Self linked Sites:");
			logger.info(properties.getProperty("available.site1"));
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Given("Record the list of surgeons")
	public void record_the_list_of_surgeons() {
		try {
			logger.info("Step :Record the list of surgeons");
			Properties properties = reader.getProperty();
			logger.info("Available Surgeons:");
			logger.info(properties.getProperty("available.site1.surgeon1"));
			logger.info(properties.getProperty("available.site1.surgeon2"));
			logger.info(properties.getProperty("available.site1.surgeon3"));
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Given("Record the list of applications")
	public void record_the_list_of_applications() {
		try {
			logger.info("Step :Record the list of applications");
			Properties properties = reader.getProperty();
			logger.info("Available Applications:");
			logger.info(properties.getProperty("available.application1"));
			logger.info(properties.getProperty("available.application2"));
			logger.info(properties.getProperty("available.application3"));
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the list of site displayed is as recorded")
	public void the_list_of_site_displayed_is_as_recorded() {
		try {
			logger.info("Step :the list of site displayed is as recorded");
			Assert.assertTrue(fuP.listOfSitesIsDisplayedCorrect());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("Self linked site is selected by default")
	public void self_linked_site_is_selected_by_default() {
		try {
			logger.info("Step :Self linked site is selected by default");
			Assert.assertTrue(fuP.selfLinkedSiteIsSelectedByDefault());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the list of surgeons displayed is as recorded")
	public void the_list_of_surgeons_displayed_is_as_recorded() {
		try {
			logger.info("Step :the list of surgeons displayed is as recorded");
			Assert.assertTrue(fuP.listOfSurgeonsIsDisplayedCorrect());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the list of application displayed is as recorded")
	public void the_list_of_application_displayed_is_as_recorded() {
		try {
			logger.info("Step :the list of application displayed is as recorded");
			Assert.assertTrue(fuP.listOfApplicationsIsDisplayedCorrect());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user selects site with no surgeon")
	public void user_selects_site_with_no_surgeon() throws IOException, InterruptedException {
		try {
			logger.info("Step : user selects site with no surgeon");
			fuP.selectSiteWithNoSurgeons();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the Surgeon selection screen is displayed with no surgeons")
	public void the_surgeon_selection_screen_is_displayed_with_no_surgeons(List<Map<String,String>> dt) throws IOException, InterruptedException {
		try {
			logger.info("Step : the Surgeon selection screen is displayed with");
			Assert.assertTrue(fuP.isSurgeonSelectionScreenComponentsDisplayed());
			Assert.assertTrue(fuP.isNoSurgeonAvailableTextDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the Error message is displayed as No Surgeon available Please request administrator to add surgeon")
	public void error_message_no_surgeon() {
		try {
			logger.info("Step :the Error message is displayed as No Surgeon available Please request administrator to add surgeon");
			Assert.assertTrue(fuP.isNoSurgeonAvailableTextDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("Select the site recorded")
	public void select_the_site_recorded() throws IOException, InterruptedException {
		try {
			logger.info("Step: Select the site recorded");
			fuP.selectSite(0);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the site is selected")
	public void the_site_is_selected() throws IOException, InterruptedException {
		try {
			logger.info("Step: the site is selected");
			Assert.assertTrue(fuP.isSiteSelected());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on next button in site selection screen")
	public void the_user_clicks_on_next_button_in_site_selection_screen() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user clicks on next button in site selection screen");
			fuP.clickNextBtn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("no surgeon is displayed as selected by default")
	public void no_surgeon_is_displayed_as_selected_by_default() throws IOException, InterruptedException {
		try {
			boolean isDisplayed = true;
			logger.info("Step: no surgeon is displayed as selected by default");
			try{
				fuP.isSurgeonSelected();
				isDisplayed = true;
			}
			catch(NoSuchElementException e) {
				isDisplayed = false;
			}
			Assert.assertFalse(isDisplayed);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("click on one surgeon name then try to select the 2nd surgeon")
	public void click_on_one_surgeon_name_then_try_to_select_the_2nd_surgeon() throws IOException, InterruptedException {
		try {
			logger.info("Step: click on one surgeon name then try to select the 2nd surgeon");
			fuP.selectSurgeon(1);
			fuP.selectSurgeon(0);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("user is not able to select multiple surgeon")
	public void user_is_not_able_to_select_multiple_surgeon() throws IOException, InterruptedException {
		try {
			logger.info("Step: user is not able to select multiple surgeon");
			Assert.assertTrue(fuP.onlyOneSurgeonisSelected());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
