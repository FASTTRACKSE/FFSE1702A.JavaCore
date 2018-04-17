package ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class LoginUI extends JPanel {

	private static final long serialVersionUID = 1L;
	final JRadioButton rbnAdmin = new JRadioButton("Quản trị viên");
	final JRadioButton rbnCustomer = new JRadioButton("Khách hàng");
	JButton btnAdminLogin, btnCustomerLogin, btnAdminExit, btnCustomerExit;
	JPanel pnInput;
	CardLayout lyt;

	public JButton getBtnAdminLogin() {
		return btnAdminLogin;
	}

	/* Thêm sự kiện cho radiobutton */
	ActionListener showAdminInput = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton aBtn = (AbstractButton) e.getSource();
			if (aBtn.isSelected()) {
				lyt.show(pnInput, "1");
			}
		}
	};

	ActionListener showCustomerInput = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton aBtn = (AbstractButton) e.getSource();
			if (aBtn.isSelected()) {
				lyt.show(pnInput, "2");
			}
		}
	};
	
	ActionListener evtExit = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};

	public LoginUI() {
		addPanels();
		addEvents();
	}

	void addPanels() {

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
		JPanel pnAdminInput = new JPanel();
		JPanel pnCustomerInput = new JPanel();
		lyt = new CardLayout();
		pnInput.setLayout(lyt);
		pnInput.add(pnAdminInput, "1");
		pnInput.add(pnCustomerInput, "2");

		/* Main -> Bottom -> Input -> Admin */
		pnAdminInput.setLayout(new BoxLayout(pnAdminInput, BoxLayout.Y_AXIS));
		JPanel pnAdminName = new JPanel();
		JPanel pnAdminPass = new JPanel();
		JPanel pnAdminButton = new JPanel();
		btnAdminLogin = new JButton("Đăng nhập");
		btnAdminExit = new JButton("Thoát");
		pnAdminInput.add(Box.createVerticalGlue());
		pnAdminInput.add(pnAdminName);
		pnAdminInput.add(pnAdminPass);
		pnAdminInput.add(pnAdminButton);
		pnAdminInput.add(Box.createVerticalGlue());

		JLabel lblAdminName = new JLabel("Tên đăng nhập:");
		lblAdminName.setPreferredSize(new Dimension(80, 15));
		JTextField txtAdminName = new JTextField(20);
		pnAdminName.add(lblAdminName);
		pnAdminName.add(txtAdminName);

		JLabel lblAdminPass = new JLabel("Mật khẩu:");
		lblAdminPass.setPreferredSize(new Dimension(80, 15));
		JTextField txtAdminPass = new JTextField(20);
		pnAdminPass.add(lblAdminPass);
		pnAdminPass.add(txtAdminPass);

		pnAdminButton.setLayout(new BoxLayout(pnAdminButton, BoxLayout.X_AXIS));
		pnAdminButton.add(Box.createRigidArea(new Dimension(85, 0)));
		pnAdminButton.add(btnAdminLogin);
		pnAdminButton.add(Box.createRigidArea(new Dimension(20, 0)));
		pnAdminButton.add(btnAdminExit);

		/* Main -> Bottom -> Input -> Customer */
		pnCustomerInput.setLayout(new BoxLayout(pnCustomerInput, BoxLayout.Y_AXIS));
		JPanel pnCustomerName = new JPanel();
		JPanel pnCustomerPass = new JPanel();
		JPanel pnCustomnerButton = new JPanel();
		btnCustomerLogin = new JButton("Đăng nhập");
		btnCustomerExit = new JButton("Thoát");
		pnCustomerInput.add(Box.createVerticalGlue());
		pnCustomerInput.add(pnCustomerName);
		pnCustomerInput.add(pnCustomerPass);
		pnCustomerInput.add(pnCustomnerButton);
		pnCustomerInput.add(Box.createVerticalGlue());

		JLabel lblCustomerName = new JLabel("Số thẻ ATM:");
		lblCustomerName.setPreferredSize(new Dimension(80, 15));
		JTextField txtCustomerName = new JTextField(20);
		pnCustomerName.add(lblCustomerName);
		pnCustomerName.add(txtCustomerName);

		JLabel lblCustomerPass = new JLabel("PIN:");
		lblCustomerPass.setPreferredSize(new Dimension(80, 15));
		JTextField txtCustomerPass = new JTextField(20);
		pnCustomerPass.add(lblCustomerPass);
		pnCustomerPass.add(txtCustomerPass);

		pnCustomnerButton.setLayout(new BoxLayout(pnCustomnerButton, BoxLayout.X_AXIS));
		pnCustomnerButton.add(Box.createRigidArea(new Dimension(85, 0)));
		pnCustomnerButton.add(btnCustomerLogin);
		pnCustomnerButton.add(Box.createRigidArea(new Dimension(20, 0)));
		pnCustomnerButton.add(btnCustomerExit);

	}

	void addEvents() {
		rbnAdmin.addActionListener(showAdminInput);
		rbnCustomer.addActionListener(showCustomerInput);
		btnAdminExit.addActionListener(evtExit);
		btnCustomerExit.addActionListener(evtExit);
	}

}
