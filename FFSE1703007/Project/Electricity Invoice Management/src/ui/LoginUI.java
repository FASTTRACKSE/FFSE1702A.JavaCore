package ui;

import java.awt.Container;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.MySQL;

public class LoginUI extends JFrame {
	JTextField txtUser, txtPass;
	JButton btnButtonLogin;

	public LoginUI(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		addControls();
		addEvents();
	}

	public void showWindow() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	void addControls() {
		Container con = getContentPane();

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnAppName = new JPanel();
		pnAppName.setMaximumSize(new Dimension(800, 100));
		JLabel lblAppName = new JLabel("Electricity Invoice Management");
		Font fontAppName = new Font("arial", Font.BOLD, 20);
		lblAppName.setFont(fontAppName);
		pnAppName.add(lblAppName);

		JPanel pnUser = new JPanel();
		pnUser.setMaximumSize(new Dimension(800, 50));
		JLabel lblUser = new JLabel("Username");
		lblUser.setPreferredSize(new Dimension(80, 10));
		txtUser = new JTextField(15);
		pnUser.add(lblUser);
		pnUser.add(txtUser);

		JPanel pnPass = new JPanel();
		pnPass.setMaximumSize(new Dimension(800, 100));
		JLabel lblPass = new JLabel("Password");
		lblPass.setPreferredSize(new Dimension(80, 10));
		txtPass = new JTextField(15);
		pnPass.add(lblPass);
		pnPass.add(txtPass);

		JPanel pnButtonLogin = new JPanel();
		pnButtonLogin.setMaximumSize(new Dimension(800, 100));
		btnButtonLogin = new JButton("Đăng nhập");
		pnButtonLogin.add(btnButtonLogin);

		JPanel pnConnection = new JPanel();
		pnConnection.setMaximumSize(new Dimension(800, 100));
		JLabel lblConnection = new JLabel("");
		if (MySQL.checkConnection()) {
			lblConnection.setText("Kết nối thành công");
		} else {
			lblConnection.setText("Kết nối thất bại");
			;
		}
		pnConnection.add(lblConnection);
		
		JPanel copyRight = new JPanel();
		copyRight.setMaximumSize(new Dimension(800, 100));
		JLabel lblCopyRight = new JLabel("© Lê Hữu Hoài Nam");
		copyRight.add(lblCopyRight);

		pnMain.add(pnAppName);
		pnMain.add(pnUser);
		pnMain.add(pnPass);
		pnMain.add(pnButtonLogin);
		pnMain.add(pnConnection);
		pnMain.add(copyRight);

		con.add(pnMain);
	}

	ActionListener eventLogin = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (login()) {
				HomeUI homeUI = new HomeUI("Electricity Invoice Management");
				homeUI.showWindow();
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
			}
		}
	};

	boolean login() {
		if (MySQL.checkLogin(txtUser.getText(), txtPass.getText())) {
			return true;
		} else {
			return false;
		}
	}

	void addEvents() {
		btnButtonLogin.addActionListener(eventLogin);
		txtUser.addActionListener(eventLogin);
		txtPass.addActionListener(eventLogin);
	}
}
