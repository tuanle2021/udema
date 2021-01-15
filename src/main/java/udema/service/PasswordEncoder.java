package udema.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {
	public String encode(String rawPassword) {
		return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
	}

	public boolean matches(String rawPassword, String encodedPassword) {
		return BCrypt.checkpw(rawPassword, encodedPassword);
	}

	// password encode example
	public static void main(String[] args) {
		PasswordEncoder pe = new PasswordEncoder();
		String encodedPassword = pe.encode("123456");
		System.out.println(encodedPassword);
		System.out.println(pe.matches("123456", encodedPassword));
	}
}
