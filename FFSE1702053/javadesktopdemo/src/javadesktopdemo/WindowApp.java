package javadesktopdemo;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowApp {

	private static JFrame jf;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jf = new JFrame("Chuong trinh cua tui");
		jf.setSize(600, 400);
		JPanel jp = new JPanel(new FlowLayout());
		JTextField quanText = new JTextField(10);
		jp.add(quanText);
		
		jf.getContentPane().add(jp);
		jf.setVisible(true);
		
	}
	
	

}
