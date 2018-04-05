package sinhvien.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class sinhVienUI extends JFrame {
	JButton them, moi, sua, xoa, thoat;
	JTable tbl;
	JComboBox cb;
	JTextField tx1,tx2,tx3;
	JLabel LTitle,maSv,tenSv,tuoi,ten,ds;
	DefaultTableModel dm = new DefaultTableModel();
	MouseAdapter eventClick = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int i = tbl.getSelectedRow();
			String[] row = new String[4];
			for (int j = 0; j < row.length; j++) {
				row[j] = (String) tbl.getValueAt(i, j);
			}
			tx1.setText(row[0]);
			tx2.setText(row[1]);
			tx3.setText(row[2]);
			cb.setSelectedItem(row[3]);
		}
	};
		ActionListener eventThem = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Them();
		}
		
		public void Them() {
			String a= tx1.getText();
			String b= tx2.getText();
			String c=tx3.getText();
			String d=(String)cb.getItemAt(cb.getSelectedIndex());
			Vector<String> vec = new Vector<String>();
			vec.add(a);
			vec.add(b);
			vec.add(c);
			vec.add(d);
			dm.addRow(vec);
		}
	};
	ActionListener evenMoi = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Moi();
		}

		public void Moi() {
			tx1.setText("");
			tx2.setText("");
			tx3.setText("");
		}

		
		
		
	};

	ActionListener eventXoa = new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
		   Xoa();
	   }
	   public void Xoa() {
		   int row = tbl.getSelectedRow();
		   if(row>-1) {
			   dm.removeRow(row);
		   } 
			   
		   
	   }
	};
  ActionListener eventSua = new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
			Sua();
			
		}
	  public void Sua() {
		  int row = tbl.getSelectedRow();
		  if(row>-1) {
			  
			  dm.setValueAt(tx1.getText(), row, 0);
			  dm.setValueAt(tx2.getText(), row, 1);
			  dm.setValueAt(tx3.getText(), row, 2);
			  dm.setValueAt((String)cb.getItemAt(cb.getSelectedIndex()), row, 3);
		  }
	  }
	
	
  };
	public sinhVienUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();
	}

	public void addControls() {
		// container
		Container con = getContentPane();
		// main chinh hien thi noi dung
		JPanel box = new JPanel();

		// cai dat cach sap xep
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		// tieu de
		JPanel Title = new JPanel();
        LTitle = new JLabel("Chương trình quản lý sinh viên");
		Font fonttitle = new Font("Arial", Font.BOLD, 20);
		LTitle.setFont(fonttitle);
		Title.add(LTitle);
		// ket thuc tieu de

		JPanel box1 = new JPanel();
	    maSv = new JLabel(" Mã sinh viên");
	    tx1 = new JTextField(20);
		Font fontmaSV = new Font("Arial", Font.BOLD, 20);
		maSv.setFont(fontmaSV);
		box1.add(maSv);
		box1.add(tx1);

		JPanel box2 = new JPanel();
		tenSv = new JLabel("Tên sinh viên");
		tx2 = new JTextField(20);
		Font fonttenSV = new Font("Arial", Font.BOLD, 20);
		tenSv.setFont(fonttenSV);
		box2.add(tenSv);
		box2.add(tx2);

		JPanel box3 = new JPanel();
		tuoi = new JLabel("              Tuổi");
		tx3 = new JTextField(20);
		Font fonttuoi = new Font("Arial", Font.BOLD, 20);
		tuoi.setFont(fonttuoi);
		box3.add(tuoi);
		box3.add(tx3);

		JPanel box4 = new JPanel();
		ds = new JLabel("Danh sách Sv");
		Font dsfont = new Font("Arial", Font.BOLD, 20);
		ds.setFont(dsfont);
		box4.add(ds);

		JPanel box5 = new JPanel();
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Lớp");
	    tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);
		Container con1 = getContentPane();
		con1.setLayout(new BorderLayout());
		con1.add(sc, BorderLayout.CENTER);
		box5.add(sc);

		JPanel box6 = new JPanel();
		them = new JButton("Thêm");
		moi = new JButton("Mới");
		sua = new JButton("Sửa");
		xoa = new JButton("Xóa");
		thoat = new JButton("Thoát");
		box6.add(them);
		box6.add(moi);
		box6.add(sua);
		box6.add(xoa);
		box6.add(thoat);

		JPanel box7 = new JPanel();
		ten = new JLabel("Tên Lớp:");
		Font fontten = new Font("Arial", Font.BOLD, 20);
		ten.setFont(fontten);
		String tenlop[] = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704", };
		 cb = new JComboBox(tenlop);
		box7.add(ten);
		box7.add(cb);

		box.add(Title);
		box.add(box7);
		box.add(box1);
		box.add(box2);
		box.add(box3);
		box.add(box4);
		box.add(box5);
		box.add(box6);
		con.add(box);

	}

	public void addEvents() {
		tbl.addMouseListener(eventClick);
		moi.addActionListener(evenMoi);
		them.addActionListener(eventThem);
		xoa.addActionListener(eventXoa);
		sua.addActionListener(eventSua);
		thoat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
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
}
