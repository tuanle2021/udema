package udema.helpers;

import java.util.Random;

public class OtpCodeHelpers {
	private static final String NUMBER_FORMAT = "0123456789";

	char[] generateCode() {
		int len = 6;
		Random rndm_method = new Random();

		char[] otp = new char[len];
		for (int i = 0; i < len; i++) {
			otp[i] = NUMBER_FORMAT.charAt(rndm_method.nextInt(NUMBER_FORMAT.length()));
		}

		return otp;
	}
}
