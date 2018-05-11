package asm2.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySQL {
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

//	public static void main(String[] args) {
//		Connection conn = getConnect("localhost", "java", "java", "12345");
//		if (conn != null) {
//			System.out.println("Kết nối MYSQL thành công");
//			
//		} else {
//			System.out.println("Kết nối MYSQL thất bại");
//		}
//	}
}
