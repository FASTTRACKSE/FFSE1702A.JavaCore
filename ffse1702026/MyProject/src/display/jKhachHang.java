package display;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import com.toedter.calendar.JMonthChooser;

import database.dbKhachHang;
import database.phuong;
import database.quan;
import object.KhachHang;
import object.MyException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class jKhachHang extends JFrame implements ActionListener {

	private JPanel pnmain;
	private JTable tablekhachhang;
	private JPanel brandpanel;
	private JPanel inputpanel;
	// private Component verticalStrut;
	private JPanel buttonpanel;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDel;
	private JButton btnback;
	private JPanel panelid;
	private JPanel panelquan;
	private JLabel lbId;
	private JTextField jtId;
	private JLabel lbQuan;
	private JComboBox cbQuan;
	private JPanel panelname;
	private JPanel panelphuong;
	private JLabel labelName;
	private JTextField jtName;
	private JLabel lbPhuong;
	private JComboBox cbPhuong;
	private JPanel paneladdress;
	private JLabel lbAdress;
	private JTextField jtAdress;
	private JPanel panelmacto;
	private JLabel labelMaCTo;
	private JTextField jtMaCongTo;
	private JPanel panelphone;
	private JLabel lbPhone;
	private JTextField jtPhone;
	private JPanel panelemail;
	private JLabel lbEmail;
	private JTextField jtEmail;
	private JPanel panel;
	private JPanel panelsearch;
	private JTextField jtSearch;
	private JButton btSearch;
	private ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
	String[] tieude = { "ID", "Họ Tên", "Mã Công Tơ", "Địa Chỉ", "Số Điện Thoại", "Email" };
	DefaultTableModel modelTable = new DefaultTableModel(tieude, 0);

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public jKhachHang() throws MyException, SQLException {
		addConTrols();
		Addevents();

	}

	public void Addevents() {

		btnAdd.addActionListener(this);
		btnEdit.addActionListener(this);
		btnDel.addActionListener(this);
		btnback.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		JButton bt = (JButton) e.getSource();
		ArrayList<Integer> count = new ArrayList<>();
		if (bt == btnAdd) {
			String maKhachHang = jtId.getText();
			try {
				MyException.checkMaKhachHang(maKhachHang);

			} catch (MyException | SQLException e2) {
				// TODO Auto-generated catch block
				count.add(1);
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
			}
			try {
				MyException.checkExist(maKhachHang, "Mã khách hàng");
			} catch (MyException | SQLException e3) {
				// TODO Auto-generated catch block
				count.add(1);
				JOptionPane.showMessageDialog(pnmain, e3, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
			}
			String tenKhachHang = jtName.getText();
			try {
				MyException.checkName(tenKhachHang);
			} catch (MyException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			String quan = cbQuan.getSelectedItem().toString();
			String phuong = cbPhuong.getSelectedItem().toString();
			String phone = jtPhone.getText();
			try {
				MyException.checkPhone(phone);
			} catch (MyException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			String email = jtEmail.getText();
			try {
				MyException.checkEmail(email);
			} catch (MyException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			String address = jtAdress.getText();
			try {
				MyException.checkAdress(address);
			} catch (MyException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			String macongto = jtMaCongTo.getText();
			try {
				MyException.checkMaCongTo(macongto);
			} catch (MyException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			try {
				MyException.checkExist(macongto, "Mã công tơ");
			} catch (MyException | SQLException e3) {
				// TODO Auto-generated catch block
				count.add(1);
				JOptionPane.showMessageDialog(pnmain, e3, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
			}

			if (count.size() == 0) {
				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, quan, phuong, address, phone, email, macongto);
				String[] row = { maKhachHang, tenKhachHang, macongto, address + " ," + phuong + " ," + quan, phone,
						email };
				modelTable.addRow(row);
				arrKhachHang.add(kh);
				try {
					setText("", "", "", "", "", "", "", "");
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnmain, e2);
				}
				try {
					dbKhachHang.add(maKhachHang, tenKhachHang, quan, phuong, address, phone, email, macongto);
					JOptionPane.showMessageDialog(pnmain, "Nhập dữ liệu thành công", "Đã Nhập",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(pnmain, "Vui lòng nhập lại dữ liệu", "Thông báo lỗi",
						JOptionPane.ERROR_MESSAGE);
			}

		}
		///

		if (bt == btnEdit) {
			int rowsl = tablekhachhang.getSelectedRow();
			String maKhachHang = jtId.getText();
			try {
				MyException.checkMaKhachHang(maKhachHang);
			} catch (MyException | SQLException e2) {
				// TODO Auto-generated catch block
				count.add(1);
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
			}
			String tenKhachHang = jtName.getText();
			try {
				MyException.checkName(tenKhachHang);
			} catch (MyException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			String quan = cbQuan.getSelectedItem().toString();
			String phuong = cbPhuong.getSelectedItem().toString();
			String phone = jtPhone.getText();
			try {
				MyException.checkPhone(phone);
			} catch (MyException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			String email = jtEmail.getText();
			try {
				MyException.checkEmail(email);
			} catch (MyException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			String address = jtAdress.getText();
			try {
				MyException.checkAdress(address);
			} catch (MyException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			String macongto = jtMaCongTo.getText();
			try {
				MyException.checkMaCongTo(macongto);
			} catch (MyException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e2, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			String sql = "select * from ffse1702026_user where maKH='" + maKhachHang + "' and macongto='" + macongto
					+ "'";
			try {
				ArrayList<KhachHang> kh2 = dbKhachHang.getInfo(sql);
				if (kh2.size() == 0) {
					JOptionPane.showMessageDialog(pnmain, "Không tồn tại khách hàng cần update", "Thông báo lỗi",
							JOptionPane.ERROR_MESSAGE);
					count.add(1);
				}
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pnmain, e3, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				count.add(1);
			}
			if (count.size() == 0) {
				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, quan, phuong, address, phone, email, macongto);
				String[] row = { maKhachHang, tenKhachHang, macongto, address + " ," + phuong + " ," + quan, phone,
						email };

				arrKhachHang.add(kh);
				try {
					setText("", "", "", "", "", "", "", "");
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnmain, e2);
				}
				try {
					dbKhachHang.upDate(maKhachHang, tenKhachHang, quan, phuong, address, phone, email, macongto);
					JOptionPane.showMessageDialog(pnmain, "Update dữ liệu thành công", "Đã Update",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				}

				try {
					ArrayList<KhachHang> khs = dbKhachHang.getSearch(maKhachHang);
					int rowCount = tablekhachhang.getRowCount();
					for (int i = rowCount - 1; i >= 0; i--) {
						modelTable.removeRow(i);
					}

					for (KhachHang kh1 : khs) {

						String[] khachhang = { kh1.getMaKhackHang(), kh1.getTenKhachHang(), kh1.getMaCongTo(),
								kh1.getDiaChi() + ", " + kh1.getPhuong() + ", " + kh1.getQuan(), kh1.getPhone(),
								kh1.getEmail() };
						modelTable.addRow(khachhang);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(pnmain, "Vui lòng nhập lại dữ liệu", "Thông báo lỗi",
						JOptionPane.ERROR_MESSAGE);
			}

		}
		if (bt == btnDel) {
			int rowsl = tablekhachhang.getSelectedRow();
			int output = JOptionPane.showConfirmDialog(pnmain, "Bạn có muốn xóa khách hàng", "Delete",
					JOptionPane.YES_NO_OPTION);

			if (output == JOptionPane.YES_OPTION) {
				String maKH = jtId.getText();
				if (rowsl > 0) {
					modelTable.removeRow(rowsl);
					try {
						dbKhachHang.del(maKH);
						JOptionPane.showMessageDialog(pnmain, "Xóa dữ liệu thành công", "Đã xóa",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(pnmain, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					}

				}

			}

		}
		if (bt == btnback) {
			super.setVisible(false);
			JMain main = new JMain();
			main.setVisible(true);
		}
	}

	private void setText(String maKhackHang, String tenKhachHang, String quan, String phuong, String diaChi,
			String phone, String email, String maCongTo) throws SQLException {
		// TODO Auto-generated method stub
		jtId.setText(maKhackHang);
		jtName.setText(tenKhachHang);
		if (quan.equals("")) {
			cbQuan.setSelectedItem(0);
			cbPhuong.setSelectedIndex(0);
		} else {
			cbQuan.setSelectedItem(quan);
			ArrayList<String> listphuong = database.phuong.getPhuong(quan);
			cbPhuong.setModel(new DefaultComboBoxModel(listphuong.toArray()));
			cbPhuong.setSelectedItem(phuong);
		}
		jtPhone.setText(phone);
		jtEmail.setText(email);
		jtAdress.setText(diaChi);
		jtMaCongTo.setText(maCongTo);
	}

	public void addConTrols() throws SQLException {
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

		JLabel lblbrand = new JLabel("Quản lý khách hàng");
		lblbrand.setBackground(SystemColor.controlHighlight);
		brandpanel.add(lblbrand);
		lblbrand.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblbrand.setForeground(new Color(102, 51, 0));
		lblbrand.setFont(new Font("Times New Roman", Font.BOLD, 32));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panelsearch = new JPanel();
		panelsearch.setMaximumSize(new Dimension(1800, 150));
		panelsearch.setBackground(SystemColor.controlHighlight);
		pnmain.add(panelsearch);
		panelsearch.setLayout(new BoxLayout(panelsearch, BoxLayout.X_AXIS));

		panelsearch.add(Box.createRigidArea(new Dimension(195, 20)));

		jtSearch = new JTextField();
		panelsearch.add(jtSearch);
		jtSearch.setColumns(10);

		panelsearch.add(Box.createRigidArea(new Dimension(20, 20)));

		btSearch = new JButton("Tìm Kiếm");
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = jtSearch.getText();
				if (!search.equals("")) {
					try {
						ArrayList<KhachHang> khs = dbKhachHang.getSearch(search);
						int rowCount = tablekhachhang.getRowCount();
						for (int i = rowCount - 1; i >= 0; i--) {
							modelTable.removeRow(i);
						}

						for (KhachHang kh : khs) {

							String[] khachhang = { kh.getMaKhackHang(), kh.getTenKhachHang(), kh.getMaCongTo(),
									kh.getDiaChi() + ", " + kh.getPhuong() + ", " + kh.getQuan(), kh.getPhone(),
									kh.getEmail() };
							modelTable.addRow(khachhang);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showInternalMessageDialog(pnmain, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btSearch.setBackground(SystemColor.activeCaption);
		panelsearch.add(btSearch);

		panelsearch.add(Box.createRigidArea(new Dimension(230, 20)));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		inputpanel = new JPanel();
		inputpanel.setMaximumSize(new Dimension(1800, 150));
		inputpanel.setBackground(SystemColor.controlHighlight);

		pnmain.add(inputpanel);
		inputpanel.setLayout(new GridLayout(0, 2, 50, 10));

		panelid = new JPanel();
		panelid.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelid);
		panelid.setLayout(new BoxLayout(panelid, BoxLayout.X_AXIS));

		panelid.add(Box.createRigidArea(new Dimension(50, 20)));

		lbId = new JLabel("Mã khách hàng");
		lbId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbId.setBackground(new Color(51, 102, 0));
		panelid.add(lbId);

		panelid.add(Box.createRigidArea(new Dimension(50, 20)));

		jtId = new JTextField();
		jtId.setColumns(10);
		panelid.add(jtId);

		panelquan = new JPanel();
		panelquan.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelquan);

		panelquan.setLayout(new BoxLayout(panelquan, BoxLayout.X_AXIS));

		lbQuan = new JLabel("Quận");
		lbQuan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbQuan.setBackground(new Color(51, 102, 0));
		panelquan.add(lbQuan);

		panelquan.add(Box.createRigidArea(new Dimension(65, 20)));
		ArrayList<String> arrQuan = quan.getQuan();

		cbQuan = new JComboBox();

		cbQuan.setModel(new DefaultComboBoxModel(arrQuan.toArray()));
		cbQuan.setMaximumRowCount(100);
		cbQuan.setBackground(Color.WHITE);

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
		panelquan.add(cbQuan);

		panelquan.add(Box.createRigidArea(new Dimension(50, 20)));

		panelname = new JPanel();
		panelname.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelname);
		panelname.setLayout(new BoxLayout(panelname, BoxLayout.X_AXIS));

		panelname.add(Box.createRigidArea(new Dimension(49, 20)));

		labelName = new JLabel("Tên khách hàng");
		labelName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelName.setBackground(new Color(51, 102, 0));
		panelname.add(labelName);

		panelname.add(Box.createRigidArea(new Dimension(50, 20)));

		jtName = new JTextField();
		jtName.setColumns(10);
		panelname.add(jtName);

		panelphuong = new JPanel();
		panelphuong.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelphuong);
		panelphuong.setLayout(new BoxLayout(panelphuong, BoxLayout.X_AXIS));

		lbPhuong = new JLabel("Phường");
		lbPhuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbPhuong.setBackground(new Color(51, 102, 0));
		panelphuong.add(lbPhuong);

		panelphuong.add(Box.createRigidArea(new Dimension(50, 20)));

		cbPhuong = new JComboBox();
		cbPhuong.setModel(new DefaultComboBoxModel(new String[] { "Bình Hiên", "Bình Thuận", "Hải Châu 1", "Hải Châu 2",
				"Hòa Cường Bắc", "Hòa Cường Nam" }));

		cbPhuong.setBackground(Color.WHITE);
		panelphuong.add(cbPhuong);

		panelphuong.add(Box.createRigidArea(new Dimension(50, 20)));

		panelmacto = new JPanel();
		panelmacto.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelmacto);
		panelmacto.setLayout(new BoxLayout(panelmacto, BoxLayout.X_AXIS));

		panelmacto.add(Box.createRigidArea(new Dimension(50, 20)));

		labelMaCTo = new JLabel("Mã công tơ");
		labelMaCTo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelMaCTo.setBackground(new Color(51, 102, 0));
		panelmacto.add(labelMaCTo);

		panelmacto.add(Box.createRigidArea(new Dimension(75, 20)));

		jtMaCongTo = new JTextField();
		jtMaCongTo.setColumns(10);
		panelmacto.add(jtMaCongTo);

		panelphone = new JPanel();
		panelphone.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelphone);
		panelphone.setLayout(new BoxLayout(panelphone, BoxLayout.X_AXIS));

		lbPhone = new JLabel("Số điện thoại");
		lbPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbPhone.setBackground(new Color(51, 102, 0));
		panelphone.add(lbPhone);

		panelphone.add(Box.createRigidArea(new Dimension(19, 20)));

		jtPhone = new JTextField();
		jtPhone.setColumns(10);
		panelphone.add(jtPhone);

		panelphone.add(Box.createRigidArea(new Dimension(50, 20)));

		panelemail = new JPanel();
		panelemail.setBackground(SystemColor.controlHighlight);
		inputpanel.add(panelemail);
		panelemail.setLayout(new BoxLayout(panelemail, BoxLayout.X_AXIS));

		panelemail.add(Box.createRigidArea(new Dimension(50, 20)));

		lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbEmail.setBackground(new Color(51, 102, 0));
		panelemail.add(lbEmail);

		panelemail.add(Box.createRigidArea(new Dimension(112, 20)));

		jtEmail = new JTextField();
		jtEmail.setColumns(10);
		panelemail.add(jtEmail);

		paneladdress = new JPanel();
		paneladdress.setBackground(SystemColor.controlHighlight);
		inputpanel.add(paneladdress);
		paneladdress.setLayout(new BoxLayout(paneladdress, BoxLayout.X_AXIS));

		lbAdress = new JLabel("Địa chỉ");
		lbAdress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbAdress.setBackground(new Color(51, 102, 0));
		paneladdress.add(lbAdress);

		paneladdress.add(Box.createRigidArea(new Dimension(55, 20)));

		jtAdress = new JTextField();
		jtAdress.setColumns(10);
		paneladdress.add(jtAdress);

		paneladdress.add(Box.createRigidArea(new Dimension(50, 20)));

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		buttonpanel = new JPanel();
		buttonpanel.setBackground(SystemColor.controlHighlight);
		pnmain.add(buttonpanel);
		buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonpanel.setMaximumSize(new Dimension(1800, 100));

		btnAdd = new JButton("Thêm");
		// btnAdd.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		btnAdd.setBackground(SystemColor.activeCaption);
		buttonpanel.add(btnAdd);

		btnEdit = new JButton("Sửa");
		btnEdit.setBackground(SystemColor.activeCaption);
		buttonpanel.add(btnEdit);

		btnDel = new JButton("Xóa");
		btnDel.setBackground(SystemColor.activeCaption);
		buttonpanel.add(btnDel);

		btnback = new JButton("Quay Lại");
		btnback.setBackground(SystemColor.activeCaption);
		buttonpanel.add(btnback);

		pnmain.add(Box.createRigidArea(new Dimension(20, 20)));

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 51, 0)), "Danh Sách Khách Hàng",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 51, 0)));
		pnmain.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		panel.add(Box.createRigidArea(new Dimension(30, 20)));

		tablekhachhang = new JTable();
		tablekhachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int rowSelect = tablekhachhang.getSelectedRow();
				String maKhachHang = (String) tablekhachhang.getValueAt(rowSelect, 0);
				String sql = "select * from ffse1702026_user where maKH='" + maKhachHang + "'";
				try {
					ArrayList<KhachHang> listInFor = dbKhachHang.getInfo(sql);
					setText(listInFor.get(0).getMaKhackHang(), listInFor.get(0).getTenKhachHang(),
							listInFor.get(0).getQuan(), listInFor.get(0).getPhuong(), listInFor.get(0).getDiaChi(),
							listInFor.get(0).getPhone(), listInFor.get(0).getEmail(), listInFor.get(0).getMaCongTo());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(pnmain, e);
				}

			}
		});
		tablekhachhang.setBackground(SystemColor.activeCaption);
		tablekhachhang.setModel(modelTable);

		JScrollPane sctable = new JScrollPane();
		panel.add(sctable);
		sctable.setViewportView(tablekhachhang);

		panel.add(Box.createRigidArea(new Dimension(30, 20)));

	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					jKhachHang frame = new jKhachHang();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
