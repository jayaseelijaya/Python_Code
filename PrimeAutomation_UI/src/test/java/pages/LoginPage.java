package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Utility;

public class LoginPage {
	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(LoginPage.class);
	Utility utility = new Utility();
	Scanner sc = new Scanner(System.in);

	/**
	 * This method is used to get the user name entered on login screen
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement getUsername() throws IOException {
		return utility.initializeElement(driver, "login.txt.username.xpath");
	}

	public WebElement getPassword() throws IOException {
		return utility.initializeElement(driver, "login.txt.password.xpath");
	}

	/**
	 * This method is used to enter the user name on login screen.
	 * 
	 * @param username
	 * @throws IOException
	 */
	public void enterUsername(String username) throws IOException {
		getUsername().sendKeys(username);
		logger.info("enterUsername : Entered user name as [" + username + "]");
	}

	/**
	 * This method is used to enter the password on login screen.
	 * 
	 * @param passwordtext
	 * @throws IOException
	 */
	public void enterPassword(String passwordtext) throws IOException {
		getPassword().click();
		getPassword().sendKeys(passwordtext);
		logger.info("enterPassword : Entered password as [" + passwordtext + "]");
	}

	/**
	 * This method is used to click Login button on login screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickLoginButton() throws IOException, InterruptedException {
		utility.initializeElement(driver, "login.btn.login.xpath").click();
		logger.info("clickLoginButton : Clicked login button");
	}
	
	public WebElement getOTP() throws Exception {
		try {
			return utility.initializeElement(LoginPage.driver, "clp.txt.otptextfield.xpath");
		} catch (Exception e) {
			logger.error("getOTP: " + e.toString());
			throw e;
		}
	}

public void clickOnApplicationTab() throws IOException, InterruptedException 
	{
		
		try {
			utility.initializeElement(driver,"clp.btn.app.xpath").click();
			logger.info("clickOnApplicationTab : Clicked Application Tab from Left panel");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"menu_item4_height\"]/a/span[2]")));
			logger.info("clickOnApplicationTab : Clicked Application Tab from Left panel");
		}
	}
	
	public void enterOTP() throws Exception {
		try {
			logger.info("Enter OTP");
			String otp = sc.nextLine();
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
			getOTP().click();
			getOTP().sendKeys(otp);
			logger.info("enterOTP: Entered OTP as [" + otp + "]");
		} catch (Exception e) {
			logger.error("enterOTP: " + e.toString());
			throw e;
		}
	}
	
	/**
	 * This method is used to click Login button on login screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSigninButton() throws IOException, InterruptedException {
		utility.initializeElement(driver, "clp.btn.signin.xpath").click();
		logger.info("clickOnSigninButton : Clicked signin button");
	}
	
	
	public void clickLoginButtonForMinimumScreenResolution() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "login.btn.login.xpath").click();
			logger.info("clickLoginButtonForMinimumScreenResolution : Clicked login button ");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"newUser\"]/div/div/form/app-login/div/button")));
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
			utility.initializeElement(LoginPage.driver, "user.logout.btn.xpath").click();
			logger.info("clickLogoutButton : Clicked logout button");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"logout_icon\"]")));
			logger.info("clickLogoutButton : Clicked logout button");
		}

	}

	/**
	 * This method is used to get user name value on login screen.
	 * 
	 * @throws IOException
	 */
	public String getUsernameValue() throws IOException {
		String username = getUsername().getAttribute("value");
		logger.info("getUserName: User name value is " + username);
		return username;
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
		return utility.initializeElement(LoginPage.driver, "user.signin.page.xpath").getText();
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
				+ utility.initializeElement(LoginPage.driver, "user.logout.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "user.logout.btn.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to click on go to login button on clp screen.
	 * 
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
	 * This method is used to check application page screen.
	 * 
	 * @throws IOException
	 */
	public String isApplicationsDisplayed() throws IOException {
		logger.info("Application page is displayed ");
		return utility.initializeElement(LoginPage.driver, "clp.menu.applications.xpath").getText();
		
	}
	
	/**
	 * This method is used to click on go to login button on clp screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnDataUploadLaunchButton() throws IOException, InterruptedException {
		Properties properties = reader.getProperty();
		List<WebElement> launchButtons= utility.initializeElements(LoginPage.driver, "clp.btn.launch.xpath");
		String applicationHeaderXpath = String.format("./../..%s", properties.getProperty("clp.applicationcard.header.xpath"));
		for(WebElement launchButton:launchButtons) {
			if(launchButton.findElement(By.xpath(applicationHeaderXpath)).getText().equals("Data Upload")) {
				launchButton.click();
			}
		}
		logger.info("clickOnDataUploadLaunchButton : Clicked launch button");
	}
	
	/**
	 * This method is used to check whether the logout icon is displayed.
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public boolean snLogoDisplayed() throws IOException, InterruptedException {
		Thread.sleep(3000);
		logger.info("SN Logo is displayed : "
				+ utility.initializeElement(LoginPage.driver, "clp.img.snlogo.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "clp.img.snlogo.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to select surgeon for staff user.
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void selectSurgeonForStaffUser() throws IOException, InterruptedException {
		WebElement firstSurgeonInList = utility.initializeElements(LoginPage.driver, "login.supportstaff.selectsurgeon.xpath").get(0);
		logger.info("Selected surgeon :"+firstSurgeonInList.getText());
		firstSurgeonInList.click();
		Thread.sleep(3000);
		utility.initializeElement(LoginPage.driver, "login.supportstaff.selectsurgeon.continue.xpath").click();
	}
	
	
}