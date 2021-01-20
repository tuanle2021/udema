package udema.controllers.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udema.constants.Constants;
import udema.dao.models.OtpCode;
import udema.dao.models.User;
import udema.dao.repos.OtpCodeDao;
import udema.dao.repos.UsersDao;

@WebServlet(urlPatterns = "/register-otp")
public class PublicAuthRegiseterConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDao usersDao;
	private OtpCodeDao codeDao;

	public PublicAuthRegiseterConfirmController() {
		super();
		usersDao = new UsersDao();
		codeDao = new OtpCodeDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/public/auth/registerOtp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String otpCode = request.getParameter("otp");
		OtpCode code = codeDao.findByCode(otpCode);

		if (code == null) {
			response.sendRedirect("/register-otp?msg=otpError");
			return;
		}

		int isActive = usersDao.activeOneByEmail(code.getEmail(), 1);

		if (isActive < 1) {
			response.sendRedirect("/register-otp?msg=otpError1");
			return;
		}

		User userLogin = usersDao.findByEmail(code.getEmail());

		HttpSession session = request.getSession();
		session.setAttribute(Constants.CREDENTIALS, userLogin);
		Integer roleId = userLogin.getRoleId();

		if (roleId == Constants.ROLE_STUDENT) {
			response.sendRedirect("/login");
			return;
		}

		if (roleId == Constants.ROLE_ADMIN || roleId == Constants.ROLE_TEACHER) {
			response.sendRedirect("/login");
			return;
		}
	}

}
