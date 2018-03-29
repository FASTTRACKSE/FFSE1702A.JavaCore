package thu;
import javax.swing.*;
import java.awt.*;
public class test1 extends JFrame {
	JFrame f;  
	test1(){ 
	    f=new JFrame("Combo ex");  
	      
	    String lop[]	= {"FFSE1701", "FFSE1702","FFSE1703", "FFSE1704"};	
		JComboBox cb	= new 	JComboBox(lop);
	    cb.setBounds(50, 50,90,20);  
	    f.add(cb);  
	      
	    f.setLayout(null);  
	    f.setSize(400,500);  
	    f.setVisible(true);  
	      
	}  
	public static void main(String[] args) {  
	    new test1();  
	      
	}  
	}  
