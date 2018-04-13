package ui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class myUI extends JFrame {

	private static final long serialVersionUID = 1L;
	Container con;
	JPanel pnMain, pnSide, pnCenter, pnCustomerAccess, pnCustomerReport, pnCustomerWithdraw, pnATMAccess, pnATMReport, pnATMWithdraw;
	JButton btnCustomerAccess, btnCustomerReport, btnCustomerWithdraw, btnATMAccess, btnATMReport, btnATMWithdraw;
	CardLayout layoutCenter;
	
	ActionListener showCustomerAccess = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "1");
		}
	};
	
	ActionListener showATMAccess = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "2");
		}
	};
	
	ActionListener showCustomerReport = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "3");
		}
	};
	
	ActionListener showCustomerWithdraw = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "4");
		}
	};
	
	ActionListener showATMReport = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "5");
		}
	};
	
	ActionListener showATMWithdraw = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "6");
		}
	};

	public myUI (String title) {
		super(title);
		addControls();
		addEvent();
	}
	
	public void addControls() {
		
		/*Main Panel*/
		con = getContentPane();
		pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
		pnSide = new JPanel();
		pnCenter = new JPanel();
		
		pnMain.add(Box.createRigidArea(new Dimension(5, 0)));
		pnMain.add(pnSide);
		pnMain.add(Box.createRigidArea(new Dimension(5, 0)));
		pnMain.add(pnCenter);
		pnMain.add(Box.createRigidArea(new Dimension(5, 0)));
		con.add(pnMain);
		
		/*Main -> Side*/
		pnSide.setLayout(new BoxLayout(pnSide, BoxLayout.Y_AXIS));
		JPanel pnButton = new JPanel();
		pnSide.add(Box.createVerticalGlue());
		pnSide.add(pnButton);
		pnSide.add(Box.createVerticalGlue());
		
		btnCustomerAccess = new JButton("QUẢN LÝ KHÁCH HÀNG");
		btnATMAccess = new JButton("QUẢN LÝ ATM");
		btnCustomerReport = new JButton("BÁO CÁO KHÁCH HÀNG");
		btnCustomerWithdraw = new JButton("TÌNH HÌNH RÚT TIỀN CỦA KHÁCH HÀNG");
		btnATMReport = new JButton("BÁO CÁO ATM");
		btnATMWithdraw = new JButton("TÌNH HÌNH RÚT TIỀN TRÊN ATM");
		
		pnButton.setLayout(new GridLayout(0, 1, 0, 5));
		pnButton.add(btnCustomerAccess);
		pnButton.add(btnATMAccess);
		pnButton.add(btnCustomerReport);
		pnButton.add(btnCustomerWithdraw);
		pnButton.add(btnATMReport);
		pnButton.add(btnATMWithdraw);
		
		/*Main -> Center*/
		layoutCenter = new CardLayout();
		pnCenter.setLayout(layoutCenter);
		
		pnCustomerAccess = new CustomerAccess();
		pnATMAccess = new ATMAccess();
		pnCustomerReport = new CustomerReport();
		pnCustomerWithdraw = new CustomerWithdraw();
		pnATMReport = new ATMReport();
		pnATMWithdraw = new ATMWithdraw();
		
		pnCenter.add(pnCustomerAccess, "1");
		pnCenter.add(pnATMAccess, "2");
		pnCenter.add(pnCustomerReport, "3");
		pnCenter.add(pnCustomerWithdraw, "4");
		pnCenter.add(pnATMReport, "5");
		pnCenter.add(pnATMWithdraw, "6");
	
	}
	
	void addEvent() {
		btnCustomerAccess.addActionListener(showCustomerAccess);
		btnATMAccess.addActionListener(showATMAccess);
		btnCustomerReport.addActionListener(showCustomerReport);
		btnCustomerWithdraw.addActionListener(showCustomerWithdraw);
		btnATMReport.addActionListener(showATMReport);
		btnATMWithdraw.addActionListener(showATMWithdraw);
	}
	
	public void showWindow() {
	    this.setSize(1200, 600);
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
		myUI ui = new myUI("Hệ thống quản lý ATM - TPBank");
		ui.showWindow();
	}
}
