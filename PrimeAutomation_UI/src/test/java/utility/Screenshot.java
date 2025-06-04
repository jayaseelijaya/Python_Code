package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Screenshot {
	final static Logger logger = Logger.getLogger(Screenshot.class);
	String screenshotDirectoryPath = "reports/screenshots/";
	String ssdirectoryPath = "reports\\screenshots\\";
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
	static String directoryPath;
	static String directoryPath1;

	public boolean createScreenshotDirectory(String directoryName) throws IOException {
		directoryPath = screenshotDirectoryPath + directoryName.replaceAll(" ", "_").split("_")[0] + "_" + dateFormat.format(new Date());
		directoryPath1 = ssdirectoryPath + directoryName.replaceAll(" ", "_").split("_")[0] + "_" + dateFormat.format(new Date());
		File screenshotDirectory = new File(directoryPath);
		if(!screenshotDirectory.exists()) {
			boolean createdSuccessfully = screenshotDirectory.mkdirs();
			if (createdSuccessfully) {
				logger.info("createScreenshotDirectory:Screenshot folder is created successfully at :" + screenshotDirectory);
				return true;
			} else {
				logger.error("createScreenshotDirectory:Error creating the folder!");
			}
		}
	//	logger.info("createScreenshotDirectory: Folder path ["+screenshotDirectory+"] already exists");
		return false;
		
	}

	public void screenshot(String stepName, WebDriver driver) throws IOException {

		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");

		File screenshotTaken = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File DestFile = new File(directoryPath + "/" + stepName.replaceAll(" ", "_") + "_" + dateFormat1.format(new Date()) + ".jpg");

		Files.copy(screenshotTaken, DestFile);
	}

	 public String autoITScreenshot(String stepName, WebDriver driver) throws IOException {
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
//			String DestFile = System.getProperty("user.dir") + "/" + directoryPath + "/" + stepName.replaceAll(" ", "_") + "_" + dateFormat1.format(new Date()) + ".jpg";
			String DestFile = System.getProperty("user.dir") +"\\" +directoryPath1 +"\\"+ stepName.replaceAll(" ", "_") + "_" + dateFormat1.format(new Date()) + ".jpg";
//			String DestFile =  directoryPath + "/" + stepName.replaceAll(" ", "_") + "_" + dateFormat1.format(new Date()) + ".jpg";
			logger.info(DestFile);
			return DestFile;
		}
}
