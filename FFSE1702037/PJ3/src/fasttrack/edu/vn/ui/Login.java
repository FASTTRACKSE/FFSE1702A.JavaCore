package fasttrack.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fasttrack.edu.vn.main.ConnectDB;

public class Login extends JFrame {
	String pass, email;

	ConnectDB cn = new ConnectDB();
	Connection conn = cn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");

	JTextField txtUsername, txtPass;
	JButton btnlogin;

	public Login(String tieude) {
		super(tieude);

		addControls();

		addEvents();

	}

	ActionListener eventMenu = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			DangNhap();

		}
	};

	protected void Menu() {

		email = txtUsername.getText();
		pass = txtPass.getText();
		if (!pass.equals("123123")) {
			Menu myUI = new Menu("My Application");
			myUI.showWindow();
			dispose();
		} else {
			KhachHang myUI = new KhachHang(email);
			myUI.showWindow();
			dispose();
		}
	}

	public void addEvents() {
		btnlogin.addActionListener(eventMenu);
	}

	public void addControls() {
		JPanel panelGirBagLayout = new JPanel();

		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		//gridBagConstraints.insets = new Insets(20, 20, 10, 10);
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.ipadx = 20;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.insets = new Insets(10, 10, 10, 10);
		panelGirBagLayout.setLayout(gridBagLayout);
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("ĐĂNG NHẬP TÀI KHOẢN");
		Font fontTitle = new Font("Time new roman", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		gridBagConstraints.gridwidth = 3;
		panelGirBagLayout.add(pnTitle, gridBagConstraints);
		
		JPanel pnInput3 = new JPanel();
		JLabel lblTitle3 = new JLabel("Tên đăng nhập :");
		pnInput3.add(lblTitle3);
		lblTitle3.setPreferredSize(new Dimension(80, 20));
		panelGirBagLayout.add(pnInput3, gridBagConstraints1);
		txtUsername = new JTextField(15);
		pnInput3.add(txtUsername);
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 1;
		panelGirBagLayout.add(pnInput3, gridBagConstraints1);
		
		JPanel pnInput4 = new JPanel();
		JLabel lblTitle4 = new JLabel("Mật khẩu :");
		pnInput4.add(lblTitle4);
		lblTitle4.setPreferredSize(new Dimension(80, 20));
		panelGirBagLayout.add(pnInput4, gridBagConstraints1);
		txtPass = new JPasswordField(15);
		pnInput4.add(txtPass);
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 2;
		panelGirBagLayout.add(pnInput4, gridBagConstraints1);
		
		JPanel pnAction = new JPanel();	
		btnlogin = new JButton("Tìm kiếm");
		pnAction.add(btnlogin);
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 3;
		panelGirBagLayout.add(pnAction, gridBagConstraints1);

		this.add(panelGirBagLayout);
	}

	PreparedStatement ptmt = null;

	public void DangNhap() {
		String sql = "SELECT * from qlkh where  BINARY Email = ? and Pass = ?";
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, txtUsername.getText());
			ptmt.setString(2, txtPass.getText());
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				Menu();
			} else {
				JOptionPane.showMessageDialog(null, "không thể login");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Loi " + e1.getMessage());
		}
	}

	public void showWindow() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
