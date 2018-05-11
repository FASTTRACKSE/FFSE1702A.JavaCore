package tiendien.MAIN;

import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

import tiendien.MODEL.ExceptionMD;
import tiendien.UI.loginUI;

public class loginMain {
	static ExceptionMD ex = new ExceptionMD();

	public static void main(String[] args) {

		try {
			// TODO Auto-generated method stub
			Connection conn = getConnect("localhost", "quanlytiendien", "quanlytiendien", "quanlytiendien");
			if (conn != null) {
				loginUI myUI = new loginUI();
				myUI.showWindow();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi");

		}

	}

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Sai Tài Khoản Hoặc Mật Khẩu Đăng Nhập Database");
			System.exit(0);
		}
		return conn;
	}
}
