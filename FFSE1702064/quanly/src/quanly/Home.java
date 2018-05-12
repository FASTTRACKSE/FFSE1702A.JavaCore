package quanly;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import quanly.KhachHang;
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

public class Home extends JFrame{
	JButton kh,bl,tk,dx;
	public Home(String tieude) {
		super(tieude);
		addControls();
		addEvents();
	}
	public void addControls() {
		Container con = getContentPane();
		// main chinh hien thi noi dung
		JPanel box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		JPanel title =new JPanel();
		JLabel Title=new JLabel("Quản lý ti�?n điện");
		Font fonttitle=new Font("Arial",Font.BOLD,30);
		Title.setFont(fonttitle);
		title.add(Title);
		JPanel box1= new JPanel();
		kh=new JButton("Khách Hàng");
		JPanel box2= new JPanel();
		bl=new JButton("Biên Lai");
		JPanel box3= new JPanel();
		tk=new JButton("Thống kê");
		JPanel box4= new JPanel();
		dx=new JButton("�?ăng xuất");
		box1.add(kh);
		box2.add(bl);
		box3.add(tk);
		box4.add(dx);
		box.add(title);
		box.add(box1);
		box.add(box2);
		box.add(box3);
		box.add(box4);
		con.add(box);
	
	}
	ActionListener khachhang = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			khachhang1();		
	}
	};
	public void khachhang1() {
		KhachHang myUI = new KhachHang("Khách Hàng");
		myUI.showWindow();
		this.dispose();
	}
	
	//Thá»‘ng kÃª
	ActionListener thongke = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			thongke1();		
	}
	};
	public void thongke1() {
		ThongKe UI = new ThongKe("Thống kê");
		UI.showWindow();
		this.dispose();
	}
	ActionListener bienlai = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			bienlai1();
		}
	};
	public void bienlai1() {
		TinhTien myUI = new TinhTien("Biên Lai");
		myUI.showWindow();
		this.dispose();
	}
	ActionListener dangxuat = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dangxuat1();
		}
	};
	    public void dangxuat1() {
	    	Login myUI = new Login("�?ăng nhập");
			myUI.showWindow();
			this.dispose();
	    }
	public void addEvents() {
		kh.addActionListener(khachhang);	
		tk.addActionListener(thongke);	
		bl.addActionListener(bienlai);
		dx.addActionListener(dangxuat);
	}
	

	public void showWindow() {
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
