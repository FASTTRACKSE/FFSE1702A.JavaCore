package assignment4;

import java.util.Scanner;

public class KH {
String ten;
String soNha;
String maCongTo;
public KH() {}
public KH(String ten, String soNha, String maCongTo) {
	super();
	this.ten = ten;
	this.soNha = soNha;
	this.maCongTo = maCongTo;
}

public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getSoNha() {
	return soNha;
}
public void setSoNha(String soNha) {
	this.soNha = soNha;
}
public String getMaCongTo() {
	return maCongTo;
}
public void setMaCongTo(String maCongTo) {
	this.maCongTo = maCongTo;
}
public void nhap() {
	Scanner sn = new Scanner(System.in);
	
	System.out.print("Nhap ten: ");
	String name= sn.nextLine();
	this.setTen(name);
	
	System.out.print("Nhap so nha: ");
	String soNha= sn.nextLine();
	this.setSoNha(soNha);
	
	System.out.print("Nhap ma cong to");
	String maCongto=sn.nextLine();
	this.setMaCongTo(maCongto);
	
}
public void xuat() {
	System.out.print(ten+"|"+soNha+"|"+maCongTo); 
	} 
}
	