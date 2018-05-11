package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class phuong {
	public static ArrayList<String>  getPhuong(String quan) throws SQLException {
		ArrayList<String> phuong =new ArrayList<>();
		Connection conn=connectdb.getConnect();
		String sql= "select ffse1702026_phuong.name from ffse1702026_quan join ffse1702026_phuong where ffse1702026_quan.id=ffse1702026_phuong.id_quan and ffse1702026_quan.name='"+quan+"'";
		Statement statement= (Statement) conn.createStatement();
		ResultSet result=statement.executeQuery(sql);
		while(result.next()) {
			phuong.add(result.getString("name"));
		}
		return phuong;
	}
	
}
