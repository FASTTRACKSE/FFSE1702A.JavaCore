package quanly;
import java.util.Scanner;
public class GiangVien extends CanBo {

	public GiangVien(String hoTen, int phuCap, float heSoLuong, double luong) {
		super(hoTen, phuCap, heSoLuong, luong);
	}
 private String khoa;
 private String trinhDo;
 private int soTietDay;
public String getKhoa() {
	return khoa;
}
public void setKhoa(String khoa) {
	this.khoa = khoa;
}
public String getTrinhDo() {
	return trinhDo;
}
public void setTrinhDo(String trinhDo) {
	this.trinhDo = trinhDo;
}
public int getSoTietDay() {
	return soTietDay;
}
public void setSoTietDay(int sotietDay) {
	this.soTietDay = sotietDay;
}
public GiangVien() {}
public GiangVien(String hoTen, int phuCap, float heSoLuong, double luong, String khoa, String trinhDo,
		int sotietDay) {
	super(hoTen, phuCap, heSoLuong, luong);
	this.khoa = khoa;
	this.trinhDo = trinhDo;
	this.soTietDay = sotietDay;
}
public void nhapGiangVien() {
	Scanner scn = new Scanner(System.in);
	
	System.out.println("nhập khoa");
	khoa= scn.nextLine();
	this.setKhoa(khoa);
	for(;;) {
	System.out.println("nhập trình độ");
	System.out.println("1.Cử nhân\n2.Thạc sĩ\n3.Tiến sĩ");
	
	try {
		String key=scn.nextLine();
		CanBoException.chkso1(key);
		int key1=Integer.parseInt(key);
	if(key1==1) {
		int cuNhan=300;
		this.setTrinhDo("Cử nhân");
		this.setPhuCap(cuNhan);
		break;
	}
	if(key1==2) {
		int thacSi=500;
		this.setTrinhDo("Thạc Sĩ");
		this.setPhuCap(thacSi);
		break;
	}
	if(key1==3) {
		int tienSi=1000;
		this.setTrinhDo("Tiến Sĩ");
		this.setPhuCap(tienSi);
		break;
	
	}}catch(Exception e) {
		System.out.print(e);
	}}
	System.out.println("nhập số tiết dạy");
	soTietDay=scn.nextInt();
	this.setSoTietDay(soTietDay);
	
	double luong = getHeSoLuong()*730+getPhuCap()+getSoTietDay()*45;
	this.setLuong(luong);
	
}
public void XuatGiangVien() {
	System.out.println("Họ Tên:"+this.getHoTen());
	System.out.println("Phụ cấp:"+this.getPhuCap());
	System.out.println("Hệ Số Lương:"+this.getHeSoLuong());
	System.out.println(" khoa:"+khoa);
	System.out.println("Trình độ:"+this.getTrinhDo());
	System.out.println("số tiết dạy:"+soTietDay);
	System.out.println("lương:"+this.getLuong());
}
}
