package fasttrack.edu.vn.main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

import fasttrack.edu.vn.ui.ThemSinhVien;



public class MyApplication {

	public static void main(String args[]) { 
		Connection conn = getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");
		if (conn != null) {
			ThemSinhVien myUI = new ThemSinhVien();
			myUI.Insertstudent();
			myUI.Display();
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase;
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

}
