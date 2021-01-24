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

@WebServlet(urlPatterns = "/admin/courses/add")
public class AdminCoursesAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CoursesDao courseDAO;
	private CatDao catDao;

	public AdminCoursesAddController() {
		courseDAO = new CoursesDao();
		catDao = new CatDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categories = catDao.findAll();

		request.setAttribute("categories", categories);

		request.getRequestDispatcher("/WEB-INF/views/admin/courses/create.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		Course course = new Course(0, name, desctiption, detail, images, prices, status, userLogin, null, null, 0, cat,
				0);

		int iscreated = courseDAO.createOne(course);

		if (iscreated < 1) {
			response.sendRedirect("/admin/courses?msg=AddErr");

			return;
		}

		response.sendRedirect("/admin/courses?msg=AddSucess");
	}
}