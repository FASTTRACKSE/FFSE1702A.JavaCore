package ffse;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

public class Login extends JFrame {
	 JButton quanly, hocsinh;

	public Login(String title) {
		super(title);
		addControls();
		addEvents();
	}

	ActionListener quanly_1 = new ActionListener() {
		public	void actionPerformed(ActionEvent e ) {
			quanly_bt_1();
		}
	};
	
	protected void quanly_bt_1() {
		 this.setVisible(false);
		 LoginQL myUI = new LoginQL("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
	        myUI.showWindow();
       
	}
	protected void hocsinh_bt_2() {
		 this.setVisible(false);
		 LoginHS myUI = new LoginHS("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
	        myUI.showWindow();

      
	}
	ActionListener hocsinh_2 = new ActionListener() {
		public	void actionPerformed(ActionEvent e ) {
			hocsinh_bt_2();
		}
	};
	
	private void addEvents() {
		quanly.addActionListener(quanly_1);
		hocsinh.addActionListener(hocsinh_2);
		
	}

	private void addControls() {
		Container con = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        JPanel img = new JPanel();
        img.setBounds(5, 5, 424, 181);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("1.jpg").getImage().getScaledInstance(450, 150, Image.SCALE_SMOOTH));
		pnMain.setLayout(null);
		JLabel label = new JLabel(imageIcon);
		img.add(label);
		pnMain.add(img);
        
		JLabel tieude1 = new JLabel("PHẦN MỀM QUẢN LÝ HỌC SINH");
		tieude1.setFont(new Font("Tahoma", Font.BOLD, 14));
		tieude1.setBounds(111, 192, 231, 14);
        pnMain.add(tieude1);
        
        JLabel tieude2 = new JLabel("Vui lòng chọn chức năng đăng nhập");
        tieude2.setFont(new Font("Tahoma", Font.BOLD, 14));
        tieude2.setBounds(97, 217, 261, 23);
        pnMain.add(tieude2);
        con.add(pnMain);
        
        ImageIcon imgquanly = new ImageIcon(new ImageIcon("quanly.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        quanly = new JButton("quản lý", imgquanly);
        quanly.setFont(new Font("Tahoma", Font.BOLD, 13));
        quanly.setBounds(64, 266, 147, 41);
        pnMain.add(quanly);
         
        ImageIcon imghocsinh = new ImageIcon(new ImageIcon("hocsinh.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
         hocsinh = new JButton("học sinh", imghocsinh);
        hocsinh.setFont(new Font("Tahoma", Font.BOLD, 13));
        hocsinh.setBounds(244, 266, 125, 41);
        pnMain.add(hocsinh);
        
        
        
        
//        pnMain.setLayout(null);
      
	}
	
/*	public static void main(String[] args) {
		 Login myUI = new Login("PHẦN MỀM QUẢN LÝ HỌC SINH & TRA CỨU THÔNG TIN SINH VIÊN");
	        myUI.showWindow();

	 }*/
	
	 public void showWindow() {
	        this.setSize(450, 400);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	 }
}
