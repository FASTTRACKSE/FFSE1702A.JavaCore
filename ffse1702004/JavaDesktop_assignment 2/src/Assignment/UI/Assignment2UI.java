package Assignment.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

public class Assignment2UI extends JFrame {
	JLabel a, b, c, title , lop ;
	JTextField text, text1, text2;
	JButton b1, b2, b3, b4 , b5;
	JComboBox cb ;
	DefaultTableModel tb = new DefaultTableModel();
	final JTable tbl = new JTable(tb);
	ArrayList<Assignment2UI> list = new ArrayList<Assignment2UI>();

	
	public Assignment2UI() {
		super("Quản Lý Sinh Viên - Oracle ");
		addControls();
		addEvents();
	}

	private void addControls() {
		Container con = getContentPane();
		JPanel boxAll = new JPanel();
		boxAll.setLayout(new BoxLayout(boxAll, BoxLayout.Y_AXIS));
		con.add(boxAll);

		JLabel titleBox = new JLabel("chương trình quản lý sinh viên ");
		titleBox.setFont(new Font("Courier New", Font.ITALIC, 12));
		
		JPanel comboBox  = new JPanel();
		// set box2

		lop = new JLabel("Lớp : ");
		String ffse[]={"1702A","1702B","1703","1704"};
		 cb = new JComboBox(ffse);
		  
		comboBox.add(lop);
		comboBox.add(cb);
		

		JPanel box1 = new JPanel();
		// set box1

		a = new JLabel("mã sinh viên  : ");
		text = new JTextField(10);

		box1.add(a);
		box1.add(text);

		JPanel box2 = new JPanel();
		// set box2

		b = new JLabel("tên sinh viên : ");
		text1 = new JTextField(10);

		box2.add(b);
		box2.add(text1);

		JPanel box3 = new JPanel();
		// set box3
		c = new JLabel(" tuổi             : ");
		text2 = new JTextField(10);

		box3.add(c);
		box3.add(text2);

		// o button
		JPanel box = new JPanel();
		// set button

		b1 = new JButton("thêm");
		b5 = new JButton("Sửa");
		b3 = new JButton("xoá");
		b4 = new JButton("thoát");
		b2 = new JButton("nhập");
		box.add(b1);box.add(b5);box.add(b3);box.add(b4);box.add(b2);
		
		JLabel titleBox1 = new JLabel("danh sách : ");
		JPanel box4 = new JPanel();
		// set box4
		tb.addColumn("mã ID ");
		tb.addColumn("Tên ");
		tb.addColumn("Tuổi");
		tb.addColumn("Lớp ");

		JScrollPane sc = new JScrollPane(tbl);
		box4.setLayout(new BorderLayout());
		box4.add(sc, BorderLayout.CENTER);

		boxAll.add(titleBox);
		boxAll.add(comboBox);
		boxAll.add(box1);
		boxAll.add(box2);
		boxAll.add(box3);
		boxAll.add(box);
		boxAll.add(titleBox1);
		boxAll.add(box4);
		box.setLayout(new FlowLayout());

	}

	// đây là sự kiện

	ActionListener bt1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			luu();
		}
	};
	ActionListener bt5 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			sua();
		}
	};

	ActionListener bt2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			moi();
		}
	};
	ActionListener bt3 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			xoa();
		}
	};

	protected void luu() {
		String hsa = text.getText();
		String hsb = text1.getText();
		String hsc = text2.getText();
		String hsd = (String)cb.getItemAt(cb.getSelectedIndex());
		tb.addRow(new String[] { hsa, hsb, hsc,hsd });
		
		text.setText("");
		text1.setText("");
		text2.setText("");

	}

	public void moi() {
		
		
	}
	public void sua() {
		
		int row = tbl.getSelectedRow();
		int col = tbl.getSelectedColumn();

	}
	public void xoa() {

		int row = tbl.getSelectedRow();
		int col = tbl.getSelectedColumn();
		removeSelectedRows(tbl);
	}

	private void removeSelectedRows(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int[] rows = table.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			model.removeRow(rows[i] - i);
		}
	}

	private void addEvents() {

		b1.addActionListener(bt1);

		b2.addActionListener(bt2);
		
		b5.addActionListener(bt5);

		b3.addActionListener(bt3);
		// tuỳ chỉnh button thoát
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public void showWindow() {
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
