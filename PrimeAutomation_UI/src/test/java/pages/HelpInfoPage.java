package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Utility;

public class HelpInfoPage {

	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HelpInfoPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to click Help & Info button on left panel screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickHelpIcon() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "help.info.btn.xpath").click();
			logger.info("clickHelpIcon : Clicked Help Icon ");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath(" //*[@id=\"help_icon\"]/img[2]")));
			logger.info("clickHelpIcon : Clicked Help Icon");
		}

	}

	/**
	 * This method is used to click on Download button
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickDownload() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "help.download.btn.xpath").click();
		logger.info("click Download Button : Clicked Download button on PDF viewer");
	}

	/**
	 * This method is used to click on Toggle-Sidebar button
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickToggleSidebar() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "help.sidebartoggle.btn.xpath").click();
		logger.info("click Toogle Sidebar Button : Clicked Toggle Sidebar button on PDF viewer");
	}

	/**
	 * This method is used to click on Document Outline button
	 * 
	 * @throws IOException
	 */
	public void clickDocumentOutline() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.showdocument.btn.xpath").click();
		logger.info("Click Document Outline Button : Cliked Document Outline Button on PDF viewer");
	}

	/**
	 * This method is used to check if Document Outline button is enabled
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isDocumentOutlineEnabled() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "help.showdocument.btn.xpath").isEnabled();
		if (bool == true) {
			logger.info("Document Outline is Enabled");
			return true;
		} else {
			logger.info("Document Outline is Disabled");
			return false;
		}
	}

	/**
	 * This method is used to click on Show attachments button
	 * 
	 * @throws IOException
	 */
	public void clickShowAttachments() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.attachment.btn.xpath").click();
		logger.info("Click Show Attachments Button: Clicked Show Attachments Button on PDF Viewer");
	}

	/**
	 * This method is used to click on Software information icon
	 * 
	 * @throws IOException
	 */
	public void clickSoftwareInformation() throws IOException {
		try {
			utility.initializeElement(LoginPage.driver, "help.software.info.xpath").click();
			logger.info("Click Software Information Icon : Clicked Software Information Icon");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"info_icon\"]")));
		}
		logger.info("Click Software Information Icon : Clicked Software Information Icon");
	}

	/**
	 * This method is used to check if Document Outline button is enabled
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isShowAttachmentsEnabled() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "help.attachment.btn.xpath").isEnabled();
		if (bool == true) {
			logger.info("Show Attachments is Enabled");
			return true;
		} else {
			logger.info("Show Attachments is Disabled");
			return false;
		}
	}

	/**
	 * This method is used to click on Search Icon in PDF Viewer
	 * 
	 * @throws IOException
	 */
	public void clickSearchButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.search.btn.xpath").click();
		logger.info("Click Search Icon Button: Clicked Search Icon Button on PDF Viewer");
	}

	/**
	 * This method is used to check if PDF Viewer Search Bar is displayed
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isSearchBarDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "help.search.box.xpath").isDisplayed();
		if (bool == true) {
			logger.info("PDF Search Bar displayed");
			return true;
		} else {
			logger.info("PDF Search bar not displayed");
			return false;
		}
	}

	public Boolean isSoftwareIconDisplayed() throws IOException, InterruptedException {
		Thread.sleep(2000);
		Boolean bool = utility.initializeElement(LoginPage.driver, "help.software.info.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Software Icon displayed");
			return true;
		} else {
			logger.info("Software Icon not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if the show previous search entry button is
	 * displayed
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isShowPreviousButtonDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "help.searchbar.showprevious.btn.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Show Previous Button is displayed");
			return true;
		} else {
			logger.info("Show Previous Button is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if the show next search entry button is
	 * displayed
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isShowNextButtonDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "help.searchbar.shownext.btn.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Show Next Button is displayed");
			return true;
		} else {
			logger.info("Show Next Button is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if the highlight all checkbox is displayed
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isHighlightAllCheckboxDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "help.searchbar.hightlightall.checkbox.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Highlight all checkbox is displayed");
			return true;
		} else {
			logger.info("Highlight all checkbox is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if the match all checkbox is displayed
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isMatchAllCheckboxDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "help.searchbar.matchall.checkbox.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Match all checkbox is displayed");
			return true;
		} else {
			logger.info("Match all checkbox is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if the match case checkbox is displayed
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isMatchCaseCheckboxDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "help.searchbar.matchcase.checkbox.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Match case checkbox is displayed");
			return true;
		} else {
			logger.info("Match case checkbox is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if the upload files page arrow icon is displayed
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isUploadFilesPageIconDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "upload.icon.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Upload files page upload arrow icon is displayed");
			return true;
		} else {
			logger.info("Upload files page upload arrow icon is not displayed");
			return false;
		}
	}

	/**
	 * This method is to click the Upload Files Button from the left menu bar
	 * 
	 * @throws IOException
	 */
	public void pressUploadFilesButton() throws IOException {
		logger.info("User clicked upload files button from left menu bar");
		utility.initializeElement(LoginPage.driver, "leftnavigation.uploadfiles.xpath").click();
	}

	/**
	 * This method is to click the upload status button from the left menu bar
	 * 
	 * @throws IOException
	 */
	public void pressUploadStatusButton() throws IOException {
		logger.info("User clicked upload status button from left menu bar");
		utility.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath").click();
	}

	/**
	 * This method is to click the history button from the left menu bar
	 * 
	 * @throws IOException
	 */
	public void pressHistoryButton() throws IOException {
		logger.info("User clicked history button from left menu bar");
		utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath").click();
	}

	/**
	 * This method is to click the audit log button from the left menu bar
	 * 
	 * @throws IOException
	 */
	public void pressAuditLogButton() throws IOException {
		logger.info("User clicked audit log button from left menu bar");
		utility.initializeElement(LoginPage.driver, "leftnavigation.auditlog.xpath").click();
	}

	/**
	 * This method is to click the imaging link button from the left menu bar
	 * 
	 * @throws IOException
	 */
	public void pressImagingLinksButton() throws IOException {
		logger.info("User clicked imaging links button from left menu bar");
		utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath").click();
	}

	/**
	 * This method is to click the settings button from the left menu bar
	 * 
	 * @throws IOException
	 */
	public void pressSettingsButton() throws IOException {
		logger.info("User clicked settings button from left menu bar");
		utility.initializeElement(LoginPage.driver, "leftnavigation.settings.xpath").click();
	}

	/**
	 * This method is used to check if the upload files page upload button is
	 * displayed
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isUploadFilesPageUploadButtonDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "upload.btn.click.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Upload files page upload button is displayed");
			return true;
		} else {
			logger.info("Upload files page upload button is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to click on Find in Document button
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickDocument() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "help.search.btn.xpath").click();
		logger.info("click Find in Document Button : Clicked Find in Document button on PDF viewer");
	}

	/**
	 * This method is used to click on Next Page button
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickNextPage() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "help.nextpage.btn.xpath").click();
		logger.info("click Next Page Button : Clicked Next Page button on PDF viewer");
	}

	/**
	 * This method is to check if the next page icon is enabled or not
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isNextEnabled() throws IOException {
		boolean next = utility.initializeElement(LoginPage.driver, "help.nextpage.btn.xpath").isEnabled();
		if (next == true) {
			logger.info("Next page icon is enabled");
			return true;
		} else {
			logger.info("Next page icon is not enabled");
			return false;
		}
	}

	/**
	 * This method is to check if the previous page icon is enabled or not
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isPreviousPageEnabled() throws IOException {
		boolean next = utility.initializeElement(LoginPage.driver, "help.previouspage.btn.xpath").isEnabled();
		if (next == true) {
			logger.info("Previous page icon is enabled");
			return true;
		} else {
			logger.info("Previous page icon is not enabled");
			return false;
		}
	}

	/**
	 * This method is used to click on Previous Page button
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickPreviousPage() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "help.previouspage.btn.xpath").click();
		logger.info("click Previous Page Button : Clicked Previous Page button on PDF viewer");
	}

	/**
	 * This method is used to click on Page Resolution button
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickPageWidht() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "help.scaleSelect.btn.xpath").click();
		logger.info("click Page Widht Button : Clicked Page Width button on PDF viewer");
	}

	/**
	 * This method is used to click on Print button
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickPrint() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "help.print.btn.xpath").click();
		logger.info("click Print Button : Clicked Print button on PDF viewer");
	}

	/**
	 * This method is used to check if Help center header displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isHelpCenterHeaderDisplayed() throws IOException {
		logger.info("Help Info header is displayed : "
				+ utility.initializeElement(LoginPage.driver, "help.center.text.xpath").isDisplayed());
		logger.info("Help Info header is displayed as : "
				+ utility.initializeElement(LoginPage.driver, "help.center.text.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "help.center.text.xpath").isDisplayed();
	}

	/**
	 * This method is used to check PDF viewer components displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isPdfInfoDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("Toggle Sidebar")) {
			return utility.initializeElement(LoginPage.driver, "help.sidebartoggle.btn.xpath");
		}
		if (component.equalsIgnoreCase("Find in Document")) {
			return utility.initializeElement(LoginPage.driver, "help.search.btn.xpath");
		}
		if (component.equalsIgnoreCase("Next Page")) {
			return utility.initializeElement(LoginPage.driver, "help.nextpage.btn.xpath");
		}
		if (component.equalsIgnoreCase("Previous Page")) {
			return utility.initializeElement(LoginPage.driver, "help.previouspage.btn.xpath");
		}
		if (component.equalsIgnoreCase("Page")) {
			return utility.initializeElement(LoginPage.driver, "help.pagenumber.btn.xpath");
		}
		if (component.equalsIgnoreCase("Zoom Out")) {
			return utility.initializeElement(LoginPage.driver, "help.zoomout.btn.xpath");
		}
		if (component.equalsIgnoreCase("Zoom In")) {
			return utility.initializeElement(LoginPage.driver, "help.zoomin.btn.xpath");
		}
		if (component.equalsIgnoreCase("Print")) {
			return utility.initializeElement(LoginPage.driver, "help.print.btn.xpath");
		}
		if (component.equalsIgnoreCase("Download")) {
			return utility.initializeElement(LoginPage.driver, "help.download.btn.xpath");
		}
		if (component.equalsIgnoreCase("Tools")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarToggle.btn.xpath");
		}
		if (component.equalsIgnoreCase("Zoom")) {
			return utility.initializeElement(LoginPage.driver, "help.scaleSelect.btn.xpath");
		}
		if (component.equalsIgnoreCase("Show Thumbnails")) {
			return utility.initializeElement(LoginPage.driver, "help.thumbnails.btn.xpath");
		}

		if (component.equalsIgnoreCase("Show Document Outline")) {
			return utility.initializeElement(LoginPage.driver, "help.showdocument.btn.xpath");
		}
		if (component.equalsIgnoreCase("Show Attachments")) {
			return utility.initializeElement(LoginPage.driver, "help.attachment.btn.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}

	/**
	 * This method is used to check if help center text is highlighted or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isHelpCenterHighlighted() throws IOException {
		logger.info("Help Center is highlighted : "
				+ utility.initializeElement(LoginPage.driver, "help.center.text.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "help.center.text.xpath").getCssValue("color");
	}

	/**
	 * This method is get the color of the pdf document
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String getPDFContentColor() throws IOException {
		logger.info("Help Center PDF content is displayed in the following color: "
				+ utility.initializeElement(LoginPage.driver, "help.pdfpagetwoheader.text.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "help.pdfpagetwoheader.text.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if no of pages.
	 * 
	 * @return integer
	 * @throws IOException
	 */
	public int pageNumber() throws IOException {
		List<WebElement> element = LoginPage.driver.findElements(By.xpath("//*[@class=\"thumbnailImage\"]"));
		WebElement q = null;
		int count = element.size();
		logger.info("Total Number of Pages in Help & Info Pdf Viewer : " + count);
		/*
		 * for (int i = 0; i < element.size(); i++) { q = element.get(i);
		 * logger.info("Facility Name listed is : " + q.getText()); }
		 */
		return count;
	}

	/**
	 * This method is used to check if scroll bar is displayed.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isScrollBarDisplayed() throws IOException {
		WebElement scrollBar = utility.initializeElement(LoginPage.driver, "help.bar.scrollbar.xpath");
		int scrollHeight = Integer.parseInt(scrollBar.getAttribute("scrollHeight"));
		int offsetHeight = Integer.parseInt(scrollBar.getAttribute("offsetHeight"));
		return scrollHeight > offsetHeight;
	}

	/**
	 * This method is used to check if search box displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSearchBoxDisplayed() throws IOException {
		logger.info("Search Box is displayed : "
				+ utility.initializeElement(LoginPage.driver, "help.search.box.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "help.search.box.xpath").isDisplayed();
	}

	/***
	 * This method is used to enter string text in search box.
	 * 
	 * @throws IOException
	 */
	public WebElement enterTextInSearchBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.search.box.xpath").clear();
		logger.info("The text in search box is entered");
		return utility.initializeElement(LoginPage.driver, "help.search.box.xpath");

	}

	/**
	 * This method is used to check entered is text records displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedSimpleText() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "help.result.btn.xpath");
		int count = list.size();
		WebElement q = null;
		if (list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				q = list.get(i);
				logger.info("Total no of matching words on PDF : " + q.getText());
			}
			return true;
		}
		return false;
	}

	public static boolean isFileDownloaded(String expectedFileName, String fileExtension, int timeOut)
			throws IOException {
		// Download Folder Path
		String folderName = System.getProperty("user.dir") + File.separator + "HelpCenterPdfdownloads";

		// Array to Store List of Files in Directory
		File[] listOfFiles;

		// Store File Name
		String fileName;

		// Consider file is not downloaded
		boolean fileDownloaded = false;

		// capture time before looking for files in directory
		// last modified time of previous files will always less than start time
		// this is basically to ignore previous downloaded files
		long startTime = Instant.now().toEpochMilli();

		// Time to wait for download to finish
		long waitTime = startTime + timeOut;

		// while current time is less than wait time
		while (Instant.now().toEpochMilli() < waitTime) {
			// get all the files of the folder
			listOfFiles = new File(folderName).listFiles();

			// iterate through each file
			for (File file : listOfFiles) {
				// get the name of the current file
				fileName = file.getName().toLowerCase();

				// condition 1 - Last Modified Time > Start Time
				// condition 2 - till the time file is completely downloaded extension will be
				// crdownload
				// Condition 3 - Current File name contains expected Text
				// Condition 4 - Current File name contains expected extension
				if (file.lastModified() > startTime && !fileName.contains("pdf")
						&& fileName.contains(expectedFileName.toLowerCase())
						&& fileName.contains(fileExtension.toLowerCase())) {
					// File Found
					fileDownloaded = true;
					break;
				}
			}
			// File Found Break While Loop
			if (fileDownloaded)
				break;
		}
		// File Not Found
		return fileDownloaded;
	}

	public void clickZoomOut() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "help.zoomout.btn.xpath").click();
		utility.initializeElement(LoginPage.driver, "help.zoomout.btn.xpath").click();
		utility.initializeElement(LoginPage.driver, "help.zoomout.btn.xpath").click();
		logger.info("click Zoom Out Button : Clicked Zoom Out button on PDF viewer");
	}

	public void clickZoomIn() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "help.zoomin.btn.xpath").click();
		utility.initializeElement(LoginPage.driver, "help.zoomin.btn.xpath").click();
		utility.initializeElement(LoginPage.driver, "help.zoomin.btn.xpath").click();
		utility.initializeElement(LoginPage.driver, "help.zoomin.btn.xpath").click();
		utility.initializeElement(LoginPage.driver, "help.zoomin.btn.xpath").click();
		logger.info("click Zoom Out Button : Clicked Zoom Out button on PDF viewer");
	}

	/**
	 * This method is to click the Toolbar button on the Help&Info Page
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickToolbarButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarToggle.btn.xpath").click();
		logger.info("click Tools Button : Clicked Tools Button on PDF viewer");
	}

	/**
	 * This method is to return each WebElement per component in the help&info
	 * secondary toolbar
	 * 
	 * @return Web Element for each component
	 * @throws IOException
	 */
	public WebElement isToolBarInfoDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("Go to first page")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarGoFirstPage.btn.xpath");
		}
		if (component.equalsIgnoreCase("Go to last page")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarGoLastPage.btn.xpath");
		}
		if (component.equalsIgnoreCase("Rotate clockwise")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarRotateClockwise.btn.xpath");
		}
		if (component.equalsIgnoreCase("Rotate counterclockwise")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarRotateCounterclockwise.btn.xpath");
		}
		if (component.equalsIgnoreCase("text selection tool")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarTextSelectorTool.btn.xpath");
		}
		if (component.equalsIgnoreCase("Hand tool")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarHandTool.btn.xpath");
		}
		if (component.equalsIgnoreCase("Vertical scrolling")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarVerticalScrolling.btn.xpath");
		}
		if (component.equalsIgnoreCase("Horizontal scrolling")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarHorizontalScrolling.btn.xpath");
		}
		if (component.equalsIgnoreCase("Wrapped scrolling")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarWrappedScrolling.btn.xpath");
		}
		if (component.equalsIgnoreCase("No spreads")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarNoSpreads.btn.xpath");
		}
		if (component.equalsIgnoreCase("Odd Spreads")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarOddSpreads.btn.xpath");
		}
		if (component.equalsIgnoreCase("Even spreads")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarEvenSpreads.btn.xpath");
		}

		if (component.equalsIgnoreCase("Document properties")) {
			return utility.initializeElement(LoginPage.driver, "help.secondaryToolbarDocumentProperties.btn.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}

	/**
	 * This method is to click the page number button at the top of the help&info
	 * pdf
	 * 
	 * @throws IOException
	 */
	public void clickPageNumberButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.pagenumber.btn.xpath").click();
		logger.info("Click Page Number Button : Clicked Page Number Button on PDF viewer");
	}

	/**
	 * This method is to enter the number 2 in the page number text box at the top
	 * of help&info pdf
	 * 
	 * @return Web Element for each component
	 * @throws IOException
	 */
	public void enterPageNumber() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.pagenumber.btn.xpath").sendKeys("2");
		utility.initializeElement(LoginPage.driver, "help.pagenumber.btn.xpath").sendKeys(Keys.RETURN);
		logger.info("Entered Page Number into Page Number Field : Entered Page Number on PDF viewer");
	}

	/**
	 * This method is to check if the second page of the help&info pdf is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isPageTwoOfPDFDisplayed() throws IOException {
		String pageHeader = utility.initializeElement(LoginPage.driver, "help.pdfpagetwoheader.text.xpath").getText();
		if (pageHeader.contains("2")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is to click the Go to First page button in the help&info
	 * secondary toolbar
	 * 
	 * @throws IOException
	 */
	public void clickGoToFirstPageButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarGoFirstPage.btn.xpath").click();
		logger.info("User clicked go to first page button");
	}

	/**
	 * This method is to check if the first page of the help&info pdf is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isPageOneOfPDFDisplayed() throws IOException {
		String pageHeader = utility.initializeElement(LoginPage.driver, "help.pdfpageoneheader.text.xpath").getText();
		if (pageHeader.contains("A Simple PDF File")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is to click the Go To Last Page button in the help&info secondary
	 * toolbar
	 * 
	 * @throws IOException
	 */
	public void clickGoToLastPageButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarGoLastPage.btn.xpath").click();
		logger.info("User clicked go to last page button");
	}

	/**
	 * This method is to check if the last page of the help&info pdf is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isLastPageOfPDFDisplayed() throws IOException {
		boolean bool = utility.initializeElement(LoginPage.driver, "help.nextpage.btn.xpath").isEnabled();
		if (bool == true) {
			logger.info("Last Page of PDF is displayed");
			return true;
		} else {
			logger.info("Last page of pdf could not be displayed");
			return false;
		}
	}

	/**
	 * This method is to click the rotate clockwise button in the help&info
	 * secondary toolbar
	 * 
	 * @throws IOException
	 */
	public void clickRotateClockwiseButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarRotateClockwise.btn.xpath").click();
		logger.info("User clicked rotate clockwise button");
	}

	/**
	 * This method is to click the rotate counterclockwise button in the help&info
	 * secondary toolbar
	 * 
	 * @throws IOException
	 */
	public void clickRotateCounterClockwiseButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarRotateCounterclockwise.btn.xpath").click();
		logger.info("User clicked rotate counterclockwise button");
	}

	/**
	 * This method is to check if the Text Selection Tool is enabled in the
	 * help&info secondary toolbar
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isTextSelectionToolEnabled() throws IOException {
		boolean bool = utility.initializeElement(LoginPage.driver, "help.secondaryToolbarTextSelectorTool.btn.xpath")
				.isEnabled();
		if (bool == true) {
			logger.info("Text Selection Tool is Enabled");
			return true;
		} else {
			logger.info("Text selection tool is not enabled");
			return false;
		}
	}

	/**
	 * This method is to select the help&info pdf second page header, using the
	 * selection tool
	 * 
	 * @throws IOException
	 */
	public void selectPDFPageTwoHeader() throws IOException {
		WebElement header = utility.initializeElement(LoginPage.driver, "help.pdfpagetwoheader.text.xpath");
		Actions selector = new Actions(LoginPage.driver);
		selector.moveToElement(header).doubleClick();
		selector.click().build().perform();
		logger.info("Selecting Page Two Header Text");
	}

	/**
	 * This method is to select the help&info pdf second page button, using the
	 * selection tool
	 * 
	 * @throws IOException
	 */
	public void selectBodyText() throws IOException {
		WebElement body = utility.initializeElement(LoginPage.driver, "help.pdfpagetwobody.text.xpath");
		Actions selector = new Actions(LoginPage.driver);
		selector.moveToElement(body).doubleClick();
		selector.click().build().perform();
		logger.info("Selecting Page Two Body Text");
	}

	/**
	 * This method is to click the hand tool button in the help&info secondary
	 * toolbar
	 * 
	 * @throws IOException
	 */
	public void clickHandTool() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarHandTool.btn.xpath").click();
		logger.info("User clicked hand tool button");
	}

	/**
	 * This method is to check if the hand tool selection is enabled in the
	 * help&info secondary toolbar
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isHandToolEnabled() throws IOException {
		boolean bool = utility.initializeElement(LoginPage.driver, "help.secondaryToolbarHandTool.btn.xpath")
				.isEnabled();
		if (bool == true) {
			logger.info("Hand tool is enabled");
			return true;
		} else {
			logger.info("Hand tool is not enabled");
			return false;
		}
	}

	/**
	 * This method is to use the secondary toolbar Hand Tool functionality to drag
	 * the help&info pdf
	 * 
	 * @throws IOException
	 */
	public void usingHandTool() throws IOException {
		Actions drag = new Actions(LoginPage.driver);
		WebElement secondElement = utility.initializeElement(LoginPage.driver, "help.pdfpagetwoheader.text.xpath");
		WebElement firstElement = utility.initializeElement(LoginPage.driver, "help.pdfpagetwobodybottom.text.xpath");
		drag.dragAndDrop(secondElement, firstElement).perform();
		;
	}

	/**
	 * This method is to click the horizontal scrolling button in the help&info
	 * secondary toolbar
	 * 
	 * @throws IOException
	 */
	public void clickHorizontalScrollingTool() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarHorizontalScrolling.btn.xpath").click();
		logger.info("User clicked horizontal scrolling button");
	}

	/**
	 * This method is to click the wrapped scrolling button in the help&info
	 * secondary toolbar
	 * 
	 * @throws IOException
	 */
	public void clickWrappedScrollingTool() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarWrappedScrolling.btn.xpath").click();
		logger.info("User clicked wrapped scrolling button");
	}

	/**
	 * This method is to click the odd spread button in the help&info secondary
	 * toolbar
	 * 
	 * @throws IOException
	 */
	public void clickOddSpreadsTool() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarOddSpreads.btn.xpath").click();
		logger.info("User clicked Odd Spreads button");
	}

	/**
	 * This method is to click the even spread button in the help&info secondary
	 * toolbar
	 * 
	 * @throws IOException
	 */
	public void clickEvenSpreadsTool() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarEvenSpreads.btn.xpath").click();
		logger.info("User clicked Even Spreads button");
	}

	/**
	 * This method is to click the Document Properties button in the help&info
	 * secondary toolbar
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public void clickDocumentProperties() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.secondaryToolbarDocumentProperties.btn.xpath").click();
		logger.info("User clicked Document Properties button");
	}

	/**
	 * This method is to check if the help&info document properties pop-up is
	 * displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isDocumentPropertiesDisplayed() throws IOException {
		boolean bool = utility.initializeElement(LoginPage.driver, "help.documentProperties.popup.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Document Properties is Displayed");
			return true;
		} else {
			logger.info("Document Properties is not Displayed");
			return false;
		}
	}

	/**
	 * This method is to click the close button in the help&info document properties
	 * pop-up
	 * 
	 * @throws IOException
	 */
	public void clickDocumentPropertiesClose() throws IOException {
		utility.initializeElement(LoginPage.driver, "help.documentProperties.close.button.xpath").click();
		logger.info("Document Properties close button has been clicked");
	}

	/**
	 * This method is to return the WebElements for each entry in the help&info
	 * document properties pop-up
	 * 
	 * @return WebElement per component
	 * @throws IOException
	 */
	public WebElement isDocumentPropertiesInfoDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("file name")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.FileName.xpath");
		}
		if (component.equalsIgnoreCase("file size")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.FileSize.xpath");
		}
		if (component.equalsIgnoreCase("title")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.Title.xpath");
		}
		if (component.equalsIgnoreCase("author")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.Author.xpath");
		}
		if (component.equalsIgnoreCase("subject")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.Subject.xpath");
		}
		if (component.equalsIgnoreCase("keywords")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.Keywords.xpath");
		}
		if (component.equalsIgnoreCase("creation date")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.CreationDate.xpath");
		}
		if (component.equalsIgnoreCase("modification date")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.ModificationDate.xpath");
		}
		if (component.equalsIgnoreCase("creator")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.Creator.xpath");
		}
		if (component.equalsIgnoreCase("pdf producer")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.PDFProducer.xpath");
		}
		if (component.equalsIgnoreCase("pdf version")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.PDFVersion.xpath");
		}
		if (component.equalsIgnoreCase("page count")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.PageCount.xpath");
		}
		if (component.equalsIgnoreCase("page size")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.PageSize.xpath");
		}
		if (component.equalsIgnoreCase("fast web view")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.FastWebView.xpath");
		}
		if (component.equalsIgnoreCase("close button")) {
			return utility.initializeElement(LoginPage.driver, "help.DocumentProperties.CloseButton.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}

	public Boolean checkAuditLogHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "auditlog.topleftheader.txt.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Audit log header is displayed");
			return true;
		} else {
			logger.info("Audit log header is not displayed");
			return false;
		}
	}

	public String getSoftwareVersion() throws IOException, InterruptedException {
		return utility.initializeElement(LoginPage.driver, "help.softwareversion.info.xpath").getText();
	}

	public String getSoftwareInformation() throws IOException, InterruptedException {
		return utility.initializeElement(LoginPage.driver, "help.softwareheader.info.xpath").getText();
	}

	public void clickSoftwareCrossIcon() throws IOException {
		try {
			utility.initializeElement(LoginPage.driver, "help.softwarecrossicon.info.xpath").click();

		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"modal-width\"]/div/div/img")));
		}

	}

}
