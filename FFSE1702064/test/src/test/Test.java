package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;  
public class Test extends JFrame { 
	DefaultTableModel table1 = new DefaultTableModel();
	DefaultTableModel table2 = new DefaultTableModel();
	JTable tb1,tb2;
	JLabel quan,phuong,ds1;
	JButton b1,b2;
	JComboBox cb ,tp;
	JRadioButton r1,r2,r3,r4,r5,r6;
	JLabel ds;
	DefaultTableModel table = new DefaultTableModel();
	JTable tb;
JFrame f;  
public Test(){  
    f=new JFrame();
    Container con = getContentPane();
    JPanel p1=new JPanel();  
    JPanel boxtong = new JPanel();
	boxtong.setLayout(new BoxLayout(boxtong, BoxLayout.Y_AXIS));
	JPanel box = new JPanel();
	  box.setLayout(new GridLayout(1,2,5,5));
	
	JPanel title =new JPanel();
	JLabel Title=new JLabel("Tình hình tiêu thụ điện");
	Font fonttitle=new Font("Arial",Font.BOLD,30);
	Title.setFont(fonttitle);
	title.add(Title);
	//Box thứ 1
    JPanel box1 = new JPanel();
    box1.setLayout(new BoxLayout(box1,BoxLayout.Y_AXIS));
    r1= new JRadioButton("Tất cả khách hàng");
    r2= new JRadioButton("Theo quận và phường");
    r3= new JRadioButton("Theo khách hàng cụ thể");
    box1.add(r1);
    box1.add(r2);
    box1.add(r3);
    // Box thứ 2
    JPanel box2 = new JPanel();
    box2.setLayout(new BoxLayout(box2,BoxLayout.Y_AXIS));
    r4=new JRadioButton("Theo năm");
    r5=new JRadioButton("Theo khoảng thời gian");
    r6= new JRadioButton("Chu kỳ");
    box2.add(r4);
    box2.add(r5);
    box2.add(r6);
    //Box thứ 3
    JPanel box3 = new JPanel();
    ds1 = new JLabel("Tình hình tiêu thụ");
    Font fontds=new Font("Arial",Font.BOLD,30);
    ds1.setFont(fontds);
    JPanel boxtb = new JPanel();
	table1.addColumn("Mã Khách hàng");
	table1.addColumn("Tên Khách hàng");
	table1.addColumn("Địa chỉ");
	table1.addColumn("Tình hình tiêu thụ");
    tb1 = new JTable(table1);
	JScrollPane sc = new JScrollPane(tb1);
	Container con1 = getContentPane();
	con1.setLayout(new BorderLayout());
	con1.add(sc, BorderLayout.CENTER);
	boxtb.add(sc);
	box3.add(boxtb);
    box.add(box1);
    box.add(box2);
    boxtong.add(title);
    boxtong.add(box);
    boxtong.add(ds1);
    boxtong.add(box3);
    p1.add(boxtong);
    JPanel p2=new JPanel();  
    JPanel boxbox = new JPanel();

	// cai dat cach sap xep
	boxbox.setLayout(new BoxLayout(boxbox, BoxLayout.Y_AXIS));
	// tieu de
	JPanel Title1 = new JPanel();
    JLabel LTitle = new JLabel("Tình hinh tiêu thụ");
	Font fonttitle1 = new Font("Arial", Font.BOLD, 20);
	LTitle.setFont(fonttitle1);
	Title1.add(LTitle);
	// ket thuc tieu de
	//Quận và phường
    JPanel box11 = new JPanel();
    quan = new JLabel("Quận");
    String tenquan[] = { "All","Hải Châu","Thanh Khê","Sơn Trà","Liên Chiểu","Cẩm Lệ","Ngũ Hành Sơn" };
	cb = new JComboBox(tenquan);
	phuong = new JLabel("Phường");
	String tenphuong[] = { "All", "An Hải Bắc" };
	tp = new JComboBox(tenphuong);
	box11.add(quan);
	box11.add(cb);
	box11.add(phuong);
	box11.add(tp);
    //Button
	JPanel box21 = new JPanel();
	b1 = new JButton("In ra");
	b2 = new JButton("Back");
	box21.add(b1);
	box21.add(b2);
	// Bảng danh sách khách hàng
    JPanel box31 = new JPanel();
    ds1 = new JLabel("Danh sách khách hàng");
	Font fonttitle2 = new Font("Arial", Font.BOLD, 20);
	ds1.setFont(fonttitle2);
    JPanel boxtb1 = new JPanel();
	table2.addColumn("Mã Khách hàng");
	table2.addColumn("Tên Khách hàng");
	table2.addColumn("Quận");
	table2.addColumn("Phường");
	table2.addColumn("Địa chỉ");
	table2.addColumn("Số điện thoại");
    tb2 = new JTable(table2);
	JScrollPane sc1 = new JScrollPane(tb2);
	Container con11 = getContentPane();
	con11.setLayout(new BorderLayout());
	con11.add(sc1, BorderLayout.CENTER);
	boxtb1.add(sc1);
	box31.add(boxtb1);
	// Thêm vào hộp chính
	boxbox.add(box11);
	boxbox.add(box21);
	boxbox.add(ds1);
	boxbox.add(box31);
	p2.add(boxbox);
    JPanel p3=new JPanel();  
    JTabbedPane tp=new JTabbedPane();  
    tp.setBounds(100,100,600,600);  
    tp.add("Danh sách khách hàng",p1);  
    tp.add("visit",p2);  
    tp.add("help",p3);    
    f.add(tp);  
    f.setSize(800,800);  
    f.setLayout(null);  
    f.setVisible(true); 
   
 
} 

} 
