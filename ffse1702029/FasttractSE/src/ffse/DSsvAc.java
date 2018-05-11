package ffse;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import javax.swing.JDesktopPane;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import java.awt.Rectangle;

public class DSsvAc extends JFrame {
	private JTable table;
	public DSsvAc(String title) {
		super(title);
		addControls();
	}

	private void addControls() {
		Container con = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setBackground(new Color(135, 206, 250));
        pnMain.setFont(new Font("Tahoma", Font.BOLD, 13));
        pnMain.setLayout(new BorderLayout());
		
		final CardLayout cardLayout = new CardLayout(); 
	    final JPanel cardPanel = new JPanel(cardLayout);
		
	    JPanel card1 = new JPanel();
	    card1.setBackground(new Color(173, 216, 230));
	    JPanel ds_SinhVien = new DS_SinhVien();
	    card1.add(ds_SinhVien);
	    
	    
	    
	    JPanel card2 = new JPanel();
	    card2.setBackground(new Color(173, 216, 230));
	    JPanel ds_MonHoc = new DS_MonHoc();
	    card2.add(ds_MonHoc);
	    
	    JPanel card3 = new JPanel();
	    card3.setBackground(new Color(173, 216, 230));
	    JPanel thoiKhoaBieu = new ThoiKhoaBieu();
	    card3.add(thoiKhoaBieu);
	    
	    JPanel card4 = new JPanel();
	    card4.setBackground(new Color(173, 216, 230));
	    JPanel TongKetDiem = new TongKetDiem();
	    card4.add(TongKetDiem);
	    
	    JPanel card5 = new JPanel();
	    card5.setBackground(new Color(173, 216, 230));
	 
	    cardPanel.add(card1,"dssv");
	    card1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	    card1.setLayout(new BoxLayout(card1, BoxLayout.X_AXIS));
	    cardPanel.add(card2,"dsmh");
	    cardPanel.add(card3,"tkb");
	    cardPanel.add(card4,"diem");
	    cardPanel.add(card5,"logout");
	  
	    JPanel buttonPanel = new JPanel();
	    JButton dssv = new JButton("DS sinh viên");
	    JButton dsmh = new JButton("DS môn học");
	    JButton tkb = new JButton("Thời khóa biểu");
	    JButton diem = new JButton("Tổng kết điểm");
	    JButton logout = new JButton("logout");
	    
	    buttonPanel.add(dssv);
	    buttonPanel.add(dsmh);
	    buttonPanel.add(tkb);
	    buttonPanel.add(diem);
	    buttonPanel.add(logout);
	    
	    dssv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "dssv");
			}
		});
	 
	    dsmh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "dsmh");
			}
		});
	    tkb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "tkb");
			}
		});
	    diem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "diem");
			}
		});
	    logout.addActionListener(new ActionListener() {
	    	ActionListener loghome = new ActionListener() {
				public	void actionPerformed(ActionEvent e ) {
					log_home();
				}
			};
			
			protected void log_home() {
				 setVisible(false);
				 Login myUI = new Login("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
			        myUI.showWindow();
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				logout.addActionListener(loghome);
			}
		});
	 
	    pnMain.add(cardPanel,BorderLayout.CENTER);
	    pnMain.add(buttonPanel,BorderLayout.NORTH);
	    pnMain.setVisible(true);
		con.add(pnMain);
		
		
	}
public static void main(String[] args) {
		DSsvAc myUI = new DSsvAc("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
	        myUI.showWindow();

	 }	
	
	
	 public void showWindow() {
	        this.setSize(1200, 680);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	 }
	
}

