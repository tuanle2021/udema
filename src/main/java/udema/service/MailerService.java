package udema.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import udema.constants.Constants;

public class MailerService {
	public static final String CONTENT_TYPE = "text/html";
	private ConfigService configService;

	public MailerService() {
		configService = new ConfigService();
	}

	public void sendEmail() throws Exception {
		final String to = "hoangtuanle2021+test@gmail.com";
		final String from = configService.get("mail.username");
		final String username = configService.get("mail.username");
		final String password = configService.get("mail.password");

		final Properties props = new Properties();
		props.put("mail.smtp.auth", configService.get("mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable", configService.get("mail.smtp.starttls.enable"));
		props.put("mail.smtp.host", configService.get("mail.smtp.host"));
		props.put("mail.smtp.port", configService.get("mail.smtp.port"));
		props.put("mail.mime.charset", configService.get("mail.mime.charset"));

		final Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		final Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject("[Udema] Otp authentication code");
		message.setContent(Constants.REGISTER_TEMPLATE, CONTENT_TYPE);

		Transport.send(message);
	}

	public static void main(String[] args) throws Exception {
		new MailerService().sendEmail();
	}
}