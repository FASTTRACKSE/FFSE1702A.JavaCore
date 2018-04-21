package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import model.CustomerReport;
import model.CustomerReportDB;
import model.User;

public class CustomerWithdrawUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] col;
	private DefaultTableModel mdlCustomerWithdraw;
	private JPanel pnFilter, pnCode;
	JScrollPane spCustomerWithdraw;
	private JButton btnFilter;
	private JTextField txtCode;
	private JDateChooser dateFrom, dateTo;
	private JLabel lblTotal, lblTitle;
	User user;

	private ActionListener evtFilter = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			String code;
			if (user.getRole() == 1) {
				code = txtCode.getText().trim();
			} else {
				code = user.getCustomerCode();
			}
			boolean isDuration = Validation.checkDuration(dateFrom, dateTo);
			if (isDuration) {
				/* Sử dung Calendar để tính toán với ngày */
				Calendar cldFrom = dateFrom.getCalendar();
				Calendar cldTo = dateTo.getCalendar();
				cldTo.add(Calendar.DATE, 1);
				double total = 0;

				ArrayList<CustomerReport> arr = CustomerReportDB.getTransactions(code, cldFrom, cldTo);
				/* Định dạng ngày */
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date date = new Date();
				mdlCustomerWithdraw.setRowCount(0);
				for (CustomerReport cus : arr) {
					/* Chuyển Timestap sang String có định dạng */
					Timestamp ts = cus.getTime();
					date.setTime(ts.getTime());
					String time = dateFormat.format(date);
					String[] row;
					if (user.getRole() == 1) {

						row = new String[] { cus.getCustomer_code(), cus.getCustomer_name(),
								cus.getAtm_code(), cus.getCode(), time,
								String.format("%,d", (long) cus.getAmount()) };
					} else {
						
						row = new String[] {  cus.getCode(),time, String.format("%,d", (long) cus.getAmount()) };
					}

					total += cus.getAmount();
					mdlCustomerWithdraw.addRow(row);
				}

				String totalString = String.format("%,d", (long) total);
				String totalTitle = "<html><p style='font-size:10px'><b>TỔNG TIỀN: " + totalString
						+ " VND</b></p></html>";
				lblTotal.setText(totalTitle);
			}
		}
	};

	public CustomerWithdrawUI(User user) {
		this.user = user;
		addPanel();
		if (user.getRole() == 1) {
			addPanelsAdmin();
		} else {
			addPanelsCustomer();
		}
		addEvent();
	}

	private void addPanel() {
		/* Panel chính */
		this.setLayout(new BorderLayout());
		JPanel pnTitle = new JPanel();
		JPanel pnAction = new JPanel();
		JPanel pnTotal = new JPanel();
		this.add(pnTitle, BorderLayout.NORTH);
		this.add(pnAction, BorderLayout.CENTER);
		this.add(pnTotal, BorderLayout.SOUTH);

		/* Panel chính -> Tiêu đề */
		pnTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		String title = "<html><p style='font-size:12px'>BÁO CÁO TÌNH HÌNH RÚT TIỀN CỦA KHÁCH HÀNG</p></html>";
		lblTitle = new JLabel(title);
		pnTitle.add(lblTitle);

		/* Panel chính -> Tông tiền */
		pnTotal.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 5));
		lblTotal = new JLabel("<html><p style='font-size:10px'><b>TỔNG TIỀN: 0 VND</b></p></html>");
		pnTotal.add(lblTotal);

		/* Panel chính -> Action */
		pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.Y_AXIS));
		pnFilter = new JPanel();
		spCustomerWithdraw = new JScrollPane();
		pnAction.add(Box.createRigidArea(new Dimension(0, 10)));
		pnAction.add(pnFilter);
		pnAction.add(spCustomerWithdraw);
		pnAction.add(Box.createRigidArea(new Dimension(0, 5)));

		/* Panel chính -> Action -> Filter */
		pnCode = new JPanel();
		JPanel pnDuration = new JPanel();
		btnFilter = new JButton("Xem");
		pnFilter.setLayout(new FlowLayout(FlowLayout.LEADING));
		pnFilter.add(pnCode);
		pnFilter.add(pnDuration);
		pnFilter.add(btnFilter);

		JLabel lblCode = new JLabel("Mã khách hàng:");
		txtCode = new JTextField(15);
		pnCode.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		pnCode.add(lblCode);
		pnCode.add(txtCode);

		JLabel lblFrom = new JLabel("Thời gian từ:");
		JLabel lblTo = new JLabel("đến:");
		dateFrom = new JDateChooser();
		dateFrom.setPreferredSize(new Dimension(100, 20));
		dateFrom.setDateFormatString("dd/MM/yyyy");
		JTextFieldDateEditor editorFrom = (JTextFieldDateEditor) dateFrom.getDateEditor();
		editorFrom.setEditable(false);
		dateTo = new JDateChooser();
		dateTo.setPreferredSize(new Dimension(100, 20));
		dateTo.setDateFormatString("dd/MM/yyyy");
		JTextFieldDateEditor editorTo = (JTextFieldDateEditor) dateTo.getDateEditor();
		editorTo.setEditable(false);
		pnDuration.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		pnDuration.add(lblFrom);
		pnDuration.add(dateFrom);
		pnDuration.add(lblTo);
		pnDuration.add(dateTo);
	}
	
	private void addPanelsAdmin() {

		/* Panel chính -> Action -> Phải -> Danh sách khách hàng */
		JTable tblCustomerWithdraw = new JTable();
		col = new String[]{ "Mã khách hàng", "Họ tên", "Máy ATM", "Mã giao dịch", "Thời gian giao dịch", "Số tiền đã rút" };
		mdlCustomerWithdraw = new DefaultTableModel(col, 0);
		tblCustomerWithdraw.setModel(mdlCustomerWithdraw);
		tblCustomerWithdraw.getColumnModel().setColumnMargin(10);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblCustomerWithdraw.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		spCustomerWithdraw.setViewportView(tblCustomerWithdraw);
	}
	
	private void addPanelsCustomer() {
		String title = "<html><p style='font-size:12px'>LỊCH SỬ GIAO DỊCH CÁ NHÂN</p></html>";
		lblTitle.setText(title);
		pnFilter.remove(pnCode);

		/* Panel chính -> Action -> Phải -> Danh sách khách hàng */
		JTable tblCustomerWithdraw = new JTable();
		col = new String[]{"Mã giao dịch", "Thời gian giao dịch", "Số tiền đã rút" };
		mdlCustomerWithdraw = new DefaultTableModel(col, 0);
		tblCustomerWithdraw.setModel(mdlCustomerWithdraw);
		tblCustomerWithdraw.getColumnModel().setColumnMargin(10);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblCustomerWithdraw.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		
		spCustomerWithdraw.setViewportView(tblCustomerWithdraw);

	}

	private void addEvent() {
		btnFilter.addActionListener(evtFilter);
	}


}
