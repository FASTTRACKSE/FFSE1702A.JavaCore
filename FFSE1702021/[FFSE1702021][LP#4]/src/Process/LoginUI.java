package Process;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Data.Connect;
import Data.phuong;

public class LoginUI extends JFrame {
	Connect cn = new Connect();
	Connection conn = (Connection) Connect.getConnect();
	JButton jbLogin, jbThoat;
	JTextField txtMK, txtTK;
	JPasswordField jPassword;

	public LoginUI(String tieude) {
		super(tieude);

		controlsLG();

	}

	public void controlsLG() {
		Container con = getContentPane();

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTittle = new JPanel();
		JLabel lbTittle = new JLabel("Quản Lý Thư Viện Điện Tử");
		Font fTittle = new Font("arial", Font.BOLD, 20);
		lbTittle.setForeground(Color.RED);
		lbTittle.setFont(fTittle);
		pnTittle.add(lbTittle);

		JPanel pnTK = new JPanel();
		JLabel lbTK = new JLabel("Nhập tài khoản");
		txtTK = new JTextField();
		Font fTK = new Font("arial", Font.PLAIN, 15);
		lbTK.setFont(fTK);
		txtTK.setColumns(17);
		pnTK.add(lbTK);
		pnTK.add(txtTK);

		JPanel pnMK = new JPanel();
		JLabel lbMK = new JLabel("Nhập mật khẩu");
		jPassword = new JPasswordField();
		Font fMK = new Font("arial", Font.PLAIN, 15);
		lbMK.setFont(fMK);
		jPassword.setColumns(17);
		pnMK.add(lbMK);
		pnMK.add(jPassword);

		JPanel pnLogin = new JPanel();
		jbLogin = new JButton("Đăng Nhập");
		jbLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				Login();

			}

		});
		pnLogin.add(jbLogin);
		jbThoat = new JButton("Thoát");
		jbThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});
		pnLogin.add(jbThoat);

		pnMain.add(pnTittle);
		pnMain.add(pnTK);
		pnMain.add(pnMK);

		pnMain.add(pnLogin);

		con.add(pnMain);

	}

	public void addOut() {
		this.setVisible(false);
	}

	public void addShow() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setVisible(true);

	}

	public void Login() {
		String email = txtTK.getText();

		if (conn != null) {
			String sql = "SELECT * FROM BanDoc WHERE email=? and password=?";

			try {
				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

				ptmt.setString(1, txtTK.getText());
				ptmt.setString(2, jPassword.getText());

				ResultSet rs = ptmt.executeQuery();

				if (rs.next()) {

					if (rs.getString("email").equals("long0202@gmail.com") && rs.getString("password").equals("123")) {
						MainUI.home.setVisible(true);
						addOut();
					} else {
						KhachHang kh = new KhachHang(email);
						kh.showWindow();
						dispose();
						addOut();

					}

				} else {
					JOptionPane.showMessageDialog(null, "Tài khoản or mật khẩu chưa đúng!");

				}

			} catch (SQLException e) {
				System.out.println("loi  " + e.getMessage());

			}
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

}
