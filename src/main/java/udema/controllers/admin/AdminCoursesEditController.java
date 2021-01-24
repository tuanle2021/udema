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
import udema.dao.models.Category;
import udema.dao.models.Course;
import udema.dao.models.User;
import udema.dao.repos.CatDao;
import udema.dao.repos.CoursesDao;

@WebServlet(urlPatterns = "/admin/courses/edit")
public class AdminCoursesEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CoursesDao courseDAO;
	private CatDao catDao;

	public AdminCoursesEditController() {
		courseDAO = new CoursesDao();
		catDao = new CatDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Course course = courseDAO.findOneById(id);
		if (course == null) {
			response.sendRedirect("/admin/courses?msg=NotFoundErr");
			return;
		}

		List<Category> categories = catDao.findAll();
		request.setAttribute("categories", categories);
		request.setAttribute("course", course);
		request.getRequestDispatcher("/WEB-INF/views/admin/courses/edit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Course course = courseDAO.findOneById(id);
		if (course == null) {
			response.sendRedirect("/admin/courses?msg=NotFoundErr");
			return;
		}

		String name = request.getParameter("name");
		String desctiption = request.getParameter("description");
		Integer category = Integer.parseInt(request.getParameter("category"));
		String images = request.getParameter("images");
		String status = request.getParameter("status");
		Double prices = Double.parseDouble(request.getParameter("prices"));
		String detail = request.getParameter("detail");

		Category cat = catDao.findOne(category);

		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute(Constants.CREDENTIALS);
		
		
		if (userLogin.getId() != course.getTeacher().getId()) {
			response.sendRedirect("/admin/courses?msg=NoPermiss");
			return;
		}
		

		course.setDescription(desctiption);
		course.setImages(images);
		course.setPrice(prices);
		course.setStatus(status);
		course.setDetail(detail);
		course.setName(name);
		course.setCategory(cat);
		

		int iscreated = courseDAO.updateOneByid(course);

		if (iscreated < 1) {
			response.sendRedirect("/admin/courses?msg=UpdateErr");

			return;
		}

		response.sendRedirect("/admin/courses?msg=updateSucess");
	}
}