package assignment_9;

<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing
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

<<<<<<< HEAD
	static void checkHoTen(String hoTen, ArrayList<CanBo> arrCanBo) throws MyException {
=======
	static void checkHoTen(String hoTen) throws MyException {
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing
		if (hoTen.equals(""))
			throw new MyException(" * Họ tên không được rỗng! \n Nhập lại: ");
		if (hoTen.length() > 40)
			throw new MyException(" * Họ tên có độ dài không quá 40 ký tự! \n Nhập lại: ");
<<<<<<< HEAD
		for (CanBo cb : arrCanBo) {
=======
		for (CanBo cb : Menu.arrCanBo) {
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing
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
