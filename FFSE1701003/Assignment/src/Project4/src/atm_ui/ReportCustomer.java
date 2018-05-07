package atm_ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import atm_model.AddressDB;
import atm_model.Withdrawal_model;

public class ReportCustomer extends JPanel {
	private JPanel pnTop;
	private JComboBox<Item> cbDistrict, cbWard;
	private JButton btn_search;
	private JTable table;
	private DefaultTableModel dm;
	AddressDB addressDB = new AddressDB();
	Withdrawal_model withdrawal = new Withdrawal_model();

	public ReportCustomer() {
		initialize();
		addEvents();
	}

	public void initialize() {
		setLayout(new BorderLayout());
		// pnTop
		pnTop = new JPanel();
		// pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.X_AXIS));
		pnTop.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JPanel pn1 = new JPanel();
		JLabel lb1 = new JLabel("Quận");
		pn1.add(lb1);
		cbDistrict = new JComboBox<>();
		AddressDB.setDistricts(cbDistrict);
		pn1.add(cbDistrict);

		JPanel pn2 = new JPanel();
		JLabel lb2 = new JLabel("Phường");
		pn2.add(lb2);
		cbWard = new JComboBox<>();
		Item itemWard = new Item(0, "Chọn phường");
		cbWard.addItem(itemWard);
		pn2.add(cbWard);
		
		JPanel pn3 = new JPanel();
		btn_search = new JButton("Tìm kiếm");
		pn3.add(btn_search);
		
		pnTop.add(pn1);
		pnTop.add(pn2);
		pnTop.add(pn3);
		
		this.add(pnTop, BorderLayout.NORTH);
		
		table = new JTable();
		String col[] = { "STT", "Tên KH", "Số thẻ","Quận", "Phường", "Địa chỉ", "Mã GD", "Thời gian", "Số tiền" };
		dm = new DefaultTableModel(col, 0);
		JScrollPane scroll = new JScrollPane(table);
		table.setModel(dm);
		table.setRowHeight(20);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách giao dịch"));
		this.add(scroll, BorderLayout.CENTER);
		String strWhere = "";
		tableRows(strWhere);
	}

	public void tableRows(String strWhere) {
		ArrayList<Withdrawal_model> dataTable = withdrawal.getRecordsWithCustomer(strWhere);

		Object[] row = new Object[9];
		int count = dataTable.size();
		dm.setRowCount(0);
		for (int i = 0; i < count; i++) {
			int j = i + 1;
			row[0] = j;
			row[1] = dataTable.get(i).getCusName();
			row[2] = dataTable.get(i).getSn_card();
			row[3] = (String) AddressDB.getNameDistrictById(dataTable.get(i).getQuan());
			row[4] = (String) AddressDB.getNameWardById(dataTable.get(i).getPhuong());
			row[5] = dataTable.get(i).getCusAddress();
			row[6] = dataTable.get(i).getCode();
			row[7] = dataTable.get(i).get_time();
			row[8] = String.format("%,d", (long) dataTable.get(i).getNumber());
			dm.addRow(row);
		}
	}

	public void addEvents() {
		cbDistrict.addActionListener(eventSelectedDistrict);
		btn_search.addActionListener(evSearch);
	}
	
	ActionListener eventSelectedDistrict = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Item value = (Item) cbDistrict.getSelectedItem();
			int value_id = value.getId();
			AddressDB.setWards(cbWard, value_id);
		}
	};

	ActionListener evSearch = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int val_district_id = 0;
			int val_ward_id = 0;
			String strWhere = "";
			
			Item val_district = (Item) cbDistrict.getSelectedItem();
			val_district_id = val_district.getId();
			Item val_ward = (Item) cbWard.getSelectedItem();
			val_ward_id = val_ward.getId();
			
			if(val_district_id != 0) {
				strWhere += " AND quan = "+ val_district_id;
			}
			if(val_ward_id != 0) {
				strWhere += " AND phuong = "+ val_ward_id;
			}
			
			tableRows(strWhere);
		}
	};
}
