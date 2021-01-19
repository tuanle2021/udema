package udema.filters;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udema.constants.Constants;
import udema.dao.models.User;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		Object loginValue = session.getAttribute(Constants.CREDENTIALS);

		if (loginValue == null || !(loginValue instanceof User)) {
			response.sendRedirect("/login");
			return;
		}

		User user = (User) loginValue;
		if (!user.getStatus()) {
			response.sendRedirect("/login");
			return;
		}

		Integer roleId = user.getRoleId();
		Boolean hasAccess = Arrays.asList(Constants.ROLE_ADMIN, Constants.ROLE_TEACHER).contains(roleId);
		if (!hasAccess) {
			response.sendRedirect("/login");
			return;
		}

		chain.doFilter(request, response);
	}
}