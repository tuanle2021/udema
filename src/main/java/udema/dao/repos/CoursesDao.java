package udema.dao.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udema.dao.models.Category;
import udema.dao.models.Course;
import udema.dao.models.User;
import udema.helpers.JdbcHelpers;

public class CoursesDao {
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;
	private Connection conn;

	private Course mapRow(ResultSet rs) throws SQLException {
		Course course = new Course(rs.getInt("c.id"), rs.getString("c.name"), rs.getString("c.description"),
				rs.getString("c.detail"), rs.getString("c.images"), rs.getDouble("c.price"), rs.getString("c.status"),
				new User(rs.getInt("u.id"), rs.getString("u.email"), rs.getString("u.password"),
						rs.getString("u.fullname"), rs.getString("u.gender"), rs.getString("u.avatar"),
						rs.getTimestamp("u.createdAt"), rs.getInt("u.roleId"), rs.getBoolean("u.status")),
				rs.getTimestamp("c.createdAt"), rs.getTimestamp("c.updatedAt"), rs.getInt("c.viewCount"),
				new Category(rs.getInt("cat.id"), rs.getString("cat.name"), rs.getInt("cat.parentId")),
				rs.getInt("c.discount"));
		return course;
	}

	public List<Course> findAll() {
		List<Course> listCourses = new ArrayList<>();
		conn = JdbcHelpers.getConnection();
		String sql = "SELECT * FROM courses as c INNER JOIN categories as cat ON c.categoryId = cat.id INNER JOIN users as u ON u.id = c.teacherId ORDER BY c.createdAt DESC LIMIT 10";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				listCourses.add(mapRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, st, conn);
		}

		return listCourses;
	}
	public List<Course> findTopcoursebyview() {
		List<Course> listCourses = new ArrayList<>();
		conn = JdbcHelpers.getConnection();
		String sql = "SELECT * FROM courses as c INNER JOIN categories as cat ON c.categoryId = cat.id INNER JOIN users as u ON u.id = c.teacherId ORDER BY c.viewCount DESC LIMIT 10";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				listCourses.add(mapRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, st, conn);
		}

		return listCourses;
	}

	public Course findOneById(int id) {
		Course course = null;
		conn = JdbcHelpers.getConnection();
		String sql = "SELECT * FROM courses as c INNER JOIN categories as cat ON c.categoryId = cat.id INNER JOIN users as u ON u.id = c.teacherId WHERE c.id = ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				course = mapRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, st, conn);
		}

		return course;
	}

	public int deleteOneByid(int id) {
		int isDeleted = 0;
		conn = JdbcHelpers.getConnection();
		String sql = "DELETE FROM courses WHERE id = ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			isDeleted = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, st, conn);
		}

		return isDeleted;
	}

	public int updateOneByid(Course updateCourse) {
		int isUpdated = 0;
		conn = JdbcHelpers.getConnection();
		String sql = "UPDATE courses SET name=?, description=?, detail=?, images=?, price=?, status=?, teacherId=?,categoryId=?, discount=? WHERE id =?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, updateCourse.getName());
			pst.setString(2, updateCourse.getDescription());
			pst.setString(3, updateCourse.getDetail());
			pst.setString(4, updateCourse.getImages());
			pst.setDouble(5, updateCourse.getPrice());
			pst.setString(6, updateCourse.getStatus());
			pst.setInt(7, updateCourse.getTeacher().getId());
			pst.setInt(8, updateCourse.getCategory().getId());
			pst.setInt(9, updateCourse.getDiscount());
			pst.setInt(10, updateCourse.getId());

			isUpdated = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, st, conn);
		}

		return isUpdated;
	}
	
	public int createOne(Course updateCourse) {
		int isCreated = 0;
		conn = JdbcHelpers.getConnection();
		String sql = "INSERT INTO courses(name, description, detail, images, price, status, teacherId, categoryId, discount, viewCount) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, updateCourse.getName());
			pst.setString(2, updateCourse.getDescription());
			pst.setString(3, updateCourse.getDetail());
			pst.setString(4, updateCourse.getImages());
			pst.setDouble(5, updateCourse.getPrice());
			pst.setString(6, updateCourse.getStatus());
			pst.setInt(7, updateCourse.getTeacher().getId());
			pst.setInt(8, updateCourse.getCategory().getId());
			pst.setInt(9, updateCourse.getDiscount());
			pst.setInt(10, updateCourse.getViewCount());

			isCreated = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, st, conn);
		}

		return isCreated;
	}
}
