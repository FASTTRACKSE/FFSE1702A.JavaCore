package atm_ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.management.modelmbean.ModelMBean;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Service.Mode;

import com.mysql.jdbc.Connection;

import atm_model.AddressDB;
import atm_model.Customer_model;
import atm_model.atm_connection;

public class ListCustomer extends JPanel // JPanel
{
	private JPanel pnListCustomer, pnForm;
	private JTable TableCustomer;
	private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10;
	private JTextField txtName;
	private JTextField txtCode;
	private JTextField txtDistrict;
	private JTextField txtWard;
	private JTextField txtAddress;
	private JTextField txtSoTKNH;
	private JTextField txtSn_Card;
	private JTextField txtEmail;
	private JTextField txtPhone;
	/* Xử lý hiển thị số có dấu phẩy động */
	NumberFormat amountFormat;
	JFormattedTextField txtAmount;

	private JComboBox<Item> cbDistrict, cbWard;
	private JButton btnAdd, btnEdit, btnDelete,btnReset;
	private JTable tbl;
	DefaultTableModel dm;
	Customer_model customer = new Customer_model();
	AddressDB addressDB = new AddressDB();

	public ListCustomer() {
		AddComponent();
		addEvents();
	}

	public void AddComponent() {
		setLayout(new BorderLayout());

		pnForm = new JPanel();
		pnForm.setLayout(new BoxLayout(pnForm, BoxLayout.Y_AXIS));
		pnForm.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

		JPanel pnInput = new JPanel();

		JPanel pn1 = new JPanel();
		pn1.add(lb1 = new JLabel("Tên khách hàng"));
		pn1.add(txtName = new JTextField(20));

		JPanel pn2 = new JPanel();
		pn2.add(lb2 = new JLabel("Mã khách hàng"));
		pn2.add(txtCode = new JTextField(20));

		JPanel pn3 = new JPanel();
		pn3.add(lb3 = new JLabel("Quận"));

		cbDistrict = new JComboBox<>();
		AddressDB.setDistricts(cbDistrict);
		pn3.add(cbDistrict);

		JPanel pn4 = new JPanel();
		pn4.add(lb4 = new JLabel("Phường"));
		cbWard = new JComboBox<>();
		Item itemWard = new Item(0, "Chọn phường");
		cbWard.addItem(itemWard);
		pn4.add(cbWard);

		JPanel pn5 = new JPanel();
		pn5.add(lb5 = new JLabel("Địa chỉ"));
		pn5.add(txtAddress = new JTextField(20));

		JPanel pn6 = new JPanel();
		pn6.add(lb6 = new JLabel("Số điện thoại"));
		pn6.add(txtPhone = new JTextField(20));

		JPanel pn7 = new JPanel();
		pn7.add(lb7 = new JLabel("Email"));
		pn7.add(txtEmail = new JTextField(20));

		JPanel pn8 = new JPanel();
		pn8.add(lb8 = new JLabel("Số thẻ"));
		pn8.add(txtSn_Card = new JTextField(20));

		JPanel pn9 = new JPanel();
		pn9.add(lb9 = new JLabel("Số TKNH"));
		pn9.add(txtSoTKNH = new JTextField(20));

		JPanel pn10 = new JPanel();
		pn10.add(lb10 = new JLabel("Tổng tiền"));
		amountFormat = NumberFormat.getNumberInstance();
		txtAmount = new JFormattedTextField(amountFormat);
		txtAmount.setValue(new Double(0));
		pn10.add(txtAmount);

		// pnInput.setLayout(new GridLayout(5, 0));
		pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));

		pnInput.add(pn1);
		pnInput.add(pn2);
		pnInput.add(pn3);
		pnInput.add(pn4);
		pnInput.add(pn5);
		pnInput.add(pn6);
		pnInput.add(pn7);
		pnInput.add(pn8);
		pnInput.add(pn9);
		pnInput.add(pn10);

		lb2.setPreferredSize(lb1.getPreferredSize());
		cbDistrict.setPreferredSize(txtSn_Card.getPreferredSize());
		lb3.setPreferredSize(lb1.getPreferredSize());
		cbWard.setPreferredSize(txtSn_Card.getPreferredSize());
		lb4.setPreferredSize(lb1.getPreferredSize());
		lb5.setPreferredSize(lb1.getPreferredSize());
		lb6.setPreferredSize(lb1.getPreferredSize());
		lb7.setPreferredSize(lb1.getPreferredSize());
		lb8.setPreferredSize(lb1.getPreferredSize());
		lb9.setPreferredSize(lb1.getPreferredSize());
		lb10.setPreferredSize(lb1.getPreferredSize());
		txtAmount.setPreferredSize(txtSn_Card.getPreferredSize());

		JPanel pn_Button = new JPanel();
		btnAdd = new JButton("Thêm mới");
		btnEdit = new JButton("Sửa");
		btnDelete = new JButton("Xóa");
		btnReset = new JButton("Reset");

		pn_Button.add(btnAdd);
		pn_Button.add(btnEdit);
		pn_Button.add(btnDelete);
		pn_Button.add(btnReset);
		
		pnForm.add(pnInput);
		pnForm.add(pn_Button);

		add(pnForm, BorderLayout.WEST);

		tbl = new JTable();
		String col[] = { "STT", "Tên", "Mã", "Quận", "Phường", "Số nhà", "SĐT", "Email" };
		dm = new DefaultTableModel(col, 0);
		JScrollPane scroll = new JScrollPane(tbl);
		tbl.setModel(dm);
		tbl.setRowHeight(20);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));
		add(scroll, BorderLayout.CENTER);
		// Table
		table();
	}

	public void table() {
		Customer_model customer_model = new Customer_model();
		ArrayList<Customer_model> dataTable = customer_model.getRecords();

		Object[] row = new Object[9];
		int count = dataTable.size();
		dm.setRowCount(0);
		for (int i = 0; i < count; i++) {
			int j = i + 1;
			row[0] = j;
			row[1] = dataTable.get(i).getName();
			row[2] = dataTable.get(i).getCode();
			row[3] = (String) AddressDB.getNameDistrictById(dataTable.get(i).getQuan());
			row[4] = (String) AddressDB.getNameWardById(dataTable.get(i).getPhuong());
			row[5] = dataTable.get(i).getAddress();
			row[6] = dataTable.get(i).getPhone();
			row[7] = dataTable.get(i).getEmail();
			// row[8] = dataTable.get(i).getSn_card();
			// row[9] = dataTable.get(i).getSoTKNH();
			// row[10] = dataTable.get(i).getAmount();
			dm.addRow(row);
		}
		tbl.getColumnModel().getColumn(0).setPreferredWidth(20);
	}

	public void addEvents() {
		btnAdd.addActionListener(AddNew);
		btnEdit.addActionListener(Edit);
		btnDelete.addActionListener(Delete);
		btnReset.addActionListener(Reset);
		tbl.addMouseListener(eventSelect);
		cbDistrict.addActionListener(eventSelectedDistrict);
	}

	MouseAdapter eventSelect = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbl.getSelectedRow();
			String codeString = (String) tbl.getModel().getValueAt(i, 2);
			int code = Integer.parseInt(codeString);
			Customer_model cus = customer.getCustomerById(code);

			txtName.setText(cus.getName());
			txtCode.setText(cus.getCode());
			AddressDB.setSelectedDistrict(cbDistrict, cus.getQuan());
			AddressDB.setSelectedWard(cbWard, cus.getPhuong(), cus.getQuan());
			txtAddress.setText(cus.getAddress());
			txtPhone.setText(cus.getPhone());
			txtEmail.setText(cus.getEmail());
			txtSn_Card.setText(cus.getSn_card());
			txtSoTKNH.setText(cus.getSoTKNH());
			txtAmount.setText(String.valueOf(cus.getAmount()));

			txtCode.setEditable(false);
			txtSn_Card.setEditable(false);
			txtSoTKNH.setEditable(false);
			
			btnAdd.setEnabled(false);
		}
	};

	ActionListener eventSelectedDistrict = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Item value = (Item) cbDistrict.getSelectedItem();
			int value_id = value.getId();
			AddressDB.setWards(cbWard, value_id);
		}
	};

	ActionListener AddNew = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String maKH = txtCode.getText();
			String tenKH = txtName.getText();
			String sodienthoai = txtPhone.getText();
			boolean issodienthoai = checkInt(sodienthoai);
			String email = txtEmail.getText();
			Item val_district = (Item) cbDistrict.getSelectedItem();
			int district_id = val_district.getId();
			Item val_ward = (Item) cbWard.getSelectedItem();
			int ward_id = val_ward.getId();
			String sothe = txtSn_Card.getText();
			boolean issothe = checkInt(sothe);
			String soTKNH = txtSoTKNH.getText();
			boolean issoTKNH = checkInt(soTKNH);
			String diachi = txtAddress.getText();
			double amount = ((Number) txtAmount.getValue()).doubleValue();
			if (!issodienthoai) {
				JOptionPane.showMessageDialog(txtPhone, "Số điện thoại phải là số");
			} else if (!issothe) {
				JOptionPane.showMessageDialog(txtSn_Card, "Số thẻ phải là số");
			} else if (!issoTKNH) {
				JOptionPane.showMessageDialog(txtSoTKNH, "Số tài khoản ngân hàng phải là số");
			} else {
				Customer_model customer = new Customer_model(maKH, tenKH, district_id, ward_id, diachi, sodienthoai,
						email, sothe, soTKNH, amount);
				int result = customer.addNew(customer);
				table();
				showMessageDialog(result, "Inserted");
			}
		}
	};

	ActionListener Edit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String maKH = txtCode.getText();
			String tenKH = txtName.getText();
			String sodienthoai = txtPhone.getText();
			boolean issodienthoai = checkInt(sodienthoai);
			String email = txtEmail.getText();
			Item val_district = (Item) cbDistrict.getSelectedItem();
			int district_id = val_district.getId();
			Item val_ward = (Item) cbWard.getSelectedItem();
			int ward_id = val_ward.getId();
			String sothe = txtSn_Card.getText();
			boolean issothe = checkInt(sothe);
			String soTKNH = txtSoTKNH.getText();
			boolean issoTKNH = checkInt(soTKNH);
			String diachi = txtAddress.getText();
			double amount = ((Number) txtAmount.getValue()).doubleValue();
			if (!issodienthoai) {
				JOptionPane.showMessageDialog(txtPhone, "Số điện thoại phải là số");
			} else if (!issothe) {
				JOptionPane.showMessageDialog(txtSn_Card, "Số thẻ phải là số");
			} else if (!issoTKNH) {
				JOptionPane.showMessageDialog(txtSoTKNH, "Số tài khoản ngân hàng phải là số");
			} else {
				Customer_model customer = new Customer_model(maKH, tenKH, district_id, ward_id, diachi, sodienthoai,
						email, sothe, soTKNH, amount);
				int result = customer.edit(customer, maKH);
				table();
				showMessageDialog(result, "Updated");
			}
		}
	};

	ActionListener Delete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String maKH = txtCode.getText();
			if (!maKH.isEmpty() && maKH != null) {
				int isDel = JOptionPane.showConfirmDialog(null, "Do you really want to delete", "Delete",
						JOptionPane.YES_NO_OPTION);
				int result = customer.delete(customer, maKH);
				table();
				showMessageDialog(result, "Delete");
			}
		}
	};
	
	ActionListener Reset = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			resetInput();
		}
	};

	public void showMessageDialog(int result, String message) {
		if (result == 1) {
			JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
		} else {
			JOptionPane.showMessageDialog(null, "Data not " + message);
		}
	}

	public boolean checkInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void resetInput() {
		txtName.setText("");
		txtCode.setText("");
		cbDistrict.setSelectedIndex(0);
		txtAddress.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		txtSn_Card.setText("");
		txtSoTKNH.setText("");
		txtAmount.setValue(new Double(0));
		/* Rest Button */
		btnDelete.setEnabled(true);
		btnEdit.setEnabled(true);
		btnAdd.setEnabled(true);
		/* Rest Textfiled */
		txtCode.setEditable(true);
		txtSn_Card.setEditable(true);
		txtSoTKNH.setEditable(true);
	}
}
