package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.PropertiesFileReader;
import utility.Utility;

public class HILLoginPage {
	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HILLoginPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to click on go to login page in CLP screen
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnGoToLoginBtn() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "clp.btn.gotologin.xpath").click();
			logger.info("clickOnGoToLoginBtn : Clicked go to login button");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//button[contains(text(),'Go to Login')]")));
			logger.info("clickLogoutButton : Clicked go to login button");
		}

	}

	/**
	 * This method is used to enter user name in user name field
	 * @param userName
	 * @throws IOException
	 */
	public void enterUserName(String userName) throws IOException {
		utility.initializeElement(LoginPage.driver, "login.txt.username.xpath").sendKeys(userName);
		logger.info("User name entered: "+ userName);
	}
	
	/**
	 * This method is used to enter password in the password field
	 * @param password
	 * @throws IOException
	 */
	public void enterPassword(String password)throws IOException {
		utility.initializeElement(LoginPage.driver, "login.txt.password.xpath").sendKeys(password);
		logger.info("password entered: "+ password);
	}

	/**
	 * This method is used to click Login button on login screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnHILLoginButton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "login.btn.login.xpath").click();
		logger.info("clickLoginButton : Clicked login button");
	}
	
	public void clickLoginButtonForMinimumScreenResolution() throws IOException, InterruptedException {
		try {
			utility.initializeElement(HILLoginPage.driver, "login.btn.login.xpath").click();
			logger.info("clickLoginButtonForMinimumScreenResolution : Clicked login button ");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) HILLoginPage.driver;
			executor.executeScript("arguments[0].click();",
					HILLoginPage.driver.findElement(By.xpath("//*[@id=\"newUser\"]/div/div/form/app-login/div/button")));
			logger.info("clickLoginButtonForMinimumScreenResolution : Clicked login button");
		}
	}
	
	/**
	 * This method is used to click Logout button on home screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickLogoutButton() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "HIL.logot.btn.xpath").click();
			logger.info("clickLogoutButton : Clicked logout button");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"logout_img\"]")));
			logger.info("clickLogoutButton : Clicked logout button");
		}

	}
	
	public void clickOnHILLaunchButton() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		List<WebElement> launchButtons= utility.initializeElements(LoginPage.driver, "clp.btn.launch.xpath");
		String applicationHeaderXpath = String.format("./../..%s", properties.getProperty("clp.applicationcard.header.xpath"));
		for(WebElement launchButton:launchButtons) {
			if(launchButton.findElement(By.xpath(applicationHeaderXpath)).getText().equalsIgnoreCase("Prime ACL")) {
				launchButton.click();
				break;
			}
		}
		logger.info("clickOnPrimeACLButton : Clicked launch button");
	}

	

	/**
	 * This method is used to view password on login screen.
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement viewPassword() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		return utility.initializeElement(driver, "login.btn.passwordshow.xpath");
	}

	/**
	 * This method is used to get SignInPage value text.
	 * 
	 * @throws IOException
	 */
	public String signInPageValidation() throws IOException {
		logger.info("User is navigated back to the Login Screen");
		return utility.initializeElement(HILLoginPage.driver, "user.signin.page.xpath").getText();
	}
	
	
	/**
	 * This method is used to check whether the logout icon is displayed.
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public boolean isLogoutBtnDisplayed() throws IOException, InterruptedException {
		Thread.sleep(3000);
		logger.info("Logout Button is displayed : "
				+ utility.initializeElement(HILLoginPage.driver, "user.logout.btn.xpath").isDisplayed());
		return utility.initializeElement(HILLoginPage.driver, "user.logout.btn.xpath").isDisplayed();
	}
	
	public boolean isUserloggedOut() throws IOException {
		return utility.initializeElement(LoginPage.driver, "clp.btn.gotologin.xpath").isDisplayed();
	}
}