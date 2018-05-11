import java.util.Scanner;
public class Sanpham {
 String tensp;
 double dongia;
 double giamgia;
 
  public void nhap() {
	  Scanner nhap = new Scanner(System.in);
	  System.out.println("nhap ten sp:");
	  String tensp = nhap.nextLine();
	  this.tensp = tensp;
	  
	  System.out.println("nhap don gia:");
	  double dongia = nhap.nextDouble();
	  this.dongia = dongia;
  }
  public void xuat() {
	  System.out.println( "ten sp la :" + this.tensp);
	  System.out.println( "don gia sp :" + this.dongia);
			  }
  public static void main(String[] args) {
	  Sanpham sp1 = new Sanpham();
	  Sanpham sp2 = new Sanpham();
	  sp1.nhap();
	  sp1.xuat();
	  sp2.nhap();
	  sp2.xuat();
  }
}
