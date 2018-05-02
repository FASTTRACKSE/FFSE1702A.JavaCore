package QLSV_Main;

import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class AppJava {
	public static void main(String args[]) {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "tungtt", "12345");
			System.out.println("Kết nối thành công");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM student");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) +" "+ rs.getString(4));

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}