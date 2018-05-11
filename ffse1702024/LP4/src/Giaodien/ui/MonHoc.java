package Giaodien.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

public class MonHoc extends JFrame { 
	JPanel panelAll = new JPanel();
	private JTable jtable = new JTable();
	private DefaultTableModel tableModelMH = new DefaultTableModel();
	private Connection connect = null;
	JTextField  maMH,tenMH,time,tinchi,hk;
	private JButton btn_Ad, btn_update, btn_Dele;
	String idd;
	public MonHoc() {
		super();
		giaodien();
		addEvents();

	}

private ResultSet giaodien() {
	
	panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.Y_AXIS));
	
	JPanel pn2 = new JPanel();
	pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));
	
	JPanel pn3 = new JPanel();
	pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
	
	JPanel pn31 = new JPanel();
	pn31.setLayout(new BoxLayout(pn31, BoxLayout.X_AXIS));
	
	JPanel pn32 = new JPanel();
	pn32.setLayout(new BoxLayout(pn32, BoxLayout.X_AXIS));
	JPanel pn33 = new JPanel();
	pn33.setLayout(new BoxLayout(pn33, BoxLayout.X_AXIS));
	
	
	
	pn3.add(pn31);
	 pn3.add(pn32);
	 pn3.add(pn33);
	 
	
	JLabel btn_c = new JLabel("Thông Tin Môn Học");
	btn_c.setForeground(Color.red);
	JPanel pn1 = new JPanel();
	pn1.setLayout(new BoxLayout(pn1, BoxLayout.Y_AXIS));
	
	pn1.add(btn_c);
	

	
	
	

	

	

	panelAll.add(pn1);
	panelAll.add(pn2);
	panelAll.add(pn3);
	
	
	
	jtable.setModel(tableModelMH);
	jtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	
	pn1.add(jtable);
	JScrollPane scroll = JTable.createScrollPaneForTable(jtable);
	pn1.add(scroll);
	
	connectSQL1(); // kết nối cơ sở dữ liệu
	updateData(viewMH());


	return null;
}
public void updateData(ResultSet result) {
	String[] colsName = { "ID","Mã MH","Học kì", "Tên MH", "Số tín chỉ", "Thời gian học"};
	tableModelMH.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName

	try {
		while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
			String rows[] = new String[6];
			rows[0] = result.getString(1);
			rows[1] = result.getString(2);
			rows[2] = result.getString(3);
			rows[3] = result.getString(4);
			rows[4] = result.getString(5);
			rows[5] = result.getString(6);

			tableModelMH.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên

			// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
			// trên frame
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

}
		
	public ResultSet viewMH() {
		ResultSet resultMH = null;
		String sql = "SELECT * FROM monhoc";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMH;

	}
	

public void  addMH() {
	

}
public void UDMH(String idd) {

}
private void addEvents() {

	
		
	}
private void connectSQL1() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = new String("jdbc:mysql://localhost:3306/quangnc1?useUnicode=true&characterEncoding=utf-8");
		try {
			connect = DriverManager.getConnection(url, "quangnc1", "abc123");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

}

		
	}




