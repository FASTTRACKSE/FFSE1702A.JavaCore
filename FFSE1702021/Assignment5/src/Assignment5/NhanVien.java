package Assignment5;
import java.util.Scanner;
public class NhanVien extends CanBo {
    // Họ tên, phòng ban, số ngày công, hệ số lương, phụ
	//cấp, chức vụ (trưởng phòng, phó phòng, nhân viên). 
	private String phongBan;
	private int ngayCong;
	private String chucVu;
	
	public NhanVien() {
		
	}
	public NhanVien(String phongBan, int ngayCong, String chucVu) {
		super();
		this.phongBan = phongBan;
		this.ngayCong = ngayCong;
		this.chucVu = chucVu;
	}
	public NhanVien(String hoTen, int phuCap, float heSoLuong, float luong) {
		super(hoTen, phuCap, heSoLuong, luong);
		this.phongBan = phongBan;
		this.ngayCong = ngayCong;
		this.chucVu = chucVu;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public int getNgayCong() {
		return ngayCong;
	}
	public void setNgayCong(int ngayCong) {
		this.ngayCong = ngayCong;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public void nhapNV() {
		Scanner scn=new Scanner(System.in);
		System.out.println("nhap phong ban:");
		String phongBan = scn.next();
		setPhongBan(phongBan);
		
		System.out.println("nhap ngay cong:");
		int ngayCong = scn.nextInt();
		setNgayCong(ngayCong);
		
		System.out.println("nhap chuc vu:");
		String chucVu = scn.next();
		setChucVu(chucVu);
	}
	public void xuatNV() {
		
	}
	
}
