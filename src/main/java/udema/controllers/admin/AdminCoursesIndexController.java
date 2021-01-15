package udema.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import udema.dao.models.Course;
import udema.dao.repos.CoursesDAO;

@WebServlet(urlPatterns = "/admin/courses")
public class AdminCoursesIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CoursesDAO courseDAO;
	
	public AdminCoursesIndexController() {
		courseDAO = new CoursesDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Course> list = courseDAO.findAll();
		System.out.println("size: " + list.size());
		
		Course course = courseDAO.findOneById(1);
		System.out.println("course: " + course.toString());
		
		int isDeleted = courseDAO.deleteOneByid(100);
		System.out.println("isDeleted: " + isDeleted);
		
		course.setStatus("uncomplete");
		int isUpdated = courseDAO.updateOneByid(course);
		System.out.println("isUpdated: "+ isUpdated);
		
		course.setName("Flutter & Dart - The Complete Guide [2021 Edition]");
		int isCreated= courseDAO.createOne(course);
		System.out.println("createone: "+ isCreated);
		
		request.setAttribute("name", "son");
		request.getRequestDispatcher("/WEB-INF/views/admin/messages/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}