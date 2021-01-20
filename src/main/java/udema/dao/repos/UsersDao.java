package udema.dao.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import udema.dao.models.User;
import udema.helpers.JdbcHelpers;

public class UsersDao {
	private ResultSet rs;
	private PreparedStatement pst;
	private Connection conn;

	private User mapRow(ResultSet rs) throws SQLException {
		User user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("fullName"),
				rs.getString("gender"), rs.getString("avatar"), rs.getTimestamp("createdAt"), rs.getInt("roleId"),
				rs.getBoolean("status"));
		return user;
	}

	public User findByEmail(String email) {
		User user = null;
		conn = JdbcHelpers.getConnection();
		String sql = "SELECT * FROM users WHERE email = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = mapRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, pst, conn);
		}
		return user;
	}

	public int createOne(User user) {
		int isCreated = 0;
		conn = JdbcHelpers.getConnection();
		String sql = "INSERT INTO users(email, password, fullName, gender, avatar, roleId) VALUEs (?,?,?,?,?,?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullName());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getAvatar());
			pst.setInt(6, user.getRoleId());

			isCreated = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, pst, conn);
		}

		return isCreated;
	}

	public User findById(Integer id) {
		User user = null;
		conn = JdbcHelpers.getConnection();
		String sql = "SELECT * FROM users WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = mapRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, pst, conn);
		}
		return user;
	}
}
