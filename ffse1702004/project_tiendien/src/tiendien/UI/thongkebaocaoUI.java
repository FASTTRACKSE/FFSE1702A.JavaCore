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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import tiendien.MODEL.ExceptionMD;
import tiendien.MODEL.database;

public class thongkebaocaoUI extends JFrame {
	Connection conn = database.getConnect("localhost", "quanlytiendien", "quanlytiendien", "quanlytiendien");
	PreparedStatement ptmt = null;
	ResultSet res;

	String maq, maqu;
	JMenu dskh, thtt;
	JMenuBar mb;

	// button window 1
	JButton bt_home, bt_logOut, bt_list;

	// button window 2
	JButton  bt_list_wd2, bt_home_wd2, bt_logOut_wd2;
	ButtonGroup customer, time;
	JRadioButton All_Customer, year_time, chuky_time, theothoigian_time,quanphuong_Customer,only_Customer;
	JTextField search_text;

	JLabel quan, phuong, ds, quan_customer, phuong_customer, year, month, year_kh, to;
	JComboBox quan_cb, quan_cb2, phuong_cb, phuong_cb2, year_cb, year_kh_cb, month_cb,cb_inMonth,cb_inYear,cb_toMonth,cb_toYear;

	DefaultTableModel tb = new DefaultTableModel();
	DefaultTableModel tb1 = new DefaultTableModel();
	final JTable tbl = new JTable(tb);
	final JTable tbl1 = new JTable(tb1);
	ExceptionMD ex = new ExceptionMD();

	public thongkebaocaoUI() {
		super("Quản Lý Tiền Điện");
		addControls();
		addEvents();
	}

	// đây là sự kiện
	private void addEvents() {
		bt_home.addActionListener(home_bt_1);
		bt_home_wd2.addActionListener(home_bt_1);
		bt_logOut_wd2.addActionListener(logout_bt_1);
		bt_logOut.addActionListener(logout_bt_1);
		bt_list_wd2.addActionListener(ds_btWd2_1);
		bt_list.addActionListener(ds_bt_1);
	}
	// home
	ActionListener home_bt_1 = new ActionListener() {
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

	// đăng xuất
	ActionListener logout_bt_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logout_bt1();
		}
	};
	public void logout_bt1() {
		loginUI myUI = new loginUI();
		myUI.showWindow();
		this.dispose();

	}

	//cửa sổ  danh sách khách hàng theo quận huyện
	ActionListener ds_bt_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			bt_ds_1();
		}
	};
	protected void bt_ds_1() {
		// xoa table:
		int row = tb.getRowCount();
		if (row > 0) {
			tb.setRowCount(0);
		}
		String mq = (String) quan_cb.getItemAt(quan_cb.getSelectedIndex());
		String mp = (String) phuong_cb.getItemAt(phuong_cb.getSelectedIndex());
		try {
			res = conn.createStatement().executeQuery(
					"SELECT `maKH`, `hoten`, `diachi`, `dienthoai`, `macongto` FROM `ffse004_customer` WHERE quan = '" + mq
							+ "' AND phuong = '" + mp + "'");
			while (res.next()) {
				tb.addRow(new String[] { res.getString("makh"), res.getString("hoten"), res.getString("diachi"),
						res.getString("dienthoai"), res.getString("macongto") });
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// danh sách khách hàng cửa sổ 2 
	ActionListener ds_btWd2_1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			bt_dsWd2_1();
		}
	};
	protected void bt_dsWd2_1() {
		// xoa table
		int row = tb1.getRowCount();
		if (row > 0) {
			tb1.setRowCount(0);
		}
		// all
		if (customer.getSelection() == null) {
			JOptionPane.showMessageDialog(null, "vui lòng chọn đối tượng cần xem !");
		} else {
			try {
				
				// nếu chọn vào tất cả khách hàng
				if (All_Customer.isSelected()) {
					
					// chọn all
					if (time.getSelection() == null) {
						JOptionPane.showMessageDialog(null, "vui lòng chọn khoảng thời gian cần xem !");
					} else {

						// chọn theo năm
						if (year_time.isSelected()) {
							String key_y = (String) year_cb.getSelectedItem();
							res = conn.createStatement().executeQuery(
									"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chuky ,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien FROM ffse004_customer INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE year = '"
											+ key_y + "' ORDER BY  macongto ,year , month  ASC");
							while (res.next()) {
								tb1.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
										res.getString("hoten"), res.getString("diachi"), res.getString("chuky"),
										res.getString("chisocongto"), res.getString("tinh_tien") });
							}
						}

						// theo chu kỳ
						if (chuky_time.isSelected()) {
							String key_m = (String) month_cb.getSelectedItem();
							String key_y = (String) year_kh_cb.getSelectedItem();
							res = conn.createStatement().executeQuery(
									"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chuky ,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien FROM ffse004_customer INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE month = '"
											+ key_m + "' and year = '" + key_y + "' ORDER BY  year , month  ASC");
							while (res.next()) {
								tb1.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
										res.getString("hoten"), res.getString("diachi"), res.getString("chuky"),
										res.getString("chisocongto"), res.getString("tinh_tien") });
							}
						}

						// theo khoảng thời gian
						if (theothoigian_time.isSelected()) {
							String th = (String) cb_inMonth.getSelectedItem();
							String na = (String) cb_inYear.getSelectedItem();
							String dth =  (String) cb_toMonth.getSelectedItem();
							String dna = (String) cb_toYear.getSelectedItem();	
							res = conn.createStatement().executeQuery(
									"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chuky ,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien FROM ffse004_customer INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE ffse004_bienlai.chuky BETWEEN '"+na+""+th+" '  AND '"+dna+""+dth+" '  ORDER BY  year , month  ASC");
							while (res.next()) {
								tb1.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
										res.getString("hoten"), res.getString("diachi"), res.getString("chuky"),
										res.getString("chisocongto"), res.getString("tinh_tien") });
							}
						}

					}
				}

				// chọn vào quận huyện
				if (quanphuong_Customer.isSelected()) {	
					if (time.getSelection() == null) {
						JOptionPane.showMessageDialog(null, "vui lòng chọn khoảng thời gian cần xem !");
					} else {

						// chọn theo năm
						if (year_time.isSelected()) {
							String key_quan = (String) quan_cb2.getSelectedItem();
							String key_huyen = (String) phuong_cb2.getSelectedItem();
							String key_y = (String) year_cb.getSelectedItem();
							res = conn.createStatement().executeQuery(
									"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chuky ,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien FROM ffse004_customer INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE quan = '"+key_quan+"' and phuong = '"+key_huyen + "' and year = '"
											+ key_y + "'  ORDER BY  macongto ,year , month  ASC");
							while (res.next()) {
								tb1.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
										res.getString("hoten"), res.getString("diachi"), res.getString("chuky"),
										res.getString("chisocongto"), res.getString("tinh_tien") });
							}
						}

						// theo chu kỳ
						if (chuky_time.isSelected()) {
							String key_quan = (String) quan_cb2.getSelectedItem();
							String key_huyen = (String) phuong_cb2.getSelectedItem();	
							String key_m = (String) month_cb.getSelectedItem();
							String key_y = (String) year_kh_cb.getSelectedItem();
							res = conn.createStatement().executeQuery(
									"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chuky ,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien FROM ffse004_customer INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE quan = '"+key_quan+"' and phuong = '"+key_huyen + "' and month = '"
											+ key_m + "' and year = '" + key_y + "' ORDER BY  year , month  ASC");
							while (res.next()) {
								tb1.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
										res.getString("hoten"), res.getString("diachi"), res.getString("chuky"),
										res.getString("chisocongto"), res.getString("tinh_tien") });
							}
						}

						// theo khoảng thời gian
						if (theothoigian_time.isSelected()) {
							String key_quan = (String) quan_cb2.getSelectedItem();
							String key_huyen = (String) phuong_cb2.getSelectedItem();
							
							String th = (String) cb_inMonth.getSelectedItem();
							String na = (String) cb_inYear.getSelectedItem();
							String dth =  (String) cb_toMonth.getSelectedItem();
							String dna = (String) cb_toYear.getSelectedItem();							
							res = conn.createStatement().executeQuery(
									"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chuky ,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien FROM ffse004_customer INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE quan = '"+key_quan+"' and phuong = '"+key_huyen + "' AND ffse004_bienlai.chuky BETWEEN '"+na+""+th+" '  AND '"+dna+""+dth+" '  ORDER BY  year , month  ASC");
							while (res.next()) {
								tb1.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
										res.getString("hoten"), res.getString("diachi"), res.getString("chuky"),
										res.getString("chisocongto"), res.getString("tinh_tien") });
							}
						}
					}
				}

				// chọn vào khách hàng cụ thể
				if (only_Customer.isSelected()) {	
					if (time.getSelection() == null) {
						JOptionPane.showMessageDialog(null, "vui lòng chọn khoảng thời gian cần xem !");
					} else {
						String key_mct="" ;
						res = conn.createStatement().executeQuery(
								"SELECT macongto FROM ffse004_customer WHERE macongto = '"+search_text.getText()+"' ");
						if (res.next()) {
							key_mct = res.getString("macongto");
						}else {
							JOptionPane.showMessageDialog(null, "Mã Công Tơ Không Tồn Tại . Vui Lòng Kiểm Tra Lại !");
						}
						// chọn theo năm 
						if (year_time.isSelected()) {						
							String key_y = (String) year_cb.getSelectedItem();
							res = conn.createStatement().executeQuery(
									"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chuky ,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien FROM ffse004_customer INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE ffse004_customer.macongto = '"+key_mct+"' and  year = '" + key_y + "'  ORDER BY  macongto ,year , month  ASC");
							while (res.next()) {
								tb1.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
										res.getString("hoten"), res.getString("diachi"), res.getString("chuky"),
										res.getString("chisocongto"), res.getString("tinh_tien") });
							}
						}

						// theo chu kỳ
						if (chuky_time.isSelected()) {							
							String key_m = (String) month_cb.getSelectedItem();
							String key_y = (String) year_kh_cb.getSelectedItem();

							res = conn.createStatement().executeQuery(
									"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chuky ,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien FROM ffse004_customer INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE ffse004_customer.macongto = '"+key_mct+"' and  month = '"+ key_m + "' and year = '" + key_y + "' ORDER BY  year , month  ASC");
							while (res.next()) {
								tb1.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
										res.getString("hoten"), res.getString("diachi"), res.getString("chuky"),
										res.getString("chisocongto"), res.getString("tinh_tien") });
							}
						}

						// theo khoảng thời gian
						if (theothoigian_time.isSelected()) {							
							String th = (String) cb_inMonth.getSelectedItem();
							String na = (String) cb_inYear.getSelectedItem();
							String dth =  (String) cb_toMonth.getSelectedItem();
							String dna = (String) cb_toYear.getSelectedItem();							
							res = conn.createStatement().executeQuery(
									"SELECT ffse004_customer.maKH,ffse004_customer.macongto,ffse004_customer.hoten,ffse004_customer.diachi,ffse004_bienlai.chuky ,ffse004_bienlai.chisocongto,ffse004_bienlai.tinh_tien FROM ffse004_customer INNER JOIN ffse004_bienlai ON ffse004_customer.macongto = ffse004_bienlai.macongto WHERE ffse004_customer.macongto = '"+key_mct+"' and ffse004_bienlai.chuky BETWEEN '"+na+""+th+" '  AND '"+dna+""+dth+" '  ORDER BY  year , month  ASC");
							while (res.next()) {
								tb1.addRow(new String[] { res.getString("maKH"), res.getString("macongto"),
										res.getString("hoten"), res.getString("diachi"), res.getString("chuky"),
										res.getString("chisocongto"), res.getString("tinh_tien") });
							}
						}

					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void addControls() {
		Container con = getContentPane();
		JPanel boxAll = new JPanel();
		con.add(boxAll);

		// cửa sổ thứ nhất
		JPanel window1 = new JPanel();
		window1.setLayout(new BoxLayout(window1, BoxLayout.Y_AXIS));
		
		// tiêu đề
		JLabel titleBox = new JLabel("Báo Cáo Danh Sách Khách Hàng");
		titleBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleBox.setFont(new Font("Courier New", Font.BOLD, 22));
		titleBox.setForeground(Color.red);
		window1.add(titleBox);
		
		// GridLayout
		JPanel boxTt = new JPanel();
		
		// hang 1
		quan = new JLabel("quận : ");
		quan.setHorizontalAlignment(SwingConstants.RIGHT);
		quan_cb = new JComboBox();
		boxTt.add(quan);
		boxTt.add(quan_cb);

		// dung database
		try {
			res = conn.createStatement().executeQuery(String.format("select * from ffse004_quan"));
			while (res.next()) {
				quan_cb.addItem(res.getString("tenquan"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// hang 2
		phuong = new JLabel("phường : ");
		phuong.setHorizontalAlignment(SwingConstants.RIGHT);
		phuong_cb = new JComboBox();
		// dung database
		try {
			res = conn.createStatement().executeQuery("select * from ffse004_phuong where maquan = '1'");
			while (res.next()) {
				phuong_cb.addItem(res.getString("tenphuong"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		quan_cb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					maqu = (String) quan_cb.getSelectedItem();
					phuong_cb.removeAllItems();
					try {
						res = conn.createStatement()
								.executeQuery("select maphuong from ffse004_quan where tenquan ='" + maqu + "'");
						if (res.next()) {
							maq = res.getString("maphuong");
							try {

								res = conn.createStatement()
										.executeQuery("select * from ffse004_phuong where maquan = '" + maq + "'");
								while (res.next()) {
									phuong_cb.addItem(res.getString("tenphuong"));

								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else {
							maq = "1";
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		boxTt.add(phuong);
		boxTt.add(phuong_cb);
		boxTt.setLayout(new GridLayout(1, 2, 40, 30));
		window1.add(boxTt);
		
		// button
		JPanel box_bt = new JPanel();
		bt_list = new JButton("In Danh Sách ");
		bt_home = new JButton("Home");
		bt_logOut = new JButton("Đăng Xuất");
		box_bt.add(bt_list);
		box_bt.add(bt_home);
		box_bt.add(bt_logOut);
		box_bt.setLayout(new FlowLayout());
		window1.add(box_bt);
		
		// table
		ds = new JLabel("danh sách : ");
		window1.add(ds);
		JPanel box6 = new JPanel();
		tb.addColumn("mã Khách Hàng  ");
		tb.addColumn("Tên ");
		tb.addColumn("Địa Chỉ");
		tb.addColumn("Số Điện Thoại");
		tb.addColumn("Mã Công Tơ");
		JScrollPane sc = new JScrollPane(tbl);
		box6.setLayout(new BorderLayout());
		box6.add(sc, BorderLayout.CENTER);
		window1.add(box6);

		// cửa sổ thứ 2
		JPanel window2 = new JPanel();
		window2.setLayout(new BoxLayout(window2, BoxLayout.Y_AXIS));
		
		// tiêu đề
		JLabel titleBox_2 = new JLabel("Báo Cáo Tình Hình Tiêu Thụ Điện");
		titleBox_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleBox_2.setFont(new Font("Courier New", Font.BOLD, 22));
		titleBox_2.setForeground(Color.red);
		window2.add(titleBox_2);

		// JRadioButton
		// box GridLayout
		JPanel box_jrb = new JPanel();
		box_jrb.setLayout(new GridLayout(1, 2, 10, 10));
		window2.add(box_jrb);

		// nhóm JRadioButton khách Hàng
		customer = new ButtonGroup();

		// box khách Hàng
		JPanel box_customer = new JPanel();
		box_customer.setLayout(new BoxLayout(box_customer, BoxLayout.Y_AXIS));
		box_jrb.add(box_customer);

		// button tất cả khách hàng
		All_Customer = new JRadioButton("Tất Cả Khách Hàng");
		All_Customer.setHorizontalAlignment(SwingConstants.RIGHT);
		customer.add(All_Customer);
		box_customer.add(All_Customer);

		// button theo quận và Phường
		// box quan phuong
		quanphuong_Customer = new JRadioButton("Khách Hàng theo quận và Phường ");
		quanphuong_Customer.setHorizontalAlignment(SwingConstants.RIGHT);
		customer.add(quanphuong_Customer);
		box_customer.add(quanphuong_Customer);

		// button theo khách hàng cụ thể
		only_Customer = new JRadioButton("một khách khàng cụ thể ");
		only_Customer.setHorizontalAlignment(SwingConstants.RIGHT);
		customer.add(only_Customer);
		box_customer.add(only_Customer);

		JPanel box_JRadio = new JPanel();

		// JComboBox
		JPanel Combobox_quanphuong_customer = new JPanel();

		// quan
		quan_customer = new JLabel("quận : ");
		Combobox_quanphuong_customer.add(quan_customer);
		quan_cb2 = new JComboBox();

		try {
			res = conn.createStatement().executeQuery(String.format("select * from ffse004_quan"));
			while (res.next()) {
				quan_cb2.addItem(res.getString("tenquan"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Combobox_quanphuong_customer.add(quan_cb2);
		// phuong
		phuong_customer = new JLabel("phường : ");
		phuong_cb2 = new JComboBox();
		
		// dung database
		try {
			res = conn.createStatement().executeQuery("select * from ffse004_phuong where maquan = '1'");
			while (res.next()) {
				phuong_cb2.addItem(res.getString("tenphuong"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		quan_cb2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					maqu = (String) quan_cb2.getSelectedItem();
					phuong_cb2.removeAllItems();
					try {
						res = conn.createStatement()
								.executeQuery("select maphuong from ffse004_quan where tenquan ='" + maqu + "'");
						if (res.next()) {
							maq = res.getString("maphuong");
							try {

								res = conn.createStatement()
										.executeQuery("select * from ffse004_phuong where maquan = '" + maq + "'");
								while (res.next()) {
									phuong_cb2.addItem(res.getString("tenphuong"));

								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else {
							maq = "1";
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		Combobox_quanphuong_customer.add(phuong_customer);
		Combobox_quanphuong_customer.add(phuong_cb2);

		box_JRadio.add(Combobox_quanphuong_customer);
		// sua tu day
		// tuỳ chọn ẩn hiện
		Combobox_quanphuong_customer.setVisible(false);

		quanphuong_Customer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Combobox_quanphuong_customer.setVisible(true);

				} else {
					Combobox_quanphuong_customer.setVisible(false);
				}
			}
		});
		// box tìm kiếm khách hàng cụ thể

		JPanel box_search_customer = new JPanel();
		JLabel nameKh = new JLabel("Mã Công Tơ  :");
		search_text = new JTextField(25);	
		box_search_customer.add(nameKh);
		box_search_customer.add(search_text);
		// hide or show 
		box_search_customer.setVisible(false);
		box_JRadio.add(box_search_customer);

		only_Customer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					box_search_customer.setVisible(true);

				} else {
					box_search_customer.setVisible(false);
				}
			}
		});
		// box time

		JPanel box_time = new JPanel();
		box_time.setLayout(new BoxLayout(box_time, BoxLayout.Y_AXIS));
		box_jrb.add(box_time);
		// nhóm JRadioButton theo thời gian
		time = new ButtonGroup();

		// button theo năm
		year_time = new JRadioButton("Năm");
		time.add(year_time);
		box_time.add(year_time);
		// button Theo khoảng thời gian
		theothoigian_time = new JRadioButton("Theo khoảng thời gian");
		time.add(theothoigian_time);
		box_time.add(theothoigian_time);
		// button theo chu kỳ
		chuky_time = new JRadioButton("chu kỳ ");
		time.add(chuky_time);
		box_time.add(chuky_time);

		// JComboBox nam
		JPanel box_year = new JPanel();
		box_JRadio.add(box_year);
		year = new JLabel("năm : ");
		String y[] = { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029",
				"2030" };
		year_cb = new JComboBox(y);
		box_year.add(year);
		box_year.add(year_cb);
		box_year.setVisible(false);
		year_time.addItemListener(new ItemListener() {
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
		box_JRadio.add(box_khoang);
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
		theothoigian_time.addItemListener(new ItemListener() {
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
		box_JRadio.add(box_chuky);
		// tháng
		month = new JLabel("tháng : ");
		String m3[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		month_cb = new JComboBox(m3);
		box_chuky.add(month);
		box_chuky.add(month_cb);
		// năm
		year_kh = new JLabel("năm : ");
		String y_kh3[] = { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028",
				"2029", "2030" };
		year_kh_cb = new JComboBox(y_kh3);
		box_chuky.add(year_kh);
		box_chuky.add(year_kh_cb);
		box_chuky.setVisible(false);
		chuky_time.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					box_chuky.setVisible(true);
				} else {
					box_chuky.setVisible(false);
				}
			}
		});

		window2.add(box_JRadio);
		box_JRadio.setLayout(new BoxLayout(box_JRadio, BoxLayout.Y_AXIS));
		// JButton
		// button
		JPanel box_6 = new JPanel();
		bt_list_wd2 = new JButton("In Danh Sách ");
		bt_home_wd2 = new JButton("Home");
		bt_logOut_wd2 = new JButton("Đăng Xuất");
		box_6.add(bt_list_wd2);
		box_6.add(bt_home_wd2);
		box_6.add(bt_logOut_wd2);
		window2.add(box_6);
		// table
		ds = new JLabel("danh sách : ");
		window2.add(ds);
		JPanel box7 = new JPanel();
		tb1.addColumn("mã Khách Hàng  ");
		tb1.addColumn("Mã Công Tơ ");
		tb1.addColumn("Tên ");
		tb1.addColumn("Địa Chỉ");
		tb1.addColumn("chu kỳ ");
		tb1.addColumn("chỉ số công tơ");
		tb1.addColumn("tiền điện ");

		JScrollPane sc1 = new JScrollPane(tbl1);
		// box7.setLayout(new BorderLayout());
		box7.add(sc1, BorderLayout.CENTER);
		window2.add(box7);
		// ket thuc

		JTabbedPane tp = new JTabbedPane();
		tp.setBounds(0, 0, 550, 550);
		tp.add("Báo Cáo Danh Sách Khách Hàng", window1); // thêm tên và cửa sổ
		tp.add("Báo Cáo Tình Hình Tiêu Thụ Điện", window2);
		boxAll.add(tp);
	}

	public void hienthi_bc() throws ExceptionMD{
		
		if(ex.chkLogin(loginUI.login)) {
			JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập trước");
			loginUI myUI = new loginUI();
			myUI.showWindow();
			this.dispose();
		}else {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	}

}
