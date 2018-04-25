package ui;

import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.CustomerDB;
import model.SessionLogin;
import model.User;
import model.UserDB;

public class ControlUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnMain;
	private AtmSimulationUI pnAtmSimulation;
	private LoginUI pnLogin;
	private ManagementUI pnManagement;
	private CardLayout cardlayout;
	
	private LoginListener evtAppLogin = new LoginListener() {
		@Override
		public boolean doLogin(String username, String password) {
			if(UserDB.isLogin(username, password)) {
				User user = UserDB.getUser(username, password);
				SessionLogin.setUser(user);
				
				pnManagement = new ManagementUI();
				pnManagement.addLogoutListener(evtLogout);
				pnMain.add(pnManagement, "2");
				cardlayout.show(pnMain, "2");
				
				if (user.getRole() == 1) {
					showManagement();
				} else {
					showCustomer();
				}
				return true;
			} 
			return false;
		}
	};
	
	private LoginListener evtAtmLogin = new LoginListener() {
		@Override
		public boolean doLogin(String cardSN, String pin) {
			if (CustomerDB.isLogin(cardSN, pin)) {
				pnAtmSimulation = new AtmSimulationUI(cardSN);
				pnAtmSimulation.addLogoutListener(evtLogout);
				pnMain.add(pnAtmSimulation, "3");
				cardlayout.show(pnMain, "3");
				showATM();
				return true;
			}
			return false;
		}
	};
	
	private LogoutListener evtLogout = new LogoutListener() {
		@Override
		public void doLogout() {
			int cf = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn thoát?", "Xác nhận",
					JOptionPane.YES_NO_OPTION);
			if (cf == JOptionPane.YES_OPTION) {
				cardlayout.show(pnMain, "1");
				showLogin();
			}
		}
	};
	
	public ControlUI(String title) {
		super(title);
		addControls();
	}

	private void addControls() {
		/* Main Panel */
		Container con = getContentPane();
		pnMain = new JPanel();
		cardlayout = new CardLayout();
		pnMain.setLayout(cardlayout);
		con.add(pnMain);
		
		pnLogin = new LoginUI();
		pnLogin.addAppLoginListener(evtAppLogin);
		pnLogin.addAtmLoginListener(evtAtmLogin);
		pnMain.add(pnLogin, "1");
				
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
