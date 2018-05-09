package tiendien.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tiendien.MODEL.ExceptionMD;

public class menuUI extends JFrame {
	JLabel xxx;
	JButton bt_QLKH, bt_QLBL,bt_logOut,bt_TKBC;
	ExceptionMD ex = new ExceptionMD();
	
	public menuUI() {
		super("Quản Lý Tiền Điện");
		addControls();
		addEvents();
	}

	// đây là sự kiện

	// BT báo cáo
		ActionListener bt_TKBC1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu_bt_TKBC();
			}
		};
		protected void menu_bt_TKBC() {
			thongkebaocaoUI myUI = new thongkebaocaoUI();
			try {
				myUI.hienthi_bc();
			} catch (ExceptionMD e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dispose();
		}
		
		// bt đăng 
		ActionListener bt_logOut1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu_bt_logOut();
			}
		};
		public void menu_bt_logOut() {
			loginUI myUI = new loginUI();
			myUI.showWindow();
			this.dispose();
			
		}
		// bt quản lý khách Hàng 
		ActionListener bt_QLKH1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu_bt_QLKH();
			}
		};
		public void menu_bt_QLKH() {
			quanlykhachhangUI myMenu = new quanlykhachhangUI();
			try {
				myMenu.hienthi_kh();
			} catch (ExceptionMD e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dispose();
		}
		//bt quản lý biên lai 
		ActionListener bt_QLBL1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				menu_bt_QLBL();
			}
		};
		public void menu_bt_QLBL() {
			quanlybienlaiUI mybt_QLBL = new quanlybienlaiUI();
			try {
				mybt_QLBL.hienthi_qlbl();
			} catch (ExceptionMD e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dispose();
		}

	private void addEvents() {
		
		bt_QLKH.addActionListener(bt_QLKH1);

		bt_QLBL.addActionListener(bt_QLBL1);
		
		bt_logOut.addActionListener(bt_logOut1);

		bt_TKBC.addActionListener(bt_TKBC1);	
		
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		JPanel boxAll = new JPanel();
		boxAll.setLayout(new BoxLayout(boxAll, BoxLayout.Y_AXIS));
		con.add(boxAll);
		
		//tieu de 
		JLabel box_title = new JLabel("Quản Lý Tiền Điện");
		box_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		box_title.setFont(new Font("Courier New", Font.BOLD, 22));
		box_title.setForeground(Color.red);
		boxAll.add(box_title);
		
		//button 1 
		JPanel box_bt = new JPanel();
		bt_QLKH = new JButton("Quản Lý Khách Hàng");
		bt_logOut = new JButton("Đăng Xuất");
		bt_QLBL = new JButton("Quản Lý Biên Lai");
		bt_TKBC = new JButton("Thông Kê Báo Cáo");
		
		bt_QLKH.setFont(new Font("Courier New", Font.ITALIC, 20));
		bt_QLBL.setFont(new Font("Courier New", Font.ITALIC, 20));
		bt_logOut.setFont(new Font("Courier New", Font.ITALIC, 20));
		bt_TKBC.setFont(new Font("Courier New", Font.ITALIC, 20));
		
		box_bt.add(bt_QLKH);
		box_bt.add(bt_QLBL);
		box_bt.add(bt_TKBC);
		box_bt.add(bt_logOut);
		// -------------//
		box_bt.setLayout(new GridLayout(2,2,10,10)); 
		boxAll.add(box_bt);
	}
	public void hienthi() throws ExceptionMD{
		
		if(ex.chkLogin(loginUI.login)) {
			JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập trước");
			loginUI myUI = new loginUI();
			myUI.showWindow();
			this.dispose();
		}else {
			this.setSize(550, 400);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}	
	}
}
