package project1.javadesktop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.regexp.internal.recompile;

public class MySQL_khachhang {
	private static Connection conn = Connection_Database.Ketnoi();
	private static PreparedStatement ptmt = null;
	private static String cottieude, key, sosanh;

	/*
	 * phuong thuc lay danh sach ten quan
	 */
	public static void getQuan(String chuoi) {

		String sql = "select  *  from Quan";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if(chuoi == "InformationCustomer")
			{
				InformationCustomer.cbquan.addItem("Chọn Quận");
				while (rs.next()) {
	
					InformationCustomer.cbquan.addItem(rs.getString("Quan"));
				}
			}
			else if(chuoi == "Bienlai")
			{
				QuanLyBienLai.cbquan.addItem("Chọn Quận");
				while (rs.next()) {
	
					QuanLyBienLai.cbquan.addItem(rs.getString("Quan"));
				}
			}
			else if(chuoi == "DSkhachhang")
			{
				DSkhachhang.cbquan.addItem("Chọn Quận");
				while(rs.next())
					
				DSkhachhang.cbquan.addItem(rs.getString("Quan"));
			}
			else if(chuoi == "DSthutiendien")
			{
				DSthutiendien.cbquan.addItem("Chọn Quận");
				while(rs.next())
					
				DSthutiendien.cbquan.addItem(rs.getString("Quan"));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("loi" + e);
		}
	}

	/*
	 * get id cua Quan
	 */
	public static int getQuanID(String Name) {
		int Quan_id = 0;	
		String sql = "select * from Quan where Quan = '" + Name + "'";

		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				Quan_id = rs.getInt("Id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("loi" + e);
		}
		return Quan_id;
	}

	/*
	 * add du lieu vao database _ Table InformationKhachhang:
	 */
	public static void add_Khachhang(String makh, String hoten, String diachi, String phuong, String quan, String sdt,
			String email, String mact) {

		String sql = "insert into Customer(Makh,Username, Address, Phuong, Quan,Phone,Email,Macongto) value (?,?,?,?,?,?,?,?)";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, makh);
			ptmt.setString(2, hoten);
			ptmt.setString(3, diachi);
			ptmt.setString(4, phuong);
			ptmt.setString(5, quan);
			ptmt.setString(6, sdt);
			ptmt.setString(7, email);
			ptmt.setString(8, mact);

			/*
			 * them, sửa, xóa => executeUpdate; select(hien thi dữ liệu) =>executeQuery:
			 */
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

	/*
	 * select du lieu ra tu database:
	 */
	public static void select_Khachhang(String cottieude, String key, String sosanh, String sql1) {
		InformationCustomer.tbmodel.setRowCount(0);
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql1);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
	
				// them vao tablemodel
				String makh = rs.getString(2);
				String hoten =  rs.getString(3);
				String diachi = rs.getString(4);
				String phuong = rs.getString(5);
				String quan = rs.getString(6);
				String sdt =  rs.getString(7);
				String email = rs.getString(8);
				String mct = rs.getString(9);
				String[] row = { makh, hoten, diachi, quan, phuong, sdt, email, mct };
				InformationCustomer.tbmodel.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * update du lieu vao database;
	 */
	public static void update_Khachhang(String makh, String hoten, String diachi, String phuong, String quan,
			String sdt, String email, String mact) {
		// update trong database: Customer(Makh,Username, Address, Phuong,
		// Quan,Phone,Email,Macongto
		String sql = "update Customer set Makh =?, Username = ?, Address = ?, Phuong = ?, Quan = ?, Phone = ?, Email = ?, Macongto = ? where Makh = ?";
		try {

			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, makh);
			ptmt.setString(2, hoten);
			ptmt.setString(3, diachi);
			ptmt.setString(4, phuong);
			ptmt.setString(5, quan);
			ptmt.setString(6, sdt);
			ptmt.setString(7, email);
			ptmt.setString(8, mact);
			ptmt.setString(9, makh);
			int k = ptmt.executeUpdate();
			if(k!=0)
			{
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
			}
			else
				JOptionPane.showMessageDialog(null, "Cập nhật không thành công");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Loi " + e1.getMessage());

		}
	}

	/*
	 * phuong thuc xoa du lieu:
	 */
	public static void del_Khachhang(String makh) {
		String sql = "delete from Customer where Makh = ?";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, makh);
			int k = ptmt.executeUpdate();
			if(k!=0)
			{
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			}
			else
				JOptionPane.showMessageDialog(null, "Xóa không thành công");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Loi " + e1.getMessage());
		}
	}
}
