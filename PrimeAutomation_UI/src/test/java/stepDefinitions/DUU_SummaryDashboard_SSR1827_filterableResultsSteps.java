package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.Assert;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDashboardPage;
import pages.LoginPage;
import pages.SelectedActivityPage;
import pages.SettingsPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_SummaryDashboard_SSR1827_filterableResultsSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_SummaryDashboard_SSR1827_filterableResultsSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	FileDashboardPage fdP = new FileDashboardPage();
	SettingsPage sP = new SettingsPage();

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

	@When("Clicks on Application option")
	public void clicks_on_application_option() {
		try {
			fdP = new FileDashboardPage();
			fdP.clickApplication();
			logger.info("Step: Application Icon is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("Selects any application for filtering")
	public void selects_any_application_for_filtering() {
		try {
			fdP = new FileDashboardPage();
			fdP.SelectApplication();
			logger.info("Step: Application is selected");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Upload dashboard page should display results with filtered data as per application selection")
	public void upload_dashboard_page_should_display_results_with_filtered_data_as_per_application_selection() {
		try {
			fdP = new FileDashboardPage();
			fdP.isApplicationDisplayed();
			logger.info(
					"Step: Upload dashboard page displays results with filtered data as per the Application selected");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("user removes the selected application from upload dashboard page")
	public void user_removes_the_selected_application_from_upload_dashboard_page() {
		try {
			fdP = new FileDashboardPage();
			fdP.clickCrossIcon();
			logger.info("Step : X Icon is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("Clicks on File Status option")
	public void clicks_on_file_status_option() {
		try {
			fdP = new FileDashboardPage();
			fdP.clickFileStatusIcon();
			logger.info("Step: FileStatus Icon is clicked");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@When("Selects File Status for filtering")
	public void selects_file_status_for_filtering() {
		try {
			fdP = new FileDashboardPage();
			fdP.SelectFileStatus();
			logger.info("Step: File Status is selected");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}

	@Then("Upload dashboard page should display results with filtered data as per File Status selection")
	public void upload_dashboard_page_should_display_results_with_filtered_data_as_per_file_status_selection() {
		try {
			fdP = new FileDashboardPage();
			fdP.isStatusDisplayed();
			logger.info("Upload dashboard page should display results with filtered data as per File Status selection");
			LoginPage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
	
	@Then("the image upload details recorded in precondition is displayed in the Upload dashboard screen")
    public void the_image_upload_details_recorded_in_precondition_is_displayed_in_the_upload_dashboard_screen() throws IOException {
        try {
            logger.info("Step : the image upload details recorded in precondition is displayed in the Upload dashboard screen");
            Assert.assertTrue(fdP.isrecordDisplayed());
            screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        }
    }

 


    @When("the user click on + for {string} and select a {string} from the list and click on done button")
    public void the_user_click_on_for_and_select_a_from_the_list_and_click_on_done_button(String string, String string2) throws IOException, InterruptedException {
        try {
        	String ssname = "the user click on + for "+string+" and select a "+string2+" from the list and click on done button";
            logger.info("Step : "+ ssname);
            fdP.selectFilter(string);
            if(string.equalsIgnoreCase("Application"))
                fdP.ApplicationInFilterListSelect();
            else if(string.equalsIgnoreCase("File status"))
                fdP.fileStatusInFilterListSelect();
            else if(string.equalsIgnoreCase("Surgeon"))
                fdP.surgeonFilterListSelect();
            else
                fdP.selectFirstoptionInFilterList();
            sP.clickDoneButton();
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        }
    }

 

    @Then("the records are filtered out as per the {string} selected in filter")
    public void the_records_are_filtered_out_as_per_the_selected_in_filter(String string) throws IOException, InterruptedException {
        try {
            String ssname = "the records are filtered out as per the "+string+" selected in filter";
            logger.info("Step : "+ ssname);
            Assert.assertTrue(fdP.isRecordsFiltered(string));
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        }
    }

 

    @Then("the selected {string} pop-up is highlighted at the top-left")
    public void the_selected_pop_up_is_highlighted_at_the_top_left(String string) throws IOException {
        try {
            String ssname = "the selected "+string+" pop-up is highlighted at the top-left";
            logger.info("Step : "+ ssname);
            if(string.equalsIgnoreCase("application name and File status")||string.equalsIgnoreCase("Application and Surgeon"))
                Assert.assertTrue(fdP.is2FiltersPopUpDisplayed());
            else
                Assert.assertTrue(fdP.isAppliedFilterPopUpDisplayed());
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        }
    }

 

    @When("the user click on {string} on the pop-up")
    public void the_user_click_on_on_the_pop_up(String string) throws IOException {
        try {
            String ssname = "the user click on "+string+" on the pop-up";
            logger.info("Step : "+ ssname);
            fdP.clickXOnAppliedFilterPopUp();
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        } 
    }

 

    @Then("the {int} hrs filter is highlighted in Upload dashboard screen")
    public void the_hrs_filter_is_highlighted_in_upload_dashboard_screen(Integer int1) throws IOException {
        try {
            String ssname = "the "+int1.toString()+" hrs filter is highlighted in Upload dashboard screen";
            logger.info("Step : "+ ssname);
            Assert.assertTrue(fdP.is24hrFilterHighlighted());
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        } 
    }

 

    @Then("the records which is uploaded within {int} hours are displayed")
    public void the_records_which_is_uploaded_within_hours_are_displayed(Integer int1) throws IOException {
        try {
            String ssname = "the records which is uploaded within "+int1.toString()+" hours are displayed";
            logger.info("Step : "+ ssname);
            Assert.assertTrue(fdP.isrecordDisplayed());
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        } 
    }

 

    @Then("the {string} pop-up is disappeared")
    public void the_pop_up_is_disappeared(String string) throws IOException {
        try {
            String ssname = "the "+string+" pop-up is disappeared";
            logger.info("Step : "+ ssname);
            Assert.assertFalse(fdP.isAppliedFilterPopUpDisplayed());
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        } 
    }

 


    @When("the user click on + for {string} and select a {string}")
    public void the_user_click_on_for_surgeon_and_select_a_surgeon(String string,String string2) throws IOException, InterruptedException {
        try {
        	String ssname = "the user click on + for "+string+" and select a "+string2;
            logger.info("Step : "+ ssname);
            fdP.selectFilter(string);
            if(string.equalsIgnoreCase("Surgeon"))
                fdP.surgeonFilterListSelect();
            else
            {fdP.selectFirstoptionInFilterList();}
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        } 
    }

 

    @Then("the selected {string} is highlighted under the surgeon filter")
    public void the_selected_surgeon_name_is_highlighted_under_the_surgeon_filter(String string) throws IOException {
        try {
            String ssname = "the selected "+string+" is highlighted under the surgeon filter";
            logger.info("Step : "+ ssname);
            Assert.assertTrue(fdP.isfilterHighlightedInList(string));
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        }
    }

    @When("the user click on + for {string}")
    public void the_user_click_on_for(String string) throws IOException, InterruptedException {
    	try {
    		String ssname = "the user click on + for "+string;
            logger.info("Step : "+ ssname);
            fdP.selectFilter(string);
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        }
    }
    @When("the user click on selected {string}")
    public void the_user_click_on_selected(String string) throws IOException, InterruptedException {
    	try {
    		String ssname = "the user click on selected "+string;
            logger.info("Step : "+ ssname);
            if(string.equalsIgnoreCase("application name"))
                {fdP.ApplicationInFilterListSelect();}
            else if(string.equalsIgnoreCase("File status"))
                {fdP.fileStatusInFilterListSelect();}
            else if(string.equalsIgnoreCase("surgeon name"))
                fdP.surgeonFilterListSelect();
            else
                {fdP.selectFirstoptionInFilterList();}
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        }
    }
    @Then("the selected {string} is not highlighted and unselected")
    public void the_selected_is_not_highlighted_and_unselected(String string) throws IOException, InterruptedException {
    	try {
    		String ssname = "the selected "+ string +" is not highlighted and unselected";
            logger.info("Step : "+ ssname);
            Assert.assertFalse(fdP.isfilterHighlightedInList(string));
            screenshot.screenshot(ssname, LoginPage.driver);
        } catch (Exception e) {
            logger.error("Step: Caught exception:: " + e.toString());
            exception = e;
        }
    }

}
