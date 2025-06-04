package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

	PropertiesFileReader reader = new PropertiesFileReader();
	final static Logger logger = Logger.getLogger(Utility.class);

	public WebElement initializeElement(WebDriver driver, String elementName) throws IOException {
		WebElement element = null;
		String eName = elementName.substring(elementName.lastIndexOf(".") + 1);
		Properties properties = reader.getProperty();
		String elemName = properties.getProperty(elementName);

		if (eName.equals("name")) {
			element = driver.findElement(By.name(elemName));
			return element;
		}
		if (eName.equals("id")) {
			element = driver.findElement(By.id(elemName));
			return element;
		}
		if (eName.equals("xpath")) {
			element = driver.findElement(By.xpath(elemName));
			return element;
		}
		logger.error("Invalid element name: " + elementName);
		return null;
	}
	
	public List<WebElement> initializeElements(WebDriver driver, String elementName) throws IOException {
		List<WebElement> elements = null;
		String eName = elementName.substring(elementName.lastIndexOf(".") + 1);
		Properties properties = reader.getProperty();
		String elemName = properties.getProperty(elementName);
		if (eName.equals("xpath")) {
			elements = driver.findElements(By.xpath(elemName));
			return elements;
		}
		logger.error("Invalid element name: " + elementName);
		return null;
	}

	public void zipFolder(final File folder, final File zipFile) throws IOException {
		zipFolder(folder, new FileOutputStream(zipFile));
	}

	public static void zipFolder(final File folder, final OutputStream outputStream) throws IOException {
		try (ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {
			zipLogs(folder, zipOutputStream, folder.getPath().length() + 1);
		}
	}

	private static void zipLogs(final File folder, final ZipOutputStream zipOutputStream, final int prefixLength)
			throws IOException {
		for (final File file : folder.listFiles()) {
			if (file.isFile()) {
				final ZipEntry zipEntry = new ZipEntry(file.getPath().substring(prefixLength));
				zipOutputStream.putNextEntry(zipEntry);
				try (FileInputStream inputStream = new FileInputStream(file)) {
					IOUtils.copy(inputStream, zipOutputStream);
				}
				zipOutputStream.closeEntry();
			} else if (file.isDirectory()) {
				zipLogs(file, zipOutputStream, prefixLength);
			}
		}
	}

	public void zipIt() {
		try {
			Properties properties = reader.getProperty();
			File folder = new File(properties.getProperty("fai.outputdir"));
			File zipFile = new File(properties.getProperty("fai.zipfile"));
			File theDir = new File(properties.getProperty("fai.zipdir"));
			if (!theDir.exists()) {
				theDir.mkdirs();
			}
			this.zipFolder(folder, zipFile);
			logger.info("zipIt : Reports file is available at: " + zipFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCurrentTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String formattedTS = timestamp.toString().replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "")
				.replace(".", "");
		return formattedTS;
	}

	
	}