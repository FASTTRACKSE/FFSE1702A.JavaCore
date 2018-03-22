package assignment4;
import java.util.ArrayList;
import java.util.Scanner;
public class KhachHang {
	private String hoten;
	private String sonha;
	private int msct;
	public KhachHang() {
        super();
    }
	public KhachHang(String hoten,String sonha,int msct) {
		this.hoten=hoten;
		this.sonha=sonha;
		this.msct=msct;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getSonha() {
		return sonha;
	}
	public void setSonha(String sonha) {
		this.sonha = sonha;
	}
	public int getMsct() {
		return msct;
	}
	public void setMsct(int msct) {
		this.msct = msct;
	}
	  public static void main(String[] args) {
	ArrayList<KhachHang> KH = new ArrayList<>();
	
	  }
	public void nhapKH() {
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("nhap ten:");
		 hoten=input.next();
		
		
		System.out.println("nhap so nha:");
		 sonha=input.next();
		
		
		System.out.println("nhap MSCT:");
	     msct=input.nextInt();
		
		
	}
	public void xuatKH() {
		
		System.out.println("Tên Chủ Hộ:" + hoten);
		System.out.println("Số Nhà:" + sonha);
		System.out.println("MSCT:" + msct);
	}
}
