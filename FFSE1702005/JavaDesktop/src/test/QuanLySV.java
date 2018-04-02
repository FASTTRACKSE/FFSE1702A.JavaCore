package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;

public class QuanLySV extends JFrame {
	public QuanLySV(String tieude) {
		super(tieude);
		addControls();
		addEvents();

	}

	private JFrame frame;
	private JTextField ma;
	private JTextField ten;
	private JTextField tuoi;
	private JButton luu;
	private JButton thoat;
	private JButton xoa;
	private JButton moi;
	private DefaultTableModel bang;

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnFlow = new JPanel();
		pnFlow.setLayout(new FlowLayout());
		luu = new JButton("Lưu");
		luu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(luu);

		moi = new JButton("Mới");
		moi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(moi);

		xoa = new JButton("Xóa");
		xoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(xoa);

		thoat = new JButton("Thoát");
		thoat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(thoat);

		JPanel trong = new JPanel();
		JLabel cach = new JLabel(" ");
		trong.add(cach);

		JPanel trong1 = new JPanel();
		JLabel cach1 = new JLabel(" ");
		trong1.add(cach);

		JPanel trong2 = new JPanel();
		JLabel cach2 = new JLabel(" ");
		trong2.add(cach);

		JPanel de = new JPanel();
		JLabel pt = new JLabel("Chương trình quản lý sinh viên");
		pt.setForeground(Color.BLUE);
		pt.setFont(new Font("Times New Roman", Font.BOLD, 33));
		pt.setHorizontalAlignment(SwingConstants.CENTER);
		de.add(pt);

		JPanel maSV = new JPanel();
		JLabel nhap = new JLabel("Mã sinh viên:  ");
		nhap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ma = new JTextField(25);
		ma.setPreferredSize(new Dimension(80, 30));
		maSV.add(nhap);
		maSV.add(ma);

		JPanel tenSV = new JPanel();
		JLabel nhap1 = new JLabel("Tên sinh viên: ");
		nhap1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ten = new JTextField(25);
		ten.setPreferredSize(new Dimension(80, 30));
		tenSV.add(nhap1);
		tenSV.add(ten);

		JPanel age = new JPanel();
		JLabel age1 = new JLabel("Tuổi:               ");
		age1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		;
		tuoi = new JTextField();
		tuoi.setPreferredSize(new Dimension(80, 30));
		tuoi.setColumns(25);
		age.add(age1);
		age.add(tuoi);

		DefaultTableModel bang = new DefaultTableModel();
		bang.addColumn("Mã");
		bang.addColumn("Tên");
		bang.addColumn("Tuổi");

		JTable tbl = new JTable(bang);
		bang.addRow(new String[] { "112", "Ngô Văn Bắp", "21" });
		bang.addRow(new String[] { "113", "Nguyễn Thị Tý", "18" });
		bang.addRow(new String[] { "114", "Trần Văn Tèo", "22" });
		tbl.setModel(bang);
		tbl.setRowHeight(30);

		JScrollPane sc = new JScrollPane(tbl);
		con.setLayout(new BorderLayout());
		con.add(sc, BorderLayout.CENTER);

		pnMain.add(de);
		pnMain.add(trong);
		pnMain.add(maSV);
		pnMain.add(tenSV);
		pnMain.add(age);
		pnMain.add(trong1);
		pnMain.add(pnFlow);
		pnMain.add(trong2);
		pnMain.add(sc);

		con.add(pnMain);

	}

	public void addEvents() {
		
		moi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
			if (ma.getText().equals("") && ten.getText().equals("") && tuoi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Nhập đầy đủ ba cột mã SV, tên SV và tuổi SV");
			}
			else {
			bang.addRow(new String[] {ma.getText() , ten.getText() , tuoi.getText()});
			}
			}
		});
		
		xoa.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(null, "Chọn mã SV cần xóa");
			}
		});

		thoat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
	}

	public void showWindow() {
		this.setSize(650, 550);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String title = "Chương Trình Quản Lý Sinh Viên";
					QuanLySV myUI = new QuanLySV(title);
					myUI.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
