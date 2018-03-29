package jv.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelloWorldUI extends JFrame {
	JTextField txtHeSoA;
	JTextField txtHeSoB;
	JTextField txtResult;
	JButton btnCalc;
	JButton btnExit;

	ActionListener gpt = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			giaiPT();
		}
	};

	public void giaiPT() {

		float a = Float.parseFloat(txtHeSoA.getText());
		float b = Float.parseFloat(txtHeSoB.getText());
		if (a != 0) {
			txtResult.setText("x=" + (-b / a));
		} else {
			if (b == 0)
				txtResult.setText("phương trình vô số nghiệm");
			else
				txtResult.setText("phương trình vô nghiệm");

		}

	}

	public HelloWorldUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Chương trình GPTB1");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);

		pnTitle.add(lblTitle);

		JPanel pnInput1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Nhập hệ số a:");
		txtHeSoA = new JTextField(15);
		pnInput1.add(lblTitle1);
		pnInput1.add(txtHeSoA);

		JPanel pnInput2 = new JPanel();
		JLabel lblTitle2 = new JLabel("Nhập hệ số b:");
		txtHeSoB = new JTextField(15);
		pnInput2.add(lblTitle2);
		pnInput2.add(txtHeSoB);

		JPanel pnAction = new JPanel();
		btnCalc = new JButton("Calculate");
		btnExit = new JButton("Exit");
		pnAction.add(btnCalc);
		pnAction.add(btnExit);

		JPanel pnResult = new JPanel();
		JLabel lblTitleResult = new JLabel("Nghiệm: ");
		txtResult = new JTextField(15);
		pnResult.add(lblTitleResult);
		pnResult.add(txtResult);

		pnMain.add(pnTitle);
		pnMain.add(pnInput1);
		pnMain.add(pnInput2);
		pnMain.add(pnAction);
		pnMain.add(pnResult);

		con.add(pnMain);
	}

	public void addEvents() {
		btnCalc.addActionListener(gpt);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
