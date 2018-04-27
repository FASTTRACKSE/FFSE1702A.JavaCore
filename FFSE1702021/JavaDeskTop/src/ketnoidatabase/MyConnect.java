package ketnoidatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyConnect extends JFrame {
	private Connection connect = null;

	private JTable jtable = new JTable();
	private DefaultTableModel mdTable = new DefaultTableModel();

	public MyConnect() {
		
		String dm[] = { "ID", "Name", "Poin" };
		mdTable.setColumnIdentifiers(dm);
		jtable.setModel(mdTable);
		showl();
		connect();
		update(view());
	}

	public void update(ResultSet result) {
		try {
			while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[4];
				rows[0] = result.getString(1);
				rows[1] = result.getString(2);
				rows[2] = result.getString(3);
				
				mdTable.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
				// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
				// trên frame
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = new String("jdbc:mysql://localhost:3306/lp4");
			try {
				connect = DriverManager.getConnection(url, "lp4", "1234");
				System.out.println("Kết nối thành công");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ResultSet view() {
		ResultSet result = null;
		String sql = "SELECT * FROM SinhVien";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void showl() {
		this.setSize(600, 400);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JScrollPane scroll = JTable.createScrollPaneForTable(jtable);   
        this.add(scroll); // Đưa thanh cuộn vào Frame (hiện thanh cuộn trên frame)
		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MyConnect();
	}

}
