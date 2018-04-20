package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class connectdb {

	public static Connection getConnect() {
		String strServer="localhost";
		String strDatabase="dienluc";
		String strUser="dienluc";
		String strPwd="dienluc";
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
			JOptionPane.showMessageDialog(null, "không thể kết nối database","Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}
	public static void main(String args[]) throws SQLException {
		Connection conn=getConnect();
		if (conn!=null) {
			System.out.print("kết nối thành công");
			Statement statement =(Statement) conn.createStatement();
			ResultSet result =statement.executeQuery("select * from ffse1702026_quan");
			while(result.next()) {
				System.out.println(result.getString("id"));
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "không thể kết nối database","Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
