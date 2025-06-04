package stepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApplicationCardsPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.UserInformationPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUploadLogin_SSR1805_ControlToLogoutSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUploadLogin_SSR1805_ControlToLogoutSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SelectedActivityPage sa = new SelectedActivityPage();
	UserInformationPage ui = new UserInformationPage();

	@Then("the Logout icon is displayed at the bottom navigation bar in the left menu panel")
	public void the_logout_icon_is_displayed_at_the_bottom_navigation_bar_in_the_left_menu_panel() {
		try {
			logger.info("Step: the Logout icon is displayed at the bottom navigation bar in the left menu panel");
			lp = new LoginPage();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			Assert.assertTrue(lp.isLogoutBtnDisplayed());
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
		}
	
	@Then("the File Dashbord is in green color and other menus in the left menu panel is displayed in white color")
	public void file_dashbord_in_green_other_menus_in_white_color() throws IOException{
		try {
			logger.info("Step: the File Dashbord is in green color and other menus in the left menu panel is displayed in white color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			Properties properties = reader.getProperty();
			Assert.assertEquals(sa.leftmenuPanelColor("File Dashboard"),properties.getProperty("green.color"));
			Assert.assertEquals(sa.leftmenuPanelColor("Upload Files"),properties.getProperty("white.color"));
			Assert.assertEquals(sa.leftmenuPanelColor("Upload Status"),properties.getProperty("white.color"));
			Assert.assertEquals(sa.leftmenuPanelColor("History"),properties.getProperty("white.color"));
			Assert.assertEquals(sa.leftmenuPanelColor("Audit log"),properties.getProperty("white.color"));
			Assert.assertEquals(sa.leftmenuPanelColor("Imaging links"),properties.getProperty("white.color"));
			Assert.assertEquals(sa.leftmenuPanelColor("Settings"),properties.getProperty("white.color"));
	} catch (Exception e) {
		logger.error("Step: Caught exception:: " + e.toString());
		exception = e;
		}
	}
	
	@When("the user clicks on File Dashboard in the left menu panel")
	public void the_user_clicks_on_file_dashboard_in_the_left_menu_panel() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user clicks on File Dashboard in the left menu panel");
			sa.clickOnDashboardButton();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the File Dashboard menu in the left menu panel is highlighted in green color")
	public void the_File_Dashboard_menu_in_the_left_menu_panel_is_highlighted_in_green_color() throws IOException{
		try {
			Properties properties = reader.getProperty();
			logger.info("Step: the File Dashboard menu in the left menu panel is highlighted in green color");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			Assert.assertEquals(sa.leftmenuPanelColor("File Dashboard"),properties.getProperty("green.color"));
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the following are displayed above File Dashboard menu in the left menu panel")
	public void the_following_are_displayed_above_file_dashboard_menu_in_the_left_menu_panel(List<Map<String, String>> dt) throws IOException, InterruptedException {
		try {
			logger.info("Step: the following are displayed above File Dashboard menu in the left menu panel");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				Properties properties = reader.getProperty();
				if (list.get(i).get("options").equals("IC admin profile picture")) {
					Assert.assertTrue(ui.profilePicture());
				}
				else if(list.get(i).get("options").equals("IC admin user name")) {
					Assert.assertTrue(sa.nameOfUser());
				}
				else {
					Assert.assertTrue(sa.roleOfUser());
				}
					
			}
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the logout button is displayed in white colour at the bottom navigation in the left menu panel")
	public void the_logout_button_is_displayed_in_white_colour_at_the_bottom_navigation_in_the_left_menu_panel() {
		try {
			logger.info("Step: the logout button is displayed in white colour at the bottom navigation in the left menu panel");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			Properties properties = reader.getProperty();
			Assert.assertEquals(sa.leftmenuPanelColor("Logout Button"),properties.getProperty("white.color"));
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
