package java_1;

import java.util.Scanner;

public class Sanpham {
    String tensp;
    double dongia;
    double giamgia;
    public double getthuenhapkhau() {
        double tnk;
        tnk = this.dongia * 10/100;
        return tnk;
    }
    public  void nhap() {
        Scanner myinput = new Scanner(System.in);
        String tensp;
        double dongia;
        double giamgia;
        System.out.println("Nhập tên san phẩm");
        tensp = myinput.nextLine();
        System.out.println("Nhập đơn giá");
        dongia = myinput.nextDouble();
        System.out.println("Nhập giảm giá");
        giamgia = myinput.nextDouble();
        this.tensp = tensp;
        this.dongia = dongia;
        this.giamgia = giamgia;
      }
    public void xuat() {
        System.out.println(" Tên Sản Phẩm" + this.tensp);
        System.out.println("Đơn giá" + this.dongia);
        System.out.println(" Giảm giá" + this.giamgia);
        System.out.println(" Giá Sản phâm :" + (this.dongia + getthuenhapkhau() - (this.dongia)*(this.giamgia)));
    }
    public static void main(String args[]) {
        Sanpham sp1 = new Sanpham();
        Sanpham sp2 = new Sanpham();
        sp1.nhap();
        sp2.nhap(); 
        sp1.xuat();
        sp2.xuat();
    }
}
