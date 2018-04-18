package fasttrack.edu.vn.ui;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyWindowUI extends JFrame {
	JTextField txtHeSoA, txtHeSoB, txtResult;
	JButton btnCalc, btnExit;
	
	public MyWindowUI(String title) {
		super(title);
		addControls();
		addEvents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	ActionListener eventCalc = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tinhNghiem();
		}
	};
	
	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		
		JPanel pnTitle = new JPanel();
		JLabel lbTitle = new JLabel("Chương Trình Phương Trình Bậc 1");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lbTitle.setFont(fontTitle);
		pnTitle.add(lbTitle);
		
		JPanel pnInput1 = new JPanel();
		JLabel lbTitle1 = new JLabel("Hệ số a: ");
		txtHeSoA = new JTextField(15);
		pnInput1.add(lbTitle1);
		pnInput1.add(txtHeSoA);
		
		JPanel pnInput2 = new JPanel();
		JLabel lbTitle2 = new JLabel("Hệ số b: ");
		txtHeSoB = new JTextField(15);
		pnInput2.add(lbTitle2);
		pnInput2.add(txtHeSoB);
		
		JPanel pnAction = new JPanel();
		btnCalc = new JButton("Tính toán");
		btnExit = new JButton("Thoát");
		pnAction.add(btnCalc);
		pnAction.add(btnExit);
		
		JPanel pnResult = new JPanel();
		JLabel lbTitleResult = new JLabel("Nghiệm :");
		txtResult = new JTextField(15);
		pnResult.add(lbTitleResult);
		pnResult.add(txtResult);
		
		pnMain.add(pnTitle);
		pnMain.add(pnInput1);
		pnMain.add(pnInput2);
		pnMain.add(pnAction);
		pnMain.add(pnResult);
		
		con.add(pnMain);
	}
	
	public void addEvents() {
		btnCalc.addActionListener(eventCalc);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
	}
	
	public void tinhNghiem() {
		String hsA = txtHeSoA.getText();
		String hsB = txtHeSoB.getText();
		
		double a = Double.parseDouble(hsA);
		double b = Double.parseDouble(hsB);
		
		if(a == 0) {
			txtResult.setText("Phương trình vô số nghiệm");
		} else if(a != 0 && b != 0) {
			String result = Double.toString(-b/a);
			txtResult.setText(result);
		} else if(a != 0 && b == 0) {
			txtResult.setText("Phương trình vô nghiệm");
		}
	}
	
	public void showWindow() {
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
