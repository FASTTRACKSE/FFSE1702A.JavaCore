package ffse;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import model.KetNoiSQL;

import java.awt.Color;
import java.awt.Dimension;

public class LoginHS extends JFrame {
	private JTextField txtemail, pass;
	private JPanel login;
	private JLabel chulg, email, Password;
	private JButton Cancel, log;
	public static String mahs;
	public static String lop;

	public LoginHS(String title) {
		super(title);
		addControls();
		addEvents();
	}

	ActionListener loghome = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			log_home();
		}
	};

	protected void log_home() {
		this.setVisible(false);
		Login myUI = new Login("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
		myUI.showWindow();
	}

	private void addEvents() {
		Cancel.addActionListener(loghome);

	}

	private void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setFont(new Font("Tahoma", Font.BOLD, 14));

		login = new JPanel();
		login.setBackground(new Color(0, 0, 255));
		login.setBounds(0, 0, 434, 60);
		pnMain.add(login);

		chulg = new JLabel("    Học sinh login");
		chulg.setFont(new Font("Tahoma", Font.BOLD, 20));
		chulg.setPreferredSize(new Dimension(200, 50));
		login.add(chulg);

		email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.BOLD, 16));
		email.setBounds(46, 94, 104, 24);
		pnMain.add(email);

		txtemail = new JTextField();
		txtemail.setBounds(157, 94, 219, 24);
		pnMain.add(txtemail);
		txtemail.setColumns(10);

		Password = new JLabel("Password");
		Password.setFont(new Font("Tahoma", Font.BOLD, 16));
		Password.setBounds(46, 164, 104, 24);
		pnMain.add(Password);

		pass = new JPasswordField();
		pass.setBounds(157, 166, 219, 24);
		pnMain.add(pass);
		pass.setColumns(10);

		Cancel = new JButton("cancel");
		Cancel.setBackground(new Color(255, 0, 0));
		Cancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		Cancel.setForeground(new Color(0, 0, 0));
		Cancel.setBounds(287, 227, 89, 23);
		pnMain.add(Cancel);

		log = new JButton("login");
		log.setBackground(new Color(30, 144, 255));
		log.setFont(new Font("Tahoma", Font.BOLD, 13));
		log.setForeground(new Color(0, 0, 0));
		log.setBounds(157, 227, 89, 23);
		log.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn = KetNoiSQL.getConnect("localhost", "ffse1702029", "ffse1702029", "12345");
					Statement ptmt = (Statement) conn.createStatement();
					String sql = "SELECT * FROM `admin` WHERE Email='" + txtemail.getText() + "'and Pass='"
							+ pass.getText().toString() + "'";
					ResultSet rs = ptmt.executeQuery(sql);
					if (rs.next()) {
						setVisible(false);
						mahs = rs.getString("ID");
						lop = rs.getString("Lop");
						DssvAdmin myUI = new DssvAdmin("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
						myUI.setMahs(mahs);
						myUI.showWindow();

					} else
						JOptionPane.showMessageDialog(null, "incorrect username and password");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		pnMain.add(log);

		con.add(pnMain);
		pnMain.setLayout(null);

	}

	// public static void main(String[] args) {
	// LoginHS myUI = new LoginHS("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN
	// SINH VIÊN");
	// myUI.showWindow();
	//
	// }
	public void showWindow() {
		this.setSize(450, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
