package fasttrack.edu.vn.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.util.*;
import java.sql.*;
import com.mysql.*;

import fasttrack.edu.vn.main.ConnectDB;
import java.io.*;

public class MyException extends Exception {
	ConnectDB cn = new ConnectDB();
	Connection conn = cn.getConnect("localhost", "Appcuatoi", "Appcuatoi", "123456");

	public MyException() {
		super();
	}

	// Check User Code
	public boolean checkMKH(String str) throws MyException {
		try {
			String sql = "select MaKH from qlkh";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if (str.equals(result.getString(1))) {
					JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại!");
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// Check Meter Code
	public boolean checkMCT(String str) throws MyException {
		try {
			String sql = "select MaCT from qlkh ";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if (str.equals(result.getString(1))) {
					JOptionPane.showMessageDialog(null, "Mã công tơ đã tồn tại!");
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// Check Empty

	public boolean checkEmpty(String str) throws MyException {
		if (str.equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			return false;
		}
		return true;
	}

	// Check Phone

	public boolean checkPhone(String str) throws MyException {
		if (str.equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống!");
			return false;
		} else {
			try {
				Integer.parseInt(str);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số!");
				return false;
			}
		}
		return true;
	}

	// Check Email

	public boolean checkEmail(String str) throws MyException {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(str);
		if (!matcher.matches()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng!");
			return false;
		}
		return true;
	}

	// Check Find Meter Code
	public boolean checkBLMaCT(String str) throws MyException {
		try {
			String sql = "select MaCT from qlkh WHERE MaCT = '" + str + "'";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				return true;
				// if(str.equals(result.getString(1))) {
				// return true;
				// } else {
				// JOptionPane.showMessageDialog(null, "Mã công tơ không tồn tại!");
				// return false;
				// }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return true;
		JOptionPane.showMessageDialog(null, "Mã công tơ không tồn tại!");
		return false;
	}

	// Check Cycle

	// Check Cycle

	public boolean chkCycle(String month, String year, String MCT) throws MyException {
		try {
			String sqlCount = "select Id_BL from qlbl where MaCT = '" + MCT + "'";
			Statement stmCount = conn.createStatement();
			ResultSet rsCount = stmCount.executeQuery(sqlCount);
			while (rsCount.next()) {
				if (rsCount.getString(1).equals("0")) {
					return true;
				} else if (month.equals("1")) {
					int lastYear = Integer.parseInt(year) - 1;
					try {
						String sql = "select * from qlbl where MaCT = '" + MCT + "' and Chu_Ky_Month = '" + 12
								+ "' and Chu_Ky_Year = '" + lastYear + "'";
						Statement stm = conn.createStatement();
						ResultSet rs = stm.executeQuery(sql);
						while (rs.next()) {
							return true;
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Kiểm tra lại chu kì");
					return false;
				} else {
					try {
						int intMonth = Integer.parseInt(month) - 1;
						String sql = "select MaCT from qlbl where MaCT = '" + MCT + "' and Chu_Ky_Month = '" + intMonth
								+ "' and Chu_Ky_Year = '" + year + "'";
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery(sql);
						while (result.next()) {
							return true;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Kiểm tra lại chu kì");
					return false;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return true;
	}

	// Check Same Cycle
	public boolean chkSameCycle(String month, String year, String meterCode) throws MyException {
		try {
			String sql = "select Meter_Code from ffse1702011_bill_information where Meter_Code = '" + meterCode
					+ "' and Cycle_Month = '" + month + "' and Cycle_Year = '" + year + "'";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				JOptionPane.showMessageDialog(null, "Kiểm tra lại chu kì");
				return false;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return true;
	}
	// Check Meter Number

	public boolean chkMeterNumber(String str) throws MyException {
		if (str.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng không để trống!");
			return false;
		} else {
			try {
				Integer.parseInt(str);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số!");
				return false;
			}
		}
		int intStr = Integer.parseInt(str);
		if (intStr < 0) {
			JOptionPane.showMessageDialog(null, "Không được nhập số âm!");
			return false;

		}
		return true;
	}
}
