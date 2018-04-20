package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import object.KhachHang;

public class dbKhachHang {
	private static PreparedStatement ptmt;

	public static void add(String maKhackHang, String tenKhachHang, String quan, String phuong, String diaChi,
			String phone, String email, String maCongTo) throws SQLException {
		Connection conn = connectdb.getConnect();
		String sql = "insert into ffse1702026_user (maKH, name, address, phone, email, phuong, quan, macongto) values (?,?,?,?,?,?,?,?)";
		Statement statement = (Statement) conn.createStatement();
		ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, maKhackHang);
		ptmt.setString(2, tenKhachHang);
		ptmt.setString(3, diaChi);
		ptmt.setString(4, phone);

		ptmt.setString(5, email);
		ptmt.setString(6, phuong);
		ptmt.setString(7, quan);
		ptmt.setString(8, maCongTo);
		int kt = ptmt.executeUpdate();

	}

	public static void upDate(String maKhackHang, String tenKhachHang, String quan, String phuong, String diaChi,
			String phone, String email, String maCongTo) throws SQLException {
		Connection conn = connectdb.getConnect();
		String sql = "update ffse1702026_user set maKH=?, name=?, address=?, phone=?, email=?, phuong=?, quan=?, macongto=?  where maKH=?";
		Statement statement = (Statement) conn.createStatement();
		ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, maKhackHang);
		ptmt.setString(2, tenKhachHang);
		ptmt.setString(3, diaChi);
		ptmt.setString(4, phone);

		ptmt.setString(5, email);
		ptmt.setString(6, phuong);
		ptmt.setString(7, quan);
		ptmt.setString(8, maCongTo);
		ptmt.setString(9, maKhackHang);
		int kt = ptmt.executeUpdate();

	}

	public static void del(String maKhackHang) throws SQLException {
		Connection conn = connectdb.getConnect();
		String sql = "delete from ffse1702026_user where maKH=?";
		Statement statement = (Statement) conn.createStatement();
		ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, maKhackHang);
		int kt = ptmt.executeUpdate();

	}

	public static ArrayList<KhachHang> getList() throws SQLException {
		ArrayList<KhachHang> list = new ArrayList<>();
		Connection conn = connectdb.getConnect();
		String sql = "select * from ffse1702026_user";
		Statement statement = (Statement) conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			KhachHang kh = new KhachHang(result.getString("maKH"), result.getString("name"), result.getString("quan"),
					result.getString("phuong"), result.getString("address"), result.getString("phone"),
					result.getString("email"), result.getString("macongto"));
			list.add(kh);
		}
		return list;
	}
	public static ArrayList<KhachHang> getSearch(String search) throws SQLException {
		ArrayList<KhachHang> list = new ArrayList<>();
		Connection conn = connectdb.getConnect();
		String sql = "select * from ffse1702026_user where maKH like  '%"+search +"%' or "+"name like '%"+search+"%'";
		Statement statement = (Statement) conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			KhachHang kh = new KhachHang(result.getString("maKH"), result.getString("name"), result.getString("quan"),
					result.getString("phuong"), result.getString("address"), result.getString("phone"),
					result.getString("email"), result.getString("macongto"));
			list.add(kh);
		}
		return list;
	}

	public static ArrayList<KhachHang> getInfo(String sql) throws SQLException {
		ArrayList<KhachHang> list = new ArrayList<>();
		Connection conn = connectdb.getConnect();
		Statement statement = (Statement) conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			KhachHang kh = new KhachHang(result.getString("maKH"), result.getString("name"), result.getString("quan"),
					result.getString("phuong"), result.getString("address"), result.getString("phone"),
					result.getString("email"), result.getString("macongto"));
			list.add(kh);
		}
		return list;
	}

}
