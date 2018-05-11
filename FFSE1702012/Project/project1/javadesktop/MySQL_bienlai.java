package project1.javadesktop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

public class MySQL_bienlai {
	private static Connection conn = Connection_Database.Ketnoi();
	private static PreparedStatement ptmt = null;
	public static void add_Bienlai(String hoten, String mact, String day, int month, int year, int csct, double tiendien, String quan, String phuong, String Selecttime)
	{
		String sql = "insert into BienLai(Username,Macongto,Ngaynhap,Thang,Nam,Chiso,Tiendien, Quan, Phuong,Selecttime) value (?,?,?,?,?,?,?,?,?,?)";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, hoten);
			ptmt.setString(2, mact);
			ptmt.setString(3, day);
			ptmt.setInt(4, month);
			ptmt.setLong(5, year);
			ptmt.setLong(6, csct);
			ptmt.setDouble(7, tiendien);
			ptmt.setString(8, quan);
			ptmt.setString(9, phuong);
			ptmt.setString(10, Selecttime);
			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				JOptionPane.showMessageDialog(null, "Thêm thành công");
			} else
				JOptionPane.showMessageDialog(null, "Thêm không thành công");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Loi " + e1.getMessage());
		}
	}
	public static void search_bienlai(String mact)
	{
		int countrow = QuanLyBienLai.tbmodel.getRowCount();
		if(countrow >0)
		{
			for(int i = countrow - 1;i>=0;i--)
			{
				QuanLyBienLai.tbmodel.removeRow(i);
			}
		}
//		QuanLyBienLai.tbmodel.removeRow(row);
		String sql = "select * from BienLai where Macongto = '" + mact + "'";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				String mact1 = rs.getString("Macongto");
				String hoten = rs.getString("Username");
				Date date = rs.getDate("Ngaynhap");
				int thang = rs.getInt("Thang");
				int nam = rs.getInt("Nam");
				int chiso = rs.getInt("Chiso");
				Object[] row = {mact1,hoten,date,thang,nam,chiso};
				QuanLyBienLai.tbmodel.addRow(row);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * update du lieu len database voi table BienLai
	 */
	public static void update_bienlai(String hoten, String mact, String day, int month, int year, int csct, double tiendien)
	{
		String sql = "update BienLai set Username = ?,Macongto = ?,Ngaynhap = ?,Thang = ?,Nam = ?,Chiso= ?,Tiendien = ? where Macongto = '" + mact +"' and Thang = " + month;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, hoten);
			ptmt.setString(2, mact);
			ptmt.setString(3, day);
			ptmt.setInt(4, month);
			ptmt.setInt(5, year);
			ptmt.setInt(6, csct);
			ptmt.setDouble(7, tiendien);
					int kt = ptmt.executeUpdate();
			if (kt != 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
			} else
				JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi" +e);
		}
	}
	/*
	 * xoa du lieu database_Bienllai
	 */
	public static void Del_bienlai(int month)
	{
		String sql = "delete  from BienLai where Thang = " + month;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			} else
				JOptionPane.showMessageDialog(null, "Xóa không thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi" +e);
		}
	}
	/*
	 * update tien dien cho tat ca cac thang sau khi một tháng bat ky trươc đo update tien dien:
	 */
	public static void update_tiendien(String mct, int month, int endmonth, int year)
	{
		String sql = "select * from BienLai where Macongto = '" + mct + "'and Thang > " + (month) + " and Thang <=" + (endmonth) + " and Nam = " + year;
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				double tiendien = BienLai.getTien(rs.getInt("Chiso"), mct, rs.getInt("Thang"), year);
				String sql1 = "update BienLai set Tiendien = ? where Macongto = '" + mct +"' and Thang = " + rs.getInt("Thang");
				try {
					ptmt = (PreparedStatement) conn.prepareStatement(sql1);
					ptmt.setDouble(1, tiendien);
					ptmt.executeUpdate();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Lỗi" +e);
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi" +e1);
		}
	}
}
