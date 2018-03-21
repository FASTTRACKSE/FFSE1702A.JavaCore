package quanly;
import java.util.Scanner;
public class CanBo {
private String hoTen;
 String MaCanBo;
private int phuCap;


public CanBo(String hoTen, String maCanBo, int phuCap, float heSoLuong, double luong) {
	super();
	this.hoTen = hoTen;
	MaCanBo = maCanBo;
	this.phuCap = phuCap;
	this.heSoLuong = heSoLuong;
	this.luong = luong;
}

public String getMaCanBo() {
	return MaCanBo;
}

public void setMaCanBo(String maCanBo) {
	MaCanBo = maCanBo;
}
private float heSoLuong;
private double luong;
public String getHoTen() {
	return hoTen;
}

public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}

public int getPhuCap() {
	return phuCap;
}

public void setPhuCap(int phuCap) {
	this.phuCap = phuCap;
}

public float getHeSoLuong() {
	return heSoLuong;
}

public void setHeSoLuong(float heSoLuong) {
	this.heSoLuong = heSoLuong;
}
public CanBo() {}
public CanBo(String hoTen, int phuCap, float heSoLuong, double luong) {
	super();
	this.hoTen = hoTen;
	this.phuCap = phuCap;
	this.heSoLuong = heSoLuong;
	this.luong = luong;
}

public double getLuong() {
	return luong;
}
public void setLuong(double luong) {
	this.luong = luong;
}
public void nhapCanBo() {
	Scanner cb = new Scanner(System.in);
	for(;;) {
	try {
	System.out.println("Nhập họ tên:");
	hoTen=cb.nextLine();
	CanBoException.chkHoten(hoTen);
	this.setHoTen(hoTen);
	break;
	}catch(Exception e) {
		System.out.print(e);
	}}
	System.out.println("Nhập hệ số lương:");
	heSoLuong=cb.nextFloat();
	this.setHeSoLuong(heSoLuong);
}
public void xuatCanBo() {
	System.out.println("Mã Cán Bộ:"+MaCanBo);
	System.out.println("Họ Tên:"+hoTen);
	System.out.println("Phụ cấp:"+phuCap);
	System.out.println("Hệ Số Lương:"+heSoLuong);
}
}
