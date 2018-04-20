package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.ATM;
import model.ATMDB;
import model.ComboItem;
import model.Customer;
import model.CustomerDB;
import model.TransactionDB;

public class ATMSimulation extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnWithdraw, btnLogout;
	private JFormattedTextField txtAmount, txtCustomerAmount;
	private JComboBox<ComboItem> cbList;
	private String cardSN;
	Customer cus;
	double customerAmount;

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public ATMSimulation(String cardSN) {
		this.cardSN = cardSN;
		addPanels();
		addEvents();
	}
	
	private void addPanels() {
		
		JPanel pnMain = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createVerticalGlue());
		this.add(pnMain);
		this.add(Box.createVerticalGlue());
		
		JLabel lblCutomerAmount = new JLabel("Số tiền trong TK:");
		JLabel lblChoose = new JLabel("Chọn máy ATM:");
		JLabel lblAmount = new JLabel("Số tiền muốn rút:");
		
		cbList = new JComboBox<>();
		ComboItem item = new ComboItem(0, "Chọn máy ATM");
		cbList.addItem(item);
		ArrayList<ComboItem> arr = ATMDB.getAllATMs();
		for (ComboItem it : arr) {
			cbList.addItem(it);
		}
		
		cus = CustomerDB.getCustomerbyCardSN(cardSN);
		customerAmount = cus.getAmount();
		txtCustomerAmount = new JFormattedTextField(new Double(customerAmount));
		txtCustomerAmount.setEditable(false);
		txtAmount = new JFormattedTextField(new Double(0));
		btnWithdraw = new JButton("Rút tiền");
		btnLogout = new JButton("Đăng xuất");
	
		GroupLayout card = new GroupLayout(pnMain);
		pnMain.setLayout(card);
		card.setAutoCreateGaps(true);
		card.setAutoCreateContainerGaps(true);
		card.setHorizontalGroup(card.createSequentialGroup()
			.addGroup(card.createParallelGroup(GroupLayout.Alignment.LEADING, false)
				.addComponent(lblCutomerAmount, 0, 90, Short.MAX_VALUE)
				.addComponent(lblAmount)
				.addComponent(lblChoose)
			)
			.addGroup(card.createParallelGroup(GroupLayout.Alignment.LEADING, false)
				.addComponent(txtCustomerAmount)
				.addComponent(txtAmount)
				.addComponent(cbList)
				.addGroup(card.createSequentialGroup()
					.addComponent(btnWithdraw, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnLogout, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				)
			)
		);
		
		card.setVerticalGroup(card.createSequentialGroup()
			.addGroup(card.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblCutomerAmount)
					.addComponent(txtCustomerAmount)
			)
			.addGroup(card.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lblAmount)
				.addComponent(txtAmount)
			)
			.addGroup(card.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(lblChoose)
				.addComponent(cbList)
			)
			.addGroup(card.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(btnWithdraw)
				.addComponent(btnLogout)
			)
		);
		
	}
	
	private void addEvents() {
		btnWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ComboItem it = (ComboItem) cbList.getSelectedItem();
				int atmKey = it.getKey();
				String atmCode = it.getValue();
				double amount = ((Number) txtAmount.getValue()).doubleValue();
				
				/*Lấy thông tin số tiền còn trong máy ATM*/
				ATM atm = ATMDB.getATMbyCode(atmCode);
				double atmAmount = atm.getAmount();
				
				/*Thực hiện giao dịch*/
				if (atmKey == 0 ) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn máy ATM.",
							"Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else if (amount > customerAmount) {
					JOptionPane.showMessageDialog(null, "Số tiền muốn rút lớn hơn số tiền bạn đang có.",
							"Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else if (amount > atmAmount) {
					JOptionPane.showMessageDialog(null, "Số tiền muốn rút lớn hơn số tiền máy ATM đang có.",
							"Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else if (amount % 10000 != 0 || amount < 10000) {
					JOptionPane.showMessageDialog(null, "Số tiền muốn rút phải là bội số của 10.000 VND.",
							"Thông báo", JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					int i = TransactionDB.makeTransaction(atmCode, cardSN, amount);
					if (i > 0) {
						cus = CustomerDB.getCustomerbyCardSN(cardSN);
						customerAmount = cus.getAmount();
						txtCustomerAmount.setValue(new Double(customerAmount));;
						JOptionPane.showMessageDialog(null, "Giao dịch thành công.", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Giao dịch không thành công.", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
	}

}
