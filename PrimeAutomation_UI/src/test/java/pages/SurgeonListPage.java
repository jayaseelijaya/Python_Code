package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Utility;

public class SurgeonListPage {

	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(SurgeonListPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to click UploadFiles from LeftPanel on home screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickUploadFilesLeftPane() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "leftnavigation.uploadfiles.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"menu_item2\"]//span")));
		}
		logger.info("clickUploadFilesButton : Clicked UploadFiles button from Left pane");
	}

	/**
	 * This method is used to click Upload-file button on Home screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickUploadFileButton() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "upload.btn.click.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"upload-file\"]")));
		}
		logger.info("clickUploadButton : Clicked Upload button");
	}

	/**
	 * This method is used to select Facility from Upload screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectFacility() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facility.btn.click.xpath").click();
		logger.info("Selected Facility is : "
				+ utility.initializeElement(LoginPage.driver, "facility.btn.click.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectFacility : Clicked Selected Facility ");
	}

	/**
	 * This method is used to click Next Button on Upload screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void nextButton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facility.btn.next.xpath").click();
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("clickNextButton: Clicked Next button");
	}

	/**
	 * This method is used to get notification message which doesn't have surgeon in the list.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String verifySurgeonmsg() throws IOException {
		return utility.initializeElement(LoginPage.driver, "surgeon.error.msg.xpath").getText();
	}

	/**
	 * This method is used to get Surgeon Names from the list.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String getSurgeonText() throws IOException {
		List<WebElement> element = LoginPage.driver
				.findElements(By.xpath("//*[@class='surgeon-list-up align-list ng-star-inserted']"));
		WebElement q = null;
		int count = element.size();
		logger.info("Surgeon associated with Facility Id : " + count);
		for (int i = 0; i < element.size(); i++) {
			q = element.get(i);
			logger.info("Surgeon listed as : " + q.getText());
		}
		return q.getText();
	}

	/**
	 * This method is used to check if Surgeon is selected by default
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isSurgeonSelected() throws IOException {
		logger.info("Verifying Surgeon should be selected by default and Next button should be in enabled state");
		logger.info("Surgeon Name displayed is : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.bydefault.selected.xpath").getText());
		logger.info("Next button is enabled : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.btn.next.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "surgeon.btn.next.xpath").isEnabled();
	}

	/**
	 * This method is used to check if Next button is disabled.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isNextButtonDisabled() throws IOException {
		logger.info("Verifying Next Button should be in Disabled state if more than one surgeon is listed or no surgeon is selected ");
		logger.info("Next button is enabled : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.btn.next.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "surgeon.btn.next.xpath").isEnabled();
	}

	/**
	 * This method is used to click Back Button on Surgeon Selection screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void BackBtnSurgeon() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "surgeon.btn.back.xpath").click();
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("clickBackButton: Clicked Back button");
}
	
	/**
	 * This method is used to select Surgeon from Surgeon selection modal screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectSurgeon() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "surgeon.select.btn.xpath").click();
		logger.info("Selected Surgeon is : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.select.btn.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectSurgeon : Clicked Selected Surgeon ");
	}
	
	/**
	 * This method is used to check if Back button is enabled.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isBackButtonEnabled() throws IOException {
		logger.info("Verifying Back Button should be in Enabled state and Clickable");
		logger.info("Back button is enabled : " + utility.initializeElement(LoginPage.driver, "surgeon.btn.back.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "surgeon.btn.back.xpath").isEnabled();
	}
	
	/**
	 * This method is used to click Next Button on Surgeon Selection screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void NextBtnSurgeon() throws IOException, InterruptedException 
	{
		utility.initializeElement(LoginPage.driver, "surgeon.btn.next.xpath").click();
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("clickNextButton: Clicked Next button");
    }
	
	/**
	 * This method is used to select Surgeon which has application cards
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectSurgeonAppCards() throws IOException, InterruptedException 
	{
		utility.initializeElement(LoginPage.driver, "surgeon.appcards.btn.xpath").click();
		logger.info("Selected Surgeon is : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.appcards.btn.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectSurgeon: Clicked Selected Surgeon button");
	}
	
	/**
	 * This method is used to check if surgeon search box displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSurgeonSearchBoxDisplayed() throws IOException {
		logger.info("Surgeon Search Box is Displayed : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath").isDisplayed();

	}
	
	/***
	 * This method is used to enter string text.
	 * 
	 * @throws IOException
	 */
	public WebElement enterTextInSurgeonSearchBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath").clear();
		logger.info("enteredText: text entered in surgeon search box");
		return utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath");
	}
	
	/**
	 * This method is used to check entered B text records displayed in list or
	 * not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedBText() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "surgeon.search.list.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of matching records in surgeon list : " + count);
		if (list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				q = list.get(i);
				logger.info("Matching surgeon Name text is : " + q.getText());

			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check entered D text records displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedDText() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "surgeon.search.list.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of matching records in surgeon list : " + count);
		if (list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				q = list.get(i);
				logger.info("Matching surgeon Name text is : " + q.getText());

			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check entered ac text records displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedACText() throws IOException {

		List<WebElement> list = utility.initializeElements(LoginPage.driver, "surgeon.search.list.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of matching records in surgeon list : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					logger.info("Matching surgeon Name text is : " + q.getText());
				}
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.info("No matching surgeon name present with text ac");
		}
		return false;
	}

	/**
	 * This method is used to check entered ElizabethAnnDailey text records
	 * displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedExactSurgeon() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "surgeon.search.list.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of matching records in surgeon list : " + count);
		if (list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				q = list.get(i);
				if (q.getText().contains("ElizabethAnnDailey")) {
					logger.info("Matching Surgeon Name text is : " + q.getText());
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * This method is used to check if surgeon modal header text displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean surgeonHeaderTitle() throws IOException {
		logger.info("Surgeon Header Title is displayed : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.txt.header.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "surgeon.txt.header.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if search surgeon text displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean searchSurgeonTextTitle() throws IOException {
		logger.info("Seach Surgeon Title is displayed : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.searchsurgeon.txt.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "surgeon.searchsurgeon.txt.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if surgeon search box text displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String surgeonSearchBoxText() throws IOException {
		logger.info("Surgeon Seach box text is displayed : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath").getAttribute("placeholder")
				.trim();
	}

	public void selectSurgNoAppCards() throws IOException {
		utility.initializeElement(LoginPage.driver, "surgeon.noappcard.btn.xpath").click();
		logger.info("Selected Surgeon is : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.noappcard.btn.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectSurgeon: Clicked Selected Surgeon button");
		

	}
	/**
	 * This method is used to check if surgeon selection screen displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSurgeonSelectionScreenDisplayed() throws IOException {
		logger.info("Surgeon Selection Screen is displayed : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.screen.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "surgeon.screen.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to select a surgeon from the list
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectSurgeonFromList() throws IOException, InterruptedException 
	{
		utility.initializeElement(LoginPage.driver, "surgeon.list.first.xpath").click();
		logger.info("Selected Surgeon is : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.list.first.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectedSurgeon: Clicked Selected Surgeon");
	}
	/**
	 * This method is used to split the surgeon's first and last names from the fullname.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String splitSurgeonName(String surgeonname) throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		if (surgeonname.equalsIgnoreCase("first name")) {
			String surgeonfirstname = properties.getProperty("available.site1.surgeon1").split(" ")[0];
			return surgeonfirstname;
		}
		else if (surgeonname.equalsIgnoreCase("last name"))
				{
			String surgeonlastname = properties.getProperty("available.site1.surgeon3").split(" ")[1];
			return surgeonlastname;
		}
		else {
			String surgeonfullname = properties.getProperty("available.site1.surgeon3");
			return surgeonfullname;
		}
		
		
	}
	public void deleteTextinSearchbox() throws IOException {
		WebElement search = utility.initializeElement(LoginPage.driver, "surgeon.txtbox.search.xpath");
		{
			for (int i = 0; i < 13; i++)
				search.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	/**
	 * This method is used to check the blankscreen is displayed or not 	 * 
	 * @return boolean
	 * @throws IOException
	 */

	public boolean blankScreenDisplayed() throws IOException {
		try {

			WebElement Listofsurgeon = utility.initializeElement(LoginPage.driver,

					"surgeon.search.list.xpath");

			return Listofsurgeon.isDisplayed();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			return true;

		}
	}
	
	/**
	 * This method is used to click the surgeon with no applicationcard linking. 
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectSurgeonWithNoapplicationCard() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		String surgeonWithNoapplication = properties.getProperty("surgeon.withoutapplicationcard");
		List<WebElement> surgeonList = utility.initializeElements(LoginPage.driver,
				"surgeon.listofsurgeon.xpath");
		for(WebElement surgeon:surgeonList) {
			if(surgeon.getText().equalsIgnoreCase(surgeonWithNoapplication)) {
				surgeon.click();
				logger.info("Selected Surgeon: "+ surgeon.getText());
				break;
			}
			
		}
		NextBtnSurgeon();
		
	}
}
