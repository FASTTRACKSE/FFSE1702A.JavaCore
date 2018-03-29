package thu;
import javax.swing.*;
public class First {
	First(){    
		JFrame f=new JFrame("First Class");    
		                    
		JButton b=new JButton("click"); 
		JLabel  l=	new JLabel("qq");

		b.setBounds(130,100,100, 40);
		
		l.setBounds(200,200,1000,200);
		
		f.add(b); 
		f.add(l);
		            
		f.setSize(300,400);    
		f.setLayout(null);    
		f.setVisible(true);    
		            
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		}    
		public static void main(String[] args) {    
		    new First();    
		}    
}
