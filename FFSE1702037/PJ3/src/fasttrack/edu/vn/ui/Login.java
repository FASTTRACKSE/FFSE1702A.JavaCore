package fasttrack.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
			Menu myUI = new Menu("Phần mềm quản lý tiền điện");
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
		this.setResizable(false);
		JPanel panelGirBagLayout = new JPanel();

		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		// gridBagConstraints.insets = new Insets(20, 20, 10, 10);
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.ipadx = 20;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.insets = new Insets(10, 10, 10, 10);
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		panelGirBagLayout.setLayout(gridBagLayout);

		ImageIcon imageIcon = new ImageIcon(new ImageIcon("image/dienluc1.jpg").getImage().getScaledInstance(290, 434, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(imageIcon);
		gridBagConstraints.gridheight = 6;
		panelGirBagLayout.add(label, gridBagConstraints3);
		JPanel pnTong = new JPanel();
		pnTong.setLayout(new BoxLayout(pnTong, BoxLayout.Y_AXIS));
		JPanel pnTong1 = new JPanel();
		pnTong1.setLayout(new BoxLayout(pnTong1, BoxLayout.X_AXIS));
		JPanel pnTong2 = new JPanel();
		pnTong2.setLayout(new BoxLayout(pnTong2, BoxLayout.Y_AXIS));
		
		JPanel pnTitle1 = new JPanel();
		JLabel lblTitle1 = new JLabel("");
		lblTitle1.setPreferredSize(new Dimension(160, 20));
		pnTitle1.add(lblTitle1);
		pnTong1.add(pnTitle1);
		
		JPanel pnTitle11 = new JPanel();
		JLabel lblTitle11 = new JLabel("");
		lblTitle11.setPreferredSize(new Dimension(160, 20));
		pnTitle11.add(lblTitle11);
		pnTong1.add(pnTitle11);
		
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("ĐĂNG NHẬP TÀI KHOẢN");
		Font fontTitle = new Font("Time new roman", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		pnTong2.add(pnTitle);
//		gridBagConstraints3.gridx = 0;
//		gridBagConstraints3.gridy = 1;
//		panelGirBagLayout.add(pnTitle, gridBagConstraints3);

		JPanel pnInput3 = new JPanel();
		JLabel lblTitle3 = new JLabel("Tài khoản :");
		pnInput3.add(lblTitle3);
		lblTitle3.setPreferredSize(new Dimension(80, 20));
		panelGirBagLayout.add(pnInput3, gridBagConstraints1);
		txtUsername = new JTextField(10);
		pnInput3.add(txtUsername);
		pnTong2.add(pnInput3);
//		gridBagConstraints3.gridx = 1;
//		gridBagConstraints3.gridy = 1;
//		panelGirBagLayout.add(pnInput3, gridBagConstraints3);

		JPanel pnInput4 = new JPanel();
		JLabel lblTitle4 = new JLabel("Mật khẩu :");
		pnInput4.add(lblTitle4);
		lblTitle4.setPreferredSize(new Dimension(80, 20));
		panelGirBagLayout.add(pnInput4, gridBagConstraints3);
		txtPass = new JPasswordField(10);
		pnInput4.add(txtPass);
		pnTong2.add(pnInput4);
//		gridBagConstraints3.gridx = 1;
//		gridBagConstraints3.gridy = 1;
//		panelGirBagLayout.add(pnInput4, gridBagConstraints3);

		JPanel pnAction = new JPanel();
		btnlogin = new JButton("Đăng nhập");
		pnAction.add(btnlogin);
		pnTong2.add(pnAction);
		pnTong.add(pnTong1);
		pnTong.add(pnTong2);

		gridBagConstraints3.gridx = 1;
		gridBagConstraints3.gridy =0;
		panelGirBagLayout.add(pnTong, gridBagConstraints3);

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
		this.setSize(646, 473);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
