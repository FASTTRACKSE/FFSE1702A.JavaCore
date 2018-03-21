package Quanlycanbo;
import java.util.ArrayList;

public class CanBoException extends Exception {
	String err;
	
	public CanBoException() {
		super();
	}

	public CanBoException(String err) {
		super();
		this.err = err;
	}
	@Override
	public String toString() {
		return this.err;
	}	
	 public static void chkHoTen(String hoTen) throws CanBoException {
		if(hoTen.equals("")) {
			throw new CanBoException("Ten rong");
		}
		if(hoTen.length()>10) {
			throw new CanBoException("Ten qua dai");
		}
	}
	public static void chkTrinhDo(String trinhDo) throws CanBoException {
		if((!trinhDo.equals("cu nhan")) || (!trinhDo.equals("thac si")) || (!trinhDo.equals("tien si"))) {
			
		}else {
			throw new CanBoException("nhap sai trinh do");
		}
	}
	public static void chkSoNguyen(int n) throws CanBoException {
		if(n < 0) throw new CanBoException("So am khong hop le");
	}
	public static void chkSoThuc(float n) throws CanBoException {
		if(n < 0) throw new CanBoException("So am khong hop le");
	}
	
	public static void chkMaCanBo(String maCanBo , ArrayList<CanBo> arr) throws CanBoException {
		for(int i=0; i<arr.size();i++) {
			if(arr.get(i).getMaCanBo().equals(maCanBo)) {
				throw new CanBoException(" Ma can bo da ton tai");
				
			}
		}
	}
}