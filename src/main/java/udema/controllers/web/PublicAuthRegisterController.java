package udema.controllers.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import udema.dao.models.User;
import udema.dao.repos.UsersDao;
import udema.service.PasswordEncoder;
import udema.constants.Constants;

@WebServlet(urlPatterns = "/register")
public class PublicAuthRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDao usersDao;
	private PasswordEncoder passwordEncoder;

	public PublicAuthRegisterController() {
		super();
		usersDao = new UsersDao();
		passwordEncoder = new PasswordEncoder();
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
			response.sendRedirect("/register?msg=registerErr");
			return;
		}

		if (!password.equals(confirmPassword)) {
			response.sendRedirect("/register?msg=registerErr");
		}

		password = passwordEncoder.encode(password);
		user = new User(null, email, password, fullname, gender, "", null, Constants.ROLE_STUDENT, false);

		int isCreated = usersDao.createOne(user);

		if (isCreated > 0) {
			response.sendRedirect("/login");
			return;
		}

		response.sendRedirect("/register?msg=registerErr");
		return;
	}
}