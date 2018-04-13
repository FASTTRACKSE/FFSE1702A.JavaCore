package ui;

import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;

import model.AddressDB;
import model.ComboItem;

public class CustomerReport extends JPanel {

	private static final long serialVersionUID = 1L;
	String[] col = {"Mã khách hàng","Họ tên","Mã ATM", "Mã giao dịch","Thời gian giao dịch","Số tiền đã rút"};
    DefaultTableModel mdlCustomerList = new DefaultTableModel(col, 0);
    JButton btnFilter;
    JComboBox<ComboItem> cbDistrict, cbWard;
    
    ActionListener evtFilter = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public CustomerReport() {
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
		JLabel lblTitle = new JLabel("BÁO CÁO KHÁCH HÀNG");
		pnTitle.add(lblTitle);
		
		/*Panel chính -> Action*/
		pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.Y_AXIS));
		JPanel pnFilter = new JPanel();
		JScrollPane spCustomerList = new JScrollPane();
		pnAction.add(Box.createRigidArea(new Dimension(0, 10)));
		pnAction.add(pnFilter);
		pnAction.add(spCustomerList);
		pnAction.add(Box.createRigidArea(new Dimension(0, 5)));
		
		/*Panel chính -> Action -> Filter*/
		JPanel pnAddress = new JPanel();
		btnFilter = new JButton("Xem");
		pnFilter.setLayout(new FlowLayout(FlowLayout.LEADING));
		pnFilter.add(pnAddress);
		pnFilter.add(btnFilter);
		
		JLabel lblAddress = new JLabel("Chọn vị trí:");
		cbDistrict = new JComboBox<>();
		cbDistrict.setPreferredSize(new Dimension(100, 20));
		AddressDB.setDistricts(cbDistrict);
		cbWard = new JComboBox<>();
		cbWard.setPreferredSize(new Dimension(100, 20));
		ComboItem itemWard = new ComboItem(0, "Chọn phường");
		cbWard.addItem(itemWard);

		pnAddress.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		pnAddress.add(lblAddress);
		pnAddress.add(cbDistrict);
		pnAddress.add(cbWard);

		/*Panel chính -> Action -> Phải -> Danh sách khách hàng*/
		JTable tblCustomerList = new JTable();
        tblCustomerList.setModel(mdlCustomerList);
        spCustomerList.setViewportView(tblCustomerList);
	
	}
	
	void addEvent() {
		btnFilter.addActionListener(evtFilter);
		cbDistrict.addActionListener(new DistrictSelectEvent(cbDistrict, cbWard));
	}

}
