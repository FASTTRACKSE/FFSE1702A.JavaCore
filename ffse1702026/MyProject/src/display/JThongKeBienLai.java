package display;

import java.awt.*;
import com.toedter.calendar.JMonthChooser;

import database.DBBienLai;
import database.dbKhachHang;
import database.phuong;
import database.quan;
import object.BienLai;
import object.KhachHang;
import object.MyException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JThongKeBienLai extends JFrame {

	private JPanel pnmain;
	private JTable tablekhachhang;
	private JPanel brandpanel;
	private JPanel inputpanel;

	private JPanel buttonpanel;
	private JButton btnback;
	private JPanel panelid;
	private JPanel panelquanphuong;
	private JPanel panelall;
	private JPanel panelmau;
	private JPanel panel;
	private JPanel panelsearch;
	private JLabel lblTmKimTheo;
	private JPanel panelsearchdate;
	private JLabel lblTmKimTheo_1;
	private JPanel panelchoicesearch;

	private JComboBox cbTime;
	private JPanel panelsearchtime;
	private JPanel panelfindchuky;
	private JPanel panelfindnam;
	private JPanel panelfindkhoangtime;
	private JLabel lblChuKyThang;
	private JComboBox cbThangChuKy;
	private JLabel labelNamChuKy;
	private JTextField jtNamChuKy;
	private JLabel lbNam;
	private JTextField jtNam;
	private JLabel labelThangFrom;
	private JComboBox cbThangFrom;
	private JLabel lbNamFrom;
	private JTextField jtNamFrom;
	private JLabel labelThangTo;
	private JComboBox cbThangTo;
	private JLabel lbNamTo;
	private JTextField jtNamTo;
	private JPanel panelMau;
	private JPanel panelchoiceKH;
	private JComboBox cbChoiceKH;
	private JLabel lbAll;
	private JLabel lbQuan;
	private JComboBox cbQuan;
	private JCheckBox lbPhuong;
	private JComboBox cbPhuong;
	private JLabel lbMaKH;
	private JTextField jtMaKhachHang;
	private JPanel panelsubmit;
	private JButton btSubmit;
	String[] monhtmodel = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	String[] tieude = { "Mã Công Tơ", "Họ Tên", "Địa Chỉ", "Ngày Nhập", "Chu kỳ", "Chỉ Số Củ", "Chỉ Số Mới",
			"Tổng số điện", "Tổng Tiền" };
	DefaultTableModel modelTable = new DefaultTableModel(tieude, 0);

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JThongKeBienLai frame = new JThongKeBienLai();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public JThongKeBienLai() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("b.jpg"));

		setTitle("ỨNG DỤNG QUẢN LÝ TIỀN ĐIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 650);

		pnmain = new JPanel();
		pnmain.setBackground(SystemColor.controlHighlight);

		setContentPane(pnmain);

		pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		brandpanel = new JPanel();
		pnmain.add(brandpanel);
		brandpanel.setLayout(new BoxLayout(brandpanel, BoxLayout.X_AXIS));

		JLabel lblbrand = new JLabel("Thống Kê Biên Lai");
		lblbrand.setBackground(SystemColor.controlHighlight);
		brandpanel.add(lblbrand);
		lblbrand.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblbrand.setForeground(new Color(102, 51, 0));
		lblbrand.setFont(new Font("Times New Roman", Font.BOLD, 32));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panelsearch = new JPanel();
		panelsearch.setBackground(SystemColor.controlHighlight);
		pnmain.add(panelsearch);
		panelsearch.setLayout(new BoxLayout(panelsearch, BoxLayout.X_AXIS));

		lblTmKimTheo = new JLabel("Tìm Kiếm Theo Khách Hàng");
		lblTmKimTheo.setForeground(new Color(102, 51, 0));
		lblTmKimTheo.setBackground(SystemColor.controlHighlight);
		lblTmKimTheo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelsearch.add(lblTmKimTheo);

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panelchoiceKH = new JPanel();
		pnmain.add(panelchoiceKH);

		cbChoiceKH = new JComboBox();
		cbChoiceKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbChoiceKH.getSelectedItem().toString().equals("Tất cả khách hàng")) {
					inputpanel.removeAll();
					inputpanel.add(panelall);
					inputpanel.repaint();
					inputpanel.revalidate();

				} else if (cbChoiceKH.getSelectedItem().toString().equals("Theo Quận - Phường")) {
					inputpanel.removeAll();
					inputpanel.add(panelquanphuong);
					inputpanel.repaint();
					inputpanel.revalidate();

				} else if (cbChoiceKH.getSelectedItem().toString().equals("Theo mã khách hàng")) {
					inputpanel.removeAll();
					inputpanel.add(panelid);
					inputpanel.repaint();
					inputpanel.revalidate();

				} else if (cbChoiceKH.getSelectedItem().toString().equals("-- Chọn --")) {
					inputpanel.removeAll();
					inputpanel.add(panelMau);
					inputpanel.repaint();
					inputpanel.revalidate();

				}

			}
		});
		cbChoiceKH.setModel(new DefaultComboBoxModel(
				new String[] { "-- Chọn --", "Tất cả khách hàng", "Theo Quận - Phường", "Theo mã khách hàng" }));
		panelchoiceKH.add(cbChoiceKH);

		inputpanel = new JPanel();
		inputpanel.setMaximumSize(new Dimension(1800, 150));
		inputpanel.setBackground(SystemColor.controlHighlight);

		pnmain.add(inputpanel);
		inputpanel.setLayout(new CardLayout(0, 0));

		panelmau = new JPanel();
		panelmau.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelmau, "name_56184463025521");
		panelmau.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panelall = new JPanel();
		panelall.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelall, "name_56184501105112");
		panelall.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lbAll = new JLabel("Tất cả khách hàng");
		panelall.add(lbAll);
		lbAll.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lbAll.setForeground(new Color(107, 142, 35));

		panelquanphuong = new JPanel();
		panelquanphuong.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelquanphuong, "name_56184530705506");
		panelquanphuong.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lbQuan = new JLabel("Quận");
		lbQuan.setForeground(new Color(107, 142, 35));
		lbQuan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelquanphuong.add(lbQuan);
		ArrayList<String> arrQuan = quan.getQuan();

		cbQuan = new JComboBox(arrQuan.toArray());
		cbQuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quanSelect = cbQuan.getSelectedItem().toString();
				try {

					ArrayList<String> arrphuong = phuong.getPhuong(quanSelect);
					cbPhuong.setModel(new DefaultComboBoxModel(arrphuong.toArray()) {
					});
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelquanphuong.add(cbQuan);

		lbPhuong = new JCheckBox("Phường");
		lbPhuong.setForeground(new Color(107, 142, 35));
		lbPhuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelquanphuong.add(lbPhuong);

		cbPhuong = new JComboBox();
		cbPhuong.setModel(new DefaultComboBoxModel(new String[] { "Bình Hiên", "Bình Thuận", "Hải Châu 1", "Hải Châu 2",
				"Hòa Cường Bắc", "Hòa Cường Nam" }));
		panelquanphuong.add(cbPhuong);

		panelid = new JPanel();
		panelid.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelid, "name_56184579511683");
		panelid.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lbMaKH = new JLabel("Mã Khách Hàng");
		lbMaKH.setForeground(new Color(107, 142, 35));
		lbMaKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelid.add(lbMaKH);

		jtMaKhachHang = new JTextField();
		panelid.add(jtMaKhachHang);
		jtMaKhachHang.setColumns(10);

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panelsearchdate = new JPanel();
		panelsearchdate.setBackground(SystemColor.controlHighlight);
		pnmain.add(panelsearchdate);
		panelsearchdate.setLayout(new BoxLayout(panelsearchdate, BoxLayout.X_AXIS));

		lblTmKimTheo_1 = new JLabel("Tìm Kiếm Theo Thời Gian");
		lblTmKimTheo_1.setForeground(new Color(102, 51, 0));
		lblTmKimTheo_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		panelsearchdate.add(lblTmKimTheo_1);

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panelchoicesearch = new JPanel();
		pnmain.add(panelchoicesearch);
		panelchoicesearch.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		cbTime = new JComboBox();
		cbTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbTime.getSelectedItem().toString().equals("Theo chu kỳ")) {
					panelsearchtime.removeAll();
					panelsearchtime.add(panelfindchuky);
					panelsearchtime.repaint();
					panelsearchtime.revalidate();

				} else if (cbTime.getSelectedItem().toString().equals("Theo Năm")) {
					panelsearchtime.removeAll();
					panelsearchtime.add(panelfindnam);
					panelsearchtime.repaint();
					panelsearchtime.revalidate();

				} else if (cbTime.getSelectedItem().toString().equals("Theo khoảng thời gian")) {
					panelsearchtime.removeAll();
					panelsearchtime.add(panelfindkhoangtime);
					panelsearchtime.repaint();
					panelsearchtime.revalidate();

				} else if (cbTime.getSelectedItem().toString().equals("-- Chọn Khoảng thời gian --")) {
					panelsearchtime.removeAll();
					panelsearchtime.add(panelMau);
					panelsearchtime.repaint();
					panelsearchtime.revalidate();

				}
			}
		});
		panelchoicesearch.add(cbTime);
		cbTime.setModel(new DefaultComboBoxModel(
				new String[] { "-- Chọn Khoảng thời gian --", "Theo chu kỳ", "Theo Năm", "Theo khoảng thời gian" }));

		panelsearchtime = new JPanel();
		pnmain.add(panelsearchtime);
		panelsearchtime.setLayout(new CardLayout(0, 0));

		panelMau = new JPanel();
		panelsearchtime.add(panelMau, "name_54941959410412");

		panelfindchuky = new JPanel();
		panelsearchtime.add(panelfindchuky, "name_124545777547730");

		lblChuKyThang = new JLabel("Chu kỳ Tháng");
		panelfindchuky.add(lblChuKyThang);

		cbThangChuKy = new JComboBox(monhtmodel);
		panelfindchuky.add(cbThangChuKy);

		labelNamChuKy = new JLabel("Năm");
		panelfindchuky.add(labelNamChuKy);

		jtNamChuKy = new JTextField();
		jtNamChuKy.setColumns(10);
		panelfindchuky.add(jtNamChuKy);

		panelfindnam = new JPanel();
		panelsearchtime.add(panelfindnam, "name_124545794320307");

		lbNam = new JLabel("Theo Năm");
		panelfindnam.add(lbNam);

		jtNam = new JTextField();
		jtNam.setColumns(10);
		panelfindnam.add(jtNam);

		panelfindkhoangtime = new JPanel();
		panelsearchtime.add(panelfindkhoangtime, "name_124545809498832");

		labelThangFrom = new JLabel("Khoảng Thời Gian Từ Tháng");
		panelfindkhoangtime.add(labelThangFrom);

		cbThangFrom = new JComboBox(monhtmodel);
		panelfindkhoangtime.add(cbThangFrom);

		lbNamFrom = new JLabel("Năm");
		panelfindkhoangtime.add(lbNamFrom);

		jtNamFrom = new JTextField();
		jtNamFrom.setColumns(10);
		panelfindkhoangtime.add(jtNamFrom);

		labelThangTo = new JLabel("Đến Tháng");
		panelfindkhoangtime.add(labelThangTo);

		cbThangTo = new JComboBox(monhtmodel);
		panelfindkhoangtime.add(cbThangTo);

		lbNamTo = new JLabel("Năm");
		panelfindkhoangtime.add(lbNamTo);

		jtNamTo = new JTextField();
		jtNamTo.setColumns(10);
		panelfindkhoangtime.add(jtNamTo);

		panelsubmit = new JPanel();
		pnmain.add(panelsubmit);

		btSubmit = new JButton("Thống kê");
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelTable.setRowCount(0);
				String checkCbKh = cbChoiceKH.getSelectedItem().toString();
				String checkCbTime = cbTime.getSelectedItem().toString();
				// new String[] { "-- Chọn --", "Tất cả khách hàng", "Theo Quận - Phường", "Theo
				// mã khách hàng" }));
				// new String[] { "-- Chọn Khoảng thời gian --", "Theo chu kỳ", "Theo Năm",
				// "Theo khoảng thời gian" }));
				String sql = "";
				String sql1 = "";
				ArrayList<Integer> arrCount = new ArrayList();
				if (checkCbKh.equals("-- Chọn --") || checkCbKh.equals("Tất cả khách hàng")) {
					sql1 = "select * from ffse1702026_user";

				}
				if (checkCbKh.equals("Theo Quận - Phường")) {
					String quan = cbQuan.getSelectedItem().toString();
					String phuong = cbPhuong.getSelectedItem().toString();
					sql1 = "select * from ffse1702026_user where quan ='" + quan + "'";
					if(lbPhuong.isSelected()) {
						sql1="select * from ffse1702026_user where phuong ='" + phuong + "'";
					}
				}
				if (checkCbKh.equals("Theo mã khách hàng")) {
					String maKH = jtMaKhachHang.getText();
					
					try {
						sql1 = "select * from ffse1702026_user where maKH ='" + maKH + "'";
						ArrayList<KhachHang> kh2 = dbKhachHang.getInfo(sql1);
						
						if (kh2.size() == 0) {
							JOptionPane.showMessageDialog(pnmain, "Không tồn tại khách hàng cần tìm kiếm", "Thông báo lỗi",
									JOptionPane.ERROR_MESSAGE);
							arrCount.add(1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						
							JOptionPane.showMessageDialog(pnmain, "Không tồn tại khách hàng cần tìm kiếm", "Thông báo lỗi",
									JOptionPane.ERROR_MESSAGE);
							arrCount.add(1);
						
					}
					
					
				}
				if (checkCbTime.equals("Theo chu kỳ")) {
					String month = cbThangChuKy.getSelectedItem().toString();
					String year = jtNamChuKy.getText();
					try {
						MyException.checkYear(year);
					} catch (MyException e) {
						JOptionPane.showMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
						arrCount.add(1);
					}
					sql = "select * from ffse1702026_bienlai where month = " + month + " and year =" + year;
				}
				if (checkCbTime.equals("Theo Năm")) {

					String year = jtNam.getText();
					try {
						MyException.checkYear(year);
					} catch (MyException e) {
						JOptionPane.showMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
						arrCount.add(1);
					}
					sql = "select * from ffse1702026_bienlai where year =" + year;

				}
				if (checkCbTime.equals("Theo khoảng thời gian")) {

					String monthFrom = cbThangFrom.getSelectedItem().toString();
					String monthTo = cbThangTo.getSelectedItem().toString();
					String yearFrom = jtNamFrom.getText();
					String yearTo = jtNamTo.getText();
					try {
						int monthFr = Integer.parseInt(monthFrom);
						int yearfr = Integer.parseInt(yearFrom);
						int monthT = Integer.parseInt(monthTo);
						int yearT = Integer.parseInt(yearTo);
						if (monthFr != 1) {
							monthFrom = String.valueOf((monthFr - 1));

						} else {
							monthFrom = "12";
							yearFrom = String.valueOf((yearfr - 1));

						}
						if (monthT != 12) {
							monthTo = String.valueOf((monthT + 1));

						} else {
							monthTo = "1";
							yearTo = String.valueOf((yearT + 1));
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
						arrCount.add(1);
					}

					try {
						MyException.checkYear(yearFrom);
						MyException.checkYear(yearTo);
					} catch (MyException e) {
						JOptionPane.showMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
						arrCount.add(1);
					}
					try {
						MyException.checkKhoangTime(monthFrom, yearFrom, monthTo, yearTo);
					} catch (MyException e) {
						JOptionPane.showMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
						arrCount.add(1);
					}
					String dateFrom = yearFrom + "-" + monthFrom + "-01";
					String dateTo = yearTo + "-" + monthTo + "-01";
					try {
						java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
						java.util.Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);

						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						dateFrom = df.format(date2);
						dateTo = df.format(date3);

					} catch (ParseException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
						arrCount.add(1);
					}
					sql = "select * from ffse1702026_bienlai where selecttime >='" + dateFrom + "' and selecttime < '"
							+ dateTo + "'";

				}
				if (checkCbTime.equals("-- Chọn Khoảng thời gian --")) {
					sql = "select * from ffse1702026_bienlai";
				}
				if (arrCount.size() == 0) {
					try {
						ArrayList<BienLai> bl = DBBienLai.getDanhSach(sql);
						//System.out.println(bl.size());
						ArrayList<KhachHang> kh = dbKhachHang.getInfo(sql1);
						//System.out.println(kh.size());
						if(kh.size()==0) {
							JOptionPane.showMessageDialog(pnmain, "Không có dữ liệu", "Không tồn tại", JOptionPane.WARNING_MESSAGE);
						}
						if(bl.size()>0) {
						for (int i = 0; i < kh.size(); i++) {

							for (int j = 0; j < bl.size(); j++) {
								if (kh.get(i).getMaCongTo().equals(bl.get(j).getMaCongTo())) {
									String[] addTable = { kh.get(i).getMaCongTo(), kh.get(i).getTenKhachHang(),
											kh.get(i).getDiaChi() + " - " + kh.get(i).getPhuong() + " - "
													+ kh.get(i).getQuan(),
											bl.get(j).getNgayNhap(), bl.get(j).getMonth() + "-" + bl.get(j).getYear(),
											String.valueOf(bl.get(j).getChiSoCu()), String.valueOf(bl.get(j).getChiSoCongTo()),
											String.valueOf(bl.get(j).getChiSoCongTo() - bl.get(j).getChiSoCu()),
											String.valueOf(BienLai.tinhTien(bl.get(j).getChiSoCongTo() - bl.get(j).getChiSoCu()))};
									modelTable.addRow(addTable);
								}
							}

						}
						}
						else {
							JOptionPane.showMessageDialog(pnmain, "Không có dữ liệu", "Không tồn tại", JOptionPane.WARNING_MESSAGE);
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		panelsubmit.add(btSubmit);

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 51, 0)), "Danh Sách Khách Hàng",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 51, 0)));
		pnmain.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		panel.add(Box.createRigidArea(new Dimension(30, 20)));

		tablekhachhang = new JTable();
		tablekhachhang.setBackground(SystemColor.activeCaption);
		tablekhachhang.setModel(modelTable);

		JScrollPane sctable = new JScrollPane();
		panel.add(sctable);
		sctable.setViewportView(tablekhachhang);

		panel.add(Box.createRigidArea(new Dimension(30, 20)));

		buttonpanel = new JPanel();
		buttonpanel.setBackground(SystemColor.controlHighlight);
		pnmain.add(buttonpanel);
		buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonpanel.setMaximumSize(new Dimension(1800, 100));

		btnback = new JButton("Quay Lại");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JMain main=new JMain();
				main.setVisible(true);
			}
		});
		btnback.setBackground(SystemColor.activeCaption);
		buttonpanel.add(btnback);

	}
}
