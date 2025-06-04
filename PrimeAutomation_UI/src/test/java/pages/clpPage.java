package pages;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.PropertiesFileReader;
import utility.Utility;

public class clpPage {
	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(LoginPage.class);
	Utility utility = new Utility();
	
	/**
	 * This method is used to check whether CLP screen is displayed
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public Boolean isClpPageDisplayed() throws IOException, InterruptedException {
		Thread.sleep(3000);
		utility.initializeElement(LoginPage.driver, "clp.btn.gotologin.xpath");
		logger.info("clp is displayed : "
				+ utility.initializeElement(LoginPage.driver, "clp.btn.gotologin.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "clp.btn.gotologin.xpath").isDisplayed();
	}
}
