package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;

public class PTBac1 extends JFrame {
	public PTBac1(String tieude) {
		super(tieude);
		addControls();
		addEvents();

	}

	private JFrame frame;
	private JTextField hsa;
	private JTextField x;
	private JTextField hsb;
	private JButton giai;
	private JButton exit;
	private JButton help;

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnFlow = new JPanel();
		pnFlow.setLayout(new FlowLayout());
		giai = new JButton("Giải");
		giai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(giai);

		exit = new JButton("Thoát");
		exit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(exit);

		help = new JButton("Help");
		help.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnFlow.add(help);

		JPanel de = new JPanel();
		JLabel pt = new JLabel("Giải phương trình bậc 1");
		pt.setForeground(Color.BLUE);
		pt.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pt.setHorizontalAlignment(SwingConstants.CENTER);
		de.add(pt);

		JPanel nhapa = new JPanel();
		JLabel a = new JLabel("Hệ số a: ");
		a.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		hsa = new JTextField(20);
		hsa.setPreferredSize(new Dimension(80, 30));
		nhapa.add(a);
		nhapa.add(hsa);

		JPanel nhapb = new JPanel();
		JLabel b = new JLabel("Hệ số b: ");
		b.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		hsb = new JTextField(20);
		hsb.setPreferredSize(new Dimension(80, 30));
		nhapb.add(b);
		nhapb.add(hsb);

		JPanel ketqua = new JPanel();
		JLabel kq = new JLabel("Kết quả: ");
		kq.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		x = new JTextField();
		x.setPreferredSize(new Dimension(80, 30));
		x.setColumns(20);
		x.setEditable(false);
		x.setBackground(Color.white);
		ketqua.add(kq);
		ketqua.add(x);

		pnMain.add(de);
		pnMain.add(nhapa);
		pnMain.add(nhapb);
		pnMain.add(pnFlow);
		pnMain.add(ketqua);

		con.add(pnMain);

	}

	public void addEvents() {
		giai.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				int a = Integer.parseInt(hsa.getText());
				int b = Integer.parseInt(hsb.getText());
				if (a == 0 && b == 0) {
					JOptionPane.showMessageDialog(null, "Phương trình vô số nghiệm");
				} else if (a == 0 && b != 0) {
					JOptionPane.showMessageDialog(frame, "Phương trình vô nghiệm");
				} else {
					x.setText("x = " + -(double) b / a);
				}
			}
		});

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});

		help.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(frame, "Éo có đâu tự tìm đi :) haha");
			}
		});
	}

	public void showWindow() {
		this.setSize(510, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String title = "Giải phương trình bậc 1";
					PTBac1 myUI = new PTBac1(title);
					myUI.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
