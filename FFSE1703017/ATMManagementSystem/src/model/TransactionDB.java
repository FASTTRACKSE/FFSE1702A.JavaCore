package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TransactionDB {
	private final static Connection conn = ConnectDB.getConnect();
	
	public static int makeTransaction (String atmCode, String cardSN, double amount) {
		try {
			
			int x = -1;
			/*Tạo giao dịch*/
			String sqlTran = "INSERT INTO tbl_transaction (atm_code, card_sn, amount) "
					+ "VALUES (?, ?, ?)";
			PreparedStatement stmTran = conn.prepareStatement(sqlTran, new String[]{"id"});
			stmTran.setString(1, atmCode);
			stmTran.setString(2, cardSN);
			stmTran.setDouble(3, amount);
			int i = stmTran.executeUpdate();
		
			/*Thực hiện khi giao dịch thành công*/
			if (i > 0) {
				
				/*Tạo mã giao dịch*/
				int last_id = 0;
				ResultSet rs = stmTran.getGeneratedKeys();
				if (rs.next()) {
					last_id = rs.getInt(1);
				}
			
				if (last_id > 0) {
					String code = "DNG" + (last_id + 11122200);
					String query = "UPDATE  tbl_transaction SET code = ? WHERE id = ? ";
					PreparedStatement pstm = conn.prepareStatement(query);
					pstm.setString(1, code);
					pstm.setInt(2, last_id);
					x = pstm.executeUpdate();
				}
			
				/*Trừ tiền trong thẻ ATM*/
				Customer cus = CustomerDB.getCustomerbyCardSN(cardSN);
				String customerCode = cus.getCode();
				double customerAmount = cus.getAmount();
				customerAmount = customerAmount - amount;
				String sqlCustomer = "UPDATE  tbl_customer SET amount = ? WHERE code = ?  ";
				PreparedStatement stmCustomer = conn.prepareStatement(sqlCustomer);
				stmCustomer.setDouble(1, customerAmount);
				stmCustomer.setString(2, customerCode); 
				int j = stmCustomer.executeUpdate();
				if (j <= 0) {
					x = -1;
				}
				
				/*Trừ tiền trong máy ATM*/
				ATM atm = ATMDB.getATMbyCode(atmCode);
				double atmAmount = atm.getAmount();
				atmAmount = atmAmount - amount;
				String sqlATM = "UPDATE  tbl_atm SET amount = ? WHERE code = ?  ";
				PreparedStatement stmATM = conn.prepareStatement(sqlATM);
				stmATM.setDouble(1, atmAmount);
				stmATM.setString(2, atmCode); 
				int k = stmATM.executeUpdate();
				if (k <= 0) {
					x = -1;
				}
			
			}
			
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
