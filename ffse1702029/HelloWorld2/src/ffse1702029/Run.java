package ffse1702029;

import javax.swing.JFrame;

public class Run {
	public static void main(String[] args) {
		GiaoDien giaodien = new GiaoDien();
		giaodien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		giaodien.setSize(700, 600);
		giaodien.setVisible(true);
	}
}