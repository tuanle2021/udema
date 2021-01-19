package udema.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import udema.helpers.ResourcesHelper;
import udema.service.params.MailParams;

public class MailerService {
	public static final String CONTENT_TYPE = "text/html";
	private ConfigService configService;

	public MailerService() {
		configService = new ConfigService();
	}

	public void sendEmail(MailParams params) throws Exception {
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
		message.setFrom(new InternetAddress(params.getFrom()));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(params.getTo()));
		message.setSubject(params.getSubject());

		String template = params.getTemplate();
		final Map<String, String> bindingParams = params.getParams();
		if (bindingParams != null && template != null) {
			for (Map.Entry<String, String> entry : bindingParams.entrySet()) {
				template = template.replace("${" + entry.getKey() + "}", entry.getValue());
			}
		}
		message.setContent(template, CONTENT_TYPE);
		Transport.send(message);
	}

	public static void demoResiter() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("username", "Son");
		map.put("link", "https://stackoverflow.com/questions/18601011/replace-string-values-with-value-in-hash-map/18601139");

		String template = ResourcesHelper.getResourceAsString("templates/forgot-password.html");

		MailParams mailParams = MailParams.builder()
				.from("hoangtuanle2021@gmail.com")
				.to("hoangtuanle2021@gmail.com")
				.subject("[Udema] Verify forgot password")
				.template(template)
				.params(map)
				.build();

		new MailerService().sendEmail(mailParams);
	}

	public static void demoForgotPassword() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("username", "Son");
		map.put("otpCode", "123456");

		String template = ResourcesHelper.getResourceAsString("templates/register-otp.html");

		MailParams mailParams = MailParams.builder()
				.from("hoangtuanle2021@gmail.com")
				.to("hoangtuanle2021@gmail.com")
				.subject("[Udema] Verify OTP code")
				.template(template)
				.params(map)
				.build();

		new MailerService().sendEmail(mailParams);
	}

	public static void main(String[] args) throws Exception {
		demoForgotPassword();
		demoResiter();
	}
}