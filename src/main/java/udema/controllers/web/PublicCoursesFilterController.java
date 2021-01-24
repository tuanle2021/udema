package udema.controllers.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import udema.dao.models.Course;
import udema.dao.repos.CoursesDao;

@WebServlet(urlPatterns = "/filter")
public class PublicCoursesFilterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CoursesDao coursesDao;

	public PublicCoursesFilterController() {
		coursesDao = new CoursesDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		int courseId = Integer.parseInt(id); 
		List<Course> courses = coursesDao.findAllbyId(courseId);
		
		request.setAttribute("courses", courses);
		
		request.getRequestDispatcher("/WEB-INF/views/public/courses/filter.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}