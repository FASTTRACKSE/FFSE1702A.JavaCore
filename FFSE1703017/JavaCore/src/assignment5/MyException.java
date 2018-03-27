package assignment5;

import java.util.ArrayList;
//import java.util.Scanner;

public class MyException extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;
	
	public MyException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg;
	}

	public static void chkHoTen(String hoTen, ArrayList<CanBo> arrCanBo) throws MyException{
		if (hoTen.length() == 0) throw new MyException("Họ tên không được để trống, hãy nhập lại: ");
		if (hoTen.length() > 40) throw new MyException("Họ tên có độ dài không quá 40 ký tự, hãy nhập lại: ");
		for(CanBo cb : arrCanBo) {
			if (cb.getHoTen().equals(hoTen)) {
				throw new MyException("Họ tên đã tồn tại, hãy nhập lại: ");
			}
		}
	}
	
	public static void chkDouble(String s) throws MyException {
//		if (s.length() == 0) throw new MyException("Vui lòng không để trống, hãy nhập lại: ");
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			throw new MyException("Vui lòng nhập đúng định dạng, hãy nhập lại: ");
		}
		if (Double.parseDouble(s) < 0) throw new MyException("Vui lòng nhập số dương, hãy nhập lại: ");
	}
	
	public static void chkInt(String s) throws MyException {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new MyException("Vui lòng nhập đúng định dạng, hãy nhập lại: ");
		}
		if (Integer.parseInt(s) < 0) throw new MyException("Vui lòng nhập số dương, hãy nhập lại: ");
	}
	
}
