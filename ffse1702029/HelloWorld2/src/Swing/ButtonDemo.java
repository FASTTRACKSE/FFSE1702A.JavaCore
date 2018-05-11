package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ButtonDemo extends JFrame{
	private JFrame label;
	public ButtonDemo() {
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//lam he thong nhanh hon
		JLabel lable = new JLabel("hello world"); 
		label.setSize(20, 50);
		add(lable); 
		JButton btn = new JButton("click me");
		add(btn, "North",1);// "north" la layout
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//label.setText("");
				changeText();
			}
		});
	}
	public void changeText() {
		label.setTitle("Tutorials' blog");
	}
	public static void main(String[] args) {
		ButtonDemo btn = new ButtonDemo(); 
	}
}