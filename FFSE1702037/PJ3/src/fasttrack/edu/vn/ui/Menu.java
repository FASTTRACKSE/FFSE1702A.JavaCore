package fasttrack.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
		QuanLyKhachHang myUI = new QuanLyKhachHang("My Application");
		myUI.showWindow();
		dispose();
	}
	protected void QuanLyBienLai() {
		 QuanLyBienLai myUI = new QuanLyBienLai("My Application");
         myUI.showWindow();
		dispose();
	}
	protected void BaoCaoTinhHinhTieuThu() {
		BaoCaoTienDien myUI = new BaoCaoTienDien("My Application");
        myUI.showWindow();
		dispose();
	}
	protected void BaoCaoKhachHang() {
		BaoCaoKhachHang myUI = new BaoCaoKhachHang("My Application");
        myUI.showWindow();
		dispose();
	}
	protected void Login() {
		Login myUI = new Login("My Application");
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
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Menu");
		Font fontTitle = new Font("Arial", Font.BOLD, 30);
		lblTitle.setForeground(Color.red);

		lblTitle.setFont(fontTitle);

		pnTitle.add(lblTitle);

		JPanel pnGroup1 = new JPanel();
		pnGroup1.setLayout(new BoxLayout(pnGroup1, BoxLayout.X_AXIS));

		JPanel pnAction = new JPanel();
		btnQlkh = new JButton("QUẢN LÝ KHÁCH HÀNG");
		btnQlkh.setPreferredSize(new Dimension(200, 50));
		
		pnAction.add(btnQlkh);

		JPanel pnAction1 = new JPanel();
		btnQlbl = new JButton("QUẢN LÝ BIÊN LAI");
		btnQlbl.setPreferredSize(new Dimension(200, 50));
		pnAction1.add(btnQlbl);
		pnGroup1.add(pnAction);
		pnGroup1.add(pnAction1);

		JPanel pnGroup2 = new JPanel();
		pnGroup2.setLayout(new BoxLayout(pnGroup2, BoxLayout.X_AXIS));

		JPanel pnAction2 = new JPanel();
		btnBckh = new JButton("BÁO CÁO KHÁCH HÀNG");
		btnBckh.setPreferredSize(new Dimension(200, 50));
		pnAction2.add(btnBckh);

		JPanel pnAction3 = new JPanel();
		btnBctd = new JButton("BÁO CÁO TIÊU THỤ ĐIỆN");
		btnBctd.setPreferredSize(new Dimension(200, 50));
		pnAction3.add(btnBctd);
		pnGroup2.add(pnAction2);
		pnGroup2.add(pnAction3);

		JPanel pnAction4 = new JPanel();
		btnLogout = new JButton("Đăng xuất");

		pnAction4.add(btnLogout);

		pnMain.add(pnTitle);

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
