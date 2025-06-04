package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApplicationCardsPage;
import pages.BrowsePcScreenPage;
import pages.FacilityListPage;
import pages.HILActiveCasePage;
import pages.LoginPage;
import pages.SurgeonListPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class HIL_ActiveCases_SSR1699_ExportAllSegmentationChangesSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HIL_ActiveCases_SSR1699_ExportAllSegmentationChangesSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HILActiveCasePage hacpage = new HILActiveCasePage();

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

	@When("the user selects a claimed case record from the active case list")
	public void the_user_selects_a_claimed_case_record_from_the_active_case_list() {
		try {
			hacpage.selectAClaimedRecord();
			logger.info("Step: the user selected a claimed record");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects the casefile claimed by the logged in user")
	public void the_user_selects_the_casefile_claimed_by_the_logged_in_user() {
		try {
			hacpage.chooseRecordForUsername();
			logger.info("Step: the user selected a claimed record");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects a case record from the case history list")
	public void the_user_selects_a_case_record_from_the_case_history_list() {
		try {
			hacpage.selectARecordFromCaseHistory();
			logger.info("Step: the user selected a record from case history");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on audit log icon for the selected case file")
	public void the_user_clicks_on_audit_log_icon_for_the_selected_case_file() {
		try {
			Thread.sleep(10000);
			hacpage.clickAuditLogIcon();
			logger.info("Step: the user clicked on audit log icon of selected case file");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user clicks on audit log icon for the selected case history file")
	public void the_user_clicks_on_audit_log_icon_for_the_selected_case_history_file() {
		try {
			Thread.sleep(10000);
			hacpage.clickOnCaseHistoryAuditlogIcon();
			logger.info("Step: the user clicked on audit log icon of selected case hsitory file");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// *********************THEN BLOCK*******************************
	@Then("the case records shall be displayed in tabular column of active cases")
	public void the_case_records_shall_be_displayed_in_tabular_column_of_active_cases() {
		try {
			Assert.assertTrue(hacpage.isRecordTableDisplayed());
			logger.info("Step : The case records are displayed in tabular column of active cases");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the active cases audit log file of selected case record shall be downloaded in .csv file")
	public void the_active_cases_audit_log_file_of_selected_case_record_shall_be_downloaded_in_csv_file() {
		try {
			Properties properties = reader.getProperty();
			List<WebElement> usernames = LoginPage.driver.findElements(By.xpath(
					"activecases.get.username"));
			WebElement allCaseIds = LoginPage.driver.findElement(By.xpath(
					"mycases.table.column.caseid.xpath"));
			for (WebElement username : usernames) {
				if (username.getText().equals(properties.getProperty("username"))) {

					String caseid = allCaseIds.getText();
					logger.info("caseid*******" + caseid);
					String fileName = caseid.concat(" Audit log.csv");
					logger.info(fileName);
					Assert.assertTrue(hacpage.copyAuditLogFileToProject(fileName));
					break;

				}
			}
			logger.info("Step : The active cases Audit log file of selected case is downloaded in .csv file");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the case records shall be displayed in the list of case history")
	public void the_case_records_shall_be_displayed_in_the_list_of_case_history() {
		try {
			Assert.assertTrue(hacpage.isRecordTableDisplayed());
			logger.info("Step : The case records are displayed in the list of case history");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the case record shall be selected and higlighted in green color")
	public void the_case_record_shall_be_selected_and_higlighted_in_green_color() {
		try {
			Assert.assertTrue(hacpage.isCaseRecordSelected());
			logger.info("Step : The case record is selected and highlighted in green color");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the case history audit log file of selected case record shall be downloaded in .csv file")
	public void the_case_history_audit_log_file_of_selected_case_record_shall_be_downloaded_in_csv_file() {
		try {
			Thread.sleep(1000);
			String caseID = utility.initializeElement(LoginPage.driver, "casehistory.table.caseidfirst.xpath")
					.getText();
			String fileName = caseID.concat(" Audit log.csv");
			logger.info(fileName);
			Assert.assertTrue(hacpage.copyAuditLogFileToProject(fileName));
			logger.info("Step : The Case history Audit log file of selected case is downloaded in .csv file");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the following headers shall be displayed in downloaded audit log file")
	public void the_following_headers_shall_be_displayed_in_downloaded_audit_log_file(List<Map<String, String>> dt)
			throws IOException {
		try {
			Properties properties = reader.getProperty();
			List<WebElement> usernames = LoginPage.driver.findElements(By.xpath(
					"activecases.get.username"));
			WebElement allCaseIds = LoginPage.driver.findElement(By.xpath(
					"caseid.xpath"));
			for (WebElement username : usernames) {
				if (username.getText().equals(properties.getProperty("username"))) {

					String caseid = allCaseIds.getText();
					logger.info("caseid*******" + caseid);
					String fileName = caseid.concat(" Audit log.csv");
					logger.info(fileName);
					Assert.assertTrue(hacpage.copyAuditLogFileToProject(fileName));
					
			String screenshotName = new Throwable().getStackTrace()[0].getMethodName() + "_" + fileName;
			logger.info("Step: the details of selected active cases records should get download in following columns");
			List<Map<String, String>> list = dt;
			String[] headers = hacpage.verifyActiveCasesAuditLogHeaders(fileName);
			String header = null;
			System.out.print(headers.length);
			for (int i = 0; i <= list.size() - 1; i++) {
				int index = 0;
				if (list.get(i).get("header").equals("Date")) {
					header = "Date";
					index = 0;
				} else if (list.get(i).get("header").equals("Case Id")) {
					header = "Case Id";
					index = 1;

				} else if (list.get(i).get("header").equals("User Id")) {
					header = "User Id";
					index = 2;
				} else if (list.get(i).get("header").equals("Action")) {
					header = "Action";
					index = 3;
				}
				Assert.assertEquals(headers[index], header);
				logger.info(header + " is present in the excel sheet");
			}
			screenshot.screenshot(screenshotName, LoginPage.driver);
				}}}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the downloaded audit log file data should match with on screen active cases data")
	public void the_downloaded_audit_log_file_data_should_match_with_on_screen_active_cases_data() throws IOException {
		try {
			String caseID = utility.initializeElement(LoginPage.driver, "activecases.table.caseidfirst.xpath")
					.getText();
			String fileName = caseID.concat(" Audit log.csv");
			logger.info(fileName);
			String screenshotName = new Throwable().getStackTrace()[0].getMethodName() + "_" + fileName;
			logger.info("Step: the data should match on screen and excel " + fileName
					+ " for selected active cases record");
			Assert.assertTrue(hacpage.compareData(fileName));
			screenshot.screenshot(screenshotName, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the following headers shall be displayed in downloaded case history audit log file")
	public void the_following_headers_shall_be_displayed_in_downloaded_case_history_audit_log_file(
			List<Map<String, String>> dt) throws IOException {
		try {
			String caseID = utility.initializeElement(LoginPage.driver, "casehistory.table.caseidfirst.xpath")
					.getText();
			String fileName = caseID.concat(" Audit log.csv");
			logger.info(fileName);
			String screenshotName = new Throwable().getStackTrace()[0].getMethodName() + "_" + fileName;
			logger.info("Step: the details of selected case history records should get download in following columns");
			List<Map<String, String>> list = dt;
			String[] headers = hacpage.verifyActiveCasesAuditLogHeaders(fileName);
			String header = null;
			System.out.print(headers.length);
			for (int i = 0; i <= list.size() - 1; i++) {
				int index = 0;
				if (list.get(i).get("header").equals("Date")) {
					header = "Date";
					index = 0;
				} else if (list.get(i).get("header").equals("Case Id")) {
					header = "Case Id";
					index = 1;

				} else if (list.get(i).get("header").equals("User Id")) {
					header = "User Id";
					index = 2;
				} else if (list.get(i).get("header").equals("Action")) {
					header = "Action";
					index = 3;
				}
				Assert.assertEquals(headers[index], header);
				logger.info(header + " is present in the excel sheet");
			}
			screenshot.screenshot(screenshotName, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the downloaded audit log file data should match with on screen case history data")
	public void the_downloaded_audit_log_file_data_should_match_with_on_screen_case_history_data() throws IOException {
		try {
			String caseID = utility.initializeElement(LoginPage.driver, "casehistory.table.caseidfirst.xpath")
					.getText();
			String fileName = caseID.concat(" Audit log.csv");
			logger.info(fileName);
			String screenshotName = new Throwable().getStackTrace()[0].getMethodName() + "_" + fileName;
			logger.info("Step: the data should match on screen and excel " + fileName
					+ " for selected case history record");
			Assert.assertTrue(hacpage.compareData(fileName));
			screenshot.screenshot(screenshotName, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}