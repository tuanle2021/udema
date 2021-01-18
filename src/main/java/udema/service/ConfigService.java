package udema.service;

import java.io.InputStream;
import java.util.Properties;

public class ConfigService {
	private Properties properties = new Properties();
	private static final String CONFIG_FILE = "config.properties";

	public ConfigService() {
		try {
			load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void load() throws Exception {
		final InputStream is = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE);
		if (is != null) {
			properties.load(is);
		} else {
			throw new Exception("property file '" + CONFIG_FILE + "' not found in the classpath");
		}
	}

	public String get(String key) {
		try {
			if (properties == null) {
				load();
			}
			return (String) properties.get(key);
		} catch (Exception e) {
			return null;
		}
	}
}
