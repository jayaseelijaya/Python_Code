
package stepDefinitions;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FacilityListPage;
import pages.LoginPage;
import pages.SurgeonListPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1803_SearchSurgeonSteps {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1803_SearchSurgeonSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	SurgeonListPage sp = new SurgeonListPage();

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
	@When("the user enters B text in search box")
	public void the_user_enters_B_text_in_search_box() {
		try {
			sp.enterTextInSurgeonSearchBox().sendKeys("B");
			logger.info("Step: Text in search box entered as B");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters D text in search box")
	public void the_user_enters_D_text_in_search_box() {
		try {
			sp.enterTextInSurgeonSearchBox().sendKeys("D");
			logger.info("Step: Text in search box entered as D");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters ac text in search box")
	public void the_user_enters_ac_text_in_search_box() {
		try {
			sp.enterTextInSurgeonSearchBox().sendKeys("ac");
			logger.info("Step: Text in search box entered as ac");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters ElizabethAnnDailey text in search box")
	public void the_user_enters_Michael_Fowler_text_in_search_box() {
		try {
			sp.enterTextInSurgeonSearchBox().sendKeys("ElizabethAnnDailey");
			;
			logger.info("Step: Text in search box entered as ElizabethAnnDailey");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	
	// *********************THEN BLOCK*******************************
		@Then("the surgeon search box shall be displayed")
		public void the_search_box_shall_be_displayed() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(sp.isSurgeonSearchBoxDisplayed());
				logger.info("Step: Surgeon search box is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the list shall display entered B text")
		public void the_list_shall_display_entered_B_text() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(sp.isListDisplayedBText());
				logger.info("Step: List is displayed matching B text surgeon records ");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}

		@Then("the list shall display entered D text")
		public void the_list_shall_display_entered_D_text() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(sp.isListDisplayedDText());
				logger.info("Step: List is displayed matching A text surgeon records");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}

		@Then("the list shall display entered ac text")
		public void the_list_shall_display_entered_ac_text() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertFalse(sp.isListDisplayedACText());
				logger.info("Step: No matching records ");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}

		@Then("the list shall display entered ElizabethAnnDailey text")
		public void the_list_shall_display_entered_ElizabethAnnDailey_text() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(sp.isListDisplayedExactSurgeon());
				logger.info("Step: List is displayed matching ElizabethAnnDailey text surgeon records ");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}

}
