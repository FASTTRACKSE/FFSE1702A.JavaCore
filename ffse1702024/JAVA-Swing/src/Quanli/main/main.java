package Quanli.main;

import javax.swing.JFrame;

import Giaodien.ui.GiaoDien;
public class main {



	public static void main (String[] args) {
		GiaoDien giaodien = new GiaoDien();
		giaodien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		giaodien.setSize(800, 700);
		giaodien.setVisible(true);
	}

}
