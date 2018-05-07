package atm_main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import atm_model.*;
import atm_ui.*;

public class MyApp extends JFrame {
	private JPanel pnMain, pnTop;
	private JPanel wrapPnContent = new JPanel();
	private JButton btnCustomer, btnATM, btnThongKe, btnGiaoDich, btnThongKeATM;
	private JPanel pnCustomer, pnCustomerLeft, pnCustomerRight, pnATM, pnATMLeft, pnATMRight, pnBaoCao, pnBaoCaoLeft,
			pnBaoCaoRight, pnGiaoDich, pnGiaoDichContent, pnBaoCaoATM;
	CardLayout card;

	final String CUSTOMER = "Customer"; // Customer frame
	final String ATM = "ATM!"; // ATM Frame
	final String THONGKE = "ThongKe"; // ThongKe Frame

	public MyApp() {
		setFrame();
		addEvents();
		showWindow();
	}

	public static void main(String[] args) {
		new Login_ui("Đăng nhập");
	}

	public void setFrame() {
		Container con = getContentPane();
		// pnTop
		pnMain = new JPanel();
		pnTop = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		btnCustomer = new JButton("Quản lý Khách hàng");
		btnATM = new JButton("Quản lý ATM");
		btnThongKe = new JButton("Thống kê KH");
		btnThongKeATM = new JButton("Thống kê ATM");
		btnGiaoDich = new JButton("Quản lý giao dịch");

		pnTop.add(btnCustomer);
		pnTop.add(btnATM);
		pnTop.add(btnGiaoDich);
		pnTop.add(btnThongKe);
		pnTop.add(btnThongKeATM);

		pnMain.add(pnTop);

		// Add JPanel to CardLayout.
		card = new CardLayout();
		wrapPnContent.setLayout(card);

		// All the cards
		pnCustomer = new JPanel();
		pnATM = new JPanel();
		pnBaoCao = new JPanel();
		pnGiaoDich = new JPanel();
		pnBaoCaoATM = new JPanel();

		// Component JPanel Customer
		pnCustomerRight = new ListCustomer();
		pnCustomer.add(pnCustomerRight);
		pnCustomer.setLayout(new BoxLayout(pnCustomer, BoxLayout.X_AXIS));

		// Component JPanel ATM
		pnATMRight = new ListAtm_ui();
		pnATM.add(pnATMRight);
		pnATM.setLayout(new BoxLayout(pnATM, BoxLayout.X_AXIS));

		// Quản lý giao dich
		pnGiaoDichContent = new Withdrawal();
		pnGiaoDich.add(pnGiaoDichContent);
		pnGiaoDich.setLayout(new BoxLayout(pnGiaoDich, BoxLayout.X_AXIS));

		// Component JPanel BaoCao
		JPanel pnBaoCaoRight = new Report();
		pnBaoCao.add(pnBaoCaoRight);
		pnBaoCao.setLayout(new BoxLayout(pnBaoCao, BoxLayout.X_AXIS));
		
		// Component JPanel BaoCao
		
		JPanel pnBaoCaoATMContent = new ReportATM();
		pnBaoCaoATM.add(pnBaoCaoATMContent);
		pnBaoCaoATM.setLayout(new BoxLayout(pnBaoCaoATM, BoxLayout.X_AXIS));

		// Add them to the cards JPanel
		wrapPnContent.add(pnCustomer, "card1");
		wrapPnContent.add(pnATM, "card2");
		wrapPnContent.add(pnGiaoDich, "card3");
		wrapPnContent.add(pnBaoCao, "card4");
		wrapPnContent.add(pnBaoCaoATM, "card5");

		// Add the panel to the Container
		pnMain.add(wrapPnContent);
		con.add(pnMain);

	}

	public void addEvents() {
		btnCustomer.addActionListener(showCard1);
		btnATM.addActionListener(showCard2);
		btnGiaoDich.addActionListener(showCard3);
		btnThongKe.addActionListener(showCard4);
		btnThongKeATM.addActionListener(showCard5);
	}

	ActionListener showCard1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			card.show(wrapPnContent, "card1");
		}
	};

	ActionListener showCard2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ListAtm_ui atm = new ListAtm_ui();
			atm.resetInput();
			card.show(wrapPnContent, "card2");
		}
	};

	ActionListener showCard3 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			card.show(wrapPnContent, "card3");
		}
	};

	ActionListener showCard4 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			card.show(wrapPnContent, "card4");
		}
	};

	ActionListener showCard5 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			card.show(wrapPnContent, "card5");
		}
	};
	
	public void showWindow() {
		// this.setBounds(0, 0, 1366, 768);
		this.setBounds(0, 0, 1300, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
