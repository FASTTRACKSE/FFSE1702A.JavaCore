package assignment4;
import java.util.Scanner;
public class BienLai {
	private int chiSoCu;
	private int chiSoMoi;
	private double soTienPhaiTra;
	private KhachHang khachHang;
	 public BienLai() {
	        super();
	    }
	 public BienLai(int chiSoCu,int chiSoMoi,double soTienPhaiTra,KhachHang khachHang) {
		this.chiSoCu=chiSoCu;
		this.chiSoMoi=chiSoMoi;
		this.soTienPhaiTra=soTienPhaiTra;
		this.khachHang=khachHang;
	 }
	 public void nhapBienLai() {
		 khachHang = new KhachHang();
		 khachHang.nhapKH();
		 Scanner input=new Scanner(System.in);
		 
		 System.out.println("Nhap CSC:");
		 chiSoCu = input.nextInt();
		 
		 System.out.println("Nhap CSM:");
		 chiSoMoi = input.nextInt();
		 
		 soTienPhaiTra = (double) (chiSoMoi - chiSoCu) * 750;
	 }
	 public void xuatBienLai() {
		 
		 khachHang.xuatKH();
		 System.out.println(" CSC:" + chiSoCu);
		 System.out.println(" CSM:" + chiSoMoi);
		 System.out.println(" Tien Phai Tra:" + soTienPhaiTra);
		 
	 }
}
