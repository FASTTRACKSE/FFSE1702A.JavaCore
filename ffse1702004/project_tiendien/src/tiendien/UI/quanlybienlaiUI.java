package tiendien.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import tiendien.MODEL.ExceptionMD;
import tiendien.MODEL.database;
import tiendien.MODEL.tinhTien;

public class quanlybienlaiUI extends JFrame {
	Connection conn = database.getConnect("localhost", "quanlytiendien", "quanlytiendien", "quanlytiendien");
	PreparedStatement ptmt = null;
	JTextField text_search;
	public static JTextField text_mct;
	JTextField text_name;
	JTextField text_diachi;
	public static JTextField text_chiso;
	JTextField text_ngaynhap;
	JButton bt_search, bt_add, bt_edit, bt_home, bt_logOut, bt_chk;
	JLabel mact, name, diachi, chiso, ngaynhap, chukynhap, ds, month, year;
	public static JComboBox cb_chukythang,cb_chukynam;
	String id, sql, key_ckt, key_ckn;
	Statement stm;
	int x;
	ResultSet res;
	DefaultTableModel tb = new DefaultTableModel();
	final JTable tbl = new JTable(tb);
	ExceptionMD ex = new ExceptionMD();

	public quanlybienlaiUI() {
		super("Quản Lý Tiền Điện");
		addControls();
		addEvents();
	}
	// đây là sự kiện
	private void addEvents() {
		bt_home.addActionListener(bt_home_1);
		bt_logOut.addActionListener(bt_logOut_1);
		bt_search.addActionListener(bt_search_1);
		bt_chk.addActionListener(bt_chk_1);
		tbl.addMouseListener(eventselect_2);

		bt_add.addActionListener(bt_add_1);
		bt_edit.addActionListener(bt_edit_1);

	}
	// đưa dữ liệu lên table
	MouseAdapter eventselect_2 = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbl.getSelectedRow();
			String[] row = new String[7];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbl.getValueAt(i, j);
			}
			text_mct.setText(row[0]);
			text_name.setText(row[1]);
			text_diachi.setText(row[2]);
			text_chiso.setText(row[3]);
			text_ngaynhap.setText(row[4]);
			cb_chukythang.setSelectedItem(row[5]);
			cb_chukynam.setSelectedItem(row[6]);

			try {
				key_ckt = (String) cb_chukythang.getItemAt(cb_chukythang.getSelectedIndex());
				key_ckn = (String) cb_chukynam.getItemAt(cb_chukynam.getSelectedIndex());

				res = conn.createStatement().executeQuery("SELECT id FROM ffse004_bienlai WHERE ffse004_bienlai.month = '" + key_ckt
						+ "' AND ffse004_bienlai.year = '" + key_ckn + "' AND macongto = '"+text_mct.getText()+"' ");
				while (res.next()) {
					id = res.getString("id");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};

	// home
	ActionListener bt_home_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			bt_home_1();
		}
	};

	protected void bt_home_1() {
		menuUI myMenu = new menuUI();
		try {
			myMenu.hienthi();
		} catch (ExceptionMD e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();
	}

	// bt tìm kiếm
	ActionListener bt_search_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				search_home_1();
			} catch (ExceptionMD e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	protected void search_home_1() throws ExceptionMD {
		if (ex.chkEmpty(text_search.getText()) && ex.chkSearch(text_search.getText())) {
			// delete table
			int row = tb.getRowCount();
			if (row > 0) {
				tb.setRowCount(0);
			}
			try {
				res = conn.createStatement().executeQuery(
						"SELECT ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chisocongto,ffse004_bienlai.ngaynhap,ffse004_bienlai.month,ffse004_bienlai.year FROM ffse004_customer INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE hoten LIKE '%"
								+ text_search.getText() + "%' ORDER BY  year , month  ASC ");

				while (res.next()) {
					tb.addRow(new String[] { res.getString("macongto"), res.getString("hoten"), res.getString("diachi"),
							res.getString("chisocongto"), res.getString("ngaynhap"), res.getString("month"),
							res.getString("year") });
				}
			} catch (SQLException e1) {
				
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// check mã công tơ
	ActionListener bt_chk_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			bt_chk_1();
		}

	};

	protected void bt_chk_1() {
		try {
			text_name.setText("");
			text_diachi.setText("");
			res = conn.createStatement()
					.executeQuery("SELECT  hoten,diachi FROM ffse004_customer WHERE macongto = '" + text_mct.getText() + "'");
			if (res.next()) {
				text_name.setText(res.getString("hoten"));
				text_diachi.setText(res.getString("diachi"));
			} else {
				JOptionPane.showMessageDialog(null, "Mã công tơ không tồn tại  ");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// đăng xuất 
	ActionListener bt_logOut_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			bt_logOut1();
		}
	};

	public void bt_logOut1() {
		loginUI myUI = new loginUI();
		myUI.showWindow();
		this.dispose();

	}

	// sửa dữ liệu 
	ActionListener bt_edit_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				bt_edit1();
			} catch (ExceptionMD e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	public void bt_edit1()throws ExceptionMD   {
		String m = (String) cb_chukythang.getItemAt(cb_chukythang.getSelectedIndex());
		String y = (String) cb_chukynam.getItemAt(cb_chukynam.getSelectedIndex());
		if(ex.chkMct(text_mct.getText()) && ex.chkEmpty(text_ngaynhap.getText()) && ex.chkChiSoThu2(text_chiso.getText())  && ex.chk_chuky(m, y)  ) {
			tinhTien tt = new tinhTien();
			tt.tinhtien();	
			try {
				String sql = "UPDATE ffse004_bienlai SET ngaynhap ='"+text_ngaynhap.getText()+"',chisocongto = '"+text_chiso.getText()+"',tinh_tien = '"+tinhTien.sotienphaitra +"' WHERE month = '"+m+"' AND year = '"+y+"' AND macongto = '"+text_mct.getText()+"'";
				Statement stm = (Statement) conn.createStatement();
				int x = stm.executeUpdate(sql);
				if (x > 0) {
					String message_true = "Cập nhật Khách Hàng Thành Công ";
					JOptionPane.showMessageDialog(null, message_true);

					// đặt các text và table về rỗng
					tb.setRowCount(0);
					text_mct.setText("");
					text_name.setText("");
					text_diachi.setText("");
					text_chiso.setText("");
					text_ngaynhap.setText("");
					text_search.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Cập Nhật Khách Hàng không Thành Công ");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
	}

	// thêm dữ liệu 
	ActionListener bt_add_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				bt_add1();
			} catch (ExceptionMD e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	public void bt_add1() throws ExceptionMD {
		String m = (String) cb_chukythang.getItemAt(cb_chukythang.getSelectedIndex());
		String y = (String) cb_chukynam.getItemAt(cb_chukynam.getSelectedIndex());
		if ( ex.chkEmpty(text_chiso.getText()) && ex.chkCk(m,y) && ex.chkEmpty(text_ngaynhap.getText()) 
				&& ex.chkChiSo(text_chiso.getText()) && ex.chkMct(text_mct.getText()) &&ex.chkCkNext()) {
			tinhTien tt = new tinhTien();
			tt.tinhtien();
			try {
				sql = "INSERT INTO ffse004_bienlai ( macongto, ngaynhap, month, year,chisocongto,chuky,tinh_tien) VALUES ('"
						+ text_mct.getText() + "', '" + text_ngaynhap.getText() + "', '" + m + "','" + y + "', '"
						+ text_chiso.getText() + "',concat('"+y+"',LPAD('"+m+"', 2, '0') ),'"+tinhTien.sotienphaitra + "');";
				stm = (Statement) conn.createStatement();
				x = stm.executeUpdate(sql);
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Thêm Dữ Liệu Thành Công ");
					tb.setRowCount(0);
					text_mct.setText("");
					text_name.setText("");
					text_diachi.setText("");
					text_chiso.setText("");
					text_ngaynhap.setText("");
					text_search.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Thêm Dữ Liệu Không Thành Công ");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	private void addControls() {
		Container con = getContentPane();
		JPanel boxAll = new JPanel();
		boxAll.setLayout(new BoxLayout(boxAll, BoxLayout.Y_AXIS));
		con.add(boxAll);
		// tiêu đề
		JLabel box_title = new JLabel("Quản Lý Biên Lai");
		box_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		box_title.setFont(new Font("Courier New", Font.BOLD, 22));
		box_title.setForeground(Color.red);
		boxAll.add(box_title);
		
		// tìm kiếm
		JLabel nameKh = new JLabel("Tên Khách Hàng :");
		JPanel box_search = new JPanel();
		text_search = new JTextField(25);
		bt_search = new JButton("tìm kiếm");
		box_search.add(nameKh);
		box_search.add(text_search);
		box_search.add(bt_search);
		boxAll.add(box_search);
	
		// ô tổng của phần GridLayout
		JPanel boxTt = new JPanel();

		// hang 1
		JPanel box_mact = new JPanel();
		box_mact.setLayout(new BoxLayout(box_mact, BoxLayout.X_AXIS));
		mact = new JLabel("Mã Công Tơ : ");
		mact.setHorizontalAlignment(SwingConstants.RIGHT);
		text_mct = new JTextField(15);
		bt_chk = new JButton("Check");
		boxTt.add(mact);
		box_mact.add(text_mct);
		box_mact.add(bt_chk);
		boxTt.add(box_mact);
		
		// hang 2
		ngaynhap = new JLabel("Ngày Nhập  : ");
		ngaynhap.setHorizontalAlignment(SwingConstants.RIGHT);
		text_ngaynhap = new JTextField(15);
		boxTt.add(ngaynhap);
		boxTt.add(text_ngaynhap);

		// hang 3
		name = new JLabel("    Họ Tên : ");
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		text_name = new JTextField(15);
		text_name.setEditable(false);

		boxTt.add(name);
		boxTt.add(text_name);

		// hang 4
		chukynhap = new JLabel("Chu Kỳ Nhập :");
		chukynhap.setHorizontalAlignment(SwingConstants.RIGHT);
		boxTt.add(chukynhap);
		JPanel box_phuong = new JPanel();
		String ck[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cb_chukythang = new JComboBox(ck);
		String yea[] = { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029","2030" };
		cb_chukynam = new JComboBox(yea);
		box_phuong.add(cb_chukythang);
		box_phuong.add(cb_chukynam);
		boxTt.add(box_phuong);

		// hang 5
		diachi = new JLabel("    Địa Chỉ : ");
		diachi.setHorizontalAlignment(SwingConstants.RIGHT);
		text_diachi = new JTextField(15);
		text_diachi.setEditable(false);
		boxTt.add(diachi);
		boxTt.add(text_diachi);

		// hang 6
		chiso = new JLabel("  Chỉ Số : ");
		chiso.setHorizontalAlignment(SwingConstants.RIGHT);
		text_chiso = new JTextField(15);
		boxTt.add(chiso);
		boxTt.add(text_chiso);
		
		//-----------------//
		boxTt.setLayout(new GridLayout(3, 4, 10, 5));
		boxAll.add(boxTt);
		
		// button
		JPanel box_bt = new JPanel();
		bt_add = new JButton("thêm");
		bt_edit = new JButton("Sửa");
		bt_home = new JButton("Home");
		bt_logOut = new JButton("Đăng Xuất");
		box_bt.add(bt_add);
		box_bt.add(bt_edit);
		box_bt.add(bt_home);
		box_bt.add(bt_logOut);
		box_bt.setLayout(new FlowLayout());
		boxAll.add(box_bt);
		
		// table
		ds = new JLabel("danh sách : ");
		boxAll.add(ds);
		JPanel box6 = new JPanel();
		tb.addColumn("Mã Công Tơ ");
		tb.addColumn("Tên ");
		tb.addColumn("Địa Chỉ");
		tb.addColumn("Chỉ Số ");
		tb.addColumn("Ngày Nhập ");
		tb.addColumn("Chu Kỳ Tháng");
		tb.addColumn("Chu Kỳ Năm");
		JScrollPane sc = new JScrollPane(tbl);
		box6.setLayout(new BorderLayout());
		box6.add(sc, BorderLayout.CENTER);
		boxAll.add(box6);
	}

	public void hienthi_qlbl()throws ExceptionMD {
		if(ex.chkLogin(loginUI.login)) {
			JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập trước");
			loginUI myUI = new loginUI();
			myUI.showWindow();
			this.dispose();
		}else {
		this.setSize(800, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		}
	}
}
