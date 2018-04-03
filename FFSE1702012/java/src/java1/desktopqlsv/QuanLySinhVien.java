package java1.desktopqlsv;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javadesktopqlsv.SinhVien;

public class QuanLySinhVien extends JFrame implements ActionListener{
	private static final MouseListener MouseEvent = null;
	private JLabel lbtitle, lblop, lbmasv, lbhoten, lbtuoi;
	private String combobox[] = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };
	private JComboBox cb = new JComboBox(combobox);
	private JButton btnAdd, btnEdit, btnExit, btnDel, btnSave, btnOpen;
	private JTable table;
	private JTextField tfmasv, tfhoten, tftuoi;
	private String[] cottieude = { "Mã", "Tên", "Tuổi", "Lớp" };
	DefaultTableModel tbmodel = new DefaultTableModel(cottieude, 0);
	ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();

	/*
	 * tao hàm dựng
	 */
	public QuanLySinhVien(String title) {
		super(title);
		addcontrols();
		addEvent();
	}
	/*
	 * phương thức showWindow
	 */
	public void showWindow() {
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	/*
	 * add events
	 */
	public void addEvent() {
		table.addMouseListener(eventSelect1);
		btnAdd.addActionListener(this);
		btnEdit.addActionListener(this);
		btnDel.addActionListener(this);
		btnExit.addActionListener(this);
		btnSave.addActionListener(this);
		btnOpen.addActionListener(this);
	}
	/*
	 * phuowng thức setText
	 */
	private void setText(String masv, String hoten, String tuoi, String lop) {
			// TODO Auto-generated method stub
			tfmasv.setText(masv);
			tfhoten.setText(hoten);
			tftuoi.setText(tuoi);
			cb.setSelectedItem(lop);
		}
	/*
	 * phương thức mouseEvent:
	 */
	MouseAdapter eventSelect1 = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = table.getSelectedRow();
			String[] row = new String[4];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) table.getValueAt(i, j);
			}
			tfmasv.setText(row[0]);
			tfhoten.setText(row[1]);
			tftuoi.setText(row[2]);
			cb.setSelectedItem(row[3]);
		}
	};
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton) e.getSource();
		if(bt == btnAdd)
		{
			String masv = tfmasv.getText();
			String hoten = tfhoten.getText();
			String tuoi = tftuoi.getText();
			String lop = (String) cb.getSelectedItem();
			SinhVien sv = new SinhVien(masv, hoten, tuoi, lop);
			arrSV.add(sv);
			String[] row = {masv, hoten, tuoi, lop};
			tbmodel.addRow(row);
			setText("","","","");
		}
		if(bt == btnEdit) 
		{
			int row = table.getSelectedRow();
			String masv = tfmasv.getText();
			String hoten = tfhoten.getText();
			String tuoi = tftuoi.getText();
			String lop = (String) cb.getSelectedItem();
			SinhVien sv = new SinhVien(masv, hoten, tuoi, lop);
			arrSV.add(sv);
			String field[] = {masv, hoten, tuoi, lop};
			for(int j=0; j<field.length;j++) 
			{
				tbmodel.setValueAt(field[j], row, j);
			}
			setText("", "", "", "");
		}
		if(bt == btnDel)
		{
			int row = table.getSelectedRow();
			arrSV.remove(row);
			tbmodel.removeRow(row);
		}
		if(bt == btnExit)
		{
			System.exit(0);
		}
		if(bt == btnSave)
		{
			try {
				FileOutputStream fos = new FileOutputStream("quan_lysv");
				ObjectOutputStream oos =  new ObjectOutputStream(fos);
				//ghi file:
				oos.writeObject(arrSV);
				//close
				fos.close();
				oos.close();
				JOptionPane.showMessageDialog(null,"Save file thành công");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(bt == btnOpen)
		{
			try {
				FileInputStream fis = new FileInputStream("quan_lysv");
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				//dojc file:
				arrSV	=	(ArrayList<SinhVien>) ois.readObject();
				ois.close();
				fis.close();
				tbmodel.setRowCount(0);
				for(SinhVien st: arrSV) {
					String[] row	=	{st.getLopSV(), st.getTenSV(), st.getTuoiSV(), st.getLopSV() };
					tbmodel.addRow(row);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	/*
	 * tao giao dien su dung
	 */
	public void addcontrols() {
		Container con = getContentPane();
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));

		// set JPanel cho title
		JPanel pntitle = new JPanel();
		lbtitle = new JLabel("Quản lý sinh viên");
		Font font = new Font("Arial", Font.BOLD,15 );
		lbtitle.setForeground(Color.RED);
		lbtitle.setFont(font);
		pntitle.add(lbtitle);
		// set Jpanel cho Combobox:
		JPanel pnCombobox = new JPanel();
		lblop = new JLabel("Chọn lớp");

		pnCombobox.add(lblop);
		pnCombobox.add(cb);
		// set Jpanel cho Mã sinh viên:
		JPanel pnmasv = new JPanel();
		lbmasv = new JLabel("Mã Sinh Viên");
		tfmasv = new JTextField(15);
		pnmasv.add(lbmasv);
		pnmasv.add(tfmasv);
		// set Jpanel cho ten sinh vien:
		JPanel pnhoten = new JPanel();
		lbhoten = new JLabel("Tên sinh viên");
		tfhoten = new JTextField(15);
		pnhoten.add(lbhoten);
		pnhoten.add(tfhoten);
		// set jPanel cho tuoi sinh viên:
		JPanel pntuoi = new JPanel();
		lbtuoi = new JLabel("Tuối sinh viên");
		tftuoi = new JTextField(15);
		pntuoi.add(lbtuoi);
		pntuoi.add(tftuoi);
		// set các button:
		JPanel pnbtn = new JPanel();
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		btnExit = new JButton("Thoát");
		btnSave = new JButton("Lưu");
		btnOpen = new JButton("Mở");
		pnbtn.add(btnAdd);
		pnbtn.add(btnEdit);
		pnbtn.add(btnDel);
		pnbtn.add(btnExit);
		pnbtn.add(btnOpen);
		pnbtn.add(btnSave);
		// set panel cho table:
		JPanel pntb = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.red);
		TitledBorder titlebd = BorderFactory.createTitledBorder(border, "Danh Sách");
		pntb.setBorder(titlebd);
		// table
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(500, 128));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tbmodel);
		// Scrollpane
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(table);
		pntb.add(sc);
		// add panel
		pnmain.add(pntitle);
		pnmain.add(pnCombobox);
		pnmain.add(pnmasv);
		pnmain.add(pnhoten);
		pnmain.add(pntuoi);
		pnmain.add(pnbtn);
		pnmain.add(pntb);
		// add vao container
		con.add(pnmain);
	}


}