package Giaodien.ui;

public class SinhVien {
	private long mssv;
	private String hoten;
	private int tuoi;
	public long getMssv() {
		return mssv;
	}
	public void setMssv(long mssv) {
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public SinhVien(long mssv, String hoten, int tuoi) {
		super();
		this.mssv = mssv;
		this.hoten = hoten;
		this.tuoi = tuoi;
	}
	public SinhVien(long mssv) {
		super();
		this.mssv = mssv;
	}
	public SinhVien() {
		super();
		
	}
	@Override
	public String toString() {
		return "SinhVien [mssv=" + mssv + ", hoten=" + hoten + ", tuoi=" + tuoi + "]";
	}
}
