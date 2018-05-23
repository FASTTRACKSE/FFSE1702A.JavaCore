package atm_ui;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Contain_ui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel f_contain;
	public Contain_ui() {
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		tabbedPane.setBounds(20, 20, 1000, 500);
		tabbedPane.add("Danh sách khách hàng", p1);
		tabbedPane.setFont(new Font("Arial", Font.BOLD / Font.ITALIC, 14));
		tabbedPane.add("Thêm mới khách hàng", p2);
		tabbedPane.setFont(new Font("Arial", Font.BOLD / Font.ITALIC, 14));

		f_contain = new JPanel();
		f_contain.add(tabbedPane);
		f_contain.setSize(1000, 500);
		f_contain.setLayout(null);
		f_contain.setVisible(true);

	}

	public static void main(String[] args) {
		new Contain_ui();
	}
}
