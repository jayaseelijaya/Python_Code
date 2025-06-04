
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
import pages.FacilityListPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_FacilitySelectionScreenSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	FacilityListPage fp = new FacilityListPage();
	UserInformationPage uiPage = new UserInformationPage();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_FacilitySelectionScreenSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	SelectedActivityPage saPage = new SelectedActivityPage();
	LoginPage lp = new LoginPage();

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
	@Then("the upload files header shall be displayed")
	public void the_upload_files_header_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(fp.uploadFilesHeader());
			logger.info("Step: Upload files header text is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("where are you working today text shall be displayed")
	public void where_are_you_working_today_text_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(fp.facilityHeaderTitle());
			logger.info("Step: Where are you working today header text is  displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Search site heading shall be displayed")
	public void search_site_heading_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(fp.searchSiteTextTitle());
			logger.info("Step: Search Site text is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the text of search box shall be displayed")
	public void the_text_of_search_box_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertEquals(fp.searchBoxText(), "Enter Keyword or Name of Site");
			logger.info("Step: Search box text is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("x button shall be displayed")
	public void x_button_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(fp.isXButtonDisplayed());
			logger.info("Step: X button is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the following information shall be displayed at left navigation bar")
	public void the_following_information_shall_be_displayed_at_left_navigation_bar(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("infomation").contains("SN logo")) {
					Assert.assertTrue(uiPage.isLeftNavigationInfoDisplayed("SN logo").isDisplayed(),
							"The SN logo is not displayed.");
					logger.info("The SN logo is displayed.");
				}
				if (list.get(i).get("infomation").contains("Profile image")) {
					assertTrue(uiPage.isLeftNavigationInfoDisplayed("Profile image").isDisplayed(),
							"The Profile image is not displayed.");
					logger.info("The Profile image is displayed.");
				}
				if (list.get(i).get("infomation").contains("File dashboard")) {
					assertTrue(uiPage.isLeftNavigationInfoDisplayed("File dashboard").isDisplayed(),
							"The File dashboard is not displayed.");
					logger.info("The File dashboard is displayed.");
				}
				if (list.get(i).get("infomation").contains("Upload files")) {
					Assert.assertTrue(uiPage.isLeftNavigationInfoDisplayed("Upload files").isDisplayed(),
							"The Upload files not displayed.");
					logger.info("The Upload files is displayed.");
				}
				if (list.get(i).get("infomation").contains("Upload status")) {
					assertTrue(uiPage.isLeftNavigationInfoDisplayed("Upload status").isDisplayed(),
							"The Upload status is not displayed.");
					logger.info("The Upload status is displayed.");
				}
				if (list.get(i).get("infomation").contains("Upload Icon")) {
					assertTrue(uiPage.isLeftNavigationInfoDisplayed("Upload Icon").isDisplayed(),
							"The Upload Icon is not displayed.");
					logger.info("The Upload Icon is displayed.");
				}
				if (list.get(i).get("infomation").contains("Audit log")) {
					Assert.assertTrue(uiPage.isLeftNavigationInfoDisplayed("Audit log").isDisplayed(),
							"The Audit log is not displayed.");
					logger.info("The Audit log is displayed.");
				}
				if (list.get(i).get("infomation").contains("imaging links")) {
					Assert.assertTrue(uiPage.isLeftNavigationInfoDisplayed("imaging links").isDisplayed(),
							"The imaging links is not displayed.");
					logger.info("The imaging links is displayed.");
				}
				if (list.get(i).get("infomation").contains("settings")) {
					Assert.assertTrue(uiPage.isLeftNavigationInfoDisplayed("settings").isDisplayed(),
							"The settings is not displayed.");
					logger.info("The settings is displayed.");
				}
				if (list.get(i).get("infomation").contains("Exit to app")) {
					Assert.assertTrue(uiPage.isLeftNavigationInfoDisplayed("Exit to app").isDisplayed(),
							"The Exit to app is not displayed.");
					logger.info("The Exit to app is displayed.");
				}
				if (list.get(i).get("infomation").contains("Help")) {
					Assert.assertTrue(saPage.isLeftNavigationInfoDisplayed("Help"));
					logger.info("Help is displayed");
				}
				if (list.get(i).get("infomation").contains("Info")) {
					Assert.assertTrue(saPage.isLeftNavigationInfoDisplayed("info"));
					logger.info("info is displayed");
				}
				if (list.get(i).get("infomation").contains("Logout")) {
					Assert.assertTrue(lp.isLogoutBtnDisplayed());
					logger.info("Logout button is displayed");
				}
				if (list.get(i).get("infomation").contains("Choose Site")) {
					Assert.assertTrue(uiPage.isLeftNavigationInfoDisplayed("Choose Site").isDisplayed(),
							"Choose Site is not displayed.");
					logger.info("Choose Site is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The Left Navigation informations are not displayed");
			exception = e;
		}
	}

	@Then("the following information should not be displayed at left navigation bar")
	public void the_following_information_should_not_be_displayed_at_left_navigation_bar(List<Map<String, String>> dt) {
		try {
			logger.info("Step: the following information should not be displayed at left navigation bar");
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("infomation").contains("Audit log")) {
					try {
						Assert.assertFalse(uiPage.isLeftNavigationInfoDisplayed("Audit log").isDisplayed());
						logger.info("The Audit log is displayed.");
			        }catch(org.openqa.selenium.NoSuchElementException e){
			        	logger.info("The Audit log is not displayed.");
			        }
				}
				if (list.get(i).get("infomation").contains("Imaging Links")) {
					try {
						Assert.assertFalse(uiPage.isLeftNavigationInfoDisplayed("imaging links").isDisplayed());
						logger.info("The imaging links is displayed.");
			        }catch(org.openqa.selenium.NoSuchElementException e){
			        	logger.info("The imaging links is not displayed.");
			        }
				}
				if (list.get(i).get("infomation").contains("Settings")) {
					try {
						Assert.assertFalse(uiPage.isLeftNavigationInfoDisplayed("settings").isDisplayed());
						logger.info("settings is displayed.");
			        }catch(org.openqa.selenium.NoSuchElementException e){
			        	logger.info("settings is not displayed.");
			        }
				}
				if (list.get(i).get("infomation").contains("Upload status")) {
					try {
						Assert.assertFalse(uiPage.isLeftNavigationInfoDisplayed("Upload status").isDisplayed());
						logger.info("Upload status is displayed.");
			        }catch(org.openqa.selenium.NoSuchElementException e){
			        	logger.info("Upload status is not displayed.");
			        }
				}
				if (list.get(i).get("infomation").contains("Upload files")) {
					try {
						Assert.assertFalse(uiPage.isLeftNavigationInfoDisplayed("Upload files").isDisplayed());
						logger.info("Upload files is displayed.");
			        }catch(org.openqa.selenium.NoSuchElementException e){
			        	logger.info("Upload files is not displayed.");
			        }
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
