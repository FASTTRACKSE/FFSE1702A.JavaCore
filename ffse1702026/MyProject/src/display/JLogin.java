package display;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.AdminDB;
import database.dbKhachHang;
import object.Admin;
import object.KhachHang;
import object.MyException;

public class JLogin extends JFrame {

	private JPanel pnMain, panelBrand, panelBao, panelUD, panelQL, panelDem, panelChoice, panelBaoCh, panelQLCH,
			panelTKCH, panelDemCH;
	private JLabel labelUD, labelQL;
	private JTextField jtName;
	private JLabel lbUser;
	private JLabel lbPass;
	private JTextField jpw;
	private JPanel panelInfor;
	private JMenuBar mbLogin;
	private JPanel panelMN;
	private JMenu mnLogin;
	private JMenuItem miAdmin;
	private JMenuItem miKH;
	private JPanel panelCard;
	private JPanel panelAdmin;
	private JPanel panelUs;
	private JPanel panelMaKH;
	private JPanel panelEmail;
	private JLabel labelMKH;

	private JTextField jtMKH;
	private JLabel labelEmail;

	private JTextField jtEmail;
	private JPanel panelifKH;
	private JLabel lbLGKH;
	private JPanel pnDNKH;
	private JLabel lbDNKH;
	private JPanel panelbtAd;
	private JButton btnLoginAd;
	private JPanel panelkhbt;
	private JButton btnLoginKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLogin() {
		setTitle("ỨNG DỤNG QUẢN LÝ TIỀN ĐIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("b.jpg"));
		setBounds(100, 100, 988, 650);
		pnMain = new JPanel();

		setContentPane(pnMain);
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		panelInfor = new JPanel();
		pnMain.add(panelInfor);
		panelInfor.setLayout(new BoxLayout(panelInfor, BoxLayout.X_AXIS));

		panelBrand = new JPanel();
		panelBrand.setBackground(Color.WHITE);
		panelInfor.add(panelBrand);
		panelBrand.setLayout(new BoxLayout(panelBrand, BoxLayout.X_AXIS));

		panelBao = new JPanel();
		panelBao.setBackground(new Color(153, 0, 204));
		panelBrand.add(panelBao);
		panelBao.setLayout(new BoxLayout(panelBao, BoxLayout.Y_AXIS));

		panelMN = new JPanel();
		panelMN.setMaximumSize(new Dimension(600, 60));
		panelMN.setBackground(new Color(153, 51, 153));
		panelBao.add(panelMN);
		panelMN.setLayout(new GridLayout(0, 1, 0, 0));

		mbLogin = new JMenuBar();
		mbLogin.setBackground(Color.WHITE);
		panelMN.add(mbLogin);

		mnLogin = new JMenu("LOGIN");
		mnLogin.setIcon(
				new ImageIcon(new ImageIcon("lg.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		mnLogin.setBackground(Color.WHITE);
		mbLogin.add(mnLogin);

		miAdmin = new JMenuItem("Admin");
		miAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				panelCard.removeAll();
				panelCard.add(panelAdmin);
				panelCard.repaint();
				panelCard.revalidate();

			}
		});
		miAdmin.setBackground(Color.WHITE);
		mnLogin.add(miAdmin);

		miKH = new JMenuItem("Khách Hàng");
		miKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				panelCard.removeAll();
				panelCard.add(panelUs);
				panelCard.repaint();
				panelCard.revalidate();

			}
		});
		miKH.setBackground(Color.WHITE);
		mnLogin.add(miKH);
		panelBao.add(Box.createRigidArea(new Dimension(200, 200)));
		panelUD = new JPanel();
		FlowLayout fl_panelUD = (FlowLayout) panelUD.getLayout();
		panelUD.setBackground(new Color(153, 0, 204));
		panelUD.setMaximumSize(new Dimension(300, 50));
		panelBao.add(panelUD);

		labelUD = new JLabel("ỨNG DỤNG");
		labelUD.setForeground(new Color(240, 230, 140));
		labelUD.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelUD.add(labelUD);

		panelQL = new JPanel();
		panelQL.setBackground(new Color(153, 0, 204));
		panelBao.add(panelQL);

		labelQL = new JLabel("QUẢN LÝ TIỀN ĐIỆN");
		labelQL.setForeground(new Color(240, 230, 140));
		labelQL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelQL.add(labelQL);

		panelDem = new JPanel();
		panelDem.setBackground(new Color(153, 0, 204));
		panelBao.add(panelDem);

		panelBao.add(Box.createRigidArea(new Dimension(200, 250)));

		panelChoice = new JPanel();
		panelChoice.setBackground(new Color(102, 102, 204));
		panelInfor.add(panelChoice);
		panelChoice.setLayout(new BoxLayout(panelChoice, BoxLayout.X_AXIS));

		panelBaoCh = new JPanel();
		panelBaoCh.setBackground(Color.WHITE);
		panelChoice.add(panelBaoCh);
		panelBaoCh.setLayout(new BoxLayout(panelBaoCh, BoxLayout.Y_AXIS));

		panelBaoCh.add(Box.createRigidArea(new Dimension(230, 200)));

		panelCard = new JPanel();
		panelBaoCh.add(panelCard);
		panelCard.setLayout(new CardLayout(0, 0));

		panelAdmin = new JPanel();
		panelAdmin.setBackground(Color.WHITE);
		panelCard.add(panelAdmin, "name_38692515123158");
		panelAdmin.setLayout(new BoxLayout(panelAdmin, BoxLayout.Y_AXIS));

		panelifKH = new JPanel();
		panelifKH.setMaximumSize(new Dimension(1000, 1000));
		panelifKH.setBackground(Color.WHITE);
		panelAdmin.add(panelifKH);

		lbLGKH = new JLabel("ĐĂNG NHẬP CHO ADMIN");
		lbLGKH.setForeground(new Color(102, 0, 51));
		lbLGKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelifKH.add(lbLGKH);

		panelQLCH = new JPanel();
		panelAdmin.add(panelQLCH);
		panelQLCH.setBackground(Color.WHITE);
		panelQLCH.setMaximumSize(new Dimension(1000, 1000));

		lbUser = new JLabel("");
		lbUser.setIcon(
				new ImageIcon(new ImageIcon("user.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		panelQLCH.add(lbUser);

		panelQLCH.add(Box.createRigidArea(new Dimension(30, 50)));

		jtName = new JTextField();
		jtName.setMinimumSize(new Dimension(300, 30));
		panelQLCH.add(jtName);
		jtName.setColumns(25);

		panelTKCH = new JPanel();
		panelTKCH.setMaximumSize(new Dimension(500, 200));
		panelAdmin.add(panelTKCH);
		panelTKCH.setBackground(Color.WHITE);

		lbPass = new JLabel("");
		lbPass.setIcon(
				new ImageIcon(new ImageIcon("pw.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		panelTKCH.add(lbPass);

		panelTKCH.add(Box.createRigidArea(new Dimension(30, 20)));

		jpw = new JPasswordField();
		jpw.setColumns(25);
		panelTKCH.add(jpw);

		panelbtAd = new JPanel();

		panelbtAd.setBackground(Color.WHITE);
		panelAdmin.add(panelbtAd);

		btnLoginAd = new JButton("Login");
		btnLoginAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String adName = jtName.getText();
				ArrayList<Integer> count = new ArrayList<>();
				try {
					MyException.checkLogin(adName, "tên");
				} catch (MyException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnMain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					count.add(1);
				}
				String password = jpw.getText();
				String pw = md5(jpw.getText());
				try {
					MyException.checkLogin(password, "mật khẩu");
				} catch (MyException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnMain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					count.add(1);
				}
				String sql = "select * from ffse1702026_admin where user_name ='" + adName + "' and password= '" + pw
						+ "'";
				if (count.size() == 0) {
					try {
						ArrayList<Admin> ad = AdminDB.getInfor(sql);
						if (ad.size() > 0) {
							setVisible(false);
							JMain jm = new JMain();
							jm.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(pnMain, "Sai tài khoản hoặc mật khẩu, đăng nhập lại",
									"Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(pnMain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnLoginAd.setIcon(
				new ImageIcon(new ImageIcon("lg.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		btnLoginAd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLoginAd.setForeground(new Color(102, 0, 51));
		panelbtAd.add(btnLoginAd);

		panelUs = new JPanel();
		panelUs.setBackground(Color.WHITE);
		panelCard.add(panelUs, "name_38858284659251");
		panelUs.setLayout(new BoxLayout(panelUs, BoxLayout.Y_AXIS));

		pnDNKH = new JPanel();
		pnDNKH.setMaximumSize(new Dimension(600, 60));
		pnDNKH.setBackground(Color.WHITE);
		panelUs.add(pnDNKH);

		lbDNKH = new JLabel("ĐĂNG NHẬP CHO KHÁCH HÀNG");
		lbDNKH.setForeground(new Color(102, 0, 51));
		lbDNKH.setBackground(Color.WHITE);
		lbDNKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnDNKH.add(lbDNKH);

		panelMaKH = new JPanel();
		panelMaKH.setMaximumSize(new Dimension(600, 60));
		panelMaKH.setBackground(Color.WHITE);
		panelUs.add(panelMaKH);

		labelMKH = new JLabel("");
		labelMKH.setIcon(
				new ImageIcon(new ImageIcon("user.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		panelMaKH.add(labelMKH);

		panelMaKH.add(Box.createRigidArea(new Dimension(30, 50)));

		jtMKH = new JTextField();
		jtMKH.setMinimumSize(new Dimension(300, 30));
		jtMKH.setColumns(25);
		panelMaKH.add(jtMKH);

		panelEmail = new JPanel();
		panelEmail.setMaximumSize(new Dimension(1000, 100));
		panelEmail.setBackground(Color.WHITE);
		panelUs.add(panelEmail);

		labelEmail = new JLabel("");
		labelEmail.setIcon(
				new ImageIcon(new ImageIcon("mail.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		panelEmail.add(labelEmail);

		panelEmail.add(Box.createRigidArea(new Dimension(30, 50)));

		jtEmail = new JTextField();
		jtEmail.setMinimumSize(new Dimension(300, 30));
		jtEmail.setColumns(25);
		panelEmail.add(jtEmail);

		panelkhbt = new JPanel();
		panelkhbt.setBackground(Color.WHITE);
		panelUs.add(panelkhbt);

		btnLoginKH = new JButton("Login");
		btnLoginKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mkh = jtMKH.getText();
				ArrayList<Integer> count = new ArrayList<>();
				try {
					MyException.checkLogin(mkh, "mã khách hàng");
				} catch (MyException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnMain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					count.add(1);
				}
				String email = jtEmail.getText();

				try {
					MyException.checkEmail(email);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnMain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					count.add(1);
				}
				String sql = "select * from ffse1702026_user where maKH ='" + mkh + "' and email= '" + email + "'";
				if (count.size() == 0) {
					try {
						ArrayList<KhachHang> ad = dbKhachHang.getInfo(sql);
						if (ad.size() > 0) {
							setVisible(false);
							JKhachHangInfor jkh = new JKhachHangInfor(mkh);
							jkh.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(pnMain, "Sai mã khách hàng hoặc emails, đăng nhập lại",
									"Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(pnMain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnLoginKH.setIcon(
				new ImageIcon(new ImageIcon("lg.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		btnLoginKH.setForeground(new Color(102, 0, 51));
		btnLoginKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelkhbt.add(btnLoginKH);

		panelDemCH = new JPanel();
		panelDemCH.setBackground(Color.WHITE);
		panelBaoCh.add(panelDemCH);

		panelBaoCh.add(Box.createRigidArea(new Dimension(200, 200)));
	}

	public String md5(String str) {
		MessageDigest md;
		String result = "";
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			BigInteger bi = new BigInteger(1, md.digest());

			result = bi.toString(16);
		} catch (NoSuchAlgorithmException e) {
			JOptionPane.showMessageDialog(pnMain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
}
