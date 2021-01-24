package udema.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import udema.constants.Constants;
import udema.dao.models.Course;
import udema.dao.models.User;
import udema.dao.repos.CoursesDao;

@WebServlet(urlPatterns = "/admin/courses")
public class AdminCoursesIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CoursesDao courseDAO;

	public AdminCoursesIndexController() {
		courseDAO = new CoursesDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User)session.getAttribute(Constants.CREDENTIALS);
		
		List<Course> listCourse = courseDAO.findAllByTeacherId(userLogin.getId());
		request.setAttribute("courses", listCourse);
		request.getRequestDispatcher("/WEB-INF/views/admin/courses/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}