package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.PropertiesFileReader;
import utility.Utility;

public class HilCaseHistoryPage {

	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HilCaseHistoryPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to click Case History Button screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnCaseHistoryBtn() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "casehistory.btn.xpath").click();
		logger.info("click Case History Button : Clicked Case History button");
	}

	/**
	 * This method is used to click error icon filter on Case History screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnErrorIcon() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "casehistory.error.icon.xpath").click();
		logger.info("click Error icon filter : Clicked Error icon filter");
	}

	/**
	 * This method is used to click on Search box in Case History screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSearchBox() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "casehistory.searchbox.xpath").click();
		logger.info("click Search box : Clicked Search Box");
	}

	/**
	 * This method is used to click on Search button in Case History screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSearchButton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "casehistory.search.btn.xpath").click();
		logger.info("click Search button : Clicked Search Button");
	}

	/**
	 * This method is used to click on Settings button in Case History screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSettingsButton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "casehistory.settings.btn.xpath").click();
		logger.info("click Settings button : Clicked Settings Button");
	}

	/**
	 * This method is used to click on Exit app button in Case History screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnExitAppButton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "casehistory.exit.btn.xpath").click();
		logger.info("click Exit App button : Clicked Exit App Button");
	}

	/**
	 * This method is used to get the text for the logged user in Case History
	 * screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String userLoggedText() throws IOException {
		return utility.initializeElement(LoginPage.driver, "casehistory.username.txt.xpath").getText();
	}

	/**
	 * This method is used to click on Filter button in Case History screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnFilterButton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "casehistory.filter.btn.xpath").click();
		logger.info("click Filter button : Clicked Filter Button");
	}

	/**
	 * This method is used to click on Done button while clicking on filter in Case
	 * History screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnDoneButton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "casehistory.done.btn.xpath").click();
		logger.info("click Done button : Clicked Done Button");
	}

	/**
	 * This method is used to check Filter menu options displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isFilterMenuDisplayed(String menu) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (menu.equalsIgnoreCase("Filter By")) {
			logger.info("Filter by option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "casehistory.filterby.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "casehistory.filterby.xpath");
		}
		if (menu.equalsIgnoreCase("Anatomy")) {
			logger.info("Anatomy option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "casehistory.anatomy.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "casehistory.anatomy.xpath");
		}
		if (menu.equalsIgnoreCase("Type")) {
			logger.info("Type option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "casehistory.type.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "casehistory.type.xpath");
		}
		if (menu.equalsIgnoreCase("Status")) {
			logger.info("Status option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "casehistory.status.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "casehistory.status.xpath");
		}
		if (menu.equalsIgnoreCase("Due Date")) {
			logger.info("Due Date option is displayed : "
					+ utility.initializeElement(LoginPage.driver, "casehistory.duedate.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver, "casehistory.duedate.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + menu);
		return null;
	}

	/**
	 * This method is used to check error filter displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isErrorIconDisplayed() throws IOException 
	{
		logger.info("Error filter is displayed : "
				+ utility.initializeElement(LoginPage.driver, "casehistory.error.icon.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "casehistory.error.icon.xpath").isDisplayed();
	}

	/**
	 * This method is used to Search Box displayed or not.
	 * 
	 * @throws IOException
	 */
	public boolean isSearchBoxDisplayed() throws IOException {
		logger.info("Search Box is displayed : "
				+ utility.initializeElement(LoginPage.driver, "casehistory.searchbox.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "casehistory.searchbox.xpath").isDisplayed();
	}
	
	/**
	 * This method is to click the filter button in the case history page
	 * 
	 * @throws IOException
	 */
	public void clickFilterButtonCHPage() throws IOException {
		logger.info("User clicks Filter button in Case History Page");
		utility.initializeElement(LoginPage.driver, "casehistory.filtermenu.btn.xpath").click();
	}
	
	/**
	 * This method is to click the status button in the case history filter menu
	 * 
	 * @throws IOException
	 */
	public void clickStatusFilterMenuOption() throws IOException {
		logger.info("User clicks status button in case history page pop up menu");
		utility.initializeElement(LoginPage.driver, "casehistory.filtermenu.status.xpath").click();
	}
	
	/**
	 * This method is to click the approved button in the case history filter menu
	 * 
	 * @throws IOException
	 */
	public void clickApprovedButtonInCHFilterMenu() throws IOException {
		logger.info("User clicks approved button in filter menu");
		utility.initializeElement(LoginPage.driver, "casehistory.filtermenu.status.approved.xpath").click();
	}
	
	/**
	 * This method is to click the done button in the case history filter menu
	 * 
	 * @throws IOException
	 */
	public void clickDoneButtonInCHFilterMenu() throws IOException {
		logger.info("User clicks done button in filter menu");
		utility.initializeElement(LoginPage.driver, "casehistory.filtermenu.done.btn.xpath").click();
	}
	
	/**
	 * This method is used to check if the view button is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean isCHViewButtonDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "casehistory.table.firstentry.viewbutton.xpath").isDisplayed();
	}
	
	/**
	 * This method is to click the view button in the CH page
	 * 
	 * @throws IOException
	 */
	public void clickCHViewButton() throws IOException {
		logger.info("User clicks Case History View Button");
		utility.initializeElement(LoginPage.driver, "casehistory.table.firstentry.viewbutton.xpath").click();
	}
	
	/**
	 * This method is to check if the following components are disabled on View Mode
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isViewModeButtonsDisabled(String component) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (component.equalsIgnoreCase("lasso")) {
			return utility.initializeElement(LoginPage.driver, "casehistory.view.lasso.btn.xpath");
		}
		if (component.equalsIgnoreCase("brush")) {
			return utility.initializeElement(LoginPage.driver, "casehistory.view.brush.btn.xpath");
		}
		if (component.equalsIgnoreCase("eraser")) {
			return utility.initializeElement(LoginPage.driver, "casehistory.view.eraser.btn.xpath");
		}
		if (component.equalsIgnoreCase("approve")) {
			return utility.initializeElement(LoginPage.driver, "casehistory.view.approve.btn.xpath");
		}
		if (component.equalsIgnoreCase("save")) {
			return utility.initializeElement(LoginPage.driver, "casehistory.view.save.btn.xpath");
		}
		if (component.equalsIgnoreCase("reject")) {
			return utility.initializeElement(LoginPage.driver, "casehistory.view.reject.btn.xpath");
		}
		if (component.equalsIgnoreCase("ctrl z")) {
			return utility.initializeElement(LoginPage.driver, "casehistory.view.ctrlz.btn.xpath");
		}
		if (component.equalsIgnoreCase("ctrl y")) {
			return utility.initializeElement(LoginPage.driver, "casehistory.view.ctrly.btn.xpath");
		}
		if (component.equalsIgnoreCase("reset changes")) {
			return utility.initializeElement(LoginPage.driver, "casehistory.view.resetchanges.btn.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + component);
		return null;
	}
	
	/**
	 * This method is used to check all the columns are displayed
	 * @return
	 * @throws IOException
	 */
	public boolean is9ColumnsDisplayed() throws IOException {
		boolean isInfoIconColumnDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.column.iconinfo.value.xpath").isDisplayed();
		boolean isCaseidColumnDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.column.caseid.value.xpath").isDisplayed();
		boolean isAnatomyColumnDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.column.anatomy.value.xpath").isDisplayed();
		boolean isTypeColumnDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.column.type.value.xpath").isDisplayed();
		boolean isStatusColumnDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.column.status.value.xpath").isDisplayed();
		boolean isReviewerColumnDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.column.reviewer.value.xpath").isDisplayed();
		boolean isCompletedDateColumnDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.column.completeddate.value.xpath").isDisplayed();
		boolean isDueDateColumnDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.column.duedate.value.xpath").isDisplayed();
		boolean isReviewTimeColumnDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.column.reviewtime.value.xpath").isDisplayed();


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
		if(isReviewerColumnDisplayed)
		{logger.info("Column6: Reviewer is displayed");}
		if(isCompletedDateColumnDisplayed)
		{logger.info("Column7: Completed date is displayed");}
		if(isDueDateColumnDisplayed)
		{logger.info("Column8: Due Date is displayed");}
		if(isReviewTimeColumnDisplayed)
		{logger.info("Column9: Review Time is displayed");}
		return isInfoIconColumnDisplayed && isCaseidColumnDisplayed && isAnatomyColumnDisplayed
			&&	isTypeColumnDisplayed	&& isStatusColumnDisplayed && isReviewerColumnDisplayed
			&& isCompletedDateColumnDisplayed && isDueDateColumnDisplayed && isReviewTimeColumnDisplayed;
	}
	
	/**
	 * This method is to click clear all filters button in filter menu
	 * 
	 * @throws IOException
	 */
	public void clickClearAllFiltersButton() throws IOException {
		logger.info("User clicked clear all filters button");
		utility.initializeElement(LoginPage.driver, "casehistory.filtermenu.clearallfilters.btn.xpath").click();
	}
	
	/**
	 * This method is to click the error status button in filter menu
	 * 
	 * @throws IOException
	 */
	public void clickErrorStatusButtonFilter() throws IOException {
		logger.info("User clicked error status button in filter menu");
		utility.initializeElement(LoginPage.driver, "casehistory.filtermenu.status.error.xpath").click();
	}
	
	/**
	 * This method is to verify the view button is not displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkForNoViewButton() throws IOException {
		List<WebElement> list = utility.initializeElements(LoginPage.driver, "casehistory.table.firstentry.viewbutton.xpath");
		return list.isEmpty();
	}
	
	/**
	 * This method is to print the completed date error entry
	 * 
	 * @throws IOException
	 */
	public void printCompletedDate() throws IOException {
		logger.info("Completed date: " + utility.initializeElement(LoginPage.driver, "casehistory.table.column.completeddate.value.xpath").getText());
	}
	
	/**
	 * This method is to print the review time error entry
	 * 
	 * @throws IOException
	 */
	public void printReviewTime() throws IOException {
		logger.info("Review Time :" + utility.initializeElement(LoginPage.driver, "casehistory.table.column.completeddate.value.xpath").getText());
	}
	
	/**
	 * This method is to check if the settings button is displayed in the top bar
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkForSettingsButtonTopBar() throws IOException {
		return utility.initializeElement(LoginPage.driver, "casehistory.top.bar.settings.icon.xpath").isDisplayed();
	}
	
	/**
	 * This method is to check for the error icon
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkForErrorIcon() throws IOException {
		return utility.initializeElement(LoginPage.driver, "casehistory.table.firstentry.error.icon.xpath").isDisplayed();
	}
	
	/**
	 * This method is to check for the error filter button
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkForErrorFilterButton() throws IOException {
		return utility.initializeElement(LoginPage.driver, "casehistory.top.bar.error.filter.btn.xpath").isDisplayed();
	}
	
	/**
	 * This method is to click the error filter button
	 * 
	 * @throws IOException
	 */
	public void clickErrorFilterButton() throws IOException {
		logger.info("User clicks error filter button");
		utility.initializeElement(LoginPage.driver, "casehistory.top.bar.error.filter.btn.xpath").click();
	}
	
	/**
	 * This method is to check for the filter button
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkFilterButton() throws IOException {
		return utility.initializeElement(LoginPage.driver, "casehistory.filtermenu.btn.xpath").isDisplayed();
	}
	
	/**
	 * This method is to check for the search bar on case history page
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkSearchBarCHPage() throws IOException {
		return utility.initializeElement(LoginPage.driver, "casehistory.search.bar.xpath").isDisplayed();
	}
	
	/**
	 * This method is to check for the search button on case history page
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkSearchButtonCHPage() throws IOException {
		return utility.initializeElement(LoginPage.driver, "casehistory.search.button.xpath").isDisplayed();
	}
	
	/**
	 * This method is to check for the show more button on case history page
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkShowMoreButtonCHPage() throws IOException {
		return utility.initializeElement(LoginPage.driver, "casehistory.showmore.btn.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check all the sorting arrows are displayed
	 * @return
	 * @throws IOException
	 */
	public boolean isSortingArrowsDisplayed() throws IOException {
		boolean isStatusArrowDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.sorting.arrow.status.xpath").isDisplayed();
		boolean isReviewerArrowDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.sorting.arrow.reviewer.xpath").isDisplayed();
		boolean isCompletedDateArrowDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.sorting.arrow.completeddate.xpath").isDisplayed();
		boolean isDueDateArrowDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.sorting.arrow.duedate.xpath").isDisplayed();
		boolean isReviewTimeArrowDisplayed = utility.initializeElement(LoginPage.driver,"casehistory.table.sorting.arrow.reviewtime.xpath").isDisplayed();
		


		if(isStatusArrowDisplayed)
		{logger.info("Status Sorting Arrow is displayed");}
		if(isReviewerArrowDisplayed)
		{logger.info("Reviewer Sorting Arrow is displayed");}
		if(isCompletedDateArrowDisplayed)
		{logger.info("Completed Date Sorting Arrow is displayed");}
		if(isDueDateArrowDisplayed)
		{logger.info("Due Date Sorting Arrow is displayed");}
		if(isReviewTimeArrowDisplayed)
		{logger.info("Review Time Sorting Arrow is displayed");}
		
		return isStatusArrowDisplayed && isReviewerArrowDisplayed && isCompletedDateArrowDisplayed
			&&	isDueDateArrowDisplayed	&& isReviewTimeArrowDisplayed;
	}
	
	/**
	 * This method is to click the first case audit log button
	 * 
	 * @throws IOException
	 */
	public void clickFirstCaseAuditLog() throws IOException {
		logger.info("User clicks first case audit log button");
		utility.initializeElement(LoginPage.driver, "casehistory.table.firstentry.auditlog.btn.xpath").click();
	}
	
	/**
	 * This method is to verify the format of review time
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean verifyReviewTimeFormat() throws IOException {
		String text = utility.initializeElement(LoginPage.driver, "casehistory.firstentry.reviewtime.txt.xpath").getText();
		int colonCount = 0;
		for(int i = 0; i < text.length(); i++) {
			char j = text.charAt(i);
			if(j == ':') {
				colonCount++;
			}
		}
		if(colonCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method is to verify the format of completed date
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean verifyCompletedDateFormat() throws IOException {
		String text = utility.initializeElement(LoginPage.driver, "casehistory.firstentry.completeddate.txt.xpath").getText();
		int colonCount = 0;
		int slashCount = 0;
		for(int i = 0; i < text.length(); i++) {
			char j = text.charAt(i);
			if(j == ':') {
				colonCount++;
			}
			if(j == '/') {
				slashCount++;
			}
		}
		if(colonCount > 0 && slashCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method is to verify the format of due date
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean verifyDueDateFormat() throws IOException {
		String text = utility.initializeElement(LoginPage.driver, "casehistory.firstentry.duedate.txt.xpath").getText();
		int colonCount = 0;
		int slashCount = 0;
		for(int i = 0; i < text.length(); i++) {
			char j = text.charAt(i);
			if(j == ':') {
				colonCount++;
			}
			if(j == '/') {
				slashCount++;
			}
		}
		if(colonCount > 0 && slashCount > 0) {
			return true;
		} else {
			return false;
		}
	}
}
