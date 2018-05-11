package JavaSwing;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class Test1 extends JFrame {
	JLabel lb_a;
	public Test1(String tieude)
	{
		super(tieude);
		lb_a = new JLabel();
		lb_a.setText("FIRST TIME: ");
		lb_a.setForeground(Color.RED);
		this.add(lb_a);
	}

}
