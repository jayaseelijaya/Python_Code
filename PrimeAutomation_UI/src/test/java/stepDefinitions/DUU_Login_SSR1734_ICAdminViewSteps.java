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
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_Login_SSR1734_ICAdminViewSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_Login_SSR1734_ICAdminViewSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	UserInformationPage up = new UserInformationPage();
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
	//*********************When**********************
	@When("the user clicks on software information icon from left menu bar")
	public void the_user_clicks_on_software_information_icon_from_left_menu_bar() {
		try {
			up.clickOnSoftwareInformationIcon();
			logger.info("The software information icon is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user click on cross button")
	public void the_user_click_on_cross_button() {
		try {
			up.clickOnCrossButton();
			logger.info("The Cross button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	//*********************Then**********************
	@Then("the heading Smith and Nephew shall be displayed at the top left side in orange color")
	public void the_heading_smith_and_nephew_shall_be_displayed_at_the_top_left_side_in_orange_color() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(up.isSmithNephewHeadingDisplayed());
			logger.info("Step: The Smith and Nephew heading is displayed in orange color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the following components shall be displayed on right side of upload dashboard")
	public void the_below_components_shall_be_displayed_on_browse_pc_screen(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("dashboard").contains("dashboard heading")) {
					Assert.assertTrue(up.isUploadDashboardComponentsDisplayed("dashboard heading").isDisplayed(), 
							"Upload dashboard heading is not displayed");
					logger.info("Upload dashboard heading is displayed");
				}
				if (list.get(i).get("dashboard").contains("uploaded records table")) {
					assertTrue(up.isUploadDashboardComponentsDisplayed("uploaded records table").isDisplayed(),
							"uploaded records table is not displayed.");
					logger.info("uploaded records table is displayed.");
				}
				if (list.get(i).get("dashboard").contains("processing status checkbox")) {
					assertTrue(up.isUploadDashboardComponentsDisplayed("processing status checkbox").isDisplayed(),
							"processing status checkbox is not displayed.");
					logger.info("processing status checkbox is displayed.");
				}
				if (list.get(i).get("dashboard").contains("uploaded status checkbox")) {
					Assert.assertTrue(up.isUploadDashboardComponentsDisplayed("uploaded status checkbox").isDisplayed(),
							"uploaded status checkbox is not displayed");
					logger.info("uploaded status checkbox is displayed.");
				}
				if (list.get(i).get("dashboard").contains("complete status checkbox")) {
					assertTrue(up.isUploadDashboardComponentsDisplayed("complete status checkbox").isDisplayed(),
							"complete status checkbox is not displayed.");
					logger.info("complete status checkbox is displayed.");
				}
				if (list.get(i).get("dashboard").contains("error status checkbox")) {
					assertTrue(up.isUploadDashboardComponentsDisplayed("error status checkbox").isDisplayed(),
							"error status checkbox is not displayed.");
					logger.info("error status checkbox is displayed.");
				}
				if (list.get(i).get("dashboard").contains("24hrs checkbox")) {
					assertTrue(
							up.isUploadDashboardComponentsDisplayed("24hrs checkbox").isDisplayed(),
							"24hrs checkbox is not displayed");
					logger.info("24hrs checkbox is displayed.");
				}
				if (list.get(i).get("dashboard").contains("filter")) {
					assertTrue(up.isUploadDashboardComponentsDisplayed("filter").isDisplayed(),
							"filter is not displayed.");
					logger.info("filter is displayed.");
				}
				if (list.get(i).get("dashboard").contains("search box")) {
					assertTrue(up.isUploadDashboardComponentsDisplayed("search box").isDisplayed(),
							"search box is not displayed.");
					logger.info("search box is displayed.");
				}
				if (list.get(i).get("dashboard").contains("search button")) {
					assertTrue(up.isUploadDashboardComponentsDisplayed("search button").isDisplayed(),
							"search buttonis not displayed.");
					logger.info("search button is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The Upload dashboard components are not displayed");
			exception = e;
		}
	}
	
	@Then("the following components shall be displayed on right side of upload files")
	public void the_following_components_shall_be_displayed_on_right_side_of_upload_files(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("upload").contains("upload files heading")) {
					Assert.assertTrue(up.isUploadFilesComponentsDisplayed("upload files heading").isDisplayed(), 
							"upload files heading is not displayed");
					logger.info("upload files heading is displayed");
				}
				if (list.get(i).get("upload").contains("upload icon")) {
					assertTrue(up.isUploadFilesComponentsDisplayed("upload icon").isDisplayed(),
							"upload icon is not displayed.");
					logger.info("upload icon is displayed.");
				}
				if (list.get(i).get("upload").contains("upload button")) {
					assertTrue(up.isUploadFilesComponentsDisplayed("upload button").isDisplayed(),
							"upload button is not displayed.");
					logger.info("upload button is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The Upload files components are not displayed");
			exception = e;
		}
	}
	
	@Then("the following components shall be displayed on right side of upload status")
	public void the_following_components_shall_be_displayed_on_right_side_of_upload_status(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("status").contains("upload status heading")) {
					Assert.assertTrue(up.isUploadStatusComponentsDisplayed("upload status heading").isDisplayed(), 
							"upload status heading is not displayed");
					logger.info("upload status heading is displayed");
				}
				if (list.get(i).get("status").contains("uploaded records table")) {
					assertTrue(up.isUploadStatusComponentsDisplayed("uploaded records table").isDisplayed(),
							"uploaded records table is not displayed.");
					logger.info("uploaded records table is displayed.");
				}
				if (list.get(i).get("status").contains("view details buttom")) {
					assertTrue(up.isUploadStatusComponentsDisplayed("view details buttom").isDisplayed(),
							"view details buttom is not displayed.");
					logger.info("view details buttom is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The Upload status components are not displayed");
			exception = e;
		}
	}
	
	@Then("the following components shall be displayed on right side of history")
	public void the_following_components_shall_be_displayed_on_right_side_of_history(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("history").contains("history heading")) {
					Assert.assertTrue(up.isHistoryComponentsDisplayed("history heading").isDisplayed(), 
							"history heading is not displayed");
					logger.info("history heading is displayed");
				}
				if (list.get(i).get("history").contains("24hrs checkbox")) {
					assertTrue(up.isHistoryComponentsDisplayed("24hrs checkbox").isDisplayed(),
							"24hrs checkbox is not displayed.");
					logger.info("24hrs checkbox is displayed.");
				}
				if (list.get(i).get("history").contains("filter")) {
					assertTrue(up.isHistoryComponentsDisplayed("filter").isDisplayed(),
							"filter is not displayed.");
					logger.info("filter is displayed.");
				}
				if (list.get(i).get("history").contains("search textbox")) {
					Assert.assertTrue(up.isHistoryComponentsDisplayed("search textbox").isDisplayed(),
							"search textbox is not displayed");
					logger.info("search textbox is displayed.");
				}
				if (list.get(i).get("history").contains("search button")) {
					assertTrue(up.isHistoryComponentsDisplayed("search button").isDisplayed(),
							"search button is not displayed.");
					logger.info("search button is displayed.");
				}
				if (list.get(i).get("history").contains("record table")) {
					assertTrue(up.isHistoryComponentsDisplayed("record table").isDisplayed(),
							"record table is not displayed.");
					logger.info("record table is displayed.");
				}
				if (list.get(i).get("history").contains("view details button")) {
					assertTrue(
							up.isHistoryComponentsDisplayed("view details button").isDisplayed(),
							"view details button is not displayed");
					logger.info("view details button is displayed.");
				}
				if (list.get(i).get("history").contains("show more")) {
					assertTrue(up.isHistoryComponentsDisplayed("show more").isDisplayed(),
							"show more is not displayed.");
					logger.info("show more is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The History components are not displayed");
			exception = e;
		}
	}
	
	@Then("the following components shall be displayed on right side of audit log")
	public void the_following_components_shall_be_displayed_on_right_side_of_audit_log(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("audit").contains("audit log heading")) {
					Assert.assertTrue(up.isAuditLogComponentsDisplayed("audit log heading").isDisplayed(), 
							"audit log heading is not displayed");
					logger.info("audit log heading is displayed");
				}
				if (list.get(i).get("audit").contains("24hrs checkbox")) {
					assertTrue(up.isAuditLogComponentsDisplayed("24hrs checkbox").isDisplayed(),
							"24hrs checkbox is not displayed.");
					logger.info("24hrs checkbox is displayed.");
				}
				if (list.get(i).get("audit").contains("filter")) {
					assertTrue(up.isAuditLogComponentsDisplayed("filter").isDisplayed(),
							"filter is not displayed.");
					logger.info("filter is displayed.");
				}
				if (list.get(i).get("audit").contains("search textbox")) {
					Assert.assertTrue(up.isAuditLogComponentsDisplayed("search textbox").isDisplayed(),
							"search textbox is not displayed");
					logger.info("search textbox is displayed.");
				}
				if (list.get(i).get("audit").contains("search button")) {
					assertTrue(up.isAuditLogComponentsDisplayed("search button").isDisplayed(),
							"csearch button is not displayed.");
					logger.info("search button is displayed.");
				}
				if (list.get(i).get("audit").contains("audit log list table")) {
					assertTrue(up.isAuditLogComponentsDisplayed("audit log list table").isDisplayed(),
							"audit log list table is not displayed.");
					logger.info("audit log list table is displayed.");
				}
				if (list.get(i).get("audit").contains("exported selected")) {
					assertTrue(
							up.isAuditLogComponentsDisplayed("exported selected").isDisplayed(),
							"exported selected is not displayed");
					logger.info("exported selected is displayed.");
				}
				if (list.get(i).get("audit").contains("exported all")) {
					assertTrue(up.isAuditLogComponentsDisplayed("exported all").isDisplayed(),
							"exported all is not displayed.");
					logger.info("exported all is displayed.");
				}
				if (list.get(i).get("audit").contains("show more")) {
					assertTrue(up.isAuditLogComponentsDisplayed("show more").isDisplayed(),
							"show more is not displayed.");
					logger.info("show more is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The auditlog components are not displayed");
			exception = e;
		}
	}
	
	@Then("the following components shall be displayed on right side of imaging links")
	public void the_following_components_shall_be_displayed_on_right_side_of_imaging_links(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("imaging").contains("list of linked facilities")) {
					Assert.assertTrue(up.isImagingComponentsDisplayed("list of linked facilities").isDisplayed(), 
							"list of linked facilities is not displayed");
					logger.info("list of linked facilities is displayed");
				}
				if (list.get(i).get("imaging").contains("remove button")) {
					Assert.assertTrue(up.isImagingComponentsDisplayed("remove button").isDisplayed(),
							"remove button is not displayed.");
					logger.info("remove button is displayed.");
				}
				if (list.get(i).get("imaging").contains("Provider Links")) {
					Assert.assertTrue(ilPage.checkImagingLinksHeader());
					logger.info("Provider links header is displayed");
				}
				if (list.get(i).get("imaging").contains("Imaging links")) {
					Assert.assertTrue(ilPage.checkImagingLinksHeader());
					logger.info("Imaging links header is displayed");
				}
				if (list.get(i).get("imaging").contains("search textbox")) {
					Assert.assertTrue(ilPage.checkSearchBarInImagingLinksPage());
					logger.info("search textbox is displayed");
				}
				if (list.get(i).get("imaging").contains("search button")) {
					Assert.assertTrue(ilPage.checkSearchButtonInImagingLinksPage());
					logger.info("search button is displayed");
				}
				if (list.get(i).get("imaging").contains("Provider details")) {
					Assert.assertTrue(ilPage.isProviderDetailsDisplayed());
					logger.info("Provider details is displayed");
				}
				if (list.get(i).get("imaging").contains("Pin linked centers to top toggle button")) {
					Assert.assertTrue(ilPage.isToggleButtonDisplayed());
					logger.info("Pin linked centers to top toggle button is displayed");
				}
				if (list.get(i).get("imaging").contains("create button")) {
					Assert.assertTrue(up.isImagingComponentsDisplayed("create button").isDisplayed());
					logger.info("create link button is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The Imaging components are not displayed");
			exception = e;
		}
	}
	
	@Then("the following components shall be displayed on right side of settings")
	public void the_following_components_shall_be_displayed_on_right_side_of_settings(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("settings").contains("heading")) {
					Assert.assertTrue(up.isSettingsComponentsDisplayed("heading").isDisplayed(), 
							"heading is not displayed");
					logger.info("heading is displayed");
				}
				if (list.get(i).get("settings").contains("successful expiration")) {
					Assert.assertTrue(up.isSettingsComponentsDisplayed("successful expiration").isDisplayed(), 
							"successful expiration is not displayed");
					logger.info("successful expiration is displayed");
				}
				if (list.get(i).get("settings").contains("unsuccessful expiration")) {
					assertTrue(up.isSettingsComponentsDisplayed("unsuccessful expiration").isDisplayed(),
							"unsuccessful expiration is not displayed.");
					logger.info("unsuccessful expiration is displayed.");
				}
				if (list.get(i).get("settings").contains("global viewing toggle button")) {
					assertTrue(up.isSettingsComponentsDisplayed("global viewing toggle button").isDisplayed(),
							"global viewing toggle button is not displayed.");
					logger.info("global viewing toggle button is displayed.");
				}
				if (list.get(i).get("settings").contains("reset to default")) {
					assertTrue(up.isSettingsComponentsDisplayed("reset to default").isDisplayed(),
							"reset to default is not displayed.");
					logger.info("reset to default is displayed.");
				}
				if (list.get(i).get("settings").contains("save button")) {
					assertTrue(up.isSettingsComponentsDisplayed("save button").isDisplayed(),
							"save button is not displayed.");
					logger.info("save button is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The Imaging components are not displayed");
			exception = e;
		}
	}
	
	@Then("the software information popup shall be displayed")
	public void the_software_information_popup_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(up.isSoftwareInformationPopupDisplayed());
			logger.info("Step: the software information popup box is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the software version details shall be displayed")
	public void the_software_version_details_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(up.isSoftwareVersionDisplayed());
			logger.info("Step: software version details is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the cross button shall be displayed")
	public void the_cross_button_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(up.isCrossButtonDisplayed());
			logger.info("Step: the cross button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the following components shall be displayed on imaging links screen")
	public void the_following_components_shall_be_displayed_on_imaging_links_screen(List<Map<String, String>> dt) {
		try {
			logger.info("Step: the following components shall be displayed on imaging links screen");
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("imaging").contains("Create or Modify links")) {
					Assert.assertTrue(ilPage.isHeaderTextDisplayed());
					logger.info("Create or Modify links header is displayed");
				}
				if (list.get(i).get("imaging").contains("Two tables for Providers and Imaging centers")) {
					Assert.assertTrue(ilPage.isLeftTableDisplayed());
					Assert.assertTrue(ilPage.isRightTableDisplayed());
					logger.info("Two tables is displayed");
				}
				if (list.get(i).get("imaging").contains("Provider table")) {
					Assert.assertTrue(ilPage.isLeftTableDisplayed());
					logger.info("Provider table is displayed");
				}
				if (list.get(i).get("imaging").contains("All Organization heading")) {
					Assert.assertTrue(ilPage.checkAllOrganizationHeader());
					logger.info("All Organization heading is displayed");
				}
				if (list.get(i).get("imaging").contains("search textbox")) {
					Assert.assertTrue(ilPage.checkSearchBarSNHILM());
					Assert.assertTrue(ilPage.isRightTableSearchTabDisplayed());
					logger.info("search textbox is displayed");
				}
				if (list.get(i).get("imaging").contains("search button")) {
					Assert.assertTrue(ilPage.checkSearchButtonSNHILM());
					Assert.assertTrue(ilPage.isRighttableSearchBtnDisplayed());
					logger.info("search button is displayed");
				}
				if (list.get(i).get("imaging").contains("List registered organizations")) {
					Assert.assertTrue(ilPage.isListOfOrganizationsDisplayed());
					logger.info("List registered organizations is displayed");
				}
				if (list.get(i).get("imaging").contains("Provider details of the 1st provider")) {
					Assert.assertTrue(ilPage.isProviderDatailsShownForHilManager());
					logger.info("Provider details of the 1st provider is displayed");
				}
				if (list.get(i).get("imaging").contains("Activate Site")) {
					Assert.assertTrue(ilPage.checkActivateSiteButton());
					logger.info("Activate Site is displayed");
				}
				if (list.get(i).get("imaging").contains("Deactivate Site")) {
					Assert.assertTrue(ilPage.checkDeactivateSiteButton());
					logger.info("Deactivate Site is displayed");
				}
				if (list.get(i).get("imaging").contains("Imaging center table")) {
					Assert.assertTrue(ilPage.isRightTableDisplayed());
					logger.info("Imaging center table is displayed");
				}
				if (list.get(i).get("imaging").contains("Pin linked centers to top toggle button")) {
					Assert.assertTrue(ilPage.isToggleButtonDisplayed());
					logger.info("Pin linked centers to top toggle button is displayed");
				}
				if (list.get(i).get("imaging").contains("List of linked and unlinked facilities")) {
					Assert.assertTrue(ilPage.isRightTableDisplayed());
					logger.info("List of linked Imaging centers is displayed");
				}
				if (list.get(i).get("imaging").contains("facility details of 1st record")) {
					Assert.assertTrue(ilPage.isFacilityDatailsShownForHilManager());
					logger.info("Imaging center details of 1st record is displayed");
				}
				if (list.get(i).get("imaging").contains("remove button")) {
					Assert.assertTrue(ilPage.checkRemoveLinkButtonRightTable(),
							"remove button is not displayed.");
					logger.info("remove button is displayed");
				}
				if (list.get(i).get("imaging").contains("create button")) {
					Assert.assertTrue(ilPage.checkCreateLinkButtonRightTable());
					logger.info("create button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The Imaging components are not displayed");
			exception = e;
		}
	}
	
}
