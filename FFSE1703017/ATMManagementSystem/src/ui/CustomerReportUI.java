package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.AddressDB;
import model.ComboItem;
import model.CustomerReport;
import model.CustomerReportDB;

public class CustomerReportUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] col = { "Mã khách hàng", "Họ tên", "Số điện thoại", "Số iền trong TK", "Tổng tiền đã rút" };
	private DefaultTableModel mdlCustomerList = new DefaultTableModel(col, 0);
	private JButton btnFilter;
	private JComboBox<ComboItem> cbDistrict, cbWard;

	private ActionListener evtFilter = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = cbDistrict.getSelectedIndex();
			if (i > 0) {
				ComboItem itemD = (ComboItem) cbDistrict.getSelectedItem();
				int districtID = itemD.getKey();
				ComboItem itemW = (ComboItem) cbWard.getSelectedItem();
				int wardID = itemW.getKey();
				ArrayList<CustomerReport> arr = CustomerReportDB.getCustomers(districtID, wardID);
				mdlCustomerList.setRowCount(0);
				for (CustomerReport cus : arr) {
					String[] row = { cus.getCustomer_code(), cus.getCustomer_name(), cus.getPhone(),
							String.format("%,d", (long) cus.getCustomer_amount()),
							String.format("%,d", (long) cus.getCustomer_withdraw()) };
					mdlCustomerList.addRow(row);
				}
			} else {
				mdlCustomerList.setRowCount(0);
				cbDistrict.showPopup();
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn quận.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	public CustomerReportUI() {
		addPanel();
		addEvent();
	}

	private void addPanel() {
		/* Panel chính */
		this.setLayout(new BorderLayout());
		JPanel pnTitle = new JPanel();
		JPanel pnAction = new JPanel();
		this.add(pnTitle, BorderLayout.NORTH);
		this.add(pnAction, BorderLayout.CENTER);

		/* Panel chính -> Tiêu đề */
		pnTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		String title = "<html><p style='font-size:12px'>BÁO CÁO KHÁCH HÀNG</p></html>";
		JLabel lblTitle = new JLabel(title);
		pnTitle.add(lblTitle);

		/* Panel chính -> Action */
		pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.Y_AXIS));
		JPanel pnFilter = new JPanel();
		JScrollPane spCustomerList = new JScrollPane();
		pnAction.add(Box.createRigidArea(new Dimension(0, 10)));
		pnAction.add(pnFilter);
		pnAction.add(spCustomerList);
		pnAction.add(Box.createRigidArea(new Dimension(0, 5)));

		/* Panel chính -> Action -> Filter */
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

		/* Panel chính -> Action -> Phải -> Danh sách khách hàng */
		JTable tblCustomerList = new JTable();
		tblCustomerList.setModel(mdlCustomerList);
		tblCustomerList.getColumnModel().setColumnMargin(10);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblCustomerList.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		tblCustomerList.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		
		spCustomerList.setViewportView(tblCustomerList);

	}

	private void addEvent() {
		btnFilter.addActionListener(evtFilter);
		cbDistrict.addActionListener(new DistrictSelectEvent(cbDistrict, cbWard));
	}

}
