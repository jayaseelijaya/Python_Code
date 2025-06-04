package stepDefinitions;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.UserInformationPage;
import utility.Screenshot;

public class DUU_ImageUploadLogin_SSR2337_NavigateToCLPSteps {
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR1763_File_DashboardSteps.class);
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	UserInformationPage ui = new UserInformationPage();
	SelectedActivityPage saPage = new SelectedActivityPage();
	
	@Then("the Exit to Apps is displayed at bottom of the left menu panel")
	public void the_exit_to_apps_is_displayed_at_bottom_of_the_left_menu_panel() {
		try {
			ui.isLeftNavigationInfoDisplayed("Exit to app");
			logger.info("Step: the Exit to Apps is displayed at bottom of the left menu panel");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("Choose Site menu in the left menu panel is highlighted")
	public void Choose_Site_menu_in_the_left_menu_panel_is_highlighted() {
		try {
			logger.info("Step: Choose Site menu in the left menu panel is highlighted");
			Assert.assertTrue(saPage.isChooseSiteHighlighted());
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
