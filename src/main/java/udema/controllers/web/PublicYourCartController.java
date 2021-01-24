package udema.controllers.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import udema.dao.models.Course;
import udema.dao.repos.CoursesDao;
import udema.dao.repos.OtpCodeDao;
import udema.dao.repos.UsersDao;
import udema.service.PasswordEncoder;

@WebServlet(urlPatterns = "/course-detail")
public class PublicYourCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CoursesDao coursesDao;

	public PublicYourCartController() {
		coursesDao = new CoursesDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		int courseId = Integer.parseInt(id); 
		Course course = coursesDao.findOneById(courseId);
		request.setAttribute("course", course);
		request.getRequestDispatcher("/WEB-INF/views/public/courses/detail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}