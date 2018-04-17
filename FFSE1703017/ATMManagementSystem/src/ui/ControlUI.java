package ui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlUI extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel pnMain, pnCustomer;
	LoginUI pnLogin;
	ManagementUI pnManagement;
	CardLayout cardlayout;
	JButton btnAmindLogin, btnAdminLogout;
	JLabel lblWelcome;

	public ControlUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void addControls() {
		/* Main Panel */
		Container con = getContentPane();
		pnMain = new JPanel();
		cardlayout = new CardLayout();
		pnMain.setLayout(cardlayout);
		con.add(pnMain);
		
		pnLogin = new LoginUI();
		pnManagement = new ManagementUI();
		pnCustomer = new JPanel();
		
		pnMain.add(pnLogin, "1");
		pnMain.add(pnManagement, "2");
		
		btnAmindLogin = pnLogin.getBtnAdminLogin();
		btnAdminLogout = pnManagement.getBtnLogout();
		lblWelcome = pnManagement.getLblWelcome();
				
	}

	public void addEvents() {
		btnAmindLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(pnMain, "2");
				showManagement();
				String welcome = "Xin chào, Administrator.";
				lblWelcome.setText(welcome);
				
			}
		});
		
		btnAdminLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(pnMain, "1");
				showLogin();
			}
		});
		

	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void showLogin() {
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("TPBank - Đăng nhập");
	}
	
	public void showManagement() {
		this.setSize(1200, 500);
		this.setLocationRelativeTo(null);
		this.setTitle("TPBank - Hệ thống quản lý ATM");
	}

	
}
