package canBo;
import java.util.Scanner;
public class NhanVien extends CanBo {
	private String phongBan;
	private int	   ngayCong;
	private String chucVu;
	public NhanVien(){
		
	}
	public NhanVien(String maCanBo, String hoTen, int phuCap, float heSoLuong, double luong) {
		super(maCanBo, hoTen, phuCap, heSoLuong, luong);
	}
	public NhanVien(String phongBan, int ngayCong, String chucVu) {
		this.phongBan	=	phongBan;
		this.ngayCong	=	ngayCong;
		this.chucVu		=	chucVu;
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
	public void nhap() {
		super.nhap();
		Scanner scn	=	new Scanner(System.in);
		System.out.println("Nhập phòng ban: ");
		phongBan	=	scn.next();
		setPhongBan(phongBan);
		System.out.println("Nhập chức vụ:");
		chucVu		=	scn.next();
		setChucVu(chucVu);
		if(chucVu.equals("nhân viên")) {
			this.setPhuCap(500);
		}else if(chucVu.equals("phó phòng")) {
			this.setPhuCap(1000);
		}else if(chucVu.equals("trưởng phòng")){
			this.setPhuCap(2000);
	    }
		System.out.println("Số ngày công: ");
		ngayCong	=	scn.nextInt();
		setNgayCong(ngayCong);
	}	
	public double tinhLuong() {
		double luong	=	getHeSoLuong()*730 + getPhuCap() + getNgayCong()*30;
		return luong;
	}
	public void xuat() {
		super.xuat();
		super.xuat();
		System.out.println("Phong Ban:" + phongBan);
		System.out.println("Chuc Vu:" + chucVu);
		System.out.println("Ngay Cong:" + ngayCong);
		System.out.println("luong:" + this.tinhLuong());
	}
}
