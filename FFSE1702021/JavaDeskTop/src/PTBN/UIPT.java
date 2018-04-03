package PTBN;

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

public class UIPT extends JFrame {
	JTextField textHSA, textHSB, textKQ;
	JButton b1, b2;
	ActionListener bn1 = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			giai();
		}
	};

	public UIPT(String tieude) {
		super(tieude);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addControls();
		addEvent();
		addShowWindow();

	}

	public void giai() {

		float a = Float.parseFloat(textHSA.getText());
		float b = Float.parseFloat(textHSB.getText());
		if (a != 0 && b !=0) {
			textKQ.setText("x = " + (-b / a));
		} else if(b == 0) {
			
			textKQ.setText("x = "+ 0);
			
		}else {
			textKQ.setText("không có nghiệm");
		}

	}

	public void addControls() {
		Container con = getContentPane();

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnTittle = new JPanel();
		JLabel lbTittle = new JLabel("Phương trình bậc 1");
		Font fTittle = new Font("arial", Font.BOLD, 20);
		lbTittle.setFont(fTittle);
		pnTittle.add(lbTittle);

		JPanel pnHSA = new JPanel();
		JLabel lbHSA = new JLabel("nhập số a");
		textHSA = new JTextField(15);
		pnHSA.add(lbHSA);
		pnHSA.add(textHSA);

		JPanel pnHSB = new JPanel();
		JLabel lbHSB = new JLabel("nhập số b");
		textHSB = new JTextField(15);
		pnHSB.add(lbHSB);
		pnHSB.add(textHSB);

		JPanel pnKQ = new JPanel();
		JLabel lbKQ = new JLabel("Nghiệm: ");
		textKQ = new JTextField(15);
		pnKQ.add(lbKQ);
		pnKQ.add(textKQ);

		JPanel pnAction = new JPanel();
		b1 = new JButton("giải");
		pnAction.add(b1);

		b2 = new JButton("thoát");
		pnAction.add(b2);

		pnMain.add(pnTittle);
		pnMain.add(pnHSA);
		pnMain.add(pnHSB);
		pnMain.add(pnAction);
		pnMain.add(pnKQ);

		con.add(pnMain);

	}

	public void addEvent() {
		b1.addActionListener(bn1);

		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public void addShowWindow() {

		this.setSize(600, 400);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		this.setVisible(true);

	}

}
