package GPT;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class PTBN extends Frame implements ActionListener
{
JLabel l1=new JLabel("nhập a:");
JLabel l2=new JLabel("nhập b:");
JLabel l3=new JLabel("Kết quả:");
JTextField tf1=new JTextField();
JTextField tf2=new JTextField();
JTextField tf3=new JTextField(); 
JButton b1=new JButton("Giải");
JButton b2=new JButton("Thoát");

public PTBN(String title)
{
super(title);
setLayout(new GridLayout(4,2));
add(l1); add(tf1);
add(l2); add(tf2);
add(l3); add(tf3);
add(b1); add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
float a=Float.parseFloat(tf1.getText());
float b=Float.parseFloat(tf2.getText());
if(a!=0)
{
tf3.setText("x="+(-b/a));
}
else
{
if(b==0)
tf3.setText("phương trình vô số nghiệm");
else
tf3.setText("phương trình vô nghiệm");

}	
}
if(ae.getSource()==b2)
System.exit(0);
}
public static void main(String[]args)
{
PTBN gpt=new PTBN("Giải phương trình ax+b=0");
gpt.setSize(350,150);
gpt.show();
}	
}