package atm_ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import atm_model.AddressDB;
import atm_model.Atm_md;
import atm_model.Withdrawal_model;

public class ReportATMWithdrawal extends JPanel{
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
	Validation validation = new Validation();
	private JDateChooser jdchooser1, jdchooser2;

	public ReportATMWithdrawal() {
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
		
		jdchooser1 = new JDateChooser();
		JPanel pn5 = new JPanel();
		JLabel lb5 = new JLabel("Từ ngày: ");
		pn5.add(lb5);
		pn5.add(jdchooser1);
		jdchooser1.setPreferredSize(txtKeywork.getPreferredSize());
		
		jdchooser2 = new JDateChooser();
		JPanel pn6 = new JPanel();
		JLabel lb6 = new JLabel("Đến ngày: ");
		pn6.add(lb6);
		pn6.add(jdchooser2);
		jdchooser2.setPreferredSize(txtKeywork.getPreferredSize());
		
		pnTop.add(pn1);
		pnTop.add(pn2);
		pnTop.add(pn4);
		pnTop.add(pn5);
		pnTop.add(pn6);
		pnTop.add(pn3);
		
		this.add(pnTop, BorderLayout.NORTH);
		
		table = new JTable();
		String col[] = { "STT", "Mã Giao dịch", "Tên KH", "Số TK", "Mã ATM", "Quận", "Phường", "Địa chỉ", "Thời gian", "Số tiền" };
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
		ArrayList<Withdrawal_model> dataTable = withdrawal.getRecordsWithCustomerAndATM(strWhere);

		Object[] row = new Object[10];
		int count = dataTable.size();
		dm.setRowCount(0);
		for (int i = 0; i < count; i++) {
			int j = i + 1;
			row[0] = j;
			row[1] = dataTable.get(i).getCode();
			row[2] = dataTable.get(i).getCusName();
			row[3] = dataTable.get(i).getSn_card();
			row[4] = dataTable.get(i).getAtm_code();
			row[5] = (String) AddressDB.getNameDistrictById(dataTable.get(i).getQuan());
			row[6] = (String) AddressDB.getNameWardById(dataTable.get(i).getPhuong());
			row[7] = dataTable.get(i).getAtmAddress();
			row[8] = dataTable.get(i).get_time();
			row[9] = dataTable.get(i).getNumber();
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
				strWhere += " AND atm.code = '"+ keyWord + "'";
			}
			
			if(val_district_id != 0) {
				strWhere += " AND atm.quan = "+ val_district_id;
			}
			
			if(val_ward_id != 0) {
				strWhere += " AND atm.phuong = "+ val_ward_id;
			}
			
			if(Validation.checkDuration(jdchooser1, jdchooser2)) {
				java.sql.Date sqldateFrom = new java.sql.Date(jdchooser1.getDate().getTime());
				java.sql.Date sqldateTo = new java.sql.Date(jdchooser2.getDate().getTime());

				strWhere += " AND trans.time > '"+ sqldateFrom +"' AND trans.time < '"+ sqldateTo +"'";
			}
			
			System.out.println(strWhere);
			tableRows(strWhere);
		}
	};
}
