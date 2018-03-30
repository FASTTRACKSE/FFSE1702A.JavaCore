package assignment1.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyUI extends JFrame {

	private static final long serialVersionUID = 1L;
	JTextField txtHeSoA = new JTextField(14);
	JTextField txtHeSoB = new JTextField(14);
	JTextField txtKetQua = new JTextField(14);
	JButton btnGiai = new JButton("Giải");
	JButton btnThoat = new JButton("Thoát");
	JButton btnHelp = new JButton("Help");
	
	ActionListener eventGiai = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String hsA = txtHeSoA.getText();
			String hsB = txtHeSoB.getText();
			boolean isA = chkDouble(hsA);
			boolean isB = chkDouble(hsB);
			if (isA && isB) {
				Double a = Double.parseDouble(hsA);
				Double b = Double.parseDouble(hsB);
				if (a == 0) {
					String s = (b == 0) ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm";
					txtKetQua.setText(s);
				} else {
					txtKetQua.setText("x = " + (-b/a));
				}
			} else {
				JOptionPane.showMessageDialog(null, "Hệ số không được để trống và phải nhập đúng định dạng", "Thông báo", JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	ActionListener eventThoat = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
	ActionListener eventHelp = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String msg = "Phương trình bậc nhất có dạng ax + b = 0, nhập vào hệ số a và b sau đó nhấn Giải để xem kết quả.";
			JOptionPane.showMessageDialog(null, msg, "Hướng dẫn", JOptionPane.INFORMATION_MESSAGE);
		}
	};
	
	public MyUI (String title) {
		super(title);
		addControls();
		addEvents();
	}
	
	public void addControls() {
		Container con = getContentPane();
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Giải phương trình bậc 1");
		Font fntTitle = new Font("arial", Font.BOLD, 18);
		lblTitle.setFont(fntTitle);
		pnTitle.add(lblTitle);
		
		JPanel pnInputA = new JPanel();
		JLabel lblHeSoA = new JLabel("Hệ số a: ");
		lblHeSoA.setPreferredSize(new Dimension(50, 15));
		pnInputA.add(lblHeSoA);
		pnInputA.add(txtHeSoA);
		
		JPanel pnInputB = new JPanel();
		JLabel lblHeSoB = new JLabel("Hệ số b: ");
		lblHeSoB.setPreferredSize(new Dimension(50, 15));
		pnInputB.add(lblHeSoB);
		pnInputB.add(txtHeSoB);
		
		JPanel pnAction = new JPanel();
		pnAction.add(btnGiai);
		pnAction.add(btnThoat);
		pnAction.add(btnHelp);
		
		JPanel pnKetQua = new JPanel();
		JLabel lblKetQua = new JLabel("Kết quả: ");
		lblKetQua.setPreferredSize(new Dimension(50, 15));
		pnKetQua.add(lblKetQua);
		pnKetQua.add(txtKetQua);
		
		pnMain.add(pnTitle);
		pnMain.add(pnInputA);
		pnMain.add(pnInputB);
		pnMain.add(pnAction);
		pnMain.add(pnKetQua);
		
		con.add(pnMain);
	}
	
	public void addEvents() {
		btnGiai.addActionListener(eventGiai);
		btnThoat.addActionListener(eventThoat);
		btnHelp.addActionListener(eventHelp);
	}
	
	public void showWindow() {
		this.setSize(400, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	static boolean chkDouble(String s) {
		try {
			Double.parseDouble(s.trim());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
