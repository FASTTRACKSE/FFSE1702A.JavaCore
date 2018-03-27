package assignment5;

public class CanBoException extends Exception {
	String errHoTen;

	public CanBoException() {
		// TODO Auto-generated constructor stub
	}

	public CanBoException(String errHoTen) {
		super();
		this.errHoTen = errHoTen;
	}

	public String toString() {
		return this.errHoTen;
	}

	static public void chkHoten(String hoTen) throws CanBoException {
		if (hoTen.equals("")) {
			throw new CanBoException("Ho ten rong");
		}
		if (hoTen.length() > 50) {
			throw new CanBoException("Ho ten dai qua so luong cho phep");
		}
	}

}
