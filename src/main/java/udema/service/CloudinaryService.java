package udema.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryService {
    private Cloudinary cloudinary;
    private ConfigService configService;
    private static final String INFO_URL = "url";

    public CloudinaryService() {
    	configService = new ConfigService();
    	cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", configService.get("cloudinay.cloud_name"),
            "api_key", configService.get("cloudinay.api_key"),
            "api_secret", configService.get("cloudinay.api_secret")
        ));
	}

    @SuppressWarnings("unchecked")
	public String upload(byte[] bytes) throws IOException {
        Map<String, Object> uploadResult = cloudinary.uploader().upload(bytes, ObjectUtils.emptyMap());
        return (String) uploadResult.get(INFO_URL);
    }

    @SuppressWarnings("unchecked")
	public Map<String, Object> uploadAndInfo(File file) throws IOException {
        return cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    }
}