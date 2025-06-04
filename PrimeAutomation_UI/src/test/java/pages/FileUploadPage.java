package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Utility;

public class FileUploadPage {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(FileUploadPage.class);
	Utility utility = new Utility();
	UserInformationPage uiPage = new UserInformationPage();
	
	/***
	 * This method is used to locate the upload button.
	 * @return
	 * @throws IOException 
	 */
	public WebElement getUploadBtn() throws IOException {
		return uiPage.isUploadFilesComponentsDisplayed("upload button");
	}
	
	
	/**
	 * This method is used to locate upload icon.
	 * @return
	 * @throws IOException
	 */
	public WebElement uploadIcon() throws IOException {
		return uiPage.isUploadFilesComponentsDisplayed("upload icon");
	}
	
	
	
	/**
	 * This method is used to check upload button is displayed.
	 * @return
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public Boolean isUploadBtnDisplayed() throws IOException, InterruptedException {
		Thread.sleep(2000);
		logger.info("Upload button is displayed : "
				+  getUploadBtn().isDisplayed());
		return  getUploadBtn().isDisplayed();
	}
	
	/**
	 * This method is used to check upload icon is displayed
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public Boolean isUploadIconDisplayed() throws IOException, InterruptedException {
		Thread.sleep(2000);
		logger.info("Upload icon is displayed : "
				+  getUploadBtn().isDisplayed());
		return  uploadIcon().isDisplayed();
	}

	/**
	 * This method is used to locate site selection elements
	 * @param element
	 * @return
	 * @throws IOException 
	 */
	public WebElement siteSelectionScreen(String element) throws IOException {
		if(element.equalsIgnoreCase("Header"))
			return utility.initializeElement(LoginPage.driver,
					"upload.siteSelectionHeader.xpath");
		else if(element.equalsIgnoreCase("Label"))
			return utility.initializeElement(LoginPage.driver,
					"upload.SiteSelectionLable.xpath");
		else if(element.equalsIgnoreCase("Button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.nextbutton.xpath");
		else if(element.equalsIgnoreCase("search box"))
			return utility.initializeElement(LoginPage.driver,
					"upload.siteselection.searcbox.xpath");
		else if(element.equalsIgnoreCase("site list"))
			try {
				return utility.initializeElement(LoginPage.driver,
						"upload.SiteSelctList.xpath");
			}catch(NoSuchElementException e){
				return utility.initializeElement(LoginPage.driver,
						"upload.selectedsite.xpath");
			}
		else if(element.equalsIgnoreCase("next button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.nextbutton.xpath");
		else if(element.equalsIgnoreCase("back button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.backbutton.xpath");
		else if(element.equalsIgnoreCase("dont see text"))
			return utility.initializeElement(LoginPage.driver,
					"upload.siteselection.idontseemy.text.xpath");
		else if(element.equalsIgnoreCase("close icon")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.closeicon.xpath");
		}
		else if(element.equalsIgnoreCase("default selected site"))
			return utility.initializeElement(LoginPage.driver,
					"facility.selectedsite.xpath");
		return null;
	}
	

/**
	 * This method is used to check whether site selection screen is displayed 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public Boolean isSiteDefaultSelectedScreenDisplayed() throws IOException, InterruptedException {
		boolean header = siteSelectionScreen("Header").isDisplayed();
		logger.info("Header is displayed as : " + siteSelectionScreen("Header").getText());
		boolean label = siteSelectionScreen("Label").isDisplayed();
		logger.info("Search box header: "+ siteSelectionScreen("Label").getText());
		boolean searchBox= siteSelectionScreen("search box").isDisplayed();
		logger.info("Search box placeholder: "+ siteSelectionScreen("Label").getAttribute("placeholder"));
		boolean siteList= siteSelectionScreen("default selected site").isDisplayed();
		boolean nextButton= siteSelectionScreen("next button").isDisplayed();
		boolean backButton= siteSelectionScreen("back button").isDisplayed();
		boolean dontSeeText= siteSelectionScreen("dont see text").isDisplayed();
		logger.info("bottom text: " +siteSelectionScreen("dont see text").getText());
		return header && label && siteList && searchBox && nextButton && backButton && dontSeeText;
	}
	
	/**
	 * This method is used to check whether site selection screen is displayed 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public Boolean isSiteSelectionScreenDisplayed() throws IOException, InterruptedException {
		boolean header = siteSelectionScreen("Header").isDisplayed();
		logger.info("Header is displayed as : " + siteSelectionScreen("Header").getText());
		boolean label = siteSelectionScreen("Label").isDisplayed();
		logger.info("Search box header: "+ siteSelectionScreen("Label").getText());
		boolean searchBox= siteSelectionScreen("search box").isDisplayed();
		logger.info("Search box placeholder: "+ siteSelectionScreen("search box").getAttribute("placeholder"));
		boolean siteList= siteSelectionScreen("site list").isDisplayed();
		boolean nextButton= siteSelectionScreen("next button").isDisplayed();
		boolean backButton= siteSelectionScreen("back button").isDisplayed();
		boolean dontSeeText= siteSelectionScreen("dont see text").isDisplayed();
		boolean closeIcon= siteSelectionScreen("close icon").isDisplayed();
		logger.info("bottom text: "+ siteSelectionScreen("dont see text").getText());
		return header && label && searchBox && siteList && nextButton && backButton && dontSeeText && closeIcon;
	}
	
	
	/**
	 * This method is used to select a site from the list in site selection screen
	 * @param index
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public void selectSite(Integer index) throws IOException, InterruptedException {
		Thread.sleep(1000);
		List<WebElement> availableSites=utility.initializeElements(LoginPage.driver,"upload.SiteSelctList.xpath");
		if(availableSites.size()== 0) {
			WebElement element = utility.initializeElement(LoginPage.driver,"upload.selectedsite.xpath");
			logger.info("Available site:" + element.getText());
			element.click();
			logger.info("Selected site: "+ element.getText());
			}
		else {
			logger.info("Available sites:");
			for(WebElement webelement:availableSites) {
				logger.info("site: "+ webelement.getText());
			}
			availableSites.get(index).click();
			logger.info("Selected site: " + availableSites.get(index).getText());
		}
	}
	
	/**
	 * This method is used to check site is selected
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public Boolean isSiteSelected() throws IOException, InterruptedException {
		Thread.sleep(1000);
		return utility.initializeElement(LoginPage.driver,"upload.selectedsite.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to click on next button
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void clickNextBtn() throws IOException, InterruptedException {
		Thread.sleep(1000);
		siteSelectionScreen("Button").click();
		logger.info("Next button is clicked");
	}
	
	/**
	 * This method is used to locate surgeon selection screen elements
	 * @param element
	 * @return
	 * @throws IOException 
	 */
	public WebElement surgeonSelectionScreen(String element) throws IOException {
		if(element.equalsIgnoreCase("Header"))
			return utility.initializeElement(LoginPage.driver,
					"upload.surgeonselectionHeader.xpath");
		else if(element.equalsIgnoreCase("Label"))
			return utility.initializeElement(LoginPage.driver,
					"upload.surgeonselectionLable.xpath");
		else if(element.equalsIgnoreCase("Button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.nextbutton.xpath");
		else if(element.equalsIgnoreCase("search box"))
			return utility.initializeElement(LoginPage.driver,
					"upload.surgeonselection.searchbox.xpath");
		else if(element.equalsIgnoreCase("next button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.nextbutton.xpath");
		else if(element.equalsIgnoreCase("back button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.backbutton.xpath");
		else if(element.equalsIgnoreCase("dont see text"))
			return utility.initializeElement(LoginPage.driver,
					"upload.siteselection.idontseemy.text.xpath");
		else if(element.equalsIgnoreCase("surgeon list")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.surgeonSelctList.xpath");
		}
		else if(element.equalsIgnoreCase("No surgeon text")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.nosurgeon.text.xpath");
		}
		else if(element.equalsIgnoreCase("close icon")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.closeicon.xpath");
		}
		return null;
	}
	
	/**
	 * This method is used to check whether surgeon selection screen is displayed 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public Boolean isSurgeonSelectionScreenDisplayed() throws IOException, InterruptedException {
		return isSurgeonSelectionScreenComponentsDisplayed() && isSurgeonListDisplayed() && isSelectionHeaderDisplyed();
	}
	
	/**
	 * This method is used to check surgeon list is displayed in surgeon selection screen
	 * @return
	 * @throws IOException
	 */
	public boolean isSurgeonListDisplayed() throws IOException {
		return surgeonSelectionScreen("surgeon list").isDisplayed();
	}
	
	/**
	 * This method is used to check no surgeon text is displayed in surgeon selection screen
	 * @return
	 * @throws IOException
	 */
	public boolean isNoSurgeonAvailableTextDisplayed() throws IOException {
		logger.info("Error message displayed: "+ surgeonSelectionScreen("No surgeon text").getText());
		return surgeonSelectionScreen("No surgeon text").isDisplayed();
	}
	
	/**
	 * This method is used to check all other components in surgeon selection screen is displayed.
	 * The surgeon list is not verified in this method
	 * @return
	 * @throws IOException
	 */
	public boolean isSurgeonSelectionScreenComponentsDisplayed() throws IOException {
		boolean header = surgeonSelectionScreen("Header").isDisplayed();
		logger.info("Header is displayed as : " + surgeonSelectionScreen("Header").getText());
		boolean label = surgeonSelectionScreen("Label").isDisplayed();
		logger.info("Search box header: "+ surgeonSelectionScreen("Label").getText());
		boolean searchBox= surgeonSelectionScreen("search box").isDisplayed();
		logger.info("Search box placeholder: "+ surgeonSelectionScreen("search box").getAttribute("placeholder"));
		boolean nextButton= surgeonSelectionScreen("next button").isDisplayed();
		boolean backButton= surgeonSelectionScreen("back button").isDisplayed();
		boolean dontSeeText= surgeonSelectionScreen("dont see text").isDisplayed();
		logger.info("bottom text: "+ surgeonSelectionScreen("dont see text").getText());
		boolean closeIcon = surgeonSelectionScreen("close icon").isDisplayed();
		return header && label && searchBox && nextButton && backButton && dontSeeText && closeIcon;
	}
	
	
	/**
	 * This method is used to select a site from the list in site selection screen
	 * @param index
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public void selectSurgeon(Integer index) throws IOException, InterruptedException {
		Thread.sleep(1000);
		List<WebElement> availableSurgeon=utility.initializeElements(LoginPage.driver,"upload.surgeonSelctList.xpath");
		if(availableSurgeon.size()== 0) {
			
			WebElement element = utility.initializeElement(LoginPage.driver,"upload.selectedsurgeon.xpath");
			logger.info("Available Surgeon:" + element.getText());
			element.click();
			logger.info("Selected Surgeon: "+ element.getText());
			}
		else {
			logger.info("Available Surgeons:");
			for(WebElement webelement:availableSurgeon) {
				logger.info("site: "+ webelement.getText());
			}
			availableSurgeon.get(index).click();
			logger.info("Selected Surgeon: " + availableSurgeon.get(index).getText());
		}
	}
	
	/**
	 * This method is used to check site is selected
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public Boolean isSurgeonSelected() throws IOException, InterruptedException {
		Thread.sleep(1000);
		return utility.initializeElement(LoginPage.driver,"upload.selectedsurgeon.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to locate application selection screen elements
	 * @param element
	 * @return
	 * @throws IOException 
	 */
	public WebElement applicationSelectionScreen(String element) throws IOException {
		if(element.equalsIgnoreCase("Header"))
			return utility.initializeElement(LoginPage.driver,
					"upload.applicationheader.xpath");
		else if(element.equalsIgnoreCase("Application card box"))
			return utility.initializeElement(LoginPage.driver,
					"upload.applicationcardbox.xpath");
		else if(element.equalsIgnoreCase("Application card"))
			return utility.initializeElement(LoginPage.driver,
					"upload.applicationcard.xpath");
		else if(element.equalsIgnoreCase("Application name"))
			return utility.initializeElement(LoginPage.driver,
					"upload.applicationcardname.xpath");
		else if(element.equalsIgnoreCase("Button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.nextbutton.xpath");
		else if(element.equalsIgnoreCase("next button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.nextbutton.xpath");
		else if(element.equalsIgnoreCase("back button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.backbutton.xpath");
		else if(element.equalsIgnoreCase("dont see text"))
			return utility.initializeElement(LoginPage.driver,
					"upload.siteselection.idontseemy.text.xpath");
		return null;
	}
	
	/**
	 * This method is used to check whether surgeon selection screen is displayed 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public Boolean isapplicationSelectionScreenDisplayed() throws IOException, InterruptedException {
		Thread.sleep(1000);
		boolean header = applicationSelectionScreen("Header").isDisplayed();
		logger.info("Header is displayed as : " + applicationSelectionScreen("Header").getText());
		boolean applicationList = applicationSelectionScreen("Application card").isDisplayed();
		boolean nextButton= applicationSelectionScreen("next button").isDisplayed();
		boolean backButton= applicationSelectionScreen("back button").isDisplayed();
		boolean dontSeeText= applicationSelectionScreen("dont see text").isDisplayed();
		logger.info("bottom text: "+ applicationSelectionScreen("dont see text").getText());
		logger.info("Application selection screen is displayed");
		return header && applicationList && nextButton && backButton && dontSeeText;
	}
	
	/**
	 * This method is used to select a application from the list in application selection screen
	 * @param index
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public void selectApplication() throws IOException, InterruptedException {
		Thread.sleep(1000);
		WebElement availableApplication=utility.initializeElement(LoginPage.driver,"upload.applicationcardname.xpath");
		availableApplication.click();
		logger.info("Selected application: " + availableApplication.getText());
	}
	
	/**
	 * This method is used to check site is selected
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public Boolean isApplicationSelected() throws IOException, InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(utility.initializeElement(LoginPage.driver,
				"upload.applicationcardselected.xpath")));
		return utility.initializeElement(LoginPage.driver,"upload.applicationcardselected.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to locate upload screen elements
	 * @param element
	 * @return
	 * @throws IOException 
	 */
	public WebElement uploadScreen(String element) throws IOException {
		if(element.equalsIgnoreCase("Header")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.uploadscreenheader.xpath");}
		else if(element.equalsIgnoreCase("Drag drop")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.dragdrop.xpath");}
		else if(element.equalsIgnoreCase("Browse pc")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.browsepc.btn.xpath");}
		else if(element.equalsIgnoreCase("Application name")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.applicationcardname.xpath");}
		else if(element.equalsIgnoreCase("Back Button")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.screen.backbutton.xpath");}
		return null;
	}
	
	/**
	 * This method is used to check whether upload screen is displayed
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public Boolean uploadScreenDisplayed() throws IOException, InterruptedException {
		boolean header = uploadScreen("Header").isDisplayed();
		logger.info("Header is displayed as : " + uploadScreen("Header").getText());
		boolean dragDrop = uploadScreen("Drag drop").isDisplayed();
		boolean browsePc = uploadScreen("Browse pc").isDisplayed();
		boolean backButton = uploadScreen("Back Button").isDisplayed();
		logger.info(dragDrop);
		logger.info(browsePc);
		logger.info(backButton);
		logger.info("Upload screen is displayed");
		return header && dragDrop && browsePc && backButton;
	}
	
	/**
	 * This method is used to locate upload success screen elements
	 * @param element
	 * @return
	 * @throws IOException
	 */
	public WebElement uploadSuccessScreen(String element) throws IOException {
		if(element.equalsIgnoreCase("Header"))
			return utility.initializeElement(LoginPage.driver,
					"upload.successmodeltitle.xpath");
		else if(element.equalsIgnoreCase("Success icon"))
			return utility.initializeElement(LoginPage.driver,
					"upload.successicon.xpath");
		else if(element.equalsIgnoreCase("Close button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.successclose.btn.xpath");
		else if(element.equalsIgnoreCase("Start new upload"))
			return utility.initializeElement(LoginPage.driver,
					"upload.startnewupload.btn.xpath");
		else if(element.equalsIgnoreCase("Dashboard button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.dashboard.btn.xpath");
		return null;
	}
	
	/**
	 * This method is used to check upload success screen is displayed
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public Boolean isuploadSuccessDisplayed() throws InterruptedException, IOException {
		Properties properties = reader.getProperty();
		boolean header = uploadSuccessScreen("Header").isDisplayed();
		boolean icon = uploadSuccessScreen("Success icon").isDisplayed();
		boolean closeBtn = uploadSuccessScreen("Success icon").isDisplayed();
		boolean startNewUploadBtn = uploadSuccessScreen("Success icon").isDisplayed();
		boolean dashboardBtn = uploadSuccessScreen("Success icon").isDisplayed();
		boolean green = false;
		if(header)
			logger.info("Upload successful text is displayed");
		if(icon)
			logger.info("Upload icon text is displayed");
		if(closeBtn)
			logger.info("Close button is displayed");
		if(startNewUploadBtn)
			logger.info("Start new upload button is displayed");
		if(dashboardBtn)
//			logger.info(uploadSuccessScreen("Dashboard button").getCssValue("color"));
			green = uploadSuccessScreen("Dashboard button").getCssValue("color").equals(properties.getProperty("browsepcbutton.color"));
			if(green)
			{
				logger.info("Dashboard button is displayed in green color");
			}
			logger.info("Dashboard button is displayed");
		return header && icon && closeBtn && startNewUploadBtn && dashboardBtn && green;
	}
	
	/**
	 * This method is used to locate selection header in application selection and surgeon selection screen
	 * @return
	 * @throws IOException
	 */
	public WebElement selectionHeader() throws IOException {
		return utility.initializeElement(LoginPage.driver,"upload.selectedsitesurgeonheader.xpath");
	}
	
	/**
	 * This method is used to check selection header is displayed.
	 * @return
	 * @throws IOException
	 */
	public Boolean isSelectionHeaderDisplyed() throws IOException {
		logger.info("Selected Header: " + selectionHeader().getText());
		return selectionHeader().isDisplayed();
	}
	/***
	 * This method is used to return the local path of Datasets folder in the project
	 * @return
	 * @throws IOException
	 */
	public String getDataSetPath() throws IOException {
		Properties properties = reader.getProperty();
		String propertiesPath;
		File jarPath = new File(FileUploadPage.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		propertiesPath = jarPath.getAbsolutePath().replace("%20", " ");
		if (propertiesPath.contains(".jar")) {
			propertiesPath = jarPath.getParentFile().getAbsolutePath().replace("%20", " ")+ properties.getProperty("uploadfile.dataset.path");
			logger.info("Path of the jar is " + propertiesPath);
		} else {
			propertiesPath = jarPath.getParentFile().getParentFile().getAbsolutePath().replace("%20", " ") + properties.getProperty("uploadfile.dataset.path");
		}
		logger.info("File local path: "+propertiesPath);
		return propertiesPath;
	}
	
	
	
	/***
	 * This method is used to upload a file in upload file screen
	 * @param FileName
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void uploadFileFromLocal(String FileName) throws IOException, InterruptedException {
		String absolutePath = getDataSetPath()  +FileName;
		File file = new File(absolutePath);
		utility.initializeElement(LoginPage.driver,
				"upload.input.xpath").sendKeys(file.getAbsolutePath());
		Thread.sleep(10000);
	}
	
	/**
	 * This method is used to click on back button (In site, surgeon and application selection screens)
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void clickBackBtn() throws IOException, InterruptedException {
		siteSelectionScreen("back button").click();
		logger.info("Back button is clicked");
	}
	
	/**
	 * This method is used to click back button in upload screen(Not in site, surgeon and application selection screens)
	 * @throws IOException 
	 * 
	 */
	public void clickBackBtnInUploadScreen() throws IOException {
		uploadScreen("Back Button").click();
		logger.info("Back button is clicked");
	}
	
	/**
	 * This method is used to click on dashboard button in upload success screen 
	 * @throws IOException
	 */
	public void clickDasboardBtnInSuccessScreen() throws IOException {
		uploadSuccessScreen("Dashboard button").click();
		logger.info("Dashboard button is clicked");
	}
	
	/**
	 * This method is used to locate elements image upload progress screen
	 * @param element
	 * @return
	 * @throws IOException
	 */
	public WebElement imageUploadingScreen(String element) throws IOException {
		WebDriverWait wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60));
		if(element.equalsIgnoreCase("Breadcrumb"))
			return utility.initializeElement(LoginPage.driver,
					"upload.uploadingscreen.breadcrumb.xpath");
		else if(element.equalsIgnoreCase("logo")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.uploadingscreen.snlogo.xpath");
		}
		else if(element.equalsIgnoreCase("Loading bar")) {
			wait.until(ExpectedConditions.visibilityOf(utility.initializeElement(LoginPage.driver,
					"upload.uploadingscreen.loadingbar.xpath")));
			return utility.initializeElement(LoginPage.driver,
					"upload.uploadingscreen.loadingbar.xpath");
		}
		else if(element.equalsIgnoreCase("file Size"))
			return utility.initializeElement(LoginPage.driver,
					"upload.uploadingscreen.filesize.xpath");
		else if(element.equalsIgnoreCase("Time Remaining"))
			return utility.initializeElement(LoginPage.driver,
					"upload.uploadingscreen.timeremaining.xpath");
		else if(element.equalsIgnoreCase("Cancel upload button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.uploadingscreen.cancelupload.btn.xpath");
		else if(element.equalsIgnoreCase("Start Next Upload button"))
			return utility.initializeElement(LoginPage.driver,
					"upload.uploadingscreen.startnextupload.btn.xpath");
		return null;
	}
	
	/**
	 * This method is used to check image upload progress screen
	 * @return
	 * @throws IOException
	 */
	public boolean isImageUploadScreenDisplayed() throws IOException {
		boolean breadcrump=imageUploadingScreen("Breadcrumb").isDisplayed();
		boolean logo=imageUploadingScreen("logo").isDisplayed();
		boolean loadingBar=imageUploadingScreen("Loading bar").isDisplayed();
		boolean fileSize=imageUploadingScreen("file Size").isDisplayed();
		boolean timeRemaining=imageUploadingScreen("Time Remaining").isDisplayed();
		boolean cancelBtn=imageUploadingScreen("Cancel upload button").isDisplayed();
		boolean startNextUploadBtn=imageUploadingScreen("Start Next Upload button").isDisplayed();
		if(breadcrump) {
			logger.info("Breadcrump: "+imageUploadingScreen("Breadcrumb").getText());
		}
		if(logo) {
			logger.info("SN logo is displayed");
		}
		if(loadingBar) {
			logger.info("loading bar is displayed");
		}
		if(fileSize) {
			logger.info("fileSize is displayed");
			logger.info(imageUploadingScreen("file Size").getText());
		}
		if(timeRemaining) {
			logger.info("timeRemaining is displayed");
			logger.info(imageUploadingScreen("Time Remaining").getText());
		}
		if(cancelBtn) {
			logger.info("cancel Button is displayed");
		}
		if(startNextUploadBtn) {
			logger.info("start Next Upload Button is displayed");
		}
		return breadcrump && logo && loadingBar && fileSize && timeRemaining && cancelBtn && startNextUploadBtn;
	}
	
	/**
	 * This method is used to wait upload is completed
	 * @throws IOException
	 */
	public void waitUntilUploadIsFinished() throws IOException {
		Properties properties = reader.getProperty();
		WebDriverWait wait = new WebDriverWait(LoginPage.driver,Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(properties.getProperty("upload.uploadingscreen.cancelupload.btn.xpath"))));
	}
	
	/**
	 * This method is used check surgeon list is correct
	 * @return
	 * @throws IOException
	 */
	public boolean listOfSitesIsDisplayedCorrect() throws IOException {
		Properties properties = reader.getProperty();
		List<WebElement> lsitOfSites = utility.initializeElements(LoginPage.driver,"upload.SiteSelctList.xpath");
		String site1 = properties.getProperty("available.site1");
		String site2 = properties.getProperty("available.site2");
		String site3 = properties.getProperty("available.site3");
		boolean isSite1Displayed = true;
		boolean isSite2Displayed = true;
		boolean isSite3Displayed = true;
		if(site1.length()!=0) {
			for(WebElement site: lsitOfSites) {
				isSite1Displayed = site.getText().equalsIgnoreCase(site1);
				if(isSite1Displayed) {
					logger.info(site1+" is displayed");
					break;
				}
			}
		}
		if(site2.length()!=0) {
			for(WebElement site: lsitOfSites) {
				isSite2Displayed = site.getText().equalsIgnoreCase(site2);
				if(isSite2Displayed) {
					logger.info(site2+" is displayed");
					break;
				}
			}
		}
		if(site3.length()!=0) {
			for(WebElement site: lsitOfSites) {
				isSite3Displayed = site.getText().equalsIgnoreCase(site3);
				if(isSite3Displayed) {
					logger.info(site3 + " is displayed");
					break;
				}
			}
		}
		return isSite1Displayed && isSite2Displayed && isSite3Displayed;
	}
	
	/**
	 * This method is used to check surgeon list is correct
	 * @return
	 * @throws IOException
	 */
	public boolean listOfSurgeonsIsDisplayedCorrect() throws IOException {
		Properties properties = reader.getProperty();
		List<WebElement> lsitOfSurgeons = utility.initializeElements(LoginPage.driver,"upload.surgeonSelctList.xpath");
		String surgeon1 = properties.getProperty("available.site1.surgeon1");
		String surgeon2 = properties.getProperty("available.site1.surgeon2");
		String surgeon3 = properties.getProperty("available.site1.surgeon3");
		boolean isSurgeon1Displayed = true;
		boolean isSurgeon2Displayed = true;
		boolean isSurgeon3Displayed = true;
		if(surgeon1.length()!=0) {
			for(WebElement surgeon: lsitOfSurgeons) {
				isSurgeon1Displayed = surgeon.getText().equalsIgnoreCase(surgeon1);
				if(isSurgeon1Displayed) {
					logger.info(surgeon1 + " is displayed");
					break;
				}
			}
		}
		if(surgeon2.length()!=0) {
			for(WebElement surgeon: lsitOfSurgeons) {
				isSurgeon2Displayed = surgeon.getText().equalsIgnoreCase(surgeon2);
				if(isSurgeon2Displayed) {
					logger.info(surgeon2 + " is displayed");
					break;
				}
			}
		}
		if(surgeon3.length()!=0) {
			for(WebElement surgeon: lsitOfSurgeons) {
				isSurgeon3Displayed = surgeon.getText().equalsIgnoreCase(surgeon3);
				if(isSurgeon3Displayed) {
					logger.info(surgeon3 + " is displayed");
					break;
				}
			}
		}
		return isSurgeon1Displayed && isSurgeon2Displayed && isSurgeon3Displayed;
	}
	
	/**
	 * This method is used to check application list is correct
	 * @return
	 * @throws IOException
	 */
	
	public boolean listOfApplicationsIsDisplayedCorrect() throws IOException {
		Properties properties = reader.getProperty();
		List<WebElement> lsitOfApplications = utility.initializeElements(LoginPage.driver,"upload.applicationnems.xpath");
		String application1 = properties.getProperty("available.application1");
		String application2 = properties.getProperty("available.application2");
		String application3 = properties.getProperty("available.application3");
		boolean isapplication1Displayed = true;
		boolean isapplication2Displayed = true;
		boolean isapplication3Displayed = true;
		if(application1.length()!=0) {
			String[] names1 = application1.split(" ");
			for(WebElement application: lsitOfApplications) {
				isapplication1Displayed = application.getText().contains(names1[0]) && application.getText().contains(names1[1]);
				if(isapplication1Displayed) {
					logger.info(application1 + " is displayed");
					break;
				}
			}
		}
		if(application2.length()!=0){
			String[] names2 = application2.split(" ");
			for(WebElement application: lsitOfApplications) {
				isapplication2Displayed = application.getText().contains(names2[0]) && application.getText().contains(names2[1]);
				if(isapplication2Displayed) {
					logger.info(application2 + " is displayed");
					break;
				}
			}
		}

		if(application3.length()!=0) {
			String[] names3 = application3.split(" ");
			for(WebElement application: lsitOfApplications) {
				isapplication3Displayed = application.getText().contains(names3[0]) && application.getText().contains(names3[1]);
				if(isapplication3Displayed) {
					logger.info(application3 + " is displayed");
					break;
				}
			}

		}
		return isapplication1Displayed && isapplication2Displayed && isapplication3Displayed;
	}
	
	/**
	 * This method is used to check self linked site is selected by default
	 * @return
	 * @throws IOException
	 */
	public boolean selfLinkedSiteIsSelectedByDefault() throws IOException {
		Properties properties = reader.getProperty();
		String site1 = properties.getProperty("available.site1");
		WebElement selectedSite = utility.initializeElement(LoginPage.driver,"upload.selectedsite.xpath");
		return selectedSite.getText().equalsIgnoreCase(site1);
	}
	
	/**
	 * This method is used to select site with no surgeons
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectSiteWithNoSurgeons() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		String hospitalWithNoSurgeon = properties.getProperty("hospital.with.nosurgeon");
		List<WebElement> surgeonList = utility.initializeElements(LoginPage.driver,
				"upload.SiteSelctList.xpath");
		for(WebElement surgeon:surgeonList) {
			if(surgeon.getText().equalsIgnoreCase(hospitalWithNoSurgeon)) {
				surgeon.click();
				logger.info("Selected Surgeon: "+ surgeon.getText());
				break;
			}
		}
		clickNextBtn();
	}
	
	/**
	 * This method is used to check only one surgeon is selected
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean onlyOneSurgeonisSelected() throws IOException, InterruptedException {
		Thread.sleep(1000);
		List<WebElement> selectedSurgeons = utility.initializeElements(LoginPage.driver,"upload.selectedsurgeon.xpath");
		return selectedSurgeons.size()==1;
	}
	
	/**
	 * This method is used to locate upload failure screen elements
	 * @param element
	 * @return
	 * @throws IOException
	 */
	public WebElement uploadFailureScreen(String element) throws IOException {
		if(element.equalsIgnoreCase("Breadcrumb"))
			return utility.initializeElement(LoginPage.driver,
					"upload.failure.breadcrumb.xpath");
		else if(element.equalsIgnoreCase("icon")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.failure.icon.xpath");
		}
		else if(element.equalsIgnoreCase("upload failed text")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.failure.uploadfailed.text.xpath");
		}
		else if(element.equalsIgnoreCase("error message")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.failure.errormessage.xpath");
		}
		else if(element.equalsIgnoreCase("progress bar")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.failure.progressbar.xpath");
		}
		else if(element.equalsIgnoreCase("start new upload button")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.failure.startnew.button.xpath");
		}
		else if(element.equalsIgnoreCase("reupload button")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.failure.reupload.button.xpath");
		}
		else if(element.equalsIgnoreCase("file name")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.failure.filename.xpath");
		}
		return null;
	}

	/**
	 * This method is used to verify error message for combination of Non DICOM files and Missing mandatory tags files. 
	 * @return
	 * @throws IOException
	 */
	public boolean errorMessageForInvalidAndMissingTags() throws IOException {
		String errorMessage = uploadFailureScreen("error message").getText();
		logger.info("Error message: "+ errorMessage);
		String expectedMessage = "Upload failed. The selected file(s) may be an invalid DICOM file(s) or missing the following mandatory DICOM tag(s): Patient Name, Date of Birth, or Patient ID";
		return errorMessage.equalsIgnoreCase(expectedMessage);
	}
	
	/**
	 * This method is used to check the error message for more than 3 gb file
	 * @return
	 * @throws IOException
	 */
	public boolean errorMessageForMoreThan3Gb() throws IOException {
		String errorMessage = uploadFailureScreen("error message").getText();
		logger.info("Error message: "+ errorMessage);
		String expectedMessage = "The total size of the selected file(s) exceeds the limit of 3GB.";
		return errorMessage.equalsIgnoreCase(expectedMessage);
	}
	
	/**
	 * This method is used to check error for non dicom files
	 * @return
	 * @throws IOException
	 */
	public boolean errorMessageForNonDicomFile() throws IOException {
		String errorMessage = uploadFailureScreen("error message").getText();
		logger.info("Error message: "+ errorMessage);
		String expectedMessage = "The Selected file(s) are not valid DICOM file(s)";
		return errorMessage.equalsIgnoreCase(expectedMessage);
	}
	
	/**
	 * This method is used to check file name is displayed in upload failure screen
	 * @return
	 * @throws IOException
	 */
	public boolean fileNameIsDisplayed() throws IOException {
		WebElement filename = uploadFailureScreen("file name");
		logger.info(filename.getText());
		return filename.isDisplayed();
	}
	
	/**
	 * This method is used to check upload failure screen is displayed
	 * @return
	 * @throws IOException
	 */
	public boolean isuploadFailureScreenDisplayed() throws IOException {
		boolean breadcrump=uploadFailureScreen("Breadcrumb").isDisplayed();
		boolean icon=uploadFailureScreen("icon").isDisplayed();
		boolean uploadFailed=uploadFailureScreen("upload failed text").isDisplayed();
		boolean errorMessage=uploadFailureScreen("error message").isDisplayed();
		boolean progressbar=uploadFailureScreen("progress bar").isDisplayed();
		boolean startNewBtn=uploadFailureScreen("start new upload button").isDisplayed();
		boolean reuploadBtn=uploadFailureScreen("reupload button").isDisplayed();
		if(breadcrump) {
			logger.info("Breadcrump: "+uploadFailureScreen("Breadcrumb").getText());
		}
		if(icon) {
			logger.info("Upload failed Icon is displayed");
		}
		if(uploadFailed) {
			logger.info("Upload failed Text is displayed");
		}
		if(errorMessage) {
			logger.info("Error meassage: "+uploadFailureScreen("error message").getText());
		}
		if(progressbar) {
			logger.info("progress bar is displayed");
		}
		if(startNewBtn) {
			logger.info("start new upload button is displayed");
		}
		if(reuploadBtn) {
			logger.info("reupload button is displayed");
		}
		return breadcrump && icon && uploadFailed && errorMessage && progressbar && startNewBtn && reuploadBtn;
	}
	
	/**
	 * This method is used to check yellow dot is displayed for upload status in left menu bar
	 * @return
	 * @throws IOException
	 */
	public boolean isYellowDotForUploadStatusDisplayed() throws IOException {
		try {
			WebElement yellowdot = utility.initializeElement(LoginPage.driver,
					"leftmenu.uploadstatus.yellowdot.xpath");
			return yellowdot.isDisplayed();
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * This method is uesd to click on Re-upload button in upload failure screen
	 * @throws IOException
	 */
	public void clickReUploadBtn() throws IOException {
		uploadFailureScreen("reupload button").click();
		logger.info("Re-upload button is clicked");
	}
	
	/**
	 * This method is used to select first record in the upload status screen
	 * @throws IOException
	 */
	public void selectFirstRecordInUploadStatusScreen() throws IOException {
		WebElement firstRecordElement = utility.initializeElement(LoginPage.driver, "uploadstatus.btn.firstentry.xpath");
		String firstRecord = firstRecordElement.getText();
		firstRecordElement.click();
		logger.info("Selected record: " + firstRecord);
	}
	

	/**
	 * This method is used to click on Start New Upload Button on Upload Failure Screen
	 * @param element
	 * @return
	 * @throws IOException
	 */
	public void clickStartNewUpload() throws IOException {
		uploadFailureScreen("Start New Upload Button").click();
		logger.info("Start New Button is clicked on Upload Failure Screen");
		
	}
	

	/**
	 * This method is used to locate elements image upload failure screen
	 * @param element
	 * @return
	 * @throws IOException
	 */
	public WebElement imageUploadingFailureScreen(String element) throws IOException {
		WebDriverWait wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60));
		if(element.equalsIgnoreCase("Breadcrumb"))
			return utility.initializeElement(LoginPage.driver,
					"upload.failurescreen.breadcrumb.xpath");
		
		else if(element.equalsIgnoreCase("Upload Failed Icon")) {
			return utility.initializeElement(LoginPage.driver,
					"upload.uploadingscreen.snlogo.xpath");
		}
		
		else if(element.equalsIgnoreCase("Error Message"))
			return utility.initializeElement(LoginPage.driver,
					"uploadfailed.notdicom.xpath");
		
		else if(element.equalsIgnoreCase("Yellow Progress Bar"))
			return utility.initializeElement(LoginPage.driver,
					"upload.failurescreen.yellowbar.xpath");
		
		else if(element.equalsIgnoreCase("Start New Upload Button"))
			return utility.initializeElement(LoginPage.driver,
					"uploadfailed.startnewupload.btn.xpath");
		
		else if(element.equalsIgnoreCase("Re-Upload Button"))
			return utility.initializeElement(LoginPage.driver,
					"uploadfailed.reupload.btn.xpath");
		
		else if(element.equalsIgnoreCase("Upload File Label"))
			return utility.initializeElement(LoginPage.driver,
					"upload.failurescreen.uploadfilestext.xpath");
		
		
		return null;
	}
	

	/**
	 * This method is used to check image upload failure screen
	 * @return
	 * @throws IOException
	 */
	public boolean isImageUploadFailureScreenDisplayed() throws IOException {
		boolean breadcrump=imageUploadingFailureScreen("Breadcrumb").isDisplayed();
		boolean UploadFailedIcon=imageUploadingFailureScreen("Upload Failed Icon").isDisplayed();
		boolean ErrorMessage=imageUploadingFailureScreen("Error Message").isDisplayed();
		boolean ProgressBar=imageUploadingFailureScreen("Yellow Progress Bar").isDisplayed();
		boolean StartNewUploadButton=imageUploadingFailureScreen("Start New Upload Button").isDisplayed();
		boolean ReUploadButton=imageUploadingFailureScreen("Re-Upload Button").isDisplayed();
		boolean UploadFileLabel=imageUploadingFailureScreen("Upload File Label").isDisplayed();
		if(breadcrump) {
			logger.info("Breadcrump: "+imageUploadingFailureScreen("Breadcrumb").getText());
		}
		if(UploadFailedIcon) {
			logger.info("The Upload Failed is displayed");
		}
		if(ErrorMessage) {
			logger.info("Error Message is displayed as : " +imageUploadingFailureScreen("Error Message").getText());
		}
		if(ProgressBar) {
			logger.info("Yellow Progress Bar is displayed");
		}
		if(StartNewUploadButton) {
			logger.info("Start New Upload Button is displayed");
		}
		if(ReUploadButton) {
			logger.info("Re-Upload Button is displayed");
		}
		if(UploadFileLabel) {
			logger.info("Upload File label is displayed");
		}
		return breadcrump && UploadFailedIcon && ErrorMessage && ProgressBar && StartNewUploadButton && ReUploadButton && UploadFileLabel;
	}
}