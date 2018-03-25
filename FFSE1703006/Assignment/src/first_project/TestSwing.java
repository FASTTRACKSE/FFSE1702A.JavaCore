package first_project;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class TestSwing implements ActionListener {
	JTextField a, b, x;
	JLabel lblInputA, lblInputB, lblX;
	JButton submit;
	JTextPane header, check_a, check_b;

	TestSwing() {
		JFrame f = new JFrame();
		a = new JTextField();
		a.setBounds(100, 50, 140, 20);
		b = new JTextField();
		b.setBounds(100, 100, 140, 20);
		x = new JTextField();
		x.setBounds(100, 150, 140, 20);
		x.setEditable(false);
		submit = new JButton("Submit");
		submit.setBounds(100, 207, 69, 30);
		submit.addActionListener(this);
		f.getContentPane().add(a);
		f.getContentPane().add(b);
		f.getContentPane().add(x);
		f.getContentPane().add(submit);
		f.setSize(300, 300);
		f.getContentPane().setLayout(null);

		lblInputA = new JLabel("Nhập a:");
		lblInputA.setBounds(33, 50, 46, 14);
		f.getContentPane().add(lblInputA);

		lblInputB = new JLabel("Nhập b:");
		lblInputB.setBounds(33, 100, 46, 14);
		f.getContentPane().add(lblInputB);

		lblX = new JLabel("x =");
		lblX.setBounds(50, 153, 25, 14);
		f.getContentPane().add(lblX);

		header = new JTextPane();
		header.setBackground(UIManager.getColor("Button.background"));
		header.setText("GIẢI PHƯƠNG TRÌNH ax + b = 0");
		header.setBounds(50, 11, 173, 20);
		f.getContentPane().add(header);

		check_a = new JTextPane();
		check_a.setForeground(new Color(255, 0, 0));
		check_a.setBackground(UIManager.getColor("Button.background"));
		check_a.setText("Vui lòng nhập số!");
		check_a.setBounds(100, 69, 140, 20);
		check_a.setVisible(false);
		f.getContentPane().add(check_a);

		check_b = new JTextPane();
		check_b.setForeground(new Color(255, 0, 0));
		check_b.setBackground(UIManager.getColor("Button.background"));
		check_b.setText("Vui lòng nhập số!");
		check_b.setBounds(100, 119, 140, 20);
		check_b.setVisible(false);
		f.getContentPane().add(check_b);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s1 = a.getText();
		String s2 = b.getText();
		boolean check_s1 = checkFloat(s1);
		if (check_s1) {
			check_a.setVisible(false);
		} else {
			check_a.setVisible(true);
		}
		boolean check_s2 = checkFloat(s2);
		if (check_s2) {
			check_b.setVisible(false);
		} else {
			check_b.setVisible(true);
		}
		if (check_s1 && check_s2) {
			float a = Float.parseFloat(s1);
			float b = Float.parseFloat(s2);
			float c = 0;
			if (e.getSource() == submit) {
				c = -b / a;
			}
			String result = String.valueOf(c);
			x.setText(result);
		} else {
			x.setText("");
		}
	}

	public boolean checkFloat(String n) {
		try {
			Float.parseFloat(n);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void setSystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
	}

	public static void main(String[] args) {
		setSystemLookAndFeel();
		new TestSwing();
	}
}