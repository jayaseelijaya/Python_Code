package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuditLogPage;
import pages.FileDashboardPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_AuditLog_SSR1789_AuditLogForHospitalDownloadableSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_AuditLog_SSR1782_FilterableByStartAndEndDateSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	AuditLogPage alPage = new AuditLogPage();
	SelectedActivityPage saPage = new SelectedActivityPage();
	FileDashboardPage daPage = new FileDashboardPage();

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
	
	@Then("the audit log record for Hospital account should only be displayed")
	public void the_audit_log_record_for_hospital_account_should_only_be_displayed() throws IOException, InterruptedException {
		try {
			logger.info("Step: the audit log record for Hospital account should only be displayed");
			Assert.assertTrue(alPage.hospitalAccountsRecordsDisplayed());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}

	@Then("the export selected button shall be {string}")
	public void the_export_selected_button_shall_be(String string) throws IOException {
		try {
			logger.info("Step: the export selected button shall be " + string);
			String screenshotName =  new Throwable().getStackTrace()[0].getMethodName() + "_" + string;
			if(string.contains("enabled")) {
				Assert.assertTrue(alPage.getExportSelectedBtnState());
			}
			else {
				Assert.assertFalse(alPage.getExportSelectedBtnState());
			}
			screenshot.screenshot(screenshotName, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the export all button shall be {string}")
	public void the_export_all_button_shall_be(String string) throws IOException {
		try {
			logger.info("Step: the export all button shall be " + string);
			String screenshotName =  new Throwable().getStackTrace()[0].getMethodName() + "_" + string; 
			if(string.contains("enabled")) {
				Assert.assertTrue(alPage.getEportAllBtnState());
			}
			else {
				Assert.assertFalse(alPage.getEportAllBtnState());
			}
			screenshot.screenshot(screenshotName, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}

	@When("the user selects one record")
	public void the_user_selects_one_record() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user selects one record");
			Thread.sleep(5000);
			alPage.selectFirstRow();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the record should be selected")
	public void the_record_should_be_selected() throws IOException {
		try {
			logger.info("Step: the record should be selected");
			Assert.assertTrue(alPage.isChecked());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}
	
	@When("the user clicks on export selected button")
	public void the_user_clicks_on_export_selected_button() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user clicks on export selected button");
		    alPage.clickExportSelectedBtn();
		    Thread.sleep(10000);
		    screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}
	
	@Then("the details of selected records should get download in following columns for excel sheet {string}")
	public void the_details_of_selected_records_should_get_download_in_following_columns_for_excel_sheet(String string, List<Map<String, String>> dt) throws IOException {
		try {
			String screenshotName =  new Throwable().getStackTrace()[0].getMethodName() + "_" + string; 
			logger.info("Step: the details of selected records should get download in following columns");
			List<Map<String, String>> list = dt;
			String[] headers = alPage.verifyAuditLogHeaders(string);
			String header = null;
			System.out.print(headers.length);	
			for (int i = 0; i <= list.size() - 1; i++) {
				int index = 0;
				Properties properties = reader.getProperty();
				if (list.get(i).get("header").equals("ActionDate")) {
					 header = "Action Date";
					 index = 0;
				}
				else if (list.get(i).get("header").equals("UserFirstName")) {
					header = "User First Name";
					index = 1;
					
				}
				else if (list.get(i).get("header").equals("UserLastName")) {
					header = "User Last Name";
					index = 2;
				}
				else if (list.get(i).get("header").equals("UserName")) {
					header = "User Name";
					index = 3;
				}
				else if (list.get(i).get("header").equals("Action")) {
					header = "Action";
					index = 4;
				}
//				if (list.get(i).get("header").equals("FacilityId")) {
//					header = "Facility Id";
//					index = 5;
//				}
				Assert.assertEquals(headers[index], header);
				logger.info(header + " is present in the excel sheet");
			}
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}
	
	
	@Then("the data should match on screen and excel {string} for selected record")
	public void data_should_match_on_screen_and_excel(String string) throws IOException {
		try {
			String screenshotName =  new Throwable().getStackTrace()[0].getMethodName() + "_" + string; 
			logger.info("Step: the data should match on screen and excel " + string + " for selected record");
			Assert.assertTrue(alPage.checkData(string,true));
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the data should match on screen and excel {string} for all records")
	public void data_should_match_on_screen_and_excel_for_all_records(String string) throws IOException {
		try {
			String screenshotName =  new Throwable().getStackTrace()[0].getMethodName() + "_" + string; 
			logger.info("Step: the data should match on screen and excel " + string + " for selected record");
			Assert.assertTrue(alPage.checkData(string,false));
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user unselects one record")
	public void the_user_unselects_one_record() throws IOException {
		try {
			logger.info("Step: the user unselects one record");
			alPage.unselectFirstRow();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on Export All button")
	public void the_user_clicks_on_export_all_button() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user clicks on Export All button");
		    alPage.clickExportAllBtn();
		    Thread.sleep(10000);
		    screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}
	
	//TC0996
	@When("the user clicks on 24hrs filter")
	public void the_user_clicks_on_24hrs_filter() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user clicks on 24hrs filter");
			alPage.click24hrscheckbox();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			Thread.sleep(3000);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("audit log records within 24hrs are only displayed")
	public void audit_log_records_within_24hrs_are_only_displayed() throws IOException {
	   try {
		   logger.info("Step: audit log records within 24hrs are only displayed");
		   Assert.assertTrue(alPage.check24hrsRecords()); 
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user click on filter and expand the User Name filter option by clicking +")
	public void the_user_click_on_filter_and_expand_the_user_name_filter_option_by_clicking() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user click on filter and expand the User Name filter option by clicking +");
			alPage.expandUsernameFilter();
			Thread.sleep(3000);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	   
	}
	@Then("the User name filter should show the names of all user who has audit log records for Hospital account")
	public void the_user_name_filter_should_show_the_names_of_all_user_who_has_audit_log_records_for_hospital_account() throws IOException {
		try {
			logger.info("Step: the User name filter should show the names of all user who has audit log records for Hospital account");
			Assert.assertTrue(alPage.usernamelist());
			Thread.sleep(3000);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects H-admin user name and click on done")
	public void the_user_selects_h_admin_user_name_and_click_on_done() throws IOException {
		try {
			logger.info("Step: the user selects H-admin user name and click on done");
			alPage.selectHAdmin();
			Thread.sleep(3000);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	@Then("the list should show the Audit logs for H-admin")
	public void the_list_should_show_the_audit_logs_for_h_admin() throws IOException, InterruptedException {
		try {
			logger.info("Step: the list should show the Audit logs for H-admin");
			Assert.assertTrue(alPage.checkHAdminRecords());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("All the records should display in descending order based on Date Time column")
	public void all_the_records_should_display_in_descending_order_based_on_date_column() {
		try {
			logger.info("Step: All the records should display in descending order based on Date Time column");
			Assert.assertTrue(alPage.dateFieldSortingCheck());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clicks on user name filer")
	public void the_user_clicks_on_user_name_filer() {
		try {
			logger.info("Step: the user clicks on user name filer");
			alPage.clickUsernameFilter();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	   
	}
	
	@Then("the list is filterd on start date, end date and user name")
	public void the_list_is_filterd_on_start_date_end_date_and_user_name() throws IOException {
		try {
			logger.info("Step: the user clicks on user name filer");
			Assert.assertTrue(alPage.isDateAndusernameFileterApplied());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	    
	}
	
//	TC1000
	
	@When("the user searchs a user in search box and click on search button")
	public void the_user_searchs_a_user_in_search_box_and_click_on_search_btn() throws IOException {
	try {
		logger.info("Step: the user searchs a user in search box and click on search button");
		alPage.searchWithUserName();
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	}catch (Exception e) {
		logger.error("Step: Caught exception:: " + e.toString());
		exception = e;
	}
	}
	
	@Then("records should be displayed based on username search")
	public void records_should_be_displayed_based_on_username_search() throws IOException, InterruptedException {
	try {
		logger.info("Step: records should be displayed based on username search");
		Assert.assertTrue(alPage.checkHAdminRecords());
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	}catch (Exception e) {
		logger.error("Step: Caught exception:: " + e.toString());
		exception = e;
	}
	}
	
	//TC1001
	
	@When("the user clicks on the sort arrow for user column")
	public void the_user_clicks_on_the_sort_arrow_for_user_column() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user clicks on the sort arrow for user column");
			alPage.clickUserColumn();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	   
	}
	@Then("the list should get sorted out in {string} order of  User column")
	public void the_list_should_get_sorted_out_in_order_of_user_column(String string) throws IOException {
		try {
			String ScreenshotName = "the list should get sorted out in "+string+" order of  User column";
			logger.info("Step: " + ScreenshotName);
			Assert.assertEquals(alPage.userColumnSortType(), string);
			screenshot.screenshot(ScreenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	    
	    
	}
	
	//TC1004
	@Then("the Audit login option should not be displayed")
	public void the_audit_login_option_should_not_be_displayed() throws IOException {
		try {
			logger.info("Step: the Audit login option should not be displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}
	
	//TC1005
	@Then("the Application should download all the records and ignore the selected records {string}")
	public void the_application_should_download_all_the_records_and_ignore_the_selected_records(String string) throws IOException {
		try {
			String screenshotName =  new Throwable().getStackTrace()[0].getMethodName() + "_" + string; 
			logger.info("Step: " + screenshotName);
			Assert.assertTrue(alPage.isSelectedRecordInExcelSheet(string));
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}
	@Then("following columns should be there in excel sheet {string}")
	public void following_columns_should_be_there_in_excel_sheet(String string, List<Map<String, String>> dt) {
		try {
			String screenshotName =  new Throwable().getStackTrace()[0].getMethodName() + "_" + string; 
			logger.info("Step: following columns should be there in excel sheet");
			List<Map<String, String>> list = dt;
			String[] headers = alPage.headersinExcel(string);
			String header = null;
			System.out.print(headers.length);	
			for (int i = 0; i <= list.size() - 1; i++) {
				int index = 0;
				if (list.get(i).get("header").equals("ActionDate")) {
					 header = "Action Date";
					 index = 0;
				}
				else if (list.get(i).get("header").equals("UserFirstName")) {
					header = "User First Name";
					index = 1;
					
				}
				else if (list.get(i).get("header").equals("UserLastName")) {
					header = "User Last Name";
					index = 2;
				}
				else if (list.get(i).get("header").equals("UserName")) {
					header = "User Name";
					index = 3;
				}
				else if (list.get(i).get("header").equals("Action")) {
					header = "Action";
					index = 4;
				}
//				if (list.get(i).get("header").equals("FacilityId")) {
//					header = "Facility Id";
//					index = 5;
//				}
				Assert.assertEquals(headers[index], header);
				logger.info(header + " is present in the excel sheet");
			}
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}
	@Then("the data should match on screen and excel {string}")
	public void the_data_should_match_on_screen_and_excel(String string) throws IOException, InterruptedException {
		try {
			String screenshotName =  new Throwable().getStackTrace()[0].getMethodName() + "_" + string; 
			logger.info("Step: following columns should be there in excel sheet");
			Assert.assertTrue(alPage.checkDataInExcelSheet(string));
			screenshot.screenshot(screenshotName, LoginPage.driver);
		}catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

}
