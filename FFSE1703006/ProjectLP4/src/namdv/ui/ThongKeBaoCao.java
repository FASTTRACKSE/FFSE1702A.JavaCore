package namdv.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class ThongKeBaoCao extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaThanhVien;
	private JTextField textFieldNhaXuatBan;
	private JTextField textFieldTheLoai;
	private JTextField textFieldTacGia;
	private JTable tableResult;
	private JRadioButton rdbtnDanhSachBanDoc, rdbtnThongKeDauSach;
	private JPanel panelOptionBanDoc, panelOptionSach;
	private JButton btnThoat;

	/**
	 * Create the frame.
	 */
	public ThongKeBaoCao() {
		addControls();
		addEvents();
	}

	@SuppressWarnings({ "rawtypes" })
	private void addControls() {
		// CENTER
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

		// Option
		JPanel panelOption = new JPanel();
		panelCenter.add(panelOption);

		JLabel lblBaoCao = new JLabel("Báo cáo: ");
		panelOption.add(lblBaoCao);

		rdbtnDanhSachBanDoc = new JRadioButton("Danh sách bạn đọc");
		panelOption.add(rdbtnDanhSachBanDoc);

		rdbtnThongKeDauSach = new JRadioButton("Thống kê đầu sách");
		panelOption.add(rdbtnThongKeDauSach);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnThongKeDauSach);
		bg.add(rdbtnDanhSachBanDoc);

		// Bạn đọc
		panelOptionBanDoc = new JPanel();
		panelOptionBanDoc.setVisible(false);
		panelOptionBanDoc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCenter.add(panelOptionBanDoc);
		panelOptionBanDoc.setLayout(new BoxLayout(panelOptionBanDoc, BoxLayout.Y_AXIS));

		JPanel panelSearchBanDoc = new JPanel();
		panelOptionBanDoc.add(panelSearchBanDoc);

		JLabel lblThanhPho = new JLabel("Thành phố:");
		panelSearchBanDoc.add(lblThanhPho);

		JComboBox cbBoxThanhPho = new JComboBox();
		panelSearchBanDoc.add(cbBoxThanhPho);

		JLabel lblMaThanhVien = new JLabel("       Mã thành viên:");
		panelSearchBanDoc.add(lblMaThanhVien);

		textFieldMaThanhVien = new JTextField();
		panelSearchBanDoc.add(textFieldMaThanhVien);
		textFieldMaThanhVien.setColumns(15);

		JButton btnTimBanDoc = new JButton("Tìm");
		panelSearchBanDoc.add(btnTimBanDoc);

		JPanel panelShowBanDoc = new JPanel();
		panelOptionBanDoc.add(panelShowBanDoc);

		JCheckBox chckbxMaBanDoc = new JCheckBox("Mã bạn đọc", true);
		panelShowBanDoc.add(chckbxMaBanDoc);

		JCheckBox chckbxTen = new JCheckBox("Tên", true);
		panelShowBanDoc.add(chckbxTen);

		JCheckBox chckbxDiaChi = new JCheckBox("Địa chỉ");
		panelShowBanDoc.add(chckbxDiaChi);

		JCheckBox chckbxPhuong = new JCheckBox("Phường");
		panelShowBanDoc.add(chckbxPhuong);

		JCheckBox chckbxQuan = new JCheckBox("Quận");
		panelShowBanDoc.add(chckbxQuan);

		JCheckBox chckbxThanhPho = new JCheckBox("Thành Phố", true);
		panelShowBanDoc.add(chckbxThanhPho);

		JCheckBox chckbxEmail = new JCheckBox("Email");
		panelShowBanDoc.add(chckbxEmail);

		JCheckBox chckbxDienThoai = new JCheckBox("Điện thoại");
		panelShowBanDoc.add(chckbxDienThoai);

		JCheckBox chckbxSoSachDangMuon = new JCheckBox("Số sách đang mượn", true);
		panelShowBanDoc.add(chckbxSoSachDangMuon);

		// Sách
		panelOptionSach = new JPanel();
		panelOptionSach.setVisible(false);
		panelOptionSach.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCenter.add(panelOptionSach);
		panelOptionSach.setLayout(new BoxLayout(panelOptionSach, BoxLayout.Y_AXIS));

		JPanel panelSearchSach = new JPanel();
		panelOptionSach.add(panelSearchSach);

		JLabel lblNhaXuatBan = new JLabel("Nhà xuất bản:");
		panelSearchSach.add(lblNhaXuatBan);

		textFieldNhaXuatBan = new JTextField();
		panelSearchSach.add(textFieldNhaXuatBan);
		textFieldNhaXuatBan.setColumns(15);

		JLabel lblTheLoai = new JLabel("       Thể loại:");
		panelSearchSach.add(lblTheLoai);

		textFieldTheLoai = new JTextField();
		panelSearchSach.add(textFieldTheLoai);
		textFieldTheLoai.setColumns(15);

		JLabel lblTacGia = new JLabel("       Tác giả:");
		panelSearchSach.add(lblTacGia);

		textFieldTacGia = new JTextField();
		panelSearchSach.add(textFieldTacGia);
		textFieldTacGia.setColumns(15);

		JButton btnTimSach = new JButton("Tìm");
		panelSearchSach.add(btnTimSach);

		JPanel panelShowSach = new JPanel();
		panelOptionSach.add(panelShowSach);

		JCheckBox chckbxMaSach = new JCheckBox("Mã sách", true);
		panelShowSach.add(chckbxMaSach);

		JCheckBox chckbxTenSach = new JCheckBox("Tên", true);
		panelShowSach.add(chckbxTenSach);

		JCheckBox chckbxTacGia = new JCheckBox("Tác giả");
		panelShowSach.add(chckbxTacGia);

		JCheckBox chckbxNhaXuatBan = new JCheckBox("Nhà xuất bản");
		panelShowSach.add(chckbxNhaXuatBan);

		JCheckBox chckbxTheLoi = new JCheckBox("Thể loại");
		panelShowSach.add(chckbxTheLoi);

		JCheckBox chckbxNamXuatBan = new JCheckBox("Năm xuất bản");
		panelShowSach.add(chckbxNamXuatBan);

		JCheckBox chckbxSoLuongTong = new JCheckBox("Số lượng tổng", true);
		panelShowSach.add(chckbxSoLuongTong);

		JCheckBox chckbxSoLuongTrongKho = new JCheckBox("Số lượng trong kho", true);
		panelShowSach.add(chckbxSoLuongTrongKho);

		// Search result
		JScrollPane scrollPaneResult = new JScrollPane();
		panelCenter.add(scrollPaneResult);

		tableResult = new JTable();
		scrollPaneResult.setViewportView(tableResult);

		// FOOTER
		JPanel footer = new JPanel();
		FlowLayout fl_footer = (FlowLayout) footer.getLayout();
		fl_footer.setHgap(15);

		JButton btnXuat = new JButton("Xuất báo cáo");
		footer.add(btnXuat);

		btnThoat = new JButton("Thoát");
		footer.add(btnThoat);

		// ADD TO JPANEL
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelCenter);
		this.add(footer);

	}

	private void addEvents() {
		// TODO Auto-generated method stub
		rdbtnDanhSachBanDoc.addActionListener(new DanhSachBanDocListener());
		rdbtnThongKeDauSach.addActionListener(new ThongKeDauSachListener());

		btnThoat.addActionListener(new ThoatListener());
	}

	private class DanhSachBanDocListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			panelOptionSach.setVisible(false);
			panelOptionBanDoc.setVisible(true);

			tableResult.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Mã bạn đọc", "Tên", "Thành phố", "Số sách đang mượn" }));
		}
	}

	private class ThongKeDauSachListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			panelOptionSach.setVisible(true);
			panelOptionBanDoc.setVisible(false);

			tableResult.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Mã sách", "Tên", "Số lượng tổng", "Số lượng trong kho" }));
		}
	}

	private class ThoatListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
