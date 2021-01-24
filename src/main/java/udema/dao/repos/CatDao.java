package udema.dao.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udema.dao.models.Category;
import udema.dao.models.User;
import udema.helpers.JdbcHelpers;

public class CatDao {
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;
	private Connection conn;

	private Category mapRow(ResultSet rs) throws SQLException {
		Category cat = new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parentId"));
		return cat;
	}

	public List<Category> findAll() {
		List<Category> list = new ArrayList<>();
		conn = JdbcHelpers.getConnection();
		String sql = "SELECT * FROM categories ";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(mapRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, pst, conn);
		}
		return list;
	}

	public Category findOne(Integer id) {
		Category cat = null;
		conn = JdbcHelpers.getConnection();
		String sql = "SELECT * FROM categories WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				cat = mapRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, pst, conn);
		}
		return cat;
	}

}
