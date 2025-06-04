package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
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
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1800_SearchSiteSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1800_SearchSiteSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FacilityListPage fp = new FacilityListPage();

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

	@Then("the list of sites are displayed")
	public void the_list_of_sites_are_displayed() throws IOException {
		
		{
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				String sites = null, count = fp.getFacilityListText();
				logger.info("List of sites:"+count);
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
				
	}
	
	@When("the user enters Uppercase of the valid site name {string} in search box")
	public void the_user_enters_uppercase_of_the_valid_site_name_in_search_box(String searchtext) {
		try {
			fp.enterTextInSearchBox().sendKeys(searchtext);
			logger.info("Step: Text in search box entered as : " + searchtext);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the list of site shall be displayed for entered text")
	public void the_list_of_site_shall_be_displayed_for_entered_text() {
		{
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(fp.isListDisplayedABCHText());
				logger.info("Step: List is displayed matching text records ");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}

	}

	@When("User enters valid site with upper and Lower case of {string} in search box")
	public void user_enters_valid_site_with_upper_and_Lower_case_in_search_box(String Searchloweruppercase) {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.enterTextInSearchBox().sendKeys(Searchloweruppercase);
			logger.info("Step: Text in search box entered as : " + Searchloweruppercase);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@When("User enters valid site with lowercase {string} in search box")
	public void user_enters_valid_site_with_lowercase_in_search_box(String Searchlowercase) {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.enterTextInSearchBox().sendKeys(Searchlowercase);
			logger.info("Step: Text in search box entered as : " + Searchlowercase);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("User enters valid full site name {string} in search box")
	public void user_enters_valid_full_site_name_in_search_box(String Searchfullsite) {
		try {

			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.enterTextInSearchBox().sendKeys(Searchfullsite);
			logger.info("Step: Full site name in search box entered as : " + Searchfullsite);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the site is matched with the displayed text")
	public void the_site_which_we_entered_is_matched_with_the_displayed_text() {
		try {

			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(fp.isListDisplayedABCHText());
			logger.info("Step: List is displayed matching text records ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("User Hover the mouse on the site name")
	public void user_hover_the_mouse_on_the_site_name() {
		try {
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.hoverOverSiteName();
			logger.info("Step: the user hover the coursor on one of site name from the list");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("The site name changing into green colour")
	public void the_site_name_changing_into_green_colour() {

		try {
			Properties properties = reader.getProperty();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(fp.isSiteNameDisplayedInGreenColour(), properties.getProperty("facility.sitename"));
			logger.info("Step: Site name is displayed in green colour");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("User removed entered site name {string} from the search box")
	public void user_removed_entered_site_name_from_the_search_box(String site) {

		try {

			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.BackspacetextinSearchBox(site);
			logger.info("Step: Searched text is removed from the search box");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("The site screen displayed all site name")
	public void the_site_screen_displayed_all_site_name() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// fp.getFacilityListText();
			fp.getFacilityListText();
			logger.info("Step: List of sites are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	

	@When("the user enters invalid site name {string} in search box")
	public void the_user_enters_invalid_site_name_in_search_box(String invalidsitename) {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.enterTextInSearchBox().sendKeys(invalidsitename);
			logger.info("Step: Text in search box entered as : " + invalidsitename);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}

	@Then("the Blank screen is displayed with no search results")
	public void the_blank_screen_is_displayed_with_no_search_results() throws IOException {
		try {
			
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.Blankscreen();
			logger.info("The Blank screen is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
		
	}
	@Then("entered special character {string} in search bar")
	public void entered_special_character_in_search_bar(String string) {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.enterTextInSearchBox().sendKeys(string);
			logger.info("Step: Text in search box entered as :" + string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("User entered site name with numbers and special characters {string} in search bar")
	public void user_entered_site_name_with_numbers_and_special_characters_in_search_box(String string) {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.enterTextInSearchBox().sendKeys(string);
			logger.info("Step: Text in search box entered as :" + string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("User entered spaces in search bar")
	public void user_entered_space_in_search_bar() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.Enterandremovespace();
			logger.info("Step: Text in search box entered as :" );
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	
	}
	
	@When("User removed entered spaces from the search box")
	public void user_removed_entered_spaces_from_the_search_box() {
		try {

			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			logger.info("Step: Searched text is removed from the search box");
			fp.BackspacetextinSearchBox("           ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	    
	}
	@When("User entered full site {string} name in search box")
	public void user_entered_full_site_name_in_search_box(String string) {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.enterTextInSearchBox().sendKeys(string);
			logger.info("Step: Text in search box entered as :" + string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	    
	}
	
	@When("User enter a full site name {string} without any space")
	public void user_enter_a_full_site_name_without_any_space(String string) {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			fp.enterTextInSearchBox().sendKeys(string);
			logger.info("Step: Text in search box entered as :" + string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	    
	}

	/*
	 * @Then("it is displaying a scroll bar on the right side") public void
	 * it_is_displaying_a_scroll_bar_in_right_side() throws IOException { try {
	 * LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	 * LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 * Assert.assertEquals(fp.getfacilityScrollbar(), true);
	 * logger.info("scroll bar" + fp.getfacilityScrollbar());
	 * screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(),
	 * LoginPage.driver); } catch (Exception e) {
	 * logger.error("Step: Caught exception:: " + e.toString()); exception = e; }
	 * 
	 * 
	 * }
	 */

}
