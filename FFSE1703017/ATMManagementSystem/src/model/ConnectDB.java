package model;

import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class ConnectDB {
	private final static String strServer = "localhost";
	private final static String strDatabase = "db_atm";
	private final static String strUser = "atm_app";
	private final static String strPwd = "123456";

	public static Connection getConnect() {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn == null) {
			String message = "Không có kết nối Cơ sở dữ liệu. Vui lòng kiểm tra lại.";
			JOptionPane.showMessageDialog(null, message, "Lỗi", JOptionPane.YES_NO_OPTION);
			System.exit(0);
		}
		return conn;
	}

}
