package stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.HelpInfoPage;
import pages.HistoryViewScreenPage;
import pages.ImagingLinksPage;
import pages.LoginPage;
import pages.SettingsPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_FacilityLinking_SSR1742_ImagingLinksScreenSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_FacilityLinking_SSR1742_ImagingLinksScreenSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
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

	@Then("check imaging links menu bar button")
	public void check_imaging_links_menu_button() {
		try {
			Assert.assertTrue(ilPage.checkImagingLinksButtonInLeftMenu());
			logger.info("Imaging links button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find imaging links button");
			exception = e;
    	}
	}

	@Then("check color of imaging links button in left menu bar")
	public void check_imaging_links_menu_color() {
		try {
			Assert.assertTrue(ilPage.checkImagingLinksButtonsColor());
			logger.info("The text in the left menu bar is the correct color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("The text in the left menu bar is the incorrect color");
			exception = e;
    	}
	}

	@Then("check imaging links page header")
	public void check_imaging_links_page_header() {
		try {
			ilPage.checkImagingLinksHeader();
			logger.info("Imaging links header is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Imaging links header is not displayed");
			exception = e;
    	}
	}

	@Then("check imaging links table header")
	public void check_imaging_links_table_header() {
		try {
			ilPage.checkImagingLinksTableHeader();
			logger.info("Imaging links table header is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Imaging links table header is not displayed");
			exception = e;
    	}
	}

	@Then("All table headers are displayed")
	public void check_all_table_headers() {
		try {
			Assert.assertTrue(ilPage.checkImagingLinksSiteTableHeader());
			Assert.assertTrue(ilPage.checkImagingLinksAddressTableHeader());
			Assert.assertTrue(ilPage.checkImagingLinksCityTableHeader());
			Assert.assertTrue(ilPage.checkImagingLinksContactTableHeader());
			Assert.assertTrue(ilPage.checkImagingLinksPhoneTableHeader());
			logger.info("All table headers are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Not all table headers are displayed");
			exception = e;
    	}
	}

	@Then("Check if the remove link button is displayed below the table")
	public void check_remove_link_button_at_bottom_of_table() {
		try {
			Assert.assertTrue(ilPage.checkRemoveLinkButtonAtBottomOfTable());
			logger.info("Remove link button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Remove link button is not displayed");
			exception = e;
    	}
	}

	@Then("Check if the create link button is displayed below the table")
	public void check_create_link_button_at_bottom_of_table() {
		try {
			Assert.assertTrue(ilPage.checkCreateLinkButtonAtBottomOfTable());
			logger.info("Create link button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Create link button is not displayed");
			exception = e;
    	}
	}

	@Then("The user clicks pin linked button in the top right")
	public void user_clicks_pin_linked_button() {
		try {
			ilPage.clickPinLinkedButton();
			logger.info("User clicked pin linked button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Could not click pin linked button");
			exception = e;
    	}
	}

	@Then("check pin linked button in the top right")
	public void check_pin_linked_button() {
		try {
			Assert.assertTrue(ilPage.checkPinLinkedButton());
			logger.info("Pin linked button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Pin linked button is not displayed");
			exception = e;
    	}
	}

	@Then("the arrows next to all table headers are displayed")
	public void check_table_header_arrows() {
		try {
			Assert.assertTrue(ilPage.checkTableSiteArrow());
			Assert.assertTrue(ilPage.checkTableAddressArrow());
			Assert.assertTrue(ilPage.checkTableCityArrow());
			Assert.assertTrue(ilPage.checkTableContactArrow());
			Assert.assertTrue(ilPage.checkTablePhoneArrow());
			logger.info("All table header arrows are displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Not all table header arrows are displayed");
			exception = e;
    	}
	}

	@Then("Search bar with search button is displayed")
	public void check_search_bar_and_button_in_imaging_links_page() {
		try {
			Assert.assertTrue(ilPage.checkSearchBarInImagingLinksPage());
			Assert.assertTrue(ilPage.checkSearchButtonInImagingLinksPage());
			logger.info("Search bar and button are not displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Search bar and button are not displayed");
			exception = e;
    	}
	}

	@Then("Check right side information on imaging links page")
	public void check_right_side_information() {
		try {
			Assert.assertTrue(ilPage.checkRightSideInfoName());
			Assert.assertTrue(ilPage.checkRightSideInfoAffiliation());
			Assert.assertTrue(ilPage.checkRightSideInfoAddress());
			Assert.assertTrue(ilPage.checkRightSideInfoContact());
			Assert.assertTrue(ilPage.checkRightSideInfoContactInfo());
			logger.info("Right side information is all displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Right side information is not all displayed");
			exception = e;
    	}
	}

	@Then("Check color of first entry in imaging links table")
	public void check_color_of_first_entry_in_table() {
		try {
			String color = ilPage.checkColorOfFirstEntry();
			logger.info("First entry color: " + color);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to get color");
			exception = e;
    	}
	}

	@Then("the user unlinks all facilities in image linking page table")
	public void user_unlinks_all_facilities() {
		try {
			ilPage.unlinkAllFacilitiesHAdmin();
			logger.info("User unlinked all facilities in image linking page table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to unlink all facilities");
			exception = e;
    	}
	}

	@Then("the user links one facility in imaging links page")
	public void user_links_one_facility() {
		try {
			ilPage.hadminLinkOneFacility();
			logger.info("User linked a facility");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to link facility");
			exception = e;
    	}
	}

	@Then("check search bar and search button snhil imaging links page")
	public void check_search_bar_and_search_button() {
		try {
			Assert.assertTrue(ilPage.checkSearchBarSNHILM());
			Assert.assertTrue(ilPage.checkSearchButtonSNHILM());
			logger.info("Search bar and button displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to find search bar or search button");
			exception = e;
    	}
	}

	@Then("check icon color on top site in table for hil manager")
	public void check_entry_icon_color() {
		try {
			String color = ilPage.getIconColorSNHIL();
			logger.info("Icon color is: " + color);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check icon color");
			exception = e;
    	}
	}

	@Then("check icon color on top site in table for hadmin")
	public void check_entry_icon_color_hadmin() {
		try {
			String color = ilPage.getIconColorHAdmin();
			logger.info("Icon color is: " + color);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check icon color");
			exception = e;
    	}
	}

	@Then("check that the create link button is disabled hadmin")
	public void check_create_link_button_disabled() {
		try {
			ilPage.clickFirstEntryInTableHadmin();
			Assert.assertTrue(ilPage.checkCreateLinkButtonHadmin());
			logger.info("Create link button is disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Create link button is not disbaled");
			exception = e;
    	}
	}

	@Then("check that the remove link button is disabled hadmin")
	public void check_remove_link_button_disabled() {
		try {
			ilPage.clickFirstEntryInTableHadmin();
			Assert.assertFalse(ilPage.checkRemoveLinkButtonHadmin());
			logger.info("Remove link button is disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Remove link button is not disbaled");
			exception = e;
    	}
	}

	@Then("Select upload files tab in left menu bar")
	public void select_upload_files_tab() {
		try {
			LoginPage.driver.switchTo().defaultContent();
			ilPage.clickUploadFilesSelection();
			logger.info("User selected upload files tab");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to select upload files tab");
			exception = e;
    	}
	}
	
	@Then("User clicks inactive facility in hospital admin imaging links table")
	public void user_clicks_inactive_facility_hospital_admin_imaging_links_table() {
		try {
			logger.info("User clicks inactive facility in hospital admin page");
			ilPage.clickInactiveFacilityHospitalAdmin();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click inactive facility");
			exception = e;
    	}
	}
	
	@Then("User clicks active facility in hospital admin imaging links table")
	public void user_clicks_active_facility_hospital_admin_imaging_links_table() {
		try {
			logger.info("User clicks active facility in hospital admin page");
			ilPage.clickActiveFacilityHospitalAdmin();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click active facility");
			exception = e;
    	}
	}
	
	@Then("HAdmin user clicks create link button at bottom of table")
	public void hadmin_user_clicks_create_link_button_bottom_of_table() {
		try {
			logger.info("Hadmin user clicks create link button");
			ilPage.clickCreateLinkButtonHadmin();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click create link button");
			exception = e;
    	}
	}
	
	@Then("HAdmin user clicks remove link button at bottom of table")
	public void hadmin_user_clicks_remove_link_button_bottom_of_table() {
		try {
			logger.info("Hadmin user clicks remove link button");
			ilPage.clickRemoveLinkButtonHadmin();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to click remove link button");
			exception = e;
    	}
	}
	
	@Then("check that the create link button is disabled hadmin table")
	public void check_create_link_button_disabled_hadmin() {
		try {
			Assert.assertFalse(ilPage.checkCreateLinkButtonDisabledHadmin());
			logger.info("Create link button is disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Create link button is not disbaled");
			exception = e;
    	}
	}
	
	@Then("Check if pinned facilities are at the top of the table")
	public void check_pinned_facilities_top_table() {
		try {
			logger.info("Pinned facilities are at the top of the table");
			ilPage.checkIfFacilityOrderIsPinned();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Unable to check table");
			exception = e;
    	}
	}
	
	@Then("check that the remove link button is disabled hadmin table")
	public void check_remove_link_button_disabled_table() {
		try {
			Assert.assertFalse(ilPage.checkRemoveLinkButtonHadmin());
			logger.info("Remove link button is disabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Remove link button is not disbaled");
			exception = e;
    	}
	}
}
