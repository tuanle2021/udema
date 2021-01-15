package udema.controllers.admin;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import udema.service.CloudinaryService;

@MultipartConfig
@WebServlet(urlPatterns = "/admin/demo/upload")
public class AdminDemoUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CloudinaryService cloudinaryService;

	public AdminDemoUploadController() {
		cloudinaryService = new CloudinaryService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/admin/demo/upload.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part part = request.getPart("image");

		if (part != null) {
			InputStream is = part.getInputStream();
			byte[] bytes = IOUtils.toByteArray(is);
			String url = cloudinaryService.upload(bytes);
			System.out.println(url);
		}
	}
}