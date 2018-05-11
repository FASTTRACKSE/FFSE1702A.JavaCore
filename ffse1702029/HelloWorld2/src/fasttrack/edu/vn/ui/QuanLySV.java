package fasttrack.edu.vn.ui;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.BorderFactory;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.border.Border;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
//
//public class QuanLySV extends JFrame {
//		private JFrame frame;
//	 	private JTextField ma;
//	 	private JTextField ten;
//	 	private JTextField tuoi;
//	 	private JButton them;
//		private JButton sua;
//		private JButton xoa;
//	 	private JButton thoat;
//	 	private JButton nhap;
//	 	private DefaultTableModel bang;    
//
//	public QuanLySV(String title) {
//		super(title);
//		addControl();
//		addEvents();
//	}
//	public void addControl() {
//		Container con = getContentPane();
//		JPanel pnMain = new JPanel();
//		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
//			
//
//		 		JPanel pnFlow = new JPanel();
//		 		pnFlow.setLayout(new FlowLayout());
//		 		
//		 		them = new JButton("thêm");
//		 		them.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//		 		pnFlow.add(them);
//		 
//		 		sua = new JButton("sửa");
//		 		sua.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//		 		pnFlow.add(sua);
//		 
//		 		xoa = new JButton("Xóa");
//		 		xoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//		 		pnFlow.add(xoa);
//		 
//		 		thoat = new JButton("Thoát");
//		 		thoat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//		 		pnFlow.add(thoat);
//		 		
//		 		nhap = new JButton("xuất");
//		 		nhap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//		 		pnFlow.add(nhap);
//		 		
//		 		JPanel trong = new JPanel();
//		 		JLabel cach = new JLabel(" ");
//		 		trong.add(cach);
//		 
//		 		JPanel trong1 = new JPanel();
//				JLabel cach1 = new JLabel(" ");
//		 		trong1.add(cach);
//		 
//		 		JPanel trong2 = new JPanel();
//		 		JLabel cach2 = new JLabel(" ");
//		 		trong2.add(cach);
//		 
//		 		JPanel de = new JPanel();
//		 		JLabel pt = new JLabel("Chương trình quản lý sinh viên");
//		 		pt.setForeground(Color.BLUE);
//		 		pt.setFont(new Font("Times New Roman", Font.BOLD, 33));
//		 		pt.setHorizontalAlignment(SwingConstants.CENTER);
//		 		de.add(pt);
//		 
//		 		JPanel maSV = new JPanel();
//		 		JLabel nhap = new JLabel("Mã sinh viên:  ");
//		 		nhap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//		 		ma = new JTextField(25);
//		 		ma.setPreferredSize(new Dimension(80, 30));
//		 		maSV.add(nhap);
//		 		maSV.add(ma);
//		 
//		 		JPanel tenSV = new JPanel();
//		 		JLabel nhap1 = new JLabel("Tên sinh viên: ");
//		 		nhap1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//		 		ten = new JTextField(25);
//		 		ten.setPreferredSize(new Dimension(80, 30));
//		 		tenSV.add(nhap1);
//		 		tenSV.add(ten);
//		 
//		 		JPanel age = new JPanel();
//		 		JLabel age1 = new JLabel("Tuổi:               ");
//		 		age1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//		 		tuoi = new JTextField();
//		 		tuoi.setPreferredSize(new Dimension(80, 30));
//		 		tuoi.setColumns(25);
//		 		age.add(age1);
//		 		age.add(tuoi);
//		 		
//		 		JPanel pnTable = new JPanel();
//		 		DefaultTableModel bang = new DefaultTableModel();
//		 		Border border = BorderFactory.createLineBorder(Color.RED);
//		 		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh Sách");
//		 		pnTable.setBorder(borderTitle);
//		 		bang.addColumn("Mã");
//		 		bang.addColumn("Tên");
//		 		bang.addColumn("Tuổi");
//		 
//		 		JTable tbl = new JTable(bang);
//		 		bang.addRow(new String[] { "sv1", "Nguyễn Thị An", "19" });
//		 		bang.addRow(new String[] { "sv2", "Hồ Ngọc Tào Lao", "18" });
//		 		bang.addRow(new String[] { "sv3", "Trần Thị Hạnh", "20" });
//		 		bang.addRow(new String[] { "sv4", "Nguyễn Văn Phúc", "22" });
//		 		bang.addRow(new String[] { "sv5", "Phạm Văn Giải", "19" });
//		 		bang.addRow(new String[] { "sv6", "Hồ Cố Thoát", "21" });
//		 		bang.addRow(new String[] { "sv7", "Trần Phạm Mẫn Nhi", "15" });
//		 		tbl.setModel(bang);
//		 		tbl.setRowHeight(30);
//		 
//		 		JScrollPane sc = new JScrollPane(tbl);
//		 		pnTable.setLayout(new BorderLayout());
//		 		pnTable.add(sc, BorderLayout.CENTER);
//		 
//		 		
//		 		pnMain.add(de);
//		 		pnMain.add(trong);
//		 		pnMain.add(maSV);
//		 		pnMain.add(tenSV);
//		 		pnMain.add(age);
//		 		pnMain.add(pnFlow);
//		 		pnTable.add(sc);
//		 		//pnTable.add();
//		 		pnMain.add(pnTable);
//		 		pnMain.add(trong1);
//		 		
//		 		pnMain.add(trong2);
//		 		
//		 		con.add(pnMain);
//		 		
//		 	
//		 		
//	
//	}
//	        
//	public void addEvents() {
//		 		
//		 		them.addActionListener(new ActionListener() {
//		 
//		 			public void actionPerformed(ActionEvent evt) {
//		 			if (ma.getText().equals("") && ten.getText().equals("") && tuoi.getText().equals("")) {
//		 			JOptionPane.showMessageDialog(null, "Nhập đầy đủ ba cột mã SV, tên SV và tuổi SV");
//		 			}
//		 			else {
//		 			bang.addRow(new String[] {ma.getText() , ten.getText() , tuoi.getText()});
//		 			}
//		 			}
//		 		});
//		 		
//		 		xoa.addActionListener(new ActionListener() {
//		 
//		 			public void actionPerformed(ActionEvent evt) {
//		 				String name=JOptionPane.showInputDialog(null,"chọn mã sinh viên");
//		 			}
//		 		});
//		 
//		 		thoat.addActionListener(new ActionListener() {
//		 
//		 			public void actionPerformed(ActionEvent evt) {
//		 				System.exit(0);
//		 			}
//		 		});
//		 	}
//	private void setText(String maSV, String tenSV, String tuoiSV) {
//		ma.setText(maSV);
//		ten.setText(tenSV);
//		tuoi.setText(tuoiSV);
//	}
//	private class AddListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String maSV = ma.getText();
//			String tenSV = ten.getText();
//			String tuoiSV = tuoi.getText();
//			if (maSV.length() != 0 && tenSV.length() != 0 && tuoiSV.length() != 0) {
//				bang.addRow(new Object[] { maSV, tenSV, tuoiSV });
//				setText("", "", "");
//			}
//		}
//	}
//	public void showWindow() {
//		this.setSize(600, 550);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setLocationRelativeTo(null);
//		this.setVisible(true);
//	}
//}


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class QuanLySV extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelInput;
	private JTextField MaSV, TenSV, TuoiSV;
	private JScrollPane scrollPane;
	private JTable table;
	private String[] columnNames = new String[] { "Mã", "Tên", "Tuổi" };
	private Object[][] data = null;
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
					new QuanLySV("Quản lý sinh viên").showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void showWindow() {
		this.setSize(450, 390);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public QuanLySV(String title) {
		super(title);
		addControls();
		
	}
	public void addControls() {
		Container con = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));

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

	private void addInput() {
		JPanel panelInput_MaSV = new JPanel();
		JLabel lblMaSV = new JLabel("Mã sinh viên:");
		lblMaSV.setPreferredSize(new Dimension(80, 20));
		MaSV = new JTextField();
		MaSV.setColumns(20);

		panelInput_MaSV.add(lblMaSV);
		panelInput_MaSV.add(MaSV);

		JPanel panelInput_TenSV = new JPanel();
		JLabel lblTenSV = new JLabel("Tên sinh viên:");
		lblTenSV.setPreferredSize(new Dimension(80, 20));
		TenSV = new JTextField();
		TenSV.setColumns(20);

		panelInput_TenSV.add(lblTenSV);
		panelInput_TenSV.add(TenSV);

		JPanel panelInput_TuoiSV = new JPanel();
		JLabel lblTuoiSV = new JLabel("Tuổi:");
		lblTuoiSV.setPreferredSize(new Dimension(80, 20));
		TuoiSV = new JTextField();
		TuoiSV.setColumns(20);

		panelInput_TuoiSV.add(lblTuoiSV);
		panelInput_TuoiSV.add(TuoiSV);

		panelInput.add(panelInput_MaSV);
		panelInput.add(panelInput_TenSV);
		panelInput.add(panelInput_TuoiSV);
	}

	private void addButton() {
		JPanel panelButton = new JPanel();

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new AddListener());

		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new EditListener());

		JButton btnDel = new JButton("Xóa");
		btnDel.addActionListener(new DelListener());

		JButton btnExit = new JButton("Thoát");
		btnExit.addActionListener(new ExitListener());

		JButton btnImport = new JButton("Nhập");
		btnImport.addActionListener(new ImportListener());

		JButton btnExport = new JButton("Xuất");
		btnExport.addActionListener(new ExportListener());

		panelButton.add(btnAdd);
		panelButton.add(btnEdit);
		panelButton.add(btnDel);
		panelButton.add(btnExit);
		panelButton.add(btnImport);
		panelButton.add(btnExport);

		panelInput.add(panelButton);
	}

	@SuppressWarnings("serial")
	private void addTable() {
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0)), "Danh sách", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		table = new JTable() {
			public boolean getScrollableTracksViewportWidth() {
				return getPreferredSize().width < getParent().getWidth();
			}
		};
		JTableHeader tableHeader = table.getTableHeader();
		// Canh giữa cell header table
		tableHeader.setDefaultRenderer(new HeaderRenderer(table));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setModel(model);
		table.addMouseListener(new MouseClickRow());
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

	private class MouseClickRow extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			String maSV = model.getValueAt(row, 0).toString();
			String tenSV = model.getValueAt(row, 1).toString();
			String tuoiSV = model.getValueAt(row, 2).toString();
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
				setText("", "", "");
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
						model.addRow(row);
					}
					br.close();

				} catch (FileNotFoundException ex) {
					System.err.println(ex);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}