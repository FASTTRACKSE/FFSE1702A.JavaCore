package sinhvien.UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.MarshalException;
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

public class quanlisinhvienUI extends JFrame {
	private Connection connect = null;
	private JTable jtable = new JTable();
	QLMH monhoc = new QLMH();
	QLLH lophoc = new QLLH();
	baocao baocao = new baocao();
	JTextField timkiem;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btn_Add, btn_Edit, btn_Dele, btn_Save;
	JTextField maSV, tenSV, tuoiSV, nha, dienthoai, email;
	String country[] = { "FFSE1702", "FFSE1703", "FFSE1704", "FFSE1801", "FFSE1802" };
	String id, mssv;
	String lop, age, adress, name, sdt, mail, cbtinh, cbhuyen, cbxa;
	String checkMa;
	
	JButton btn_timkiem;
	JComboBox jcomboClass = new JComboBox(country);
	JPanel boxa = new JPanel();
	JLabel ab = new JLabel("Lớp :         ");

	JPanel boxb = new JPanel();

	JLabel tinh = new JLabel("Tỉnh(TP) :     ");

	JComboBox jcomboTinh = new JComboBox();
	JPanel boxc = new JPanel();
	JLabel huyen = new JLabel("Huyện(Quận) :     ");
	JComboBox jcomboHuyen = new JComboBox();

	JLabel xa = new JLabel("Xã(Phường) :     ");
	JComboBox jcomboXa = new JComboBox();

	public quanlisinhvienUI(String title) {
		super(title);
		createGUI();
		addEvents();

	}

	private void createGUI() {
		add(createTabbedPane());
	}

	private JTabbedPane createTabbedPane() {

		Container con = getContentPane();
		JPanel boxAll = new JPanel();
		boxAll.setLayout(new BoxLayout(boxAll, BoxLayout.Y_AXIS));

		con.add(boxAll);
		JPanel boxa = new JPanel();
		JLabel ab = new JLabel("Lớp :     ");

		JPanel box1 = new JPanel();
		JLabel a = new JLabel("Mã sinh viên :     ");
		maSV = new JTextField(20);
	
		box1.add(a);
		box1.add(maSV);

		JPanel box2 = new JPanel();
		JLabel a1 = new JLabel("Tên sinh viên :  ");
		tenSV = new JTextField(20);
	
		box2.add(a1);
		box2.add(tenSV);

		JPanel box3 = new JPanel();
		JLabel a2 = new JLabel("Tuổi sinh viên : ");
		tuoiSV = new JTextField(20);
		
		box3.add(a2);
		box3.add(tuoiSV);

		JPanel box4 = new JPanel();
		JLabel a3 = new JLabel("Số nhà :         ");
		
		nha = new JTextField(20);
		box4.add(a3);
		box4.add(nha);

		JPanel box5 = new JPanel();
		JLabel a4 = new JLabel("Điện thoại :       ");
		dienthoai = new JTextField(20);
		box5.add(a4);
		
		box5.add(dienthoai);

		JPanel box6 = new JPanel();
		JLabel a5 = new JLabel("Email :           ");
		email = new JTextField(20);
		
		box6.add(a5);
		box6.add(email);
		a3.setPreferredSize(a.getPreferredSize());
		a1.setPreferredSize(a.getPreferredSize());
		a2.setPreferredSize(a.getPreferredSize());
		a4.setPreferredSize(a.getPreferredSize());
		a5.setPreferredSize(a.getPreferredSize());

		JPanel box7 = new JPanel();
		JLabel a11 = new JLabel("Tìm theo mã SV :           ");
		timkiem = new JTextField(20);
		
		box7.add(a11);
		box7.add(timkiem);

		btn_timkiem = new JButton("Tìm");
		box7.add(btn_timkiem);

		btn_Add = new JButton("ADD");
		btn_Edit = new JButton("EDIT");
		btn_Edit.setEnabled(false);
		btn_Dele = new JButton("DELE");
		btn_Dele.setEnabled(false);

		JPanel panelall = new JPanel();
		panelall.setLayout(new BoxLayout(panelall, BoxLayout.X_AXIS));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

		JPanel panel11 = new JPanel();
		panel11.setLayout(new BoxLayout(panel11, BoxLayout.X_AXIS));

		JPanel panel12 = new JPanel();
		panel12.setLayout(new BoxLayout(panel12, BoxLayout.X_AXIS));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

		JPanel panel21 = new JPanel();
		panel21.setLayout(new BoxLayout(panel21, BoxLayout.Y_AXIS));

		JPanel panel22 = new JPanel();
		panel22.setLayout(new BoxLayout(panel22, BoxLayout.Y_AXIS));

		JPanel panel221 = new JPanel();
		panel221.setLayout(new BoxLayout(panel221, BoxLayout.Y_AXIS));

		JPanel panel2a = new JPanel();
		panel221.setLayout(new BoxLayout(panel221, BoxLayout.Y_AXIS));

		JPanel panel2b = new JPanel();
		panel221.setLayout(new BoxLayout(panel221, BoxLayout.Y_AXIS));

		JPanel panel2c = new JPanel();
		panel221.setLayout(new BoxLayout(panel221, BoxLayout.Y_AXIS));

		JPanel panel222 = new JPanel();
		panel222.setLayout(new BoxLayout(panel222, BoxLayout.Y_AXIS));

		JPanel panel2221 = new JPanel();
		panel2221.setLayout(new BoxLayout(panel2221, BoxLayout.Y_AXIS));

		JPanel panel2222 = new JPanel();
		panel2222.setLayout(new BoxLayout(panel2222, BoxLayout.Y_AXIS));

		JPanel panela = new JPanel();
		panela.setLayout(new BoxLayout(panela, BoxLayout.X_AXIS));

		JPanel panelb = new JPanel();
		panelb.setLayout(new BoxLayout(panelb, BoxLayout.X_AXIS));

		JPanel panelc = new JPanel();
		panelc.setLayout(new BoxLayout(panelc, BoxLayout.X_AXIS));

		JPanel panelc1 = new JPanel();
		panelc1.setLayout(new BoxLayout(panelc1, BoxLayout.X_AXIS));

		JPanel panelc2 = new JPanel();
		panelc1.setLayout(new BoxLayout(panelc1, BoxLayout.X_AXIS));

		JPanel paneld = new JPanel();
		paneld.setLayout(new BoxLayout(paneld, BoxLayout.X_AXIS));

		panel11.add(box7);

		panela.add(box1);

		panela.add(box2);
		panelb.add(box3);
		panelb.add(box4);
		panelc.add(box5);
		panelc.add(box6);

		panelc1.add(boxa);
		panelc2.add(boxc);

		boxa.add(ab);
		panelc1.add(boxb);
		panelc2.add(huyen);
		panelc2.add(jcomboHuyen);
		panelc2.add(xa);
		panelc2.add(jcomboXa);
		boxa.add(jcomboClass);
		boxa.add(tinh);
		boxa.add(jcomboTinh);

		panelc1.add(boxa);
		// panelc1.add(boxa1);
		paneld.add(btn_Add);
		paneld.add(btn_Edit);
		paneld.add(btn_Dele);

		jtable.setModel(tableModel);
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel21.add(jtable);
		JScrollPane scroll = JTable.createScrollPaneForTable(jtable);
		panel21.add(scroll);

		boxAll.add(panel1);
		boxAll.add(panel2);
		panel1.add(panel11);
		panel1.add(panel12);
		panel2.add(panel22);
		panel2.add(panel21);

		panel2221.add(panela);
		panel2221.add(panelb);
		panel2221.add(panelc);
		panel2221.add(panelc1);
		panel2221.add(panelc2);
		panel2221.add(paneld);
		panel22.add(panel221);
		panel22.add(panel222);
		panel222.add(panel2221);
		panel222.add(panel2222);

		panel221.add(panel2a);
		panel221.add(panel2b);
		panel221.add(panel2c);

		// endTab1
		// tab2

		// endTab2

		connectSQL(); // kết nối cơ sở dữ liệu
		updateData(view());
		updateDatatinh(tinh());
		updateDatahuyen(huyen());
		updateDataxa(xa());
		// gọi hàm view để truy suất dữ liệu sau đó truyền cho hàm updateData để đưa dữ
		// liệu vào tableModel và hiện lên Jtable trong Frame

		JTabbedPane tabbedPane = new JTabbedPane();

		

		tabbedPane.addTab("Sinh Viên", null, boxAll, "Quản lí Sinh Viên");

	
		tabbedPane.addTab("Môn Học", null, monhoc.panelAll, "Quản lí Môn Học");

	
		tabbedPane.addTab("Lớp học", null, lophoc.pnAll, "Quản lí Lớp Học");

		
		tabbedPane.addTab("Báo Cáo", null, baocao.pnAll, "Báo Cáo");

		tabbedPane.setTabPlacement(JTabbedPane.LEFT);

		return tabbedPane;

	}

	ActionListener eventAdd = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {

			try {
				addInfo();
				addInfo1();
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			deleteAllTableRows(jtable);
			updateData(view());
		}

	};
	ActionListener evUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			deleteAllTableRows(jtable);
			addUpdate(id.toString());
			updateData(view());
			maSV.setEditable(true);
			btn_Edit.setEnabled(false);
			btn_Dele.setEnabled(false);
		}
	};
	ActionListener eventDele = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			deleteAllTableRows(jtable);
			dele(id.toString());
			xoadiem();
			updateData(view());
			maSV.setEditable(true);
			btn_Dele.setEnabled(false);
			btn_Edit.setEnabled(false);
		}
	};

	void deleteAllTableRows(JTable jtable) {
		DefaultTableModel tableModelLH = (DefaultTableModel) jtable.getModel();
		while (tableModelLH.getRowCount() > 0) {
			tableModelLH.removeRow(0);
		}
	}

	public void addInfo1()  throws MyException{
		try {
		if(MyException.ChekMaSV(maSV.getText())) {
			try {
				String sql = "INSERT INTO `diemsinhvien` ( `mssv1`, `hocki`, `monhoc`, `diem`) VALUES ( '" + mssv
						+ "', 'HK1', 'LP#1', '')," + " ( '" + mssv + "', 'HK1', 'LP#2', ''), ( '" + mssv
						+ "', 'HK1', 'LP#3', '')," + " ( '" + mssv + "', 'HK2', 'LP#4', ''), ( '" + mssv
						+ "', 'HK2', 'LP#5', '')," + " ( '" + mssv + "', 'HK2', 'LP#6', ''), ( '" + mssv
						+ "', 'HK1', 'ELC', '')," + " ( '" + mssv + "', 'HK2', 'E4IT', '')";
				Statement statement = connect.createStatement();
				int x = statement.executeUpdate(sql);
				if (x > 0) {

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

	

	public void addInfo() throws MyException{
		deleteAllTableRows(jtable);
		updateData(view());
try {
	
if(MyException.ChekMaSV(maSV.getText())&&MyException.chkTrong(maSV.getText())&&MyException.chkTrong(tuoiSV.getText())&&MyException.chkTrong(nha.getText())&&MyException.chkTrong(tenSV.getText())&&MyException.chkTrong(dienthoai.getText())) {
			mssv = maSV.getText();
			age = tuoiSV.getText();
			adress = nha.getText();
			name = tenSV.getText();
			sdt = dienthoai.getText();
			lop = (String) jcomboClass.getSelectedItem();
			mail = email.getText();
			cbtinh = (String) jcomboTinh.getSelectedItem();
			cbhuyen = (String) jcomboHuyen.getSelectedItem();
			cbxa = (String) jcomboXa.getSelectedItem();
			maSV.setText("");
			nha.setText("");
			tenSV.setText("");
			tuoiSV.setText("");
			email.setText("");
			dienthoai.setText("");

		

		
				try {

					String sql = "INSERT INTO `sinhvien` (`maSV`, `tenSV`, `tuoiSV`, `lop`, `nha`, `email`, `dienthoai`, `tinh`, `huyen`, `xa`)"
							+ " VALUES ('" + mssv + "', '" + name + "', '" + age + "', '" + lop + "', '" + adress
							+ "', '" + mail + "', '" + sdt + "', '" + cbtinh + "', '" + cbhuyen + "', '" + cbxa + "')";
					Statement statement = connect.createStatement();
					int x = statement.executeUpdate(sql);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Lưu OK");
					}
					
				} catch (Exception ex) {

					ex.printStackTrace();
				}

			
		
		DefaultTableModel TableModel = (DefaultTableModel) jtable.getModel();
}
} catch (Exception e) {
	// TODO: handle exception
}
	
	}

	public void xoadiem() {

		try {

			String sql = "DELETE FROM `diemsinhvien`  WHERE mssv1 = '" + mssv + "' ";
			Statement statement = connect.createStatement();
			int x = statement.executeUpdate(sql);

			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dele(String id) {

		try {

			String sql = "DELETE FROM `sinhvien`  WHERE id = '" + id + "' ";
			Statement statement = connect.createStatement();
			int x = statement.executeUpdate(sql);

			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addUpdate(String id) {

		mssv = maSV.getText();
		age = tuoiSV.getText();
		adress = nha.getText();
		name = tenSV.getText();
		sdt = dienthoai.getText();
		lop = (String) jcomboClass.getSelectedItem();
		mail = email.getText();
		cbtinh = (String) jcomboTinh.getSelectedItem();

		cbhuyen = (String) jcomboHuyen.getSelectedItem();

		cbxa = (String) jcomboXa.getSelectedItem();
		try {

			String sql = "UPDATE sinhvien SET `maSV`='" + mssv + "',`tenSV`='" + name + "',`tuoiSV`='" + age
					+ "',`lop`='" + lop + "',`nha`='" + adress + "',`email`='" + mail + "', `dienthoai`='" + sdt
					+ "', `tinh`='" + cbtinh + "',`huyen`='" + cbhuyen + "',`xa`='" + cbxa + "'  WHERE id = '" + id
					+ "' ";
			Statement statement = connect.createStatement();
			int x = statement.executeUpdate(sql);

			if (x < 0) {
				JOptionPane.showMessageDialog(null, "Lưu OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addEvents() {
		btn_timkiem.addActionListener(timkim);
		btn_Add.addActionListener(eventAdd);
		btn_Edit.addActionListener(evUpdate);
		jtable.addMouseListener(eventDataToTextField);
		btn_Dele.addActionListener(eventDele);
		// btn_Save.addActionListener(evDelete);

	}

	ActionListener timkim = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			deleteAllTableRows(jtable);
			updateDatatim(viewtim());
			timkiem.setText("");
		}
	};

	public ResultSet viewtim() {
		String seach = timkiem.getText();

		ResultSet resulttim = null;
		String sql = "SELECT * FROM sinhvien WHERE maSV LIKE '%" + seach + "%'";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resulttim;

	}

	public void updateDatatim(ResultSet resulttim) {
		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Tuổi", "Lớp", "Địa Chỉ", "Email", "SĐT", "Tỉnh", "Huyện","Xã" };
		tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName

		try {
			while (resulttim.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[10];
				rows[0] = resulttim.getString(1);
				rows[1] = resulttim.getString(2);
				rows[2] = resulttim.getString(3);
				rows[3] = resulttim.getString(4);
				rows[4] = resulttim.getString(5);
				rows[5] = resulttim.getString(6);
				rows[6] = resulttim.getString(7);
				rows[7] = resulttim.getString(8);
				rows[8] = resulttim.getString(9);
				rows[9] = resulttim.getString(10);
				rows[10] = resulttim.getString(11);

				tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên

				// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
				// trên frame
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// lấy dữ liệu từ table ra textfield {
	MouseListener eventDataToTextField = new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			getDataToTextField();
		}
	};

	void getDataToTextField() {
		maSV.setEditable(false);
		btn_Edit.setEnabled(true);

		btn_Dele.setEnabled(true);
		int row = jtable.getSelectedRow();
		id = (String) tableModel.getValueAt(row, 0);
		mssv = (String) tableModel.getValueAt(row, 1);
		maSV.setText((String) jtable.getValueAt(row, 1));
		tenSV.setText((String) jtable.getValueAt(row, 2));
		tuoiSV.setText((String) jtable.getValueAt(row, 3));
		nha.setText((String) jtable.getValueAt(row, 5));
		email.setText((String) jtable.getValueAt(row, 6));
		dienthoai.setText((String) jtable.getValueAt(row, 7));
		jcomboClass.setSelectedItem(jtable.getValueAt(row, 4));
		jcomboTinh.setSelectedItem(jtable.getValueAt(row, 8));
		jcomboHuyen.setSelectedItem(jtable.getValueAt(row, 9));
		jcomboXa.setSelectedItem(jtable.getValueAt(row, 10));
	}

	// end }
	public void updateData(ResultSet result) {
		String[] colsName = { "ID", "Mã SV", "Họ Tên", "Tuổi", "Lớp", "Địa Chỉ", "Email", "SĐT", "Tỉnh", "Huyện",
				"Xã" };
		tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName

		try {
			while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
				String rows[] = new String[11];
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
				rows[10] = result.getString(11);

				tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên

				// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại
				// trên frame
			}
		} catch (SQLException e) {
			e.printStackTrace();
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

	public ResultSet view() {
		ResultSet result = null;
		String sql = "SELECT * FROM sinhvien";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public void updateDatatinh(ResultSet resulttinh) {
		Vector<String> data = new Vector<String>();
		try {
			while (resulttinh.next()) {
				data.addElement(resulttinh.getString(1));
				jcomboTinh.setModel(new DefaultComboBoxModel<>(data));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ResultSet tinh() {

		ResultSet resulttinh = null;
		String sql = "SELECT name FROM devvn_tinhthanhpho";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resulttinh;
	}

	public void updateDatahuyen(ResultSet resulthuyen) {
		Vector<String> datahuyen = new Vector<String>();
		try {
			while (resulthuyen.next()) {
				datahuyen.addElement(resulthuyen.getString(1));
				jcomboHuyen.setModel(new DefaultComboBoxModel<>(datahuyen));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ResultSet huyen() {
		cbtinh = (String) jcomboTinh.getSelectedItem();

		ResultSet resulthuyen = null;
		String sql = "SELECT devvn_quanhuyen.name FROM devvn_quanhuyen INNER JOIN devvn_tinhthanhpho ON devvn_quanhuyen.matp = devvn_tinhthanhpho.matp AND"
				+ " devvn_tinhthanhpho.name ='" + cbtinh + "' ";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resulthuyen;
	}

	public void updateDataxa(ResultSet resultxa) {
		Vector<String> dataxa = new Vector<String>();
		try {
			while (resultxa.next()) {
				dataxa.addElement(resultxa.getString(1));
				jcomboXa.setModel(new DefaultComboBoxModel<>(dataxa));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ResultSet xa() {
		cbhuyen = (String) jcomboHuyen.getSelectedItem();

		ResultSet resultxa = null;
		String sql = "SELECT devvn_xaphuongthitran.name FROM devvn_xaphuongthitran INNER JOIN devvn_quanhuyen ON devvn_xaphuongthitran.maqh = devvn_quanhuyen.maqh AND"
				+ " devvn_quanhuyen.name ='" + cbhuyen + "' ";
		try {
			Statement statement = (Statement) connect.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultxa;
	}

	public void windows() {

		this.setSize(1300, 678);
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		jcomboTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDatahuyen(huyen());
			}
		});
		jcomboHuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDataxa(xa());
			}
		});
	}

}