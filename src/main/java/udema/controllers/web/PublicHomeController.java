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

@WebServlet(urlPatterns = "/home")
public class PublicHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CoursesDao coursesDao;
	
	public PublicHomeController() {
		coursesDao = new CoursesDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Course> courses = coursesDao.findAll();
		request.setAttribute("courses", courses);
		request.getRequestDispatcher("/WEB-INF/views/public/home/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}