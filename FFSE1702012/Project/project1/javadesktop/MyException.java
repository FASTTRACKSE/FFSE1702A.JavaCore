package project1.javadesktop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class MyException extends Exception {
	static Connection conn = Connection_Database.Ketnoi();
	static PreparedStatement ptmt = null;
	private String error;
	private static String sql = "";

	public MyException() {
		// TODO Auto-generated constructor stub
	}

	public MyException(String error) {
		this.error = error;
	}

	public String toString() {
		return this.error;
	}

	// check mã khách hàng
	public static void MyE_check_mkh(String mkh) {

		try {
			if (mkh.equals("") || mkh.length() > 6) {
				throw new MyException("Mã khách hàng không hợp lệ ");
			}
		} catch (MyException e1) {
			// TODO Auto-generated catch block
			InformationCustomer.count.add(1);
			JOptionPane.showMessageDialog(null, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}

	}

	// check mã công tơ
	public static void MyE_check_mct(String mct) {
		try {
			if (mct.equals("")) {
				throw new MyException("Mã công tơ không hợp lệ ");
			}
		} catch (MyException e1) {
			// TODO Auto-generated catch block

			InformationCustomer.count.add(1);
			JOptionPane.showMessageDialog(null, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void MyE_check_mct1(String mct) {
		try {
			if (mct.equals(" ")) {
				throw new MyException("Mã công tơ không hợp lệ ");
			}
		} catch (MyException e1) {
			// TODO Auto-generated catch block

			QuanLyBienLai.dem.add(1);
			JOptionPane.showMessageDialog(null, e1, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}

	}

	// //check tôn tại ma khach hang và mã công tơ:
	public static void MyE_check_exist(String sql2, String com) {
		// TODO Auto-generated method stub
		int j = 0;
		try {

			ptmt = (PreparedStatement) conn.prepareStatement(sql2);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				j++;
			}
			if (j > 0) {
				throw new MyException(com + " đả tồn tại");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			InformationCustomer.count.add(1);
			System.out.println("Lỗi " + e);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			InformationCustomer.count.add(1);
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}

	}

	// check ho ten:
	public static void MyE_checkName(String name) {
		try {
			if (name.equals("")) {
				throw new MyException("Tên không được để trống ");
			}
			if (name.length() >= 30) {
				throw new MyException("Độ dài tên phải dưới 30 ký tự ");
			}
			if (name.length() <= 5) {
				throw new MyException("Độ dài tên phải trên 5 ký tự ");
			}
		} catch (MyException e) {
			InformationCustomer.count.add(1);
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	// check dia chi:
	public static void MyE_checkAddress(String address) {
		try {
			if (address.equals("")) {
				throw new MyException("Địa chỉ không được để trống");
			} else if (address.length() <= 5) {

			}
		} catch (MyException e) {
			InformationCustomer.count.add(1);
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	// check quan phuong
	public static void MyE_checkquan(String quan, String phuong) {
		try {
			if ((quan == "Chọn Quận")) {
				throw new MyException("Quận không được để trống");
			}
			if (phuong == "Chọn Phường") {
				throw new MyException("Phường không được để trống");
			}
		} catch (MyException e) {
			InformationCustomer.count.add(1);
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	// check so dien thoai:
	public static void MyE_checkphone(String phone) {
		try {
			if (phone.equals("")) {
				throw new MyException("Số điện thoại không được để trống ");
			}

			if (phone.length() <= 9) {
				throw new MyException("Độ dài số điện thoại phải trên 9 ký tự ");
			}
			String phonept = "0\\d{9,11}";
			if (!phone.matches(phonept)) {
				throw new MyException("Số điện thoại phải có dang 0.....");
			}
		} catch (MyException e) {
			InformationCustomer.count.add(1);
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	// check email:
	public static void MyE_checkemail(String email) {
		try {
			if (email.equals("")) {
				throw new MyException("Email không được để trống ");
			}
			String emailpt = "\\w+@\\w+\\.\\w+";
			if (!email.matches(emailpt)) {
				throw new MyException("Email không hợp lệ");
			}
		} catch (MyException e) {
			InformationCustomer.count.add(1);
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
	// check chu ky:

	public static void MyE_end_year(String mct, int month, int year) {
		int endmonth = 0;
		int endyear = 0;
		int i = 0;
		sql = "select * from BienLai where Macongto = '" + mct + "'";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				endmonth = rs.getInt("Thang");
				endyear = rs.getInt("Nam");
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
		// set exception cho chu ky nhap:
		if (i > 0) {
			try {
				if (year < endyear) {
					throw new MyException("Bạn đả nhập cho năm này");
				} else if (year == endyear) {
					if (((month - endmonth) != 1) && (endmonth != 12)) {
						throw new MyException(
								"Bạn phải nhập cho chu kỳ tháng " + (endmonth + 1) + " và năm " + endyear);
					} else if (endmonth == 12) {
						throw new MyException("Bạn phải nhập cho chu kỳ tháng " + (1) + " và năm " + (endyear + 1));
					}

				} else if (year > (endyear)) {
					if (((month - endmonth) != 1) && (endmonth != 12)) {
						throw new MyException(
								"Bạn phải nhập cho chu kỳ tháng " + (endmonth + 1) + " và năm " + endyear);
					}

					else if (endmonth == 12 && month != 1) {
						throw new MyException("Bạn phải nhập cho chu kỳ tháng " + 1 + " và năm " + (endyear + 1));

					}
				}

			} catch (MyException e) {
				QuanLyBienLai.dem.add(1);
				JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// check ngay nhap
	public static void MyE_date(String day) {
		try {
			if (day.equals(" ")) {
				throw new MyException("Ngày nhập không được tróng");
			}
		} catch (MyException e) {
			QuanLyBienLai.dem.add(1);
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	// check chi so cong to:
	public static void MyE_checkChiSo(String mct, String chiso, int csct) {
		int endcsct = 0;
		sql = "select * from BienLai where Macongto = '" + mct + "'";
		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				endcsct = rs.getInt("Chiso");
			}
			System.out.println(endcsct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}

		try {
			if (chiso.equals("")) {
				throw new MyException("Chi số không được để trống ");
			}
			String chisolpt = "\\d{1,10}";
			if (!chiso.matches(chisolpt)) {
				throw new MyException("Chỉ số chỉ được nhập số");
			}
			if (csct < endcsct) {
				throw new MyException("Bạn phải nhập chỉ số công tơ lớn hơn hoặc bằng với chu kỳ trước =" + endcsct);
			}
		} catch (MyException e) {
			QuanLyBienLai.dem.add(1);
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	// check ma so cong to tai thoi update:

	public static void MyE_checkChiSo1(int csct, int monthcp, int yearcp, String mct) {
		String monthFrom = "";
		String yearFrom = "";
		String monthTo = "";
		String yearTo = "";

		if (monthcp == 1) {
			monthFrom = "12";
			yearFrom = String.valueOf((yearcp - 1));
			monthTo = "2";
			yearTo = String.valueOf(yearcp);
		} else if (monthcp == 12) {
			monthFrom = "11";
			yearFrom = String.valueOf(yearcp);
			monthTo = "1";
			yearTo = String.valueOf((yearcp + 1));
		} else {
			monthFrom = String.valueOf((monthcp - 1));
			yearFrom = String.valueOf(yearcp);
			monthTo = String.valueOf((monthcp + 1));
			yearTo = String.valueOf(yearcp);

		}
		String dateFrom = yearFrom + "-" + monthFrom + "-01";
		String dateTo = yearTo + "-" + monthTo + "-01";

		java.util.Date date2 = null;
		java.util.Date date3 = null;
		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
			date3 = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dateFrom = df.format(date2);
		dateTo = df.format(date3);

		String sql = "select * from BienLai where Selecttime >='" + dateFrom + "' and Selecttime <= '" + dateTo + "'"
				+ " and Macongto='" + mct + "'";

		ArrayList<Integer> bl = new ArrayList<>();

		try {
			ptmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {

				int chiso = rs.getInt("Chiso");
				System.out.println(chiso);
				bl.add(chiso);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * 
		 */
		try {
			if (bl.size() == 2) {
				if (bl.get(0) == csct) {
					if (csct > bl.get(1)) {
						throw new MyException("Số chỉ số công tơ nhập lớn hơn chu kỳ sau");
					}
				}
				if (bl.get(1) == csct) {
					if (csct < bl.get(0)) {
						throw new MyException("Số chỉ số công tơ nhập nhỏ hơn chu kỳ trước");
					}
				}
			}
			if (bl.size() == 3) {

				if (csct > bl.get(2)) {
					throw new MyException("Số chỉ số công tơ nhập lớn hơn chu kỳ sau");
				}

				if (csct < bl.get(0)) {
					throw new MyException("Số chỉ số công tơ nhập nhỏ hơn chu kỳ trước");
				}

			}
		} catch (MyException e) {
			QuanLyBienLai.dem.add(1);
			JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
}
