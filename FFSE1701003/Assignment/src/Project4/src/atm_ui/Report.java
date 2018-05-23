package atm_ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import atm_model.AddressDB;

public class Report extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnReport, pnControls;
	private JButton btn_reportCus;
	private JButton btn_reportCusWithdrawl;
	AddressDB addressDB = new AddressDB();
	CardLayout cardReport;

	public Report() {
		initialize();
		addEvents();
	}

	public void initialize() {
		setLayout(new BorderLayout());
		cardReport = new CardLayout();
		pnReport = new JPanel();
		pnControls = new JPanel();
		pnReport.setLayout(cardReport);
		JPanel pnReportCus = new ReportCustomer();
		JPanel pnReportCusWithdrawl = new ReportCustomerWithdrawal();
		
		// set gridlayout group 
		pnControls.setLayout(new GridLayout(0, 1, 5, 5));
		btn_reportCus = new JButton("Báo cáo khách hàng");
		btn_reportCusWithdrawl = new JButton("Báo cáo rút tiền khách hàng");

		pnControls.add(btn_reportCus);
		pnControls.add(btn_reportCusWithdrawl);
		
		JPanel contentLeft = new JPanel();
		contentLeft.setLayout(new BoxLayout(contentLeft, BoxLayout.Y_AXIS));
		contentLeft.add(Box.createVerticalGlue());
		contentLeft.add(pnControls);
		contentLeft.add(Box.createVerticalGlue());

		// Add them to the cards JPanel
		pnReport.add(pnReportCus, "card1");
		pnReport.add(pnReportCusWithdrawl, "card2");

		this.add(contentLeft, BorderLayout.WEST);
		this.add(pnReport, BorderLayout.CENTER);
	}

	public void addEvents() {
		btn_reportCus.addActionListener(showCard1);
		btn_reportCusWithdrawl.addActionListener(showCard2);
	}

	ActionListener showCard1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			cardReport.show(pnReport, "card1");
		}
	};

	ActionListener showCard2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ListAtm_ui atm = new ListAtm_ui();
			atm.resetInput();
			cardReport.show(pnReport, "card2");
		}
	};
}
