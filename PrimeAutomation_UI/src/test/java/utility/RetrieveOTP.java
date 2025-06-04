package utility;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;

import pages.LoginPage;

public class RetrieveOTP {
	Utility utility = new Utility();
	final static Logger logger = Logger.getLogger(RetrieveOTP.class);
	LoginPage loginPage = new LoginPage();
	Screenshot screenshot = new Screenshot();
	PropertiesFileReader reader = new PropertiesFileReader();
	public static String OTP;
	public static String subjectLine;
	public static String bodytext1;
	public static String bodytext2;


	// ***********Retrive OTP for PRIME*************************//
	/**
	 * This method is used to get OTP for FAI Application.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void readOtp() throws IOException, InterruptedException {
		String propertiesPath = null;
		File jarPath = new File(LoginPage.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		propertiesPath = jarPath.getAbsolutePath();
		Scanner sc = new Scanner(System.in);
		if (propertiesPath.contains(".jar")) {
			logger.info("Enter OTP");
			String Otp = sc.nextLine();
			utility.initializeElement(LoginPage.driver, "clp.txt.otptextfield.xpath").sendKeys(Otp);
			logger.info("readOtp: Entered OTP as [" + Otp + "]");
			sc.close();
		}
		if (!propertiesPath.contains(".jar")) {
			Properties properties = reader.getProperty();

			// Open new window to open IFTTT website

			LoginPage.driver.switchTo().newWindow(WindowType.WINDOW);
			LoginPage.driver.get("https://ifttt.com/");

			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

			Set<String> getWin = LoginPage.driver.getWindowHandles();
			List<String> list = new ArrayList<String>(getWin);
			String parentWindowId = list.get(0);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName().concat("_ifttt_page_displayed"),
					LoginPage.driver);

			utility.initializeElement(LoginPage.driver, "login.applet.btn.homelogin.xpath").click();
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName().concat("_clicked_on_home_login"),
					LoginPage.driver);

			/**
			 * Create account on IFTTT In 1st sendKeys give your IFTTT email id In 2nd
			 * sendKeys give your IFTTT password
			 **/
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			utility.initializeElement(LoginPage.driver, "login.applet.emailid.id")
					.sendKeys(properties.getProperty("fai.ifttt.emailaddress"));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName().concat("_entered_email_id"),
					LoginPage.driver);

			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			utility.initializeElement(LoginPage.driver, "login.applet.password.id")
					.sendKeys(properties.getProperty("fai.ifttt.password"));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName().concat("_entered_password"),
					LoginPage.driver);

			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			utility.initializeElement(LoginPage.driver, "login.applet.btn.loginbtn.xpath").click();

			while (LoginPage.driver.getCurrentUrl().contains("subscriptions")) {
				LoginPage.driver.findElement(By.xpath("/html/body/main/div/header/div[1]/button")).click();
				logger.info("going back");
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				utility.initializeElement(LoginPage.driver, "login.applet.btn.loginbtn.xpath").click();
			}

			logger.info("Logged into applet successfully");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName().concat("_clicked_on_login_button"),
					LoginPage.driver);

			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			utility.initializeElement(LoginPage.driver, "login.applet.myapplets.xpath").click();
			logger.info("Clicked on my applets");
			screenshot.screenshot(
					new Throwable().getStackTrace()[0].getMethodName().concat("_clicked_on_myapplets_button"),
					LoginPage.driver);

//			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//			utility.initializeElement(LoginPage.driver, "login.applet.maybelater.xpath").click();
//			logger.info("maybe later popup is dismissed");
//			screenshot.screenshot(
//					new Throwable().getStackTrace()[0].getMethodName().concat("_clicked_on_maybe_later_button"),
//					LoginPage.driver);
//
//			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//			while (!utility.initializeElements(LoginPage.driver, "login.applet.ratingpoup.xpath").isEmpty()) {
//				utility.initializeElement(LoginPage.driver, "login.applet.ratingpoup.xpath").click();
//				logger.info("Closed the Popup for rating");
//			}

			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Thread.sleep(20000);
			utility.initializeElement(LoginPage.driver, "login.applet.firstcard.xpath").click();
			logger.info("card is clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName().concat("_clicked_on_first_card"),
					LoginPage.driver);

			JavascriptExecutor js = (JavascriptExecutor) LoginPage.driver;
			js.executeScript("javascript:window.scrollBy(0,150)");

			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Thread.sleep(20000);
			utility.initializeElement(LoginPage.driver, "login.applet.btn.viewlog.xpath").click();
			logger.info("View Activity is clicked");
			screenshot.screenshot(
					new Throwable().getStackTrace()[0].getMethodName().concat("_clicked_on_view_activity_button"),
					LoginPage.driver);

			Thread.sleep(1000);
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
			LoginPage.driver.navigate().refresh();
			utility.initializeElement(LoginPage.driver, "login.applet.btn.sms.xpath").click();
			js.executeScript("javascript:window.scrollBy(0,200)");

			/**
			 * Extract OTP
			 **/

			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String str = utility.initializeElement(LoginPage.driver, "login.applet.txt.otpcode.xpath").getText();
			OTP = str.replace("Your S+N Common Login Portal verification code is ", "").trim();
			logger.info("OTP is: " + OTP);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName().concat("_otp_is_displayed"),
					LoginPage.driver);

			LoginPage.driver.close();
			LoginPage.driver.switchTo().window(parentWindowId);
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName().concat("_window_closed"),
					LoginPage.driver);

			logger.info("driver switched to old Window");
		}
	}
}
