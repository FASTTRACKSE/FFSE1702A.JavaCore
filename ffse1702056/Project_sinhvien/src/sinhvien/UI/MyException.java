package sinhvien.UI;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class MyException extends Exception{
	private String error;
	private String errHoTen;
	static Connection connect = null;
	
	
	public MyException() {
	
		
	}

	public MyException(String errHoTen) {
		this.errHoTen = errHoTen;
		
	}

	@Override
	public String toString() {
		return this.errHoTen;

	}

	static public boolean chkTrong(String str) throws MyException {
	if (str.equals("")) {
		JOptionPane.showMessageDialog(null,"Nhập đầy đủ thông tin");
		return false;
	}
	return true ; 
}
	public static boolean ChekMaSV(String str) throws MyException {
		
		try {
		connectSQL(); 
		String sql = "select maSV from sinhvien";
		Statement statement = (Statement) connect.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			if (str.equals(result.getString(1))) {
				JOptionPane.showMessageDialog(null, "Mã sinh viên đã tồn tại!");
				return false;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
}
	public static void connectSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = new String("jdbc:mysql://localhost:3306/sinhvien?useUnicode=true&characterEncoding=utf-8");
			try {
				connect = DriverManager.getConnection(url, "sinhvien", "1234");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}}
