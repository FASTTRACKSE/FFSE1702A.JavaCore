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
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import model.CustomerReport;
import model.CustomerReportDB;

public class CustomerWithdrawUI extends JPanel {

	private static final long serialVersionUID = 1L;
	String[] col = {"Mã khách hàng", "Họ tên","Máy ATM", "Mã giao dịch","Thời gian giao dịch","Số tiền đã rút"};
    DefaultTableModel mdlCustomerWithdraw = new DefaultTableModel(col, 0);
    JButton btnFilter;
    JTextField txtCode;
    JDateChooser dateFrom, dateTo;
    
    ActionListener evtFilter = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String code = txtCode.getText();
			boolean isDuration = Validation.checkDuration(dateFrom, dateTo);
			if (isDuration) {
				/*Sử dung Calendar để tính toán với ngày*/
				Calendar cldFrom = dateFrom.getCalendar();
				Calendar cldTo = dateTo.getCalendar();
				cldTo.add(Calendar.DATE, 1);
				double total = 0;
				
				ArrayList<CustomerReport> arr = CustomerReportDB.getTransactions(code, cldFrom, cldTo);
				/*Định dạng ngày*/
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date date = new Date();
				mdlCustomerWithdraw.setRowCount(0);
				for (CustomerReport cus : arr) {
					/*Chuyển Timestap sang String có định dạng*/
					Timestamp ts = cus.getTime();
					date.setTime(ts.getTime());
					String time = dateFormat.format(date);
					
					String[] row = {
							cus.getCustomer_code(),
							cus.getCustomer_name(),
							cus.getAtm_code(),
							cus.getCode(),
							time,
							String.format("%,d", (long)cus.getAmount())
					};
					
					total += cus.getAmount();
					mdlCustomerWithdraw.addRow(row);
				}
				
				String totalString = String.format("%,d",(long) total);
				String[] totalPrint = {"", "", "", "",
						"<html><b>TỔNG TIỀN",
						"<html><b>" + totalString + "</b></html>"};
				String[] emptyRow = {};
				mdlCustomerWithdraw.addRow(emptyRow);
				mdlCustomerWithdraw.addRow(totalPrint);
			}
		}
	};
	
	public CustomerWithdrawUI() {
		addPanel();
		addEvent();
	}
	
	void addPanel() {
		/*Panel chính*/
		this.setLayout(new BorderLayout());
		JPanel pnTitle = new JPanel();
		JPanel pnAction = new JPanel();
		this.add(pnTitle, BorderLayout.NORTH);
		this.add(pnAction, BorderLayout.CENTER);
		
		/*Panel chính -> Tiêu đề*/
		pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		JLabel lblTitle = new JLabel("BÁO CÁO TÌNH HÌNH RÚT TIỀN CỦA KHÁCH HÀNG");
		pnTitle.add(lblTitle);
		
		/*Panel chính -> Action*/
		pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.Y_AXIS));
		JPanel pnFilter = new JPanel();
		JScrollPane spCustomerWithdraw = new JScrollPane();
		pnAction.add(Box.createRigidArea(new Dimension(0, 10)));
		pnAction.add(pnFilter);
		pnAction.add(spCustomerWithdraw);
		pnAction.add(Box.createRigidArea(new Dimension(0, 5)));
		
		/*Panel chính -> Action -> Filter*/
		JPanel pnCode = new JPanel();
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
		dateTo = new JDateChooser();
		dateTo.setPreferredSize(new Dimension(100, 20));
		dateTo.setDateFormatString("dd/MM/yyyy");
		pnDuration.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		pnDuration.add(lblFrom);
		pnDuration.add(dateFrom);
		pnDuration.add(lblTo);
		pnDuration.add(dateTo);

		/*Panel chính -> Action -> Phải -> Danh sách khách hàng*/
		JTable tblCustomerWithdraw = new JTable();
        tblCustomerWithdraw.setModel(mdlCustomerWithdraw);
        spCustomerWithdraw.setViewportView(tblCustomerWithdraw);
	
	}
	
	void addEvent() {
		btnFilter.addActionListener(evtFilter);
	}

}
