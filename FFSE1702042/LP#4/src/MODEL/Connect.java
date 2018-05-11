package MODEL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

public class Connect {

	private static String strServer = "localhost";
	private static String strDatabase = "student";
	private static String strUser = "tungtt";
	private static String strPwd = "12345";

	public static Connection getConnect() {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
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
