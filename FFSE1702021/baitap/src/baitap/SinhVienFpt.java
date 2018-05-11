package baitap;

 public abstract class SinhVienFpt {
	private String hoten;
	private String nganh;
	
	public SinhVienFpt(String hoten, String nganh) {
		this.hoten = hoten;
		this.nganh =nganh;
		
	}

	abstract double getDiem() ;
	String getHocLuc() {
		String hocluc = "";
		if(getDiem()<5) {
			hocluc = "yeu";
		}else if(getDiem() <6.5) {
			hocluc="trungbinh";
		}else if(getDiem()<7.5) {
			hocluc ="gioi";
		}else if(getDiem()> 9) {
			hocluc="xuat sac";
		}
		return hocluc;
	}
	void xuat() {
		System.out.println("Hoten:" + this.hoten);
		System.out.println("Nganh:" + this.nganh);
		System.out.println("Diem:" + this.getDiem());
		System.out.println("HocLuc:" + this.getHocLuc());
	}
	
	
	
	
	

}
