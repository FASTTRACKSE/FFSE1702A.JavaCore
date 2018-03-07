package Quanlycanbo.com;
import java.util.*;
public class GiangVien extends CanBo {
	String khoa;
	String trinhDo;
	float phuCap;
	int soTiet;
	Scanner myInput = new Scanner(System.in);
	
	public GiangVien() {
		super();
	}
	
	public GiangVien(String hoTen, String khoa, String trinhDo, float phuCap, int soTiet, float heSoLuong) {
		super(hoTen, heSoLuong);
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.phuCap = phuCap;
		this.soTiet = soTiet;
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
	
	public float getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(float phuCap) {
		this.phuCap = phuCap;
	}
	
	public int getSoTiet() {
		return soTiet;
	}
	
	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}
	
	public void nhapGiangVien() {
		System.out.print("Nhap khoa: ");
		String khoa = myInput.nextLine();
		this.setKhoa(khoa);
		
		System.out.println("Chon trinh do");
		System.out.println("1. Cu nhan");
		System.out.println("2. Thac si");
		System.out.println("3. Tien si");
		int btn = Integer.parseInt(myInput.nextLine());
			if(btn == 1) {
				String trinhDo = "Cu nhan";
				this.setTrinhDo(trinhDo);
				
				float phuCap = 300;
				this.setPhuCap(phuCap);
				System.out.println("Trinh do cu nhan co phu cap la 300");
			} else if(btn == 2) {
				String trinhDo = "Thac si";
				this.setTrinhDo(trinhDo);
				
				float phuCap = 500;
				this.setPhuCap(phuCap);
				System.out.println("Trinh do thac si co phu cap la 500");
			} else if(btn == 3) {
				String trinhDo = "Tien si";
				this.setTrinhDo(trinhDo);
				
				float phuCap = 1000;
				this.setPhuCap(phuCap);
				System.out.println("Trinh do tien si co phu cap la 1000");
			}
		
		System.out.print("So tiet day: ");
		int soTiet = Integer.parseInt(myInput.nextLine());
		this.setSoTiet(soTiet);
	}
	
	public void xuatGiangVien() {
		System.out.println("Ten: " + this.getHoTen() + " || Khoa: " + this.getKhoa() + " || Trinh do: " + this.getTrinhDo() + " || Phu cap: " + this.getPhuCap() + " || So tiet day: " + this.getSoTiet() + " || He so luong: " + this.getHeSoLuong());
	}
}
