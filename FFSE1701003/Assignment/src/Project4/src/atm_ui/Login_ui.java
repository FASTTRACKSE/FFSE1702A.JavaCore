package atm_ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


import atm_main.MyApp;
import atm_model.Session_model;
import atm_model.atm_connection;

public class Login_ui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel f_login;
	private JTextField txtUsername;
	private JPasswordField txtPassWord;
	private JButton btnLogin;
	private String _snCard, _soTK;
	private final static Connection conn = atm_connection.getConnect();

	public String getUsername() {
		return _snCard;
	}

	public void setUsername(String username) {
		this._snCard = username;
	}

	public String getPassword() {
		return _soTK;
	}

	public void setPassword(String password) {
		this._soTK = password;
	}

	public Login_ui(String title) {
		super(title);
		addControls();
		addEvents();
		showWindow();
	}

	public void addControls() {
		f_login = new JPanel();
		f_login.setLayout(new BoxLayout(f_login, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Đăng nhập hệ thống");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// panel username
		JPanel pnUsername = new JPanel();
		JLabel lbUsername = new JLabel("Username: ");
		lbUsername.setPreferredSize(new Dimension(80, 20));
		txtUsername = new JTextField(15);
		pnUsername.add(lbUsername);
		pnUsername.add(txtUsername);

		// panel password
		JPanel pnPassword = new JPanel();
		JLabel lbPassword = new JLabel("Password: ");
		lbPassword.setPreferredSize(new Dimension(80, 20));
		txtPassWord = new JPasswordField(15);
		
		pnPassword.add(lbPassword);
		pnPassword.add(txtPassWord);

		// panel action
		JPanel pnAction = new JPanel();
		btnLogin = new JButton("Đăng nhập");
		pnAction.add(btnLogin);

		// panel main
		f_login.add(pnTitle);
		f_login.add(pnUsername);
		f_login.add(pnPassword);
		f_login.add(pnAction);

		this.add(f_login);
	}

	public void addEvents() {
		btnLogin.addActionListener(eventLogin);
	}

	ActionListener eventLogin = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String snCard = txtUsername.getText();
			char[] soTK = txtPassWord.getPassword();
			String numberTK = String.valueOf(soTK);
			if (snCard.equals("") || numberTK.equals("")) {
				JOptionPane.showMessageDialog(getParent(), "Bạn chưa nhập đầy đủ thông tin");
			} else {
				try {
					Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					String sql = "SELECT * FROM tbl_customer WHERE sn_card = '" + snCard + "' AND soTKNH = '"
							+ numberTK + "'";
					ResultSet rs = stm.executeQuery(sql);
					if (rs.next()) {
						 Session_model.setLoginName(rs.getString("code"));
						 Session_model.setSnCard(rs.getInt("sn_card"));
						
						JOptionPane.showMessageDialog(f_login, "Bạn đăng nhập thành công !", "Thông báo", 1);
						new MyApp().setVisible(true);
						closeWindow();
					} else {
						JOptionPane.showMessageDialog(f_login, "Tài khoản hoặc mật khẩu không chính xác !", "Error", 1);
						txtUsername.setText("");
						txtPassWord.setText("");
						txtUsername.requestFocus();
					}
				} catch (SQLException error) {
				}

			}
		}
	};

	public void checkInput() {
		String snCard = txtUsername.getText();
		char[] soTK = txtPassWord.getPassword();
		String numberTK = String.valueOf(soTK);
		if(!snCard.equals("")) {
			this._snCard = snCard;
		}
		if(!numberTK.equals("")) {
			this._soTK = numberTK;
		}
	}
	
	private void closeWindow() {
		this.dispose();
	}

	public void showWindow() {
		this.setSize(500, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Login_ui("Đăng nhập");
	}
}

