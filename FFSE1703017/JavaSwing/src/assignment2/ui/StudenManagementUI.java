package assignment2.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import assignment2.model.Student;
import assignment2.model.StudentModel;

public class StudenManagementUI extends JFrame {

	private static final long serialVersionUID = 1L;
	String[] items = {"FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704"};
	JComboBox<String> cbClass = new JComboBox<>(items);
	JButton btnNew = new JButton("Thêm");
    JButton btnUpdate = new JButton("Sửa");
    JButton btnDel = new JButton("Xóa");
    JButton btnExit = new JButton("Thoát");
    JTextField txtCode = new JTextField(15);
    JTextField txtName = new JTextField(15);
    JTextField txtAge = new JTextField(15);
    JScrollPane spList = new JScrollPane();
    JTable tblList = new JTable();
    String[] col = {"Mã","Tên","Tuổi"};
    DefaultTableModel modelList = new DefaultTableModel(col, 0);
    ArrayList<Student> arrStudent;
    String course = "FFSE1701";
    
    ActionListener eventSelectClass = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			course = (String) cbClass.getSelectedItem();
			arrStudent = StudentModel.getByCourse(course);
			modelList.setRowCount(0);
			for (Student st : arrStudent) {
				String[] row = {st.getCode(), st.getName(), st.getAge()};
				modelList.addRow(row);
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
    		txtCode.setText(row[0]);
    		txtName.setText(row[1]);
    		txtAge.setText(row[2]);
    	}
    };
	
	ActionListener eventNew = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String code = txtCode.getText();
			String name = txtName.getText();
			String age = txtAge.getText();
			if (isEmpty(code) || isEmpty(name) || isEmpty(age)) {
				JOptionPane.showMessageDialog(null,"Thông tin phải được nhập đầy đủ.","Alert",JOptionPane.WARNING_MESSAGE);
			} else if (!(checkAge(age))) {
				JOptionPane.showMessageDialog(null,"Tuổi phải nhập dạng số","Alert",JOptionPane.WARNING_MESSAGE);
			} else if (!(checkCode(code))) {
				JOptionPane.showMessageDialog(null,"Mã sinh viên đã tồn tại.","Alert",JOptionPane.WARNING_MESSAGE);
			} else {
				Student st = new Student(code, course, name, age);
				int x = StudentModel.addStudent(st);
				if (x > 0) {
					JOptionPane.showMessageDialog(null,"Thêm sinh viên thành công.","Alert",JOptionPane.WARNING_MESSAGE);
					String[] row = {code, name, age};
					modelList.addRow(row);
					txtCode.setText("");txtName.setText("");txtAge.setText("");
				} else {
					JOptionPane.showMessageDialog(null,"Thêm sinh viên thất bại.","Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	};
	ActionListener eventUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int i = tblList.getSelectedRow();
			if (i != -1) {
				String oldCode = (String) modelList.getValueAt(i, 0);
				String code = txtCode.getText();
				String name = txtName.getText();
				String age = txtAge.getText();
				boolean isCode = true;
				if (!(oldCode.equals(code))) {
					isCode = checkCode(code);
				}
				if (isEmpty(code) || isEmpty(name) || isEmpty(age)) {
					JOptionPane.showMessageDialog(null,"Thông tin phải được nhập đầy đủ.","Alert",JOptionPane.WARNING_MESSAGE);
				} else if (!(checkAge(age))) {
					JOptionPane.showMessageDialog(null,"Tuổi phải nhập dạng số.","Alert",JOptionPane.WARNING_MESSAGE);
				} else if (!(isCode)) {
					JOptionPane.showMessageDialog(null,"Mã sinh viên đã tồn tại.","Alert",JOptionPane.WARNING_MESSAGE);
				} else {
					
					Student st = new Student(code, name, age);
					int x = StudentModel.updateStudent(st, oldCode);
					if (x > 0) {
						String[] row = {code, name, age};
						for (int j = 0; j < 3; j++) {
							tblList.setValueAt(row[j], i, j);
						}
						txtCode.setText("");txtName.setText("");txtAge.setText("");
						JOptionPane.showMessageDialog(null,"Sửa sinh viên thành công.","Alert",JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,"Sửa sinh viên thất bại.","Alert",JOptionPane.WARNING_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null,"Không dòng nào được chọn.","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	ActionListener eventDel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int i = tblList.getSelectedRow();
			if (i != -1) {
				String code = (String) modelList.getValueAt(i, 0);
				int x = StudentModel.deleteStudent(code);
				if (x > 0) {
					modelList.removeRow(i);
					txtCode.setText("");txtName.setText("");txtAge.setText("");
					JOptionPane.showMessageDialog(null,"Xóa sinh viên thành công.","Alert",JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Xóa sinh viên thất bại.","Alert",JOptionPane.WARNING_MESSAGE);
				}
				
			} else {
				JOptionPane.showMessageDialog(null,"Không dòng nào được chọn.","Alert",JOptionPane.WARNING_MESSAGE);
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
        pnInputID.add(txtCode);
        
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
	
	public static boolean checkAge(String s) {
		try {
			Integer.parseInt(s.trim());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkCode (String s) {
		boolean isCode = true;
		ArrayList<Student> arr = StudentModel.getStudent();
		for (Student st : arr) {
			if (s.equals(st.getCode())) {
				isCode = false;
				break;
			}
		}
		return isCode;
	}

}
