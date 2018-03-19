package Assignment5;

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
		if(hoTen.length()>3) {
			throw new CanBoException("Ten qua dai");
		}
	}
	public static void chkTrinhDo(String trinhDo) throws CanBoException {
		if((!trinhDo.equals("cu nhan")) && (!trinhDo.equals("thac si")) && (!trinhDo.equals("tien si"))) {
		
			throw new CanBoException("nhap sai trinh do");
		}
	}
	public static void chkSoNguyen(int tiecDay) throws CanBoException {
		if(tiecDay < 0) throw new CanBoException("khong duoc nhap so am");
	}
	public static void chkSoThuc(float heSoLuong) throws CanBoException {
		if(heSoLuong < 0) throw new CanBoException("khong duoc nhap so am");
	}
	
	public static void chkMaCanBo(String maCanBo , ArrayList<CanBo> arrCanBo) throws CanBoException {
		for(int i=0; i<arrCanBo.size();i++) {
			if(arrCanBo.get(i).getMaCanBo().equals(maCanBo)) {
				throw new CanBoException(" Ma can bo da ton tai vui long nhap lai \n");
				
			}
		}
	}
	public static void chkChucVu(String trinhDo) throws CanBoException {
		if((!trinhDo.equals("truong phong")) && (!trinhDo.equals("pho phong")) && (!trinhDo.equals("nhan vien"))) {
		
			throw new CanBoException("nhap sai chuc vu");
		}
	}
}
