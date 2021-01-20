package udema.controllers.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import udema.dao.models.User;
import udema.dao.repos.UsersDao;
import udema.helpers.OtpCodeHelpers;
import udema.helpers.ResourcesHelper;
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

	public PublicAuthRegisterController() {
		super();
		usersDao = new UsersDao();
		passwordEncoder = new PasswordEncoder();
		mailerService = new MailerService();
		codeHelpers = new OtpCodeHelpers();
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

		password = passwordEncoder.encode(password);
		user = new User(null, email, password, fullname, gender, "", null, Constants.ROLE_STUDENT, false);

		int isCreated = usersDao.createOne(user);

		if (isCreated < 1) {
			response.sendRedirect("/register?msg=registerErr");
			return;
		}


		// send mail
		Map<String, String> map = new HashMap<>();
		String otpCode = codeHelpers.generateCode();
		map.put("username", fullname);
		map.put("otpCode", otpCode);

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
			response.sendRedirect("/register?msg=registerErr");
			return;
		}

		response.sendRedirect("/register-otp?msg=Success");
		return;
	}
}