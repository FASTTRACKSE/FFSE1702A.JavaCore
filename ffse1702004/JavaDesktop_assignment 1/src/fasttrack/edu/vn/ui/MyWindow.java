package fasttrack.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyWindow extends JFrame {
	JLabel a,b,c,title;
	JTextField text,text1,text2;
	JButton b1,b2,b3;
	
	public MyWindow() {
		super("Đây Là Phương Trình Bậc 1 - Nổi Tiếng");
		addControls();
		addEvents();
	}
	
	//đây là sự kiện 
	ActionListener eventCong = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
               congHaiSo();
        }
 };

 ActionListener eventTru = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
               truHaiSo();
        }
 };

 protected void congHaiSo() {
        String hsa = text.getText();
        String hsb = text1.getText();
        double a = Double.parseDouble(hsa);
        double b = Double.parseDouble(hsb);
        if(a == 0 && b==0) {
        	text2.setText("pt vô số nghiệm ");
        }
        if(a == 0 && b !=0) {
        	text2.setText("pt vô nghiệm ");
        }
        if(a != 0 ) {
        double c = -b/a;
        text2.setText(Double.toString(c));
        }
 }

 public void truHaiSo() {
        text2.setText("ax + b = 0");
 }
	private void addEvents() {
		 b1.addActionListener(eventCong);
         b3.addActionListener(eventTru);

         b2.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                      System.exit(0);
                }
         });

	}

	private void addControls() {
		Container con = getContentPane();
		JPanel boxAll = new JPanel();
		boxAll.setLayout(new BoxLayout(boxAll, BoxLayout.Y_AXIS));
		con.add(boxAll);
		
		JLabel titleBox  = new JLabel("Giải Phương Trình Bậc 1 ");
	    titleBox.setFont(new Font("Courier New", Font.ITALIC, 12));
	    titleBox.setForeground(Color.BLUE);
		
		JPanel box1 = new JPanel();
		//set box1 
		
		a = new JLabel("he so a : ");
		 text=new JTextField(10);  
	     
	     box1.add(a);
	     box1.add(text);
	     
		JPanel box2 = new JPanel();
		//set box2
		
		b = new JLabel("he so b : ");
		 text1=new JTextField(10);  
	    
	     box2.add(b);
	     box2.add(text1);
	     
		JPanel box3 = new JPanel();
		//set box3
		c = new JLabel(" ket qua : ");
		text2=new JTextField(10);  
         
        text2.setEditable(false);
        box3.add(c);
	     box3.add(text2);
		
	     
		//o button 
		JPanel box = new JPanel();
		//set button 
		
		b1 = new JButton("giai");
		b2 = new JButton("thoat");
		b3 = new JButton("help");
		box.add(b1);		box.add(b2);		box.add(b3);
		
		boxAll.add(titleBox);
		boxAll.add(box1);
		boxAll.add(box2);
		boxAll.add(box3);
		boxAll.add(box);
		box.setLayout(new FlowLayout());
	}

	public void showWindow() {
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
