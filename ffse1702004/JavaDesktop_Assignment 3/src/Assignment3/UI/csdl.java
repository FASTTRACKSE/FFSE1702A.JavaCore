package Assignment3.UI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class csdl {

	static Statement statement;

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		Connection conn = getConnect("localhost", "qlsv", "qlsv", "qlsv");
		if (conn != null) {
			System.out.print("chào mừng đến với công nghệ 4.0\n");
//			// laays duwx lieeuj tufw database
//			try {
//				statement = (Statement) conn.createStatement();
//				ResultSet result = statement.executeQuery("select * from sinhvien");
//				while (result.next()) {
//					System.out.println(result.getString("id") + "   " + result.getString("name") + "   "
//							+ result.getString("class"));
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

		} else {
			System.out.print("xin chào mừng bạn về với thời tiền sử ");
		}
	}
}
