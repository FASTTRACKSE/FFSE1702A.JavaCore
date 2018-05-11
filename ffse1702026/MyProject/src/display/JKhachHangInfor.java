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

public class JKhachHangInfor extends JFrame {

	private JPanel pnmain;
	private JTable tablekhachhang;
	private JPanel brandpanel;

	private JPanel buttonpanel;
	private JButton btnback;
	private JPanel panel;
	private JPanel panelsearch;
	private JLabel lblTTKH;
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
	private JPanel panelsubmit;
	private JButton btSubmit;
	String[] monhtmodel = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	String[] tieude = { "Mã Công Tơ", "Họ Tên", "Địa Chỉ", "Ngày Nhập", "Chu kỳ", "Chỉ Số Củ", "Chỉ Số Mới",
			"Tổng số điện", "Tổng Tiền" };
	DefaultTableModel modelTable = new DefaultTableModel(tieude, 0);
	private JScrollPane scInfor;
	private JTable inforTable;
	String[] collum = { "ID", "Họ Tên", "Mã Công Tơ", "Địa Chỉ", "Số Điện Thoại", "Email" };
	DefaultTableModel modelKhachHang = new DefaultTableModel(collum, 0);
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JKhachHangInfor frame = new JKhachHangInfor("KH_0001");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public JKhachHangInfor(String maKH) throws SQLException {
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

		lblTTKH = new JLabel("Thông Tin Khách Hàng");
		lblTTKH.setForeground(new Color(102, 51, 0));
		lblTTKH.setBackground(SystemColor.controlHighlight);
		lblTTKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelsearch.add(lblTTKH);

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panelchoiceKH = new JPanel();
		panelchoiceKH.setBorder(new TitledBorder(new LineBorder(new Color(102, 51, 51)), "Khach Hang", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(153, 51, 0)));
		pnmain.add(panelchoiceKH);
		panelchoiceKH.setLayout(new BoxLayout(panelchoiceKH, BoxLayout.X_AXIS));
		
		
		panelchoiceKH.add(Box.createRigidArea(new Dimension(20, 20)));
		
		scInfor = new JScrollPane();
		panelchoiceKH.add(scInfor);
		String sql="select * from ffse1702026_user where maKH= '"+maKH+"'";
		ArrayList<KhachHang> kh=dbKhachHang.getInfo(sql);
		
		modelTable.setRowCount(0);

		for (KhachHang kh1 : kh) {

			String[] khachhang = { kh1.getMaKhackHang(), kh1.getTenKhachHang(), kh1.getMaCongTo(),
					kh1.getDiaChi() + ", " + kh1.getPhuong() + ", " + kh1.getQuan(), kh1.getPhone(),
					kh1.getEmail() };
			modelKhachHang.addRow(khachhang);
		}
		inforTable = new JTable(modelKhachHang);
		scInfor.setViewportView(inforTable);
		
		
		panelchoiceKH.add(Box.createRigidArea(new Dimension(20, 20)));
		ArrayList<String> arrQuan = quan.getQuan();

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
				new String[] { "-- Tất cả --", "Theo chu kỳ", "Theo Năm", "Theo khoảng thời gian" }));

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
				ArrayList<Integer> arrCount=new ArrayList<>();
				String checkCbTime = cbTime.getSelectedItem().toString();
				// new String[] { "-- Chọn --", "Tất cả khách hàng", "Theo Quận - Phường", "Theo
				// mã khách hàng" }));
				// new String[] { "-- Chọn Khoảng thời gian --", "Theo chu kỳ", "Theo Năm",
				// "Theo khoảng thời gian" }));
				String sql = "";
				String sql1 = "select * from ffse1702026_user where maKH='"+maKH+"'";
	
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
				if (checkCbTime.equals("-- Tất cả --")) {
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
		panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 51, 0)), "Danh S\u00E1ch Bi\u00EAn Lai", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 51, 0)));
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
				int output = JOptionPane.showConfirmDialog(pnmain, "Bạn có muốn thoát", "Thông Báo",
						JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					setVisible(false);
					JLogin lg = new JLogin();
					lg.setVisible(true);
				}
			}
		});
		btnback.setBackground(SystemColor.activeCaption);
		buttonpanel.add(btnback);

	}
}
