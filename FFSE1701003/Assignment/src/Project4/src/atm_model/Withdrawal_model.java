package atm_model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class Withdrawal_model {
	private final static Connection conn = atm_connection.getConnect();
	private String code, atm_code, cusName, cusAddress;
	private String atmAddress;
	private int quan, phuong;
	private int sn_card, number;
	private String _time;
	SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAtm_code() {
		return atm_code;
	}

	public void setAtm_code(String atm_code) {
		this.atm_code = atm_code;
	}

	public int getSn_card() {
		return sn_card;
	}

	public void setSn_card(int sn_card) {
		this.sn_card = sn_card;
	}

	public double getNumber() {
		return number;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String get_time() {
		return _time;
	}

	public void set_time(String _time) {
		this._time = _time;
	}

	public int getQuan() {
		return quan;
	}

	public void setQuan(int quan) {
		this.quan = quan;
	}

	public int getPhuong() {
		return phuong;
	}

	public void setPhuong(int phuong) {
		this.phuong = phuong;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public String getAtmAddress() {
		return atmAddress;
	}

	public void setAtmAddress(String atmAddress) {
		this.atmAddress = atmAddress;
	}

	public Withdrawal_model() {
	}

	public Withdrawal_model(String code, String atm_code, int sn_card, int number, String _time) {
		this.code = code;
		this.atm_code = atm_code;
		this.sn_card = sn_card;
		this.number = number;
		this._time = _time;
	}

	public Withdrawal_model(String code, String atm_code, int sn_card, int number) {
		this.code = code;
		this.atm_code = atm_code;
		this.sn_card = sn_card;
		this.number = number;
	}

	public ArrayList<Withdrawal_model> getRecords() {
		ArrayList<Withdrawal_model> data = new ArrayList<>();
		String sql = "SELECT * FROM tbl_transaction WHERE isactive = 1";
		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			Withdrawal_model atm;

			while (result.next()) {
				atm = new Withdrawal_model(result.getString("code"), result.getString("atm_code"),
						result.getInt("sn_card"), result.getInt("number"), result.getString("time"));
				data.add(atm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public ArrayList<Withdrawal_model> getRecordsWithCustomer(String strWhere) {
		ArrayList<Withdrawal_model> data = new ArrayList<>();
		String sql = "SELECT trans.*, trans.`code` as transCode, cus.*, cus.code as cusCode FROM tbl_transaction AS trans INNER JOIN "
				+ "tbl_customer AS cus ON trans.sn_card = cus.sn_card WHERE trans.isactive = 1 " + strWhere;
		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			Withdrawal_model atm;
			while (result.next()) {
				atm = new Withdrawal_model();
				atm.setCusName(result.getString("name"));
				atm.setSn_card(result.getInt("cus.sn_card"));
				atm.setQuan(result.getInt("quan"));
				atm.setPhuong(result.getInt("phuong"));
				atm.setCusAddress(result.getString("address"));
				atm.setCode(result.getString("transCode"));
				atm.set_time(result.getString("time"));
				atm.setNumber(result.getInt("number"));
				data.add(atm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public ArrayList<Withdrawal_model> getRecordsWithCustomerAndATM(String strWhere) {
		ArrayList<Withdrawal_model> data = new ArrayList<>();
		String sql = "SELECT trans.*, trans.`code` as transCode, cus.*, cus.code as cusCode, atm.* FROM "
				+ "tbl_transaction AS trans INNER JOIN tbl_customer AS cus ON trans.sn_card = cus.sn_card "
				+ "INNER JOIN tbl_atm AS atm ON trans.atm_code = atm.code " + "WHERE trans.isactive = 1 " + strWhere;
		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			Withdrawal_model atm;
			while (result.next()) {
				atm = new Withdrawal_model();
				atm.setCode(result.getString("transCode"));
				atm.setCusName(result.getString("cus.name"));
				atm.setSn_card(result.getInt("trans.sn_card"));
				atm.setAtm_code(result.getString("trans.atm_code"));
				atm.setQuan(result.getInt("atm.quan"));
				atm.setPhuong(result.getInt("atm.phuong"));
				atm.setAtmAddress(result.getString("atm.address"));
				atm.set_time(result.getString("trans.time"));
				atm.setNumber(result.getInt("trans.number"));
				data.add(atm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static int addNew(Withdrawal_model atm) {
		try {
			int x = 1;
			int atmTotal = kiemTraATM(atm.getAtm_code());
			int cusAmount = kiemTraTaiKhoan(atm.getSn_card());
			int percent = atmTotal % (int) atm.getNumber();
			if (atmTotal > (int) atm.getNumber() && percent == 0 && cusAmount > (int) atm.getNumber()) {
				String sql = "insert into tbl_transaction (code, atm_code, sn_card, number) " + " values (?, ?, ?, ?)";
				PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);

				stm.setString(1, atm.getCode());
				stm.setString(2, atm.getAtm_code());
				stm.setInt(3, atm.getSn_card());
				stm.setDouble(4, atm.getNumber());
				int i = stm.executeUpdate();

				if (i > 0) {
					/* Trừ tiền trong thẻ ATM */
					Customer_model cus = Customer_model.getCustomerbyCardSN(atm.getSn_card());
					double customerAmount = atmTotal - atm.getNumber();

					String sqlCustomer = "UPDATE tbl_customer SET amount = ? WHERE sn_card = ? ";
					PreparedStatement stmCustomer = (PreparedStatement) conn.prepareStatement(sqlCustomer);
					stmCustomer.setDouble(1, customerAmount);
					stmCustomer.setInt(2, atm.getSn_card());
					int j = stmCustomer.executeUpdate();
					if (j <= 0) {
						x = -1;
					}

					/* Trừ tiền trong máy ATM */
					Atm_md atm_md = Atm_md.getATMbyCode(atm.getAtm_code());
					double atmAmount = atm_md.getTotal();
					atmAmount = atmAmount - atm.getNumber();
					String sqlATM = "UPDATE  tbl_atm SET total = ? WHERE code = ?  ";
					PreparedStatement stmATM = (PreparedStatement) conn.prepareStatement(sqlATM);
					stmATM.setDouble(1, atmAmount);
					stmATM.setString(2, atm.getAtm_code());
					int k = stmATM.executeUpdate();
					if (k <= 0) {
						x = -1;
					}
				}
				return x;
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int kiemTraATM(String amtCode) {
		try {
			String sql = "SELECT total FROM  tbl_atm WHERE code = '" + amtCode + "'";
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				return result.getInt("total");
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int truTienATM(int total, int number) {
		try {
			int result = total - number;
			String sql = "UPDATE tbl_atm SET VALUES total = " + result;
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			int i = stm.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int kiemTraTaiKhoan(int snCard) {
		try {
			String sql = "SELECT amount FROM  tbl_customer WHERE sn_card = " + snCard;
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				return result.getInt("amount");
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int truTienCus(int amount, int number) {
		try {
			int result = amount - number;
			String sql = "UPDATE tbl_customer SET VALUES amount = " + result;
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static Date truncateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static int getLastID() {
		try {
			String sql = "SELECT MAX(id) as MAXID FROM tbl_transaction ";
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			result.next();
			return result.getInt("MAXID");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
