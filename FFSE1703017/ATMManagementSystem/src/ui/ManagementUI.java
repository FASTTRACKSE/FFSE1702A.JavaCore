package ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.SessionLogin;
import model.User;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ManagementUI extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel pnSide, pnButton, pnCenter, pnCustomerReport, 
					pnCustomerWithdraw, pnATMReport,pnATMWithdraw;
	AtmAccessUI pnATMAccess;
	CustomerAccessUI pnCustomerAccess;
	private JButton btnCustomerAccess, btnCustomerReport, btnCustomerWithdraw, 
					btnATMAccess, btnATMReport, btnATMWithdraw, btnLogout;
	private CardLayout layoutCenter;
	private JLabel lblWelcome;
	private User user;

	private ActionListener showCustomerAccess = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "1");
			if (user.getRole() == 1) {
				pnCustomerAccess.loadCustomerList();
			} else {
				pnCustomerAccess.setTextToInput(user.getCustomerCode());
			}
		}
	};

	private ActionListener showATMAccess = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "2");
			pnATMAccess.loadAtmList();
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
	
	private ActionListener showUserWithdraw = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			layoutCenter.show(pnCenter, "2");
		}
	};

	public ManagementUI() {
		this.user = SessionLogin.getUser();
		addControls();
		if (user.getRole() == 1) {
			addControlsAdmin();
			addEventsAdmin();
		} else {
			addControlsCustomer();
			addEventsCustomer();
		}
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
		JPanel pnWelcome = new JPanel();
		pnSide.setLayout(new BoxLayout(pnSide, BoxLayout.Y_AXIS));
		pnButton = new JPanel();
		pnSide.add(Box.createVerticalGlue());
		pnSide.add(pnWelcome);
		pnSide.add(pnButton);
		pnSide.add(Box.createVerticalGlue());
		
		/*Main - Welcome*/
		String name = user.getName();
		String welcomeString = "<html>Xin chào, <font color='red'>" + name + "</font></html>.";
		lblWelcome = new JLabel(welcomeString);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblUser = new JLabel();
		ImageIcon bgImage = new ImageIcon(getClass().getResource("/images/user.png"));
		bgImage.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		lblUser.setIcon(bgImage);
		GroupLayout welcome = new GroupLayout(pnWelcome);
		pnWelcome.setLayout(welcome);
		welcome.setAutoCreateGaps(true);
		welcome.setAutoCreateContainerGaps(true);
		welcome.setHorizontalGroup(welcome.createSequentialGroup()
			.addGroup(welcome.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(lblUser)
				.addComponent(lblWelcome)
			)
		);
		welcome.setVerticalGroup(welcome.createSequentialGroup()
			.addComponent(lblUser)
			.addComponent(lblWelcome)
		);
		
	}
	
	private void addControlsAdmin() {
		
		/*Main --> Button*/
		btnCustomerAccess = new JButton("QUẢN LÝ KHÁCH HÀNG");
		btnCustomerAccess.setHorizontalAlignment(SwingConstants.LEFT);
		btnATMAccess = new JButton("QUẢN LÝ ATM");
		btnATMAccess.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomerReport = new JButton("BÁO CÁO KHÁCH HÀNG");
		btnCustomerReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomerWithdraw = new JButton("TÌNH HÌNH RÚT TIỀN CỦA KHÁCH HÀNG");
		btnCustomerWithdraw.setHorizontalAlignment(SwingConstants.LEFT);
		btnATMReport = new JButton("BÁO CÁO ATM");
		btnATMReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnATMWithdraw = new JButton("TÌNH HÌNH RÚT TIỀN TRÊN ATM");
		btnATMWithdraw.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout = new JButton("ĐĂNG XUẤT");
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		
		pnButton.setLayout(new GridLayout(0, 1, 0, 5));
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
		pnATMAccess = new AtmAccessUI();
		pnCustomerReport = new CustomerReportUI();
		pnCustomerWithdraw = new CustomerWithdrawUI();
		pnATMReport = new AtmReportUI();
		pnATMWithdraw = new AtmWithdrawUI();

		pnCenter.add(pnCustomerAccess, "1");
		pnCenter.add(pnATMAccess, "2");
		pnCenter.add(pnCustomerReport, "3");
		pnCenter.add(pnCustomerWithdraw, "4");
		pnCenter.add(pnATMReport, "5");
		pnCenter.add(pnATMWithdraw, "6");

	}

	private void addEventsAdmin() {
		btnCustomerAccess.addActionListener(showCustomerAccess);
		btnATMAccess.addActionListener(showATMAccess);
		btnCustomerReport.addActionListener(showCustomerReport);
		btnCustomerWithdraw.addActionListener(showCustomerWithdraw);
		btnATMReport.addActionListener(showATMReport);
		btnATMWithdraw.addActionListener(showATMWithdraw);

	}
	
	private void addControlsCustomer() {
		
		/*Main --> Button*/
		btnCustomerAccess = new JButton("THÔNG TIN CÁ NHÂN");
		btnCustomerAccess.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomerWithdraw = new JButton("LỊCH SỬ GIAO DỊCH CÁ NHÂN");
		btnCustomerWithdraw.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout = new JButton("ĐĂNG XUẤT");
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		
		pnButton.setLayout(new GridLayout(0, 1, 0, 5));
		pnButton.add(btnCustomerAccess);
		pnButton.add(btnCustomerWithdraw);
		pnButton.add(btnLogout);
		
		/* Main -> Center */
		layoutCenter = new CardLayout();
		pnCenter.setLayout(layoutCenter);

		pnCustomerAccess = new CustomerAccessUI();
		pnCustomerWithdraw = new CustomerWithdrawUI();

		pnCenter.add(pnCustomerAccess, "1");
		pnCenter.add(pnCustomerWithdraw, "2");

	}
	
	private void addEventsCustomer() {
		btnCustomerAccess.addActionListener(showCustomerAccess);
		btnCustomerWithdraw.addActionListener(showUserWithdraw);

	}
	
	public void addLogoutListener(LogoutListener evt) {
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				evt.doLogout();
			}
		});
	}

}
