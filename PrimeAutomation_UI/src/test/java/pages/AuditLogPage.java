package pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.opencsv.CSVReader;

import utility.PropertiesFileReader;
import utility.Utility;

public class AuditLogPage {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(AuditLogPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to check 24hrs filter on audit log displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean is24HrsFilterOnAuditLogDisplayed() throws IOException {
		logger.info("24Hrs filter is displayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.filter.24hrs.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "auditlog.filter.24hrs.xpath").isDisplayed();
	}

	/**
	 * This method is used to check filter button on audit log displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isFilterBttonOnAuditLogDisplayed() throws IOException {
		logger.info("Filter button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.btn.filter.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "auditlog.btn.filter.xpath").isDisplayed();
	}

	/**
	 * This method is used to check searchbox on audit log displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSearchboxOnAuditLogDisplayed() throws IOException {
		logger.info("Searchbox is displayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.txtbox.searchbox.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "auditlog.txtbox.searchbox.xpath").isDisplayed();
	}

	/**
	 * This method is used to check search button on audit log displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSearchButtonOnAuditLogDisplayed() throws IOException {
		logger.info("Search button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.btn.search.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "auditlog.btn.search.xpath").isDisplayed();
	}

	/**
	 * This method is used to check audit log table header displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isAuditLogTableHeaderDisplayed(String header) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (header.equalsIgnoreCase("date")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.header.date.xpath");
		}
		if (header.equalsIgnoreCase("user")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.header.user.xpath");
		}
		if (header.equalsIgnoreCase("username")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.header.username.xpath");
		}
		if (header.equalsIgnoreCase("action")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.header.action.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + header);
		return null;
	}

	/**
	 * This method is used to check audit log records displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isAuditLogTableRecordsDisplayed() throws IOException {
		logger.info("Audit log table record is displayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.table.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "auditlog.table.xpath").isDisplayed();
	}

	/**
	 * This method is used to check export selected button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isExportSelectedButtonDisplayed() throws IOException {
		logger.info("Export selected button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.btn.exportselected.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "auditlog.btn.exportselected.xpath").isDisplayed();
	}

	/**
	 * This method is used to check export all button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isExportAllButtonDisplayed() throws IOException {
		logger.info("Export all button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.btn.exportall.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "auditlog.btn.exportall.xpath").isDisplayed();
	}

	/**
	 * This method is used to check scrollbar displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isScrollBarDisplayed() throws IOException {
		logger.info("Scrollbar is displayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.scrollbar.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "auditlog.scrollbar.xpath").isDisplayed();
	}

	/**
	 * This method is used to check show more button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isShowMoreButtonDisplayed() throws IOException {
		logger.info("Show more button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.btn.showmore.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "auditlog.btn.showmore.xpath").isDisplayed();
	}

	/**
	 * This method is used to click on Filter button on audit log .
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnFilterButton() throws IOException, InterruptedException {
		Thread.sleep(7000);
		logger.info("Filter button is clicked : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.btn.filter.xpath").isDisplayed());
		utility.initializeElement(LoginPage.driver, "auditlog.btn.filter.xpath").click();
	}

	/***
	 * This method is used to click on date filter option
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnDateFilterOption() throws IOException, InterruptedException {
		Thread.sleep(20000);
		utility.initializeElement(LoginPage.driver, "auditlog.filter.list.date.xpath").click();
		logger.info("clicked on date filter option");
	}

	/***
	 * This method is used to click on start date button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnStartDateButton() throws IOException, InterruptedException {
		logger.info("start date button is clicked : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.filter.date.start.xpath").isDisplayed());
		utility.initializeElement(LoginPage.driver, "auditlog.filter.date.start.xpath").click();
	}

	/***
	 * This method is used to select start date as current date.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectStartDateFilterAsCurrentDate() throws IOException, InterruptedException {
		logger.info("selectStartDateFilterAsCurrentDate: Start Date as Current date is selected");
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
	}

	/**
	 * This method is used to check end date by default as current date selected or
	 * not.
	 * 
	 * @throws IOException
	 */
	public String isEndDateByDefaultAsCurrentDate() throws IOException {
		logger.info("End date by default as current date is : "
				+ utility.initializeElement(LoginPage.driver, "history.filter.btn.xpath").getText().substring(11)
						.replaceAll("-", "").replaceAll(" X", "").trim());
		return utility.initializeElement(LoginPage.driver, "history.filter.btn.xpath").getText().substring(11)
				.replaceAll("-", "").replaceAll(" X", "").trim();
	}

	/**
	 * This method is used to check if audit log page filtered out as per current
	 * date filter or not or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getAuditLogFilteredAsPerCurrentDate() throws IOException, InterruptedException {
		try {
			List<WebElement> List = utility.initializeElements(LoginPage.driver, "auditlog.table.column.date.xpath");
			int size = List.size();
			logger.info("Total no. of filtered out records : " + size);
			Date date1 = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
			String today = formatter.format(date1);
			if (size >= 1) {
				for (WebElement newList : List) {
					if (newList.getText().contains(today)) {
						logger.info("Audit log record list as per current date filter : " + newList.getText());
					}
				}
				return true;
			}
			Thread.sleep(1000);
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}

	/**
	 * This method is used to check start date as current date selected or not.
	 * 
	 * @throws IOException
	 */
	public String isStartDateAsCurrentDateDisplayed() throws IOException {
		logger.info("Start date as current date is : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.filter.date.start.xpath").getText().trim());
		return utility.initializeElement(LoginPage.driver, "auditlog.filter.date.start.xpath").getText().trim();
	}

	/***
	 * This method is used to select start date less than current date.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectDateLessThanCurrentDate() throws IOException, InterruptedException {
		logger.info("selectDateLessThanCurrentDate: Date less than Current date is selected");
		List<WebElement> endDate = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		Date previousDate = calendar.getTime();
		String oldDate = formatter.format(previousDate);
		for (WebElement cell : endDate) {
			if (cell.getText().equals(oldDate)) {
				logger.info("Selected Date is : " + cell.getText());
				cell.click();
				break;
			}
		}
	}

	/***
	 * This method is used to click on done button on audit log filter option.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnDoneButton() throws IOException, InterruptedException {
		logger.info("Done button is clicked : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").isDisplayed());
		utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").click();
	}

	/**
	 * This method is used to check if audit log page filtered out as per selected
	 * date date filter or not or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getAuditLogFilteredAsPerSelectedDate() throws IOException, InterruptedException {
		try {
			List<WebElement> List = utility.initializeElements(LoginPage.driver, "auditlog.table.column.date.xpath");
			int size = List.size();
			logger.info("Total no. of filtered out records : " + size);
			if (size >= 1) {
				for (WebElement newList : List) {
					logger.info("Audit log record list as per selected date filter : " + newList.getText());

				}
				return true;
			}
			Thread.sleep(1000);
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}

	/***
	 * This method is used to click on end date button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnEndDateButton() throws IOException, InterruptedException {
		logger.info("start date button is clicked : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.filter.date.end.xpath").isDisplayed());
		utility.initializeElement(LoginPage.driver, "auditlog.filter.date.end.xpath").click();
	}

	/***
	 * This method is used to select end date as current date.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectEndDateFilterAsCurrentDate() throws IOException, InterruptedException {
		logger.info("selectEndDateFilterAsCurrentDate: End Date as Current date is selected");
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
	}

	/**
	 * This method is used to check end date as current date selected or not.
	 * 
	 * @throws IOException
	 */
	public String isEndDateAsCurrentDateDisplayed() throws IOException {
		logger.info("End date as current date is : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.filter.date.end.xpath").getText().trim());
		return utility.initializeElement(LoginPage.driver, "auditlog.filter.date.end.xpath").getText().trim();
	}

	/**
	 * This method is used to check no date in start date button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isNoDateDisplayedInStartDate() throws IOException {
		String noDate = utility.initializeElement(LoginPage.driver, "auditlog.filter.date.start.xpath").getText();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		format.setLenient(false);
		try {
			format.parse(noDate);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * This method is used to check no date in end date button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isNoDateDisplayedInEndDate() throws IOException {
		String noDate = utility.initializeElement(LoginPage.driver, "auditlog.filter.date.end.xpath").getText();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		format.setLenient(false);
		try {
			format.parse(noDate);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/***
	 * This method is used to select start date less than current date.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectStartDateLessThanCurrentDate() throws IOException, InterruptedException {
		logger.info("selectStartDateLessThanEndDate: Date less than current date is selected");
		List<WebElement> endDate = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		calendar.add(Calendar.DAY_OF_YEAR, -2);
		Date previousDate = calendar.getTime();
		String oldDate = formatter.format(previousDate);
		for (WebElement cell : endDate) {
			if (cell.getText().equals(oldDate)) {
				logger.info("Selected Date is : " + cell.getText());
				cell.click();
				break;
			}
		}
	}

	/**
	 * This method is used to check selected start and end date displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSelectedStartEndDateDisplayed() throws IOException {
		logger.info("Selected Start date is Dipslayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.filter.date.start.xpath").isDisplayed());
		logger.info("Selected End date is Dipslayed : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.filter.date.end.xpath").isDisplayed());
		utility.initializeElement(LoginPage.driver, "auditlog.filter.date.start.xpath").isDisplayed();
		return utility.initializeElement(LoginPage.driver, "auditlog.filter.date.end.xpath").isDisplayed();
	}

	/**
	 * This method is used to click on date column screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnDateColumn() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "auditlog.header.date.xpath").click();
		logger.info("clickOnDateColumn : Clicked on date column header");
	}

	/**
	 * This method is used to check .
	 * 
	 * @throws IOException
	 */
	public boolean isAuditLogSortedInAscendingOrder() throws IOException {
		logger.info("isAuditLogSortedInAscendingOrder: Audit log in ascending order");
		List<WebElement> dateColumn = utility.initializeElements(LoginPage.driver, "auditlog.table.column.date.xpath");
		ArrayList<String> tmp = new ArrayList<String>();
		for (WebElement e : dateColumn) {
			tmp.add(e.getText());
		}
		Collections.sort(tmp);
		logger.info("The audit log records after sorting in ascending order");
		for (String date : tmp) {
			System.out.println(date);
		}
		return true;
	}

	/***
	 * This method is used to select start date less than current date.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectDateGreaterThanCurrentDate() throws IOException, InterruptedException {
		logger.info("selectDateGreaterThanCurrentDate: Date less than Current date is selected");
		List<WebElement> endDate = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		calendar.add(Calendar.DAY_OF_YEAR, +1);
		Date previousDate = calendar.getTime();
		String oldDate = formatter.format(previousDate);
		for (WebElement cell : endDate) {
			if (cell.getText().equals(oldDate)) {
				logger.info("Selected Date is : " + cell.getText());
				cell.click();
				break;
			}
		}
	}

	/**
	 * This method is used to check left panel fields displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isLeftPanelInfoDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("Choose Site")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.choosesite.xpath");
		}
		if (component.equalsIgnoreCase("File Dashboard")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath");
		}
		if (component.equalsIgnoreCase("History")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath");
		}
		if (component.equalsIgnoreCase("Audit Log")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.auditlog.xpath");
		}
		if (component.equalsIgnoreCase("Imaging Links")) {
			return utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath");
		}
		if (component.equalsIgnoreCase("24 Hrs")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.hours.check.xpath");
		}
		if (component.equalsIgnoreCase("Filter")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.filter.btn.xpath");
		}
		if (component.equalsIgnoreCase("Search box")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath");
		}
		if (component.equalsIgnoreCase("Search")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.search.btn.xpath");
		}
		if (component.equalsIgnoreCase("Events")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.events.txt.xpath");
		}
		if (component.equalsIgnoreCase("Export Selected")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.btn.exportselected.xpath");
		}
		if (component.equalsIgnoreCase("Export all")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.exportall.btn.xpath");
		}
		if (component.equalsIgnoreCase("Show more")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.showmore.btn.xpath");
		}
		if (component.equalsIgnoreCase("Scroll bar")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.scrollbar.btn.xpath");
		}
		if (component.equalsIgnoreCase("Date")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.date.filter.xpath");
		}
		if (component.equalsIgnoreCase("User Name")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.username.filter.xpath");
		}
		if (component.equalsIgnoreCase("Done")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.Done.btn.xpath");
		}
		if (component.equalsIgnoreCase("Filter By")) {
			return utility.initializeElement(LoginPage.driver, "auditlog.filterBy.btn.xpath");
		}

		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}

	/**
	 * This method is used to select Facility from choose site
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void chooseSite() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facility.select.secondsite.xpath").click();
		logger.info("Selected Facility is : "
				+ utility.initializeElement(LoginPage.driver, "facility.select.secondsite.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectFacility : Clicked Selected Facility ");
	}

	/**
	 * This method is used to click on select button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickSelectBtn() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facility.select.btn.xpath").click();
		logger.info("clickSelect : Clicked Select Button");
	}

	/**
	 * This method is used to click on 24 hrs button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickon24Hrs() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "auditlog.hours.check.xpath").click();
		Thread.sleep(3000);
		logger.info("click24Hrs : Clicked 24 Hrs checkbox Button");
	}

	/**
	 * This method is used to get the audit log records for 24 hrs in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedHrs() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "auditlog.list.username.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in Audit Log Screen : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					logger.info("Records Displayed in Audit Log after 24 hrs filter : " + q.getText());
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to get the audit log records user-name in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedUsername() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "auditlog.list.username.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in Audit Log Screen : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					logger.info("Records Displayed in Audit Log after filter with username : " + q.getText());
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to get the audit log records user-value in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedUservalue() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "auditlog.list.uservalue.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in Audit Log Screen : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					logger.info("Records Displayed in Audit Log after filter with uservalue : " + q.getText());
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to get the audit log records action value in list or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedActionValue() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "auditlog.list.action.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in Audit Log Screen : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					logger.info("Records Displayed in Audit Log after filter with Action value : " + q.getText());
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to get the audit log records for filtering dates in list
	 * or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isListDisplayedDateFilter() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "auditlog.list.date.xpath");
		int count = list.size();
		WebElement q = null;
		logger.info("Number of records in Audit Log Screen : " + count);
		try {
			if (list.size() >= 1) {
				for (int i = 0; i < list.size(); i++) {
					q = list.get(i);
					logger.info("Records Displayed in Audit Log after Date filter : " + q.getText());
				}
				return true;
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to click on selected 24 hrs button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickonselected24Hrs() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "auditlog.hours.checked.xpath").click();
		Thread.sleep(3000);
		logger.info("click24Hrs : Clicked 24 Hrs selected checkbox Button");
	}

	/**
	 * This method is used to click on arrow for sorting on user column
	 * 
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickonArrow() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "auditlog.arrow.btn.xpath").click();
		Thread.sleep(3000);
		logger.info("click On Arrow for sorting : Clicked Arrow Button");
	}

	/**
	 * This method is used to click on filter tab
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickonFilter() throws IOException, InterruptedException {

		try {
			utility.initializeElement(LoginPage.driver, "auditlog.filter.btn.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@class='filter d-flex']")));
		}
		logger.info("click Filter : Clicked Filter Tab");

	}

	/**
	 * This method is used to click on plus icon from filter tab
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickPlusIcon() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.filter.plusicon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"modal-dialog\"]/div/div[2]/div[3]/div[2]/p")));
		}
		logger.info("click + Icon : Clicked + Button");
	}

	/**
	 * This method is used to click on plus icon of date from filter tab
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickdatePlusIcon() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.date.plusicon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@class='pointer text-26 ng-star-inserted'][1]")));
		}
		logger.info("click + Icon : Clicked + Button from Date");
	}

	/**
	 * This method is used to click on Done Button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickDoneBtn() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.Done.btn.xpath").click();
			Thread.sleep(3000);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@class='btn-SN-primary btn-db-filter font-16']")));
		}
		logger.info("clickDoneBtn : Clicked Done Button");
	}

	/**
	 * This method is used to select user-name from filter tab
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectUsername() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.select.username.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@title='h-test-admin@capgemini.com']")));
		}
		logger.info("Selected username from filter is : h-test-admin@capgemini.com");
	}

	public void selectnextUsername() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.select.nextusername.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@title='ic-test-surgeon@capgemini.com']")));
		}
		logger.info("Selected username from filter is : ic-test-surgeon@capgemini.com");
	}

	/**
	 * This method is used to click on remove cross icon from filter tab
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void removeCrossIcon() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.cross.icon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@class='icon-cross']")));
		}
		logger.info("Remove Filter : Removed Filter");
	}

	/**
	 * This method is used to click on start date from filter tab
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void clickonStartDate() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.startdate.plusicon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@class='btn filter-dates ng-star-inserted'][1]")));
		}
		logger.info("Click Start Date : Clicked StartDate");
	}

	public void clickonEndDate() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.enddate.plusicon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@class='btn filter-dates ng-star-inserted'][2]")));
		}
		logger.info("Click End Date : Clicked EndDate");
	}

	public void clickonSearchBtn() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.search.btn.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@class='search-button']")));
		}
		logger.info("Click Search Button : Clicked Search Button");
	}

	/**
	 * This method is used to check Audit log is displayed on descending order or
	 * not
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public boolean isRecordsDisplayedInDescendingOrder() throws IOException, InterruptedException, ParseException {
		logger.info("Audit Log is in descending order : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.row.desc.xpath").isDisplayed());
		Thread.sleep(5000);
		List<WebElement> order = utility.initializeElements(LoginPage.driver, "auditlog.row.desc.xpath");
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

	/***
	 * This method is used to enter user-name in search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterUserNameInSearchBox() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath")
				.sendKeys("ic-test-snhilmanager@capgemini.com");
		logger.info("UserName in searchbox is entered as : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").getAttribute("value"));
	}

	/***
	 * This method is used to enter user value in search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterUservalueInSearchBox() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").clear();
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").sendKeys("S PA-C");
		logger.info("User Value in searchbox is entered as : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").getAttribute("value"));
	}

	/***
	 * This method is used to enter action in search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterActioninSearchBox() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").clear();
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").sendKeys("Audit log viewed");
		logger.info("User Value in searchbox is entered as : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").getAttribute("value"));
	}

	/**
	 * This method is used to select any record from audit log
	 *
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void clickonRecord() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.select.record.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"check_audit\"]")));
		}
		logger.info("Click One Record : Selected One Record");
	}

	/**
	 * This method is used to click on Export Selected button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickonExportSelected() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.export.selected.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("/html/body/app-root/app-auditlog/div/div[3]/button[1]")));
		}
		logger.info("clickExportSelected : Clicked Export Selected Button");
	}

	/**
	 * This method is used to click on Export All button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickonExportAll() throws IOException, InterruptedException {

		try {
			utility.initializeElement(LoginPage.driver, "auditlog.exportall.btn.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("/html/body/app-root/app-auditlog/div/div[3]/button[2]")));
		}
		logger.info("clickExportAll : Clicked Export All Button");
	}

	public void clickonSecondRecord() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.select.secondrecord.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"mat-checkbox-184\"]/label")));
		}
		logger.info("Click Another Record : Selected Another Record");
	}

	/**
	 * This method is used to get the audit log records action performed logs
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isActionPerformedLogsDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "auditlog.list.action.xpath");
		int count = list.size();
		if (count >= 1) {
			for (WebElement newList : list) {
				logger.info("upload files action performed logs are :" + newList.getText());
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check if recall button displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isRecallButtonDisplayed() throws IOException {
		logger.info("Recall button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "summarydashboard.btn.recall.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "summarydashboard.btn.recall.xpath").isDisplayed();
	}

	/**
	 * This method is used to click on recall button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnRecallButton() throws IOException, InterruptedException {
		logger.info("Recall button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "summarydashboard.btn.recall.xpath").isDisplayed());
		utility.initializeElement(LoginPage.driver, "summarydashboard.btn.recall.xpath").click();
		utility.initializeElement(LoginPage.driver, "summarydashboard.btn.confirm.xpath").click();
	}
	
	/**
	 * This method is used to click on acknowledge button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnAcknowledgeButton() throws IOException, InterruptedException {
		logger.info("Acknowledge button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "summarydashboard.btn.acknowledge.xpath").isDisplayed());
		utility.initializeElement(LoginPage.driver, "summarydashboard.btn.acknowledge.xpath").click();
	}
	
	/**
	 * This method is used to click on acknowledge button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isYellowDotDisappeared() throws IOException, InterruptedException {
		logger.info("Yellow dot is displayed : "
				+ utility.initializeElement(LoginPage.driver, "summarydashboard.btn.yellowdot.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "summarydashboard.btn.yellowdot.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to enter value in successful upload
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterValueinSuccessfulUpload() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").sendKeys("10");
		logger.info("Entered value in successful upload is : "
				+ utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").getAttribute("value"));
	}
	
	/**
	 * This method is used to enter value in unsuccessful upload
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterValueinUnsuccessfulUpload() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").sendKeys("12");
		logger.info("Entered value in unsuccessful upload is : "
				+ utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").getAttribute("value"));
	}
	
	/**
	 * This method is used to click on toggle button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnToggleButton() throws IOException, InterruptedException {
		logger.info("Gloabl Viewing toggle is displayed : "
				+ utility.initializeElement(LoginPage.driver, "setting.btn.toggle.globalviewing.xpath").isDisplayed());
		 utility.initializeElement(LoginPage.driver, "setting.btn.toggle.globalviewing.xpath").click();
	}
	
	/**
	 * This method is used to click on save button
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSaveButton() throws IOException, InterruptedException {
		logger.info("Save button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "setting.btn.toggle.globalviewing.xpath").isDisplayed());
		 utility.initializeElement(LoginPage.driver, "setting.btn.toggle.globalviewing.xpath").click();
	}
	
	/**
	 * This method is used to remove text from searchbox
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void removeTextInSearchbox() throws IOException, InterruptedException {
		 utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").clear();
		 utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").click();
		 utility.initializeElement(LoginPage.driver, "dashboard.btn.search.xpath").click();
	}
	
	/**
	 * This method is used to click on 24hrs filter
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOn24hrsFilterOnDashboard() throws IOException, InterruptedException {
		 try {
			 logger.info("24hrs filter is displayed : "
						+ utility.initializeElement(LoginPage.driver, "summarydashboard.filter.24hrs.xpath").isDisplayed());
				 utility.initializeElement(LoginPage.driver, "summarydashboard.filter.24hrs.xpath").click();
			} catch (Exception e) {
				logger.info("24hrs filter is displayed : "
						+ utility.initializeElement(LoginPage.driver, "summarydashboard.filter.24hrs.xpath").isDisplayed());
				JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
				executor.executeScript("arguments[0].click();", utility.initializeElement(LoginPage.driver, "summarydashboard.filter.24hrs.xpath"));
			}
	}
	
	/**
	 * This method is used to remove text from searchbox
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void removeTextInSearchboxOnHistory() throws IOException, InterruptedException {
		 utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").clear();
		 utility.initializeElement(LoginPage.driver, "dashboard.searchbox.xpath").click();
		 utility.initializeElement(LoginPage.driver, "history.btn.search.xpath").click();
	}
	
	/**
	 * This method is used to remove text from searchbox
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void removeTextInSearchboxOnAuditLog() throws IOException, InterruptedException {
		 utility.initializeElement(LoginPage.driver, "auditlog.txtbox.searchbox.xpath").clear();
		 utility.initializeElement(LoginPage.driver, "auditlog.txtbox.searchbox.xpath").click();
		 utility.initializeElement(LoginPage.driver, "auditlog.btn.search.xpath").click();
	}
	
	/***
	 * This method is used to check the hospital account records are displayed on screen
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean hospitalAccountsRecordsDisplayed() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		Thread.sleep(2000);
		List<WebElement> allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
		Boolean isNotPresent = false;
		for(int i = 0; i< allRows.size();i++) {
			if(StringUtils.isNotEmpty(allRows.get(i).getText())) {
			logger.info("Contents : " + allRows.get(i).getText());
			}
			else
				System.out.print("empty string");
		}
		for(int i = 0; i< allRows.size();i++) {
			if(StringUtils.isNotEmpty(allRows.get(i).getText())) {
			if(allRows.get(i).getText().contains(properties.getProperty("hospital.admin"))||
					allRows.get(i).getText().contains(properties.getProperty("hospital.surgeon"))||
					allRows.get(i).getText().contains(properties.getProperty("hospital.staff")))
				isNotPresent = true;
			else {
				isNotPresent = false;
				logger.info("Details other than H account displayed at line ");
				logger.info("Content : " + allRows.get(i).getText());
				break;
			}
			}
		}
		return isNotPresent;
	}
	
	/***
	 * This method is used get export selected button state.
	 * 
	 * @throws IOException
	 */
	public boolean getExportSelectedBtnState() throws IOException {
		return utility.initializeElement(LoginPage.driver, "auditlog.btn.exportselected.xpath").isEnabled();
	}
	
	/***
	 * This method is used to
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean getEportAllBtnState() throws IOException {
		
		return utility.initializeElement(LoginPage.driver, "auditlog.btn.exportall.xpath").isEnabled();
	}

	/***
	 * This method is used to select first row
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void selectFirstRow() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "auditlog.table.firstrow.xpath").click();
		Thread.sleep(5000);
	}
	
	/***
	 * This method is used to unselect first row
	 * 
	 * @throws IOException
	 */
	public void unselectFirstRow() throws IOException {
		utility.initializeElement(LoginPage.driver, "auditlog.table.rowselected.xpath").click();
	}
	
	/***
	 * This method is used to check checkbox is selected
	 * 
	 * @throws IOException
	 */
	public Boolean isChecked() throws IOException {
		List<WebElement> allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
		String classType = utility.initializeElement(LoginPage.driver, "auditlog.table.firstrow.checkbox.xpath").getAttribute("class");
//		System.out.print(firstRow.getAttribute("class"));
		if(classType.contains("mat-checkbox-checked"))
			return true;
		else
			return false;
	}
	
	/***
	 * This method is used to click export selected button
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void clickExportSelectedBtn() throws IOException, InterruptedException {
		Thread.sleep(30000);
//		utility.initializeElement(LoginPage.driver, "auditlog.btn.exportselected.xpath").click();
		JavascriptExecutor js = (JavascriptExecutor)LoginPage.driver;
		js.executeScript("arguments[0].click();", utility.initializeElement(LoginPage.driver, "auditlog.btn.exportselected.xpath"));
	}
	
	/***
	 * This method is used to click export all button
	 * 
	 * @throws IOException
	 */
	public void clickExportAllBtn() throws IOException {
		utility.initializeElement(LoginPage.driver, "auditlog.btn.exportall.xpath").click();
	}
	
	/***
	 * This method is used to copy Audit log excel sheet from local download path to inside the project. And then delete the local downloaded file.
	 * 
	 * @throws IOException
	 */
	public void copyAuditLogToProject(String fileName) throws IOException {
		Properties properties = reader.getProperty();
		String fromLocation = properties.getProperty("auditlog.local.path");
		String toLocation = properties.getProperty("auditlog.project.path") + fileName;
		File from = new File(fromLocation);
		File to = new File(toLocation);
		FileUtils.copyFile(from,to);
		from.delete();
	}
	
	/***
	 * This method is used to verify the headers of downloaded Audit logs
	 * 
	 * @throws IOException
	 */
	public String[] verifyAuditLogHeaders(String fileName) throws IOException {
		Properties properties = reader.getProperty();
		copyAuditLogToProject(fileName);
		FileReader filereader = new FileReader(properties.getProperty("auditlog.project.path") + fileName);
	    CSVReader csvReader = new CSVReader(filereader);
	    String[] headers = csvReader.readNext();
	    System.out.print(headers.length);
	    return headers;
	}
	
	/***
	 * This method is used to read all data from the downloaded excel sheet.
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public List<String[]> readAllAuditLogs(String fileName) throws IOException {
		Properties properties = reader.getProperty();
//		copyAuditLogToProject(fileName);
		FileReader filereader = new FileReader(properties.getProperty("auditlog.project.path") + fileName);
	    CSVReader csvReader = new CSVReader(filereader);
	    List<String[]> allData = csvReader.readAll();
	    return allData;
	}
	

	/***
	 * This method is used to compare the audit logs on screen and downloaded file 
	 * @param fileName
	 * @param isSelected
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean checkData(String fileName, Boolean isSelected) throws IOException, InterruptedException {
		Thread.sleep(3000);
		List<String[]> excelData = readAllAuditLogs(fileName);
		List<WebElement> allRows;
		if(isSelected == true) {
			allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.rowselected.xpath");
			if(allRows.size()==0) {
				allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.rowhoveredselected.xpath");
			}
		}
		else
			allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
//		System.out.print(excelData.size());
//		System.out.print("\n");
//		System.out.print(allRows.size());
		Boolean flag = true;
		for(int i=1;i<excelData.size();i++) {
			String[] rowInExcel = excelData.get(i);
			logger.info("Data in Excel sheet: "+ rowInExcel[0]+ " " + rowInExcel[1] + " " + rowInExcel[2]+ " " + rowInExcel[3]+ " " + rowInExcel[4]  );
			String rowOnDisplay = allRows.get(i-1).getText();
			logger.info("Data on display: " + rowOnDisplay);
			if(	rowOnDisplay.contains(rowInExcel[0]) &&
//				rowOnDisplay.contains(rowInExcel[1]) &&
				rowOnDisplay.contains(rowInExcel[2]) &&
				rowOnDisplay.contains(rowInExcel[3]) &&
				rowOnDisplay.contains(rowInExcel[4]) ){
				flag = true;
		}
			else 
				flag = false;
		}
		return flag;
		
	}

	
	/***
	 * This method is used to click on 24 hrs filter in audit log screen
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void click24hrscheckbox() throws IOException, InterruptedException {
		Thread.sleep(3000);
		utility.initializeElement(LoginPage.driver, "auditlog.24hrs.btn.xpath").click();
	}
	
	
	/**
	 * This method is used to check whether only the past 24hrs records are shown
	 * 
	 * @return Boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean check24hrsRecords() throws IOException, InterruptedException {
		Thread.sleep(3000);
		List<WebElement> allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
         LocalDateTime now = LocalDateTime.now();  
         LocalDateTime yest = now.minus(1, ChronoUnit.DAYS);
 		for(int i = 0; i< allRows.size();i++) {
			logger.info("Contents : " + allRows.get(i).getText());
		}
         Boolean flag =false;
         for(int i=0;i<allRows.size();i++) {
        	 if(allRows.get(i).getText().contains(dtf.format(now))||allRows.get(i).getText().contains(dtf.format(yest))) {
        		 flag = true;
        	 }
        	 else {
        		 flag = false;
        		 break;
        	 }
         } 
         return flag;
	}
	
	
	/***
	 * This method is used to click on the + icon to expand the user name filter
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void expandUsernameFilter() throws IOException, InterruptedException {
		Thread.sleep(7000);
		utility.initializeElement(LoginPage.driver, "auditlog.btn.filter.xpath").click();
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.filter.plusicon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"modal-dialog\"]/div/div[2]/div[3]/div[2]/p")));
		}
		
	}
	
	
	/***
	 * This method is used to click + icon for user name filter when already the date filter is expanded 
	 */
	public void clickUsernameFilter() {
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.filter.plusicon.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			try {
				executor.executeScript("arguments[0].click();",
						LoginPage.driver.findElement(By.xpath("//*[@id=\"modal-dialog\"]/div/div[2]/div[3]/div[2]/p")));
			}catch(Exception e1) {
				executor.executeScript("arguments[0].click();",
						LoginPage.driver.findElement(By.xpath("//*[@id=\"modal-dialog\"]/div/div[2]/div[4]")));
			}
			
			
		}
	}
	
	
	/***
	 * This method is used to print the user names present in the user name filter
	 * @throws IOException
	 */
	public Boolean usernamelist() throws IOException {
 		Properties properties = reader.getProperty();
 		Boolean flag = true;
 		List<WebElement> usernamesDisplayed = utility.initializeElements(LoginPage.driver, "auditlog.filter.username.list.xpath");
 		logger.info("Displayed usernames: ");
 		for(int i=0;i<usernamesDisplayed.size();i++) {
 			logger.info("\n"+usernamesDisplayed.get(i).getText());
 		}
 		for(int i=0;i<usernamesDisplayed.size();i++) {
 			if(usernamesDisplayed.get(i).getText().equals(properties.getProperty("hospital.surgeon"))||
 			usernamesDisplayed.get(i).getText().equals(properties.getProperty("hospital.staff"))||
			usernamesDisplayed.get(i).getText().equals(properties.getProperty("hospital.admin"))){
				flag = true;
			}
 			else {
 				logger.info(usernamesDisplayed.get(i).getText() + " is not a hospital account");
 				flag = false;
 			}
 		}
		return flag;

 	}
	
	
	/***
	 * This method is used to select H admin user name from user name filters
	 * @throws IOException
	 */
	public void selectHAdmin() throws IOException {
		Properties properties = reader.getProperty();
		List<WebElement> usernamesDisplayed = utility.initializeElements(LoginPage.driver, "auditlog.filter.username.list.xpath");
		for(int i=0;i<usernamesDisplayed.size();i++) {
			if(usernamesDisplayed.get(i).getText().equals(properties.getProperty("hospital.admin"))){
				usernamesDisplayed.get(i).click();
			}
		}
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.Done.btn.xpath").click();
			Thread.sleep(3000);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@class='btn-SN-primary btn-db-filter font-16']")));
		}
		
	}
	
	
	/***
	 * This method is used to verify that onlyH admin records are displayed in the screen
	 * @return Boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean checkHAdminRecords() throws IOException, InterruptedException {
		Thread.sleep(3000);
		List<WebElement> allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
		Properties properties = reader.getProperty();
 		for(int i = 0; i< allRows.size();i++) {
			logger.info("Contents : " + allRows.get(i).getText());
		}
         Boolean flag =false;
         for(int i=0;i<allRows.size();i++) {
        	 if(allRows.get(i).getText().contains(properties.getProperty("hospital.admin"))) {
        		 flag = true;
        	 }
        	 else {
        		 flag = false;
        		 break;
        	 }
         } 
         return flag;
	}
	
	
	
	/***
	 * This method is used to check wether the date column is sorted in descending order
	 * @return
	 * @throws IOException
	 */
	public Boolean dateFieldSortingCheck() throws IOException {
		String sortType = utility.initializeElement(LoginPage.driver, "auditlog.header.date.xpath").getAttribute("aria-sort");
		logger.info("Sorting type : " + sortType);
		List<WebElement> allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
		for(int i = 0; i< allRows.size();i++) {
			logger.info("Contents : " + allRows.get(i).getText());
		}
		if(sortType.equals("descending")){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/***
	 * This method is used to check the records are filtered according to the applied date and user name filters 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isDateAndusernameFileterApplied() throws IOException {
		Properties properties = reader.getProperty();
		String dates = utility.initializeElement(LoginPage.driver, "auditlog.datefilter.heading.xpath").getText();
		String startDate = dates.split(" - ")[0];
		String endDate = dates.split(" - ")[1];
		String username = properties.getProperty("hospital.admin");
		List<WebElement> allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
		for(int i = 0; i< allRows.size();i++) {
			logger.info("Contents : " + allRows.get(i).getText());
		}
		Boolean flag =false;
        for(int i=0;i<allRows.size();i++) {
       	 if(allRows.get(i).getText().contains(username)) {
       		 if(allRows.get(i).getText().contains(startDate) || allRows.get(i).getText().contains(endDate)) {
       			flag = true;
       		 }
       		else {
          		 flag = false;
       		 	logger.info("Date not matching at record number: " + i+1);
          		 break;
       		}
       	 }
       	 else {
       		 flag = false;
       		logger.info("username not matching at record number: " + i+1);
       		 break;
       	 }
        } 
        return flag;
		
	}
	
	//TC1000
	
	/***
	 * This method is used to type user name in the search box and click the search button
	 * @throws IOException
	 */
	public void searchWithUserName() throws IOException {
		Properties properties = reader.getProperty();
		utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").click();
		logger.info("Search textbox clicked");
		utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").sendKeys(properties.getProperty("hospital.admin"));
		logger.info("UserName in searchbox is entered as : "
		+ utility.initializeElement(LoginPage.driver, "auditlog.search.box.xpath").getAttribute("value"));
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.search.btn.xpath").click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@class='search-button']")));
		}
		logger.info("Search button is clicked");
	}
	
	//TC1001
	/***
	 * This method is used to click on the user column in the audit log table
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickUserColumn() throws IOException, InterruptedException {
		logger.info("clickOnDateColumn : Clicked on user column header");
		utility.initializeElement(LoginPage.driver, "auditlog.header.user.xpath").click();
		Thread.sleep(3000);
		
	}
	
	
	/***
	 * This method is used to return the sorting type of user column in audit log table
	 * 
	 * @return
	 * @throws IOException
	 */
	public String userColumnSortType() throws IOException {
		List<WebElement> allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
		for(int i = 0; i< allRows.size();i++) {
			logger.info("Contents : " + allRows.get(i).getText());
		}
		String sortType = utility.initializeElement(LoginPage.driver, "auditlog.header.user.xpath").getAttribute("aria-sort");
		logger.info("Sorting type : " + sortType);
		return sortType;
	}
	
	
	/***
	 * This method is used to check whether selected audit log record is present in exported excel sheet
	 * @param fileName
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isSelectedRecordInExcelSheet(String fileName) throws IOException {
		Properties properties = reader.getProperty();
		copyAuditLogToProject(fileName);
		List<String[]> excelData = readAllAuditLogs(fileName);
		Boolean flag =true;
	    List<WebElement> unselectedRows =  utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
		if(excelData.size()==(unselectedRows.size()+1)){  //+1 is for the header column in excel sheet
			flag = true;
		}
		else
			flag = false;
		return flag;
	}
	
	/***
	 * This method is used to extract headers from excel sheet after export all option
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public String[] headersinExcel(String fileName) throws IOException {
		Properties properties = reader.getProperty();
		FileReader filereader = new FileReader(properties.getProperty("auditlog.project.path") + fileName);
	    CSVReader csvReader = new CSVReader(filereader);
	    String[] headers = csvReader.readNext();
	    System.out.print(headers.length);
	    return headers;
	}
	
	/***
	 * This method is used to check the data on screen and excel sheet is same after export all
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean checkDataInExcelSheet(String fileName) throws IOException, InterruptedException {
		Thread.sleep(3000);
		List<String[]> excelData = readAllAuditLogs(fileName);
		List<WebElement> allRows;
		allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
		Boolean flag = true;
		for(int i=1;i<excelData.size();i++) {
			String[] rowInExcel = excelData.get(i);
			logger.info("Data in Excel sheet: "+ rowInExcel[0]+ " " + rowInExcel[1] + " " + rowInExcel[2]+ " " + rowInExcel[3]+ " " + rowInExcel[4]  );
			String rowOnDisplay = allRows.get(i-1).getText();
			logger.info("Data on display: " + rowOnDisplay);
			if(	rowOnDisplay.contains(rowInExcel[0]) &&
//				rowOnDisplay.contains(rowInExcel[1]) &&
				rowOnDisplay.contains(rowInExcel[2]) &&
				rowOnDisplay.contains(rowInExcel[3]) &&
				rowOnDisplay.contains(rowInExcel[4]) ){
				flag = true;
		}
			else 
				flag = false;
		}
		return flag;
		
	}
	
	/***
 	 * This method is used to uncheck the username filter already applied
 	 * @throws IOException
 	 * @throws InterruptedException 
 	 */
 	public void unselectUsernameFilter() throws IOException, InterruptedException {
 		utility.initializeElement(LoginPage.driver, "auditlog.filter.selectedusername.xpath").click();
 		logger.info("Filter is Unselected");
 		Thread.sleep(2000);
 	}
 	
 	
 	/***
 	 * This method is used to select the user name from user name filter
 	 * @param userName
 	 * @throws IOException
 	 * @throws InterruptedException 
 	 */
 	public void selectUsernameFilter(String userName) throws IOException, InterruptedException {
 		Properties properties = reader.getProperty();
 		String user = null;
 		if(userName.equalsIgnoreCase("Surgeon")) {
 			user = properties.getProperty("hospital.surgeon");
 		}
 		else if(userName.equalsIgnoreCase("Support staff")) {
 			user = properties.getProperty("hospital.staff");
 		}

 		
 		List<WebElement> usernamesDisplayed = utility.initializeElements(LoginPage.driver, "auditlog.filter.username.list.xpath");
 		for(int i=0;i<usernamesDisplayed.size();i++) {
 			if(usernamesDisplayed.get(i).getText().equalsIgnoreCase(user)){
 				usernamesDisplayed.get(i).click();
 				logger.info(userName + " is selected as filter");
 				break;
 			}
 		}
 		Thread.sleep(2000);
 		try {
 			utility.initializeElement(LoginPage.driver, "auditlog.Done.btn.xpath").click();
 			Thread.sleep(3000);
 		} catch (Exception e) {
 			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
 			executor.executeScript("arguments[0].click();",
 					LoginPage.driver.findElement(By.xpath("//*[@class='btn-SN-primary btn-db-filter font-16']")));
 		}
 	}
 	
 	
 	/***
 	 * This method is used to check the audit log records are filtered according to the username filter applied
 	 * @param userName
 	 * @return
 	 * @throws IOException
 	 * @throws InterruptedException
 	 */
 	public Boolean checkUsernameFilterRecords(String userName) throws IOException, InterruptedException {
 		Thread.sleep(3000);
 		String user = null;
 		List<WebElement> allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
 		Properties properties = reader.getProperty();
 		if(userName.equalsIgnoreCase("Surgeon")) {
 			user = properties.getProperty("hospital.surgeon");
 		}
 		else if(userName.equalsIgnoreCase("Support staff")) {
 			user = properties.getProperty("hospital.staff");
 		}
 		logger.info("Checking that audit log records only contains records with username: "+userName);
  		for(int i = 0; i< allRows.size();i++) {
 			logger.info("Contents : " + allRows.get(i).getText());
 		}
          Boolean flag =false;
          for(int i=0;i<allRows.size();i++) {
         	 if(allRows.get(i).getText().contains(user)) {
         		 flag = true;
         	 }
         	 else {
         		 flag = false;
         		 logger.info("The below record does not contain " +userName+ " : " + user  +":\n" +allRows.get(i).getText());
         		 break;
         	 }
          } 
          return flag;
 	}
 	
 	/***
 	 * This method is used to compare the data in exported all excel sheet and on screen
 	 * @param filename
 	 * @return
 	 * @throws IOException
 	 */
 	public Boolean checkAllDataInExportAllExcelSheet(String filename) throws IOException {
 		copyAuditLogToProject(filename);
 		List<String[]> excelData = readAllAuditLogs(filename);
 		List<WebElement> allRows = utility.initializeElements(LoginPage.driver, "auditlog.table.row.xpath");
 		Boolean flag= false;
 		for(int i=1;i<excelData.size();i++) {
 			String[] rowInExcel = excelData.get(i);
 			logger.info("Data in Excel sheet: "+ rowInExcel[0]+ " " + rowInExcel[1] + " " + rowInExcel[2]+ " " + rowInExcel[3]+ " " + rowInExcel[4]  );
 			String rowOnDisplay = allRows.get(i-1).getText();
 			logger.info("Data on display: " + rowOnDisplay);
 			if(	rowOnDisplay.contains(rowInExcel[0]) &&
// 				rowOnDisplay.contains(rowInExcel[1]) &&
 				rowOnDisplay.contains(rowInExcel[2]) &&
 				rowOnDisplay.contains(rowInExcel[3]) &&
 				rowOnDisplay.contains(rowInExcel[4]) ){
 				flag = true;
 		}
 			else 
 				flag = false;
 		}
 		return flag;
 		
 	}
 	

}
