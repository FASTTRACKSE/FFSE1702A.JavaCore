package test;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GiaiPT {
	int a;
	int b;
	
	public GiaiPT(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public double tinhNghiem() {
		return (-(double) this.b / this.a);
	}

	private JFrame frame;
	private JTextField hsa;
	private JTextField x;
	private JTextField hsb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaiPT window = new GiaiPT();
					window.frame.setVisible(true);
//					String title = "Giai pt bac 1";
//					MyFlowLayoutUI myUI = new MyFlowLayoutUI(title);
//					myUI.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GiaiPT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblGiiPhngTrnh = new JLabel("Gi\u1EA3i Ph\u01B0\u01A1ng Tr\u00ECnh B\u1EADc 1");
		lblGiiPhngTrnh.setForeground(Color.BLUE);
		lblGiiPhngTrnh.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblGiiPhngTrnh.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblHSA = new JLabel("H\u1EC7 s\u1ED1 a:");
		lblHSA.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		hsa = new JTextField();
		hsa.setColumns(10);

		JLabel lblHSB = new JLabel("H\u1EC7 s\u1ED1 b:");
		lblHSB.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnThot.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		JButton submit = new JButton("Gi\u1EA3i\r\n");
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int a = Integer.parseInt(hsa.getText());
				int b = Integer.parseInt(hsb.getText());
				if (a == 0 && b == 0) {
					JOptionPane.showMessageDialog(frame, "Phương trình vô số nghiệm");
				} else if (a == 0 && b != 0) {
					JOptionPane.showMessageDialog(frame, "Phương trình vô nghiệm");
				} else {
					GiaiPT pt1 = new GiaiPT(a, b);
					x.setText("x = " + String.valueOf(pt1.tinhNghiem()));
				}
			}
		});
		submit.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		JLabel lblKtQu = new JLabel("K\u1EBFt qu\u1EA3 :");
		lblKtQu.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		x = new JTextField();
		x.setBackground(Color.WHITE);
		x.setEditable(false);
		x.setColumns(10);
		
		hsb = new JTextField();
		hsb.setColumns(10);
		
		JButton btnHelp = new JButton("Help\r\n");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnHelp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblKtQu, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(x, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHSB, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(submit, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(43)
									.addComponent(btnThot)
									.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
									.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(hsb, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHSA, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(hsa, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
					.addGap(127))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGiiPhngTrnh, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblGiiPhngTrnh)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(hsa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHSA, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHSB, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(hsb, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submit)
						.addComponent(btnThot)
						.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKtQu, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(x, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
