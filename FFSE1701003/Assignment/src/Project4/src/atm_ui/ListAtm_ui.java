package atm_ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import atm_model.AddressDB;
import atm_model.Atm_md;
import atm_model.Customer_model;

public class ListAtm_ui extends JPanel {
	private JTextField txtCode, txtAddress;
	private JComboBox<Item> cbDistrict, cbWard;
	private JButton btnAdd, btnEdit, btnDelete, btnReset;
	private JTable listAtm;
	Atm_md atm = new Atm_md();
	AddressDB addressDB = new AddressDB();
	private JPanel pnLeft, pnRight;
	private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10;
	private JTable tbl;
	DefaultTableModel dm;
	NumberFormat amountFormat;
	JFormattedTextField txtTotal;

	public ListAtm_ui() {
		initialize();
		addEvents();
		// showWindow();
	}

	public static void main(String[] args) {
		new ListAtm_ui();
	}

	public void initialize() {
		setLayout(new BorderLayout());
		pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		pnLeft.setBorder(BorderFactory.createTitledBorder("Thông tin ATM"));
		JPanel pn_form = new JPanel();
		pn_form.setLayout(new BoxLayout(pn_form, BoxLayout.Y_AXIS));
		JPanel pn_Button = new JPanel();
		pnLeft.add(pn_form);
		pnLeft.add(pn_Button);
		add(pnLeft, BorderLayout.WEST);

		JPanel pn1 = new JPanel();
		pn1.add(lb1 = new JLabel("Mã ATM"));
		pn1.add(txtCode = new JTextField(20));

		JPanel pn2 = new JPanel();
		pn2.add(lb2 = new JLabel("Quận"));
		cbDistrict = new JComboBox<>();
		AddressDB.setDistricts(cbDistrict);
		pn2.add(cbDistrict);

		JPanel pn3 = new JPanel();
		pn3.add(lb3 = new JLabel("Phường"));
		cbWard = new JComboBox<>();
		Item itemWard = new Item(0, "Chọn phường");
		cbWard.addItem(itemWard);
		pn3.add(cbWard);

		JPanel pn4 = new JPanel();
		pn4.add(lb4 = new JLabel("Địa chỉ"));
		pn4.add(txtAddress = new JTextField(20));

		JPanel pn5 = new JPanel();
		pn5.add(lb5 = new JLabel("Tổng tiền"));
		amountFormat = NumberFormat.getNumberInstance();
		txtTotal = new JFormattedTextField(amountFormat);
		txtTotal.setValue(new Double(0));
		pn5.add(txtTotal);

		btnAdd = new JButton("Thêm mới");
		btnEdit = new JButton("Sửa");
		btnDelete = new JButton("Xóa");
		btnReset = new JButton("Reset");
		pn_Button.add(btnAdd);
		pn_Button.add(btnEdit);
		pn_Button.add(btnDelete);
		pn_Button.add(btnReset);

		pn_form.add(pn1);
		pn_form.add(pn2);
		pn_form.add(pn3);
		pn_form.add(pn4);
		pn_form.add(pn5);
		pn_form.add(pn_Button);

		pn1.setSize(150, 30);
		pn2.setSize(150, 30);
		pn3.setSize(150, 30);
		pn4.setSize(150, 30);
		pn5.setSize(150, 30);

		lb1.setPreferredSize(lb5.getPreferredSize());
		lb2.setPreferredSize(lb5.getPreferredSize());
		lb3.setPreferredSize(lb5.getPreferredSize());
		lb4.setPreferredSize(lb5.getPreferredSize());
		cbDistrict.setPreferredSize(txtCode.getPreferredSize());
		cbWard.setPreferredSize(txtCode.getPreferredSize());
		txtTotal.setPreferredSize(txtCode.getPreferredSize());

		tbl = new JTable();
		String col[] = { "STT", "Mã", "Thành phố", "Quận", "Phường", "Số nhà" };
		dm = new DefaultTableModel(col, 0);
		JScrollPane scroll = new JScrollPane(tbl);
		tbl.setModel(dm);
		tbl.setRowHeight(20);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách cây ATM"));
		//tbl.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		add(scroll, BorderLayout.CENTER);
		// Table
		table();
	}

	public void table() {
		String strWhere = "";
		ArrayList<Atm_md> dataTable = atm.getRecords(strWhere);

		Object[] row = new Object[6];
		int count = dataTable.size();
		dm.setRowCount(0);
		for (int i = 0; i < count; i++) {
			int j = i + 1;
			row[0] = j;
			row[1] = dataTable.get(i).getCode();
			row[2] = "Đà Nẵng";
			row[3] = (String) AddressDB.getNameDistrictById(dataTable.get(i).getQuan());
			row[4] = (String) AddressDB.getNameWardById(dataTable.get(i).getPhuong());
			row[5] = dataTable.get(i).getAddress();
			dm.addRow(row);
		}
		tbl.getColumnModel().getColumn(0).setPreferredWidth(20);
	}

	public void addEvents() {
		btnAdd.addActionListener(AddNew);
		btnEdit.addActionListener(Edit);
		btnDelete.addActionListener(Delete);
		btnReset.addActionListener(Reset);
		tbl.addMouseListener(eventSelectedRow);
		cbDistrict.addActionListener((ActionListener) eventSelectedDistrict);
	}

	ActionListener eventSelectedDistrict = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Item value = (Item) cbDistrict.getSelectedItem();
			int value_id = value.getId();
			AddressDB.setWards(cbWard, value_id);
		}
	};

	MouseAdapter eventSelectedRow = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			int i = tbl.getSelectedRow();
			String codeString = (String) tbl.getModel().getValueAt(i, 1);
			Atm_md tempAtm = atm.getAtmByCode(codeString);

			txtCode.setText(tempAtm.getCode());
			AddressDB.setSelectedDistrict(cbDistrict, tempAtm.getQuan());
			AddressDB.setSelectedWard(cbWard, tempAtm.getPhuong(), tempAtm.getQuan());
			txtAddress.setText(tempAtm.getAddress());
			txtTotal.setValue(new Double(tempAtm.getTotal()));
			txtCode.setEditable(false);
			txtTotal.setEditable(false);
			
			/* Rest Button */
			btnDelete.setEnabled(true);
			btnEdit.setEnabled(true);
			btnAdd.setEnabled(false);
		}
	};
	
	ActionListener AddNew = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String maThe = txtCode.getText();
			Item val_district = (Item) cbDistrict.getSelectedItem();
			int district_id = val_district.getId();
			Item val_ward = (Item) cbWard.getSelectedItem();
			int ward_id = val_ward.getId();
			String diachi = txtAddress.getText();
			double total = ((Number) txtTotal.getValue()).doubleValue();

			Atm_md temAtm = new Atm_md(48, district_id, ward_id, maThe, diachi, total);
			int result = atm.addNew(temAtm);
			table();
			showMessageDialog(result, "Inserted");
		}
	};

	ActionListener Edit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String maThe = txtCode.getText();
			Item val_district = (Item) cbDistrict.getSelectedItem();
			int district_id = val_district.getId();
			Item val_ward = (Item) cbWard.getSelectedItem();
			int ward_id = val_ward.getId();
			String diachi = txtAddress.getText();
			double total = ((Number) txtTotal.getValue()).doubleValue();

			Atm_md temAtm = new Atm_md(48, district_id, ward_id, maThe, diachi, total);
			int result = atm.edit(temAtm, maThe);
			table();
			showMessageDialog(result, "Updated");
		}
	};

	ActionListener Delete = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String maATM = txtCode.getText();
			if (!maATM.isEmpty() && maATM != null) {
				int isDel = JOptionPane.showConfirmDialog(null, "Do you really want to delete", "Delete",
						JOptionPane.YES_NO_OPTION);
				int result = atm.delete(maATM);
				table();
				showMessageDialog(result, "Delete");
			}

		}
	};
	
	ActionListener Reset = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			resetInput();
		}
	};

	public void showMessageDialog(int result, String message) {
		if (result == 1) {
			resetInput();
			JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
		} else {
			JOptionPane.showMessageDialog(null, "Data not " + message);
		}
	}

	public void resetInput() {
		txtCode.setText("");
		cbDistrict.setSelectedIndex(0);
		txtAddress.setText("");
		txtTotal.setValue(new Double(0));
		/* Rest Button */
		btnDelete.setEnabled(true);
		btnEdit.setEnabled(true);
		btnAdd.setEnabled(true);
		/* Rest Textfiled */
		txtCode.setEditable(true);
		txtTotal.setEditable(true);
	}

}
