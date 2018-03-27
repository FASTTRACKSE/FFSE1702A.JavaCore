package java_asm;

import java.util.ArrayList;

public class CanBoException extends Exception {
	String errHoTen;
	String err;

	public CanBoException() {
		super();
	}

	public CanBoException(String errHoTen) {
		this.errHoTen = errHoTen;

	}

	@Override
	public String toString() {
		return this.errHoTen;

	}

	static public void chkHoTen(String hoTen) throws CanBoException {
		if (hoTen.equals("")) {
			throw new CanBoException("Họ tên rỗng ");

		}
		if (hoTen.length() > 10) {
			throw new CanBoException("Họ tên dài quá số kí tự quy định ");
		}
	}

	static public void chkSoNguyen(int n) throws CanBoException {
		if (n < 0)
			throw new CanBoException("Số âm ");
	}

	static public void chkMaCanBo(String maCanBo, ArrayList<CanBo> arrCanBo) throws CanBoException {
		for (int i = 0; i < arrCanBo.size(); i++) {
			if (arrCanBo.get(i).getMaCanBo().equals(maCanBo)) {
				throw new CanBoException("Ma can bo da ton tai");
			}
		}
	}

}