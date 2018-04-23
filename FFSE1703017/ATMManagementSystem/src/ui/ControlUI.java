package ui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.CustomerDB;
import model.User;
import model.UserDB;

public class ControlUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnMain;
	private ATMSimulation pnCustomer;
	private LoginUI pnLogin;
	private ManagementUI pnManagement;
	private CardLayout cardlayout;
	private JButton btnAppLogin, btnAtmLogin;
	private JTextField txtAdminName, txtCardSN;
	private JPasswordField txtAdminPass, txtPIN;
	
	private ActionListener adminLogin = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = txtAdminName.getText();
			String password = new String(txtAdminPass.getPassword());
			if(UserDB.isLogin(username, password)) {
				User user = UserDB.getUser(username, password);
				
				pnManagement = new ManagementUI(user);
				pnManagement.getBtnLogout().addActionListener(adminLogout);
				pnMain.add(pnManagement, "2");
				cardlayout.show(pnMain, "2");
				
				if (user.getRole() == 1) {
					showManagement();
				} else {
					showCustomer();
				}
				
				txtAdminName.setText("");
				txtAdminPass.setText("");
				
			} else {
				JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu.", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtAdminName.requestFocus();
			}
		}
	};
	
	private ActionListener adminLogout = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int cf = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn thoát?", "Xác nhận",
					JOptionPane.YES_NO_OPTION);
			if (cf == JOptionPane.YES_OPTION) {
				cardlayout.show(pnMain, "1");
				showLogin();
			}
		}
	};
	
	private ActionListener customerLogin = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cardSN = txtCardSN.getText();
			String pin = new String(txtPIN.getPassword());
			if (CustomerDB.isLogin(cardSN, pin)) {
				pnCustomer = new ATMSimulation(cardSN);
				pnCustomer.getBtnLogout().addActionListener(customerLogout);
				pnMain.add(pnCustomer, "3");
				cardlayout.show(pnMain, "3");
				showATM();
				
				txtCardSN.setText("");
				txtPIN.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Sai mật khẩu.", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtCardSN.requestFocus();
			}
		}
	};
	
	private ActionListener customerLogout = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardlayout.show(pnMain, "1");
			showLogin();
		}
	};


	public ControlUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	private void addControls() {
		/* Main Panel */
		Container con = getContentPane();
		pnMain = new JPanel();
		cardlayout = new CardLayout();
		pnMain.setLayout(cardlayout);
		con.add(pnMain);
		
		pnLogin = new LoginUI();
		pnMain.add(pnLogin, "1");
		btnAppLogin = pnLogin.getBtnAppLogin();
		txtAdminName = pnLogin.getTxtAdminName();
		txtAdminPass = pnLogin.getTxtAdminPass();
		btnAtmLogin = pnLogin.getBtnAtmLogin();
		txtCardSN = pnLogin.getTxtCardSN();
		txtPIN = pnLogin.getTxtPIN();
				
	}

	private void addEvents() {
		txtAdminName.addActionListener(adminLogin);
		txtAdminPass.addActionListener(adminLogin);
		btnAppLogin.addActionListener(adminLogin);
		
		txtCardSN.addActionListener(customerLogin);
		txtPIN.addActionListener(customerLogin);
		btnAtmLogin.addActionListener(customerLogin);
	}

	public void showWindow() {
		ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo.png"));
		this.setIconImage(logo.getImage());
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void showLogin() {
		this.dispose();
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("TPBank - Đăng nhập");
		this.setVisible(true);
	}
	
	private void showManagement() {
		this.dispose();
		this.setSize(1200, 500);
		this.setLocationRelativeTo(null);
		this.setTitle("TPBank - Hệ thống quản lý ATM");
		this.setVisible(true);
	}
	
	private void showCustomer() {
		this.dispose();
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("TPBank - Hệ thống quản lý ATM");
		this.setVisible(true);
	}
	
	private void showATM() {
		this.dispose();
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("TPBank - Mô phỏng ATM");
		this.setVisible(true);
	}

	
}
