package project1.javadesktop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class MySQL_thongke {
	private static Connection conn = Connection_Database.Ketnoi();
	private static PreparedStatement ptmt = null;
	
	public static void search_dskh(String sql1)
	{	
		int rowcount1 = DSkhachhang.tbmodel.getRowCount();
		if (rowcount1 > 0) {
			for (int i = rowcount1 - 1; i >= 0; i--) {
				DSkhachhang.tbmodel.removeRow(i);
			}
		}
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql1);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				String makh = rs.getString("Makh");
				String hoten = rs.getString("Username");
				String diachi = rs.getString("Address");
				String phuong1 = rs.getString("Phuong");
				String quan1 = rs.getString("Quan");
				String sdt = rs.getString("Phone");
				String email1 = rs.getString("Email");
				String mct = rs.getString("Macongto");
				String[] row = { makh, hoten, diachi, quan1, phuong1, sdt, email1, mct };
				DSkhachhang.tbmodel.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi" + e);
		}
	}
	
	/*
	 * lay danh sach thu tien dien
	 */
	public static void search_dstiendien(String sql1)
	{	
		int rowcount1 = DSthutiendien.model.getRowCount();
		if (rowcount1 > 0) {
			for (int i = rowcount1 - 1; i >= 0; i--) {
				DSthutiendien.model.removeRow(i);
			}
		}
		if(sql1.length()>0)
		{
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql1);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				String mact1 = rs.getString("Macongto");
				String hoten = rs.getString("Username");
				Date date = rs.getDate("Ngaynhap");
				int thang = rs.getInt("Thang");
				int nam = rs.getInt("Nam");
				int chiso = rs.getInt("Chiso");
				double tiendien = rs.getDouble("Tiendien");
				Object[] row = {mact1,hoten,date,thang,nam,chiso,tiendien};
				DSthutiendien.model.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi" + e);
		}
		}
	}
}
