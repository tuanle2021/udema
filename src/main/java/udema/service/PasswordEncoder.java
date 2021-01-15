package udema.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {
	public String encode(String rawPassword) {
		return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
	}

	public boolean matches(String rawPassword, String encodedPassword) {
		return BCrypt.checkpw(rawPassword, encodedPassword);
	}
}
