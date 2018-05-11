package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class QuanLySV extends JFrame {
	public QuanLySV(String tieude) {
		super(tieude);
		addControls();
		addEvents();

	}

	private JTextField ma;
	private JTextField ten;
	private JTextField tuoi;
	private JButton luu;
	private JButton thoat;
	private JButton xoa;
	private JButton moi;
	private JButton tai;
	ArrayList<SinhVien> arrStd = new ArrayList<SinhVien>();
	private DefaultTableModel bang;
	private JTable tbl;

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnFlow = new JPanel();
		pnFlow.setLayout(new FlowLayout());
		luu = new JButton("Lưu");
		luu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(luu);

		moi = new JButton("Thêm");
		moi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(moi);

		xoa = new JButton("Xóa");
		xoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(xoa);
		
		tai = new JButton("Tải");
		tai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(tai);

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
		tuoi = new JTextField();
		tuoi.setPreferredSize(new Dimension(80, 30));
		tuoi.setColumns(25);
		age.add(age1);
		age.add(tuoi);

		bang = new DefaultTableModel();
		bang.addColumn("Mã");
		bang.addColumn("Tên");
		bang.addColumn("Tuổi");

		tbl = new JTable(bang);
//		bang.addRow(new String[] { "112", "Ngô Văn Bắp", "21" });
//		bang.addRow(new String[] { "113", "Nguyễn Thị Tý", "18" });
//		bang.addRow(new String[] { "114", "Trần Văn Tèo", "22" });
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

	MouseAdapter eventSelect = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbl.getSelectedRow();
			String[] row = new String[3];
			for (int j = 0; j < 3; j++) {
				row[j] = (String) tbl.getValueAt(i, j);
			}
			ma.setText(row[0]);
			ten.setText(row[1]);
			tuoi.setText(row[2]);
		}
	};

	public void addEvents() {
		tbl.addMouseListener(eventSelect);

		luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					FileOutputStream fos = new FileOutputStream("test.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(arrStd);
					oos.close();
					fos.close();
					JOptionPane.showMessageDialog(null, "Đã lưu");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Lỗi khi lưu");
				}
			}
		});

		moi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				String id = ma.getText();
				String name = ten.getText();
				String age = tuoi.getText();
				SinhVien st = new SinhVien(id, name, age);
				if (id.equals("") && name.equals("") && age.equals("")) {
					JOptionPane.showMessageDialog(null, "Nhập đầy đủ ba cột mã SV, tên SV và tuổi SV");
				} else {
					arrStd.add(st);
					String[] row = { id, name, age };
					bang.addRow(row);
					ma.setText("");
					ten.setText("");
					tuoi.setText("");
				}
			}
		});

		xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (ma.getText().equals("") && ten.getText().equals("") && tuoi.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Chọn sinh viên để xóa");
				} else {
					int i = tbl.getSelectedRow();
					arrStd.remove(i);
					bang.removeRow(i);
					ma.setText("");
					ten.setText("");
					tuoi.setText("");
				}

			}
		});
		
		tai.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				FileInputStream	fis	=	new FileInputStream("test.txt");
				ObjectInputStream ois=	new ObjectInputStream(fis);
				arrStd	=	(ArrayList<SinhVien>) ois.readObject();
				ois.close();
				fis.close();
				bang.setRowCount(0);
				for(SinhVien st: arrStd) {
					String[] row = {st.getId(), st.getName(), st.getAge()};
					bang.addRow(row);
				}
				JOptionPane.showMessageDialog(null, "Đã tải dữ liệu");

			} catch (Exception ex) {
				System.out.println(ex);
				JOptionPane.showMessageDialog(null, "Lỗi khi tải.");
			}
				}
		});
		
		thoat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
				
			}
		});
	}
	
//	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
//        Connection conn = null;
//        String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?useUnicode=true&characterEncoding=utf-8";
//        Properties pro = new Properties();
//        pro.put("user", strUser);
//        pro.put("password", strPwd);
//        try {
//               Driver driver = new Driver();
//               conn = (Connection) driver.connect(strConnect, pro);
//        } catch (SQLException ex) {
//               ex.printStackTrace();
//        }
//        return conn;
// }
	
	

	public void showWindow() {
		this.setSize(650, 500);
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
