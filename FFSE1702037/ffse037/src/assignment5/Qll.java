package assignment5;

import java.util.ArrayList;

public class Qll extends Exception {
	String errHoTen;

	public Qll(String errHoTen) {

		this.errHoTen = errHoTen;

	}
	public String toString() {
		return this.errHoTen;
	}

	static public void chkHoTen(String hoTen) throws Qll {
		if (hoTen.equals("")) {
			throw new Qll("Ten rong");
		}
		if (hoTen.length() > 40) {
			throw new Qll("Ten qua dai");
		}
	}

	static public void chkTrinhDo(String trinhdo) throws Qll {
		if (!trinhdo.equals("cử nhân") && !trinhdo.equals("thạc sĩ") && !trinhdo.equals("tiến sĩ")) {
			throw new Qll("nhập sai trình độ");
		}
	}

	static public void chkChucVu(String chucvu) throws Qll {
		if (!chucvu.equals("trưởng phòng") && !chucvu.equals("phó phòng") && !chucvu.equals("nhân viên")) {
			throw new Qll("nhập sai chức vụ");
		}
	}

	static public void chkMaCanBo(String maCanBo, ArrayList<CanBo> arr) throws Qll {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getMaCanBo().equals(maCanBo)) {
				throw new Qll("ma  can bo da ton tai");
			}
		}
	}

	static public void chkHeSoLuong(float hesoluong) throws Qll {
		if (hesoluong < 0) {
			throw new Qll("moi ban nhap lai!");
		}
	}

	static public void chkSoThuc(int songaycong) throws Qll {
		if (songaycong < 0) {
			throw new Qll("moi ban nhap lai so ngay cong!");
		}
	}
}