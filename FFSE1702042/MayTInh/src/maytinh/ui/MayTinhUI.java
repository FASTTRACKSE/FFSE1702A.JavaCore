package maytinh.ui;

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

public class MayTinhUI extends JFrame {
	JTextField txa, txb, tkq;
	JButton btc, btt;

	ActionListener cong = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			congHaiSo();
		}
	};
	ActionListener tru = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			truHaiSo();
		}
	};

	public void congHaiSo() {
		int a = Integer.parseInt(txa.getText());
		int b = Integer.parseInt(txb.getText());
		tkq.setText("Kết quả= " + (a + b));
	}

	public void truHaiSo() {
		int a = Integer.parseInt(txa.getText());
		int b = Integer.parseInt(txb.getText());
		tkq.setText("Kết quả= " + (a - b));
	}

	public MayTinhUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();

	}

	public void addControls() {
		Container con = getContentPane();
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

		JPanel title = new JPanel();
		JLabel lbt = new JLabel("Máy tính cá nhân");
		Font flbt = new Font("arial", Font.BOLD, 20);
		lbt.setFont(flbt);
		title.add(lbt);

		JPanel soA = new JPanel();
		JLabel lba = new JLabel("nhập số thứ nhất");
		txa = new JTextField(12);
		Font fa = new Font("arial", Font.BOLD, 12);
		lba.setFont(fa);
		soA.add(lba);
		soA.add(txa);

		JPanel soB = new JPanel();
		JLabel lbb = new JLabel("nhập số thứ hai");
		txb = new JTextField(12);
		Font fb = new Font("arial", Font.BOLD, 12);
		lbb.setFont(fb);
		soB.add(lbb);
		soB.add(txb);

		JPanel action = new JPanel();
		btc = new JButton("Cộng");
		btt = new JButton("Trừ");
		action.add(btc);
		action.add(btt);

		JPanel kq = new JPanel();
		JLabel lkq = new JLabel();
		tkq = new JTextField(12);
		kq.add(lkq);
		kq.add(tkq);

		main.add(title);
		main.add(soA);
		main.add(soB);
		main.add(action);
		main.add(kq);

		con.add(main);
	}

	public void addEvents() {
		btc.addActionListener(cong);
		btt.addActionListener(tru);

	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
