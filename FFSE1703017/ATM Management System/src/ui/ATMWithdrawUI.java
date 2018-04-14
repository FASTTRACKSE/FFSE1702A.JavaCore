package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import model.ATMReportDB;
import model.AddressDB;
import model.ComboItem;
import model.Transaction;

public class ATMWithdrawUI extends JPanel {

	private static final long serialVersionUID = 1L;
	JScrollPane spATMWithdraw = new JScrollPane();
	JTable tblATMWithdraw = new JTable();
	String[] col = {"Mã máy ATM", "Mã khách hàng","Mã giao dịch", "Thời gian giao dịch","Số tiền đã rút"};
    DefaultTableModel mdlATMWithdraw = new DefaultTableModel(col, 0);
    JDateChooser dateFrom, dateTo;
    JComboBox<ComboItem> cbSelect, cbDistrict, cbWard;
    JTextField txtCode, txtStreet;
    CardLayout lyt;
    JPanel pnChoice;
    JButton btnFilter;
    
    ActionListener evtSelect = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = cbSelect.getSelectedIndex();
			if (i == 1) {
				lyt.show(pnChoice, "2");
			} else {
				lyt.show(pnChoice, "1");
			}
		}
	};
	
	ActionListener evtFilter = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = cbSelect.getSelectedIndex();
			boolean isDuration = Validation.checkDuration(dateFrom, dateTo);
			if (isDuration) {
				
				/*Sử dung Calendar để tính toán với ngày*/
				Calendar cldFrom = dateFrom.getCalendar();
				Calendar cldTo = dateTo.getCalendar();
				cldTo.add(Calendar.DATE, 1);
				
				ArrayList<Transaction> arr;
				
				if (i == 1 ) {
					String code = txtCode.getText();
					arr = ATMReportDB.getTransactionByCode(code, cldFrom, cldTo);
					
				} else {
					ComboItem itemD = (ComboItem) cbDistrict.getSelectedItem();
					int districtID = itemD.getKey();
					ComboItem itemW = (ComboItem) cbWard.getSelectedItem();
					int wardID = itemW.getKey();
					String street = txtStreet.getText();
					
					arr = ATMReportDB.getTransactionByAddress(
							districtID, wardID, street, cldFrom, cldTo);
				}
				
				/*Định dạng ngày*/
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date date = new Date();
				mdlATMWithdraw.setRowCount(0);
				for (Transaction tran : arr) {
					/*Chuyển Timestap sang String có định dạng*/
					Timestamp ts = tran.getTime();
					date.setTime(ts.getTime());
					String time = dateFormat.format(date);
					
					String[] row = {
							tran.getAtm_code(),
							tran.getCard_sn(),
							tran.getCode(),
							time,
							String.format("%,d", (long)tran.getAmount())
					};
					
					mdlATMWithdraw.addRow(row);
				}
				
			}

		}
	};
	
	public ATMWithdrawUI() {
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
		JLabel lblTitle = new JLabel("TÌNH HÌNH RÚT TIỀN CỦA MÁY ATM");
		pnTitle.add(lblTitle);
		
		/*Panel chính -> Action*/
		pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.Y_AXIS));
		JPanel pnFilter = new JPanel();
		pnAction.add(Box.createRigidArea(new Dimension(0, 10)));
		pnAction.add(pnFilter);
		pnAction.add(spATMWithdraw);
		pnAction.add(Box.createRigidArea(new Dimension(0, 5)));
		
		/*Panel chính -> Action -> Filter*/
		JPanel pnSelection = new JPanel();
		JPanel pnDuration = new JPanel();
		btnFilter = new JButton("Xem");
		pnFilter.setLayout(new FlowLayout(FlowLayout.LEADING));
		pnFilter.add(pnSelection);
		pnFilter.add(pnDuration);
		pnFilter.add(btnFilter);
		
		/*Panel chính -> Action -> Filter -> Selection*/
		JPanel pnSelect = new JPanel();
		pnChoice = new JPanel();
		pnSelection.add(pnSelect);
		pnSelection.add(pnChoice);
		
		/*Panel chính -> Action -> Filter -> Selection -> Select*/
		JLabel lblSelect = new JLabel("Theo:");
		cbSelect = new JComboBox<>();
		cbSelect.setPreferredSize(new Dimension(65, 20));
		cbSelect.addItem(new ComboItem(0, "Vị trí"));
		cbSelect.addItem(new ComboItem(1, "Mã máy"));
		cbSelect.setSelectedIndex(0);
		pnSelect.add(lblSelect);
		pnSelect.add(cbSelect);
		
		/*Panel chính -> Action -> Filter -> Selection -> Choice*/
		JPanel pnCode = new JPanel();
		JPanel pnLocation = new JPanel();
		lyt = new CardLayout();
		pnChoice.setLayout(lyt);
		pnChoice.add(pnLocation, "1");
		pnChoice.add(pnCode, "2");
		
		JLabel lblCode = new JLabel("Mã máy ATM:");
		txtCode = new JTextField(15);
		pnCode.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		pnCode.add(lblCode);
		pnCode.add(txtCode);
		
		JLabel lblDistrict = new JLabel("Chọn vị trí:");
		cbDistrict = new JComboBox<>();
		cbDistrict.setPreferredSize(new Dimension(100, 20));
		AddressDB.setDistricts(cbDistrict);
		cbWard = new JComboBox<>();
		cbWard.setPreferredSize(new Dimension(100, 20));
		ComboItem itemWard = new ComboItem(0, "Chọn phường");
		cbWard.addItem(itemWard);
		txtStreet = new JTextField(15);
		pnLocation.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		pnLocation.add(lblDistrict);
		pnLocation.add(cbDistrict);
		pnLocation.add(cbWard);
		pnLocation.add(txtStreet);
	
		/*Panel chính -> Action -> Filter -> Duration*/
		JLabel lblFrom = new JLabel("Thời gian từ:");
		JLabel lblTo = new JLabel("đến:");
		dateFrom = new JDateChooser();
		dateFrom.setPreferredSize(new Dimension(100, 20));
		dateFrom.setDateFormatString("dd/MM/yyyy");
		dateTo = new JDateChooser();
		dateTo.setPreferredSize(new Dimension(100, 20));
		dateTo.setDateFormatString("dd/MM/yyyy");
		pnDuration.add(lblFrom);
		pnDuration.add(dateFrom);
		pnDuration.add(lblTo);
		pnDuration.add(dateTo);

		/*Panel chính -> Action -> Phải -> Danh sách máy ATM*/
        tblATMWithdraw.setModel(mdlATMWithdraw);
        spATMWithdraw.setViewportView(tblATMWithdraw);
	
	}
	
	void addEvent() {
		btnFilter.addActionListener(evtFilter);
		cbSelect.addActionListener(evtSelect);
		cbDistrict.addActionListener(new DistrictSelectEvent(cbDistrict, cbWard));
	}

}
