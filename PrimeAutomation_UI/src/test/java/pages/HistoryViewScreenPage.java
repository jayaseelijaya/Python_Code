
package pages;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.PropertiesFileReader;
import utility.Utility;

public class HistoryViewScreenPage {

	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HistoryViewScreenPage.class);
	Utility utility = new Utility();
	FileDashboardPage daPage = new FileDashboardPage();

	/***
	 * This method is used to enter string text.
	 * 
	 * @throws IOException
	 */
	public void enterUploaderFirstName() throws IOException {
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").click();
		logger.info("uploader first name in search box is entered");
		WebElement searchBox = utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath");
		JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
		js.executeScript("arguments[0].value ='ChristopherBaker';", searchBox);
		logger.info("Entered uploader first name as : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").getAttribute("value"));
	}

	/***
	 * This method is used to click on search button in history page.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSearchButtonInHistory() throws IOException, InterruptedException {
		Thread.sleep(10000);
		// utility.initializeElement(LoginPage.driver,
		// "history.btn.search.xpath").click();
		try {

		} catch (Exception e) {
			WebElement searchBtn = utility.initializeElement(LoginPage.driver, "history.btn.search.xpath");
			JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
			js.executeScript("arguments[0].click", searchBtn);
			logger.info("Search button is clicked");
			Thread.sleep(20000);
		}
	}

	/**
	 * This method is used to check if search button displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSearchButtonDisplayed() throws IOException {
		logger.info("Search button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.search.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.btn.search.xpath").isDisplayed();
	}

	/**
	 * This method is used to check history page header displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isHistoryPageHeaderDisplayed(String header) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (header.equalsIgnoreCase("date")) {
			return utility.initializeElement(LoginPage.driver, "history.header.date.xpath");
		}
		if (header.equalsIgnoreCase("upload id")) {
			return utility.initializeElement(LoginPage.driver, "history.header.uploadid.xpath");
		}
		if (header.equalsIgnoreCase("upload user")) {
			return utility.initializeElement(LoginPage.driver, "history.header.uploaduser.xpath");
		}
		if (header.equalsIgnoreCase("patient")) {
			return utility.initializeElement(LoginPage.driver, "history.header.patient.xpath");
		}
		if (header.equalsIgnoreCase("doctor")) {
			return utility.initializeElement(LoginPage.driver, "history.header.doctor.xpath");
		}
		if (header.equalsIgnoreCase("hospital")) {
			return utility.initializeElement(LoginPage.driver, "history.header.hospital.xpath");
		}
		if (header.equalsIgnoreCase("status")) {
			return utility.initializeElement(LoginPage.driver, "history.header.status.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + header);
		return null;
	}

	/***
	 * This method is used to select 24hrs checkbox filter in history page.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void select24HrsCheckboxFilter() throws IOException, InterruptedException {
		try {
			logger.info("24hrs filter is displayed : " + utility
					.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").isDisplayed());
			utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").click();
		} catch (Exception e) {
			logger.info("24hrs filter is displayed : " + utility
					.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").isDisplayed());
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath"));
		}
	}

	/**
	 * This method is used to check table records filtered based on 24hrs filter.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public boolean get24HrsFilteredRecords() throws IOException, InterruptedException, ParseException {
		logger.info("24Hrs filter is applied  : "
				+ utility.initializeElement(LoginPage.driver, "history.table.row.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> rows = utility.initializeElements(LoginPage.driver, "history.table.row.xpath");
		int size = rows.size();
		logger.info("Total no. of record is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("24hrs filtered record list is : " + rows.get(i).getText() + "\n");

				}
			}
			return true;
		}
		return false;
	}

	/***
	 * This method is used to enter patient first name.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterPatientNameInSearchBox() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").sendKeys("Patrick");
		logger.info("The entered patient name is : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").getAttribute("value"));

	}

	/***
	 * This method is used to click View Details button in history page.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickViewDetails() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "history.btn.viewdetails.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "history.btn.viewdetails.xpath"));
		}
		logger.info("clickViewDetails : Clicked View Details");
	}

	/***
	 * This method is used to Record entry in history page is dsisplayed
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void recordEntryPage() throws IOException, InterruptedException {
		logger.info("Record Entry page is displayed : "
				+ utility.initializeElement(LoginPage.driver, "history.recordentry.txt.xpath").isDisplayed());
		logger.info("Record Entry page is displayed with all details");
	}

	/***
	 * This method is used to click on search button.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSearchButtonOnHistoryPage() throws IOException, InterruptedException {
		try {
			logger.info("Search button is clicked : "
					+ utility.initializeElement(LoginPage.driver, "history.btn.search.xpath").isDisplayed());
			utility.initializeElement(LoginPage.driver, "history.btn.search.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "history.btn.search.xpath"));
		}
	}

	/**
	 * This method is used to check table records filtered based on 24hrs filter.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public boolean get24HrsFilteredRecordsBasedOnSearchedPatientName()
			throws IOException, InterruptedException, ParseException {
		logger.info("24Hrs filter is applied based on searched patient name  : "
				+ utility.initializeElement(LoginPage.driver, "history.table.column.patient.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> patientColumn = utility.initializeElements(LoginPage.driver,
				"history.table.column.patient.xpath");
		int size = patientColumn.size();
		logger.info("Total no. of record is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {

				System.out.println("24hrs filtered record based on searched patient name list is : "
						+ patientColumn.get(i).getText() + "\n");
			}
			return true;
		}
		return false;
	}

	/***
	 * This method is used to click on filter button.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnFilterButtonOnHistoryPage() throws IOException, InterruptedException {
		try {
			logger.info("Filter button is clicked : "
					+ utility.initializeElement(LoginPage.driver, "history.filter.xpath").isDisplayed());
			utility.initializeElement(LoginPage.driver, "history.filter.xpath").click();
		} catch (Exception e) {
			logger.info("Filter button is clicked : "
					+ utility.initializeElement(LoginPage.driver, "history.filter.xpath").isDisplayed());
			WebElement filterBtn = utility.initializeElement(LoginPage.driver, "history.filter.xpath");
			JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
			js.executeScript("arguments[0].click", filterBtn);
			logger.info("Filter button is clicked");
			Thread.sleep(20000);
		}
	}

	/**
	 * This method is used to check if 24hrs checkbox is removed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean is24HrsCheckboxRemoved() throws IOException {
		logger.info("24hrs checkbox is removed : "
				+ utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").isSelected());
		return utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").isSelected();
	}

	/**
	 * This method is used to check table records filtered based on selected date.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean getEnteredPatientNameWithinSelectedDate() throws IOException, InterruptedException {
		logger.info("searched patient name is filtered based on selected date  : "
				+ utility.initializeElement(LoginPage.driver, "history.table.row.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> patientColumn = utility.initializeElements(LoginPage.driver, "history.table.row.xpath");
		int size = patientColumn.size();
		logger.info("Total no. of record is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {

				System.out.println("the searched patient name record list is based on selected date : "
						+ patientColumn.get(i).getText() + "\n");
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check selected filters displayed or not.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isSelectedFilterDisplayed() throws IOException, InterruptedException {
		logger.info("selected filters are displayed  : "
				+ utility.initializeElement(LoginPage.driver, "history.filter.btn.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> filter = utility.initializeElements(LoginPage.driver, "history.filter.btn.xpath");
		int size = filter.size();
		logger.info("Total no. of record is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {

				System.out.println("the searched patient name record list is based on selected date : "
						+ filter.get(i).getText().replace(" X", "").trim());
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check table records filtered based on applied filters.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean getRecordsBasedOnAppliedFilters() throws IOException, InterruptedException {
		logger.info("Records are displayed based on applied filters  : "
				+ utility.initializeElement(LoginPage.driver, "history.table.row.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> patientColumn = utility.initializeElements(LoginPage.driver, "history.table.row.xpath");
		int size = patientColumn.size();
		logger.info("Total no. of record is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {

				System.out.println(
						"the record list based on applied filter is : " + patientColumn.get(i).getText() + "\n");
			}
			return true;
		}
		return false;
	}

	/***
	 * This method is used to enter current date in search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterCurrentDateInSearchBox() throws IOException, InterruptedException {
		Date date1 = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYY");
		String today = formatter.format(date1);
		logger.info("Current date is : " + today);
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").click();
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").sendKeys(today);
		logger.info("Current date in searchbox is entered as : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").getAttribute("value"));
	}

	/**
	 * This method is used to check if no data to display displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isHistoryViewDisplayedNoDataToDisplay() throws IOException {
		logger.info("No data to display is displayed : "
				+ utility.initializeElement(LoginPage.driver, "history.nodatatodisplay.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.nodatatodisplay.xpath").isDisplayed();
	}

	/***
	 * This method is used to enter upload id in search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterUploadIdInSearchBox() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").clear();
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath")
				.sendKeys(properties.getProperty("history.uploadId"));
		logger.info("Upload id in searchbox is entered as : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").getAttribute("value"));
	}

	/***
	 * This method is used to any data in search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterAnyDataNotPresentInTable() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").clear();
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").sendKeys("Alex@123#");
		logger.info("data in searchbox is entered as : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").getAttribute("value"));
	}

	/***
	 * This method is used to perform click in search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void removeTextInSearchBox() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").clear();
		utility.initializeElement(LoginPage.driver, "history.btn.search.xpath").click();
	}

	/**
	 * This method is used to check if history view table displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isHistoryViewTableDisplayed() throws IOException {
		logger.info("History view table is displayed : "
				+ utility.initializeElement(LoginPage.driver, "history.table.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.table.xpath").isDisplayed();
	}

	/**
	 * This method is used to check table records filtered based on searched
	 * uploader.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isHistoryViewFilteredAsPerEnteredUploaderName() throws IOException, InterruptedException {
		logger.info("Records are displayed based on entered uploader name in searchbox  : "
				+ utility.initializeElement(LoginPage.driver, "history.table.uploaderusercolumn.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> uploaderColumn = utility.initializeElements(LoginPage.driver,
				"history.table.uploaderusercolumn.xpath");
		int size = uploaderColumn.size();
		logger.info("Total no. of record is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {

				System.out.println(
						"the record list based on uploader name filter is : " + uploaderColumn.get(i).getText() + "\n");
			}
			return true;
		}
		return false;
	}

	/***
	 * This method is used to enter string text in search box.
	 * 
	 * @throws IOException
	 */
	public void enterUploaderLastName() throws IOException {
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").clear();
		logger.info("uploader last name in search box is entered");
		WebElement searchBox = utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath");
		JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
		js.executeScript("arguments[0].value ='Anderson';", searchBox);
		logger.info("Entered uploader last name as : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").getAttribute("value"));
	}

	/***
	 * This method is used to enter string text in search box.
	 * 
	 * @throws IOException
	 */
	public void enterSurgeonFirstName() throws IOException {
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").clear();
		logger.info("surgeon first name in search box is entered");
		WebElement searchBox = utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath");
		JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
		js.executeScript("arguments[0].value ='ChristopherBaker';", searchBox);
		logger.info("Entered surgeon first name as : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").getAttribute("value"));
	}

	/**
	 * This method is used to check table records filtered based on searched surgeon
	 * name.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isHistoryViewFilteredAsPerEnteredSurgeonName() throws IOException, InterruptedException {
		logger.info("Records are displayed based on entered surgeon name in searchbox  : "
				+ utility.initializeElement(LoginPage.driver, "history.table.doctorcolumn.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> doctorColumn = utility.initializeElements(LoginPage.driver,
				"history.table.doctorcolumn.xpath");
		int size = doctorColumn.size();
		logger.info("Total no. of record is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {

				System.out.println(
						"the record list based on surgeon name filter is : " + doctorColumn.get(i).getText() + "\n");
			}
			Thread.sleep(10000);
			return true;
		}
		return false;
	}

	/***
	 * This method is used to enter string text in search box.
	 * 
	 * @throws IOException
	 */
	public void enterSurgeonLastName() throws IOException {
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").clear();
		logger.info("surgeon last name in search box is entered");
		WebElement searchBox = utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath");
		JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
		js.executeScript("arguments[0].value ='CRNP';", searchBox);
		logger.info("Entered surgeon last name as : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").getAttribute("value"));
	}

	/***
	 * This method is used to enter string text in search box.
	 * 
	 * @throws IOException
	 */
	public void enterUploadStaus() throws IOException {
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").clear();
		logger.info("upload status in search box is entered");
		WebElement searchBox = utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath");
		JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
		js.executeScript("arguments[0].value ='Processing';", searchBox);
		logger.info("Entered upload status as : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").getAttribute("value"));
	}

	/**
	 * This method is used to check table records filtered based on searched upload
	 * status.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isHistoryViewFilteredAsPerEnteredUploadStatus() throws IOException, InterruptedException {
		logger.info("Records are displayed based on entered upload status in searchbox  : "
				+ utility.initializeElement(LoginPage.driver, "history.table.statuscolumn.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> uploadColumn = utility.initializeElements(LoginPage.driver,
				"history.table.statuscolumn.xpath");
		int size = uploadColumn.size();
		logger.info("Total no. of record is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {

				System.out.println(
						"the record list based on upload status filter is : " + uploadColumn.get(i).getText() + "\n");
			}
			Thread.sleep(10000);
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check if scrollbar displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isScrollBarDisplayed() throws IOException {
		logger.info("Scroll bar is displayed : "
				+ utility.initializeElement(LoginPage.driver, "history.scrollbar.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.scrollbar.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if scrollbar displayed in green color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isScrollbarDisplayedInGreenColour() throws IOException {
		logger.info("Scroll bar is displayed in Green Colour : "
				+ utility.initializeElement(LoginPage.driver, "history.scrollbar.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "history.scrollbar.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if view details button displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isViewDetailsButtonDisplayed() throws IOException {
		logger.info("View details button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.viewdetails.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.btn.viewdetails.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if 24hrs checkbox displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean is24HrsCheckboxDisplayed() throws IOException {
		logger.info("24hrs checkbox is displayed : "
				+ utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if 24hrs checkbox highlighted in green colour or
	 * not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String is24HrsCheckboxHighlightedInGreenColour() throws IOException {
		logger.info("24hrs checkbox is highlighted in green colour : " + utility
				.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if searchbar displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSearchBarDisplayed() throws IOException {
		logger.info("Searchbar is displayed : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").isDisplayed();
	}

	/***
	 * This method is used to uncheck 24hrs checkbox filter in history page.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void uncheck24HrsCheckboxFilter() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").click();
	}

	/***
	 * This method is used to click on History from left panel
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnHistory() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath").click();
		logger.info("click History Button from left panel : Clicked History button");
	}

	public Boolean isHistoryHeaderDisplayed() throws IOException {
		logger.info("History header is displayed : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.history.xpath").isDisplayed());
		logger.info("History header is displayed as : "
				+ utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.history.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.history.xpath").isDisplayed();
	}

	/**
	 * This method is used to check History coloumn components displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isHistoryColoumnsDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("Date")) {
			return utility.initializeElement(LoginPage.driver, "history.date.btn.xpath");
		}
		if (component.equalsIgnoreCase("Upload Id")) {
			return utility.initializeElement(LoginPage.driver, "history.uploadId.btn.xpath");
		}
		if (component.equalsIgnoreCase("Upload User")) {
			return utility.initializeElement(LoginPage.driver, "history.uploadUser.btn.xpath");
		}
		if (component.equalsIgnoreCase("Patient")) {
			return utility.initializeElement(LoginPage.driver, "history.patient.btn.xpath");
		}
		if (component.equalsIgnoreCase("Doctor")) {
			return utility.initializeElement(LoginPage.driver, "history.doctor.btn.xpath");
		}
		if (component.equalsIgnoreCase("Hospital")) {
			return utility.initializeElement(LoginPage.driver, "history.hospital.btn.xpath");
		}
		if (component.equalsIgnoreCase("Status")) {
			return utility.initializeElement(LoginPage.driver, "history.status.btn.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}

	/**
	 * This method is used to display History records is displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public boolean isHistoryRecordsDisplayed() throws IOException, InterruptedException, ParseException {
		logger.info("History page contains records : "
				+ utility.initializeElement(LoginPage.driver, "history.list.btn.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> order = utility.initializeElements(LoginPage.driver, "history.list.btn.xpath");
		int size = order.size();
		logger.info("Total no. of Records is : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("Records entry displayed as : " + order.get(i).getText() + "\n");
				}
			}
			return true;
		}
		return false;
	}

	/***
	 * This method is used to click on date filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnDateFilterOption() throws IOException, InterruptedException {
		daPage.waitForSpinnerToDisappear();
		utility.initializeElement(LoginPage.driver, "auditlog.filter.list.date.xpath").click();
		logger.info("clicked on date filter option");
	}

	/**
	 * This method is used to check the sorting type of columns in History screen
	 * 
	 * @throws IOException
	 */
	public Boolean historyViewSortingCheck(String headerName, String sortType) throws IOException {
		WebElement element = getHeaderElement(headerName);
		logger.info("Header " + element.getText() + " is found");
		String sortingType = element.getAttribute("aria-sort");
		logger.info("Sorting type : " + sortingType);

		List<WebElement> allRows = LoginPage.driver
				.findElements(By.xpath("//table[@class='mat-table cdk-table mat-sort mat-elevation-z8']//tr"));

		for (int i = 1; i < allRows.size(); i++) {
			logger.info("Contents : " + allRows.get(i).getText());
		}
		if (sortType.equals(sortingType)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to check the table contents after searching in History
	 * screen
	 * 
	 * @throws IOException
	 */
	public Boolean checktablecontents() throws IOException {
		List<WebElement> allRows = LoginPage.driver
				.findElements(By.xpath("//table[@class='mat-table cdk-table mat-sort mat-elevation-z8']//tr"));
		Boolean isNotPresent = false;
		for (int i = 1; i < allRows.size(); i++) {
			logger.info("Contents : " + allRows.get(i).getText());
			if (allRows.get(i).getText().contains("Patrick"))
				isNotPresent = true;
			else
				isNotPresent = false;
		}
		return isNotPresent;
	}

	/**
	 * This method is used to click table headers in the history screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickHeader(String headerName) throws IOException, InterruptedException {
		WebElement element = getHeaderElement(headerName);
		element.click();
		logger.info("Header " + element.getText() + " is clicked");
		Thread.sleep(1000);
	}

	/**
	 * This method is used to return History table header elements.
	 * 
	 * @throws IOException
	 */
	public WebElement getHeaderElement(String headerName) throws IOException {
		WebElement element;
		if (headerName.equals("Date")) {
			element = utility.initializeElement(LoginPage.driver, "history.header.date.xpath");
		} else if (headerName.equals("Upload ID")) {
			element = utility.initializeElement(LoginPage.driver, "history.header.uploadid.xpath");
		} else if (headerName.equals("Upload User")) {
			element = utility.initializeElement(LoginPage.driver, "history.header.uploaduser.xpath");
		} else if (headerName.equals("Patient")) {
			element = utility.initializeElement(LoginPage.driver, "history.header.patient.xpath");
		} else if (headerName.equals("Doctor")) {
			element = utility.initializeElement(LoginPage.driver, "history.header.doctor.xpath");
		} else if (headerName.equals("Hospital")) {
			element = utility.initializeElement(LoginPage.driver, "history.header.hospital.xpath");
		} else {
			element = utility.initializeElement(LoginPage.driver, "history.header.status.xpath");
		}
		return element;
	}

	/**
	 * This method is used to check the type of arrows for sorting columns in
	 * history table.
	 * 
	 * @throws IOException
	 */
	public Boolean sortArrowCheck(String headerName, String arrowType) throws IOException {
		WebElement element = getHeaderElement(headerName);
		int index;
		if (headerName.equals("Date")) {
			index = 1;
		} else if (headerName.equals("Upload ID")) {
			index = 2;
		} else if (headerName.equals("Upload User")) {
			index = 3;
		} else if (headerName.equals("Patient")) {
			index = 4;
		} else if (headerName.equals("Doctor")) {
			index = 5;
		} else if (headerName.equals("Hospital")) {
			index = 6;
		} else {
			index = 7;
		}

		Properties properties = reader.getProperty();
		String leftPointerXpath = properties.getProperty("history.table.sortLeftPointer.xpath");
		String rightPointerXpath = properties.getProperty("history.table.sortRightPointer.xpath");
		WebElement leftPointer = element.findElement(By.xpath((leftPointerXpath + "[" + index + "]")));
		WebElement rightPointer = element.findElement(By.xpath((rightPointerXpath + "[" + index + "]")));
		String leftPointerStyle = leftPointer.getAttribute("style");
		String rightPointerStyle = rightPointer.getAttribute("style");
		if (arrowType.equals("facing up")) {
			if (leftPointerStyle.equals("transform: rotate(-45deg);")
					& rightPointerStyle.equals("transform: rotate(45deg);")) {
				logger.info("arrow is facing up");
				return true;
			} else
				logger.info("arrow is facing down");
			return false;
		} else {
			if (leftPointerStyle.equals("transform: rotate(45deg);")
					& rightPointerStyle.equals("transform: rotate(-45deg);")) {
				logger.info("arrow is facing down");
				return true;
			} else
				logger.info("arrow is facing up");
			return false;
		}

	}

	/**
	 * This method is used to check uploaded files details displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isUploadFilesDetailsDisplayed(String detail) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (detail.equalsIgnoreCase("Date of upload")) {
			logger.info("Date of upload is displayed as " + utility
					.initializeElement(LoginPage.driver, "uploaddashboard.dateofupload.first.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "uploaddashboard.dateofupload.first.xpath");
		}
//		if (detail.equalsIgnoreCase("site")) {
//			return utility.initializeElement(LoginPage.driver,
//					"dashboard.table.records.xpath");
//		}
		if (detail.equalsIgnoreCase("Surgeon")) {
			logger.info("Surgeon is displayed as "
					+ utility.initializeElement(LoginPage.driver, "uploaddashboard.surgeonname.first.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "uploaddashboard.surgeonname.first.xpath");
		}
		if (detail.equalsIgnoreCase("Patient name")) {
			logger.info("Patient name is displayed as "
					+ utility.initializeElement(LoginPage.driver, "uploaddashboard.patientname.first.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "uploaddashboard.patientname.first.xpath");
		}
		if (detail.equalsIgnoreCase("Application")) {
			logger.info("Application is displayed as "
					+ utility.initializeElement(LoginPage.driver, "uploaddashboard.application.first.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "uploaddashboard.application.first.xpath");
		}
		if (detail.equalsIgnoreCase("No. of files uploaded")) {
			logger.info("No. of files uploaded is displayed as " + utility
					.initializeElement(LoginPage.driver, "uploaddashboard.nooffilesuploaded.first.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "uploaddashboard.nooffilesuploaded.first.xpath");
		}
		if (detail.equalsIgnoreCase("Status of image uploaded")) {
			logger.info("Status of image uploaded is displayed as " + utility
					.initializeElement(LoginPage.driver, "uploaddashboard.statusofimageupload.first.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "uploaddashboard.statusofimageupload.first.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + detail);
		return null;
	}

	/**
	 * This method is used to check if new uploaded files details displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isNewUploadedDetailsDisplayedAtTop() throws IOException {
		logger.info("History entry record displayed new uploaded files at the top");
		return utility.initializeElement(LoginPage.driver, "history.table.firstrecord.xpath").isDisplayed();
	}

	/**
	 * This method is used to check uploaded files details displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isUploadedRecordDetailsDisplayed(String record) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (record.equalsIgnoreCase("date")) {
			logger.info("Date is displayed as "
					+ utility.initializeElement(LoginPage.driver, "history.table.columnfirst.date.xpath").getText()
							.substring(10));
			return utility.initializeElement(LoginPage.driver, "history.table.columnfirst.date.xpath");
		}
		if (record.equalsIgnoreCase("upload id")) {
			logger.info("Upload id is displayed as " + utility
					.initializeElement(LoginPage.driver, "history.table.columnfirst.uploadid.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "history.table.columnfirst.uploadid.xpath");
		}
		if (record.equalsIgnoreCase("upload user")) {
			logger.info("upload user is displayed as " + utility
					.initializeElement(LoginPage.driver, "history.table.columnfirst.uploaduser.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "history.table.columnfirst.uploaduser.xpath");
		}
		if (record.equalsIgnoreCase("patient")) {
			logger.info("Patient name is displayed as "
					+ utility.initializeElement(LoginPage.driver, "history.table.columnfirst.patient.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "history.table.columnfirst.patient.xpath");
		}
		if (record.equalsIgnoreCase("doctor")) {
			logger.info("Doctor is displayed as "
					+ utility.initializeElement(LoginPage.driver, "history.table.columnfirst.doctor.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "history.table.columnfirst.doctor.xpath");
		}
		if (record.equalsIgnoreCase("hospital")) {
			logger.info("Hospital is displayed as " + utility
					.initializeElement(LoginPage.driver, "history.table.columnfirst.hospital.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "history.table.columnfirst.hospital.xpath");
		}
		if (record.equalsIgnoreCase("Status")) {
			logger.info("Status is displayed as "
					+ utility.initializeElement(LoginPage.driver, "history.table.columnfirst.status.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "history.table.columnfirst.status.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + record);
		return null;
	}

	/**
	 * This method is used to locate the table contents
	 * 
	 * @param item
	 * @return
	 * @throws IOException
	 */
	public WebElement HistoryItems(Integer row, String item) throws IOException {
		Properties properties = reader.getProperty();
		List<WebElement> rowContents = utility.initializeElements(LoginPage.driver, "history.list.btn.xpath");
		WebElement requiredRow = rowContents.get(row);
		if (item.equalsIgnoreCase("Date")) {
			return requiredRow.findElement(By.xpath(properties.getProperty("history.list.date.xpath")));
		} else if (item.equalsIgnoreCase("uploadid")) {
			return requiredRow.findElement(By.xpath(properties.getProperty("history.list.uploadid.xpath")));
		} else if (item.equalsIgnoreCase("user")) {
			return requiredRow.findElement(By.xpath(properties.getProperty("history.list.uploaduser.xpath")));
		} else if (item.equalsIgnoreCase("patient")) {
			return requiredRow.findElement(By.xpath(properties.getProperty("history.list.patient.xpath")));
		} else if (item.equalsIgnoreCase("Doctor")) {
			return requiredRow.findElement(By.xpath(properties.getProperty("history.list.doctor.xpath")));
		} else if (item.equalsIgnoreCase("hospital")) {
			return requiredRow.findElement(By.xpath(properties.getProperty("history.list.hospital.xpath")));
		} else if (item.equalsIgnoreCase("status")) {
			return requiredRow.findElement(By.xpath(properties.getProperty("history.list.status.xpath")));
		}
		return null;
	}

	/**
	 * This method is used to check details in a row in history screen
	 * 
	 * @param row
	 * @param surgeonName
	 * @param patientName
	 * @param hospitalName
	 * @return
	 * @throws IOException
	 */
	public boolean verifyRecentUploadInHistory(Integer row, String surgeonName, String patientName, String hospitalName)
			throws IOException {
		boolean isDisplayed = false;
		String patientNameInRow = HistoryItems(row, "patient").getText();
		String hospitalNameInRow = HistoryItems(row, "hospital").getText();
		String doctorNameInRow = HistoryItems(row, "doctor").getText();
		logger.info(HistoryItems(row, "patient").getText());
		logger.info(HistoryItems(row, "hospital").getText());
		logger.info(HistoryItems(row, "doctor").getText());
		if (doctorNameInRow.equals(surgeonName)) {
			logger.info("Surgeon name is correct)");
			if (patientNameInRow.equals(patientName)) {
				logger.info("patient name is correct)");
				if (hospitalNameInRow.contains(hospitalName)) {
					logger.info("application name is correct)");
					isDisplayed = true;
				}
			}

		}
		return isDisplayed;
	}

	/**
	 * This method is used to get the upload status of the first row in history
	 * screen
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String uploadStatusInHistory() throws IOException, InterruptedException {
		Thread.sleep(10000);
		return HistoryItems(0, "status").getText();
	}	

	/**
	 * This method is used to check if history button highlighted or not.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public String isHistoryHeaderHighlighted() throws IOException {
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.history.xpath").getCssValue("color");
	}
		

/***
	 * This method is used to check 24 hours check-box displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isHoursChexkboxDisplayed() throws IOException {
		logger.info("24 Hours checkbox is displayed: "
				+ utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.checkbox.twentyfourhrs.xpath").isDisplayed();
	}


/***
	 * This method is used to enter Upload user name in search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterUploadUserInSearchBox() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").sendKeys("Alex Anderson");
		logger.info("The entered Upload user name is : "
				+ utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").getAttribute("value"));

	}


/***
	 * This method is used to click on filter + button.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnFilterPlusIcon() throws IOException, InterruptedException 
	{
		utility.initializeElement(LoginPage.driver, "history.filter.plusicon.xpath").click();
    }

	/***
	 * This method is used to click on select uploader from filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void SelectUploaderfromFilter() throws IOException, InterruptedException 
	{
		logger.info("Selected Uploader Name is : " +utility.initializeElement(LoginPage.driver, "history.uploader.selection.xpath").getText());
		utility.initializeElement(LoginPage.driver, "history.uploader.selection.xpath").click();
	}
	
	
	/***
	 * This method is used to click on filter + icon for file status
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickFileStatusOnFilter() throws IOException, InterruptedException 
	{
		utility.initializeElement(LoginPage.driver, "history.filter.fileplusicon.xpath").click();
    }

	/***
	 * This method is used to select file status from filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void SelectFileStatusfromFilter() throws IOException, InterruptedException 
	{
		logger.info("Selected File Status is : " + utility.initializeElement(LoginPage.driver, "history.filestatus.selection.xpath").getText());
		utility.initializeElement(LoginPage.driver, "history.filestatus.selection.xpath").click();
	}
	
	/***
	 * This method is used to click on filter + icon for site
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickSiteOnFilter() throws IOException, InterruptedException 
	{
		utility.initializeElement(LoginPage.driver, "history.filter.siteplusicon.xpath").click();
    }
 
	/***
	 * This method is used to select site from filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void SelectSitefromFilter() throws IOException, InterruptedException 
	{
		logger.info("Selected Site is : " + utility.initializeElement(LoginPage.driver, "history.site.selection.xpath").getText());
		utility.initializeElement(LoginPage.driver, "history.site.selection.xpath").click();
	}
	
	/***
	 * This method is used to click on Done button.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnDoneBtn() throws IOException, InterruptedException 
	{
		utility.initializeElement(LoginPage.driver, "histoy.filter.done.xpath").click();
	}

/***
	 * This method is used to remove filter from history.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void removeFilter() throws IOException, InterruptedException 
	{
		
	utility.initializeElement(LoginPage.driver, "history.filter.crossicon.xpath").click();
	Thread.sleep(3000);
	}

	/**
	 * This method is used to check uploaded files details displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public WebElement isFilterOptionsDisplayed(String filter) throws IOException, InterruptedException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (filter.equalsIgnoreCase("date")) {
			Thread.sleep(10000);
			logger.info("Date filter option is displayed with + as : "
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.date.xpath").getText()
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.date.+.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "(history.filter.option.date.xpath");
		}
		if (filter.equalsIgnoreCase("uploader")) {
			Thread.sleep(10000);
			logger.info("uploader filter option is displayed with + "
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.uploader.xpath").getText()
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.uploader.+.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "history.filter.option.uploader.xpath");
		}
		if (filter.equalsIgnoreCase("patient")) {
			logger.info("patient filter option is displayed with + "
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.patient.xpath").getText()
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.patient.+.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "history.filter.option.patient.xpath");
		}
		if (filter.equalsIgnoreCase("surgeon")) {
			logger.info("surgeon filter option is displayed with + "
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.surgeon.xpath").getText()
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.surgeon.+.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "history.filter.option.surgeon.xpath");
		}
		if (filter.equalsIgnoreCase("site")) {
			logger.info("site filter option is displayed with + "
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.site.xpath").getText()
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.site.+.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "history.filter.option.site.xpath");
		}
		if (filter.equalsIgnoreCase("file status")) {
			logger.info("file status filter option is displayed with "
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.filestatus.xpath").getText()
					+ utility.initializeElement(LoginPage.driver, "history.filter.option.filestatus.+.xpath")
							.getText());
			return utility.initializeElement(LoginPage.driver, "history.filter.option.filestatus.xpath");
		}
		if (filter.equalsIgnoreCase("done")) {
			return utility.initializeElement(LoginPage.driver, "history.filter.btn.done.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + filter);
		return null;
	}

	/***
	 * This method is used to click on date filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnDateFilter() throws IOException, InterruptedException {
		daPage.waitForSpinnerToDisappear();
		utility.initializeElement(LoginPage.driver, "history.filter.option.date.+.xpath").click();
		logger.info("clicked on date filter option");
	}

	/***
	 * This method is used to click on start date button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnStartDateButton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.filter.btn.start.xpath").click();
		logger.info("clicked on start date button");
	}

	/**
	 * This method is used to check if start and end boxes displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isStartAndEndBoxesDisplayed() throws IOException {
		logger.info("Start and end boxes are displayed");
		utility.initializeElement(LoginPage.driver, "history.filter.btn.start.xpath").isDisplayed();
		return utility.initializeElement(LoginPage.driver, "history.filter.btn.end.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if start and end boxes displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean selectedStartEndDateDisplayed() throws IOException {
		logger.info("Selected start date as : "
				+ utility.initializeElement(LoginPage.driver, "history.filter.startdateselected.xpath").getText());
		logger.info("Selected end date as : "
				+ utility.initializeElement(LoginPage.driver, "history.filter.enddateselected.xpath").getText());
		utility.initializeElement(LoginPage.driver, "history.filter.startdateselected.xpath").isDisplayed();
		return utility.initializeElement(LoginPage.driver, "history.filter.enddateselected.xpath").isDisplayed();
	}

	/***
	 * This method is used to select start date less than current date.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectStartDateTwoDaysBackFromCurrentDate() throws IOException, InterruptedException {
		logger.info("selectStartDateTwoDaysBackFromCurrentDate: Date 2 days back from Current date is selected");
		List<WebElement> endDate = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		calendar.add(Calendar.DAY_OF_YEAR, -2);
		Date previousDate = calendar.getTime();
		String oldDate = formatter.format(previousDate);
		String dateNumber = oldDate.substring(0).replaceAll("0", "");
		for (WebElement cell : endDate) {
			if (cell.getText().equals(dateNumber)) {
				logger.info("Selected Date is : " + cell.getText());
				cell.click();
				break;
			}
		}
	}

	/**
	 * This method is used to check if selected filter displayed at top
	 * or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public boolean isSelectedFilterAtTopDisplayed() throws IOException, InterruptedException {
		Thread.sleep(10000);
		List<WebElement> List = utility.initializeElements(LoginPage.driver, "history.filter.appliedfilterlist.xpath");
		 for (WebElement webElement : List) {
	            String selectedFilters = webElement.getText();
	            logger.info("Selected Filter at top are displayed as : " +selectedFilters);
	        }
		 return utility.initializeElement(LoginPage.driver, "history.filter.appliedfilterlist.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if history page filtered out as per selected
	 * filter
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isHistoryRecordFiltered() throws IOException, InterruptedException {
		try {
			List<WebElement> List = utility.initializeElements(LoginPage.driver, "history.table.row.xpath");
			int size = List.size();
			logger.info("Total no. of filtered out records : " + size);
			if (size >= 1) {
				for (WebElement newList : List) {

					logger.info("History record list as per selected filter : " + newList.getText());

				}
				return true;
			}
			Thread.sleep(10000);
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}

	/***
	 * This method is used to click on uploader filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnUploaderFilter() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.filter.option.uploader.+.xpath").click();
		logger.info("clicked on uploader filter option");
	}

	/**
	 * This method is used to check if history page filtered out as per selected
	 * filter
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isOptionNamesDisplayed() throws IOException, InterruptedException {

		List<WebElement> List = utility.initializeElements(LoginPage.driver, "history.filter.uploader.list.xpath");
		int size = List.size();
		logger.info("Total no. of option names : " + size);
		if (size >= 1) {
			for (WebElement newList : List) {
				logger.info("The option name is : " + newList.getText());
			}
			return true;
		}
		return false;
	}

	/***
	 * This method is used to select any option name
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectAnyOption() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.filter.uploader.firstname.xpath").click();
		logger.info("Option is selected as : "
				+ utility.initializeElement(LoginPage.driver, "history.filter.uploader.firstname.xpath").getText());
	}
	
	/***
	 * This method is used to remove filter
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnXToRemoveFilter() throws IOException, InterruptedException {
		List<WebElement> List = utility.initializeElements(LoginPage.driver, "history.filter.btn.x.xpath");
		 for (WebElement webElement : List) {
			 webElement.click();
	            logger.info("Filter is removed");
	            Thread.sleep(10000);
	        }
	}
	
	/**
	 * This method is used to check if filter removed or not
	 * filter
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isFilterRemoved() throws IOException, InterruptedException {
		 try {
			  utility.initializeElement(LoginPage.driver, "history.filter.btn.x.xpath").isDisplayed();             
			  return false;
		 } catch (NoSuchElementException e) {
             return false;
         }
	}
	
	/***
	 * This method is used to click on patient filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnPatient() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.filter.option.patient.+.xpath").click();
		logger.info("clicked on patient filter option");
	}
	
	/***
	 * This method is used to deselect patient name
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void deselectPatientName() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.filter.option.patient.+.xpath").click();
		utility.initializeElement(LoginPage.driver, "history.filter.uploader.firstname.xpath").click();
		utility.initializeElement(LoginPage.driver, "history.filter.option.patient.+.xpath").click();
		logger.info("Patient name is deselected");
	}
	
	/***
	 * This method is used to click on surgeon filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSurgeonFilter() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.filter.option.surgeon.+.xpath").click();
		logger.info("clicked on surgeon filter option");
	}
	
	/***
	 * This method is used to deselect surgeon name
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void deselectSurgeonName() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.filter.option.surgeon.+.xpath").click();
		utility.initializeElement(LoginPage.driver, "history.filter.uploader.firstname.xpath").click();
		utility.initializeElement(LoginPage.driver, "history.filter.option.surgeon.+.xpath").click();
		logger.info("Surgeon name is deselected");
	}
	
	/***
	 * This method is used to click on site filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSiteFilter() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.filter.option.site.+.xpath").click();
		logger.info("clicked on site filter option");
	}
	
	/***
	 * This method is used to click on file status filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnFileStatusFilter() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.filter.option.filestatus.+.xpath").click();
		logger.info("clicked on file status filter option");
	}
	
	/***
	 * This method is used to select any option name
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectAnyFileStatus() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "history.filter.filestatus.firstname.xpath").click();
		logger.info("File status is selected as : "
				+ utility.initializeElement(LoginPage.driver, "history.filter.filestatus.firstname.xpath").getText());
	}
	
	
	

/**
	 * This method is used to check if filter button is displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isFilterBtnDisplayed() throws IOException {
		logger.info("Filter Button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "history.filter.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.filter.xpath").isDisplayed();
	}
	
/***
	 * This method is used to click one record in history page.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickRecord() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "history.record.select.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "history.record.select.xpath"));
		}
		logger.info("clickRecord : Record is clicked");
	}
	
	/**
	 * This method is used to check if View Details button is displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isViewDetailsdisabled() throws IOException, InterruptedException {
		logger.info("View Details button is displayed and in disabled mode : " + utility.initializeElement(LoginPage.driver, "history.btn.viewdetails.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.btn.viewdetails.xpath").isDisplayed();		
		
	}
	
	public boolean isViewDetailsEnabled() throws IOException, InterruptedException {
		logger.info("View Details button is displayed and in enabled mode : " + utility.initializeElement(LoginPage.driver, "history.btn.viewdetails.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "history.btn.viewdetails.xpath").isEnabled();		
		
	}
	
	/**
	 * This method is used to check if Show More button is displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isShowMoreBtnDisplayed() throws IOException, InterruptedException {
		logger.info("Show More Buton is displayed : " + utility.initializeElement(LoginPage.driver, "history.btn.showmore.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "history.btn.showmore.xpath").isDisplayed();		
		
	}
	
	
	/**
	 * This method is to print the most recent entry's date to the console
	 * 
	 * 
	 * @throws IOException
	 */
	public void getDateOfFirstEntryOnDashboard() throws IOException {
		String date = utility.initializeElement(LoginPage.driver, "uploaddashboard.uploaddate.first.xpath").getText();
		logger.info("Date of most recent upload in dashboard: " + date);
	}
	
	/**
	 * This method is to print the most recent entry's date in the console
	 * 
	 * @throws IOException
	 */
	public void getDateOfFirstEntryOnHistoryPage() throws IOException {
		String date = utility.initializeElement(LoginPage.driver, "history.table.columnfirst.date.xpath").getText();
		logger.info("Date of most recent upload in history page: " + date);
	}
	
	/**
     * This method is used to check if search box is displayed or not
     * 
     * @return boolean
     * @throws IOException
     */
    public boolean isSearchBoxDisplayed() throws IOException {
        logger.info("Search Box is displayed : "
                + utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").isDisplayed());
        return utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath").isDisplayed();
    }
    
    /**
	 * This method is used to enter text in search box and click on search button
	 * @param string
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterStringAndclickSearchBtn(String string) throws IOException, InterruptedException {
		WebElement searchBox = utility.initializeElement(LoginPage.driver, "history.btn.searchbox.xpath");
		searchBox.clear();
		logger.info("Search box is cleared");
		searchBox.sendKeys(string);
		logger.info(string+ " is entered");
		clickOnSearchButtonOnHistoryPage();
	}
	
	/**
	 * This method is used to verify the history is as per search
	 * @param string
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean verifySearchResult(String string) throws IOException, InterruptedException {
		Thread.sleep(3000);
		List<WebElement> allRows = LoginPage.driver.findElements(By.xpath("//table[@class='mat-table cdk-table mat-sort mat-elevation-z8']//tr"));
		Boolean isNotPresent = false;
		for(int i = 1; i< allRows.size();i++) {
			logger.info("Contents : " + allRows.get(i).getText());
			if(allRows.get(i).getText().contains(string))
				isNotPresent = true;
			else
				isNotPresent = false;
		}
		return isNotPresent;
	}
		
	/**
	 * This method is used to get the  patient's first name form first row
	 * @return
	 * @throws IOException
	 */
	public String getPatientFirstNameInFirstRow() throws IOException {
		logger.info("Patient First name: " + (HistoryItems(0,"patient").getText().split(" "))[0]);
		return (HistoryItems(0,"patient").getText().split(" "))[0];
	}
	
	/**
	 * This method is used to get the  patient's last name form first row
	 * @return
	 * @throws IOException
	 */
	public String getPatientLastNameInFirstRow() throws IOException {
		logger.info("Patient Last name: " + (HistoryItems(0,"patient").getText().split(" "))[1]);
		return (HistoryItems(0,"patient").getText().split(" "))[1];
	}
	
	/**
	 * This method is used to get the  hospital name form first row
	 * @return
	 * @throws IOException
	 */
	public String getHospitalNameInFirstRow() throws IOException {
		logger.info("Hospital name: " + HistoryItems(0,"hospital").getText());
		return HistoryItems(0,"hospital").getText();
	}
	
	/**
	 * This method is used to get the  uploader first name form first row
	 * @return
	 * @throws IOException
	 */
	public String getUploaderFirstNameInFirstRow() throws IOException {
		logger.info("Uploader First name: " + (HistoryItems(0,"user").getText().split(" "))[0]);
		return (HistoryItems(0,"user").getText().split(" "))[0];
	}
	
	/**
	 * This method is used to get the  uploader last name form first row
	 * @return
	 * @throws IOException
	 */
	public String getUploaderLastNameInFirstRow() throws IOException {
		logger.info("Uploader Last name: " + (HistoryItems(0,"user").getText().split(" "))[1]);
		return (HistoryItems(0,"user").getText().split(" "))[1];
	}
	
	/**
	 * This method is used to get the  surgeon first name form first row
	 * @return
	 * @throws IOException
	 */
	public String getSurgeonFirstNameInFirstRow() throws IOException {
		logger.info("Surgeon First name: " + (HistoryItems(0,"Doctor").getText().split(" "))[0]);
		return (HistoryItems(0,"Doctor").getText().split(" "))[0];
	}
	
	/**
	 * This method is used to get the  surgeon last name form first row
	 * @return
	 * @throws IOException
	 */
	public String getSurgeonLastNameInFirstRow() throws IOException {
		logger.info("Surgeon Last name: " + (HistoryItems(0,"Doctor").getText().split(" "))[1]);
		return (HistoryItems(0,"Doctor").getText().split(" "))[1];
	}
	
	/**
	 * This method is used to get the  upload status form first row
	 * @return
	 * @throws IOException
	 */
	public String getUploadStatusInFirstRow() throws IOException {
		logger.info("Upload status: " + HistoryItems(0,"status").getText());
		return HistoryItems(0,"status").getText();
	}
	
	/**
	 * This method is used to select the first row in history table
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectFirstRow() throws IOException, InterruptedException {
		Thread.sleep(2000);
		List<WebElement> rowContents = utility.initializeElements(LoginPage.driver, "history.list.btn.xpath");
		rowContents.get(0).click();
		Thread.sleep(2000);
	}
	
	/**
	 * This method is used to verify view details pop up is displayed
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isViewDetailsPopupDisplayed() throws IOException, InterruptedException {
		Thread.sleep(1000);
		if(utility.initializeElement(LoginPage.driver, "history.viewdetails.close.btn.xpath").isDisplayed() && utility.initializeElement(LoginPage.driver, "history.viewdetails.applicationname.xpath").isDisplayed())
			return true;
		else
			return false;
	}
	
	/**
	 * This method is used to verify application name displayed in View details popup
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean verifyApplicationName() throws IOException, InterruptedException {
		boolean isTrue = false;
		Properties properties = reader.getProperty();
		String applicationNameDisplayed = utility.initializeElement(LoginPage.driver, "history.viewdetails.applicationname.xpath").getText().toUpperCase();
		logger.info("Application name : "+applicationNameDisplayed);
		if(applicationNameDisplayed.equals(properties.getProperty("available.application1")))
			isTrue = true;
		logger.info("Application name is matched : "+isTrue);
		utility.initializeElement(LoginPage.driver, "history.viewdetails.close.btn.xpath").click();
		return isTrue;
	}
	
	/**
	 * This method is to click upload status page in left menu bar
	 *
	 * @throws IOException
	 */
	public void clickUploadStatusPage() throws IOException {
		logger.info("User clicked Upload Status from left menu bar");
		utility.initializeElement(LoginPage.driver, "leftnavigation.uploadstatus.xpath").click();
	}

	/**
	 * This method is to check upload status first entry date
	 *
	 * @throws IOException
	 */
	public void checkUploadStatusFirstEntryDate() throws IOException {
		String date = utility.initializeElement(LoginPage.driver, "uploadstatus.date.firstentry.txt.xpath").getText();
		logger.info("Upload status first entry date: " + date);
	}

	/**
	 * This method is to click upload status view details button
	 *
	 * @throws IOException
	 */
	public void clickUploadStatusViewDetailsButton() throws IOException {
		logger.info("User clicked view details button on upload status page");
		utility.initializeElement(LoginPage.driver, "uploadstatus.btn.viewdetails.xpath").click();
	}

	public void clickFirstEntryInUploadStatusPage() throws IOException {
		logger.info("User clicked first entry in upload status page");
		utility.initializeElement(LoginPage.driver, "uploadstatus.btn.firstentry.xpath").click();
	}

	/**
	 * This method is to check for the check mark image on the view details screen
	 *
	 * @return
	 * @throws IOException
	 */
	public Boolean checkViewDetailsImage() throws IOException {
		Boolean bool = 	utility.initializeElement(LoginPage.driver, "uploadstatus.viewdetails.check.img.xpath").isDisplayed();
		if(bool == true) {
			logger.info("View details image is displayed");
			return true;
		} else {
			logger.info("View details image is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check for the success message on the view details screen
	 *
	 * @return
	 * @throws IOException
	 */
	public Boolean checkViewDetailsSuccessText() throws IOException {
		Boolean bool = 	utility.initializeElement(LoginPage.driver, "uploadstatus.viewdetails.success.txt.xpath").isDisplayed();
		if(bool == true) {
			logger.info("View details success text is displayed");
			return true;
		} else {
			logger.info("View details success text is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check for the file count on the view details screen
	 *
	 * @return
	 * @throws IOException
	 */
	public Boolean checkViewDetailsFileCountText() throws IOException {
		Boolean bool = 	utility.initializeElement(LoginPage.driver, "uploadstatus.viewdetails.filecount.txt.xpath").isDisplayed();
		if(bool == true) {
			logger.info("View details file count text is displayed");
			return true;
		} else {
			logger.info("View details file count text is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check for the close button on the view details screen
	 *
	 * @return
	 * @throws IOException
	 */
	public Boolean checkViewDetailsCloseButton() throws IOException {
		Boolean bool = 	utility.initializeElement(LoginPage.driver, "uploadstatus.viewdetails.close.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("View details close button is displayed");
			return true;
		} else {
			logger.info("View details close button is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check for the new upload button on the view details screen
	 *
	 * @return
	 * @throws IOException
	 */
	public Boolean checkViewDetailsNewUploadButton() throws IOException {
		Boolean bool = 	utility.initializeElement(LoginPage.driver, "uploadstatus.viewdetails.newupload.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("View details new upload button is displayed");
			return true;
		} else {
			logger.info("View details new upload button is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check for the dashboard button on the view details screen
	 *
	 * @return
	 * @throws IOException
	 */
	public Boolean checkViewDetailsDashboardButton() throws IOException {
		Boolean bool = 	utility.initializeElement(LoginPage.driver, "uploadstatus.viewdetails.dashboard.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("View details dashboard button is displayed");
			return true;
		} else {
			logger.info("View details dashboard button is not displayed");
			return false;
		}
	}

	/**
	 * This method is to select the first entry in the history page table
	 *
	 * @throws IOException
	 */
	public void clickFirstEntryHistoryTable() throws IOException {
		logger.info("User clicked first entry in history page table");
		utility.initializeElement(LoginPage.driver, "history.table.firstrecord.xpath").click();
	}

	/**
	 * This method is to click the view details button in the history page
	 *
	 * @throws IOException
	 */
	public void clickViewDetailsButton() throws IOException {
		logger.info("User clicked view details button in history page");
		utility.initializeElement(LoginPage.driver, "history.viewdetails.btn.xpath").click();
	}

	/**
	 * This method is to print the upload id of the entry
	 *
	 * @throws IOException
	 */
	public void printIdOfEntry() throws IOException {
		logger.info("Entry ID: " + utility.initializeElement(LoginPage.driver, "history.viewdetails.id.txt.xpath").getText());
	}

	/**
	 * This method is to check the total file size of the entry
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkTotalFileSizeOfEntry() throws IOException {
		String fileSize = utility.initializeElement(LoginPage.driver, "history.viewdetails.totalfilesize.txt.xpath").getText();
		if(fileSize.contains("1.51")) {
			logger.info("File size is correct");
			return true;
		} else {
			logger.info("File Size is incorrect");
			return false;
		}
	}

	/**
	 * This method is to print the uploader
	 *
	 * @throws IOException
	 */
	public void printUploaderOfEntry() throws IOException {
		logger.info("Uploader: " + utility.initializeElement(LoginPage.driver, "history.viewdetails.uploader.txt.xpath").getText());
	}

	/**
	 * This method is to check if the patient in the entry is correct
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkPatientOfEntry() throws IOException {
		String patient = utility.initializeElement(LoginPage.driver, "history.viewdetails.patient.txt.xpath").getText();
		if(patient.contains("Patrick David")) {
			logger.info("Patient is correct");
			return true;
		} else {
			logger.info("Patient is incorrect");
			return false;
		}
	}

	/**
	 * This method is to print the doctor of the entry
	 *
	 * @throws IOException
	 */
	public void printDoctorOfEntry() throws IOException {
		logger.info("Doctor: " + utility.initializeElement(LoginPage.driver, "history.viewdetails.doctor.txt.xpath").getText());
	}

	/**
	 * This method is to print the uploading organization
	 *
	 * @throws IOException
	 */
	public void printOrganizationOfEntry() throws IOException {
		logger.info("Organization: " + utility.initializeElement(LoginPage.driver, "history.viewdetails.organization.txt.xpath").getText());
	}

	/**
	 * This method is to check if the application is correct
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkApplicationOfEntry() throws IOException {
		String application = utility.initializeElement(LoginPage.driver, "history.viewdetails.application.txt.xpath").getText();
		if(application.contains("Data Storage")) {
			logger.info("Application is correct");
			return true;
		} else {
			logger.info("Application is not correct");
			return false;
		}
	}

	/**
	 * This method is to print the upload behind date of the entry
	 *
	 * @throws IOException
	 */
	public void printUploadBeginOfEntry() throws IOException {
		logger.info("Upload Begin: " + utility.initializeElement(LoginPage.driver, "history.viewdetails.uploadbegin.txt.xpath").getText());
	}

	/**
	 * This method is to print the upload end date of the entry
	 *
	 * @throws IOException
	 */
	public void printUploadEndOfEntry() throws IOException {
		logger.info("Upload End: " + utility.initializeElement(LoginPage.driver, "history.viewdetails.uploadend.txt.xpath").getText());
	}

	/**
	 * This method is to print the new status of the entry
	 *
	 * @throws IOException
	 */
	public void printNewStatusOfEntry() throws IOException {
	String newStatus = utility.initializeElement(LoginPage.driver, "history.viewdetails.newstatus.txt.xpath").getText().replaceAll("New Status:", "");
	logger.info("New Status: " +newStatus.trim());
	}
	
	/**
	 * This method is to check if the upload successful screen is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkUploadSuccessfulScreen() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "upload.successheader.txt.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Upload Successful Screen is displayed");
			return true;
		} else {
			logger.info("Upload successful screen is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the upload id from history screen and view details matched or not
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public boolean isUploadIDMatched() throws IOException {
		boolean flag = false;
		String uploadId = utility.initializeElement(LoginPage.driver, "history.table.columnfirst.uploadid.xpath").getText();
		logger.info("History screen Upload Id : "+uploadId); 
		String uploadIdViewDetails = utility.initializeElement(LoginPage.driver, "history.viewdetails.id.txt.xpath").getText();
		logger.info("View details Upload Id : "+uploadIdViewDetails);
		if(uploadId.equals(uploadIdViewDetails)) {
			logger.info("Upload id of history screen matched with view details");
			flag = true;
		} else {
			logger.info("Upload id of history screen not matched with view details");
			flag = false;
		}
		return flag;
	}
	
	/**
	 * This method is to check if the uploader name from history screen and view details matched or not
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public boolean isUploadNameMatched() throws IOException {
		boolean flag = false;
		String uploaderName = utility.initializeElement(LoginPage.driver, "history.table.columnfirst.uploaduser.xpath").getText();
		logger.info("History screen Uploader name : "+uploaderName); 
		String[] uploaderNameViewDetails = utility.initializeElement(LoginPage.driver, "history.viewdetails.uploader.txt.xpath").getText().split(",");
		logger.info("View details Uploader name : "+uploaderNameViewDetails[0]);
		if(uploaderName.contains(uploaderNameViewDetails[0])) {
			logger.info("Uploader name of history screen matched with view details");
			flag = true;
		} else {
			logger.info("Uploader name of history screen not matched with view details");
			flag = false;
		}
		return flag;
	}
	
	/**
	 * This method is to check if the patient name from history screen and view details matched or not
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public boolean isPatientNameMatched() throws IOException {
		boolean flag = false;
		String patientName = utility.initializeElement(LoginPage.driver, "history.table.columnfirst.patient.xpath").getText();
		logger.info("History screen Patient name : "+patientName); 
		String patientNameViewDetails = utility.initializeElement(LoginPage.driver, "history.viewdetails.patient.txt.xpath").getText();
		logger.info("View details Patient name : "+patientNameViewDetails);
		if(patientName.contains(patientNameViewDetails)) {
			logger.info("Patient name of history screen matched with view details");
			flag = true;
		} else {
			logger.info("Patient name of history screen not matched with view details");
			flag = false;
		}
		return flag;
	}
	
	/**
	 * This method is to check if the doctor name from history screen and view details matched or not
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public boolean isDoctorNameMatched() throws IOException {
		boolean flag = false;
		String doctorName = utility.initializeElement(LoginPage.driver, "history.table.columnfirst.doctor.xpath").getText();
		logger.info("History screen Doctor name : "+doctorName); 
		String doctorNameViewDetails = utility.initializeElement(LoginPage.driver, "history.viewdetails.doctor.txt.xpath").getText();
		logger.info("View details Doctor name : "+doctorNameViewDetails);
		if(doctorName.equals(doctorNameViewDetails)) {
			logger.info("Doctor name of history screen matched with view details");
			flag = true;
		} else {
			logger.info("Doctor name of history screen not matched with view details");
			flag = false;
		}
		return flag;
	}
	
	/**
	 * This method is to check if the hospital name from history screen and view details matched or not
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public boolean isHospitalNameMatched() throws IOException {
		boolean flag = false;
		String hospitalName = utility.initializeElement(LoginPage.driver, "history.table.columnfirst.hospital.xpath").getText();
		logger.info("History screen Hospital name : "+hospitalName); 
		String hospitalNameViewDetails = utility.initializeElement(LoginPage.driver, "history.viewdetails.organization.txt.xpath").getText();
		logger.info("View details Hospital name : "+hospitalNameViewDetails);
		if(hospitalName.equals(hospitalNameViewDetails)) {
			logger.info("Hospital name of history screen matched with view details");
			flag = true;
		} else {
			logger.info("Hospital name of history screen not matched with view details");
			flag = false;
		}
		return flag;
	}
	
	/**
	 * This method is to check if the status from history screen and view details matched or not
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public boolean isStatusMatched() throws IOException {
		boolean flag = false;
		String status = utility.initializeElement(LoginPage.driver, "history.table.columnfirst.status.xpath").getText().toUpperCase();
		logger.info("History screen Hospital name : "+status); 
		String statusViewDetails = utility.initializeElement(LoginPage.driver, "history.viewdetails.newstatus.txt.xpath").getText().replace("New Status:", "");
		logger.info("View details Hospital name : "+statusViewDetails);
		if(status.equals(statusViewDetails)) {
			logger.info("Status of history screen matched with view details");
			flag = true;
		} else {
			logger.info("Status of history screen not matched with view details");
			flag = false;
		}
		return flag;
	}
	public Boolean checkFilterBlockVisible() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "history.filter.block.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Filter is applied");
			return true;
		} else {
			logger.info("Filter has been removed");
			return false;
		}
	}
	
	public void printUploadId() throws IOException {
		logger.info("Upload ID: " + utility.initializeElement(LoginPage.driver, "history.table.columnfirst.uploadid.xpath").getText());
	}
}
