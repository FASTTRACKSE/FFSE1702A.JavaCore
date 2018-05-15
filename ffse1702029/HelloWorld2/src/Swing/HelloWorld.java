package Swing;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorld extends JFrame{
	public HelloWorld() {
		setSize(300, 400); //set kich thuoc bang fame
		setVisible(true); //hien thi bang fame
		/*
		co the viet this phia truoc de ro code hon
		this.setSize(300, 400);
		this.setVisible(true);
		*/
		setLocation(500, 300);//SET vi tri de bang
		setResizable(false); //thay doi kich thuoc bang, true thay doi dc, false thi k thay doi dc
		JLabel lable = new JLabel("hello world"); //tao label moi 
		add(lable); //add label vao frame
	}
	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld(); 
		//hello.setVisible(true); (neu k set o phia tren thi set o duoi van duoc
	}
}
//tao 1 cai frame dau tien
//package Swing;
//
//import javax.swing.JFrame;
//
//public class HelloWorld extends JFrame{
//	public HelloWorld() {
//		setSize(300, 400);
//		setVisible(true);
//	}
//	public static void main(String[] args) {
//		HelloWorld hello = new HelloWorld(); 
//	}
//}