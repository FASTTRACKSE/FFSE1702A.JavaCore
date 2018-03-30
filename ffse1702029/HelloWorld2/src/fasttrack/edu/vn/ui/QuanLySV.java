package fasttrack.edu.vn.ui;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuanLySV extends JFrame {
	public QuanLySV(String title) {
		super(title);
		addControl();
	}
	public void addControl() {
		Container con = getContentPane();
		JPanel pn = new JPanel();
		pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS ));
		JPanel pnTitle
	}
}
