package atm_ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import atm_model.AddressDB;
import atm_model.Atm_md;
import atm_model.Withdrawal_model;

public class ReportATMStatus extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnTop;
	private JComboBox<Item> cbDistrict, cbWard;
	private JButton btn_search;
	private JTable table;
	private DefaultTableModel dm;
	AddressDB addressDB = new AddressDB();
	Withdrawal_model withdrawal = new Withdrawal_model();
	Atm_md atm_md = new Atm_md();
	private JTextField txtKeywork;

	public ReportATMStatus() {
		initialize();
		addEvents();
	}

	public void initialize() {
		setLayout(new BorderLayout());
		// pnTop
		pnTop = new JPanel();
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
		
		JPanel pn4 = new JPanel();
		txtKeywork = new JTextField("Mã ATM");
		txtKeywork.setPreferredSize(new Dimension(150,25));
		txtKeywork.setForeground(Color.GRAY);
		pn4.add(txtKeywork);
		txtKeywork.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtKeywork.getText().equals("Mã ATM")) {
					txtKeywork.setText("");
					txtKeywork.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtKeywork.getText().isEmpty()) {
					txtKeywork.setForeground(Color.GRAY);
					txtKeywork.setText("Mã ATM");
				}
			}
		});
		
		pnTop.add(pn1);
		pnTop.add(pn2);
		pnTop.add(pn4);
		pnTop.add(pn3);
		
		this.add(pnTop, BorderLayout.NORTH);
		
		table = new JTable();
		String col[] = { "STT", "Mã ATM", "Quận", "Phường", "Địa chỉ", "Tổng tiền" };
		dm = new DefaultTableModel(col, 0);
		JScrollPane scroll = new JScrollPane(table);
		table.setModel(dm);
		table.setRowHeight(20);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách ATM"));
		this.add(scroll, BorderLayout.CENTER);
		String strWhere = "";
		tableRows(strWhere);
	}

	public void tableRows(String strWhere) {
		ArrayList<Atm_md> dataTable = atm_md.getRecords(strWhere);

		Object[] row = new Object[6];
		int count = dataTable.size();
		dm.setRowCount(0);
		for (int i = 0; i < count; i++) {
			int j = i + 1;
			row[0] = j;
			row[1] = dataTable.get(i).getCode();
			row[2] = (String) AddressDB.getNameDistrictById(dataTable.get(i).getQuan());
			row[3] = (String) AddressDB.getNameWardById(dataTable.get(i).getPhuong());
			row[4] = dataTable.get(i).getAddress();
			row[5] = dataTable.get(i).getTotal();
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
			String keyWord = txtKeywork.getText();
			int val_district_id = 0;
			int val_ward_id = 0;
			String strWhere = "";
			
			Item val_district = (Item) cbDistrict.getSelectedItem();
			val_district_id = val_district.getId();
			Item val_ward = (Item) cbWard.getSelectedItem();
			val_ward_id = val_ward.getId();
			
			if(!keyWord.equals("Mã ATM") && (!keyWord.equals("") && !keyWord.equals(null))) {
				strWhere += " AND code = '"+ keyWord + "'";
			}
			
			if(val_district_id != 0) {
				strWhere += " AND quan = "+ val_district_id;
			}
			
			if(val_ward_id != 0) {
				strWhere += " AND phuong = "+ val_ward_id;
			}
			System.out.println(strWhere);
			tableRows(strWhere);
		}
	};
}
