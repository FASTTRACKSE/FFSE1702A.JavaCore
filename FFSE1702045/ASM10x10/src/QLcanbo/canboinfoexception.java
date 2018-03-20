package QLcanbo;

public class canboinfoexception extends Exception {
	String err;

	public canboinfoexception(String err) {
		super();
		this.err = err;
	}
	@Override
	public String toString() {
		return "Loi "+this.err;
	}
	static void chkHoten(String hoTen) throws canboinfoexception {
		if(hoTen==null) {
			throw new  canboinfoexception("Ten rong");
		}
		if(hoTen.length()>8) {
			throw new  canboinfoexception("Ten qua dai");
		}
	}
	
	static void chkValue(String khoa) throws canboinfoexception {
		if(khoa.length()>1) {
			throw new  canboinfoexception("Khoa chi nhap 1 ki tu");
		}
	}
	static void chkSo(int choose) throws canboinfoexception {
		if(choose<1 || choose>3) {
			throw new  canboinfoexception("Lua chon khong hop le chi duoc chon tu khoan 1-3");	
	
	}
	
	}
}