package atm_ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import atm_model.AddressDB;
import atm_model.Withdrawal_model;

public class ReportCustomerWithdrawal extends JPanel {
	private JPanel pnTop;
	private JComboBox<Item> cbDistrict, cbWard;
	private JButton btn_search;
	private JTable table;
	private DefaultTableModel dm;
	AddressDB addressDB = new AddressDB();
	Withdrawal_model withdrawal = new Withdrawal_model();
	Validation validation = new Validation();
	private JDateChooser jdchooser1, jdchooser2;
	private JTextField txtKeywork;

	public ReportCustomerWithdrawal() {
		initialize();
		addEvents();
	}

	public void initialize() {
		setLayout(new BorderLayout());
		// pnTop
		pnTop = new JPanel();
		pnTop.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JPanel pn1 = new JPanel();
		txtKeywork = new JTextField("Mã khách hàng");
		txtKeywork.setPreferredSize(new Dimension(150,25));
		txtKeywork.setForeground(Color.GRAY);
		pn1.add(txtKeywork);
		txtKeywork.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtKeywork.getText().equals("Mã khách hàng")) {
					txtKeywork.setText("");
					txtKeywork.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtKeywork.getText().isEmpty()) {
					txtKeywork.setForeground(Color.GRAY);
					txtKeywork.setText("Mã khách hàng");
				}
			}
		});
		
		JPanel pn2 = new JPanel();
		btn_search = new JButton("Tìm kiếm");
		pn2.add(btn_search);
		
		jdchooser1 = new JDateChooser();
		JPanel pn3 = new JPanel();
		JLabel lb3 = new JLabel("Từ ngày: ");
		pn3.add(lb3);
		pn3.add(jdchooser1);
		jdchooser1.setPreferredSize(txtKeywork.getPreferredSize());
		
		jdchooser2 = new JDateChooser();
		JPanel pn4 = new JPanel();
		JLabel lb4 = new JLabel("Đến ngày: ");
		pn4.add(jdchooser2);
		pn3.add(lb4);
		jdchooser2.setPreferredSize(txtKeywork.getPreferredSize());

		pnTop.add(pn1);
		pnTop.add(pn3);
		pnTop.add(pn4);
		pnTop.add(pn2);

		this.add(pnTop, BorderLayout.NORTH);

		table = new JTable();
		String col[] = { "STT", "Tên KH", "Số thẻ", "Quận", "Phường", "Địa chỉ", "Mã GD", "Thời gian", "Số tiền" };
		dm = new DefaultTableModel(col, 0);
		JScrollPane scroll = new JScrollPane(table);
		table.setModel(dm);
		table.setRowHeight(20);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách giao dịch"));
		this.add(scroll, BorderLayout.CENTER);
		String strWhere = " AND cus.isactive = 0 ";
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
			row[8] = dataTable.get(i).getNumber();
			dm.addRow(row);
		}
	}

	public void addEvents() {
		btn_search.addActionListener(evSearch);
	}

	ActionListener evSearch = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String maKH = txtKeywork.getText();
			String strWhere = "";

			if (!maKH.equals("") || !maKH.equals(null)) {
				strWhere += " AND cus.code = '" + maKH + "'";
			}
			
			if(validation.checkDuration(jdchooser1, jdchooser2)) {
				java.sql.Date sqldateFrom = new java.sql.Date(jdchooser1.getDate().getTime());
				java.sql.Date sqldateTo = new java.sql.Date(jdchooser2.getDate().getTime());

				strWhere += " AND time > '"+ sqldateFrom +"' AND time < '"+ sqldateTo +"'";
				
				tableRows(strWhere);
			}
		}
	};
}
