package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class UserDB {
	private final static Connection conn = ConnectDB.getConnect();

	public static boolean isLogin(String username, String password) {
		try {
			String sql = "SELECT * FROM tbl_user WHERE username = ? AND password = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static User getUser(String username, String password) {
		User user = new User();
		try {
			String sql = "SELECT * FROM tbl_user "
					+ "WHERE username = ? AND password = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getInt("role"));
				user.setCustomerCode(rs.getString("customer_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static int changePassword(String password, String code) {
		
		try {
			String sql = "UPDATE tbl_user SET password = ? WHERE customer_code = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, password);
			stm.setString(2, code);
			return stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
