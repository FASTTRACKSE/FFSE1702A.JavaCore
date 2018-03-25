package Lap5;
import java.util.Scanner;
public class Nguoi {
	private String hoTen;
	private String ngaySinh;
	private String cMND;
	public Nguoi() {
        super();
    }
	public Nguoi(String hoTen,String ngaySinh,String cMND) {
		this.hoTen=hoTen;
		this.ngaySinh=ngaySinh;
		this.cMND=cMND;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getcMND() {
		return cMND;
	}
	public void setcMND(String cMND) {
		this.cMND = cMND;
	}
	public void nhapNguoi() {
Scanner input=new Scanner(System.in);
		
		System.out.println("nhap ten:");
		 hoTen=input.next();
		
		
		System.out.println("nhap ngay sinh:");
		ngaySinh=input.next();
		
		
		System.out.println("nhap CMND:");
	     cMND=input.next();
		
		
	}
	public void xuatNguoi() {
		
		System.out.println("Tên Chủ Hộ:" + hoTen);
		System.out.println("Số Nhà:" + ngaySinh);
		System.out.println("MSCT:" + cMND);
	}
}
