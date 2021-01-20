package udema.controllers.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import udema.dao.models.OtpCode;
import udema.dao.models.User;
import udema.dao.repos.OtpCodeDao;
import udema.dao.repos.UsersDao;
import udema.helpers.OtpCodeHelpers;
import udema.helpers.ResourcesHelper;
import udema.service.ConfigService;
import udema.service.MailerService;
import udema.service.PasswordEncoder;
import udema.service.params.MailParams;
import udema.constants.Constants;

@WebServlet(urlPatterns = "/register")
public class PublicAuthRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDao usersDao;
	private PasswordEncoder passwordEncoder;
	private MailerService mailerService;
	private OtpCodeHelpers codeHelpers;
	private ConfigService configService;
	private OtpCodeDao otpCodeDao;

	public PublicAuthRegisterController() {
		super();
		usersDao = new UsersDao();
		passwordEncoder = new PasswordEncoder();
		mailerService = new MailerService();
		codeHelpers = new OtpCodeHelpers();
		otpCodeDao = new OtpCodeDao();
		configService = new ConfigService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/public/auth/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String gender = request.getParameter("gender");
		User user = usersDao.findByEmail(email);

		if (user != null) {
			response.sendRedirect("/register?msg=registerErrExist");
			return;
		}

		if (!password.equals(confirmPassword)) {
			response.sendRedirect("/register?msg=registerErrPass");
			return;
		}

		user = new User(null, email, passwordEncoder.encode(password), fullname, gender, "", null, Constants.ROLE_STUDENT, false);
		int isCreated = usersDao.createOne(user);

		if (isCreated < 1) {
			response.sendRedirect("/register?msg=registerErr");
			return;
		}

		String code = codeHelpers.generateCode();
		Integer timeout = Integer.parseInt(configService.get("auth.register-timeout"));
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, timeout);
		Timestamp expiredTime = new Timestamp(cal.getTimeInMillis());
		otpCodeDao.createOne(new OtpCode(null, code, 0, email, expiredTime, null, null));
		
		// send mail
		Map<String, String> map = new HashMap<>();
		map.put("username", fullname);
		map.put("otpCode", code);
		String template = ResourcesHelper.getResourceAsString("templates/register-otp.html");
		MailParams mailParams = MailParams.builder()
				.from("hoangtuanle2021@gmail.com")
				.to(email)
				.subject("[Udema] Verify OTP code")
				.template(template)
				.params(map)
				.build();

		try {
			mailerService.sendEmail(mailParams);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/register?msg=registerErrMail");
			return;
		}

		response.sendRedirect("/register-otp?msg=success");
		return;
	}
}