package Data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class Connect {
	public static Connection getConnect() {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + "localhost" + "/" + "lp4" + "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", "lp4");
		pro.put("password", "1234");
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}