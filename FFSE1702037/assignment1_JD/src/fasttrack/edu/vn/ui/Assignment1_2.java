package fasttrack.edu.vn.ui;

import javax.swing.JFrame;

import java.io.*;
import java.awt.Color;
import java.awt.Container;
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

public class Assignment1_2 extends JFrame {
	JTextField txtID = new JTextField(15);
	JTextField txtName = new JTextField(15);
	JTextField txtAge = new JTextField(15);
	JButton btnNew, btnUpdate, btnDelete, btnSave, btnLoad, btnExit;
	String lop[] = { "FFSE1701", "FFSE1702", "FFSE1703" };
	JComboBox jcLop = new JComboBox(lop);
	JScrollPane spList = new JScrollPane();
	JTable tbList = new JTable();
	String tbSV[] = { "Ma SV", "Ten SV", "Tuoi", "Lop" };
	DefaultTableModel mdTable = new DefaultTableModel(tbSV, 0);
	ArrayList<Sinhvien> arrSV = new ArrayList<>();

	MouseAdapter evSelect = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int i = tbList.getSelectedRow();
			String[] row = new String[4];
			for (int j = 0; j < 4; j++) {
				row[j] = (String) tbList.getValueAt(i, j);
			}

			txtID.setText(row[0]);
			txtName.setText(row[1]);
			txtAge.setText(row[2]);
			jcLop.setSelectedItem(row[3]);
		}
	};

	ActionListener evNew = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

			String id = txtID.getText();
			String name = txtName.getText();
			String age = txtAge.getText();
			String clas = (String) jcLop.getSelectedItem();
			Sinhvien sv = new Sinhvien(id, name, age, clas);
			arrSV.add(sv);
			String[] row = { id, name, age, clas };
			mdTable.addRow(row);
			txtID.setText("");
			txtName.setText("");
			txtAge.setText("");
			jcLop.setSelectedItem("");
		}
	};
	ActionListener evUpdate = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String id = txtID.getText();
			String name = txtName.getText();
			String age = txtAge.getText();
			String clas = (String) jcLop.getSelectedItem();
			int i = tbList.getSelectedRow();
			Sinhvien sv = new Sinhvien(id, name, age, clas);
			arrSV.set(i, sv);
			String[] row = { id, name, age, clas };
			for (int j = 0; j < 4; j++) {
				tbList.setValueAt(row[j], i, j);
			}

			txtID.setText("");
			txtName.setText("");
			txtAge.setText("");
			jcLop.setSelectedItem("");
		}
	};
	ActionListener evDelete = new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {

			int i = tbList.getSelectedRow();
			arrSV.remove(i);
			mdTable.removeRow(i);
			txtID.setText("");
			txtName.setText("");
			txtAge.setText("");
			jcLop.setSelectedItem("");
		}
	};

	ActionListener evSave = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {

				FileOutputStream fos = new FileOutputStream("Sinhvien.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(arrSV);

				oos.close();
				fos.close();

				JOptionPane.showMessageDialog(null, "OK", "Alert", JOptionPane.WARNING_MESSAGE);

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "NO", "Alert", JOptionPane.WARNING_MESSAGE);
			}

		}
	};
	ActionListener evLoad = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				FileInputStream fis = new FileInputStream("Sinhvien.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				arrSV = (ArrayList<Sinhvien>) ois.readObject();
				ois.close();
				fis.close();
				mdTable.setRowCount(0);
				for (Sinhvien sv : arrSV) {
					String[] row = { sv.getId(), sv.getName(), sv.getAge(), sv.getClas() };
					mdTable.addRow(row);
				}
				;
				JOptionPane.showMessageDialog(null, "OK", "Alert", JOptionPane.WARNING_MESSAGE);

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "NO", "Alert", JOptionPane.WARNING_MESSAGE);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	};

	public Assignment1_2(String tieude) {
		super(tieude);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addControls();
		addEvents();
		addShowWindow();
	}

	public void addControls() {
		Container con = getContentPane();

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTittle = new JPanel();
		JLabel lbTittle = new JLabel("Quan Ly Sinh Vien");
		Font fTittle = new Font("arial", Font.BOLD, 20);
		lbTittle.setFont(fTittle);
		pnTittle.add(lbTittle);

		JPanel pnID = new JPanel();
		JLabel lbID = new JLabel("Nhap Ma Sinh Vien");
		Font fID = new Font("arial", Font.ITALIC, 15);
		lbID.setFont(fID);
		pnID.add(lbID);
		pnID.add(txtID);

		JPanel pnName = new JPanel();
		JLabel lbName = new JLabel("Nhap Ten Sinh Vien");
		Font fName = new Font("arial", Font.ITALIC, 15);
		lbName.setFont(fName);
		pnName.add(lbName);
		pnName.add(txtName);

		JPanel pnAge = new JPanel();
		JLabel lbAge = new JLabel("Nhap Tuoi                ");
		Font fAge = new Font("arial", Font.ITALIC, 15);
		lbAge.setFont(fAge);
		pnAge.add(lbAge);
		pnAge.add(txtAge);

		JPanel pnCls = new JPanel();
		JLabel lbCls = new JLabel("Lop");
		Font fCls = new Font("arial", Font.ITALIC, 15);
		lbCls.setFont(fCls);
		pnCls.add(lbCls);
		pnCls.add(jcLop);

		JPanel pnAction = new JPanel();
		btnNew = new JButton("Thêm");
		pnAction.add(btnNew);
		btnUpdate = new JButton("Sửa");
		pnAction.add(btnUpdate);
		btnDelete = new JButton("Xóa");
		pnAction.add(btnDelete);
		btnSave = new JButton("Lưu");
		pnAction.add(btnSave);
		btnLoad = new JButton("Tải");
		pnAction.add(btnLoad);
		btnExit = new JButton("Thoát");
		pnAction.add(btnExit);

		Border border = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder borderTittle = BorderFactory.createTitledBorder(border, "Danh Sach");
		spList.setBorder(borderTittle);
		tbList.setModel(mdTable);
		spList.setViewportView(tbList);

		pnMain.add(pnTittle);
		pnMain.add(pnID);
		pnMain.add(pnName);
		pnMain.add(pnAge);
		pnMain.add(pnCls);
		pnMain.add(pnAction);
		pnMain.add(spList);

		con.add(pnMain);

	}

	public void addEvents() {
		tbList.addMouseListener(evSelect);
		btnNew.addActionListener(evNew);
		btnUpdate.addActionListener(evUpdate);
		btnDelete.addActionListener(evDelete);
		btnSave.addActionListener(evSave);
		btnLoad.addActionListener(evLoad);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});

	}

	public void addShowWindow() {
		this.setSize(600, 400);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}

}
