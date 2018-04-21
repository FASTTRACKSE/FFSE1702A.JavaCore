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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import model.MySQL;

public class InvoiceUI extends JFrame {
	JTextField txtSearch1, txtMeterID, txtDateAdded, txtMeterIndex;
	JButton btnSearch1, btnAdd, btnEdit, btnDel;
	JTable jt = new JTable(new DefaultTableModel(
			new Object[] { "Mã biên lai", "Mã Công tơ", "Ngày nhập", "Chu kì nhập", "Chỉ số công tơ", "Số tiền" }, 0));
	JMonthChooser jmc;
	JYearChooser jyc;

	public InvoiceUI(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		showWindow();
		addControls();
		addEvents();
	}

	public void showWindow() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	void addControls() {
		Container con = getContentPane();

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Quản lí biên lai");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pn1 = new JPanel();
		JLabel lblSearch1 = new JLabel("Mã công tơ");
		txtSearch1 = new JTextField(15);
		btnSearch1 = new JButton("Tìm kiếm");
		pn1.add(lblSearch1);
		pn1.add(txtSearch1);
		pn1.add(btnSearch1);

		JPanel pn3 = new JPanel();
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		pn3.add(btnAdd);
		pn3.add(btnEdit);
		pn3.add(btnDel);

		JScrollPane pn4 = new JScrollPane(jt);

		JPanel pn5 = new JPanel();
		JLabel lblMeterID = new JLabel("Mã công tơ");
		lblMeterID.setPreferredSize(new Dimension(90, 15));
		txtMeterID = new JTextField(15);
		txtMeterID.setPreferredSize(new Dimension(90, 20));
		// txtMeterID.setEditable(false);
		pn5.add(lblMeterID);
		pn5.add(txtMeterID);

		JPanel pn6 = new JPanel();
		JLabel lblDateAdded = new JLabel("Ngày nhập");
		lblDateAdded.setPreferredSize(new Dimension(90, 15));
		txtDateAdded = new JTextField(15);
		txtDateAdded.setEditable(false);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		txtDateAdded.setText(dateFormat.format(date));
		pn6.add(lblDateAdded);
		pn6.add(txtDateAdded);

		JPanel pn7 = new JPanel();
		JLabel lblMonth = new JLabel("Chu kì nhập");
		lblMonth.setPreferredSize(new Dimension(100, 15));
		jmc = new JMonthChooser();
		jyc = new JYearChooser();
		pn7.add(lblMonth);
		pn7.add(jmc);
		pn7.add(jyc);

		JPanel pn9 = new JPanel();
		JLabel lblMeterIndex = new JLabel("Chỉ số công tơ");
		lblMeterIndex.setPreferredSize(new Dimension(90, 15));
		txtMeterIndex = new JTextField(15);
		pn9.add(lblMeterIndex);
		pn9.add(txtMeterIndex);

		pnMain.add(pnTitle);
		pnMain.add(pn1);
		pnMain.add(pn4);
		pnMain.add(pn3);
		pnMain.add(pn5);
		pnMain.add(pn6);
		pnMain.add(pn7);
		pnMain.add(pn9);

		con.add(pnMain);
	}

	void addEvents() {
		btnSearch1.addActionListener(eventAddDataToTable);
		btnAdd.addActionListener(eventAddInvoice);
		jt.addMouseListener(eventDataToTextField);
		btnEdit.addActionListener(eventEditInvoice);
		btnDel.addActionListener(eventDelInvoice);
	}

	ActionListener eventAddDataToTable = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ResultSet invoiceList = MySQL.getInvoice(txtSearch1.getText());
			DefaultTableModel model = (DefaultTableModel) jt.getModel();
			model.setRowCount(0);
			try {
				addDataToTable(invoiceList, model);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};

	ActionListener eventAddInvoice = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (txtMeterID.getText().equals("") || txtMeterIndex.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
			} else {
				String meterID = txtMeterID.getText();
				String dateAdded = txtDateAdded.getText();
				int month = jmc.getMonth() + 1;
				int year = jyc.getYear();
				//

				String cycle = year + "/" + month;
				DateFormat df = new SimpleDateFormat("yyyy/MM");
				Date cycleDate;
				try {
					cycleDate = df.parse(cycle);
				} catch (ParseException e1) {
					cycleDate = new Date();
					e1.printStackTrace();
				}
				// Calendar cal = Calendar.getInstance();
				// cal.setTime(cycleDate);

				int recentMeterIndex = Integer.parseInt(txtMeterIndex.getText());

				int meterNumber = 0;
				int lastestMeterIndex = 0;
				ResultSet lastestInvoice = MySQL.getLastestInvoice(meterID);
				try {
					while (lastestInvoice.next()) {
						lastestMeterIndex = lastestInvoice.getInt("MeterIndex");
					}
					meterNumber = recentMeterIndex - lastestMeterIndex;
					int amount = calcAmount(meterNumber);
					if (MySQL.addInvoice(meterID, dateAdded, cycleDate, recentMeterIndex, amount)) {
						JOptionPane.showMessageDialog(null, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Thêm thất bại");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};

	MouseListener eventDataToTextField = new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			getDataToTextField();
		}
	};

	ActionListener eventEditInvoice = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (jt.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Hãy chọn dòng muốn sửa");
			} else {
				if (txtMeterIndex.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
				} else {
					try {
						editInvoice();
						int row = jt.getSelectedRow();
						int col = jt.getSelectedColumn();
						btnSearch1.doClick();
						jt.requestFocus();
						jt.changeSelection(row, col, false, false);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	};

	ActionListener eventDelInvoice = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (jt.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Hãy chọn dòng muốn xóa");
			} else {
				delInvoice();
				DefaultTableModel model = (DefaultTableModel) jt.getModel();
				model.removeRow(jt.getSelectedRow());
			}
		}
	};

	void addDataToTable(ResultSet customerList, DefaultTableModel model) throws SQLException {
		Object[] row = new Object[6];
		while (customerList.next()) {
			for (int i = 1; i <= 6; ++i) {
				row[i - 1] = customerList.getString(i); // Or even rs.getObject()
			}
			model.addRow(row);
		}

	}

	void getDataToTextField() {
		int row = jt.getSelectedRow();

		String month = (String) jt.getValueAt(row, 3);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(month);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		txtMeterID.setText((String) jt.getValueAt(row, 1));
		txtDateAdded.setText((String) jt.getValueAt(row, 2));
		jmc.setMonth(cal.get(Calendar.MONTH));
		jyc.setYear(cal.get(Calendar.YEAR));
		txtMeterIndex.setText((String) jt.getValueAt(row, 4));
	}

	int calcAmount(int meterNumber) throws SQLException {
		int rate[] = { 0, 1549, 1600, 1858, 2340, 2615, 2701 };
		int step[] = { 0, 50, 50, 100, 100, 100 };
		int i = 1;
		int subtotal, total = 0;
		while (meterNumber > 0) {
			if (i < 6) {
				meterNumber = meterNumber - step[i];
				if (meterNumber > 0) {
					subtotal = step[i] * rate[i];
					total += subtotal;
				} else {
					subtotal = (meterNumber + step[i]) * rate[i];
					total += subtotal;
				}
				i++;
			} else {
				subtotal = meterNumber * rate[i];
				total += subtotal;
				break;
			}
		}
		return total;
	}

	void editInvoice() throws SQLException {
		int invoiceID = Integer.parseInt((String) jt.getValueAt(jt.getSelectedRow(), 0));
		String meterID = (String) jt.getValueAt(jt.getSelectedRow(), 1);
		ResultSet preInvoice = MySQL.getLastestInvoiceForEdit(meterID, invoiceID);
		int preMeterIndex = 0;
		while (preInvoice.next()) {
			preMeterIndex = preInvoice.getInt("meterIndex");
		}

		int month = jmc.getMonth() + 1;
		int year = jyc.getYear();
		//
		String cycle = year + "/" + month;
		DateFormat df = new SimpleDateFormat("yyyy/MM");
		Date cycleDate;
		try {
			cycleDate = df.parse(cycle);
		} catch (ParseException e1) {
			cycleDate = new Date();
			e1.printStackTrace();
		}

		int recentMeterIndex = Integer.parseInt(txtMeterIndex.getText());
		int meterNumber = recentMeterIndex - preMeterIndex;
		int amount = calcAmount(meterNumber);
		if (MySQL.editInvoice(cycleDate, txtMeterIndex.getText(), amount, invoiceID)) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Sửa thất bại");
		}
	}

	void delInvoice() {
		String invoiceID = (String) jt.getValueAt(jt.getSelectedRow(), 0);
		if (MySQL.delInvoice(invoiceID)) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}

}
