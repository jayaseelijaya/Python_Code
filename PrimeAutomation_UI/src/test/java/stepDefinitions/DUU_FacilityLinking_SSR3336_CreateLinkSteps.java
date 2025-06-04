package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
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
import pages.FacilityListPage;
import pages.ImagingLinksPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.SurgeonListPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_FacilityLinking_SSR3336_CreateLinkSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR3336_CreateLinkSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
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


	@Then("the Create or Modify Links screen is displayed")
	public void the_create_or_modify_links_screen_is_displayed() throws IOException {
		try {

			logger.info("Step: the Create or Modify Links screen is displayed");
			Assert.assertTrue(ilPage.isHeaderTextDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the Create or Modify Links header text in white color")
	public void the_create_or_modify_links_header_text_in_white_color() throws IOException {
		try {
			logger.info("Step: the Create or Modify Links header text in white color");
			Assert.assertTrue(ilPage.isHeaderTextDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the left section table of Imaging Links screen is displayed")
	public void the_left_section_table_of_imaging_links_screen_is_displayed(List<Map<String, String>> dt) throws IOException {
		try {
			logger.info("Step: the left section table of Imaging Links screen is displayed");
			List<Map<String, String>> list = dt;
			String header = "Items";
			for(Map<String, String> i:list ) {
				if(i.get(header).contains("All organizations")) {
					Assert.assertTrue(ilPage.isAllOrganizationsTextWhite());
					logger.info("All organizations text is displayed");
				}
				if(i.get(header).contains("Search tab")) {
					assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("search tab").isDisplayed());
					logger.info("Search bar is displayed");
				}
				if(i.get(header).contains("Enter keyword, Name of Facility or City")) {
					assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("search tab").isDisplayed());
					logger.info("Enter keyword, Name of Facility or City is in white color");
				}
				if(i.get(header).contains("Search Button")) {
					assertTrue(ilPage.isImagingLinkScreenElementsDisplayed("search button").isDisplayed());
					logger.info("Search button is displayed in green color");
				}
				if(i.get(header).contains("Name of the all the facilities")) {
					Assert.assertTrue(ilPage.isLeftTableContentsDisplayed());
					logger.info("Name of the all the facilities are diaplyed");
				}
				if(i.get(header).contains("Facility type")) {
					Assert.assertTrue(ilPage.isLeftTableContentsDisplayed());
					logger.info("Facility type are displayed");
				}
				if(i.get(header).contains("City, State of the facilities")){
					Assert.assertTrue(ilPage.isLeftTableContentsDisplayed());
					logger.info("City, State of the facilities are displayed");
				} 
				if(i.get(header).contains("Active status")) {
					Assert.assertTrue(ilPage.isLeftTableContentsDisplayed());
					logger.info("Active status of the facilities are displayed");
				}
				if(i.get(header).contains("Show more")) {
					Assert.assertTrue(ilPage.isShowMoreBtnDisplayed());
					logger.info("Show more button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects {string} from the left table which is in {string} status")
	public void the_user_selects_from_the_left_table_which_is_in_status(String string, String string2) throws IOException {
		try {
			String ssname = "the user selects "+string+" from the left table which is in "+string2+" status";
			logger.info("Step: " + ssname);
			ilPage.selectFromLeftTable(string, string2);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the selected facility is highlighted in the teal color rectangular box")
	public void the_selected_facility_is_highlighted_in_the_teal_color_rectangular_box() throws IOException {
		try {
			logger.info("Step: the selected facility is highlighted in the teal color rectangular box");
			Assert.assertTrue(ilPage.selectedRowIsHighlighted());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the following elements are displayed below the left table in white font")
	public void the_following_elements_are_displayed_below_the_left_table_in_white_font(List<Map<String, String>> dt) throws IOException {
		try {
			logger.info("Step: the following elements are displayed below the left table in white font");
			List<Map<String, String>> list = dt;
			String header = "elements";
			for(Map<String, String> i:list ) {
				if(i.get(header).contains("Imaging Facility Details text")) {
					Assert.assertTrue(ilPage.leftTableProviderDetailsText());
					logger.info("Imaging Facility Details text is Displayed");
				}
				if(i.get(header).contains("Provider Details text")) {
					Assert.assertTrue(ilPage.leftTableProviderDetailsText());
					logger.info("Provider Details text is Displayed");
				}
				if(i.get(header).contains("Name")) {
					Assert.assertTrue(ilPage.leftTableDetailsName());
					logger.info("Name is Displayed");
				}
				if(i.get(header).contains("Address")) {
					Assert.assertTrue(ilPage.leftTableDetailsAddress());
					logger.info("Address is Displayed");
				}
				if(i.get(header).contains("Admin")) {
					Assert.assertTrue(ilPage.leftTableDetailAdminName());
					logger.info("Admin Name is Displayed");
				}
				if(i.get(header).contains("Email")) {
					Assert.assertTrue(ilPage.leftTableDetailEmail());
					logger.info("Email is Displayed");
				}
				if(i.get(header).contains("Contact number")) {
					Assert.assertTrue(ilPage.leftTableDetailContactNumber());
					logger.info("Contact number is Displayed");
				}
				if(i.get(header).contains("Activate Site button Disabled")) {
					Assert.assertEquals(ilPage.btnState("Activate Site",false),false);
				}
				if(i.get(header).contains("Deactivate Site button Enabled")) {
					Assert.assertEquals(ilPage.btnState("Deactivate Site",true),true);
				}
				if(i.get(header).contains("Activate Site button Enabled")) {
					Assert.assertEquals(ilPage.btnState("Activate Site",true),true);
				}
				if(i.get(header).contains("Deactivate Site button Disabled")) {
					Assert.assertEquals(ilPage.btnState("Deactivate Site",false),false);
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the right section table of Imaging Links screen is displayed")
	public void the_right_section_table_of_imaging_links_screen_is_displayed(List<Map<String, String>> dt) throws IOException {
		try {
			logger.info("Step: the right section table of Imaging Links screen is displayed");
			List<Map<String, String>> list = dt;
			String header = "Items";
			for(Map<String, String> i:list ) {
				if(i.get(header).contains("Available Imaging Facilities text")) {
					Assert.assertTrue(ilPage.isAvailableprovidersTextDisplayed());
					logger.info("Available Imaging Facilities text is displayed");
				}
				if(i.get(header).contains("Available Providers header text")) {
					Assert.assertTrue(ilPage.isAvailableprovidersTextDisplayed());
					logger.info("Available Providers header text is displayed");
				}
				if(i.get(header).contains("Pin linked centers to top")) {
					Assert.assertTrue(ilPage.righttableToggleText());
					logger.info("Pin linked centers to top is displayed");
				}
				if(i.get(header).contains("Toggle button turned on")) {
					Assert.assertTrue(ilPage.righttableToggleBtnIsOn());
					logger.info("toggle button is on");
					screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
				}
				if(i.get(header).contains("Toggle button turned off")) {
					ilPage.clickrighttableToggleBtn();
					Assert.assertEquals(ilPage.righttableToggleBtnIsOn(),false);
					logger.info("toggle button is off");
					screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
				}
				if(i.get(header).contains("Search tab")) {
					Assert.assertTrue(ilPage.isRightTableSearchTabDisplayed());
					logger.info("search tab is displayed");
				}
				if(i.get(header).contains("Enter keyword, Name of Facility or City")) {
					Assert.assertTrue(ilPage.isRightTableSearchTabDisplayed());
					logger.info("Enter keyword, Name of Facility or City is displayed");
				}
				if(i.get(header).contains("Search Button")) {
					Assert.assertTrue(ilPage.isRighttableSearchBtnDisplayed());
					logger.info("search button is displayed");
				}
				if(i.get(header).contains("Name")) {
					Assert.assertTrue(ilPage.isRightTableContentsDisplayed());
					logger.info("Name is displayed");
				}
				if(i.get(header).contains("Link and delink icons")) {
					Assert.assertTrue(ilPage.isRightTableContentsDisplayed());
					logger.info("Link and delink icons is displayed");
				}
				if(i.get(header).contains("City and State")) {
					Assert.assertTrue(ilPage.isRightTableContentsDisplayed());
					logger.info("City and State is displayed");
				}
				if(i.get(header).contains("Contact number")) {
					Assert.assertTrue(ilPage.isRightTableContentsDisplayed());
					logger.info("Contact number is displayed");
				}
				if(i.get(header).contains("Show more")) {
					Assert.assertTrue(ilPage.isRighttableShowMoreBtnDisplayed());
					logger.info("Show more button is displayed");
				}
			}
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects {string} from the right table which is in {string} state")
	public void the_user_selects_from_the_right_table_which_is_in_state(String string, String string2) throws IOException, InterruptedException {
		try {
			String ssname = "the user selects " +string+" from the right table which is in "+string2+" state";
			logger.info("Step: " + ssname);
			ilPage.selectFromRightTable(string2);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the selected provider is highlighted in the teal color rectangular box")
	public void the_selected_provider_is_highlighted_in_the_teal_color_rectangular_box() throws IOException {
		try {
			logger.info("Step: the selected provider is highlighted in the teal color rectangular box");
			Assert.assertTrue(ilPage.isRightTableRowHighlighted());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the following elements are displayed below the right table in white font")
	public void the_following_elements_are_displayed_below_the_right_table_in_white_font(List<Map<String, String>> dt) throws IOException {
		try {
			logger.info("Step: the following elements are displayed below the right table in white font");
			List<Map<String, String>> list = dt;
			String header = "elements";
			for(Map<String, String> i:list ) {
				if(i.get(header).contains("Provider Details text")) {
					Assert.assertTrue(ilPage.rightTableProviderDetailsText());
					logger.info("Provider Details text is displayed");
				}
				if(i.get(header).contains("Name")) {
					Assert.assertTrue(ilPage.rightTableDetailsName());
					logger.info("Name is displayed");
				}
				if(i.get(header).contains("Address")) {
					Assert.assertTrue(ilPage.rightTableDetailsAddress());
					logger.info("Address is displayed");
				}
				if(i.get(header).contains("Admin")) {
					Assert.assertTrue(ilPage.rightTableDetailAdminName());
					logger.info("Admin Name is displayed");
				}
				if(i.get(header).contains("Website")) {
					Assert.assertTrue(ilPage.rightTableDetailEmail());
					logger.info("Website is displayed");
				}
				if(i.get(header).contains("Contact number")) {
					Assert.assertTrue(ilPage.rightTableDetailContactNumber());
					logger.info("Contact number is displayed");
				}
				if(i.get(header).contains("Create Link button Disabled")) {
					Assert.assertEquals(ilPage.btnState("Create Link",false),false);
					logger.info("Create Link button Disabled");
				}
				if(i.get(header).contains("Remove Link button Enabled")) {
					Assert.assertEquals(ilPage.btnState("Remove Link",true),true);
					logger.info("Remove Link button  Enabled");
				}
				if(i.get(header).contains("Create Link button Enabled")) {
					Assert.assertEquals(ilPage.btnState("Create Link",true),true);
					logger.info("Create Link button Enabled");
				}
				if(i.get(header).contains("Remove Link button Disabled")) {
					Assert.assertEquals(ilPage.btnState("Remove Link",false),false);
					logger.info("Remove Link button Disabled");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}


	@Then("Highlighted Hospital details and the status are displayed under {string} details")
	public void highlighted_hospital_details_and_the_status_are_displayed_under_details(String string) throws IOException {
		try {
			String ssname = "Highlighted Hospital details and the status are displayed under "+string+" details";
			logger.info("Step: " + ssname);
			Assert.assertTrue(ilPage.lefttableDetailsAreDisplayed());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("Linked facility is displayed with link icon highlighted in Green color")
	public void linked_facility_is_displayed_with_link_icon_highlighted_in_green_color() throws IOException {
		try {
			logger.info("Step: Linked facility is displayed with link icon highlighted in Green color");
			Assert.assertTrue(ilPage.rightTableContentsLinkIconDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Unlinked facility is displayed with stroked link icon highlighted in white color")
	public void unlinked_facility_is_displayed_with_stroked_link_icon_highlighted_in_white_color() throws IOException {
		try {
			logger.info("Step: Unlinked facility is displayed with stroked link icon highlighted in white color");
			Assert.assertTrue(ilPage.rightTableContentsUnlinkIconDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the Activate Site and Deactivate site buttons are available under {string} details")
	public void the_activate_site_and_deactivate_site_buttons_are_available_under_provider_details(String string) throws IOException {
		try {
			String ssname = "the Activate Site and Deactivate site buttons are available under "+string+" details";
			logger.info("Step: " + ssname);
			Assert.assertTrue(ilPage.activateSiteAndDeactivateSiteBtnsDisplayed());
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("{string} button is enabled")
	public void button_is_enabled(String string) throws IOException {
		try {
			String ssname = string+" button is enabled";
			logger.info("Step: " + ssname);
			Assert.assertEquals(ilPage.btnState(string,true),true);
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on {string} button")
	public void the_user_clicks_on_button(String string) throws IOException {
		try {
			String ssname = "the user clicks on "+string+" button";
			logger.info("Step: " + ssname);
			if(string.equalsIgnoreCase("Activate Site")) {
				ilPage.clickActivateSite();
			}
			else {
				ilPage.clickDeactivateSite();
			}
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("{string} status is changed to {string} within the table and highlighted in green color")
	public void hospital_status_is_changed_to_inactive_within_the_table_and_highlighted_in_green_color(String string,String string2) throws IOException {
		try {
			String ssname = string+" status is changed to "+string2+" within the table and highlighted in green color";
			logger.info("Step: " + ssname);
			logger.info("$$$$$$$$"+string2);
			Assert.assertTrue(ilPage.selectedRowStatus(string2));
			screenshot.screenshot(ssname, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Highlighted Image center details and the status are displayed under Imaging Facility details")
	public void highlighted_image_center_details_and_the_status_are_displayed_under_imaging_facility_details() throws IOException {
		try {
			logger.info("Step: Highlighted Image center details and the status are displayed under Imaging Facility details");
			Assert.assertTrue(ilPage.lefttableDetailsAreDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("The user clicks the create link button under the right table")
	public void user_clicks_create_link_button_under_right_table() {
		try {
			ilPage.clickCreateLinkButtonUnderRightTable();
			logger.info("User clicks create link button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click create link button");
			exception = e;
		}
	}
	
	@Then("the user clicks the fourth entry in the right side table")
	public void user_clicks_fourth_entry_right_side_table() {
		try {
			logger.info("User clicks fourth entry in the right side table");
			ilPage.clickFourthEntryRightTable();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click fourth entry");
			exception = e;
		}
	}

}
