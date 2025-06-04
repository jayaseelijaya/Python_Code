package pages;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PropertiesFileReader;
import utility.Utility;

public class HILPatientViewerPage {

	public static WebDriver driver;
	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(HILPatientViewerPage.class);
	Utility utility = new Utility();
	
	
	/**
	 * This method is to check if SN img in the top left of screen
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkLogo() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.sn.img.xpath").isDisplayed();
		if(bool == true) {
			logger.info("The SN Logo is displayed");
			return true;
		} else {
			logger.info("SN Logo is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the case ID text is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkCaseIDText() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.caseid.txt.xpath").isDisplayed();
		if(bool == true) {
			logger.info("The Case ID Text is displayed");
			return true;
		} else {
			logger.info("Case ID Text not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the four view mode button is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkFourViewModeButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.four.view.mode.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("The Four View Mode Button is displayed");
			return true;
		} else {
			logger.info("Four View Mode button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the single view mode button is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkSingleViewModeButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.single.view.mode.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("The Single View Mode Button is displayed");
			return true;
		} else {
			logger.info("Four Single Mode button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the two view mode button is displayed
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean checkTwoViewModeButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.two.view.mode.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("The Two View Mode Button is displayed");
			return true;
		} else {
			logger.info("Four Two Mode button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the reset views button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkResetViewsButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.resetviews.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Reset views button is displayed");
			return true;
		} else {
			logger.info("Reset views button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the slices scroller is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkSlicesScroll() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.slicescroller.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Slices scroller is displayed");
			return true;
		} else {
			logger.info("Slices scroller is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the color menu is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkColorMenu() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.colormenu.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Color Menu is displayed");
			return true;
		} else {
			logger.info("Color Menu is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the Transparency header is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkTransparencyHeader() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.transparency.header.txt.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Transparency header is displayed");
			return true;
		} else {
			logger.info("Transparency header is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the transparency slider is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkTransparencySlider() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.transparency.slider.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Transparency slider is displayed");
			return true;
		} else {
			logger.info("Transparency slider is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the reset transparency button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkResetTransparencyButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.resettransparency.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Reset transparency button is displayed");
			return true;
		} else {
			logger.info("Reset transparency button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the brightness contrast button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkBrightnessContrastButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.brightnesscontrast.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Brightness Contrast button is displayed");
			return true;
		} else {
			logger.info("Brightness Contrast button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the lass button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkLassoButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.lasso.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Lasso button is displayed");
			return true;
		} else {
			logger.info("Lasso button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the brush button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkBrushButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.brush.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Brush button is displayed");
			return true;
		} else {
			logger.info("Brush button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the eraser button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkEraserButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.eraser.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Eraser button is displayed");
			return true;
		} else {
			logger.info("Eraser button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the view changes button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkViewChangesButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.viewchanges.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("View Changes button is displayed");
			return true;
		} else {
			logger.info("View Changes button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the undo button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkUndoButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.undo.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Undo button is displayed");
			return true;
		} else {
			logger.info("Undo button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the redo button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkRedoButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.redo.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Redo button is displayed");
			return true;
		} else {
			logger.info("Redo button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the reset changes button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkResetChangesButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.resetchanges.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Reset Changes button is displayed");
			return true;
		} else {
			logger.info("Reset Changes button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the approve button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkApproveButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.approve.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Approve button is displayed");
			return true;
		} else {
			logger.info("Approve button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the save button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkSaveButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.save.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Save button is displayed");
			return true;
		} else {
			logger.info("Save button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the reject button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkRejectButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.reject.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Reject button is displayed");
			return true;
		} else {
			logger.info("Reject button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the download log button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkDownloadLogButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.downloadlog.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Download log button is displayed");
			return true;
		} else {
			logger.info("Download log button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the exit button is Displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkExitButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.exit.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Exit button is displayed");
			return true;
		} else {
			logger.info("Exit button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the first dicom container is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkFirstContiner() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.firstdicomcontainer.xpath").isDisplayed();
		if(bool == true) {
			logger.info("First Dicom Container is displayed");
			return true;
		} else {
			logger.info("First dicom container is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the second dicom container is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkSecondContiner() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.seconddicomcontainer.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Second Dicom Container is displayed");
			return true;
		} else {
			logger.info("Second dicom container is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the third dicom container is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkThirdContiner() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.thirddicomcontainer.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Third Dicom Container is displayed");
			return true;
		} else {
			logger.info("Third dicom container is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the fourth dicom container is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkFourthContiner() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.fourthdicomcontainer.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Fourth Dicom Container is displayed");
			return true;
		} else {
			logger.info("Fourth dicom container is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the first dicom container fullsize button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkFirstContinerFullsizeButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.first.fullsize.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("First Dicom Container Fullsize Button is displayed");
			return true;
		} else {
			logger.info("First Dicom Container Fullsize Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the second dicom container fullsize button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkSecondContinerFullsizeButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.second.fullsize.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Second Dicom Container Fullsize Button is displayed");
			return true;
		} else {
			logger.info("Second Dicom Container Fullsize Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the third dicom container fullsize button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkThirdContinerFullsizeButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.third.fullsize.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Third Dicom Container Fullsize Button is displayed");
			return true;
		} else {
			logger.info("Third Dicom Container Fullsize Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the fourth dicom container fullsize button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkFourthContinerFullsizeButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.fourth.fullsize.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Fourth Dicom Container Fullsize Button is displayed");
			return true;
		} else {
			logger.info("Fourth Dicom Container Fullsize Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the first dicom container pan button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkFirstContinerPanButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.first.pan.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("First Dicom Container Pan Button is displayed");
			return true;
		} else {
			logger.info("First Dicom Container Pan Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the second dicom container pan button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkSecondContinerPanButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.second.pan.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Second Dicom Container Pan Button is displayed");
			return true;
		} else {
			logger.info("Second Dicom Container Pan Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the third dicom container pan button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkThirdContinerPanButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.third.pan.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Third Dicom Container Pan Button is displayed");
			return true;
		} else {
			logger.info("Third Dicom Container Pan Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the fourth dicom container pan button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkFourthContinerPanButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.fourth.pan.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Fourth Dicom Container Pan Button is displayed");
			return true;
		} else {
			logger.info("Fourth Dicom Container Pan Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the first dicom container zoom button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkFirstContinerZoomButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.first.zoom.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("First Dicom Container Zoom Button is displayed");
			return true;
		} else {
			logger.info("First Dicom Container Zoom Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the second dicom container zoom button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkSecondContinerZoomButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.second.zoom.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Second Dicom Container Zoom Button is displayed");
			return true;
		} else {
			logger.info("Second Dicom Container Zoom Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the third dicom container zoom button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkThirdContinerZoomButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.third.zoom.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Third Dicom Container Zoom Button is displayed");
			return true;
		} else {
			logger.info("Third Dicom Container Zoom Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the fourth dicom container zoom button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkFourthContinerZoomButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.fourth.zoom.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Fourth Dicom Container Zoom Button is displayed");
			return true;
		} else {
			logger.info("Fourth Dicom Container Zoom Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the second dicom container rotate button is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkSecondContinerRotateButton() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.second.rotate.btn.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Second Dicom Container Rotate Button is displayed");
			return true;
		} else {
			logger.info("Second Dicom Container Rotate Button is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the first dicom container view selection menu is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkFirstContinerViewSelectionMenu() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.first.viewselection.menu.xpath").isDisplayed();
		if(bool == true) {
			logger.info("First Dicom Container View Selection Menu Button is displayed");
			return true;
		} else {
			logger.info("First Dicom Container View Selection Menu is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the second dicom container view selection menu is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkSecondContinerViewSelectionMenu() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.second.viewselection.menu.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Second Dicom Container View Selection Menu Button is displayed");
			return true;
		} else {
			logger.info("Second Dicom Container View Selection Menu is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the third dicom container view selection menu is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkThirdContinerViewSelectionMenu() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.third.viewselection.menu.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Third Dicom Container View Selection Menu Button is displayed");
			return true;
		} else {
			logger.info("Third Dicom Container View Selection Menu is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to check if the fourth dicom container view selection menu is displayed
	 * 
	 * @throws IOException
	 * @returns Boolean
	 */
	public Boolean checkFourthContinerViewSelectionMenu() throws IOException {
		Boolean bool = utility.initializeElement(LoginPage.driver, "patientviewer.fourth.viewselection.menu.xpath").isDisplayed();
		if(bool == true) {
			logger.info("Fourth Dicom Container View Selection Menu Button is displayed");
			return true;
		} else {
			logger.info("Fourth Dicom Container View Selection Menu is not displayed");
			return false;
		}
	}
	
	/**
	 * This method is to click the patient viewer four view mode button
	 * 
	 * @throws IOException
	 */
	public void clickFourViewModeButton() throws IOException {
		logger.info("User clicked four viewer mode button");
		utility.initializeElement(LoginPage.driver, "patientviewer.four.view.mode.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer single view mode button
	 * 
	 * @throws IOException
	 */
	public void clickSingleViewModeButton() throws IOException {
		logger.info("User clicked single viewer mode button");
		utility.initializeElement(LoginPage.driver, "patientviewer.single.view.mode.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer two view mode button
	 * 
	 * @throws IOException
	 */
	public void clickTwoViewModeButton() throws IOException {
		logger.info("User clicked two viewer mode button");
		utility.initializeElement(LoginPage.driver, "patientviewer.two.view.mode.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer reset views button
	 * 
	 * @throws IOException
	 */
	public void clickResetViewsButton() throws IOException {
		logger.info("User clicked reset views button");
		utility.initializeElement(LoginPage.driver, "patientviewer.resetviews.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer reset transparency button
	 * 
	 * @throws IOException
	 */
	public void clickResetTransparencyButton() throws IOException {
		logger.info("User clicked reset trasparency button");
		utility.initializeElement(LoginPage.driver, "patientviewer.resettransparency.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer brightness contrast button
	 * 
	 * @throws IOException
	 */
	public void clickBrightnessContrastButton() throws IOException {
		logger.info("User clicked brightness contrast button");
		utility.initializeElement(LoginPage.driver, "patientviewer.brightnesscontrast.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer lasso button
	 * 
	 * @throws IOException
	 */
	public void clickLassoButton() throws IOException {
		logger.info("User clicked lasso button");
		utility.initializeElement(LoginPage.driver, "patientviewer.lasso.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer brush button
	 * 
	 * @throws IOException
	 */
	public void clickBrushButton() throws IOException {
		logger.info("User clicked brush button");
		utility.initializeElement(LoginPage.driver, "patientviewer.brush.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer eraser button
	 * 
	 * @throws IOException
	 */
	public void clickEraserButton() throws IOException {
		logger.info("User clicked eraser button");
		utility.initializeElement(LoginPage.driver, "patientviewer.eraser.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer view changes button
	 * 
	 * @throws IOException
	 */
	public void clickViewChangesButton() throws IOException {
		logger.info("User clicked view changes button");
		utility.initializeElement(LoginPage.driver, "patientviewer.viewchanges.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer undo button
	 * 
	 * @throws IOException
	 */
	public void clickUndoButton() throws IOException {
		logger.info("User clicked undo button");
		utility.initializeElement(LoginPage.driver, "patientviewer.undo.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer redo button
	 * 
	 * @throws IOException
	 */
	public void clickRedoButton() throws IOException {
		logger.info("User clicked redo button");
		utility.initializeElement(LoginPage.driver, "patientviewer.redo.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer reset changes button
	 * 
	 * @throws IOException
	 */
	public void clickResetChangesButton() throws IOException {
		logger.info("User clicked reset changes button");
		utility.initializeElement(LoginPage.driver, "patientviewer.resetchanges.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer approve button
	 * 
	 * @throws IOException
	 */
	public void clickApproveButton() throws IOException {
		logger.info("User clicked approve button");
		utility.initializeElement(LoginPage.driver, "patientviewer.approve.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer save button
	 * 
	 * @throws IOException
	 */
	public void clickSaveButton() throws IOException {
		logger.info("User clicked save button");
		utility.initializeElement(LoginPage.driver, "patientviewer.save.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer reject button
	 * 
	 * @throws IOException
	 */
	public void clickRejectButton() throws IOException {
		logger.info("User clicked reject button");
		utility.initializeElement(LoginPage.driver, "patientviewer.reject.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer download log button
	 * 
	 * @throws IOException
	 */
	public void clickDownloadLogButton() throws IOException {
		logger.info("User clicked download log button");
		utility.initializeElement(LoginPage.driver, "patientviewer.downloadlog.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer exit button
	 * 
	 * @throws IOException
	 */
	public void clickExitButton() throws IOException {
		logger.info("User clicked exit button");
		utility.initializeElement(LoginPage.driver, "patientviewer.exit.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer first dicom container fullsize button
	 * 
	 * @throws IOException
	 */
	public void clickFirstDicomContainerFullsizeButton() throws IOException {
		logger.info("User clicked first dicom container fullsize button");
		utility.initializeElement(LoginPage.driver, "patientviewer.first.fullsize.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer second dicom container fullsize button
	 * 
	 * @throws IOException
	 */
	public void clickSecondDicomContainerFullsizeButton() throws IOException {
		logger.info("User clicked second dicom container fullsize button");
		utility.initializeElement(LoginPage.driver, "patientviewer.second.fullsize.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer third dicom container fullsize button
	 * 
	 * @throws IOException
	 */
	public void clickThirdDicomContainerFullsizeButton() throws IOException {
		logger.info("User clicked cthird dicom container fullsize button");
		utility.initializeElement(LoginPage.driver, "patientviewer.third.fullsize.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer fourth dicom container fullsize button
	 * 
	 * @throws IOException
	 */
	public void clickFourthDicomContainerFullsizeButton() throws IOException {
		logger.info("User clicked fourth dicom container fullsize button");
		utility.initializeElement(LoginPage.driver, "patientviewer.fourth.fullsize.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer first dicom container pan button
	 * 
	 * @throws IOException
	 */
	public void clickFirstDicomContainerPanButton() throws IOException {
		logger.info("User clicked first dicom container pan button");
		utility.initializeElement(LoginPage.driver, "patientviewer.first.pan.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer second dicom container pan button
	 * 
	 * @throws IOException
	 */
	public void clickSecondDicomContainerPanButton() throws IOException {
		logger.info("User clicked second dicom container pan button");
		utility.initializeElement(LoginPage.driver, "patientviewer.second.pan.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer third dicom container pan button
	 * 
	 * @throws IOException
	 */
	public void clickThirdDicomContainerPanButton() throws IOException {
		logger.info("User clicked third dicom container pan button");
		utility.initializeElement(LoginPage.driver, "patientviewer.third.pan.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer fourth dicom container pan button
	 * 
	 * @throws IOException
	 */
	public void clickFourthDicomContainerPanButton() throws IOException {
		logger.info("User clicked fourth dicom container pan button");
		utility.initializeElement(LoginPage.driver, "patientviewer.fourth.pan.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer first dicom container zoom button
	 * 
	 * @throws IOException
	 */
	public void clickFirstDicomContainerZoomButton() throws IOException {
		logger.info("User clicked first dicom container zoom button");
		utility.initializeElement(LoginPage.driver, "patientviewer.first.zoom.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer second dicom container zoom button
	 * 
	 * @throws IOException
	 */
	public void clickSecondDicomContainerZoomButton() throws IOException {
		logger.info("User clicked second dicom container zoom button");
		utility.initializeElement(LoginPage.driver, "patientviewer.second.zoom.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer third dicom container zoom button
	 * 
	 * @throws IOException
	 */
	public void clickThirdDicomContainerZoomButton() throws IOException {
		logger.info("User clicked third dicom container zoom button");
		utility.initializeElement(LoginPage.driver, "patientviewer.third.zoom.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer fourth dicom container zoom button
	 * 
	 * @throws IOException
	 */
	public void clickFourthDicomContainerZoomButton() throws IOException {
		logger.info("User clicked fourth dicom container zoom button");
		utility.initializeElement(LoginPage.driver, "patientviewer.fourth.zoom.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer second dicom container rotate button
	 * 
	 * @throws IOException
	 */
	public void clickSecondDicomContainerRotateButton() throws IOException {
		logger.info("User clicked second dicom container rotate button");
		utility.initializeElement(LoginPage.driver, "patientviewer.second.rotate.btn.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer first dicom container view selection menu
	 * 
	 * @throws IOException
	 */
	public void clickFirstDicomContainerViewSelectionMenu() throws IOException {
		logger.info("User clicked first dicom container view selection menu");
		utility.initializeElement(LoginPage.driver, "patientviewer.first.viewselection.menu.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer second dicom container view selection menu
	 * 
	 * @throws IOException
	 */
	public void clickSecondDicomContainerViewSelectionMenu() throws IOException {
		logger.info("User clicked second dicom container view selection menu");
		utility.initializeElement(LoginPage.driver, "patientviewer.second.viewselection.menu.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer third dicom container view selection menu
	 * 
	 * @throws IOException
	 */
	public void clickThirdDicomContainerViewSelectionMenu() throws IOException {
		logger.info("User clicked third dicom container view selection menu");
		utility.initializeElement(LoginPage.driver, "patientviewer.third.viewselection.menu.xpath").click();
	}
	
	/**
	 * This method is to click the patient viewer fourth dicom container view selection menu
	 * 
	 * @throws IOException
	 */
	public void clickFourthDicomContainerViewSelectionMenu() throws IOException {
		logger.info("User clicked fourth dicom container view selection menu");
		utility.initializeElement(LoginPage.driver, "patientviewer.fourth.viewselection.menu.xpath").click();
	}
}