package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import object.BienLai;

public class DBBienLai {
	public static ArrayList<BienLai> getList(String maCongTo) throws SQLException {
		ArrayList<BienLai> list = new ArrayList<>();
		Connection conn = connectdb.getConnect();
		String sql = "select * from ffse1702026_bienlai where macongto = '"+maCongTo+"'";
		Statement statement = (Statement) conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			BienLai bl = new BienLai(result.getString("macongto"), result.getString("date"), result.getString("chuky"),result.getInt("chisocongto"),Integer.parseInt(result.getString("month")),Integer.parseInt(result.getString("year")),Integer.parseInt(result.getString("chisocu")));
			list.add(bl);
			Collections.sort(list);
		}
		return list;
	}
	public static ArrayList<BienLai> getDanhSach(String sql) throws SQLException {
		ArrayList<BienLai> list = new ArrayList<>();
		Connection conn = connectdb.getConnect();
	
		Statement statement = (Statement) conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			BienLai bl = new BienLai(result.getString("macongto"), result.getString("date"), result.getString("chuky"),result.getInt("chisocongto"),Integer.parseInt(result.getString("month")),Integer.parseInt(result.getString("year")),Integer.parseInt(result.getString("chisocu")));
			list.add(bl);
			Collections.sort(list);
		}
		return list;
	}
	public static void addBienLai(String sql) throws SQLException {
		Connection conn = connectdb.getConnect();
		Statement statement = (Statement) conn.createStatement();
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		int kt = ptmt.executeUpdate();

	}
	public static void del(String maCongTo,String month,String year) throws SQLException {
		Connection conn = connectdb.getConnect();
		String sql = "delete from ffse1702026_bienlai where macongto=? and month=? and year=?";
		Statement statement = (Statement) conn.createStatement();
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, maCongTo);
		ptmt.setString(2, month);
		ptmt.setString(3, year);
		int kt = ptmt.executeUpdate();

	}

}
