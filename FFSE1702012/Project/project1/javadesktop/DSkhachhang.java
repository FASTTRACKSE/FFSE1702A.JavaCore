package project1.javadesktop;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javafx.scene.layout.Border;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DSkhachhang extends JFrame implements ActionListener {
	static JComboBox cbquan, cbphuong;
	private JPanel contentPane;
	private JTable table;
	private JButton btnsubmit, btnreturn;
	private int Quan_id;
	static Connection conn = Connection_Database.Ketnoi();
	static PreparedStatement ptmt = null;
	private static String[] cottieude = { "Mã", "Họ Tên", "Địa Chỉ", "Quận", "Phường", "Số đt", "Email", "Mã công tơ" };
	static DefaultTableModel tbmodel = new DefaultTableModel(cottieude, 0);

	/**
	 * ham dung khong tham so
	 */
	public DSkhachhang() {
		Addcontrolls();
		Addevents();
	}

	/*
	 * phuong thuc create event
	 */
	public void Addevents() {
		cbquan.addActionListener(selectevent);
		btnsubmit.addActionListener(this);
		btnreturn.addActionListener(this);
	}

	// thuc hien chuc nang:
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton) e.getSource();
		if (bt == btnsubmit) {
		
			String sql ="";
			// add your code
			String quan = (String) cbquan.getSelectedItem();
			String phuong = (String) cbphuong.getSelectedItem();
			if(quan != "Chọn Quận")
			{
			if(phuong == "Chọn_Phường")
			{
				 sql = "select * from Customer where Quan = '" + quan + "'" ;
		
				 MySQL_thongke.search_dskh(sql);
			}
			else if(phuong != "Chọn_Phường")
			{
				 sql = "select * from Customer where Quan = '" + quan + "'" + "and Phuong = '" + phuong +"'";
				 MySQL_thongke.search_dskh(sql);
			}
			}else
			{
				JOptionPane.showMessageDialog(null, "Chọn điều kiện để loc dữ liệu","Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
			}
//			
		}
		if (bt == btnreturn) {
//	
			super.setVisible(false);
			Homepage hp = new Homepage("PHẦN MỀM TÍNH TIỀN ĐIỆN");
			hp.showWindow();
		}
	}

	/*
	 * thuc hien chuc nang khi chon combobox:
	 */
	ActionListener selectevent = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			cbphuong.removeAllItems();
			String Name_quan = cbquan.getSelectedItem().toString();
			Quan_id = MySQL_khachhang.getQuanID(Name_quan);
			String sql = "select  *  from Phuong where Parent_id = " + Quan_id;
			try {
				ptmt = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();
				cbphuong.addItem("Chọn_Phường");
				while (rs.next()) {
					cbphuong.addItem(rs.getString("Phuong"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("loi" + e1);
			}
		}
	};

	/**
	 * Create the frame.
	 */
	public void Addcontrolls() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
		this.setTitle("PHẦN MỀM QUẢN LÝ TIỀN ĐIỆN");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 100, 900, 600);
		this.setResizable(false);

		// get The Window Container
		Container con = getContentPane();
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));

		// set JPanel Title cho Jpanel:
		JPanel pntitle = new JPanel();
		pntitle.setBackground(new Color(139, 0, 139));
		pntitle.setMaximumSize(new Dimension(900, 130));
		JLabel lbtitle = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lbtitle.setForeground(Color.WHITE);
		lbtitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		pntitle.add(lbtitle);
		// set font
		Font font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16);
		// set panel cho viec SELECT information:
		JPanel pnselect = new JPanel();
		pnselect.setLayout(new FlowLayout());

		JLabel lbselect = new JLabel("Lựa chọn:");
		lbselect.setForeground(Color.RED);
		lbselect.setFont(font);
		lbselect.setPreferredSize(new Dimension(100, 25));
		pnselect.add(lbselect);
		// -----------------
		JLabel lbquan = new JLabel("Quận");
		lbquan.setForeground(Color.BLACK);
		lbquan.setFont(font);
		lbquan.setPreferredSize(new Dimension(70, 25));
		pnselect.add(lbquan);

		cbquan = new JComboBox();
		String chuoi = "DSkhachhang";
		MySQL_khachhang.getQuan(chuoi);
		cbquan.setPreferredSize(new Dimension(140, 25));
		pnselect.add(cbquan);
		// ---------------------------
		JLabel lb = new JLabel();
		lb.setPreferredSize(new Dimension(20, 25));
		pnselect.add(lb);
		// --------------------------
		JLabel lbphuong = new JLabel("Phường");
		lbphuong.setForeground(Color.BLACK);
		lbphuong.setFont(font);
		lbphuong.setPreferredSize(new Dimension(70, 25));
		pnselect.add(lbphuong);

		cbphuong = new JComboBox();
		cbphuong.setPreferredSize(new Dimension(140, 25));
		pnselect.add(cbphuong);
		// -------------------------------
		JLabel lb1 = new JLabel();
		lb1.setPreferredSize(new Dimension(20, 25));
		pnselect.add(lb1);
		// ---------------------------------
		btnsubmit = new JButton("Xác nhận");
		btnsubmit.setForeground(Color.RED);
		btnsubmit.setFont(font);
		btnsubmit.setPreferredSize(new Dimension(100, 25));
		pnselect.add(btnsubmit);

		// -----------------------------
		// set Panel cho table
		JPanel pntable = new JPanel();
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder title = BorderFactory.createTitledBorder(border, "Danh Sách");
		pntable.setBorder(title);

		table = new JTable();
		table.setModel(tbmodel);
		table.setPreferredScrollableViewportSize(new Dimension(800, 250));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane sc = new JScrollPane();
		sc.setViewportView(table);
		pntable.add(sc);

		// set Panel cho table
		JPanel pnreturn = new JPanel();
		pnreturn.setPreferredSize(new Dimension(700, 30));
		btnreturn = new JButton("Quay lại");
		btnreturn.setForeground(Color.RED);
		btnreturn.setFont(font);
		pnreturn.add(btnreturn);

		// add panel:
		pnmain.add(pntitle);
		pnmain.add(pnselect);
		pnmain.add(pntable);
		pnmain.add(pnreturn);
		con.add(pnmain);
	}

}
