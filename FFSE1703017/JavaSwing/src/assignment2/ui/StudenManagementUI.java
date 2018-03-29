package assignment2.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	JButton btnNew = new JButton("New");
    JButton btnUpdate = new JButton("Update");
    JButton btnDel = new JButton("Delete");
    JButton btnSave = new JButton("Save");
    JButton btnLoad = new JButton("Load");
    JButton btnExit = new JButton("Exit");
    JTextField txtID = new JTextField(15);
    JTextField txtName = new JTextField(15);
    JTextField txtAge = new JTextField(15);
    JScrollPane spList = new JScrollPane();
    JTable tblList = new JTable();
    String[] col = {"Mã","Tên","Tuổi"};
    DefaultTableModel modelList = new DefaultTableModel(col, 0);
    ArrayList<Student> arrStudent = new ArrayList<Student>();
    
    MouseAdapter eventSelect = new MouseAdapter() {
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
			if (Validation.isEmpty(id) || Validation.isEmpty(name) || Validation.isEmpty(age)) {
				JOptionPane.showMessageDialog(null,"Input không được để trống.","Alert",JOptionPane.WARNING_MESSAGE);
			} else if (!(Validation.chkInt(age))) {
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
			String id = txtID.getText();
			String name = txtName.getText();
			String age = txtAge.getText();
			if (Validation.isEmpty(id) || Validation.isEmpty(name) || Validation.isEmpty(age)) {
				JOptionPane.showMessageDialog(null,"Input không được để trống.","Alert",JOptionPane.WARNING_MESSAGE);
			} else if (!(Validation.chkInt(age))) {
				JOptionPane.showMessageDialog(null,"Tuổi phải nhập số","Alert",JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					int i = tblList.getSelectedRow();
					Student st = new Student(id, name, age);
					arrStudent.set(i, st);
					String[] row = {id, name, age};
					for (int j = 0; j < 3; j++) {
						tblList.setValueAt(row[j], i, j);
					}
					txtID.setText("");txtName.setText("");txtAge.setText("");
					JOptionPane.showMessageDialog(null,"Update thành công.","Alert",JOptionPane.WARNING_MESSAGE);
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
				FileOutputStream fos = new FileOutputStream("Data.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(arrStudent);
				oos.close();fos.close();
				JOptionPane.showMessageDialog(null,"Ghi file thành công.","Alert",JOptionPane.WARNING_MESSAGE);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null,"Ghi file  thất bại.","Alert",JOptionPane.WARNING_MESSAGE); 
			}
		}
	};
	
	ActionListener eventLoad = new ActionListener() {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			try {
				FileInputStream fis = new FileInputStream("Data.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				arrStudent = (ArrayList<Student>) ois.readObject();
				fis.close();ois.close();
				modelList.setRowCount(0);
				for (Student st : arrStudent) {
					String[] row = {st.getID(), st.getName(), st.getAge()};
					modelList.addRow(row);
				}
				JOptionPane.showMessageDialog(null,"Load file thành công.","Alert",JOptionPane.WARNING_MESSAGE);

			} catch (Exception ex) {
				System.out.println(ex);
				JOptionPane.showMessageDialog(null,"Load file thất bại.","Alert",JOptionPane.WARNING_MESSAGE);
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
        pnAction.add(btnLoad);
        pnAction.add(btnExit);
        
        Border border = BorderFactory.createLineBorder(Color.RED);
        TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
        spList.setBorder(borderTitle);
        tblList.setModel(modelList);
        spList.setViewportView(tblList);
        
        pnMain.add(pnTitle);
        pnMain.add(pnInputID);
        pnMain.add(pnInputName);
        pnMain.add(pnInputAge);
        pnMain.add(pnAction);
        pnMain.add(spList);
        
        con.add(pnMain);

	}
	
	public void addEvents() {
		tblList.addMouseListener(eventSelect);
		btnNew.addActionListener(eventNew);
		btnUpdate.addActionListener(eventUpdate);
		btnDel.addActionListener(eventDel);
		btnSave.addActionListener(eventSave);
		btnLoad.addActionListener(eventLoad);
		btnExit.addActionListener(eventExit);
	}
	
	public void showWindow() {
	    this.setSize(600, 400);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}

}
