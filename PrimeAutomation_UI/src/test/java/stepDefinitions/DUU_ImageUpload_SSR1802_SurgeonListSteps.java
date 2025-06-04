package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import pages.FileUploadPage;
import pages.LoginPage;
import pages.SurgeonListPage;
import utility.PropertiesFileReader;
import utility.ScreenRecording;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1802_SurgeonListSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1802_SurgeonListSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SurgeonListPage sP = new SurgeonListPage();
	FacilityListPage fp = new FacilityListPage();
	FileUploadPage fuPage = new FileUploadPage();

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

	// *********************WHEN BLOCK*******************************

	@When("The user enters the first name of the surgeon in uppercase into the search box")
	public void the_user_enters_the_first_name_of_the_surgeon_in_uppercase_into_the_search_box() {
		try {
			String surgeonname = sP.splitSurgeonName("first name");
			sP.enterTextInSurgeonSearchBox().sendKeys(surgeonname.toUpperCase());
			logger.info("Step: Uppercase surgeon name "+surgeonname+" entered into search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the first name of the surgeon in upper and lower case into the search box")
	public void the_user_enters_the_first_name_of_the_surgeon_in_upper_and_lower_case_into_the_search_box() {
		try {
			String surgeonname = sP.splitSurgeonName("first name");
			sP.enterTextInSurgeonSearchBox().sendKeys(surgeonname);
			logger.info("Step: Combination of Upper&lowercase surgeon name" + surgeonname + "placed into search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the first name of the surgeon in lowercase into the search box")
	public void the_user_enters_the_first_name_of_the_surgeon_in_lowercase_into_the_search_box() {
		try {
			String surgeonname = sP.splitSurgeonName("first name");
			sP.enterTextInSurgeonSearchBox().sendKeys(surgeonname.toLowerCase());
			logger.info("Step: Lowercase surgeon name "+surgeonname+" entered into search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the last name of the surgeon in uppercase into the search box")
	public void the_user_enters_the_last_name_of_the_surgeon_in_uppercase_into_the_search_box() {
		try {
			String surgeonname = sP.splitSurgeonName("last name");
			sP.enterTextInSurgeonSearchBox().sendKeys(surgeonname.toUpperCase());
			logger.info("Step: The last name of the uppercase surgeon name "+surgeonname+" is entered");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the last name of the surgeon in upper and lower case into the search box")
	public void the_user_enters_the_last_name_of_the_surgeon_in_upper_and_lower_case_into_the_search_box() {
		try {
			String surgeonname = sP.splitSurgeonName("last name");
			sP.enterTextInSurgeonSearchBox().sendKeys(surgeonname);
			logger.info("Step: Last name of the surgeon name "+surgeonname+" is placed into search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the last name of the surgeon in lowercase into the search box")
	public void the_user_enters_the_last_name_of_the_surgeon_in_lowercase_into_the_search_box() {
		try {
			String surgeonname = sP.splitSurgeonName("last name");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			sP.enterTextInSurgeonSearchBox().sendKeys(surgeonname.toLowerCase());
			logger.info("Step: Surgeon name"+surgeonname+" is placed into search box as lowercase");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the full name of the surgeon in uppercase into the search box")
	public void the_user_enters_the_full_name_of_the_surgeon_in_uppercase_into_the_search_box() {
		try {
			String surgeonname = sP.splitSurgeonName("full name");
			sP.enterTextInSurgeonSearchBox().sendKeys(surgeonname.toUpperCase());
			logger.info("Step: The full surgeon name in uppercase is placed into search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the full name of the surgeon in  upper and lower case into the search box")
	public void the_user_enters_the_full_name_of_the_surgeon_in_upper_and_lower_case_into_the_search_box() {
		try {
			String surgeonname = sP.splitSurgeonName("full name");
			sP.enterTextInSurgeonSearchBox().sendKeys(surgeonname);
			logger.info(
					"Step: The full surgeon name "+surgeonname+" is entered into search box as upperandlowercase");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the full name of the surgeon in lower case into the search box")
	public void the_user_enters_the_full_name_of_the_surgeon_in_lower_case_into_the_search_box() {
		try {
			String surgeonname = sP.splitSurgeonName("full name");
			sP.enterTextInSurgeonSearchBox().sendKeys(surgeonname.toLowerCase());
			logger.info("Step: The surgeon name"+surgeonname+" in lowercase is placed into search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters the site name into the search field and selects a site")
	public void the_user_enters_the_site_name_into_the_search_field_and_selects_a_site() {
		try {
			Properties properties = reader.getProperty();
			fp.enterTextInSearchBox().sendKeys(properties.getProperty("available.site1"));
			fuPage.selectSite(0);
			fp.clickOnNextButton();
			logger.info("Step: the user enters the site name" + properties.getProperty("available.site1")
					+ " into the search field and selects a site");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("When a user selects a site that is not linked to a surgeon")
	public void When_a_user_selects_a_site_that_is_not_linked_to_a_surgeon(String string) {
		try {
			sP.enterTextInSurgeonSearchBox().sendKeys(string);
			fuPage.selectSite(0);
			Assert.assertTrue(fuPage.isNoSurgeonAvailableTextDisplayed());
			logger.info("Step: The Selected site name of the surgeon: " + string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the invalid {string} surgeon name in search box")
	public void the_user_enters_the_invalid_surgeon_name_in_search_box(String string) {
		try {
			sP.enterTextInSurgeonSearchBox().sendKeys(string);
			logger.info("Step: the user enters the invalid site name" + string + " into the search field");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the surgeon name with special characters {string} in search box")
	public void the_user_enters_the_surgeon_name_with_special_characters_in_search_box(String string) {
		try {
			sP.enterTextInSurgeonSearchBox().sendKeys(string);
			logger.info("Step: The surgeon name with special characters " + string + "placed into search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters the valid surgeon name with numbers and special characters {string} in search box")
	public void the_user_enters_the_valid_surgeon_name_with_numbers_and_special_characters_in_search_box(
			String string) {
		try {
			sP.enterTextInSurgeonSearchBox().sendKeys(string);
			logger.info("Step: The valid surgeon name with numbers and special characters" + string
					+ "placed into search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user enters spaces in search box")
	public void the_user_enters_spaces_in_search_box() {
		try {

			sP.enterTextInSurgeonSearchBox().sendKeys("            ");
			logger.info("Step: Spaces are entered into search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("The user clear the spaces from the search bar")
	public void the_user_clear_the_spaces_from_the_search_bar() {
		try {
			sP.deleteTextinSearchbox();
			logger.info("Step: The search box spaces are deleted");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	// *********************THEN BLOCK*******************************
	@Then("List of Surgeon is displayed")
	public void list_of_surgeon_is_displayed() throws IOException {

		try {
			sP.getSurgeonText();
			logger.info("Step: List of Surgeon is displayed for selected facility");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("click on the next button")
	public void click_on_the_next_button() {
		try {
			Properties properties = reader.getProperty();
			fp.clickOnNextButton();
			logger.info("Step: click on the next button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the list will be displayed for entering text")
	public void the_list_will_be_displayed_for_entering_text() {
		try {
			Properties properties = reader.getProperty();
			sP.getSurgeonText();
			logger.info("Step: the list of surgeon name will be displayed for entered text");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the surgeon search box is displayed")
	public void the_surgeon_search_box_is_displayed() {
		try {

			Assert.assertTrue(sP.isSurgeonSearchBoxDisplayed());
			logger.info("Step: Surgeon search box is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the blankscreen displays with no search results")
	public void the_blankscreen_displays_with_no_search_results() {
		try {
			boolean BlankScreen = sP.blankScreenDisplayed();
			logger.info(BlankScreen);
			Assert.assertTrue(BlankScreen);
			logger.info("Step: Blank screen is displayed with no search results");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

}
