package Swing;

import java.awt.Color;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelDemo extends JFrame{
	public LabelDemo() {
		setSize(300, 300);
		setVisible(true);
		
		JLabel label = new JLabel("hoc java swing ");
		add(label);
		
		label.setText("label"); //thay "hoc java swing" bang "label"
		label.setToolTipText("chu thich dung tooltiptex"); // khi re chuot vao thi dong chu se hien ra
		label.setForeground(Color.BLUE);//set mau cho chu
	}
	public static void main(String[] args) {
		LabelDemo lb = new LabelDemo(); 
	}
}