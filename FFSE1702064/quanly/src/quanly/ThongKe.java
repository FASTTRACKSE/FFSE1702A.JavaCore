package quanly;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import quanly.TinhTien.Item;
import quanly.model.SinhVien;
import quanly.model.database;

public class ThongKe extends JFrame {
	int mqu,mquan;
	database db, db1,db2;
	Connection con;
	String makh, tenkh;
	String tenquan, tenphuong;
    JButton indanhsach,back;
	public ThongKe() {
		db = new database();
		con = db.connectSQL();
	}

	ActionListener cboQuanChange = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			updatePhuong();
		}
	};

	public void updatePhuong() {
		comboboxphuong.removeAllItems();
		try {
			ResultSet res;
			db1 = new database();
			Connection conn = db.connectSQL();
			// System.out.println(conn);
			Statement sttm = (Statement) conn.createStatement();
			mqu = ((Item) comboboxquan.getSelectedItem()).getId();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// System.out.println(mqu);
		try {
			ResultSet res;
			db = new database();
			Connection conn = db1.connectSQL();
			Statement sttm = (Statement) conn.createStatement();
			res = sttm.executeQuery("SELECT TenPhuong FROM `Phuong` INNER JOIN Quan ON Phuong.MaQuan = '" + mqu
					+ "'  AND Quan.MaQuan = '" + mqu + "'");
			while (res.next()) {
				comboboxphuong.addItem(res.getString("TenPhuong"));

			}
			tenquan = ((Item) comboboxquan.getSelectedItem()).getDescription();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	ActionListener cboQuan = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			updatePhuong2();
		}
	};

	public void updatePhuong2() {
		comboboxphuong2.removeAllItems();
		try {
			ResultSet res;
			db2 = new database();
			Connection conn = db.connectSQL();
			// System.out.println(conn);
			Statement sttm = (Statement) conn.createStatement();
			mquan = ((Item) comboboxquan2.getSelectedItem()).getId();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// System.out.println(mqu);
		try {
			ResultSet res;
			db = new database();
			Connection conn = db2.connectSQL();
			Statement sttm = (Statement) conn.createStatement();
			res = sttm.executeQuery("SELECT TenPhuong FROM `Phuong` INNER JOIN Quan ON Phuong.MaQuan = '" + mquan
					+ "'  AND Quan.MaQuan = '" + mquan + "'");
			while (res.next()) {
				comboboxphuong2.addItem(res.getString("TenPhuong"));

			}
//			tenquan = ((Item) comboboxquan2.getSelectedItem()).getDescription();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	ActionListener eventIn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			In();
		}

		public void In() {
			try {
				ResultSet res;
//				System.out.println("SELECT MaKH, TenKH,Quan,Phuong,DiaChi,Phone FROM KhachHang where Quan= '" + tenquan
//						+ "' AND Phuong='" + comboboxphuong.getSelectedItem() + "'");
				res = con.createStatement()
						.executeQuery("SELECT MaKH, TenKH,Quan,Phuong,DiaChi,Phone FROM KhachHang where Quan= '"
								+ tenquan + "' AND Phuong='" + comboboxphuong.getSelectedItem() + "'");
				while (res.next()) {
					table2.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"), res.getString("Quan"),
							res.getString("Phuong"), res.getString("DiaChi"), res.getString("Phone") });
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	ActionListener thongkedanhsach = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			thongkedanhsach();
		}
		public void thongkedanhsach() {
			// Xóa table
			int row = table1.getRowCount();
			if (row > 0) {
				table1.setRowCount(0);
			}
			if (buttongroupanelChinhTrang2.getSelection() == null) {
				JOptionPane.showMessageDialog(null, "vui lòng chọn đối tượng cần xem !");
			} else {
				try {

					// nếu chọn vào tất cả khách hàng
					if (allcustomer.isSelected()) {
						// nếu chọn all thì .....
						

						if (buttongroupanelChinhTrang1.getSelection() == null) {
							JOptionPane.showMessageDialog(null, "vui lòng chọn khoảng thời gian cần xem !");
						} else {

							// nếu chọn theo năm thì ....
							if (year.isSelected()) {
								// xoa table:
								row = table1.getRowCount();
								if (row > 0) {
									table1.setRowCount(0);
								}
								String key_y = (String) cbnamhet.getSelectedItem();
								ResultSet res;
								db = new database();
								Connection conn = db.connectSQL();
								Statement sttm = (Statement) conn.createStatement();
								res = conn.createStatement().executeQuery(
										"SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE Nam = '"
												+ key_y + "' ORDER BY Nam , Thang  ASC");
								while (res.next()) {
									table1.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"),
											res.getString("DiaChi"), res.getString("Sotien")
											 });
								}
							}

							// theo chu kỳ
							if (theochuky.isSelected()) {
								// xoa table:
								row = table1.getRowCount();
								if (row > 0) {
									table1.setRowCount(0);
								}

								String key_m = (String) cbthangkt.getSelectedItem();
								String key_y = (String) cbnamhet.getSelectedItem();
								ResultSet res;
								db = new database();
								Connection conn = db.connectSQL();
								Statement sttm = (Statement) conn.createStatement();
								res = conn.createStatement().executeQuery(
										"SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN bienlai ON KhachHang.MaCT = BienLai.MaCT WHERE Thang = '"
												+ key_m + "' and Nam = '" + key_y + "' ORDER BY  Nam , Thang  ASC");
								while (res.next()) {
									table1.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"),
											res.getString("DiaChi"), res.getString("Sotien")
											 });
								}
							}

							// theo khoảng thời gian

							if (khoangthoigian.isSelected()) {
								// xoa table:
								row = table1.getRowCount();
								if (row > 0) {
									table1.setRowCount(0);
								}
								String th = (String) cbthangbd.getSelectedItem();
								String na = (String) cbnamdau.getSelectedItem();
								String dth =  (String) cbthangkt.getSelectedItem();
								String dna = (String) cbnamhet.getSelectedItem();
								ResultSet res;
								db = new database();
								Connection conn = db.connectSQL();
								Statement sttm = (Statement) conn.createStatement();
								System.out.println("SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE BienLai.ChuKy BETWEEN '"+na+""+th+" '  AND '"+dna+""+dth+" '  ORDER BY  Nam , Thang  ASC");
								res = conn.createStatement().executeQuery(
										"SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE BienLai.ChuKy BETWEEN '"+na+""+th+" '  AND '"+dna+""+dth+" '  ORDER BY  Nam , Thang  ASC");
								while (res.next()) {
									table1.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"),
											res.getString("DiaChi"), res.getString("Sotien")
											 });
								}
							}

						}
					}

					// nếu chọn vào quận huyện
					if (quanphuong.isSelected()) {	
						if (buttongroupanelChinhTrang1.getSelection() == null) {
							JOptionPane.showMessageDialog(null, "vui lòng chọn khoảng thời gian cần xem !");
						} else {

							// nếu chọn theo năm thì ....
							if (year.isSelected()) {
								// xoa table:
								row = table1.getRowCount();
								if (row > 0) {
									table1.setRowCount(0);
								}
								String key_quan = ((Item) comboboxquan2.getSelectedItem()).getDescription();
								String key_huyen = (String) comboboxphuong2.getSelectedItem();
								String key_y = (String) cbnamhet.getSelectedItem();
								ResultSet res;
								db = new database();
								Connection conn = db.connectSQL();
								Statement sttm = (Statement) conn.createStatement();
//								System.out.println("SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE KhachHang.Quan = '"+key_quan+"' and KhachHang.Phuong = '"+key_huyen + "' and BienLai.Nam = '"
//												+ key_y + "' ");
								res = conn.createStatement().executeQuery(
										"SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE KhachHang.Quan = '"+key_quan+"' and KhachHang.Phuong = '"+key_huyen + "' and BienLai.Nam = '"
												+ key_y + "'ORDER BY  Nam   ASC " );
								while (res.next()) {
									table1.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"),
											res.getString("DiaChi"), res.getString("Sotien")
											 });
								}
							}

							// theo chu kỳ
							if (theochuky.isSelected()) {
								// xoa table:
								row = table1.getRowCount();
								if (row > 0) {
									table1.setRowCount(0);
								}
								String key_quan = ((Item) comboboxquan2.getSelectedItem()).getDescription();
								String key_huyen = (String) comboboxphuong2.getSelectedItem();
								
								String key_m = (String) cbthangkt.getSelectedItem();
								String key_y = (String) cbnamhet.getSelectedItem();
								ResultSet res;
								db = new database();
								Connection conn = db.connectSQL();
								Statement sttm = (Statement) conn.createStatement();
								System.out.println("SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE KhachHang.Quan = '"+key_quan+"' and KhachHang.Phuong = '"+key_huyen + "' and BienLai.Thang = '"
												+ key_m + "' and BienLai.Nam = '" + key_y + "' ORDER BY  Nam , Thang  ASC");
								res = conn.createStatement().executeQuery(
										"SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE KhachHang.Quan = '"+key_quan+"' and KhachHang.Phuong = '"+key_huyen + "' and BienLai.Thang = '"
												+ key_m + "' and BienLai.Nam = '" + key_y + "' ORDER BY  Nam , Thang  ASC");
								while (res.next()) {
									table1.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"),
											res.getString("DiaChi"), res.getString("Sotien")
											 });
								}
							}

							// theo khoảng thời gian

							if (khoangthoigian.isSelected()) {
								// xoa table:
								row = table1.getRowCount();
								if (row > 0) {
									table1.setRowCount(0);
								}
								String key_quan = ((Item) comboboxquan2.getSelectedItem()).getDescription();
								String key_huyen = (String) comboboxphuong2.getSelectedItem();
								
								String th = (String) cbthangbd.getSelectedItem();
								String na = (String) cbnamdau.getSelectedItem();
								String dth =  (String) cbthangkt.getSelectedItem();
								String dna = (String) cbnamhet.getSelectedItem();	
								ResultSet res;
								db = new database();
								Connection conn = db.connectSQL();
								Statement sttm = (Statement) conn.createStatement();
//								System.out.print("SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE Quan = '"+key_quan+"' and Phuong = '"+key_huyen + "' AND BienLai.ChuKy BETWEEN '"+na+""+th+" '  AND '"+dna+""+dth+" '  ORDER BY  Nam   ASC");
								res = conn.createStatement().executeQuery(
										"SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE KhachHang.Quan = '"+key_quan+"' and KhachHang.Phuong = '"+key_huyen + "' AND BienLai.ChuKy BETWEEN '"+na+""+th+" '  AND '"+dna+""+dth+" '  ORDER BY  Nam   ASC");
								while (res.next()) {
									table1.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"),
											res.getString("DiaChi"), res.getString("Sotien")
											 });
								}
							}

						}
					}

					// nếu chọn vào khách hàng cụ thể
					if (selectcustomer.isSelected()) {	
						if (buttongroupanelChinhTrang1.getSelection() == null) {
							JOptionPane.showMessageDialog(null, "vui lòng chọn khoảng thời gian cần xem !");
						} else {
							String key_mct="" ;
							ResultSet res;
							db = new database();
							Connection conn = db.connectSQL();
							Statement sttm = (Statement) conn.createStatement();
							res = conn.createStatement().executeQuery(
									"SELECT MaCT FROM KhachHang WHERE MaCT = '"+JTFmaKH.getText()+"' ");
							if (res.next()) {
								key_mct = res.getString("MaCT");
							}else {
								JOptionPane.showMessageDialog(null, "Mã Công Tơ Không Tồn Tại . Vui Lòng Kiểm Tra Lại !");
							}
							// nếu chọn theo năm thì ....
							if (year.isSelected()) {
								// xoa table:
								row = table1.getRowCount();
								if (row > 0) {
									table1.setRowCount(0);
								}
							
								String key_y = (String) cbnamhet.getSelectedItem();
								res = conn.createStatement().executeQuery(
										"SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE KhachHang.MaCT = '"+key_mct+"' and  Nam = '" + key_y + "'  ORDER BY Nam , Thang  ASC");
								while (res.next()) {
									table1.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"),
											res.getString("DiaChi"), res.getString("Sotien")
											 });
								}
							}

							// theo chu kỳ
							if (theochuky.isSelected()) {
								// xoa table:
								row = table1.getRowCount();
								if (row > 0) {
									table1.setRowCount(0);
								}
								
								String key_m = (String) cbthangkt.getSelectedItem();
								String key_y = (String) cbnamhet.getSelectedItem();

								res = conn.createStatement().executeQuery(
										"SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE KhachHang.MaCT = '"+key_mct+"' and  Thang = '"+ key_m + "' and Nam = '" + key_y + "' ORDER BY  Nam , Thang  ASC");
								while (res.next()) {
									table1.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"),
											res.getString("DiaChi"), res.getString("Sotien")
											 });
								}
							}

							// theo khoảng thời gian

							if (khoangthoigian.isSelected()) {
								// xoa table:
								row = table1.getRowCount();
								if (row > 0) {
									table1.setRowCount(0);
								}							
								String th = (String) cbthangbd.getSelectedItem();
								String na = (String) cbnamdau.getSelectedItem();
								String dth =  (String) cbthangkt.getSelectedItem();
								String dna = (String) cbnamhet.getSelectedItem();	
//								System.out.println("SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE KhachHang.MaCT = '"+key_mct+"' and BienLai.ChuKy BETWEEN '"+na+""+th+" '  AND '"+dna+""+dth+" '  ORDER BY  Nam  ASC");
								res = conn.createStatement().executeQuery(
										"SELECT KhachHang.MaKH,KhachHang.TenKH,KhachHang.DiaChi,BienLai.Sotien FROM KhachHang INNER JOIN BienLai ON KhachHang.MaCT = BienLai.MaCT WHERE KhachHang.MaCT = '"+key_mct+"' and BienLai.ChuKy BETWEEN '"+na+""+th+" '  AND '"+dna+""+dth+" '  ORDER BY  Nam  ASC");
								while (res.next()) {
									table1.addRow(new String[] { res.getString("MaKH"), res.getString("TenKH"),
											res.getString("DiaChi"), res.getString("Sotien")
											 });
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
		
	};
	public ThongKe(String tieude) {
		super(tieude);
		addControls();
		addEvents();
		db = new database();
		con = db.connectSQL();
	}

	DefaultTableModel table1 = new DefaultTableModel();
	DefaultTableModel table2 = new DefaultTableModel();
	JTable tb1, tbt_back;
	JScrollPane sc, sc1;
	JLabel quan, phuong, ds1,maKH;
	JButton buttonIn, bt_back;
	ButtonGroup buttongroupanelChinhTrang2 = new ButtonGroup();
	ButtonGroup buttongroupanelChinhTrang1 = new ButtonGroup();
	JComboBox comboboxquan = new JComboBox(), comboboxphuong = new JComboBox();
	JComboBox comboboxquan2 = new JComboBox(), comboboxphuong2 = new JComboBox();
	JTextField JTFmaKH;
	JComboBox cbthangbd,cbnamdau,cbthangkt,cbnamhet;
	JRadioButton allcustomer, quanphuong, selectcustomer, year, khoangthoigian, theochuky;
	JLabel ds;
	DefaultTableModel table = new DefaultTableModel();
	JTable tb;
	JFrame f;

	public void addControls() {
		Container con = getContentPane();
		JPanel panelChinhTrang2 = new JPanel();
		panelChinhTrang2.setLayout(new BoxLayout(panelChinhTrang2, BoxLayout.Y_AXIS));
		JPanel boxtong = new JPanel();
		boxtong.setLayout(new BoxLayout(boxtong, BoxLayout.Y_AXIS));
		JPanel box = new JPanel();
		box.setLayout(new GridLayout(1, 2, 5, 5));

		JPanel title = new JPanel();
		JLabel Title = new JLabel("Tình hình tiêu thụ điện");
		Font fonttitle = new Font("Arial", Font.BOLD, 30);
		Title.setFont(fonttitle);
		title.add(Title);
		// Group đầu tiên
		JPanel groupDoiTuong = new JPanel();
		groupDoiTuong.setLayout(new BoxLayout(groupDoiTuong, BoxLayout.Y_AXIS));
		allcustomer = new JRadioButton("Tất cả khách hàng");
		quanphuong = new JRadioButton("Theo quận và phường");
		selectcustomer = new JRadioButton("Theo khách hàng cụ thể");
		buttongroupanelChinhTrang2 = new ButtonGroup();
		buttongroupanelChinhTrang2.add(allcustomer);
		buttongroupanelChinhTrang2.add(quanphuong);
		buttongroupanelChinhTrang2.add(selectcustomer);
		groupDoiTuong.add(allcustomer);
		groupDoiTuong.add(quanphuong);
		groupDoiTuong.add(selectcustomer);
		// Quận và phường trang thứ 2
		JPanel quanandphuong = new JPanel();
		maKH = new JLabel("Mã Công Tơ");
		JTFmaKH = new JTextField(15);
		quan = new JLabel("Quận");
		comboboxquan2.addActionListener(cboQuan);

		try {

			ResultSet res;
			db = new database();
			Connection conn = db.connectSQL();
			Statement sttm = (Statement) conn.createStatement();
			res = sttm.executeQuery("SELECT * FROM `Quan`");
			while (res.next()) {
				comboboxquan2.addItem(new Item(res.getInt("MaQuan"), res.getString("TenQuan")));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		phuong = new JLabel("Phường");
		updatePhuong2();
        quanandphuong.add(maKH);
        quanandphuong.add(JTFmaKH);
		quanandphuong.add(quan);
		quanandphuong.add(comboboxquan2);
		quanandphuong.add(phuong);
		quanandphuong.add(comboboxphuong2);
		// Tùy chọn ẩn hiện group thứ 1
		maKH.setVisible(false);
		JTFmaKH.setVisible(false);
		quan.setVisible(false);
		comboboxquan2.setVisible(false);
		phuong.setVisible(false);
		comboboxphuong2.setVisible(false);
		quanphuong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					quan.setVisible(true);
					comboboxquan2.setVisible(true);
					phuong.setVisible(true);
					comboboxphuong2.setVisible(true);
				} else {
					maKH.setVisible(false);
					JTFmaKH.setVisible(false);
					quan.setVisible(false);
					comboboxquan2.setVisible(false);
					phuong.setVisible(false);
					comboboxphuong2.setVisible(false);
				}
			}
			});
		selectcustomer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					maKH.setVisible(true);
					JTFmaKH.setVisible(true);
				} else {
					maKH.setVisible(false);
					JTFmaKH.setVisible(false);
					quan.setVisible(false);
					comboboxquan2.setVisible(false);
					phuong.setVisible(false);
					comboboxphuong2.setVisible(false);
				}
			}
			});
		JPanel panelThoiGian = new JPanel();
		panelThoiGian.setLayout(new BoxLayout(panelThoiGian, BoxLayout.Y_AXIS));
		year = new JRadioButton("Theo năm");
		khoangthoigian = new JRadioButton("Theo khoảng thời gian");
		theochuky = new JRadioButton("Chu kỳ");
		buttongroupanelChinhTrang1 = new ButtonGroup();
		buttongroupanelChinhTrang1.add(year);
		buttongroupanelChinhTrang1.add(khoangthoigian);
		buttongroupanelChinhTrang1.add(theochuky);
		panelThoiGian.add(year);
		panelThoiGian.add(khoangthoigian);
		panelThoiGian.add(theochuky);
		// Thêm vào
		//Cho hiển thị theo năm
		String namketthuc[] = { "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
				"2020" };
		String nambatdau[] = { "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
		"2020" };
		String thangbatdau[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		String thangketthuc[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		cbthangbd = new JComboBox(thangbatdau);
		cbnamdau = new JComboBox(nambatdau);
		cbthangkt = new JComboBox(thangketthuc);
		cbnamhet = new JComboBox(namketthuc);
		JLabel text = new JLabel("Từ");
		JLabel thangg = new JLabel("Tháng");
		JLabel thanggg = new JLabel("Tháng");
		JLabel den = new JLabel("Đến");
		JLabel namm=new JLabel("Năm");
		JLabel nammm=new JLabel("Năm");

		JPanel pnanhien = new JPanel();
		pnanhien.add(text);
		pnanhien.add(thanggg);
		pnanhien.add(cbthangbd);
		pnanhien.add(nammm);
		pnanhien.add(cbnamdau);
		pnanhien.add(den);
		pnanhien.add(thangg);
		pnanhien.add(cbthangkt);
		pnanhien.add(namm);
		pnanhien.add(cbnamhet);
		
		
		// tuỳ chọn ẩn hiện group thứ 2
		cbnamhet.setVisible(false);
		text.setVisible(false);
		thangg.setVisible(false);
		thanggg.setVisible(false);
		cbthangbd.setVisible(false);
		den.setVisible(false);
		namm.setVisible(false);
		cbnamdau.setVisible(false);
		cbthangkt.setVisible(false);
		nammm.setVisible(false);
		cbnamhet.setVisible(false);
	khoangthoigian.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				cbnamhet.setVisible(true);
				namm.setVisible(true);
				text.setVisible(true);
				thangg.setVisible(true);
				thanggg.setVisible(true);
				cbthangbd.setVisible(true);
				cbnamdau.setVisible(true);
				cbthangkt.setVisible(true);
				nammm.setVisible(true);
				den.setVisible(true);
			} else {
				cbnamhet.setVisible(false);
				text.setVisible(false);
				thangg.setVisible(false);
				thanggg.setVisible(false);
				cbthangbd.setVisible(false);
				namm.setVisible(false);
				cbnamdau.setVisible(false);
				cbthangkt.setVisible(false);
				nammm.setVisible(false);
				cbnamhet.setVisible(false);
				den.setVisible(false);
			}
		}
		});
	year.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				cbnamhet.setVisible(true);
				namm.setVisible(true);
			} else {
				cbnamhet.setVisible(false);
				text.setVisible(false);
				thangg.setVisible(false);
				thanggg.setVisible(false);
				cbthangbd.setVisible(false);
				namm.setVisible(false);
				cbnamdau.setVisible(false);
				cbthangkt.setVisible(false);
				nammm.setVisible(false);
				cbnamhet.setVisible(false);
				den.setVisible(false);
			}
		}
		});
	theochuky.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				thangg.setVisible(true);
				cbthangkt.setVisible(true);
				namm.setVisible(true);
				cbnamhet.setVisible(true);
			} else {
				cbnamhet.setVisible(false);
				text.setVisible(false);
				thangg.setVisible(false);
				thanggg.setVisible(false);
				cbthangbd.setVisible(false);
				namm.setVisible(false);
				cbnamdau.setVisible(false);
				cbthangkt.setVisible(false);
				nammm.setVisible(false);
				cbnamhet.setVisible(false);
				den.setVisible(false);
			}
		}
		});
		//Cho hiển thị theo khoảng thời gian
		//Thêm các Button
		JPanel thembutton = new JPanel();
		indanhsach = new JButton("In dữ liệu");
		back = new JButton("Back");
		thembutton.add(indanhsach);
		thembutton.add(back);
		// Box thứ 3
		JPanel tableThongKe = new JPanel();
		ds1 = new JLabel("Tình hình tiêu thụ");
		Font fontds = new Font("Arial", Font.BOLD, 30);
		ds1.setFont(fontds);
		JPanel boxtb = new JPanel();
		table1.addColumn("Mã Khách hàng");
		table1.addColumn("Tên Khách hàng");
		table1.addColumn("Địa chỉ");
		table1.addColumn("Tình hình tiêu thụ");
		tb1 = new JTable(table1);
		sc = new JScrollPane(tb1);
		Container con1 = getContentPane();
		con1.setLayout(new BorderLayout());
		// con1.add(sc, BorderLayout.CENTER);
		// boxtb.add(sc);
		tableThongKe.add(boxtb);
		box.add(groupDoiTuong);
		box.add(panelThoiGian);
		boxtong.add(title);
		boxtong.add(box);
		boxtong.add(tableThongKe);
		boxtong.add(quanandphuong);
		boxtong.add(pnanhien);
		panelChinhTrang2.add(boxtong);
		panelChinhTrang2.add(thembutton);
		panelChinhTrang2.add(ds1);
		panelChinhTrang2.add(sc);

		JPanel panelChinhTrang1 = new JPanel();
		panelChinhTrang1.setLayout(new BoxLayout(panelChinhTrang1, BoxLayout.Y_AXIS));
		JPanel Panelchinh = new JPanel();

		// cai dat cach sap xep
		Panelchinh.setLayout(new BoxLayout(Panelchinh, BoxLayout.Y_AXIS));
		// tieu de
		JPanel Title1 = new JPanel();
		JLabel LTitle = new JLabel("Tình hinh tiêu thụ");
		Font fonttitle1 = new Font("Arial", Font.BOLD, 20);
		LTitle.setFont(fonttitle1);
		Title1.add(LTitle);
		// ket thuc tieu de

		// Quận và phường
		JPanel panelQuanandPhuong = new JPanel();
		quan = new JLabel("Quận");
		comboboxquan.addActionListener(cboQuanChange);

		try {

			ResultSet res;
			db = new database();
			Connection conn = db.connectSQL();
			Statement sttm = (Statement) conn.createStatement();
			res = sttm.executeQuery("SELECT * FROM `Quan`");
			while (res.next()) {
				comboboxquan.addItem(new Item(res.getInt("MaQuan"), res.getString("TenQuan")));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		phuong = new JLabel("Phường");
		updatePhuong();

		panelQuanandPhuong.add(quan);
		panelQuanandPhuong.add(comboboxquan);
		panelQuanandPhuong.add(phuong);
		panelQuanandPhuong.add(comboboxphuong);
		// Button
		JPanel panelButton = new JPanel();
		buttonIn = new JButton("In ra");
		bt_back = new JButton("Back");
		panelButton.add(buttonIn);
		panelButton.add(bt_back);
		// Bảng danh sách khách hàng
		JPanel panelDSKH = new JPanel();
		ds1 = new JLabel("Danh sách khách hàng");
		Font fonttitle2 = new Font("Arial", Font.BOLD, 20);
		ds1.setFont(fonttitle2);
		JPanel boxtb1 = new JPanel();
		table2.addColumn("Mã Khách hàng");
		table2.addColumn("Tên Khách hàng");
		table2.addColumn("Quận");
		table2.addColumn("Phường");
		table2.addColumn("Địa chỉ");
		table2.addColumn("Số điện thoại");
		tbt_back = new JTable(table2);
		// tbt_back.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sc1 = new JScrollPane(tbt_back);
		// Container con11 = getContentPane();
		// con11.setLayout(new BorderLayout());
		// con11.add(sc1, BorderLayout.CENTER);
		// boxtb1.add(sc1);
		panelDSKH.add(boxtb1);

		// Thêm vào hộp chính
		Panelchinh.add(panelQuanandPhuong);
		
		Panelchinh.add(panelButton);
		Panelchinh.add(ds1);
		Panelchinh.add(panelDSKH);

		panelChinhTrang1.add(Panelchinh);
		panelChinhTrang1.add(sc1);
		JTabbedPane tp = new JTabbedPane();
		tp.setBounds(100, 100, 600, 600);
		tp.add("Danh sách khách hàng", panelChinhTrang1);
		tp.add("Tình hình tiêu thụ", panelChinhTrang2);
		con.add(tp);
	}

	ActionListener eventback = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			menu_back();
		}
	};

	public void menu_back() {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				/* ignored */}
		}
		// this.setVisible(false); //you can't see me!
		this.dispose();
		Home myUI = new Home("Khách Hàng");
		myUI.showWindow();
	}

	// even
	public void addEvents() {
		buttonIn.addActionListener(eventIn);
		bt_back.addActionListener(eventback);
		back.addActionListener(eventback);
		indanhsach.addActionListener(thongkedanhsach);
	}

	public void showWindow() {
		this.setSize(800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	class Item {

		private int id;
		private String description;

		public Item(int id, String description) {
			this.id = id;
			this.description = description;
		}

		public int getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}

		@Override
		public String toString() {
			return description;
		}
	}
	
}
