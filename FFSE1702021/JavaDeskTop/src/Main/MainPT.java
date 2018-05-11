package Main;




import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * ----------------- @author nguyenvanquan7826 -----------------
 * ---------------nguyenvanquan7826.wordpress.com --------------
 */
public class MainPT extends JFrame {
	JButton jbLogout, jbTK;
	JButton jbLogin;
	JMenuBar menuBar ;
	JScrollPane spListKH = new JScrollPane();
	JTable tbListKH = new JTable();
	String tbKH[] = { "Tên sách", "Tên tác gải", "Thể loại", "Nhà xuất bản","Tình trạng" };
	DefaultTableModel mdTableKH = new DefaultTableModel(tbKH, 0);
	public MainPT() {
		createGUI();
		setDisplay();
	}

	/**
	 * set display for JFrame
	 */
	private void setDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * add JTabbedPane into JFrame
	 */
	private void createGUI() {
		add(createTabbedPane());
	}

	/**
	 * create a JTabbedPane contain three tab
	 */
	private JTabbedPane createTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane();

		/* create three JPanel, which is content of tabs */
		JPanel panel1 = createPane1();
		LoginUI lg = new LoginUI();
//		JPanel pnMain = new JPanel();
//		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
//
//
//		
//		
//		
//		JPanel pnTittle = new JPanel();
//		JLabel lbTittle = new JLabel("Quản Lý Thư Viện Điện Tử");
//		Font fTittle = new Font("arial", Font.BOLD, 20);
//		lbTittle.setForeground(Color.RED);
//		lbTittle.setFont(fTittle);
//		pnTittle.add(lbTittle);
//		
//		JPanel pnTK = new JPanel();
//		JLabel lbTK = new JLabel("Nhập tài khoản");
//		JTextField txtTK = new JTextField();
//		Font fTK = new Font("arial", Font.PLAIN, 15);
//		lbTK.setFont(fTK);
//		txtTK.setColumns(17);
//		pnTK.add(lbTK);
//		pnTK.add(txtTK);
//		
//		JPanel pnMK = new JPanel();
//		JLabel lbMK = new JLabel("Nhập mật khẩu");
//		JTextField txtMK = new JTextField();
//		Font fMK = new Font("arial", Font.PLAIN, 15);
//		lbMK.setFont(fMK);
//		txtMK.setColumns(17);
//		pnMK.add(lbMK);
//		pnMK.add(txtMK);
//		
//		JPanel pnPQuyen = new JPanel();
//		Font fPQ = new Font("arial", Font.PLAIN, 15);
//		JRadioButton rdbPQAdmin = new JRadioButton("Admin                                                          ");
//		rdbPQAdmin.setFont(fPQ);
//		pnPQuyen.add(rdbPQAdmin);
//		JRadioButton rdbPQKhHang = new JRadioButton("Khách hàng");
//		rdbPQKhHang.setFont(fPQ);
//		pnPQuyen.add(rdbPQKhHang);
//		
//		JPanel pnLogin = new JPanel();
//		jbLogin = new JButton("Đăng Xuất");
//		pnLogin.add(jbLogin);
//		jbLogin = new JButton("Thoát");
//		pnLogin.add(jbLogin);
//		
//		
//		pnMain.add(pnTittle);
//		pnMain.add(pnTK);
//		pnMain.add(pnMK);
//		pnMain.add(pnPQuyen);
//		
//		pnMain.add(pnLogin);
//		

		/* add three tab with three JPanel */
		tabbedPane.addTab("Tab 1",  panel1);
		tabbedPane.addTab("Tab 2", lg);
	//	tabbedPane.addTab("Tab 3", pnMain1);

		return tabbedPane;
	}

	/**
	 * create JPanel 1 contain a JTextArea
	 */
	private JPanel createPane1() {
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(createTextArea(20, 30)));
		return panel;
	}

	/**
	 * create a JPanel contain a JLabel
	 */
	private JPanel createJPanel(String text) {
		JPanel panel = new JPanel(new GridLayout(1, 1));
		JLabel lb = new JLabel();
		lb.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lb);
		return panel;
	}

	/**
	 * create a JTextArea with rows and columns, two method setWrapStyleWord and
	 * setLineWrap make text can down line when text too long
	 */
	private JTextArea createTextArea(int row, int col) {
		JTextArea ta = new JTextArea(row, col);
		ta.setWrapStyleWord(true);
		ta.setLineWrap(true);
		ta.setForeground(Color.BLUE);
		return ta;
	}

	public static void main(String[] args) {
		new MainPT();
	}
}