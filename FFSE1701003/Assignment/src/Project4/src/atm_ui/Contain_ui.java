package atm_ui;

import java.awt.*;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import org.gjt.mm.mysql.Driver;

import javax.swing.JTable;

public class Contain_ui extends JFrame {
	private JPanel f_contain;
	private JFrame pn_container;

	public Contain_ui() {
		JTabbedPane tabbedPane = new JTabbedPane();
		JScrollPane spTable = new JScrollPane(tabbedPane);
		// Vùng chứa nội dung
		JTextArea ta = new JTextArea(1000, 500);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		tabbedPane.setBounds(20, 20, 1000, 500);
		tabbedPane.add("Danh sách khách hàng", p1);
		tabbedPane.setFont(new Font("Arial", Font.BOLD / Font.ITALIC, 14));
		tabbedPane.add("Thêm mới khách hàng", p2);
		tabbedPane.setFont(new Font("Arial", Font.BOLD / Font.ITALIC, 14));

		// pn_container = new JPanel();
		// pn_container.add(tabbedPane);
		// pn_container.setSize(1000, 500);
		// pn_container.setLayout(null);
		// pn_container.setVisible(true);

		// f_contain = new JFrame();
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
