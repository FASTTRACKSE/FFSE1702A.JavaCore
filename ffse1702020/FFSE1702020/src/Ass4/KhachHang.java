package Ass4;
import java.util.Scanner;
public class KhachHang {
 String hoTen;
 String maCT;
 int soNha;
 
 
 
 public KhachHang() {}
public KhachHang(String hoTen, String maCT, int soNha) {
	super();
	this.hoTen = hoTen;
	this.maCT = maCT;
	this.soNha = soNha;
}
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public String getMaCT() {
	return maCT;
}
public void setMaCT(String maCT) {
	this.maCT = maCT;
}
public int getSoNha() {
	return soNha;
}
public void setSoNha(int soNha) {
	this.soNha = soNha;
}
 public void xuat()
 {
		System.out.print("\n------------------------------------------------\n");
	    System.out.println( "- tên chủ hộ       : " + this.getHoTen()+ "\n- mã số công tơ    : " + this.getMaCT() + " \n- số nhà" + this.getSoNha()); 
 }
 public void nhapthongtin()
 {
	 Scanner nhap = new Scanner(System.in);
	 
	 System.out.println("Nhap ten chu ho: ");
	 String ten = nhap.nextLine();
	 this.setHoTen(ten);
	 
	 System.out.println("Nhap so nha: ");
	 int so = nhap.nextInt();
	 this.setSoNha(so);
	 
	 System.out.println("Nhap so cong to: ");
	 
 }
}
