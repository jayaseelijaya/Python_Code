package pages;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Utility;

public class SettingsPage {

	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(SettingsPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to click Settings page button from left menu bar
	 * 
	 * @throws IOException
	 */
	public void clickSettingsPage() throws IOException, InterruptedException {
		logger.info("User clicked settings page from left menu bar");
		utility.initializeElement(LoginPage.driver, "leftnavigation.settings.xpath").click();
	}

	/**
	 * This method is used to click settings reset to default button
	 * 
	 * @throws IOException
	 */
	public void setGlobalViewSettingToDefault() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.btn.resettodefault.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").click();
		logger.info("Global View Setting has been set to default");
	}

	/**
	 * This method is used to click file dashboard button from left menu bar
	 * 
	 * @throws IOException
	 */
	public void clickFileDashboardButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "leftnavigation.filedashboard.xpath").click();
		logger.info("User clicks file dashboard button from left menu");
	}

	/**
	 * This method is used to click history button from left menu bar
	 * 
	 * @throws IOException
	 */
	public void clickHistoryButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "leftnavigation.history.xpath").click();
		logger.info("User clicks history button from left menu");
	}

	/**
	 * This method is used to turn on global view setting
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void turnOnGlobalViewSetting() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "setting.btn.toggle.globalviewing.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").click();
		Thread.sleep(2000);
		logger.info("User turned on global view setting");
	}

	/**
	 * This method is used to check if successful upload text is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean isSuccessfulUploadDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Successful Upload Text is displayed");
			return true;
		} else {
			logger.info("Successful Upload Text is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if unsuccessful upload text is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean isUnsuccessfulUploadDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Unsuccessful Upload Text is displayed");
			return true;
		} else {
			logger.info("Unsuccessful Upload Text is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if Global View Toggle is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean isGlobalViewToggleDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "setting.btn.toggle.globalviewing.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Global View Toggle is displayed");
			return true;
		} else {
			logger.info("Global View Toggle is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if reset to default button is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean isResetToDefaultuttonDisplayedAndEnabled() throws IOException {
		Boolean bool1 = utility.initializeElement(LoginPage.driver, "setting.btn.resettodefault.xpath").isDisplayed();
		Boolean bool2 = utility.initializeElement(LoginPage.driver, "setting.btn.resettodefault.xpath").isEnabled();
		if (bool1 == true && bool2 == true) {
			logger.info("Reset to default button is displayed and enabled");
			return true;
		} else {
			logger.info("Reset to default button is not displayed and enabled");
			return false;
		}
	}

	/**
	 * This method is used to check if save button is displayed and disabled
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean isSaveButtonDisplayedAndDisabled() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").isDisplayed();
		Boolean bool2 = utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").isEnabled();
		if (bool == true && bool2 == false) {
			logger.info("Save button is displayed and disabled");
			return true;
		} else {
			logger.info("Save button is not displayed and disabled");
			return false;
		}
	}

	/**
	 * This method is used to check if settings page header is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean isSettingsPageHeaderDisplayed() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "setting.txt.settingheader.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Settings Page Header is displayed");
			return true;
		} else {
			logger.info("Settings Page Header is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if settings page header is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean areCosmeticLinesCorrect() throws IOException {
		Boolean bool1 = utility.initializeElement(LoginPage.driver, "setting.bar.cosmeticbar1.xpath").isDisplayed();
		Boolean bool2 = utility.initializeElement(LoginPage.driver, "setting.bar.cosmeticbar2.xpath").isDisplayed();
		Boolean bool3 = utility.initializeElement(LoginPage.driver, "setting.bar.cosmeticbar3.xpath").isDisplayed();
		String color1 = utility.initializeElement(LoginPage.driver, "setting.bar.cosmeticbar1.xpath")
				.getCssValue("color");
		String color2 = utility.initializeElement(LoginPage.driver, "setting.bar.cosmeticbar2.xpath")
				.getCssValue("color");
		String color3 = utility.initializeElement(LoginPage.driver, "setting.bar.cosmeticbar3.xpath")
				.getCssValue("color");
		if (bool1 == true && bool2 == true && bool3 == true && color1.contains("rgba(235, 235, 235, 1")
				&& color2.contains("rgba(235, 235, 235, 1") && color3.contains("rgba(235, 235, 235, 1")) {
			logger.info("Cosmetic lines are displayed correctly");
			return true;
		} else {
			logger.info("Cosmetic lines are not displayed correctly");
			return false;
		}
	}

	/**
	 * This method is used to check if settings text in left menu bar is green
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean isSettingsTextInLeftMenuBarGreen() throws IOException {
		String color = utility.initializeElement(LoginPage.driver, "setting.leftmenu.settings.txt.xpath")
				.getCssValue("color");
		if (color.contains("rgba(0, 203, 157, 1)")) {
			logger.info("Settings text in left menu bar is green");
			return true;
		} else {
			logger.info("Settings text in left menu bar is not green");
			return false;
		}
	}

	/**
	 * This method is used to enter the value 20 into the Successful Uploads Input
	 * box
	 * 
	 * @throws IOException
	 */
	public void enterValueIntoSuccessfulUploadsInputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").sendKeys("20");
		logger.info("User entered 20 into the successful upload input box");
	}

	/**
	 * This method is used to enter the value 20 into the Unsuccessful Uploads Input
	 * box
	 * 
	 * @throws IOException
	 */
	public void enterValueIntoUnsuccessfulUploadsInputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").sendKeys("20");
		logger.info("User entered 20 into the unsuccessful upload input box");
	}

	/**
	 * This method is used to enter the value -2 into the Successful Uploads Input
	 * box
	 * 
	 * @throws IOException
	 */
	public void enterNegativeValueIntoSuccessfulUploadsInputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").sendKeys("-2");
		logger.info("User entered 20 into the successful upload input box");
	}

	/**
	 * This method is used to enter the value 20 into the Unsuccessful Uploads Input
	 * box
	 * 
	 * @throws IOException
	 */
	public void enterNegativeValueIntoUnsuccessfulUploadsInputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").sendKeys("-2");
		logger.info("User entered 20 into the unsuccessful upload input box");
	}

	/**
	 * This method is used to check Successful input box text color
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkSuccessfulInputBoxColor() throws IOException {
		String color = utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath")
				.getCssValue("color");
		if (color.contains("rgba(255, 0, 0, 1)")) {
			logger.info("Successful Input Box Color is red");
			return true;
		} else {
			logger.info("Successful Input Box Color is red");
			return false;
		}
	}

	/**
	 * This method is used to check Unsuccessful input box text color
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkUnsuccessfulInputBoxColor() throws IOException {
		String color = utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath")
				.getCssValue("color");
		if (color.contains("rgba(255, 0, 0, 1)")) {
			logger.info("Unsuccessful Input Box Color is red");
			return true;
		} else {
			logger.info("Unsuccessful Input Box Color is not red");
			return false;
		}
	}

	/**
	 * This method is used to enter no value into the Successful Uploads Input box
	 * 
	 * @throws IOException
	 */
	public void enterNoValueIntoSuccessfulUploadsInputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").clear();
		logger.info("User entered nothing into the successful upload input box");
	}

	/**
	 * This method is used to enter no value into the Unsuccessful Uploads Input box
	 * 
	 * @throws IOException
	 */
	public void enterNoValueIntoUnsuccessfulUploadsInputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").clear();
		logger.info("User entered nothing into the unsuccessful upload input box");
	}

	/**
	 * This method is used to enter high value into the Successful Uploads Input box
	 * 
	 * @throws IOException
	 */
	public void enterHighValueIntoSuccessfulUploadsInputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").sendKeys("31");
		logger.info("User entered high value into the successful upload input box");
	}

	/**
	 * This method is used to enter high value into the Unsuccessful Uploads Input
	 * box
	 * 
	 * @throws IOException
	 */
	public void enterHighValueIntoUnsuccessfulUploadsInputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").sendKeys("31");
		logger.info("User entered high value into the successful upload input box");
	}

	/**
	 * This method is used to enter special character into the successful Uploads
	 * Input box
	 * 
	 * @throws IOException
	 */
	public void enterSpecialCharacterIntoSuccessfulUploadsInputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").sendKeys("%%");
		logger.info("User entered special characters into the successful upload input box");
	}

	/**
	 * This method is used to enter special character into the unsuccessful Uploads
	 * Input box
	 * 
	 * @throws IOException
	 */
	public void enterSpecialCharacterIntoUnsuccessfulUploadsInputBox() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").sendKeys("%%");
		logger.info("User entered special characters into the unsuccessful upload input box");
	}

	/**
	 * This method is used to check if the recent file upload appears in the
	 * dashboard page
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean verifyFileUploadInDashboard() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "summarydashboard.recall.xpath").isDisplayed();
		if (bool == true) {
			logger.info("New entry found on upload dashboard");
			return true;
		} else {
			logger.info("New entry not found on upload dashboard");
			return false;
		}
	}

	/**
	 * This method is used to check if the recent file upload appears in the History
	 * Page
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean verifyFileUploadInHistoryPage() throws IOException {
		String text = utility.initializeElement(LoginPage.driver, "history.firstentrypatientname.txt.xpath").getText();
		if (text.contains("Patrick David")) {
			logger.info("File Upload Entry found in History Page");
			return true;
		} else {
			logger.info("File Upload Entry not found in History Page");
			return false;
		}
	}

	/***
	 * This method is used to select back date from current date.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectDateBackFromCurrentDate(String date) throws IOException, InterruptedException {
		logger.info("selectDateBackFromCurrentDate: " + date + "th date back from current date is selected");
		int numDate = Integer.parseInt(date);
		logger.info(+numDate + "th days back date to be selected");
		List<WebElement> dateTable = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		calendar.add(Calendar.DAY_OF_YEAR, -(numDate));
		Date previousDate = calendar.getTime();
		String oldDate = formatter.format(previousDate);
		String oldDate1 = oldDate.substring(0).replaceAll("0", "");
		for (WebElement cell : dateTable) {
			if (cell.getText().equals(oldDate1)) {
				logger.info("Selected back date is : " + cell.getText());
				cell.click();
				break;
			}
		}
	}

	/***
	 * This method is used to remove date filter
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void removeDateFilter() throws IOException, InterruptedException {
		Thread.sleep(10000);
		utility.initializeElement(LoginPage.driver, "uploaddashboard.crossicon.btn.xpath").click();
		logger.info("Date filter is removed");
	}

	/**
	 * This method is used to check all Successful unsuccessful upload within the
	 * filtered date.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public boolean isAllSuccessfulUnsuccessfulUploadDisplayedInUploadDashboard(String upload)
			throws IOException, InterruptedException {
		try {
			List<WebElement> uploadDate = utility.initializeElements(LoginPage.driver,
					"summarydashboard.dateoffileuploaded.list.xpath");
			int size = uploadDate.size();
			String dateFilter = utility.initializeElement(LoginPage.driver, "filter.filtered.dashboard.xpath")
					.getText();
			String startDate = dateFilter.substring(0, 10);
			String endDate = dateFilter.substring(13, 23);
			logger.info("the upload dashbaord displayed details between filtered date of start date as " + startDate
					+ " and end date as " + endDate);
			if (size < 25) {
				for (int i = 0; size < 25; i++) {
					String dateUploaded = uploadDate.get(i).getText();
					logger.info("Filtered uploaded records date are : " + dateUploaded);
				}
			}
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			logger.info("All list of records are not printed due to show more button interruption");
		}
		return true;

	}

	/**
	 * This method is used to enter the value into the successful Uploads Input box
	 * 
	 * @throws IOException
	 */
	public void enterValueInToSuccessfulUploadTextbox(String string) throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").sendKeys(string);
		utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.settings.xpath").click();
		logger.info("The user entered " + string + " into the successful upload input box");
	}

	/**
	 * This method is used to check entered value saved into the successful Uploads
	 * Input box displayed or not
	 * 
	 * @throws IOException
	 */
	public String isEnteredValueSavedInSuccessfulExpirationTextbox(String string) throws IOException {
		logger.info("The entered value is saved as : " + utility
				.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").getAttribute("value"));
		return utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath")
				.getAttribute("value");

	}

	/**
	 * This method is used to check entered value saved into the unsuccessful
	 * Uploads Input box displayed or not
	 * 
	 * @throws IOException
	 */
	public String isEnteredValueSavedInUnsuccessfulExpirationTextbox(String string) throws IOException {
		logger.info("The entered value is saved as : "
				+ utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath")
						.getAttribute("value"));
		return utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath")
				.getAttribute("value");

	}

	/**
	 * This method is used to enter the value into the successful Uploads Input box
	 * 
	 * @throws IOException
	 */
	public void enterValueInToUnSuccessfulUploadTextbox(String string) throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").sendKeys(string);
		utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.settings.xpath").click();
		logger.info("The user entered " + string + " into the successful upload input box");
	}

	/**
	 * This method is used to click on save button
	 * 
	 * @throws IOException
	 */
	public void clickOnSaveButton() throws IOException {
		try {
		utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").click();
		}catch(ElementClickInterceptedException e) {
			logger.info("Save button is disabled,so not clicking");
		}
		logger.info("The save button is clicked");
	}

	/**
	 * This method is used to remove text from successful Upload Input box
	 * 
	 * @throws IOException
	 */
	public void removeTextFromSuccessfulExpiration() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").clear();
		logger.info("The text from successful upload input box is removed");
	}

	/**
	 * This method is used to remove text from unsuccessful Upload Input box
	 * 
	 * @throws IOException
	 */
	public void removeTextFromUnsuccessfulExpiration() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").click();
		logger.info("The text from unsuccessful upload input box is removed");
	}

	/**
	 * This method is used to check successful Uploads Input box displayed in red
	 * color or not
	 * 
	 * @throws IOException
	 */
	public String isSuccessfulExpirationTextboxDisplayedInRedColor() throws IOException {
		logger.info("The successful upload expiration textbox borderline color displayed as : " + utility
				.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath")
				.getCssValue("color");
	}

	/**
	 * This method is used to check unsuccessful Uploads Input box displayed in red
	 * color or not
	 * 
	 * @throws IOException
	 */
	public String isUnsuccessfulExpirationTextboxDisplayedInRedColor() throws IOException {
		logger.info("The unsuccessful upload expiration textbox borderline color displayed as : "
				+ utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath")
						.getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath")
				.getCssValue("color");

	}

	/**
	 * This method is used to check values other than 1-30 are not allowed to save
	 * 
	 * @throws IOException
	 */
	public boolean notAllowedValues(String string) throws IOException {
		logger.info(
				"The user is not able to save " + string + " values in successful and unsuccessful expiration textbox");
		return utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").isEnabled();
	}

	/**
	 * This method is used to check values are default or not
	 * 
	 * @throws IOException
	 */
	public boolean isDefaultValuesDisplayed() throws IOException {
		String successful = utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath")
				.getAttribute("value");
		logger.info(successful);
		int i = Integer.parseInt(successful);
		String unsuccessful = utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath")
				.getAttribute("value");
		int j = Integer.parseInt(unsuccessful);
		if (i == 14 && j == 14) {
			logger.info("Successful upload textbox has default values 14");
			return true;
		} else
			return false;
	}

	/**
	 * This method is to reset settings to default in settings page
	 * 
	 * @throws IOException
	 * 
	 */
	public void resetSettingsToDefault() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.btn.resettodefault.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").click();
		logger.info("Successful Uploads Expiration & Unsuccessful Uploads Expiration have been reseted to 14 days");
	}

	/**
	 * This method takes the list of web-elements that is the dates in the file
	 * dashboard page Then checks the differential between the first and last date,
	 * making sure it is within the 14 day limit
	 * 
	 * @throws IOException
	 * @return Boolean
	 * 
	 */
	public Boolean checkAllUploadDates() throws IOException {
		List<WebElement> file = utility.initializeElements(LoginPage.driver,
				"summarydashboard.dateoffileuploaded.list.xpath");
		int size = file.size();
		logger.info("Total no. of items : " + size);
		String first = editDateString(file.get(0).getText());
		LocalDate firstDate = LocalDate.parse(first);
		if (size > 0) {
			for (int i = 0; i < file.size(); i++) {
				String second = editDateString(file.get(i).getText());
				LocalDate secondDate = LocalDate.parse(second);
				long differential = ChronoUnit.DAYS.between(firstDate, secondDate);
				differential *= -1;
				if (differential > 14) {
					return false;
				}
			}
			return true;
		}
		return true;
	}

	/**
	 * This method is to edit the date strings for the checkAllUploadDates to allow
	 * for LocalDate parsing
	 * 
	 * 
	 * @throws IOException
	 * @return String *
	 */
	public String editDateString(String date) {
		String finalDate = "";
		String[] arrStr = date.split("-", 3);
		String year = arrStr[0];
		String month = arrStr[1];
		String day = arrStr[2];
		String monthInt = "";
		switch (month.toLowerCase()) {
		case "jan":
			monthInt = "01";
			break;
		case "feb":
			monthInt = "02";
			break;
		case "mar":
			monthInt = "03";
			break;
		case "apr":
			monthInt = "04";
			break;
		case "may":
			monthInt = "05";
			break;
		case "jun":
			monthInt = "06";
			break;
		case "jul":
			monthInt = "07";
			break;
		case "aug":
			monthInt = "08";
			break;
		case "sep":
			monthInt = "09";
			break;
		case "oct":
			monthInt = "10";
			break;
		case "nov":
			monthInt = "11";
			break;
		case "dec":
			monthInt = "12";
			break;
		}
		finalDate = year + "-" + monthInt + "-" + day;
		return finalDate;
	}

	/**
	 * This method is to click the filter button on dashboard
	 * 
	 * @throws IOException
	 * 
	 */
	public void clickFilterButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "dashboard.filter.xpath").click();
		logger.info("User clicked filter button on dashboard");
	}

	/**
	 * This method checks to see if all filter fields are displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 * 
	 */
	public Boolean checkFilterFields() throws IOException {
		Boolean bool1 = utility.initializeElement(LoginPage.driver, "dashboard.filterlist.date.xpath").isDisplayed();
		Boolean bool2 = utility.initializeElement(LoginPage.driver, "dashboard.filterlist.surgeon.xpath").isDisplayed();
		Boolean bool3 = utility.initializeElement(LoginPage.driver, "dashboard.filterlist.site.xpath").isDisplayed();
		Boolean bool4 = utility.initializeElement(LoginPage.driver, "dashboard.filterlist.application.xpath")
				.isDisplayed();
		Boolean bool5 = utility.initializeElement(LoginPage.driver, "dashboard.filterlist.filestatus.xpath")
				.isDisplayed();
		if (bool1 == true && bool2 == true && bool3 == true && bool4 == true && bool5 == true) {
			logger.info("All filter fields are displayed");
			return true;
		} else {
			logger.info("Not all filter fields are displayed");
			return false;
		}
	}

	/**
	 * This method is to expand date filter option in filter menu
	 * 
	 * @throws IOException
	 */
	public void clickDateFilterPlusButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "dashboard.filterlist.date.btn.xpath").click();
		logger.info("User has clicked + button on date filter");
	}

	/**
	 * This method checks to see if the start and end buttons are displayed in the
	 * date filter
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkStartEndButtons() throws IOException {
		Boolean bool1 = utility.initializeElement(LoginPage.driver, "dashboard.filterlist.date.start.btn.xpath")
				.isDisplayed();
		Boolean bool2 = utility.initializeElement(LoginPage.driver, "dashboard.filterlist.date.end.btn.xpath")
				.isDisplayed();
		if (bool1 == true && bool2 == true) {
			logger.info("Both Start and End buttons are displayed");
			return true;
		} else {
			logger.info("Both Start and End buttons are not displayed");
			return false;
		}
	}

	/**
	 * This method is to click the start button in the date filter
	 * 
	 * @throws IOException
	 */
	public void clickStartButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "dashboard.filterlist.date.start.btn.xpath").click();
		logger.info("User clicked start button in date filter");
	}

	/**
	 * This method is to get the current day of the last upload
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String getCurrentDay() throws IOException {
		List<WebElement> file = utility.initializeElements(LoginPage.driver,
				"summarydashboard.dateoffileuploaded.list.xpath");
		String date = file.get(0).getText();
		String[] arrStr = date.split("-", 3);
		String day = arrStr[2];
		return day;
	}

	/**
	 * This method is to get the day value that is going to be clicked on the
	 * calendar as 5 days back from the current day If the date is 5 of less, it
	 * will calculate based off the previous month Then it will click the day
	 * 
	 * @return String
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void getDaySub5() throws IOException, InterruptedException {
		String curr = getCurrentDay();
		int num = Integer.parseInt(curr);
		if (num > 5) {
			int secondNum = num - 6;
			List<WebElement> table = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
			table.get(secondNum).click();
		} else {
			int subNum = 5 - num;
			utility.initializeElement(LoginPage.driver, "dashboard.filterlist.date.prevmonth.btn.xpath").click();
			List<WebElement> table = utility.initializeElements(LoginPage.driver, "filter.calender.datecolumn.xpath");
			int size = table.size();
			int finalNum = size - subNum - 1;
			table.get(finalNum).click();
		}
	}

	/**
	 * This method is to click the done button in the filter menu
	 * 
	 * @throws IOException
	 */
	public void clickDoneButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "dashboard.filterlist.done.btn.xpath").click();
		logger.info("User clicked done button in filter menu");
	}

	/**
	 * This method is to check the number of entries on the summary dashboard
	 * 
	 * @return
	 * @throws IOException
	 */
	public Integer getTotalDashboardEntries() throws IOException {
		List<WebElement> file = utility.initializeElements(LoginPage.driver,
				"summarydashboard.dateoffileuploaded.list.xpath");
		int size = file.size();
		return size;
	}

	/**
	 * This method is to clear the filter from the top menu bar in dashboard
	 * 
	 * @throws IOException
	 */
	public void clearFilter() throws IOException {
		try {
			utility.initializeElement(LoginPage.driver, "dashboard.filter.clearfilter.btn.xpath").click();
			logger.info("User clears filter from top menu bar");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();", LoginPage.driver.findElement(
					By.xpath("/html/body/app-root/app-filedashboard/div/div[1]/div[2]/span[1]/button/span")));
		}
	}

	/**
	 * This method is to enter the value 5 into the input boxes in settings menu
	 * then press save
	 * 
	 * @throws IOException
	 */
	public void enterFiveInSettingsInput() throws IOException {
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.successfuluploadexpiry.xpath").sendKeys("5");
		logger.info("User entered 5 into the successful upload input box");
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").click();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").clear();
		utility.initializeElement(LoginPage.driver, "setting.txt.unsuccessfuluploadexpiry.xpath").sendKeys("5");
		logger.info("User entered 5 into the unsuccessful upload input box");
		utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").click();
		logger.info("User clicked save button");
	}
	
	/**
	 * This method is used to check the number of days Number of days image uploads are shown on the dashboard before being archived (1-30) text is displayed
	 * @return
	 * @throws IOException
	 */
	public boolean numberofdaysTextIsDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "settings.numbertext.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check the global viewing is turned on
	 * @return
	 * @throws IOException
	 */
	public boolean isGlobalViewingOn() throws IOException {
		logger.info(utility.initializeElement(LoginPage.driver, "settings.globalviwing.toggle.xpath").getAttribute("aria-checked"));
		if(utility.initializeElement(LoginPage.driver, "settings.globalviwing.toggle.xpath").getAttribute("aria-checked").equals("true")){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This method is used to check only records of int1 days are displayed
	 * @param int1
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean checkAllUploadDatesdisplayed(Integer int1) throws IOException, InterruptedException {
		Thread.sleep(1000);
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> file = utility.initializeElements(LoginPage.driver,
				"summarydashboard.dateoffileuploaded.list.xpath");
		int size = file.size();
		String first = editDateString(file.get(0).getText());
		String last = editDateString(file.get(size-1).getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		for (int i = 0; i < size-1; i++) {
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			logger.info(file.get(i).getText());
		}
		logger.info("Total no. of items : " + size);
		LocalDate firstDate = LocalDate.parse(first);
		LocalDate lastDate = LocalDate.parse(last);
		long differential = ChronoUnit.DAYS.between(firstDate, lastDate);
		differential *= -1;
		if (differential > int1) {
			return false;
		}
		else
			return true;
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
			logger.info("Upload Successful Screen is not displayed");
			return false;
		}
	}
	
	/***
	 * This method is used to clear selected date filter
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnClearButton() throws IOException, InterruptedException {
		Thread.sleep(10000);
		utility.initializeElement(LoginPage.driver, "dashboard.filter.date.btn.clear.xpath").click();
		logger.info("Selected Dates are removed");
	}
	
	/**
	 * This method is used to show total number of records
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 * 
	 */
	public int totalNumberofrecordsOnDashbaord() throws IOException, InterruptedException {
			List<WebElement> List = utility.initializeElements(LoginPage.driver, "dashboard.totalrows.xpath");
			int size = List.size();
			return size;
			
	}
	
	/**
	 * This method is used to show total number of records
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 * 
	 */
	public boolean recordTotalNumberofDetailsOnDashbaord() throws IOException, InterruptedException {
		try {
			logger.info("Total no. of records on dashboard screen : " + totalNumberofrecordsOnDashbaord());
			return true;
			
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}
	
	/**
	 * This method is used to show total number of records
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isErrorMessageDisplayed() throws IOException, InterruptedException {
		logger.info("The error message is displayed as : "+utility.initializeElement(LoginPage.driver, "dashboard.nodatadisplay.text.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "dashboard.nodatadisplay.text.xpath").isDisplayed();
			
	}
	
	/**
	 * This method is used to show total number of records
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isDashboardRecordsMatch() throws IOException, InterruptedException {
		List<WebElement> List = utility.initializeElements(LoginPage.driver, "dashboard.totalrows.xpath");
		int count = List.size();
		if(totalNumberofrecordsOnDashbaord() == count) {
			logger.info("Total no. of records after removing filter :" +count);
			logger.info("Total no. of records matches with previous record :" +totalNumberofrecordsOnDashbaord());
			return true;
		}
		return false;
	}
	
	/**
	 * This method is used to check settings separated grey line displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isGreyLineSepratesSettings() throws IOException, InterruptedException {
		logger.info("The Successful Uploads Expiration is seperated by line : " 
	+utility.initializeElement(LoginPage.driver, "settings.successfulupload.horizontalline.xpath").isDisplayed());
		logger.info("The Unsuccessful Uploads Expiration is seperated by line : " 
				+utility.initializeElement(LoginPage.driver, "settings.unsuccessfulupload.horizontalline.xpath").isDisplayed());
		logger.info("The Global viewing is seperated by line : " 
				+utility.initializeElement(LoginPage.driver, "settings.globalviwing.horizontalline.xpath").isDisplayed());
		logger.info("The Successful Uploads and Unsuccessful Uploads Expiration and Global viewing are seperated by grey line as : " +utility.initializeElement(LoginPage.driver, "settings.globalviwing.horizontalline.xpath").getCssValue("color"));
		utility.initializeElement(LoginPage.driver, "settings.successfulupload.horizontalline.xpath").isDisplayed();
		utility.initializeElement(LoginPage.driver, "settings.unsuccessfulupload.horizontalline.xpath").isDisplayed();
		return utility.initializeElement(LoginPage.driver, "settings.globalviwing.horizontalline.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check settings header displayed in white color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isSettingsHeaderDisplayedInWhiteColor() throws IOException, InterruptedException {
		logger.info("The Setting header is displayed in white color as : " 
	+utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.settings.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "leftnavigation.txt.header.settings.xpath").getCssValue("color");
	}
	
	/**
	 * This method is used to check successful upload textbox displayed in green color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isSuccessfulUploadTextboxDisplayedInGreenColor() throws IOException, InterruptedException {
		logger.info("The Successful upload textbox is displayed in green color as : " 
	+utility.initializeElement(LoginPage.driver, "settings.txtbox.successfuluploads.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "settings.txtbox.successfuluploads.xpath").getCssValue("color");
	}
	
	/**
	 * This method is used to check successful upload text displayed in white color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isSuccessfulUploadExpirationTextDisplayedInWhiteColor() throws IOException, InterruptedException {
		logger.info("The Successful upload expiration text is displayed in white color as : " 
	+utility.initializeElement(LoginPage.driver, "settings.txt.successfuluploadexpiration.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "settings.txt.successfuluploadexpiration.xpath").getCssValue("color");
	}
	
	/**
	 * This method is used to check textbox description displayed in white color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isTextBoxDescriptionDisplayedInWhiteColor() throws IOException, InterruptedException {
		logger.info("The textbox description is displayed in white color as : " 
	+utility.initializeElement(LoginPage.driver, "settings.txtbox.description.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "settings.txtbox.description.xpath").getCssValue("color");
	}
	
	/**
	 * This method is used to check successful upload textbox value displayed in green color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isSuccessfulUploadTextBoxValueInGreenColor() throws IOException, InterruptedException {
		logger.info("The Successful upload expiration text value is displayed in green color as : " 
	+utility.initializeElement(LoginPage.driver, "settings.txtbox.successfuluploads.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "settings.txtbox.successfuluploads.xpath").getCssValue("color");
	}
	
	/**
	 * This method is used to check unsuccessful upload textbox displayed in green color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isUnsuccessfulUploadTextboxDisplayedInGreenColor() throws IOException, InterruptedException {
		logger.info("The Unsuccessful upload textbox is displayed in green color as : " 
	+utility.initializeElement(LoginPage.driver, "settings.txtbox.unsuccessfuluploads.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "settings.txtbox.unsuccessfuluploads.xpath").getCssValue("color");
	}
	
	/**
	 * This method is used to check unsuccessful upload text displayed in white color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isUnsuccessfulUploadExpirationTextDisplayedInWhiteColor() throws IOException, InterruptedException {
		logger.info("The Unsuccessful upload expiration text is displayed in white color as : " 
	+utility.initializeElement(LoginPage.driver, "settings.txt.successfuluploadexpiration.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "settings.txt.successfuluploadexpiration.xpath").getCssValue("color");
	}
	
	/**
	 * This method is used to check unsuccessful upload textbox value displayed in green color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isUnsuccessfulUploadTextBoxValueInGreenColor() throws IOException, InterruptedException {
		logger.info("The Successful upload expiration text value is displayed in green color as : " 
	+utility.initializeElement(LoginPage.driver, "settings.txtbox.unsuccessfuluploads.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "settings.txtbox.unsuccessfuluploads.xpath").getCssValue("color");
	}
	
	/**
	 * This method is used to check save button displayed in white color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isSavebuttonColorDisplayedInWhiteColor() throws IOException, InterruptedException {
		logger.info("The save button is displayed in white color as : " 
	+utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").getCssValue("color");
	}
	
	/**
	 * This method is used to check reset to default button displayed in white color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isResetToDefaultButtonColorDisplayed() throws IOException, InterruptedException {
		logger.info("The reset to default button is displayed in white color as : " 
	+utility.initializeElement(LoginPage.driver, "setting.btn.resettodefault.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "setting.btn.resettodefault.xpath").getCssValue("color");
	}
	
	/**
	 * This method is used to get upload successful expiration textbox value
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String getSuccessfulUploadValue(Integer value) throws IOException, InterruptedException {
		logger.info("The Successful upload value displayed as : " +value );
		return utility.initializeElement(LoginPage.driver, "settings.txtbox.successfuluploads.xpath").getAttribute("value");
	}
	
	/**
	 * This method is used to get upload successful expiration textbox value
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String getUnsuccessfulUploadValue(Integer value) throws IOException, InterruptedException {
		logger.info("The Unsuccessful upload value displayed as : " +value );
		return utility.initializeElement(LoginPage.driver, "settings.txtbox.unsuccessfuluploads.xpath").getAttribute("value");
	}
	
	/**
	 * This method is used to check global viewing toggle is on or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isGlobalViewingToggledOn() throws IOException, InterruptedException {
		logger.info("The Global viewing toggle is on : " 
	+utility.initializeElement(LoginPage.driver, "setting.toggle.globalviewing.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "setting.toggle.globalviewing.xpath").isEnabled();
	}
	
	/**
	 * This method is used to check save button disabled or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isSaveButtonDiabled() throws IOException, InterruptedException {
		logger.info("The save button is displayed as disabled : " 
	+utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "setting.btn.save.xpath").isEnabled();
	}
	
	/**
	 * This method is used to get upload successful expiration textbox value
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isGlobalViewingTextInWhiteColor() throws IOException, InterruptedException {
		logger.info("The gloabal viewing text is displayed in white color as : " +utility.initializeElement(LoginPage.driver, "setting.btn.resettodefault.xpath").getCssValue("color") );
		return utility.initializeElement(LoginPage.driver, "setting.btn.resettodefault.xpath").getCssValue("color");
	}
}