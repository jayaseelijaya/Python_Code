package utility;

import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	public Properties getProperty() throws IOException {
		Properties properties = new Properties();
		try {
			properties.load(PropertiesFileReader.class.getResourceAsStream("/config/browser-config.properties"));
			properties.load(PropertiesFileReader.class.getResourceAsStream("/config/locator.properties"));
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return properties;
	}
}
