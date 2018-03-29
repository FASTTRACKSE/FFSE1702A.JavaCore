package assignment2.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class StudenManagementUI extends JFrame {

	private static final long serialVersionUID = 1L;
	String[] items = {"FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	JComboBox<String> cbClass = new JComboBox<>(items);
    int c;
	JButton btnNew = new JButton("Thêm");
    JButton btnUpdate = new JButton("Sửa");
    JButton btnDel = new JButton("Xóa");
    JButton btnSave = new JButton("Lưu");
    JButton btnExit = new JButton("Thoát");
    JTextField txtID = new JTextField(15);
    JTextField txtName = new JTextField(15);
    JTextField txtAge = new JTextField(15);
//    JTextField[] txt = new JTextField[] {txtID, txtName, txtAge};
    JScrollPane spList = new JScrollPane();
    JTable tblList = new JTable();
    String[] col = {"Mã","Tên","Tuổi"};
    DefaultTableModel modelList = new DefaultTableModel(col, 0);
    ArrayList<Student> arrStudent = new ArrayList<Student>();
    File file = new File("FFSE1701.txt");
    String[] filename = {"FFSE1701.txt", "FFSE1702.txt", "FFSE1703.txt", "FFSE1704.txt"};
    
    ActionListener eventSelectClass = new ActionListener() {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			c = cbClass.getSelectedIndex();
			file = new File(filename[c]);
			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				arrStudent = (ArrayList<Student>) ois.readObject();
				fis.close();ois.close();
				modelList.setRowCount(0);
				for (Student st : arrStudent) {
					String[] row = {st.getID(), st.getName(), st.getAge()};
					modelList.addRow(row);
				}
			} catch (Exception ex) {
				System.out.println(ex);
				JOptionPane.showMessageDialog(null,"Nạp tập tin thất bại.","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
    };
         
    MouseAdapter eventSelectRow = new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		int i = tblList.getSelectedRow();
    		String[] row = new String[3];
    		for (int j = 0; j < 3; j++) {
    			row[j] = (String) tblList.getValueAt(i, j);
    		}
    		txtID.setText(row[0]);
    		txtName.setText(row[1]);
    		txtAge.setText(row[2]);
    	}
    };
	
	ActionListener eventNew = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String id = txtID.getText();
			String name = txtName.getText();
			String age = txtAge.getText();
			if (isEmpty(id) || isEmpty(name) || isEmpty(age)) {
				JOptionPane.showMessageDialog(null,"Trường nhập không được để trống.","Alert",JOptionPane.WARNING_MESSAGE);
			} else if (!(chkInt(age))) {
				JOptionPane.showMessageDialog(null,"Tuổi phải nhập số","Alert",JOptionPane.WARNING_MESSAGE);
			} else {
				Student st = new Student(id, name, age);
				arrStudent.add(st);
				String[] row = {id, name, age};
				modelList.addRow(row);
				txtID.setText("");txtName.setText("");txtAge.setText("");
				JOptionPane.showMessageDialog(null,"Thêm sinh viên thành công.","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	ActionListener eventUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int i = tblList.getSelectedRow();
			String id = txtID.getText();
			String name = txtName.getText();
			String age = txtAge.getText();
			if (isEmpty(id) || isEmpty(name) || isEmpty(age)) {
				JOptionPane.showMessageDialog(null,"Trường nhập không được để trống.","Alert",JOptionPane.WARNING_MESSAGE);
			} else if (!(chkInt(age))) {
				JOptionPane.showMessageDialog(null,"Tuổi phải nhập số.","Alert",JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					Student st = new Student(id, name, age);
					arrStudent.set(i, st);
					String[] row = {id, name, age};
					for (int j = 0; j < 3; j++) {
						tblList.setValueAt(row[j], i, j);
					}
					txtID.setText("");txtName.setText("");txtAge.setText("");
					JOptionPane.showMessageDialog(null,"Sửa thành công.","Alert",JOptionPane.WARNING_MESSAGE);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Không dòng nào được chọn.","Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	};
	
	ActionListener eventDel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int i = tblList.getSelectedRow();
				arrStudent.remove(i);
				modelList.removeRow(i);
				txtID.setText("");txtName.setText("");txtAge.setText("");
				JOptionPane.showMessageDialog(null,"Xóa sinh viên thành công.","Alert",JOptionPane.WARNING_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Không dòng nào được chọn.","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	ActionListener eventSave = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(arrStudent);
				oos.close();fos.close();
				JOptionPane.showMessageDialog(null,"Lưu thành công.","Alert",JOptionPane.WARNING_MESSAGE);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null,"Lưu  thất bại.","Alert",JOptionPane.WARNING_MESSAGE); 
			}
		}
	};
	
	ActionListener eventExit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
	public StudenManagementUI (String title) {
		super(title);
        addControls();
        addEvents();
	}
	
	public void addControls () {
		Container con = getContentPane();
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JPanel pnTitle = new JPanel();
        JLabel lblTitle = new JLabel("Chương trình quản lý sinh viên");
        Font fontTitle = new Font("arial", Font.BOLD, 18);
        lblTitle.setFont(fontTitle);
        pnTitle.add(lblTitle);
        
        JPanel pnClass = new JPanel();
        JLabel lblClass = new JLabel("Chọn lớp: ");
        JLabel lblSpace = new JLabel("");
        lblSpace.setPreferredSize(new Dimension(100, 14));
        pnClass.add(lblSpace);
        pnClass.add(lblClass);
        pnClass.add(cbClass);
           
        JPanel pnInputID = new JPanel();
        JLabel lblID = new JLabel("Mã sinh viên:");
        lblID.setPreferredSize(new Dimension(80,14));
        pnInputID.add(lblID);
        pnInputID.add(txtID);
        
        JPanel pnInputName = new JPanel();
        JLabel lblName = new JLabel("Tên sinh viên:");
        lblName.setPreferredSize(new Dimension(80,14));
        pnInputName.add(lblName);
        pnInputName.add(txtName);
        
        JPanel pnInputAge = new JPanel();
        JLabel lblAge = new JLabel("Tuổi:");
        lblAge.setPreferredSize(new Dimension(80,14));
        pnInputAge.add(lblAge);
        pnInputAge.add(txtAge);
      
        JPanel pnAction = new JPanel();
        pnAction.add(btnNew);
        pnAction.add(btnUpdate);
        pnAction.add(btnDel);
        pnAction.add(btnSave);
        pnAction.add(btnExit);
        
        Border border = BorderFactory.createLineBorder(Color.RED);
        TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
        spList.setBorder(borderTitle);
        tblList.setModel(modelList);
        spList.setViewportView(tblList);
        
        pnMain.add(pnTitle);
        pnMain.add(pnClass);
        pnMain.add(pnInputID);
        pnMain.add(pnInputName);
        pnMain.add(pnInputAge);
        pnMain.add(pnAction);
        pnMain.add(spList);
        
        con.add(pnMain);

	}
	
	public void addEvents() {
		cbClass.addActionListener(eventSelectClass);
		tblList.addMouseListener(eventSelectRow);
		btnNew.addActionListener(eventNew);
		btnUpdate.addActionListener(eventUpdate);
		btnDel.addActionListener(eventDel);
		btnSave.addActionListener(eventSave);
		btnExit.addActionListener(eventExit);
	}
	
	public void showWindow() {
	    this.setSize(600, 400);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
	
	public static boolean isEmpty(String s) {
		return s.trim().isEmpty();
	}
	
	public static boolean chkInt(String s) {
		try {
			Integer.parseInt(s.trim());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
