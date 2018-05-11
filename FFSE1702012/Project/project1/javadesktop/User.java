package project1.javadesktop;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

public class User extends JFrame implements ActionListener {
	private JLabel lbusername;
	private JPanel contentPane;
	private JTextField tfusername;
	private JTextField tfpass;
	private JButton btnexit,btnlogin;
	static Connection conn = null;
	static PreparedStatement ptmt = null;
	static String makh1 = "";
	static String mact1 = "";
	
	public User()
	{
		Addcontrolls();
		Addevents();
	}
	public void Addevents()
	{
		lbusername.addMouseListener(event);
		btnlogin.addActionListener(this);
		btnexit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton) e.getSource();
		if(bt == btnlogin)
		{
			String makh = tfusername.getText();
			String password = md5(tfpass.getText());
			int i = 0;
			String sql = "select * from User  where  BINARY Makh = '" + makh + "' and Password = '" + password +"'";
			try {
				conn = Connection_Database.Ketnoi();
				if (conn == null) {
					System.exit(0);
				}

				ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();
				
				while(rs.next())
				{
					i++;
					 mact1 = rs.getString("Macongto");
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Lỗi" + e1);
			}
			if(i > 0)
			{
				makh1 = makh;
				PageUser pguser = new PageUser();
				pguser.setVisible(true);
				super.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Xin mời nhập đúng tài khoản");
			}
		}
		else if(bt == btnexit)
		{
			int click = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn thoát?");
			if (click == JOptionPane.YES_OPTION) {
				Login lg = new Login();
				lg.setVisible(true);
				super.setVisible(false);
			} else if (click == JOptionPane.NO_OPTION) {
				super.setVisible(true);
			}
			else if(click == JOptionPane.CANCEL_OPTION)
			{
				super.setVisible(true);
			}
		
		}
		
		
	}


	
	/*
	 * 
	 */
	/*
	 * chuyen pass sang dang MD5
	 */
	public String md5(String str){
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
	 * thuc hien khi click val LaBel:
	 */
	MouseAdapter event = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			JLabel lb = (JLabel) e.getSource();
			if (lb == lbusername) {
				tfusername.setText("DL_00");
			}
		}
	};

	/**
	 * Create the frame.
	 */
	public void Addcontrolls() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
		setTitle("PHẦN MỀM QUẢN LÝ TIỀN ĐIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 420);
		Container con = getContentPane();
		getContentPane().setLayout(null);
		
		JPanel pntitle = new JPanel();
		pntitle.setBounds(50, 21, 521, 37);
		con.add(pntitle);
		JLabel lbtitle = new JLabel("TRANG ĐĂNG NHẬP CHO USER");
		lbtitle.setForeground(Color.RED);
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
		
		btnexit = new JButton("Quay lại");
		btnexit.setForeground(Color.RED);
		btnexit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnexit.setBounds(208, 240, 101, 30);
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