package stepDefinitions;

import java.time.Duration;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApplicationCardsPage;
import pages.LoginPage;
import pages.SurgeonListPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1720_ListedApplicationSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1720_ListedApplicationSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	ApplicationCardsPage ap = new ApplicationCardsPage();
	SurgeonListPage sp = new SurgeonListPage();

	@Then("List of Application Card associated with selected facility\\/surgeon is displayed")
	public void list_of_application_card_associated_with_selected_facility_surgeon_is_displayed() {
		try {
			ap = new ApplicationCardsPage();
			ap.applicationcardText();
			logger.info("Step: List of Application Card is displayed to the user");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Notification message should be displayed to user if no application card is present")
	public void notification_message_no_application_card_displayed_to_the_user() {
		try {
			ap = new ApplicationCardsPage();
			String msg = ap.getMessage();
			logger.info("Notification message is displayed as : " + msg);
			logger.info("Step : Notification message is displayed to user if no cards associated");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("Application card is displayed as not selected if there is more than one card")
	public void application_card_displayed_as_not_selected() {
		try {
			ap = new ApplicationCardsPage();
			ap.isNoCardSelectedByDefault();
			logger.info("Step : No application is displayed as selected by default");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("user doesn't select any card & verifies the Next button")
	public void user_doesnot_select_any_card_verifies_Next_button() {
		try {
			ap.isNextButtonEnabled();
			logger.info("Step : Next button is in disable state");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user selects one application card")
	public void user_selects_one_application_card() {
		try {
			ap.selectFirstAppCard();
			Thread.sleep(2000);
			ap.isCardSelectedByDefault();
			logger.info("Step : User selects the card and verifies other cards are selected or not");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	
	@When("user selects another application card")
	public void to_select_another_card() {
		try {
			ap.selectSecondAppCard();
			logger.info("Another Application card is selected other than previously selected card");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("verify other application card should be in unselected mode")
	public void verifies_user_not_able_to_select_multiple_cards() 
	{
		try {
			ap.isCardSelectedByDefault();
			logger.info("Step : User selects one card and verifies other cards are selected or not");
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
