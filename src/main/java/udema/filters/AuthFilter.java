package udema.filters;

import static udema.constants.Constants.ASSETS_FOLDER;
import static udema.constants.Constants.LOGIN_URL;
import static udema.constants.Constants.LOGOUT_URL;

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
import udema.dao.repos.UsersDao;

@WebFilter("/*")
public class AuthFilter implements Filter {
	private UsersDao usersDao;

	public AuthFilter() {
		usersDao = new UsersDao();
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		Boolean isExcluded = Arrays.asList(LOGIN_URL, LOGOUT_URL, ASSETS_FOLDER).stream().anyMatch(each -> {
			return request.getRequestURI().startsWith("/" + each);
		});

		if (isExcluded) {
			chain.doFilter(req, resp);
			return;
		}

		HttpSession session = request.getSession();
		Object loginValue = session.getAttribute(Constants.CREDENTIALS);

		if (loginValue != null && loginValue instanceof User) {
			User sessionUser = (User) loginValue;
			Integer userId = sessionUser.getId();
			User user = usersDao.findById(userId);
			if (user != null) {
				request.setAttribute(Constants.CREDENTIALS, user);
			}
		}

		chain.doFilter(request, response);
	}
}