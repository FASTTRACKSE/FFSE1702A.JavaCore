package assignment1.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	public MyUI (String title) {
		super(title);
		addControls();
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
	
	public void showWindow() {
		this.setSize(400, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
