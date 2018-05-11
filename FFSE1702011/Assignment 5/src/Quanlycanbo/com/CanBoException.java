package Quanlycanbo.com;

import java.util.ArrayList;
import java.util.*;

public class CanBoException extends Exception {
	String errHoten;

	
	public CanBoException(String errHoten) {
		super();
		this.errHoten = errHoten;
	}


	@Override
	public String toString() {
		return "CanBoException [errHoten=" + errHoten + "]";
	}
	
	//kiem tra loi ho ten
	static public void chkHoTen(String Hoten) throws CanBoException {
		if(Hoten.equals("")) {
			throw new CanBoException("Vui long khong de rong \n");
		} else if(Hoten.length() > 40) {
			throw new CanBoException("Khong nhap qua 40 ki tu");
		}
	}
	
	//kiem tra trinh do
	static public void chkTrinhDo(String Trinhdo) throws CanBoException {
		if(!Trinhdo.equals("1") && !Trinhdo.equals("2") && !Trinhdo.equals("3")) {
			throw new CanBoException("Vui long nhap dung yeu cau \n");
		}
	}
	
	//kiem tra so duong
	static public void chkSoDuong(float i) throws CanBoException {
		if(i < 0) {
			throw new CanBoException("Vui long nhap so duong \n");
		}
	}
	
	//kiem tra ma can bo
	static public void chkMaCB(String MaCB, ArrayList<CanBo> arr) throws CanBoException {
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getMaCanBo().equals(MaCB)) {
				throw new CanBoException("Ma can bo da ton tai");
			}
		}
	}
	
}
