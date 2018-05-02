package LP4;

import LP4.connect;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class QLSVException extends Exception {
	String err;

	public QLSVException(String err) {
		super();
		this.err = err;
	}

	@Override
	public String toString() {
		return "*" + this.err + "*";
	}

	static void chkHoten(String username, String password) throws QLSVException {
		if (username.length() == 0 || password.length() == 0) {
			throw new QLSVException("Tên đăng nhập và mật khẩu không được để trống");
		}

		return;
	}
	static void chkHocKi(String hocki) throws QLSVException {
		if (hocki.length() == 0) {
			throw new QLSVException("Bạn chưa chọn học kì");
		}

		return;
	}

	public static boolean checkAdd(String mssv11,String email1,String sdt2,String sdt, String cls, String tinh, String quan, String phuong, String mssv,
			String adress, String name, String mail, String pass) throws QLSVException {
		Pattern checkmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher mail1 = checkmail.matcher(mail);
		Pattern checksdt = Pattern.compile("^[0-9]*");
		Matcher sdt1 = checksdt.matcher(sdt);
		if (!sdt1.find()) {
			throw new QLSVException("Số điện thoại chỉ bao gồm số");
		}
		if (sdt == null) {
			return false;
		}
		if (cls == null) {
			return false;
		}
		if (tinh == null) {
			return false;
		}
		if (quan == null) {
			return false;
		}
		if (phuong == null) {
			return false;
		}
		if (mssv == null) {
			return false;
		}
		if (listSV.textMSSV.getText() == null) {
			return false;
		}
		if (adress == null) {
			return false;
		}
		if (name == null) {
			return false;
		}
		if (mail1 == null) {
			return false;
		}
		if (pass == null) {
			return false;
		}

		if (tinh == "Chọn tỉnh") {
			throw new QLSVException("Vui lòng chọn tỉnh/thành phố");
		}

		if (quan == "Chọn huyện") {
			throw new QLSVException("Vui lòng chọn quận/huyện");
		}
		if (phuong == "Chọn xã") {
			throw new QLSVException("Vui lòng chọn xã/phường");
		}
		if (cls == "Chọn lớp") {
			throw new QLSVException("Vui lòng chọn lớp");
		}
		if (listSV.textMSSV.getText().length() == 0) {
			throw new QLSVException("Vui lòng nhập -mã số sinh viên");
		}
		if (adress.length() == 0) {
			throw new QLSVException("Vui lòng nhập - địa chỉ");
		}
		if (name.length() == 0) {
			throw new QLSVException("Vui lòng nhập - tên sinh viên");
		}
		if (sdt.length() == 0) {
			throw new QLSVException("Vui lòng nhập - số điện thoại");
		}
		if (mail.length() == 0) {
			throw new QLSVException("Vui lòng nhập - email");
		}
		if (pass.length() == 0) {
			throw new QLSVException("Vui lòng nhập -mã mật khẩu");
		}
		if (sdt.length() > 0 && (sdt.length() < 10 || sdt.length() > 11)) {
			throw new QLSVException("Số điện thoại chỉ từ 10-11 số");
		}
		if (!mail1.find()) {
			throw new QLSVException("vui lòng nhập đúng định dạng Email:example@mail.com");
		}
		if (mssv.equals(mssv11)) {
			throw new QLSVException("Mã số sinh viên này đã tồn tại");
		}
		if (mail.equals(email1)) {
			throw new QLSVException("Email này đã được đăng kí");
		}
		if (sdt.equals(sdt2)) {
			throw new QLSVException("Số điện thoại này đã được đăng kí");
		}
		return false;
	}


	public static boolean checkEdit(String mssv11,String email1,String sdt, String cls, String tinh, String quan, String phuong, String mssv,
			String adress, String name, String mail, String pass, String pass2) throws QLSVException {
		for(;;) {
		Pattern checkmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher mail1 = checkmail.matcher(mail);
		Pattern checksdt = Pattern.compile("^[0-9]*");
		Matcher sdt1 = checksdt.matcher(sdt);
		if (!sdt1.find()) {
			throw new QLSVException("Số điện thoại chỉ bao gồm số");
		}

		if (sdt == null) {
			return false;
		}
		if (cls == null) {
			return false;
		}
		if (tinh == null) {
			return false;
		}
		if (quan == null) {
			return false;
		}
		if (phuong == null) {
			return false;
		}
		if (adress == null) {
			return false;
		}
		if (name == null) {
			return false;
		}
		if (mail1 == null) {
			return false;
		}
		if (pass == null) {
			return false;
		}

		if (tinh == "Chọn tỉnh") {
			throw new QLSVException("Vui lòng chọn tỉnh/thành phố");
		}

		if (quan == "Chọn huyện") {
			throw new QLSVException("Vui lòng chọn quận/huyện");
		}
		if (phuong == "Chọn xã") {
			throw new QLSVException("Vui lòng chọn xã/phường");
		}
		if (cls == "Chọn lớp") {
			throw new QLSVException("Vui lòng chọn lớp");
		}
		if (adress.length() == 0) {
			throw new QLSVException("Vui lòng nhập - địa chỉ");
		}
		if (name.length() == 0) {
			throw new QLSVException("Vui lòng nhập - tên sinh viên");
		}
		if (sdt.length() == 0) {
			throw new QLSVException("Vui lòng nhập - số điện thoại");
		}
		if (mail.length() == 0) {
			throw new QLSVException("Vui lòng nhập - email");
		}
		if (sdt.length() > 0 && (sdt.length() < 10 || sdt.length() > 11)) {
			throw new QLSVException("Số điện thoại chỉ từ 10-11 số");
		}
		if (!mail1.find()) {
			throw new QLSVException("vui lòng nhập đúng định dạng Email:example@mail.com");
		}
		if (mail.equals(listSV.getmail)) {
		}
		else if(mail.equals(listSV.email1)) {
			throw new QLSVException("E-mail này đã được đăng kí");
		}
		if (sdt.equals(listSV.getsdt)) {
		}
		else if(sdt.equals(listSV.sdt2)) {
			throw new QLSVException("Số điện thoại này đã được đăng kí");
		}
		return false;
	}
	}
}
