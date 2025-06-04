package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.HistoryViewScreenPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;
import org.apache.commons.lang3.StringUtils; 

public class DUU_History_SSR1831_SearchSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_History_SSR1831_SearchSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	FileDashboardPage daPage = new FileDashboardPage();
	HistoryViewScreenPage hp = new HistoryViewScreenPage();
	SelectedActivityPage sap = new SelectedActivityPage();
	
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

	@Then("enter any {string} in the Search bar and click on Search button and verify result")
	public void enter_any_in_the_search_bar_and_click_on_search_button_and_verify_result(String string,List<Map<String, String>> dt) throws IOException, InterruptedException {
		try {
			String ssname = "enter any "+string+" in the Search bar and click on Search button and verify result";
			logger.info("Step: "+ ssname);
			List<Map<String, String>> list = dt;
			String searchText = "";
			if(string.equalsIgnoreCase("Patient first name")) {
				searchText = hp.getPatientFirstNameInFirstRow();
			}
			else if(string.equalsIgnoreCase("Patient last name")) {
				searchText = hp.getPatientLastNameInFirstRow();
			}
			else if(string.equalsIgnoreCase("Hospital name")) {
				searchText = hp.getHospitalNameInFirstRow();
			}
			else if(string.equalsIgnoreCase("Uploader first name")) {
				searchText = hp.getUploaderFirstNameInFirstRow();
			}
			else if(string.equalsIgnoreCase("Uploader last name")) {
				searchText = hp.getUploaderLastNameInFirstRow();
			}
			else if(string.equalsIgnoreCase("Surgeon first name")) {
				searchText = hp.getSurgeonFirstNameInFirstRow();
			}
			else if(string.equalsIgnoreCase("Surgeon last name")) {
				searchText = hp.getSurgeonLastNameInFirstRow();
			}
			else if(string.equalsIgnoreCase("Upload status")) {
				searchText = hp.getUploadStatusInFirstRow();
			}
			String searchTextUpper = searchText.toUpperCase();
			String searchTextLower = searchText.toLowerCase();
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("Test data").contains("combination of lower and upper case")) {
					hp.enterStringAndclickSearchBtn(searchText);
					Assert.assertTrue(hp.verifySearchResult(searchText));
					logger.info(list.get(i).get("Test data") +" is verified");
					screenshot.screenshot(ssname, LoginPage.driver);
				}
				else if (list.get(i).get("Test data").contains("upper case")) {
					hp.enterStringAndclickSearchBtn(searchTextUpper);
					Assert.assertTrue(hp.verifySearchResult(searchText));
					logger.info(list.get(i).get("Test data") +" is verified");
					screenshot.screenshot(ssname, LoginPage.driver);
				} 
				else {
					hp.enterStringAndclickSearchBtn(searchTextLower);
					Assert.assertTrue(hp.verifySearchResult(searchText));
					logger.info(list.get(i).get("Test data") +" is verified");
					screenshot.screenshot(ssname, LoginPage.driver);
				}
			}
				
			
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}
	
	@Then("enter any {string} in the Search bar and click on Search button and verify result in view details")
	public void enter_any_in_the_search_bar_and_click_on_search_button_and_verify_viewdetails(String string,List<Map<String, String>> dt) throws IOException, InterruptedException {
		try {
			String ssname = "enter any "+string+" in the Search bar and click on Search button and verify result in view details";
			logger.info("Step: "+ ssname);
			List<Map<String, String>> list = dt;
			Properties properties = reader.getProperty();
			String searchText = properties.getProperty("available.application1");
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("Test data").contains("combination of lower and upper case")) {
					hp.enterStringAndclickSearchBtn(searchText);
					screenshot.screenshot(ssname, LoginPage.driver);
				}
				else if (list.get(i).get("Test data").contains("upper case")) {
					hp.enterStringAndclickSearchBtn(searchText.toUpperCase());
					screenshot.screenshot(ssname, LoginPage.driver);
				} 
				else {
					hp.enterStringAndclickSearchBtn(searchText.toLowerCase());
					screenshot.screenshot(ssname, LoginPage.driver);
				}
			}
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user selects any record displayed on record entry table and Click on View details button")
	public void the_user_selects_any_record_displayed_on_record_entry_table_and_click_on_view_details_button() throws IOException, InterruptedException {
	    try {
	    	logger.info("Step: the user selects any record displayed on record entry table and Click on View details button");
	    	hp.selectFirstRow();
		    hp.clickViewDetails();
	    	screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the View detail pop up is opened")
	public void the_view_detail_pop_up_is_opened() throws IOException, InterruptedException {
		try {
	    	logger.info("Step: the View detail pop up is opened");
	    	Assert.assertTrue(hp.isViewDetailsPopupDisplayed());
	    	screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the Application name is matched with searched Application")
	public void the_application_name_is_matched_with_searched_application() throws IOException, InterruptedException {
		try {
	    	logger.info("Step: the Application name is matched with searched Application");
	    	Assert.assertTrue(hp.verifyApplicationName());
	    	screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		
	}
}
