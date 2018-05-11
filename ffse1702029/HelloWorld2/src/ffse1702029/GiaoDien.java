	package ffse1702029;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class GiaoDien extends JFrame {
	DefaultTableModel model;
	String[] row;
	Data database= new Data();
	JButton btn_them, btn_luu, btn_xoa, btn_sua, btn_thoat;
	JLabel l1, l2, l3, l4, l5;
	JTextField txtma, txtten, txtnam, txtemail;
	JTable table;
	DanhSach ds = new DanhSach();
	public GiaoDien() {

		super("quản lý sinh viên"); //tên trang chính

		Data data=new Data();

		gui();
		try {
			loadData();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void loadData() throws Exception{
		 ds = database.readSV("data.txt");
		for(SinhVien sv:ds.getDs()) {
			String[] row = {sv.getMs()+"", sv.getHt(), sv.getTuoi()+"",sv.getEmail()};
			model.addRow(row);
		}
		
	}
	@Override
	public synchronized void addWindowListener(WindowListener arg0) {
		// TODO Auto-generated method stub
		
		super.addWindowListener(arg0);
	}

//	DefaultTableModel model;
//	Object ds;
	private void gui() {
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		b.add(b5);
		b.add(Box.createVerticalStrut(5));
		this.add(b,BorderLayout.NORTH);
		
		b1.add(l1 = new JLabel("Mã số"));
		b1.add(txtma = new JTextField(15));
		b2.add(l2 = new JLabel("Họ tên"));
		b2.add(txtten = new JTextField(15));
		b3.add(l3 = new JLabel("Năm sinh"));
		b3.add(txtnam = new JTextField(15));
		b4.add(l4 = new JLabel("Email"));
		b4.add(txtemail = new JTextField(15));
		l1.setPreferredSize(l3.getPreferredSize());
		l2.setPreferredSize(l3.getPreferredSize());
		l4.setPreferredSize(l3.getPreferredSize());
		JPanel panel = new JPanel();
		b5.add(panel);
		
		panel.add(btn_them = new JButton("thêm"));
		panel.add(btn_luu = new JButton("lưu"));
		panel.add(btn_xoa = new JButton("xóa"));
		panel.add(btn_sua = new JButton("sửa"));
		panel.add(btn_thoat = new JButton("thoát"));
		taotable();
		//Su kien nut them
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ms = txtma.getText();
				String ht = txtten.getText();
				String tuoi = txtnam.getText();
				String email = txtemail.getText();
				SinhVien sv = new SinhVien(ms, ht,Integer.parseInt(tuoi), email);
				ds.them(sv);
				try {
					database.write("Data.txt", ds);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] row = {ms, ht, tuoi, email};
				
				model.addRow(row);
			}
		}
		);
		//Su kien nut luu
		btn_luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtma.setText("Da bam nut them");
			}
		}
		);
		
		//Su kien nut xoa
		btn_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtma.setText("Da bam nut them");
			}
		}
		);
		
		//Su kien nut sua
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtma.setText("Da bam nut them");
			}
		}
		);
		
		//Su kien nut thoat
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtma.setText("Da bam nut them");
			}
		}
		);

		
	}
	private void taotable() {
		 model = new DefaultTableModel();
		 table = new JTable(model);
		model.addColumn("mã số");
		model.addColumn("họ tên");
		model.addColumn("Năm sinh");
		model.addColumn("email");
		JScrollPane sc = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(sc,BorderLayout.CENTER);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				txtma.setText(model.getValueAt(row, 0).toString());
				txtten.setText(model.getValueAt(row, 0).toString());
				txtnam.setText(model.getValueAt(row, 0).toString());
				txtemail.setText(model.getValueAt(row, 0).toString());
			}
		});
	}
	
}
