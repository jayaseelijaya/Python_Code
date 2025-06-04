package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuditLogPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_AuditLog_SSR1790_SmithNephewAdminSteps {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_AuditLog_SSR1790_SmithNephewAdminSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	AuditLogPage ap = new AuditLogPage();
	SelectedActivityPage sp = new SelectedActivityPage();

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

	@Given("below components is displayed on left side panel")
	public void below_components_is_displayed_on_left_side_panel(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("screen").contains("File Dashboard")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("File Dashboard").isDisplayed(),
							"File dashboard button is not displayed.");
					logger.info("File dashboard button is displayed on left panel");
				}
				if (list.get(i).get("screen").contains("History")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("History").isDisplayed(), "History is not displayed.");
					logger.info("History button is displayed on left panel");
				}
				if (list.get(i).get("screen").contains("Audit Log")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("History").isDisplayed(), "Audit Log is not displayed.");
					logger.info("Audit Log button is displayed on left panel");
				}
				if (list.get(i).get("screen").contains("Imaging Links")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Imaging Links").isDisplayed(),
							"Imaging Links is not displayed.");
					logger.info("Imaging Links button is displayed on left panel");
				}
				if (list.get(i).get("screen").contains("Choose Site")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Choose Site").isDisplayed(),
							"Choose Site Button is not displayed.");
					logger.info("Choose Site button is displayed on left panel");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Left panel components are not displayed");
			exception = e;
		}
	}

	@When("SN user click on any facility from list")
	public void sn_user_click_on_any_facility_from_list() {
		try {
			ap.chooseSite();
			logger.info("Step : Facility is selected from the screen");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("clicks on Select button")
	public void clicks_on_select_button() {
		try {
			ap.clickSelectBtn();
			logger.info("Step : Select Button is clicked ");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Upload dashboard page is displayed")
	public void upload_dashboard_page_is_displayed() {
		try {
			sp.isDashboardHeaderDisplayed();
			logger.info("Step : Upload Dashboard page is displayed ");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on Audit log from left panel")
	public void user_clicks_on_audit_log_from_left_panel() {
		try {
			sp.clickOnAuditLogButton();
			logger.info("Step : Audit Log Button is clicked ");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Audit log page should be displayed with below components")
	public void audit_log_page_should_be_displayed_with_below_components(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("screen").contains("24 Hrs")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("24 Hrs").isDisplayed(), "24 Hrs button is not displayed.");
					logger.info("24 Hrs button is displayed on Audit Log screen");
				}
				if (list.get(i).get("screen").contains("Filter")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Filter").isDisplayed(), "Filter is not displayed.");
					logger.info("Filter button is displayed on Audit Log screen");
				}
				if (list.get(i).get("screen").contains("Search box")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Search box").isDisplayed(), "Search box is not displayed.");
					logger.info("Search box is displayed on Audit Log screen");
				}
				if (list.get(i).get("screen").contains("Search")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Search").isDisplayed(), "Search Button is not displayed.");
					logger.info("Search Button is displayed on Audit Log screen");
				}
				if (list.get(i).get("screen").contains("Events")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Events").isDisplayed(), "Events is not displayed.");
					logger.info("Events is displayed on Audit Log screen");
				}
				if (list.get(i).get("screen").contains("Export Selected")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Export Selected").isDisplayed(),
							"Export Selected is not displayed.");
					logger.info("Export Selected button is displayed on Audit Log screen");
				}
				if (list.get(i).get("screen").contains("Show more")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Show more").isDisplayed(),
							"Export Selected is not displayed.");
					logger.info("Show more button is displayed on Audit Log screen");
				}
				if (list.get(i).get("screen").contains("Export all")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Show more").isDisplayed(), "Export all is not displayed.");
					logger.info("Export all button is displayed on Audit Log screen");
				}
				if (list.get(i).get("screen").contains("Scroll bar")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Scroll bar").isDisplayed(), "Scroll bar is not displayed.");
					logger.info("Scroll bar is displayed on Audit Log screen");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Audit Log components are not displayed");
			exception = e;
		}
	}

	@When("user clicks on Hrs checkbox")
	public void user_clicks_hrs_checkbox() {
		try {
			ap.clickon24Hrs();
			logger.info("Step : 24 Hrs Button is clicked ");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records uploaded within twenty four Hrs is displayed")
	public void records_uploaded_within_hrs_is_displayed() {
		try {
			ap.isRecordsDisplayedInDescendingOrder();
			Thread.sleep(2000);
			ap.clickonselected24Hrs();
			logger.info("Step : Records uploaded within 24 Hrs is displayed");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on filter tab")
	public void user_clicks_on_filter_tab() {
		try {
			ap.clickonFilter();
			logger.info("Step : Filter Button is clicked ");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("below components is displayed")
	public void below_components_is_displayed(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("screen").contains("Filter By")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Filter By").isDisplayed(),
							"Filter By button is not displayed.");
					logger.info("Filter By field is displayed on Filter tab once clicked");
				}
				if (list.get(i).get("screen").contains("Date")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Date").isDisplayed(), "Date is not displayed.");
					logger.info("Date field is displayed on Filter tab once clicked");
				}
				if (list.get(i).get("screen").contains("User Name")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("User Name").isDisplayed(), "User Name is not displayed.");
					logger.info("User Name field is displayed on Filter tab once clicked");
				}
				if (list.get(i).get("screen").contains("Done")) {
					assertTrue(ap.isLeftPanelInfoDisplayed("Done").isDisplayed(), "Done Button is not displayed.");
					logger.info("Done Button is displayed on Filter tab");
					utility.initializeElement(LoginPage.driver, "auditlog.Done.btn.xpath").click();
					Thread.sleep(2000);
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Audit Log components are not displayed");
			exception = e;
		}
	}

	@When("user clicks on username field from filter tab")
	public void user_clicks_on_username_field_from_filter_tab() {
		try {
			ap.clickPlusIcon();
			logger.info("Step : + icon from username is clicked ");
			Thread.sleep(5000);
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("select any username")
	public void select_any_username() {
		try {
			ap.selectUsername();
			logger.info("Step : Username is selected");
			Thread.sleep(4000);
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@When("clicks on Done button")
	public void clicks_on_done_button() {
		try {
			ap.clickDoneBtn();
			logger.info("Step : Done Button from Filter tab is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records is displayed based on filter username")
	public void records_is_displayed_based_on_filter_username() {
		try {
			ap.isListDisplayedUsername();
			Thread.sleep(2000);
			logger.info("Step : Records displayed based on filtered username");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("clicks on Date field")
	public void clicks_on_date_field() {
		try {
			ap.clickdatePlusIcon();
			Thread.sleep(2000);
			logger.info("Step : Date Plus icon is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("click on start and select any date")
	public void click_on_start_and_select_any_date() {
		try {
			ap.clickonStartDate();
			Thread.sleep(2000);
			logger.info("Step : Start Date is clicked");
			utility.initializeElement(LoginPage.driver, "auditlog.startdate.selection.xpath").click();
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("click on end and select any date")
	public void click_on_end_and_select_any_date() {
		try {
			ap.clickonEndDate();
			Thread.sleep(2000);
			logger.info("Step : End Date is clicked");
			utility.initializeElement(LoginPage.driver, "auditlog.enddate.selection.xpath").click();
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records are displayed based on date selected")
	public void records_are_displayed_based_on_date_selected() {
		try {
			ap.isListDisplayedDateFilter();
			Thread.sleep(2000);
			logger.info("Step : Records displayed based on filtered date");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user removes the filter criteria")
	public void user_removes_the_filter_criteria() {
		try {
			ap.removeCrossIcon();
			logger.info("Step : User removed the filter criteria");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records are displayed in descending order")
	public void records_are_displayed_in_descending_order() {
		try {
			ap.isRecordsDisplayedInDescendingOrder();
			logger.info("Step : Records are displayed in descending order");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("User clicks on filter tab")
	public void User_clicks_on_filter_tab() {
		try {
			ap.clickonFilter();
			logger.info("Step : Filter Button is clicked ");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@When("user search with username")
	public void user_search_with_username() {
		try {
			ap.enterUserNameInSearchBox();
			logger.info("Step : Username is entered in Search Box");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("clicks on Search button")
	public void clicks_on_search_button() {
		try {
			ap.clickonSearchBtn();
			logger.info("Step : Search Button is clicked ");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records should be displayed based on search criteria")
	public void records_should_be_displayed_based_on_search_criteria() {
		try {
			ap.isListDisplayedHrs();
			Thread.sleep(2000);
			logger.info("Step : Records should be displayed based on search criteria");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user search with uservalue")
	public void user_search_with_uservalue() {
		try {
			ap.enterUservalueInSearchBox();
			logger.info("Step : Uservalue is entered in Search Box");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user search with action value")
	public void user_search_with_action_value() {
		try {
			ap.enterActioninSearchBox();
			logger.info("Step : Action Value is entered in Search Box");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clears the text from the search box")
	public void user_clears_the_text_from_the_search_box() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").clear();
		Thread.sleep(2000);
		logger.info("Step : Text is cleared from Search Box");

	}

	@Then("records is displayed to the user")
	public void records_is_displayed_to_the_user() {
		try {
			ap.isRecordsDisplayedInDescendingOrder();
			logger.info("Step : Records are displayed to the user");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on sort arrow for user coloumn")
	public void user_clicks_on_sort_arrow_for_user_coloumn() {
		try {
			ap.clickonArrow();
			Thread.sleep(2000);
			logger.info("Step : Clicked on sort arrow for user coloumn");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("event records is displayed based on sorting")
	public void event_records_is_displayed_based_on_sorting() {
		try {
			ap.isRecordsDisplayedInDescendingOrder();
			logger.info("Step : Records are displayed in descending order");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records should be displayed based on username search criteria")
	public void records_should_be_displayed_based_on_username_search_criteria() {
		try {
			ap.isListDisplayedUsername();
			Thread.sleep(2000);
			logger.info("Step : Records should be displayed based on username search criteria");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records should be displayed based on uservalue search criteria")
	public void records_should_be_displayed_based_on_uservalue_search_criteria() {
		try {
			ap.isListDisplayedUservalue();
			Thread.sleep(2000);
			logger.info("Step : Records should be displayed based on User value search criteria");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("records should be displayed based on action value search criteria")
	public void records_should_be_displayed_based_on_action_value_search_criteria() {
		try {
			ap.isListDisplayedActionValue();
			Thread.sleep(2000);
			logger.info("Step : Records should be displayed based on Action value search criteria");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
