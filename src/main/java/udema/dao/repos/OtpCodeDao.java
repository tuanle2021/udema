package udema.dao.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import udema.dao.models.OtpCode;
import udema.helpers.JdbcHelpers;

public class OtpCodeDao {
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;
	private Connection conn;

	private OtpCode mapRow(ResultSet rs) throws SQLException {
		OtpCode otp = new OtpCode(rs.getInt("id"), rs.getString("code"), rs.getInt("userID"), rs.getString("email"),
				rs.getTimestamp("expiredTime"), rs.getTimestamp("createdAt"), rs.getTimestamp("updatedAt"));
		return otp;
	}

	public int createOne(OtpCode createOTP) {
		int isCreated = 0;
		conn = JdbcHelpers.getConnection();
		String sql = "INSERT INTO otp_codes(code, userId, email, expiredTime) VALUES(?,?,?,?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, createOTP.getCode());
			pst.setInt(2, createOTP.getUserId());
			pst.setString(3, createOTP.getEmail());
			pst.setTimestamp(4, createOTP.getExpiredTime());

			isCreated = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, st, conn);
		}

		return isCreated;
	}

	public int updateOne(OtpCode updateOTP) {
		int isUpdated = 0;
		conn = JdbcHelpers.getConnection();
		String sql = "UPDATE otp_codes set code = ?, expiredTime = ? WHERE email =?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, updateOTP.getCode());
			pst.setTimestamp(2, updateOTP.getExpiredTime());
			pst.setString(3, updateOTP.getEmail());

			isUpdated = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, st, conn);
		}

		return isUpdated;
	}

	public OtpCode findByEmail(String email) {
		OtpCode otp = null;
		conn = JdbcHelpers.getConnection();
		String sql = "SELECT * FROM otp_codes WHERE email = ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if (rs.next()) {
				otp = mapRow(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, st, conn);
		}

		return otp;
	}

	public OtpCode findByCode(String code) {
		OtpCode otp = null;
		conn = JdbcHelpers.getConnection();
		String sql = "SELECT * FROM otp_codes WHERE code = ? AND CURRENT_TIME() <= expiredTime";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, code);
			rs = pst.executeQuery();
			if (rs.next()) {
				otp = mapRow(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcHelpers.close(rs, st, conn);
		}

		return otp;
	}
}
