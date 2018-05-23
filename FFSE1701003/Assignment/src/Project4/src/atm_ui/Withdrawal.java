package atm_ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import java.util.UUID;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import atm_model.Withdrawal_model;
import atm_model.Atm_md;
import atm_model.Session_model;

public class Withdrawal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Item> cbATM;
	private JButton btnRutTien;
	NumberFormat amountFormat;
	JFormattedTextField txtPrice;
	Atm_md Atm_md = new Atm_md();
	Withdrawal_model withdrawal = new Withdrawal_model();
	JTable table = new JTable();
	private DefaultTableModel dm;

	public Withdrawal() {
		initialize();
		addEvents();
	}

	public static void main(String[] args) {
		new Withdrawal();
	}

	public void initialize() {
		setLayout(new BorderLayout());
		JPanel pnWithdrawal = new JPanel();
		JPanel pnContentLeft = new JPanel();

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Rút tiền");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JLabel lb1 = new JLabel();
		lb1.setText("Số tiền");
		amountFormat = NumberFormat.getNumberInstance();
		txtPrice = new JFormattedTextField(amountFormat);
		txtPrice.setValue(new Double(0));

		JLabel lb2 = new JLabel();
		lb2.setText("Chọn ATM");
		cbATM = new JComboBox<>();
		Atm_md.setATM(cbATM);

		btnRutTien = new JButton("Rút tiền");

		lb1.setPreferredSize(new Dimension(80, 20));
		lb2.setPreferredSize(new Dimension(80, 20));
		txtPrice.setPreferredSize(new Dimension(150, 20));
		cbATM.setPreferredSize(txtPrice.getPreferredSize());

		GroupLayout layout = new GroupLayout(pnContentLeft);
		pnContentLeft.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lb1).addComponent(lb2))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(txtPrice)
						.addComponent(cbATM).addComponent(btnRutTien))

		);

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lb1)
						.addComponent(txtPrice))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lb2)
						.addComponent(cbATM))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnRutTien))

		);

		this.add(pnContentLeft, BorderLayout.WEST);

		this.add(pnWithdrawal);

		table = new JTable();
		String col[] = { "STT", "Mã giao dịch", "Mã thẻ", "Mã ATM", "Số tiền", "Thời gian" };
		dm = new DefaultTableModel(col, 0);
		JScrollPane scroll = new JScrollPane(table);
		table.setModel(dm);
		table.setRowHeight(20);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách giao dịch"));
		this.add(scroll, BorderLayout.CENTER);
		table();
	}

	public void table() {
		ArrayList<Withdrawal_model> dataTable = withdrawal.getRecords();

		Object[] row = new Object[6];
		int count = dataTable.size();
		dm.setRowCount(0);
		for (int i = 0; i < count; i++) {
			int j = i + 1;
			row[0] = j;
			row[1] = dataTable.get(i).getCode();
			row[2] = dataTable.get(i).getSn_card();
			row[3] = dataTable.get(i).getAtm_code();
			row[4] = dataTable.get(i).getNumber();
			row[5] = dataTable.get(i).get_time();
			dm.addRow(row);
		}
	}

	public void addEvents() {
		btnRutTien.addActionListener(RutTien);
	}

	ActionListener RutTien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int price = ((Number) txtPrice.getValue()).intValue();
			Item atmSelected = (Item) cbATM.getSelectedItem();
			String atm_code = atmSelected.getDescription();

			// RandomString
			String transaction_code = generateString();

			int sn_card = Session_model.getSnCard();
			Withdrawal_model temp = new Withdrawal_model(transaction_code, atm_code, sn_card, price);

			if (checkInput()) {
				int result = Withdrawal_model.addNew(temp);
				if (result != -1) {
					table();
					showMessageDialog(result, "Rút tiền");
				} else {
					showMessageDialog(result, "Rút tiền");
				}
			}
		}
	};

	public static String generateString() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}

	public void showMessageDialog(int result, String message) {
		if (result == 1) {
			resetInput();
			JOptionPane.showMessageDialog(null, message + " thành công");
		} else {
			JOptionPane.showMessageDialog(null, message + " không thành công");
		}
	}

	public boolean checkInput() {
		int price = ((Number) txtPrice.getValue()).intValue();
		int percent = price % 10000;
		Item atmSelected = (Item) cbATM.getSelectedItem();
		String atm_code = atmSelected.getDescription();
		int result = 1;
		if (percent != 0 || price < 10000) {
			JOptionPane.showMessageDialog(null, "Số tiền rút phải là bội số của 10.000đ");
			result = 0;
		} else if (atm_code.equals("") || atm_code.equals(null) || atm_code.equals("Chọn một ATM")) {
			JOptionPane.showMessageDialog(null, "Chọn một ATM");
			result = 0;
		}
		if (result == 1) {
			return true;
		} else {
			return false;
		}

	}

	public void resetInput() {
		txtPrice.setText("");
		cbATM.setSelectedIndex(0);
	}
}
