package text;

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
	static public void chekHoten(String hoTen) throws CanBoException{
		if(hoTen.equals("")) {
			throw new CanBoException("Họ tên rỗng");
		}
		if(hoTen.length() > 50) 
			throw new CanBoException("Họ tên quá dài");
		
	}
}

