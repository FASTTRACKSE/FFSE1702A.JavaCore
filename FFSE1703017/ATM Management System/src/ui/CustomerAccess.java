package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.AddressDB;
import model.ComboItem;
import model.Customer;
import model.CustomerDB;

public class CustomerAccess extends JPanel {

	private static final long serialVersionUID = 1L;
	String[] col = {"Mã khách hàng","Họ tên","Số điện thoại", "Số tiền trong TK"};
    DefaultTableModel mdlCustomerList = new DefaultTableModel(col, 0);
    JButton btnAdd, btnEdit, btnDelete, btnSearch;
    JTextField txtName, txtPhone, txtEmail, txtStreet, txtCode, txtCardSN, txtAccSN, txtAmount, txtSearch;
    JComboBox<ComboItem> cbDistrict, cbWard;
    JTable tblCustomerList;
    
    MouseAdapter evtRowSelected = new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		int i = tblCustomerList.getSelectedRow();
    		if (i >= 0) {
    			setTextToInput(i);
    			btnEdit.setEnabled(true);
    			btnDelete.setEnabled(true);
    		} else {
    			resetInput();
    		}

    	}
	};
	
	ActionListener evtAdd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = txtName.getText();
			String phone = txtPhone.getText();
			String email = txtEmail.getText();
			ComboItem itemD = (ComboItem) cbDistrict.getSelectedItem();
			int districtID = itemD.getKey();
			ComboItem itemW = (ComboItem) cbWard.getSelectedItem();
			int wardID = itemW.getKey();
			String street = txtStreet.getText();
			String code = txtCode.getText();
			String cardSN = txtCardSN.getText();
			String accSN = txtAccSN.getText();
			double amount = Double.parseDouble(txtAmount.getText());
			Customer ctm = new Customer(name, phone, email, districtID, wardID, street, code, cardSN, accSN, amount);
			int i = CustomerDB.addCustomer(ctm);
			if (i > 0) {
				JOptionPane.showMessageDialog(null,"Thêm khách hàng thành công.",
						"Thông báo",JOptionPane.INFORMATION_MESSAGE);
				loadCustomerList();
			} else {
				JOptionPane.showMessageDialog(null,"Thêm khách hàng không thành công.",
						"Lỗi",JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	ActionListener evtEdit = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = txtName.getText();
			String phone = txtPhone.getText();
			String email = txtEmail.getText();
			ComboItem itemD = (ComboItem) cbDistrict.getSelectedItem();
			int districtID = itemD.getKey();
			ComboItem itemW = (ComboItem) cbWard.getSelectedItem();
			int wardID = itemW.getKey();
			String street = txtStreet.getText();
			String code = txtCode.getText();
			String cardSN = txtCardSN.getText();
			String accSN = txtAccSN.getText();
			double amount = Double.parseDouble(txtAmount.getText());
			Customer customer = new Customer(name, phone, email, districtID, wardID, street, code, cardSN, accSN, amount);
			int i = tblCustomerList.getSelectedRow();
			if (i >= 0) {
				String oldcode = (String) mdlCustomerList.getValueAt(i, 0);
				int x = CustomerDB.setCustomer(customer, oldcode);
				if (x > 0) {
					JOptionPane.showMessageDialog(null,"Sửa thông tin khách hàng thành công.",
							"Thông báo",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Sửa thông tin khách hàng không thành công.",
							"Lỗi",JOptionPane.WARNING_MESSAGE);
				}
				loadCustomerList();
		        resetInput();
			} else {
				JOptionPane.showMessageDialog(null,"Bạn chưa chọn khách hàng muốn sửa.",
						"Lỗi",JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	ActionListener evtDelete = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = tblCustomerList.getSelectedRow();
			String code = (String) mdlCustomerList.getValueAt(i, 0);
			if (i >= 0) {
				int x = CustomerDB.delCustomer(code);
				if (x > 0) {
					JOptionPane.showMessageDialog(null,"Xóa khách hàng thành công.",
							"Thông báo",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Xóa khách hàng không thành công.",
							"Lỗi",JOptionPane.WARNING_MESSAGE);
				}
				loadCustomerList();
		        resetInput();
			} else {
				JOptionPane.showMessageDialog(null,"Bạn chưa chọn khách hàng muốn xóa.",
						"Lỗi",JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	ActionListener evtSearch = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String keySearch = txtSearch.getText();
			ArrayList<Customer> arr = CustomerDB.getCustomesByName(keySearch);
			mdlCustomerList.setRowCount(0);
			if (arr.isEmpty()) {
				JOptionPane.showMessageDialog(null,"Không tìm thấy khách hàng phù hợp.",
						"Thông báo",JOptionPane.INFORMATION_MESSAGE);
			}
			for (Customer ctm : arr) {
				String[] row = {ctm.getCode(), ctm.getName(), ctm.getPhone(), String.format("%,d", (long)ctm.getAmount())};
	        	mdlCustomerList.addRow(row);
			}
			resetInput();
		}
	};
	
	public CustomerAccess() {
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
		JLabel lblTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		pnTitle.add(lblTitle);
		
		/*Panel chính -> Action*/
		pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.X_AXIS));
		JPanel pnLeft = new JPanel();
		JPanel pnRight = new JPanel();
		pnAction.add(pnLeft);
		pnAction.add(Box.createRigidArea(new Dimension(5, 0)));
		pnAction.add(pnRight);
		
		/*Panel chính -> Action -> Trái*/
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JPanel pnProfile = new JPanel();
		JPanel pnAddress = new JPanel();
		JPanel pnAccount = new JPanel();
		JPanel pnButton = new JPanel();
		
		pnLeft.add(Box.createVerticalGlue());
		pnLeft.add(pnProfile);
		pnLeft.add(pnAddress);
		pnLeft.add(pnAccount);
		pnLeft.add(pnButton);
		pnLeft.add(Box.createVerticalGlue());
		
		/*Panel chính -> Action -> Trái -> Thông tin cá nhân*/
		Border bdrProfile = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bttProfile = BorderFactory.createTitledBorder(bdrProfile, " Thông tin cá nhân ");
		pnProfile.setBorder(bttProfile);
		pnProfile.setLayout(new BoxLayout(pnProfile, BoxLayout.Y_AXIS));
		JPanel pnName = new JPanel();
		JPanel pnPhone = new JPanel();
		JPanel pnEmail = new JPanel();
		pnProfile.add(pnName);
		pnProfile.add(pnPhone);
		pnProfile.add(pnEmail);
		
		
		JLabel lblName = new JLabel("Họ và tên:");
		lblName.setPreferredSize(new Dimension(80,15));
		txtName = new JTextField(20);
		pnName.add(lblName);
		pnName.add(txtName);
		
		JLabel lblPhone = new JLabel("Số điện thoại:");
		lblPhone.setPreferredSize(new Dimension(80,15));
		txtPhone = new JTextField(20);
		pnPhone.add(lblPhone);
		pnPhone.add(txtPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setPreferredSize(new Dimension(80,15));
		txtEmail = new JTextField(20);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		
		/*Panel chính -> Action -> Trái -> Địa chỉ*/
		Border bdrAddress = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bttAddress = BorderFactory.createTitledBorder(bdrAddress, " Địa chỉ ");
		pnAddress.setBorder(bttAddress);
		pnAddress.setLayout(new BoxLayout(pnAddress, BoxLayout.Y_AXIS));
		JPanel pnDistrict = new JPanel();
		JPanel pnWard = new JPanel();
		JPanel pnStreet = new JPanel();
		pnAddress.add(pnDistrict);
		pnAddress.add(pnWard);
		pnAddress.add(pnStreet);
		
		JLabel lblDistrict = new JLabel("Quận:");
		lblDistrict.setPreferredSize(new Dimension(80,15));
		cbDistrict = new JComboBox<>();
		cbDistrict.setPreferredSize(new Dimension(165, 20));
		AddressDB.setDistricts(cbDistrict);
		pnDistrict.add(lblDistrict);
		pnDistrict.add(cbDistrict);
		
		JLabel lblWard = new JLabel("Phường:");
		lblWard.setPreferredSize(new Dimension(80,15));
		cbWard = new JComboBox<>();
		cbWard.setPreferredSize(new Dimension(165, 20));
		ComboItem itemWard = new ComboItem(0, "Chọn phường");
		cbWard.addItem(itemWard);
		pnWard.add(lblWard);
		pnWard.add(cbWard);
		
		JLabel lblStreet = new JLabel("Địa chỉ nhà:");
		lblStreet.setPreferredSize(new Dimension(80,15));
		txtStreet = new JTextField(20);
		pnStreet.add(lblStreet);
		pnStreet.add(txtStreet);
		
		/*Panel chính -> Action -> Trái -> Thông tin tài khoản*/
		Border bdrAccount = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bttAccount = BorderFactory.createTitledBorder(bdrAccount, " Thông tin tài khoản ");
		pnAccount.setBorder(bttAccount);
		pnAccount.setLayout(new BoxLayout(pnAccount, BoxLayout.Y_AXIS));
		JPanel pnCode = new JPanel();
		JPanel pnCardSN = new JPanel();
		JPanel pnAccSN = new JPanel();
		JPanel pnAmount = new JPanel();
		pnAccount.add(pnCode);
		pnAccount.add(pnCardSN);
		pnAccount.add(pnAccSN);
		pnAccount.add(pnAmount);
		
		JLabel lblCode = new JLabel("Mã khách hàng:");
		lblCode.setPreferredSize(new Dimension(80,15));
		txtCode = new JTextField(20);
		pnCode.add(lblCode);
		pnCode.add(txtCode);
		
		JLabel lblCardSN = new JLabel("Số thẻ ATM:");
		lblCardSN.setPreferredSize(new Dimension(80,15));
		txtCardSN = new JTextField(20);
		pnCardSN.add(lblCardSN);
		pnCardSN.add(txtCardSN);
		
		JLabel lblAccSN = new JLabel("Số tài khoản:");
		lblAccSN.setPreferredSize(new Dimension(80,15));
		txtAccSN = new JTextField(20);
		pnAccSN.add(lblAccSN);
		pnAccSN.add(txtAccSN);
		
		JLabel lblAmount = new JLabel("Tiền trong TK:");
		lblAmount.setPreferredSize(new Dimension(80,15));
		txtAmount = new JTextField(20);
		pnAmount.add(lblAmount);
		pnAmount.add(txtAmount);
		
		/*Panel chính -> Action -> Trái -> Button xử lý*/
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnEdit.setEnabled(false);
		btnDelete = new JButton("Xóa");
		btnDelete.setEnabled(false);
		pnButton.add(btnAdd);
		pnButton.add(btnEdit);
		pnButton.add(btnDelete);
		
		/*Panel chính -> Action -> Phải*/
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		JPanel pnSearch = new JPanel();
		JScrollPane spCustomerList = new JScrollPane();
		pnRight.add(pnSearch);
		pnRight.add(spCustomerList);
		pnRight.add(Box.createRigidArea(new Dimension(0, 5)));
		
		/*Panel chính -> Action -> Phải -> Tìm kiêm*/
		pnSearch.setLayout(new FlowLayout(FlowLayout.RIGHT));
		txtSearch = new JTextField(30);
		btnSearch = new JButton("Tìm kiếm");
		pnSearch.add(txtSearch);
		pnSearch.add(btnSearch);
		
		/*Panel chính -> Action -> Phải -> Danh sách khách hàng*/
		tblCustomerList = new JTable();
        tblCustomerList.setModel(mdlCustomerList);
        spCustomerList.setViewportView(tblCustomerList);
        loadCustomerList();
		
	}
	
	void addEvent() {
		tblCustomerList.addMouseListener(evtRowSelected);
		btnAdd.addActionListener(evtAdd);
		btnEdit.addActionListener(evtEdit);
		btnDelete.addActionListener(evtDelete);
		btnSearch.addActionListener(evtSearch);
		cbDistrict.addActionListener(new DistrictSelectEvent(cbDistrict, cbWard));
	}
	
	void setTextToInput(int i) {
		String code = (String) tblCustomerList.getValueAt(i, 0);
		Customer ctm = CustomerDB.getCustomerbyCode(code);
		txtName.setText(ctm.getName());
		txtPhone.setText(ctm.getPhone());
		txtEmail.setText(ctm.getEmail());
		txtStreet.setText(ctm.getStreet());
		txtCode.setText(ctm.getCode());
		txtCardSN.setText(ctm.getCardSN());
		txtAccSN.setText(ctm.getAccSN());
		txtAmount.setText(String.format("%d",(long) ctm.getAmount()));
		/*Quận*/
		int districtID = ctm.getDistrictID();
		ArrayList<ComboItem> arrDistrict = AddressDB.getDistricts();
		for (ComboItem itemD : arrDistrict) {
			if(itemD.getKey() == districtID) {
				int indexD = arrDistrict.indexOf(itemD) + 1;
				cbDistrict.setSelectedIndex(indexD);
				break;
			}
		}
		/*Phường*/
		int wardID = ctm.getWardID();
		ArrayList<ComboItem> arrWard = AddressDB.getWards(districtID);
		for (ComboItem itemW : arrWard) {
			if(itemW.getKey() == wardID) {
				int indexW = arrWard.indexOf(itemW) + 1;
				cbWard.setSelectedIndex(indexW);
				break;
			}
		}
	}
	
	void resetInput() {
		txtName.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		txtStreet.setText("");
		txtCode.setText("");
		txtCardSN.setText("");
		txtAccSN.setText("");
		txtAmount.setText("");
		cbDistrict.setSelectedIndex(0);
		btnDelete.setEnabled(false);
		btnEdit.setEnabled(false);
	}
	
	void loadCustomerList() {
		ArrayList<Customer> arr = CustomerDB.getCustomersList();
		mdlCustomerList.setRowCount(0);
        for (Customer ctm : arr) {
        	String[] row = {ctm.getCode(), ctm.getName(), ctm.getPhone(), String.format("%,d", (long)ctm.getAmount())};
        	mdlCustomerList.addRow(row);
        }
	}

}
