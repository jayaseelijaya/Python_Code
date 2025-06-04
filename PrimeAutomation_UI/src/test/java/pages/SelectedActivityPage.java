
package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Utility;

public class SelectedActivityPage {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(SelectedActivityPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to click on dashboard button screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnDashboardButton() throws IOException, InterruptedException {
		logger.info("clickOnDashboardButton : Clicked dashbaord button");
		{
			try {
				utility.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath").click();
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
				executor.executeScript("arguments[0].click();",
				utility.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath"));
			}
		}
	}

	/**
	 * This method is used to check if dashboard button highlighted or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isDashboardHighlighted() throws IOException {
		logger.info("Dashboard button is highlighted : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if dashboard header displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public Boolean isDashboardHeaderDisplayed() throws IOException, InterruptedException {
		Thread.sleep(10000);
		logger.info("Dashboard header is displayed : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.dashboard.xpath").isDisplayed());
		logger.info("Dashboard header is displayed as : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.dashboard.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.dashboard.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if upload files button highlighted or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isUploadFilesHighlighted() throws IOException {
		logger.info("Upload Files button is highlighted : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.uploadfiles.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "leftnavigation.uploadfiles.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if upload files header displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isUploadFilesHeaderDisplayed() throws IOException {
		logger.info("Upload Files header is displayed : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.uploadfiles.xpath").isDisplayed());
		logger.info("Upload Files header is displayed as : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.uploadfiles.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.uploadfiles.xpath").isDisplayed();
	}

	/**
	 * This method is used to click on upload status button screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnUploadStatusButton() throws IOException, InterruptedException {
		logger.info("clickOnUploadStatusButton : Clicked upload status button");
		{
			try {
				utility.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath").click();
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
				executor.executeScript("arguments[0].click();",
						utility.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath"));
			}
		}
	}

	/**
	 * This method is used to check if upload status button highlighted or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isUploadStatusHighlighted() throws IOException {
		logger.info("upload status button is highlighted : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if upload status header displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isUploadStatusHeaderDisplayed() throws IOException {
		logger.info("upload status header is displayed : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.uploadstatus.xpath").isDisplayed());
		logger.info("upload status header is displayed as : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.uploadstatus.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.uploadstatus.xpath")
				.isDisplayed();
	}

	/**
	 * This method is used to click on history button screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnHistoryButton() throws IOException, InterruptedException {
		logger.info("clickOnHistoryButton : Clicked history button");
		{
			try {
				Thread.sleep(1000);
				utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath").click();
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
				executor.executeScript("arguments[0].click();",
						utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath"));
			}
		}
	}

	/**
	 * This method is used to check if history button highlighted or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isHistoryHighlighted() throws IOException {
		logger.info("History button is highlighted : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.history.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if history header displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isHistoryHeaderDisplayed() throws IOException {
		logger.info("History header is displayed : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.history.xpath").isDisplayed());
		logger.info("History header is displayed as : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.history.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.history.xpath")
				.isDisplayed();
	}

	/**
	 * This method is used to click on audit log button screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnAuditLogButton() throws IOException, InterruptedException {
		logger.info("clickOnAuditLogButton : Clicked audit log button");
		{
			try {
				utility.initializeElement(LoginPage.driver, "leftnavigation.auditlog.xpath").click();
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
				executor.executeScript("arguments[0].click();",
						utility.initializeElement(LoginPage.driver, "leftnavigation.auditlog.xpath"));
			}
		}
	}

	/**
	 * This method is used to check if audit log button highlighted or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isAuditLogHighlighted() throws IOException {
		logger.info("Audit Log button is highlighted : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.auditlog.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "leftnavigation.auditlog.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if audit log header displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isAuditLogHeaderDisplayed() throws IOException {
		logger.info("Audit Log header is displayed : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.auditlog.xpath").isDisplayed());
		logger.info("Audit Log header is displayed as : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.auditlog.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.auditlog.xpath").isDisplayed();
	}

	/**
	 * This method is used to click on imaging links button screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnImagingLinksButton() throws IOException, InterruptedException {
		logger.info("clickOnAuditLogButton : Clicked imaging links button");
		{
			try {
				WebElement element = utility.initializeElement(LoginPage.driver,
						"leftnavigation.imaginglinks.xpath");
				WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
						.until(ExpectedConditions.visibilityOf(element));
				 wait.click();
				//utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath").click();
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
				executor.executeScript("arguments[0].click();",
						utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath"));
			}
		}
	}

	/**
	 * This method is used to check if imaging links button highlighted or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isImagingLinksHighlighted() throws IOException {
		logger.info("Imaging Links button is highlighted : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if imaging links header displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isImagingLinksHeaderDisplayed() throws IOException {
		logger.info("Imaging Links header is displayed : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.imaginglinks.xpath").isDisplayed());
		logger.info("Imaging Links header is displayed as : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.imaginglinks.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.imaginglinks.xpath")
				.isDisplayed();
	}

	/**
	 * This method is used to click on settings button screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSettingsButton() throws IOException, InterruptedException {
		logger.info("clickOnAuditLogButton : Clicked Settings button");
		{
			try {
				utility.initializeElement(LoginPage.driver, "leftnavigation.settings.xpath").click();
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
				executor.executeScript("arguments[0].click();",
						utility.initializeElement(LoginPage.driver, "leftnavigation.settings.xpath"));
			}
		}
	}

	/**
	 * This method is used to check if settings button highlighted or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isSettingsHighlighted() throws IOException {
		logger.info("Settings button is highlighted : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.settings.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "leftnavigation.settings.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if settings header displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isSettingsHeaderDisplayed() throws IOException {
		logger.info("Settings header is displayed : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.settings.xpath").isDisplayed());
		logger.info("Settings header is displayed as : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.settings.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.settings.xpath").isDisplayed();
	}

	/**
	 * This method is used to click on exit to app button screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnExitToAppButton() throws IOException, InterruptedException {
		logger.info("Clicked Exit to app button");
		{
			try {
				utility.initializeElement(LoginPage.driver, "leftnavigation.exittoapp.xpath").click();
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
				executor.executeScript("arguments[0].click();",
						utility.initializeElement(LoginPage.driver, "leftnavigation.exittoapp.xpath"));
			}
		}
	}

	/**
	 * This method is used to check if exit to app button highlighted or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isExittoAppHighlighted() throws IOException {
		logger.info("Exit to app button is highlighted : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.exittoapp.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "leftnavigation.exittoapp.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if exit to app header displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isExittoAppHeaderDisplayed() throws IOException {
		logger.info("Exit to app header is displayed : " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.exittoapp.xpath").isDisplayed());
		logger.info("Exit to app header is displayed as : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.exittoapp.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.exittoapp.xpath").isDisplayed();
	}

	/***
	 * This method is used to check what left navigation options should be visible to the user
	 * @param info
	 * @return
	 * @throws IOException
	 */
	public boolean isLeftNavigationInfoDisplayed(String info) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		String elementName = null;
		if (info.equalsIgnoreCase("File Dashboard")) {
			elementName = "leftnavigation.filedashboard.xpath";
		}
		if (info.equalsIgnoreCase("Upload Files")) {
			elementName = "leftnavigation.uploadfiles.xpath";
		
		}
		if (info.equalsIgnoreCase("Upload Status")) {
			elementName = "leftnavigation.uploadstatus.xpath";
		}
		if (info.equalsIgnoreCase("History")) {
			elementName = "leftnavigation.history.xpath";
		}
		if (info.equalsIgnoreCase("Audit log")) {
			elementName = "leftnavigation.auditlog.xpath";
		}
		if (info.equalsIgnoreCase("Imaging links")) {
			elementName = "leftnavigation.imaginglinks.xpath";
		}
		if (info.equalsIgnoreCase("Settings")) {
			elementName = "leftnavigation.settings.xpath";
		}
		if (info.equalsIgnoreCase("info")) {
			elementName = "leftnavigation.info.xpath";
		}
		if (info.equalsIgnoreCase("help")) {
			elementName = "leftnavigation.help.xpath";
		}
		if (info.equalsIgnoreCase("Choose site")) {
			elementName = "leftnavigation.choosesite.xpath";
		}
		try {
			logger.info(info + " is displayed: " + utility.initializeElement(LoginPage.driver, elementName).isDisplayed());
			return utility.initializeElement(LoginPage.driver, elementName).isDisplayed();
		}
		catch(Exception e) {
				logger.info(info + " is displayed: " + false);
				return false;
		}
	}
	
	/***
	 * This method is used to return the color of left menu panel items.
	 * @param info
	 * @return
	 * @throws IOException
	 */
	public String leftmenuPanelColor(String info) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		String elementName = null;
		if (info.equalsIgnoreCase("File Dashboard")) {
			elementName = "leftnavigation.filedashboard.xpath";
		}
		if (info.equalsIgnoreCase("Upload Files")) {
			elementName = "leftnavigation.uploadfiles.xpath";
		}
		if (info.equalsIgnoreCase("Upload Status")) {
			elementName = "leftnavigation.uploadstatus.xpath";
		}
		if (info.equalsIgnoreCase("History")) {
			elementName = "leftnavigation.history.xpath";
		}
		if (info.equalsIgnoreCase("Audit log")) {
			elementName = "leftnavigation.auditlog.xpath";
		}
		if (info.equalsIgnoreCase("Imaging links")) {
			elementName = "leftnavigation.imaginglinks.xpath";
		}
		if (info.equalsIgnoreCase("Settings")) {
			elementName = "leftnavigation.settings.xpath";
		}
		if (info.equalsIgnoreCase("info")) {
			elementName = "leftnavigation.info.xpath";
		}
		if (info.equalsIgnoreCase("help")) {
			elementName = "leftnavigation.help.xpath";
		}
		if (info.equalsIgnoreCase("Choose site")) {
			elementName = "leftnavigation.choosesite.xpath";
		}
		if(info.equalsIgnoreCase("Logout Button")) {
			elementName = "user.logout.btn.xpath";
		}
		logger.info(info + " color: " + utility.initializeElement(LoginPage.driver, elementName).getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, elementName).getCssValue("color");

	}
	
	/**
	 * This method is used to check name of user is displayed.
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean nameOfUser() throws IOException, InterruptedException {
		logger.info("Logged in users's name : "
				+ utility.initializeElement(LoginPage.driver, "user.txt.name.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "user.txt.name.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to Check whether the role of the user is displayed.
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean roleOfUser() throws IOException, InterruptedException {
		logger.info("Logged in users's role : "
				+ utility.initializeElement(LoginPage.driver, "user.text.userrole.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "user.text.userrole.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check choose site is highlighted in left navigation bar
	 * @return
	 * @throws IOException 
	 */
	public boolean isChooseSiteHighlighted() throws IOException {
		Properties properties = reader.getProperty();
		if(leftmenuPanelColor("Choose site").equals(properties.getProperty("green.color"))){
			return true;
		}
		else
			return false;
	}
}
