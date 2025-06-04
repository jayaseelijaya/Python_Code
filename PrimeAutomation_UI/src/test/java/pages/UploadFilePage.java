
package pages;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class UploadFilePage {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(UploadFilePage.class);
	Utility utility = new Utility();
	Screenshot screenshot = new Screenshot();
	HistoryViewScreenPage history = new HistoryViewScreenPage();

	/**
	 * This method is used to get Title of the page.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String getPageTitle() {
		String Title = LoginPage.driver.getTitle();
		return Title;
	}

	/**
	 * This method is used to perform click.
	 * 
	 * @throws IOException
	 */
	public void clickOnUploadFilesFromLeftMenu() throws IOException {
		WebElement history = utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.search.xpath");
		if (!history.isDisplayed()) {
			WebElement element = utility.initializeElement(LoginPage.driver, "uploadfiles.img.xpath");
			WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.elementToBeClickable(element));

			wait.click();
		} else {
			WebElement element = utility.initializeElement(LoginPage.driver, "uploadfiles.img.xpath");
			WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.elementToBeClickable(element));

			wait.click();
		}
	}

	/**
	 * This method is used to check right sides components displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isRightSideInfoDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("Upload file icon")) {
			WebElement element = utility.initializeElement(LoginPage.driver, "uploadfiles.img.uploadicon.xpath");
			WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.visibilityOf(element));
			return wait;
		}
		if (component.equalsIgnoreCase("Upload file button")) {
			WebElement element = utility.initializeElement(LoginPage.driver, "uploadfiles.btn.upload.xpath");
			WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.visibilityOf(element));
			return wait;
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}

	/**
	 * This method is used to check facility selection modal displayed or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isFacilitySelectionModalDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "uploadfiles.modal.newfacilityselection.xpath")
				.isDisplayed();
	}

	/**
	 * This method is used to check surgeon selection modal displayed or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isSurgeonSelectionModalDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "uploadfiles.modal.newsurgeonselection.xpath").isDisplayed();
	}

	/**
	 * This method is used to perform click.
	 * 
	 * @throws IOException
	 */
	public void clickOnAnyFacility() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver, "uploadfiles.facilityselection.second.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
	}

	/**
	 * This method is used to perform select a surgeon.
	 * 
	 * @throws IOException
	 */
	public void selectASurgeon() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver, "uploadfiles.surgeonselection.first.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
	}

	/**
	 * This method is used to perform select a surgeon.
	 * 
	 * @throws IOException
	 */
	public void selectApplication() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"uploadfiles.applicationselection.first.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
	}

	/**
	 * This method is used to perform click.
	 * 
	 * @throws IOException
	 */
	public void clickOnNextButton() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver, "uploadfiles.btn.surgeon.next.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
	}

	/**
	 * This method is used to perform click.
	 * 
	 * @throws IOException
	 */
	public void clickOnUploadFilesIcon() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver, "uploadfiles.img.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
	}

	/**
	 * This method is used to perform click.
	 * 
	 * @throws IOException
	 */
	public void clickOnBrowsePcButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "upload.browsepc.btn.xpath").click();
	}

	/**
	 * This method is to check the upload files page header
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkUploadFilesHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "upload.txt.title.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Upload files page header is displayed");
			return true;
		} else {
			logger.info("Upload files page header is not displayed");
			return false;
		}
	}

	/**
	 * This method is to upload valid dicom files using the windows file explorer
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void uploadUsingWindows() throws IOException, InterruptedException {
		Actions actions = new Actions(LoginPage.driver);
		WebElement uploadBox = utility.initializeElement(LoginPage.driver, "upload.dragdrop.xpath");
		actions.moveToElement(uploadBox).click().build().perform();
		Thread.sleep(5000);
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		String SSPath = screenshot.autoITScreenshot(new Throwable().getStackTrace()[0].getMethodName() + "1",
				LoginPage.driver);
		String SSPath2 = screenshot.autoITScreenshot(new Throwable().getStackTrace()[0].getMethodName() + "2",
				LoginPage.driver);
		String autoItScriptPath = System.getProperty("user.dir") + "\\src\\test\\resources\\autoit\\FileUpload.exe";
		String validDicomFolderPath = System.getProperty("user.dir") + "\\src\\test\\resources\\datasets\\valid\\";
		String[] cmd = { autoItScriptPath, validDicomFolderPath, SSPath, SSPath2 };
		Runtime.getRuntime().exec(cmd);
		Thread.sleep(10000);
	}

	/**
	 * This method is to upload invalid dicom files using the windows file explorer
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void uploadInvalidUsingWindows() throws IOException, InterruptedException {
		Actions actions = new Actions(LoginPage.driver);
		WebElement uploadBox = utility.initializeElement(LoginPage.driver, "upload.dragdrop.xpath");
		actions.moveToElement(uploadBox).click().build().perform();
		Thread.sleep(5000);
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		String SSPath = screenshot.autoITScreenshot(new Throwable().getStackTrace()[0].getMethodName() + "1",
				LoginPage.driver);
		String SSPath2 = screenshot.autoITScreenshot(new Throwable().getStackTrace()[0].getMethodName() + "2",
				LoginPage.driver);
		String autoItScriptPath = System.getProperty("user.dir") + "\\src\\test\\resources\\autoit\\FileUpload.exe";
		String validDicomFolderPath = System.getProperty("user.dir") + "\\src\\test\\resources\\datasets\\invalid\\";
		String[] cmd = { autoItScriptPath, validDicomFolderPath, SSPath, SSPath2 };
		Runtime.getRuntime().exec(cmd);
		Thread.sleep(10000);
	}

	/**
	 * This method is to upload non dicom files using the windows file explorer
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void uploadNonDicomUsingWindows() throws IOException, InterruptedException {
		Actions actions = new Actions(LoginPage.driver);
		WebElement uploadBox = utility.initializeElement(LoginPage.driver, "upload.dragdrop.xpath");
		actions.moveToElement(uploadBox).click().build().perform();
		Thread.sleep(5000);
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		String SSPath = screenshot.autoITScreenshot(new Throwable().getStackTrace()[0].getMethodName() + "1",
				LoginPage.driver);
		String SSPath2 = screenshot.autoITScreenshot(new Throwable().getStackTrace()[0].getMethodName() + "2",
				LoginPage.driver);
		String autoItScriptPath = System.getProperty("user.dir") + "\\src\\test\\resources\\autoit\\FileUpload.exe";
		String validDicomFolderPath = System.getProperty("user.dir") + "\\src\\test\\resources\\datasets\\non_dicom\\";
		String[] cmd = { autoItScriptPath, validDicomFolderPath, SSPath, SSPath2 };
		Runtime.getRuntime().exec(cmd);
		Thread.sleep(10000);
	}
	
String autoItScriptPath = System.getProperty("user.dir") + "\\src\\test\\resources\\autoit\\FileUpload.exe";
	
	/**
	 * This method is used to verify Select Folder To Upload Pop up is displayed 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectFolderPopUpIsDisplayed() throws IOException, InterruptedException {
		String SSPath = screenshot.autoITScreenshot(new Throwable().getStackTrace()[0].getMethodName() + "1",
				LoginPage.driver);
		String[] cmd = { autoItScriptPath, "", SSPath, "", "screenshot" };
		Runtime.getRuntime().exec(cmd);
		Thread.sleep(3000);
	}
	
	/**
	 * This method is used to click cancel on the Select Folder To Upload Pop up
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickCancelInSelectFilePopUp() throws IOException, InterruptedException {
		String[] cmd = { autoItScriptPath, "", "", "","cancel" };
		Runtime.getRuntime().exec(cmd);
		Thread.sleep(3000);
	}
	
	/**
	 * This method is used to select the file for upload and click on upload button on Select Folder To Upload Pop up
	 * @param dicomFileName
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void uploadFile(String dicomFileName) throws IOException, InterruptedException {
		String validDicomFolderPath = System.getProperty("user.dir") + "\\src\\test\\resources\\datasets\\"+dicomFileName;
		String SSPath = screenshot.autoITScreenshot(new Throwable().getStackTrace()[0].getMethodName() + "1",
				LoginPage.driver);
		String[] cmd = { autoItScriptPath, validDicomFolderPath, SSPath, "","select file" };
		Runtime.getRuntime().exec(cmd);
		Thread.sleep(5000);
	}
	
	/**
	 * This method is used to check alert for Upload is displayed 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void alertIsDisplayed() throws IOException, InterruptedException {
		String SSPath = screenshot.autoITScreenshot(new Throwable().getStackTrace()[0].getMethodName() + "1",
				LoginPage.driver);
		String[] cmd = { autoItScriptPath, "", SSPath, "", "alert screenshot" };
		Runtime.getRuntime().exec(cmd);
		Thread.sleep(3000);
	}
	
	public static String uploadTime = null;
	
	/**
	 * This method is used to click on upload button in the Upload File Alert
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickUploadInAlert() throws IOException, InterruptedException {
		String SSPath2 = screenshot.autoITScreenshot(new Throwable().getStackTrace()[0].getMethodName() + "2",
				LoginPage.driver);
		String[] cmd = { autoItScriptPath, "", "", SSPath2, "upload" };
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");  
		LocalDateTime now = LocalDateTime.now();  
		Runtime.getRuntime().exec(cmd);
		Thread.sleep(3000);
		uploadTime = dtf.format(now);
		logger.info("uploadTime: " +uploadTime);
	}
	
	/**
	 * This method is used to click on cancel button in the Upload File Alert
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickCancelInAlert() throws IOException, InterruptedException {
		String[] cmd = { autoItScriptPath, "", "", "", "upload" };
		Runtime.getRuntime().exec(cmd);
		Thread.sleep(3000);
	}
	
	/**
	 * This method is used for uploading file
	 * 1.the file to be uploaded is passed to Select Folder To Upload Pop up
	 * 2.Upload button in Select Folder To Upload Pop up is clicked
	 * 3.Upload button in Upload Alert is clicked
	 * @param dicomFileName
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void uploadFileCompleteFlow(String dicomFileName) throws IOException, InterruptedException {
		uploadFile(dicomFileName);
		clickUploadInAlert();
	}
	
	/**
	 * This method is used to check uploaded record is shown in upload status screen
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public boolean checkUploadStatusFirstRecordMatchesLastUpload() throws IOException, ParseException {
    	Properties properties = reader.getProperty();
    	String organization = properties.getProperty("available.site1");
    	String surgeon = properties.getProperty("available.site1.surgeon1");
    	String application = properties.getProperty("available.application1");
    	String dateTimeXpath = properties.getProperty("uploadsatus.datetime.value.text");
    	WebElement firstRecordElement = utility.initializeElement(LoginPage.driver, "uploadstatus.btn.firstentry.xpath");
    	String firstRecord = firstRecordElement.getText();
		logger.info("First record in Upload Status: " + firstRecord);
		if(firstRecord.contains(organization) && firstRecord.contains(surgeon) && firstRecord.contains(application)) {
			logger.info("###################" + uploadTime);
			logger.info("###################" +firstRecordElement.findElement(By.xpath(dateTimeXpath)).getText());
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
			Date date1 = format.parse(uploadTime);
			Date date2 = format.parse(firstRecordElement.findElement(By.xpath(dateTimeXpath)).getText());
			long difference = date2.getTime() - date1.getTime(); 
			logger.info("###################" + difference);
			return true;
		}else {
			return false;
		}
    	
    	
    }
	
	/**
	 * This method is used to perform click on back button.
	 * 
	 * @throws IOException
	 */
	public void clickOnSiteSeclectionBackBtn() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.backbutton.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.elementToBeClickable(element));
		wait.click();
		logger.info("Back button is clicked");
	}
	
	/**
	 * This method is used to check hovered site highlighted or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isHoveredSiteHighlighted() throws IOException {
		logger.info("Hovered site is highlighted : " +utility.initializeElement(LoginPage.driver, "upload.site.highlighted.xpath")
				.isEnabled());
		logger.info("Hovered site is highlighted in green color as : " +utility.initializeElement(LoginPage.driver, "upload.site.highlighted.xpath")
		.getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "upload.site.highlighted.xpath")
				.isEnabled();
	}
	
	/**
	 * This method is used to check close button displayed or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isCloseBtnDisplayed() throws IOException {
		logger.info("Popup close button is displayed : " +utility.initializeElement(LoginPage.driver, "upload.idontsee.btn.close.xpath")
				.isDisplayed());
		return utility.initializeElement(LoginPage.driver, "upload.idontsee.btn.close.xpath")
				.isDisplayed();
	}
	
	/**
	 * This method is used to check x button displayed or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isXBtnDisplayed() throws IOException {
		logger.info("X button is displayed : " +utility.initializeElement(LoginPage.driver, "upload.idontsee.x.xpath")
				.isDisplayed());
		logger.info("X button is displayed in white color as : " +utility.initializeElement(LoginPage.driver, "upload.idontsee.x.xpath")
		.getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "upload.idontsee.x.xpath")
				.isDisplayed();
	}
	
	/**
	 * This method is used to perform click on close button.
	 * 
	 * @throws IOException
	 */
	public void clickOnCloseBtn() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.idontsee.btn.close.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.elementToBeClickable(element));
		wait.click();
		logger.info("Close button is clicked");
	}
	
	/**
	 * This method is used to check searchbox highlighted or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isSearchBoxHighlighted() throws IOException {
		logger.info("Searchbox is highlighted : " +utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath")
				.isEnabled());
		return utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath")
				.isEnabled();
	}
	
	/**
	 * This method is used to check next button disabled or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isNextButtonDisabled() throws IOException {
		logger.info("Next button is disabled : " +utility.initializeElement(LoginPage.driver, "upload.nextbutton.xpath")
				.isEnabled());
		return utility.initializeElement(LoginPage.driver, "upload.nextbutton.xpath")
				.isEnabled();
	}
	
	/**
	 * This method is used to check breadcrumb displayed or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isBreadcrumbDisplayed() throws IOException {
		try {
		logger.info("Breadcrumb is displayed : " +utility.initializeElement(LoginPage.driver, "upload.bredcrumb.xpath")
				.isEnabled());
		return utility.initializeElement(LoginPage.driver, "upload.bredcrumb.xpath")
				.isEnabled();
		}catch(Exception e) {
			return false;
		}
		
	}
	
	/**
	 * This method is used to check next button enabled or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isNextButtonEnabled() throws IOException {
		logger.info("Next button is enabled : " +utility.initializeElement(LoginPage.driver, "upload.nextbutton.xpath")
				.isEnabled());
		logger.info("Next button is highlighted in green color as : " +utility.initializeElement(LoginPage.driver, "upload.nextbutton.xpath")
		.getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "upload.nextbutton.xpath")
				.isEnabled();
	}
	
	/**
	 * This method is used to perform click on next button.
	 * 
	 * @throws IOException
	 */
	public void clickOnNextBtn() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.nextbutton.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
		logger.info("Next button is clicked");
	}
	
	/**
	 * This method is used to perform click on i don't see surgeon listed.
	 * 
	 * @throws IOException
	 */
	public void clickOnIdontseeSurgeon() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.siteselection.idontseemy.text.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
		logger.info("I don't see my surgeon is clicked");
	}
	
	/**
	 * This method is used to hover over one site name
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void hoverOverSurgeonName() throws IOException, InterruptedException {
		WebElement surgeon = utility.initializeElement(LoginPage.driver, "upload.surgeon.list.first.xpath");
		Actions action = new Actions(LoginPage.driver);
		action.moveToElement(surgeon).perform();
	}
	
	/**
	 * This method is used to check hovered surgeon highlighted or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isHoveredSurgeonHighlighted() throws IOException {
		logger.info("Hovered surgeon is highlighted : " +utility.initializeElement(LoginPage.driver, "upload.surgeon.list.first.xpath")
				.isEnabled());
		logger.info("Hovered surgeon is highlighted in teal color as : " +utility.initializeElement(LoginPage.driver, "upload.surgeon.list.first.xpath")
		.getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "upload.surgeon.list.first.xpath")
				.isEnabled();
	}
	
	/**
	 * This method is used to remove text from searchbox
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clearSearchbox() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath").clear();
		utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath").click();
		
	}
	
	/**
	 * This method is used to check surgeon search placeholder or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isSurgeonSearchPlaceholderDisplayed() throws IOException {
		logger.info("Surgeon search placeholder text displayed as : " +utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath")
				.getAttribute("placeholder"));
		return utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath")
				.isDisplayed();
	}
	
	/**
	 * This method is used to check hovered surgeon highlighted or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isSurgeonScreenDisplayed() throws IOException {
		logger.info("Surgeon selection screen is displayed : " +utility.initializeElement(LoginPage.driver, "upload.surgeon.screen.xpath")
				.isDisplayed());
		return utility.initializeElement(LoginPage.driver, "upload.surgeon.screen.xpath")
				.isDisplayed();
	}
	
	/**
	 * This method is used to perform click on i don't see surgeon listed.
	 * 
	 * @throws IOException
	 */
	public void clickOnIdontseeApplication() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.siteselection.idontseemy.text.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
		logger.info("I don't see my application is clicked");
	}
	
	/**
	 * This method is used to check no next screen without site selection  or not.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean NoNextScreenWithoutSiteSelection() throws IOException {
		utility.initializeElement(LoginPage.driver, "upload.nextbutton.xpath").click();
		logger.info("Next button is not clicked and user can not proceed to next screen");
		return utility.initializeElement(LoginPage.driver, "upload.nextbutton.xpath")
				.isEnabled();
	}
	
	/**
	 * This method is used to click on site.
	 * 
	 * @throws IOException
	 */
	public void select1st2ndSite() throws IOException {
		utility.initializeElement(LoginPage.driver,
				"upload.site.list.first.xpath").click();
		logger.info("First site is selected");
		utility.initializeElement(LoginPage.driver,
				"upload.site.list.second.xpath").click();
		logger.info("Second site is selected");
	}
	
	/**
	 * This method is used to check user not able to select multiple site.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public boolean isMultipleSiteSelected() throws IOException {
		utility.initializeElement(LoginPage.driver, "upload.site.list.first.xpath").isEnabled();
		logger.info("First site is not selected");
		utility.initializeElement(LoginPage.driver, "upload.site.list.second.xpath")
		.isEnabled();
		logger.info("Second site is selected");
		return utility.initializeElement(LoginPage.driver, "upload.site.list.second.xpath")
				.isEnabled();
	}
	
	/**
	 * This method is used to check upload failure Screen details displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isUploadFailureScreenDetailsDisplayed(String detail) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (detail.equalsIgnoreCase("Breadcrumb of selected Site name, surgeon name application name")) {
			
			WebElement element = utility.initializeElement(LoginPage.driver,
					"upload.bredcrumb.xpath");
			WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.elementToBeClickable(element));
			logger.info("Breadcrumb is displayed as : "+wait.getText());
			
			return wait;
		}
		if (detail.equalsIgnoreCase("Failed icon")) {
			return utility.initializeElement(LoginPage.driver, "upload.logo.failed.xpath");
		}
		if (detail.equalsIgnoreCase("upload failed text")) {
			return utility.initializeElement(LoginPage.driver, "upload.txt.uploadfailed.xpath");
		}
		if (detail.equalsIgnoreCase("total size exceeded the limit of 3gb message")) {
			logger.info("Error message displayed as : " +utility.initializeElement(LoginPage.driver, "upload.txt.errormessage.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "upload.txt.errormessage.xpath");
		}
		if (detail.equalsIgnoreCase("yellow progress bar")) {
			return utility.initializeElement(LoginPage.driver, "upload.yellow.progressbar.xpath");
		}
		if (detail.equalsIgnoreCase("start new upload and reupload buttons")) {
			utility.initializeElement(LoginPage.driver, "upload.btn.reupload.xpath").isDisplayed();
			return utility.initializeElement(LoginPage.driver, "upload.btn.newupload.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + detail);
		return null;
	}
	
	/**
	 * This method is used to check failed status is shown in upload status screen
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public boolean isFailedStatusShown() throws IOException, ParseException {
		WebElement firstRecordElement = utility.initializeElement(LoginPage.driver, "uploadstatus.btn.firstentry.xpath");
		String firstRecord = firstRecordElement.getText();
		boolean isFailedDisplayed = firstRecord.contains("Failed");
		return checkUploadStatusFirstRecordMatchesLastUpload() && isFailedDisplayed;
	}
	
	/**
	 * This method is used to check "Uploading" status is shown in upload status screen
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public boolean isUploadingStatusShown() throws IOException, ParseException {
		WebElement firstRecordElement = utility.initializeElement(LoginPage.driver, "uploadstatus.btn.firstentry.xpath");
		String firstRecord = firstRecordElement.getText();
		boolean isFailedDisplayed = firstRecord.contains("Uploading");
		return checkUploadStatusFirstRecordMatchesLastUpload() && isFailedDisplayed;
	}
	
	/**
	 * This method is used to check record is not displayed in history screen when user logs out of the application in the middle of uploading a file.
	 * @return
	 * @throws IOException 
	 * 
	 */
	public boolean isUploadNotDisplayedInHistoryScreen() throws IOException {
		logger.info(history.HistoryItems(0,"Date").getText());
		logger.info(uploadTime);
		return !(history.HistoryItems(0,"Date").getText().contains(uploadTime));
	}
	
	/**
	 * This method is used to check record is not displayed in Upload Status screen when user logs out of the application in the middle of uploading a file.
	 * @return
	 * @throws IOException 
	 * 
	 */
	public boolean isUploadNotDisplayedInUploadStatusScreen() throws IOException {
		try {
			WebElement firstRecordElement = utility.initializeElement(LoginPage.driver, "uploadstatus.btn.firstentry.xpath");
			String firstRecord = firstRecordElement.getText();
			return !(firstRecord.contains(uploadTime));
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return utility.initializeElement(LoginPage.driver, "uploadstatus.norecentuploads.text.xpath").isDisplayed();
		}
	}
	
}
