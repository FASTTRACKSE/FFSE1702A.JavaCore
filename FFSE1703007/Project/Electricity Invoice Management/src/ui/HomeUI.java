package ui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeUI extends JFrame {
	JButton btnButton1, btnButton2, btnButton3;

	public HomeUI(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		addControls();
		addEvents();
	}

	public void showWindow() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	void addControls() {
		Container con = getContentPane();
		
//		CardLayout layout = new CardLayout();
//		JPanel pnAction = new JPanel();
//		pnAction.setLayout(layout);
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnButton1 = new JPanel();
		btnButton1 = new JButton("Quản lí khách hàng");
		btnButton1.setPreferredSize(new Dimension(200, 50));
		pnButton1.add(btnButton1);

		JPanel pnButton2 = new JPanel();
		btnButton2 = new JButton("Quản lí biên lai");
		btnButton2.setPreferredSize(new Dimension(200, 50));
		pnButton2.add(btnButton2);

		JPanel pnButton3 = new JPanel();
		btnButton3 = new JButton("Thống kê");
		btnButton3.setPreferredSize(new Dimension(200, 50));
		pnButton3.add(btnButton3);

		pnMain.add(pnButton1);
		pnMain.add(pnButton2);
		pnMain.add(pnButton3);

		con.add(pnMain);
	}
	ActionListener eventShowCustomerUI = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				showCustomerUI();
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	void showCustomerUI() throws HeadlessException, SQLException {
		CustomerUI customerUI =  new CustomerUI("Quản lí khách hàng");
		customerUI.showWindow();
	}
	
ActionListener eventShowInvoiceUI = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				showInvoiceUI();
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	ActionListener eventShowStatisticUI = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				showStatisticUI();
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	void showInvoiceUI() throws HeadlessException, SQLException {
		InvoiceUI invoiceUI =  new InvoiceUI("Quản lí biên lai");
		invoiceUI.showWindow();
	}
	
	void showStatisticUI() throws HeadlessException, SQLException {
		StatisticUI statisticUI = new StatisticUI("Thống kê");
		statisticUI.showWindow();
	}
	
	void addEvents() {
		btnButton1.addActionListener(eventShowCustomerUI);
		btnButton2.addActionListener(eventShowInvoiceUI);
		btnButton3.addActionListener(eventShowStatisticUI);
	}
}
