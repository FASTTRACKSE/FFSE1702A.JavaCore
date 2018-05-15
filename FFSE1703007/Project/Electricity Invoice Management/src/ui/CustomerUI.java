package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import model.MySQL;

public class CustomerUI extends JFrame {
	JTextField txtSearch, txtName, txtAddress, txtPhone, txtEmail, txtMeterID;
	JButton btnSearch2, btnAdd, btnEdit, btnDel;
	JComboBox cb1, cb2, cb3, cb4;
	Object[] obj = { "Mã khách hàng", "Họ tên", "Địa chỉ", "Quận", "Phường",
			"Điện thoại", "Email", "Mã công tơ" };
	DefaultTableModel mdl = new DefaultTableModel(obj, 0) {
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
		
	};
	JTable jt = new JTable(mdl);

	public CustomerUI(String title) throws HeadlessException, SQLException {
		super(title);
		// TODO Auto-generated constructor stub
		addControls();
		addEvents();
	}

	public void showWindow() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	void addControls() throws SQLException {
		Container con = getContentPane();

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Quản lí khách hàng");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pn1 = new JPanel();
		JLabel lblSearch = new JLabel("Tên khách hàng");
		txtSearch = new JTextField(15);
		pn1.add(lblSearch);
		pn1.add(txtSearch);

		JPanel pn2 = new JPanel();
		JLabel lblCounty = new JLabel("Quận");
		String County[] = {};
		cb1 = new JComboBox(County);
		cb1.setPreferredSize(new Dimension(115, 20));
		JLabel lblWard = new JLabel("Phường");
		String Ward[] = {};
		cb2 = new JComboBox(Ward);
		cb2.setPreferredSize(new Dimension(115, 20));
		btnSearch2 = new JButton("Tìm kiếm");
		pn2.add(lblCounty);
		pn2.add(cb1);
		pn2.add(lblWard);
		pn2.add(cb2);
		pn2.add(btnSearch2);

		JPanel pn3 = new JPanel();
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		pn3.add(btnAdd);
		pn3.add(btnEdit);
		pn3.add(btnDel);

		JScrollPane pn4 = new JScrollPane(jt);

		JPanel pn5 = new JPanel();
		pn5.setLayout(new BoxLayout(pn5, BoxLayout.Y_AXIS));
		JPanel pnName = new JPanel();
		JLabel lblName = new JLabel("Họ tên");
		lblName.setPreferredSize(new Dimension(90, 15));
		txtName = new JTextField(15);
		pnName.add(lblName);
		pnName.add(txtName);

		JPanel pnAddress = new JPanel();
		JLabel lblAddress = new JLabel("Địa chỉ");
		lblAddress.setPreferredSize(new Dimension(90, 15));
		txtAddress = new JTextField(15);
		pnAddress.add(lblAddress);
		pnAddress.add(txtAddress);

		JPanel pnCounty = new JPanel();
		JLabel lblCounty2 = new JLabel("Quận");
		lblCounty2.setPreferredSize(new Dimension(90, 15));
		cb3 = new JComboBox(County);
		cb3.setPreferredSize(new Dimension(170, 20));
		pnCounty.add(lblCounty2);
		pnCounty.add(cb3);

		JPanel pnWard = new JPanel();
		JLabel lblWard2 = new JLabel("Phường");
		lblWard2.setPreferredSize(new Dimension(90, 15));
		cb4 = new JComboBox(Ward);
		cb4.setPreferredSize(new Dimension(170, 20));
		pnWard.add(lblWard2);
		pnWard.add(cb4);

		JPanel pnPhone = new JPanel();
		JLabel lblPhone = new JLabel("Điện thoại");
		lblPhone.setPreferredSize(new Dimension(90, 15));
		txtPhone = new JTextField(15);
		pnPhone.add(lblPhone);
		pnPhone.add(txtPhone);

		JPanel pnEmail = new JPanel();
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setPreferredSize(new Dimension(90, 15));
		txtEmail = new JTextField(15);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);

		JPanel pnMeterID = new JPanel();
		JLabel lblMeterID = new JLabel("Mã công tơ");
		lblMeterID.setPreferredSize(new Dimension(90, 15));
		txtMeterID = new JTextField(15);
		pnMeterID.add(lblMeterID);
		pnMeterID.add(txtMeterID);

		pn5.add(pnName);
		pn5.add(pnAddress);
		pn5.add(pnCounty);
		pn5.add(pnWard);
		pn5.add(pnPhone);
		pn5.add(pnEmail);
		pn5.add(pnMeterID);

		pnMain.add(pnTitle);
		pnMain.add(pn1);
		pnMain.add(pn2);
		pnMain.add(pn4);
		pnMain.add(pn3);
		pnMain.add(pn5);

		con.add(pnMain);

		Object str = "Tất cả";
		cb1.addItem(str);
		cb2.addItem(str);

		addComboBoxCounty(MySQL.getCounty(), cb1);
		addComboBoxCounty(MySQL.getCounty(), cb3);

		cb3.setRenderer(new MyComboBoxRenderer("Chọn quận"));
		cb3.setSelectedIndex(-1);
	}

	void addEvents() {
		cb1.addActionListener(eventChangeCounty);
		cb3.addActionListener(eventChangeCounty2);
		btnAdd.addActionListener(eventAddCustomer);
		btnSearch2.addActionListener(eventAddDataToTable);
		btnEdit.addActionListener(eventEditCustomer);
		jt.getSelectionModel().addListSelectionListener(eventDataToTextField);
		btnDel.addActionListener(eventDelCustomer);
	}

	ActionListener eventChangeCounty = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cb2.removeAllItems();
			Object str = "Tất cả";
			cb2.addItem(str);
			int countyID = cb1.getSelectedIndex();
			try {
				addComboBoxWard(MySQL.getWard(countyID), cb2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	ActionListener eventChangeCounty2 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cb4.removeAllItems();
			int countyID = cb3.getSelectedIndex() + 1;
			try {
				addComboBoxWard(MySQL.getWard(countyID), cb4);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	ActionListener eventAddCustomer = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			try {
				if (txtName.getText().equals("") || txtAddress.getText().equals("") || cb3.getSelectedIndex() < 0
						|| cb4.getSelectedIndex() < 0 || txtPhone.getText().equals("") || txtEmail.getText().equals("")
						|| txtMeterID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
				} else if (!checkRegexPhoneNumber(txtPhone.getText())) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng, vui lòng nhập lại");
				} else if (!checkRegexEmail(txtEmail.getText())) {
					JOptionPane.showMessageDialog(null, "Email không đúng định dạng, vui lòng nhập lại");
				} else if (checkDuplicateMeterID(txtMeterID.getText())) {
					JOptionPane.showMessageDialog(null, "Mã công tơ đã bị trùng, vui lòng nhập lại");
				} else {
					addCustomer();
					btnSearch2.doClick();
				}
				//
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	ActionListener eventAddDataToTable = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customerName = txtSearch.getText();
			String countyName = (String) cb1.getSelectedItem();
			String wardName = (String) cb2.getSelectedItem();

			if (countyName.equals("Tất cả")) {
				countyName = "";
			}
			if (wardName.equals("Tất cả")) {
				wardName = "";
			}

			ResultSet customerList = MySQL.getCustomerList(customerName, countyName, wardName);
			DefaultTableModel model = (DefaultTableModel) jt.getModel();
			model.setRowCount(0);
			try {
				addDataToTable(customerList, model);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};
	
	ListSelectionListener eventDataToTextField = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			int row = jt.getSelectedRow();
			if (row != -1 && !e.getValueIsAdjusting()) {
				getDataToTextField(row);
			}
		}
	};

	ActionListener eventDelCustomer = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (jt.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Hãy chọn dòng muốn xóa");
			} else {
				delCustomer();
				DefaultTableModel model = (DefaultTableModel) jt.getModel();
				model.removeRow(jt.getSelectedRow());
			}
		}
	};

	ActionListener eventEditCustomer = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (jt.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Hãy chọn dòng muốn sửa");
			} else {
				try {
					String oldMeterID = (String) jt.getValueAt(jt.getSelectedRow(), 7);
					if (txtName.getText().equals("") || txtAddress.getText().equals("") || txtPhone.getText().equals("")
							|| txtEmail.getText().equals("") || txtMeterID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
					} else if (!checkRegexPhoneNumber(txtPhone.getText())) {
						JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng, vui lòng nhập lại");
					} else if (!checkRegexEmail(txtEmail.getText())) {
						JOptionPane.showMessageDialog(null, "Email không đúng định dạng, vui lòng nhập lại");
					} else if (checkDuplicateMeterID(txtMeterID.getText()) && !oldMeterID.equals(txtMeterID.getText())) {
						JOptionPane.showMessageDialog(null, "Mã công tơ đã bị trùng, vui lòng nhập lại");
					} else {
						 editCustomer();
						 int row = jt.getSelectedRow();
						 int col = jt.getSelectedColumn();
						 btnSearch2.doClick();
						 jt.requestFocus();
						 jt.changeSelection(row, col, false, false);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};

	void addComboBoxCounty(ResultSet county, JComboBox cb) throws SQLException {
		while (county.next()) {
			cb.addItem(county.getObject("name"));
		}
	}

	void addComboBoxWard(ResultSet wardList, JComboBox cb) throws SQLException {
		while (wardList.next()) {
			cb.addItem(wardList.getObject("name"));
		}
	}

	void addDataToTable(ResultSet customerList, DefaultTableModel model) throws SQLException {
		Object[] row = new Object[8];
		while (customerList.next()) {
			for (int i = 1; i <= 8; ++i) {
				row[i - 1] = customerList.getString(i); // Or even rs.getObject()
			}
			model.addRow(row);
		}

	}

	void addCustomer() throws SQLException {
		int countyID = cb3.getSelectedIndex() + 1;
		Object wardName = cb4.getSelectedItem();
		ResultSet wardList = MySQL.getWard(countyID);
		int wardID = 0;
		while (wardList.next()) {
			if (wardList.getObject("name").equals(wardName)) {
				wardID = wardList.getInt("id");
			}
		}

		if (MySQL.addCustomer(txtName.getText(), txtAddress.getText(), countyID, wardID, txtPhone.getText(),
				txtEmail.getText(), txtMeterID.getText())) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm thất bại");
		}
	}

	void getDataToTextField(int row) {
//		int row = jt.getSelectedRow();
		txtName.setText((String) jt.getValueAt(row, 1));
		txtAddress.setText((String) jt.getValueAt(row, 2));
		txtPhone.setText((String) jt.getValueAt(row, 5));
		txtEmail.setText((String) jt.getValueAt(row, 6));
		txtMeterID.setText((String) jt.getValueAt(row, 7));
		cb3.setSelectedItem(jt.getValueAt(row, 3));
		cb4.setSelectedItem(jt.getValueAt(row, 4));
	}

	void editCustomer() throws SQLException {
		String customerID = (String) jt.getValueAt(jt.getSelectedRow(), 0);

		int countyID = cb3.getSelectedIndex() + 1;
		Object wardName = cb4.getSelectedItem();
		ResultSet wardList = MySQL.getWard(countyID);
		int wardID = 0;
		while (wardList.next()) {
			if (wardList.getObject("name").equals(wardName)) {
				wardID = wardList.getInt("id");
			}
		}
		if (MySQL.editCustomer(txtName.getText(), txtAddress.getText(), countyID, wardID, txtPhone.getText(),
				txtEmail.getText(), txtMeterID.getText(), customerID)) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Sửa thất bại");
		}
	}

	void delCustomer() {
		String customerID = (String) jt.getValueAt(jt.getSelectedRow(), 0);
		if (MySQL.delCustomer(customerID)) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}

	public static boolean checkDuplicateMeterID(String meterID) throws SQLException {
		ResultSet meterIdList = MySQL.getMeterIdList();
		while (meterIdList.next()) {
			if (meterID.equals(meterIdList.getString("meterID"))) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkRegexEmail(String email) {
		String regex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return email.matches(regex);
	}

	public static boolean checkRegexPhoneNumber(String phoneNumber) {
		String regex = "(\\+84|0)\\d{9,10}";
		return phoneNumber.matches(regex);
	}
}
