package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.PropertiesFileReader;
import utility.Utility;

public class FacilityListPage {
	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(FacilityListPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to get facility list on selection modal screen.
	 * 
	 * @throws IOException
	 */
	public String getFacilityListText() throws IOException {
		List<WebElement> element = LoginPage.driver
				.findElements(By.xpath("//*[@id=\"addNewFacilitySelect\"]/div/div/div[3]/div[2]/ul/li"));
		WebElement q = null;
		int count = element.size();
		logger.info("Number of Facility listed in  Site Selection Screen : " + count);
		for (int i = 0; i < element.size(); i++) {
			q = element.get(i);
			logger.info("Facility Name listed is : " + q.getText());
		}
		return q.getText();
	}

	/**
	 * This method is used to check if the button displayed.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean backButtonDisplayed() throws IOException {
		logger.info("Verify Back and Next Button on Homescreen");
		logger.info("Back Button is Displayed : "
				+ utility.initializeElement(LoginPage.driver, "facility.btn.back.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facility.btn.back.xpath").isDisplayed();
	}

	public Boolean NextButtonDisplayed() throws IOException {
		logger.info("Next Button is Displayed : "
				+ utility.initializeElement(LoginPage.driver, "facility.btn.next.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facility.btn.next.xpath").isDisplayed();
	}

	public Boolean dontSeeButtonDisplayed() throws IOException {
		logger.info("Verify I don't see my site listed on Homescreen");
		logger.info("I don't see my site listed Button is Displayed : "
				+ utility.initializeElement(LoginPage.driver, "facility.btn.nofacility.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facility.btn.nofacility.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if Next button is enabled.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isNextButtonEnabled() throws IOException {
		logger.info("Verifying Next Button should be in enabled state once facility is selected ");
		logger.info("Next button is enabled : "
				+ utility.initializeElement(LoginPage.driver, "facility.btn.next.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "facility.btn.next.xpath").isEnabled();
	}

	/**
	 * This method is used to click I don't see my site Listed button on facility
	 * screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickifNofacility() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facility.btn.nofacility.xpath").click();
		logger.info("clickIdon'tSeeMySiteListed Button : Clicked I don't see my site listed button");
	}

	/**
	 * This method is used to get notification message when user clicks on I don't
	 * see any site listed
	 * 
	 * @throws IOException
	 */
	public String verifymsg() throws IOException {
		return utility.initializeElement(LoginPage.driver, "facility.msg.nofacility.xpath").getText();
	}

	/**
	 * This method is used to select Facility which has only one surgeon associated.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectFacilityOneSurgoen() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facility.onesur.btn.xpath").click();
		logger.info("Selected Facility is : "
				+ utility.initializeElement(LoginPage.driver, "facility.onesur.btn.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectFacility : Clicked Selected Facility ");
	}

	/**
	 * This method is used to select Facility which has surgeon listed
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectFacilityListedSurgeon() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "facility.surglist.btn.xpath").click();
			logger.info("Selected Facility is : "
					+ utility.initializeElement(LoginPage.driver, "facility.surglist.btn.xpath").getText());
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();", LoginPage.driver
					.findElement(By.xpath("//*[@id=\"addNewFacilitySelect\"]/div/div/div[3]/div[2]/ul/li[2]/a")));
			logger.info("Selected Facility is : "
					+ utility.initializeElement(LoginPage.driver, "facility.surglist.btn.xpath").getText());
		}
		logger.info("SelectFacility : Clicked Selected Facility ");
	}

	/**
	 * This method is used to check if Facility is selected by default
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSiteSelected() throws IOException {
		logger.info("Verifying Facility should be selected by default and Next button should be in enabled state");
		logger.info("Facility Name displayed is : "
				+ utility.initializeElement(LoginPage.driver, "facility.bydefault.selected.xpath").getText());
		logger.info("Facility is selected by default : "
				+ utility.initializeElement(LoginPage.driver, "facility.bydefault.selected.xpath").isSelected());
		return utility.initializeElement(LoginPage.driver, "facility.bydefault.selected.xpath").isSelected();
	}

	/**
	 * This method is used to click facility which has no Surgeon associated
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectfacilitynoSurgeon() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facility.nosurgeon.btn.xpath").click();
		logger.info("Selected Facility is : "
				+ utility.initializeElement(LoginPage.driver, "facility.surglist.btn.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectFacility which has no surgeon associated : Clicked Selected Facility ");

	}

	/**
	 * This method is used to check if Facility is selected by default
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSearchBoxDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath").isDisplayed();

	}

	/***
	 * This method is used to enter string text.
	 * 
	 * @throws IOException
	 */
	public WebElement enterTextInSearchBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath").clear();
		logger.info("The text in search box entered");
		return utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath");

	}

	/**
	 * This method is used to check entered ABCH text records displayed in list or
	 * not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedABCHText() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "facility.search.list.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of matching records in facility list : " + count);
		if (list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				q = list.get(i);
				logger.info("Matching Facility Name text is : " + q.getText());

			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check entered A text records displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedAText() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "facility.search.list.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of matching records in facility list : " + count);
		if (list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				q = list.get(i);
				logger.info("Matching Facility Name text is : " + q.getText());

			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check entered zx text records displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedZXText() throws IOException {

		List<WebElement> list = utility.initializeElements(LoginPage.driver, "facility.search.list.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of matching records in facility list : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					logger.info("Matching Facility Name text is : " + q.getText());
				}
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.info("No matching list present with text zx");
		}
		return false;
	}

	/**
	 * This method is used to check entered Baystate Wing Hospital text records
	 * displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedExactext() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "facility.search.list.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of matching records in facility list : " + count);
		if (list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				q = list.get(i);
				if (q.getText().contains("Baystate Wing Hospital")) {
					logger.info("Matching Facility Name text is : " + q.getText());
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check if upload files header text displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean uploadFilesHeader() throws IOException {
		logger.info("Upload Files Header is displayed : "
				+ utility.initializeElement(LoginPage.driver, "upload.txt.title.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "upload.txt.title.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if facility modal header text displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean facilityHeaderTitle() throws IOException {
		logger.info("Facility Header Title is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facility.txt.header.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facility.txt.header.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if search site text displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean searchSiteTextTitle() throws IOException {
		logger.info("Seach Site Title is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facility.searchsite.txt.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facility.searchsite.txt.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if search box text displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String searchBoxText() throws IOException {
		logger.info("Seach box text is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facility.searchsite.txt.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath").getAttribute("placeholder")
				.trim();
	}

	/**
	 * This method is used to check if X button displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isXButtonDisplayed() throws IOException {
		logger.info("X button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facility.btn.close.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facility.btn.close.xpath").isDisplayed();
	}

	/**
	 * This method is used to select a facility from the list
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void selectFacilityFromList() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facility.list.first.xpath").click();
		logger.info("Selected Facility is : "
				+ utility.initializeElement(LoginPage.driver, "facility.list.first.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectedFacility: Clicked Selected Facility");
	}

	/**
	 * This method is used to click on next button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void clickOnNextButton() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "facility.btn.nextbutton.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "facility.btn.nextbutton.xpath"));
		}
		logger.info("clickNextButton : Clicked Next button");
//		utility.initializeElement(LoginPage.driver, "facility.btn.nextbutton.xpath").click();
//		logger.info("clickOnNextButton: Clicked Next Button on Facility");
	}
	
	/**
	 * This method is used to check searched site name displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedSearchedSiteName() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "facility.search.list.xpath");
		int count = list.size();
		WebElement q = null;
		String searchbox = utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath").getAttribute("value");
		logger.info(searchbox);
		logger.info("Number of matching records in facility list : " + count);
			for (int i = 0; i < list.size(); i++) {
				q = list.get(i);
				if(q.getText().contains(searchbox)) {
				logger.info("Matching searched site Name is : " + q.getText());
				}

			}
			return true;
	}
	
	/**
	 * This method is used to hover over one site name
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void hoverOverSiteName() throws IOException, InterruptedException {
		WebElement site = utility.initializeElement(LoginPage.driver, "facility.search.list.first.xpath");
		//Creating object of an Actions class
		Actions action = new Actions(LoginPage.driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(site).perform();

	}
	
	/**
	 * This method is used to check if hover over site name displayed in green color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isSiteNameDisplayedInGreenColour() throws IOException {
		logger.info("Site name is displayed in Green Colour : "
				+ utility.initializeElement(LoginPage.driver, "facility.search.list.first.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "facility.search.list.first.xpath").getCssValue("color");
	}
	
	/***
	 * This method is used to clear search box text.
	 * 
	 * @throws IOException
	 */
	public void clearSearchBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath").clear();
		logger.info("The text in search box is cleared");
	}

	public String chooseSitemsg() throws IOException, InterruptedException 
	{
		Thread.sleep(10000);
		return utility.initializeElement(LoginPage.driver, "facility.screen.txt.xpath").getText();
	}
	
	public void selectFacilityFromChooseSite() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		utility.initializeElement(LoginPage.driver, "facility.search.textbox.xpath").sendKeys(properties.getProperty("available.site1"));
		utility.initializeElement(LoginPage.driver, "facility.search.textbox.xpath").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "facility.first.btn.xpath").click();
		logger.info("Selected Facility is : "
				+ utility.initializeElement(LoginPage.driver, "facility.first.btn.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectedFacility: Clicked Selected Facility");
	}
	
	public void selectAnotherFacilityFromChooseSite() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facility.second.site.xpath").click();
		logger.info("Selected Facility is : "
				+ utility.initializeElement(LoginPage.driver, "facility.second.site.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectedFacility: Clicked Selected Facility");
	}
	
	public void clickOnSelectBtn() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "facility.select.button.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "facility.select.button.xpath"));
		}
		logger.info("clickSelectButton : Clicked Select button");

	}
	
	public void clickOnChooseSiteButton() throws IOException, InterruptedException {
		logger.info("clickOnChooseSiteButton : Clicked Choose Site button");
		{
			try {
				utility.initializeElement(LoginPage.driver, "leftnavigation.choosesite.xpath").click();
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
				executor.executeScript("arguments[0].click();",
						utility.initializeElement(LoginPage.driver, "leftnavigation.choosesite.xpath"));
			}
		}
	}

	/**
	 * This method is to enter the word hospital into the facility list search bar
	 * 
	 * @throws IOException
	*/
	public void searchForHospital() throws IOException {
		logger.info("User searched for Hosptital");
		utility.initializeElement(LoginPage.driver, "dashboard.placeholder.text.xpath").sendKeys("Hospital");
	}

	/**
	 * This method is used to select sit of IC admin
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectICAdminSiteFromChooseSite() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		utility.initializeElement(LoginPage.driver, "facility.search.textbox.xpath").sendKeys(properties.getProperty("icsitename"));
		utility.initializeElement(LoginPage.driver, "facility.search.textbox.xpath").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "facility.first.btn.xpath").click();
		logger.info("Selected Facility is : "
				+ utility.initializeElement(LoginPage.driver, "facility.first.btn.xpath").getText());
		logger.info("SelectedFacility: Clicked Selected Facility");
	}
	
/**
	 * This method is used to check if only one site is displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isOnlyOneSiteDisplayed() throws IOException {
		utility.initializeElement(LoginPage.driver, "facility.selectedsite.xpath").click();
		Boolean b = utility.initializeElement(LoginPage.driver, "facility.selectedsite.xpath").isSelected();
		logger.info("Site is Selected bydefault :" +b);
		Boolean bool = utility.initializeElement(LoginPage.driver, "facility.selectedsite.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Only One Site is displayed");
			String msg = utility.initializeElement(LoginPage.driver, "facility.selectedsite.xpath").getText();
			logger.info("Site displayed as : "+msg);
			return true;
		} else {
			logger.info("Site is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is used to check if only one surgeon is displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isOnlyOneSurgeonDisplayed() throws IOException {
		utility.initializeElement(LoginPage.driver, "surgeon.selectedsite.xpath").click();
		Boolean b = utility.initializeElement(LoginPage.driver, "surgeon.selectedsite.xpath").isSelected();
		logger.info("Surgeon is Selected bydefault :" +b);
		Boolean bool = utility.initializeElement(LoginPage.driver, "surgeon.selectedsite.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Only One Surgeon is displayed");
			String msg = utility.initializeElement(LoginPage.driver, "surgeon.selectedsite.xpath").getText();
			logger.info("Surgeon displayed as : "+msg);
			return true;
		} else {
			logger.info("Surgeon is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is used to check if Next button is enabled.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isNextBtnEnabled() throws IOException {
		logger.info("Verifying Next Button should be in Enabled state if only one surgeon is present");
		logger.info("Next button is enabled : " + utility.initializeElement(LoginPage.driver, "surgeon.btn.next.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "surgeon.btn.next.xpath").isEnabled();
	}
	
	/**
	 * This method is used to check if only one application card is displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public Boolean isOnlyOneApplicationDisplayed() throws IOException, InterruptedException 
	{
		utility.initializeElement(LoginPage.driver, "application.selectedcard.xpath").click();
		Thread.sleep(2000);
		Boolean b = utility.initializeElement(LoginPage.driver, "application.selectedcard.xpath").isSelected();
		logger.info("Application Card is Selected bydefault : " +b);
		Boolean bool = utility.initializeElement(LoginPage.driver, "application.selectedcard.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Only One Application Card is displayed");
			String msg = utility.initializeElement(LoginPage.driver, "application.selectedcard.xpath").getText();
			logger.info("Application Card displayed as : "+msg);
			return true;
		} else {
			logger.info("Application Card is not displayed");
			return false;
		}
	}
	/**
	 * This method is used to check if ERROR message is displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isErrorMessageDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "upload.nositeshown.txt.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Error Message is displayed");
			String msg = utility.initializeElement(LoginPage.driver, "upload.nositeshown.txt.xpath").getText();
			logger.info("Error Message : " +msg);
			return true;
		} else {
			logger.info("Error Message is not displayed");
			return false;
		}
	}
        /***
	 * This method is used to backspace search box text.
	 * 
	 * @throws IOException
	 */
	public void BackspacetextinSearchBox(String fullsite) throws IOException {
		WebElement search = utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath");
		if (fullsite != null) {
			int realLength = fullsite.length();
			for (int i = 0; i < realLength; i++) {
				search.sendKeys(Keys.BACK_SPACE);
			}
		} else {

			for (int i = 0; i < 11; i++)
				search.sendKeys(Keys.BACK_SPACE);
		}

		logger.info("The text in search box is removed");
	}

	/***
	 * This method is used to verify blank screen.
	 * 
	 * @throws IOException
	 */
	public void Blankscreen() throws IOException {
		{
			WebElement blankscreen = utility.initializeElement(LoginPage.driver, "facility.blank.xpath");
			String listofsites = blankscreen.getAttribute("value");
			if (listofsites == null)
			{
				System.out.println("the Blank screen is displayed with no search results");
			} else {
				logger.info("Search result found");
			}
		}

	}

	/***
	 * This method is used to enter space in Search Box.
	 * 
	 * @throws IOException
	 */
	public void Enterandremovespace() throws IOException {

		for (int i = 0; i < 11; i++) {
			WebElement spaces = utility.initializeElement(LoginPage.driver, "facility.txtbox.search.xpath");
			spaces.sendKeys(Keys.SPACE);

		}
	}
}
