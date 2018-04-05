package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private final String className = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/JavaDesktop";
	private final String user = "ffse1702005";
	private final String pass = "ffse1702@12345";

	private Connection connection;

	private void connect() {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, pass);
			System.out.print("Kết nối thành công");
		} catch (ClassNotFoundException e) {
			System.out.print("Không tìm thấy lớp");
		} catch (SQLException e) {
			System.out.print("Lỗi kết nối");
		}
	}

	public static void main(String[] args) {
		Connect conn = new Connect();
	    	conn.connect();
	    }
}
