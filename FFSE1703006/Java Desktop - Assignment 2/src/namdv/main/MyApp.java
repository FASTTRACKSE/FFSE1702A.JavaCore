package namdv.main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import namdv.ui.QuanLySVUI;

public class MyApp {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLySVUI myUI = new QuanLySVUI("Quản lý sinh viên - JunBjn");
					myUI.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
