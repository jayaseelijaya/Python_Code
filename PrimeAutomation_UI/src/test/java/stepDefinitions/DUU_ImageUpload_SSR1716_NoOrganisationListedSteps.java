package stepDefinitions;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Then;
import pages.FacilityListPage;
import pages.LoginPage;
import utility.PropertiesFileReader;
import utility.Screenshot;
import utility.Utility;

public class DUU_ImageUpload_SSR1716_NoOrganisationListedSteps {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(DUU_ImageUpload_SSR1716_NoOrganisationListedSteps.class);
	Utility utility = new Utility();
	Exception exception = null;
	Boolean stepStatus = true;
	Screenshot screenshot = new Screenshot();
	String scenarioName;
	LoginPage lp = new LoginPage();
	FacilityListPage fp = new FacilityListPage();

	@Then("error message is displayed if no data available for linked sites")
	public void error_message_is_displayed_if_no_data_available_for_linked_sites() {
		try {
			fp.isErrorMessageDisplayed();
			logger.info("Step: Error message is displayed if no data available for linked sites in Facility selection screen");
			screenshot.screenshot(new Throwable().getStackTrace()[0].getMethodName(), LoginPage.driver);
		} catch (Exception e) {
			logger.error("Step: Caught exception:: " + e.toString());
			exception = e;
		}
	}
}
