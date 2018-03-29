package assignment1;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;

public class Main {
	private JTextField txtHeSoA;
	private JTextField txtHeSoB;
	private JTextField txtKetQua;
	
	public static void main(String[] args) {
		new Main();
	}


	public Main() {
		JFrame fr = new JFrame("Đây là phương trình bậc 1 - nổi tiếng");
		JButton btnGiai = new JButton("Giải");
		JButton btnThoat = new JButton("Thoát");
		JButton btnHelp = new JButton("Help");
		
		btnGiai.setBounds(73,133,60, 30);
		btnThoat.setBounds(156,133,68, 30);
		btnHelp.setBounds(245,133,60, 30);
		fr.getContentPane().add(btnGiai);
		fr.getContentPane().add(btnThoat);
		fr.getContentPane().add(btnHelp);
		fr.setSize(400,250);    
		fr.getContentPane().setLayout(null);
		
		JDialog dlg = new JDialog(fr,"Hướng dẫn", false);
		dlg.setResizable(false);
		dlg.setSize(300,250);
			
		JLabel lblHeading = new JLabel("Giải Phương Trình Bậc 1");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setForeground(Color.BLUE);
		lblHeading.setFont(new Font("Arial", Font.BOLD, 14));
		lblHeading.setBounds(73, 11, 232, 21);
		fr.getContentPane().add(lblHeading);
		
		JLabel lblHeSoA = new JLabel("Hệ số a:");
		lblHeSoA.setBounds(73, 43, 46, 16);
		fr.getContentPane().add(lblHeSoA);
		
		JLabel lblHeSoB = new JLabel("Hệ số b:");
		lblHeSoB.setBounds(73, 88, 46, 20);
		fr.getContentPane().add(lblHeSoB);
		
		txtHeSoA = new JTextField();
		txtHeSoA.setBounds(129, 43, 176, 20);
		fr.getContentPane().add(txtHeSoA);
		txtHeSoA.setColumns(10);
		
		txtHeSoB = new JTextField();
		lblHeSoA.setLabelFor(txtHeSoB);
		lblHeSoB.setLabelFor(txtHeSoB);
		txtHeSoB.setColumns(10);
		txtHeSoB.setBounds(129, 88, 176, 20);
		fr.getContentPane().add(txtHeSoB);
		
		JLabel lblMsg1 = new JLabel("Phải nhập số");
		lblMsg1.setForeground(Color.RED);
		lblMsg1.setBounds(129, 63, 90, 14);
		fr.getContentPane().add(lblMsg1);
		lblMsg1.setVisible(false);
		
		JLabel lblMsg2 = new JLabel("Phải nhập số");
		lblMsg2.setForeground(Color.RED);
		lblMsg2.setBounds(129, 108, 90, 14);
		fr.getContentPane().add(lblMsg2);
		
		JLabel lblKetQua = new JLabel("Kết quả:");
		lblKetQua.setBounds(73, 179, 46, 16);
		fr.getContentPane().add(lblKetQua);
		lblMsg2.setVisible(false);
		
		txtKetQua = new JTextField();
		txtKetQua.setColumns(10);
		txtKetQua.setBounds(129, 179, 176, 20);
		fr.getContentPane().add(txtKetQua);
		fr.setVisible(true);    
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnGiai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isHeSoA = Validation.chkDouble(txtHeSoA.getText());
				boolean isHeSoB = Validation.chkDouble(txtHeSoB.getText());
				if (!isHeSoA) lblMsg1.setVisible(true);else lblMsg1.setVisible(false);
				if (!isHeSoB) lblMsg2.setVisible(true);else lblMsg2.setVisible(false);
				if(isHeSoA && isHeSoB) {
					lblMsg1.setVisible(false);
					lblMsg2.setVisible(false);
					Double a = Double.parseDouble(txtHeSoA.getText().trim());
					Double b = Double.parseDouble(txtHeSoB.getText().trim());
					if (a == 0) {
						String s = (b == 0) ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm";
						txtKetQua.setText(s);
					} else {
						txtKetQua.setText("x = " + (-b/a));
					}
				}
			}
		});
		
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fr.dispose();
			}
		});
		
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(true);
			}
		});
	}
}
