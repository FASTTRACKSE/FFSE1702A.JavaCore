package project1.javadesktop;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class QuanLyBienLai extends JFrame implements ActionListener {
	static JComboBox cbquan, cbphuong, mactd, cbmonth;
	private JDateChooser date;
	private JYearChooser yearChooser;
	private JPanel contentPane;
	private JTextField tfhoten, tfcsct;
	private JButton btnadd, btnedit, btndel, btnreturn, btnsubmit;
	private int Quan_id;
	static Connection conn = Connection_Database.Ketnoi();
	static PreparedStatement ptmt = null;
	private String Name;
	private JTable table;
	private static String[] cottieude = { "Mã công tơ", " Tên khách hàng", "Ngày nhập", "Tháng", "Năm",
			"Chỉ số công tơ" };
	static DefaultTableModel tbmodel = new DefaultTableModel(cottieude, 0);
	static ArrayList<Integer> dem = new ArrayList<>();

	/*
	 * ham dung khong truyen tham so
	 */
	public QuanLyBienLai() {
		Addcontrolls();
		Addevents();
	}

	/*
	 * phuong thuc create event
	 */
	public void Addevents() {
		cbquan.addActionListener(cbevent1);
		cbphuong.addActionListener(cbevent1);
		mactd.addActionListener(cbevent1);
		table.addMouseListener(tbevent);
		btnadd.addActionListener(this);
		btnedit.addActionListener(this);
		btndel.addActionListener(this);
		btnreturn.addActionListener(this);
		btnsubmit.addActionListener(this);

	}

	// thuc hien chuc nang:
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton) e.getSource();
		if (bt == btnadd) {

			// add your code
			int csct = 0;
			String mact = "";
			try {
			mact = mactd.getSelectedItem().toString();
			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(contentPane, "Chưa chọn mã công tơ","Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
				dem.add(1);
				
			}
			// MyException.MyE_check_mct1(mact);

			// check ma ct va
			String hoten = tfhoten.getText();

			// dinh dang cho ngay nhap:
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String day = "";
			try {
					day = df.format(date.getDate());
			}catch(Exception e1)
			{
				dem.add(1);
				JOptionPane.showMessageDialog(contentPane, "Chưa chọn ngày nhập","Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
			}
			
			// nhap chu ki:
			
			int month = Integer.parseInt(cbmonth.getSelectedItem().toString());
			int year = yearChooser.getYear();
			MyException.MyE_end_year(mact, month, year);
			// quan ly MyException: yearFrom + "-" + monthFrom + "-01";
			String selecttime = year + "-" + month + "-01";
			String csct1 = tfcsct.getText();
			if (csct1.length() > 0) {
				csct = Integer.parseInt(csct1);
				MyException.MyE_checkChiSo(mact, csct1, csct);
			}
			else
			{
				dem.add(1);
				JOptionPane.showMessageDialog(contentPane, "Chưa nhập chỉ số công tơ","Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
			}
		
			// them quan va phuong vao trong bang quan ly bien lai
			String quan = (String) cbquan.getSelectedItem();
			String phuong = (String) cbphuong.getSelectedItem();
			if (dem.size() == 0) {

				double tiendien = BienLai.getTien(csct, mact, month, year);
				MySQL_bienlai.add_Bienlai(hoten, mact, day, month, year, csct, tiendien, quan, phuong, selecttime);
				// set Text:
				setText();
			} 
			if (dem.size() > 0) {

				for (int i = 0; i < dem.size(); i++) {
					dem.remove(i);
				}
			}
		}
		if (bt == btnedit) {
			// add your code
			int csct = 0;
			int row = table.getSelectedRow();
			if(row!=-1)
			{
			String mact = mactd.getSelectedItem().toString();
			String hoten = tfhoten.getText();
			// dinh dang cho ngay nhap:
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String day = df.format(date.getDate());
			int month = Integer.parseInt(cbmonth.getSelectedItem().toString());
			int year = yearChooser.getYear();
			/*
			 * update chi so cong to;
			 */
			String csct1 = tfcsct.getText();
			if (csct1.length() > 0) {
				csct = Integer.parseInt(csct1);
				MyException.MyE_checkChiSo1(csct, month, year, mact);
			}

			if (dem.size() == 0) {
				double tiendien = BienLai.getTien(csct, mact, month, year);
				// update vao tbmodel hien thi ở trang hien thi:
				Object[] row_update = { mact, hoten, day, month, year, csct };
				for (int i = 0; i < row_update.length; i++) {
					tbmodel.setValueAt(row_update[i], row, i);
				}
				MySQL_bienlai.update_bienlai(hoten, mact, day, month, year, csct, tiendien);
				setText();
				/*
				 * update cho tat ca cac chu ky sau do:
				 * 
				 */
				int endmonth = month + 1;
				MySQL_bienlai.update_tiendien(mact, month, endmonth, year);
			} else {
				JOptionPane.showMessageDialog(null, "Yêu cầu nhập đầy đủ thông tin", "Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
			}
			if (dem.size() > 0) {

				for (int i = 0; i < dem.size(); i++) {
					dem.remove(i);
				}
			}
			}else
			{
				JOptionPane.showMessageDialog(null, "Chưa chọn thông tin để chỉnh sửa", "Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
			}

		}
		if (bt == btndel) {
			// add your code
			int row = table.getSelectedRow();
			if(row!=-1)
			{
			int month = Integer.parseInt(cbmonth.getSelectedItem().toString());
			tbmodel.removeRow(row);
			MySQL_bienlai.Del_bienlai(month);
			setText();
			}else
			{
				JOptionPane.showMessageDialog(null, "Chưa chọn dữ liệu để xóa", "Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
			}
		}
		if (bt == btnsubmit) {
			// add your code
			String quan1 = (String) cbquan.getSelectedItem();
			String phuong1 = (String) cbphuong.getSelectedItem();
			String mact1 = (String) mactd.getSelectedItem();
			if(phuong1 != "Chọn Phường" && quan1!= "Chọn Quận" && mact1 != "Chọn Mã công tơ")
			{
				String mact = mactd.getSelectedItem().toString(); 
				MySQL_bienlai.search_bienlai(mact);
			}else
			{
				JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng để tìm kiếm", "Thông báo lỗi",JOptionPane.ERROR_MESSAGE);
			}

		}
		if (bt == btnreturn) {

			super.setVisible(false);
			Homepage hp = new Homepage("PHẦN MỀM TÍNH TIỀN ĐIỆN");
			hp.showWindow();

		}
	}

	/*
	 * thuc hien chuc nang setText();
	 */
	public void setText() {
		mactd.setSelectedIndex(0);
		mactd.setEnabled(true);
		date.setDate(null);
		date.setEnabled(true);
		cbmonth.setSelectedIndex(0);
		cbmonth.setEnabled(true);
		yearChooser.setEnabled(true);
		tfcsct.setText("");
		mactd.setEnabled(true);
		cbquan.setEnabled(true);
		cbphuong.setEnabled(true);
	}

	/*
	 * thuc hien chuc nang khi chon combobox quan:
	 */
	ActionListener cbevent1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();

			if (cb == cbquan) {
				mactd.removeAllItems();
				cbphuong.removeAllItems();
				Name = cbquan.getSelectedItem().toString();
				Quan_id = MySQL_khachhang.getQuanID(Name);
				String sql = "select  *  from Phuong where Parent_id = " + Quan_id;
				try {
					ptmt = (PreparedStatement) conn.prepareStatement(sql);
					ResultSet rs = ptmt.executeQuery();
					cbphuong.addItem("Chọn Phường");
					while (rs.next()) {
						cbphuong.addItem(rs.getString("Phuong"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("loi" + e1);
				}
			}
			if ((cb == cbphuong)) {
				mactd.removeAllItems();
				if (cbphuong.getItemCount() > 0) {
					Name = cbphuong.getSelectedItem().toString();
					String sql1 = "select * from Customer where Phuong = '" + Name + "'";
					try {
						ptmt = (PreparedStatement) conn.prepareStatement(sql1);
						ResultSet rs1 = ptmt.executeQuery();
						mactd.addItem("Chọn Mã công tơ");
						while (rs1.next()) {
							mactd.addItem(rs1.getString("Macongto"));
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("loi" + e1);
					}
				}
			}
			if (cb == mactd) {
				tfhoten.setText("");
				if (mactd.getItemCount() > 0) {
					String Mact = mactd.getSelectedItem().toString();
					String sql = "select * from Customer where Macongto = '" + Mact + "'";
					try {
						ptmt = (PreparedStatement) conn.prepareStatement(sql);
						ResultSet rs = ptmt.executeQuery();
						while (rs.next()) {
							tfhoten.setText(rs.getString("Username"));
							tfhoten.setEditable(false);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("loi" + e1);
					}
				}
			}

		}
	};
	/*
	 * thuc hien chuc nang khi click vao table:
	 */
	MouseAdapter tbevent = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = table.getSelectedRow();
			Object[] value = new Object[6];
			for (int j = 0; j < value.length; j++) {
				value[j] = table.getValueAt(i, j);
			}
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date.setDate(formatter.parse((value[2]).toString()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				System.out.println("loi" + e1);
			}

			cbmonth.setSelectedItem(value[3].toString());
			yearChooser.setValue((int) value[4]);
			tfcsct.setText(value[5].toString());
			cbmonth.setEnabled(false);
			date.setEnabled(false);
			yearChooser.setEnabled(false);
			mactd.setSelectedItem(value[0]);
			mactd.setEnabled(false);
			cbquan.setEnabled(false);
			cbphuong.setEnabled(false);
		}
	};

	/**
	 * Create the frame.
	 */
	public void Addcontrolls() {

		this.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
		this.setTitle("PHẦN MỀM QUẢN LÝ TIỀN ĐIỆN");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBounds(200, 100, 900, 600);
		this.setResizable(false);

		Container con = getContentPane();
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));
		// Tao Jpanel title cho Panel
		JPanel pntitle = new JPanel();
		pntitle.setBackground(new Color(139, 0, 139));
		JLabel lbtitle = new JLabel("QUẢN LÝ BIÊN LAI");
		lbtitle.setForeground(Color.WHITE);
		lbtitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		pntitle.add(lbtitle);
		// set FONT:
		Font font = new Font("Times New Roman", Font.BOLD, 14);

		// tao Panel1 nhap thong tin:
		JPanel pnnhap1 = new JPanel();

		JLabel lbquan = new JLabel("Quận");
		lbquan.setForeground(Color.black);
		lbquan.setFont(font);
		lbquan.setPreferredSize(new Dimension(70, 25));
		pnnhap1.add(lbquan);

		cbquan = new JComboBox();
		String chuoi = "Bienlai";
		MySQL_khachhang.getQuan(chuoi);
		cbquan.setPreferredSize(new Dimension(150, 25));
		pnnhap1.add(cbquan);

		JLabel lb1 = new JLabel();
		lb1.setPreferredSize(new Dimension(70, 25));
		pnnhap1.add(lb1);

		JLabel lbphuong = new JLabel("Phường");
		lbphuong.setForeground(Color.black);
		lbphuong.setFont(font);
		lbphuong.setPreferredSize(new Dimension(70, 25));
		pnnhap1.add(lbphuong);

		cbphuong = new JComboBox();
		cbphuong.setPreferredSize(new Dimension(150, 25));
		pnnhap1.add(cbphuong);

		// tao Panel 2 nhap thong tin:
		JPanel pnnhap2 = new JPanel();
		JLabel lbmactd = new JLabel("Mã công tơ điện");
		lbmactd.setForeground(Color.BLACK);
		lbmactd.setFont(font);
		lbmactd.setPreferredSize(new Dimension(150, 25));
		pnnhap2.add(lbmactd);
		mactd = new JComboBox();
		mactd.setPreferredSize(new Dimension(150, 25));
		pnnhap2.add(mactd);

		// tap panel3 nhap thong tin:
		JPanel pnnhap3 = new JPanel();
		JLabel lbhoten = new JLabel("Tên khách hàng");
		lbhoten.setForeground(Color.BLACK);
		lbhoten.setFont(font);
		lbhoten.setPreferredSize(new Dimension(150, 25));

		tfhoten = new JTextField();
		tfhoten.setPreferredSize(new Dimension(150, 20));
		pnnhap3.add(lbhoten);
		pnnhap3.add(tfhoten);

		// Tao Panel4 nhap thong tin:
		JPanel pnnhap4 = new JPanel();
		JLabel lbngay = new JLabel("Ngày nhập");
		lbngay.setForeground(Color.black);
		lbngay.setFont(font);
		lbngay.setPreferredSize(new Dimension(150, 25));

		// ngay nhap
		date = new JDateChooser();
		date.setPreferredSize(new Dimension(150, 20));
		pnnhap4.add(lbngay);
		pnnhap4.add(date);

		// tao Jpanel 5 nhap thong tin:
		JPanel pnnhap5 = new JPanel();

		// ngay tháng nhập
		JLabel lbchuky = new JLabel("Chu kỳ nhập");
		lbchuky.setForeground(Color.BLACK);
		lbchuky.setFont(font);
		lbchuky.setPreferredSize(new Dimension(150, 25));
		pnnhap5.add(lbchuky);

		String[] month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cbmonth = new JComboBox(month);
		cbmonth.setPreferredSize(new Dimension(50, 25));
		yearChooser = new JYearChooser();
		yearChooser.setPreferredSize(new Dimension(95, 25));
		pnnhap5.add(cbmonth);
		pnnhap5.add(yearChooser);
		// tao panel 6 nhap thong tin:
		JPanel pnnhap6 = new JPanel();
		JLabel lbcsct = new JLabel("Chỉ số công tơ");
		lbcsct.setForeground(Color.BLACK);
		lbcsct.setFont(font);
		lbcsct.setPreferredSize(new Dimension(150, 25));

		tfcsct = new JTextField();
		tfcsct.setPreferredSize(new Dimension(150, 20));
		pnnhap6.add(lbcsct);
		pnnhap6.add(tfcsct);

		// Set panel cho BUtton
		JPanel pncontroll = new JPanel();
		pncontroll.setLayout(new FlowLayout());

		btnadd = new JButton("Thêm");
		btnadd.setForeground(Color.RED);
		btnadd.setFont(font);
		pncontroll.add(btnadd);

		btnedit = new JButton("Sửa");
		btnedit.setForeground(Color.RED);
		btnedit.setFont(font);
		pncontroll.add(btnedit);

		btndel = new JButton("Xóa");
		btndel.setForeground(Color.RED);
		btndel.setFont(font);
		pncontroll.add(btndel);

		btnsubmit = new JButton("Tìm kiếm");
		btnsubmit.setForeground(Color.RED);
		btnsubmit.setFont(font);
		pncontroll.add(btnsubmit);

		btnreturn = new JButton("Quay lại");
		btnreturn.setForeground(Color.RED);
		btnreturn.setFont(font);
		pncontroll.add(btnreturn);

		// Tao panel cho tabel
		JPanel pntable = new JPanel();
		pntable.setBounds(10, 299, 764, 152);
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.red);
		TitledBorder title = BorderFactory.createTitledBorder(border, "Danh Sách");
		pntable.setBorder(title);

		table = new JTable();
		table.setModel(tbmodel);
		JScrollPane sc = new JScrollPane();
		table.setPreferredScrollableViewportSize(new Dimension(800, 200));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sc.setViewportView(table);
		pntable.add(sc);

		pnmain.add(pntitle);
		pnmain.add(pnnhap1);
		pnmain.add(pnnhap2);
		pnmain.add(pnnhap3);
		pnmain.add(pnnhap4);
		pnmain.add(pnnhap5);
		pnmain.add(pnnhap6);
		pnmain.add(pncontroll);
		pnmain.add(pntable);
		con.add(pnmain);

	}
}
