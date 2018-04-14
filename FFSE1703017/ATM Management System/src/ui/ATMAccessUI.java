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
import model.ATM;
import model.ATMDB;

public class ATMAccessUI extends JPanel {

	private static final long serialVersionUID = 1L;
	String[] col = {"Mã máy ATM","Đường","Số tiền trong máy"};
    DefaultTableModel mdlATMList = new DefaultTableModel(col, 0);
    JButton btnAdd, btnEdit, btnDelete, btnSearch;
    JTextField txtStreet, txtCode, txtAmount, txtSearch;
    JComboBox<ComboItem> cbDistrict, cbWard;
    JTable tblATMList;
    
    MouseAdapter evtRowSelected = new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		int i = tblATMList.getSelectedRow();
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
			ComboItem itemD = (ComboItem) cbDistrict.getSelectedItem();
			int districtID = itemD.getKey();
			ComboItem itemW = (ComboItem) cbWard.getSelectedItem();
			int wardID = itemW.getKey();
			String street = txtStreet.getText();
			String code = txtCode.getText();
			double amount = Double.parseDouble(txtAmount.getText());
			ATM atm = new ATM(code, amount, districtID, wardID, street);
			int i = ATMDB.addATM(atm);
			if (i > 0) {
				JOptionPane.showMessageDialog(null,"Thêm máy ATM thành công.",
						"Thông báo",JOptionPane.INFORMATION_MESSAGE);
				loadATMList();
			} else {
				JOptionPane.showMessageDialog(null,"Thêm máy ATM không thành công.",
						"Lỗi",JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	ActionListener evtEdit = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ComboItem itemD = (ComboItem) cbDistrict.getSelectedItem();
			int districtID = itemD.getKey();
			ComboItem itemW = (ComboItem) cbWard.getSelectedItem();
			int wardID = itemW.getKey();
			String street = txtStreet.getText();
			String code = txtCode.getText();
			double amount = Double.parseDouble(txtAmount.getText());
			ATM atm = new ATM(code, amount, districtID, wardID, street);
			int i = tblATMList.getSelectedRow();
			if (i >= 0) {
				String oldcode = (String) mdlATMList.getValueAt(i, 0);
				int x = ATMDB.setATM(atm , oldcode);
				if (x > 0) {
					JOptionPane.showMessageDialog(null,"Sửa thông tin máy ATM thành công.",
							"Thông báo",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Sửa thông tin máy ATM không thành công.",
							"Lỗi",JOptionPane.WARNING_MESSAGE);
				}
				loadATMList();
		        resetInput();
			} else {
				JOptionPane.showMessageDialog(null,"Bạn chưa chọn máy ATM muốn sửa.",
						"Lỗi",JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	ActionListener evtDelete = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = tblATMList.getSelectedRow();
			String code = (String) mdlATMList.getValueAt(i, 0);
			if (i >= 0) {
				int x = ATMDB.delATM(code);
				if (x > 0) {
					JOptionPane.showMessageDialog(null,"Xóa máy ATM thành công.",
							"Thông báo",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Xóa máy ATM không thành công.",
							"Lỗi",JOptionPane.WARNING_MESSAGE);
				}
				loadATMList();
		        resetInput();
			} else {
				JOptionPane.showMessageDialog(null,"Bạn chưa chọn máy ATM muốn xóa.",
						"Lỗi",JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	ActionListener evtSearch = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String keySearch = txtSearch.getText();
			ArrayList<ATM> arr = ATMDB.getATMsByName(keySearch);
			mdlATMList.setRowCount(0);
			if (arr.isEmpty()) {
				JOptionPane.showMessageDialog(null,"Không tìm thấy máy ATM phù hợp.",
						"Thông báo",JOptionPane.INFORMATION_MESSAGE);
			}
			for (ATM atm : arr) {
				String[] row = {atm.getCode(), atm.getStreet(), String.format("%,d", (long)atm.getAmount())};
	        	mdlATMList.addRow(row);
			}
			resetInput();
		}
	};
	
	public ATMAccessUI() {
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
		JLabel lblTitle = new JLabel("QUẢN LÝ MÁY ATM");
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
		JPanel pnButton = new JPanel();
		
		pnLeft.add(Box.createVerticalGlue());
		pnLeft.add(pnProfile);
		pnLeft.add(pnAddress);
		pnLeft.add(pnButton);
		pnLeft.add(Box.createVerticalGlue());
		
		/*Panel chính -> Action -> Trái -> Thông tin máy ATM*/
		Border bdrProfile = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bttProfile = BorderFactory.createTitledBorder(bdrProfile, " Thông tin máy ATM ");
		pnProfile.setBorder(bttProfile);
		pnProfile.setLayout(new BoxLayout(pnProfile, BoxLayout.Y_AXIS));
		JPanel pnCode = new JPanel();
		JPanel pnAmount = new JPanel();
		pnProfile.add(Box.createRigidArea(new Dimension(0, 30)));
		pnProfile.add(pnCode);
		pnProfile.add(pnAmount);
		
		JLabel lblCode = new JLabel("Mã máy ATM:");
		lblCode.setPreferredSize(new Dimension(80,15));
		txtCode = new JTextField(20);
		pnCode.add(lblCode);
		pnCode.add(txtCode);
		
		JLabel lblAmount = new JLabel("Tiền còn lại:");
		lblAmount.setPreferredSize(new Dimension(80,15));
		txtAmount = new JTextField(20);
		pnAmount.add(lblAmount);
		pnAmount.add(txtAmount);
		
		/*Panel chính -> Action -> Trái -> Địa chỉ*/
		Border bdrAddress = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bttAddress = BorderFactory.createTitledBorder(bdrAddress, " Vị trí đặt máy ");
		pnAddress.setBorder(bttAddress);
		pnAddress.setLayout(new BoxLayout(pnAddress, BoxLayout.Y_AXIS));
		JPanel pnDistrict = new JPanel();
		JPanel pnWard = new JPanel();
		JPanel pnStreet = new JPanel();
		pnAddress.add(Box.createRigidArea(new Dimension(0, 30)));
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
		
		JLabel lblStreet = new JLabel("Đường phố:");
		lblStreet.setPreferredSize(new Dimension(80,15));
		txtStreet = new JTextField(20);
		pnStreet.add(lblStreet);
		pnStreet.add(txtStreet);
		
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
		JScrollPane spATMList = new JScrollPane();
		pnRight.add(pnSearch);
		pnRight.add(spATMList);
		pnRight.add(Box.createRigidArea(new Dimension(0, 5)));
		
		/*Panel chính -> Action -> Phải -> Tìm kiêm*/
		pnSearch.setLayout(new FlowLayout(FlowLayout.RIGHT));
		txtSearch = new JTextField(30);
		btnSearch = new JButton("Tìm kiếm");
		pnSearch.add(txtSearch);
		pnSearch.add(btnSearch);
		
		/*Panel chính -> Action -> Phải -> Danh sách máy ATM*/
		tblATMList = new JTable();
        tblATMList.setModel(mdlATMList);
        spATMList.setViewportView(tblATMList);
		loadATMList();
	}
	
	void addEvent() {
		tblATMList.addMouseListener(evtRowSelected);
		btnAdd.addActionListener(evtAdd);
		btnEdit.addActionListener(evtEdit);
		btnDelete.addActionListener(evtDelete);
		btnSearch.addActionListener(evtSearch);
		cbDistrict.addActionListener(new DistrictSelectEvent(cbDistrict, cbWard));
	}
	
	void setTextToInput(int i) {
		String code = (String) tblATMList.getValueAt(i, 0);
		ATM atm = ATMDB.getATMbyCode(code);
		txtStreet.setText(atm.getStreet());
		txtCode.setText(atm.getCode());
		txtAmount.setText(String.format("%d",(long) atm.getAmount()));
		/*Quận*/
		int districtID = atm.getDistrictID();
		ArrayList<ComboItem> arrDistrict = AddressDB.getDistricts();
		for (ComboItem itemD : arrDistrict) {
			if(itemD.getKey() == districtID) {
				int indexD = arrDistrict.indexOf(itemD) + 1;
				cbDistrict.setSelectedIndex(indexD);
				break;
			}
		}
		/*Phường*/
		int wardID = atm.getWardID();
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
		txtStreet.setText("");
		txtCode.setText("");
		txtAmount.setText("");
		cbDistrict.setSelectedIndex(0);
		btnDelete.setEnabled(false);
		btnEdit.setEnabled(false);
	}
	
	void loadATMList() {
		ArrayList<ATM> arr = ATMDB.getATMsList();
		mdlATMList.setRowCount(0);
        for (ATM atm : arr) {
        	String[] row = {atm.getCode(), atm.getStreet(), String.format("%,d", (long)atm.getAmount())};
        	mdlATMList.addRow(row);
        }
	}

}
