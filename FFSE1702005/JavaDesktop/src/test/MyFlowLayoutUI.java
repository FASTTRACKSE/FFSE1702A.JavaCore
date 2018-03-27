package test;

import javax.swing.*;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyFlowLayoutUI extends JFrame {
	public MyFlowLayoutUI(String tieude) {
		super(tieude);
		addControls();

	}

	public void addControls() {
		Container con = getContentPane();

		JPanel pnFlow = new JPanel();
		pnFlow.setLayout(new FlowLayout());
		JButton hsa = new JButton("Giải");
		JButton hsb = new JButton("Thoát");
		JButton x = new JButton("Help");
		pnFlow.add(hsa);
		pnFlow.add(hsb);
		pnFlow.add(x);

		con.add(pnFlow);
	}

	public void showWindow() {
		this.setSize(510, 326);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {			
					String title = "Giai pt bac 1";
					MyFlowLayoutUI myUI = new MyFlowLayoutUI(title);
					myUI.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
