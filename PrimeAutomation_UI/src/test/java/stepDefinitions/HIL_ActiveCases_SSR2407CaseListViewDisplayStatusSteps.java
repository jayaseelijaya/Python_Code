package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HILActiveCasePage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class HIL_ActiveCases_SSR2407CaseListViewDisplayStatusSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HIL_ActiveCases_SSR2407CaseListViewDisplayStatusSteps.class);
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
	@When("the user selects an unclaimed case and clicks on claim button")
	public void the_user_selects_an_unclaimed_case_and_clicks_on_claim_button() {
		try {
			hacpage.selectUnclaimedCaseAndClickOnClaimButton();
			logger.info("Step: the user selected an unclaimed case");
			logger.info("Step: the user clicked on claim button of selected case");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user clciks on open button of selected case")
	public void the_user_clciks_on_open_button_of_selected_case() {
		try {
			hacpage.clickOnOpenButtonOfSelectedCase();
			logger.info("Step: the user clicked on open button of selected case");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the hil image editor screen shall be displayed for selected case")
	public void the_hil_image_editor_screen_shall_be_displayed_for_selected_case() {
		try {
			Thread.sleep(20000);
			hacpage.isHilImageEditorScreenDisplayed();
			logger.info("Step: The Hil Image Editor screen is displayed for the selected case.");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects only coronal view")
	public void the_user_selects_only_coronal_view() {
		try {
			//Thread.sleep(1000);
			hacpage.SelectCoronalView();
			logger.info("Step: The user selected coronal view only.");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("the user selects already claimed case record from the active case list")
	public void the_user_selects_already_claimed_case_record_from_the_active_case_list() {
		try {
			//Thread.sleep(1000);
			hacpage.selectClaimedCase();
			logger.info("Step: The user selected alreday claimed case record");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	// *********************THEN BLOCK*******************************
	@Then("the unclaimed case status shall be displayed as new or unclaimed")
	public void the_unclaimed_case_status_shall_be_displayed_as_new_or_unclaimed() {
		try {
			Assert.assertTrue(hacpage.isNewUnclaimedStatusDisplayed());
			logger.info("Step: The new/unclaimed case status is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the open button in 10th column shall be enabled")
	public void the_open_button_in_10th_column_shall_be_enabled() {
		try {
			Assert.assertTrue(hacpage.isOpenButtonEnabled());
			logger.info("Step: The open button in 10th column is enabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the status of claimed case shall be displayed as reviewer name")
	public void the_status_of_claimed_case_shall_be_displayed_as_reviewer_name() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(hacpage.isReviewerNameDisplayed());
			logger.info("Step: Reviewer name is displayed as status of claimed case.");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the following four views along with toolbar shall be displayed")
	public void the_following_four_views_along_with_toolbar_shall_be_displayed(List<Map<String, String>> dt) {
		try {
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("view").contains("Axial")) {
					assertTrue(hacpage.isImageEditorScreenFourViewsDisplayed("Axial").isDisplayed(),
							"Axial view is not displayed.");
					logger.info("Axial view is displayed.");
				}
				if (list.get(i).get("view").contains("Sagittal")) {
					assertTrue(hacpage.isImageEditorScreenFourViewsDisplayed("Sagittal").isDisplayed(),
							"Sagittal view is not displayed.");
					logger.info("Sagittal view is displayed.");
				}
				if (list.get(i).get("view").contains("Coronal")) {
					assertTrue(hacpage.isImageEditorScreenFourViewsDisplayed("Coronal").isDisplayed(),
							"Coronal view is not displayed.");
					logger.info("Coronal view is displayed.");
				}
				if (list.get(i).get("view").contains("3D Model")) {
					Assert.assertTrue(hacpage.isImageEditorScreenFourViewsDisplayed("3D Model").isDisplayed(),
							"3D Model view is displayed.");
					logger.info("3D Model view is displayed.");
				}
				if (list.get(i).get("view").contains("right panel toolbar")) {
					assertTrue(hacpage.isImageEditorScreenFourViewsDisplayed("right panel toolbar").isDisplayed(),
							"Right panel toolbar is not displayed.");
					logger.info("Right panel toolbar is displayed.");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The image editor screen views are not displayed");
			exception = e;
		}
	}
	
	@Then("the reject button shall be displayed at the right bottom of the screen")
	public void the_reject_button_shall_be_displayed_at_the_right_bottom_of_the_screen() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(hacpage.isRejectButtonDisplayed());
			logger.info("Step: Reject button is displayed at the right bottom.");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the reviewer name shall be displayed for the claimed case")
	public void the_reviewer_name_shall_be_displayed_for_the_claimed_case() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(hacpage.isClaimedCaseReviewerNameDisplayed());
			logger.info("Step: The claimed case reviewer name is displayed.");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the view button shall be enabled for the uncalimed case")
	public void the_view_button_shall_be_enabled_for_the_uncalimed_case() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(hacpage.isViewButtonEnabledForUnclimedCase());
			logger.info("Step: The unclaimed case view button is enabled.");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the open button shall be enabled for the claimed case")
	public void the_open_button_shall_be_enabled_for_the_claimed_case() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(hacpage.isOpenButtonEnabledForClaimedCase());
			logger.info("Step: The claimed case open button is enabled.");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the unassign button shall be enabled for the claimed case")
	public void the_unassign_button_shall_be_enabled_for_the_claimed_case() {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(hacpage.isUnassignButtonEnabledForClaimedCase());
			logger.info("Step: The claimed case unassign button is enabled.");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
