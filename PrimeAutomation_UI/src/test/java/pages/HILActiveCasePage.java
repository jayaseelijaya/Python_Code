package pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;

import utility.PropertiesFileReader;
import utility.Utility;

public class HILActiveCasePage {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HILActiveCasePage.class);
	Utility utility = new Utility();
	
	/**
	 * This method is used to check active cases displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isActiveCasesDisplayed() throws IOException {
		logger.info("Active Cases is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.link.activecases.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.link.activecases.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check case history displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isCaseHistoryDisplayed() throws IOException {
		logger.info("Case History is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.link.casehistory.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.link.casehistory.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check new case filter displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isNewCaseFilterDisplayed() throws IOException {
		logger.info("New Case filter is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.filter.newcase.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.filter.newcase.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to click on New Case Filter.
	 * 
	 * @throws IOException
	 */
	public void clickOnNewCaseFilter() throws IOException {
		logger.info("New Case filter is clicked : "
				+ utility.initializeElement(LoginPage.driver, "activecases.filter.newcase.xpath").isDisplayed());
		 utility.initializeElement(LoginPage.driver, "activecases.filter.newcase.xpath").click();
	}
	
	/**
	 * This method is used to check claimed by you filter displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isClaimedByYouFilterDisplayed() throws IOException {
		logger.info("Claimed By You filter is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.filter.claimedbyyou.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.filter.claimedbyyou.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to click on claimed by you filter.
	 * 
	 * @throws IOException
	 */
	public void clcikOnClaimedByYouFilter() throws IOException {
		logger.info("Claimed By You filter is clciked : "
				+ utility.initializeElement(LoginPage.driver, "activecases.filter.claimedbyyou.xpath").isDisplayed());
		 utility.initializeElement(LoginPage.driver, "activecases.filter.claimedbyyou.xpath").click();
	}
	
	/**
	 * This method is used to check overdue cases filter displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isOverdueCasesFilterDisplayed() throws IOException {
		logger.info("Overdue cases filter is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.filter.overduecases.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.filter.overduecases.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to click overdue cases filter.
	 * 
	 * @throws IOException
	 */
	public void clickOnOverdueCasesFilter() throws IOException {
		logger.info("Overdue cases filter is clicked : "
				+ utility.initializeElement(LoginPage.driver, "activecases.filter.overduecases.xpath").isDisplayed());
		 utility.initializeElement(LoginPage.driver, "activecases.filter.overduecases.xpath").click();
	}
	
	/**
	 * This method is used to check 24hrs filter displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean is24HrsFilterDisplayed() throws IOException {
		logger.info("24Hrs filter is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.filter.24hrs.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.filter.24hrs.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to click on 24hrs filter displayed or not.
	 * 
	 * @throws IOException
	 */
	public void clickOn24HrsFilterDisplayed() throws IOException {
		logger.info("24Hrs filter is clicked : "
				+ utility.initializeElement(LoginPage.driver, "activecases.filter.24hrs.xpath").isDisplayed());
		 utility.initializeElement(LoginPage.driver, "activecases.filter.24hrs.xpath").click();
	}
	
	/**
	 * This method is used to check filter displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isFilterDisplayed() throws IOException {
		logger.info("Filter is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.filter.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.filter.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to click on filter.
	 * 
	 * @throws IOException
	 */
	public void clickOnFilter() throws IOException {
		logger.info("Filter is clicked : "
				+ utility.initializeElement(LoginPage.driver, "activecases.filter.xpath").isDisplayed());
		 utility.initializeElement(LoginPage.driver, "activecases.filter.xpath").click();
	}
	
	/**
	 * This method is used to check Filter menu options displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isFilterMenuDisplayed(String menu) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (menu.equalsIgnoreCase("anatomy")) {
			logger.info("Anatomy option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "activecases.filter.option.anatomy.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "activecases.filter.option.anatomy.xpath");
		}
		if (menu.equalsIgnoreCase("type")) {
			logger.info("type option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "activecases.filter.option.type.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "activecases.filter.option.type.xpath");
		}
		if (menu.equalsIgnoreCase("staus")) {
			logger.info("Satus option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "activecases.filter.option.status.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "activecases.filter.option.status.xpath");
		}
		if (menu.equalsIgnoreCase("due date")) {
			logger.info("Due date option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "activecases.filter.option.duedate.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "activecases.filter.option.duedate.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + menu);
		return null;
	}
	
	/**
	 * This method is used to click on done.
	 * 
	 * @throws IOException
	 */
	public void clickOnDoneButton() throws IOException {
		logger.info("Done button is clicked : "
				+ utility.initializeElement(LoginPage.driver, "activecases.btn.done.xpath").isDisplayed());
		 utility.initializeElement(LoginPage.driver, "activecases.btn.done.xpath").click();
	}
	
	/**
	 * This method is used to check searchbox displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSearchboxDisplayed() throws IOException {
		logger.info("Searchbox is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.searchbox.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.searchbox.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to enter text in searchbox.
	 * 
	 * @throws IOException
	 */
	public void enterTextInSearchBox(String text) throws IOException {
		logger.info("The text is entered in searchbox as "+text);
		 utility.initializeElement(LoginPage.driver, "activecases.searchbox.xpath").sendKeys(text);
	}
	
	/**
	 * This method is used to check search button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSearchButtonDisplayed() throws IOException {
		logger.info("Search button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.btn.search.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.btn.search.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check username displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isUserNameDisplayed() throws IOException {
		logger.info("Username is displayed as : "
				+ utility.initializeElement(LoginPage.driver, "activecases.btn.done.xpath").getText());
		 return utility.initializeElement(LoginPage.driver, "activecases.btn.done.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check settings button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSettingsButtonDisplayed() throws IOException {
		logger.info("Settings button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.btn.search.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.btn.search.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check table header displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isTableHeaderDisplayed(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("case ID")) {
			logger.info("case ID header is displayed : "
                    + utility.initializeElement(LoginPage.driver, "activecases.table.column.caseid.xpath").isDisplayed());
			utility.initializeElement(LoginPage.driver,
					"activecases.table.column.caseid.xpath");
		}
		if (component.equalsIgnoreCase("Anatomy")) {
			logger.info("Anatomy header is displayed : "
                    + utility.initializeElement(LoginPage.driver, "activecases.table.column.anatomy.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver,
					"activecases.table.column.anatomy.xpath");
		}
		if (component.equalsIgnoreCase("type")) {
			logger.info("Type header is displayed : "
                    + utility.initializeElement(LoginPage.driver, "activecases.table.column.type.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver,
					"activecases.table.column.type.xpath");
		}
		if (component.equalsIgnoreCase("status")) {
			logger.info("Status header is displayed : "
                    + utility.initializeElement(LoginPage.driver, "activecases.table.column.casestatus.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver,"activecases.table.column.casestatus.xpath");
		}
		if (component.equalsIgnoreCase("created")) {
			logger.info("Created header is displayed : "
                    + utility.initializeElement(LoginPage.driver, "activecases.table.column.createdatetime.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver,
					"activecases.table.column.createdatetime.xpath");
		}
		if (component.equalsIgnoreCase("time until due")) {
			logger.info("Time ubtil due is displayed : "
                    + utility.initializeElement(LoginPage.driver, "activecases.table.column.timeuntildue.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver,
					"activecases.table.column.timeuntildue.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}

	/***
	 * This method is used to get alphanumeric unique id of case id column.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean getAlphanumericUniqueID() throws IOException, InterruptedException {
		List<WebElement> caseIDList = utility.initializeElements(LoginPage.driver, "activecases.table.list.caseid.xpath");
		logger.info("The case id list is displayed");
		ArrayList<WebElement> list = new ArrayList<WebElement>();
		for(int i = 0; i< caseIDList.size(); ++i ) {
			if(!list.contains(caseIDList.get(i))) {
				list.add(caseIDList.get(i));
			}
			String pattern= "^[a-zA-Z0-9]*$";
			if(list.get(i).getText().matches(pattern)) {
			logger.info(list.get(i).getText());
		}
		}
		logger.info("No. of unique case id : " +list.size());
		return false;
	}
	
	/**
	 * This method is used to perform click.
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void clickOnsecondTab(String string) throws IOException, InterruptedException {
		Thread.sleep(10000);
		if(string.equalsIgnoreCase("My Cases")) {
			WebElement element = utility.initializeElement(LoginPage.driver, "activecases.link.casehistory.xpath");
			WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.visibilityOf(element));
			wait.click();
			logger.info("The "+string+ "tab is clicked");
		}
		else {
			WebElement element = utility.initializeElement(LoginPage.driver, "activecases.link.casehistory.xpath");
			WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.visibilityOf(element));
			wait.click();
			logger.info("The "+string+ "tab is clicked");
		}
	}
		 
	/*****************************************************/
	
	/**
	 * This method is used to locate the table headers
	 * @param header
	 * @return
	 * @throws IOException
	 */
	public WebElement locateTableHeaders(String header) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		String locator = null;
		if (header.equalsIgnoreCase("case ID")) {
			locator = "activecases.table.column.caseid.xpath";
		}
		if (header.equalsIgnoreCase("Anatomy")) {
			locator ="activecases.table.column.anatomy.xpath";
		}
		if (header.equalsIgnoreCase("Type")) {
			locator ="activecases.table.column.type.xpath";
		}
		if (header.equalsIgnoreCase("Status")) {
			locator ="activecases.table.column.casestatus.xpath";
		}
		if (header.equalsIgnoreCase("Created")) {
			locator ="activecases.table.column.createdatetime.xpath";
		}
		if (header.equalsIgnoreCase("Due Date")) {
			locator ="activecases.table.column.duedateheader.xpath";
		}
		if (header.equalsIgnoreCase("time until due")) {
			locator ="activecases.table.column.timeuntildue.xpath";
		}
		return utility.initializeElement(LoginPage.driver,locator);
	}
	
	/**
	 * This method is used to check all the column headers are displayed
	 * @return
	 * @throws IOException
	 */
	public boolean isColumnHeadersDisplayed() throws IOException {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			logger.info("aa");
		}
		boolean isCaseIdHeaderDisplayed = locateTableHeaders("case ID").isDisplayed();
		boolean isAnatomyHeaderDisplayed = locateTableHeaders("Anatomy").isDisplayed();
		boolean isTypeHeaderDisplayed = locateTableHeaders("Type").isDisplayed();
		boolean isStatusHeaderDisplayed = locateTableHeaders("Status").isDisplayed();
		boolean isCreatedHeaderDisplayed = locateTableHeaders("Created").isDisplayed();
		boolean isDueDateHeaderDisplayed = locateTableHeaders("Due Date").isDisplayed();
		boolean istimeuntildueHeaderDisplayed = locateTableHeaders("time until due").isDisplayed();
		return isCaseIdHeaderDisplayed && isAnatomyHeaderDisplayed 
				&& isTypeHeaderDisplayed && isStatusHeaderDisplayed 
				&& isCreatedHeaderDisplayed && isDueDateHeaderDisplayed &&  istimeuntildueHeaderDisplayed;
	}
	
	/**
	 * This method is used to check all the columns are displayed
	 * @return
	 * @throws IOException
	 */
	public boolean is10ColumnsDisplayed() throws IOException {
		boolean isInfoIconColumnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.table.column.iconinfo.value.xpath").isDisplayed();
		boolean isCaseidColumnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.table.column.caseid.value.xpath").isDisplayed();
		boolean isAnatomyColumnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.table.column.anatomy.value.xpath").isDisplayed();
		boolean isTypeColumnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.table.column.type.value.xpath").isDisplayed();
		boolean isStatusColumnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.table.column.status.value.xpath").isDisplayed();
		boolean isCreatedColumnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.table.column.created.value.xpath").isDisplayed();
		boolean isDueDateColumnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.table.column.duedate.value.xpath").isDisplayed();
		boolean isTimeTillDueColumnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.table.column.timetilldue.value.xpath").isDisplayed();
		boolean isClaimOrUnassighColumnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.table.column.claimoruassign.value.xpath").isDisplayed();
		boolean isOpenOrViewColumnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.table.column.openorview.value.xpath").isDisplayed();

		if(isInfoIconColumnDisplayed)
		{logger.info("Column1:Audit {log icon /info icon is displayed");}
		if(isCaseidColumnDisplayed)
		{logger.info("Column2: Case ID is displayed");}
		if(isAnatomyColumnDisplayed)
		{logger.info("Column3: Anatomy is displayed");}
		if(isTypeColumnDisplayed)
		{logger.info("Column4: Type is displayed");}
		if(isStatusColumnDisplayed)
		{logger.info("Column5: Status is displayed");}
		if(isCreatedColumnDisplayed)
		{logger.info("Column6: Created is displayed");}
		if(isDueDateColumnDisplayed)
		{logger.info("Column7: Due date is displayed");}
		if(isTimeTillDueColumnDisplayed)
		{logger.info("Column8:Time until due is displayed");}
		if(isClaimOrUnassighColumnDisplayed)
		{logger.info("Column9: Claim/Unassign is displayed");}
		if(isOpenOrViewColumnDisplayed)
		{logger.info("Column10: Open/View is displayed");}
		return isInfoIconColumnDisplayed && isCaseidColumnDisplayed && isAnatomyColumnDisplayed
			&&	isTypeColumnDisplayed	&& isStatusColumnDisplayed && isCreatedColumnDisplayed
			&& isDueDateColumnDisplayed && isTimeTillDueColumnDisplayed && isClaimOrUnassighColumnDisplayed && isOpenOrViewColumnDisplayed; 
	}
	
	/**
	 * This method is used to check the sorting type of due date column
	 * @param sortType
	 * @return
	 * @throws IOException
	 */
	public boolean isDueDateSorting(String sortType) throws IOException {
		String actualSortType = locateTableHeaders("Due Date").getAttribute("aria-sort");
		logger.info("actualSortType******"+actualSortType);
		List<WebElement> allDueDates = utility.initializeElements(LoginPage.driver,"activecases.table.column.duedate.value.xpath");
		logger.info("Displayed Due dates:");
		for(WebElement dueDate : allDueDates) {
			logger.info(dueDate.getText());
		}
		return actualSortType.equals(sortType);
	}
	
	/**
	 * This method is used to click on due date header sorting arrow
	 * @throws IOException
	 */
	public void clickDueDateHeaderArrow() throws IOException {
		locateTableHeaders("Due Date").click();
		logger.info("Due Date sort arrow is clicked");
	}
	
	public static List<String> caseIds = new ArrayList<>();
	public static String caseId1 = null;
	public static String caseId2 = null;
	
	/**
	 * This method is used to click on claim button
	 * @throws IOException
	 */
	public void clickClaimButton() throws IOException {
		Properties properties = reader.getProperty();
		String elemName = properties.getProperty("activecases.table.claim.btn.xpath");
		String caseIdLocator = String.format("(%s)[1]/../..%s",properties.getProperty("activecases.table.claim.btn.xpath"),properties.getProperty("activecases.table.column.caseid.value.xpath"));
//		logger.info("caseIdLocator**********"+caseIdLocator);
		caseIds.add(LoginPage.driver.findElement(By.xpath(caseIdLocator)).getText());
		for(String caseID:caseIds) {
			logger.info(caseID);
		}
		caseId1 = caseIds.get(caseIds.size()-1);
		logger.info("caseId1*****"+caseId1);
		LoginPage.driver.findElement(By.xpath(elemName)).click();
	}
	

	/**
	 * This method is used to get status of record with case id CaseId1
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String getStatusOfRecordSelectedRecord() throws IOException, InterruptedException {
		String status = null;
		Thread.sleep(10000);
		Properties properties = reader.getProperty();
		String Status = null;
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseId1)) {
//				logger.info("caseId1*****"+caseId1);
				String statusXpath = String.format("./..%s", properties.getProperty("activecases.table.column.status.value.xpath"));
//				logger.info("statusXpath*****"+statusXpath);
				Status = caseId.findElement(By.xpath(statusXpath)).getText();
				break;
			}
		}
		return status;
	}
	
	/**
	 * This method is used to get view/open button of record with case id CaseId1
	 * @return
	 * @throws IOException
	 */
	public String checkVieworOpenButton() throws IOException {
		Properties properties = reader.getProperty();
		String button = null;
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseId1)) {
				String viewOrOpenButtonXpath = String.format("./..%s", properties.getProperty("activecases.table.column.openorview.value.xpath"));
				button = caseId.findElement(By.xpath(viewOrOpenButtonXpath)).getText();
				logger.info("view/open******"+button);
				break;
			}
		}
		return button;
	}
	
	/**
	 * This method is used to get claim/unclaim/unassign button of record with case id CaseId1
	 * @return
	 * @throws IOException
	 */
	public String checkClaimUnclaimorUnassignButton() throws IOException {
		Properties properties = reader.getProperty();
		String button = null;
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseId1)) {
				String claimOrUnclaimBtnXpath = String.format("./..%s", properties.getProperty("activecases.table.column.claimoruassign.value.xpath"));
				logger.info("claimOrUnclaimBtnXpath*****"+claimOrUnclaimBtnXpath);
				button = caseId.findElement(By.xpath(claimOrUnclaimBtnXpath)).getText();
				logger.info("claim/unclaim/unassign******"+button);
				break;
			}
		}
		return button;
	}
	
	/**
	 * This method is used to click on "My Cases" on top navigation bar
	 * @throws IOException
	 */
	public void clickMyCases() throws IOException {
		utility.initializeElement(LoginPage.driver,"activecases.mycases.btn.xpath").click();
		logger.info("My cases is clicked");
	}
	
	/**
	 * This method is used to check MY cases screen is displayed
	 * @return
	 * @throws IOException
	 */
	public boolean isMyCasesScreenDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver,"mycases.table.allrows.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check claimed cases are displayed in MY cases screen
	 * @return
	 * @throws IOException
	 */
	public boolean isPreviouslyClaimedrecordsDisplayed() throws IOException {
		utility.initializeElement(LoginPage.driver,"mycases.filter.btn.xpath").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		utility.initializeElement(LoginPage.driver,"mycases.filter.status.plus.xpath").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> availableFilter = utility.initializeElements(LoginPage.driver,"mycases.filter.status.values.xpath");
		for(WebElement filter:availableFilter) {
			if(!filter.getText().contains("Error")) {
				filter.click();
			}
		}
		utility.initializeElement(LoginPage.driver,"mycases.filter.done.button.xpath").click();
		boolean isCaseId1Displayed = false;
		boolean isCaseId2Displayed = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"mycases.table.column.caseid.xpath");
		for(WebElement caseID:allCaseIds) {
			if(caseID.getText().contains(caseIds.get(0))) {	
			isCaseId1Displayed = true;
			break;
			}
		}
		for(WebElement caseID:allCaseIds) {
			if(caseID.getText().contains(caseIds.get(1))) {
				isCaseId2Displayed = true;
				break;
			}
		}
		if(isCaseId1Displayed && isCaseId2Displayed) {
			logger.info("claimed records are displayed");
		}
		if(isCaseId1Displayed) {
			logger.info(caseIds.get(0) + " is found");
		}
		else {
			logger.info(caseIds.get(0) + " is not found");
		}
		if(isCaseId2Displayed) {
			logger.info(caseIds.get(1) + " is found");
		}
		else {
			logger.info(caseIds.get(1) + " is not found");
		}
		caseIds.clear();
		return isCaseId1Displayed && isCaseId2Displayed;
	}
	
	/**
	 * This method is used to check date and time format in duedate column
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public boolean checkDateTimeFormat() throws IOException, ParseException {
		String DateTime = utility.initializeElement(LoginPage.driver,"activecases.table.column.duedate.value.xpath").getText();
		logger.info("Displayed Date Time: "+ DateTime);
		String datetime = DateTime.split(" ")[0] +" "+ DateTime.split(" ")[1]; 
		SimpleDateFormat sdfrmt = new SimpleDateFormat("mm/dd/YYYY HH:MM");
		sdfrmt.setLenient(false);
		try{
			Date javaDate = sdfrmt.parse(datetime); 
		}catch (ParseException e){
			return false;
		} 
		return (DateTime.split(" ")[2].equals("AM")||DateTime.split(" ")[2].equals("PM"));
	}
	
	/**
	 * This method is used to check the font and sorting arrow of duedate colum is white in color
	 * @return
	 * @throws IOException
	 */
	public boolean fontsAndArrowWhiteColor() throws IOException {
		WebElement arrow = utility.initializeElement(LoginPage.driver,"activecases.table.duedate.arrow.xpath");
		WebElement header = locateTableHeaders("Due Date");
		logger.info("header color: "+header.getCssValue("color"));
		logger.info("Arrow color : "+arrow.getCssValue("color"));
		Properties properties = reader.getProperty();
		String headerColor = properties.getProperty("white.color");
		String arrowColor = properties.getProperty("arrow.color");
		boolean isHeaderWhite = header.getCssValue("color").equals(headerColor);
		boolean isArrowWhite = arrow.getCssValue("color").equals(arrowColor);
		return isHeaderWhite && isArrowWhite;
	}
	
	/**
	 * This method is used to click on edit icon
	 * @throws IOException
	 */
	public void clickEditButton() throws IOException {
		WebElement editBtn = utility.initializeElement(LoginPage.driver,"activecases.table.edit.button.xpath");
		Properties properties = reader.getProperty();
		String caseIdXpath = String.format("(./../../..%s)[1]", properties.getProperty("activecases.table.column.caseid.value.xpath"));
		caseId2 = editBtn.findElement(By.xpath(caseIdXpath)).getText();
		editBtn.click();
		logger.info("Edit icon is Clicked");
		
	}
	
	public static String newDueDate = null;
	
	/**
	 * This method is used to check edit due date popup
	 * @return
	 * @throws IOException
	 */
	public boolean verifyNewDueDatePopUp() throws IOException {
		boolean isCurrentDateHighlighted = false;
		boolean isWeekendDisabled = false;
		boolean header = utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.header.xpath").isDisplayed();
		List<WebElement> dates = utility.initializeElements(LoginPage.driver,"activecases.newduedatepopup.calender.eachdate.xpath");
		for(WebElement date:dates) {
			if(date.getAttribute("class").equals("mat-calendar-body-cell mat-calendar-body-active")) {
				isCurrentDateHighlighted = date.getAttribute("aria-pressed").equals("true");
				if(isCurrentDateHighlighted) {
					logger.info("Current date is highlighted");
				}
				break;
			}
		}
		for(WebElement date:dates) {
			WebElement parentTd = date.findElement(By.xpath(".//.."));
			if(parentTd.getAttribute("data-mat-col").equals("1")||parentTd.getAttribute("data-mat-col").equals("6")) {
				if(date.getAttribute("class").equals("mat-calendar-body-cell mat-calendar-body-disabled")) {
					isWeekendDisabled = true;
				}
			}
		}
		if(isWeekendDisabled) {
			logger.info("Weekends are disabled");
		}
		else {
			logger.info("Weekends are not disabled");
		}
		WebElement enterTimeField =  utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.entertime.input.xpath");
		if(enterTimeField.isDisplayed()) {
			logger.info("Autopopulated time: "+ enterTimeField.getText());
		}
		boolean isAMPMtoggleDisplayed = utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.toggleampm.xpath").isDisplayed();
		if(isAMPMtoggleDisplayed) {
			logger.info("Toggle button AM/PM is displayed");
		}
		WebElement newDueDateField =  utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.newduedatefield.xpath");
		if(newDueDateField.isDisplayed()) {
			logger.info("Autopopulated date and time: "+ newDueDateField.getText());
			newDueDate = newDueDateField.getText();
		}
		boolean isCancelBtnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.cancel.button.xpath").isDisplayed();
		if(isCancelBtnDisplayed) {
			logger.info("Cancel button is displayed");
		}
		boolean isSubmitBtnDisplayed = utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.submit.button.xpath").isDisplayed();
		if(isSubmitBtnDisplayed) {
			logger.info("Submit button is displayed");
		}
		return isCurrentDateHighlighted && isWeekendDisabled && header && enterTimeField.isDisplayed() && newDueDateField.isDisplayed() &&isCancelBtnDisplayed &&isSubmitBtnDisplayed;
	}
	
	/**
	 * This method is used to click submit button in edit due date pop up
	 * @throws IOException
	 */
	public void clickNewDueDateSubmitBtn() throws IOException {
		utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.submit.button.xpath").click();
		logger.info("Submit button is clicked");
	}
	
	/**
	 * This method is used to check due date changed in edit due date popup is reflected in Active cases Screen
	 * @return
	 * @throws IOException
	 */
	public boolean duedateChangedAfterEdit() throws IOException {
		boolean flag = false;
		Properties properties = reader.getProperty();
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseId2)) {
				logger.info("caseId2*****"+caseId2);
				String dueDateXpath = String.format("(./..%s)[1]", properties.getProperty("activecases.table.column.duedate.value.xpath"));
				String dueDate = caseId.findElement(By.xpath(dueDateXpath)).getText();
				logger.info("duedate******"+dueDate);
				String date = dueDate.split(" ")[0];
				String time = dueDate.split(" ")[1];
				String AmPm = dueDate.split(" ")[2];
				logger.info("newDueDate*****"+newDueDate);
				if(newDueDate.contains(date)) {
					logger.info("Date is displayed correctly");
				}
				if(newDueDate.contains(time)) {
					logger.info("Time is displayed correctly");
				}
				if(newDueDate.contains(AmPm)) {
					logger.info("AmPm is displayed correctly");
				}
				if(newDueDate.contains(date)&& newDueDate.contains(time)&&newDueDate.contains(AmPm)) {
					flag= true;
				}
				JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", caseId);
				break;
			}
		}
		return flag;
	}
	
	/**
	 * This method is used to check due date colum header is displayed
	 * @return
	 * @throws IOException
	 */
	public boolean duedateHEaderTextIsDisplayed() throws IOException {
		return locateTableHeaders("Due Date").isDisplayed();
	}
	
	/**
	 * This method is used to check Active Cases screen is displayed
	 * @return
	 * @throws IOException
	 */
	public boolean activeCasesScreenIsDisplayed() throws IOException {
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		logger.info("Records displayed");
		for(WebElement caseId:allCaseIds) {
			logger.info(caseId.getText());
		}
		return is10ColumnsDisplayed();
	}
	
	/**
	 * This method is used to check record table displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isRecordTableDisplayed() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"activecases.table.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		logger.info("Case record table is displayed : "
				+ utility.initializeElement(LoginPage.driver, "activecases.table.xpath").isDisplayed());
		return wait.isDisplayed();
	}
	
	/**
	 * This method is used to select claimed record
	 * @throws IOException
	 */
	public void selectAClaimedRecord() throws IOException {
		String claimColumn = utility.initializeElement(LoginPage.driver,"activecases.table.cloumn.claim.xpath").getText().trim();
		if(claimColumn.equalsIgnoreCase("Claim")) {
			utility.initializeElement(LoginPage.driver,"activecases.table.row.firstclaim.xpath").click();
			logger.info("Claim record is clicked ");
		}else {
			logger.info("Claim record is not found");
		}
		
	}
	
	/**
	 * This method is used to click on auditlog icon
	 * @throws IOException
	 */
	public void clickOnAuditlogIcon() throws IOException {
		boolean flag = utility.initializeElement(LoginPage.driver,"activecases.table.row.highlighted.xpath").isDisplayed();
		if(flag == true) {
			utility.initializeElement(LoginPage.driver,"activecases.table.auditlog.xpath").click();
			logger.info("Audit log icon is clicked ");
		}else {
			logger.info("Audit log icon is not clicked");
		}
		
	}
	
	/***
	 * This method is used to copy Audit log excel sheet from local download path to inside the project and then delete the local downloaded file.
	 * 
	 * @throws IOException
	 */
	public boolean copyAuditLogFileToProject(String fileName) throws IOException {
		boolean flag = false;
		Properties properties = reader.getProperty();
		String fromLocation = properties.getProperty("hilauditlog.local.path")+ fileName;
		String toLocation = properties.getProperty("hilauditlog.project.path")+ fileName;
		File from = new File(fromLocation);
		File to = new File(toLocation);
		FileUtils.copyFile(from,to);
		logger.info("file copied to HILAuditLogs folder location : " + toLocation);
		//from.delete();
		if(!(fromLocation == null)) {
			logger.info("Audlit log .csv file is downloaded");
			  flag = true;
		}
		return flag;
	}
	
	/**
	 * This method is used to select a record from case history
	 * @throws IOException
	 */
	public void selectARecordFromCaseHistory() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"casehistory.table.row.first.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		wait.click();
	}
	
	/**
	 * This method is used to check case history record selected or not.
	 * 
	 * @throws IOException
	 */
	public boolean isCaseRecordSelected() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"casehistory.table.row.first.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOf(element));
		logger.info("The Case record is selected : "
				+ utility.initializeElement(LoginPage.driver, "activecases.table.row.highlighted.xpath").isEnabled());
		logger.info("The Case record table is higlighted in green color : "
				+ utility.initializeElement(LoginPage.driver, "activecases.table.row.highlighted.xpath").getCssValue("outline-color"));
		return wait.isDisplayed();
	}
	
	/**
	 * This method is used to click on auditlog icon
	 * @throws IOException
	 */
	public void clickOnCaseHistoryAuditlogIcon() throws IOException {
		boolean flag = utility.initializeElement(LoginPage.driver,"activecases.table.row.highlighted.xpath").isDisplayed();
		if(flag == true) {
			utility.initializeElement(LoginPage.driver,"casehistory.table.auditlog.xpath").click();
			logger.info("Case history audit log icon is clicked ");
		}else {
			logger.info(" Case history audit log icon is not clicked");
		}
		
	}
	
	/***
	 * This method is used to verify the headers of downloaded Audit logs
	 * 
	 * @throws IOException
	 */
	public String[] verifyActiveCasesAuditLogHeaders(String fileName) throws IOException {
		Properties properties = reader.getProperty();
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
	public List<String[]> readAllAuditLogsData(String fileName) throws IOException {
		Properties properties = reader.getProperty();
		FileReader filereader = new FileReader(properties.getProperty("hilauditlog.project.path") + fileName);
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
	public Boolean compareData(String fileName) throws IOException, InterruptedException {
		Thread.sleep(3000);
		List<String[]> excelData = readAllAuditLogsData(fileName);
		WebElement allRows;
			allRows = utility.initializeElement(LoginPage.driver, "activecases.table.row.highlighted.xpath");
		Boolean flag = true;
		logger.info("No. of rows in excel sheet "+excelData.size());
		for(int i=1;i<excelData.size();i++) {
			String[] rowInExcel = excelData.get(i);
			logger.info("Data in Excel sheet: "+ rowInExcel[0]+  " " + rowInExcel[1]+ " " + rowInExcel[2]+ " " + rowInExcel[3] );
			String rowOnDisplay = allRows.getText();
			logger.info("Data on display: " + rowOnDisplay);
			if(	!(rowOnDisplay == null))
				{
				flag = true;
		}
			else 
				flag = false;
		}
		return flag;
		
	}

/**
	 * This method is used to Logout button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isLogOutBtnDisplayed() throws IOException {
		logger.info("LogOut Button is displayed  : "
				+ utility.initializeElement(LoginPage.driver, "HIL.logot.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "HIL.logot.btn.xpath").isDisplayed();
	}

	/**
	 * This method is used to click Logout button.
	 * 
	 * @throws IOException
	 */
	public void clickExitBtn() throws IOException {
		utility.initializeElement(LoginPage.driver, "activecases.exit.btn.xpath").click();
		logger.info("Exit button is clicked");
	}

	/**
	 * This method is used to check whether application screen is displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isApplicationScreenDisplayed() throws IOException {
		logger.info("Application screen is displayed  : "
				+ utility.initializeElement(LoginPage.driver, "clp.btn.app.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "clp.btn.app.xpath").isDisplayed();
	}
	
	/**
	 * This method is to get the first entry caseID
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String getFirstEntryCaseID() throws IOException {
		String caseID = utility.initializeElement(LoginPage.driver, "activecases.table.column.caseid.firstentry.txt.xpath").getText();
		logger.info("Case ID: " + caseID);
		return caseID;
	}
	
	/**
	 * This method is to click the unassign button on first entry 
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void clickUnassignButtonOnFirstEntry() throws IOException, InterruptedException {
		String text = utility.initializeElement(LoginPage.driver, "activecases.table.column.unassign.btn.xpath").getText();
		logger.info("Unassign Step button text: " + text);
		if(text.equalsIgnoreCase("Unassign")) {
			utility.initializeElement(LoginPage.driver, "activecases.table.column.unassign.btn.xpath").click();
			logger.info("User clicks unassign button");
			Thread.sleep(5000);
		} else {
			logger.info("Button is claim, not unassign");
		}
	}

	/**
	 * This method is to click the claim button on first entry
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void clickClaimButtonOnFirstEntry() throws IOException, InterruptedException {
		String text = utility.initializeElement(LoginPage.driver, "activecases.table.column.claim.btn.xpath").getText();
		logger.info("Claim step button text: " + text);
		if(text.equalsIgnoreCase("Claim")) {
			utility.initializeElement(LoginPage.driver, "activecases.table.column.claim.btn.xpath").click();
			logger.info("User clicks claim button");
			Thread.sleep(5000);
		} else {
			logger.info("Button is unassign, not claim");
		}
	}
	
	/**
	 * This method is to click the open button on first entry
	 * 
	 * @throws IOException
	 */
	public void clickOpenButtonOnFirstEntry() throws IOException {
		utility.initializeElement(LoginPage.driver, "activecases.table.column.open.btn.xpath").click();
		logger.info("User clicks open button on first entry");
	}
	
	/**
	 * This method is to click the reject button on hil page
	 * 
	 * @throws IOException
	 */
	public void clickRejectButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "HIL.reject.btn.xpath").click();
		logger.info("User clicked reject button");
	}
	
	/**
	 * This method is to send keys into the reject popup text area
	 * 
	 * @throws IOException
	 */
	public void sendKeysIntoRejectPopUp() throws IOException {
		utility.initializeElement(LoginPage.driver, "HIL.reject.popup.txt.area.xpath").sendKeys("Automation Testing");
		logger.info("User entered keys into reject pop up text field");
	}
	
	/**
	 * This method is to click the reject button in the reject pop up window
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void clickRejectButtonInRejectPopUp() throws IOException, InterruptedException {
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "HIL.reject.popup.reject.btn.xpath").click();
		logger.info("User clicked reject button in reject pop up window");
	}
	
	/**
	 * This method is to click the exit button in HIL Page
	 * 
	 * @throws IOException
	 */
	public void clickExitButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "HIL.exit.btn.xpath").click();
		logger.info("User clicked exit button");
	}
	
	/**
	 * This method is to get the status of the first entry in active cases table
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String getFirstEntryStatus() throws IOException {
		String text = utility.initializeElement(LoginPage.driver, "activecases.table.column.status.firstentry.txt.xpath").getText();
		logger.info("First entry status: " + text);
		return text;
	}
	
	/**
	 * This method is to click the active case button
	 * 
	 * @throws IOException
	 */
	public void clickActiveCasesButtonInTop() throws IOException {
		utility.initializeElement(LoginPage.driver, "activecases.link.activecases.xpath").click();
		logger.info("User clicked active cases button in the top bar");
	}
	
	/**
	 * This method is to click the case history button
	 * 
	 * @throws IOException
	 */
	public void clickCaseHistoryButtonInTop() throws IOException {
		utility.initializeElement(LoginPage.driver, "activecases.link.casehistory.xpath").click();
		logger.info("User clicked case history button in the top bar");
	}
	
	/**
	 * This method is to click the axial view in HIL page
	 * 
	 * @throws IOException
	 */
	public void clickAxialView() throws IOException {
		utility.initializeElement(LoginPage.driver, "HIL.axial.btn.xpath").click();
		logger.info("User clicked axial view");
	}
	
	/**
	 * This method is to click the left and right slider buttons 10 times
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void clickSlidersToAchieve100Percent() throws IOException, InterruptedException {
		Thread.sleep(3000);
		for(int i = 0; i < 2; i++) {
			utility.initializeElement(LoginPage.driver, "HIL.left.slider.btn.xpath").click();
		}
		logger.info("User clicked left 10 times");
		Thread.sleep(3000);
		for(int j = 0; j < 12; j++) {
			utility.initializeElement(LoginPage.driver, "HIL.right.slider.btn.xpath").click();
		}
		logger.info("User clicked right 12 times");
		for(int i = 0; i < 20; i++) {
			utility.initializeElement(LoginPage.driver, "HIL.left.slider.btn.xpath").click();
		}
		logger.info("User clicked left 20 times");
	}
	
	/**
	 * This method is to click the approve button in the bottom right panel
	 * 
	 * @throws IOException
	 */
	public void clickApproveButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "HIL.approve.btn.xpath").click();
		logger.info("User clicked approve button in bottom right panel");
	}
	
	/**
	 * This method is to click the approve button in the approve button pop up
	 * 
	 * @throws IOException
	 */
	public void clickApproveButtonInApproveButtonPopUp() throws IOException {
		utility.initializeElement(LoginPage.driver, "HIL.approve.popup.approve.btn.xpath").click();
		logger.info("User clicks approve button in approve button pop up");
	}
	
	/**
	 * This method is to print the status of the first entry in the table
	 * 
	 * @throws IOException
	 */
	public void printFirstEntryStatus() throws IOException {
		logger.info("First entry status: " + utility.initializeElement(LoginPage.driver, "activecases.table.column.status.firstentry.txt.xpath").getText());
	}
	
	/**
	 * This method is to click the mycases page button
	 * 
	 * @throws IOException
	 */
	public void clickMyCasesPageButton() throws IOException {
		logger.info("User clicks my cases page button");
		utility.initializeElement(LoginPage.driver, "casehistory.btn.xpath").click();
	}
	
	/**
	 * This method is to get the first entry id on my cases page
	 * 
	 * @throws IOException
	 * @return String
	 */
	public String getFirstEntryIDMCPage() throws IOException {
		return utility.initializeElement(LoginPage.driver, "mycases.table.status.firstentry.txt.xpath").getText();
	}
	
	/**
	 * This method is to verify the unassign button is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean verifyUnassignButton() throws IOException {
		String btnText = utility.initializeElement(LoginPage.driver, "activecases.table.column.unassign.btn.xpath").getText();
		if(btnText.equalsIgnoreCase("Unassign")) {
			logger.info("Unassign button is displayed");
			return true;
		} else {
			logger.info("Unassign button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to verify the unassign button is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean verifyClaimButton() throws IOException {
		String btnText = utility.initializeElement(LoginPage.driver, "activecases.table.column.claim.btn.xpath").getText();
		if(btnText.equalsIgnoreCase("Claim")) {
			logger.info("Claim button is displayed");
			return true;
		} else {
			logger.info("Claim button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to verify the open button is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean verifyOpenButton() throws IOException {
		String btnText = utility.initializeElement(LoginPage.driver, "activecases.table.column.open.btn.xpath").getText();
		if(btnText.equalsIgnoreCase("Open")) {
			logger.info("Open button is displayed");
			return true;
		} else {
			logger.info("Open button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to verify the view button is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean verifyViewButton() throws IOException {
		String btnText = utility.initializeElement(LoginPage.driver, "activecases.table.column.open.btn.xpath").getText();
		if(btnText.equalsIgnoreCase("View")) {
			logger.info("View button is displayed");
			return true;
		} else {
			logger.info("View button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to print the status of the first entry in the case history page
	 * 
	 * @throws IOException
	 */
	public void printFirstEntryStatusCHPage() throws IOException {
		logger.info("Case History First Entry Status: " + utility.initializeElement(LoginPage.driver, "casehistory.table.status.firstentry.txt.xpath").getText());
	}


	/**
	 * This method is used to check exit button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isExitBtnDisplayed() throws IOException {
		logger.info("Exit Button is displayed  : "
				+ utility.initializeElement(LoginPage.driver, "activecases.exit.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "activecases.exit.btn.xpath").isDisplayed();
	}

	/**
	 * This method is used to click on one enabled date in the calender in new due date pop up
	 * @throws IOException
	 */
	public void chengeDueDate() throws IOException {
		utility.initializeElements(LoginPage.driver,"activecases.newduedatepopup.calender.enableddates.xpath").get(0).click();
		WebElement newDueDateField =  utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.newduedatefield.xpath");
		if(newDueDateField.isDisplayed()) {
			logger.info("Autopopulated date and time: "+ newDueDateField.getText());
			logger.info("Please check the date format");
			newDueDate = newDueDateField.getText();
		}
	}

	 /* This method is used to click on first available edit button of due date
	 * @return
	 * @throws IOException
	 */
	public boolean isEditButtonDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver,"activecases.table.edit.button.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check edit button is available for a case
	 * @return
	 * @throws IOException
	 */
	public boolean isEditButtonDisplayedForRecord() throws IOException {
		boolean isDisplayed = false;
		Properties properties = reader.getProperty();
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseId1)) {
				String editIcon = String.format("./..%s", properties.getProperty("activecases.table.edit.button.xpath"));
				try {
					isDisplayed =caseId.findElement(By.xpath(editIcon)).isDisplayed();
				}catch(org.openqa.selenium.NoSuchElementException e) {
					isDisplayed = false;
				}
			}
		}
		if(!isDisplayed) {
			logger.info("Edit icon is not displayed");
			caseIds.clear();
			return true;
		}
		else {
			logger.info("Edit icon is displayed");
			caseIds.clear();
			return false;
		}
	}
	
	/**
	 * This method is to print the first entry status in the my cases page
	 * 
	 * @throws IOException
	 */
	public void printFirstEntryStatusInMyCasesPage() throws IOException {
		logger.info("First Entry Status In My Cases Page: " + utility.initializeElement(LoginPage.driver, "mycases.table.status.firstentry.txt.xpath").getText());
	}
	
	/**
	 * Check Audit Log Icon
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkAuditLogIconFirstEntryNotDisplayed() throws IOException {
		String text =  utility.initializeElement(LoginPage.driver, "activecases.table.column.auditlog.icon.xpath").getText();
		if(text.equalsIgnoreCase("Audit Log")) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Check Edit Date Icon
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkEditDateIconFirstEntryNotDisplayed() throws IOException {
		List<WebElement> list =  utility.initializeElements(LoginPage.driver, "activecases.table.column.editdate.icon.xpath");
		return list.isEmpty();
	}
	
	/**
	 * Check Settings button
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkSettingsButtonTopRightNotDisplayed() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "activecases.settings.btn.xpath");
		return list.isEmpty();
	}
	
	/**
	 * This method is used to check unclaimed status case displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isNewUnclaimedStatusDisplayed() throws IOException {
		boolean flag = false;
		List<WebElement> statusColumn = utility.initializeElements(LoginPage.driver, "activecases.table.column.status.value.xpath");
		for(int i = 0; i<statusColumn.size() ; i++) {
			if(statusColumn.get(i).getText().contains("Unclaimed")) {
				logger.info("Status in 5th column is displayed as : " +statusColumn.get(i).getText());
				return flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * This method is used to select unclaimed case and click on claim button
	 * 
	 * @throws IOException
	 */
	public void selectUnclaimedCaseAndClickOnClaimButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "activecases.table.status.unclaimed.xpath").click();
		logger.info("Unclaimed Status case is selected");
		utility.initializeElement(LoginPage.driver, "activecases.table.button.claim.xpath").click();
		logger.info("Selected unclaimed case claim button is clicked");
	
	}
	
	/**
	 * This method is used to check claimed case open button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isOpenButtonEnabled() throws IOException {
		logger.info("The open button is enabled : " +utility.initializeElement(LoginPage.driver, "activecases.table.button.open.xpath").isEnabled());
	return utility.initializeElement(LoginPage.driver, "activecases.table.button.open.xpath").isEnabled();
		
	}
	
	/**
	 * This method is used to check claimed case reviewer name displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isReviewerNameDisplayed() throws IOException {
		logger.info("The selected case reviewer name is displayed as : " +utility.initializeElement(LoginPage.driver, "activecases.table.status.reviewername.xpath").getText());
	return utility.initializeElement(LoginPage.driver, "activecases.table.status.reviewername.xpath").isDisplayed();
		
	}
	
	/**
	 * This method is used to click on open button of selected case
	 * 
	 * @throws IOException
	 */
	public void clickOnOpenButtonOfSelectedCase() throws IOException {
		logger.info("Selected case caseID is displayed as : " +utility.initializeElement(LoginPage.driver, "activecases.table.column.caseid.selectedcase.xpath").getText());
		utility.initializeElement(LoginPage.driver, "activecases.table.button.open.selectedcase.xpath").click();
		logger.info("The open button of selected case is clicked");
	}
	
	/**
	 * This method is used to check claimed case reviewer name displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isHilImageEditorScreenDisplayed() throws IOException {
		logger.info("The Hil Image Editor Screen is displayed : " +utility.initializeElement(LoginPage.driver, "activecases.imageeditorscreen.xpath").isDisplayed());
		logger.info("The Hil Image Editor Screen is displayed for selected caseID as : " +utility.initializeElement(LoginPage.driver, "imageeditor.caseid.xpath").getText());
	return utility.initializeElement(LoginPage.driver, "activecases.imageeditorscreen.xpath").isDisplayed();
		
	}
	
	/**
	 * This method is used to check iamge editor four views displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isImageEditorScreenFourViewsDisplayed(String view) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (view.equalsIgnoreCase("Axial")) {
			logger.info("Axial view");
			utility.initializeElement(LoginPage.driver,
					"imageeditor.axial.xpath");
		}
		if (view.equalsIgnoreCase("Sagittal")) {
			return utility.initializeElement(LoginPage.driver,
					"imageeditor.sagittal.xpath");
		}
		if (view.equalsIgnoreCase("Coronal")) {
			return utility.initializeElement(LoginPage.driver,
					"imageeditor.coronal.xpath");
		}
		if (view.equalsIgnoreCase("3D Model")) {
			return utility.initializeElement(LoginPage.driver,"imageeditor.3dmodel.xpath");
		}
		if (view.equalsIgnoreCase("right panel toolbar")) {
			return utility.initializeElement(LoginPage.driver,
					"imageeditor.righttoolbar.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + view);
		return null;
	}
	
	/**
	 * This method is used to click on coronal view
	 * 
	 * @throws IOException
	 */
	public void SelectCoronalView() throws IOException {
		utility.initializeElement(LoginPage.driver, "hil.select.dropdown.xpath").click();
		logger.info("The Coronal view is selected : " +utility.initializeElement(LoginPage.driver, "hil.coronal.selected.xpath").isEnabled());
		logger.info("The Coronal view is selected and highlighted in green color as : " +utility.initializeElement(LoginPage.driver, "hil.coronal.selected.xpath").getCssValue("outline-color"));
	}
	
	/**
	 * This method is used to check reject button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isRejectButtonDisplayed() throws IOException {
		logger.info("Reject button is displayed : " +utility.initializeElement(LoginPage.driver, "HIL.reject.btn.xpath").isDisplayed());
	return utility.initializeElement(LoginPage.driver, "HIL.reject.btn.xpath").isDisplayed();
		
	}
	
	/**
	 * This method is used to click on coronal view
	 * 
	 * @throws IOException
	 */
	public void selectClaimedCase() throws IOException {
		utility.initializeElement(LoginPage.driver, "activecases.cloumn.claimed.xpath").click();
		logger.info("The selected claimed case record caseid is : " +utility.initializeElement(LoginPage.driver, "activecases.table.column.caseid.selectedcase.xpath"));
	}
	
	/**
	 * This method is used to check claimed case reviewer name displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isClaimedCaseReviewerNameDisplayed() throws IOException {
		logger.info("Reviewer name is displayed as : " +utility.initializeElement(LoginPage.driver, "activecases.table.reviewername.xpath").getText());
	return utility.initializeElement(LoginPage.driver, "activecases.table.reviewername.xpath").isDisplayed();
		
	}
	
	/**
	 * This method is used to check unclaimed case view button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isViewButtonEnabledForUnclimedCase() throws IOException {
		logger.info("Unclaimed case view button is displayed : " +utility.initializeElement(LoginPage.driver, "activecases.table.btn.view.xpath").isEnabled());
	return utility.initializeElement(LoginPage.driver, "activecases.table.btn.view.xpath").isDisplayed();
		
	}
	
	/**
	 * This method is used to check claimed case open button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isOpenButtonEnabledForClaimedCase() throws IOException {
		logger.info("Claimed case open button is displayed : " +utility.initializeElement(LoginPage.driver, "activecases.table.btn.open.xpath").isEnabled());
	return utility.initializeElement(LoginPage.driver, "activecases.table.btn.open.xpath").isDisplayed();
		
	}
	
	/**
	 * This method is used to check claimed case unassign button displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isUnassignButtonEnabledForClaimedCase() throws IOException {
		logger.info("Claimed case unassign button is displayed : " +utility.initializeElement(LoginPage.driver, "activecases.table.btn.unassign.xpath").isEnabled());
	return utility.initializeElement(LoginPage.driver, "activecases.table.btn.unassign.xpath").isDisplayed();
		
	}
	
	


	/**
	 * This method is used to get the current date as a string
	 * @return
	 */
	public static String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		logger.info("Current date: "+dtf.format(now)); 
		return dtf.format(now);
	}

	/**
	 * This method is used to select a caseid with creation date as current date
	 * @throws IOException
	 */
	public void selectCaseIdWithCreatedDateAsCurrentDate() throws IOException {
		Properties properties = reader.getProperty();
		String caseIdXpath = String.format("./..%s", properties.getProperty("activecases.table.column.caseid.value.xpath"));
		String currentDate = getCurrentDate();
		//		   utility.initializeElement(LoginPage.driver,"activecases.searchbar.xpath").sendKeys("PUv0gR");
		//		   utility.initializeElement(LoginPage.driver,"activecases.searchbutton.xpath").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> allCreatedDates = utility.initializeElements(LoginPage.driver,"activecases.table.column.created.value.xpath");
		for(WebElement createdDate:allCreatedDates) {
			if(createdDate.getText().contains(currentDate)) {
				caseId2 = createdDate.findElement(By.xpath(caseIdXpath)).getText();
			}
		}
	}

	/**
	 * This method is used to select add business days(i.e excluding weekends) to the current date
	 * @param days
	 * @return
	 */
	public static String addDaysSkippingWeekends(int days) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
		LocalDate today = LocalDate.parse(getCurrentDate(),dtf);
		LocalDate result = today;
		int addedDays = 0;
		while (addedDays < days) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}
		return dtf.format(result);
	}

	/**
	 * This method is used to verify due date is displayed as two days after current date
	 * @return
	 * @throws IOException
	 */
	public boolean isDueDate2WorkingDaysAhead() throws IOException{
		String dateAfter = addDaysSkippingWeekends(2);
		//        logger.info("dateAfter*******"+dateAfter);
		String dueDate = null;
		Properties properties = reader.getProperty();
		String dueDateXpath = String.format("./..%s", properties.getProperty("activecases.table.column.duedate.value.xpath"));
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseId2)) {
				dueDate = caseId.findElement(By.xpath(dueDateXpath)).getText();
				break;
			}
		}
		logger.info("dueDate***"+dueDate);
		return dueDate.contains(dateAfter);
	}


	/**
	 * This method is used to click on edit button of a particular case
	 * @param caseID
	 * @throws IOException
	 */
	public void clickEditButtonOfCaseId(String caseID) throws IOException {
		Properties properties = reader.getProperty();
		String eidBtnXpath=String.format("./..%s", properties.getProperty("activecases.table.edit.button.xpath"));
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseID)) {
				logger.info("caseId*****"+caseID);
				caseId.findElement(By.xpath(eidBtnXpath)).click();
				logger.info("Edit button clicked");
				break;
			}
		}
	}

	/**
	 * This method is used to click edit button of caseId2
	 * @throws IOException
	 */
	public void clickEditOfCaseId2() throws IOException {
		clickEditButtonOfCaseId(caseId2);
	}


	/**
	 * This method is used to select new due date in New due date pop up
	 * @param days
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void changeDueDate(String days) throws IOException, InterruptedException {
		logger.info("days********"+days);
		List<WebElement> availableDates = utility.initializeElements(LoginPage.driver,"activecases.newduedatepopup.calender.enableddates.xpath");
		if(availableDates.size()==0) {
			utility.initializeElement(LoginPage.driver,"activecases.calender.nextmonth.arrow.xpath").click();
			Thread.sleep(1000);
			availableDates = utility.initializeElements(LoginPage.driver,"activecases.newduedatepopup.calender.enableddates.xpath");
		}
		String date = null;
		if(days.contains("5 minutes")) {
			enter5minutesFromNow();
		}else {
			if(days.contains("24 hrs")) {
				date = addDaysSkippingWeekends(1).split("/")[1];
				enter5minutesFromNow();
			}
			if(days.contains("5 days")) {
				date = addDaysSkippingWeekends(5).split("/")[1];
				enter5minutesFromNow();
			}
			logger.info("date**********"+date);
			char firstDigit = date.charAt(0);
			logger.info("firstDigit**********"+firstDigit);
			if(firstDigit == '0') {
				date = date.replace("0", "");
			}
			for(WebElement Date:availableDates) {
				if(Date.findElement(By.xpath("..//div[1]")).getText().equals(date)) {
					Date.click();
				}
			}
		}
		newDueDate = utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.newduedatefield.xpath").getText();
		logger.info("Changed date: "+ newDueDate);
	}

	/**
	 * This method is used to click on cancel button of New date Pop up
	 * @throws IOException
	 */
	public void clickCancelBtnOfNewDueDatePopup() throws IOException {
		utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.cancel.button.xpath").click();
		logger.info("cancel button is click");
	}

	/**
	 * This method is used to check New due date pop up is dismissed
	 * @return
	 * @throws IOException
	 */
	public boolean isNewDueDatePopupDismissed() throws IOException {
		try {
			verifyNewDueDatePopUp();
			logger.info("Not dismissed");
			return false;
		}catch(org.openqa.selenium.NoSuchElementException e) {
			logger.info("Pop up is dismissed");
			return true;
		}
	}

	/**
	 * This method is used to get Time Until Due of a particular case
	 * @param caseID
	 * @return
	 * @throws IOException
	 */
	public String getTimeUntilDueOfCaseId(String caseID) throws IOException {
		Properties properties = reader.getProperty();
		String timeUntilDue=String.format("./..%s", properties.getProperty("activecases.table.column.timetilldue.value.xpath"));
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseID)) {
				//				logger.info("caseId*****"+caseID);
				logger.info("Time Until Due displayed: "+caseId.findElement(By.xpath(timeUntilDue)).getText());
				return caseId.findElement(By.xpath(timeUntilDue)).getText();
			}
		}
		return null;
	}

	/**
	 * This method is used to get the Time Until Due date of CaseId2
	 * @return
	 * @throws IOException
	 */
	public String getTimeUntilDueOfCaseId2() throws IOException {
		return getTimeUntilDueOfCaseId(caseId2);
	}

	/**
	 * This method is used to enter time 5 minutes after current time, in New due date pop up
	 * @throws IOException
	 */
	public void enter5minutesFromNow() throws IOException {
		String newHour = null;
		String newMinutes = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
		LocalDateTime now = LocalDateTime.now();
		String currentTime = dtf.format(now);
		logger.info("currentTime**********"+currentTime);
		String hours = currentTime.split(":")[0];
		logger.info("hours**********"+hours);
		String minutes = currentTime.split(":")[1];
		logger.info("minutes**********"+minutes);
		newHour = hours;
		logger.info("newHour**********"+newHour);
		newMinutes = Integer.toString(Integer.parseInt(minutes)+ 5);
		logger.info("newMinutes**********"+newMinutes);
		if(Integer.parseInt(newMinutes)>60) {
			newMinutes = Integer.toString(Integer.parseInt(newMinutes)-60);
			newHour= Integer.toString(Integer.parseInt(hours)+ 1);
			logger.info("newHour**********"+newHour);
			logger.info("newMinutes**********"+newMinutes);
		}
		String time = newHour + newMinutes;
		logger.info("time**********"+time);
		utility.initializeElement(LoginPage.driver,"activecases.newduedatepopup.entertime.input.xpath").sendKeys(time);
	}

	/**
	 * This method waits for 5 minutes until CaseId2 record becomes overdue
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void waitFor5minutesToBecomeOverdue() throws IOException, InterruptedException {
		logger.info("inside waitFor5minutesToBecomeOverdue*****************");
		caseId2 = "NptoLR";
		String statusColor=null;
		Properties properties = reader.getProperty();
		String statusXpath=String.format("./..%s", properties.getProperty("activecases.table.column.status.value.xpath"));
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseId2)) {
				final long NANOSEC_PER_SEC = 1000l*1000*1000;
				long startTime = System.nanoTime();
				while ((System.nanoTime()-startTime)< 5*60*NANOSEC_PER_SEC){
					logger.info(System.nanoTime()-startTime);{
						statusColor = caseId.findElement(By.xpath(statusXpath)).getCssValue("color");
						logger.info("statusColor*****"+statusColor);
						if(statusColor.equals(properties.getProperty("setting.redcolor"))) {
							logger.info("Status changed to overdue");
							break;
						}
						else {
							Thread.sleep(10000);
							logger.info("Delay 10 seconds");
						}
					}
					caseId.findElement(By.xpath(statusXpath)).getText();
				}
			}
		}
	}

	/**
	 * This method is used to check the time until due is notified as due date is crossed
	 * @return
	 * @throws IOException
	 */
	public boolean isTimeCrossed() throws IOException {
		String dueDateColor = null;
		Properties properties = reader.getProperty();
		String timeUntilDueXpath=String.format("./..%s", properties.getProperty("activecases.table.column.timetilldue.value.xpath"));
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseId2)) {
				logger.info("Displayed time until due :"+caseId.findElement(By.xpath(timeUntilDueXpath)).getText());
				dueDateColor = caseId.findElement(By.xpath(timeUntilDueXpath)).getCssValue("color");
				if(dueDateColor.equals(properties.getProperty("setting.redcolor"))) {
					logger.info("Time is crossed");
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * This method is used to get the time until due of CaseId2
	 * @return
	 * @throws IOException
	 */
	public String timeUntilDue() throws IOException {
		Properties properties = reader.getProperty();
		String timeUntilDueXpath=String.format("./..%s", properties.getProperty("activecases.table.column.timetilldue.value.xpath"));
		List<WebElement> allCaseIds = utility.initializeElements(LoginPage.driver,"activecases.table.column.caseid.value.xpath");
		for(WebElement caseId:allCaseIds) {
			if(caseId.getText().equals(caseId2)) {
				logger.info("Displayed time until due :"+caseId.findElement(By.xpath(timeUntilDueXpath)).getText());
				return caseId.findElement(By.xpath(timeUntilDueXpath)).getText();
			}
		}
		return null;
	}
	
	/**
	 * This method is to click the filter button at the top bar of the active cases page
	 *
	 * @throws IOException
	 */
	public void clickFilterButtonACP() throws IOException {
		logger.info("User clicks filter button on active cases page");
		utility.initializeElement(LoginPage.driver, "activecases.topbar.filter.btn.xpath").click();
	}

	/**
	 * This method is to click the status button in the filter menu of the active cases page
	 *
	 * @throws IOException
	 */
	public void clickStatusButtonACP() throws IOException {
		logger.info("User clicks status button on active cases filter menu");
		utility.initializeElement(LoginPage.driver, "activecases.filtermenu.status.btn.xpath").click();
	}

	/**
	 * This method is to click the new status button in the status section of the filter menu of the active cases page
	 *
	 * @throws IOException
	 */
	public void clickNewStatusButtonACP() throws IOException {
		logger.info("User clicks new status button in filter menu");
		utility.initializeElement(LoginPage.driver, "activecases.filtermenu.status.new.btn.xpath").click();
	}

	/**
	 * This method is to click the done button in the filter menu on the Active Cases Page
	 *
	 * @throws IOException
	 */
	public void clickDoneButtonFilterMenuACP() throws IOException {
		logger.info("User clicks done button in filter menu on Active Cases Page");
		utility.initializeElement(LoginPage.driver, "activecases.filtermenu.done.btn.xpath").click();
	}

	/**
	 * This method is to check the difference between Created Date and Due Date
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkCreatedAgainstDueDate() throws IOException {
		String firstDate = utility.initializeElement(LoginPage.driver, "activecases.table.createddate.firstentry.txt.xpath").getText();
		String firstDateSplit[] = firstDate.split(" ");
		String firstDateDay = firstDateSplit[0];
		String firstDateDaySplit[] = firstDateDay.split("/");
		String firstDateMiddle = firstDateDaySplit[1];
		String firstDateTime = firstDateSplit[1];
		String secondDate = utility.initializeElement(LoginPage.driver, "activecases.table.duedate.firstentry.txt.xpath").getText();
		String secondDateSplit[] = secondDate.split(" ");
		String secondDateDay = secondDateSplit[0];
		String secondDateTime = secondDateSplit[1];
		String secondDateDaySplit[] = secondDateDay.split("/");
		String secondDateMiddle = secondDateDaySplit[1];

		int firstDay = Integer.parseInt(firstDateMiddle);
		int secondDay = Integer.parseInt(secondDateMiddle);
		int difference = secondDay - firstDay;

		if(!firstDateTime.equals(secondDateTime)) {
			logger.info("The time on each day is not equivalent");
		}

		if(difference == 2) {
			logger.info("The Created and Due dates are exactly 2 days apart");
			return true;
		}
		if(difference == 4) {
			logger.info("The created and due dates are 4 days apart, meaning it is a weekend");
			return true;
		}
		if(difference < 0) {
			logger.info("Difference between the due date and created dates is negative, meaning it moves into a new month");
			return true;
		}
		logger.info("Default date is not correct");
		return false;
	}

	/**
	 * This method is to get the difference between created and due date
	 *
	 * @throws IOException
	 */
	public void getCreatedDueDateDifference() throws IOException {
		String firstDate = utility.initializeElement(LoginPage.driver, "activecases.table.createddate.firstentry.txt.xpath").getText();
		String firstDateSplit[] = firstDate.split(" ");
		String firstDateDay = firstDateSplit[0];
		String firstDateDaySplit[] = firstDateDay.split("/");
		String firstDateMiddle = firstDateDaySplit[1];
		String secondDate = utility.initializeElement(LoginPage.driver, "activecases.table.duedate.firstentry.txt.xpath").getText();
		String secondDateSplit[] = secondDate.split(" ");
		String secondDateDay = secondDateSplit[0];
		String secondDateDaySplit[] = secondDateDay.split("/");
		String secondDateMiddle = secondDateDaySplit[1];

		int firstDay = Integer.parseInt(firstDateMiddle);
		int secondDay = Integer.parseInt(secondDateMiddle);
		int difference = secondDay - firstDay;

		if(difference < 0) {
			logger.info("Difference is negative meaning the dates cut into a new month, read difference manually");
		} else {
			logger.info("Difference between Created and Due Date: " + difference);
		}
	}

	/**
	 * This method is to print the Time Until Due value
	 *
	 * @throws IOException
	 */
	public void printTimeUntilDueValue() throws IOException {
		logger.info("Time Until Due: " + utility.initializeElement(LoginPage.driver, "activecases.table.timeuntildue.firstentry.txt.xpath").getText());
	}

	/**
	 * This method is to click the status button in the filter menu for hil reviewer
	 *
	 * @throws IOException
	 */
	public void clickStatusButtonReviewer() throws IOException {
		logger.info("Reviewer User clicks status button in filter menu");
		utility.initializeElement(LoginPage.driver, "activecases.reviewer.filtermenu.status.btn.xpath").click();
	}

	/**
	 * This method is to click the new status button for hil reviewer
	 *
	 * @throws IOException
	 */
	public void clickNewStatusButtonReviewer() throws IOException {
		logger.info("Reviewer user clicks new status button in filter menu");
		utility.initializeElement(LoginPage.driver, "activecases.reviewer.filtermenu.status.new.btn.xpath").click();
	}

	/**
	 * This method is to click the done button for hil reviewer
	 *
	 * @throws IOException
	 */
	public void clickDoneButtonReviewer() throws IOException {
		logger.info("Reviewer user clicks done button in filter menu");
		utility.initializeElement(LoginPage.driver, "activecases.reviewer.filtermenu.done.btn.xpath").click();
	}

	/**
	 * This method is to save the time until due entry
	 *
	 * @return String
	 * @throws IOException
	 */
	public String getTimeUntilDue() throws IOException {
		return utility.initializeElement(LoginPage.driver, "activecases.table.timeuntildue.firstentry.txt.xpath").getText();
	}

	/**
	 * This method is to click the edit date button for the first entry
	 *
	 * @throws IOException
	 */
	public void clickEditDateButton() throws IOException {
		logger.info("User clicks edit date button");
		utility.initializeElement(LoginPage.driver, "activecases.editdate.btn.xpath").click();
	}

	/**
	 * This method is to check if the select a new date header is displayed
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkIfNewDateHeaderIsDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "activecases.editdate.header.txt.xpath").isDisplayed();
	}

	/**
	 * This method is to select the day in the calendar after the current day
	 *
	 * @throws IOException
	 */
	public void clickDayAfterCurrentDay() throws IOException {
		LocalDate today = LocalDate.now();
		DayOfWeek dayOfWeek = today.getDayOfWeek();
		int dayVal = dayOfWeek.getValue();
		Calendar cal = Calendar.getInstance();
		String DATE_FORMAT_NOW = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String todayDate = sdf.format(cal.getTime());
		String todaysDate[] = todayDate.split("-");
		String todayDayString = todaysDate[2];
		int todayDayValue = Integer.valueOf(todayDayString);
		int valToClick = todayDayValue + 1;
		if(dayVal == 5) {
			valToClick = valToClick + 2;
		}
		if(dayVal == 6) {
			valToClick = valToClick + 1;
		}
		List<WebElement> calendar = utility.initializeElements(LoginPage.driver, "activecases.editdate.table.xpath");
		calendar.get(valToClick - 1).click();
	}

	/**
	 * This method is to click the submit button
	 *
	 * @throws IOException
	 */
	public void clickSubmitButtonEditDatePopUp() throws IOException {
		logger.info("User clicks submit button");
		utility.initializeElement(LoginPage.driver, "activecases.editdate.submit.btn.xpath").click();
	}

	/**
	 * This method is to select the day in the calendar two days after the current day
	 *
	 * @throws IOException
	 */
	public void clickTwoDaysAfterCurrentDay() throws IOException {
		LocalDate today = LocalDate.now();
		DayOfWeek dayOfWeek = today.getDayOfWeek();
		int dayVal = dayOfWeek.getValue();
		Calendar cal = Calendar.getInstance();
		String DATE_FORMAT_NOW = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String todayDate = sdf.format(cal.getTime());
		String todaysDate[] = todayDate.split("-");
		String todayDayString = todaysDate[2];
		int todayDayValue = Integer.valueOf(todayDayString);
		int valToClick = todayDayValue + 2;
		if(dayVal == 4) {
			valToClick = valToClick + 2;
		}
		if(dayVal == 5) {
			valToClick = valToClick + 1;
		}
		List<WebElement> calendar = utility.initializeElements(LoginPage.driver, "activecases.editdate.table.xpath");
		calendar.get(valToClick - 1).click();
	}

	/**
	 * This method is to click the pm button
	 *
	 * @throws IOException
	 */
	public void clickPMButton() throws IOException {
		logger.info("User clicks PM Button");
		utility.initializeElement(LoginPage.driver, "activecases.editdate.pm.btn.xpath").click();
	}

	/**
	 * This method is to click the cancel button
	 *
	 * @throws IOException
	 */
	public void clickCancelButton() throws IOException {
		logger.info("User clicks Cancel button");
		utility.initializeElement(LoginPage.driver, "activecases.editdate.cancel.btn.xpath").click();
	}

	/**
	 * This method is to select the day in the calendar five days after the current day
	 *
	 * @throws IOException
	 */
	public void clickFiveDaysAfterCurrentDay() throws IOException {
		LocalDate today = LocalDate.now();
		DayOfWeek dayOfWeek = today.getDayOfWeek();
		int dayVal = dayOfWeek.getValue();
		Calendar cal = Calendar.getInstance();
		String DATE_FORMAT_NOW = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String todayDate = sdf.format(cal.getTime());
		String todaysDate[] = todayDate.split("-");
		String todayDayString = todaysDate[2];
		int todayDayValue = Integer.valueOf(todayDayString);
		int valToClick = todayDayValue + 5;
		if(dayVal == 1) {
			valToClick = valToClick + 2;
		}
		if(dayVal == 2) {
			valToClick = valToClick + 1;
		}
		List<WebElement> calendar = utility.initializeElements(LoginPage.driver, "activecases.editdate.table.xpath");
		calendar.get(valToClick - 1).click();
	}

	/**
	 * This method is to select the day in the calendar five days after the current day
	 *
	 * @throws IOException
	 */
	public void clickCurrentDate() throws IOException {
		LocalDate today = LocalDate.now();
		DayOfWeek dayOfWeek = today.getDayOfWeek();
		Calendar cal = Calendar.getInstance();
		String DATE_FORMAT_NOW = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String todayDate = sdf.format(cal.getTime());
		String todaysDate[] = todayDate.split("-");
		String todayDayString = todaysDate[2];
		int todayDayValue = Integer.valueOf(todayDayString);
		int valToClick = todayDayValue;
		List<WebElement> calendar = utility.initializeElements(LoginPage.driver, "activecases.editdate.table.xpath");
		calendar.get(valToClick - 1).click();
	}

	/**
	 * This method is to check if the status says overdue for the first entry
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkOverdueStatus() throws IOException {
		String statusText = utility.initializeElement(LoginPage.driver, "activecases.table.firstentry.overdue.status.txt.xpath").getText();
		if(statusText.contains("Overdue")) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * This method is used to Select particular username
	 * @param username
	 * @return 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void chooseRecordForUsername() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		//String name = null;
		List<WebElement> usernames = LoginPage.driver.findElements(By.xpath("/html/body/app-root/app-active-case/div/div/cdk-virtual-scroll-viewport/div[1]/table/tbody/tr/td[5]/div/span[2]"));
		for(WebElement username:usernames) {
			if(username.getText().equals(properties.getProperty("username"))) {
				logger.info("username*****"+username.getText());
				String name = username.getText();
			}
		
	}}
	/**
	 * This method is used to get click auditlogicon
	 * @param username
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void clickAuditLogIcon()throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		List<WebElement> usernames = LoginPage.driver.findElements(By.xpath("/html/body/app-root/app-active-case/div/div/cdk-virtual-scroll-viewport/div[1]/table/tbody/tr/td[5]/div/span[2]"));
		for(WebElement username:usernames) {
			if(username.getText().equals(properties.getProperty("username"))) {
				username.findElement(By.xpath("//*[@id=\"patientDescription\"]")).click();
				logger.info("clicked audit log icon");
				break;
			}
						}
		
	}
}
