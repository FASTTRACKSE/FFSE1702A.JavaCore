package Qlsv_ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.io.*;

public class QuanLiSinhVien_UI extends JFrame {
	JTextField txtID = new JTextField(15);
	JTextField txtName = new JTextField(15);
	JTextField txtAge = new JTextField(15);
	String lop[]	= {"FFSE1701", "FFSE1702","FFSE1703", "FFSE1704"};	
	JComboBox cb	= new 	JComboBox(lop);
	JButton btnNew = new JButton("Thêm");
	JButton btnUpdate = new JButton("Sửa");
	JButton btnDelete = new JButton("Xóa");
	JButton btnSave	  =	new JButton("Lưu");
	JButton btnLoad	  = new JButton("Tải");	
	JButton btnExit = new JButton("Thoát");
	JScrollPane spList = new JScrollPane();
	JTable tbList = new JTable();
	String[] col = { "Mã SV", "Tên SV", "Tuổi","Lớp" };
	DefaultTableModel mdList = new DefaultTableModel(col, 0);
	ArrayList<SinhVien> arrStd = new ArrayList<SinhVien>();

	MouseAdapter eventSelect=new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			int i=tbList.getSelectedRow();
			String[]row=new String[4];
			for(int j=0;j<4;j++){
				row[j]=(String)tbList.getValueAt(i,j);
				}
			txtID.setText(row[0]);
			txtName.setText(row[1]);
			txtAge.setText(row[2]);
		    cb.setSelectedItem(row[3]);
			}
		};
	

	ActionListener evNew=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String id=txtID.getText();
			String name=txtName.getText();
			String age=txtAge.getText();
			String cls= (String) cb.getSelectedItem(); 
			SinhVien st=new SinhVien(id,name,age, cls);
			arrStd.add(st);
			String[]row={id,name,age,cls};
			mdList.addRow(row);
			txtID.setText("");
			txtName.setText("");
			txtAge.setText("");
			cb.setSelectedItem("");
			}
		};
	
	ActionListener evUpdate=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String id=txtID.getText();
			String name=txtName.getText();
			String age=txtAge.getText();
			String cls= (String) cb.getSelectedItem();
			int i=tbList.getSelectedRow();
			SinhVien st=new SinhVien(id,name,age, cls);
			arrStd.set(i,st);
			String[]row={id,name,age, cls};
			for(int j=0;j<4;j++){
				tbList.setValueAt(row[j],i,j);
				}
			txtID.setText("");
			txtName.setText("");
			txtAge.setText("");
			cb.setSelectedItem("");
		}
	};


	ActionListener evDel=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int i=tbList.getSelectedRow();
			arrStd.remove(i);
			mdList.removeRow(i);
			txtID.setText("");
			txtName.setText("");
			txtAge.setText("");
			cb.setSelectedItem("");
			}
		};
	
	ActionListener evExit=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			System.exit(0);
			}
		};
	
	ActionListener evSave	=	new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				FileOutputStream fos	=	new FileOutputStream("Data.txt");
				ObjectOutputStream oos	=	new ObjectOutputStream(fos);
				oos.writeObject(arrStd);
				oos.close();
				fos.close();
				JOptionPane.showMessageDialog(null,"Ghi file thành công.","Alert",JOptionPane.WARNING_MESSAGE);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null,"Ghi file  thất bại.","Alert",JOptionPane.WARNING_MESSAGE); 
			}
		}
				
	};
	ActionListener evLoad	=	new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
			FileInputStream	fis	=	new FileInputStream("Data.txt");
			ObjectInputStream ois=	new ObjectInputStream(fis);
			arrStd	=	(ArrayList<SinhVien>) ois.readObject();
			ois.close();
			fis.close();
			mdList.setRowCount(0);
			for(SinhVien st: arrStd) {
				String[] row	=	{st.getID(), st.getName(), st.getAge(), st.getCls()};
				mdList.addRow(row);
			}
			JOptionPane.showMessageDialog(null,"Load file thành công.","Alert",JOptionPane.WARNING_MESSAGE);

		} catch (Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null,"Load file thất bại.","Alert",JOptionPane.WARNING_MESSAGE);
		}
			}
		
	};
	public QuanLiSinhVien_UI(String tieude) {
		super(tieude);
		addControls();
		addEvents();
	}

	private void addControls() {
		Container con	=	getContentPane();
		JPanel main		=	new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		
		JPanel pnTitle	=	new JPanel();
		JLabel lbTitle	=	new JLabel("Quản lí sinh viên");
		Font fTitle		=	new Font("arial", Font.BOLD, 20); 
		lbTitle.setFont(fTitle);
		pnTitle.add(lbTitle);
		
		JPanel pnID		=	new JPanel();
		JLabel lbID		=	new JLabel("Mã sinh viên");
		Font fID		=	new Font("arial", Font.ITALIC, 15);
		lbID.setFont(fID);
		pnID.add(lbID);
		pnID.add(txtID);
		
		JPanel pnName	=	new JPanel();
		JLabel lbName	=	new JLabel("Tên sinh viên");
		Font fName		=	new Font("arial", Font.ITALIC, 15);
		lbName.setFont(fName);
		pnName.add(lbName);
		pnName.add(txtName);
		
		JPanel pnAge	=	new JPanel();
		JLabel lbAge	=	new JLabel("Tuổi              ");
		Font fAge		=	new Font("arial", Font.ITALIC, 15);
		lbAge.setFont(fAge);
		pnAge.add(lbAge);
		pnAge.add(txtAge);
		
		JPanel pnCls	=	new JPanel();
		JLabel lbCls	=	new JLabel("Lớp");
		Font fCls		=	new Font("arial", Font.ITALIC, 15);
		lbAge.setFont(fCls);
		pnCls.add(lbCls);
		pnCls.add(cb);
		
		JPanel pnAction	=	new JPanel();
		pnAction.add(btnNew);
		pnAction.add(btnUpdate);
		pnAction.add(btnDelete);
		pnAction.add(btnSave);
		pnAction.add(btnLoad);
		pnAction.add(btnExit);
		
		
		Border border = BorderFactory.createLineBorder(Color.RED);
        TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
        spList.setBorder(borderTitle);
        tbList.setModel(mdList);
        spList.setViewportView(tbList);
        
        main.add(pnTitle);
        main.add(pnID);
        main.add(pnName);
        main.add(pnAge);
        main.add(pnCls);
        main.add(pnAction);
        main.add(spList);
        
        con.add(main);
	}

	private void addEvents() {
		tbList.addMouseListener(eventSelect);
		btnNew.addActionListener(evNew);
		btnUpdate.addActionListener(evUpdate);
		btnDelete.addActionListener(evDel);
		btnSave.addActionListener(evSave);
		btnLoad.addActionListener(evLoad);
		btnExit.addActionListener(evExit);
		
	}

	public void showWindow() {
		this.setSize(600,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}

