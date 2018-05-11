package project1.javadesktop;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JYearChooser;
import java.awt.Component;
import javax.swing.Box;

public class DSthutiendien extends JFrame implements ActionListener {
	static JComboBox cbquan, cbphuong, cbmactd, cbmonth, cbmonth1, cbmonth2, cbkh, cbtime;
	private JTable table;
	private JTextField tfkhct;
	private JButton btnreturn, btnsubmit;
	private JYearChooser year1, year2, year3, year4;
	private static String[] cottieude1 = { "Mã công tơ", " Tên khách hàng", "Ngày nhập", "Tháng", "Chu kỳ nhâp",
			"Chỉ số ct", "Tiền điện" };
	static DefaultTableModel model = new DefaultTableModel(cottieude1, 0);
	private String Name;
	private int Quan_id;
	static Connection conn = Connection_Database.Ketnoi();
	static PreparedStatement ptmt = null;
	private JPanel pnkh_select, pntckh, pnquan_phuong, pnkhct, pntime, pnyear1, pnyear2, pnyear3;
	private JRadioButton rdbutton;

	/**
	 * ham dung khong tham so
	 */
	public DSthutiendien() {
		Addcontrolls();
		Addevents();
	}

	/*
	 * phuong thuc create event
	 */
	public void Addevents() {
		cbkh.addActionListener(event1);
		cbtime.addActionListener(event2);
		cbquan.addActionListener(cbevent1);
		cbphuong.addActionListener(cbevent1);
		btnsubmit.addActionListener(this);
		btnreturn.addActionListener(this);

	}

	ActionListener event1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (cbkh.getSelectedItem().toString().equals("Tất cả khách hàng")) {

				pnkh_select.removeAll();
				pnkh_select.add(pntckh);
				pnkh_select.repaint();
				pnkh_select.revalidate();

			} else if (cbkh.getSelectedItem().toString().equals("Theo Quận, Phường")) {
				pnkh_select.removeAll();
				pnkh_select.add(pnquan_phuong);
				pnkh_select.repaint();
				pnkh_select.revalidate();

			} else if (cbkh.getSelectedItem().toString().equals("Theo khách hàng cụ thể")) {
				pnkh_select.removeAll();
				pnkh_select.add(pnkhct);
				pnkh_select.repaint();
				pnkh_select.revalidate();

			} else if (cbkh.getSelectedItem().toString().equals("Chọn")) {
				pnkh_select.removeAll();
				pnkh_select.repaint();
				pnkh_select.revalidate();

			}
		}
	};
	ActionListener event2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			// "Theo năm", "Theo khoảng thời gian (tháng/năm - tháng/năm)", "Theo chu kỳ"

			if (cbtime.getSelectedItem().toString().equals("Theo năm")) {
				pntime.removeAll();
				pntime.add(pnyear1);
				pntime.repaint();
				pntime.revalidate();
			} else if (cbtime.getSelectedItem().toString().equals("Theo khoảng thời gian")) {
				pntime.removeAll();
				pntime.add(pnyear2);
				pntime.repaint();
				pntime.revalidate();
			} else if (cbtime.getSelectedItem().toString().equals("Theo chu kỳ")) {
				pntime.removeAll();
				pntime.add(pnyear3);
				pntime.repaint();
				pntime.revalidate();
			} else if (cbtime.getSelectedItem().toString().equals("Chọn")) {
				pntime.removeAll();
				pntime.repaint();
				pntime.revalidate();
			}
		}
	};

	// thuc hien chuc nang:
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton) e.getSource();
		if (bt == btnsubmit) {
			String kh = (String) cbkh.getSelectedItem();
			String time = (String) cbtime.getSelectedItem();
			if((kh == "Chọn") && (time == "Chọn"))
			{	
				JOptionPane.showMessageDialog(null, "Chưa chọn mục để tìm kiếm", "Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
			}
			String quan = (String) cbquan.getSelectedItem();
			String phuong = (String) cbphuong.getSelectedItem();
			String mct = tfkhct.getText();
			boolean rd = rdbutton.isSelected();
			int month = Integer.parseInt(cbmonth.getSelectedItem().toString());
			int month1 = Integer.parseInt(cbmonth1.getSelectedItem().toString());
			int month2 = Integer.parseInt(cbmonth2.getSelectedItem().toString());
			int year11 = year1.getValue();
			int year22 = year2.getValue();
			int year33 = year3.getValue();
			int year44 = year4.getValue();
			String sql = "";
			// chon tat ca khach hang
			if ((rd == true)) {
				year1.setValue(1);
				year2.setValue(2);
				year3.setValue(3);
				year4.setValue(4);
				if (quan.isEmpty() == false) {
					cbphuong.removeAllItems();
				}
				sql = "select * from BienLai";
				MySQL_thongke.search_dstiendien(sql);
			}
			else if (rd == false && (year11 == 1) && (year22 == 2) && (year33 == 3) && (year44 == 4)) {
				sql = "";
				MySQL_thongke.search_dstiendien(sql);
				// search thep ten quan
				if ((phuong == "Chọn_Phường")) {
					sql = "select * from BienLai where Quan = '" + quan + "'";
					MySQL_thongke.search_dstiendien(sql);
					cbquan.setSelectedIndex(0);
				}
				// search thep ten quan
				else if ((phuong != "Chọn_Phường") && (quan != "Chọn Quận")) {
					sql = "select * from BienLai where Phuong = '" + phuong + "'";
					MySQL_thongke.search_dstiendien(sql);
					cbphuong.setSelectedIndex(0);
					cbquan.setSelectedIndex(0);
					
				} else if (mct.length() > 0) {
					sql = "select * from BienLai where Macongto = '" + mct + "'";
					MySQL_thongke.search_dstiendien(sql);
					tfkhct.setText("");
				}
			}
			// search theo thoi gian
			else if (year11 != 1 && (quan == "Chọn Quận") && mct.length() <= 0) {
//				System.out.println("search theo thoi gian nam");
				year2.setValue(2);
				year3.setValue(3);
				year4.setValue(4);
				sql = "select * from BienLai where Nam = " + year11;
				MySQL_thongke.search_dstiendien(sql);
				year1.setValue(1);

			} else if ((year22 != 2) && (year33 != 3) && (quan == "Chọn Quận") && mct.length() <=0) {
//				System.out.println("search theo thoi gian theo khoang thoi gian 111");
				year1.setValue(1);
				year4.setValue(4);

				String dateFrom = year22 + "-" + month + "-01";
				String dateTo = year33 + "-" + month1 + "-01";

				java.util.Date date2 = null;
				java.util.Date date3 = null;
				try {
					date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
					date3 = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				dateFrom = df.format(date2);
				dateTo = df.format(date3);
				sql = "select * from BienLai where Selecttime >='" + dateFrom + "' and Selecttime <= '" + dateTo +"'";
				System.out.println(sql);
				
				MySQL_thongke.search_dstiendien(sql);
				year3.setValue(3);
				year2.setValue(2);


			} else if (year44 != 4 && (quan == "Chọn Quận") &&mct.length()<0) {
//				System.out.println("search theo thoi gian theo chu ky");
				year1.setValue(1);
				year2.setValue(2);
				year3.setValue(3);
				sql = "select * from BienLai where Thang = " + month2 + " and Nam = " + year44;
				MySQL_thongke.search_dstiendien(sql);
				year4.setValue(4);
			}

			// ket hop quan va thoi gian
			else if (mct.length() <= 0 && (year11 != 1) && (quan != "Chọn Quận") && (phuong == "Chọn_Phường")) {
//				System.out.println("search theo thoi gian ket hop vs quan");
				year2.setValue(2);
				year3.setValue(3);
				year4.setValue(4);
				sql = "select * from BienLai where Quan = '" + quan + "' and Nam =" + year11;
				MySQL_thongke.search_dstiendien(sql);
				year1.setValue(1);
				cbquan.setSelectedIndex(0);

			} else if ((quan != "Chọn Quận") && (year22 != 2) && (year33 != 3) && (phuong == "Chọn_Phường") && mct.length() <=0) {
//				System.out.println("search theo khoang thoi gian ket hop vs quan");
				year1.setValue(1);
				year4.setValue(4);
				String dateFrom = year22 + "-" + month + "-01";
				String dateTo = year33 + "-" + month1 + "-01";

				java.util.Date date2 = null;
				java.util.Date date3 = null;
				try {
					date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
					date3 = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				dateFrom = df.format(date2);
				dateTo = df.format(date3);
				sql = "select * from BienLai where Selecttime >='" + dateFrom + "' and Selecttime <= '" + dateTo + "' and Quan='" + quan + "'";
				MySQL_thongke.search_dstiendien(sql);
				year2.setValue(2);
				year3.setValue(3);
				cbquan.setSelectedIndex(0);
			} else if ((year44 != 4) && (quan != "Chọn Quận") && (phuong == "Chọn_Phường")) {
//				System.out.println("search theo chu ky ket hop vs quan");
				year2.setValue(2);
				year3.setValue(3);
				year1.setValue(1);
				sql = "select * from BienLai where Quan = '" + quan + "' and Nam =" + year44 + " and Thang =" + month2;
				MySQL_thongke.search_dstiendien(sql);
				year4.setValue(4);
				cbquan.setSelectedIndex(0);
			}
			// ket hop giua phuong va khoang thoi gian
			else if (mct.length() <= 0 && year11 != 1 && (phuong != "Chọn_Phường")) {
//				System.out.println("search theo nam ket hop vs phuong");
				year2.setValue(2);
				year3.setValue(3);
				year4.setValue(4);
				sql = "select * from BienLai where Phuong = '" + phuong + "' and Nam =" + year11;
				MySQL_thongke.search_dstiendien(sql);
				year1.setValue(1);
				cbquan.setSelectedIndex(0);
				cbphuong.setSelectedIndex(0);

			} else if ((phuong != "Chọn_Phường") && (year22 != 2) && (year33 != 3) && mct.length()<=0) {
				year1.setValue(1);
				year4.setValue(4);
				String dateFrom = year22 + "-" + month + "-01";
				String dateTo = year33 + "-" + month1 + "-01";

				java.util.Date date2 = null;
				java.util.Date date3 = null;
				try {
					date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
					date3 = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				dateFrom = df.format(date2);
				dateTo = df.format(date3);
				sql = "select * from BienLai where Selecttime >='" + dateFrom + "' and Selecttime <= '" + dateTo + "' and Phuong='" + phuong + "'";
				MySQL_thongke.search_dstiendien(sql);
				year2.setValue(2);
				year3.setValue(3);
				cbquan.setSelectedIndex(0);
				cbphuong.setSelectedIndex(0);
			} else if (year44 != 4 && (phuong != "Chọn_Phường")) {
//				System.out.println("search theo chu ky ket hop vs phuong");
				year2.setValue(2);
				year3.setValue(3);
				year1.setValue(1);
				sql = "select * from BienLai where Phuong = '" + phuong + "' and Nam =" + year44 + " and Thang ="
						+ month2;
				MySQL_thongke.search_dstiendien(sql);
				year4.setValue(4);
				cbquan.setSelectedIndex(0);
			}
			// ket hop giua ma cong to va thoi gian
			else if (mct.length() > 0 && year11 != 1) {
//				System.out.println("search theo nam ket hop vs ma cong to");
				year2.setValue(2);
				year3.setValue(3);
				year4.setValue(4);
				sql = "select * from BienLai where Macongto = '" + mct + "'and Nam =" + year11;
				MySQL_thongke.search_dstiendien(sql);
				year1.setValue(1);
				tfkhct.setText("");
			} else if (mct.length() > 0 && (year22 != 2) && (year33 != 3)) {
				year1.setValue(1);
				year4.setValue(4);
				String dateFrom = year22 + "-" + month + "-01";
				String dateTo = year33 + "-" + month1 + "-01";

				java.util.Date date2 = null;
				java.util.Date date3 = null;
				try {
					date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
					date3 = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				dateFrom = df.format(date2);
				dateTo = df.format(date3);
				sql = "select * from BienLai where Selecttime >='" + dateFrom + "' and Selecttime <= '" + dateTo + "' and Macongto='" + mct + "'";
				MySQL_thongke.search_dstiendien(sql);
				year3.setValue(3);
				year2.setValue(2);
				tfkhct.setText("");

			} else if (mct.length() > 0 && (year44 != 4)) {
//				System.out.println("search theo chu ky ket hop vs mã");
				year2.setValue(2);
				year3.setValue(3);
				year1.setValue(1);
				sql = "select * from BienLai where Macongto = '" + mct + "' and Nam =" + year44 + " and Thang =";
				MySQL_thongke.search_dstiendien(sql);
				year4.setValue(4);
				tfkhct.setText("");
			}
		
		}
		if (bt == btnreturn) {
			super.setVisible(false);
			Homepage hp = new Homepage("PHẦN MỀM TÍNH TIỀN ĐIỆN");
			hp.showWindow();
		}
	}

	/*
	 * thuc hien chuc nang khi click vao combobox
	 */
	/*
	 * thuc hien chuc nang khi chon combobox quan:
	 */
	ActionListener cbevent1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();

			if (cb == cbquan) {
				cbphuong.removeAllItems();
				Name = cbquan.getSelectedItem().toString();
				Quan_id = MySQL_khachhang.getQuanID(Name);
				String sql = "select * from Phuong where Parent_id = " + Quan_id;
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

		// get Window Conatiner
		Container con = getContentPane();
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));

		// set panel cho title:
		JPanel pntitle = new JPanel();
		pntitle.setMaximumSize(new Dimension(900, 130));
		pntitle.setBackground(new Color(139, 0, 139));
		JLabel lbtitle = new JLabel("TÌNH HÌNH THU TIỀN ĐIỆN");
		lbtitle.setForeground(Color.WHITE);
		lbtitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		pntitle.add(lbtitle);
		// set Font
		Font font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16);

		// set JPanel cho nhap thong tin
		JPanel pnnhap1 = new JPanel();
		JLabel lbselect = new JLabel("LỰA CHỌN");
		lbselect.setForeground(Color.RED);
		lbselect.setFont(font);
		pnnhap1.add(lbselect);
		/*
		 * //JPanel combobox lua chon khach hang
		 */
		JPanel pnkhachhang = new JPanel();
		JLabel lb1 = new JLabel("Theo khách hàng");
		lb1.setForeground(Color.RED);
		lb1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		String[] khachhang = { "Chọn", "Tất cả khách hàng", "Theo Quận, Phường", "Theo khách hàng cụ thể" };
		cbkh = new JComboBox(khachhang);
		cbkh.setMaximumSize(new Dimension(400, 30));
		pnkhachhang.add(lb1);
		pnkhachhang.add(javax.swing.Box.createRigidArea(new Dimension(40, 10)));
		pnkhachhang.add(cbkh);

		// JPanel CardLayout:
		pnkh_select = new JPanel();
		pnkh_select.setMaximumSize(new Dimension(600, 60));
		pnkh_select.setLayout(new CardLayout(0, 0));

		// set 3 panel cho Jpanel Cardlayout
		// panel1
		pntckh = new JPanel();
		pntckh.setMinimumSize(new Dimension(600, 60));

		rdbutton = new JRadioButton("Tất cả khách hàng");
		rdbutton.setForeground(Color.BLACK);
		rdbutton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbutton.setMinimumSize(new Dimension(300, 25));
		pntckh.add(rdbutton);

		// panel 2
		pnquan_phuong = new JPanel();
		pnquan_phuong.setMinimumSize(new Dimension(600, 60));
		pnquan_phuong.setLayout(new BoxLayout(pnquan_phuong, BoxLayout.X_AXIS));
		pnquan_phuong.add(javax.swing.Box.createRigidArea(new Dimension(50, 10)));

		JLabel lbquan = new JLabel("Quận");
		lbquan.setForeground(Color.BLACK);
		lbquan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbquan.setPreferredSize(new Dimension(50, 25));

		cbquan = new JComboBox();
		String chuoi = "DSthutiendien";
		MySQL_khachhang.getQuan(chuoi);
		cbquan.setPreferredSize(new Dimension(123, 25));

		JLabel lbphuong = new JLabel("Phường");
		lbphuong.setForeground(Color.BLACK);
		lbphuong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbphuong.setPreferredSize(new Dimension(70, 25));

		cbphuong = new JComboBox();
		cbphuong.setPreferredSize(new Dimension(123, 25));

		pnquan_phuong.add(lbquan);
		pnquan_phuong.add(javax.swing.Box.createRigidArea(new Dimension(50, 10)));
		pnquan_phuong.add(cbquan);
		pnquan_phuong.add(javax.swing.Box.createRigidArea(new Dimension(90, 10)));
		pnquan_phuong.add(lbphuong);
		pnquan_phuong.add(cbphuong);

		// set panel 3:
		pnkhct = new JPanel();
		pnkhct.setMinimumSize(new Dimension(600, 60));
		JLabel lbmactd = new JLabel("Mã công tơ điện");
		lbmactd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tfkhct.setText("CT_00..");
			}

		});
		lbmactd.setForeground(Color.BLACK);
		lbmactd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbmactd.setPreferredSize(new Dimension(150, 25));

		tfkhct = new JTextField();
		tfkhct.setColumns(14);
		pnkhct.add(lbmactd);
		pnkhct.add(tfkhct);
		JPanel pncbtiendien = new JPanel();
		JLabel lb2 = new JLabel("Theo thời gian");
		lb2.setForeground(Color.RED);
		lb2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		String[] strcbtiendien = { "Chọn", "Theo năm", "Theo khoảng thời gian(m/y)", "Theo chu kỳ" };
		cbtime = new JComboBox(strcbtiendien);
		cbtime.setModel(
		new DefaultComboBoxModel(new String[] { "Chọn", "Theo năm", "Theo khoảng thời gian", "Theo chu kỳ" }));
		cbtime.setMaximumSize(new Dimension(400, 30));
		pncbtiendien.add(lb2);
		pncbtiendien.add(javax.swing.Box.createRigidArea(new Dimension(55, 10)));
		pncbtiendien.add(cbtime);

		// them khoang trong
		JPanel pnthem11 = new JPanel();

		// JPanel CardLayout:
		pntime = new JPanel();
		pntime.setMaximumSize(new Dimension(600, 30));
		pntime.setLayout(new CardLayout(0, 0));

		// set 3 panel cho Jpanel Cardlayout
		// panel1
		pnyear1 = new JPanel();
		JLabel lbyear1 = new JLabel("Lựa chọn theo năm");
		lbyear1.setForeground(Color.BLACK);
		lbyear1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbyear1.setPreferredSize(new Dimension(120, 25));

		year1 = new JYearChooser();
		year1.setValue(1);
		year1.setPreferredSize(new Dimension(100, 25));
		pnyear1.add(lbyear1);
		pnyear1.add(javax.swing.Box.createRigidArea(new Dimension(50, 10)));
		pnyear1.add(year1);
		pnyear1.add(javax.swing.Box.createRigidArea(new Dimension(30, 10)));

		// panel2
		pnyear2 = new JPanel();
		pnyear2.setBorder(null);
		pnyear2.setLayout(new BoxLayout(pnyear2, BoxLayout.X_AXIS));

		JLabel lbkhoangtg1 = new JLabel("Từ tháng/năm");
		lbkhoangtg1.setForeground(Color.BLACK);
		lbkhoangtg1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbkhoangtg1.setPreferredSize(new Dimension(114, 25));

		String[] month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cbmonth = new JComboBox(month);
		cbmonth.setPreferredSize(new Dimension(70, 25));

		year2 = new JYearChooser();
		year2.setValue(2);
		year2.setPreferredSize(new Dimension(100, 25));

		JLabel lbkhoangtg2 = new JLabel("Đến tháng/năm");
		lbkhoangtg2.setForeground(Color.BLACK);
		lbkhoangtg2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbkhoangtg2.setPreferredSize(new Dimension(114, 25));

		String[] month1 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cbmonth1 = new JComboBox(month);
		cbmonth1.setPreferredSize(new Dimension(69, 25));
		year3 = new JYearChooser();
		year3.setValue(3);
		year3.setPreferredSize(new Dimension(100, 25));

		pnyear2.add(lbkhoangtg1);
		pnyear2.add(cbmonth);
		pnyear2.add(year2);
		pnyear2.add(javax.swing.Box.createRigidArea(new Dimension(40, 10)));
		pnyear2.add(lbkhoangtg2);
		pnyear2.add(cbmonth1);
		pnyear2.add(year3);

		// set panel3:
		pnyear3 = new JPanel();
		JLabel lbkhoangtg3 = new JLabel("Chọn tháng/năm");
		lbkhoangtg3.setForeground(Color.BLACK);
		lbkhoangtg3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbkhoangtg3.setPreferredSize(new Dimension(100, 25));

		String[] month2 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cbmonth2 = new JComboBox(month);
		cbmonth2.setPreferredSize(new Dimension(70, 25));

		year4 = new JYearChooser();
		year4.setValue(4);
		year4.setPreferredSize(new Dimension(100, 25));
		pnyear3.add(javax.swing.Box.createRigidArea(new Dimension(115, 10)));
		pnyear3.add(lbkhoangtg3);
		pnyear3.add(javax.swing.Box.createRigidArea(new Dimension(40, 10)));
		pnyear3.add(cbmonth2);
		pnyear3.add(year4);
		pnyear3.add(javax.swing.Box.createRigidArea(new Dimension(100, 10)));

		/*
		 * set panel button
		 */
		JPanel pnbutton = new JPanel();
		btnsubmit = new JButton("Xác nhận");
		btnsubmit.setForeground(Color.RED);
		btnsubmit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnsubmit.setPreferredSize(new Dimension(120, 25));

		btnreturn = new JButton("Quay lại");
		btnreturn.setForeground(Color.RED);
		btnreturn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnreturn.setPreferredSize(new Dimension(120, 25));
		pnbutton.add(btnsubmit);
		pnbutton.add(btnreturn);
		// set panel cho tabel:

		JPanel pntable = new JPanel();
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder title = BorderFactory.createTitledBorder(border, "Danh Sách");
		pntable.setBorder(title);

		table = new JTable();
		table.setModel(model);
		table.setPreferredScrollableViewportSize(new Dimension(800, 150));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane sc = new JScrollPane();
		sc.setBounds(59, 11, 648, 190);
		sc.setViewportView(table);
		pntable.add(sc);

		// add cac panel vao
		pnmain.add(pntitle);
		pnmain.add(pnnhap1);
		pnmain.add(pnkhachhang);
		pnmain.add(pnkh_select);
		pnmain.add(pncbtiendien);
		pnmain.add(pntime);

		pnmain.add(Box.createRigidArea(new Dimension(55, 20)));
		pnmain.add(pnbutton);
		pnmain.add(pntable);
		con.add(pnmain);
	}
}
