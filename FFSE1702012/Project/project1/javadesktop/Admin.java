package project1.javadesktop;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
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

import com.mysql.jdbc.PreparedStatement;

public class Admin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfusername;
	private JTextField tfpass;
	private JButton btnexit, btnlogin;
	Connection conn = null;
	PreparedStatement ptmt = null;

	private JLabel lbusername;

	public Admin() {
		Addcontrolls();
		Addevents();
	}

	public void Addevents() {
		btnlogin.addActionListener(this);
		btnexit.addActionListener(this);
		lbusername.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				tfusername.setText("lehung");
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				// tfusername.setText("lequochung");
			}

		});
	}

	/*
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton) e.getSource();
		if (bt == btnlogin) {

			String username = tfusername.getText();
			String password = md5(tfpass.getText());
			int i = 0;
			String sql = "select * from Admin where BINARY Username = '" + username + "' and Password = '" + password
					+ "'";
			try {
				conn = Connection_Database.Ketnoi();
				if (conn == null) {
					System.exit(0);
				}

				ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();

				while (rs.next()) {
					i++;
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Yêu cầu kết nối Database", "Thông báo lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
			if (i > 0) {
				Homepage hp = new Homepage("PHẦN MỀM TÍNH TIỀN ĐIỆN");
				hp.showWindow();
				super.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Xin mời nhập đúng tài khoản");
			}

		} else if (bt == btnexit) {
			int click = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn thoát?");
			if (click == JOptionPane.YES_OPTION) {
				Login lg = new Login();
				lg.setVisible(true);
				super.setVisible(false);
			} else if (click == JOptionPane.NO_OPTION) {
				super.setVisible(true);
			} else if (click == JOptionPane.CANCEL_OPTION) {
				super.setVisible(true);
			}

		}
	}

	/*
	 * chuyen pass sang dang MD5
	 */
	public String md5(String str) {
		MessageDigest md;
		String result = "";
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			BigInteger bi = new BigInteger(1, md.digest());

			result = bi.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * lay Username vaf password xuong
	 */

	/**
	 * Create the frame.
	 */
	public void Addcontrolls() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
		setResizable(false);
		setTitle("PHẦN MỀM QUẢN LÝ TIỀN ĐIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 420);
		Container con = getContentPane();
		getContentPane().setLayout(null);

		JPanel pntitle = new JPanel();
		pntitle.setBackground(new Color(139, 0, 139));
		pntitle.setBounds(10, 11, 624, 69);
		con.add(pntitle);
		JLabel lbtitle = new JLabel("TRANG ĐĂNG NHẬP CHO ADMIN");
		pntitle.setLayout(new BoxLayout(pntitle, BoxLayout.X_AXIS));
		pntitle.add(javax.swing.Box.createRigidArea(new Dimension(130, 5)));
		lbtitle.setForeground(Color.WHITE);
		lbtitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
		pntitle.add(lbtitle);

		lbusername = new JLabel("TÀI KHOẢN");
		lbusername.setBounds(148, 126, 74, 14);
		lbusername.setForeground(Color.BLACK);
		lbusername.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		getContentPane().add(lbusername);

		tfusername = new JTextField();
		tfusername.setBounds(289, 123, 178, 20);
		getContentPane().add(tfusername);
		tfusername.setColumns(10);

		JLabel lbpass = new JLabel("MẬT KHẨU");
		lbpass.setBounds(148, 167, 74, 14);
		lbpass.setForeground(Color.BLACK);
		lbpass.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		getContentPane().add(lbpass);

		tfpass = new JPasswordField();
		tfpass.setBounds(289, 164, 178, 20);
		getContentPane().add(tfpass);

		btnexit = new JButton("Thoát");
		btnexit.setForeground(Color.RED);
		btnexit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnexit.setBounds(180, 240, 101, 30);
		btnexit.setIcon(new ImageIcon("exit.jpg"));
		getContentPane().add(btnexit);

		btnlogin = new JButton("Đăng nhập");
		btnlogin.setForeground(Color.RED);
		btnlogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnlogin.setBounds(351, 240, 116, 30);
		getContentPane().add(btnlogin);

		JLabel lbeditor = new JLabel("Phần mềm quản lý tiền điện Đà Nẵng");
		lbeditor.setBounds(220, 343, 214, 17);
		getContentPane().add(lbeditor);
		lbeditor.setForeground(Color.RED);
		lbeditor.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		ImageIcon icon = new ImageIcon("login.jpg");

	}

}