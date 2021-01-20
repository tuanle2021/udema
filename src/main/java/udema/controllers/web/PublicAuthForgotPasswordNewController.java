package udema.controllers.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import udema.dao.models.OtpCode;
import udema.dao.models.User;
import udema.dao.repos.OtpCodeDao;
import udema.dao.repos.UsersDao;
import udema.service.PasswordEncoder;

@WebServlet(urlPatterns = "/forgot/password/new")
public class PublicAuthForgotPasswordNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDao usersDao;
	private OtpCodeDao otpCodeDao;
	private PasswordEncoder passwordEncoder;

	public PublicAuthForgotPasswordNewController() {
		usersDao = new UsersDao();
		otpCodeDao = new OtpCodeDao();
		passwordEncoder = new PasswordEncoder();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		if (code == null || code.trim().equals("")) {
			response.sendRedirect("/home");
			return;
		}

		OtpCode otpCode = otpCodeDao.findByCode(code);
		if (otpCode == null) {
			response.sendRedirect("/home");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/views/public/auth/forgot-password-new.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		if (code == null || code.trim().equals("")) {
			response.sendRedirect("/home");
			return;
		}

		OtpCode otpCode = otpCodeDao.findByCode(code);
		if (otpCode == null) {
			response.sendRedirect("/home");
			return;
		}

		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		if (!password.equals(confirmPassword)) {
			response.sendRedirect(request.getRequestURI());
			return;
		}

		Integer userId = otpCode.getUserId();
		User user = usersDao.findById(userId);
		if (user == null || !user.getStatus()) {
			response.sendRedirect(request.getRequestURI());
			return;
		}
		password = passwordEncoder.encode(password);
		user.setPassword(password);
		int isUpdated = usersDao.updateOne(user);
		if (isUpdated > 0) {
			response.sendRedirect("/login");
			return;
		}

		response.sendRedirect("/home");
		return; 
	}
}