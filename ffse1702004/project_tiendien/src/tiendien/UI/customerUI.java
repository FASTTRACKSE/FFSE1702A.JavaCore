package tiendien.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import tiendien.MODEL.ExceptionMD;
import tiendien.MODEL.database;

public class customerUI extends JFrame {
	Connection conn = database.getConnect("localhost", "quanlytiendien", "quanlytiendien", "quanlytiendien");
	ExceptionMD ex = new ExceptionMD();
	ResultSet res;
	JLabel year, month, year_kh, to, ds;
	JComboBox cb_year, cb_year_kh, cb_month, cb_toYear, cb_toMonth, cb_inMonth, cb_inYear,cb_ckMonth,cb_ckYear;
	JButton bt_list, bt_logOut;
	JRadioButton JradioBt_time, JradioBt_ttg, JradioBt_chuky;
	String key = loginUI.email;
	ButtonGroup time;
	DefaultTableModel tb = new DefaultTableModel();
	final JTable tbl = new JTable(tb);

	public customerUI() {
		super("Quản Lý Tiền Điện");
		addControls();
		addEvents();
	}
	// sự kiện

	// đăng xuất 
	ActionListener logOut1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logOut();
		}
	};
	public void logOut() {
		loginUI myUI = new loginUI();
		myUI.showWindow();
		this.dispose();
	}

	// hiện thị danh sách
	ActionListener bt_list1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			list();
		}
	};
	public void list() {
		// xoa table
		int row = tb.getRowCount();
		if (row > 0) {
			tb.setRowCount(0);
		}
		try {
			if (time.getSelection() != null) {

				// chọn theo năm
				if (JradioBt_time.isSelected()) {
					String Ye = (String) cb_year.getSelectedItem();
					res = conn.createStatement().executeQuery(
							"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien,ffse004_bienlai.month,ffse004_bienlai.year FROM ffse004_customer  INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE maKH LIKE '%"+ key + "%' AND year = '" + Ye + "' ");
					while (res.next()) {
						tb.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
								res.getString("hoten"), res.getString("diachi"), res.getString("month"),
								res.getString("year"), res.getString("chisocongto"), res.getString("tinh_tien") });
					}
				}
				
				// chọn theo khoảng thời gian
				if (JradioBt_ttg.isSelected()) {
					String th = (String) cb_inMonth.getSelectedItem();
					String na = (String) cb_inYear.getSelectedItem();
					String dth =  (String) cb_toMonth.getSelectedItem();
					String dna = (String) cb_toYear.getSelectedItem();
					res = conn.createStatement().executeQuery(
							"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien,ffse004_bienlai.month,ffse004_bienlai.year FROM ffse004_customer  INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE maKH LIKE '%"+key+ "%' AND ffse004_bienlai.chuky BETWEEN  '"+na+""+th+"' AND '"+dna+""+dth+"' ");	
					while (res.next()) {
						tb.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
								res.getString("hoten"), res.getString("diachi"), res.getString("month"),
								res.getString("year"), res.getString("chisocongto"), res.getString("tinh_tien") });
					}
				}
				
				// chọn theo chu kỳ
				if (JradioBt_chuky.isSelected()) {
					String ckt = (String) cb_ckMonth.getSelectedItem();
					String ckn = (String) cb_ckYear.getSelectedItem();
					res = conn.createStatement().executeQuery(
							"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien,ffse004_bienlai.month,ffse004_bienlai.year FROM ffse004_customer  INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE maKH LIKE '%"
									+ key + "%' AND year = '" + ckn + "' AND month = '" + ckt + "' ");
					while (res.next()) {
						tb.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
								res.getString("hoten"), res.getString("diachi"), res.getString("month"),
								res.getString("year"), res.getString("chisocongto"), res.getString("tinh_tien") });
					}
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		bt_logOut.addActionListener(logOut1);

		bt_list.addActionListener(bt_list1);
	}

	private void addControls() {
		// TODO Auto-generated method stub

		// main
		Container con = getContentPane();
		JPanel boxAll = new JPanel();
		boxAll.setLayout(new BoxLayout(boxAll, BoxLayout.Y_AXIS));
		con.add(boxAll);

		// tiêu đề
		JLabel titleBox = new JLabel("Thống Kê Biên Lai");
		titleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleBox.setFont(new Font("Courier New", Font.BOLD, 22));
		titleBox.setForeground(Color.red);
		boxAll.add(titleBox);

		// nhóm JRadioButton theo thời gian
		time = new ButtonGroup();

		// box JRadio tổng của jradio / chứa box theo thời gian và theo khoảng thời gian và theo chu kỳ  
		JPanel box_jradio = new JPanel();
		box_jradio.setLayout(new BoxLayout(box_jradio, BoxLayout.Y_AXIS));
		boxAll.add(box_jradio);
		
		// box của jradio theo thời gian 
		JPanel box_time = new JPanel();
		box_time.setLayout(new BoxLayout(box_time, BoxLayout.X_AXIS));
		
		box_jradio.add(box_time);
		
		// button theo năm
		JradioBt_time = new JRadioButton("Năm");
		time.add(JradioBt_time);
		box_time.add(JradioBt_time);

		// button Theo khoảng thời gian
		JradioBt_ttg = new JRadioButton("Theo khoảng thời gian");
		time.add(JradioBt_ttg);
		box_time.add(JradioBt_ttg);

		// button theo chu kỳ
		JradioBt_chuky = new JRadioButton("chu kỳ ");
		time.add(JradioBt_chuky);
		box_time.add(JradioBt_chuky);

		// JComboBox theo năm
		JPanel box_year = new JPanel();
		
		box_jradio.add(box_year);
		year = new JLabel("năm : ");
		String y[] = { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2028",
				"2030" };
		cb_year = new JComboBox(y);
		box_year.add(year);
		box_year.add(cb_year);
		box_year.setVisible(false);
		JradioBt_time.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					box_year.setVisible(true);
				} else {
					box_year.setVisible(false);
				}
			}
		});

		// button Theo khoảng thời gian
		JPanel box_khoang = new JPanel();
		box_jradio.add(box_khoang);
		// tháng
		month = new JLabel("tháng : ");
		String m[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		cb_inMonth = new JComboBox(m);
		box_khoang.add(month);
		box_khoang.add(cb_inMonth);
		// năm
		year_kh = new JLabel("năm : ");
		String y_kh[] = { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028",
				"2029", "2030" };
		cb_inYear = new JComboBox(y_kh);
		box_khoang.add(year_kh);
		box_khoang.add(cb_inYear);
		to = new JLabel(" đến ");
		box_khoang.add(to);
		// tháng
		month = new JLabel("tháng : ");
		String m1[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		cb_toMonth = new JComboBox(m1);
		box_khoang.add(month);
		box_khoang.add(cb_toMonth);
		// năm
		year_kh = new JLabel("năm : ");
		String y_kh1[] = { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028",
				"2029", "2030" };
		cb_toYear = new JComboBox(y_kh1);
		box_khoang.add(year_kh);
		box_khoang.add(cb_toYear);

		box_khoang.setVisible(false);
		JradioBt_ttg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					box_khoang.setVisible(true);
				} else {
					box_khoang.setVisible(false);
				}
			}
		});
		// button Theo kỳ
		JPanel box_chuky = new JPanel();
		box_jradio.add(box_chuky);
		// tháng
		month = new JLabel("tháng : ");
		String m3[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cb_ckMonth = new JComboBox(m3);
		box_chuky.add(month);
		box_chuky.add(cb_ckMonth);
		// năm
		year_kh = new JLabel("năm : ");
		String y_kh3[] = { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028",
				"2029", "2030" };
		cb_ckYear = new JComboBox(y_kh3);
		box_chuky.add(year_kh);
		box_chuky.add(cb_ckYear);
		box_chuky.setVisible(false);
		JradioBt_chuky.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					box_chuky.setVisible(true);
				} else {
					box_chuky.setVisible(false);
				}
			}
		});
		// button
		JPanel box5 = new JPanel();
		bt_list = new JButton("Xem Danh Sách");
		bt_logOut = new JButton("Đăng Xuất ");
		box5.add(bt_list);
		box5.add(bt_logOut);
		box5.setLayout(new FlowLayout());
		boxAll.add(box5);
		// table
		ds = new JLabel("danh sách : ");
		boxAll.add(ds);
		JPanel box6 = new JPanel();
		tb.addColumn("mã Khách Hàng  ");
		tb.addColumn("Mã Công Tơ");
		tb.addColumn("Tên");
		tb.addColumn("Địa chỉ");
		tb.addColumn("Chu kỳ tháng ");
		tb.addColumn("Chu kỳ năm");
		tb.addColumn("Chỉ số công tơ");
		tb.addColumn("Tổng tiền");
		JScrollPane sc = new JScrollPane(tbl);

		box6.setLayout(new BorderLayout());
		box6.add(sc, BorderLayout.CENTER);
		boxAll.add(box6);
	}

	public void hienthi_customer() throws ExceptionMD {
		if (ex.chkLogin(loginUI.login)) {
			String lg = loginUI.login;
			JOptionPane.showMessageDialog(null, lg);
			loginUI myUI = new loginUI();
			myUI.showWindow();
			this.dispose();
		} else {
			this.setSize(800, 500);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
	}

}
