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
import java.util.Date;

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

import javafx.scene.shape.Box;
import java.awt.Component;

public class PageUser extends JFrame implements ActionListener {
	static JComboBox cbmonth, cbmonth1, cbmonth2, cbtime;
	private JTable table;
	private JButton btnreturn, btnsubmit;
	private JYearChooser year1, year2, year3, year4;
	private static String[] cottieude1 = { "Mã công tơ", " Tên khách hàng", "Ngày nhập", "Tháng", "Chu kỳ nhâp",
			"Chỉ số ct", "Tiền điện" };
	static DefaultTableModel model = new DefaultTableModel(cottieude1, 0);
	private String Name;
	private int Quan_id;
	static Connection conn = Connection_Database.Ketnoi();
	static PreparedStatement ptmt = null;
	private JPanel pntckh, pntime, pnyear1, pnyear2, pnyear3;
	private JRadioButton rdbutton;
	private JPanel pnmain;

	/**
	 * ham dung khong tham so
	 */
	public PageUser() {
		Addcontrolls();
		Addevents();
		search_khachhang();
	}

	/*
	 * phuong thuc create event
	 */
	public void Addevents() {
		cbtime.addActionListener(event2);
		btnsubmit.addActionListener(this);
		btnreturn.addActionListener(this);

	}

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
			} else if (cbtime.getSelectedItem().toString().equals("Tất cả")) {
				pntime.removeAll();
				pntime.add(pntckh);
				pntime.repaint();
				pntime.revalidate();
			}
		}
	};
	private JTextField tfhoten;
	private JTextField tfMakh;
	private JTextField tfstreet;
	private JTextField tfquan;
	private JTextField tfphuong;
	private JTextField tfphone;
	private JTextField tfemail;
	private JTextField tfmct;
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Component rigidArea_4;
	private Component rigidArea_5;

	// thuc hien chuc nang:
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton) e.getSource();
		if (bt == btnsubmit) {
			String makh = User.makh1;
			String mact = User.mact1;
			if(cbtime.getSelectedItem() != "Chọn")
			{
			boolean rd = rdbutton.isSelected();
			int month = Integer.parseInt(cbmonth.getSelectedItem().toString());
			int month1 = Integer.parseInt(cbmonth1.getSelectedItem().toString());
			int month2 = Integer.parseInt(cbmonth2.getSelectedItem().toString());
			int year11 = year1.getValue();
			int year22 = year2.getValue();
			int year33 = year3.getValue();
			int year44 = year4.getValue();
			String sql = "";
			if (rd == true) {
				sql = "select * from BienLai where Macongto = '" + mact + "'";
				search_dstiendien(sql);

			} else if (rd == false) {
				sql ="";
				search_dstiendien(sql);
				if (year11 != 1) {
					year2.setValue(2);
					year3.setValue(3);
					year4.setValue(4);
					sql = "select * from BienLai where Macongto ='" + mact + "'and Nam = "+ year11;
					search_dstiendien(sql);
					year1.setValue(1);
				}
				else if((year22 != 2) && (year33 != 3))
				{
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

					sql = "select * from BienLai where Selecttime >='" + dateFrom + "' and Selecttime <= '"
							+ dateTo + "'" + " and Macongto='" + mact + "'";
					search_dstiendien(sql);
					year3.setValue(3);
					year2.setValue(2);
				}
				else if (year44 != 4 ) {
					year1.setValue(1);
					year2.setValue(2);
					year3.setValue(3);			
					sql = "select * from BienLai where Macongto ='"+ mact+ "' and Thang = " + month2 + " and Nam = " + year44;
					search_dstiendien(sql);
					year4.setValue(4);
				}
			}
			}else {
				JOptionPane.showMessageDialog(pnmain, "Chọn điều kiện để loc dữ liệu","Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
			}
		}
		if (bt == btnreturn) {
			int click = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn đăng xuất?");
			if (click == JOptionPane.YES_OPTION) {
				super.setVisible(false);
				User user = new User();
				user.setVisible(true);
			} else if (click == JOptionPane.NO_OPTION) {
				super.setVisible(true);
			}
			else if(click == JOptionPane.CANCEL_OPTION)
			{
				super.setVisible(true);
			}

		}
	}
	
	/*
	 * select thong tin
	 */
	public void search_dstiendien(String sql1) {
		int rowcount1 = model.getRowCount();
		if (rowcount1 > 0) {
			for (int i = rowcount1 - 1; i >= 0; i--) {
				model.removeRow(i);
			}
		}
		if (sql1.length() > 0) {
			try {
				ptmt = (PreparedStatement) conn.prepareStatement(sql1);
				ResultSet rs = ptmt.executeQuery();
				
				while (rs.next()) {
					String mact1 = rs.getString("Macongto");
					String hoten = rs.getString("Username");
					Date date = rs.getDate("Ngaynhap");
					int thang = rs.getInt("Thang");
					int nam = rs.getInt("Nam");
					int chiso = rs.getInt("Chiso");
					double tiendien = rs.getDouble("Tiendien");
					Object[] row = { mact1, hoten, date, thang, nam, chiso, tiendien };
					model.addRow(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Lỗi" + e);
			}
		}
	}
	/*
	 * select thong tin:
	 */
	public void search_khachhang()
	{
		String makh = User.makh1;
		String sql = "select * from Customer where Makh = '" + makh + "'";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				tfMakh.setText("Mã khách hàng: " + rs.getString("Makh"));
				tfhoten.setText("Họ tên: "+rs.getString("Username"));
				tfstreet.setText("Địa chỉ: "+rs.getString("Address"));
				tfphuong.setText("Phường: "+rs.getString("Phuong"));
				tfquan.setText("Quận: "+rs.getString("Quan"));
				tfphone.setText("Số điện thoại: " + rs.getString("Phone"));
				tfemail.setText("Email: " + rs.getString("Email"));
				tfmct.setText( "Mã công tơ: " + rs.getString("Macongto"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public void Addcontrolls() {

		this.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
		this.setTitle("PHẦN MỀM QUẢN LÝ TIỀN ĐIỆN");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 800, 500);
		this.setResizable(false);

		// get Window Conatiner
		Container con = getContentPane();
		pnmain = new JPanel();
		pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));

		// set panel cho title:
		JPanel pntitle = new JPanel();
		pntitle.setMaximumSize(new Dimension(800, 60));
		pntitle.setBackground(new Color(139, 0, 139));
		JLabel lbtitle = new JLabel("THÔNG TIN CÁ NHÂN");
		lbtitle.setForeground(Color.WHITE);
		lbtitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		pntitle.add(lbtitle);
		// set Font
		Font font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16);

		// set JPanel cho nhap thong tin
		JPanel pnnhap1 = new JPanel();
		JPanel pnthem3 = new JPanel();
		JPanel pncbtiendien = new JPanel();
		JLabel lb2 = new JLabel("Theo thời gian");
		lb2.setForeground(Color.RED);
		lb2.setFont(new Font("Times New Roman", Font.BOLD, 14));

		String[] strcbtiendien = { "Chọn", "Tất cả", "Theo năm", "Theo khoảng thời gian", "Theo chu kỳ" };
		cbtime = new JComboBox(strcbtiendien);
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

		// set 4 panel cho Jpanel Cardlayout
		pntckh = new JPanel();
		rdbutton = new JRadioButton("Lựa chọn tất cả");
		pntckh.add(rdbutton);
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

		btnreturn = new JButton("Đăng xuất");
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
		table.setPreferredScrollableViewportSize(new Dimension(700, 120));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane sc = new JScrollPane();
		sc.setBounds(59, 11, 648, 190);
		sc.setViewportView(table);
		pntable.add(sc);

		// add cac panel vao

		pnmain.add(pntitle);
		pnmain.add(pnnhap1);
		
		tfMakh = new JTextField();
		pnnhap1.add(tfMakh);
		tfMakh.setEditable(false);
		tfMakh.setColumns(15);
		
		pnnhap1.add( javax.swing.Box.createRigidArea(new Dimension(25, 10)));
		
		tfhoten = new JTextField();
		tfhoten.setEditable(false);
		pnnhap1.add(tfhoten);
		tfhoten.setColumns(15);
		
		pnnhap1.add( javax.swing.Box.createRigidArea(new Dimension(25, 10)));
		
		tfstreet = new JTextField();
		tfstreet.setEditable(false);
		pnnhap1.add(tfstreet);
		tfstreet.setColumns(15);
		
		pnnhap1.add( javax.swing.Box.createRigidArea(new Dimension(25, 10)));
		
		tfquan = new JTextField();
		tfquan.setEditable(false);
		pnnhap1.add(tfquan);
		tfquan.setColumns(15);
		
		JPanel pnnhap11 = new JPanel();
		pnmain.add(pnnhap11);
		
		tfphuong = new JTextField();
		tfphuong.setEditable(false);
		pnnhap11.add(tfphuong);
		tfphuong.setColumns(15);
	
		pnnhap11.add(javax.swing.Box.createRigidArea(new Dimension(25, 10)));
		
		tfphone = new JTextField();
		tfphone.setEditable(false);
		pnnhap11.add(tfphone);
		tfphone.setColumns(15);
		
		pnnhap11.add(javax.swing.Box.createRigidArea(new Dimension(25, 10)));
		
		tfemail = new JTextField();
		tfemail.setEditable(false);
		pnnhap11.add(tfemail);
		tfemail.setColumns(15);
		
		pnnhap11.add(javax.swing.Box.createRigidArea(new Dimension(25, 10)));
		
		tfmct = new JTextField();
		tfmct.setEditable(false);
		pnnhap11.add(tfmct);
		tfmct.setColumns(15);
		
		
		pnmain.add(pncbtiendien);
		pnmain.add(pntime);
		pnmain.add(pnthem3);
		pnmain.add(pnbutton);
		pnmain.add(pntable);
		con.add(pnmain);
	}
}
