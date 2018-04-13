package ui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	final JRadioButton rbnAdmin = new JRadioButton("Quản trị viên");
	final JRadioButton rbnCustomer = new JRadioButton("Khách hàng");
	JButton btnAdminLogin, btnCustomerLogin;
	JPanel pnInput;
	CardLayout lyt;
	
	/*Thêm sự kiện cho radiobutton*/
	ActionListener showAdminInput = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton aBtn = (AbstractButton) e.getSource();
			if (aBtn.isSelected()) {
				lyt.show(pnInput, "1");
			}
		}
	};
	
	ActionListener showCustomerInput = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton aBtn = (AbstractButton) e.getSource();
			if (aBtn.isSelected()) {
				lyt.show(pnInput, "2");
			}
		}
	};
	
	public LoginUI(String title) {
		super(title);
		addPanels();
		addEvents();
	}
	
	void addPanels() {
		
		/*Main*/
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		con.add(pnMain);
		
		JPanel pnTop = new JPanel();
		JPanel pnBottom = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		pnMain.add(pnTop);
		pnMain.add(pnBottom);
		
		/*Main -> Top*/
		pnTop.setLayout(new GridLayout(0, 1));
		JLabel bg = new JLabel();
		bg.setPreferredSize(new Dimension(600, 200));
		pnTop.add(bg);
		ImageIcon bgImage = new ImageIcon(getClass().getResource("/images/bg.png"));
		bgImage.getImage().getScaledInstance(600, 200, Image.SCALE_SMOOTH);
		bg.setIcon(bgImage);
	
		/*Main -> Bottom*/
		pnInput = new JPanel();
		JPanel pnSelection = new JPanel();
		pnBottom.setLayout(new BoxLayout(pnBottom, BoxLayout.Y_AXIS));
		pnBottom.add(pnInput);
		pnBottom.add(pnSelection);
		
		/*Main -> Bottom -> Selection*/
		ButtonGroup bgSelect = new ButtonGroup();
		bgSelect.add(rbnAdmin);
		bgSelect.add(rbnCustomer);
		rbnAdmin.setSelected(true);
		pnSelection.add(rbnAdmin);
		pnSelection.add(rbnCustomer);
		
		/*Main -> Bottom -> Input*/
		JPanel pnAdminInput = new JPanel();
		JPanel pnCustomerInput = new JPanel();
		lyt = new CardLayout();
		pnInput.setLayout(lyt);
		pnInput.add(pnAdminInput, "1");
		pnInput.add(pnCustomerInput, "2");
		
		/*Main -> Bottom -> Input -> Admin*/
		pnAdminInput.setLayout(new BoxLayout(pnAdminInput, BoxLayout.Y_AXIS));
		JPanel pnAdminName = new JPanel();
		JPanel pnAdminPass = new JPanel();
		JPanel pnAdminButton = new JPanel();
		btnAdminLogin = new JButton("Đăng nhập");
		pnAdminInput.add(Box.createVerticalGlue());
		pnAdminInput.add(pnAdminName);
		pnAdminInput.add(pnAdminPass);
		pnAdminInput.add(pnAdminButton);
		pnAdminInput.add(Box.createVerticalGlue());
		
		JLabel lblAdminName = new JLabel("Tên đăng nhập:");
		lblAdminName.setPreferredSize(new Dimension(80, 15));
		JTextField txtAdminName = new JTextField(20);
		pnAdminName.add(lblAdminName);
		pnAdminName.add(txtAdminName);
		
		JLabel lblAdminPass = new JLabel("Mật khẩu:");
		lblAdminPass.setPreferredSize(new Dimension(80, 15));
		JTextField txtAdminPass = new JTextField(20);
		pnAdminPass.add(lblAdminPass);
		pnAdminPass.add(txtAdminPass);
		
		pnAdminButton.setLayout(new BoxLayout(pnAdminButton, BoxLayout.X_AXIS));
		pnAdminButton.add(Box.createRigidArea(new Dimension(10, 0)));
		pnAdminButton.add(btnAdminLogin);
		
		/*Main -> Bottom -> Input -> Customer*/
		pnCustomerInput.setLayout(new BoxLayout(pnCustomerInput, BoxLayout.Y_AXIS));
		JPanel pnCustomerName = new JPanel();
		JPanel pnCustomerPass = new JPanel();
		JPanel pnCustomnerButton = new JPanel();
		btnCustomerLogin = new JButton("Đăng nhập");
		pnCustomerInput.add(Box.createVerticalGlue());
		pnCustomerInput.add(pnCustomerName);
		pnCustomerInput.add(pnCustomerPass);
		pnCustomerInput.add(pnCustomnerButton);
		pnCustomerInput.add(Box.createVerticalGlue());
		
		JLabel lblCustomerName = new JLabel("Số thẻ ATM:");
		lblCustomerName.setPreferredSize(new Dimension(80, 15));
		JTextField txtCustomerName = new JTextField(20);
		pnCustomerName.add(lblCustomerName);
		pnCustomerName.add(txtCustomerName);
		
		JLabel lblCustomerPass = new JLabel("PIN:");
		lblCustomerPass.setPreferredSize(new Dimension(80, 15));
		JTextField txtCustomerPass = new JTextField(20);
		pnCustomerPass.add(lblCustomerPass);
		pnCustomerPass.add(txtCustomerPass);
		
		pnCustomnerButton.setLayout(new BoxLayout(pnCustomnerButton, BoxLayout.X_AXIS));
		pnCustomnerButton.add(Box.createRigidArea(new Dimension(10, 0)));
		pnCustomnerButton.add(btnCustomerLogin);

	}
	
	void addEvents() {
		rbnAdmin.addActionListener(showAdminInput);
		rbnCustomer.addActionListener(showCustomerInput);
	}
	
	void showWindow() {
	    this.setSize(600, 400);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	    this.setResizable(false);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
		LoginUI ui = new LoginUI("Đăng nhập - TPBank");
		ui.showWindow();
	}

}
