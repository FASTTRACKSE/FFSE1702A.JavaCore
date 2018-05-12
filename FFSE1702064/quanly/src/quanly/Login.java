package quanly;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import quanly.KhachHang;
import quanly.model.database;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTable;
public class Login extends JFrame{
	database db;
	Connection con;
	JLabel lableUser,lablePassword;
	JTextField JtextUser;
	JPasswordField JtextPassword;
	JButton login,thoat;
//	public Login() {
//		db = new database();
//		con = db.connectSQL();
//	}
	public Login(String tieude) {
		super(tieude);
		addControls();
		addEvents();
		
		// Connect DB
		db = new database();
		con = db.connectSQL();
		
	}
	public void addControls() {
		Container con = getContentPane();
		// main chinh hien thi noi dung
		JPanel Panelchinh = new JPanel();
		Panelchinh.setLayout(new BoxLayout(Panelchinh, BoxLayout.Y_AXIS));
		JPanel title =new JPanel();
		JLabel Title=new JLabel("Quản lý ti�?n điện");
		Font fonttitle=new Font("Arial",Font.BOLD,30);
		Title.setFont(fonttitle);
		title.add(Title);
		//Username
		JPanel username = new JPanel();
		lableUser= new JLabel("Username");
		JtextUser = new JTextField(15);
		username.add(lableUser);
		username.add(JtextUser);
		//Password
		JPanel password = new JPanel();
		lablePassword= new JLabel("Username");
		JtextPassword = new JPasswordField(15);
		password.add(lablePassword);
		password.add(JtextPassword);
		//Button
		JPanel button = new JPanel();
		login= new JButton("Login");
		thoat= new JButton("Thoát");
		button.add(login);
		button.add(thoat);
		//ThÃªm vÃ o panel chÃ­nh
		Panelchinh.add(title);
		Panelchinh.add(username);
		Panelchinh.add(password);
		Panelchinh.add(button);
		//ThÃªm vÃ o container
		con.add(Panelchinh);
	}
	ActionListener Login = new ActionListener() {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (con != null) {
				String sql = "SELECT * FROM User WHERE Username=? and Password=?";

				try {
					PreparedStatement ptmt = (PreparedStatement) con.prepareStatement(sql);

					ptmt.setString(1, JtextUser.getText());
					ptmt.setString(2, JtextPassword.getText());

					ResultSet rs = ptmt.executeQuery();

					if (rs.next()) {

						if (rs.getString("Username").equals("manhdung") && rs.getString("Password").equals("123456")) {
							Home myUI = new Home("Khách hàng");
							myUI.showWindow();
							myUI.setVisible(true);
//							if (con != null) {
//						        try {
//						            con.close();
//						        } catch (SQLException e) { /* ignored */}
//						    }
							dispose();
							JOptionPane.showMessageDialog(null, "�?ăng nhập thành công!");

						}
					} else {
						JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu chưa đúng!");
					}
				} catch (SQLException e) {
					System.out.println("loi  " + e.getMessage());

				}
			} else {
				System.out.println("Kết nối thất bại");
			}
		}

	};
	public void addEvents() {
		login.addActionListener(Login);
		thoat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public void showWindow() {
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
