package text;

import java.util.ArrayList;

public class CanBoException extends Exception {
	String errHoTen;

	public CanBoException() {

	}

	public CanBoException(String errHoTen) {
		this.errHoTen = errHoTen;

	}

	@Override
	public String toString() {
		return this.errHoTen;

	}

	static public void chekHoten(String hoTen) throws CanBoException {
		if (hoTen.equals("")) {
			throw new CanBoException("Họ tên rỗng.");
		}
		if (hoTen.length() > 40)
			throw new CanBoException("Họ tên không được quá 40 kí tự.");

	}

	static public void chekMCB(String maCanBo, ArrayList<CanBo> arr) throws CanBoException {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getMaCanBo().equals(maCanBo)) {
				throw new CanBoException("Mã cán bộ đã tồn tại.");
			}

		}
		if (maCanBo.equals("")) {
			throw new CanBoException("Mã cán bộ rỗng.");
		}

	}

}
