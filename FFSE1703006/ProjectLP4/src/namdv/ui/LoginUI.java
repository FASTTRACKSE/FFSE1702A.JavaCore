package namdv.ui;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import namdv.main.MyApp;
import namdv.model.AccountModel;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnDangNhap;
	private AccountModel accountModel = new AccountModel();

	public void showWindow() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public LoginUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();

		showWindow();
	}

	private void addControls() {
		Container con = getContentPane();

		JPanel pnl = new JPanel();
		con.add(pnl);

		pnl.setBorder(new TitledBorder(null, "Đăng nhập", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));

		JPanel pnlUser = new JPanel();
		pnl.add(pnlUser);

		JLabel lblUser = new JLabel("Tài khoản:");
		pnlUser.add(lblUser);

		textField = new JTextField();
		pnlUser.add(textField);
		textField.setColumns(15);

		JPanel pnlPass = new JPanel();
		pnl.add(pnlPass);

		JLabel lblPass = new JLabel("Mật khẩu:");
		pnlPass.add(lblPass);

		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		pnlPass.add(passwordField);

		JPanel pnlButton = new JPanel();
		pnl.add(pnlButton);

		btnDangNhap = new JButton("Đăng nhập");
		pnlButton.add(btnDangNhap);
	}

	private void addEvents() {
		passwordField.addActionListener(new EnterListener());
		btnDangNhap.addActionListener(new DangNhapListener());
	}

	private class EnterListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnDangNhap.doClick();
		}
	}

	private class DangNhapListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				if (accountModel.checkLogin(username, password)) {
					MyApp.loginFrame.dispose();
					MyApp.mainFrame = new QuanLyThuVienUI("Quản lí thư viện");
				} else {
					JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng!");
				}
			} catch (HeadlessException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
