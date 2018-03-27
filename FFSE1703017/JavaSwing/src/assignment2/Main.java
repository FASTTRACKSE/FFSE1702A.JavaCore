package assignment2;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtAge;
	private JTable tblStudent;
	static ArrayList<Student> arrStudent = new ArrayList<Student>();
	final static String col[] = {"Mã","Tên","Tuổi"};
	private DefaultTableModel studentModal;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		JFrame fr = new JFrame("Quản lý sinh viên - Oracle");
		JButton btnUpdate = new JButton("Sửa");
		JButton btnNew = new JButton("Thêm");
		JButton btnDelete = new JButton("Xóa");
		JButton btnSave = new JButton("Save");
		JButton btnLoad = new JButton("Load");
		JButton btnExit = new JButton("Thoát");
		
		btnUpdate.setBounds(10,133,60, 30);
		btnNew.setBounds(80,133,68, 30);
		btnDelete.setBounds(158,133,60, 30);
		btnSave.setBounds(228, 133, 68, 30);
		btnLoad.setBounds(306, 133, 68, 30);
		btnExit.setBounds(384, 133, 68, 30);
		
		JLabel lblHeading = new JLabel("Chương trình quản lý sinh viên");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHeading.setBounds(10, 11, 440, 21);
		fr.getContentPane().add(lblHeading);
		fr.getContentPane().add(btnUpdate);
		fr.getContentPane().add(btnNew);
		fr.getContentPane().add(btnDelete);
		fr.getContentPane().add(btnSave);
		fr.getContentPane().add(btnLoad);
		fr.getContentPane().add(btnExit);
		fr.setSize(476,330);    
		fr.getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("Mã sinh viên:");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblID.setBounds(80, 50, 95, 14);
		fr.getContentPane().add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(194, 48, 180, 20);
		fr.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel lblName = new JLabel("Tên sinh viên:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(80, 75, 95, 14);
		fr.getContentPane().add(lblName);
		
		JLabel lblAge = new JLabel("Tuổi:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAge.setBounds(80, 100, 95, 14);
		fr.getContentPane().add(lblAge);
		
		JLabel lblMsg = new JLabel("Phải nhập số");
		lblMsg.setForeground(Color.RED);
		lblMsg.setBounds(264, 101, 110, 14);
		fr.getContentPane().add(lblMsg);
		lblMsg.setVisible(false);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(194, 73, 180, 20);
		fr.getContentPane().add(txtName);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(194, 98, 60, 20);
		fr.getContentPane().add(txtAge);
		
		studentModal = new DefaultTableModel(col, 0);
		tblStudent = new JTable(studentModal);
		JScrollPane sp = new JScrollPane(tblStudent);
		
		TitledBorder border = BorderFactory.createTitledBorder("Danh sách");
	    border.setTitleJustification(TitledBorder.LEFT);
	   	sp.setBorder(border);
		sp.setSize(440, 106);
		sp.setLocation(10, 174);
		fr.getContentPane().add(sp);
		
		fr.setVisible(true);    
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tblStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblStudent.getSelectedRow();
				Student st = arrStudent.get(i);
				txtID.setText(st.getID());
				txtName.setText(st.getName());
				txtAge.setText(String.valueOf(st.getAge()));
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isAge = Validation.chkInt(txtAge.getText());
				if (isAge) {
					lblMsg.setVisible(false);
					int i = tblStudent.getSelectedRow();
					String id = txtID.getText();
					String name = txtName.getText();
					int age = Integer.parseInt(txtAge.getText());
					Student stu = new Student(id, name, age);
					arrStudent.set(i, stu);
					studentModal = new DefaultTableModel(col, 0);
					setTblStudent(studentModal);
					tblStudent.setModel(studentModal);
					sp.setViewportView(tblStudent);
				} else {
					lblMsg.setVisible(true);
				}
			}
		});
		
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isAge = Validation.chkInt(txtAge.getText());
				if (isAge) {
					lblMsg.setVisible(false);
					String id = txtID.getText();
					String name = txtName.getText();
					int age = Integer.parseInt(txtAge.getText());
					Student st = new Student(id, name, age);
					arrStudent.add(st);
					studentModal = new DefaultTableModel(col, 0);
					setTblStudent(studentModal);
					tblStudent.setModel(studentModal);
					sp.setViewportView(tblStudent);
				} else {
					lblMsg.setVisible(true);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tblStudent.getSelectedRow();
				arrStudent.remove(i);
				studentModal = new DefaultTableModel(col, 0);
				setTblStudent(studentModal);
				tblStudent.setModel(studentModal);
				sp.setViewportView(tblStudent);
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(arrStudent);
				try {
					FileOutputStream fos = new FileOutputStream("Data.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(arrStudent);
					oos.close();fos.close();
					JOptionPane.showMessageDialog(fr,"Save file successful.","Alert",JOptionPane.WARNING_MESSAGE);
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(fr,"Save file unsuccessful.","Alert",JOptionPane.WARNING_MESSAGE); 
				}
			}
		});
		
		btnLoad.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				try {
					FileInputStream fis = new FileInputStream("Data.txt");
					ObjectInputStream ois = new ObjectInputStream(fis);
					arrStudent = (ArrayList<Student>) ois.readObject();
					fis.close();ois.close();
					studentModal = new DefaultTableModel(col, 0);
					setTblStudent(studentModal);
					tblStudent.setModel(studentModal);
					sp.setViewportView(tblStudent);
				} catch (Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(fr,"Load file unsuccessful.","Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fr.dispose();
			}
		});
		
	}
	
	static void setTblStudent(DefaultTableModel studentModal) {
		for (Student st : arrStudent) {
			String id = st.getID();
			String name = st.getName();
			int age = st.getAge();
			Object[] data = {id, name, age};
			studentModal.addRow(data);
		}
	}
}
