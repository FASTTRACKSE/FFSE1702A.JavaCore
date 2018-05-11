package fasttrack.edu.vn.ui;

import java.sql.*;
import com.mysql.*;
import java.io.*;
import fasttrack.edu.vn.connection.ConnectSql;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class UIMyWindow extends JFrame {
	static Connection conn = ConnectSql.getConnect("localhost", "FFSE", "FFSE", "123456");
	JTextField txtA = new JTextField(15);
	JTextField txtB = new JTextField(15);
	JTextField txtC = new JTextField(15);
	String[] lop = {"FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	JComboBox cb = new JComboBox(lop);
	JButton btnAdd, btnEdit, btnExit, btnDel, btnSave, btnLoad;
	String[] col = {"Mã SV", "Tên SV", "Tuổi", "Lớp"};
	DefaultTableModel dm = new DefaultTableModel(col,0);
	final JTable tb = new JTable(dm);
	ArrayList<Sinhvien> arrSV = new ArrayList<Sinhvien>();
	public UIMyWindow(String title) {
		super(title);
		addControls();
		addEvents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		JPanel pnNorth = new JPanel();
		JLabel lbTitle = new JLabel("Chương trình quản lý sinh viên");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lbTitle.setFont(fontTitle);
		lbTitle.setForeground(Color.RED);
		pnNorth.add(lbTitle);
		
		JPanel pnBoxCenter = new JPanel();
		pnBoxCenter.setLayout(new BoxLayout(pnBoxCenter, BoxLayout.Y_AXIS));
		
		JPanel pnCb = new JPanel();
		JLabel lbCb = new JLabel("Lớp");
		Font fontCb = new Font("Arial", Font.BOLD, 15);
		lbCb.setFont(fontCb);
		pnCb.add(lbCb);
		pnCb.add(cb);
		pnBoxCenter.add(pnCb);		
		
		JPanel pnInput1 = new JPanel();
		JLabel lbTitle1 = new JLabel("Mã sinh viên");
		lbTitle1.setPreferredSize(new Dimension(100, 20));
		Font fontTitle1 = new Font("Arial", Font.BOLD, 15);
		lbTitle1.setFont(fontTitle1);
		pnInput1.add(lbTitle1);
		pnInput1.add(txtA);
		pnBoxCenter.add(pnInput1);

		JPanel pnInput2 = new JPanel();
		JLabel lbTitle2 = new JLabel("Tên sinh viên");
		lbTitle2.setPreferredSize(new Dimension(100, 20));
		Font fontTitle2 = new Font("Arial", Font.BOLD, 15);
		lbTitle2.setFont(fontTitle2);
		pnInput2.add(lbTitle2);
		pnInput2.add(txtB);
		pnBoxCenter.add(pnInput2);
		
		JPanel pnInput3 = new JPanel();
		JLabel lbTitle3 = new JLabel("Tuổi");
		lbTitle3.setPreferredSize(new Dimension(100, 20));
		Font fontTitle3 = new Font("Arial", Font.BOLD, 15);
		lbTitle3.setFont(fontTitle3);
		pnInput3.add(lbTitle3);
		pnInput3.add(txtC);
		pnBoxCenter.add(pnInput3);
		
		JPanel pnAction = new JPanel();
		btnAdd = new JButton("Nhập");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xoá");
		btnSave = new JButton("Lưu");
		btnLoad = new JButton("Mở");
		btnExit = new JButton("Thoát");
		pnAction.add(btnAdd);
		pnAction.add(btnEdit);
		pnAction.add(btnDel);
		pnAction.add(btnSave);
		pnAction.add(btnExit);
		pnAction.add(btnLoad);
		pnBoxCenter.add(pnAction);
		
		JPanel pnSouth = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Danh sách");
		pnSouth.setBorder(titleBorder);
		
		JScrollPane sc = new JScrollPane(tb);
		pnSouth.add(sc);
		
		pnMain.add(pnSouth, BorderLayout.SOUTH);
		pnMain.add(pnNorth, BorderLayout.NORTH);
		pnMain.add(pnBoxCenter, BorderLayout.CENTER);
		
		con.add(pnMain);
	}
	
	ActionListener eventAdd = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			add();
		}
	};
	
	ActionListener eventEdit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			edit();
		}
	};
	
	ActionListener eventSave = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			save();
			
		}
	};
	
	ActionListener eventLoad = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			load();
			
		}
	};
	
	ActionListener eventDel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			del();
			
		}
	};
	
	MouseAdapter eventClick = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tb.getSelectedRow();
			String[] row = new String[4];
			for(int j = 0; j < 4; j++) {
				row[j]=(String)tb.getValueAt(i,j);
			}
			txtA.setText(row[0]);
			txtB.setText(row[1]);
			txtC.setText(row[2]);
			cb.setSelectedItem(row[3]);
		}
	};
	
	public void add() {
		String id = txtA.getText();
		String name = txtB.getText();
		String age = txtC.getText();
		String cls = (String) cb.getSelectedItem();
		Sinhvien sv = new Sinhvien(id, name, age, cls);
		arrSV.add(sv);
		String[] row = {id, name, age, cls};
		dm.addRow(row);
		txtA.setText("");
		txtB.setText("");
		txtC.setText("");
	}
	
	public void edit() {
		String id = txtA.getText();
		String name = txtB.getText();
		String age = txtC.getText();
		String cls = (String) cb.getSelectedItem();
		int i = tb.getSelectedRow();
		Sinhvien sv = new Sinhvien(id, name, age, cls);
		arrSV.set(i, sv);
		String[] row = {id, name, age, cls};
		for(int j = 0; j < 4; j ++) {
			tb.setValueAt(row[j], i, j);
		}
		txtA.setText("");
		txtB.setText("");
		txtC.setText("");
 	}
	
	public void save() {
		try {
			FileOutputStream fos	=	new FileOutputStream("Data.txt");
			ObjectOutputStream oos	=	new ObjectOutputStream(fos);
			oos.writeObject(arrSV);
			oos.close();
			fos.close();
			JOptionPane.showMessageDialog(null,"Ghi file thành công.","Alert",JOptionPane.WARNING_MESSAGE);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,"Ghi file  thất bại.","Alert",JOptionPane.WARNING_MESSAGE); 
		}
	}
	
	public void load() {
		try {
			FileInputStream	fis	=	new FileInputStream("Data.txt");
			ObjectInputStream ois=	new ObjectInputStream(fis);
			arrSV	=	(ArrayList<Sinhvien>) ois.readObject();
			ois.close();
			fis.close();
			dm.setRowCount(0);
			for(Sinhvien st: arrSV) {
				String[] row	=	{st.getId(), st.getName(), st.getAge(), st.getCls()};
				dm.addRow(row);
			}
			JOptionPane.showMessageDialog(null,"Load file thành công.","Alert",JOptionPane.WARNING_MESSAGE);

		} catch (Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null,"Load file thất bại.","Alert",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void del() {
		int i=tb.getSelectedRow();
		arrSV.remove(i);
		dm.removeRow(i);
		txtA.setText("");
		txtB.setText("");
		txtC.setText("");
	}
	
	public void addEvents() {
		tb.addMouseListener(eventClick);
		btnEdit.addActionListener(eventEdit);
		btnAdd.addActionListener(eventAdd);
		btnSave.addActionListener(eventSave);
		btnLoad.addActionListener(eventLoad);
		btnDel.addActionListener(eventDel);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
	}
	
	public void showWindow() {
		this.setSize(600, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
