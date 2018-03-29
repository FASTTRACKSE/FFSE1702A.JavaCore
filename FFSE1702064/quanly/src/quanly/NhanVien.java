package quanly;
import java.util.Scanner;
public class NhanVien extends CanBo {

	public NhanVien(String hoTen, int phuCap, float heSoLuong, double luong) {
		super(hoTen, phuCap, heSoLuong, luong);
		
	}
private String phongBan;
private int soNgayCong;
private String chucVu;
public String getPhongBan() {
	return phongBan;
}
public void setPhongBan(String phongBan) {
	this.phongBan = phongBan;
}
public int getSoNgayCong() {
	return soNgayCong;
}
public void setSoNgayCong(int soNgayCong) {
	this.soNgayCong = soNgayCong;
}
public String getChucVu() {
	return chucVu;
}
public void setChucVu(String chucVu) {
	this.chucVu = chucVu;
}
public NhanVien() {}
public NhanVien(String hoTen, int phuCap, float heSoLuong, double luong, String phongBan, int soNgayCong,
		String chucVu) {
	super(hoTen, phuCap, heSoLuong, luong);
	this.phongBan = phongBan;
	this.soNgayCong = soNgayCong;
	this.chucVu = chucVu;
}
public void nhapNhanVien() {
	Scanner nv=new Scanner(System.in);
	
	System.out.println("Nhập phòng ban");
	phongBan=nv.nextLine();
	this.setPhongBan(phongBan);
	System.out.println("Nhập số ngày công");
	soNgayCong=nv.nextInt();
	this.setSoNgayCong(soNgayCong);
	for(;;) {
	System.out.println("Nhập chức vụ");
	System.out.println("1.Nhân viên\n2.Phó phòng\n3.Trưởng phòng");
	try {
		int key1 =9;
		String key = nv.nextLine();
		CanBoException.chkso1(key);
		key1 = Integer.parseInt(key);
	if(key1==1) {
		int nhanVien=500;
		this.setChucVu("Nhân viên");
		this.setPhuCap(nhanVien);
		break;
	}
	if(key1==2) {
		int phoPhong=1000;
		this.setChucVu("Phó Phòng");
		this.setPhuCap(phoPhong);
		break;
	}
	if(key1==3) {
		int truongPhong=2000;
		this.setChucVu("Trưởng Phòng");
		this.setPhuCap(truongPhong);
	}
	}catch(CanBoException e) 
	{
		System.out.print(e);
	}
	}
	double luong = getHeSoLuong()*730+getPhuCap()+getSoNgayCong()*45;
	this.setLuong(luong);
}
public void xuatNhanVien() {
	System.out.println("Họ Tên:"+this.getHoTen());
	System.out.println("Phụ cấp:"+this.getPhuCap());
	System.out.println("Hệ Số Lương:"+this.getHeSoLuong());
	System.out.println("Phòng ban:"+phongBan);
	System.out.println("Số ngày công:"+soNgayCong);
	System.out.println("Chức vụ:"+chucVu);
	System.out.println("Lương:"+this.getLuong());
}
}
