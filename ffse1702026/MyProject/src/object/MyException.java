package object;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import database.DBBienLai;
import database.dbKhachHang;

public class MyException extends IOException {

	private String error;

	public MyException() {
		// TODO Auto-generated constructor stub
	}

	public MyException(String error) {
		this.error = error;
	}

	public String toString() {
		return this.error;
	}

	public static void checkName(String name) throws MyException {

		if (name.equals("")) {
			throw new MyException("Tên không được để trống ");
		}
		if (name.length() >= 30) {
			throw new MyException("Độ dài tên phải dưới 30 ký tự ");
		}
		if (name.length() <= 5) {
			throw new MyException("Độ dài tên phải trên 5 ký tự ");
		}
		// if (!name.matches(
		// "/^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð
		// ,.'-]+$/u")) {
		// throw new MyException("Tên chứa ký tự không hợp lệ ");
		// }

	}
	public static void checkLogin(String name,String check) throws MyException {

		if (name.equals("")) {
			throw new MyException(check+" không được để trống ");
		}
		if (name.length() >= 30) {
			throw new MyException("Độ dài "+check+" phải dưới 30 ký tự ");
		}
		if (name.length() <= 5) {
			throw new MyException("Độ dài "+check+" phải trên 5 ký tự ");
		}
		// if (!name.matches(
		// "/^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð
		// ,.'-]+$/u")) {
		// throw new MyException("Tên chứa ký tự không hợp lệ ");
		// }

	}

	public static void checkAdress(String address) throws MyException {
		if (address.equals("")) {
			throw new MyException("Địa chỉ không được để trống ");
		}

		if (address.length() <= 5) {
			throw new MyException("Độ dài địa chỉ phải trên 5 ký tự ");
		}
	}

	public static void checkPhone(String phone) throws MyException {
		if (phone.equals("")) {
			throw new MyException("Phone không được để trống ");
		}

		if (phone.length() <= 6) {
			throw new MyException("Độ dài số điện thoại phải trên 6 ký tự ");
		}
		String phonept = "0\\d{9,11}";
		if (!phone.matches(phonept)) {
			throw new MyException("phone không hợp lệ");
		}
	}

	public static void checkEmail(String email) throws MyException {
		if (email.equals("")) {
			throw new MyException("Email không được để trống ");
		}
		String emailpt = "\\w+@\\w+\\.\\w+";
		if (!email.matches(emailpt)) {
			throw new MyException("Email không hợp lệ");
		}
	}

	public static void checkMaKhachHang(String maKhachHang) throws MyException, SQLException {
		if (maKhachHang.equals("")) {
			throw new MyException("Mã khách hàng không được để trống ");
		}

		if (maKhachHang.length() <= 3) {
			throw new MyException("Độ dài mã khách hàng phải trên 3 ký tự ");
		}
		

	}
	public static void checkExist(String ma,String text) throws MyException, SQLException {
		
		ArrayList<KhachHang> arrKH = dbKhachHang.getList();
		for (KhachHang kh : arrKH) {
			if (ma.equals(kh.getMaKhackHang())) {
				throw new MyException(text+" đã tồn tại");
			}
		}

	}
	

	public static void checkMaCongTo(String maCongTo) throws MyException, SQLException {
		if (maCongTo.equals("")) {
			throw new MyException("Mã công tơ không được để trống ");
		}

		if (maCongTo.length() <= 3) {
			throw new MyException("Độ dài địa chỉ phải trên 3 ký tự ");
		}
		

	}

	public static void checkMCT(String maCongTo) throws MyException {
		if (maCongTo.equals("")) {
			throw new MyException("Mã công tơ không được để trống ");
		}
	}

	public static void checkYear(String year) throws MyException {
		if (year.equals("")) {
			throw new MyException("Năm không được để trống ");
		}
		String yearlpt = "\\d{4}";
		if (!year.matches(yearlpt)) {
			throw new MyException("Năm không hợp lệ");
		}
	}

	public static void checkChuky(String maCongTo, String month, String year, String chiSoCongTo)
			throws MyException, SQLException {
		ArrayList<BienLai> bl = DBBienLai.getList(maCongTo);
		int count = bl.size();
		int ncount = count - 1;
		if (count > 0) {

			int endyear = bl.get(ncount).getYear();
			int endmonth = bl.get(ncount).getMonth();
			int endchiso = bl.get(ncount).getChiSoCongTo();

			if (Integer.parseInt(year) < endyear) {
				throw new MyException("Bạn đã nhập cho năm " + year);
			} else if (Integer.parseInt(year) == endyear) {
				if (Integer.parseInt(month) < endmonth) {
					throw new MyException("Bạn phải nhập cho tháng " + (endmonth + 1) + ",năm " + endyear);
				}
				if (Integer.parseInt(month) == endmonth) {
					throw new MyException("Bạn đã nhập cho chu kỳ này");
				}
				if (Integer.parseInt(month) > endmonth + 1) {
					//int n = Integer.parseInt(month) - endmonth - 1;
					throw new MyException("Bạn phải nhập cho tháng " + (endmonth + 1) + ",năm " + endyear);
				}

			} else {
				if (Integer.parseInt(year) > endyear + 1) {
					//int n = Integer.parseInt(month) + 11 - endmonth + 12 * (Integer.parseInt(year) - endyear - 1);
					throw new MyException("Bạn phải nhập cho tháng " + (endmonth + 1) + ",năm " + endyear);
				} else {
					if (Integer.parseInt(month) != 1 || endmonth != 12) {
						//int n = Integer.parseInt(month) + 11 - endmonth;
						throw new MyException("Bạn phải nhập cho tháng 1 " + ",năm " + (endyear + 1));
					}
				}
			}

			if (endchiso > Integer.parseInt(chiSoCongTo)) {
				throw new MyException("Chỉ số công tơ chu kỳ mới nhỏ hơn chỉ số công tơ chu kỳ cũ");
			}

		}

	}

	public static void checkChiSo(String chiso) throws MyException {
		if (chiso.equals("")) {
			throw new MyException("Chi số không được để trống ");
		}
		String chisolpt = "\\d{1,10}";
		if (!chiso.matches(chisolpt)) {
			throw new MyException("Chỉ số chỉ được nhập số");
		}
	}

	public static void checkKhoangTime(String monthFr, String yearFr, String monthT, String yearT) throws MyException {
		
			int monthFrom = Integer.parseInt(monthFr);
			int yearFrom = Integer.parseInt(yearFr);
			int monthTo = Integer.parseInt(monthT);
			int yearTo = Integer.parseInt(yearT);
			if (yearFrom > yearTo) {
				throw new MyException("Khoảng thời gian chọn năm sau bé hơn năm trước");
			}
			if (yearFrom == yearTo) {
				if (monthFrom > monthTo) {
					throw new MyException("Khoảng thời gian chọn tháng sau bé hơn tháng trước");
				}
				if (monthFrom == monthTo) {
					throw new MyException("Bạn đã chọn trùng tháng");
				}
			}
		

	}

	public static void checkChiSo(String chiso, String month, String year, String maCongTo)
			throws MyException, ParseException, SQLException {
		int monthcp = Integer.parseInt(month);
		int yearcp = Integer.parseInt(year);
		int csct = Integer.parseInt(chiso);
		String monthFrom = "";
		String yearFrom = "";
		String monthTo = "";
		String yearTo = "";

		if (monthcp == 1) {

			monthFrom = "12";
			yearFrom = String.valueOf((yearcp - 1));
			monthTo = "2";
			yearTo = year;

		} else if (monthcp == 12) {
			monthFrom = "11";
			yearFrom = year;
			monthTo = "1";
			yearTo = String.valueOf((yearcp + 1));
		} else {
			monthFrom = String.valueOf((monthcp - 1));
			yearFrom = year;
			monthTo = String.valueOf((monthcp + 1));
			yearTo = year;

		}
		String dateFrom = yearFrom + "-" + monthFrom + "-01";
		String dateTo = yearTo + "-" + monthTo + "-01";

		java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
		java.util.Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dateFrom = df.format(date2);
		dateTo = df.format(date3);

		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// JOptionPane.showMessageDialog(null, e, "Thông báo lỗi",
		// JOptionPane.ERROR_MESSAGE);
		//
		//
		// }
		String sql = "select * from ffse1702026_bienlai where selecttime >='" + dateFrom + "' and selecttime <= '"
				+ dateTo + "'" + " and macongto='" + maCongTo + "'";

		ArrayList<BienLai> bl = DBBienLai.getDanhSach(sql);
		if (bl.size() == 2) {
			if (bl.get(0).getMonth() == monthcp) {
				if (csct > bl.get(1).getChiSoCongTo()) {
					throw new MyException("Số chỉ số công tơ nhập lớn hơn chu kỳ sau");
				}
			}
			if (bl.get(1).getMonth() == monthcp) {
				if (csct < bl.get(0).getChiSoCongTo()) {
					throw new MyException("Số chỉ số công tơ nhập nhỏ hơn chu kỳ trước");
				}
			}
		}
		if (bl.size() == 3) {

			if (csct > bl.get(2).getChiSoCongTo()) {
				throw new MyException("Số chỉ số công tơ nhập lớn hơn chu kỳ sau");
			}

			if (csct < bl.get(0).getChiSoCongTo()) {
				throw new MyException("Số chỉ số công tơ nhập nhỏ hơn chu kỳ trước");
			}

		}

	}
}
