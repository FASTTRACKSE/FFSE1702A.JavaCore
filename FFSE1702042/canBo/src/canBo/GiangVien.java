package canBo;
import java.util.Scanner;
public class GiangVien extends CanBo {
	private String khoa;
	private String trinhDo;
	private int    soTiet;
	public GiangVien() {
		
	}
	public GiangVien(String maCanBo, String hoTen, int phuCap, float heSoLuong, double luong ) {
	super(maCanBo, hoTen, phuCap, heSoLuong, luong);
	}
	public GiangVien(String khoa, String trinhDo, int soTiet) {
		super();
		this.khoa	=	khoa;
		this.trinhDo=	trinhDo;
		this.soTiet	=	soTiet;
	}
	public String getKhoa() {
		return khoa;
	}
	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public int getSoTiet() {
		return soTiet;
	}
	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}
	public void nhap(){
		super.nhap();
		Scanner scn	=	new Scanner(System.in);
		System.out.println("Nhập khoa: ");
		khoa	=	scn.next();
		setKhoa(khoa);
		System.out.println("Nhập trình độ: ");
		trinhDo	=	scn.next();
		setTrinhDo(trinhDo);
		if(trinhDo.equals("cử nhân")) {
			this.setPhuCap(300);
		}else if(trinhDo.equals("thạc sĩ")) {
			this.setPhuCap(500);
		}else if(trinhDo.equals("tiến sĩ")) {
			this.setPhuCap(1000);
		}
		System.out.println("Nhập số tiết dạy: ");
		soTiet	=	scn.nextInt();
		setSoTiet(soTiet);
	}
	public double tinhLuong() {
		double luong	=	getHeSoLuong()*750 + getPhuCap() + getSoTiet()*45;
		return luong;
	}
	public void xuat() {
		super.xuat();
		System.out.println("Khoa: " + khoa);
		System.out.println("Trình độ: " + trinhDo);
		System.out.println("Số tiết dạy: " + soTiet);
		System.out.println("luong:" + this.tinhLuong());
	}
	
}
