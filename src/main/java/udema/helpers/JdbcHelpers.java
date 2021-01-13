package udema.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcHelpers {
	private static String url = "jdbc:mysql://localhost/racing_f1?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			System.out.println("Không thể nạp driver");
			e.printStackTrace();
			return null;
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs, Statement st, Connection conn) {
		close(rs);
		close(st);
		close(conn);
	}

	public static void close(ResultSet rs, PreparedStatement pst) {
		close(rs);
		close(pst);
	}

	public static void close(ResultSet rs, PreparedStatement pst, Connection conn) {
		close(rs);
		close(pst);
		close(conn);
	}

	public static void close(PreparedStatement pst, Connection conn) {
		close(pst);
		close(conn);
	}
}
