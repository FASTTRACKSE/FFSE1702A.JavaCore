package assignment_java;
import java.util.Scanner ;
public class Sanpham {
	String tensp ;
	double dongia ;
	double giamgia;
	double tnk; 
public double getthuenhapkhau() {
	double tnk = 0 ;
	tnk = this.dongia*10/100;
	return tnk;
}
public void nhap() {
	Scanner nhap = new Scanner(System.in);
	System.out.println("nhap ten sp : ");
	String tensp = nhap.nextLine();
	this.tensp = tensp;
	
	System.out.println("nhap don gia  : ");
	double dongia = nhap.nextDouble();
	this.dongia = dongia;
	
	System.out.println("nhap giam gia  : ");
	double giamgia = nhap.nextDouble();
	this.giamgia = giamgia;
	
	System.out.println("nhap thue nhap khau  : ");
	double tnk = nhap.nextDouble();
	this.tnk = tnk;
	
	
	
	
	// nhập thông tin đơn giá 	
}
public void xuat() {
	System.out.println(this);
}
public static void main(String[] args ) {
	Sanpham sp1 = new Sanpham();
	Sanpham sp2 = new Sanpham();
	sp1.nhap();
	sp2.nhap();
}
}
