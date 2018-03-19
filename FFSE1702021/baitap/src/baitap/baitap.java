package baitap;
import java.util.Scanner;
public class baitap {
	String tensp;
	double dongia;
	double giamgia;
	double tnk;
	
	
	public double getthuenhapkhau() {
		double tnk = 0;
		tnk = this.dongia*10/100;
		return tnk;
	}
	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		System.out.println("nhap ten san pham");
		String tensp = nhap.nextLine();
		this.tensp = tensp;
		//nhap thong tin ve don gia
		System.out.println("gia");
		double dongia = nhap.nextDouble();
		this.dongia=dongia;
		//giam gia
		System.out.println("giam gia");
		double giamgia = nhap.nextDouble();
		this.giamgia = giamgia;
		
	}
    public void xuat() {
		//su dunh println(this.tensp)
    	System.out.println("ten sp:" + this.tensp);
    	System.out.println("don gia:"+(this.dongia));
    	System.out.println("giam gia:"+this.giamgia+"%");
    	System.out.println("thue :"+ getthuenhapkhau());
    	System.out.println("gia:"+(this.dongia + getthuenhapkhau() - this.dongia*(this.giamgia/100) ));
    	
    	
	}
    public static void main(String arg[]) {
    	baitap sp1 = new baitap();
    	baitap sp2 = new baitap();
    	
    	sp1.nhap();
    	
    		
    	sp1.xuat();
    	
    	
    } 

}








