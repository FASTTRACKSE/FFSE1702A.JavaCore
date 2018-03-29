package Canbo;

<<<<<<< HEAD
import java.util.Scanner;

public class MyException extends Exception {
public static Scanner myinput =  new Scanner(System.in);
    String error;

    public MyException() {

    }

    public MyException(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return this.error;
    }

    static void checkHoTen(String hoTen) throws MyException {
        if (hoTen.equals(""))
            throw new MyException(" * Họ tên không được rỗng! \n Nhập lại: ");
        if (hoTen.length() > 40)
            throw new MyException(" * Họ tên có độ dài không quá 40 ký tự! \n Nhập lại: ");
        for (CanBo cb : Menu.arrCanBo) {
            if (cb.getHoTen().equals(hoTen)) {
                throw new MyException(" * Họ tên đã tồn tại! \n Nhập lại: ");
            }
        }
    }

    static void checkDouble(String n) throws MyException {
        double str;
        try {
            str = Double.parseDouble(n);
        } catch (Exception e) {
            throw new MyException(" * Vui lòng nhập đúng định dạng! \n Nhập lại: ");
        }
        if (str <= 0)
            throw new MyException(" * Vui lòng nhập số dương! \n Nhập lại: ");
    }

    static void checkInt(String n) throws MyException {
        double str;
        try {
            str = Integer.parseInt(n);
        } catch (Exception e) {
            throw new MyException(" * Vui lòng nhập đúng định dạng! \n Nhập lại: ");
        }
        if (str <= 0)
            throw new MyException(" * Vui lòng nhập số dương! \n Nhập lại: ");
    }
=======
import java.util.ArrayList;

public class MyException extends Exception {
	private static final long serialVersionUID = 3036003619876834868L;
	String error;

	public MyException() {

	}

	public MyException(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return this.error;
	}

	static void checkHoTen(String hoTen) throws MyException {
		if (hoTen.equals(""))
			throw new MyException(" * Họ tên không được rỗng! \n Nhập lại: ");
		if (hoTen.length() > 40)
			throw new MyException(" * Họ tên có độ dài không quá 40 ký tự! \n Nhập lại: ");

	}

	static void checkDouble(String n) throws MyException {
		double str;
		try {
			str = Double.parseDouble(n);
		} catch (Exception e) {
			throw new MyException(" * Vui lòng nhập đúng định dạng! \n Nhập lại: ");
		}
		if (str <= 0)
			throw new MyException(" * Vui lòng nhập số dương! \n Nhập lại: ");
	}

	static void checkInt(String n) throws MyException {
		double str;
		try {
			str = Integer.parseInt(n);
		} catch (Exception e) {
			throw new MyException(" * Vui lòng nhập đúng định dạng! \n Nhập lại: ");
		}
		if (str <= 0)
			throw new MyException(" * Vui lòng nhập số dương! \n Nhập lại: ");
	}

	static void checkExist(String maCanBo, ArrayList<CanBo> arrCanBo) throws MyException {
		if(arrCanBo.size()>0) {
		for (int i=0;i<arrCanBo.size();i++) {
			
			if (arrCanBo.get(i).getMaCanBo().equals(maCanBo)) {
				throw new MyException(" * Mã cán bộ đã tồn tại, vui lòng nhập lại: ");
			}
			else {System.out.print("22");}
		}
		}
	}
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
}