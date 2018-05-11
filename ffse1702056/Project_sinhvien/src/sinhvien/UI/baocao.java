package sinhvien.UI;

import java.awt.Color;
import java.awt.Component;
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
public class baocao {
	static JPanel panelAll = new JPanel();
	JPanel pnAll = new JPanel();
	private JTable jtable = new JTable();
	private JTable jtable1 = new JTable();
	private DefaultTableModel tableModelLH = new DefaultTableModel();
	JButton btn_dslop,btn_trungbinh;
	String id;
	JTextField text;
	JTextField text51,text52,text53;
	JLabel a11,a,a12,a13 ;
	
	String nam[] = { "2017", "2018", "2019"};
	JComboBox jcnam = new JComboBox(nam);
	JComboBox jclop = new JComboBox();
	JPanel boxa = new JPanel();

	JLabel c = new JLabel("Năm :");
	JLabel aa = new JLabel("Lớp :");
	
	private Connection connect = null;
	JComboBox jcombomon,jcomboki;
	public baocao() {
		super();
		hienthi();
		event();
	}
	
	

	private void hienthi() {
		jcombomon = new JComboBox();
		JLabel mon = new JLabel("Môn :");
		JPanel pna = new JPanel();
		
		jcomboki = new JComboBox();
		JLabel ki = new JLabel("Kì : ");
		JPanel pnhk = new JPanel();
		
		
		pnAll.setLayout(new BoxLayout(pnAll, BoxLayout.Y_AXIS));
		
		JPanel pn1 = new JPanel();
		pn1.setLayout(new BoxLayout(pn1, BoxLayout.Y_AXIS));
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(new BoxLayout(pn2, BoxLayout.X_AXIS));
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
		
		JPanel pn4 = new JPanel();
		pn4.setLayout(new BoxLayout(pn4, BoxLayout.Y_AXIS));
		
		JPanel pn41 = new JPanel();
		pn41.setLayout(new BoxLayout(pn41, BoxLayout.Y_AXIS));
		
		JPanel pn42 = new JPanel();
		pn42.setLayout(new BoxLayout(pn42, BoxLayout.Y_AXIS));
		
	
		btn_trungbinh = new JButton("Xem Điểm trung bình");
	
		
	
		
		jtable.setModel(tableModelLH);
	
		
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		boxa.add(c);
		boxa.add(jcnam);
		boxa.add(aa);
		boxa.add(jclop);
		
		
		
		
		
		
		pn2.add(boxa);
	
		boxa.add(btn_trungbinh);
		
		pn42.add(pna);
		pn42.add(pnhk);
		
		pn4.add(pn42);
		pnAll.add(pn1);
		pnAll.add(pn2);
		pnAll.add(pn3);
		pnAll.add(pn4);
		JScrollPane scroll = JTable.createScrollPaneForTable(jtable);
		
		pn3.add(scroll);
		
		
		connectSQL(); 
		
		
		

	}
	
	private void event() {
		jcnam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDatalop(lop());
			}
		});
		jclop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllTableRows(jtable);
				update(ds());
			}
		});
		btn_trungbinh.addActionListener(xemdiem);
		
	}
	
	
	
	public ResultSet ds() {
		String cc = (String) jclop.getSelectedItem();
		ResultSet result2 = null;
		String sql = "SELECT sinhvien.lop,COUNT(sinhvien.maSV ) FROM sinhvien WHERE sinhvien.lop = '"+cc+"'";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result2;

	}
public void update(ResultSet result2) {
	String[] colsName = { "Tên Lớp", "Số Lượng Học Viên Đang Theo Học" };
	tableModelLH.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName

	try {
		while (result2.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
			String rows[] = new String[2];
			rows[0] = result2.getString(1);
			rows[1] = result2.getString(2);
			
			

			tableModelLH.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên

			// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
			// trên frame
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

}
	


	ActionListener xemdiem = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			deleteAllTableRows(jtable);
			updateData(xemdiem());
		}
		};
		
		public void updateDatalop(ResultSet resultlop) {
			Vector<String> datalop = new Vector<String>();
			try {
				while (resultlop.next()) {
					datalop.addElement(resultlop.getString(1));
					jclop.setModel(new DefaultComboBoxModel<>(datalop));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public ResultSet lop() {
			String nam = (String) jcnam.getSelectedItem();

			ResultSet resultlop = null;
			String sql = "SELECT lophoc.lop FROM `lophoc` WHERE lophoc.nam = '"+nam+"'";
			try {
				Statement statement = (Statement) connect.createStatement();
				return statement.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return resultlop;
		}
		public ResultSet xemdiem() {
			ResultSet result = null;
			String sql = "SELECT diemsinhvien.mssv1, SUM(CASE WHEN diemsinhvien.monhoc='LP#1' THEN diemsinhvien.diem END) AS 'LP1', SUM(CASE WHEN diemsinhvien.monhoc='LP#2' THEN diemsinhvien.diem END) AS 'LP2', SUM(CASE WHEN diemsinhvien.monhoc='LP#3' THEN diemsinhvien.diem END) AS 'LP3', SUM(CASE WHEN diemsinhvien.monhoc='LP#4' THEN diemsinhvien.diem END) AS 'LP4', SUM(CASE WHEN diemsinhvien.monhoc='LP#5' THEN diemsinhvien.diem END) AS 'LP5', SUM(CASE WHEN diemsinhvien.monhoc='LP#6' THEN diemsinhvien.diem END) AS 'LP6', SUM(CASE WHEN diemsinhvien.monhoc='ELC' THEN diemsinhvien.diem END) AS 'ELC', SUM(CASE WHEN diemsinhvien.monhoc='E4IT' THEN diemsinhvien.diem END) AS 'E4IT', ROUND(SUM(diemsinhvien.diem)/7,1) AS 'AVG' FROM diemsinhvien GROUP BY diemsinhvien.mssv1";
			try {
				Statement statement = (Statement) connect.createStatement();
				return statement.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;

		}
public void updateData(ResultSet result) {
		String[] colsName = { "Mã sinh viên", "LP1", "LP2", "LP3", "LP4", "LP5", "LP6", "ELC", "E4IT","AVG" };
		tableModelLH.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName

		try {
			while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[10];
				rows[0] = result.getString(1);
				rows[1] = result.getString(2);
				rows[2] = result.getString(3);
				rows[3] = result.getString(4);
				rows[4] = result.getString(5);
				rows[5] = result.getString(6);
				rows[6] = result.getString(7);
				rows[7] = result.getString(8);
				rows[8] = result.getString(9);
				rows[9] = result.getString(10);
				

				tableModelLH.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên

				// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
				// trên frame
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
		private void deleteAllTableRows(JTable jtable) {
			DefaultTableModel tableModelLH = (DefaultTableModel) jtable.getModel();
			while (tableModelLH.getRowCount() > 0) {
				tableModelLH.removeRow(0);
			}
		}

		public void connectSQL() {
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

		}
	
	}