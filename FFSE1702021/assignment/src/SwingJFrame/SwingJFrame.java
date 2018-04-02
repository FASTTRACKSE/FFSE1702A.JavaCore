package SwingJFrame;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

public class SwingJFrame extends JFrame implements ActionListener{ 

	JLabel l1,l2,l3;JTextField f1,f2,f3; JButton b1, b2;
	
	 public SwingJFrame() {
	  
	   super("PTBN");
	   l1=new JLabel("nhập a:");
	   l1.setBounds(50,50, 150,20);  
	   f1= new JTextField();
	   f1.setBounds(50,70, 150,20);
	   
	   l2=new JLabel("nhập b:");
	   l2.setBounds(50,90, 150,20);
	   f2= new JTextField();
	   f2.setBounds(50,110, 150,20);
	   
	   l3=new JLabel("Kết quả:");
	   l3.setBounds(50,130, 150,20);
	   f3= new JTextField();
	   f3.setBounds(50,150, 150,20);
	   b1=new JButton("Giải");
	   b1.setBounds(50,170,150,30); 
	   b2=new JButton("Thoát");
	   b2.setBounds(50,200,150,30);
	   add(l1); add(f1);
	   add(l2); add(f2);
	   add(l3); add(f3);
	   add(b1); add(b2);
	   b1.addActionListener(this);
	  
	   b2.addActionListener(this);
	   
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setSize(600,600); 
	   setLayout(null);
	   setVisible(true);  
	        
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			float a =Float.parseFloat(f1.getText());
			float b =Float.parseFloat(f2.getText());
			if(a!=0) {
				f3.setText("x = "+(-b/a));
			}else 
			{
				if(b==0)
				f3.setText("phương trình vô số nghiệm");
				else
				f3.setText("phương trình vô nghiệm");

				}
		}
		if(e.getSource()==b2) {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SwingJFrame();
        
		

	}

	 

}
