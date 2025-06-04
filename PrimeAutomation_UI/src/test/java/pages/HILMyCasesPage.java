package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import utility.PropertiesFileReader;
import utility.Utility;

public class HILMyCasesPage {
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HILMyCasesPage.class);
	Utility utility = new Utility();
	
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
		if (header.equalsIgnoreCase("Completed Date")) {
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
	 * This method is used to check all column headers are displayed
	 * @return
	 * @throws IOException
	 */
	public boolean isColumnHeadersDisplayed() throws IOException {
		boolean isCaseIdHeaderDisplayed = locateTableHeaders("case ID").isDisplayed();
		boolean isAnatomyHeaderDisplayed = locateTableHeaders("Anatomy").isDisplayed();
		boolean isTypeHeaderDisplayed = locateTableHeaders("Type").isDisplayed();
		boolean isStatusHeaderDisplayed = locateTableHeaders("Status").isDisplayed();
		boolean isCompletedDateHeaderDisplayed = locateTableHeaders("Completed Date").isDisplayed();
		boolean isDueDateHeaderDisplayed = locateTableHeaders("Due Date").isDisplayed();
		boolean istimeuntildueHeaderDisplayed = locateTableHeaders("time until due").isDisplayed();
		return isCaseIdHeaderDisplayed && isAnatomyHeaderDisplayed 
				&& isTypeHeaderDisplayed && isStatusHeaderDisplayed 
				&& isCompletedDateHeaderDisplayed && isDueDateHeaderDisplayed &&  istimeuntildueHeaderDisplayed;
	}
	
	

	/**
	 * This method is used to check all columns are diplayed
	 * @return
	 * @throws IOException
	 */
	public boolean is8ColumnsDisplayed() throws IOException {
		boolean isInfoIconColumnDisplayed = utility.initializeElement(LoginPage.driver,"mycases.table.column.info.xpath").isDisplayed();
		boolean isCaseidColumnDisplayed = utility.initializeElement(LoginPage.driver,"mycases.table.column.caseid.xpath").isDisplayed();
		boolean isAnatomyColumnDisplayed = utility.initializeElement(LoginPage.driver,"mycases.table.column.anatomy.xpath").isDisplayed();
		boolean isTypeColumnDisplayed = utility.initializeElement(LoginPage.driver,"mycases.table.column.type.xpath").isDisplayed();
		boolean isStatusColumnDisplayed = utility.initializeElement(LoginPage.driver,"mycases.table.column.status.xpath").isDisplayed();
		boolean isCompletedDateColumnDisplayed = utility.initializeElement(LoginPage.driver,"mycases.table.column.completeddate.xpath").isDisplayed();
		boolean isDueDateColumnDisplayed = utility.initializeElement(LoginPage.driver,"mycases.table.column.duedate.xpath").isDisplayed();
		boolean isTimeTillDueColumnDisplayed = utility.initializeElement(LoginPage.driver,"mycases.table.column.timeuntil.xpath").isDisplayed();
		boolean isClaimColumnDisplayed = utility.initializeElement(LoginPage.driver,"mycases.table.column.claim.xpath").isDisplayed();
		boolean isOpenColumnDisplayed = utility.initializeElement(LoginPage.driver,"mycases.table.column.open.xpath").isDisplayed();
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
		if(isCompletedDateColumnDisplayed)
		{logger.info("Column6: Completed Date is displayed");}
		if(isDueDateColumnDisplayed)
		{logger.info("Column7: Due date is displayed");}
		if(isTimeTillDueColumnDisplayed)
		{logger.info("Column8:Time until due is displayed");}
		if(isClaimColumnDisplayed)
		{logger.info("Column9:claim is displayed");}
		if(isOpenColumnDisplayed)
		{logger.info("Column8:Open is displayed");}
		return isInfoIconColumnDisplayed && isCaseidColumnDisplayed && isAnatomyColumnDisplayed
			&&	isTypeColumnDisplayed	&& isStatusColumnDisplayed && isCompletedDateColumnDisplayed
			&& isDueDateColumnDisplayed && isTimeTillDueColumnDisplayed; 
	}
	
	/**
	 * This method is used to check due date column sorting
	 * @param sortType
	 * @return
	 * @throws IOException
	 */
	public boolean isDueDateSorting(String sortType) throws IOException {
		String actualSortType = locateTableHeaders("Due Date").getAttribute("aria-sort");
		logger.info("actualSortType******"+actualSortType);
		List<WebElement> allDueDates = utility.initializeElements(LoginPage.driver,"mycases.table.column.duedate.xpath");
		logger.info("Displayed Due dates:");
		for(WebElement dueDate : allDueDates) {
			logger.info(dueDate.getText());
		}
		return actualSortType.equals(sortType);
	}
}
