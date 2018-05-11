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
public class QLLH extends JFrame {
	static JPanel panelAll = new JPanel();
	JPanel pnAll = new JPanel();
	private JTable jtable = new JTable();
	
	private DefaultTableModel tableModelLH = new DefaultTableModel();
	JButton btn_xemSV, btn_xemdiem, btn_them;
	String id;
	JTextField nhapdiem;
	JTextField nhapki, nhapmon, nhapma;
	JLabel Lbki, Lbdiem, Lbmon, Lbma;
	String country[] = { "FFSE1702", "FFSE1703", "FFSE1704", "FFSE1801", "FFSE1802" };
	JComboBox lop = new JComboBox(country);
	JPanel boxa = new JPanel();
	JLabel ab = new JLabel("Chọn Lớp :");
	private Connection connect = null;
	JComboBox jcombomon, jcomboki;

	public QLLH() {
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

		btn_xemSV = new JButton("Xem DS Sinh Viên");
		btn_them = new JButton("Xem Điểm");
		btn_xemdiem = new JButton("Thêm Điểm");
		
		btn_xemdiem.setVisible(false);

		Lbki = new JLabel("Kì :");
		nhapki = new JTextField(10);
		nhapki.setVisible(false);
		
		Lbki.setVisible(false);

		Lbmon = new JLabel("Môn :");
		nhapmon = new JTextField(10);
		nhapmon.setVisible(false);
		
		Lbmon.setVisible(false);

		Lbma = new JLabel("Mã số SV :");
		nhapma = new JTextField(10);
		nhapma.setVisible(false);
		
		Lbma.setVisible(false);

		Lbdiem = new JLabel("Điểm :");
		nhapdiem = new JTextField(10);
		nhapdiem.setVisible(false);
		
		Lbdiem.setVisible(false);

		jtable.setModel(tableModelLH);

		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		boxa.add(ab);
		boxa.add(lop);

		pna.add(Lbma);
		pna.add(nhapma);
		pna.add(Lbki);
		pna.add(nhapki);
		pn2.add(boxa);
		boxa.add(btn_xemSV);
		boxa.add(btn_them);

		pna.add(Lbmon);
		pna.add(nhapmon);

		pna.add(Lbdiem);
		pna.add(nhapdiem);
		pna.add(btn_xemdiem);

		pn42.add(pna);
		pn42.add(pnhk);

		pn4.add(pn42);
		pnAll.add(pn1);
		pnAll.add(pn2);
		pnAll.add(pn3);
		pnAll.add(pn4);
		JScrollPane scroll = JTable.createScrollPaneForTable(jtable);

		pn3.add(scroll);

		connectSQL2(); // kết nối cơ sở dữ liệu

		updateData(xemSV());

		// updateDatamon(mon());
		// updateDataki(ki());
		//
	}

	private void event() {
		jcomboki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// updateDatamon(mon());

			}

		});
		lop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAllTableRows(jtable);
				some();
				update(some());
			}
		});
		btn_xemSV.addActionListener(eventAdd);
		btn_xemdiem.addActionListener(themdiem);
		btn_them.addActionListener(viewds);
		jtable.addMouseListener(eventDataToTextField);
	}

	MouseListener eventDataToTextField = new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			getDataToTextField();
		}
	};

	void getDataToTextField() {
		int row = jtable.getSelectedRow();
		id = (String) tableModelLH.getValueAt(row, 0);

		nhapki.setText((String) jtable.getValueAt(row, 3));
		nhapmon.setText((String) jtable.getValueAt(row, 4));
		nhapma.setText((String) jtable.getValueAt(row, 1));
		nhapdiem.setText((String) jtable.getValueAt(row, 5));
	}

	public ResultSet some() {
		String a = (String) lop.getSelectedItem();
		ResultSet result2 = null;
		String sql = "SELECT id,maSV,tenSV,lop,email FROM sinhvien Where lop = '" + a + "'";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result2;

	}

	public void update(ResultSet result2) {
		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Lớp", "Email" };
		tableModelLH.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName

		try {
			while (result2.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[5];
				rows[0] = result2.getString(1);
				rows[1] = result2.getString(2);
				rows[2] = result2.getString(3);
				rows[3] = result2.getString(4);
				rows[4] = result2.getString(5);

				tableModelLH.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên

				// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
				// trên frame
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private String setText(String valueAt) {
		// TODO Auto-generated method stub
		return null;
	}

	ActionListener themdiem = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			deleteAllTableRows(jtable);

			addInfo(id.toString());
			updateData1(viewdiem());
		}
	};

	public void addInfo(String id) {
		String ma = nhapma.getText();
		String ki = nhapki.getText();
		String mon = nhapmon.getText();
		String diem = nhapdiem.getText();

		try {

			String sql = "UPDATE `diemsinhvien` SET `mssv1`='" + ma + "',`hocki`='" + ki + "',`monhoc`='" + mon
					+ "',`diem`='" + diem + "' WHERE id='" + id + "'";
			Statement statement = connect.createStatement();
			int x = statement.executeUpdate(sql);

			if (x > 0) {
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	ActionListener eventAdd = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			deleteAllTableRows(jtable);
			updateData(xemSV());
			btn_xemdiem.setVisible(false);
			nhapki.setVisible(false);
			Lbki.setVisible(false);
			nhapmon.setVisible(false);
			Lbmon.setVisible(false);
			Lbma.setVisible(false);
			nhapma.setVisible(false);
			nhapdiem.setVisible(false);
			Lbdiem.setVisible(false);

		}
	};
	ActionListener viewds = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			btn_xemdiem.setVisible(true);
			nhapki.setVisible(true);
			Lbki.setVisible(true);
			nhapmon.setVisible(true);
			Lbmon.setVisible(true);
			Lbma.setVisible(true);
			nhapma.setVisible(true);
			nhapdiem.setVisible(true);
			Lbdiem.setVisible(true);

			btn_xemdiem.setEnabled(true);
			nhapki.setEnabled(false);
			Lbki.setEnabled(true);
			nhapmon.setEnabled(false);
			Lbmon.setEnabled(true);
			Lbma.setEnabled(true);
			nhapma.setEnabled(false);
			nhapdiem.setVisible(true);
			Lbdiem.setVisible(true);
			
			deleteAllTableRows(jtable);
			updateData1(viewdiem());

		}

	};

	public ResultSet xemSV() {
		ResultSet result = null;
		String sql = "SELECT id,maSV,tenSV,lop,email FROM sinhvien";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public void updateData(ResultSet result) {
		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Lớp", "Email" };
		tableModelLH.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName

		try {
			while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[5];
				rows[0] = result.getString(1);
				rows[1] = result.getString(2);
				rows[2] = result.getString(3);
				rows[3] = result.getString(4);
				rows[4] = result.getString(5);

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

	// điểm
	public void updateData1(ResultSet result1) {
		String[] colsName = { "ID", "Mã SV", "Tên SV", "Học kì", "Môn học", "Điểm" };
		tableModelLH.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName

		try {
			while (result1.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[6];
				rows[0] = result1.getString(1);
				rows[1] = result1.getString(2);
				rows[2] = result1.getString(3);
				rows[3] = result1.getString(4);
				rows[4] = result1.getString(5);
				rows[5] = result1.getString(6);

				tableModelLH.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên

				// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
				// trên frame

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ResultSet viewdiem() {
		ResultSet result1 = null;
		String sql = "SELECT diemsinhvien.id,mssv1,sinhvien.tenSV,hocki,monhoc,diem FROM diemsinhvien LEFT JOIN sinhvien ON sinhvien.maSV = diemsinhvien.mssv1 UNION SELECT  diemsinhvien.id,mssv1,sinhvien.tenSV,hocki,monhoc,diem FROM diemsinhvien RIGHT JOIN sinhvien ON sinhvien.maSV = diemsinhvien.mssv1";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result1;

	}

	// het
	private void connectSQL2() {
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