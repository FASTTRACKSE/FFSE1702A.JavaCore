package asm2.ui;

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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

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
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import asm2.model.MySQL;
import asm2.model.Sinhvien;

public class Asm2UI extends JFrame {
	JTextField txtID, txtName, txtAge;
	JButton btnAdd, btnEdit, btnDel, btnExit, btnWrite, btnRead;
	JTable table;
	JComboBox cb;
	ArrayList<Sinhvien> list = new ArrayList<Sinhvien>();
	String[] courseArray = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };
	Connection conn = MySQL.getConnect("localhost", "java", "java", "12345");

	public Asm2UI(String title) {
		super(title);
		addControls();
		addEvents();
		changeCourse();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Chương trình Quản lí sinh viên");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pnComboBox = new JPanel();
		JLabel lblComboBox = new JLabel("Chọn lớp");
		String[] course = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };
		cb = new JComboBox<>(course);
		pnComboBox.add(lblComboBox);
		pnComboBox.add(cb);

		JPanel pnInput1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Mã sinh viên");
		lblTitle1.setPreferredSize(new Dimension(80, 10));
		txtID = new JTextField(15);
		pnInput1.add(lblTitle1);
		pnInput1.add(txtID);

		JPanel pnInput2 = new JPanel();
		JLabel lblTitle2 = new JLabel("Tên sinh viên");
		lblTitle2.setPreferredSize(new Dimension(80, 10));
		txtName = new JTextField(15);
		pnInput2.add(lblTitle2);
		pnInput2.add(txtName);

		JPanel pnInput3 = new JPanel();
		JLabel lblTitle3 = new JLabel("Tuổi");
		lblTitle3.setPreferredSize(new Dimension(80, 10));
		txtAge = new JTextField(15);
		pnInput3.add(lblTitle3);
		pnInput3.add(txtAge);

		JPanel pnAction = new JPanel();
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		btnWrite = new JButton("Lưu File");
		btnRead = new JButton("Đọc File");
		btnExit = new JButton("Thoát");
		pnAction.add(btnAdd);
		pnAction.add(btnEdit);
		pnAction.add(btnDel);
		pnAction.add(btnWrite);
		pnAction.add(btnRead);
		pnAction.add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[] { "Mã", "Tên", "Tuổi" }, 0);
		table.setModel(model);
		scrollPane.setViewportView(table);

		pnMain.add(pnTitle);
		pnMain.add(pnComboBox);
		pnMain.add(pnInput1);
		pnMain.add(pnInput2);
		pnMain.add(pnInput3);
		pnMain.add(pnAction);
		pnMain.add(scrollPane);

		con.add(pnMain);
	}

	ActionListener eventAdd = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			add();
		}
	};

	public void add() {
		String iD = txtID.getText();
		String name = txtName.getText();
		int age = Integer.parseInt(txtAge.getText());
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] data = { iD, name, age };
		model.addRow(data);
		int indexSelectedCourse = cb.getSelectedIndex();

		try {
			String sql = "insert into students values (" + "'" + iD + "'" + "," + "'" + name + "'" + "," + "'" + age
					+ "'" + "," + "'" + courseArray[indexSelectedCourse] + "'" + ")";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Lưu OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		txtID.setText("");
		txtName.setText("");
		txtAge.setText("");
	}

	ActionListener eventDel = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			del();
		}
	};

	public void del() {
		int row = table.getSelectedRow();
		int modelRow = table.convertRowIndexToModel(row);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(modelRow);

		txtID.setText("");
		txtName.setText("");
		txtAge.setText("");
	}

	MouseListener eventGetRow = new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			getRow();
		}
	};

	public void getRow() {
		JTextField[] jTextField = { txtID, txtName, txtAge };
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int numberOfColumn = table.getColumnCount();
		int indexOfSelectedRow = table.getSelectedRow();
		for (int i = 0; i < numberOfColumn; i++) {
			String value = (String) (model.getValueAt(indexOfSelectedRow, i));
			jTextField[i].setText(value);
		}
	}

	ActionListener eventEdit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			edit();
		}
	};

	public void edit() {

		String iD = txtID.getText();
		String name = txtName.getText();
		int age = Integer.parseInt(txtAge.getText());

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int indexOfSelectedRow = table.getSelectedRow();
		String oldID = (String) model.getValueAt(indexOfSelectedRow, 0);
		model.setValueAt(iD, indexOfSelectedRow, 0);
		model.setValueAt(name, indexOfSelectedRow, 1);
		model.setValueAt(age, indexOfSelectedRow, 2);

		try {
			String sql = "update students set id=?, name=?, age=? where id=?";

			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, iD);
			stm.setString(2, name);
			stm.setInt(3, age);
			stm.setString(4, oldID);
			int x = stm.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void addEvents() {
		btnAdd.addActionListener(eventAdd);
		btnDel.addActionListener(eventDel);
		btnEdit.addActionListener(eventEdit);
		// btnWrite.addActionListener(eventAddToMySQL);
		// btnRead.addActionListener(eventReadFromMySQL);
		table.addMouseListener(eventGetRow);
		cb.addActionListener(eventChangeCourse);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	ActionListener eventChangeCourse = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			changeCourse();
		}
	};

	public void changeCourse() {
		int indexSelectedCourse = cb.getSelectedIndex();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(
					"select id,name,age from students where course =" + "'" + courseArray[indexSelectedCourse] + "'");
			while (result.next()) {
				Object[] data = { result.getString(1), result.getString(2), result.getString(3) };
				model.addRow(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
