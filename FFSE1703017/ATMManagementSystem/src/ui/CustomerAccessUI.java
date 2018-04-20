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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import model.AddressDB;
import model.ComboItem;
import model.Customer;
import model.CustomerDB;
import model.User;
import model.UserDB;

public class CustomerAccessUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] col = { "Mã khách hàng", "Họ tên", "Số điện thoại", "Email", "Số tiền trong TK" };
	private DefaultTableModel mdlCustomerList = new DefaultTableModel(col, 0);
	private JButton btnAdd, btnEdit, btnDelete, btnReset;
	private JTextField txtName, txtPhone, txtEmail, txtStreet, txtCode, txtCardSN, txtAccSN, txtSearch;
	/* Xử lý hiển thị số có dấu phẩy động */
	private NumberFormat amountFormat;
	private JFormattedTextField txtAmount;
	private JComboBox<ComboItem> cbDistrict, cbWard;
	private JTable tblCustomerList;
	private JPanel pnLeft, pnRight, pnAddress, pnButton;
	UserInfo pnUser;
	User user;
	JLabel lblTitle;

	private MouseAdapter evtRowSelected = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tblCustomerList.getSelectedRow();
			if (i >= 0) {
				String code = (String) tblCustomerList.getValueAt(i, 0);
				setTextToInput(code);
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				btnAdd.setEnabled(false);
			} else {
				resetInput();
			}

		}
	};

	private ActionListener evtAdd = new ActionListener() {
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
			double amount = ((Number) txtAmount.getValue()).doubleValue();

			/* Check input validation */
			boolean isInput = checkInput(name, email, phone, districtID, wardID, street, code, cardSN, accSN);

			if (isInput) {

				/* Check valid items */
				boolean isValidItems = checkValidItems(code, phone, email, cardSN, accSN);

				if (isValidItems) {
					Customer ctm = new Customer(name, phone, email, districtID, wardID, street, code, cardSN, accSN,
							amount);
					int i = CustomerDB.addCustomer(ctm);
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công.", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						loadCustomerList();
						resetInput();
					} else {
						JOptionPane.showMessageDialog(null, "Thêm khách hàng không thành công.", "Lỗi",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
	};

	private ActionListener evtEdit = new ActionListener() {
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
			double amount = ((Number) txtAmount.getValue()).doubleValue();
			/* Check row selected */
			int i = tblCustomerList.getSelectedRow();

			if (i >= 0) {
				/* Check input validation */
				boolean isInput = checkInput(name, email, phone, districtID, wardID, street, code, cardSN, accSN);

				if (isInput) {
					/* Check valid items */
					String oldPhone = (String) mdlCustomerList.getValueAt(i, 2);
					String oldEmail = (String) mdlCustomerList.getValueAt(i, 3);
					if (CustomerDB.isItem("phone", phone) && !phone.equals(oldPhone)) {

						txtPhone.requestFocus();
						JOptionPane.showMessageDialog(null, "Số điện thoại đã được sử dụng.", "Lỗi",
								JOptionPane.WARNING_MESSAGE);
					} else if (CustomerDB.isItem("email", email) && !email.equals(oldEmail)) {

						txtEmail.requestFocus();
						JOptionPane.showMessageDialog(null, "Email đã được sử dụng.", "Lỗi",
								JOptionPane.WARNING_MESSAGE);
					} else {

						Customer customer = new Customer(name, phone, email, districtID, wardID, street, code, cardSN,
								accSN, amount);
						int x = CustomerDB.setCustomer(customer);
						if (x > 0) {
							JOptionPane.showMessageDialog(null, "Sửa thông tin khách hàng thành công.", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Sửa thông tin khách hàng không thành công.", "Lỗi",
									JOptionPane.WARNING_MESSAGE);
						}
						loadCustomerList();
						resetInput();
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn khách hàng muốn sửa.", "Lỗi",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	private ActionListener evtDelete = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = tblCustomerList.getSelectedRow();
			String code = (String) mdlCustomerList.getValueAt(i, 0);
			if (i >= 0) {
				int cf = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa?", "Xác nhận",
						JOptionPane.YES_NO_OPTION);
				if (cf == JOptionPane.YES_OPTION) {
					int x = CustomerDB.delCustomer(code);
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công.", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Xóa khách hàng không thành công.", "Lỗi",
								JOptionPane.WARNING_MESSAGE);
					}
					loadCustomerList();
					resetInput();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn khách hàng muốn xóa.", "Lỗi",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	private ActionListener evtReset = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			resetInput();
		}
	};
	
	private DocumentListener evtSearch = new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			search();
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			search();
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			search();
		}
	};
	
	private ActionListener evtChangePassword = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String password = new String(pnUser.txtPassword.getPassword());
			String rePassword = new String(pnUser.txtRePassword.getPassword());
			String code = user.getCustomerCode();
			if (password.isEmpty() || rePassword.isEmpty() || !password.equals(rePassword)) {
				JOptionPane.showMessageDialog(null, "Mật khẩu trống hoặc không khớp.", "Lỗi",
						JOptionPane.WARNING_MESSAGE);
			} else {
				int i = UserDB.changePassword(password, code);
				if (i > 0) {
					pnUser.txtPassword.setText("");
					pnUser.txtRePassword.setText("");
					JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công.", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Đổi mật khẩu không thành công.", "Lỗi",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
	};

	public CustomerAccessUI(User user) {
		this.user = user;
		setupInput();
		addPanel();
		if (user.getRole() == 1) {
			addPanelsAdmin();
			addEvent();
		} else {
			addPanelsCustomer();
		}
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
		String title = "<html><p style='font-size:12px'>QUẢN LÝ KHÁCH HÀNG</p></html>";
		lblTitle = new JLabel(title);
		pnTitle.add(lblTitle);

		/* Panel chính -> Action */
		pnAction.setLayout(new BoxLayout(pnAction, BoxLayout.X_AXIS));
		pnLeft = new JPanel();
		pnRight = new JPanel();
		pnAction.add(pnLeft);
		pnAction.add(Box.createRigidArea(new Dimension(5, 0)));
		pnAction.add(pnRight);

		/* Panel chính -> Action -> Trái */
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JPanel pnProfile = new JPanel();
		pnAddress = new JPanel();
		JPanel pnAccount = new JPanel();
		pnButton = new JPanel();

		pnLeft.add(Box.createVerticalGlue());
		pnLeft.add(pnProfile);
		pnLeft.add(pnAddress);
		pnLeft.add(pnAccount);
		pnLeft.add(pnButton);
		pnLeft.add(Box.createVerticalGlue());

		/* Panel chính -> Action -> Trái -> Thông tin cá nhân */
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
				.addGroup(lytProfile.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(lblName, 0, 80, Short.MAX_VALUE)
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

		/* Panel chính -> Action -> Trái -> Địa chỉ */
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
				.addGroup(lytAddress.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(lblDistrict, 0, 80, Short.MAX_VALUE)
						.addComponent(lblWard)
						.addComponent(lblStreet)
				)
				.addGroup(lytAddress.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(cbDistrict)
						.addComponent(cbWard).addComponent(txtStreet)));
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

		/* Panel chính -> Action -> Trái -> Thông tin tài khoản */
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
				.addGroup(lytAccount.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(lblCode, 0, 80, Short.MAX_VALUE)
						.addComponent(lblCardSN)
						.addComponent(lblAccSN)
						.addComponent(lblAmount)
				)
				.addGroup(lytAccount.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(txtCode)
						.addComponent(txtCardSN).addComponent(txtAccSN)
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

		/* Panel chính -> Action -> Trái -> Button xử lý */
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnEdit.setEnabled(false);
		btnDelete = new JButton("Xóa");
		btnDelete.setEnabled(false);
		btnReset = new JButton("Reset");
		pnButton.add(btnAdd);
		pnButton.add(btnEdit);
		pnButton.add(btnDelete);
		pnButton.add(btnReset);
		
	}
	
	private void addPanelsAdmin() {

		/* Panel chính -> Action -> Phải */
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		JPanel pnSearch = new JPanel();
		JScrollPane spCustomerList = new JScrollPane();
		pnRight.add(pnSearch);
		pnRight.add(spCustomerList);
		pnRight.add(Box.createRigidArea(new Dimension(0, 5)));

		/* Panel chính -> Action -> Phải -> Tìm kiêm */
		pnSearch.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblSearch = new JLabel("Tìm kiếm: ");
		pnSearch.add(lblSearch);
		pnSearch.add(txtSearch);

		/* Panel chính -> Action -> Phải -> Danh sách khách hàng */
		tblCustomerList = new JTable();
		tblCustomerList.setModel(mdlCustomerList);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblCustomerList.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		
		TableColumnModel columnModel = tblCustomerList.getColumnModel();
		columnModel.getColumn(1).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(120);
		spCustomerList.setViewportView(tblCustomerList);
		loadCustomerList();

	}
	
	private void addPanelsCustomer() {
		String title = "<html><p style='font-size:12px'>THÔNG TIN CÁ NHÂN</p></html>";
		lblTitle.setText(title);
		
		pnLeft.remove(pnAddress);
		pnLeft.remove(pnButton);
		
		JPanel pnEdit = new JPanel();
		pnEdit.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnEdit.add(btnEdit);
		btnEdit.setEnabled(true);
		
		pnUser = new UserInfo(user);
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		pnRight.add(Box.createVerticalGlue());
		pnRight.add(Box.createRigidArea(new Dimension(0, 25)));
		pnRight.add(pnAddress);
		pnRight.add(pnUser);
		pnRight.add(pnEdit);
		pnRight.add(Box.createVerticalGlue());
		
		String code = user.getCustomerCode();
		cbDistrict.addActionListener(new DistrictSelectEvent(cbDistrict, cbWard));
		setTextToInput(code);
		
		txtName.setEditable(false);
		txtPhone.setEditable(false);
		txtEmail.setEditable(false);
		txtAmount.setEditable(false);
		cbDistrict.setEditable(false);
		cbWard.setEditable(false);
		txtStreet.setEditable(false);
		
		btnEdit.addActionListener(evtChangePassword);
	}

	private void addEvent() {
		tblCustomerList.addMouseListener(evtRowSelected);
		btnAdd.addActionListener(evtAdd);
		btnEdit.addActionListener(evtEdit);
		btnDelete.addActionListener(evtDelete);
		btnReset.addActionListener(evtReset);
		cbDistrict.addActionListener(new DistrictSelectEvent(cbDistrict, cbWard));
		txtSearch.getDocument().addDocumentListener(evtSearch);
	}

	private void setupInput() {
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

	private void setTextToInput(String code) {
		Customer ctm = CustomerDB.getCustomerbyCode(code);
		txtName.setText(ctm.getName());
		txtPhone.setText(ctm.getPhone());
		txtEmail.setText(ctm.getEmail());
		txtStreet.setText(ctm.getStreet());
		txtCode.setText(ctm.getCode());
		txtCardSN.setText(ctm.getCardSN());
		txtAccSN.setText(ctm.getAccSN());
		txtAmount.setValue(new Double(ctm.getAmount()));
		/* Các trường không được sửa set enable false */
		txtCode.setEditable(false);
		txtCardSN.setEditable(false);
		txtAccSN.setEditable(false);
		/* Quận */
		int districtID = ctm.getDistrictID();
		ArrayList<ComboItem> arrDistrict = AddressDB.getDistricts();
		for (ComboItem itemD : arrDistrict) {
			if (itemD.getKey() == districtID) {
				int indexD = arrDistrict.indexOf(itemD) + 1;
				cbDistrict.setSelectedIndex(indexD);
				break;
			}
		}
		/* Phường */
		int wardID = ctm.getWardID();
		ArrayList<ComboItem> arrWard = AddressDB.getWards(districtID);
		for (ComboItem itemW : arrWard) {
			if (itemW.getKey() == wardID) {
				int indexW = arrWard.indexOf(itemW) + 1;
				cbWard.setSelectedIndex(indexW);
				break;
			}
		}
	}

	private void resetInput() {
		txtName.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		txtStreet.setText("");
		txtCode.setText("");
		txtCardSN.setText("");
		txtAccSN.setText("");
		txtAmount.setValue(new Double(0));
		cbDistrict.setSelectedIndex(0);
		/* Reset Button */
		btnDelete.setEnabled(false);
		btnEdit.setEnabled(false);
		btnAdd.setEnabled(true);
		/* Reset Textfiled */
		txtCode.setEditable(true);
		txtCardSN.setEditable(true);
		txtAccSN.setEditable(true);
	}

	/* Validate input */
	private boolean checkInput(String name, String email, String phone, int districtID, int wardID, String street, String code,
			String cardSN, String accSN) {
		/* Email validate by RegEx */
		String emailReg = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
		Pattern emailPatt = Pattern.compile(emailReg);
		Matcher emailMat = emailPatt.matcher(email);

		/* Email validate by RegEx */
		String phoneReg = "0\\d{9,10}";
		Pattern phonePatt = Pattern.compile(phoneReg);
		Matcher phoneMat = phonePatt.matcher(phone);

		if (name.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên khách hàng.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtName.requestFocus();
			return false;
		} else if (phone.isEmpty() || !phoneMat.matches()) {

			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtPhone.requestFocus();
			return false;
		} else if (email.isEmpty() || !emailMat.matches()) {

			JOptionPane.showMessageDialog(null, "Email không hợp lệ.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtEmail.requestFocus();
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

			JOptionPane.showMessageDialog(null, "Bạn chưa nhập địa chỉ nhà.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtStreet.requestFocus();
			return false;
		} else if (code.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã khách hàng.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtCode.requestFocus();
			return false;
		} else if (cardSN.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã số thẻ.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtCardSN.requestFocus();
			return false;
		} else if (accSN.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã tài khoản.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtAccSN.requestFocus();
			return false;
		} else {

			return true;
		}
	}

	/* Check exist */
	private boolean checkValidItems(String code, String phone, String email, String cardSN, String accSN) {
		if (CustomerDB.isItem("phone", phone)) {

			JOptionPane.showMessageDialog(null, "Số điện thoại đã được sử dụng.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtPhone.requestFocus();
			return false;
		} else if (CustomerDB.isItem("email", email)) {

			JOptionPane.showMessageDialog(null, "Email đã được sử dụng.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtEmail.requestFocus();
			return false;
		} else if (CustomerDB.isItem("code", code)) {

			JOptionPane.showMessageDialog(null, "Mã khách hàng đã được sử dụng.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtCode.requestFocus();
			return false;
		} else if (CustomerDB.isItem("card_sn", cardSN)) {

			JOptionPane.showMessageDialog(null, "Số thẻ ATM đã được sử dụng.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtCardSN.requestFocus();
			return false;
		} else if (CustomerDB.isItem("acc_sn", accSN)) {

			JOptionPane.showMessageDialog(null, "Số tài khoản đã được sử dụng.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			txtAccSN.requestFocus();
			return false;
		} else {
			return true;
		}
	}
	
	private void search() {
		String keySearch = txtSearch.getText();
		ArrayList<Customer> arr = CustomerDB.getCustomersByName(keySearch);
		mdlCustomerList.setRowCount(0);

		for (Customer ctm : arr) {
			String[] row = { ctm.getCode(), ctm.getName(), ctm.getPhone(), ctm.getEmail(), 
					String.format("%,d", (long) ctm.getAmount()) };
			mdlCustomerList.addRow(row);
		}
		resetInput();
	}

	void loadCustomerList() {
		ArrayList<Customer> arr = CustomerDB.getCustomersList();
		mdlCustomerList.setRowCount(0);
		for (Customer ctm : arr) {
			String[] row = { ctm.getCode(), ctm.getName(), ctm.getPhone(), ctm.getEmail(),
					String.format("%,d", (long) ctm.getAmount()) };
			mdlCustomerList.addRow(row);
		}
	}

}
