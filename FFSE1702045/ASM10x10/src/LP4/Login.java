package LP4;

import LP4.connect;
import QLcanbo.canboinfoexception;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

class Login extends JFrame {
	JButton b1;
	static JLabel l1;
	boolean login = false;
	static JTextField UserName;
	static JPasswordField PassWord;
	String dbUsername, dbPassword;
	int x = 0, y = 0;

	static String levelString,idString,NameString,UserNameString;

	public Login() {
		setTitle("Background Color for JFrame");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		setLayout(new BorderLayout());
		JPanel Con = new JPanel();
		Con.setLayout(new BoxLayout(Con, BoxLayout.Y_AXIS));
		Con.setBackground(new Color(0, 0, 0, 0));
		JPanel Login = new JPanel();
		Login.setLayout(new BoxLayout(Login, BoxLayout.Y_AXIS));
		UserName = new JTextField(24);
		PassWord = new JPasswordField(24);
		JPanel PanelUserName = new JPanel();
		PanelUserName.setBackground(new Color(0, 0, 0, 0));
		JPanel PanelPassWord = new JPanel();
		PanelPassWord.setBackground(new Color(0, 0, 0, 0));
		Login.setBackground(new Color(0, 0, 0, 0));
		JLabel h1 = new JLabel("QUẢN LÍ FASTTRACK - SE", JLabel.CENTER);
		h1.setFont(new java.awt.Font("Times New Roman", 1, 18));
		h1.setForeground(new java.awt.Color(37, 97, 134));
		JPanel Head = new JPanel();
		JPanel Head1 = new JPanel();
		JPanel btn = new JPanel();
		JPanel btn1 = new JPanel();
		btn1.setBackground(new Color(0, 0, 0, 0));
		Head.setBackground(new Color(0, 0, 0, 0));
		Head1.setBackground(new Color(0, 0, 0, 0));
		btn.setBackground(new Color(0, 0, 0, 0));
		Head.add(h1);
		btn1.setPreferredSize(new Dimension(185, 0));
		Head1.setPreferredSize(new Dimension(5, 70));
		Head.setPreferredSize(new Dimension(300, 100));
		JLabel LabelUserName = new JLabel("Username");
		JLabel LabelPassWord = new JLabel("Password ");
		LabelUserName.setForeground(new java.awt.Color(37, 97, 134));
		LabelPassWord.setForeground(new java.awt.Color(37, 97, 134));
		b1 = new JButton("Đăng Nhập");
		btn.add(btn1);
		btn.add(b1);
		PanelUserName.add(LabelUserName);
		PanelUserName.add(UserName);
		PanelPassWord.add(LabelPassWord);
		PanelPassWord.add(PassWord);
		l1 = new JLabel("");
		Login.add(PanelUserName);
		Login.add(PanelPassWord);
		Login.add(btn, BorderLayout.LINE_END);
		Login.setBackground(new Color(0, 0, 0, 0));
		btn.setPreferredSize(new Dimension(0, 60));
		Login.add(l1);
		Con.add(Head1);
		Con.add(Head);
		Con.add(Login, BorderLayout.SOUTH);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(
				"C:\\Users\\ASUS\\Documents\\GitHub\\FFSE1702A.JavaCore\\FFSE1702045\\ASM10x10\\src\\bgr0.png")));
		setLayout(new FlowLayout());

		// add(Con, BorderLayout.CENTER);​
		add(Con, BorderLayout.CENTER);
		setSize(668, 499);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckUsers(connect.checkUsers());
			}
		});
	}

	public boolean CheckUsers(ResultSet resultUser) {
		String username = UserName.getText();
		String password = PassWord.getText();
		try {
			y = 0;
			QLSVException.chkHoten(username,password);
		} catch (QLSVException e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
			y = 1;
		} finally {
			if (y == 0) {
				if (x == 0) {
					l1.setText("");
					l1.setText("Tên đăng nhập hoặc mật khẩu không đúng");
					x = 1;
				}
				try {
					while (resultUser.next()) {
						dbUsername = resultUser.getString("username");
						dbPassword = resultUser.getString("password");
						login = true;
						if (dbUsername.equals(username) && dbPassword.equals(password)) {
							idString = resultUser.getString("ID");
							NameString = resultUser.getString("name");
							UserNameString = resultUser.getString("username");
							levelString = resultUser.getString("level");
												l1.setText("");
							listSV run = new listSV("");
							run.showWindow();
							setVisible(false);
							x = 0;
						}

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return login;
			}
		}
		return login;
	}
	
}