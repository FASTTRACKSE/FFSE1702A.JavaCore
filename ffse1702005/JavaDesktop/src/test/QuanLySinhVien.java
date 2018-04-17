package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import java.awt.Panel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import java.awt.List;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class QuanLySinhVien {

	private JFrame frame;
	private JTextField mSV;
	private JTextField tSV;
	private JTextField tuoi;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblQunLSinh = new JLabel("Ch\u01B0\u01A1ng tr\u00ECnh qu\u1EA3n l\u00FD sinh vi\u00EAn\r\n");
		lblQunLSinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLSinh.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblMSinhVin = new JLabel("M\u00E3 sinh vi\u00EAn:");
		lblMSinhVin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMSinhVin.setHorizontalAlignment(SwingConstants.LEFT);
		
		mSV = new JTextField();
		mSV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mSV.setColumns(10);
		
		JLabel lblTnSinhVin = new JLabel("T\u00EAn sinh vi\u00EAn:");
		lblTnSinhVin.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnSinhVin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		tSV = new JTextField();
		tSV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tSV.setColumns(10);
		
		tuoi = new JTextField();
		tuoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tuoi.setColumns(10);
		
		JButton luu = new JButton("L\u01B0u");
		luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton moi = new JButton("M\u1EDBi");
		
		JButton xoa = new JButton("X\u00F3a");
		xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton thoat = new JButton("Tho\u00E1t");
		thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JLabel lblTui = new JLabel("Tu\u1ED5i:\r\n");
		lblTui.setHorizontalAlignment(SwingConstants.LEFT);
		lblTui.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3", "T\u00EAn", "Tu\u1ED5i"
			}
		));
		table.setBorder(UIManager.getBorder("TextField.border"));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		table.setEnabled(false);
		
		JLabel lblDanhSch = new JLabel("Danh s\u00E1ch:");
		lblDanhSch.setHorizontalAlignment(SwingConstants.LEFT);
		lblDanhSch.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblQunLSinh, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(76)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMSinhVin, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(mSV, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTnSinhVin, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(tSV, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTui, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
										.addComponent(luu, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(moi, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(xoa, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
											.addGap(34)
											.addComponent(thoat, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
										.addComponent(tuoi, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(lblDanhSch, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblQunLSinh)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(mSV, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMSinhVin))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tSV, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTnSinhVin, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTui, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuoi, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(luu, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(moi, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(thoat, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(xoa, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(lblDanhSch, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
