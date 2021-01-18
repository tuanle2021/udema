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
}
