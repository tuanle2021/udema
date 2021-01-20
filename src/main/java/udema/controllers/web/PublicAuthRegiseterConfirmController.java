package udema.controllers.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udema.constants.Constants;
import udema.dao.models.User;
import udema.dao.repos.UsersDao;
import udema.helpers.OtpCodeHelpers;
import udema.helpers.ResourcesHelper;
import udema.service.MailerService;
import udema.service.PasswordEncoder;
import udema.service.params.MailParams;

@WebServlet(urlPatterns = "/register-otp")
public class PublicAuthRegiseterConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDao usersDao;
	private OtpCodeHelpers codeHelpers;

	public PublicAuthRegiseterConfirmController() {
		super();
		usersDao = new UsersDao();
		codeHelpers = new OtpCodeHelpers();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/public/auth/registerOtp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String otpCode = request.getParameter("otp");
		User user = null;

		if (user == null) {
			response.sendRedirect("/login?msg=loginError");
			return;
		}


		/** Login successfully */
		HttpSession session = request.getSession();
		session.setAttribute(Constants.CREDENTIALS, user);
		Integer roleId = user.getRoleId();

		if (roleId == Constants.ROLE_STUDENT) {
			response.sendRedirect("/home");
			return;
		}

		if (roleId == Constants.ROLE_ADMIN || roleId == Constants.ROLE_TEACHER) {
			response.sendRedirect("/admin/dashboard");
			return;
		}
	}

}
