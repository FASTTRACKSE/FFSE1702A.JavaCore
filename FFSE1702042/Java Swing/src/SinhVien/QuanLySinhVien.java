package SinhVien;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

public class QuanLySinhVien extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField MaSV;
	private JTextField TenSV;
	private JTextField TuoiSV;
	private JTable table;
	private String[] columnNames = new String[] { "Mã", "Tên", "Tuổi" };
	private Object[][] data = new Object[][] { { "SV1", "Nguyễn Văn A", 19 }, { "SV2", "Nguyễn Văn B", 18 },
			{ "SV3", "Nguyễn Văn C", 20 }, { "SV4", "Nguyễn Văn D", 22 }, { "SV5", "Nguyễn Văn E", 19 },
			{ "SV6", "Nguyễn Văn F", 21 }, { "SV7", "Nguyễn Văn G", 20 }, { "SV8", "Nguyễn Văn H", 17 },
			{ "SV9", "Nguyễn Văn I", 20 }, { "SV10", "Nguyễn Văn J", 22 }, { "SV11", "Nguyễn Văn K", 18 },
			{ "SV12", "Nguyễn Văn L", 21 }, { "SV13", "Nguyễn Văn M", 17 }, { "SV14", "Nguyễn Văn N", 22 },
			{ "SV15", "Nguyễn Văn O", 19 }, };
	private DefaultTableModel model = new DefaultTableModel(data, columnNames);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLySinhVien window = new QuanLySinhVien();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuanLySinhVien() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Quản lý sinh viên - JunBjn");
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel title = new JLabel("Chương trình quản lí sinh viên");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblMaSV = new JLabel("Mã sinh viên:");

		JLabel lblTenSV = new JLabel("Tên sinh viên:");
		lblTenSV.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel lblTuoiSV = new JLabel("Tuổi:");

		MaSV = new JTextField();
		MaSV.setColumns(10);

		TenSV = new JTextField();
		TenSV.setColumns(10);

		TuoiSV = new JTextField();
		TuoiSV.setColumns(10);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new AddListener());

		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new EditListener());

		JButton btnDel = new JButton("Xóa");
		btnDel.addActionListener(new DelListener());

		JButton btnExit = new JButton("Thoát");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0)), "Danh s\u00E1ch", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(117)
						.addComponent(title, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE).addGap(114))
				.addGroup(groupLayout.createSequentialGroup().addGap(76)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblTenSV)
								.addComponent(lblMaSV).addComponent(lblTuoiSV))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(TuoiSV, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
								.addComponent(TenSV, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
								.addComponent(MaSV, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
						.addGap(86))
				.addGroup(groupLayout.createSequentialGroup().addGap(20)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE).addGap(25))
				.addGroup(groupLayout.createSequentialGroup().addGap(92)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnDel, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE).addGap(102)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(title, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(MaSV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaSV))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(TenSV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTenSV))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(TuoiSV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTuoiSV))
				.addGap(20)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnDel).addComponent(btnEdit)
						.addComponent(btnExit).addComponent(btnAdd))
				.addGap(18)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(27, Short.MAX_VALUE)));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		table = new JTable();
		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new HeaderRenderer(table));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		scrollPane.setViewportView(table);
		table.setPreferredScrollableViewportSize(new Dimension(350, 128));
		table.setModel(model);
		// table.getSelectionModel().addListSelectionListener(new SelectRowListener());

		frame.getContentPane().setLayout(groupLayout);
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

	private class AddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String maSV = MaSV.getText();
			String tenSV = TenSV.getText();
			String tuoiSV = TuoiSV.getText();
			if (maSV.length() != 0 && tenSV.length() != 0 && tuoiSV.length() != 0) {
				model.addRow(new Object[] { maSV, tenSV, tuoiSV });
				setText("", "", "");
			}
		}
	}

	/*private class SelectRowListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent event) {
			// TODO Auto-generated method stub
			int row = table.getSelectedRow();
			String maSV = model.getValueAt(row, 0).toString();
			String tenSV = model.getValueAt(row, 1).toString();
			String tuoiSV = model.getValueAt(row, 2).toString();
			MaSV.setText(maSV);
			TenSV.setText(tenSV);
			TuoiSV.setText(tuoiSV);
		}
	}*/

	private class EditListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String maSV = MaSV.getText();
			String tenSV = TenSV.getText();
			String tuoiSV = TuoiSV.getText();
			int row = table.getSelectedRow();
			if (row != -1) {
				if (maSV.length() == 0 | tenSV.length() == 0 | tuoiSV.length() == 0) {
					maSV = model.getValueAt(row, 0).toString();
					tenSV = model.getValueAt(row, 1).toString();
					tuoiSV = model.getValueAt(row, 2).toString();
					setText(maSV, tenSV, tuoiSV);
				} else {
					model.setValueAt(maSV, row, 0);
					model.setValueAt(tenSV, row, 1);
					model.setValueAt(tuoiSV, row, 2);
					setText("", "", "");
				}
			}
		}
	}

	private class DelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = table.getSelectedRow();
			if (row != -1) {
				model.removeRow(row);
			}
		}
	}
}
