package ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.ConnectDB;

import javax.swing.ImageIcon;

public class LoginUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JRadioButton rbnAdmin = new JRadioButton("Hệ thống quản lý");
	private final JRadioButton rbnCustomer = new JRadioButton("Mô phỏng giao dịch");
	private JButton btnAppLogin, btnAppExit, btnAtmLogin, btnAtmExit;
	private JPanel pnInput;
	private JTextField txtAdminName, txtCardSN;
	private JPasswordField txtAdminPass, txtPIN;
	private CardLayout lyt;

	public JButton getBtnAppLogin() {
		return btnAppLogin;
	}

	public JTextField getTxtAdminName() {
		return txtAdminName;
	}

	public JPasswordField getTxtAdminPass() {
		return txtAdminPass;
	}

	public JButton getBtnAtmLogin() {
		return btnAppExit;
	}

	public JTextField getTxtCardSN() {
		return txtCardSN;
	}

	public JPasswordField getTxtPIN() {
		return txtPIN;
	}

	/* Thêm sự kiện cho radiobutton */
	private ActionListener showInput = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (rbnAdmin.isSelected()) {
				lyt.show(pnInput, "1");
			} else {
				lyt.show(pnInput, "2");
			}
		}
	};
	
	private ActionListener evtExit = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};

	public LoginUI() {
		addPanels();
		addEvents();
		checkConnect();
	}

	private void addPanels() {

		JPanel pnTop = new JPanel();
		JPanel pnBottom = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(pnTop);
		this.add(pnBottom);

		/* Main -> Top */
		pnTop.setLayout(new GridLayout(0, 1));
		JLabel bg = new JLabel();
		bg.setPreferredSize(new Dimension(600, 200));
		pnTop.add(bg);
		ImageIcon bgImage = new ImageIcon(getClass().getResource("/images/bg.png"));
		bgImage.getImage().getScaledInstance(600, 200, Image.SCALE_SMOOTH);
		bg.setIcon(bgImage);

		/* Main -> Bottom */
		pnInput = new JPanel();
		JPanel pnSelection = new JPanel();
		pnBottom.setLayout(new BoxLayout(pnBottom, BoxLayout.Y_AXIS));
		pnBottom.add(pnInput);
		pnBottom.add(pnSelection);

		/* Main -> Bottom -> Selection */
		ButtonGroup bgSelect = new ButtonGroup();
		bgSelect.add(rbnAdmin);
		bgSelect.add(rbnCustomer);
		rbnAdmin.setSelected(true);
		pnSelection.add(rbnAdmin);
		pnSelection.add(rbnCustomer);

		/* Main -> Bottom -> Input */
		JPanel pnAdmin = new JPanel();
		JPanel pnCustomer = new JPanel();
		lyt = new CardLayout();
		pnInput.setLayout(lyt);
		pnInput.add(pnAdmin, "1");
		pnInput.add(pnCustomer, "2");

		/* Main -> Bottom -> Input -> Admin */
		JPanel pnAdminInput = new JPanel();
		pnAdmin.setLayout(new BoxLayout(pnAdmin, BoxLayout.X_AXIS));
		pnAdmin.add(Box.createHorizontalGlue());
		pnAdmin.add(pnAdminInput);
		pnAdmin.add(Box.createHorizontalGlue());
		
		JLabel lblAdminName = new JLabel("Tên đăng nhập:");
		txtAdminName = new JTextField(20);
		JLabel lblAdminPass = new JLabel("Mật khẩu:");
		txtAdminPass = new JPasswordField(20);
		btnAppLogin = new JButton("Đăng nhập");
		btnAtmLogin = new JButton("Thoát");
		
		GroupLayout lytAdmin = new GroupLayout(pnAdminInput);
		pnAdminInput.setLayout(lytAdmin);
		lytAdmin.setAutoCreateGaps(true);
		lytAdmin.setAutoCreateContainerGaps(true);
		lytAdmin.setHorizontalGroup(lytAdmin.createSequentialGroup()
			.addGroup(lytAdmin.createParallelGroup(GroupLayout.Alignment.LEADING, false)
				.addComponent(lblAdminName, 0, 80, Short.MAX_VALUE)
				.addComponent(lblAdminPass)
			)
			.addGroup(lytAdmin.createParallelGroup(GroupLayout.Alignment.LEADING, false)
				.addComponent(txtAdminName)
				.addComponent(txtAdminPass)
				.addGroup(lytAdmin.createSequentialGroup()
					.addComponent(btnAppLogin, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnAtmLogin, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				)
			)
		);
		
		lytAdmin.setVerticalGroup(lytAdmin.createSequentialGroup()
			.addGroup(lytAdmin.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lblAdminName)
				.addComponent(txtAdminName)
			)
			.addGroup(lytAdmin.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lblAdminPass)
				.addComponent(txtAdminPass)
			)
			.addGroup(lytAdmin.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(btnAppLogin)
				.addComponent(btnAtmLogin)
			)
		);

		/* Main -> Bottom -> Input -> Customer */
		JPanel pnCustomerInput = new JPanel();
		pnCustomer.setLayout(new BoxLayout(pnCustomer, BoxLayout.X_AXIS));
		pnCustomer.add(Box.createHorizontalGlue());
		pnCustomer.add(pnCustomerInput);
		pnCustomer.add(Box.createHorizontalGlue());

		JLabel lblCustomerName = new JLabel("Số thẻ ATM:");
		txtCardSN = new JTextField(20);
		JLabel lblCustomerPass = new JLabel("PIN:");
		txtPIN = new JPasswordField();
		btnAppExit = new JButton("Đăng nhập");
		btnAtmExit = new JButton("Thoát");

		GroupLayout lytCustomer = new GroupLayout(pnCustomerInput);
		pnCustomerInput.setLayout(lytCustomer);
		lytCustomer.setAutoCreateGaps(true);
		lytCustomer.setAutoCreateContainerGaps(true);
		lytCustomer.setHorizontalGroup(lytCustomer.createSequentialGroup()
			.addGroup(lytCustomer.createParallelGroup(GroupLayout.Alignment.LEADING, false)
				.addComponent(lblCustomerName, 0, 80, Short.MAX_VALUE)
				.addComponent(lblCustomerPass)
			)
			.addGroup(lytCustomer.createParallelGroup(GroupLayout.Alignment.LEADING, false)
				.addComponent(txtCardSN)
				.addComponent(txtPIN)
				.addGroup(lytCustomer.createSequentialGroup()
					.addComponent(btnAppExit, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnAtmExit, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				)
			)
		);
		
		lytCustomer.setVerticalGroup(lytCustomer.createSequentialGroup()
			.addGroup(lytCustomer.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lblCustomerName)
				.addComponent(txtCardSN)
			)
			.addGroup(lytCustomer.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lblCustomerPass)
				.addComponent(txtPIN)
			)
			.addGroup(lytCustomer.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(btnAppExit)
				.addComponent(btnAtmExit)
			)
		);
		
	}

	private void addEvents() {
		rbnAdmin.addActionListener(showInput);
		rbnCustomer.addActionListener(showInput);
		btnAtmLogin.addActionListener(evtExit);
		btnAtmExit.addActionListener(evtExit);

	}
	
	private void checkConnect() {
		if (!ConnectDB.checkConnect()) {
			JOptionPane.showMessageDialog(null, "Kiểm tra kết nối Cơ sở dữ liệu.", "Lỗi",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
