package project1.javadesktop;
		import java.sql.DriverManager;
		import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
		import com.mysql.jdbc.Driver;
public class Connection_Database {
	private static	Connection conn = null;

	public static Connection Ketnoi() {
		String strUser = null;
		String strPwd = null;
	
		String strConnect = "jdbc:mysql://" + "localhost" + "/" + "QUANLYDIEN"
				+ "?useUnicode=true&characterEncoding=utf-8" + "?useUnicode=true&characterEncoding=utf-8";
		// Properties pro = new Properties();
		// pro.put("JavaDatabase", strUser);
		// pro.put("123456", strPwd);
		String username = "QUANLYDIEN";
		String password = "123456";

		try {
			Driver driver = new Driver();
			conn = (Connection) DriverManager.getConnection(strConnect, username, password);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không kết nối Database", "Thông báo lỗi",
					JOptionPane.ERROR_MESSAGE);
			//ex.printStackTrace();
		}
		return conn;
	}
}

