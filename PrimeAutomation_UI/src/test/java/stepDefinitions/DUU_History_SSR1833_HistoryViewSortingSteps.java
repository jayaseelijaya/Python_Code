package stepDefinitions;

import static org.junit.Assert.assertArrayEquals;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HistoryViewScreenPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_History_SSR1833_HistoryViewSortingSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_History_SSR1832_HistoryViewSearchableByAllFieldsSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	HistoryViewScreenPage hvsPage = new HistoryViewScreenPage();

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
	@When("the user clicks on the header {string}")
	public void the_user_clicks_on_the_header(String headerName) throws IOException, InterruptedException {
		try {
			logger.info("Step: the user clicks on the header" + "_" + headerName);
			hvsPage.clickHeader(headerName);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName() + "_" + headerName,
					LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("the user enters a patient name and clicks on search button")
	public void the_user_enters_a_patient_name_and_clicks_search_button() {
		try {
			logger.info("Step: the user enters a patient name and clicks on search button");
			hvsPage.enterPatientNameInSearchBox();
			logger.info("Step: The patient first name is entered in the search box");
			hvsPage.clickOnSearchButtonOnHistoryPage();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	// *********************THEN BLOCK*******************************
	@Then("the records are sorted by Date in Descending order by default with arrow {string}")
	public void the_records_are_sorted_by_date_in_descending_order_by_default(String arrowType) throws IOException {
		try {
			logger.info("Step: the records are sorted by Date in Descending order by default with arrow " + arrowType);
			Boolean sortType = hvsPage.historyViewSortingCheck("Date", "descending");
			Assert.assertTrue(sortType);
			Boolean arrow = hvsPage.sortArrowCheck("Date", arrowType);
			Assert.assertTrue(arrow);
			logger.info("the records are sorted by Date in Descending");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("the records should sort in {string} order as per {string} indicated by arrow {string}")
	public void sorting(String sortType, String headerName, String arrowType) throws IOException {
		try {
			logger.info("Step: the records should sort in " + sortType + " order as per " + headerName
					+ " indicated by arrow " + arrowType);
			String screenshotName = String.format("the records should sort in %s order as per %s indicated by arrow %s",
					sortType, headerName, arrowType);
			Boolean sort = hvsPage.historyViewSortingCheck(headerName, sortType);
			Assert.assertTrue(sort);
			Boolean arrow = hvsPage.sortArrowCheck(headerName, arrowType);
			Assert.assertTrue(arrow);
			screenshot.screenshot(screenshotName, LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the entered records are displayed in the table")
	public void the_eneterd_records_are_displayed_in_the_table() throws IOException {
		try {
			logger.info("Step: the entered records are displayed in the table");
			Assert.assertTrue(hvsPage.checktablecontents());
			logger.info("The entered records is only displayed in the history table");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {

		}
	}

}
