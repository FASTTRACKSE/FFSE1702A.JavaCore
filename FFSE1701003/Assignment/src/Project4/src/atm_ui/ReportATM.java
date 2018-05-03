package atm_ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import atm_model.AddressDB;

public class ReportATM extends JPanel {
	private JPanel pnReport, pnControls;
	private JButton btn_reportATM, btn_reportATMWithdrawl;
	private JTable table;
	private DefaultTableModel dm;
	AddressDB addressDB = new AddressDB();
	CardLayout cardReport;

	public ReportATM() {
		initialize();
		addEvents();
	}

	public void initialize() {
		setLayout(new BorderLayout());
		cardReport = new CardLayout();
		pnReport = new JPanel();
		pnControls = new JPanel();
		pnReport.setLayout(cardReport);
		JPanel pnReportCus = new ReportATMStatus();
		JPanel pnReportCusWithdrawl = new ReportATMWithdrawal();

		// set gridlayout group
		pnControls.setLayout(new GridLayout(0, 1, 5, 5));
		btn_reportATM = new JButton("Báo cáo tình trạng ATM");
		btn_reportATMWithdrawl = new JButton("Báo cáo rút tiền theo ATM");

		pnControls.add(btn_reportATM);
		pnControls.add(btn_reportATMWithdrawl);

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
		btn_reportATM.addActionListener(showCard1);
		btn_reportATMWithdrawl.addActionListener(showCard2);
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
