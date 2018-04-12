package namdv.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MuonSachUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldSearch;
	private JTextField textFieldMaBanDoc;
	private JTextField textFieldTen;
	private JTextField textFieldEmail;
	private JTextField textFieldDienThoai;
	private JTextField textFieldSachChuaTra;
	private JTable tableSachChuaTraDetail;
	private JTable tableThongTinSachResult;
	private JTable tableDanhSachMuon;
	private JTextField textFieldThanhPho;
	private JButton btnThoat;

	/**
	 * Create the panel.
	 */
	public MuonSachUI() {
		addControls();
		addEvents();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControls() {
		// Search
		JPanel panelSearch = new JPanel();
		FlowLayout fl_panelSearch = (FlowLayout) panelSearch.getLayout();
		fl_panelSearch.setVgap(15);

		JComboBox cbBoxSearch = new JComboBox();
		cbBoxSearch.setModel(new DefaultComboBoxModel(new String[] { "Mã sách", "Tên sách", "Tác giả" }));
		panelSearch.add(cbBoxSearch);

		textFieldSearch = new JTextField(20);
		panelSearch.add(textFieldSearch);

		JButton btnSearch = new JButton("Tìm");
		panelSearch.add(btnSearch);

		// Thông tin mượn sách
		JPanel panelThongTinMuonSach = new JPanel();
		panelThongTinMuonSach.setLayout(new BoxLayout(panelThongTinMuonSach, BoxLayout.X_AXIS));

		// Thông tin bạn đọc
		JPanel panelThongTinBanDoc = new JPanel();
		panelThongTinMuonSach.add(panelThongTinBanDoc);

		JPanel panelThongTinBanDocBorder = new JPanel();
		panelThongTinBanDocBorder.setPreferredSize(new Dimension(375, 325));
		panelThongTinBanDocBorder.setBorder(
				new TitledBorder(null, "Thông tin bạn đọc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinBanDoc.add(panelThongTinBanDocBorder);
		panelThongTinBanDocBorder.setLayout(new BoxLayout(panelThongTinBanDocBorder, BoxLayout.Y_AXIS));

		JPanel panelMaBanDoc = new JPanel();
		panelThongTinBanDocBorder.add(panelMaBanDoc);

		JLabel lblMaBanDoc = new JLabel("Mã bạn đọc: ");
		lblMaBanDoc.setPreferredSize(new Dimension(90, 20));
		panelMaBanDoc.add(lblMaBanDoc);

		textFieldMaBanDoc = new JTextField(20);
		textFieldMaBanDoc.setEditable(false);
		panelMaBanDoc.add(textFieldMaBanDoc);

		JPanel panelTen = new JPanel();
		panelThongTinBanDocBorder.add(panelTen);

		JLabel lblTen = new JLabel("Tên: ");
		lblTen.setPreferredSize(new Dimension(90, 20));
		panelTen.add(lblTen);

		textFieldTen = new JTextField(20);
		textFieldTen.setEditable(false);
		panelTen.add(textFieldTen);

		JPanel panelThanhPho = new JPanel();
		panelThongTinBanDocBorder.add(panelThanhPho);

		JLabel lblThanhPho = new JLabel("Thành phố: ");
		lblThanhPho.setPreferredSize(lblTen.getPreferredSize());
		panelThanhPho.add(lblThanhPho);

		textFieldThanhPho = new JTextField(20);
		textFieldThanhPho.setEditable(false);
		panelThanhPho.add(textFieldThanhPho);

		JPanel panelEmail = new JPanel();
		panelThongTinBanDocBorder.add(panelEmail);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setPreferredSize(lblTen.getPreferredSize());
		panelEmail.add(lblEmail);

		textFieldEmail = new JTextField(20);
		textFieldEmail.setEditable(false);
		panelEmail.add(textFieldEmail);

		JPanel panelDienThoai = new JPanel();
		panelThongTinBanDocBorder.add(panelDienThoai);

		JLabel lblDienThoai = new JLabel("Điện thoại: ");
		lblDienThoai.setPreferredSize(lblTen.getPreferredSize());
		panelDienThoai.add(lblDienThoai);

		textFieldDienThoai = new JTextField(20);
		textFieldDienThoai.setEditable(false);
		panelDienThoai.add(textFieldDienThoai);

		JPanel panelSachChuaTra = new JPanel();
		panelThongTinBanDocBorder.add(panelSachChuaTra);

		JLabel lblSachChuaTra = new JLabel("Sách chưa trả:");
		lblSachChuaTra.setPreferredSize(lblTen.getPreferredSize());
		panelSachChuaTra.add(lblSachChuaTra);

		textFieldSachChuaTra = new JTextField(20);
		textFieldSachChuaTra.setVisible(false);
		panelSachChuaTra.add(textFieldSachChuaTra);

		JPanel panelSachChuaTraDetail = new JPanel();
		panelThongTinBanDocBorder.add(panelSachChuaTraDetail);

		JScrollPane scrollPaneSachChuaTraDetail = new JScrollPane();
		scrollPaneSachChuaTraDetail.setPreferredSize(new Dimension(350, 80));
		panelSachChuaTraDetail.add(scrollPaneSachChuaTraDetail);

		tableSachChuaTraDetail = new JTable();
		tableSachChuaTraDetail.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "Mã sách", "Tên sách", "Tác giả" }));
		scrollPaneSachChuaTraDetail.setViewportView(tableSachChuaTraDetail);

		// Thông tin sách
		JPanel panelThongTinSach = new JPanel();
		panelThongTinMuonSach.add(panelThongTinSach);

		JPanel panelThongTinSachBorder = new JPanel();
		panelThongTinSachBorder.setPreferredSize(new Dimension(375, 325));
		panelThongTinSachBorder.setBorder(
				new TitledBorder(null, "Thông tin sách", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinSach.add(panelThongTinSachBorder);
		panelThongTinSachBorder.setLayout(new BoxLayout(panelThongTinSachBorder, BoxLayout.Y_AXIS));

		JPanel panelThongTinSachResult = new JPanel();
		panelThongTinSachBorder.add(panelThongTinSachResult);

		JScrollPane scrollPaneThongTinSachResult = new JScrollPane();
		panelThongTinSachResult.add(scrollPaneThongTinSachResult);
		scrollPaneThongTinSachResult.setPreferredSize(new Dimension(350, 150));

		tableThongTinSachResult = new JTable();
		tableThongTinSachResult
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã sách", "Tên sách", "Tác giả" }));
		scrollPaneThongTinSachResult.setViewportView(tableThongTinSachResult);

		JPanel panelThongTinSachButton = new JPanel();
		FlowLayout fl_panelThongTinSachButton = (FlowLayout) panelThongTinSachButton.getLayout();
		fl_panelThongTinSachButton.setHgap(25);
		panelThongTinSachBorder.add(panelThongTinSachButton);

		JButton btnThem = new JButton("Thêm vào DS mượn");
		panelThongTinSachButton.add(btnThem);

		JButton btnXoa = new JButton("Xóa khỏi DS mượn");
		panelThongTinSachButton.add(btnXoa);

		JPanel panelDanhSachMuon = new JPanel();
		panelThongTinSachBorder.add(panelDanhSachMuon);

		JScrollPane scrollPaneDanhSachMuon = new JScrollPane();
		panelDanhSachMuon.add(scrollPaneDanhSachMuon);
		scrollPaneDanhSachMuon.setPreferredSize(new Dimension(350, 80));

		tableDanhSachMuon = new JTable();
		tableDanhSachMuon.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "Mã sách", "Tên sách", "Tác giả" }));
		scrollPaneDanhSachMuon.setViewportView(tableDanhSachMuon);

		// FOOTER
		JPanel panelFooter = new JPanel();
		panelFooter.setLayout(new BoxLayout(panelFooter, BoxLayout.X_AXIS));

		JPanel panelButton = new JPanel();
		panelFooter.add(panelButton);

		JButton btnMuon = new JButton("Mượn sách");
		panelButton.add(btnMuon);

		JPanel panelThoatButton = new JPanel();
		panelFooter.add(panelThoatButton);

		btnThoat = new JButton("Thoát");
		panelThoatButton.add(btnThoat);

		// ADD TO JPANEL
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelSearch);
		this.add(panelThongTinMuonSach);
		this.add(panelFooter);
	}

	private void addEvents() {
		btnThoat.addActionListener(new ThoatListener());
	}

	private class ThoatListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
