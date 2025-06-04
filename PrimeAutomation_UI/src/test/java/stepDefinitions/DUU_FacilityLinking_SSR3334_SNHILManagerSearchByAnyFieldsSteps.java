package stepDefinitions;

import static org.testng.Assert.assertTrue;

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

public class DUU_FacilityLinking_SSR3334_SNHILManagerSearchByAnyFieldsSteps {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR3334_SNHILManagerSearchByAnyFieldsSteps.class);
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
		@When("the user selects a facility type as {string} from the left table")
		public void the_user_selects_an_aorganization_of_facility_type_as_from_the_left_table(String string) {
			try {
				ilPage.selectFacilityTypeFromLeftTable(string);
				logger.info("Step: The user selected " +string+ " facility type from the left table");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters organization name in {string} as {string} in search bar of left table")
		public void the_user_enters_organization_name_in_as_in_search_bar_of_left_table(String string, String text) {
			try {
				ilPage.enterTextInLeftTableSearchbar(string, text);
				logger.info("Step: the user entered organization name in left table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user clicks on search button of left table")
		public void the_user_clicks_on_search_button_of_left_table() {
			try {
				ilPage.clickOnSearchButtonInLeftTable();
				logger.info("Step: The user clicked left table search button");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters address in {string} as {string} in search bar of left table")
		public void the_user_enters_address_in_as_in_search_bar_of_left_table(String string, String text) {
			try {
				ilPage.enterTextInLeftTableSearchbar(string, text);
				logger.info("Step: the user entered address in left table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters zipcode as {string} in search bar of left table")
		public void the_user_enters_zipcode_as_in_search_bar_of_left_table(String string) {
			try {
				ilPage.enterTextInLeftSearchbox(string);
				logger.info("Step: the user entered zipcode in left table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters city in {string} as {string} in search bar of left table")
		public void the_user_enters_city_in_as_in_search_bar_of_left_table(String string, String text) {
			try {
				ilPage.enterTextInLeftTableSearchbar(string, text);
				logger.info("Step: the user entered city in left table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters admin name in {string} as {string} in search bar of left table")
		public void the_user_enters_admin_name_in_as_in_search_bar_of_left_table(String string, String text) {
			try {
				ilPage.enterTextInLeftTableSearchbar(string, text);
				logger.info("Step: the user entered admin name in left table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters admin email as {string} in search bar of left table")
		public void the_user_enters_admin_email_in_as_in_search_bar_of_left_table(String string) {
			try {
				ilPage.enterTextInLeftSearchbox(string);
				logger.info("Step: the user entered admin email in left table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters admin phone number as {string} in search bar of left table")
		public void the_user_enters_admin_phone_number_in_as_in_search_bar_of_left_table(String string) {
			try {
				ilPage.enterTextInLeftSearchbox(string);
				logger.info("Step: the user entered phone number in left table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user clears the content of left search bar")
		public void the_user_clears_the_content_of_left_search_bar() {
			try {
				ilPage.clearTextFromLeftTableSearchbar();
				logger.info("Step: The user cleared the content of left table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user selects a facility provider from the right table")
		public void the_user_selects_a_facility_provider_from_the_right_table() {
			try {
				ilPage.selectFacilityFromRightTable();
				logger.info("Step: The user selected a facility from the right table");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters organization name in {string} as {string} in search bar of right table")
		public void the_user_enters_organization_name_in_as_in_search_bar_of_right_table(String string, String text) {
			try {
				ilPage.enterTextInRightTableSearchbar(string, text);
				logger.info("Step: the user entered organization name in right table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user clicks on search button of right table")
		public void the_user_clicks_on_search_button_of_right_table() {
			try {
				ilPage.clickOnSearchButtonInRightTable();
				logger.info("Step: The user clicked right table search button");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters address in {string} as {string} in search bar of right table")
		public void the_user_enters_address_in_as_in_search_bar_of_right_table(String string, String text) {
			try {
				ilPage.enterTextInRightTableSearchbar(string, text);
				logger.info("Step: the user entered address in right table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters zipcode as {string} in search bar of right table")
		public void the_user_enters_zipcode_as_in_search_bar_of_right_table(String string) {
			try {
				ilPage.enterTextInRightSearchbox(string);
				logger.info("Step: the user entered zipcode in right table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters city in {string} as {string} in search bar of right table")
		public void the_user_enters_city_in_as_in_search_bar_of_right_table(String string, String text) {
			try {
				ilPage.enterTextInRightTableSearchbar(string, text);
				logger.info("Step: the user entered city in right table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters admin name in {string} as {string} in search bar of right table")
		public void the_user_enters_admin_name_in_as_in_search_bar_of_right_table(String string, String text) {
			try {
				ilPage.enterTextInRightTableSearchbar(string, text);
				logger.info("Step: the user entered admin name in right table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters admin email as {string} in search bar of right table")
		public void the_user_enters_admin_email_as_in_search_bar_of_right_table(String string) {
			try {
				ilPage.enterTextInRightSearchbox(string);
				logger.info("Step: the user entered admin email in right table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters admin phone number as {string} in search bar of right table")
		public void the_user_enters_admin_phone_number_as_in_search_bar_of_right_table(String string) {
			try {
				ilPage.enterTextInRightSearchbox(string);
				logger.info("Step: the user entered phone number in right table search bar");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters test data as {string} in left table search bar")
		public void the_user_enters_test_data_as_in_left_table_search_bar(String string) {
			try {
				ilPage.enterTextInLeftSearchbox(string);
				logger.info("Step: the invalid test data is entered as : " +string);
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@When("the user enters test data as {string} in right table search bar")
		public void the_user_enters_test_data_as_in_right_table_search_bar(String string) {
			try {
				ilPage.enterTextInRightSearchbox(string);
				logger.info("Step: the invalid test data is entered as : " +string);
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		// *********************THEN BLOCK*******************************
		@Then("the selected facility shall be displayed in teal color")
		public void the_selected_facility_shall_be_displayed_in_teal_color() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(ilPage.isSelectedFacilityDisplayedInTealColor(),properties.getProperty("highlightedfacility.color"));
				logger.info("Step: The selected facility is displayed in teal color");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the details of selected provider shall be displayed as below")
		public void the_details_of_selected_provider_shall_be_displayed_as_below(List<Map<String, String>> dt) {
			try {
				List<Map<String, String>> list = dt;
				for (int i = 0; i <= list.size() - 1; i++) {
					if (list.get(i).get("provider").contains("organization name")) {
						Assert.assertTrue(ilPage.isProviderDetailsDisplayed("organization name").isDisplayed(),
								"organization name is not displayed.");
						logger.info("organization name is displayed.");
					}
					if (list.get(i).get("provider").contains("address")) {
						assertTrue(ilPage.isProviderDetailsDisplayed("address").isDisplayed(),
								"address is not displayed.");
						logger.info("address is displayed.");
					}
					if (list.get(i).get("provider").contains("admin name")) {
						assertTrue(ilPage.isProviderDetailsDisplayed("admin name").isDisplayed(),
								"admin name is not displayed.");
						logger.info("admin name is displayed.");
					}
					if (list.get(i).get("provider").contains("admin email")) {
						Assert.assertTrue(ilPage.isProviderDetailsDisplayed("admin email").isDisplayed(),
								"admin email is displayed.");
						logger.info("admin email is displayed.");
					}
					if (list.get(i).get("provider").contains("phone number")) {
						assertTrue(ilPage.isProviderDetailsDisplayed("phone number").isDisplayed(),
								"phone number is not displayed.");
						logger.info("phone number is displayed.");
					}
				}
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				Assert.fail("The provider details are not displayed");
				exception = e;
			}
		}
		
		@Then("the searched keyword results shall be displayed under all organizations")
		public void the_searched_keyword_results_shall_be_displayed_under_all_organizations() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(ilPage.getSearchedListUnderAllOrganization());
				logger.info("Step: The searched keyword is displayed under all organization table");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the right section table detials shall be displayed as below")
		public void the_right_section_table_detials_shall_be_displayed_as_below(List<Map<String, String>> dt) {
			try {
				List<Map<String, String>> list = dt;
				for (int i = 0; i <= list.size() - 1; i++) {
					if (list.get(i).get("section").contains("available provider")) {
						Assert.assertTrue(ilPage.isRightTableDetailsDisplayed("available provider").isDisplayed(),
								"available provider is not displayed.");
						logger.info("available provider is displayed.");
					}
					if (list.get(i).get("section").contains("toggle button")) {
						assertTrue(ilPage.isRightTableDetailsDisplayed("toggle button").isDisplayed(),
								"toggle button is not displayed.");
						logger.info("toggle button is displayed.");
					}
					if (list.get(i).get("section").contains("toggle button text")) {
						assertTrue(ilPage.isRightTableDetailsDisplayed("toggle button text").isDisplayed(),
								"toggle button text is not displayed.");
						logger.info("toggle button text is displayed.");
					}
					if (list.get(i).get("section").contains("search tab")) {
						Assert.assertTrue(ilPage.isRightTableDetailsDisplayed("search tab").isDisplayed(),
								"search tab is displayed.");
						logger.info("search tab is displayed.");
					}
					if (list.get(i).get("section").contains("search button")) {
						assertTrue(ilPage.isRightTableDetailsDisplayed("search button").isDisplayed(),
								"search button is not displayed.");
						logger.info("search button is displayed.");
					}
					if (list.get(i).get("section").contains("name of hospitals")) {
						assertTrue(ilPage.isRightTableDetailsDisplayed("name of hospitals").isDisplayed(),
								"Name of hospitals is not displayed.");
						logger.info("Name of hospitals is displayed.");
					}
//					if (list.get(i).get("section").contains("linked icon")) {
//						assertTrue(ilPage.isRightTableDetailsDisplayed("linked icon").isDisplayed(),
//								"Linked icon is not displayed.");
//						logger.info("Linked icon is displayed.");
//					}
					if (list.get(i).get("section").contains("unlinked icon")) {
						assertTrue(ilPage.isRightTableDetailsDisplayed("unlinked icon").isDisplayed(),
								"Unlinked icon is not displayed.");
						logger.info("Unlinked icon is displayed.");
					}
					if (list.get(i).get("section").contains("citystate")) {
						assertTrue(ilPage.isRightTableDetailsDisplayed("citystate").isDisplayed(),
								"City state is not displayed.");
						logger.info("City state is displayed.");
					}
					if (list.get(i).get("section").contains("contact number")) {
						assertTrue(ilPage.isRightTableDetailsDisplayed("contact number").isDisplayed(),
								"Contact number is not displayed.");
						logger.info("Contact number is displayed.");
					}
				}
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				Assert.fail("The provider details are not displayed");
				exception = e;
			}
		}
		
		@Then("the selected provider shall be displayed in teal color")
		public void the_selected_provider_shall_be_displayed_in_teal_color() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(ilPage.isSelectedFacilityProviderDisplayedInTealColor(),properties.getProperty("highlightedfacility.color"));
				logger.info("Step: The selected provider facility is displayed in teal color");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the details of selected provider from right table shall be displayed as below")
		public void the_details_of_selected_provider_from_right_table_shall_be_displayed_as_below(List<Map<String, String>> dt) {
			try {
				List<Map<String, String>> list = dt;
				for (int i = 0; i <= list.size() - 1; i++) {
					if (list.get(i).get("provider").contains("organization name")) {
						Assert.assertTrue(ilPage.isProviderDetailsFromRightTableDisplayed("organization name").isDisplayed(),
								"organization name is not displayed.");
						logger.info("organization name is displayed.");
					}
					if (list.get(i).get("provider").contains("address")) {
						assertTrue(ilPage.isProviderDetailsFromRightTableDisplayed("address").isDisplayed(),
								"address is not displayed.");
						logger.info("address is displayed.");
					}
					if (list.get(i).get("provider").contains("admin name")) {
						assertTrue(ilPage.isProviderDetailsFromRightTableDisplayed("admin name").isDisplayed(),
								"admin name is not displayed.");
						logger.info("admin name is displayed.");
					}
					if (list.get(i).get("provider").contains("admin email")) {
						Assert.assertTrue(ilPage.isProviderDetailsFromRightTableDisplayed("admin email").isDisplayed(),
								"admin email is displayed.");
						logger.info("admin email is displayed.");
					}
					if (list.get(i).get("provider").contains("phone number")) {
						assertTrue(ilPage.isProviderDetailsFromRightTableDisplayed("phone number").isDisplayed(),
								"phone number is not displayed.");
						logger.info("phone number is displayed.");
					}
				}
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				Assert.fail("The provider details are not displayed");
				exception = e;
			}
		}
		
		@Then("the searched keyword results shall be displayed under all provider")
		public void the_searched_keyword_results_shall_be_displayed_under_all_provider() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(ilPage.getSearchedListUnderAvailableProvider());
				logger.info("Step: The searched keyword is displayed in right table");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("The all organizations left table list {string} clicking search button")
		public void the_all_organizations_left_table_list_clicking_search_button(String string) {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(ilPage.getLeftTableList());
				logger.info("Step: The all organization left table list is displayed "+string+" clicking search button");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the message no data to display shall be displayed in left table")
		public void the_message_no_data_to_display_shall_be_displayed_in_left_table() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(ilPage.isNoDataToDisplayMessageDisplayedInLeftTable());
				logger.info("Step: The No data to display message is displayed in left table");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("The available provider right table list {string} clicking search button")
		public void the_available_provider_right_table_list_clicking_search_button(String string) {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(ilPage.getRightTableList());
				logger.info("Step: The available provider righ table list is displayed "+string+" clicking search button");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the message no data to display shall be displayed in right table")
		public void the_message_no_data_to_display_shall_be_displayed_in_right_table() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(ilPage.isNoDataToDisplayMessageDisplayedInRightTable());
				logger.info("Step: The No data to display message is displayed in right table");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}

}
