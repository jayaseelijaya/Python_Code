package pages;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Utility;

public class UserInformationPage {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(UserInformationPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to check if the S&N Logo is displayed
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isLogoDisplayed() throws IOException {
		logger.info("S&N Logo is displayed (T/F) : "
				+ utility.initializeElement(LoginPage.driver, "user.text.logo.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "user.text.logo.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if the ProfilePicture is displayed.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean profilePicture() throws IOException {
		WebElement imageWebElement = utility.initializeElement(LoginPage.driver, "user.text.profilepic.xpath");
		Boolean isImageLoaded = (Boolean) ((JavascriptExecutor) LoginPage.driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				imageWebElement);
		logger.info("Profile Picture of the Logged-in user is displayed (T/F) :" + isImageLoaded);
		return isImageLoaded;
	}

	/**
	 * This method is used to get text for user name
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String getLoggedUserName() throws IOException, InterruptedException {
		return utility.initializeElement(LoginPage.driver, "user.txt.name.xpath").getText();
	}

	/**
	 * This method is used to get text for user role
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String getUserRole() throws IOException, InterruptedException {
		return utility.initializeElement(LoginPage.driver, "user.text.userrole.xpath").getText();
	}

	/**
	 * This method is used to check Left navigation information
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isLeftNavigationInfoDisplayed(String info) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (info.equalsIgnoreCase("SN logo")) {
			return utility.initializeElement(LoginPage.driver, "user.text.logo.xpath");
		}
		if (info.equalsIgnoreCase("Profile image")) {
			return utility.initializeElement(LoginPage.driver, "user.text.profilepic.xpath");
		}
		if (info.equalsIgnoreCase("File dashboard")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath");
		}
		if (info.equalsIgnoreCase("Upload files")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.uploadfiles.xpath");
		}
		if (info.equalsIgnoreCase("Upload status")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath");
		}
		if (info.equalsIgnoreCase("History")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath");
		}
		if (info.equalsIgnoreCase("Audit log")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.auditlog.xpath");
		}
		if (info.equalsIgnoreCase("imaging links")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath");
		}
		if (info.equalsIgnoreCase("settings")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.settings.xpath");
		}
		if (info.equalsIgnoreCase("Exit to app")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.exittoapp.xpath");
		}
		if (info.equalsIgnoreCase("Choose Site")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.choosesite.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + info);
		return null;
	}
	
	/**
	 * This method is used to check if the S&N heading displayed
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSmithNephewHeadingDisplayed() throws IOException {
		logger.info("S&N heading is displayed as : "
				+ utility.initializeElement(LoginPage.driver, "user.text.heading.xpath").getAttribute("title"));
		logger.info("S&N heading color is : "
				+ utility.initializeElement(LoginPage.driver, "user.text.heading.xpath").getCssValue("color"));
		
		return utility.initializeElement(LoginPage.driver, "user.text.heading.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check upload dashboard components displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isUploadDashboardComponentsDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("dashboard heading")) {
			return utility.initializeElement(LoginPage.driver,
					"leftnavigation.txt.header.dashboard.xpath");
		}
		if (component.equalsIgnoreCase("uploaded records table")) {
			return utility.initializeElement(LoginPage.driver,
					"dashboard.table.records.xpath");
		}
		if (component.equalsIgnoreCase("processing status checkbox")) {
			return utility.initializeElement(LoginPage.driver,
					"dashboard.processing.checkbox.xpath");
		}
		if (component.equalsIgnoreCase("uploaded status checkbox")) {
			return utility.initializeElement(LoginPage.driver,
					"dashboard.checkbox.uploaded.xpath");
		}
		if (component.equalsIgnoreCase("complete status checkbox")) {
			return utility.initializeElement(LoginPage.driver,"dashboard.checkbox.complete.xpath");
		}
		if (component.equalsIgnoreCase("error status checkbox")) {
			return utility.initializeElement(LoginPage.driver,
					"dashboard.checkbox.error.xpath");
		}
		if (component.equalsIgnoreCase("24hrs checkbox")) {
			return utility.initializeElement(LoginPage.driver,
					"dashboard.checkbox.btn.xpath");
		}
		if (component.equalsIgnoreCase("filter")) {
			return utility.initializeElement(LoginPage.driver,
					"dashboard.filter.xpath");
		}
		if (component.equalsIgnoreCase("search box")) {
			return utility.initializeElement(LoginPage.driver,
					"dashboard.searchbox.xpath");
		}
		if (component.equalsIgnoreCase("search button")) {
			return utility.initializeElement(LoginPage.driver,
					"dashboard.btn.search.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}
	
	/**
	 * This method is used to check upload files components displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isUploadFilesComponentsDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("upload files heading")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.txt.title.xpath");
		}
		if (component.equalsIgnoreCase("upload icon")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.icon.xpath");
		}
		if (component.equalsIgnoreCase("upload button")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.btn.click.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}
	
	/**
	 * This method is used to check upload status components displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isUploadStatusComponentsDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("upload status heading")) {
			return utility.initializeElement(LoginPage.driver,
					"leftnavigation.txt.header.uploadstatus.xpath");
		}
		if (component.equalsIgnoreCase("uploaded records table")) {
			return utility.initializeElement(LoginPage.driver,
					"uploadstatus.table.xpath");
		}
		if (component.equalsIgnoreCase("view details buttom")) {
			return utility.initializeElement(LoginPage.driver,
					"uploadstatus.btn.viewdetails.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}
	
	/**
	 * This method is used to check history components displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isHistoryComponentsDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("history heading")) {
			return utility.initializeElement(LoginPage.driver,
					"leftnavigation.txt.header.history.xpath");
		}
		if (component.equalsIgnoreCase("24hrs checkbox")) {
			return utility.initializeElement(LoginPage.driver,
					"history.checkbox.twentyfourhrs.xpath");
		}
		if (component.equalsIgnoreCase("filter")) {
			return utility.initializeElement(LoginPage.driver,
					"history.filter.xpath");
		}
		if (component.equalsIgnoreCase("search textbox")) {
			return utility.initializeElement(LoginPage.driver,
					"history.btn.searchbox.xpath");
		}
		if (component.equalsIgnoreCase("search button")) {
			return utility.initializeElement(LoginPage.driver,"history.btn.search.xpath");
		}
		if (component.equalsIgnoreCase("record table")) {
			return utility.initializeElement(LoginPage.driver,
					"history.table.xpath");
		}
		if (component.equalsIgnoreCase("view details button")) {
			return utility.initializeElement(LoginPage.driver,
					"history.btn.viewdetails.xpath");
		}
		if (component.equalsIgnoreCase("show more")) {
			return utility.initializeElement(LoginPage.driver,
					"history.btn.showmore.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}
	
	/**
	 * This method is used to check auditlog components displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isAuditLogComponentsDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("audit log heading")) {
			return utility.initializeElement(LoginPage.driver,
					"leftnavigation.txt.header.auditlog.xpath");
		}
		if (component.equalsIgnoreCase("24hrs checkbox")) {
			return utility.initializeElement(LoginPage.driver,
					"auditlog.filter.24hrs.xpath");
		}
		if (component.equalsIgnoreCase("filter")) {
			return utility.initializeElement(LoginPage.driver,
					"history.filter.xpath");
		}
		if (component.equalsIgnoreCase("search textbox")) {
			return utility.initializeElement(LoginPage.driver,
					"auditlog.txtbox.searchbox.xpath");
		}
		if (component.equalsIgnoreCase("search button")) {
			return utility.initializeElement(LoginPage.driver,"auditlog.btn.search.xpath");
		}
		if (component.equalsIgnoreCase("exported selected")) {
			return utility.initializeElement(LoginPage.driver,
					"auditlog.btn.exportselected.xpath");
		}
		if (component.equalsIgnoreCase("exported all")) {
			return utility.initializeElement(LoginPage.driver,
					"auditlog.btn.exportall.xpath");
		}
		if (component.equalsIgnoreCase("show more")) {
			return utility.initializeElement(LoginPage.driver,
					"auditlog.btn.showmore.xpath");
		}
		if (component.equalsIgnoreCase("audit log list table")) {
			return utility.initializeElement(LoginPage.driver,
					"auditlog.table.row.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}
	
	/**
	 * This method is used to check imaging links components displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isImagingComponentsDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("list of linked facilities")) {
			return utility.initializeElement(LoginPage.driver,
					"facilitylinking.list.xpath");
		}
		if (component.equalsIgnoreCase("remove button")) {
			return utility.initializeElement(LoginPage.driver,
					"facilitylinking.btn.remove.xpath");
		}
		if (component.equalsIgnoreCase("create button")) {
			return utility.initializeElement(LoginPage.driver,
					"imaginglinks.btn.createlink.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}
	
	/**
	 * This method is used to check settings components displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isSettingsComponentsDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("heading")) {
			return utility.initializeElement(LoginPage.driver,
					"leftnavigation.txt.header.settings.xpath");
		}
		if (component.equalsIgnoreCase("successful expiration")) {
			return utility.initializeElement(LoginPage.driver,
					"setting.txt.successfuluploadexpiry.xpath");
		}
		if (component.equalsIgnoreCase("unsuccessful expiration")) {
			return utility.initializeElement(LoginPage.driver,
					"setting.txt.unsuccessfuluploadexpiry.xpath");
		}
		if (component.equalsIgnoreCase("global viewing toggle button")) {
			return utility.initializeElement(LoginPage.driver,
					"setting.btn.toggle.globalviewing.xpath");
		}
		if (component.equalsIgnoreCase("reset to default")) {
			return utility.initializeElement(LoginPage.driver,
					"setting.btn.resettodefault.xpath");
		}
		if (component.equalsIgnoreCase("save button")) {
			return utility.initializeElement(LoginPage.driver,
					"setting.btn.save.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}
	
	/**
	 * This method is used to click on software information icon.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSoftwareInformationIcon() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "softwareinformation.btn.xpath").click();
			logger.info("clickOnSoftwareInformationIcon : Clicked Software information icon ");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//span/img[@id=\"info_icon\"][2]")));
			logger.info("clickOnSoftwareInformationIcon : Clicked Software information icon");
		}
	}
	
	/**
	 * This method is used to check if software information popupbox displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSoftwareInformationPopupDisplayed() throws IOException {
		logger.info("Software information popupbox is displayed : "
				+ utility.initializeElement(LoginPage.driver, "softwareinformation.popupbox.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "softwareinformation.popupbox.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check if software version displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSoftwareVersionDisplayed() throws IOException {
		logger.info("Software version is displayed : "
				+ utility.initializeElement(LoginPage.driver, "softwareinformation.version.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "softwareinformation.version.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check if software version displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isCrossButtonDisplayed() throws IOException {
		logger.info("Cross button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "softwareinformation.btn.cross.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "softwareinformation.btn.cross.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to click on cross button.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnCrossButton() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "softwareinformation.btn.cross.xpath").click();
			logger.info("clickOnCrossButton : Clicked cross button ");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//div[@class=\"modal-body\"]/img")));
			logger.info("clickOnCrossButton : Clicked cross button");
		}
	}
}
