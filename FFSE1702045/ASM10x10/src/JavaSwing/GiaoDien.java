package JavaSwing;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class GiaoDien extends JFrame{
	public GiaoDien() {
		super("QLSV");
	}
private void gui() {
	Box b = Box.createVerticalBox();
	Box b1 = Box.createHorizontalBox();
	Box b2 = Box.createHorizontalBox();
	Box b3 = Box.createHorizontalBox();
	Box b4 = Box.createHorizontalBox();
	Box b5 = Box.createHorizontalBox();
	b.add(b1);
	b.add(Box.createVerticalStrut(5));
	b.add(b2);
	b.add(Box.createVerticalStrut(5));
	b.add(b3);
	b.add(Box.createVerticalStrut(5));
	b.add(b4);
	b.add(Box.createVerticalStrut(5));
	b.add(b5);
	b.add(Box.createVerticalStrut(10));
	this.add(b,BorderLayout.NORTH);
	JLabel l1;
	b1.add(l1 = new JLabel("id"));
	JTextField txt_ma;
	b1.add(txt_ma = new JTextField(20));
	
}

}
