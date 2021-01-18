package udema.controllers.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udema.constants.Constants;

@WebServlet(urlPatterns = "/logout")
public class PublicAuthLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object loginValue = session.getAttribute(Constants.CREDENTIALS);

		if (loginValue != null) {
			session.removeAttribute(Constants.CREDENTIALS);
		}

		response.sendRedirect("/login");
	}
}