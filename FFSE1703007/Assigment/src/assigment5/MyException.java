package assigment5;

public class MyException extends Exception {
	String erro;

	public MyException() {

	}

	public MyException(String errHoTen) {
		this.erro = errHoTen;
	}

	@Override
	public String toString() {
		return this.erro;
	}

	static void chkHoTen(String hoTen) throws MyException {
		if (hoTen.equals("")) {
			throw new MyException("Họ tên không được để trống");
		}
		if (hoTen.length() > 40 ) {
			throw new MyException("Họ tên không được có độ dài quá 40 kí tự");
		}
	}
	
	static void chkTrinhDo(String trinhDo) throws MyException{
		if (!trinhDo.equals("cử nhân")||trinhDo.equals("thạc sĩ")||trinhDo.equals("tiến sĩ")) {
			throw new MyException("Nhập cử nhân hoặc thạc sĩ hoặc tiến sĩ");
		}
	}
}
