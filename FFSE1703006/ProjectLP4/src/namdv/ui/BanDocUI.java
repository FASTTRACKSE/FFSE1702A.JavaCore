package namdv.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import namdv.model.BanDoc;
import namdv.model.BanDocModel;
import namdv.model.ComboItem;

public class BanDocUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textFieldSearch;
	private JTable tableResult;
	private JTextField textFieldId;
	private JTextField textFieldDiaChi;
	private JTextField textFieldHoTen;
	private JTextField textFieldEmail;
	private JTextField textFieldDienThoai;
	private JTable tableThongTinSachMuon;
	private JButton btnSearch, btnSua, btnXoa, btnThem, btnThoat;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBoxSearch, cbBoxThanhPho, cbBoxQuan, cbBoxPhuong;

	private DefaultTableModel tableResultModel = new DefaultTableModel(
			new String[] { "ID", "Tên", "Thành phố", "Email", "Điện thoại", "Số sách đang mượn" }, 0);
	private DefaultTableModel tableThongTinSachMuonModel = new DefaultTableModel(
			new Object[][] { { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null }, },
			new String[] { "Mã sách", "Tên sách mượn", "Tác giả" });
	private BanDocModel banDocModel = new BanDocModel();

	/**
	 * Create the panel.
	 */
	public BanDocUI() {
		addControls();
		addEvents();
	}

	private void addEvents() {
		btnSearch.addActionListener(new SearchListener());
		btnThem.addActionListener(new ThemListener());
		btnSua.addActionListener(new SuaListener());
		btnXoa.addActionListener(new XoaListener());
		btnThoat.addActionListener(new ThoatListener());

		tableResult.addMouseListener(new ClickTableResult());

		cbBoxThanhPho.addActionListener(new SelectThanhPhoListener());
		cbBoxQuan.addActionListener(new SelectQuanListener());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControls() {
		// CENTER
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

		// Search
		JPanel panelSearch = new JPanel();
		panelSearch.setPreferredSize(new Dimension(10, 75));
		panelCenter.add(panelSearch);

		cbBoxSearch = new JComboBox();
		cbBoxSearch.setModel(new DefaultComboBoxModel(new String[] { "ID", "Tên" }));
		panelSearch.add(cbBoxSearch);

		textFieldSearch = new JTextField();
		panelSearch.add(textFieldSearch);
		textFieldSearch.setColumns(20);

		btnSearch = new JButton("Tìm");
		panelSearch.add(btnSearch);

		JScrollPane scrollPaneResult = new JScrollPane();
		panelCenter.add(scrollPaneResult);

		tableResult = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		// tableResult.setAutoCreateRowSorter(true);
		// Canh giữa cell header table
		JTableHeader tableHeader_1 = tableResult.getTableHeader();
		tableHeader_1.setDefaultRenderer(new HeaderRenderer(tableResult));
		tableResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableResult.setModel(tableResultModel);
		scrollPaneResult.setViewportView(tableResult);

		JPanel panel = new JPanel();
		panelCenter.add(panel);

		JPanel panelButton = new JPanel();
		FlowLayout fl_panelButton = (FlowLayout) panelButton.getLayout();
		fl_panelButton.setHgap(30);
		panelButton.setPreferredSize(new Dimension(10, 75));
		panelCenter.add(panelButton);

		btnThem = new JButton("Thêm");
		panelButton.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setEnabled(false);
		panelButton.add(btnSua);

		btnXoa = new JButton("Xóa");
		panelButton.add(btnXoa);

		// Thông tin bạn đọc
		JPanel panelThongTinBanDoc = new JPanel();
		panelThongTinBanDoc.setBorder(
				new TitledBorder(null, "Thông tin bạn đọc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCenter.add(panelThongTinBanDoc);
		panelThongTinBanDoc.setLayout(new BoxLayout(panelThongTinBanDoc, BoxLayout.Y_AXIS));

		// Panel 1
		JPanel panelSub_1 = new JPanel();
		panelThongTinBanDoc.add(panelSub_1);
		panelSub_1.setLayout(new BoxLayout(panelSub_1, BoxLayout.X_AXIS));

		JPanel panelId = new JPanel();
		panelSub_1.add(panelId);

		JLabel lblId = new JLabel("ID: ");
		lblId.setPreferredSize(new Dimension(80, 22));
		panelId.add(lblId);

		textFieldId = new JTextField(20);
		textFieldId.setEditable(false);
		panelId.add(textFieldId);

		// set auto new id
		try {
			textFieldId.setText(banDocModel.getAutoId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JPanel panelDiaChi = new JPanel();
		panelSub_1.add(panelDiaChi);

		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		panelDiaChi.add(lblDiaChi);
		lblDiaChi.setPreferredSize(lblId.getPreferredSize());

		textFieldDiaChi = new JTextField(20);
		panelDiaChi.add(textFieldDiaChi);

		// Panel 2
		JPanel panelSub_2 = new JPanel();
		panelThongTinBanDoc.add(panelSub_2);
		panelSub_2.setLayout(new BoxLayout(panelSub_2, BoxLayout.X_AXIS));

		JPanel panelTen = new JPanel();
		panelSub_2.add(panelTen);

		JLabel lblTen = new JLabel("Tên: ");
		lblTen.setPreferredSize(lblId.getPreferredSize());
		panelTen.add(lblTen);

		textFieldHoTen = new JTextField(20);
		panelTen.add(textFieldHoTen);

		JPanel panelThanhPho = new JPanel();
		panelSub_2.add(panelThanhPho);

		JLabel lblThanhPho = new JLabel("Thành phố: ");
		lblThanhPho.setPreferredSize(lblId.getPreferredSize());
		panelThanhPho.add(lblThanhPho);

		cbBoxThanhPho = new JComboBox();
		cbBoxThanhPho.setPreferredSize(new Dimension(165, 22));
		panelThanhPho.add(cbBoxThanhPho);
		getThanhPho();

		// Panel 3
		JPanel panelSub_3 = new JPanel();
		panelThongTinBanDoc.add(panelSub_3);
		panelSub_3.setLayout(new BoxLayout(panelSub_3, BoxLayout.X_AXIS));

		JPanel panelEmail = new JPanel();
		panelSub_3.add(panelEmail);

		JLabel lblEmail = new JLabel("Email: ");
		panelEmail.add(lblEmail);
		lblEmail.setPreferredSize(lblId.getPreferredSize());

		textFieldEmail = new JTextField(20);
		panelEmail.add(textFieldEmail);

		JPanel panelQuan = new JPanel();
		panelSub_3.add(panelQuan);

		JLabel lblQuan = new JLabel("Quận: ");
		panelQuan.add(lblQuan);
		lblQuan.setPreferredSize(lblId.getPreferredSize());

		cbBoxQuan = new JComboBox();
		cbBoxQuan.setPreferredSize(new Dimension(165, 22));
		panelQuan.add(cbBoxQuan);

		// Panel 4
		JPanel panelSub_4 = new JPanel();
		panelThongTinBanDoc.add(panelSub_4);
		panelSub_4.setLayout(new BoxLayout(panelSub_4, BoxLayout.X_AXIS));

		JPanel panelDienThoai = new JPanel();
		panelSub_4.add(panelDienThoai);

		JLabel lblDienThoai = new JLabel("Điện thoại: ");
		panelDienThoai.add(lblDienThoai);
		lblDienThoai.setPreferredSize(lblId.getPreferredSize());

		textFieldDienThoai = new JTextField(20);
		panelDienThoai.add(textFieldDienThoai);

		JPanel panelPhuong = new JPanel();
		panelSub_4.add(panelPhuong);

		JLabel lblPhuong = new JLabel("Phường: ");
		panelPhuong.add(lblPhuong);
		lblPhuong.setPreferredSize(lblId.getPreferredSize());

		cbBoxPhuong = new JComboBox();
		cbBoxPhuong.setPreferredSize(new Dimension(165, 22));
		panelPhuong.add(cbBoxPhuong);

		// Thông tin sách mượn
		JLabel lblThongTinSachMuon = new JLabel("Thông tin sách mượn");
		panelThongTinBanDoc.add(lblThongTinSachMuon);

		JScrollPane scrollPaneThongTinSachMuon = new JScrollPane();
		panelThongTinBanDoc.add(scrollPaneThongTinSachMuon);

		tableThongTinSachMuon = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		// tableResult.setAutoCreateRowSorter(true);
		// Canh giữa cell header table
		JTableHeader tableHeader_2 = tableThongTinSachMuon.getTableHeader();
		tableHeader_2.setDefaultRenderer(new HeaderRenderer(tableThongTinSachMuon));
		tableThongTinSachMuon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableThongTinSachMuon.setModel(tableThongTinSachMuonModel);
		scrollPaneThongTinSachMuon.setViewportView(tableThongTinSachMuon);

		// FOOTER
		JPanel footer = new JPanel();
		btnThoat = new JButton("Thoát");
		footer.add(btnThoat);

		// ADD TO JPANEL
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(footer, BorderLayout.SOUTH);
	}

	private static class HeaderRenderer implements TableCellRenderer {
		DefaultTableCellRenderer renderer;

		public HeaderRenderer(JTable table) {
			renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
			renderer.setHorizontalAlignment(JLabel.CENTER);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int col) {
			return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		}
	}

	private void setText(String hoTen, String thanhPho, String quan, String phuong, String diaChi, String email,
			String dienThoai) {
		textFieldHoTen.setText(hoTen);
		ComboItem item;

		if (thanhPho == null) {
			cbBoxThanhPho.setSelectedIndex(0);
		} else {
			for (int i = 1; i < cbBoxThanhPho.getItemCount(); i++) {
				item = (ComboItem) cbBoxThanhPho.getItemAt(i);
				if (item.getKey().equals(thanhPho)) {
					cbBoxThanhPho.setSelectedIndex(i);
					break;
				}
			}

			for (int i = 1; i < cbBoxQuan.getItemCount(); i++) {
				item = (ComboItem) cbBoxQuan.getItemAt(i);
				if (item.getKey().equals(quan)) {
					cbBoxQuan.setSelectedIndex(i);
					break;
				}
			}

			for (int i = 1; i < cbBoxPhuong.getItemCount(); i++) {
				item = (ComboItem) cbBoxPhuong.getItemAt(i);
				if (item.getKey().equals(phuong)) {
					cbBoxPhuong.setSelectedIndex(i);
					break;
				}
			}
		}

		textFieldDiaChi.setText(diaChi);
		textFieldEmail.setText(email);
		textFieldDienThoai.setText(dienThoai);
	}

	private void addDataToTableResult(String[] where, String[] value) throws SQLException {
		ResultSet rs = banDocModel.getBanDoc(where, value);
		int row = 0;
		while ((rs != null) && (rs.next())) {
			tableResultModel.addRow(new Object[0]);
			tableResultModel.setValueAt(rs.getString("id"), row, 0);
			tableResultModel.setValueAt(rs.getString("ho_ten"), row, 1);
			tableResultModel.setValueAt(rs.getString("gsovn_tinhthanhpho.name"), row, 2);
			tableResultModel.setValueAt(rs.getString("email"), row, 3);
			tableResultModel.setValueAt(rs.getString("dien_thoai"), row, 4);
			tableResultModel.setValueAt(rs.getString("so_sach_dang_muon"), row, 5);
			row++;
		}
	}

	private class SearchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// reset table
				tableResultModel.setRowCount(0);
				String[] where = { null };
				int search = cbBoxSearch.getSelectedIndex();

				if (search == 0) {
					where[0] = "id";
				}
				if (search == 1) {
					where[0] = "ho_ten";
				}

				String[] value = { textFieldSearch.getText() };
				addDataToTableResult(where, value);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class ClickTableResult extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				// Load data to textfield + combobox
				btnSua.setEnabled(true);
				int row = tableResult.getSelectedRow();
				String[] where = { "id" };
				String[] value = { tableResultModel.getValueAt(row, 0).toString() };
				ResultSet rs = banDocModel.getBanDoc(where, value);
				rs.next();
				textFieldId.setText(rs.getString("id"));
				setText(rs.getString("ho_ten"), rs.getString("thanh_pho"), rs.getString("quan"), rs.getString("phuong"),
						rs.getString("dia_chi"), rs.getString("email"), rs.getString("dien_thoai"));

				// Load data to table
				tableThongTinSachMuonModel.setRowCount(0);
				rs = banDocModel.getDataSachChuaTra(value[0]);
				row = 0;
				while ((rs != null) && (rs.next())) {
					tableThongTinSachMuonModel.addRow(new Object[0]);
					tableThongTinSachMuonModel.setValueAt(rs.getString("id"), row, 0);
					tableThongTinSachMuonModel.setValueAt(rs.getString("ten"), row, 1);
					tableThongTinSachMuonModel.setValueAt(rs.getString("tac_gia"), row, 2);
					row++;
				}
				while (row < 3) {
					tableThongTinSachMuonModel.addRow(new Object[0]);
					row++;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private BanDoc GetDataInput() {
		String id = textFieldId.getText();
		String hoTen = textFieldHoTen.getText();
		String thanhPho = ((ComboItem) cbBoxThanhPho.getSelectedItem()).getKey();
		String quan = ((ComboItem) cbBoxQuan.getSelectedItem()).getKey();
		String phuong = ((ComboItem) cbBoxPhuong.getSelectedItem()).getKey();
		String diaChi = textFieldDiaChi.getText();
		String email = textFieldEmail.getText();
		String dienThoai = textFieldDienThoai.getText();
		if (hoTen.length() != 0 && diaChi.length() != 0 && thanhPho.length() != 0) {
			BanDoc banDoc = new BanDoc(id, hoTen, thanhPho, quan, phuong, diaChi, email, dienThoai);
			return banDoc;
		}
		return null;
	}

	private class ThemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// set auto new id
				textFieldId.setText(banDocModel.getAutoId());
				if (btnSua.isEnabled()) {
					// Nếu đang select row on table => đang sửa => reset
					btnSua.setEnabled(false);
					tableResult.getSelectionModel().clearSelection();
					setText(null, null, null, null, null, null, null);
				} else {
					BanDoc banDoc = GetDataInput();
					if (banDoc != null && banDocModel.addBanDoc(banDoc) > 0) {
						setText(null, null, null, null, null, null, null);
						textFieldId.setText(banDocModel.getAutoId());
						btnSearch.doClick();
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
					}
				}
				tableThongTinSachMuonModel.setRowCount(0);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class SuaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				BanDoc banDoc = GetDataInput();
				if (banDoc != null && banDocModel.editBanDoc(banDoc) > 0) {
					btnSearch.doClick();
					JOptionPane.showMessageDialog(null, "Sửa thành công!");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private class XoaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int row = tableResult.getSelectedRow();
				String id = tableResultModel.getValueAt(row, 0).toString();
				if (row != -1) {
					int reply = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu này không?",
							"Confirm to Delete?", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						if (banDocModel.deleteBanDoc(id) > 0) {
							tableResultModel.removeRow(row);
							setText(null, null, null, null, null, null, null);
							btnSearch.doClick();
							JOptionPane.showMessageDialog(null, "Xóa thành công!");
						}
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings({ "unchecked" })
	private void getThanhPho() {
		try {
			ComboItem item;
			cbBoxThanhPho.addItem(null);

			ResultSet rs = banDocModel.getThanhPho();
			while ((rs != null) && (rs.next())) {
				item = new ComboItem(rs.getString("matp"), rs.getString("name"));
				cbBoxThanhPho.addItem(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked" })
	private class SelectThanhPhoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				cbBoxQuan.removeAllItems();

				ComboItem item;
				Object tp = cbBoxThanhPho.getSelectedItem();

				if (tp != null) {
					String matp = ((ComboItem) tp).getKey();

					cbBoxQuan.addItem(null);

					ResultSet rs = banDocModel.getQuan(matp);
					while ((rs != null) && (rs.next())) {
						item = new ComboItem(rs.getString("maqh"), rs.getString("name"));
						cbBoxQuan.addItem(item);
					}
					cbBoxPhuong.setSelectedIndex(-1);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	@SuppressWarnings({ "unchecked" })
	private class SelectQuanListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				cbBoxPhuong.removeAllItems();

				ComboItem item;
				Object qh = cbBoxQuan.getSelectedItem();
				if (qh != null) {
					String maqh = ((ComboItem) qh).getKey();

					cbBoxPhuong.addItem(null);

					ResultSet rs = banDocModel.getPhuong(maqh);
					while ((rs != null) && (rs.next())) {
						item = new ComboItem(rs.getString("xaid"), rs.getString("name"));
						cbBoxPhuong.addItem(item);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private class ThoatListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
