package Giaodien.ui;
import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
public class login extends JFrame {
	
	
	
	
	JTextField textuser;
	JPasswordField  textpass;
	JButton btn_Login;
	String pass,user;
	private Connection connect = null;
	
	public login(String title) {
		
		super(title);
		Controls();
		Events();
		
	}
private void Controls() {
		Container con = getContentPane();
		JPanel PanelMain = new JPanel();
		PanelMain.setLayout(new BoxLayout(PanelMain, BoxLayout.Y_AXIS));
		JPanel Panel1 = new JPanel();
		Panel1.setLayout(new BoxLayout(Panel1, BoxLayout.Y_AXIS));
		JPanel Panel11 = new JPanel();
		Panel11.setLayout(new BoxLayout(Panel11, BoxLayout.Y_AXIS));
		JPanel Panel12 = new JPanel();
		Panel12.setLayout(new BoxLayout(Panel12, BoxLayout.Y_AXIS));
		JPanel Panel2 = new JPanel();
		Panel2.setLayout(new BoxLayout(Panel2, BoxLayout.Y_AXIS));
		JPanel P1 = new JPanel();
		JLabel L1 = new JLabel("Tài Khoản:");
		textuser = new JTextField(18);
		P1.add(L1);
		P1.add(textuser);
		JLabel L2 = new JLabel("Mật Khẩu :");
		textpass =  new JPasswordField(18);
		P1.add(L2);
		P1.add(textpass);
		L1.setPreferredSize(L2.getPreferredSize());
		btn_Login = new JButton("Đăng Nhập");
		P1.add(btn_Login);
		Panel11.add(P1);
	
		Panel1.add(Panel11);
		PanelMain.add(Panel1);
		con.add(PanelMain);
		
		connectSQL(); 

	}
	public void Events() {
		
		btn_Login.addActionListener(dangnhap);
			}
	ActionListener dangnhap = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			update	(check());
			
		}
	};
	
	public ResultSet check() {
		pass = textpass.getText();
		user = textuser.getText();
		
		
			ResultSet result2 = null;
			String sql = "SELECT * FROM `user` WHERE user='"+user+"' AND pass = '"+pass+"'";
			try {
				Statement statement = (Statement) connect.createStatement();
				return statement.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result2;

		}
	public void update(ResultSet result2) {
		

		try {
			
			while (result2.next()) { 
			
				String dtuser = result2.getString(1);
				String dtpass = result2.getString(2);
					if(dtuser.length()>0 && dtpass.length()>0) {
						this.setVisible(false);
						DesktopUI DesktopUI = new DesktopUI("Chương trình của tui");
						DesktopUI.windows();
					
					}
			}}
		catch (SQLException e) {
			e.printStackTrace();
		}}
	
	public void connectSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = new String("jdbc:mysql://localhost:3306/quangnc1?useUnicode=true&characterEncoding=utf-8");
			try {
				connect = (Connection) DriverManager.getConnection(url, "quangnc1", "abc123");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
			public void showWindow() {
				this.setSize(320, 130);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				this.setLocationRelativeTo(null);
				this.setVisible(true);
			}	}
			