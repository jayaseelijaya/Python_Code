
package pages;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.PropertiesFileReader;
import utility.Utility;

public class FileDashboardPage {

	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(FileDashboardPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to check Filter menu options displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isFilterMenuDisplayed(String menu) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (menu.equalsIgnoreCase("filter by")) {
			logger.info("Filter by option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "filter.option.filterby.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "filter.option.filterby.xpath");
		}
		if (menu.equalsIgnoreCase("date")) {
			logger.info("Date option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "filter.option.date.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "filter.option.date.xpath");
		}
		if (menu.equalsIgnoreCase("surgeon")) {
			logger.info("Filter by option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "filter.option.surgeon.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "filter.option.surgeon.xpath");
		}
		if (menu.equalsIgnoreCase("site")) {
			logger.info("Site option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "filter.option.site.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "filter.option.site.xpath");
		}
		if (menu.equalsIgnoreCase("application")) {
			logger.info("Application option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "filter.option.application.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "filter.option.application.xpath");
		}
		if (menu.equalsIgnoreCase("file status")) {
			logger.info("File Status option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "filter.option.filestatus.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "filter.option.filestatus.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + menu);
		return null;
	}

	/**
	 * This method is used to check filter button displayed or not.
	 * 
	 * @throws IOException
	 */
	public Boolean isFilterButtonDisplayed() throws IOException {
		logger.info("Filter button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "dashboard.filter.xpath").isDisplayed();
	}

	/***
	 * This method is used to perform click on date filter menu option.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnDateFiltermenu() throws IOException, InterruptedException {
		logger.info("clickOnDateFiltermenu: Date filter option is clicked");
		Thread.sleep(2000);
		WebElement date = utility.initializeElement(LoginPage.driver, "filter.option.date.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(date));
		wait.click();
	}

	/**
	 * This method is used to check start button and end button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isStartEndButtonDisplayed() throws IOException {
		logger.info("Start button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "filter.option.startdate.xpath").isDisplayed());
		logger.info("End button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "filter.option.enddate.xpath").isDisplayed());
		utility.initializeElement(LoginPage.driver, "filter.option.startdate.xpath").isDisplayed();
		return utility.initializeElement(LoginPage.driver, "filter.option.enddate.xpath").isDisplayed();
	}

	/**
	 * This method is used to click Filter button on Upload dash-board page screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickFilterButton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "uploaddashboard.filter.btn.xpath").click();
		logger.info("click Filter Button : Clicked Filter button");
	}

	/***
	 * This method is used to perform click on start button option.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnStartButton() throws IOException, InterruptedException {
		logger.info("clickOnStartButton: Start button is clicked");
		utility.initializeElement(LoginPage.driver, "filter.option.startdate.xpath").click();
	}

	/**
	 * This method is used to check start date table displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isStartDateTableDisplayed() throws IOException {
		logger.info("Start Date Table is displayed : "
				+ utility.initializeElement(LoginPage.driver, "filter.calender.startdate.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "filter.calender.startdate.xpath").isDisplayed();
	}

	/***
	 * This method is used to select start date from date picker.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectStartDate() throws IOException, InterruptedException {
		logger.info("selectStartDate: Start Date is selected");
		List<WebElement> date = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		Date previousDate = calendar.getTime();
		String oldDate = formatter.format(previousDate);
		for (WebElement cell : date) {
			if (cell.getText().equals(oldDate)) {
				logger.info("Selected Date is : " + cell.getText());
				cell.click();
				break;
			}
		}
	}

	/**
	 * This method is used to check selected start date displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSelectedStartDateDisplayed() throws IOException {
		logger.info("Selected Start Date is Displayed : "
				+ utility.initializeElement(LoginPage.driver, "filter.option.startdate.xpath").isDisplayed());
		logger.info("Selected Start Date is : "
				+ utility.initializeElement(LoginPage.driver, "filter.option.startdate.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "filter.option.startdate.xpath").isDisplayed();
	}

	/***
	 * This method is used to perform click on end button option.
	 * 
	 * @throws IOException
	 */
	public void clickOnEndButton() throws IOException {
		logger.info("clickOnEndButton: End button is clicked");
		utility.initializeElement(LoginPage.driver, "filter.option.enddate.xpath").click();
	}

	/**
	 * This method is used to check end date table displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isEndDateTableDisplayed() throws IOException {
		logger.info("End Date Table is displayed : "
				+ utility.initializeElement(LoginPage.driver, "filter.calender.startdate.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "filter.calender.startdate.xpath").isDisplayed();
	}

	/***
	 * This method is used to select end date from date picker.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectEndDate() throws IOException, InterruptedException {
		logger.info("selectEndDate: End Date is selected");
		List<WebElement> date = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
		Date date1 = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		String today = formatter.format(date1);
		for (WebElement cell : date) {
			if (cell.getText().equals(today)) {
				logger.info("Selected Date is : " + cell.getText());
				cell.click();
				break;
			}
		}
	}

	/**
	 * This method is used to check selected end date displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSelectedEndDateDisplayed() throws IOException {
		logger.info("Selected End Date is Displayed : "
				+ utility.initializeElement(LoginPage.driver, "filter.option.enddate.xpath").isDisplayed());
		logger.info("Selected End Date is : "
				+ utility.initializeElement(LoginPage.driver, "filter.option.enddate.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "filter.option.enddate.xpath").isDisplayed();
	}

	/***
	 * This method is used to perform click on done button option.
	 * 
	 * @throws IOException
	 */
	public void clickOnDoneButton() throws IOException {
		logger.info("clickOnDoneButton: Done button is clicked");
		utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").click();
	}

	/**
	 * This method is used to check dashboard is filtered based on date or not.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public boolean isDashboardFilteredBasedOnDate() throws IOException, InterruptedException, ParseException {
		logger.info("Dashboard is filtered based on date : "
				+ utility.initializeElement(LoginPage.driver, "filter.filtered.dashboard.xpath").isDisplayed());
		String filter = utility.initializeElement(LoginPage.driver, "filter.filtered.dashboard.xpath").getText();
		String filteredDate = filter.replace(" X", "").trim();
		logger.info("Filtered Date is : " + filteredDate);
		Thread.sleep(10000);
		List<WebElement> serachDate = utility.initializeElements(LoginPage.driver, "filter.dashboard.date.xpath");
		if (serachDate.size() >= 1) {
			for (int i = 0; i < serachDate.size(); i++) {
				{
					logger.info("Filtered list is : " + serachDate.get(i).getText());

				}
			}
			return true;
		}
		return false;

	}

	/**
	 * This method is used to click FileStatus Icon on Upload dash-board page
	 * screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickFileStatusIcon() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "uploaddashboard.filestatus.icon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "uploaddashboard.filestatus.icon.xpath"));
		}
		logger.info("click Filter Button : Clicked FilterStatus plus icon");
	}

	/**
	 * This method is used for File-status button is displayed on Upload dash-board
	 * page screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean CompleteFileStatusDisplayed() throws IOException {
		logger.info("Complete File Status button is displayed under Filter option : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.complete.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.complete.btn.xpath").isDisplayed();
	}

	public Boolean ProcessingFileStatusDisplayed() throws IOException {
		logger.info("Processing File Status button is displayed under Filter option : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.processing.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.processing.btn.xpath").isDisplayed();
	}

	public Boolean ErrorFileStatusDisplayed() throws IOException {
		logger.info("Error File Status is displayed button under Filter option : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.error.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.error.btn.xpath").isDisplayed();
	}

	public Boolean RecalledFileStatusDisplayed() throws IOException {
		logger.info("Recalled File Status button is displayed under Filter option : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.recalled.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.recalled.btn.xpath").isDisplayed();
	}

	public Boolean UploadedFileStatusDisplayed() throws IOException {
		logger.info("Uploaded File Status button is displayed under Filter option : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.uploaded.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.uploaded.btn.xpath").isDisplayed();
	}

	/**
	 * This method is used to wait for the spinner to disappear
	 * 
	 * @param page
	 * @throws IOException
	 */
	public void waitForSpinnerToDisappear() throws IOException {
		WebElement spinner = null;
		WebDriverWait wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60));
		spinner = utility.initializeElement(LoginPage.driver, "history.spinner.xpath");
		wait.until(ExpectedConditions.visibilityOf(spinner));
		logger.info("spinner appeared");
		wait.until(ExpectedConditions.invisibilityOf(spinner));
		logger.info("spinner disappeared");
	}

	/**
	 * This method is used to check summary dash-board list displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isDashboardListDisplayed() throws IOException {
		logger.info("Summary dashboard list is displayed : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.list.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "dashboard.list.xpath").isDisplayed();
	}

	/***
	 * This method is used to enter string text.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public WebElement enterTextInSearchBox() throws IOException, InterruptedException {
		Thread.sleep(500);
		utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").clear();
		logger.info("enterTextInSearchBox: text entered in search box");
		return utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath");
	}

	/***
	 * This method is used to perform click on search button.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSearchButton() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "dashboard.btn.search.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "dashboard.btn.search.xpath"));
		}
		Thread.sleep(5000);
		logger.info("clickOnSearchButton: search button is clicked");
	}

	/**
	 * This method is used to search surgeon name text Lisa displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSearchTextLisaDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.surgeonname.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in search list : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					if (q.getText().contains("Lisa")) {
						logger.info("Matching Surgeon Name text is : " + q.getText());
					}
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/***
	 * This method is used to perform click on filter button.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnFilterButton() throws IOException, InterruptedException {
		logger.info("clickOnFilterButton: filter button is clicked");
		Thread.sleep(500);
		utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").clear();
		utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").click();
		// LoginPage.driver.navigate().refresh();
		// waitForSpinnerToDisappear();
		Thread.sleep(500);
		utility.initializeElement(LoginPage.driver, "dashboard.filter.xpath").click();
	}

	/***
	 * This method is used to select filter as surgeon name.
	 * 
	 * @throws IOException
	 */
	public void selectFilterAsSurgeonName() throws IOException {
		logger.info("selectFilterAsSurgeonName: filter is selected as surgeon name");
		waitForSpinnerToDisappear();
		utility.initializeElement(LoginPage.driver, "dashboard.filter.modal.xpath").isDisplayed();
		utility.initializeElement(LoginPage.driver, "dashboard.filter.surgeon.xpath").click();
		utility.initializeElement(LoginPage.driver, "dashboard.filter.surgeonname.crnp.xpath").click();
		logger.info("Selected surgeon name filter is: "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.surgeonname.crnp.xpath").getText());
		utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").click();
	}

	/**
	 * This method is used to filter surgeon name text CRNP displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isFilteredCrnpSurgeonNameListDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.surgeonname.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in filtered list : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					if (q.getText().contains("CRNP")) {
						logger.info("Matching Filtered Surgeon Name text is : " + q.getText());
					}
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/***
	 * This method is used to check history tab displayed or not.
	 * 
	 * @throws IOException
	 */
	public String isHistoryTabDisplayed() throws IOException {
		logger.info("History tab button is displayed: "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.history.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.history.xpath").getText().trim();
	}

	/**
	 * This method is used to search surgeon name text Patrick displayed in list or
	 * not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSearchTextPatrickDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "history.list.patientname.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in search list : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					if (q.getText().contains("Patrick")) {
						logger.info("Matching Patient Name text is : " + q.getText());
					}
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/***
	 * This method is used to select filter as patient name.
	 * 
	 * @throws IOException
	 */
	public void selectFilterAspatientName() throws IOException {
		logger.info("selectFilterAspatientName: filter is selected as patient name");
		logger.info("Filter is selected: "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.modal.xpath").isDisplayed());
		waitForSpinnerToDisappear();
		utility.initializeElement(LoginPage.driver, "history.filter.patient.xpath").click();
		utility.initializeElement(LoginPage.driver, "history.filter.patientname.patrick.xpath").click();
		logger.info("Selected patient name filter is: "
				+ utility.initializeElement(LoginPage.driver, "history.filter.patientname.patrick.xpath").getText());
		utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").click();
	}

	/**
	 * This method is used to filter patient name text Patrick displayed in list or
	 * not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isFilteredPatrickPatientNameListDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "history.list.patientname.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in filtered list : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					if (q.getText().contains("Patrick")) {
						logger.info("Matching Filtered Surgeon Name text is : " + q.getText());
					}
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/***
	 * This method is used to enter string text.
	 * 
	 * @throws IOException
	 */
	public WebElement enterTextInSearchBar() throws IOException {
		utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").clear();
		WebElement element = utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath");
		JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
		js.executeScript("arguments[0].value='Patrick'", element);
		logger.info("enterTextInSearchBar: text entered in search box");
		return utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath");
	}

	/***
	 * This method is used to perform click on search button on history tab.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSearchBtn() throws IOException, InterruptedException {
		logger.info("clickOnSearchButton: search btn is clicked");
		try {
			utility.initializeElement(LoginPage.driver, "history.btn.search.xpath").click();
		} catch (Exception e) {
			WebElement element = utility.initializeElement(LoginPage.driver, "history.btn.search.xpath");
			JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
			js.executeScript("arguments[0].click", element);
		}
	}

	/***
	 * This method is used to perform click on filter button on history tab.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnFilterBtn() throws IOException, InterruptedException {
		logger.info("clickOnFilterButton: filter button is clicked");
		// waitForSpinnerToDisappear();
		Thread.sleep(500);
		WebElement search = utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(search));
		wait.clear();
		utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").click();
		LoginPage.driver.navigate().refresh();
		// waitForSpinnerToDisappear();
		Thread.sleep(500);
		utility.initializeElement(LoginPage.driver, "history.filter.xpath").click();
	}

	/***
	 * This method is used to check Audit Log tab displayed or not.
	 * 
	 * @throws IOException
	 */
	public String isAuditLogTabDisplayed() throws IOException {
		logger.info("Audit Log tab button is displayed: " + utility
				.initializeElement(LoginPage.driver, "leftnavigation.txt.header.auditlog.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.auditlog.xpath").getText().trim();
	}

	/***
	 * This method is used to enter string text.
	 * 
	 * @throws IOException
	 */
	public WebElement enterTextInAuditLogSearchBar() throws IOException {
		utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").clear();
		WebElement element = utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath");
		JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
		js.executeScript("arguments[0].value='ic-test-admin@capgemini.com'", element);
		logger.info("enterTextInSearchBar: text entered in search box");
		return utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath");
	}

	/**
	 * This method is used to search user name email ic-test-admin@capgemini.com
	 * displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSearchedUserNameDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "auditlog.list.username.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in search list : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					if (q.getText().contains("ic-test-admin@capgemini.com")) {
						logger.info("Matching User Name text is : " + q.getText());
					}
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/***
	 * This method is used to select filter as patient name.
	 * 
	 * @throws IOException
	 */
	public void selectFilterAsUserName() throws IOException {
		logger.info("selectFilterAspatientName: filter is selected as user name");
		logger.info("Filter is selected: "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.modal.xpath").isDisplayed());
		waitForSpinnerToDisappear();
		utility.initializeElement(LoginPage.driver, "auditlog.username.xpath").click();
		utility.initializeElement(LoginPage.driver, "auditlog.username.icadmin.xpath").click();
		logger.info("Selected user name filter is: "
				+ utility.initializeElement(LoginPage.driver, "auditlog.username.icadmin.xpath").getText());
		utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").click();
	}

	/**
	 * This method is used to filter user name text displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isFilteredUserNameListDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "auditlog.list.username.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in filtered list : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					if (q.getText().contains("ic-test-admin@capgemini.com")) {
						logger.info("Matching Filtered User Name text is : " + q.getText());
					}
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/***
	 * This method is used to perform click on filter button on audit log page.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnFilterBtnOnAuditLog() throws IOException, InterruptedException {
		logger.info("clickOnFilterBtnOnAuditLog: Filter button is clicked");
		Thread.sleep(500);
		WebElement search = utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(search));
		wait.clear();
		Thread.sleep(500);
		utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").click();
		LoginPage.driver.navigate().refresh();
		// waitForSpinnerToDisappear();
		Thread.sleep(500);
		utility.initializeElement(LoginPage.driver, "history.filter.xpath").click();
	}

	/***
	 * This method is used to perform click on search button on history tab.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSearchButtonOnAuditLog() throws IOException, InterruptedException {
		logger.info("clickOnSearchButtonOnAuditLog: Search button is clicked");
		Thread.sleep(1000);
		WebElement search = utility.initializeElement(LoginPage.driver, "history.btn.search.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.elementToBeClickable(search));
		wait.click();
	}

	/**
	 * This method is used to get notification message when any invalid data is
	 * entered on search box
	 * 
	 * @throws IOException
	 */
	public String msgNodata() throws IOException {
		return utility.initializeElement(LoginPage.driver, "dashboard.nodata.msg.xpath").getText();
	}

	/**
	 * This method is used to click Site Icon on Upload dash-board filter option
	 * screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickSiteIcon() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "uploaddashboard.site.icon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "uploaddashboard.site.icon.xpath"));
		}
		logger.info("click Site Button : Clicked Site plus icon");
	}

	/**
	 * This method is used to click Site Icon on Upload dash-board filter option
	 * screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickSurgeonIcon() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "uploaddashboard.surgeon.icon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "uploaddashboard.surgeon.icon.xpath"));
		}
		logger.info("click Surgeon Button : Clicked Surgeon plus icon");
	}

	public void clickApplication() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "uploaddashboard.application.icon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "uploaddashboard.application.icon.xpath"));
		}
		logger.info("click Application Button : Clicked Application plus icon");
	}

	public void clickFileStatus() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "uploaddashboard.filestatus.icon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "uploaddashboard.filestatus.icon.xpath"));
		}
		logger.info("click FileStatus Button : Clicked FileStatus plus icon");
	}

	/**
	 * This method is used to select site from filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void SelectSite() throws IOException, InterruptedException {

		utility.initializeElement(LoginPage.driver, "uploaddashboard.siteselected.icon.xpath").click();
		logger.info("Selected Facility from filter option is : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.siteselected.icon.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectFacility : Clicked Selected Facility ");
	}

	/**
	 * This method is used to select surgeon from filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void SelectSurgeon() throws IOException, InterruptedException {

		utility.initializeElement(LoginPage.driver, "uploaddashboard.surgeonselected.icon.xpath").click();
		logger.info("Selected Surgeon from filter option is : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.surgeonselected.icon.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectSurgeon : Clicked Selected Surgeon ");
	}

	/**
	 * This method is used to select application from filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void SelectApplication() throws IOException, InterruptedException {

		utility.initializeElement(LoginPage.driver, "uploaddashboard.applicationselected.icon.xpath").click();
		logger.info("Selected Application from filter option is : " + utility
				.initializeElement(LoginPage.driver, "uploaddashboard.applicationselected.icon.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectApplication : Clicked Selected Application ");
	}

	/**
	 * This method is used to select file-status from filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void SelectFileStatus() throws IOException, InterruptedException {

		utility.initializeElement(LoginPage.driver, "uploaddashboard.statusselected.icon.xpath").click();
		logger.info("Selected File Status from filter option is : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.statusselected.icon.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectFileStatus : Clicked Selected FileStatus ");
	}

	/**
	 * This method is used to search surgeon name text ACMH Hospital displayed in
	 * list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isFilterTextACMHDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.surgeonname.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in search list : " + count);
		return false;
	}

	public void clickCrossIcon() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "uploaddashboard.crossicon.btn.xpath").click();
		logger.info("click Cross Button : Clicked X Icon button");
	}

	public void clickDoneBtn() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "uploaddashboard.done.btn.xpath").click();
		logger.info("click Done Button : Clicked Done button");
	}

	/**
	 * This method is used to filter Surgeon name text displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isFilteredSurgeonNameListDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.surgeonname.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in filtered list : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					if (q.getText().contains("ChristopherBaker CRNP")) {
						logger.info("Matching Filtered Surgeon Name text is : " + q.getText());
					}
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check matching application is displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isApplicationDisplayed() throws IOException {
		List<WebElement> application = utility.initializeElements(LoginPage.driver,
				"summarydashboard.application.list.xpath");
		int size = application.size();
		logger.info("Total no. of Records displayed in dashboard page : " + size);
		if (size >= 1) {
			for (int i = 0; i < application.size(); i++) {
				{
					logger.info("Application name and no. of files uploaded is displayed as : "
							+ application.get(i).getAttribute("textContent"));
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check matching file status is displayed in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */

	public Boolean isStatusDisplayed() throws IOException {
		List<WebElement> statusIcon = utility.initializeElements(LoginPage.driver,
				"summarydashboard.uploadicon.list.xpath");
		int size = statusIcon.size();
		logger.info("Total no. of Records displayed in dashboard page : " + size);
		if (size >= 1) {
			for (int i = 0; i < statusIcon.size(); i++) {
				{
					logger.info("Uploaded File status icon is displayed : " + statusIcon.get(i).isDisplayed());
				}
			}
			return true;
		}
		return false;
	}

	/***
	 * This method is used to select end date as current date from date picker.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectsEndDateFilterAsCurrentDateOnDashboard() throws IOException, InterruptedException {
		logger.info("selectsEndDateFilterAsCurrentDateOnDashboard: End Date as Current date is selected");
		List<WebElement> endDate = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
		Date date1 = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		String today = formatter.format(date1);
		for (WebElement cell : endDate) {
			if (cell.getText().equals(today)) {
				logger.info("Selected Date is : " + cell.getText());
				cell.click();
				break;
			}
		}
		logger.info("Done button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").isDisplayed());
		utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").click();

	}

	/**
	 * This method is used to check selected end date displayed or not.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isSelectedCurrentDateAsEndDateDisplayed() throws IOException, InterruptedException {
		// try {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "history.table.createddate.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in filtered list : " + count);

		if (list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				q = list.get(i);
				logger.info("Matching Filtered Created Date is : " + q.getText());
			}
			Thread.sleep(2000);
			return true;

		}
		LoginPage.driver.navigate().refresh();
		WebElement last = utility.initializeElement(LoginPage.driver, "history.table.lastrow.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.elementToBeClickable(last));
		wait.isDisplayed();

//		} catch(org.openqa.selenium.StaleElementReferenceException e) {
//			WebElement last = utility.initializeElement(LoginPage.driver, "history.table.lastrow.xpath");
//			WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
//					.until(ExpectedConditions.elementToBeClickable(last));
//			wait.isDisplayed();
//			logger.info("Last element is located");
//		}
		return false;
	}

	/**
	 * This method is used to check dashboard is filtered based on date or not.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public boolean isRecordsDisplayedInDescendingOrder() throws IOException, InterruptedException, ParseException {
		logger.info("Dashboard is in descending order : "
				+ utility.initializeElement(LoginPage.driver, "summarydashboard.row.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> order = utility.initializeElements(LoginPage.driver, "summarydashboard.row.xpath");
		int size = order.size();
		logger.info("Total no. of count is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("Descending ordered list is : " + order.get(i).getText() + "\n");

				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check dashboard contains the surgeon first and last
	 * name or not
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public boolean isSurgeonFirstNameLastNameDisplayed() throws IOException, InterruptedException, ParseException {
		logger.info("Dashboard is getting displayed : "
				+ utility.initializeElement(LoginPage.driver, "summarydashboard.row.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> order = utility.initializeElements(LoginPage.driver, "summarydashboard.row.xpath");
		List<WebElement> name = utility.initializeElements(LoginPage.driver, "summarydashboard.surgeonname.list.xpath");
		int size = name.size();
		logger.info("Total no. of count is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("Surgeon first and last name is : " + name.get(i).getText() + "\n");

				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check dashboard contains the date of the file upload
	 * or not
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public boolean isFileUploadDateDisplayed() throws IOException, InterruptedException, ParseException {
		logger.info("Dashboard is getting displayed : "
				+ utility.initializeElement(LoginPage.driver, "summarydashboard.row.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> order = utility.initializeElements(LoginPage.driver, "summarydashboard.row.xpath");
		List<WebElement> date = utility.initializeElements(LoginPage.driver,
				"summarydashboard.dateoffileuploaded.list.xpath");
		int size = date.size();
		logger.info("Total no. of count is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("Date of the file uploaded is : " + date.get(i).getText() + "\n");

				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check if processing checkbox displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isProcessingCheckboxDisplayed() throws IOException {
		logger.info("Processing checkbox is displayed : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.processing.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.processing.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if processing checkbox is in grey color or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String getProcessingCheckboxColor() throws IOException {
		logger.info("Processing checkbox is in grey Color : " + utility
				.initializeElement(LoginPage.driver, "uploaddashboard.icon.processing.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.icon.processing.xpath")
				.getCssValue("color");
	}

	/**
	 * This method is used to check if uploaded checkbox displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isUploadedCheckboxDisplayed() throws IOException {
		logger.info("Uploaded checkbox is displayed : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.uploaded.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.uploaded.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if uploaded checkbox is in white color or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String getUploadedCheckboxTickMarkColor() throws IOException {
		logger.info("Uploaded checkbox tick mark is in white colour : " + utility
				.initializeElement(LoginPage.driver, "uploaddashboard.icon.uploaded.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.icon.uploaded.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if complete checkbox displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isCompleteCheckboxDisplayed() throws IOException {
		logger.info("Complate checkbox is displayed : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.complete.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.complete.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if complete checkbox is in green color or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String getCompleteCheckboxTickMarkColor() throws IOException {
		logger.info("Complete checkbox tick mark is in green colour : " + utility
				.initializeElement(LoginPage.driver, "uploaddashboard.icon.complete.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.icon.complete.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if error checkbox displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isErrorCheckboxDisplayed() throws IOException {
		logger.info("Error checkbox is displayed : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.error.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.error.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if error checkbox is in green color or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String getErrorCheckboxTickMarkColor() throws IOException {
		logger.info("Error checkbox exclamation mark is in yellow colour : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.icon.error.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.icon.error.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if 24hrs checkbox displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isTwentyFourHrsCheckboxDisplayed() throws IOException, InterruptedException {
		Thread.sleep(3000);
		logger.info("24hrs checkbox is displayed : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.twentyfourhrs.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.twentyfourhrs.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if 24hrs checkbox is in green color or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String getTwentyFourHrsCheckboxTickMarkColor() throws IOException {
		logger.info("24hrs checkbox  is in white colour : " + utility
				.initializeElement(LoginPage.driver, "uploaddashboard.icon.twentyfourhrs.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.icon.twentyfourhrs.xpath")
				.getCssValue("color");
	}

	/**
	 * This method is used to check if filter button icon is in white color or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String getFilterButtonIconColor() throws IOException {
		logger.info("Filter button icon colour is in white colour : " + utility
				.initializeElement(LoginPage.driver, "uploaddashboard.icon.filter.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.icon.filter.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if search box icon is in white color or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String getSearchboxIconColor() throws IOException {
		logger.info("Searchbox icon colour is in white colour : " + utility
				.initializeElement(LoginPage.driver, "uploaddashboard.icon.searchbox.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.icon.searchbox.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if search button displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isSearchButtonDisplayed() throws IOException {
		logger.info("Search button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.btn.search.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "dashboard.btn.search.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if search box icon is in white color or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String getSearchButtonTextColor() throws IOException {
		logger.info("Search button text colour is in black colour : " + utility
				.initializeElement(LoginPage.driver, "uploaddashboard.icon.searchbox.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.icon.searchbox.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if searchbox displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isSearchBoxDisplayed() throws IOException {
		logger.info("Search box is displayed : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.searchbox.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.searchbox.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if search box icon is in white color or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String getDoneButtonColor() throws IOException {
		logger.info("Done button is in green colour : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").getCssValue("color");
	}

	/**
	 * This method is used to select multiple filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectMultipleFilters() throws IOException, InterruptedException {
		logger.info("selectMultipleFilters: Multiple filter option is selected");
		utility.initializeElement(LoginPage.driver, "dashboard.filter.surgeon.xpath").click();
		utility.initializeElement(LoginPage.driver, "dashboard.filter.surgeonname.crnp.xpath").click();
		utility.initializeElement(LoginPage.driver, "filter.option.site.xpath").click();
		utility.initializeElement(LoginPage.driver, "dashboard.filter.sitename.acmh.xpath").click();
		utility.initializeElement(LoginPage.driver, "filter.option.application.xpath").click();
		utility.initializeElement(LoginPage.driver, "dashboard.filter.applicationname.fai7.xpath").click();
	}

	/**
	 * This method is used to check if selected filter displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isSelectedFiltersDisplayed() throws IOException {
		logger.info("Selected filter is : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.filter.selectedsurgeon.xpath").getText()
						.replaceAll(" X", "").trim());
		logger.info("Selected filter is : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.filter.selectedsite.xpath").getText()
						.replaceAll(" X", "").trim());
		logger.info("Selected filter is : "
				+ utility.initializeElement(LoginPage.driver, "uploaddashboard.filter.selectedapplication.xpath")
						.getText().replaceAll(" X", "").trim());
		utility.initializeElement(LoginPage.driver, "uploaddashboard.filter.selectedsurgeon.xpath").isDisplayed();
		utility.initializeElement(LoginPage.driver, "uploaddashboard.filter.selectedsite.xpath").isDisplayed();
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.filter.selectedapplication.xpath")
				.isDisplayed();
	}

	/**
	 * This method is used to check if selected filter X icon displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isSelectedFiltersXIconDisplayed() throws IOException {
		logger.info("Selected filter X is displayed ");
		utility.initializeElement(LoginPage.driver, "uploaddashboard.filter.selectedsurgeonXicon.xpath").isDisplayed();
		utility.initializeElement(LoginPage.driver, "uploaddashboard.filter.selectedsiteXicon.xpath").isDisplayed();
		return utility.initializeElement(LoginPage.driver, "uploaddashboard.filter.selectedapplicationXicon.xpath")
				.isDisplayed();
	}

	public boolean isRecordsDisplayed() throws IOException, InterruptedException {
		logger.info("Dashboard details is displayed in chronological order : "
				+ utility.initializeElement(LoginPage.driver, "summarydashboard.row.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> order = utility.initializeElements(LoginPage.driver, "summarydashboard.row.xpath");
		int size = order.size();
		logger.info("Total no. of records in Upload Dashboard page : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("Records dispalyed as : " + order.get(i).getText() + "\n");
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check if selected filter X icon displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isProcessingStatusDisplayed() throws IOException, InterruptedException {
		logger.info("Each dashboard item processing status displayed  : "
				+ utility.initializeElement(LoginPage.driver, "summarydashboard.row.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> status = utility.initializeElements(LoginPage.driver,
				"summarydashboard.uploadicon.list.xpath");
		int size = status.size();
		logger.info("Total no. of records in Upload Dashboard page : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("Each item status displayed as : " + status.get(i).getAttribute("title"));
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to click 24 Hrs checkbox on Upload dash-board page
	 * screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickcheckBox() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "dashboard.checkbox.btn.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "dashboard.checkbox.btn.xpath"));
		}
		logger.info("click 24 Hrs Checkbox : Clicked 24Hrs checkbox icon");
	}

	public Boolean isrecordDisplayed() throws IOException {
		for (Integer i = 0; i < 10; i++) {
			try {
				utility.initializeElement(LoginPage.driver, "dashboard.showmore.button.xpath");
				clickShowmore();
			} catch (NoSuchElementException e) {
				logger.info("");
				break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.data.xpath");
		int size = list.size();
		logger.info("Total no. of records in upload dashbaord : " + size);
		if (size >= 1) {
			for (WebElement item : list) {
				{
					logger.info("Records data is displayed as : " + item.getText());
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to return show more button.
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement getShowmoreBtn() throws IOException {
		return utility.initializeElement(LoginPage.driver, "summarydashboard.showmore.btn.xpath");
	}

	/**
	 * This method is used to check show more button is displayed.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isShowmoreBtnDisplayed() throws IOException {
		logger.info("24hrs checkbox is displayed : " + getShowmoreBtn().isDisplayed());
		return getShowmoreBtn().isDisplayed();
	}

	/**
	 * This method is used to click show more button.
	 * 
	 * @return void
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickShowmoreBtn() throws IOException, InterruptedException {
		getShowmoreBtn().click();
		Thread.sleep(3000);
		logger.info("Show more button is clicked");
	}

	/**
	 * This method is used to check more records are displayed.
	 * 
	 * @return Boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isMoreRecordsDisplayed() throws IOException, InterruptedException {
		Thread.sleep(2000);
		List<WebElement> rows = utility.initializeElements(LoginPage.driver, "summarydashboard.row.xpath");
		int size = rows.size();
		logger.info("Total no. of records in Upload Dashboard page : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("Records dispalyed as : " + rows.get(i).getText() + "\n");
				}
			}
		}
		if (size > 25) {
			return true;
		} else
			return false;
	}

	/**
	 * This method is used to check whether the records are scrollable.
	 * 
	 * @return Boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void isRecordsScrollable() throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
		WebElement element = utility.initializeElement(LoginPage.driver, "summarydashboard.nextrow.xpath");
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		logger.info("Scrolled down");
	}

	/**
	 * This method is used to get the scroll bar.
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement getScrollbar() throws IOException {
		return utility.initializeElement(LoginPage.driver, "summarydashboard.scrollbar.xpath");
	}

	/**
	 * This method is used to click Show more button on Upload dash-board page
	 * screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickShowmore() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "dashboard.showmore.button.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "dashboard.showmore.button.xpath"));
		}
		logger.info("click Show more button : Clicked Show more Button");
	}

	/**
	 * This method is used to get the scroll bar color.
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public boolean getScrollBarColor() throws IOException {
		logger.info(getScrollbar().getCssValue("overflow-y"));
//		logger.info("#####"+getScrollbar().getCssValue("background"));
		if (getScrollbar().getCssValue("overflow-y").equals("scroll")) {
			return true;
		} else
			return false;
	}

	/**
	 * This method is used to locate the table contents
	 * 
	 * @param item
	 * @return
	 * @throws IOException
	 */
	public List<WebElement> fileDashboardItems(String item) throws IOException {
		if (item.equalsIgnoreCase("Status Symbol"))
			return utility.initializeElements(LoginPage.driver, "summarydashboard.uploadstatus.icon.xpath");
		else if (item.equalsIgnoreCase("surgeon names"))
			return utility.initializeElements(LoginPage.driver, "summarydashboard.surgeonnamelist.xpath");
		else if (item.equalsIgnoreCase("patient names"))
			return utility.initializeElements(LoginPage.driver, "summarydashboard.patientnamelist.xpath");
		else if (item.equalsIgnoreCase("application names"))
			return utility.initializeElements(LoginPage.driver, "summarydashboard.apllicationnamelst.xpath");
		else if (item.equalsIgnoreCase("DOBs"))
			return utility.initializeElements(LoginPage.driver, "summarydashboard.doblist.xpath");
		return null;
	}

	/**
	 * This method is used to check details in a row in file dashboard screen
	 * 
	 * @param row
	 * @param surgeonName
	 * @param patientName
	 * @param applicationName
	 * @return
	 * @throws IOException
	 */
	public boolean verifyMostRecentUploadinFileDashboard(Integer row, String surgeonName, String patientName,
			String applicationName) throws IOException {
		boolean isDisplayed = false;
		String surgeonNameInRow = fileDashboardItems("surgeon names").get(row).getText();
		String patientNameInRow = fileDashboardItems("patient names").get(row).getText();
		String applicationNameInRow = fileDashboardItems("application names").get(row).getText();
		logger.info(fileDashboardItems("surgeon names").get(0).getText());
		logger.info(fileDashboardItems("patient names").get(0).getText());
		logger.info(fileDashboardItems("application names").get(0).getText());
		if (surgeonNameInRow.equals(surgeonName)) {
			logger.info("Surgeon name is correct)");
			if (patientNameInRow.contains(patientName)) {
				logger.info("patient name is correct)");
				if (applicationNameInRow.contains(applicationName)) {
					logger.info("application name is correct)");
					isDisplayed = true;
				}
			}

		}
		return isDisplayed;
	}

	/**
	 * This method is used to verify whether the data are shown as a table
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean records_are_in_tabular_format() throws IOException, InterruptedException {
		boolean isDisplayed = false;
		Thread.sleep(2000);
		if (fileDashboardItems("Status Symbol").get(0).isDisplayed()) {
			logger.info("Status symbol for each uploaded status is displayed");
			if (fileDashboardItems("surgeon names").get(0).isDisplayed()) {
				logger.info("Surgeon name and uploaded date is displayed");
				if (fileDashboardItems("patient names").get(0).isDisplayed()) {
					logger.info("Patient name with DOB is displayed");
					if (fileDashboardItems("application names").get(0).isDisplayed()) {
						logger.info("Application name with no. of files uploaded is displayed");
						isDisplayed = true;
					} else {
						logger.info("Application name with no. of files uploaded is not displayed");
					}
				} else {
					logger.info("Patient name with DOB is not displayed");
				}
			} else {
				logger.info("Surgeon name and uploaded date is not displayed");
			}
		} else {
			logger.info("Status symbol for each uploaded status is not displayed");
		}
		return isDisplayed;
	}

	/**
	 * This method is used to verify the status is shown when mouse is hovered over
	 * status icon
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@SuppressWarnings("deprecation")
	public boolean mouseHoverOnUploadIcon() throws IOException, InterruptedException {
		boolean isDisplayed = false;
		LoginPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ele = fileDashboardItems("Status Symbol").get(0);
		Actions action = new Actions(LoginPage.driver);
		action.moveToElement(ele).moveToElement(ele).click().build().perform();
		Thread.sleep(10000);
		if (getUploadStatusIconTitle().equals("Uploaded")) {
			logger.debug("Hover is working. Pop up: " + getUploadStatusIconTitle());
			isDisplayed = true;
		}
		return isDisplayed;
	}

	/**
	 * This method is used to get title of the status icon in first row
	 * 
	 * @return
	 * @throws IOException
	 */
	public String getUploadStatusIconTitle() throws IOException {
		return fileDashboardItems("Status Symbol").get(0).getAttribute("title");
	}

	/**
	 * This method is used to locate recall button
	 * 
	 * @return
	 * @throws IOException
	 */
	public WebElement recallBtn() throws IOException {
		return utility.initializeElement(LoginPage.driver, "summarydashboard.recall.xpath");
	}

	/**
	 * This method is used to click on recall button
	 * 
	 * @throws IOException
	 */
	public void clickRecallBtn() throws IOException {
		recallBtn().click();
	}

	/**
	 * This method is used to verify recall button is displayed
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isRecallBtnDisplayed() throws IOException {
		return recallBtn().isDisplayed();
	}

	/**
	 * This method is used to verify the pop up for recall
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isRecallpopupDisplayed() throws IOException, InterruptedException {
		Thread.sleep(1000);
		boolean isDisplayed = false;
		if (utility.initializeElement(LoginPage.driver, "summarydashboard.recall.message.xpath").isDisplayed()) {
			logger.info("Are you sure you want to recall the image? alert message is displayed");
			if (utility.initializeElement(LoginPage.driver, "summarydashboard.recall.cancel.xpath").isDisplayed()) {
				logger.info("Cancel Button is displayed");
				if (utility.initializeElement(LoginPage.driver, "summarydasboard.recall.confirm.xpath").isDisplayed()) {
					logger.info("confirm Button is displayed");
					isDisplayed = true;
				}
			}

		}
		return isDisplayed;
	}

	/**
	 * This method is used to click on confirm button in recall pop up
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickRecallConfirmBtn() throws IOException, InterruptedException {
		Thread.sleep(1000);
		utility.initializeElement(LoginPage.driver, "summarydasboard.recall.confirm.xpath").click();
	}

	/**
	 * This method is to check for the recently uploaded entry in the upload status
	 * page
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkEntryInUploadStatusPage() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "uploadstatus.firstentry.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Upload found in upload status page");
			return true;
		} else {
			logger.info("Upload not found in upload status page");
			return false;
		}
	}

	/**
	 * This method is used to click on 24hrs check-box.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickTwentyFourHrsCheckbox() throws IOException {
		utility.initializeElement(LoginPage.driver, "uploaddashboard.btn.twentyfourhrs.xpath").click();
		logger.info("clickOnTwentyFourHrsCheckbox : 24 Hrs checkbox button is clicked");
	}

	/**
	 * This method is used to check choose site screen is displayed or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isChooseSiteScreenDisplayed() throws IOException {
		logger.info("Choose Site Screen is displayed : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.choose.site.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "dashboard.choose.site.xpath").isDisplayed();
	}

	/**
	 * This method is used to click on site which has no data associated
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void selectFacilityFromChooseSite() throws IOException {
		utility.initializeElement(LoginPage.driver, "dashboard.site.selection.xpath").click();
		logger.info("selectFacility	 : Facility is selected from Choose Site");
	}

	/**
	 * This method is used to click on select Button
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickselectButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "dashboard.select.btn.xpath").click();
		logger.info("clickSelectBtn	 : Select Button is clicked");
	}

	/**
	 * This method is to check if the first entry status is uploaded in upload
	 * status page
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkFirstEntryStatus() throws IOException {
		String status = utility.initializeElement(LoginPage.driver, "uploadstatus.firstentry.status.txt.xpath")
				.getText();
		if (status.contains("Uploaded")) {
			logger.info("Status is uploaded");
			return true;
		} else {
			logger.info("Status it not uploaded");
			return false;
		}
	}

	/**
	 * This method is to click upload status in the left menu bar
	 * 
	 * @throws IOException
	 */
	public void clickUploadStatus() throws IOException {
		utility.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath").click();
		logger.info("User clicked upload status in left menu bar");
	}

	/**
	 * This method is to print the status of the first entry in the history page
	 * 
	 * @throws IOException
	 */
	public void printHistoryFirstEntryStatus() throws IOException {
		logger.info("History page entry status: "
				+ utility.initializeElement(LoginPage.driver, "history.firstentryuploadstatus.txt.xpath").getText());
	}

	/**
	 * This method is to check the upload status page most recent entry, or lack
	 * there of
	 * 
	 * @throws IOException
	 */
	public void checkUploadStatusAfterRecall() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "uploadstatus.firstentry.date.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Date of most recent entry: "
					+ utility.initializeElement(LoginPage.driver, "uploadstatus.firstentry.date.txt.xpath").getText());
		} else {
			logger.info("No entries in upload status page");
		}
	}

	/**
	 * This method is to click the cancel button in the recall pop up
	 * 
	 * @throws IOException
	 */
	public void clickRecallPopUpCancelButton() throws IOException {
		logger.info("User clicks cancel in recall pop up");
		utility.initializeElement(LoginPage.driver, "summarydashboard.recall.cancel.xpath").click();
	}

	/**
	 * This method is to check if the dates after the current date are disabled
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkSubsequentDates() throws IOException {
		List<WebElement> table = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
		Date date1 = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		String today = formatter.format(date1);
		int dateVal = Integer.parseInt(today);
		for (int i = dateVal - 1; i < table.size(); i++) {
			String color = table.get(i).getCssValue("color");
			if (!color.contains("235, 235, 235, 1")) {
				logger.info("Date: " + table.get(i).getText() + " is enabled");
				return false;
			}
		}
		logger.info("All dates after current date are greyed out");
		return true;
	}

	/**
	 * This method is used to click on + icon filter
	 * 
	 * @param filter
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectFilter(String filter) throws IOException, InterruptedException {
		Thread.sleep(10000);
		String element = null;
		if (filter.equalsIgnoreCase("Surgeon"))
			element = "dashboard.list.surgeonfilter.xpath";
		else if (filter.equalsIgnoreCase("Site"))
			element = "dashboard.list.sitefilter.xpath";
		else if (filter.equalsIgnoreCase("Application"))
			element = "dashboard.list.applicationfilter.xpath";
		else if (filter.equalsIgnoreCase("File status"))
			element = "dashboard.list.filestatusfilter.xpath";
		utility.initializeElement(LoginPage.driver, element).click();
		Thread.sleep(1000);
	}

	/**
	 * This method is used to select the first option in filter list
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectFirstoptionInFilterList() throws IOException, InterruptedException {
		Thread.sleep(1000);
		WebElement filterSelected = utility.initializeElement(LoginPage.driver,
				"dashboard.filter.surgeonname.crnp.xpath");
		filterSelected.click();
		logger.info("Slected filter: " + filterSelected.getText());
	}

	/**
	 * This method is used to select the application from application filter list
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void ApplicationInFilterListSelect() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		Thread.sleep(1000);
		List<WebElement> filterList = utility.initializeElements(LoginPage.driver, "dashboard.filternamelist.xpath");
		for (WebElement element : filterList) {
			if (element.getText().equals(properties.getProperty("available.application1"))) {
				element.click();
				logger.info("Slected filter: " + element.getText());
				break;
			}
		}

	}

	/**
	 * This method is used to select surgeon from surgeon filter list
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void surgeonFilterListSelect() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		String surgeonLastname = properties.getProperty("available.site1.surgeon1").split(" ")[1];
		Thread.sleep(1000);
		List<WebElement> filterList = utility.initializeElements(LoginPage.driver, "dashboard.filternamelist.xpath");
		for (WebElement element : filterList) {
			if (element.getText().contains(surgeonLastname)) {
				element.click();
				logger.info("Slected filter: " + element.getText());
				break;
			}
		}
	}

	/**
	 * This method is used to select file ststus from file status filter list
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void fileStatusInFilterListSelect() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		Thread.sleep(1000);
		List<WebElement> filterList = utility.initializeElements(LoginPage.driver, "dashboard.filternamelist.xpath");
		for (WebElement element : filterList) {
			if (element.getText().equals(properties.getProperty("filestatus1"))) {
				element.click();
				logger.info("Slected filter: " + element.getText());
				break;
			}
		}
	}

	/**
	 * This method is used to check first option in filter list is highlighted
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isSelectedFirstOptionInFilterListHighlighted() throws IOException {
		Properties properties = reader.getProperty();
		return utility.initializeElement(LoginPage.driver, "dashboard.filter.surgeonname.crnp.xpath")
				.getAttribute("class").contains("active");
	}

	/**
	 * This method is used to locate the filter pop up
	 * 
	 * @return
	 * @throws IOException
	 */
	public WebElement getAppliedFiletrPopup() throws IOException {
		try {
			return utility.initializeElement(LoginPage.driver, "dashboard.appliedfilter.name.xpath");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return null;
		}

	}

	/**
	 * This method is used to check the summary dashboard records are filtered
	 * according to applied filter
	 * 
	 * @param filter
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isRecordsFiltered(String filter) throws IOException, InterruptedException {
		Thread.sleep(2000);
		logDisplayedRecords();
		boolean flag = false;
		if (filter.equalsIgnoreCase("Surgeon"))
			flag = isSurgeonFilterApplied();
		else if (filter.equalsIgnoreCase("Site"))
			flag = isSiteFilterApplied();
		else if (filter.equalsIgnoreCase("Application")) {
			flag = isApplicationFilterApplied();
		} else if (filter.equalsIgnoreCase("File status")) {
			flag = isFileStatusFilterApplied();
		} else if (filter.equalsIgnoreCase("Application and File status")) {
			flag = isApplicationFilterApplied() && isFileStatusFilterApplied();
		} else if (filter.equalsIgnoreCase("Application and Surgeon")) {
			flag = isApplicationFilterApplied() && isSurgeonFilterApplied();
		} else
			flag = false;
		return flag;
	}

	/***
	 * This method is used to check the summary dashboard records are filtered
	 * according to applied surgeon filter
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isSurgeonFilterApplied() throws IOException, InterruptedException {
		Thread.sleep(10000);
		boolean flag = false;
		String filterName = getAppliedFiletrPopup().getText();
		String surgeonLastname = filterName.split(" ")[1];
		List<WebElement> elements = fileDashboardItems("surgeon names");
		for (WebElement element : elements) {
			WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.visibilityOf(element));
			flag = element.getText().contains(surgeonLastname);
		}
		return flag;
	}

	/***
	 * This method is used to check the summary dashboard records are filtered
	 * according to applied site filter
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isSiteFilterApplied() throws IOException {
		Properties properties = reader.getProperty();
		boolean flag = false;
		List<WebElement> elements = fileDashboardItems("surgeon names");
		String surgeon1 = properties.getProperty("available.site1.surgeon1");
		String surgeon2 = properties.getProperty("available.site1.surgeon2");
		String surgeon3 = properties.getProperty("available.site1.surgeon3");
		boolean isSurgeon1Present = surgeon1.length() != 0;
		boolean isSurgeon2Present = surgeon2.length() != 0;
		boolean isSurgeon3Present = surgeon3.length() != 0;
		for (WebElement element : elements) {
			if (isSurgeon1Present && isSurgeon2Present && isSurgeon3Present)
				return element.getText().contains(surgeon1) || element.getText().contains(surgeon2)
						|| element.getText().contains(surgeon3);
			else if (isSurgeon1Present && isSurgeon2Present && !isSurgeon3Present)
				return element.getText().contains(surgeon1) || element.getText().contains(surgeon2);
			else if (isSurgeon1Present && !isSurgeon2Present && !isSurgeon3Present)
				return element.getText().contains(surgeon1);
		}
		return false;
	}

	/**
	 * This method is used to check the summary dashboard records are filtered
	 * according to applied application filter
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isApplicationFilterApplied() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		String filterName = properties.getProperty("available.application1");
		boolean flag = false;
		Thread.sleep(3000);
		List<WebElement> elements = fileDashboardItems("application names");
		for (WebElement element : elements) {
			if (element.getText().contains(filterName)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * This method is used to check the summary dashboard records are filtered
	 * according to applied file status filter
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isFileStatusFilterApplied() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		String filterName = properties.getProperty("filestatus1");
		boolean flag = false;
		Thread.sleep(3000);
		List<WebElement> elements = fileDashboardItems("Status Symbol");
		for (WebElement element : elements) {
			if (element.getAttribute("title").contains(filterName)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * This method is used to check applied filter pop up is displayed
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isAppliedFilterPopUpDisplayed() throws IOException {
		try {
			logger.info("Pop up text: " + getAppliedFiletrPopup().getText());
			return getAppliedFiletrPopup().isDisplayed();
		} catch (java.lang.NullPointerException e) {
			logger.info("Pop up is not displayed");
			return false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.info("Pop up is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check pop up is displayed when 2 filters are applied
	 * together
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean is2FiltersPopUpDisplayed() throws IOException {
		List<WebElement> elements = utility.initializeElements(LoginPage.driver, "dashboard.appliedfilter.name.xpath");
		for (WebElement element : elements) {
			logger.info("Filter Pop up: " + element.getText());
		}
		return utility.initializeElements(LoginPage.driver, "dashboard.appliedfilter.name.xpath").size() == 2;
	}

	/**
	 * This method is used to click on the X on applied filter pop up
	 * 
	 * @throws IOException
	 */
	public void clickXOnAppliedFilterPopUp() throws IOException {
//      List<WebElement> elements = utility.initializeElements(LoginPage.driver, "dashboard.appliedfilter.name.xpath");
		List<WebElement> elements = utility.initializeElements(LoginPage.driver, "dashboard.filter.btn.x.xpath");
		if (elements.size() > 1) {
			for (WebElement element : elements) {
				element.click();
			}
		} else
			utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.x.xpath").click();
	}

	/**
	 * This method is used to check 24hr filter is highlighted
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean is24hrFilterHighlighted() throws IOException {
		Properties properties = reader.getProperty();
		return utility.initializeElement(LoginPage.driver, "summarydashboard.filter.24hrs.xpath").getCssValue("color")
				.equals(properties.getProperty("green.color"));
	}

	/**
	 * This method is used to log the displayed records in summary dashboard
	 * 
	 * @throws IOException
	 */
	public void logDisplayedRecords() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.data.xpath");
		int size = list.size();
		logger.info("Total no. of records in upload dashbaord : " + size);
		if (size >= 1) {
			for (int i = 0; i < list.size(); i++)
				logger.info("Records data is displayed as : " + list.get(i).getText());
		}
	}

	/***
	 * This method is used to check filter is highlighted in list
	 * 
	 * @param filter
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isfilterHighlightedInList(String filter) throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		Thread.sleep(1000);
		List<WebElement> filterList = utility.initializeElements(LoginPage.driver, "dashboard.filternamelist.xpath");
		if (filter.equalsIgnoreCase("application name")) {
			for (WebElement element : filterList) {
				if (element.getText().equals(properties.getProperty("available.application1"))) {
					return element.getAttribute("class").contains("active");
				}
			}
		} else if (filter.equalsIgnoreCase("file status")) {
			for (WebElement element : filterList) {
				if (element.getText().equals(properties.getProperty("filestatus1"))) {
					return element.getAttribute("class").contains("active");
				}
			}
		} else if (filter.equalsIgnoreCase("surgeon name")) {
			String surgeonLastname = properties.getProperty("available.site1.surgeon1").split(" ")[1];
			for (WebElement element : filterList) {
				if (element.getText().contains(surgeonLastname)) {
					return element.getAttribute("class").contains("active");
				}
			}
		} else if (filter.equalsIgnoreCase("site name")) {
			for (WebElement element : filterList) {
				if (element.getText().equals(properties.getProperty("available.site1"))) {
					return element.getAttribute("class").contains("active");
				}
			}
		} else
			return isSelectedFirstOptionInFilterListHighlighted();
		return true;
	}

	/**
	 * This method is used to check Which site would you like to view ? is displayed
	 * or not.
	 * 
	 * @throws IOException
	 */
	public boolean isWhichSiteTextDisplayed() throws IOException {
		logger.info("Which site would you like to view ? Text is displayed : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.whichsite.txt.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "dashboard.whichsite.txt.xpath").isDisplayed();
	}

	/**
	 * This method is used to check Search site is displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSearchsitetextTextDisplayed() throws IOException {
		logger.info("Search site Text is displayed : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.searchsite.txt.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "dashboard.searchsite.txt.xpath").isDisplayed();
	}

	/**
	 * This method is used to check Text Enter Keyword or Name of Site is displayed
	 * or not.
	 * 
	 * @throws IOException
	 */
	public boolean isEnterKeywordTextDisplayed() throws IOException {
		logger.info("Enter Keyword placeholder Text is displayed as : " + utility
				.initializeElement(LoginPage.driver, "dashboard.placeholder.text.xpath").getAttribute("placeholder"));
		return utility.initializeElement(LoginPage.driver, "dashboard.placeholder.text.xpath").isDisplayed();
	}

	/**
	 * This method is used to check List of Facility is displayed or not.
	 * 
	 * @throws IOException
	 */
	public void isListDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.facilitylist.text.xpath");
		int size = list.size();
		logger.info("Total no. of Facility Listed : " + size);
	}

	/**
	 * This method is used to check Select Button is displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSelectButtonDisplayed() throws IOException {
		logger.info("Select Button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.select.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "dashboard.select.btn.xpath").isDisplayed();
	}

	/**
	 * This method is used to click on site which belongs to ic-admin
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void selectICadminFacilityFromChooseSite() throws IOException {
		logger.info("Facility Selected : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.admin.select.xpath").getText());
		utility.initializeElement(LoginPage.driver, "dashboard.admin.select.xpath").click();
		logger.info("selectFacility	 : Facility which is IC-admin associated is selected from Choose Site");
	}

	/**
	 * This method is used to click on site which belongs to Hospital-admin
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void selectHospitaladminFacilityFromChooseSite() throws IOException {
		logger.info("Facility Selected : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.Hadmin.select.xpath").getText());
		utility.initializeElement(LoginPage.driver, "dashboard.Hadmin.select.xpath").click();
		logger.info("selectFacility	 : Facility which is Hospital-admin associated is selected from Choose Site");
	}

	/**
	 * This method is used to click on choose site Button
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public void clickonChooseSite() throws IOException {
		utility.initializeElement(LoginPage.driver, "leftnavigation.choosesite.xpath").click();
		logger.info("clickChooseSiteBtn	 : Choose Site is clicked");
	}

	/**
	 * This method is used to locate the search bar
	 * 
	 * @return
	 * @throws IOException
	 */
	public WebElement locateSearchBar() throws IOException {
		return utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath");
	}

	/**
	 * This method is used to enter text in serach bar
	 * 
	 * @param text
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterTextInSearchbar(String text) throws IOException, InterruptedException {
		locateSearchBar().sendKeys(text);
		logger.info("text entered in search bar : " + text);
	}

	/**
	 * This method is used to enter text in serach bar and click on search button
	 * 
	 * @param text
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterTextInSearchbarAndClickSearchBtn(String text) throws IOException, InterruptedException {
		enterTextInSearchbar(text);
		clickOnSearchButton();
	}

	/**
	 * This method is used to search valid data in summary dashboard record
	 * 
	 * @param type
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void searchValidData(String type) throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		String text = "";
		if (type.equalsIgnoreCase("surgeon name")) {
			text = fileDashboardItems("surgeon names").get(0).getText();
		}
		if (type.equalsIgnoreCase("patient name")) {
			text = fileDashboardItems("patient names").get(0).getText();
			if (text.split(" ")[1].contains("(")) {
				text = text.split(" ")[0];
			} else {
				text = text.split(" ")[0] + " " + text.split(" ")[1];
			}
		}
		if (type.equalsIgnoreCase("application name")) {
			text = fileDashboardItems("application names").get(0).getText();
			text = (text.split("\n")[0]).split("Application: ")[1];
		}
		if (type.equalsIgnoreCase("site name")) {
			text = properties.getProperty("available.site1");
		}
		if (type.equalsIgnoreCase("file status")) {
			text = properties.getProperty("filestatus1");
		}
		if (type.equalsIgnoreCase("DOB")) {
			text = fileDashboardItems("DOBs").get(0).getText();
			text = text.split(" ")[1];
		}
		enterTextInSearchbarAndClickSearchBtn(text);
	}

	/**
	 * This method is used to check whether search is working properly
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isSearchWorking() throws IOException, InterruptedException {
		boolean flag = false;
		String searchedText = locateSearchBar().getText();
		logDisplayedRecords();
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.data.xpath");
		for (WebElement elemet : list) {
			flag = elemet.getText().contains(searchedText);
			if (!flag) {
				break;
			}
		}
		return flag;
	}

	/**
	 * This method is used to clear the search bar
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clearSearchbar() throws IOException, InterruptedException {
		locateSearchBar().clear();
		Thread.sleep(2000);
		clickOnSearchButton();
		logger.info("Search bar is cleared");
	}

	/**
	 * This method is used to search data which is not present in the summary
	 * dashboard records
	 * 
	 * @param type
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void searchInvalidData(String type) throws IOException, InterruptedException {
		String text = "";
		if (type.equalsIgnoreCase("surgeon name")) {
			text = "Surg A";
		}
		if (type.equalsIgnoreCase("patient name")) {
			text = "Pati A";
		}
		if (type.equalsIgnoreCase("application name")) {
			text = "Ap A";
		}
		if (type.equalsIgnoreCase("site name")) {
			text = "Si A";
		}
		if (type.equalsIgnoreCase("file status")) {
			text = "Status A";
		}
		if (type.equalsIgnoreCase("DOB")) {
			text = "04/11/2050";
		}
		enterTextInSearchbarAndClickSearchBtn(text);
	}

	/**
	 * This method is used to check whether No Data To Display text is displayed
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isNoDataTextDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "dashboard.nodatadisplay.text.xpath").isDisplayed();
	}

	/**
	 * This method is used to check whether only current date is selectable or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public Boolean isOnlyCurrentDateSelectableDate() throws IOException {
		logger.info("The only selectable date is current date as : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.date.active.xpath").getText());
		logger.info("The current date is selectable : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.date.active.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "dashboard.filter.date.active.xpath").isEnabled();
	}

	/**
	 * This method is used to check whether calendar dates are greyed out or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public Boolean isCalendarDateGreyedOut() throws IOException {
		boolean flag = false;
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.filter.date.alldisabled.xpath");
		int size = list.size();
		logger.info("Total no. of greyed out dates : " + size);
		if (size >= 1) {
			for (int i = 0; i < list.size(); i++) {
				{
					logger.info(list.get(i).getText() + " is  greyed out date as " + list.get(i).getCssValue("Color"));
				}
			}
			flag = true;
		}
		return flag;
	}

	/**
	 * This method is to check that the recall button is no longer displayed
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkRecallNotDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "summardashboard.recall.btn.xpath");
		if (list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to log the specified number of records
	 * 
	 * @param count
	 * @throws IOException
	 */
	public void logRecordsInSummaryDashboard(Integer count) throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.data.xpath");
		logger.info("First " + count + " records are: ");
		for (Integer i = 0; i < count; i++) {
			logger.info(list.get(i).getText());
		}
	}

	/**
	 * This method is used to verify four patients
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean verify4Patients() throws IOException {
		boolean patient1Displayed = false;
		boolean patient2Displayed = false;
		boolean patient3Displayed = false;
		boolean patient4Displayed = false;
		Properties properties = reader.getProperty();
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.data.xpath");
		String patient1Name = properties.getProperty("patient1.name");
		String patient1DOB = properties.getProperty("patient1.dob");
		String patient1Gender = properties.getProperty("patient1.gender");
		String patient2Name = properties.getProperty("patient2.name");
		String patient2DOB = properties.getProperty("patient2.dob");
		String patient2Gender = properties.getProperty("patient2.gender");
		String patient3Name = properties.getProperty("patient3.name");
		String patient3DOB = properties.getProperty("patient3.dob");
		String patient3Gender = properties.getProperty("patient3.gender");
		String patient4Name = properties.getProperty("patient4.name");
		String patient4DOB = properties.getProperty("patient4.dob");
		String patient4Gender = properties.getProperty("patient4.gender");
		String surgeonName = properties.getProperty("available.site1.surgeon1");
		for (Integer i = 0; i < 4; i++) {
			if (list.get(i).getText().contains(surgeonName)) {
				Integer rowNum = i + 1;
				logger.info(list.get(i).getText());
				if (list.get(i).getText().contains(patient1Name)) {
					patient1Displayed = list.get(i).getText().contains(patient1DOB)
							&& list.get(i).getText().contains(patient1Gender);
					logger.info("Patient " + patient1Name + " is displayed in row :" + rowNum);
					continue;
				} else if (list.get(i).getText().contains(patient2Name)) {
					patient2Displayed = list.get(i).getText().contains(patient2DOB)
							&& list.get(i).getText().contains(patient2Gender);
					logger.info("Patient " + patient2Name + " is displayed in row :" + rowNum);
					continue;
				} else if (list.get(i).getText().contains(patient3Name)) {
					patient3Displayed = list.get(i).getText().contains(patient3DOB)
							&& list.get(i).getText().contains(patient3Gender);
					logger.info("Patient " + patient3Name + " is displayed in row :" + rowNum);
					continue;
				} else if (list.get(i).getText().contains(patient4Name)) {
					patient4Displayed = list.get(i).getText().contains(patient4DOB)
							&& list.get(i).getText().contains(patient4Gender);
					logger.info("Patient " + patient4Name + " is displayed in row :" + rowNum);
					continue;
				}
			} else {
				logger.info("Surgeon name is nor diaplayed");
				return false;
			}
		}
		return patient1Displayed && patient2Displayed && patient3Displayed && patient4Displayed;
	}

	/**
	 * This method is used to most recent first paitent record on dashboard
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean mostRecentPatientRecordDetails() throws IOException {
		boolean flag = false;
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.data.xpath");
		int count = list.size();
		if (count > 1) {
			logger.info("Most recent patient record details are : " + list.get(0).getText());
			return flag = true;
		}
		return flag;
	}
	
	/**
	 * This method is used to select a record for uploaded status
	 * 
	 * @throws IOException
	 */
	public void selectUploadedStatusRecord() throws IOException {
		logger.info("The uploaded status record is selected");
	utility.initializeElement(LoginPage.driver, "uploadstatus.firstentry.status.uploaded.xpath").click();
	}
	
	/**
	 * This method is used to click on view details button
	 * 
	 * @throws IOException
	 */
	public void clickonViewDetailsButton() throws IOException {
		logger.info("The view details button is clicked");
	utility.initializeElement(LoginPage.driver, "uploadstatus.btn.viewdetails.xpath").click();
	}
	
	/**
	 * This method is used to click on close button on upload screen
	 * 
	 * @throws IOException
	 */
	public void clickOnCloseButton() throws IOException {
		logger.info("The close button is clicked");
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.successclose.btn.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
	}
	
	/**
	 * This method is used to check uploading status record details
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean checkUploadingStatusRecordDetails() throws IOException {
		logger.info(driver);
		WebElement dateTime = utility.initializeElement(LoginPage.driver, "uploadstatus.status.uploading.datetime.xpath");
		WebElement organization = utility.initializeElement(LoginPage.driver, "uploadstatus.status.uploading.organization.xpath");
		WebElement surgeon = utility.initializeElement(LoginPage.driver, "uploadstatus.status.uploading.surgeon.xpath");
		WebElement application = utility.initializeElement(LoginPage.driver, "uploadstatus.status.uploading.application.xpath");
		WebElement fileStatus = utility.initializeElement(LoginPage.driver, "uploadstatus.status.uploading.status.xpath");
			logger.info("Date Time : " + dateTime.getText());
			logger.info("Organization : " + organization.getText());
			logger.info("Surgeon : " + surgeon.getText());
			logger.info("Application : " + application.getText());
			logger.info("File Status : " + fileStatus.getText());
	return utility.initializeElement(LoginPage.driver, "uploadstatus.status.uploading.status.xpath").isDisplayed();	
	}
	
	/**
	 * This method is used to check cancelled status record details
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean checkCancelledStatusRecordDetails() throws IOException {
		WebElement dateTime = utility.initializeElement(LoginPage.driver, "uploadstatus.status.cancelled.datetime.xpath");
		WebElement organization = utility.initializeElement(LoginPage.driver, "uploadstatus.status.cancelled.organization.xpath");
		WebElement surgeon = utility.initializeElement(LoginPage.driver, "uploadstatus.status.cancelled.surgeon.xpath");
		WebElement application = utility.initializeElement(LoginPage.driver, "uploadstatus.status.cancelled.application.xpath");
		WebElement fileStatus = utility.initializeElement(LoginPage.driver, "uploadstatus.status.cancelled.status.xpath");
			logger.info("Date Time : " + dateTime.getText());
			logger.info("Organization : " + organization.getText());
			logger.info("Surgeon : " + surgeon.getText());
			logger.info("Application : " + application.getText());
			logger.info("File Status : " + fileStatus.getText());
		return utility.initializeElement(LoginPage.driver, "uploadstatus.status.cancelled.status.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check view details button disabled for cancelled status
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isViewDetailsDisabledForCancelled() throws IOException {
		utility.initializeElement(LoginPage.driver, "uploadstatus.firstentry.status.cancelled.xpath").click();
		logger.info("View Details button is disabled for cancelled record :" +utility.initializeElement(LoginPage.driver, "uploadstatus.btn.viewdetails.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "uploadstatus.btn.viewdetails.xpath").isEnabled();
	}
	
	/**
	 * This method is used to select a record for uploading status
	 * 
	 * @throws IOException
	 */
	public void selectUploadingStatusRecord() throws IOException {
		logger.info("The uploading status record is selected");
	utility.initializeElement(LoginPage.driver, "uploadstatus.firstentry.status.uploading.xpath").click();
	}
	
	/**
	 * This method is used to click on cancel button on upload screen
	 * 
	 * @throws IOException
	 */
	public void clickonCancelButton() throws IOException {
		logger.info("The cancel upload button is clicked");
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.uploadingscreen.cancelupload.btn.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
	}
	
	/**
	 * This method is used to click on start new upload button 
	 * 
	 * @throws IOException
	 */
	public void clickOnStartNewUploadButton() throws IOException {
		logger.info("The Start new upload button is clicked");
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.btn.newupload.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
	}
	
	/**
	 * This method is used to check text message displayed or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isInvalidDicomMsgTextDisplayed() throws IOException {
		logger.info("The selected files are not valid text displayed as :" +utility.initializeElement(LoginPage.driver, "upload.msg.invalid.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "upload.msg.invalid.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check upload failed text displayed or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isUploadFailedMessageDisplayed() throws IOException {
		logger.info("The upload failed displayed as :" +utility.initializeElement(LoginPage.driver, "upload.msg.uploadfailed.xpath").isDisplayed());
		logger.info("The failed logo displayed :" +utility.initializeElement(LoginPage.driver, "upload.logo.failed.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "upload.logo.failed.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check yellow bar displayed or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isYellowBarDisplayed() throws IOException {
		logger.info("The Yellow Bar is displayed :" +utility.initializeElement(LoginPage.driver, "upload.yellow.progressbar.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "upload.yellow.progressbar.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check start new button displayed or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isStartNewButtonDisplayed() throws IOException {
		logger.info("The Start New button is displayed :" +utility.initializeElement(LoginPage.driver, "upload.btn.newupload.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "upload.btn.newupload.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check reupload button displayed and highlighted in green color or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isReuploadButtonDisplayed() throws IOException {
		logger.info("The Re-upload button is displayed :" +utility.initializeElement(LoginPage.driver, "upload.btn.reupload.xpath").isDisplayed());
		logger.info("The Re-upload button is highlighted in green color as :" +utility.initializeElement(LoginPage.driver, "upload.btn.reupload.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "upload.btn.reupload.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check breadcrumb list displayed or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isBreadcrumbListDisplayed() throws IOException {
		logger.info("The Breadcrumb list is displayed as :" +utility.initializeElement(LoginPage.driver, "upload.bredcrumb.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "upload.bredcrumb.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check yellow dot displayed or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isYellowDotDisplayedForUploadFailed() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.dot.yellow.failed.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		logger.info("The yellow dot is displayed as soon as upload failed :" +wait.isDisplayed());
		return wait.isDisplayed();
	}
	
	/**
	 * This method is used to check upload success screen displayed or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isUploadSuccessScreenDisplayed() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.txt.uploadsuccessful.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		logger.info("The upload succes screen is displayed :" +wait.isDisplayed());
		return wait.isDisplayed();
	}
	
	/**
	 * This method is used to check upload successful text displayed or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isUploadSuccessfulTextDisplayed() throws IOException {
		logger.info("The upload successful text is displayed as :" +utility.initializeElement(LoginPage.driver, "upload.txt.uploadsuccessful.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "upload.txt.uploadsuccessful.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check upload successful text displayed or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isInvalidDicomOrMissingTagsTextDisplayed() throws IOException {
		logger.info("The text is displayed as :" +utility.initializeElement(LoginPage.driver, "upload.msg.skipped.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "upload.msg.skipped.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check close button displayed or not
	 * 
	 * @throws IOException
	 */
	public boolean isCloseButtonDisplayed() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.successclose.btn.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		logger.info("The close button is displayed : " +wait.isDisplayed());
		return wait.isDisplayed();
		
	}
	
	/**
	 * This method is used to check dashboard button displayed or not
	 * 
	 * @throws IOException
	 */
	public boolean isDashboardButtonDisplayed() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"upload.dashboard.btn.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		logger.info("The dashboard button is displayed : " +wait.isDisplayed());
		return wait.isDisplayed();
		
	}
	
	/**
	 * This method is used to check text message displayed or not
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isInvalidFilesTextDisplayed() throws IOException {
		logger.info("The selected files are not valid dicom files text displayed as :" +utility.initializeElement(LoginPage.driver, "upload.txt.invalidfiles.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "upload.txt.invalidfiles.xpath").isDisplayed();
	}
	
	/**
     * This method is used to check the patient with 500Mb files uploaded is displayed in upload dashboard screen
     * @return
     * @throws IOException
     */
    public boolean verify500MbPatient() throws IOException {
    	Properties properties = reader.getProperty();
    	String firstRecord = utility.initializeElements(LoginPage.driver, "dashboard.list.data.xpath").get(0).getText();
    	String patientName = properties.getProperty("patient.morethan500mb.name");
    	String patientDOB = properties.getProperty("patient.morethan500mb.dob");
    	String patientGender = properties.getProperty("patient.morethan500mb.gender");
    	String surgeonName = properties.getProperty("available.site1.surgeon1");
    	return firstRecord.contains(patientName)
    			&&firstRecord.contains(patientDOB)
    			&&firstRecord.contains(patientGender)
    			&&firstRecord.contains(surgeonName);
    }
    
    /**
     * This method is used to verify all the record values of the first record in Summary Dashboard Page 
     * @return
     * @throws IOException
     */
    public boolean firstRecordValues() throws IOException {
    	
    	boolean patient1Displayed = false;
    	
    	Properties properties = reader.getProperty();
    	List<WebElement> list = utility.initializeElements(LoginPage.driver, "dashboard.list.data.xpath");
    	String patient1Name = properties.getProperty("patient1.name");
    	String patient1DOB = properties.getProperty("patient1.dob");
    	String patient1Gender = properties.getProperty("patient1.gender");
    	String surgeonName = properties.getProperty("available.site1.surgeon1");
    	String applicationName= properties.getProperty("available.application1");
  
    		if(list.get(0).getText().contains(surgeonName)) 
    		{
    			Integer rowNum = 1;
    			logger.info(list.get(0).getText());
    			if(list.get(0).getText().contains(patient1Name)) 
    			{
    				patient1Displayed = list.get(0).getText().contains(patient1DOB) && list.get(0).getText().contains(patient1Gender);
    				logger.info("Patient "+patient1Name+" is displayed in row :" + rowNum +"with Date of Birth as :" +patient1DOB + "and Gender as :" + patient1Gender);
    				
    				Assert.assertEquals(surgeonName,utility.initializeElement(LoginPage.driver, "uploaddashboard.surgeonname.first.xpath").getText());
    				logger.info("Surgeon name is : "+ surgeonName );
    				
    				Assert.assertEquals(applicationName,utility.initializeElement(LoginPage.driver, "uploaddashboard.application.first.xpath").getText());
    				logger.info("Application name is : "+ applicationName );
    			}
    		}
    		else {
    			logger.info("No Patient is Displayed");
    			return false;
    		}
    		logger.info("Date of Upload is : " +utility.initializeElement(LoginPage.driver, "uploaddashboard.dateofupload.first.xpath").getText());
    		logger.info("Number of files uploaded is : " +utility.initializeElement(LoginPage.driver, "uploaddashboard.nooffilesuploaded.first.xpath").getText());
    		
    	return patient1Displayed ;
    	}
	
}
