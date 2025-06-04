package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuditLogPage;
import pages.FileDashboardPage;
import pages.ImagingLinksPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_FacilityLinking_SSR1743_SearchLinkedUnlinkedFacilitiesSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR1743_SearchLinkedUnlinkedFacilitiesSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	AuditLogPage alPage = new AuditLogPage();
	SelectedActivityPage saPage = new SelectedActivityPage();
	FileDashboardPage daPage = new FileDashboardPage();
	ImagingLinksPage ilPage = new ImagingLinksPage();

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
	@When("the user enters site name as {string} in search bar")
	public void the_user_enters_site_name_as_in_search_bar(String string) {
		try {
			ilPage.enterTextInSearchbox(string);
			logger.info("Step: the site name is entered as : " +string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on search button in facility linking")
	public void the_user_clicks_on_search_button_in_facility_linking() {
		try {
			ilPage.clickOnSearchButton();
			logger.info("Step: the user clicked search button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user enters address keyword as {string} in search bar")
	public void the_user_enters_address_keyword_as_in_search_bar(String string) {
		try {
			ilPage.enterTextInSearchbox(string);
			logger.info("Step: the address keyword is entered as : " +string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user enters city name as {string} in search bar")
	public void the_user_enters_city_name_as_in_search_bar(String string) {
		try {
			ilPage.enterTextInSearchbox(string);
			logger.info("Step: the city name is entered as : " +string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user enters contact name as {string} in search bar")
	public void the_user_enters_contact_name_as_in_search_bar(String string) {
		try {
			ilPage.enterTextInSearchbox(string);
			logger.info("Step: the address keyword is entered as : " +string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user enters phone number as {string} in search bar")
	public void the_user_enters_phone_number_as_in_search_bar(String string) {
		try {
			ilPage.enterTextInSearchbox(string);
			logger.info("Step: the address keyword is entered as : " +string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clears the content in search bar")
	public void the_user_clears_the_content_in_search_bar() {
		try {
			ilPage.removeContentFromSearchbox();
			logger.info("Step: the user removed content from searchbox ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user enters test data as {string} in search bar")
	public void the_user_enters_test_data_as_in_search_bar(String string) {
		try {
			ilPage.enterTextInSearchbox(string);
			logger.info("Step: the test data is entered as : " +string);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects an unlinked image center from the table")
	public void the_user_selects_an_unlinked_image_center_from_the_table() {
		try {
			ilPage.selectUnlinkedImageCenter();
			logger.info("Step: the user clicked unlinked image center");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects a linked image center from the table")
	public void the_user_selects_a_linked_image_center_from_the_table() {
		try {
			ilPage.selectLinkedImageCenter();
			logger.info("Step: the user clicked linked image center");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on toggle button")
	public void the_user_clicks_on_toggle_button() {
		try {
			ilPage.clickOnToggleButton();
			logger.info("Step: the user clicked on toggle button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	// *********************THEN BLOCK*******************************
	@Then("the following details shall be displayed on facility linking screen")
	public void the_following_details_shall_be_displayed_on_facility_linking_screen(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("details").contains("all available image center")) {
					Assert.assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("all available image center").isDisplayed(),
							"All available image center title is not displayed.");
					logger.info("All available image center title is displayed.");
				}
				if (list.get(i).get("details").contains("site")) {
					assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("site").isDisplayed(),
							"site column is not displayed.");
					logger.info("site column is displayed.");
				}
				if (list.get(i).get("details").contains("address")) {
					assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("address").isDisplayed(),
							"address column is not displayed.");
					logger.info("address column is displayed.");
				}
				if (list.get(i).get("details").contains("city state zipcode")) {
					Assert.assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("city state zipcode").isDisplayed(),
							"city state zipcode column is displayed.");
					logger.info("city state zipcode column is displayed.");
				}
				if (list.get(i).get("details").contains("contact")) {
					assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("contact").isDisplayed(),
							"contact column is not displayed.");
					logger.info("contact column is displayed.");
				}
				if (list.get(i).get("details").contains("phone number")) {
					assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("phone number").isDisplayed(),
							"phone number column is not displayed.");
					logger.info("phone number column is displayed.");
				}
				if (list.get(i).get("details").contains("remove link")) {
					Assert.assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("remove link").isDisplayed(),
							"remove link button is displayed.");
					logger.info("remove link button is displayed.");
				}
				if (list.get(i).get("details").contains("create link")) {
					Assert.assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("create link").isDisplayed(),
							"create link button is displayed.");
					logger.info("create link button is displayed.");
				}
				if (list.get(i).get("details").contains("search box")) {
					Assert.assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("search box").isDisplayed(),
							"search box is displayed.");
					logger.info("search box is displayed.");
				}
				if (list.get(i).get("details").contains("search button")) {
					Assert.assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("search button").isDisplayed(),
							"search button is displayed.");
					logger.info("search button is displayed.");
				}
				if (list.get(i).get("details").contains("toggle button")) {
					Assert.assertTrue(ilPage.isFacilityLinkingScreenDetailsDisplayed("toggle button").isDisplayed(),
							"toggle button is displayed.");
					logger.info("toggle button is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The facility linking details are not displayed");
			exception = e;
		}
	}
	
	@Then("the linked facilities shall be displayed in green color")
	public void the_linked_facilities_shall_be_displayed_in_green_color() {
		try {
			Properties properties = reader.getProperty();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(ilPage.isLinkedFacilitiesDisplayedInGreenColor(),properties.getProperty("linkedfacility.color"));
			logger.info("Step: The Linked facilities is displayed in green color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the unlinked facilities shall be displayed in white color")
	public void the_unlinked_facilities_shall_be_displayed_in_white_color() {
		try {
			Properties properties = reader.getProperty();
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(ilPage.isUnlinkedFacilitiesDisplayedInWhiteColor(),properties.getProperty("unlinkedfacility.color"));
			logger.info("Step: The Unlinked facilities is displayed in white color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the site matching with search criteria shall be displayed in the table")
	public void the_site_matching_with_search_criteria_shall_be_displayed_in_the_table() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(ilPage.getSearchedMatchingList());
			logger.info("Step: The site matching with search criteria is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the list of linked and unliked image center shall be displayed")
	public void the_list_of_linked_and_unliked_image_center_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(ilPage.getLinkedUnlinkedList());
			logger.info("Step: The linked and unlinked image center list is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("image linking table list {string} clicking search button")
	public void image_linking_table_list_clicking_search_button(String string) {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(ilPage.getImageLinkingTableList());
			logger.info("Step: The image linking table list is displayed "+string+ " clicking search button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the message no data to display shall be displayed")
	public void the_message_no_data_to_display_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(ilPage.isNoDataToDisplayMessageDisplayed());
			logger.info("Step: The No data to display message is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the search bar shall be displayed along with search icon")
	public void the_search_bar_shall_be_displayed_along_with_search_icon() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(ilPage.isSearchBoxDisplayed());
			logger.info("Step: The search bar is displayed along with search icon");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the selected image center shall be highlighted in green color")
	public void the_selected_image_center_shall_be_highlighted_in_green_color() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(ilPage.isSelectedImageCenterHighlighted());
			logger.info("Step: The selected image center is highlighted in green color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the following details shall be displayed at right section of the screen")
	public void the_following_details_shall_be_displayed_at_right_section_of_the_screen(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("section").contains("profile")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("profile").isDisplayed(),
							"The profile is not displayed.");
					logger.info("The profile is displayed.");
				}
				if (list.get(i).get("section").contains("image center details")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("image center details").isDisplayed(),
							"The image center details is not displayed.");
					logger.info("The image center details is displayed.");
				}
				if (list.get(i).get("section").contains("link inactive text")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("link inactive text").isDisplayed(),
							"The link inactive text is not displayed.");
					logger.info("The link inactive text is displayed.");
				}
				if (list.get(i).get("section").contains("link active text")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("link active text").isDisplayed(),
							"The link active text is not displayed.");
					logger.info("The link active text is displayed.");
				}
				if (list.get(i).get("section").contains("name")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("name").isDisplayed(),
							"The name is not displayed.");
					logger.info("The name is displayed.");
				}
				if (list.get(i).get("section").contains("name of selected imaging center")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("name of selected imaging center").isDisplayed(),
							"The name of selected imaging center is not displayed.");
					logger.info("The name of selected imaging center is displayed.");
				}
				if (list.get(i).get("section").contains("Affliation")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("Affliation").isDisplayed(),
							"The Affliation is not displayed.");
					logger.info("The Affliation is displayed.");
				}
				if (list.get(i).get("section").contains("name of selected organization")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("name of selected organization").isDisplayed(),
							"The name of selected organization is not displayed.");
					logger.info("The name of selected organization is displayed.");
				}
				if (list.get(i).get("section").contains("address")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("address").isDisplayed(),
							"The address is not displayed.");
					logger.info("The address is displayed.");
				}
				if (list.get(i).get("section").contains("address of selected imaging center")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("address of selected imaging center").isDisplayed(),
							"The address of selected imaging center is not displayed.");
					logger.info("The address of selected imaging center is displayed.");
				}
				if (list.get(i).get("section").contains("site contact")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("site contact").isDisplayed(),
							"The site contact is not displayed.");
					logger.info("The site contact is displayed.");
				}
				if (list.get(i).get("section").contains("contact information")) {
					assertTrue(ilPage.isImagingCenterDetailsDisplayed("contact information").isDisplayed(),
							"The contact information is not displayed.");
					logger.info("The contact information is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The browse pc screen components are not displayed");
			exception = e;
		}
	}
	
	@Then("the toggle button with text pin linked center to top shall be displayed and enabled")
	public void the_toggle_button_with_text_pin_linked_center_to_top_shall_be_displayed_and_enabled() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(ilPage.isToggleButtonDisplayed());
			logger.info("Step: The toggle button is displayed and enabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the toggle button shall be disabled")
	public void the_toggle_button_shall_be_disabled() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertFalse(ilPage.isToggleButtonDisabled());
			logger.info("Step: The toggle button is disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
}
