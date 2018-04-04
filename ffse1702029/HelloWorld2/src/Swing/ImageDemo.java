package Swing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageDemo extends JFrame{
	public ImageDemo() {
		setSize(300, 400);
		setVisible(true);
		JLabel label = new JLabel();
		add(label);
		label.setSize(300, 400);//set sixe cho label
	//	System.out.println("x: "+label.getSize().width+"y:"+label.getSize().height);
		try {
			// dat hinh vao ngang muc voi project 
			BufferedImage img =ImageIO.read(new File("dep.jpg"));
			ImageIcon icon = new ImageIcon(img.getScaledInstance(300, 400, img.SCALE_SMOOTH)); //SCALE_SMOOTH la chon do min cua anh
			label.setIcon(icon);
		}catch(IOException ex){
			Logger.getLogger(ImageDemo.class.getName()).log(Level.SEVERE,null, ex);
		}
		
		
	}
	public static void main(String[] args) {
		ImageDemo img = new ImageDemo(); 
	}
}