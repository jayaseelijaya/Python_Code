package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.PropertiesFileReader;
import utility.Utility;

public class ApplicationCardsPage {

	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(SurgeonListPage.class);
	Utility utility = new Utility();

	/**
	 * This method is used to check if the button displayed on Application selection
	 * screen.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean backButtonDisplayed() throws IOException {
		logger.info("Verify Back and Next Button on Application Selection Modal Screen");
		logger.info("Back Button is Displayed : "
				+ utility.initializeElement(LoginPage.driver, "applicationcard.back.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "applicationcard.back.btn.xpath").isDisplayed();
	}

	public Boolean NextButtonDisplayed() throws IOException {
		logger.info("Next Button is Displayed : "
				+ utility.initializeElement(LoginPage.driver, "applicationcard.next.btn.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "applicationcard.next.btn.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if Next button is enabled in Application card
	 * selection screen.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isNextButtonEnabled() throws IOException {
		logger.info("Next button is enabled : "
				+ utility.initializeElement(LoginPage.driver, "applicationcard.next.btn.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "applicationcard.next.btn.xpath").isEnabled();
	}

	/**
	 * This method is used to select Application card from application selection
	 * modal screen.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectAppCard() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "applicationcard.click.btn.xpath").click();
		logger.info("Selected Application Card is : "
				+ utility.initializeElement(LoginPage.driver, "applicationcard.click.btn.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectApplicationCard : Clicked Application Card button");
	}

	/**
	 * This method is used to select Surgeon which has 9 application cards
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectSurgeon() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "surgeon.nineappcards.btn.xpath").click();
		logger.info("Selected Surgeon is : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.nineappcards.btn.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectSurgeon: Clicked Selected Surgeon button");
	}

	/**
	 * This method is used to get text of the application card d
	 * 
	 * @throws IOException
	 */
	public String applicationcardText() throws IOException {
		List<WebElement> element = LoginPage.driver
				.findElements(By.xpath("//*[@class='application-card cursor-pointer ng-star-inserted']"));
		WebElement q = null;
		int count = element.size();
		logger.info("Total Number of Application Cards listed after selecting Surgeon : " + count);
		for (int i = 0; i < element.size(); i++) {
			q = element.get(i);
			logger.info("Application Card description as :" + q.getText());
		}
		return q.getText();
	}

	/**
	 * This method is used to click Back Button from application card screen
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickBack() throws IOException, InterruptedException {
		try {
			utility.initializeElement(LoginPage.driver, "applicationcard.back.btn.xpath").click();
			logger.info("clickBackButton: Clicked Back button");
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) LoginPage.driver;
			executor.executeScript("arguments[0].click();",
					LoginPage.driver.findElement(By.xpath("//*[@id=\"applicationSelect\"]/div/div/div[6]/button[1]")));
		}
		logger.info("clickBackButton: Clicked Back button");
	}

	/**
	 * This method is used to get error message when no application cards associated
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String getMessage() throws IOException, InterruptedException {
		return utility.initializeElement(LoginPage.driver, "application.message.xpath").getText();
	}

	/**
	 * This method is used to select Surgeon which has more than 9 application cards
	 * associated
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void moreAppCardSurgeon() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "surgeon.second.select.xpath").click();
		logger.info("Selected Surgeon is : "
				+ utility.initializeElement(LoginPage.driver, "surgeon.second.select.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectSurgeon: Clicked Selected Surgeon button");
	}

	/**
	 * This method is used to click forward Button from application card screen
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickforward() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "application.forward.btn.xpath").click();
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("clickForwardButton: Clicked Forward Button button");
	}
	
	/**
	 * This method is used to check if application screen displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isApplicationSelectionScreenDisplayed() throws IOException {
		logger.info("Application Selection Screen is displayed : "
				+ utility.initializeElement(LoginPage.driver, "applicationcard.screen.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "applicationcard.screen.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to select a application card from the list
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectApplicationFromList() throws IOException, InterruptedException 
	{
		utility.initializeElement(LoginPage.driver, "applicationcard.card.first.xpath").click();
		logger.info("Selected Application card is : "
				+ utility.initializeElement(LoginPage.driver, "applicationcard.card.first.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("SelectedApplication: Clicked Selected Application Card");
	}
	
	/**
	 * This method is used to check if card selected by default or not
	 * screen.
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isNoCardSelectedByDefault() throws IOException {
		List<WebElement> card = utility.initializeElements(LoginPage.driver, "applicationcard.card.list.xpath");
		int no =card.size();
		logger.info("Number of Application card displayed : " +no);
		for(int i = 0; i< card.size(); i++) {
			 logger.info("Application card selected by default : " +card.get(i).isSelected());
		}
		logger.info("No cards are selected by default if more than one application card is available");
		return false;
	}
	
	/**
	 * This method is used to check if left right arrows displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isLeftRightArrowsDisplayed() throws IOException {
		logger.info("Left arrow is displayed : " +utility.initializeElement(LoginPage.driver, "applicationcard.btn.prev.xpath").isDisplayed());
		logger.info("right arrow is displayed : " +utility.initializeElement(LoginPage.driver, "applicationcard.btn.next.xpath").isDisplayed());
		utility.initializeElement(LoginPage.driver, "applicationcard.btn.prev.xpath").isDisplayed();
		return utility.initializeElement(LoginPage.driver, "applicationcard.btn.next.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to select one Application card from application selection
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectFirstAppCard() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "applicationcard.card.first.xpath").click();
		logger.info("Selected Application Card is : "
				+ utility.initializeElement(LoginPage.driver, "applicationcard.card.first.xpath").getText());
		logger.info("1st Selected Application Card is selected: "
				+ utility.initializeElement(LoginPage.driver, "applicationcard.card.first.xpath").isSelected());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("selectFirstAppCard : Clicked Application Card button");
	}
	
	/**
	 * This method is used to select 2nd Application card from application selection
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectSecondAppCard() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "applicationcard.card.second.xpath").click();
		logger.info("Selected 2nd Application Card is : "
				+ utility.initializeElement(LoginPage.driver, "applicationcard.card.second.xpath").getText());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("selectSecondAppCard : Clicked Application Card button");
	}
	
	/**
	 * This method is used to check Application card unselected or not 
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void isPrevioslySelectedCardUnselected() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "applicationcard.card.first.xpath").isSelected();
		logger.info("1st Selected Application Card is selected: "
				+ utility.initializeElement(LoginPage.driver, "applicationcard.card.first.xpath").isSelected());
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("unselectFirstAppCard : Previously selected Application Card is unselected");
	}
	
	
	public Boolean isCardSelectedByDefault() throws IOException {
		List<WebElement> card = utility.initializeElements(LoginPage.driver, "applicationcard.card.list.xpath");
		int no =card.size();
		utility.initializeElement(LoginPage.driver, "applicationcard.card.first.xpath").click();
		logger.info("Number of Application card displayed : " +no);
		for(int i = 0; i< card.size(); i++) {
			 logger.info("Application card selected by default : "+card.get(i).isSelected());
		}
		return false;
	}
}
