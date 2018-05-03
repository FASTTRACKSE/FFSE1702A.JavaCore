package fasttrack.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JFrame {
	JButton btnQlkh, btnQlbl, btnBckh, btnBctd, btnLogout;

	public Menu(String tieude) {
		super(tieude);

		addControls();

		addEvents();
	}

	ActionListener eventQLKH = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			QuanLyKhachHang();
		}
	};
	ActionListener eventLogout = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			Login();
		}
	};
	ActionListener eventQLBL = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			QuanLyBienLai();
		}
	};
	ActionListener eventBCTD = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			BaoCaoTinhHinhTieuThu();
		}
	};
	ActionListener eventBCKH= new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			BaoCaoKhachHang();
		}
	};


	protected void QuanLyKhachHang() {
		QuanLyKhachHang myUI = new QuanLyKhachHang("Phần mềm quản lý tiền điện");
		myUI.showWindow();
		dispose();
	}
	protected void QuanLyBienLai() {
		 QuanLyBienLai myUI = new QuanLyBienLai("Phần mềm quản lý tiền điện");
         myUI.showWindow();
		dispose();
	}
	protected void BaoCaoTinhHinhTieuThu() {
		BaoCaoTienDien myUI = new BaoCaoTienDien("Phần mềm quản lý tiền điện");
        myUI.showWindow();
		dispose();
	}
	protected void BaoCaoKhachHang() {
		BaoCaoKhachHang myUI = new BaoCaoKhachHang("Phần mềm quản lý tiền điện");
        myUI.showWindow();
		dispose();
	}
	protected void Login() {
		Login myUI = new Login("Phần mềm quản lý tiền điện");
       myUI.showWindow();
		dispose();
	}

	public void addEvents() {
		btnQlkh.addActionListener(eventQLKH);
		btnLogout.addActionListener(eventLogout);
		btnQlbl.addActionListener(eventQLBL);
		btnBckh.addActionListener(eventBCKH);
		btnBctd.addActionListener(eventBCTD);



	}

	public void addControls() {
		this.setResizable(false);
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Menu");
		Font fontTitle = new Font("Arial", Font.BOLD, 30);
		lblTitle.setForeground(Color.white);

		lblTitle.setFont(fontTitle);
		pnTitle.setBackground(new Color(28, 105, 131));;
		pnTitle.add(lblTitle);
		pnTitle.setMaximumSize(new Dimension(700, 55));
		JPanel pnGroup1 = new JPanel();
		pnGroup1.setLayout(new BoxLayout(pnGroup1, BoxLayout.X_AXIS));

		JPanel pnAction = new JPanel();
		ImageIcon iconView = new ImageIcon("image/khachhang.png");
		Image getIconView = iconView.getImage();
		Image newIconView = getIconView.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newIconView);
		btnQlkh = new JButton("QUẢN LÝ KHÁCH HÀNG",newIcon);
		btnQlkh.setFocusPainted(false);
		pnAction.add(btnQlkh);


		JPanel pnAction1 = new JPanel();
		ImageIcon iconView1 = new ImageIcon("image/hoadon.png");
		Image getIconView1 = iconView1.getImage();
		Image newIconView1 = getIconView1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newIconView1);
		btnQlbl = new JButton("QUẢN LÝ BIÊN LAI           ",newIcon1);
		pnAction1.add(btnQlbl);
		pnGroup1.add(pnAction);
		pnGroup1.add(pnAction1);

		JPanel pnGroup2 = new JPanel();
		pnGroup2.setLayout(new BoxLayout(pnGroup2, BoxLayout.X_AXIS));

		JPanel pnAction2 = new JPanel();
		ImageIcon iconView2 = new ImageIcon("image/khach.png");
		Image getIconView2 = iconView2.getImage();
		Image newIconView2 = getIconView2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newIconView2);
		btnBckh = new JButton("BÁO CÁO KHÁCH HÀNG",newIcon2);
		pnAction2.add(btnBckh);

		JPanel pnAction3 = new JPanel();
		ImageIcon iconView3 = new ImageIcon("image/hoa1.png");
		Image getIconView3 = iconView3.getImage();
		Image newIconView3 = getIconView3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newIconView3);
		btnBctd = new JButton("BÁO CÁO TIÊU THỤ ĐIỆN",newIcon3);
		pnAction3.add(btnBctd);
		pnGroup2.add(pnAction2);
		pnGroup2.add(pnAction3);

		JPanel pnAction4 = new JPanel();
		ImageIcon iconView4 = new ImageIcon("image/logout.png");
		Image getIconView4 = iconView4.getImage();
		Image newIconView4 = getIconView4.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newIconView4);
		btnLogout = new JButton(newIcon4);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		pnAction4.add(btnLogout);
		pnMain.add(Box.createRigidArea(new Dimension(30,30)));
		pnMain.add(pnTitle);
		pnMain.add(Box.createRigidArea(new Dimension(30,30)));

		pnMain.add(pnGroup1);
		pnMain.add(pnGroup2);

		pnMain.add(pnAction4);
		con.add(pnMain);
	}

	public void showWindow() {
		this.setSize(700, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
