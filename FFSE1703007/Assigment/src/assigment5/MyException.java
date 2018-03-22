package assigment5;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyException extends Exception {
	String erro;

	public MyException() {

	}

	public MyException(String errHoTen) {
		this.erro = errHoTen;
	}

	@Override
	public String toString() {
		return this.erro;
	}

	static void chkHoTen(String hoTen, ArrayList<CanBo> list) throws MyException {
		if (hoTen.equals("")) {
			throw new MyException("Họ tên không được để trống, vui lòng nhập lại");
		}
		if (hoTen.length() > 40 ) {
			throw new MyException("Họ tên không được có độ dài quá 40 kí tự, vui lòng nhập lại");
		}
		for(CanBo cb : list) {
			if (hoTen.equals(cb.getHoTen())) {
				throw new MyException("Họ tên đã tồn tại, vui lòng nhập lại");
			}
		}
	}
	
	static void chkTrinhDo(String trinhDo) throws MyException{
		if (!(trinhDo.equals("cử nhân")||trinhDo.equals("thạc sĩ")||trinhDo.equals("tiến sĩ"))) {
			throw new MyException("Nhập cử nhân hoặc thạc sĩ hoặc tiến sĩ, vui lòng nhập lại");
		}
	}
	
	static void chkInt(String str) throws MyException{
		int n;
		try {
			n = Integer.parseInt(str);
		}
		catch (Exception e) {
			throw new MyException("Vui lòng nhập đúng định dạng!");
		}
		if (n < 0) {
			throw new MyException("Chỉ được nhập số dương, vui lòng nhập lại");
		}
	}
	
	static void chkhesoluong(String str) throws MyException{
		int hesoluong;
		try {
			hesoluong = Integer.parseInt(str);
		}
		catch (Exception e) {
			throw new MyException("Vui lòng nhập đúng định dạng!");
		}
		if (hesoluong < 0) {
			throw new MyException("Chỉ được nhập số thực, vui lòng nhập lại");
		}
	}
	
	static void chkChucVu(String chucVu) throws MyException{
		if (!(chucVu.equals("trưởng phòng")||chucVu.equals("phó phòng")||chucVu.equals("nhân viên"))) {
			throw new MyException("Chỉ được nhập trưởng phòng, phó phòng, nhân viên, vui lòng nhập lại");
		}
	}
}
