package udema.controllers.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import udema.dao.models.OtpCode;
import udema.dao.models.User;
import udema.dao.repos.OtpCodeDao;
import udema.dao.repos.UsersDao;
import udema.helpers.ResourcesHelper;
import udema.service.ConfigService;
import udema.service.MailerService;
import udema.service.params.MailParams;

@WebServlet(urlPatterns = "/forgot/password")
public class PublicAuthForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDao usersDao;
	private OtpCodeDao otpCodeDao;
	private ConfigService configService;
	private MailerService mailerService;

	public PublicAuthForgotPasswordController() {
		usersDao = new UsersDao();
		otpCodeDao = new OtpCodeDao();
		configService = new ConfigService();
		mailerService = new MailerService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/public/auth/forgot-password.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		User user = usersDao.findByEmail(email);
		if (user == null) {
			response.sendRedirect("/forgot/password?msg=notfound");
			return;
		}

		if (!user.getStatus()) {
			response.sendRedirect("/forgot/password?msg=status-ban");
			return;
		}

		Integer timeout = Integer.parseInt(configService.get("auth.forgot-password-timeout"));
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, timeout);
		Timestamp expiredTime = new Timestamp(cal.getTimeInMillis());

		String code = UUID.randomUUID().toString();
		otpCodeDao.createOne(new OtpCode(null, code, user.getId(), user.getEmail(), expiredTime, null, null));

		// send email that has a link
		Map<String, String> map = new HashMap<>();
		String name = user.getFullName() != null ? user.getFullName() : user.getEmail();
		map.put("name", name);
		map.put("link", configService.get("app.url") + "/forgot/password/new?code=" + code);
		String template = ResourcesHelper.getResourceAsString("templates/forgot-password.html");
		MailParams mailParams = MailParams.builder()
				.from("hoangtuanle2021@gmail.com")
				.to(user.getEmail())
				.subject("[Udema] Verify to create new password")
				.template(template)
				.params(map)
				.build();
		Thread thread = new Thread(() -> {
			try {
				mailerService.sendEmail(mailParams);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		thread.start();

		response.sendRedirect("/forgot/password?msg=success");
	}
}