package ui;

import java.util.Date;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.ZonedDateTime;
import java.util.Calendar;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import model.MySQL;

public class StatisticUI extends JFrame {
	JComboBox cb, cb1, cb2;
	JPanel pnSL;
	JMonthChooser jmcStart, jmcEnd, jmcPn3;
	JYearChooser jycPn1, jycStart, jycEnd, jycPn3;
	JTextField txtSearch;
	JButton btnSearch2, btnSearch3, btnSearch4;
	JTable jt = new JTable(new DefaultTableModel(new Object[] { "Mã khách hàng", "Mã công tơ", "Tên khách hàng",
			"Địa chỉ", "Quận", "Phường", "Điện thoại", "Email", "Chu kì", "Số tiền" }, 0));

	public StatisticUI(String arg0) throws HeadlessException, SQLException {
		super(arg0);
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
		JLabel lblTitle = new JLabel("Thống kê");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pn1 = new JPanel();
		JLabel lblSearch = new JLabel("Tên khách hàng");
		txtSearch = new JTextField(15);
		// btnSearch1 = new JButton("Tìm kiếm");
		pn1.add(lblSearch);
		pn1.add(txtSearch);
		// pn1.add(btnSearch1);

		JPanel pn2 = new JPanel();
		JLabel lblCounty = new JLabel("Quận");
		String County[] = {};
		cb1 = new JComboBox(County);
		cb1.setPreferredSize(new Dimension(115, 20));
		JLabel lblWard = new JLabel("Phường");
		String Ward[] = {};
		cb2 = new JComboBox(Ward);
		cb2.setPreferredSize(new Dimension(115, 20));
		pn2.add(lblCounty);
		pn2.add(cb1);
		pn2.add(lblWard);
		pn2.add(cb2);

		JPanel pn3 = new JPanel();
		// pn3.setLayout(new BoxLayout(pn3, BoxLayout.X_AXIS));

		JPanel pnRB = new JPanel();
		String comboBoxItems[] = { "Theo năm", "Theo khoảng thời gian", "Theo kì" };
		cb = new JComboBox(comboBoxItems);
		pnRB.add(cb);

		pnSL = new JPanel(new CardLayout());
		JPanel pnYear = new JPanel();
		jycPn1 = new JYearChooser();
		btnSearch2 = new JButton("Tìm kiếm");
		pnYear.add(jycPn1);
		pnYear.add(btnSearch2);
		JPanel pnInterval = new JPanel();
		jmcStart = new JMonthChooser();
		jycStart = new JYearChooser();
		jmcEnd = new JMonthChooser();
		jycEnd = new JYearChooser();
		JLabel lblStart = new JLabel("Bắt đầu");
		JLabel lblEnd = new JLabel("Kết thúc");
		btnSearch3 = new JButton("Tìm kiếm");
		pnInterval.add(lblStart);
		pnInterval.add(jmcStart);
		pnInterval.add(jycStart);
		pnInterval.add(lblEnd);
		pnInterval.add(jmcEnd);
		pnInterval.add(jycEnd);
		pnInterval.add(btnSearch3);
		JPanel pnTerm = new JPanel();
		jmcPn3 = new JMonthChooser();
		jycPn3 = new JYearChooser();
		btnSearch4 = new JButton("Tìm kiếm");
		pnTerm.add(jmcPn3);
		pnTerm.add(jycPn3);
		pnTerm.add(btnSearch4);
		pnSL.add(pnYear, "0");
		pnSL.add(pnInterval, "1");
		pnSL.add(pnTerm, "2");
		pn3.add(pnRB);
		pn3.add(pnSL);

		JScrollPane pn4 = new JScrollPane(jt);

		pnMain.add(pnTitle);
		pnMain.add(pn1);
		pnMain.add(pn2);
		pnMain.add(pn3);
		pnMain.add(pn4);

		con.add(pnMain);

		Object str = "Tất cả";
		cb1.addItem(str);
		cb2.addItem(str);
		addComboBoxCounty(MySQL.getCounty(), cb1);

		// cb1.setRenderer(new MyComboBoxRenderer("Chọn quận"));
		// cb1.setSelectedIndex(-1);
	}

	void addEvents() {
		cb.addActionListener(eventChangeCB);
		cb1.addActionListener(eventChangeCounty);
		btnSearch2.addActionListener(eventAddDataToTable1);
		btnSearch3.addActionListener(eventAddDataToTable2);
		btnSearch4.addActionListener(eventAddDataToTable3);
	}

	ActionListener eventChangeCB = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			CardLayout cl = (CardLayout) (pnSL.getLayout());
			cl.show(pnSL, Integer.toString(cb.getSelectedIndex()));
		}
	};

	ActionListener eventChangeCounty = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cb2.removeAllItems();
			int countyID = cb1.getSelectedIndex();
			Object str = "Tất cả";
			cb2.addItem(str);
			try {
				addComboBoxWard(MySQL.getWard(countyID), cb2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	ActionListener eventAddDataToTable1 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customerName = txtSearch.getText();
			String countyName = (String) cb1.getSelectedItem();
			String wardName = (String) cb2.getSelectedItem();
			String cycle = Integer.toString(jycPn1.getYear());

			if (countyName.equals("Tất cả")) {
				countyName = "";
			}
			if(wardName.equals("Tất cả")) {
				wardName="";
			}

			ResultSet data = MySQL.getDataBySearch1(customerName, countyName, wardName, cycle);

			DefaultTableModel model = (DefaultTableModel) jt.getModel();
			model.setRowCount(0);
			try {
				addDataToTable(data, model);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};

	ActionListener eventAddDataToTable2 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customerName = txtSearch.getText();
			String countyName = (String) cb1.getSelectedItem();
			String wardName = (String) cb2.getSelectedItem();
			
			int monthStart = jmcStart.getMonth() + 1;
			int monthEnd = jmcEnd.getMonth() + 1;

			String cycleStart = jycStart.getYear() + "/" + monthStart;
			String cycleEnd = jycEnd.getYear() + "/" + monthEnd;

			DateFormat df = new SimpleDateFormat("yyyy/MM");

			Date cycleStartDate = null;
			Date cycleEndDate = null;
			try {
				cycleStartDate = df.parse(cycleStart);
				cycleEndDate = df.parse(cycleEnd);
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (countyName.equals("Tất cả")) {
				countyName = "";
			}
			if(wardName.equals("Tất cả")) {
				wardName="";
			}

			ResultSet data = MySQL.getDataBySearch2(customerName, countyName, wardName, cycleStartDate, cycleEndDate);

			DefaultTableModel model = (DefaultTableModel) jt.getModel();
			model.setRowCount(0);
			try {
				addDataToTable(data, model);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	ActionListener eventAddDataToTable3 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customerName = txtSearch.getText();
			String countyName = (String) cb1.getSelectedItem();
			String wardName = (String) cb2.getSelectedItem();
			
			int month = jmcPn3.getMonth() + 1;

			String cycle = jycPn3.getYear() + "/" + month;

			DateFormat df = new SimpleDateFormat("yyyy/MM");

			Date cycleDate = null;
			try {
				cycleDate = df.parse(cycle);
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (countyName.equals("Tất cả")) {
				countyName = "";
			}
			if(wardName.equals("Tất cả")) {
				wardName="";
			}

			ResultSet data = MySQL.getDataBySearch3(customerName, countyName, wardName, cycleDate);

			DefaultTableModel model = (DefaultTableModel) jt.getModel();
			model.setRowCount(0);
			try {
				addDataToTable(data, model);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
		Object[] row = new Object[10];
		while (customerList.next()) {
			for (int i = 1; i <= 10; ++i) {
				row[i - 1] = customerList.getString(i); // Or even rs.getObject()
			}
			model.addRow(row);
		}

	}

}
