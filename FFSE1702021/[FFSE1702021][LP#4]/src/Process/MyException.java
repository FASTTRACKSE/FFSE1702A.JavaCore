package Process;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Data.Connect;

public class MyException extends Exception {
	Connect cn = new Connect();
	static Connection conn = (Connection) Connect.getConnect();
	
	public MyException() {
		super();
	}
	public static boolean ChekEmpty(String str) throws MyException {
		if(str.equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			return false;
		}
		return true;
		
	}
	public static boolean ChekSo(String str) throws MyException {
		if(str.equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			return false;
		}else {
			try {
				Integer.parseInt(str);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số!");
				return false;
			}
			}
		int so = Integer.parseInt(str);
		if(so <0) {
			JOptionPane.showMessageDialog(null, "Không được số âm!");
			return false;
		}
		return true;
			
		
	}
	public static boolean ChekMSach(String str) throws MyException {
		try {
		String sql = "select ma_s from QuanLy_Sach ";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(1))) {
				JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
}
	public static boolean ChekMBDoc(String str) throws MyException {
		try {
		String sql = "select Matv from BanDoc ";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(1))) {
				JOptionPane.showMessageDialog(null, "Mã thành viên đã tồn tại!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
}
	public static boolean ChekEmail(String str) throws MyException {
		try {
		String sql = "select email from BanDoc ";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(4))) {
				JOptionPane.showMessageDialog(null, "Email  đã tồn tại!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
}
	public static boolean ChekMPM(String str) throws MyException {
		try {
		String sql = "select ma_gd from Phieu_Muon ";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(1))) {
				JOptionPane.showMessageDialog(null, "Mã giao dịch đã tồn tại!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
}
	
	public static boolean ChekNgay(Date date) {
		if(date==null) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			return false;
		}
		return true;
	}
//	public static boolean ChekMPM1(String str) throws MyException {
//		try {
//		String sql = "select ma_gd from Phieu_Muon ";
//		Statement statement = conn.createStatement();
//		ResultSet result = statement.executeQuery(sql);
//		while (result.next()) {
//			if (str.equals(result.getString(1))) {
//				
//				return true;
//			}
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//		return false;
//}
	public static boolean ChekTraSach(String str) throws MyException {
		try {
		String sql = "select tinh_trang from Phieu_Muon ";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(5))) {
				JOptionPane.showMessageDialog(null, "Đã trả!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return true;
		
}
//	public static boolean ChekTK(String str) throws MyException {
//		try {
//		String sql = "select username from dang_nhap ";
//		Statement statement = conn.createStatement();
//		ResultSet result = statement.executeQuery(sql);
//		while (result.next()) {
//			if (str.equals(result.getString(1))) {
//				
//				
//				
//				return true;
//			}
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//		JOptionPane.showMessageDialog(null, "Tên đăng nhập chưa đúng!");
//		return false;
//		
//}
//	public static boolean ChekMK(String str) throws MyException {
//		try {
//		String sql = "select password from dang_nhap ";
//		Statement statement = conn.createStatement();
//		ResultSet result = statement.executeQuery(sql);
//		while (result.next()) {
//			if (str.equals(result.getString(2))) {
//				
//				
//				
//				return true;
//			}
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//		JOptionPane.showMessageDialog(null, "Mật khẩu chưa đúng!");
//		return false;
//		
//}
}
