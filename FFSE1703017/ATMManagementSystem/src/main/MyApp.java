package main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ui.ControlUI;

public class MyApp {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlUI ui = new ControlUI("TPBank - Đăng nhập");
					ui.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
