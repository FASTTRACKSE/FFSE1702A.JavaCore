package Oop;

public abstract class SinhVienFpt {
	String hoTen;
	String nganh;
	public SinhVienFpt(String hoTen, String nganh) {
		this.hoTen = hoTen;
		this.nganh = nganh;
	}
	
	

	abstract double getDiem();
	String getHocLuc() {
		String hocLuc = "";
		if(getDiem() < 5) hocLuc = "yeu";
		else if (getDiem()< 6.5) hocLuc = "tb";
		else hocLuc="xuat sac";
		return hocLuc;
	}
	void xuat() {
		System.out.println("ho ten: " + this.hoTen);
		System.out.println("nganh: " + this.nganh);
		System.out.println("diem: " + this.getDiem());
		System.out.println("hoc luc: " + this.getHocLuc());
	}
	
}
