package project1.javadesktop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Login extends JFrame implements ActionListener {

	private JPanel pnmain;
	private JButton btnadmin, btnuser;

	/**
	 * Launch the application.
	 */
	public Login()
	{
		Addcontrolls();
		Addevents();
		
	}
	/*
	 * Add event
	 */
	public void Addevents()
	{
		btnadmin.addActionListener(this);
		btnuser.addActionListener(this);
	}
	/*
	 * phuong thuc su kien khi click vao button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton) e.getSource();
		if(bt == btnadmin)
		{
			Admin ad = new Admin();
			ad.setVisible(true);
			super.setVisible(false);
		}
		else if(bt == btnuser)
		{
			User user = new User();
			user.setVisible(true);
			super.setVisible(false);
		}
	}
	/**
	 * Create the frame.
	 */
	public void Addcontrolls() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
		setTitle("PHẦN MỀM QUẢN LÝ TIỀN ĐIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 420);
		this.setResizable(false);
		pnmain = new JPanel();
		pnmain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnmain);
		pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));
		
		JPanel pntitle = new JPanel();
		pntitle.setBackground(new Color(139, 0, 139));
		FlowLayout flowLayout = (FlowLayout) pntitle.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(10);
		pntitle.setMaximumSize(new Dimension(800, 100));
		pnmain.add(pntitle);
		pntitle.add(javax.swing.Box.createRigidArea(new Dimension(130, 10)));
		JLabel lbtitle = new JLabel("TRANG ĐĂNG NHẬP HỆ THỐNG QUẢN LÝ TIỀN ĐIỆN");
		lbtitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lbtitle.setForeground(Color.WHITE);
		lbtitle.setFont(new Font("Times New Roman", Font.BOLD, 21));
		pntitle.add(lbtitle);
		
		JPanel pnselect = new JPanel();
		pnselect.setMaximumSize(new Dimension(600, 280));
		pnmain.add(pnselect);
		pnselect.setLayout(new BoxLayout(pnselect, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(600, 60));
		pnselect.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.RED);
		panel_1.setMaximumSize(new Dimension(600, 110));
		pnselect.add(panel_1);
		
		btnadmin = new JButton("ADMIN");
		btnadmin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnadmin.setForeground(Color.RED);
		btnadmin.setPreferredSize(new Dimension(100, 40));
		panel_1.add(btnadmin);
		panel_1.add(javax.swing.Box.createRigidArea(new Dimension(130, 70)));
		

		btnuser = new JButton("USER ");
		btnuser.setForeground(Color.RED);
		btnuser.setPreferredSize(new Dimension(100, 40));
		btnuser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(btnuser);
		
		JPanel pntime = new JPanel();
		pntime.setMaximumSize(new Dimension(600, 70));
		pnmain.add(pntime);
		
		JLabel lblDanangNgay = new JLabel("Hệ thống quản lý điện Đà Nẵng");
		lblDanangNgay.setForeground(Color.RED);
		lblDanangNgay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		pntime.add(lblDanangNgay);
		
	}


}
