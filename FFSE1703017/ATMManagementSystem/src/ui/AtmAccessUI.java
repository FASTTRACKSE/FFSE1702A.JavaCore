package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.AddressDB;
import model.ComboItem;
import model.ATM;
import model.ATMDB;

public class AtmAccessUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel mdlAtmList;
	private JButton btnAdd, btnEdit, btnDelete, btnReset;
	private JTextField txtStreet, txtCode;
	private PlaceholderTextField txtSearch;
	/* Xử lý hiển thị số có dấu phẩy động */
	private NumberFormat amountFormat;
	private JFormattedTextField txtAmount;
	private JComboBox<ComboItem> cbDistrict, cbWard;
	private JTable tblAtmList;
	
	private ListSelectionListener evtRowSelected = new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			int i = tblAtmList.getSelectedRow();
			if (i >= 0) {
				setTextToInput(i);
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				btnReset.setEnabled(true);
				btnAdd.setEnabled(false);
			} else {
				resetInput();
			}
		}
	};
	
	private ActionListener evtAdd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ComboItem itemD = (ComboItem) cbDistrict.getSelectedItem();
			int districtID = itemD.getKey();
			ComboItem itemW = (ComboItem) cbWard.getSelectedItem();
			int wardID = itemW.getKey();
			String street = txtStreet.getText();
			String code = txtCode.getText();
			double amount = ((Number) txtAmount.getValue()).doubleValue();

			/* Check input validation */
			boolean isInput = checkInput(code, districtID, wardID, street);
			if (isInput) {
				/* Check exist code */
				boolean isValidCode = ATMDB.isValidCode(code);
				if (isValidCode) {
					ATM atm = new ATM(code, amount, districtID, wardID, street);
					int i = ATMDB.addATM(atm);
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Thêm máy ATM thành công.", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						loadAtmList();
					} else {
						JOptionPane.showMessageDialog(null, "Thêm máy ATM không thành công.", "Lỗi",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Mã ATM đã được sử dụng.", "Lỗi", JOptionPane.WARNING_MESSAGE);
					txtCode.requestFocus();
				}
			}
		}
	};

	private ActionListener evtEdit = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ComboItem itemD = (ComboItem) cbDistrict.getSelectedItem();
			int districtID = itemD.getKey();
			ComboItem itemW = (ComboItem) cbWard.getSelectedItem();
			int wardID = itemW.getKey();
			String street = txtStreet.getText();
			String code = txtCode.getText();
			double amount = ((Number) txtAmount.getValue()).doubleValue();
			ATM atm = new ATM(code, amount, districtID, wardID, street);
			int i = tblAtmList.getSelectedRow();
			/* Check row selected */
			if (i >= 0) {
				/* Check input validation */
				boolean isInput = checkInput(code, districtID, wardID, street);
				if (isInput) {
					int x = ATMDB.setATM(atm);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Sửa thông tin máy ATM thành công.", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Sửa thông tin máy ATM không thành công.", "Lỗi",
								JOptionPane.WARNING_MESSAGE);
					}
					loadAtmList();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn máy ATM muốn sửa.", "Lỗi",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	private ActionListener evtDelete = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = tblAtmList.getSelectedRow();
			String code = (String) mdlAtmList.getValueAt(i, 0);

			if (i >= 0) {
				int cf = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa?", "Xác nhận",
						JOptionPane.YES_NO_OPTION);
				if (cf == JOptionPane.YES_OPTION) {
					int x = ATMDB.delATM(code);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Xóa máy ATM thành công.", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Xóa máy ATM không thành công.", "Lỗi",
								JOptionPane.WARNING_MESSAGE);
					}
					loadAtmList();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn máy ATM muốn xóa.", "Lỗi",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	private ActionListener evtReset = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tblAtmList.clearSelection();
			resetInput();
		}
	};
	
	private DocumentListener evtSearch = new DocumentListener() {
		@Override
		public void removeUpdate(DocumentEvent arg0) {
			search();
		}
		@Override
		public void insertUpdate(DocumentEvent arg0) {
			search();
		}
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			search();
		}
	};

	public AtmAccessUI() {
		setupInput();
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
		String title = "<html><p style='font-size:12px'>QUẢN LÝ MÁY ATM</p></html>";
		JLabel lblTitle = new JLabel(title);
		pnTitle.add(lblTitle);

		/* Panel chính -> Action */
		pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.X_AXIS));
		JPanel pnLeft = new JPanel();
		JPanel pnRight = new JPanel();
		pnAction.add(pnLeft);
		pnAction.add(Box.createRigidArea(new Dimension(5, 0)));
		pnAction.add(pnRight);

		/* Panel chính -> Action -> Trái */
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JPanel pnProfile = new JPanel();
		JPanel pnAddress = new JPanel();
		JPanel pnButton = new JPanel();

		pnLeft.add(Box.createVerticalGlue());
		pnLeft.add(pnProfile);
		pnLeft.add(pnAddress);
		pnLeft.add(pnButton);
		pnLeft.add(Box.createVerticalGlue());

		/* Panel chính -> Action -> Trái -> Thông tin máy ATM */
		Border bdrProfile = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bttProfile = BorderFactory.createTitledBorder(bdrProfile, " Thông tin máy ATM ");
		pnProfile.setBorder(bttProfile);

		JLabel lblCode = new JLabel("Mã máy ATM:");
		JLabel lblAmount = new JLabel("Tiền còn lại:");

		GroupLayout lytProfile = new GroupLayout(pnProfile);
		pnProfile.setLayout(lytProfile);
		lytProfile.setAutoCreateGaps(true);
		lytProfile.setAutoCreateContainerGaps(true);
		lytProfile.setHorizontalGroup(lytProfile.createSequentialGroup()
				.addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(lblCode, 0, 70, Short.MAX_VALUE)
						.addComponent(lblAmount)
				)
				.addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(txtCode)
						.addComponent(txtAmount)
				)
		);
		lytProfile.setVerticalGroup(lytProfile.createSequentialGroup()
				.addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblCode)
						.addComponent(txtCode)
				)
				.addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(txtAmount)
				)

		);

		/* Panel chính -> Action -> Trái -> Địa chỉ */
		Border bdrAddress = BorderFactory.createLineBorder(Color.RED);
		TitledBorder bttAddress = BorderFactory.createTitledBorder(bdrAddress, " Vị trí đặt máy ");
		pnAddress.setBorder(bttAddress);

		JLabel lblDistrict = new JLabel("Quận:");
		AddressDB.setDistricts(cbDistrict);

		JLabel lblWard = new JLabel("Phường:");
		ComboItem itemWard = new ComboItem(0, "Chọn phường");
		cbWard.addItem(itemWard);

		JLabel lblStreet = new JLabel("Đường phố:");
		lblStreet.setPreferredSize(new Dimension(80, 15));

		GroupLayout lytAddress = new GroupLayout(pnAddress);
		pnAddress.setLayout(lytAddress);
		lytAddress.setAutoCreateGaps(true);
		lytAddress.setAutoCreateContainerGaps(true);
		lytAddress.setHorizontalGroup(lytAddress.createSequentialGroup()
				.addGroup(lytAddress.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(lblDistrict, 0, 70, Short.MAX_VALUE)
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

		/* Panel chính -> Action -> Trái -> Button xử lý */
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnEdit.setEnabled(false);
		btnDelete = new JButton("Xóa");
		btnDelete.setEnabled(false);
		btnReset = new JButton("Hủy");
		btnReset.setEnabled(false);
		pnButton.add(btnAdd);
		pnButton.add(btnEdit);
		pnButton.add(btnDelete);
		pnButton.add(btnReset);

		/* Panel chính -> Action -> Phải */
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		JPanel pnSearch = new JPanel();
		JScrollPane spAtmList = new JScrollPane();
		pnRight.add(pnSearch);
		pnRight.add(spAtmList);
		pnRight.add(Box.createRigidArea(new Dimension(0, 5)));

		/* Panel chính -> Action -> Phải -> Tìm kiêm */
		pnSearch.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblSearch = new JLabel("Tìm kiếm: ");
		pnSearch.add(lblSearch);
		pnSearch.add(txtSearch);

		/* Panel chính -> Action -> Phải -> Danh sách máy ATM */
		tblAtmList = new JTable();
		tblAtmList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] col = { "Mã máy ATM", "Đường", "Số tiền trong máy" };
		mdlAtmList = new DefaultTableModel(col, 0);
		tblAtmList.setModel(mdlAtmList);
		tblAtmList.getColumnModel().setColumnMargin(10);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblAtmList.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		
		spAtmList.setViewportView(tblAtmList);
	}

	private void addEvent() {
		tblAtmList.getSelectionModel().addListSelectionListener(evtRowSelected);
		btnAdd.addActionListener(evtAdd);
		btnEdit.addActionListener(evtEdit);
		btnDelete.addActionListener(evtDelete);
		btnReset.addActionListener(evtReset);
		cbDistrict.addActionListener(new DistrictSelectEvent(cbDistrict, cbWard));
		txtSearch.getDocument().addDocumentListener(evtSearch);
	}

	private void setupInput() {
		txtCode = new JTextField();
		amountFormat = NumberFormat.getNumberInstance();
		txtAmount = new JFormattedTextField(amountFormat);
		txtAmount.setValue(new Double(0));
		cbDistrict = new JComboBox<>();
		cbWard = new JComboBox<>();
		txtStreet = new JTextField();
		txtSearch = new PlaceholderTextField(30);
		txtSearch.setPlaceholder("Nhập mã ATM để tìm kiếm");
	}

	private void setTextToInput(int i) {
		String code = (String) tblAtmList.getValueAt(i, 0);
		ATM atm = ATMDB.getATMbyCode(code);
		txtStreet.setText(atm.getStreet());
		txtCode.setText(atm.getCode());
		txtAmount.setValue(new Double(atm.getAmount()));
		/* Các trường không được sửa set enable false */
		txtCode.setEditable(false);
		/* Quận */
		int districtID = atm.getDistrictID();
		ArrayList<ComboItem> arrDistrict = AddressDB.getDistricts();
		for (ComboItem itemD : arrDistrict) {
			if (itemD.getKey() == districtID) {
				int indexD = arrDistrict.indexOf(itemD) + 1;
				cbDistrict.setSelectedIndex(indexD);
				break;
			}
		}
		/* Phường */
		int wardID = atm.getWardID();
		ArrayList<ComboItem> arrWard = AddressDB.getWards(districtID);
		for (ComboItem itemW : arrWard) {
			if (itemW.getKey() == wardID) {
				int indexW = arrWard.indexOf(itemW) + 1;
				cbWard.setSelectedIndex(indexW);
				break;
			}
		}
	}

	/* Reset input */
	private void resetInput() {
		txtStreet.setText("");
		txtCode.setText("");
		txtCode.setEditable(true);
		txtAmount.setValue(new Double(0));
		cbDistrict.setSelectedIndex(0);
		btnDelete.setEnabled(false);
		btnEdit.setEnabled(false);
		btnReset.setEnabled(false);
		btnAdd.setEnabled(true);
	}

	/* Validate input */
	private boolean checkInput(String code, int districtID, int wardID, String street) {
		if (code.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã máy ATM.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtCode.requestFocus();
			return false;
		} else if (districtID < 1) {

			JOptionPane.showMessageDialog(null, "Bạn chưa chọn quận.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			cbDistrict.showPopup();
			return false;
		} else if (wardID < 1) {

			JOptionPane.showMessageDialog(null, "Bạn chưa chọn phường.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			cbWard.showPopup();
			return false;
		} else if (street.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Bạn chưa nhập đường phố.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtStreet.requestFocus();
			return false;
		} else {

			return true;
		}
	}
	
	private void search() {
		String keySearch = txtSearch.getText().trim();
		ArrayList<ATM> arr = ATMDB.getATMsByName(keySearch);
		mdlAtmList.setRowCount(0);
		
		for (ATM atm : arr) {
			String[] row = { atm.getCode(), atm.getStreet(), String.format("%,d", (long) atm.getAmount()) };
			mdlAtmList.addRow(row);
		}
	}

	/* Load table ATM list */
	void loadAtmList() {
		ArrayList<ATM> arr = ATMDB.getATMsList();
		mdlAtmList.setRowCount(0);
		for (ATM atm : arr) {
			String[] row = { atm.getCode(), atm.getStreet(), String.format("%,d", (long) atm.getAmount()) };
			mdlAtmList.addRow(row);
		}
	}

}
