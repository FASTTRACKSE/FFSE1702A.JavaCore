package canBo;

import java.util.ArrayList;

import canBo.CanBo;
import canBo.CanBoException;

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
		if (hoTen.equals("")) {
			throw new CanBoException("Tên rỗng");
		}
		if (hoTen.length() > 20) {
			throw new CanBoException("Tên quá dài");
		}
	}

	public static void chkTrinhDo(String trinhDo) throws CanBoException {
		if ((!trinhDo.equals("cu nhan")) && (!trinhDo.equals("thac si")) && (!trinhDo.equals("tien si"))) {

			throw new CanBoException("nhập sai trình độ");
		}
	}

	public static void chkSoNguyen(int tiecDay) throws CanBoException {
		if (tiecDay < 0)
			throw new CanBoException("số âm không hợp lệ");
	}

	public static void chkSoThuc(float heSoLuong) throws CanBoException {
		if (heSoLuong < 0)
			throw new CanBoException("sô âm không hợ lệ");
	}

	public static void chkMaCanBo(String maCanBo, ArrayList<CanBo> arrCanBo) throws CanBoException {
		for (int i = 0; i < arrCanBo.size(); i++) {
			if (arrCanBo.get(i).getMaCanBo().equals(maCanBo)) {
				throw new CanBoException(" Mã cán bộ đã tồn tại \n");

			}
		}
	}

	public static void chkChucVu(String trinhDo) throws CanBoException {
		if ((!trinhDo.equals("truong phong")) && (!trinhDo.equals("pho phong")) && (!trinhDo.equals("nhan vien"))) {

			throw new CanBoException("nhap sai chuc vu");
		}
	}
}
