package namdv.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import namdv.model.SinhVien;

public class QuanLySVUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelInput;
	private JTextField MaSV, TenSV, TuoiSV;
	@SuppressWarnings("rawtypes")
	private JComboBox LopSV;
	private JButton btnAdd, btnEdit, btnDel, btnExit, btnImport, btnExport;
	private JScrollPane scrollPane;
	private JTable table;
	private String[] columnNames = new String[] { "Lớp", "Mã", "Tên", "Tuổi" };
	private ArrayList<SinhVien> data = new ArrayList<SinhVien>();
	private DefaultTableModel model = new DefaultTableModel(columnNames, 0);

	public void showWindow() {
		this.setSize(450, 390);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public QuanLySVUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLabel header = new JLabel("Chương trình quản lí sinh viên");
		header.setPreferredSize(new Dimension(100, 30));
		header.setFont(new Font("Tahoma", Font.BOLD, 12));
		header.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

		panelInput = new JPanel();
		panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.Y_AXIS));

		panel.add(header, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);

		addInput();
		addButton();
		panelCenter.add(panelInput);

		addTable();
		panelCenter.add(scrollPane);

		con.add(panel);
	}

	public void addEvents() {
		btnAdd.addActionListener(new AddListener());
		btnEdit.addActionListener(new EditListener());
		btnDel.addActionListener(new DelListener());
		btnExit.addActionListener(new ExitListener());
		btnImport.addActionListener(new ImportListener());
		btnExport.addActionListener(new ExportListener());

		LopSV.addActionListener(new SelectListener());

		table.addMouseListener(new MouseClickRow());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addInput() {
		JPanel panelInput_MaSV = new JPanel();
		JLabel lblMaSV = new JLabel("Mã sinh viên:");
		lblMaSV.setPreferredSize(new Dimension(80, 20));
		MaSV = new JTextField(20);

		panelInput_MaSV.add(lblMaSV);
		panelInput_MaSV.add(MaSV);

		JPanel panelInput_TenSV = new JPanel();
		JLabel lblTenSV = new JLabel("Tên sinh viên:");
		lblTenSV.setPreferredSize(lblMaSV.getPreferredSize());
		TenSV = new JTextField(20);

		panelInput_TenSV.add(lblTenSV);
		panelInput_TenSV.add(TenSV);

		JPanel panelInput_TuoiSV = new JPanel();
		JLabel lblTuoiSV = new JLabel("Tuổi:");
		lblTuoiSV.setPreferredSize(lblMaSV.getPreferredSize());
		TuoiSV = new JTextField(20);

		panelInput_TuoiSV.add(lblTuoiSV);
		panelInput_TuoiSV.add(TuoiSV);

		JPanel panelInput_LopSV = new JPanel();
		JLabel lblLopSV = new JLabel("Lớp: ");
		lblLopSV.setPreferredSize(lblMaSV.getPreferredSize());
		String arrLopSV[] = { "FFSE1701", "FFSE1702", "FFSE1703" };
		LopSV = new JComboBox(arrLopSV);
		LopSV.setSelectedIndex(-1);

		panelInput_LopSV.add(lblLopSV);
		panelInput_LopSV.add(LopSV);

		panelInput.add(panelInput_LopSV);
		panelInput.add(panelInput_MaSV);
		panelInput.add(panelInput_TenSV);
		panelInput.add(panelInput_TuoiSV);
	}

	private void addButton() {
		JPanel panelButton = new JPanel();

		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		btnExit = new JButton("Thoát");
		btnImport = new JButton("Nhập");
		btnExport = new JButton("Xuất");

		panelButton.add(btnAdd);
		panelButton.add(btnEdit);
		panelButton.add(btnDel);
		panelButton.add(btnExit);
		panelButton.add(btnImport);
		panelButton.add(btnExport);

		panelInput.add(panelButton);
	}

	private void addTable() {
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0)), "Danh sách", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		table = new JTable();
		JTableHeader tableHeader = table.getTableHeader();
		// Canh giữa cell header table
		tableHeader.setDefaultRenderer(new HeaderRenderer(table));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setModel(model);
		scrollPane.setViewportView(table);
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

	private void setText(String maSV, String tenSV, String tuoiSV) {
		MaSV.setText(maSV);
		TenSV.setText(tenSV);
		TuoiSV.setText(tuoiSV);
	}

	private class SelectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			model.setRowCount(0);
			String selectLopSV = LopSV.getSelectedItem().toString();
			for (SinhVien sv : data) {
				if (sv.getLopSV().equals(selectLopSV)) {
					model.addRow(new Object[] { sv.getLopSV(), sv.getMaSV(), sv.getTenSV(), sv.getTuoiSV() });
				}
			}
			setText("", "", "");
		}
	}

	private class AddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (LopSV.getSelectedIndex() != -1) {
				String lopSV = LopSV.getSelectedItem().toString();
				String maSV = MaSV.getText();
				String tenSV = TenSV.getText();
				String tuoiSV = TuoiSV.getText();
				if (maSV.length() != 0 && tenSV.length() != 0 && tuoiSV.length() != 0) {
					data.add(new SinhVien(lopSV, maSV, tenSV, tuoiSV));

					model.addRow(new Object[] { lopSV, maSV, tenSV, tuoiSV });
					setText("", "", "");
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				}
			}
		}
	}

	private class MouseClickRow extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			String maSV = model.getValueAt(row, 1).toString();
			String tenSV = model.getValueAt(row, 2).toString();
			String tuoiSV = model.getValueAt(row, 3).toString();
			MaSV.setText(maSV);
			TenSV.setText(tenSV);
			TuoiSV.setText(tuoiSV);
		}
	}

	private class EditListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String maSV = MaSV.getText();
			String tenSV = TenSV.getText();
			String tuoiSV = TuoiSV.getText();
			int row = table.getSelectedRow();
			String maSV_Old = model.getValueAt(row, 1).toString();

			if (row != -1 && maSV.length() != 0 && tenSV.length() != 0 && tuoiSV.length() != 0) {
				for (int i = 0; i < data.size(); i++) {
					SinhVien sv = data.get(i);
					if (sv.getMaSV().equals(maSV_Old)) {
						sv.setMaSV(maSV);
						sv.setTenSV(tenSV);
						sv.setTuoiSV(tuoiSV);
						break;
					}
				}

				model.setValueAt(maSV, row, 1);
				model.setValueAt(tenSV, row, 2);
				model.setValueAt(tuoiSV, row, 3);
				setText("", "", "");
				JOptionPane.showMessageDialog(null, "Sửa thành công!");
			}
		}
	}

	private class DelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = table.getSelectedRow();
			String maSV = model.getValueAt(row, 1).toString();
			if (row != -1) {
				for (int i = 0; i < data.size(); i++) {
					SinhVien sv = data.get(i);
					if (sv.getMaSV().equals(maSV)) {
						data.remove(i);
						break;
					}
				}

				model.removeRow(row);
				setText("", "", "");
				JOptionPane.showMessageDialog(null, "Xóa thành công!");
			}
		}
	}

	private class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class ExportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			int i = fc.showSaveDialog((Component) e.getSource());
			if (i == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				String filepath = f.getPath();
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
					for (int k = 0; k < table.getRowCount(); k++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
							bw.write(table.getValueAt(k, j).toString() + ",");
						}
						bw.newLine();
					}
					bw.flush();
					bw.close();
					JOptionPane.showMessageDialog(null, "Xuất file thành công!");
				} catch (IOException ex) {
					System.err.println(ex);
				}
			}
		}
	}

	private class ImportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			int i = fc.showOpenDialog((Component) e.getSource());
			if (i == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				String filepath = f.getPath();
				try {
					BufferedReader br = new BufferedReader(new FileReader(filepath));

					Object[] lines = br.lines().toArray();

					for (int j = 0; j < lines.length; j++) {
						String[] row = lines[j].toString().split(",");
						data.add(new SinhVien(row[0], row[1], row[2], row[3]));
					}
					br.close();
					JOptionPane.showMessageDialog(null, "Thêm file thành công!");
				} catch (FileNotFoundException ex) {
					System.err.println(ex);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}