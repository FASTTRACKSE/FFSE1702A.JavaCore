package Process;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.mysql.jdbc.Connection;

import Data.Connect;

public class HomeUI extends JFrame {

	JTabbedPane tabbedPaneContent;
	JLabel lblHeader;
    JButton jbThoat;
	public HomeUI() {
        
		controlsMenu();
		addEvents();
		this.setSize(700, 575);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}

	public void controlsMenu() {

		Container con = getContentPane();

		tabbedPaneContent = new JTabbedPane(JTabbedPane.TOP);

		SachUI sach = new SachUI();
		tabbedPaneContent.addTab("Sách", sach);

//		KhachHangUI kh = new KhachHangUI();
//		tabbedPaneContent.addTab("Khách Hàng", kh);

		BanDocUI banDoc = new BanDocUI();
		tabbedPaneContent.addTab("Bạn Đọc", banDoc);

		MuonSachUI muonSach = new MuonSachUI();
		tabbedPaneContent.addTab("Mượn Sách", muonSach);

		ThongKeUI thongKe = new ThongKeUI();
		tabbedPaneContent.addTab("Thống kê báo cáo", thongKe);

		con.add(tabbedPaneContent, BorderLayout.CENTER);

	}

	public void addEvents() {
		// tabbedPaneContent.addChangeListener(new SelectedTab());
	}
	public void addOut() {
		this.setVisible(false);
	
	}
	public void exit() {
		
		dispose();
	}
	public static void main(String[] agrs) {
		new HomeUI();
	}

}
