package ffse037;
import java.util.Scanner;
public class assignment8 {
    String tensp;
    double dongia;
    double giamgia;
    public double getthuenhapkhau() {
        double tnk = 0;
        tnk = this.dongia*10/100;
        return  tnk;
    }
    public void nhap() {
    	System.out.println("vui lòng nhập tên sản phẩm ");
        Scanner nhap = new Scanner(System.in);
        String tensp = nhap.nextLine();
        this.tensp = tensp;
        //nhap thong tin odon gia
        System.out.println("vui lòng nhập giá sản phẩm ");
        double dongia= nhap.nextDouble();;
        this.dongia = dongia;
        System.out.println("vui lòng nhập giá giam sản phẩm ");
        double giamgia= nhap.nextDouble();;
        this.giamgia = giamgia;
    }
    public void xuat() {
       // println("this.tensp");
    	
    	System.out.println("ten sản phẩm:"+this.tensp);
    	System.out.println(" giá sản phẩm:"+this.dongia);
    	System.out.println(" giá giảm sản phẩm:"+this.giamgia);
    	System.out.println(" giá sản phẩm sau cùng:"+(this.dongia+getthuenhapkhau()-this.dongia*this.giamgia/100));
    }
    public static void main(String args[]) {
    	assignment8 sp1 = new assignment8();
    	assignment8 sp2 = new assignment8();
        sp1.nhap();
        sp2.nhap();
        sp1.xuat();
        sp2.xuat();
    }
}