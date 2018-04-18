package ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class ManagementUI extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel pnSide, pnCenter, pnCustomerAccess, pnCustomerReport, 
					pnCustomerWithdraw, pnATMAccess, pnATMReport,pnATMWithdraw;
	private JButton btnCustomerAccess, btnCustomerReport, btnCustomerWithdraw, 
					btnATMAccess, btnATMReport, btnATMWithdraw, btnLogout;
	private CardLayout layoutCenter;
	private JLabel lblWelcome;

	private ActionListener showCustomerAccess = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "1");
		}
	};

	private ActionListener showATMAccess = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "2");
		}
	};

	private ActionListener showCustomerReport = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "3");
		}
	};

	private ActionListener showCustomerWithdraw = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "4");
		}
	};

	private ActionListener showATMReport = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "5");
		}
	};

	private ActionListener showATMWithdraw = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "6");
		}
	};

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JLabel getLblWelcome() {
		return lblWelcome;
	}

	public ManagementUI() {
		addControls();
		addEvent();
	}

	public void addControls() {

		/* Main Panel */
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		pnSide = new JPanel();
		pnCenter = new JPanel();

		this.add(Box.createRigidArea(new Dimension(5, 0)));
		this.add(pnSide);
		this.add(Box.createRigidArea(new Dimension(5, 0)));
		this.add(pnCenter);
		this.add(Box.createRigidArea(new Dimension(5, 0)));

		/* Main -> Side */
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
		lblWelcome = new JLabel();
		btnLogout = new JButton("ĐĂNG XUẤT");
		pnButton.add(lblWelcome);
		pnButton.add(btnCustomerAccess);
		pnButton.add(btnATMAccess);
		pnButton.add(btnCustomerReport);
		pnButton.add(btnCustomerWithdraw);
		pnButton.add(btnATMReport);
		pnButton.add(btnATMWithdraw);
		pnButton.add(btnLogout);
		
		/* Main -> Center */
		layoutCenter = new CardLayout();
		pnCenter.setLayout(layoutCenter);

		pnCustomerAccess = new CustomerAccessUI();
		pnATMAccess = new ATMAccessUI();
		pnCustomerReport = new CustomerReportUI();
		pnCustomerWithdraw = new CustomerWithdrawUI();
		pnATMReport = new ATMReportUI();
		pnATMWithdraw = new ATMWithdrawUI();

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

}
