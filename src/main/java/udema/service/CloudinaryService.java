package udema.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryService {
    private Cloudinary cloudinary;

    public CloudinaryService() {
    	cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dqceu7sxd",
            "api_key", "338579227615242",
            "api_secret", "bGNmTk50_cFwhlJq-6DPY6FvCCk"
        ));
	}
    private static final String INFO_URL = "url";

    @SuppressWarnings("unchecked")
	public String upload(File file) throws IOException {
        Map<String, String> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        return (String) uploadResult.get(INFO_URL);
    }

    @SuppressWarnings("unchecked")
	public Map<String, String> uploadAndInfo(File file) throws IOException {
        return cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    }
}