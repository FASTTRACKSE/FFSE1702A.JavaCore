package as5;

import java.util.ArrayList;

public class CanboException extends Exception {
	String err;
	
	public CanboException() {
		super();
	}

	public CanboException(String err) {
		super();
		this.err = err;
	}
	@Override
	public String toString() {
		return this.err;
	}	
	 public static void chkHoTen(String hoTen) throws CanboException {
		if(hoTen.equals("")) {
			throw new CanboException("Tên trống");
		}
		if(hoTen.length()>3) {
			throw new CanboException("Tên quá dài");
		}
	}
	public static void chkTrinhDo(String trinhDo) throws CanboException {
		if((!trinhDo.equals("cử nhân")) || (!trinhDo.equals("thạc sĩ")) || (!trinhDo.equals("tien si"))) {
			
		}else {
			throw new CanboException("nhập sai trình độ");
		}
	}
	public static void chkSoNguyen(int n) throws CanboException {
		if(n < 0) throw new CanboException("Tên quá dài");
	}
	public static void chkSoThuc(float n) throws CanboException {
		if(n < 0) throw new CanboException("Tên quá dài");
	}
	
	public static void chkMaCanBo(String maCanBo , ArrayList<Canbo> arr) throws CanboException {
		for(int i=0; i<arr.size();i++) {
			if(arr.get(i).getMaCanBo().equals(maCanBo)) {
				throw new CanboException(" Mã cán bộ đã tồn tại");
				
			}
		}
	}
}