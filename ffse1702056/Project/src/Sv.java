

//Import the Swing classes
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Sv {

	public JFrame frmTh;
	private JTable table_DiemDat;
	private JTable table_DiemKhongDat;
	private JPanel panel_2;

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private int j = 0, i = 0;
	private Object chart4;


	/**
	 * Launch the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sv window = new Sv();
					window.frmTh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public Sv() {
		initialize();
		// TODO Auto-generated constructor stub
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Sv(String name, String idsv) {
		// TODO Auto-generated constructor stub
		initialize();
		try {
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		showTableDiemDat(idsv);
		showTableDiemKhongDat(idsv);

		JLabel txtName = new JLabel(name + " - " + idsv);
		txtName.setForeground(new Color(255, 51, 153));
		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtName.setBounds(140, 11, 250, 19);
		panel_2.add(txtName);

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void showTableDiemDat(String idsv) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("STT");
		cols.addElement("ID Mon");
		cols.addElement("Ten Mon");
		cols.addElement("Diem 15p");
		cols.addElement("Diem 45p");
		cols.addElement("Diem Thi");
		cols.addElement("Tong Ket");
		cols.addElement("Ket Qua");
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.diem WHERE ketqua=? AND idsv=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "Dat");
			stmt.setString(2, idsv);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Vector sinhvien = new Vector();
				sinhvien.addElement((i++) + 1);
				sinhvien.addElement(rs.getString("idmon"));
				sinhvien.addElement(rs.getString("mon"));
				sinhvien.addElement(rs.getString("diem15"));
				sinhvien.addElement(rs.getString("diem45"));
				sinhvien.addElement(rs.getString("diemthi"));
				sinhvien.addElement(rs.getString("tongket"));
				sinhvien.addElement(rs.getString("ketqua"));
				data.add(sinhvien);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel txtCounta = new JLabel(Integer.toString(i));
		txtCounta.setBounds(133, 68, 21, 22);
		panel_2.add(txtCounta);
		table_DiemDat.setModel(new DefaultTableModel(data, cols));
		txtCounta.setForeground(new Color(255, 0, 0));
		txtCounta.setFont(new Font("Tahoma", Font.BOLD, 15));
	}

	public void showTableDiemKhongDat(String idsv) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("STT");
		cols.addElement("ID Mon");
		cols.addElement("Ten Mon");
		cols.addElement("Diem 15p");
		cols.addElement("Diem 45p");
		cols.addElement("Diem Thi");
		cols.addElement("Tong Ket");
		cols.addElement("Ket Qua");
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.diem WHERE ketqua=? AND idsv=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "Khong Dat");
			stmt.setString(2, idsv);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vector sinhvien = new Vector();
				sinhvien.addElement((j++) + 1);
				sinhvien.addElement(rs.getString("idmon"));
				sinhvien.addElement(rs.getString("mon"));
				sinhvien.addElement(rs.getString("diem15"));
				sinhvien.addElement(rs.getString("diem45"));
				sinhvien.addElement(rs.getString("diemthi"));
				sinhvien.addElement(rs.getString("tongket"));
				sinhvien.addElement(rs.getString("ketqua"));
				data.add(sinhvien);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		JLabel txtCountb = new JLabel(Integer.toString(j));
		txtCountb.setBounds(284, 68, 21, 20);
		panel_2.add(txtCountb);
		table_DiemKhongDat.setModel(new DefaultTableModel(data, cols));
		txtCountb.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtCountb.setForeground(new Color(255, 0, 0));

		JLabel label = new JLabel(Integer.toString(j + i));
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(255, 46, 18, 23);
		panel_2.add(label);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmTh = new JFrame();
		frmTh.setResizable(false);
		frmTh.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frmTh.setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lonely\\workspace\\ProjectDTD\\icon\\chart-icon.png"));
		frmTh.setTitle("Danh sách sinh viên");
		frmTh.setBounds(90, 235, 1007, 424);
		frmTh.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(452, 11, 538, 35);
		frmTh.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblCacMonDiem = new JLabel("Danh s\u00E1ch c\u00E1c m\u00F4n \u0111\u1EA1t  ");
		lblCacMonDiem.setForeground(new Color(255, 255, 255));
		lblCacMonDiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblCacMonDiem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(452, 57, 538, 135);
		frmTh.getContentPane().add(scrollPane);

		table_DiemDat = new JTable();
		scrollPane.setViewportView(table_DiemDat);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setBounds(452, 203, 538, 35);
		frmTh.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblDanhSchCc = new JLabel("Danh s\u00E1ch c\u00E1c m\u00F4n kh\u00F4ng \u0111\u1EA1t - phải học lại");
		lblDanhSchCc.setForeground(new Color(255, 255, 255));
		lblDanhSchCc.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblDanhSchCc);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(452, 249, 538, 135);
		frmTh.getContentPane().add(scrollPane_1);

		table_DiemKhongDat = new JTable();
		scrollPane_1.setViewportView(table_DiemKhongDat);

		// Initialize the dataset

		// Retun get a b;
		
		

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 448, 384);
		frmTh.getContentPane().add(panel_2);
		panel_2.setLayout(null);



		JLabel lblSinhVien = new JLabel("Sinh viên");
		lblSinhVien.setBounds(67, 11, 72, 20);
		panel_2.add(lblSinhVien);
		lblSinhVien.setForeground(new Color(0, 0, 153));
		lblSinhVien.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel txtTenBieuDo = new JLabel("Danh sách sinh viên");
		txtTenBieuDo.setBounds(56, 345, 337, 28);
		panel_2.add(txtTenBieuDo);
		txtTenBieuDo.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel txtTong = new JLabel("Tổng số môn học:       môn");
		txtTong.setBounds(123, 42, 230, 28);
		panel_2.add(txtTong);
		txtTong.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel txtCountKetQua = new JLabel("Đạt       môn  - Không đạt       môn");
		txtCountKetQua.setBounds(102, 68, 281, 20);
		panel_2.add(txtCountKetQua);
		txtCountKetQua.setFont(new Font("Tahoma", Font.BOLD, 15));

	}
}
