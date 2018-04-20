package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class quan {
	private static Statement statement;

	public static ArrayList<String> getQuan() throws SQLException {
		ArrayList<String> quan = new ArrayList<>();
		Connection conn = connectdb.getConnect();
		try {
			
			String sql = "select * from ffse1702026_quan";
			statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				quan.add(result.getString("name"));
			}
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
		return quan;
	}

}
