package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import model.AddressDB;
import model.ComboItem;

public class ATMWithdraw extends JPanel {

	private static final long serialVersionUID = 1L;
	JScrollPane spATMWithdraw = new JScrollPane();
	JTable tblATMWithdraw = new JTable();
	String[] col = {"Mã máy ATM","Thời gian giao dịch","Số tiền đã rút"};
    DefaultTableModel mdlATMWithdraw = new DefaultTableModel(col, 0);
    JDateChooser dateFrom, dateTo;
    JComboBox<ComboItem> cbSelect, cbDistrict, cbWard;
    JTextField txtCode, txtStreet;
    CardLayout lyt;
    JPanel pnChoice;
    
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
	
	public ATMWithdraw() {
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
		JButton btnFilter = new JButton("Xem");
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
		cbSelect.addActionListener(evtSelect);
		cbDistrict.addActionListener(new DistrictSelectEvent(cbDistrict, cbWard));
	}

}
