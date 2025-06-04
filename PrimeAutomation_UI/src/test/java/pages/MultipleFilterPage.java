package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Utility;

public class MultipleFilterPage {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(MultipleFilterPage.class);
	Utility utility = new Utility();
	FileDashboardPage fdPage = new FileDashboardPage();

	/**
	 * This method is used to select date filter
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public void selectsDateFilterOnDashboard() throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		try {
			utility.initializeElement(LoginPage.driver, "filter.option.date.xpath").click();
			logger.info("Date filter is selected: "
					+ utility.initializeElement(LoginPage.driver, "filter.option.date.xpath").isDisplayed());
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "filter.option.date.xpath"));
			logger.info("Date Filter is selected : "
					+ utility.initializeElement(LoginPage.driver, "filter.option.date.xpath").isDisplayed());
		}
		utility.initializeElement(LoginPage.driver, "filter.option.startdate.xpath").click();
		utility.initializeElement(LoginPage.driver, "filter.calender.firstdatecolumn.xpath").click();
		utility.initializeElement(LoginPage.driver, "filter.option.enddate.xpath").click();
		utility.initializeElement(LoginPage.driver, "filter.calender.firstdatecolumn.xpath").click();
	}

	/**
	 * This method is used to select surgeon filter
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public void selectsSurgeonFilterOnDashboard() throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		try {
			utility.initializeElement(LoginPage.driver, "dashboard.list.surgeonfilter.xpath").click();
			logger.info("Surgeon filter is selected: "
					+ utility.initializeElement(LoginPage.driver, "dashboard.list.surgeonfilter.xpath").isDisplayed());
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "dashboard.list.surgeonfilter.xpath"));
			logger.info("Surgeon Filter is selected : "
					+ utility.initializeElement(LoginPage.driver, "dashboard.list.surgeonfilter.xpath").isDisplayed());
		}
		utility.initializeElement(LoginPage.driver, "dashboard.filter.surgeonname.crnp.xpath").click();
		logger.info("Surgeon name is selected : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.surgeonname.crnp.xpath").isDisplayed());
	}

	/**
	 * This method is used to select site filter
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public void selectsSiteFilterOnDashboard() throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		try {
			utility.initializeElement(LoginPage.driver, "filter.option.site.xpath").click();
			logger.info("Site filter is selected: "
					+ utility.initializeElement(LoginPage.driver, "filter.option.site.xpath").isDisplayed());
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "filter.option.site.xpath"));
			logger.info("Site Filter is selected : "
					+ utility.initializeElement(LoginPage.driver, "filter.option.site.xpath").isDisplayed());
		}
		utility.initializeElement(LoginPage.driver, "dashboard.filter.sitename.acmh.xpath").click();
		logger.info("Site name is selected : "
				+ utility.initializeElement(LoginPage.driver, "dashboard.filter.sitename.acmh.xpath").isDisplayed());
	}

	/**
	 * This method is used to click on done button
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public void clicksOnDoneButton() throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		try {
			logger.info("Done button is clicked: "
					+ utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").isDisplayed());
			utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").click();
		} catch (Exception e) {
			logger.info("Done button is clicked : "
					+ utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath").isDisplayed());
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "dashboard.filter.btn.done.xpath"));

		}

	}

	/**
	 * This method is used to select application filter
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public void selectsApplicationFilterOnDashboard() throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		try {
			utility.initializeElement(LoginPage.driver, "filter.option.application.xpath").click();
			logger.info("Application filter is selected: "
					+ utility.initializeElement(LoginPage.driver, "filter.option.application.xpath").isDisplayed());
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "filter.option.application.xpath"));
			logger.info("Application Filter is selected : "
					+ utility.initializeElement(LoginPage.driver, "filter.option.application.xpath").isDisplayed());
		}
		utility.initializeElement(LoginPage.driver, "dashboard.filter.applicationname.fai7.xpath").click();
		logger.info("Application name is selected : " + utility
				.initializeElement(LoginPage.driver, "dashboard.filter.applicationname.fai7.xpath").isDisplayed());
	}

	/**
	 * This method is used to check if summary dashboard multiple filter displayed
	 * or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isMultiFilterListDisplayed() throws IOException, InterruptedException {
		List<WebElement> multiFilter = utility.initializeElements(LoginPage.driver,
				"dashboard.filter.multifilter.xpath");
		if (multiFilter.size() >= 1) {
			for (int i = 0; i < multiFilter.size(); i++) {
				{
					logger.info("Filter name is : " + multiFilter.get(i).getText().replaceAll(" X", "").trim());

				}
			}
		}
		Thread.sleep(500);
		List<WebElement> multiFilterList = utility.initializeElements(LoginPage.driver,
				"dashboard.filter.multifilterlist.xpath");
		if (multiFilterList.size() >= 1) {
			for (int i = 0; i < multiFilterList.size(); i++) {
				{
					logger.info("Filtered list is : " + multiFilterList.get(i).getText());

				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check if history page displayed all items without
	 * filter or not or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isAllItemsDisplayedOnDashboard() throws IOException, InterruptedException {
		List<WebElement> List = utility.initializeElements(LoginPage.driver, "dashboard.filter.multifilterlist.xpath");
		int size = List.size();
		logger.info("No. of total list without filter" + size);
		if (size >= 1) {
			for (int i = 0; i < List.size(); i++) {
				
					logger.info("Summary dashboard list item without filter is : " + List.get(i).getText());

				
			}
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	/**
	 * This method is used to remove filter
	 * 
	 * @return WebElement
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void removeFilters() throws IOException, InterruptedException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		try {
			while (true) {
				utility.initializeElement(LoginPage.driver, "history.filter.btn.x.xpath").click();
				logger.info("Filter is removed");
				fdPage.waitForSpinnerToDisappear();
			}
		} catch (Exception e) {
			logger.info("No more filter present");
		}

	}

	/**
	 * This method is used to select uploader filter
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public void selectsUploaderFilterOnHistory() throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		try {
			utility.initializeElement(LoginPage.driver, "history.filter.uploader.xpath").click();
			logger.info("Uploader filter is clicked: "
					+ utility.initializeElement(LoginPage.driver, "history.filter.uploader.xpath").isDisplayed());
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "history.filter.uploader.xpath"));
			logger.info("Uploader Filter is clicked : "
					+ utility.initializeElement(LoginPage.driver, "history.filter.uploader.xpath").isDisplayed());
		}
		utility.initializeElement(LoginPage.driver, "history.filter.uploadername.xpath").click();
		logger.info("Uploader name is selected : "
				+ utility.initializeElement(LoginPage.driver, "history.filter.uploadername.xpath").isDisplayed());
		logger.info("Selected uploader name is : "
				+ utility.initializeElement(LoginPage.driver, "history.filter.uploadername.xpath").getText());
	}

	/**
	 * This method is used to select patient filter
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public void selectsPatientFilterOnHistory() throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		try {
			utility.initializeElement(LoginPage.driver, "history.filter.patient.xpath").click();
			logger.info("Patient filter is clicked: "
					+ utility.initializeElement(LoginPage.driver, "history.filter.patient.xpath").isDisplayed());
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "history.filter.patient.xpath"));
			logger.info("Patient Filter is clicked : "
					+ utility.initializeElement(LoginPage.driver, "history.filter.patient.xpath").isDisplayed());
		}
		utility.initializeElement(LoginPage.driver, "history.filter.patientname.zeorone.xpath").click();
		logger.info("Patient name is selected : " + utility
				.initializeElement(LoginPage.driver, "history.filter.patientname.zeorone.xpath").isDisplayed());
		logger.info("selected patient name is : "
				+ utility.initializeElement(LoginPage.driver, "history.filter.patientname.zeorone.xpath").getText());
	}

	/**
	 * This method is used to check if history page multiple filter displayed or not
	 * or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isMultiFilterListDisplayedOnHistory() throws IOException, InterruptedException {
		List<WebElement> multiFilter = utility.initializeElements(LoginPage.driver,
				"dashboard.filter.multifilter.xpath");
		if (multiFilter.size() >= 1) {
			for (int i = 0; i < multiFilter.size(); i++) {
				{
					logger.info("Filter name is : " + multiFilter.get(i).getText().replaceAll(" X", "").trim());

				}
			}
		}
		Thread.sleep(1000);
		// try {
		List<WebElement> multiFilterList = utility.initializeElements(LoginPage.driver,
				"history.filter.multifilterlist.xpath");
		int size = multiFilterList.size();
		logger.info("No. of total filtered list is : " + size);
		if (size >= 1) {
			for (int i = 0; i < multiFilterList.size(); i++) {
				{
					logger.info("Filtered list is : " + multiFilterList.get(i).getText());

				}
			}
			return true;
		}
		Thread.sleep(1000);
//		}catch (Exception e){
//			e.printStackTrace();
//		}
		return false;
	}

	/**
	 * This method is used to check if history page displayed all items without
	 * filter or not or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isAllItemsDisplayedOnHisotry() throws IOException, InterruptedException {
		List<WebElement> List = utility.initializeElements(LoginPage.driver, "history.filter.multifilterlist.xpath");
		int size = List.size();
		if (size >= 1) {
			for (int i = 0; i < List.size(); i++) {
				{
					logger.info("Hisotry page list item without filter is : " + List.get(i).getText());

				}
			}
			Thread.sleep(1000);
			return true;
		}
		return false;
	}

	/**
	 * This method is used to click on filter button
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public void clickOnFilterButton() throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.filter.btn.xpath").click();
			logger.info("Filter button is clicked: "
					+ utility.initializeElement(LoginPage.driver, "auditlog.filter.btn.xpath").isDisplayed());
			fdPage.waitForSpinnerToDisappear();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "auditlog.filter.btn.xpath"));
			logger.info("Filter button is clicked : "
					+ utility.initializeElement(LoginPage.driver, "auditlog.filter.btn.xpath").isDisplayed());
			fdPage.waitForSpinnerToDisappear();
		}
	}

	/**
	 * This method is used to select username filter
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public void selectsUsernameFilterOnDashboard() throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		try {
			utility.initializeElement(LoginPage.driver, "auditlog.filter.username.xpath").click();
			logger.info("Username filter is clicked: "
					+ utility.initializeElement(LoginPage.driver, "auditlog.filter.username.xpath").isDisplayed());
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					utility.initializeElement(LoginPage.driver, "auditlog.filter.username.xpath"));
			logger.info("Username Filter is clicked : "
					+ utility.initializeElement(LoginPage.driver, "auditlog.filter.username.xpath").isDisplayed());
		}
		utility.initializeElement(LoginPage.driver, "auditlog.filter.username.icadmin.xpath").click();
		logger.info("Username name is selected : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.filter.username.icadmin.xpath").isDisplayed());
		logger.info("selected username is : "
				+ utility.initializeElement(LoginPage.driver, "auditlog.filter.username.icadmin.xpath").getText());
	}

}
