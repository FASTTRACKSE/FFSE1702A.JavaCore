package Giaodien.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
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

public class GiaoDien extends JFrame implements ActionListener  {
	
	private JLabel l1,l2,l3;
	private JTextField txt_ma,txt_ten,txt_tuoi;
	private JButton btn_them,btn_sua,btn_xoa,btn_thoat,btn_luu;
	private DefaultTableModel model;
	private JTable table;
	private DataBase database;
	private DanhsachSV ds;
	
	public GiaoDien() {
		super("Quan Li Sinh Vien");
		database=new DataBase(); 
		ds = new DanhsachSV();
		gui();
		try {
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.addWindowListener(new WindowAdapter() {
			@Override 
			public void windowClosing(WindowEvent e) {
				dong();
			}
			private void dong() {
				try {
					database.writeSV("data.txt", ds);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(1);
			}
			@Override 
			public void windowClosed(WindowEvent e) {
			dong();
			}
		});
	}
	private void loadData() throws Exception {
		ds = database.readSV("data.txt");
		for(SinhVien sv:ds.getDs()) {
			String[] row = {sv.getMssv()+"",sv.getHoten(),sv.getTuoi()+""};
			model.addRow(row);
			
		}
		
	}

	private void gui() {
	Box b = Box.createVerticalBox();
	Box b1 = Box.createHorizontalBox();
	Box b2= Box.createHorizontalBox();
	Box b3 = Box.createHorizontalBox();
	Box b4 = Box.createHorizontalBox();
	b.add(b1);
	b.add(Box.createVerticalStrut(5));
	b.setLocation(20,300);
	b.add(b2);
	b.add(Box.createVerticalStrut(5));
	b.add(b3);
	b.add(Box.createVerticalStrut(5));
	b.add(b4);
	b.add(Box.createVerticalStrut(10));
	this.add(b,BorderLayout.NORTH);
	JLabel l1;
	b1.add(l1= new JLabel("Ma sinh vien"));
	b1.add(txt_ma = new JTextField(20));
	b2.add(l2= new JLabel ("Ten sv"));
	b2.add(txt_ten = new JTextField(20));
	b3.add(l3 = new JLabel("Tuoi sv"));
	b3.add(txt_tuoi = new JTextField(20));
	
	l2.setPreferredSize(l1.getPreferredSize());
	l3.setPreferredSize(l1.getPreferredSize());
	/*Label lab1 = new Label("abc");
	lab1.setSize(500,700);
	lab1.setLocation(400,500);
	*/
	
	JPanel panel = new JPanel();
	b4.add(panel);
	panel.add(btn_them = new JButton("Add"));
	b4.setLocation(10, 200);
	panel.add(btn_luu = new JButton("Save"));
	panel.add(btn_sua = new JButton("Edit"));
	panel.add(btn_xoa = new JButton("Del"));
	panel.add(btn_thoat = new JButton("Out"));
	

	taotable();
	btn_them.addActionListener(this);
	btn_luu.addActionListener(this);
	btn_sua.addActionListener(this);
	btn_xoa.addActionListener(this);
	btn_thoat.addActionListener(this);
	}

	private void taotable() {
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã sinh viên");
		model.addColumn("Tên sinh viên");
		model.addColumn("Tuổi sinh viên");
		JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(sc,BorderLayout.CENTER);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int row = table.getSelectedRow();
				txt_ma.setText( model.getValueAt(row, 0).toString());
				txt_ten.setText(model.getValueAt(row, 1).toString());
				txt_tuoi.setText(model.getValueAt(row, 2).toString());
				
			}
			
		});
		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btn_them)) {
		  txt_ma.setEnabled(true);
		  SuaText(true);
			if(btn_them.getText().equalsIgnoreCase("Add")) {
				btn_them.setText("Cancer");
				btn_them.setEnabled(true);
				btn_luu.setEnabled(true);
				btn_sua.setEnabled(false);
				btn_xoa.setEnabled(false);
				btn_thoat.setEnabled(false);
			}
			else if(btn_them.getText().equalsIgnoreCase("Cancer"))
			{
				txt_ma.setEnabled(false);
				SuaText(true);
				btn_them.setText("Add");
				btn_them.setEnabled(true);
				btn_luu.setEnabled(false);
				btn_sua.setEnabled(true);
				btn_xoa.setEnabled(true);
				btn_thoat.setEnabled(true);
			}
		}
		if(e.getSource().equals(btn_thoat)) {
			dispose();
		}
		if(e.getSource().equals(btn_luu)) {
			if(ds.KiemTra(Long.parseLong(txt_ma.getText()), txt_ten.getText(),Integer.parseInt(txt_tuoi.getText()))) {
				luu();
			}	
			else {
				ds.SuaSV(Long.parseLong(txt_ma.getText()), txt_ten.getText(),Integer.parseInt(txt_tuoi.getText()));
				model.setValueAt(txt_ten.getText(), table.getSelectedRow(), 1);
				model.setValueAt(txt_tuoi.getText(), table.getSelectedRow(), 2);
			}
		}
		if(e.getSource().equals(btn_sua)) {
			if(btn_sua.getText().equalsIgnoreCase("Edit"))
			{
				SuaText(true);
				btn_sua.setText("Cancer");
				btn_sua.setEnabled(true);
				btn_xoa.setEnabled(false);
				btn_them.setEnabled(false);
				btn_thoat.setEnabled(false);
				btn_luu.setEnabled(true);
			}
			else if(btn_sua.getText().equalsIgnoreCase("Cancer")) {
				SuaText(true);
				btn_sua.setText("Edit");
				btn_sua.setEnabled(true);
				btn_xoa.setEnabled(true);
				btn_them.setEnabled(true);
				btn_thoat.setEnabled(true);
				btn_luu.setEnabled(false);
			}
		}
	}

	private void luu() {
		String ms = txt_ma.getText();
		String ten = txt_ma.getText();
		String tuoi = txt_ma.getText();
		SinhVien sv = new SinhVien(Long.parseLong(ms),ten,Integer.parseInt(tuoi));
		ds.themSV(sv);
		String[] row = {ms,ten,tuoi};
		model.addRow(row);
		
	}
	public void SuaText(boolean trangthai) {
		txt_ten.setEnabled(trangthai);
		txt_tuoi.setEnabled(trangthai);
	}
}
		
	