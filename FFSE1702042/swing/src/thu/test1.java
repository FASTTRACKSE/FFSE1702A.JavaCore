package thu;
import java.awt.event.*;  
import javax.swing.*;    
public class test1 {  
public static void main(String[] args) {  
    JFrame f=new JFrame("Button Example");  
    JTextField tf=new JTextField();  
    tf.setBounds(200,50, 150,20);  
    JButton b=new JButton("Click Here");  
    b.setBounds(50,100,95,30);  
    b.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
            tf.setText("Ha ha");  
        }  
    });  
    f.add(b);f.add(tf);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
}  