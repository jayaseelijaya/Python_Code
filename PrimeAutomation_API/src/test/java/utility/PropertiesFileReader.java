package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesFileReader {
	Logger logger = Logger.getLogger("properties");

	public Properties getProperty() throws IOException {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("./src/test/resources/config/api-config.properties"));
			properties.load(new FileInputStream("./src/test/resources/config/api-config-responseData_PRSAMD-144_PRSAMD-37.properties"));
			properties.load(new FileInputStream("./src/test/resources/config/api-config-responseData_PRSAMD-140.properties"));
			properties.load(new FileInputStream("./src/test/resources/config/api-config-responseData_PRSAMD-181.properties"));
			properties.load(new FileInputStream("./src/test/resources/config/api-config-responseData_PRSAMD-225.properties"));
			properties.load(new FileInputStream("./src/test/resources/config/api-config-responseData_PRSAMD-573.properties"));
		} catch (Exception e) {

			logger.warning("PropertiesFileReader:Could not load property!" + e);
		}
		return properties;
	}
}
