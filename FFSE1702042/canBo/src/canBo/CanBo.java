package canBo;
import java.util.Scanner;
public class CanBo {
	private String maCanBo;
	private String hoTen;
	private int	   phuCap;
	private float  heSoLuong;
	private double luong;
	public CanBo() {
		
	}
	public CanBo(String maCanBo, String hoTen, int phuCap, float heSoLuong, double luong) {
		super();
		this.maCanBo	=	maCanBo;
		this.hoTen		=	hoTen;
		this.phuCap		=   phuCap;
		this.heSoLuong	= 	heSoLuong;
		this.luong		=	luong;		
	}
	public String getMaCanBo() {
		return maCanBo;
	}
	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
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
	public float getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public void nhap() {
		Scanner scn	=	new Scanner(System.in);
		for(;;) {
			System.out.println("Nhập học tên: ");
			String hoTen	=	scn.next();
//			try {
//				
//			}
		}
	}
	public double tinhLuong() {
		return 0;
	}
	public void xuat() {
		System.out.println("Họ và tên: " + hoTen);
		System.out.println("Hệ số lương: " + heSoLuong);
	}
}
