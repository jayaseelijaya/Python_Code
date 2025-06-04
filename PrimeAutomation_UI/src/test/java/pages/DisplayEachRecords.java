package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Utility;

public class DisplayEachRecords {
	
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DisplayEachRecords.class);
	Utility utility = new Utility();
	
	/**
	 * This method is used to check dashboard displayed six columns or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public WebElement isColumnsDisplayed(String column) throws IOException, InterruptedException {
		WebElement icon = utility.initializeElement(LoginPage.driver,
				"summarydashboard.uploadicon.xpath");
		WebElement wait = new WebDriverWait(LoginPage.driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(icon));
		wait.isDisplayed();
		if (column.equalsIgnoreCase("uploader icon")) {
			logger.info("Uploader icon column is displayed : " +utility.initializeElement(LoginPage.driver,
					"summarydashboard.uploadicon.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver,
					"summarydashboard.uploadicon.xpath");
		}
		if (column.equalsIgnoreCase("surgeon name")) {
		logger.info("Surgeon name column is displayed : " +utility.initializeElement(LoginPage.driver,
					"summarydashboard.surgeonname.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver,
					"summarydashboard.surgeonname.xpath");
		}
		if (column.equalsIgnoreCase("patient name")) {
			logger.info("Patient name column is displayed : " +utility.initializeElement(LoginPage.driver,
					"summarydashboard.patientname.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver,
					"summarydashboard.patientname.xpath");
		}
		if (column.equalsIgnoreCase("application")) {
			logger.info("Application column is displayed : " +utility.initializeElement(LoginPage.driver,
					"summarydashboard.application.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver,
					"summarydashboard.application.xpath");
		}
		if (column.equalsIgnoreCase("recall button")) {
			logger.info("Recall button column is displayed : " +utility.initializeElement(LoginPage.driver,
					"summarydashboard.recall.xpath").isDisplayed());
			return utility.initializeElement(LoginPage.driver,
					"summarydashboard.recall.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + column);
		return null;
	}
	
	/**
	 * This method is used to check if first column status icon displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isStatusIconColumnDisplayed() throws IOException {
		List<WebElement> statusIcon = utility.initializeElements(LoginPage.driver,
				"summarydashboard.uploadicon.list.xpath");
		int size = statusIcon.size();
		logger.info("Total no. of items in 1st column : " +size);
		if ( size >= 1) {
			for (int i = 0; i < statusIcon.size(); i++) {
				{
					logger.info("upload status icon is Displayed as : " + statusIcon.get(i).getAttribute("Title"));

				}
			}return true;
		}
		return false;
	}
	
	/**
	 * This method is used to check if second column surgeon name displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isSurgeonNameColumnDisplayed() throws IOException {
		try {
		List<WebElement> surgeonName = utility.initializeElements(LoginPage.driver,
				"summarydashboard.surgeonname.list.xpath");
		int size = surgeonName.size();
		logger.info("Total no. of items in 2nd column : " +size);
		if ( size >= 1) {
			for (int i = 0; i < surgeonName.size(); i++) {
				{
					logger.info("Surgeon name is displayed as : " + surgeonName.get(i).getText());

				}
			}return true;
		}
		return false;
		}
		catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}
	
	/**
	 * This method is used to check if date of file uploaded displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isDateOfFileUploadedDisplayed() throws IOException {
		List<WebElement> file = utility.initializeElements(LoginPage.driver,
				"summarydashboard.dateoffileuploaded.list.xpath");
		int size = file.size();
		logger.info("Total no. of items : " +size);
		if ( size >= 1) {
			for (int i = 0; i < file.size(); i++) {
				{
					logger.info("Date of file is displayed as : " + file.get(i).getText());

				}
			}return true;
		}
		return false;
	}
	
	/**
	 * This method is used to check if third column patient name and gender displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isPatientNameAndGenderColumnDisplayed() throws IOException {
		List<WebElement> patientName = utility.initializeElements(LoginPage.driver,
				"summarydashboard.patientname.list.xpath");
		int size = patientName.size();
		logger.info("Total no. of items in 3rd column : " +size);
		if ( size >= 1) {
			for (int i = 0; i < patientName.size(); i++) {
				{
					logger.info("Patient name and gender is displayed as : " + patientName.get(i).getText());

				}
			}return true;
		}
		return false;
	}
	
	/**
	 * This method is used to check if third column patient date of birth displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isDateOfBirthDisplayed() throws IOException {
		List<WebElement> birthDate = utility.initializeElements(LoginPage.driver,
				"summarydashboard.dateofbirth.list.xpath");
		int size = birthDate.size();
		logger.info("Total no. of items in date of birth column : " +size);
		if ( size >= 1) {
			for (int i = 0; i < birthDate.size(); i++) {
				{
					logger.info("Patient date of birth is displayed as : " + birthDate.get(i).getText());

				}
			}return true;
		}
		return false;
	}
	
	/**
	 * This method is used to check if fourth column application name and no. of files uploaded displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isApplicationNameColumnDisplayed() throws IOException {
		List<WebElement> application = utility.initializeElements(LoginPage.driver,
				"summarydashboard.application.list.xpath");
		int size = application.size();
		logger.info("Total no. of items in 4th column : " +size);
		if ( size >= 1) {
			for (int i = 0; i < application.size(); i++) {
				{
					logger.info("Application name and no. of files uploaded is displayed as : " + application.get(i).getAttribute("textContent"));

				}
			}return true;
		}
		return false;
	}

}
