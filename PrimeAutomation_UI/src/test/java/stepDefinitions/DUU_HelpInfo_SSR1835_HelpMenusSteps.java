package stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.HelpInfoPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_HelpInfo_SSR1835_HelpMenusSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_HelpInfo_SSR1835_HelpMenusSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	SelectedActivityPage sp = new SelectedActivityPage();
	HelpInfoPage hp = new HelpInfoPage();

	@BeforeStep
	public void beforeStep(Scenario scenario) {
		exception = null;
	}

	@AfterStep
	public void afterStep() {
		String exceptionName = null;
		if (exception != null) {
			stepStatus = false;
			logger.info(
					"\n******************************STEP FAILED*****************************************************");
			exceptionName = exception.getClass().getSimpleName();
			logger.info("Exception Type : " + exceptionName);
			if (exceptionName.equals("NoSuchElementException")) {
				logger.info("Element could not be found");
			} else if (exceptionName.equals("ElementNotSelectableException")) {
				logger.info("Element could not be not selected");
			} else if (exceptionName.equals("NoSuchFrameException")) {
				logger.info("Frame does not exist");
			} else if (exceptionName.equals("NoSuchWindowException")) {
				logger.info("Window does not exist");
			} else if (exceptionName.equals("TimeoutException")) {
				logger.info("Element could not be found within the specified time");
			} else if (exceptionName.equals("ConnectionClosedException")) {
				logger.info("Driver is disconnected");
			} else if (exceptionName.equals("AssertionError")) {
				logger.info(exceptionName);
			} else {
				logger.info("Exception occured : " + exceptionName);
			}
			logger.info("Exception Details below:\n");
			logger.info(exception.toString());
			logger.info(
					"**********************************************************************************************");
			System.out.println(stepStatus);
		}
		if (stepStatus == false) {
			logger.info("TESTCASE HAS FAILED AT THIS STEP");
			Assert.fail();
		}
	}

	@Given("file dashboad page is displayed to user")
	public void file_dashboad_page_is_displayed_to_user() {
		try {
			lp = new LoginPage();
			String title = LoginPage.driver.getTitle();
			logger.info("Title of the application : " + title);
			logger.info("Step : Homepage is displayed to the user ");
			sp.isDashboardHeaderDisplayed();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("Homepage is not loaded ");
			exception = e;
		}
	}

	@When("user clicks on help center menu icon")
	public void user_clicks_on_help_center_menu_icon() {
		try {
			lp = new LoginPage();
			hp.clickHelpIcon();
			logger.info("Step : Help Icon is clicked and PDF viewer is displayed on right side panel");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}

	}

	@Then("pdf viewer is displayed on left menu panel")
	public void pdf_viewer_is_displayed_on_left_menu_panel() {
		try {
			lp = new LoginPage();
			hp.isHelpCenterHeaderDisplayed();
			logger.info("Step : PDF viewer is displayed to the user ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("PDF is not loaded ");
			exception = e;
		}
	}

	@Then("file gets downloaded in the current user system")
	public void file_gets_dpwnloaded() {
		try {
			Thread.sleep(5000);
			logger.info("Step : File gets downloaded in the system");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			logger.error("PDF is not downlaoded");
			exception = e;
		}
	}

	@Then("the below components shall be displayed on top bar of pdf viewer")
	public void the_below_components_shall_be_displayed_on_top_bar_of_pdf_viewer(List<Map<String, String>> dt) {
		try {
			LoginPage.driver.switchTo().frame(0);
			lp = new LoginPage();
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("screen").contains("Toggle Sidebar")) {
					assertTrue(hp.isPdfInfoDisplayed("Toggle Sidebar").isDisplayed(),
							"The Toggle Sidebar button is not displayed");
					logger.info("The Toggle Sidebar button is displayed");

				}
				if (list.get(i).get("screen").contains("Find in Document")) {
					assertTrue(hp.isPdfInfoDisplayed("Find in Document").isDisplayed(),
							"Find in Document button is not displayed");
					logger.info("Find in Document button is displayed");
				}

				if (list.get(i).get("screen").contains("Next Page")) {
					assertTrue(hp.isPdfInfoDisplayed("Next Page").isDisplayed(), "Next Page button is not displayed");
					logger.info("Next Page button is displayed");
				}

				if (list.get(i).get("screen").contains("Page")) {
					assertTrue(hp.isPdfInfoDisplayed("Page").isDisplayed(), "Page button is not displayed");
					logger.info("Page button is displayed");
				}
				if (list.get(i).get("screen").contains("Zoom Out")) {
					assertTrue(hp.isPdfInfoDisplayed("Zoom Out").isDisplayed(), "Zoom Out button is not displayed.");
					logger.info("Zoom Out button is displayed");
				}
				if (list.get(i).get("screen").contains("Zoom In")) {
					assertTrue(hp.isPdfInfoDisplayed("Zoom In").isDisplayed(), "Zoom In button is not displayed.");
					logger.info("Zoom In button is displayed");
				}
				if (list.get(i).get("screen").contains("Print")) {
					assertTrue(hp.isPdfInfoDisplayed("Print").isDisplayed(), "Print button is not displayed.");
					logger.info("Print button is displayed");
				}
				if (list.get(i).get("screen").contains("Download")) {
					assertTrue(hp.isPdfInfoDisplayed("Download").isDisplayed(), "Download button is not displayed.");
					logger.info("Download button is displayed");
				}
				if (list.get(i).get("screen").contains("Tools")) {
					assertTrue(hp.isPdfInfoDisplayed("Tools").isDisplayed(), "Tools button is not displayed.");
					logger.info("Tools button is displayed");
				}
				if (list.get(i).get("screen").contains("Zoom")) {
					assertTrue(hp.isPdfInfoDisplayed("Tools").isDisplayed(), "Page Width button is not displayed.");
					logger.info("Page Width button is displayed");
				}
				if (list.get(i).get("screen").contains("Previous Page")) {
					assertFalse(hp.isPdfInfoDisplayed("Previous Page").isEnabled(),
							"Page Width button is not displayed");
					logger.info("Previous Page button is displayed but is in disabled mode");
				}

			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("PDF Viewer screen components are not displayed");
			exception = e;
		}
	}

	@When("user clicks on Toggle Sidebar")
	public void user_clicks_on_toggle_sidebar() {
		try {
			hp.clickToggleSidebar();
			logger.info("Step : Toggle Sidebar icon is clicked on PDF viewer");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("the menu bar slights from left to right that displays below components")
	public void the_menu_bar_slights_from_left_to_right_that_displays_below_components(List<Map<String, String>> dt) {
		try {
			lp = new LoginPage();
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {

				if (list.get(i).get("screen").contains("Show Thumbnails")) {
					assertTrue(hp.isPdfInfoDisplayed("Show Thumbnails").isDisplayed(),
							"Show Thumbnails button is not displayed");
					logger.info("Show Thumbnails button is displayed");
				}
				if (list.get(i).get("screen").contains("Show Document Outline")) {
					assertFalse(hp.isPdfInfoDisplayed("Show Document Outline").isEnabled(),
							"Show Document Outline button is not displayed.");
					logger.info("Show Document Outline button is displayed but is in disabled mode");
				}
				if (list.get(i).get("screen").contains("Show Attachments")) {
					assertFalse(hp.isPdfInfoDisplayed("Show Attachments").isEnabled(),
							"Show Attachments button is not displayed.");
					logger.info("Show Attachments button is displayed but is in disabled mode");
					hp.clickToggleSidebar();
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Toggle Sidebar screen components are not displayed");
			exception = e;
		}
	}

	@When("user clicks on Download button on pdf viewer")
	public void user_clicks_on_download_button_on_pdf_viewer() {
		try {
			hp.clickDownload();
			logger.info("Step : Download Icon is clicked on PDF viewer");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Scroll bar is displayed to the user")
	public void scroll_bar_displayed_to_the_user() {
		{
			try {
				hp.isScrollBarDisplayed();
				logger.info("Step : Scroll bar is displayed ");
				LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			} catch (Exception e) {
				logger.error("Step: Caught exception:: " + e.toString());
				exception = e;
			}
		}
	}

	@Then("all the page of the pdf is displayed in left side bar")
	public void all_the_page_of_the_pdf_is_displayed_in_left_side_bar() {
		try {
			hp.clickToggleSidebar();
			hp.pageNumber();
			logger.info("Step : All the page of the PDF viewer is displayed to user ");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			hp.clickToggleSidebar();
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on Find in Document button")
	public void user_clicks_on_find_in_document_button() {
		try {
			hp.clickDocument();
			logger.info("Step : File in Document button is clicked on PDF viewer");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user enters any keyword to search")
	public void user_enters_any_keyword_to_search() {
		try {
			hp.enterTextInSearchBox().sendKeys("simple");
			logger.info("The text in search box is entered as : simple ");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on Next page button")
	public void user_clicks_on_next_page_button() {
		try {
			hp.clickNextPage();
			logger.info("Step : Next Page button is clicked on PDF viewer");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on Previous page button")
	public void user_clicks_on_previous_page_button() {
		try {
			hp.clickPreviousPage();
			logger.info("Step : Previous Page button is clicked on PDF viewer");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on Zoom out icon")
	public void user_clicks_on_zoom_out_icon() {
		try {
			hp.clickZoomOut();
			logger.info("Step : Zoom Out button is clicked on PDF viewer");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on Zoom in icon")
	public void user_clicks_on_zoom_in_icon() {
		try {
			hp.clickZoomOut();
			logger.info("Step : Zoom In button is clicked on PDF viewer");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on page width field")
	public void user_clicks_on_page_width_field() {
		try {
			hp.clickPageWidht();
			logger.info("Step : Page Widht button is clicked on PDF viewer");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("user verifies software information menu icon is displayed on the bottom of left menu")
	public void software_information() {
		try {
			hp.isSoftwareIconDisplayed();
			logger.info("Step : Software information menu icon is displayed on the bottom of left menu");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@When("clicks on software information icon")
	public void clicks_on_software_information_icon() {
		try {
			hp.clickSoftwareInformation();
			logger.info("Step : Software information icon is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("selects any of the value")
	public void selects_any_of_the_value() {
		try {
			Select s = new Select(LoginPage.driver.findElement(By.id("scaleSelect")));
			List<WebElement> op = s.getOptions();
			int size = op.size();
			for (int i = 0; i < size; i++) {
				String options = op.get(i).getText();
				logger.info("Values present in dropdown field : " + options);
			}
			Thread.sleep(4000);
			s.selectByIndex(9);
			logger.info("Step : Value is selected from dropdwon list");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("user clicks on Print button")
	public void user_clicks_on_print_button() {
		try {
			hp.clickPrint();
			logger.info("Step : Print button is clicked on PDF viewer");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("pdf page is zoomed in")
	public void pdf_page_is_zoomed_in() throws IOException {
		logger.info("Step : PDF page is zoomed in from original");
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	}

	@Then("Search box is displayed on pdf viewer")
	public void search_box_is_displayed_on_pdf_viewer() {
		try {
			hp.isSearchBoxDisplayed();
			logger.info("Step : Search Box is displayed on PDF viewer");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Number of matching words in the pdf shall be displayed")
	public void list_of_matching_words_in_the_pdf_shall_be_displayed() {
		try {
			LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Assert.assertTrue(hp.isListDisplayedSimpleText());
			logger.info("Step : The Number of matching words is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
			hp.enterTextInSearchBox().clear();
			hp.clickDocument();
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("print pop up screen is displayed")
	public void print_pop_up_screen_is_displayed() throws IOException, InterruptedException {
		Thread.sleep(10000);
		LoginPage.driver.switchTo().defaultContent();
		logger.info("Step : Print Pop up screen is displayed on PDF viewer page");
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);

	}

	@Then("pdf page is zoomed out")
	public void pdf_page_is_zoomed_out() throws IOException {
		logger.info("Step : PDF page is zoomed out from original");
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);

	}
	
	@Then("software information is displayed on the screen")
	public void software_information_displayed_the_screen() throws IOException, InterruptedException {
		hp.getSoftwareInformation();
		hp.getSoftwareVersion();
		logger.info("Step : software information is displayed on the screen");
		hp.clickSoftwareCrossIcon();
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);

	}

	@Then("PDF is displayed as per the resolution selected on page width field")
	public void pdf_is_displayed_as_per_the_resolution_selected_on_page_width_field() throws IOException {
		logger.info("Step : PDF page is displayed as per the resolution selected ");
		LoginPage.driver.switchTo().defaultContent();
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	}

	@Then("user redirects to PDF Previous page")
	public void user_redirects_to_pdf_previous_page() throws IOException, InterruptedException {
		Thread.sleep(2000);
		logger.info("Step : User is navigated to Previous Page of the PDF ");
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	}

	@Then("user redirects to PDF Next page")
	public void user_redirects_to_pdf_next_page() throws IOException, InterruptedException {
		Thread.sleep(2000);
		logger.info("Step : Next Page of the PDF is displayed to user");
		LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	}
	
	@When("the user clicks on tools icon on top right side of pdf viewer")
	public void user_selects_tools_menu() throws IOException, InterruptedException {
		try {
			logger.info("Step: the user clicks on tools icon on top right side of pdf viewer");
			hp.clickToolbarButton();
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Tools Menu could not be selected");
			exception = e;
		}
	}
	
	@Then("the following tool feature pop up shall be opened")
	public void the_below_components_shall_be_displayed_in_toolbar_of_pdf_viewer(List<Map<String, String>> dt) {
		try {
			lp = new LoginPage();
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("option").contains("Go to first page")) {
					assertTrue(hp.isToolBarInfoDisplayed("Go to first page").isDisplayed(), "Go to first page button is not displayed");
					logger.info("Go to first page button is displayed");
				}
				if (list.get(i).get("option").contains("Go to last page")) {
					assertTrue(hp.isToolBarInfoDisplayed("Go to last page").isDisplayed(), "Go to last page button is not displayed");
					logger.info("Go to last page button is displayed");
				}
				if (list.get(i).get("option").contains("Rotate clockwise")) {
					assertTrue(hp.isToolBarInfoDisplayed("Rotate clockwise").isDisplayed(), "Rotate clockwise button is not displayed");
					logger.info("rotate clockwise button is displayed");
				}
				if (list.get(i).get("option").contains("Rotate counterclockwise")) {
					assertTrue(hp.isToolBarInfoDisplayed("Rotate counterclockwise").isDisplayed(), "Rotate counterclockwise button is not displayed");
					logger.info("rotate counterclockwise button is displayed");
				}
				if (list.get(i).get("option").contains("text selection tool")) {
					assertTrue(hp.isToolBarInfoDisplayed("text selection tool").isDisplayed(), "Text selection tool button is not displayed.");
					logger.info("text selection tool button is displayed");
				}
				if (list.get(i).get("option").contains("Hand tool")) {
					assertTrue(hp.isToolBarInfoDisplayed("Hand tool").isDisplayed(), "Hand tool button is not displayed.");
					logger.info("Hand tool button is displayed");
				}
				if (list.get(i).get("option").contains("Vertical scrolling")) {
					assertTrue(hp.isToolBarInfoDisplayed("Vertical scrolling").isDisplayed(), "Vertical scrolling button is not displayed.");
					logger.info("Vertical Scrolling button is displayed");
				}
				if (list.get(i).get("option").contains("Horizontal scrolling")) {
					assertTrue(hp.isToolBarInfoDisplayed("Horizontal scrolling").isDisplayed(), "Horizontal scrolling button is not displayed.");
					logger.info("Horizontal scrolling button is displayed");
				}
				if (list.get(i).get("option").contains("Wrapped scrolling")) {
					assertTrue(hp.isToolBarInfoDisplayed("Wrapped scrolling").isDisplayed(), "Wrapped scrolling button is not displayed.");
					logger.info("Wrapped scrolling button is displayed");
				}
				if (list.get(i).get("option").contains("No spreads")) {
					assertTrue(hp.isToolBarInfoDisplayed("No spreads").isDisplayed(), "No spreads button is not displayed.");
					logger.info("No spreads button is displayed");
				}
				if (list.get(i).get("option").contains("Odd Spreads")) {
					assertTrue(hp.isToolBarInfoDisplayed("Odd Spreads").isDisplayed(), "Odd Spreads button is not displayed.");
					logger.info("Odd Spreads button is displayed");
				}
				if (list.get(i).get("option").contains("Even spreads")) {
					assertTrue(hp.isToolBarInfoDisplayed("Even spreads").isDisplayed(), "Even spreads button is not displayed.");
					logger.info("Even spreads button is displayed");
				}
				if (list.get(i).get("option").contains("Document properties")) {
					assertTrue(hp.isToolBarInfoDisplayed("Document properties").isDisplayed(), "Document properties button is not displayed.");
					logger.info("Document properties button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("PDF Viewer screen toolbar components are not displayed");
			exception = e;
		}
	}
	
	@When("the user clicks on page number textbox and enters 2")
	public void user_enters_page_into_textbox() throws IOException {
		try {
			hp.clickPageNumberButton();
			hp.enterPageNumber();
			logger.info("User Enters Page 2 into textbox");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("User unable to enter page number into textbox");
			exception = e;
		}
	}
	
	@Then("the 2 page of pdf viewer shall be displayed")
	public void page_two_of_pdf_is_displayed() {
		try {
			assertTrue(hp.isPageTwoOfPDFDisplayed());
			logger.info("Page two of PDF is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Page Two of PDF not displayed");
			exception = e;
		}
	}
	
	@Then("the user clicks on go to first page")
	public void user_clicks_go_to_first_page_button() {
		try {
			hp.clickGoToFirstPageButton();
			logger.info("User Clicks Go To First Page Button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("User unable to click go to first page button in help&info toolbar");
			exception = e;
		}
	}

    @Then("the first page of pdf viewer shall be displayed")
    public void page_one_of_pdf_is_displayed() {
		try {
			assertTrue(hp.isPageOneOfPDFDisplayed());
			logger.info("Page one of PDF is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Page One of PDF not displayed");
			exception = e;
		}
    }
    
    @Then("the user clicks on go to last page")
    public void user_clicks_go_to_last_page_button() {
    	try {
    		hp.clickGoToLastPageButton();
			logger.info("User Clicks Go To Last Page Button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("User unable to click go to last page button in help&info toolbar");
			exception = e;
		}
    }
    
    @Then("the last page of pdf viewer shall be displayed")
    public void last_page_of_pdf_is_displayed() {
    	try {
    		assertFalse(hp.isLastPageOfPDFDisplayed());
    		logger.info("Last page of pdf is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Last page of PDF not displayed");
			exception = e;
		}
    }
    
    @Then("the user clicks on rotate clockwise")
    public void user_clicks_rotate_clockwise_button() {
    	try {
    		hp.clickRotateClockwiseButton();
    		hp.clickToolbarButton();
    		logger.info("Rotate Clockwise Button has been clicked");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Could not click rotate clockwise button");
			exception = e;
		}
    }
    
	@Then("the pdf document shall be rotated clockwise")
	public void the_pdf_is_rotated_clockwise() {
    	try {
    		logger.info("PDF is rotated Clockwise");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The page is not rotated clockwise");
			exception = e;
		}
    }
	
	@Then("the user clicks on rotate counterclockwise")
	public void user_clicks_rotate_counterclockwise_button() {
		try {
			hp.clickRotateCounterClockwiseButton();
			hp.clickToolbarButton();
			logger.info("User clicks rotate counterclockwise button");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Could not click rotate counterclockwise button");
			exception = e;
		}
	}

    @Then("the pdf document shall be rotated counterclockwise")
    public void the_pdf_is_rotated_counterclockwise() {
    	try {
    		logger.info("PDF is rotated CounterClockwise");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	    } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("The page is not rotated counterclockwise");
			exception = e;
		}
    }
    @Then("the text selection tool shall be displayed as selected")
    public void text_selection_tool_selected() {
    	try {
    		assertTrue(hp.isTextSelectionToolEnabled());
    		logger.info("Text Selection Tool Enabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Text Selection tool is disabled");
			exception = e;
		}
    }

    @When("the user selects any text on pdf viewer")
    public void user_select_pdf_page_two_header_text() {
    	try {
    		hp.selectPDFPageTwoHeader();
    		logger.info("User selects the PDF Page Two Header Text");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to select text");
			exception = e;
		}
    }

    @Then("the user should be able to select text on pdf viewer")
    public void user_selects_all_text() {
    	try {
    		hp.selectBodyText();
    		logger.info("User selects the pdf Page Two Body Text");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Text is not selected");
			exception = e;
		}
    }
    
    @Then("the user clicks on hand tool")
    public void user_selects_hand_tool() {
    	try {
    		hp.clickHandTool();
    		logger.info("User Selects Hand Tool");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to select Hand Tool");
			exception = e;
		}
    }

    @Then("the hand tool shall be enabled")
    public void hand_tool_is_enabled() {
    	try {
    		hp.isHandToolEnabled();
    		logger.info("Hand tool is enabled");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Hand tool not enabled");
			exception = e;
		}
    }
    
    @Then("the user shall be able to move the pdf document using hand cursor tool")
    public void user_moves_pdf_with_hand_tool() {
    	try {
    		hp.usingHandTool();
    		logger.info("User uses hand tool on pdf");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unabled to use Hand Tool to move document");
			exception = e;
		}
    }
    
    @Then("the user clicks on horizontal scrolling")
    public void user_clicks_horizonal_scrolling() {
    	try {
    		hp.clickHorizontalScrollingTool();
    		logger.info("User selects horizontal scrolling tool");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unabled to select Horizontal Scrolling tool");
			exception = e;
		}
    }
    
    @Then("the horizontal scrolling bar shall be displayed at the bottom of pdf viewer")
    public void horizontal_scrolling_bar_is_displayed() {
    	try {
    	logger.info("Horizontal scrolling bar is displayed");
		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Horizontal Scrolling bar is not displayed");
			exception = e;
		}
    }
    
    @Then("the user clicks on wrapped scrolling")
    public void user_clicks_wrapped_scrolling() {
    	try {
    		hp.clickWrappedScrollingTool();
    		logger.info("User clicked wrapped scrolling button");
    		screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
       	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Horizontal Scrolling bar is not displayed");
			exception = e;
    	}
    }
    
    @Then("the wrapped scrolling bar shall be displayed at the bottom of pdf viewer")
    public void wrapped_scrolling_bar_is_displayed() {
    	try {
	    	logger.info("Wrapped scrolling bar is displayed");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
    	} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Wrapped Scrolling bar is not displayed");
			exception = e;
        }
    }
    
   @Then("the user clicks on odd spreads")
   public void user_clicks_odd_spreads_button() {
	   try {
		   hp.clickOddSpreadsTool();
		   logger.info("User clicked odd spreads button");
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	   } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Could not click odd spreads button");
			exception = e;
       }
   }
   
   @Then("the pdf pages shall be displayed side by side starting with odd pages")
   public void odd_spreads_is_displayed() {
	   try {
		   logger.info("Odd Spreads functionality displayed");
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	   } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Odd spreads not displayed correctly");
			exception = e;
      }
   }
   
   @Then("the user clicks on even spreads")
   public void user_clicks_even_spreads_button() {
	   try {
		   hp.clickEvenSpreadsTool();
		   logger.info("Even Spreads functionality displayed");
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	   } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Could not click even spreads");
			exception = e;
       }
   }
   
   @Then("the pdf pages shall be displayed side by side starting with even pages")
   public void even_spreads_is_displayed() {
	   try {
		   logger.info("Even Spreads displayed correctly");
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	   } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Even spreads not displayed correctly");
			exception = e;
      }
   }

   @Then("the user clicks on document properties")
   public void user_clicks_document_properties_button() {
	   try {
		   hp.clickDocumentProperties();
		   logger.info("User clicked document properties button");
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	   } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to click document properties button");
			exception = e;
       }
   }
   
   @Then("the pdf document properties pop up shall be displayed")
   public void document_properties_displayed() {
	   try {
		   assertTrue(hp.isDocumentPropertiesDisplayed());
		   logger.info("Document properties pop up is displayed");
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	   } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Document Properties pop up not displayed");
			exception = e;
      }
   }

   @When("the user clicks on close")
   public void user_clicks_document_properties_close_button() {
	   try {
		   hp.clickDocumentPropertiesClose();
		   logger.info("User closed document properties pop up");
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	   } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Unable to click document properties close button");
			exception = e;
       }
   }
   
   @Then("the pdf document properties popup shall be closed")
   public void document_properties_is_not_displayed() {
	   try {
		   assertFalse(hp.isDocumentPropertiesDisplayed());
		   logger.info("Document properties pop up has been closed properly");
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	   } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Document properties was not closed properly");
			exception = e;
       }
   }
   
   @Then("the following properties of pdf document shall be displayed")
	public void the_below_components_shall_be_displayed_in_document_properties_pop_up(List<Map<String, String>> dt) {
		try {
			lp = new LoginPage();
			List<Map<String, String>> list = dt;
			for (int i = 0; i <= list.size() - 1; i++) {
				if (list.get(i).get("properties").contains("file name")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("file name").isDisplayed(), "file name is not displayed");
					logger.info("file name is displayed");
				}
				if (list.get(i).get("properties").contains("file size")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("file size").isDisplayed(), "file size is not displayed");
					logger.info("file size is displayed");
				}
				if (list.get(i).get("properties").contains("title")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("title").isDisplayed(), "title is not displayed");
					logger.info("title is displayed");
				}
				if (list.get(i).get("properties").contains("author")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("author").isDisplayed(), "author is not displayed");
					logger.info("author is displayed");
				}
				if (list.get(i).get("properties").contains("subject")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("subject").isDisplayed(), "subject is not displayed.");
					logger.info("subject is displayed");
				}
				if (list.get(i).get("properties").contains("keywords")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("keywords").isDisplayed(), "keywords is not displayed.");
					logger.info("keywords is displayed");
				}
				if (list.get(i).get("properties").contains("creation date")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("creation date").isDisplayed(), "creation date is not displayed.");
					logger.info("creation date is displayed");
				}
				if (list.get(i).get("properties").contains("modification date")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("modification date").isDisplayed(), "modification date is not displayed.");
					logger.info("modification date is displayed");
				}
				if (list.get(i).get("properties").contains("creator")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("creator").isDisplayed(), "creator is not displayed.");
					logger.info("creator is displayed");
				}
				if (list.get(i).get("properties").contains("pdf producer")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("pdf producer").isDisplayed(), "pdf producer is not displayed.");
					logger.info("pdf producer button is displayed");
				}
				if (list.get(i).get("properties").contains("pdf version")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("pdf version").isDisplayed(), "pdf version is not displayed.");
					logger.info("pdf version is displayed");
				}
				if (list.get(i).get("properties").contains("page count")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("page count").isDisplayed(), "page count is not displayed.");
					logger.info("page count is displayed");
				}
				if (list.get(i).get("properties").contains("page size")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("page size").isDisplayed(), "page size is not displayed.");
					logger.info("page size is displayed");
				}
				if (list.get(i).get("properties").contains("fast web view")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("fast web view").isDisplayed(), "fast web view is not displayed.");
					logger.info("fast web view is displayed");
				}
				if (list.get(i).get("properties").contains("close button")) {
					assertTrue(hp.isDocumentPropertiesInfoDisplayed("close button").isDisplayed(), "close button is not displayed.");
					logger.info("close button is displayed");
				}
			}
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Document Properties components are not displayed");
			exception = e;
		}
	}
   
   @Then("the header text as help center shall be displayed at top left of the screen")
   public void the_header_text_as_help_center_shall_be_displayed_at_top_left_of_the_screen() {
	   try {
		   hp.isHelpCenterHeaderDisplayed();
		   logger.info("Header text as help center shall be displayed at top left of the screen");
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	   } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("Header text as help center is not displayed");
			exception = e;
       }
   }
   
   @Then("the pdf viewer popup shall be displayed")
   public void the_pdf_viewer_popup_shall_be_displayed() {
	   try {
		   hp.isHelpCenterHeaderDisplayed();
		   logger.info("PDF viewer popup is displayed in the screen");
		   screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
	   } catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			Assert.fail("PDF Viewer is not loaded");
			exception = e;
       }
   }
   
   @Then("the help center text shall be displayed in white colour")
   public void the_help_center_text_shall_be_displayed_in_white_colour() {
	   try {
			hp.isHelpCenterHighlighted();
			logger.info("Step : Help Center is highlighted ");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
   }
   
   @Then("the second page of pdf viewer shall be displayed")
   public void the_second_page_of_pdf_viewer_shall_be_displayed() {
	   try {
			hp.isPageTwoOfPDFDisplayed();
			logger.info("Step : Second page of PDF viewer is displayed to the user");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
   }
   
   @Then("the next page icon shall be disabled")
   public void the_next_page_icon_shall_be_disabled() {
	   try {
			hp.isNextEnabled();
			logger.info("Step : Next page icon is in disabled state");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
   }
   
   
   @Then("the previous page icon shall be shall be enabled")
   public void the_previous_page_icon_shall_be_shall_be_enabled() {
	   try {
			hp.isPreviousPageEnabled();
			logger.info("Step : Previous page icon is in enabled state");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
   }
   @Then("the next page icon shall be enabled")
   public void the_next_page_icon_shall_be_enabled() {
	   try {
			hp.isNextEnabled();
			logger.info("Step : Next page icon is enabled ");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
   }
   @Then("the previous page icon shall be shall be disabled")
   public void the_previous_page_icon_shall_be_shall_be_disabled() {
	   try {
			hp.isPreviousPageEnabled();
			logger.info("Step : Previous page icon is in disabled state");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
   }
   
   @Then("the content of pdf viewer shall be displayed in black colour")
   public void the_content_of_pdf_viewer_shall_be_displayed_in_black_colour() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @When("the user clicks on show document outline")
   public void the_user_clicks_on_show_document_outline() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @Then("the user shall not be able to click on show document outline icon if no otline available")
   public void the_user_shall_not_be_able_to_click_on_show_document_outline_icon_if_no_otline_available() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @When("the user clicks on show attachments")
   public void the_user_clicks_on_show_attachments() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @Then("the user shall not be able to click on show attachments icon if no attachments available")
   public void the_user_shall_not_be_able_to_click_on_show_attachments_icon_if_no_attachments_available() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @When("the user clicks on search icon at top left bar of pdf viewer")
   public void the_user_clicks_on_search_icon_at_top_left_bar_of_pdf_viewer() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @Then("a find search bar with text find in document shall be displayed")
   public void a_find_search_bar_with_text_find_in_document_shall_be_displayed() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @Then("the states find the previous occurrence of the phrase shall be displayed")
   public void the_states_find_the_previous_occurrence_of_the_phrase_shall_be_displayed() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @Then("the states find the next occurrence of the phrase shall be displayed")
   public void the_states_find_the_next_occurrence_of_the_phrase_shall_be_displayed() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @Then("the checkbox for highlight all shall be displayed")
   public void the_checkbox_for_highlight_all_shall_be_displayed() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @Then("the checkbox for match case shall be displayed")
   public void the_checkbox_for_match_case_shall_be_displayed() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @Then("the checkbox for whole words shall be displayed")
   public void the_checkbox_for_whole_words_shall_be_displayed() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @Then("the upload file icon shall be displayed")
   public void the_upload_file_icon_shall_be_displayed() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   @Then("upload button shall be displayed")
   public void upload_button_shall_be_displayed() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
   
   
}