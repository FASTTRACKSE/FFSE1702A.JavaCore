package assignment_9;

import java.util.ArrayList;

public class MyException extends Exception {
	private static final long serialVersionUID = 3036003619876834868L;
	String error;

	public MyException() {

	}

	public MyException(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return this.error;
	}

	static void checkHoTen(String hoTen, ArrayList<CanBo> arrCanBo) throws MyException {
		if (hoTen.equals(""))
			throw new MyException(" * Họ tên không được rỗng! \n Nhập lại: ");
		if (hoTen.length() > 40)
			throw new MyException(" * Họ tên có độ dài không quá 40 ký tự! \n Nhập lại: ");
		for (CanBo cb : arrCanBo) {
			if (cb.getHoTen().equals(hoTen)) {
				throw new MyException(" * Họ tên đã tồn tại! \n Nhập lại: ");
			}
		}
	}

	static void checkDouble(String n) throws MyException {
		double str;
		try {
			str = Double.parseDouble(n);
		} catch (Exception e) {
			throw new MyException(" * Vui lòng nhập đúng định dạng! \n Nhập lại: ");
		}
		if (str <= 0)
			throw new MyException(" * Vui lòng nhập số dương! \n Nhập lại: ");
	}

	static void checkInt(String n) throws MyException {
		double str;
		try {
			str = Integer.parseInt(n);
		} catch (Exception e) {
			throw new MyException(" * Vui lòng nhập đúng định dạng! \n Nhập lại: ");
		}
		if (str <= 0)
			throw new MyException(" * Vui lòng nhập số dương! \n Nhập lại: ");
	}
}
