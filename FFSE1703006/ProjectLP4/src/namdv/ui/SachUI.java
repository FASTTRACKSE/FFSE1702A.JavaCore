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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class SachUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldSearch;
	private JTable tableResult;
	private JTextField textFieldMaSach;
	private JTextField textFieldTenSach;
	private JTextField textFieldTacGia;
	private JTextField textFieldNhaXuatBan;
	private JTextField textFieldNamXuatBan;
	private JTextField textFieldSLTong;
	private JTextField textFieldSLHienCo;
	private JButton btnThoat;

	/**
	 * Create the frame.
	 */
	public SachUI() {
		addControls();
		addEvents();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addControls() {
		// CENTER
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

		// Search
		JPanel panelSearch = new JPanel();
		FlowLayout fl_panelSearch = (FlowLayout) panelSearch.getLayout();
		fl_panelSearch.setHgap(10);
		panelSearch.setPreferredSize(new Dimension(10, 75));
		panelCenter.add(panelSearch);

		JComboBox cbBoxSearch = new JComboBox();
		cbBoxSearch.setModel(new DefaultComboBoxModel(new String[] { "Mã sách", "Tên sách" }));
		panelSearch.add(cbBoxSearch);

		textFieldSearch = new JTextField(20);
		panelSearch.add(textFieldSearch);

		JButton btnSearch = new JButton("Tìm");
		panelSearch.add(btnSearch);

		JScrollPane scrollPaneResult = new JScrollPane();
		panelCenter.add(scrollPaneResult);

		tableResult = new JTable();
		tableResult.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã sách", "Tên sách", "Thời gian",
				"Nhà xuất bản", "Thể loại", "Năm xuất bản", "Tổng", "Hiện có" }));
		scrollPaneResult.setViewportView(tableResult);

		JPanel panel = new JPanel();
		panelCenter.add(panel);

		JPanel panelButton = new JPanel();
		FlowLayout fl_panelButton = (FlowLayout) panelButton.getLayout();
		fl_panelButton.setHgap(30);
		panelButton.setPreferredSize(new Dimension(10, 75));
		panelCenter.add(panelButton);

		JButton btnThem = new JButton("Thêm");
		panelButton.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		panelButton.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		panelButton.add(btnXoa);

		// Thông tin sách
		JPanel panelThongTinSach = new JPanel();
		panelThongTinSach.setBorder(
				new TitledBorder(null, "Thông tin sách", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCenter.add(panelThongTinSach);
		panelThongTinSach.setLayout(new BoxLayout(panelThongTinSach, BoxLayout.Y_AXIS));

		// Panel 1
		JPanel panelSub_1 = new JPanel();
		panelThongTinSach.add(panelSub_1);
		panelSub_1.setLayout(new BoxLayout(panelSub_1, BoxLayout.X_AXIS));

		JPanel panelMaSach = new JPanel();
		panelSub_1.add(panelMaSach);

		JLabel lblMaSach = new JLabel("Mã sách: ");
		lblMaSach.setPreferredSize(new Dimension(80, 20));
		panelMaSach.add(lblMaSach);

		textFieldMaSach = new JTextField();
		panelMaSach.add(textFieldMaSach);
		textFieldMaSach.setColumns(20);

		JPanel panelTheLoai = new JPanel();
		panelSub_1.add(panelTheLoai);

		JLabel lblTheLoai = new JLabel("Thể loại: ");
		lblTheLoai.setPreferredSize(new Dimension(80, 20));
		panelTheLoai.add(lblTheLoai);

		JComboBox cbBoxTheLoai = new JComboBox();
		cbBoxTheLoai.setPreferredSize(new Dimension(165, 22));
		panelTheLoai.add(cbBoxTheLoai);

		// Panel 2
		JPanel panelSub_2 = new JPanel();
		panelThongTinSach.add(panelSub_2);
		panelSub_2.setLayout(new BoxLayout(panelSub_2, BoxLayout.X_AXIS));

		JPanel panelTenSach = new JPanel();
		panelSub_2.add(panelTenSach);

		JLabel lblTenSach = new JLabel("Tên sách: ");
		lblTenSach.setPreferredSize(new Dimension(80, 20));
		panelTenSach.add(lblTenSach);

		textFieldTenSach = new JTextField();
		panelTenSach.add(textFieldTenSach);
		textFieldTenSach.setColumns(20);

		JPanel panelNamXuatBan = new JPanel();
		panelSub_2.add(panelNamXuatBan);

		JLabel lblNamXuatBan = new JLabel("Năm xuất bản: ");
		lblNamXuatBan.setPreferredSize(new Dimension(80, 20));
		panelNamXuatBan.add(lblNamXuatBan);

		textFieldNamXuatBan = new JTextField();
		panelNamXuatBan.add(textFieldNamXuatBan);
		textFieldNamXuatBan.setColumns(20);

		// Panel 3
		JPanel panelSub_3 = new JPanel();
		panelThongTinSach.add(panelSub_3);
		panelSub_3.setLayout(new BoxLayout(panelSub_3, BoxLayout.X_AXIS));

		JPanel panelTacGia = new JPanel();
		panelSub_3.add(panelTacGia);

		JLabel lblTacGia = new JLabel("Tác giả: ");
		lblTacGia.setPreferredSize(new Dimension(80, 20));
		panelTacGia.add(lblTacGia);

		textFieldTacGia = new JTextField();
		panelTacGia.add(textFieldTacGia);
		textFieldTacGia.setColumns(20);

		JPanel panelSLTong = new JPanel();
		panelSub_3.add(panelSLTong);

		JLabel lblSLTong = new JLabel("SL tổng: ");
		lblSLTong.setPreferredSize(new Dimension(80, 20));
		panelSLTong.add(lblSLTong);

		textFieldSLTong = new JTextField();
		panelSLTong.add(textFieldSLTong);
		textFieldSLTong.setColumns(20);

		// Panel 4
		JPanel panelSub_4 = new JPanel();
		panelThongTinSach.add(panelSub_4);
		panelSub_4.setLayout(new BoxLayout(panelSub_4, BoxLayout.X_AXIS));

		JPanel panelNhaXuatBan = new JPanel();
		panelSub_4.add(panelNhaXuatBan);

		JLabel lblNhaXuatBan = new JLabel("Nhà xuất bản: ");
		lblNhaXuatBan.setPreferredSize(new Dimension(80, 20));
		panelNhaXuatBan.add(lblNhaXuatBan);

		textFieldNhaXuatBan = new JTextField();
		panelNhaXuatBan.add(textFieldNhaXuatBan);
		textFieldNhaXuatBan.setColumns(20);

		JPanel panelSLHienCo = new JPanel();
		panelSub_4.add(panelSLHienCo);

		JLabel lblSLHienCo = new JLabel("SL hiện có: ");
		lblSLHienCo.setPreferredSize(new Dimension(80, 20));
		panelSLHienCo.add(lblSLHienCo);

		textFieldSLHienCo = new JTextField();
		textFieldSLHienCo.setEditable(false);
		panelSLHienCo.add(textFieldSLHienCo);
		textFieldSLHienCo.setColumns(20);

		JPanel panel_1 = new JPanel();
		panelThongTinSach.add(panel_1);

		// FOOTER
		JPanel footer = new JPanel();
		btnThoat = new JButton("Thoát");
		footer.add(btnThoat);

		// ADD TO JPANEL
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelCenter);
		this.add(footer);
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
