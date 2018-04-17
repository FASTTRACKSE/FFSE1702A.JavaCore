package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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

public class CustomerAccessUI extends JPanel {

	private static final long serialVersionUID = 1L;
	String[] col = {"Mã khách hàng","Họ tên","Số điện thoại", "Số tiền trong TK"};
    DefaultTableModel mdlCustomerList = new DefaultTableModel(col, 0);
    JButton btnAdd, btnEdit, btnDelete, btnSearch;
    JTextField txtName, txtPhone, txtEmail, txtStreet, txtCode, txtCardSN, txtAccSN, txtSearch;
    /*Xử lý hiển thị số có dấu phẩy động*/
    NumberFormat amountFormat;
    JFormattedTextField txtAmount;
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
			double amount = ((Number)txtAmount.getValue()).doubleValue();
			Customer ctm = new Customer(name, phone, email, districtID, wardID, street, code, cardSN, accSN, amount);
			int i = CustomerDB.addCustomer(ctm);
			if (i > 0) {
				JOptionPane.showMessageDialog(null,"Thêm khách hàng thành công.",
						"Thông báo",JOptionPane.INFORMATION_MESSAGE);
				loadCustomerList();
				resetInput();
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
			double amount = ((Number)txtAmount.getValue()).doubleValue();
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
			ArrayList<Customer> arr = CustomerDB.getCustomersByName(keySearch);
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
	
	public CustomerAccessUI() {
		setupInput();
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
		
		JLabel lblName = new JLabel("Họ và tên:");
		JLabel lblPhone = new JLabel("Số điện thoại:");
		JLabel lblEmail = new JLabel("Email:");
		
		GroupLayout lytProfile = new GroupLayout(pnProfile);
		pnProfile.setLayout(lytProfile);
		lytProfile.setAutoCreateGaps(true);
		lytProfile.setAutoCreateContainerGaps(true);
		lytProfile.setHorizontalGroup(lytProfile.createSequentialGroup()
	            .addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.LEADING)
	                .addComponent(lblName)
	                .addComponent(lblPhone)
	                .addComponent(lblEmail)
                )
	            .addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.LEADING)
	                .addComponent(txtName)
	                .addComponent(txtPhone)
	                .addComponent(txtEmail)
                )
        );
		
		lytProfile.setVerticalGroup(lytProfile.createSequentialGroup()
	            .addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(lblName)
	                .addComponent(txtName)
                )
	            .addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(lblPhone)
	                .addComponent(txtPhone)
                )
	            .addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(lblEmail)
	                .addComponent(txtEmail)
                )
        );
		
		/*Panel chính -> Action -> Trái -> Địa chỉ*/
		Border bdrAddress = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bttAddress = BorderFactory.createTitledBorder(bdrAddress, " Địa chỉ ");
		pnAddress.setBorder(bttAddress);
		
		JLabel lblDistrict = new JLabel("Quận:");
		AddressDB.setDistricts(cbDistrict);
		
		JLabel lblWard = new JLabel("Phường:");
		ComboItem itemWard = new ComboItem(0, "Chọn phường");
		cbWard.addItem(itemWard);
		
		JLabel lblStreet = new JLabel("Địa chỉ nhà:");
		
		GroupLayout lytAddress = new GroupLayout(pnAddress);          
		pnAddress.setLayout(lytAddress);
        lytAddress.setAutoCreateGaps(true);
        lytAddress.setAutoCreateContainerGaps(true);
        lytAddress.setHorizontalGroup(lytAddress.createSequentialGroup()
    		.addGroup(lytAddress.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(lblDistrict)
				.addComponent(lblWard)
				.addComponent(lblStreet)
			)
    		.addGroup(lytAddress.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(cbDistrict)
				.addComponent(cbWard)
				.addComponent(txtStreet)
			)
		);
        lytAddress.setVerticalGroup(lytAddress.createSequentialGroup()
    		.addGroup(lytAddress.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lblDistrict)
				.addComponent(cbDistrict)
			)
    		.addGroup(lytAddress.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lblWard)
				.addComponent(cbWard)
			)
    		.addGroup(lytAddress.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lblStreet)
				.addComponent(txtStreet)
			)
		);
		
		/*Panel chính -> Action -> Trái -> Thông tin tài khoản*/
		Border bdrAccount = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bttAccount = BorderFactory.createTitledBorder(bdrAccount, " Thông tin tài khoản ");
		pnAccount.setBorder(bttAccount);
		
		JLabel lblCode = new JLabel("Mã khách hàng:");
		JLabel lblCardSN = new JLabel("Số thẻ ATM:");
		JLabel lblAccSN = new JLabel("Số tài khoản:");
		JLabel lblAmount = new JLabel("Tiền trong TK:");
		
		GroupLayout lytAccount = new GroupLayout(pnAccount);          
		pnAccount.setLayout(lytAccount);
        lytAccount.setAutoCreateGaps(true);
        lytAccount.setAutoCreateContainerGaps(true);
        lytAccount.setHorizontalGroup(lytAccount.createSequentialGroup()
            .addGroup(lytAccount.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblCode)
                .addComponent(lblCardSN)
                .addComponent(lblAccSN)
            	.addComponent(lblAmount)
        	)
            .addGroup(lytAccount.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(txtCode)
                .addComponent(txtCardSN)
                .addComponent(txtAccSN)
            	.addComponent(txtAmount)
        	)
        );
        lytAccount.setVerticalGroup(lytAccount.createSequentialGroup()
            .addGroup(lytAccount.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblCode)
                .addComponent(txtCode)
            )
            .addGroup(lytAccount.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblCardSN)
                .addComponent(txtCardSN)
            )
            .addGroup(lytAccount.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblAccSN)
                .addComponent(txtAccSN)
            )
            .addGroup(lytAccount.createParallelGroup(GroupLayout.Alignment.BASELINE)
            	.addComponent(lblAmount)
            	.addComponent(txtAmount)
        	)
            
        );
		
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
	
	void setupInput() {
		txtName = new JTextField();
		txtPhone = new JTextField();
		txtEmail = new JTextField();
		txtStreet = new JTextField();
		txtCode = new JTextField();
		txtCardSN = new JTextField();
		txtAccSN = new JTextField();
		txtSearch = new JTextField(30);
		amountFormat = NumberFormat.getNumberInstance();
		txtAmount = new JFormattedTextField(amountFormat);
		txtAmount.setValue(new Double(0));
		cbDistrict = new JComboBox<>();
		cbWard = new JComboBox<>();
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
		txtAmount.setValue(new Double(ctm.getAmount()));
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
		txtAmount.setValue(new Double(0));
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
