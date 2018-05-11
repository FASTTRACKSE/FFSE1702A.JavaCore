package project1.javadesktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Homepage extends JFrame implements ActionListener {
	private JMenuItem itlogout, itexit, itkhachhang, itbienlai, itthongkekh, itthutiendien;
	private JPanel contentPane;
	private JLabel lbwelcom;

	/*
	 * tao ham dung
	 */
	public Homepage(String title) {
		super(title);
		Addcontrolls();
		Addevents();
	}

	/*
	 * Add event
	 */
	public void Addevents() {
		itlogout.addActionListener(this);
		itexit.addActionListener(this);
		itkhachhang.addActionListener(this);
		itbienlai.addActionListener(this);
		itthongkekh.addActionListener(this);
		itthutiendien.addActionListener(this);
	}

	/*
	 * Action events;
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem mn = (JMenuItem) e.getSource();
		if (mn == itlogout) {
			int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát ứng dụng?");
			if (click == JOptionPane.YES_OPTION) {
				Admin lg = new Admin();
				lg.setVisible(true);
				super.setVisible(false);
			} else if (click == JOptionPane.NO_OPTION) {
				super.setVisible(true);
			}
			else if(click == JOptionPane.CANCEL_OPTION)
			{
				super.setVisible(true);
			}
			// add code
			
		}
		if (mn == itexit) {
			int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát ứng dụng?");
			if (click == JOptionPane.YES_OPTION) {
				Connection conn = Connection_Database.Ketnoi();
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			} else if (click == JOptionPane.NO_OPTION) {
				super.setVisible(true);
			}
			else if(click == JOptionPane.CANCEL_OPTION)
			{
				super.setVisible(true);
			}
		
		}
		if (mn == itkhachhang) {
			InformationCustomer icm = new InformationCustomer();
			icm.setVisible(true);
			super.setVisible(false);
		}
		if (mn == itbienlai) {
			QuanLyBienLai bl = new QuanLyBienLai();
			bl.setVisible(true);
			super.setVisible(false);
		}
		if (mn == itthongkekh) {
			DSkhachhang dskh = new DSkhachhang();
			dskh.setVisible(true);
			super.setVisible(false);
		}
		if (mn == itthutiendien) {
			DSthutiendien dsttd = new DSthutiendien();
			dsttd.setVisible(true);
			super.setVisible(false);
		}
	}

	/**
	 * Create the frame.
	 */
	public void showWindow() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
		// setTitle("PHẦN MỀM QUẢN LÝ TIỀN ĐIỆN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 500);
		setVisible(true);

	}

	/*
	 * Create the MenuBar
	 */
	public void Addcontrolls() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnhethong = new JMenu("Hệ thống");
		mnhethong.setBackground(Color.PINK);
		mnhethong.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnhethong);

		itlogout = new JMenuItem("Đăng xuất");
		itlogout.setBackground(Color.WHITE);
		itlogout.setFont(new Font("Arial", Font.BOLD, 12));
		mnhethong.add(itlogout);

		itexit = new JMenuItem("Thoát");
		itexit.setFont(new Font("Arial", Font.BOLD, 12));
		mnhethong.add(itexit);

		JMenu mnquanly = new JMenu("Quản lý");
		mnquanly.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnquanly);

		itkhachhang = new JMenuItem("Khách hàng");
		itkhachhang.setFont(new Font("Arial", Font.BOLD, 12));
		mnquanly.add(itkhachhang);

		itbienlai = new JMenuItem("Biên lai tiền điện");
		itbienlai.setFont(new Font("Arial", Font.BOLD, 12));
		mnquanly.add(itbienlai);

		JMenu mnthongke = new JMenu("Thống kê");
		mnthongke.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnthongke);

		itthongkekh = new JMenuItem("Khách hàng");
		itthongkekh.setFont(new Font("Arial", Font.BOLD, 12));
		mnthongke.add(itthongkekh);

		itthutiendien = new JMenuItem("Tình hình thu tiền điện");
		itthutiendien.setFont(new Font("Arial", Font.BOLD, 12));
		mnthongke.add(itthutiendien);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbwelcom = new JLabel("WELCOME!!!");
		lbwelcom.setForeground(Color.WHITE);
		lbwelcom.setFont(new Font("VNI-Butlong", Font.BOLD, 30));
		lbwelcom.setBounds(276, 136, 262, 93);

		JLabel lbhtd = new JLabel("PHẦN MỀM QUẢN LÝ TIỀN ĐIỆN");
		lbhtd.setForeground(Color.WHITE);
		lbhtd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lbhtd.setBounds(218, 204, 700, 93);
		contentPane.add(lbwelcom);
		contentPane.add(lbhtd);

	}

}
