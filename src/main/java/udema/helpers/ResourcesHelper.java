package udema.helpers;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class ResourcesHelper {
	public static String getResourceAsString(String path) throws IOException {
		InputStream is = ResourcesHelper.class.getClassLoader().getResourceAsStream(path);
		return IOUtils.toString(is, "UTF-8");
	}
}
