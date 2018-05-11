package danhsach;
import java.util.Scanner;
public class CanBo {
private String hoTen;
private int phuCap;
private Float heSoLuong;
private Float Luong;
public CanBo() {
	
}
public CanBo(String hoTen, int phuCap, Float heSoLuong, Float luong) {
	super();
	this.hoTen = hoTen;
	this.phuCap = phuCap;
	this.heSoLuong = heSoLuong;
	Luong = luong;
}
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
public Float getHeSoLuong() {
	return heSoLuong;
}
public void setHeSoLuong(Float heSoLuong) {
	this.heSoLuong = heSoLuong;
}
public Float getLuong() {
	return Luong;
}
public void setLuong(Float luong) {
	Luong = luong;
}
public void nhap() {
	   Scanner scn= new Scanner(System.in);
	   System.out.println("nhap ho ten:");
	   String hoTen= scn.next();
	   setHoTen(hoTen);
	   
	   System.out.println("nhap he so luong:");
	   float heSoLuong= scn.nextFloat();
	   setHeSoLuong(heSoLuong);

}
public double tinhLuong() {
	   return 0;
}
public void xuat() {
	   
    System.out.print("Ten:"+ hoTen);
    System.out.print("He So Luong:"+ heSoLuong);
}
}
