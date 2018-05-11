package tiendien.UI;

import tiendien.MODEL.ExceptionMD;
import tiendien.MODEL.database;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class loginUI extends JFrame {
	Connection conn = database.getConnect("localhost", "quanlytiendien", "quanlytiendien", "quanlytiendien");
	ResultSet res;

	static String email, login;
	JLabel userName, passWord, title;
	JPasswordField text_passWord;
	JTextField text_userName;
	JLabel xxx;
	JButton bt_login, bt_exit;
	Container con = getContentPane();
	JPanel boxAll;

	public loginUI() {
		super("Quản Lý Tiền Điện");
		addControls();
		addEvents();
	}

	private void addControls() {

		// box main
		boxAll = new JPanel();
		boxAll.setLayout(new BoxLayout(boxAll, BoxLayout.Y_AXIS));
		con.add(boxAll);

		// title
		JLabel titleBox = new JLabel("Quản Lý Tiền Điện");
		titleBox.setFont(new Font("Courier New", Font.CENTER_BASELINE, 22));
		titleBox.setForeground(Color.red);
		boxAll.add(titleBox);
		//
		JPanel box_xxx = new JPanel();
		xxx = new JLabel(" ");
		box_xxx.add(xxx);
		boxAll.add(box_xxx);

		// khung userName
		JPanel box_user = new JPanel();
		userName = new JLabel("usename  : ");
		text_userName = new JTextField(20);
		userName.setFont(new Font("Courier New", Font.ITALIC, 15));
		text_userName.setFont(new Font("Courier New", Font.ITALIC, 15));
		box_user.add(userName);
		box_user.add(text_userName);
		boxAll.add(box_user);

		// khung password
		JPanel box_pass = new JPanel();
		passWord = new JLabel("password : ");
		text_passWord = new JPasswordField(20);
		passWord.setFont(new Font("Courier New", Font.ITALIC, 15));
		text_passWord.setFont(new Font("Courier New", Font.ITALIC, 15));
		box_pass.add(passWord);
		box_pass.add(text_passWord);
		boxAll.add(box_pass);

		// button
		JPanel box_bt = new JPanel();
		bt_login = new JButton("Đăng Nhập");
		bt_exit = new JButton("Thoát");
		box_bt.add(bt_login);
		box_bt.add(bt_exit);
		box_bt.setLayout(new FlowLayout());
		boxAll.add(box_bt);
	}

	// đây là sự kiện
	private void addEvents() {

		// button login
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		// tuỳ chỉnh button thoát
		bt_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	// check login
	public void login() {
		// check empty
		if (text_userName.getText().equals("") || new String(text_passWord.getPassword()).equals("")) {
			String message_rong = "tài khoản và mật khẩu rỗng ";
			JOptionPane.showMessageDialog(null, message_rong);
			return;
		}
		// ---------------------//
		try {
			res = conn.createStatement()
					.executeQuery(String.format("select * from ffse004_admin where userName = '%s' and password = '%s'",
							text_userName.getText(), new String(text_passWord.getPassword())));
			if (res != null) {
				try {
					if (res.next()) {
						try {
							if (res.getString("password").equals(new String(text_passWord.getPassword()))) {

								// Login successful DO SOMETHING HERE
								login = "true";
								menuUI myMenu = new menuUI();
								try {
									myMenu.hienthi();
								} catch (ExceptionMD e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								this.dispose();

							} else {
								String message_f = "Sai Tài Khoản Hoặc Mật Khẩu";
								JOptionPane.showMessageDialog(null, message_f);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						// đăng nhập bằng theo khách hàng
						try {
							res = conn.createStatement()
									.executeQuery(String.format(
											"SELECT * FROM ffse004_used WHERE userName = '%s' AND passWord = '%s'",
											text_userName.getText(), new String(text_passWord.getPassword())));
							if (res != null) {
								try {
									if (res.next()) {
										try {
											if (res.getString("password")
													.equals(new String(text_passWord.getPassword()))) {
												email = text_userName.getText();
												login = "true";
												// Login successful DO SOMETHING HERE
												customerUI myMenu = new customerUI();
												try {
													myMenu.hienthi_customer();
												} catch (ExceptionMD e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												this.dispose();
											} else {
												String message_f = "Sai Tài Khoản Hoặc Mật Khẩu";
												JOptionPane.showMessageDialog(null, message_f);
											}
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}else {
										String message_f = "Sai Tài Khoản Hoặc Mật Khẩu";
										JOptionPane.showMessageDialog(null, message_f);
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showWindow() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
