package udema.controllers.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udema.constants.Constants;
import udema.dao.models.User;
import udema.dao.repos.UsersDao;
import udema.service.PasswordEncoder;

@WebServlet(urlPatterns = "/login")
public class PublicAuthLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDao usersDao;
	private PasswordEncoder passwordEncoder;

	public PublicAuthLoginController() {
		usersDao = new UsersDao();
		passwordEncoder = new PasswordEncoder();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/public/auth/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = usersDao.findByEmail(email);

		if (user == null) {
			response.sendRedirect("/login?msg=loginError");
			return;
		}

		if (!passwordEncoder.matches(password, user.getPassword())) {
			response.sendRedirect("/login?msg=loginError");
			return;
		}

		/** Login successfully */
		HttpSession session = request.getSession();
		session.setAttribute(Constants.CREDENTIALS, user);
		Integer roleId = user.getRoleId();

		if (roleId == Constants.ROLE_STUDENT) {
			response.sendRedirect("/");
			return;
		}

		if (roleId == Constants.ROLE_ADMIN || roleId == Constants.ROLE_TEACHER) {
			response.sendRedirect("/admin/dashboard");
			return;
		}
	}
}