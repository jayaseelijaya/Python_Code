package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.PropertiesFileReader;
import utility.Utility;

public class ImagingLinksPage {

	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(ImagingLinksPage.class);
	Utility utility = new Utility();

	/**
	 * This method is to click the imaging links button in the left menu bar
	 * 
	 * @throws IOException
	 */
	public void clickImagingLinksPageButton() throws IOException {
		logger.info("User clicked imaging links page button");
		utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath").click();
	}

	/**
	 * This method is to unlink all facilities to the selected facility in ilPage
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void unlinkAllFacilities() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.left.canton.row.xpath").click();
		logger.info("Clicked Canton Health Center in Left Menu");
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "imaginglinks.pinlinked.btx.xpath").click();
		logger.info("Clicked pin linking button");
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "imaginglinks.right.abch.row.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").click();
			Thread.sleep(1000);
			utility.initializeElement(LoginPage.driver, "imaginglinks.pinlinked.btx.xpath").click();
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.right.acmh.row.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").click();
			Thread.sleep(1000);
			utility.initializeElement(LoginPage.driver, "imaginglinks.pinlinked.btx.xpath").click();
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.right.baystate.row.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").click();
			Thread.sleep(1000);
			utility.initializeElement(LoginPage.driver, "imaginglinks.pinlinked.btx.xpath").click();
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.right.briarwood.row.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").click();
			Thread.sleep(1000);
			utility.initializeElement(LoginPage.driver, "imaginglinks.pinlinked.btx.xpath").click();
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.right.emerson.row.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").click();
			Thread.sleep(1000);
			utility.initializeElement(LoginPage.driver, "imaginglinks.pinlinked.btx.xpath").click();
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.right.liviona.row.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").click();
			Thread.sleep(1000);
			utility.initializeElement(LoginPage.driver, "imaginglinks.pinlinked.btx.xpath").click();
		}
	}

	/**
	 * This method is to check that there are no facilities shown in upload sequence
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean noSiteShownInUpload() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "upload.nositeshown.txt.xpath").isDisplayed();
		if (bool == true) {
			logger.info("No sites are displayed");
			return true;
		} else {
			logger.info("There is a site displayed");
			return false;
		}
	}

	/**
	 * This method is to link a site in the image linking page to canton health
	 * center
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void linkSiteToCanton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.left.canton.row.xpath").click();
		logger.info("Clicked Canton Health Center in Left Menu");
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "imaginglinks.pinlinked.btx.xpath").click();
		logger.info("Clicked pin linking button");
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "imaginglinks.right.acmh.row.xpath").click();
		Thread.sleep(1000);
		utility.initializeElement(LoginPage.driver, "imaginglinks.createlink.btn.xpath").click();
		logger.info("Linked site to canton health center");
	}

	/**
	 * This method is to check that there is a facility shown in upload sequence
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean siteShownInUpload() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "upload.firstentry.txt.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Entry found in upload sequence");
			return true;
		} else {
			logger.info("No entry found in upload sequence");
			return false;
		}
	}

	/**
	 * This method is to check that the all organizations header is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkAllOrganizationHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.organizations.header.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Left side imaging links Header is displayed");
			return true;
		} else {
			logger.info("Left side imaging links Header is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the left table is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkLeftTable() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.left.table.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Left side table is displayed");
			return true;
		} else {
			logger.info("Left side table is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the activate site button is displayed in imaging
	 * links page
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkActivateSiteButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.activatesite.btn.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Activate site button is displayed");
			return true;
		} else {
			logger.info("Activate site button is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the activate site button is displayed in imaging
	 * links page
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkDeactivateSiteButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.deactivatesite.btn.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Deactivate site button is displayed");
			return true;
		} else {
			logger.info("Deactivate site button is not displayed");
			return false;
		}
	}

	/**
	 * This method is to click canton health center entry in left table
	 * 
	 * @throws IOException
	 */
	public void clickCantonHealthCenterInLeftTable() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.left.canton.row.xpath").click();
		logger.info("User clicked canton health center in left table");
	}

	/**
	 * This method is to check if the facility name under the left table is
	 * displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkLeftTableInfoFacilityName() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.info.facilityname.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Under Left Table info Facility Name is displayed");
			return true;
		} else {
			logger.info("Under Left Table info Facility Name is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the address under the left table is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkLeftTableInfoAddress() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.info.address.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Under Left Table info Address is displayed");
			return true;
		} else {
			logger.info("Under Left Table info Address is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the surgeon under the left table is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkLeftTableInfoSurgeon() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.info.surgeon.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Under Left Table info Surgeon is displayed");
			return true;
		} else {
			logger.info("Under Left Table info Surgeon is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the email under the left table is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkLeftTableInfoEmail() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.info.email.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Under Left Table info Email is displayed");
			return true;
		} else {
			logger.info("Under Left Table info Email is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the phone under the left table is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkLeftTableInfoPhone() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.info.phone.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Under Left Table info Phone is displayed");
			return true;
		} else {
			logger.info("Under Left Table info Phone is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the facility name under the right table is
	 * displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRightTableInfoFacilityName() throws IOException {
		Boolean bool = utility
				.initializeElement(LoginPage.driver, "imaginglinks.righttable.info.facilityname.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Under Right Table info Facility Name is displayed");
			return true;
		} else {
			logger.info("Under Right Table info Facility Name is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the address under the right table is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRightTableInfoAddress() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.info.address.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Under Right Table info Address is displayed");
			return true;
		} else {
			logger.info("Under Right Table info Address is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the surgeon under the right table is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRightTableInfoSurgeon() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.info.surgeon.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Under Right Table info Surgeon is displayed");
			return true;
		} else {
			logger.info("Under Right Table info Surgeon is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the email under the right table is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRightTableInfoEmail() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.info.email.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Under Right Table info Email is displayed");
			return true;
		} else {
			logger.info("Under Right Table info Email is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the phone under the right table is displayed
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRightTableInfoPhone() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.info.phone.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Under Right Table info Phone is displayed");
			return true;
		} else {
			logger.info("Under Right Table info Phone is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the imaging links button in the left menu bar is
	 * enabled
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkImagingLinksButtonInLeftMenu() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath").isDisplayed();
		if (bool == true) {
			logger.info("The imaging links button is displayed in the left menu bar");
			return true;
		} else {
			logger.info("The imaging links button is not displayed in the left menu bar");
			return false;
		}
	}

	/**
	 * This method is to check the color of the text of the imaging links button in
	 * left menu bar
	 *
	 * @throws IOException
	 */
	public Boolean checkImagingLinksButtonsColor() throws IOException {
		String color = utility.initializeElement(LoginPage.driver, "leftnavigation.imaginglinks.xpath")
				.getCssValue("color");
		if (color.contains("(0, 203, 157, 1)")) {
			logger.info("Imaging links button color is correct");
			return true;
		} else {
			logger.info("Imaging links button color is incorrect");
			return false;
		}
	}

	/**
	 * This method is to check the imaging links header
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkImagingLinksHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.page.header.txt.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Imaging links header is displayed");
			return true;
		} else {
			logger.info("Imaging links header is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the imaging links table header
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkImagingLinksTableHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.page.table.header.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Imaging links table header is displayed");
			return true;
		} else {
			logger.info("Imaging links table header is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the imaging links site table header
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkImagingLinksSiteTableHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.table.header.site.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Imaging links site table header is displayed");
			return true;
		} else {
			logger.info("Imaging links site table header is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the imaging links address table header
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkImagingLinksAddressTableHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.table.header.address.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Imaging links address table header is displayed");
			return true;
		} else {
			logger.info("Imaging links address table header is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the imaging links site table header
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkImagingLinksCityTableHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.table.header.city.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Imaging links city table header is displayed");
			return true;
		} else {
			logger.info("Imaging links city table header is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the imaging links contact table header
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkImagingLinksContactTableHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.table.header.contact.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Imaging links contact table header is displayed");
			return true;
		} else {
			logger.info("Imaging links contact table header is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the imaging links phone table header
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkImagingLinksPhoneTableHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.table.header.phone.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Imaging links phone table header is displayed");
			return true;
		} else {
			logger.info("Imaging links phone table header is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the create link button is displayed
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkCreateLinkButtonAtBottomOfTable() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.btn.createlink.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Create link button is displayed");
			return true;
		} else {
			logger.info("Create link button is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the remove link button is displayed
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkRemoveLinkButtonAtBottomOfTable() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Remove link button is displayed");
			return true;
		} else {
			logger.info("Remove link button is not displayed");
			return false;
		}
	}

	/**
	 * This method is to click the pin linked images to top button
	 *
	 * @throws IOException
	 */
	public void clickPinLinkedButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.btn.pinlinkedsites.xpath").click();
		logger.info("User clicked pin linked button");
	}

	/**
	 * This method is to check the pin linked images to top button
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkPinLinkedButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.btn.pinlinkedsites.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Pin linked button is displayed");
			return true;
		} else {
			logger.info("Pin linked button is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the site arrow in imaging links table
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkTableSiteArrow() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.table.arrow.site.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Site table arrows are displayed");
			return true;
		} else {
			logger.info("Site table arrows are not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the address arrow in imaging links table
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkTableAddressArrow() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.table.arrow.address.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Address table arrows are displayed");
			return true;
		} else {
			logger.info("Address table arrows are not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the city arrow in imaging links table
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkTableCityArrow() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.table.arrow.city.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("City table arrows are displayed");
			return true;
		} else {
			logger.info("City table arrows are not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the contact arrow in imaging links table
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkTableContactArrow() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.table.arrow.contact.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Contact table arrows are displayed");
			return true;
		} else {
			logger.info("Contact table arrows are not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the phone arrow in imaging links table
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkTablePhoneArrow() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.table.arrow.phone.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Phone table arrows are displayed");
			return true;
		} else {
			logger.info("Phone table arrows are not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the search bar in imaging links page
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkSearchBarInImagingLinksPage() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.search.bar.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Search bar is displayed in imaging links page");
			return true;
		} else {
			logger.info("Search bar is not displayed in imaging links page");
			return false;
		}
	}

	/**
	 * This method is to check the search button in imaging links page
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkSearchButtonInImagingLinksPage() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.search.btn.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Search button is displayed in imaging links page");
			return true;
		} else {
			logger.info("Search button is not displayed in imaging links page");
			return false;
		}
	}

	/**
	 * This method is to check the right side info name
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRightSideInfoName() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.info.name.txt.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Name information is displayed in imaging links page");
			return true;
		} else {
			logger.info("Name information is not displayed in imaging links page");
			return false;
		}
	}

	/**
	 * This method is to check the right side info affiliation
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRightSideInfoAffiliation() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.info.affiliation.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Affiliation information is displayed in imaging links page");
			return true;
		} else {
			logger.info("Affiliation information is not displayed in imaging links page");
			return false;
		}
	}

	/**
	 * This method is to check the right side info address
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRightSideInfoAddress() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.info.address.txt.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Address information is displayed in imaging links page");
			return true;
		} else {
			logger.info("Adrress information is not displayed in imaging links page");
			return false;
		}
	}

	/**
	 * This method is to check the right side info contact
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRightSideInfoContact() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.info.contact.txt.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Contact information is displayed in imaging links page");
			return true;
		} else {
			logger.info("Contact information is not displayed in imaging links page");
			return false;
		}
	}

	/**
	 * This method is to check the right side info contact info
	 *
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRightSideInfoContactInfo() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.info.contactinfo.txt.xpath")
				.isDisplayed();
		if (bool == true) {
			logger.info("Contact info information is displayed in imaging links page");
			return true;
		} else {
			logger.info("Contact info information is not displayed in imaging links page");
			return false;
		}
	}

	/**
	 * This method is to check the color of the first entry
	 *
	 * @return String
	 * @throws IOException
	 */
	public String checkColorOfFirstEntry() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.table.first.entry.xpath").click();
		return utility.initializeElement(LoginPage.driver, "imaginglinks.table.first.entry.xpath").getCssValue("color");
	}

	/**
	 * This method is to unlink all facilities to the selected facility in ilPage
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void unlinkAllFacilitiesHAdmin() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.table.abch.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").click();
			Thread.sleep(1000);
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.table.acmh.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").click();
			Thread.sleep(1000);
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.table.baystate.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").click();
			Thread.sleep(1000);
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.table.briarwood.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").click();
			Thread.sleep(1000);
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.table.emerson.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").click();
			Thread.sleep(1000);
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.table.liviona.xpath").click();
		if (utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").isEnabled()) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").click();
			Thread.sleep(1000);
		}
		logger.info("User unlinked all facilities");
	}

	/**
	 * This method is to link one facility for hadmin imaging links tab
	 * 
	 * @throws IOException
	 */
	public void hadminLinkOneFacility() throws IOException, InterruptedException {
		logger.info("User linked one facility");
		utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.table.acmh.xpath").click();
		Thread.sleep(1000);
		utility.initializeElement(LoginPage.driver, "imaginglinks.btn.createlink.xpath").click();
	}

	/**
	 * This method is to check the search bar on snhil manager page imaging links
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkSearchBarSNHILM() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.search.bar.div.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Search bar is displayed");
			return true;
		} else {
			logger.info("Search bar is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the search button on snhil manager page imaging links
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkSearchButtonSNHILM() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.search.bar.btn.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Search bar is displayed");
			return true;
		} else {
			logger.info("Search bar is not displayed");
			return false;
		}
	}

	/**
	 * This method is to get the top icon's color in the imaging links table for
	 * SNHILManager
	 * 
	 * @throws IOException
	 * @return String
	 **/
	public String getIconColorSNHIL() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imaginglinks.icon.snhiladmin.img.xpath")
				.getCssValue("color");
	}

	/**
	 * This method is to get the top icon's color in the imaging links table for h
	 * admin
	 * 
	 * @throws IOException
	 * @return String
	 */
	public String getIconColorHAdmin() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imaginglinks.icon.hadmin.img.xpath").getCssValue("color");
	}

	/**
	 * This method is to check that the create link button is disabled for hadmin
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkCreateLinkButtonHadmin() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.btn.createlink.xpath").isEnabled();
		if (bool == true) {
			logger.info("Create Link is disabled");
			return true;
		} else {
			logger.info("Create link is not distabled");
			return false;
		}
	}

	/**
	 * This method is to check that the create link button is disabled for hadmin
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkRemoveLinkButtonHadmin() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").isEnabled();
		if (bool == true) {
			logger.info("Remove Link is disabled");
			return true;
		} else {
			logger.info("Remove link is not distabled");
			return false;
		}
	}

	/**
	 * This method is to click the first entry in the table
	 * 
	 * @throws IOException
	 */
	public void clickFirstEntryInTableHadmin() throws IOException {
		logger.info("User clicked first entry in hadmin imaging links table");
		utility.initializeElement(LoginPage.driver, "imaginglinks.table.first.entry.xpath").click();
	}

	/**
	 * This method is used to check if search box is displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isSearchBoxDisplayed() throws IOException {
		logger.info("Search box is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.searchbox.xpath").isDisplayed());
		logger.info("Search icon is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.searchbox.icon.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.searchbox.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if search button is displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isSearchButtonDisplayed() throws IOException {
		logger.info("Search button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.btn.search.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.btn.search.xpath").isDisplayed();
	}

	/**
	 * This method is used to check table facility linking screen displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isFacilityLinkingScreenDetailsDisplayed(String header) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (header.equalsIgnoreCase("all available image center")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.title.subtitle.xpath");
		}
		if (header.equalsIgnoreCase("site")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.header.site.xpath");
		}
		if (header.equalsIgnoreCase("address")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.header.address.xpath");
		}
		if (header.equalsIgnoreCase("city state zipcode")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.header.CityStateZipcode.xpath");
		}
		if (header.equalsIgnoreCase("contact")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.header.contact.xpath");
		}
		if (header.equalsIgnoreCase("phone number")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.header.phonenumber.xpath");
		}
		if (header.equalsIgnoreCase("remove link")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.btn.removelink.xpath");
		}
		if (header.equalsIgnoreCase("create link")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.btn.createlink.xpath");
		}
		if (header.equalsIgnoreCase("search box")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.searchbox.xpath");
		}
		if (header.equalsIgnoreCase("search button")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.btn.search.xpath");
		}
		if (header.equalsIgnoreCase("toggle button")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.btn.toggle.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + header);
		return null;
	}

	/**
	 * This method is used to check if search box is displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public Boolean isRemoveLinkButtonDisplayed() throws IOException {
		logger.info("Remove Link button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.btn.remove.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.btn.remove.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if linked facilities displayed in green color or
	 * not
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String isLinkedFacilitiesDisplayedInGreenColor() throws IOException {
		logger.info("Linked facilities color is displayed as : " + utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.linked.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "facilitylinking.linked.column.xpath").getCssValue("color");
	}

	/**
	 * This method is used to check if unlinked facilities displayed in white color
	 * or not
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String isUnlinkedFacilitiesDisplayedInWhiteColor() throws IOException {
		logger.info("Unlinked facilities color is displayed as : " + utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.unlinked.xpath").getCssValue("color"));
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.unlinked.xpath").getCssValue("color");
	}

	/***
	 * This method is used to enter user value in search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterTextInSearchbox(String string) throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facilitylinking.searchbox.xpath").clear();
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "facilitylinking.searchbox.xpath").sendKeys(string);
		logger.info("The text in searchbox is entered as : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.searchbox.xpath").getAttribute("value"));
	}

	/***
	 * This method is used to enter user value in search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSearchButton() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facilitylinking.btn.search.xpath").click();
		logger.info("The Search button is clicked");
	}

	/**
	 * This method is used to check if search criteria matching list displayed or
	 * not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getSearchedMatchingList() throws IOException, InterruptedException {
		try {
			List<WebElement> List = utility.initializeElements(LoginPage.driver, "facilitylinking.table.list.xpath");
			int size = List.size();
			logger.info("Total no. of search criteria matching results : " + size);
			if (size >= 1) {
				for (WebElement newList : List) {
					logger.info("Table list as per search criteria : " + newList.getText());

				}
				return true;
			}
			Thread.sleep(1000);
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}

	/***
	 * This method is used to remove content from searchbox.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void removeContentFromSearchbox() throws IOException, InterruptedException {
		Thread.sleep(10000);
		utility.initializeElement(LoginPage.driver, "facilitylinking.searchbox.xpath").clear();
		LoginPage.driver.navigate().refresh();
		utility.initializeElement(LoginPage.driver, "facilitylinking.btn.search.xpath").click();
		logger.info("The searchbox is cleared");
	}

	/**
	 * This method is used to check if search criteria matching list displayed or
	 * not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getLinkedUnlinkedList() throws IOException, InterruptedException {
		try {
			List<WebElement> Linked = utility.initializeElements(LoginPage.driver, "facilitylinking.table.list.xpath");
			int size = Linked.size();
			List<WebElement> Unlinked = utility.initializeElements(LoginPage.driver,
					"facilitylinking.table.list.icon.xpath");
			int size1 = Unlinked.size();
			logger.info("Total no. of result : " + size);
			if (size >= 1 && size1 >= 1) {
				for (WebElement newList : Linked) {
					for (WebElement newList1 : Unlinked) {
						logger.info("Table list as per linked and unlinked facilities : "
								+ newList1.getAttribute("title") + " " + newList.getText());

					}
				}
				return true;
			}
			Thread.sleep(1000);
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}

	/**
	 * This method is used to check table list displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getImageLinkingTableList() throws IOException, InterruptedException {
		List<WebElement> List = utility.initializeElements(LoginPage.driver, "facilitylinking.table.list.xpath");
		int size = List.size();
		logger.info("Total no. records in table : " + size);
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.xpath").isDisplayed();
	}

	/**
	 * This method is used to check no data to display message displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isNoDataToDisplayMessageDisplayed() throws IOException, InterruptedException {
		logger.info("The message for invalid input search is displayed as : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.msg.nodatatodisplay.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.msg.nodatatodisplay.xpath").isDisplayed();
	}

	/***
	 * This method is used to click on unlinked image center.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectUnlinkedImageCenter() throws IOException, InterruptedException {
		// Thread.sleep(10000);
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.unlinked.xpath").click();
		logger.info("The Unlinked image center is clicked");
	}

	/**
	 * This method is used to check if image center highlighted or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isSelectedImageCenterHighlighted() throws IOException, InterruptedException {
		logger.info("The selected image center is highlighted : " + utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.row.highlighted.xpath").isEnabled());
		logger.info("The selected image center is displayed in green color as : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.row.highlighted.xpath")
						.getCssValue("border-top-color"));
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.row.highlighted.xpath").isEnabled();
	}

	/**
	 * This method is used to check table facility linking screen displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public WebElement isImagingCenterDetailsDisplayed(String detail) throws IOException, InterruptedException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		Thread.sleep(1000);
		if (detail.equalsIgnoreCase("profile")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.img.profile.xpath");
		}
		if (detail.equalsIgnoreCase("image center details")) {

			logger.info("The imaging center details text is displayed as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.imagecenterdetails.xpath").getText());
			logger.info("The imaging center details text is displayed in white color as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.imagecenterdetails.xpath")
							.getCssValue("color"));
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.imagecenterdetails.xpath");
		}
		if (detail.equalsIgnoreCase("link inactive text")) {
			logger.info("The link inactive text is displayed as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.linkinactive.xpath").getText());
			logger.info("The link inactive text is displayed in white color as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.linkinactive.xpath")
							.getCssValue("color"));
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.linkinactive.xpath");
		}
		if (detail.equalsIgnoreCase("link active text")) {
			logger.info("The link active text is displayed as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.linkactive.xpath").getText());
			logger.info("The link active text is displayed in green color as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.linkactive.xpath").getCssValue("color"));
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.linkactive.xpath");
		}
		if (detail.equalsIgnoreCase("name")) {
			logger.info("The Name text is displayed as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.name.xpath").getText());
			logger.info("The Name text is displayed in white color as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.name.xpath").getCssValue("color"));
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.name.xpath");
		}
		if (detail.equalsIgnoreCase("name of selected imaging center")) {
			logger.info("The name of selected imaging center is displayed as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.nameofselectedimagecenter.xpath")
							.getText());
			logger.info("The name of selected imaging center is displayed in white color as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.nameofselectedimagecenter.xpath")
							.getCssValue("color"));
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.nameofselectedimagecenter.xpath");
		}
		if (detail.equalsIgnoreCase("Affliation")) {
			logger.info("The Affliation text is displayed as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.affiliation.xpath").getText());
			logger.info("The Affliation text is displayed in white color as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.affiliation.xpath").getCssValue("color"));
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.affiliation.xpath");
		}
		if (detail.equalsIgnoreCase("name of selected organization")) {
			logger.info("The name of selected organization is displayed as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.nameofselectedorganization.xpath")
					.getText());
			logger.info("The name of selected organization is displayed in white color as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.nameofselectedorganization.xpath")
					.getCssValue("color"));
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.nameofselectedorganization.xpath");
		}
		if (detail.equalsIgnoreCase("address")) {
			logger.info("The address text is displayed as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.address.xpath").getText());
			logger.info("The address text is displayed in white color as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.address.xpath").getCssValue("color"));
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.address.xpath");
		}
		if (detail.equalsIgnoreCase("address of selected imaging center")) {
			logger.info("The address of selected imaging center is displayed as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.addressofselectedimagecenter.xpath")
					.getText());
			logger.info("The address of selected imaging center is displayed in white color as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.addressofselectedimagecenter.xpath")
					.getCssValue("color"));
			return utility.initializeElement(LoginPage.driver,
					"facilitylinking.txt.addressofselectedimagecenter.xpath");
		}
		if (detail.equalsIgnoreCase("site contact")) {
			logger.info("The site contact text is displayed as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.sitecontatct.xpath").getText());
			logger.info("The site contact text is displayed in white color as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.sitecontatct.xpath")
							.getCssValue("color"));
			logger.info("The site contact is displayed as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.sitecontatctname.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.sitecontatct.xpath");
		}
		if (detail.equalsIgnoreCase("contact information")) {
			logger.info("The contact information text is displayed as : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.txt.contatctinformation.xpath").getText());
			logger.info("The contact information is displayed in white color as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.contatctinformation.xpath")
							.getCssValue("color"));
			logger.info("The contact information email id is displayed as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.contatctemail.xpath").getText());
			logger.info("The contact information phone number is displayed as : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.txt.contatctphone.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.contatctinformation.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + detail);
		return null;
	}

	/***
	 * This method is used to click on unlinked image center.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectLinkedImageCenter() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.linked.xpath").click();
		logger.info("The Linked image center is clicked");
	}

	/**
	 * This method is used to check if toggle button displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isToggleButtonDisplayed() throws IOException, InterruptedException {
		logger.info("The toggle button is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.btn.toggle.xpath").isDisplayed());
		logger.info("The toggle button is enabled : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.btn.toggle.xpath").isEnabled());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.btn.toggle.xpath").isEnabled();
	}

	/***
	 * This method is used to click on toggle button.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnToggleButton() throws IOException, InterruptedException {
		// Thread.sleep(10000);
		utility.initializeElement(LoginPage.driver, "facilitylinking.label.toggle.xpath").click();
		logger.info("The toggle button is clicked");
	}

	/**
	 * This method is used to check if toggle button displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isToggleButtonDisabled() throws IOException, InterruptedException {
		Thread.sleep(1000);
		logger.info("The toggle button is enabled : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.btn.toggle.xpath").isSelected());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.row.highlighted.xpath").isSelected();
	}

	/**
	 * This method is used to check if search criteria matching list displayed or
	 * not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getLinkedList() throws IOException, InterruptedException {
		try {
			List<WebElement> Linked = utility.initializeElements(LoginPage.driver, "facilitylinking.table.list.xpath");
			int size = Linked.size();
			List<WebElement> Unlinked = utility.initializeElements(LoginPage.driver,
					"facilitylinking.table.list.icon.xpath");
			int size1 = Unlinked.size();
			logger.info("Total no. of result : " + size);
			if (size >= 1 && size1 >= 1) {
				for (WebElement newList : Linked) {
					for (WebElement newList1 : Unlinked) {
						logger.info("Table list as per linked facilities : " + newList1.getAttribute("title") + " "
								+ newList.getText());

					}
				}
				return true;
			}
			Thread.sleep(1000);
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}

	/**
	 * This method is used to click on remove link button
	 * 
	 * @throws IOException
	 */
	public void clickOnRemoveLinkButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "facilitylinking.btn.remove.xpath").click();
		logger.info("Remove link button is clicked");
	}

	/**
	 * This method is used to check if selected site displayed in white color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isSelectedSiteDisplayedInWhiteColor() throws IOException, InterruptedException {
		Thread.sleep(10000);
		logger.info("The selected site is displayed in white color as : " + utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.unlinked.xpath").getCssValue("color"));
		logger.info("The selected site is displayed with unlinked icon : " + utility
				.initializeElement(LoginPage.driver, "facilitylinking.unlinked.iconfirst.xpath").getAttribute("title"));
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.unlinked.xpath").isDisplayed();
	}

	/**
	 * This method is used to check table facility linking screen displayed or not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isImagingLinkScreenElementsDisplayed(String header) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (header.equalsIgnoreCase("all organizations")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.allorganizations.xpath");
		}
		if (header.equalsIgnoreCase("search tab")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.searchtab.xpath");
		}
		if (header.equalsIgnoreCase("search button")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.btn.search.xpath");
		}
		if (header.equalsIgnoreCase("name of facilities")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.columnname.xpath");
		}
		if (header.equalsIgnoreCase("facilities type")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.columnfacilitytype.xpath");
		}
		if (header.equalsIgnoreCase("citystate")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.columncitystate.xpath");
		}
		if (header.equalsIgnoreCase("status")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.columnstatus.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + header);
		return null;
	}

	/**
	 * This method is used to select organization from left table
	 * 
	 * @throws IOException
	 */
	public void selectFacilityTypeFromLeftTable(String string) throws IOException {

		List<WebElement> elements = utility.initializeElements(LoginPage.driver,
				"facilitylinking.table.columnfacilitytype.xpath");
		for (WebElement element : elements) {
			if (elements.size() > 0) {
				if (element.getText().contains(string)) {
					element.click();
					break;
				}
			}
		}
		logger.info("A facility type " + string + " is selected from left table");

	}

	/**
	 * This method is used to check if selected site displayed in teal color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isSelectedFacilityDisplayedInTealColor() throws IOException, InterruptedException {
		logger.info("The selected facility is displayed in teal color as : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.columnhighlighted.xpath")
						.getCssValue("border-top-color"));
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.columnhighlighted.xpath")
				.getCssValue("border-top-color");
	}

	/**
	 * This method is used to check left table facility linking screen displayed or
	 * not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isProviderDetailsDisplayed(String detail) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (detail.equalsIgnoreCase("organization name")) {
			logger.info("Organization name is : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.organizationname.xpath")
							.getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.organizationname.xpath");
		}
		if (detail.equalsIgnoreCase("address")) {
			logger.info("Address is : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.table.left.address.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.address.xpath");
		}
		if (detail.equalsIgnoreCase("admin name")) {
			logger.info("Admin name is : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.table.left.adminname.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.adminname.xpath");
		}
		if (detail.equalsIgnoreCase("admin email")) {
			logger.info("Admin email is : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.table.left.adminemail.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.adminemail.xpath");
		}
		if (detail.equalsIgnoreCase("phone number")) {
			logger.info("Phone number is : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.table.left.phonenumber.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.phonenumber.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + detail);
		return null;
	}

	/***
	 * This method is used to enter text in left table search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterTextInLeftTableSearchbar(String string, String text) throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.searchbox.xpath").clear();
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.searchbox.xpath").sendKeys(text);
		logger.info("The " + string + " text in searchbox is entered as  : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.searchbox.xpath")
						.getAttribute("value"));
	}

	/***
	 * This method is used to click on left table search button.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSearchButtonInLeftTable() throws IOException, InterruptedException {
		logger.info("Left Table Search Button is Clicked");
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.btn.search.xpath").click();
		Thread.sleep(10000);
	}

	/**
	 * This method is used to check if search criteria matching list displayed under
	 * all organization or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getSearchedListUnderAllOrganization() throws IOException, InterruptedException {
		try {
			List<WebElement> List = utility.initializeElements(LoginPage.driver,
					"facilitylinking.table.left.row.list.xpath");
			int size = List.size();
			logger.info("Total no. of search matching results : " + size);
			if (size >= 1) {
				for (WebElement newList : List) {
					logger.info("Left Table list as per searched keyword : " + newList.getText());

				}
				return true;
			}
			Thread.sleep(1000);
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}

	/***
	 * This method is used to enter text in left table search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterTextInLeftSearchbox(String string) throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.searchbox.xpath").clear();
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.searchbox.xpath").sendKeys(string);
		logger.info("The text in searchbox is entered as  : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.searchbox.xpath")
						.getAttribute("value"));
	}

	/***
	 * This method is used to clear text in left table search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clearTextFromLeftTableSearchbar() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.searchbox.xpath").clear();
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.btn.search.xpath").click();
		LoginPage.driver.navigate().refresh();
		Thread.sleep(1000);
		logger.info("The Left table search bar is cleared");
	}

	/**
	 * This method is used to check right table facility linking screen displayed or
	 * not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isRightTableDetailsDisplayed(String detail) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (detail.equalsIgnoreCase("available provider")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.availableproviders.xpath");
		}
		if (detail.equalsIgnoreCase("toggle button")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.btn.toggle.xpath");
		}
		if (detail.equalsIgnoreCase("toggle button text")) {
			logger.info("toggle button text is : "
					+ utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.pinlinked.text.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.pinlinked.text.xpath");
		}
		if (detail.equalsIgnoreCase("search tab")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.left.searchtab.xpath");
		}
		if (detail.equalsIgnoreCase("search button")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.btn.left.search.xpath");
		}
		if (detail.equalsIgnoreCase("name of hospitals")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.hospitalnames.xpath");
		}
		if (detail.equalsIgnoreCase("linked icon")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.linkedicon.xpath");
		}
		if (detail.equalsIgnoreCase("unlinked icon")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.unlinkedicon.xpath");
		}
		if (detail.equalsIgnoreCase("citystate")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.citystate.xpath");
		}
		if (detail.equalsIgnoreCase("contact number")) {
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.phonenumber.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + detail);
		return null;
	}

	/***
	 * This method is used to select facility from right table.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectFacilityFromRightTable() throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.rowfirst.xpath").click();
		logger.info("The facility from right table is selected as : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.rowfirst.xpath").getText());
	}

	/**
	 * This method is used to check if selected site displayed in teal color or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String isSelectedFacilityProviderDisplayedInTealColor() throws IOException, InterruptedException {
		logger.info("The selected facility provider is displayed in teal color as : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.rowfirst.xpath")
						.getCssValue("border-top-color"));
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.rowfirst.xpath")
				.getCssValue("border-top-color");
	}

	/**
	 * This method is used to check left table facility linking screen displayed or
	 * not
	 * 
	 * @return WebElement
	 * @throws IOException
	 */
	public WebElement isProviderDetailsFromRightTableDisplayed(String detail) throws IOException {
		LoginPage.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		if (detail.equalsIgnoreCase("organization name")) {
			logger.info("Organization name is : "
					+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.organizationname.xpath")
							.getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.organizationname.xpath");
		}
		if (detail.equalsIgnoreCase("address")) {
			logger.info("Address is : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.table.right.address.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.address.xpath");
		}
		if (detail.equalsIgnoreCase("admin name")) {
			logger.info("Admin name is : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.table.right.adminname.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.adminname.xpath");
		}
		if (detail.equalsIgnoreCase("admin email")) {
			logger.info("Admin email is : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.table.right.adminemail.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.adminemail.xpath");
		}
		if (detail.equalsIgnoreCase("phone number")) {
			logger.info("Phone number is : " + utility
					.initializeElement(LoginPage.driver, "facilitylinking.table.right.phonenumber.xpath").getText());
			return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.phonenumber.xpath");
		}
		logger.error("Unable to find the WebElement as locator is null or element name is not found " + detail);
		return null;
	}

	/***
	 * This method is used to enter text in right table search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterTextInRightTableSearchbar(String string, String text) throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.searchbox.xpath").clear();
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.searchbox.xpath").sendKeys(text);
		logger.info("The " + string + " text in searchbox is entered as  : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.searchbox.xpath")
						.getAttribute("value"));
	}

	/***
	 * This method is used to click on right table search button.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clickOnSearchButtonInRightTable() throws IOException, InterruptedException {
		logger.info("Right Table Search Button is Clicked");
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.btn.search.xpath").click();
		Thread.sleep(10000);
	}

	/**
	 * This method is used to check if search criteria matching list displayed in
	 * right table or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getSearchedListUnderAvailableProvider() throws IOException, InterruptedException {
		try {
			List<WebElement> List = utility.initializeElements(LoginPage.driver,
					"facilitylinking.table.right.row.list.xpath");
			int size = List.size();
			logger.info("Total no. of search matching results : " + size);
			if (size >= 1) {
				for (WebElement newList : List) {
					logger.info("Right Table list as per searched keyword : " + newList.getText());

				}
				return true;
			}
			Thread.sleep(1000);
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}

	/***
	 * This method is used to enter text in left table search box.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterTextInRightSearchbox(String string) throws IOException, InterruptedException {
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.searchbox.xpath").clear();
		Thread.sleep(2000);
		utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.searchbox.xpath").sendKeys(string);
		logger.info("The text in searchbox is entered as  : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.searchbox.xpath")
						.getAttribute("value"));
	}

	/**
	 * This method is used to check left table list displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getLeftTableList() throws IOException, InterruptedException {
		List<WebElement> List = utility.initializeElements(LoginPage.driver,
				"facilitylinking.table.left.row.list.xpath");
		int size = List.size();
		logger.info("Total no. records in left table : " + size);
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.row.list.xpath").isDisplayed();
	}

	/**
	 * This method is used to check left table no data to display message displayed
	 * or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isNoDataToDisplayMessageDisplayedInLeftTable() throws IOException, InterruptedException {
		logger.info("The left table message for invalid input search is displayed as : " + utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.msg.nodatatodisplay.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.msg.nodatatodisplay.xpath")
				.isDisplayed();
	}

	/**
	 * This method is used to check right table no data to display message displayed
	 * or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isNoDataToDisplayMessageDisplayedInRightTable() throws IOException, InterruptedException {
		logger.info("The right table message for invalid input search is displayed as : " + utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.msg.nodatatodisplay.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.msg.nodatatodisplay.xpath")
				.isDisplayed();
	}

	/**
	 * This method is used to check left table list displayed or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getRightTableList() throws IOException, InterruptedException {
		List<WebElement> List = utility.initializeElements(LoginPage.driver,
				"facilitylinking.table.right.row.list.xpath");
		int size = List.size();
		logger.info("Total no. records in left table : " + size);
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.row.list.xpath").isDisplayed();
	}

	/**
	 * This method is used to verify imagelinking screen header is displayed
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isHeaderTextDisplayed() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver, "imaginglinks.headertext.xpath");
		logger.info("Color : " + element.getCssValue("color"));
		logger.info("Header text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check color is green
	 * 
	 * @param element
	 * @return
	 * @throws IOException
	 */
	public boolean isGreenColor(WebElement element) throws IOException {
		Properties properties = reader.getProperty();
		String color = properties.getProperty("green.color");
		logger.info("Color : " + element.getCssValue("color"));
		return element.getCssValue("color").equals(color);
	}

	/**
	 * This method is used to check color is white
	 * 
	 * @param element
	 * @return
	 * @throws IOException
	 */
	public boolean isWhiteColor(WebElement element) throws IOException {
		Properties properties = reader.getProperty();
		String color = properties.getProperty("white.color");
		logger.info("Color : " + element.getCssValue("color"));
		return element.getCssValue("color").equals(color);
	}

	/**
	 * This method is used to check all organizations text is displayed
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isAllOrganizationsTextWhite() throws IOException {
		WebElement element = isImagingLinkScreenElementsDisplayed("all organizations");
		return isWhiteColor(element);
	}

	/**
	 * This method is used to check left table is displayed
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isLeftTableContentsDisplayed() throws IOException {
		boolean isNameDisplayed = utility.initializeElement(LoginPage.driver, "facilitylinking.table.columnname.xpath")
				.isDisplayed();
		boolean isFacilityTypeDsiplayed = utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.columnfacilitytype.xpath").isDisplayed();
		boolean isCityStateDisplayed = utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.columncitystate.xpath").isDisplayed();
		boolean isActiveStatusDisplayed = utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.columnstatus.xpath").isDisplayed();
		return isNameDisplayed && isFacilityTypeDsiplayed && isCityStateDisplayed && isActiveStatusDisplayed;
	}

	/**
	 * This method is used to check show more button of left table
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isShowMoreBtnDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imgainglinks.showmore.btn.xpath").isDisplayed();
	}

	/**
	 * This method is used to select row from left table
	 * 
	 * @param facilityType
	 * @param status
	 * @throws IOException
	 */
	public void selectFromLeftTable(String facilityType, String status) throws IOException {
		List<WebElement> rows = null;
		if (status.equalsIgnoreCase("Active")) {
			rows = utility.initializeElements(LoginPage.driver, "imaginglinks.lefttable.row.active.xpath");
		} else if (status.equalsIgnoreCase("N/A")) {
			rows = utility.initializeElements(LoginPage.driver, "imgainglinks.lefttable.row.na.xpath");
		} else {
			rows = utility.initializeElements(LoginPage.driver, "imaginglinks.lefttable.row.xpath");
		}
		String type = facilityType.split(" ")[0];
		for (Integer i = 0; i < rows.size() - 1; i++) {
			if (rows.get(i).getText().contains(type)) {
				rows.get(i).click();
				logger.info("Selected Details:");
				logger.info(rows.get(i).getText());
				break;
			}
		}
	}

	/**
	 * This method is used to check selected row is highlighted
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean selectedRowIsHighlighted() throws IOException {
		logger.info("is highlighted: " + utility
				.initializeElement(LoginPage.driver, "imaginglinks.lefttable.row.highlighted.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.row.highlighted.xpath")
				.isDisplayed();
	}

	/**
	 * This method is used to check left table detalis header text
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean leftTableProviderDetailsText() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.lefttable.details.providerdetails.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check lefttable detail name
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean leftTableDetailsName() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.lefttable.details.facilityname.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check lefttable detail address
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean leftTableDetailsAddress() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.lefttable.details.facilityaddress.text.xpath");
		WebElement element2 = utility.initializeElement(LoginPage.driver,
				"imaginglinks.lefttable.details.facilityaddress.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		logger.info(element2.getText());
		return element.isDisplayed() && element2.isDisplayed();
	}

	/**
	 * This method is used to check lefttable detail admin name
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean leftTableDetailAdminName() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.lefttable.details.adminname.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check lefttable detail email
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean leftTableDetailEmail() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.lefttable.details.email.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check lefttable detail contact number
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean leftTableDetailContactNumber() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.lefttable.details.contactnumber.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check lefttable details
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean lefttableDetailsAreDisplayed() throws IOException {
		boolean header = leftTableProviderDetailsText();
		boolean name = leftTableDetailsName();
		boolean address = leftTableDetailsAddress();
		boolean admin = leftTableDetailAdminName();
		boolean email = leftTableDetailEmail();
		boolean contact = leftTableDetailContactNumber();
		return header && name && address && admin && email && contact;

	}

	/**
	 * This method is used to check the enable/disable states of Activate Site,
	 * Deactivate Site, Create Link and Remove Link buttons
	 * 
	 * @param button
	 * @param state
	 * @return
	 * @throws IOException
	 */
	public boolean btnState(String button, boolean state) throws IOException {
		String btn = null;
		if (button.equalsIgnoreCase("Activate Site")) {
			btn = "imaginglinks.activatesite.btn.xpath";
		} else if (button.equalsIgnoreCase("Deactivate Site")) {
			btn = "imaginglinks.deactivatesite.btn.xpath";
		} else if (button.equalsIgnoreCase("Create Link")) {
			btn = "imaginglinks.createlink.btn.xpath";
		} else if (button.equalsIgnoreCase("Remove Link")) {
			btn = "imaginglinks.removelink.btn.xpath";
		}
		if (utility.initializeElement(LoginPage.driver, btn).isEnabled()) {
			logger.info(button + " is Enabled");
		} else {
			logger.info(button + " is Disabled");
		}
		return utility.initializeElement(LoginPage.driver, btn).isEnabled();
	}

	/**
	 * This method is used to check header text of right table
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isAvailableprovidersTextDisplayed() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver, "imaginglinks.allproviders.text.xpath");
		logger.info("Displayed text: " + element.getText());
		return isWhiteColor(element);
	}

	/**
	 * This method is used to check Pin linked facilities to top text
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean righttableToggleText() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.righttable.toggletext.text.xpath");
		logger.info("Displayed text: " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check Pin linked facilities to top toggle is on
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean righttableToggleBtnIsOn() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.righttable.toggle.btn.onoff.xpath");
		logger.info("toggle button Is On : " + element.getAttribute("aria-checked"));
		return element.getAttribute("aria-checked").equals("true");
	}

	/**
	 * This method is used to click Pin linked facilities to top toggle
	 * 
	 * @throws IOException
	 */
	public void clickrighttableToggleBtn() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.toggle.btn.xpath").click();
		logger.info("Toggle clicked");
	}

	/**
	 * This method is used to check right table search bar
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isRightTableSearchTabDisplayed() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.righttable.searchbar.edittext.xpath");
		return element.isDisplayed();
	}

	/**
	 * This method is used to check right table search button
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isRighttableSearchBtnDisplayed() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.searchbtn.btn.xpath");
		return element.isDisplayed();
	}

	/**
	 * This method is used to check table contents of right table
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isRightTableContentsDisplayed() throws IOException {
		boolean isNameDisplayed = utility
				.initializeElement(LoginPage.driver, "imaginglinks.righttable.columnname.xpath").isDisplayed();
		boolean islinkIConDsiplayed = utility
				.initializeElement(LoginPage.driver, "imaginglinks.righttable.linkicon.xpath").isDisplayed();
		boolean isCityStateDisplayed = utility
				.initializeElement(LoginPage.driver, "imaginglinks.righttable.columncitystate.xpath").isDisplayed();
		boolean iscontactDisplayed = utility
				.initializeElement(LoginPage.driver, "imaginglinks.table.columncontact.xpath").isDisplayed();
		return isNameDisplayed && islinkIConDsiplayed && isCityStateDisplayed && iscontactDisplayed;
	}

	/**
	 * This method is used to check show more button of right table
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isRighttableShowMoreBtnDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imgainglinks.righttable.showmore.btn.xpath").isDisplayed();
	}

	/**
	 * This method is used to select row from right table
	 * 
	 * @param state
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectFromRightTable(String state) throws IOException, InterruptedException {
		List<WebElement> rows = null;
		if (state.equalsIgnoreCase("Linked")) {
			rows = utility.initializeElements(LoginPage.driver, "imaginglinks.righttable.rows.linked.xpath");
			logger.info("Selected row : " + rows.get(0).getText());
			rows.get(0).click();
		} else {
			rows = utility.initializeElements(LoginPage.driver, "imaginglinks.righttable.rows.unlinked.xpath");
			logger.info("Selected row : " + rows.get(0).getText());
			rows.get(0).click();
		}

	}

	/**
	 * This method is used to check right table row is highlighted
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isRightTableRowHighlighted() throws IOException {
		logger.info("Highlighted row : " + utility
				.initializeElement(LoginPage.driver, "imaginglinks.righttable.rows.highlighted.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.rows.highlighted.xpath")
				.isDisplayed();
	}

	/**
	 * This method is used to check right table details header text
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean rightTableProviderDetailsText() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.righttable.details.header.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check right table details name
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean rightTableDetailsName() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.righttable.details.facilityname.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check right table details address
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean rightTableDetailsAddress() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.righttable.details.facilityaddress.text.xpath");
		WebElement element2 = utility.initializeElement(LoginPage.driver,
				"imaginglinks.righttable.details.facilityaddress2.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		logger.info(element2.getText());
		return element.isDisplayed() && element2.isDisplayed();
	}

	/**
	 * This method is used to check right table details admin name
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean rightTableDetailAdminName() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.righttable.details.adminname.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check right table details email
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean rightTableDetailEmail() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.righttable.details.email.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check right table details contact number
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean rightTableDetailContactNumber() throws IOException {
		WebElement element = utility.initializeElement(LoginPage.driver,
				"imaginglinks.righttable.details.contactnumber.text.xpath");
		logger.info("Displayed Text : " + element.getText());
		return element.isDisplayed();
	}

	/**
	 * This method is used to check link icons are displayed in right table
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean rightTableContentsLinkIconDisplayed() throws IOException {
		List<WebElement> rows = utility.initializeElements(LoginPage.driver,
				"imaginglinks.righttable.rows.linked.xpath");
		logger.info("Link icons are displayed");
		return rows.size() != 0;
	}

	/**
	 * This method is used to check unlink icons are displayed in right table
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean rightTableContentsUnlinkIconDisplayed() throws IOException {
		List<WebElement> rows = utility.initializeElements(LoginPage.driver,
				"imaginglinks.righttable.rows.unlinked.xpath");
		logger.info("Unlink icons are displayed");
		return rows.size() != 0;
	}

	/**
	 * This method is used to check Activate site and Deactivate Site buttons are
	 * displayed
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean activateSiteAndDeactivateSiteBtnsDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imaginglinks.activatesite.btn.xpath").isDisplayed()
				&& utility.initializeElement(LoginPage.driver, "imaginglinks.deactivatesite.btn.xpath").isDisplayed();
	}

	/**
	 * This method is used to click Activate Site button
	 * 
	 * @throws IOException
	 */
	public void clickActivateSite() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.activatesite.btn.xpath").click();
		logger.info("Activate site button clicked");
	}

	/**
	 * This method is used to click Deactivate Site button
	 * 
	 * @throws IOException
	 */
	public void clickDeactivateSite() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.deactivatesite.btn.xpath").click();
		logger.info("Deactivate site button clicked");
	}

	/**
	 * This method is used to get the status of selected row in left table
	 * 
	 * @param status
	 * @return
	 * @throws IOException
	 */
	public boolean selectedRowStatus(String status) throws IOException {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actaulStatus = utility
				.initializeElement(LoginPage.driver, "imaginglinks.lefttable.highlightedrow.status.xpath").getText();
		logger.info("Status : " + actaulStatus);

		return actaulStatus.equals(status);
	}

	/**
	 * This method is to click the remove link button at the bottom of the table
	 * hadmin/icadmin
	 *
	 * @throws IOException
	 */
	public void clickRemoveLinkButton() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.btn.removelink.xpath").click();
		logger.info("User clicked remove link button");
	}

	/**
	 * This method is to link the top entry in the right table
	 *
	 * @throws IOException
	 */
	public void linkTopFacilityRightTable() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath(
				"/html/body/app-root/app-managefacilities/div/div[2]/div[2]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			row.click();
			break;
		}
		utility.initializeElement(LoginPage.driver, "imaginglinks.createlink.btn.xpath").click();
	}

	/**
	 * This method is to get the color of the first entry icon
	 *
	 * @throws IOException
	 * @return String
	 */
	public String getFirstEntryIconColor() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath(
				"/html/body/app-root/app-managefacilities/div/div[2]/div[2]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			row.click();
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				String color = col.getCssValue("color");
				return color;
			}
		}
		return "could not get color";
	}

	/**
	 * This method is to select an inactive facilty from the left table
	 *
	 * @throws IOException
	 */
	public void clickInactiveFacilityInLeftTable() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath(
				"/html/body/app-root/app-managefacilities/div/div[2]/div[1]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				String text = col.getText();
				if (text.contains("Inactive")) {
					row.click();
					break;
				}
			}
		}
	}

	/**
	 * This method is to unlink the top entry in the right side table
	 *
	 * @throws IOException
	 */
	public String unlinkTopEntryRightTable() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.right.firstentry.xpath").click();
		utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").click();
		logger.info("Unlinked top site from right side of the table");
		String unlinkedSite = utility.initializeElement(LoginPage.driver, "imaginglinks.right.firstentry.xpath")
				.getText();
		String newStr = "";
		for (int i = 0; i < unlinkedSite.length(); i++) {
			if (unlinkedSite.charAt(i) == ' ') {
				return newStr;
			}
			newStr += unlinkedSite.charAt(i);
		}
		return newStr;
	}

	/**
	 * This method is to check if the remove link button id displayed under right
	 * table
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkRemoveLinkButtonRightTable() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.btn.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Remove link button is displayed");
			return true;
		} else {
			logger.info("Remove link button is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check if the create link button id displayed under right
	 * table
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkCreateLinkButtonRightTable() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.createlink.btn.xpath").isDisplayed();
		if (bool == true) {
			logger.info("Create link button is displayed");
			return true;
		} else {
			logger.info("Create link button is not displayed");
			return false;
		}
	}

	/**
	 * This method is to check the left table for organizations
	 *
	 * @throws IOException
	 */
	public void checkLeftTableOrganizations() throws IOException {
		WebElement simpletable = LoginPage.driver.findElement(By.xpath(
				"/html/body/app-root/app-managefacilities/div/div[2]/div[1]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = simpletable.findElements(By.tagName("tr"));
		logger.info("Organizations in the left table are being printed below: ");
		for (WebElement row : rows) {
			row.click();
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				logger.info(col.getText());
				break;
			}
		}
	}

	/**
	 * This method is to select an active facilty from the left table
	 *
	 * @throws IOException
	 */
	public void clickActiveFacilityInLeftTable() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath(
				"/html/body/app-root/app-managefacilities/div/div[2]/div[1]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Boolean isActiveSite = false;
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				String text = col.getText();
				if (text.equals("Active")) {
					row.click();
					isActiveSite = true;
					break;
				}
			}
			if (isActiveSite == true) {
				break;
			}
		}
		if (isActiveSite == false) {
			utility.initializeElement(LoginPage.driver, "imaginglinks.activatesite.btn.xpath").click();
		}
	}

	/**
	 * This method is to check the activate site button
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkActivateSiteButtonUnderLeftTable() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.activatesite.btn.xpath").isEnabled();
		if (bool == true) {
			logger.info("Activate site button is enabled");
			return true;
		} else {
			logger.info("Activate site button is disabled");
			return false;
		}
	}

	/**
	 * This method is to check the deactivate site button
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkDeactivateSiteButtonUnderLeftTable() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.deactivatesite.btn.xpath").isEnabled();
		if (bool == true) {
			logger.info("Deactivate site button is enabled");
			return true;
		} else {
			logger.info("Deactivate site button is disabled");
			return false;
		}
	}

	/**
	 * This method is to click the deactivate site button
	 *
	 * @throws IOException
	 */
	public void clickDeactivateSiteButtonUnderLeftTable() throws IOException {
		logger.info("User clicked deactivate site button under left table");
		utility.initializeElement(LoginPage.driver, "imaginglinks.deactivatesite.btn.xpath").click();
	}

	/**
	 * This method is to return the status of Canton Health Center in the left table
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String getCantonHealthCenterStatus() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath(
				"/html/body/app-root/app-managefacilities/div/div[2]/div[1]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			String rowText = row.getText();
			if (rowText.contains("Canton")) {
				for (WebElement col : cols) {
					String text = col.getText();
					if (text.equals("Active")) {
						return "Active";
					} else if (text.equals("Inactive")) {
						return "Inactive";
					} else {
						return "N/A";
					}
				}
			}
		}
		return "unable to find canton health center status";
	}

	
public boolean isLinkedRecordsDisplayed() throws IOException, InterruptedException
	{
		logger.info("Linked Image Centers are displayed or not : " + utility.initializeElement(LoginPage.driver, "facilitylinking.linked.list.xpath").isDisplayed());
		Thread.sleep(1000);
		
		List<WebElement> order = utility.initializeElements(LoginPage.driver, "facilitylinking.linked.list.xpath");
		int size = order.size();
		logger.info("Total no. of Linked Image Centers in Imaging Links page : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("Linked Image Centers are : " + order.get(i).getText() + "\n");
				}
			}
			return true;
		}
		return false;
	}


public boolean isRecordsDisplayed() throws IOException, InterruptedException {
		logger.info("Dashboard details is displayed in chronological order : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.list.xpath").isDisplayed());
		Thread.sleep(1000);
		List<WebElement> order = utility.initializeElements(LoginPage.driver, "facilitylinking.table.list.xpath");
		int size = order.size();
		logger.info("Total no. of records in Upload Dashboard page : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("Records dispalyed as : " + order.get(i).getText() + "\n");
				}
			}
			return true;
		}
		return false;
	}

public boolean isUnLinkedRecordsDisplayed() throws IOException, InterruptedException
	{
		logger.info("Unlinked Image Centers are displayed or not : " + utility.initializeElement(LoginPage.driver, "facilitylinking.unlinked.list.xpath").isDisplayed());
		Thread.sleep(1000);
		
		List<WebElement> order = utility.initializeElements(LoginPage.driver, "facilitylinking.unlinked.list.xpath");
		int size = order.size();
		logger.info("Total no. of Unlinked Image Centers in Imaging Links page : " + size);
		if (size >= 1) {
			for (int i = 0; i < size; i++) {
				{
					System.out.println("Un-Linked Image Centers are : " + order.get(i).getText() + "\n");
				}
			}
			return true;
		}
		return false;
	}


	/**
	 * This method is to check if the canton health center is displayed in the left
	 * table
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkCantonHealthCenterInLeftTable() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath(
				"/html/body/app-root/app-managefacilities/div/div[2]/div[1]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			String rowText = row.getText();
			if (rowText.contains("Canton")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is used to check if linked imaging center list displayed in right
	 * table or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getLinkedImagingCenter() throws IOException, InterruptedException {
		try {
			List<WebElement> List = utility.initializeElements(LoginPage.driver,
					"facilitylinking.table.right.row.linked.xpath");
			int size = List.size();
			logger.info("Total no. of linked imaging centers : " + size);
			if (size > 0) {
				for (WebElement newList : List) {
					logger.info("Linked Hospital and Imaging centers are  : " + newList.getText());

				}
				return true;
			}
			Thread.sleep(1000);
			return false;
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			return true;
		}
	}	
	
	
	public static String name;
	public static String addressLine1;
	public static String addressLine2;
	public static String adminName;
	public static String adminemail;
	public static String adminPhoneNumber;
	public String rightTableName = "right";
	public String leftTableName = "left";
	
	
	/**
	 * This method is used to get the table details
	 * @param tableName
	 * @throws IOException
	 */
	public void getTableDetails(String tableName) throws IOException {
		if(tableName.equalsIgnoreCase(leftTableName)){
			name = utility.initializeElement(LoginPage.driver,"imaginglinks.lefttable.details.facilityname.text.xpath").getText();
			addressLine1 = utility.initializeElement(LoginPage.driver,"imaginglinks.lefttable.details.facilityaddress.text.xpath").getText();
			addressLine2 = utility.initializeElement(LoginPage.driver,"imaginglinks.lefttable.details.facilityaddress2.text.xpath").getText();
			adminName = utility.initializeElement(LoginPage.driver,"imaginglinks.lefttable.details.adminname.text.xpath").getText();
			adminemail = utility.initializeElement(LoginPage.driver,"imaginglinks.lefttable.details.email.text.xpath").getText();
			adminPhoneNumber = utility.initializeElement(LoginPage.driver,"imaginglinks.lefttable.details.contactnumber.text.xpath").getText();
		}else {
			name = utility.initializeElement(LoginPage.driver,"imaginglinks.righttable.details.facilityname.text.xpath").getText();
			addressLine1 = utility.initializeElement(LoginPage.driver,"imaginglinks.righttable.details.facilityaddress.text.xpath").getText();
			addressLine2 = utility.initializeElement(LoginPage.driver,"imaginglinks.righttable.details.facilityaddress2.text.xpath").getText();
			adminName = utility.initializeElement(LoginPage.driver,"imaginglinks.righttable.details.adminname.text.xpath").getText();
			adminemail = utility.initializeElement(LoginPage.driver,"imaginglinks.righttable.details.email.text.xpath").getText();
			adminPhoneNumber = utility.initializeElement(LoginPage.driver,"imaginglinks.righttable.details.contactnumber.text.xpath").getText();
		}
	}
	
	/**
	 * This method is used to locate the left search bar
	 * @return
	 * @throws IOException
	 */
	public WebElement locateLeftSearchbar() throws IOException {
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.searchbox.xpath");
	}
	
	/**
	 * This method is used to locate the right search bar
	 * @return
	 * @throws IOException
	 */
	public WebElement locateRightSearchbar() throws IOException {
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.searchbox.xpath");
	}	
	
	/**
	 * This method is used to enter text in search bar
	 * @param tableName
	 * @param textType
	 * @param caseType
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterTextInSearchBar(String tableName,String textType, String caseType) throws IOException, InterruptedException {
		String textToSearch = null;
		WebElement searchbar =  (tableName.equalsIgnoreCase(leftTableName)) ?locateLeftSearchbar() : locateRightSearchbar();
		searchbar.clear();
		Thread.sleep(2000);
		if(textType.equals("name")){
			textToSearch = name.split(" ")[0];
		}
		else if(textType.equals("address")){
			textToSearch = addressLine1.split(" ")[1];
		}
		else if(textType.equals("zipcode")){
			textToSearch = addressLine2.split(" ")[addressLine2.split(" ").length-1];
		}
		else if(textType.equals("city")){
			textToSearch = addressLine2.split(" ")[0];
		}
		else if(textType.equals("admin first name")){
			textToSearch = adminName.split(" ")[0];
		}
		else if(textType.equals("admin last name")){
			textToSearch = ((adminName.split(" ").length)>1) 
								? adminName.split(" ")[1] 
								: adminName.split(" ")[0];
			
		}
		else if(textType.equals("admin phone number")){
			textToSearch = adminPhoneNumber;
		}
		else if(textType.equals("admin email")){
			textToSearch = adminemail;
		}
		textToSearch = textToSearch.replace(",", "");
//		logger.info("textToSearch**********"+textToSearch);
		switch(caseType) {
		case "lower case":
			searchbar.sendKeys(textToSearch.toLowerCase());
			break;
		case "upper case":
			searchbar.sendKeys(textToSearch.toUpperCase());
			break;
		case "upper case and lower case":
			searchbar.sendKeys(textToSearch);
			break;
		}
		logger.info("The  text in searchbox is entered as  : "+ searchbar.getAttribute("value"));
		
		if(tableName.equalsIgnoreCase(leftTableName)){
			clickOnSearchButtonInLeftTable();
		}else {
			clickOnSearchButtonInRightTable();
		}
	
	}
	
	/**
	 * This method is used to check the search functionality is working
	 * @param tableName
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isSearchWorking(String tableName) throws IOException, InterruptedException {
		boolean flag = false;
		String searchedText =  (tableName.equalsIgnoreCase(leftTableName)) 
				?locateLeftSearchbar().getAttribute("value") 
				:locateRightSearchbar().getAttribute("value");
		List<WebElement> searchResultRows = (tableName.equalsIgnoreCase(leftTableName)) 
				?utility.initializeElements(LoginPage.driver,"imaginglinks.lefttable.allrows.xpath")
				:utility.initializeElements(LoginPage.driver,"imaginglinks.righttable.allrows.xpath");
		String tableDetails = null;
		for(WebElement row : searchResultRows) {
			row.click();
			Thread.sleep(500);
			tableDetails = (tableName.equalsIgnoreCase(leftTableName)) 
					?utility.initializeElement(LoginPage.driver,"imaginglinks.lefttable.details.all.xpath").getText()
					:utility.initializeElement(LoginPage.driver,"imaginglinks.righttable.details.all.xpath").getText();
			logger.info("Searched row details************");
			logger.info(tableDetails);
			logger.info("************");
			flag = Pattern.compile(Pattern.quote(searchedText), Pattern.CASE_INSENSITIVE).matcher(tableDetails).find();
			if(flag){
				continue;
			}else {
				break;
			}
		}
		if(flag) {
			logger.info("Search is working as expected");
		}else {
			logger.info("Search is  not working as expected");
			}
		Thread.sleep(1000);
		return flag;
	}
	
	
	/**
	 * This method is used to clear the contents of search bar
	 * @param tableName
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void clearSearchbar(String tableName) throws IOException, InterruptedException {
		if(tableName.equalsIgnoreCase(leftTableName)){
			locateLeftSearchbar().clear();
			clickOnSearchButtonInLeftTable();
			clickOnSearchButtonInLeftTable();
		}else {
			locateRightSearchbar().clear();
			clickOnSearchButtonInRightTable();
			clickOnSearchButtonInRightTable();
		}
		logger.info("Search bar is cleared");
	}
	
	/**
	 * This method is used to check 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean isListOfFacilitiesInRightTableDisplayed() throws IOException, InterruptedException {
		List<WebElement> allRows = utility.initializeElements(LoginPage.driver,"imaginglinks.lefttable.allrows.xpath");
		String leftTableDetails = null;
		for(WebElement row : allRows) {
			leftTableDetails = row.getText();
			logger.info("************");
			logger.info(leftTableDetails);
			logger.info("************");
		}
		return true;
	}
	
	
	/**
	 * This method is to click the create link button on hadmin page
	 *
	 * @throws IOException
	 */
	public void clickCreateLinkButtonHadmin() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.createlink.btn.xpath").click();
		logger.info("User has clicked create link button on hadmin imaging links page");
	}
	
	/**
	 * This method is to click the create link button under the right table
	 *
	 * @throws IOException
	 */
	public void clickCreateLinkButtonUnderRightTable() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.createlink.righttable.btn.xpath").click();
		logger.info("User clicked create link button under right table");
	}

	/**
	 * This method is to click the remove link button under the right table
	 *
	 * @throws IOException
	 */
	public void clickRemoveLinkButtonUnderRightTable() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.removelink.righttable.btn.xpath").click();
		logger.info("User clicked remove link button under right table");
	}

	/**
	 * This method is to click the remove link button on hadmin page
	 *
	 * @throws IOException
	 */
	public void clickRemoveLinkButtonHadmin() throws IOException {
		utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.removelink.btn.xpath").click();
		logger.info("User has clicked remove link button on hadmin imaging links page");
	}
	
	/**
	 * This method is to check the hadmin pin linked button
	 *
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkPinLinkedHadmin() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.pinlinked.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Pin linked button is displayed");
			return true;
		} else {
			logger.info("Pin linked button is not displayed");
			return false;
		}
	}

	/**
	 * This method is used to check if unlinked imaging center list displayed in
	 * right table or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getUnlinkedImagingCenter() throws IOException, InterruptedException {
		List<WebElement> List = utility.initializeElements(LoginPage.driver,
				"facilitylinking.table.right.row.unlinked.xpath");
		int size = List.size();
		logger.info("Total no. of unlinked imaging centers : " + size);
		if (size > 0) {
			for (WebElement newList : List) {
				logger.info("Unlinked Hospital and Imaging centers are  : " + newList.getText());

			}
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check if available imaging or provider text displayed
	 * or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isAvailableProviderHeaderDisplayed() throws IOException, InterruptedException {
		logger.info("The available imaging or provider text is displayed as : " + utility
				.initializeElement(LoginPage.driver, "facilitylinking.txt.availableproviders.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.txt.availableproviders.xpath")
				.isDisplayed();
	}

	/**
	 * This method is used to check if left table with search button displayed or
	 * not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isLeftTableDisplayedWithSearchButton() throws IOException, InterruptedException {
		logger.info("The Left table is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.xpath").isDisplayed());
		logger.info("The Left table search button is displayed : " + utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.left.btn.search.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.left.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if right table with search button displayed or
	 * not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean isRightTableDisplayedWithSearchButton() throws IOException, InterruptedException {
		logger.info("The Right table is displayed : "
				+ utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.xpath").isDisplayed());
		logger.info("The Right table search button is displayed : " + utility
				.initializeElement(LoginPage.driver, "facilitylinking.table.right.btn.search.xpath").isDisplayed());
		return utility.initializeElement(LoginPage.driver, "facilitylinking.table.right.xpath").isDisplayed();
	}

	/**
	 * This method is used to check if linked unlinked hospital list displayed in
	 * right table or not
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean getHospitalList() throws IOException, InterruptedException {
		List<WebElement> linked = utility.initializeElements(LoginPage.driver,
				"facilitylinking.table.right.row.linked.xpath");
		List<WebElement> unlinked = utility.initializeElements(LoginPage.driver,
				"facilitylinking.table.right.row.unlinked.xpath");
		int linkedSize = linked.size();
		logger.info("Total no. of linked hospitals : " + linkedSize);
		int unlinkedSize = unlinked.size();
		logger.info("Total no. of unlinked hospitals : " + unlinkedSize);
		if (linkedSize > 0) {
			for (WebElement linkedList : linked) {
				logger.info("List of Linked Hospitals are  : " + linkedList.getText());
			}
			return true;
		}
		if (unlinkedSize > 0) {
			for (WebElement unlinkedList : unlinked) {
				logger.info("List of Unlinked Hospitals are  : " + unlinkedList.getText());
			}
		}
		return false;
	}
     
	/**
	 * This method is to navigate to the upload files page
	 *
	 * @throws IOException
	 */
	public void navigateToUploadFilesPage() throws IOException {
		utility.initializeElement(LoginPage.driver, "leftnavigation.uploadfiles.xpath").click();
		logger.info("User has navigated to upload files page");
	}
	
	/**
	 * This method is to select the canton health center is displayed in the left table
	 *
	 * @throws IOException
	 */
	public void selectCantonHealthCenterInLeftTable() throws IOException {
	   WebElement table = LoginPage.driver.findElement(By.xpath("/html/body/app-root/app-managefacilities/div/div[2]/div[1]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
	   List<WebElement> rows = table.findElements(By.tagName("tr"));
	   for(WebElement row: rows) {
	      String rowText = row.getText();
	      if(rowText.contains("Canton")) {
	    	row.click();
	      }
	   }
	}
	
	/**
	 * This method is to click the upload files page
	 *
	 * @throws IOException
	 */
	public void clickUploadFilesSelection() throws IOException {
	  logger.info("User clicks upload files page");
	  utility.initializeElement(LoginPage.driver, "leftnavigation.uploadfiles.xpath").click();
	}
	
	/**
	 * This method is to click the create link button
	 * 
	 * @throws IOException
	 */
	public void clickCreateLinkButton() throws IOException {
		logger.info("User clicks create link button");
		utility.initializeElement(LoginPage.driver, "imaginglinks.btn.createlink.xpath").click();
	}
	
	/**
	 * This method is to click the fourth entry in the right side table
	 * 
	 * @throws IOException
	 */
	public void clickFourthEntryRightTable() throws IOException {
		logger.info("User clicks fourth entry in right side table");
		utility.initializeElement(LoginPage.driver, "imaginglinks.table.fourthentry.xpath").click();
	}
	
	/**
	 * This method is to enter string into search bar
	 * 
	 * @throws IOException
	 */
	public void enterStringIntoSearchBar(String name) throws IOException {
		logger.info("User enters: " + name + " into search bar");
		utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.search.txt.xpath").sendKeys(name);
	}
	
	/**
	 * This method is to click an inactive facility hospital admin table
	 * 
	 * @throws IOException
	 */
	public void clickInactiveFacilityHospitalAdmin() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath("/html/body/app-root/app-facilitylinking/div/div[2]/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		outer:
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				String text = col.getText();
				if (!text.isEmpty()) {
					row.click();
					String statusText = utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.status.rightinfo.txt.xpath").getText();
					if(statusText.equalsIgnoreCase("Link Inactive")) {
						break outer;
					}
				}
			}
		}
	}
	
	/**
	 * This method is to click an active facility hospital admin table
	 * 
	 * @throws IOException
	 */
	public void clickActiveFacilityHospitalAdmin() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath("/html/body/app-root/app-facilitylinking/div/div[2]/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		outer:
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				String text = col.getText();
				if (!text.isEmpty()) {
					row.click();
					String statusText = utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.status.rightinfo.txt.xpath").getText();
					if(statusText.contains("Link Active")) {
						break outer;
					}
				}
			}
		}
	}
	
	/**
	 * This method is to check that the create link button is disabled for hadmin
	 * 
	 * @throws IOException
	 * @return Boolean
	 */
	public Boolean checkCreateLinkButtonDisabledHadmin() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "imaginglinks.btn.createlink.xpath").isEnabled();
		if (bool == true) {
			logger.info("Create Link is Enabled");
			return true;
		} else {
			logger.info("Create link is Disabled");
			return false;
		}
	}
	
	/**
	 * This method is to check if the active facilities are pinned to the top
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkIfFacilityOrderIsPinned() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath("/html/body/app-root/app-managefacilities/div/div[2]/div[2]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Boolean isActive = true;
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				String text = col.getText();
				if (!text.isEmpty()) {
					row.click();
					String statusText = utility.initializeElement(LoginPage.driver, "imaginglinks.hadmin.status.rightinfo.txt.xpath").getText();
					if(statusText.contains("Link Active")) {
						isActive = true;
					}
					if(statusText.contains("Link Inactive")) {
						isActive = false;
					}
					if(isActive == false) {
						if(statusText.contains("Link Active")) {
							return false;
						}
					}
				}
			}
			return true;
		}
		return true;
	}
	
	/**
	 * This method is to check the right table pin linked button
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkPinLinkedRightTable() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imaginglinks.pinlinked.btx.xpath").isDisplayed();
	}
	
	/**
	 * This method is to click the right table pin linked button
	 * 
	 * @throws IOException
	 */
	public void clickPinLinkedButtonRightTable() throws IOException {
		logger.info("User clicks pin linked button above right table");
		utility.initializeElement(LoginPage.driver, "imaginglinks.pinlinked.btx.xpath").click();
	}
	
	
	/**
	 * This method is to check if the active facilities are pinned to the top
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkIfFacilityOrderIsPinnedRightTable() throws IOException {
		WebElement table = LoginPage.driver.findElement(By.xpath("/html/body/app-root/app-managefacilities/div/div[2]/div[2]/div/div[1]/cdk-virtual-scroll-viewport/div[1]/table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Boolean isActive = true;
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				String text = col.getText();
				row.click();
				if (!text.isEmpty()) {
					String statusText = utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.info.status.txt.xpath").getText();
					if(statusText.contains("Linked")) {
						isActive = true;
					}
					if(statusText.contains("Unlinked")) {
						isActive = false;
					}
					if(isActive == false) {
						if(statusText.contains("Linked")) {
							return false;
						}
					}
				}
			}
			return true;
		}
		return true;
	}
	
	/**
	 * This method is used to check provider details is displayed for Ic admin
	 * @throws IOException
	 */
	public boolean isProviderDetailsDisplayed() throws IOException {
		logger.info(utility.initializeElement(LoginPage.driver, "imaginglinks.icadmin.providerDetails.xpath").getText());
		return utility.initializeElement(LoginPage.driver, "imaginglinks.icadmin.providerDetails.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check left table is displayed
	 * @return
	 * @throws IOException
	 */
	public boolean isLeftTableDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.xpath").isDisplayed();
	}
	
	
	/**
	 * This method is used to check right table is displayed
	 * @return
	 * @throws IOException
	 */
	public boolean isRightTableDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check the list of all registered organizations is shown in left table
	 * @return
	 * @throws IOException 
	 */
	public boolean isListOfOrganizationsDisplayed() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.allrows.xpath").isDisplayed();
	}
	
	/**
	 * This method is used to check left table details is displayed for HIL manager user
	 * @return
	 * @throws IOException
	 */
	public boolean isProviderDatailsShownForHilManager() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imaginglinks.lefttable.details.all.xpath").isDisplayed();
	}
	

	/**
	 * This method is used to check right details is displayed for HIL manager user
	 * @return
	 * @throws IOException
	 */
	public boolean isFacilityDatailsShownForHilManager() throws IOException {
		return utility.initializeElement(LoginPage.driver, "imaginglinks.righttable.details.all.xpath").isDisplayed();
	}
}
