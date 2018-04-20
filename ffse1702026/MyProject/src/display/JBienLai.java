package display;

import java.awt.*;
import com.toedter.calendar.JMonthChooser;

import database.DBBienLai;
import database.dbKhachHang;
import object.BienLai;
import object.KhachHang;
import object.MyException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JBienLai extends JFrame {

	private JPanel pnmain;
	private JTable tablebienlai;
	private JPanel brandpanel;
	private JPanel inputpanel;
	private Component verticalStrut;
	private JPanel buttonpanel;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDel;
	private JButton btnback;
	private JPanel panelid;
	private JPanel paneldate;
	private JLabel lbId;
	private JTextField jtId;
	private JLabel lbDate;
	private JPanel panelname;
	private JPanel panelmonth;
	private JLabel labelName;
	private JTextField jtName;
	private JLabel lbMonth;
	private JComboBox cbMonth;
	private JPanel paneladdress;
	private JLabel lbAdress;
	private JTextField jtAdress;
	private JLabel labelYear;
	private JTextField jtYear;
	private JPanel panelchiso;
	private JLabel lbChiSo;
	private JTextField jtChiSo;
	private JPanel panel;
	private JButton btnShow;
	private JDateChooser jtDate;
	private String date = "";
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
//					JBienLai frame = new JBienLai();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public JBienLai() {
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

		JLabel lblbrand = new JLabel("Quản lý biên lai");
		lblbrand.setBackground(SystemColor.controlHighlight);
		brandpanel.add(lblbrand);
		lblbrand.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblbrand.setForeground(new Color(102, 51, 0));
		lblbrand.setFont(new Font("Times New Roman", Font.BOLD, 32));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		inputpanel = new JPanel();
		inputpanel.setMaximumSize(new Dimension(1800, 150));
		inputpanel.setBackground(SystemColor.controlHighlight);

		pnmain.add(inputpanel);
		inputpanel.setLayout(new GridLayout(0, 1, 0, 8));

		panelid = new JPanel();
		panelid.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelid);
		panelid.setLayout(new BoxLayout(panelid, BoxLayout.X_AXIS));

		panelid.add(Box.createRigidArea(new Dimension(220, 20)));

		lbId = new JLabel("Mã Công tơ");
		lbId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbId.setBackground(new Color(51, 102, 0));
		panelid.add(lbId);

		panelid.add(Box.createRigidArea(new Dimension(69, 20)));

		jtId = new JTextField();
		jtId.setColumns(10);
		panelid.add(jtId);

		panelid.add(Box.createRigidArea(new Dimension(20, 20)));

		btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String maCongTo = jtId.getText();
				String sql = "select * from ffse1702026_user where macongto='" + maCongTo + "'";
				modelTable.setRowCount(0);
				try {
					ArrayList<KhachHang> infor = dbKhachHang.getInfo(sql);
					if (infor.size() > 0) {
						jtName.setText(infor.get(0).getTenKhachHang());
						jtAdress.setText(infor.get(0).getDiaChi() + ", " + infor.get(0).getPhuong() + ", "
								+ infor.get(0).getQuan());
						ArrayList<BienLai> bl = DBBienLai.getList(maCongTo);
						setTextTable(bl, infor.get(0).getTenKhachHang(), infor.get(0).getDiaChi() + ", "
								+ infor.get(0).getPhuong() + ", " + infor.get(0).getQuan());
					} else {
						JOptionPane.showMessageDialog(pnmain, "Không tồn tại công tơ mã " + maCongTo, "Thông báo lỗi",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnShow.setBackground(SystemColor.activeCaption);
		panelid.add(btnShow);

		panelid.add(Box.createRigidArea(new Dimension(215, 20)));

		panelname = new JPanel();
		panelname.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelname);
		panelname.setLayout(new BoxLayout(panelname, BoxLayout.X_AXIS));

		panelname.add(Box.createRigidArea(new Dimension(220, 20)));

		labelName = new JLabel("Tên khách hàng");
		labelName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelName.setBackground(new Color(51, 102, 0));
		panelname.add(labelName);

		panelname.add(Box.createRigidArea(new Dimension(49, 20)));

		jtName = new JTextField();
		jtName.setColumns(10);
		panelname.add(jtName);

		panelname.add(Box.createRigidArea(new Dimension(300, 20)));

		paneladdress = new JPanel();
		paneladdress.setBackground(SystemColor.controlHighlight);
		inputpanel.add(paneladdress);
		paneladdress.setLayout(new BoxLayout(paneladdress, BoxLayout.X_AXIS));

		paneladdress.add(Box.createRigidArea(new Dimension(220, 20)));

		lbAdress = new JLabel("Địa chỉ");
		lbAdress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbAdress.setBackground(new Color(51, 102, 0));
		paneladdress.add(lbAdress);

		paneladdress.add(Box.createRigidArea(new Dimension(102, 20)));

		jtAdress = new JTextField();
		jtAdress.setColumns(10);
		paneladdress.add(jtAdress);

		paneladdress.add(Box.createRigidArea(new Dimension(300, 20)));

		paneldate = new JPanel();
		paneldate.setBackground(SystemColor.controlHighlight);
		inputpanel.add(paneldate);

		paneldate.setLayout(new BoxLayout(paneldate, BoxLayout.X_AXIS));

		paneldate.add(Box.createRigidArea(new Dimension(220, 20)));

		lbDate = new JLabel("Ngày ");
		lbDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbDate.setBackground(new Color(51, 102, 0));
		paneldate.add(lbDate);

		paneldate.add(Box.createRigidArea(new Dimension(108, 20)));

		jtDate = new JDateChooser();
		paneldate.add(jtDate);

		paneldate.add(Box.createRigidArea(new Dimension(300, 20)));

		panelmonth = new JPanel();
		panelmonth.setBackground(SystemColor.controlHighlight);

		inputpanel.add(panelmonth);
		panelmonth.setLayout(new BoxLayout(panelmonth, BoxLayout.X_AXIS));

		panelmonth.add(Box.createRigidArea(new Dimension(220, 20)));

		lbMonth = new JLabel("Chu Kỳ Nhập Tháng");
		lbMonth.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbMonth.setBackground(new Color(51, 102, 0));
		panelmonth.add(lbMonth);

		panelmonth.add(Box.createRigidArea(new Dimension(18, 20)));

		cbMonth = new JComboBox();
		cbMonth.setBackground(Color.WHITE);
		String[] monthmodel = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cbMonth.setModel(new DefaultComboBoxModel(monthmodel));
		panelmonth.add(cbMonth);

		panelmonth.add(Box.createRigidArea(new Dimension(40, 20)));

		labelYear = new JLabel("Năm");
		panelmonth.add(labelYear);
		labelYear.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelYear.setBackground(new Color(51, 102, 0));

		panelmonth.add(Box.createRigidArea(new Dimension(40, 20)));

		jtYear = new JTextField();
		panelmonth.add(jtYear);
		jtYear.setColumns(10);

		panelmonth.add(Box.createRigidArea(new Dimension(300, 20)));

		panelchiso = new JPanel();
		panelchiso.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelchiso);
		panelchiso.setLayout(new BoxLayout(panelchiso, BoxLayout.X_AXIS));

		panelchiso.add(Box.createRigidArea(new Dimension(220, 20)));

		lbChiSo = new JLabel("Chỉ số công tơ");
		lbChiSo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbChiSo.setBackground(new Color(51, 102, 0));
		panelchiso.add(lbChiSo);

		panelchiso.add(Box.createRigidArea(new Dimension(56, 20)));

		jtChiSo = new JTextField();
		jtChiSo.setColumns(10);
		panelchiso.add(jtChiSo);

		panelchiso.add(Box.createRigidArea(new Dimension(300, 20)));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		buttonpanel = new JPanel();
		buttonpanel.setBackground(SystemColor.controlHighlight);
		pnmain.add(buttonpanel);
		buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonpanel.setMaximumSize(new Dimension(1800, 100));

		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> countnb = new ArrayList();
				String maCongTo = jtId.getText();
				String sql = "select * from ffse1702026_user where macongto='" + maCongTo + "'";
				try {
					ArrayList<KhachHang> kh = dbKhachHang.getInfo(sql);
					if (kh.size() == 0) {
						JOptionPane.showInternalMessageDialog(pnmain, "Không tồn tại mã khách hàng", "Thông báo lỗi",
								JOptionPane.ERROR_MESSAGE);
						countnb.add(1);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}
				try {
					MyException.checkMCT(maCongTo);
				} catch (MyException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}
				try {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					date = df.format(jtDate.getDate());
				} catch (Exception e1) {
					JOptionPane.showInternalMessageDialog(pnmain, "Bạn chưa chọn ngày", "Thông báo lỗi",
							JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}

				String month = cbMonth.getSelectedItem().toString();
				String year = jtYear.getText();
				try {
					MyException.checkYear(year);
				} catch (MyException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}
				String chiSoCongTo = jtChiSo.getText();
				try {
					MyException.checkChiSo(chiSoCongTo);
				} catch (MyException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}
				try {
					MyException.checkChuky(maCongTo, month, year, chiSoCongTo);
					// System.out.println("đã check");
					// ArrayList<BienLai> blai = DBBienLai.getList(maCongTo);
					// int n=blai.size();
					// for(BienLai bls: blai) {
					// int a=Integer.parseInt("2018");
					// System.out.println(n);
					// System.out.println(bls.getChiSoCongTo());
					// }
					//
				} catch (MyException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}

				// MyException.checkChuKy(month,year);
				System.out.println(countnb.size());

				if (countnb.size() == 0) {

					try {
						ArrayList<BienLai> bla = DBBienLai.getList(maCongTo);
						int count = bla.size() - 1;
						int chiSoCu = 0;
						if (count >= 0) {
							chiSoCu = bla.get(count).getChiSoCongTo();
						}
						int chiSoMoi = Integer.parseInt(chiSoCongTo);
						int soDien = chiSoMoi - chiSoCu;
						String tongDien = String.valueOf(soDien);
						String diaChi = jtAdress.getText();
						double tongTien = BienLai.tinhTien(soDien);
						String tTien = String.valueOf(tongTien);
						String cSc = String.valueOf(chiSoCu);
						String tenKH = jtName.getText();
						String sql1 = "insert into ffse1702026_bienlai ( macongto, date, chisocongto, month, year, chuky, chisocu, selecttime) VALUES ('"
								+ maCongTo + "','" + date + "','" + chiSoCongTo + "','" + month + "','" + year + "','"
								+ month + "-" + year + "','" + cSc + "','" + year + "-" + month + "-01" + "')";
						System.out.println(sql1);
						try {
							String[] addTable = { maCongTo, tenKH, diaChi, date, month + "-" + year, cSc, chiSoCongTo,
									tongDien, tTien };
							modelTable.addRow(addTable);
							setText("", "", "", "", "", "", "");
							DBBienLai.addBienLai(sql1);
							JOptionPane.showInternalMessageDialog(pnmain, "Nhập dữ liệu thành công", "Thành công",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException | ParseException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		btnAdd.setBackground(SystemColor.activeCaption);
		buttonpanel.add(btnAdd);

		btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Integer> countnb = new ArrayList();
				String maCongTo = jtId.getText();
				String sql = "select * from ffse1702026_user where macongto='" + maCongTo + "'";
				try {
					ArrayList<KhachHang> kh = dbKhachHang.getInfo(sql);
					if (kh.size() == 0) {
						JOptionPane.showInternalMessageDialog(pnmain, "Không tồn tại mã khách hàng", "Thông báo lỗi",
								JOptionPane.ERROR_MESSAGE);
						countnb.add(1);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}
				try {
					MyException.checkMCT(maCongTo);
				} catch (MyException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}

				try {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					date = df.format(jtDate.getDate());
				} catch (Exception e) {
					JOptionPane.showInternalMessageDialog(pnmain, "Bạn chưa chọn ngày", "Thông báo lỗi",
							JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}

				String month = cbMonth.getSelectedItem().toString();
				String year = jtYear.getText();
				try {
					MyException.checkYear(year);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}
				String chiSoCongTo = jtChiSo.getText();
				try {
					MyException.checkChiSo(chiSoCongTo);
				} catch (MyException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}
				try {
					MyException.checkChiSo(chiSoCongTo, month, year, maCongTo);
				} catch (MyException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}

				String sql1 = "select * from ffse1702026_bienlai where month=" + month + " and year=" + year
						+ " and macongto='" + maCongTo + "'";
				ArrayList<BienLai> bl = new ArrayList<BienLai>();
				try {
					bl = DBBienLai.getDanhSach(sql1);
					if (bl.size() == 0) {
						JOptionPane.showInternalMessageDialog(pnmain, "Không tồn tại dữ liệu cần update",
								"Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
						countnb.add(1);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					countnb.add(1);
				}

				// try {
				// MyException.checkChuky(maCongTo, month, year, chiSoCongTo);
				// // System.out.println("đã check");
				// // ArrayList<BienLai> blai = DBBienLai.getList(maCongTo);
				// // int n=blai.size();
				// // for(BienLai bls: blai) {
				// // int a=Integer.parseInt("2018");
				// // System.out.println(n);
				// // System.out.println(bls.getChiSoCongTo());
				// // }
				// //
				// } catch (MyException | SQLException e) {
				// // TODO Auto-generated catch block
				// JOptionPane.showInternalMessageDialog(pnmain, e, "Thông báo lỗi",
				// JOptionPane.ERROR_MESSAGE);
				// countnb.add(1);
				// }

				// MyException.checkChuKy(month,year);

				if (countnb.size() == 0) {

					int count = bl.size() - 1;
					int chiSoCu = 0;
					if (count >= 1) {
						chiSoCu = bl.get(count).getChiSoCu();
					}

					int chiSoMoi = Integer.parseInt(chiSoCongTo);
					int soDien = chiSoMoi - chiSoCu;
					String tongDien = String.valueOf(soDien);
					String diaChi = jtAdress.getText();
					double tongTien = BienLai.tinhTien(soDien);
					String tTien = String.valueOf(tongTien);
					String cSc = String.valueOf(chiSoCu);
					String tenKH = jtName.getText();
					String sql2 = "update ffse1702026_bienlai set macongto='" + maCongTo + "'," + "date='" + date + "',"
							+ "chisocongto ='" + chiSoCongTo + "'," + "month='" + month + "'," + "year= '" + year + "',"
							+ "chuky= '" + month + "-" + year + "'" + " where macongto='" + maCongTo + "' and month='"
							+ month + "' and year='" + year + "'";

					int monthT = Integer.parseInt(month);
					int yearT = Integer.parseInt(year);
					String monthTo = "";
					String yearTo = "";

					if (monthT != 12) {
						monthTo = String.valueOf((monthT + 1));
						 yearTo=year;
					} else {
						monthTo = "1";
						yearTo = String.valueOf((yearT + 1));
					}
					String sql3 = "update ffse1702026_bienlai set chisocu=" + chiSoCongTo + " where macongto='"
							+ maCongTo + "' and month='" + monthTo + "' and year='" + yearTo + "'";
					try {
						// String[] addTable = { maCongTo, tenKH, diaChi, date, month + "-" + year, cSc,
						// chiSoCongTo,
						// tongDien, tTien };
						// modelTable.addRow(addTable);
						// int row = tablebienlai.getSelectedRow();
						// tablebienlai.setValueAt(maCongTo, row, 0);
						// tablebienlai.setValueAt(tenKH, row, 1);
						// tablebienlai.setValueAt(diaChi, row, 2);
						// tablebienlai.setValueAt(date, row, 3);
						// tablebienlai.setValueAt(month + "-" + year, row, 4);
						// tablebienlai.setValueAt(cSc, row, 5);
						// tablebienlai.setValueAt(chiSoCongTo, row, 6);
						// tablebienlai.setValueAt(tongDien, row, 7);
						// tablebienlai.setValueAt(tTien, row, 8);

						DBBienLai.addBienLai(sql2);
						DBBienLai.addBienLai(sql3);
						ArrayList<KhachHang> infor = dbKhachHang.getInfo(sql);
						modelTable.setRowCount(0);
						if (infor.size() > 0) {
							jtName.setText(infor.get(0).getTenKhachHang());
							jtAdress.setText(infor.get(0).getDiaChi() + ", " + infor.get(0).getPhuong() + ", "
									+ infor.get(0).getQuan());
							ArrayList<BienLai> bla = DBBienLai.getList(maCongTo);
							setTextTable(bla, infor.get(0).getTenKhachHang(), infor.get(0).getDiaChi() + ", "
									+ infor.get(0).getPhuong() + ", " + infor.get(0).getQuan());

							JOptionPane.showInternalMessageDialog(pnmain, "Update dữ liệu thành công", "Thành công",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showInternalMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					}

				}
			}

		});
		btnEdit.setBackground(SystemColor.activeCaption);
		buttonpanel.add(btnEdit);

		btnDel = new JButton("Xóa");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowsl = tablebienlai.getSelectedRow();
				if (rowsl > 0) {
				int output = JOptionPane.showConfirmDialog(pnmain, "Bạn có muốn xóa khách hàng", "Delete",
						JOptionPane.YES_NO_OPTION);

				if (output == JOptionPane.YES_OPTION) {
					String macongto = (String) tablebienlai.getValueAt(rowsl, 0);
					String ckyTable = (String) tablebienlai.getValueAt(rowsl, 4);
					String[] split = ckyTable.split("-");
					String monthsp = split[0];
					String yearsp = split[1];

					try {
						DBBienLai.del(macongto, monthsp, yearsp);
						modelTable.removeRow(rowsl);
						JOptionPane.showMessageDialog(pnmain, "Xóa dữ liệu thành công", "Đã xóa",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
			}
		});
		btnDel.setBackground(SystemColor.activeCaption);
		buttonpanel.add(btnDel);

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

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 51, 0)), "Danh Sách Biên Lai",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 51, 0)));
		pnmain.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		panel.add(Box.createRigidArea(new Dimension(30, 20)));

		tablebienlai = new JTable();
		tablebienlai.setBackground(SystemColor.activeCaption);
		tablebienlai.setModel(modelTable);
		tablebienlai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tablebienlai.getSelectedRow();
				String ckyTable = (String) tablebienlai.getValueAt(row, 4);
				String[] split = ckyTable.split("-");
				String month = split[0];
				String year = split[1];
				String maCongTo = (String) tablebienlai.getValueAt(row, 0);
				String tenKhachHang = (String) tablebienlai.getValueAt(row, 1);
				String date = (String) tablebienlai.getValueAt(row, 3);
				String chiSoCongTo = (String) tablebienlai.getValueAt(row, 6);
				String diaChi = (String) tablebienlai.getValueAt(row, 2);
				try {
					setText(maCongTo, tenKhachHang, month, year, date, chiSoCongTo, diaChi);
				} catch (SQLException | ParseException e) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JScrollPane sctable = new JScrollPane();

		panel.add(sctable);
		sctable.setViewportView(tablebienlai);

		panel.add(Box.createRigidArea(new Dimension(30, 20)));

	}

	private void setText(String maCongTo, String tenKhachHang, String month, String year, String date,
			String chiSoCongTo, String diaChi) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		jtId.setText(maCongTo);
		jtName.setText(tenKhachHang);
		jtYear.setText(year);
		jtChiSo.setText(chiSoCongTo);
		jtAdress.setText(diaChi);
		cbMonth.setSelectedItem(month);
		if (!date.equals("")) {
			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			jtDate.setDate(date2);
		}

	}

	public void setTextTable(ArrayList<BienLai> bl, String tenKhachHang, String diaChi) {
		for (int i = 0; i < bl.size(); i++) {
			if (i == 0) {
				String[] addTable = { bl.get(i).getMaCongTo(), tenKhachHang, diaChi, bl.get(i).getNgayNhap(),
						bl.get(i).getMonth() + "-" + bl.get(i).getYear(), "0",
						String.valueOf(bl.get(i).getChiSoCongTo()), String.valueOf(bl.get(i).getChiSoCongTo()),
						String.valueOf(BienLai.tinhTien(bl.get(i).getChiSoCongTo())) };
				modelTable.addRow(addTable);
			} else {
				String[] addTable = { bl.get(i).getMaCongTo(), tenKhachHang, diaChi, bl.get(i).getNgayNhap(),
						bl.get(i).getMonth() + "-" + bl.get(i).getYear(),
						String.valueOf(bl.get(i - 1).getChiSoCongTo()), String.valueOf(bl.get(i).getChiSoCongTo()),
						String.valueOf(bl.get(i).getChiSoCongTo() - bl.get(i - 1).getChiSoCongTo()),
						String.valueOf(BienLai.tinhTien(bl.get(i).getChiSoCongTo() - bl.get(i - 1).getChiSoCongTo())) };
				modelTable.addRow(addTable);
			}

			// String[] addTable = { blT.getMaCongTo(), tenKH, diaChi, date, month + "-" +
			// year, cSc, chiSoCongTo,
			// tongDien, tTien };
		}

	}
}
