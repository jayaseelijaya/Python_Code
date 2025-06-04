
package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FacilityListPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.SurgeonListPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1807_SelectedActivitySteps {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1807_SelectedActivitySteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SurgeonListPage sp = new SurgeonListPage();
	FacilityListPage fp = new FacilityListPage();
	UserInformationPage userPage = new UserInformationPage();
	SelectedActivityPage saPage = new SelectedActivityPage();
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
	@When("the user clicks on dashbaord button from left menu bar")
	public void the_user_clicks_on_dashbaord_button_from_left_menu_bar() {
		try {
			saPage.clickOnDashboardButton();
			logger.info("Step: the dashboard button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on upload status button from left menu bar")
	public void the_user_clicks_on_upload_status_button_from_left_menu_bar() {
		try {
			saPage.clickOnUploadStatusButton();
			logger.info("Step: the upload status button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on history button from left menu bar")
	public void the_user_clicks_on_history_button_from_left_menu_bar() {
		try {
			saPage.clickOnHistoryButton();
			logger.info("Step: the history button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on audit log button from left menu bar")
	public void the_user_clicks_on_audit_log_button_from_left_menu_bar() {
		try {
			saPage.clickOnAuditLogButton();
			logger.info("Step: the Audit Log button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on imaging links button from left menu bar")
	public void the_user_clicks_on_imaging_links_button_from_left_menu_bar() {
		try {
			saPage.clickOnImagingLinksButton();
			logger.info("Step: the Imaging links button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on settings button from left menu bar")
	public void the_user_clicks_on_settings_button_from_left_menu_bar() {
		try {
			saPage.clickOnSettingsButton();
			logger.info("Step: the Settings button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on exit to app button from left menu bar")
	public void the_user_clicks_on_exit_to_app_button_from_left_menu_bar() {
		try {
			saPage.clickOnExitToAppButton();
			logger.info("Step: the Exit To App button is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	// *********************THEN BLOCK*******************************
		@Then("the dashbaord shall be higlighted in left menu bar")
		public void the_dashbaord_shall_be_higlighted_in_left_menu_bar() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(saPage.isDashboardHighlighted(),properties.getProperty("selectedtab.color"));
				logger.info("Step: dashboard button is highlighted");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the right side header shall be displayed as upload dashboard")
		public void the_right_side_header_shall_be_displayed_as_upload_dashboard() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(saPage.isDashboardHeaderDisplayed());
				logger.info("Step: Right side header is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the upload files shall be higlighted in left menu bar")
		public void the_upload_files_shall_be_higlighted_in_left_menu_bar() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(saPage.isUploadFilesHighlighted(),properties.getProperty("selectedtab.color"));
				logger.info("Step: Upload files button is highlighted");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the right side header shall be displayed as upload files")
		public void the_right_side_header_shall_be_displayed_as_upload_files() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(saPage.isUploadFilesHeaderDisplayed());
				logger.info("Step: Upload files header is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the upload status shall be higlighted in left menu bar")
		public void the_upload_status_shall_be_higlighted_in_left_menu_bar() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(saPage.isUploadStatusHighlighted(),properties.getProperty("selectedtab.color"));
				logger.info("Step: Upload status button is highlighted");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the right side header shall be displayed as upload status")
		public void the_right_side_header_shall_be_displayed_as_upload_status() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(saPage.isUploadStatusHeaderDisplayed());
				logger.info("Step: Upload status header is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the history shall be higlighted in left menu bar")
		public void the_history_shall_be_higlighted_in_left_menu_bar() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(saPage.isHistoryHighlighted(),properties.getProperty("selectedtab.color"));
				logger.info("Step: History button is highlighted");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the right side header shall be displayed as history")
		public void the_right_side_header_shall_be_displayed_as_history() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(saPage.isHistoryHeaderDisplayed());
				logger.info("Step: History header is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the audit log shall be higlighted in left menu bar")
		public void the_audit_log_shall_be_higlighted_in_left_menu_bar() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(saPage.isAuditLogHighlighted(),properties.getProperty("selectedtab.color"));
				logger.info("Step: Audit Log button is highlighted");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the right side header shall be displayed as audit log")
		public void the_right_side_header_shall_be_displayed_as_audit_log() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(saPage.isAuditLogHeaderDisplayed());
				logger.info("Step: Audit Log header is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the imaging links shall be higlighted in left menu bar")
		public void the_imaging_links_shall_be_higlighted_in_left_menu_bar() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(saPage.isImagingLinksHighlighted(),properties.getProperty("selectedtab.color"));
				logger.info("Step: Imaging Links button is highlighted");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the right side header shall be displayed as provider links")
		public void the_right_side_header_shall_be_displayed_as_provider_links() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(saPage.isImagingLinksHeaderDisplayed());
				logger.info("Step: Imaging links header is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the settings shall be higlighted in left menu bar")
		public void the_settings_shall_be_higlighted_in_left_menu_bar() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(saPage.isSettingsHighlighted(),properties.getProperty("selectedtab.color"));
				logger.info("Step: Settings button is highlighted");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the right side header shall be displayed as settings")
		public void the_right_side_header_shall_be_displayed_as_settings() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(saPage.isSettingsHeaderDisplayed());
				logger.info("Step: Settings header is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the exit to app shall be higlighted in left menu bar")
		public void the_exit_to_app_shall_be_higlighted_in_left_menu_bar() {
			try {
				Properties properties = reader.getProperty();
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertEquals(saPage.isExittoAppHighlighted(),properties.getProperty("selectedtab.color"));
				logger.info("Step: Exit to App button is highlighted");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		@Then("the right side header shall be displayed as exit to app works")
		public void the_right_side_header_shall_be_displayed_as_exit_to_app_works() {
			try {
				LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Assert.assertTrue(saPage.isExittoAppHeaderDisplayed());
				logger.info("Step: Exit to App Works header is displayed");
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
		
		
		@Then("the user can only see the left menu components as per access")
		public void the_user_can_only_see_the_left_menu_components_as_per_access(List<Map<String, String>> dt) throws IOException {
			try {
				logger.info("Step: the user can only see the left menu components as per access");
				List<Map<String, String>> list = dt;
				Boolean fileDashboard = false;
				Boolean uploadFiles = false;
				Boolean uploadStatus = false;
				Boolean history = false;
				Boolean auditLog = false;
				Boolean imagingLinks = false;
				Boolean settings = false;
				Boolean help = false;
				Boolean info = false;
				Boolean chooseSite = false;
				for (int i = 0; i <= list.size() - 1; i++) {
					Properties properties = reader.getProperty();
					if (list.get(i).get("menuitems").equals("File Dashboard")) {
						fileDashboard = true;
					}
					else if (list.get(i).get("menuitems").equals("Upload Files")) {
						uploadFiles = true;
						
					}
					else if (list.get(i).get("menuitems").equals("Upload status")) {
						uploadStatus=true;
					}
					else if (list.get(i).get("menuitems").equals("History")) {
						history=true;
					}
					else if (list.get(i).get("menuitems").equals("Audit log")) {
						auditLog = true;
					}
					else if (list.get(i).get("menuitems").equals("Imaging links")) {
						imagingLinks = true;
					}
					else if (list.get(i).get("menuitems").equals("Settings")) {
						settings = true;
					}
					else if (list.get(i).get("menuitems").equals("Help")) {
						help = true;
					}
					else if (list.get(i).get("menuitems").equals("Info")) {
						info = true;
					}
					else if (list.get(i).get("menuitems").equals("Choose site")) {
						chooseSite = true;
					}
				}
				Assert.assertEquals(saPage.isLeftNavigationInfoDisplayed("File Dashboard"), fileDashboard);
				Assert.assertEquals(saPage.isLeftNavigationInfoDisplayed("Upload Files"), uploadFiles);
				Assert.assertEquals(saPage.isLeftNavigationInfoDisplayed("Upload status"), uploadStatus);
				Assert.assertEquals(saPage.isLeftNavigationInfoDisplayed("History"), history);
				Assert.assertEquals(saPage.isLeftNavigationInfoDisplayed("Audit log"), auditLog);
				Assert.assertEquals(saPage.isLeftNavigationInfoDisplayed("Imaging links"), imagingLinks);
				Assert.assertEquals(saPage.isLeftNavigationInfoDisplayed("Settings"), settings);
				Assert.assertEquals(saPage.isLeftNavigationInfoDisplayed("Help"), help);
				Assert.assertEquals(saPage.isLeftNavigationInfoDisplayed("Info"), info);
				Assert.assertEquals(saPage.isLeftNavigationInfoDisplayed("Choose site"), chooseSite);
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
			
		}
		
		
		

}
