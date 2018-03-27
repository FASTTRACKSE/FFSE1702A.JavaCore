package assignment;

import java.util.Scanner;

public class BienLai {
private int chisocu;
private int chisomoi;
private int sotienphaitra;
private KhachHang khachhang;
public int getChisocu() {
	return chisocu;
}
public void setChisocu(int chisocu) {
	this.chisocu = chisocu;
}
public int getChisomoi() {
	return chisomoi;
}
public void setChisomoi(int chisomoi) {
	this.chisomoi = chisomoi;
}
public int getSotienphaitra() {
	return sotienphaitra;
}
public void setSotienphaitra(int sotienphaitra) {
	this.sotienphaitra = sotienphaitra;
}
public KhachHang getKhachhang() {
	return khachhang;
}
public void setKhachhang(KhachHang khachhang) {
	this.khachhang = khachhang;
}
public BienLai() {}
public BienLai(int chisocu, int chisomoi, int sotienphaitra, KhachHang khachhang) {
	super();
	this.chisocu = chisocu;
	this.chisomoi = chisomoi;
	this.sotienphaitra = sotienphaitra;
	this.khachhang = khachhang;
}
 public void nhap() {
	 khachhang=new KhachHang();
	 khachhang.nhap();
	 Scanner scanner= new Scanner(System.in);
	 System.out.println("chi so cu :");
	 chisocu=scanner.nextInt();
	 System.out.println("chi so moi:");
	 chisomoi=scanner.nextInt();
	 sotienphaitra=(chisomoi-chisocu)*750;
 }
 public void xuat() {
	 khachhang=new KhachHang();
	 khachhang.xuat();
	 System.out.println("chi so cu:"+chisocu);
	 System.out.println("chi so moi:"+chisomoi);
	 System.out.println("sotienphaitra:"+sotienphaitra);
	 
 }
}
