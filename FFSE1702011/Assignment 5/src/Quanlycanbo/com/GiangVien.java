package Quanlycanbo.com;
import java.util.*;
import java.io.Serializable;
public class GiangVien extends CanBo {
	String khoa;
	String trinhDo;
	float phuCap;
	int soTiet;
	
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
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhap khoa: ");
		String khoa = myInput.nextLine();
		this.setKhoa(khoa);
		
		for(;;) {
			System.out.println("Chon trinh do");
			System.out.println("1. Cu nhan");
			System.out.println("2. Thac si");
			System.out.println("3. Tien si");
			
			try {
				String btn = myInput.nextLine();
				CanBoException.chkTrinhDo(btn);
				if(btn.equals("1")) {
					String trinhDo = "Cu nhan";
					this.setTrinhDo(trinhDo);
					
					float phuCap = 300;
					this.setPhuCap(phuCap);
					System.out.println("Trinh do cu nhan co phu cap la 300");
				} else if(btn.equals("2")) {
					String trinhDo = "Thac si";
					this.setTrinhDo(trinhDo);
					
					float phuCap = 500;
					this.setPhuCap(phuCap);
					System.out.println("Trinh do thac si co phu cap la 500");
				} else if(btn.equals("3")) {
					String trinhDo = "Tien si";
					this.setTrinhDo(trinhDo);
					
					float phuCap = 1000;
					this.setPhuCap(phuCap);
					System.out.println("Trinh do tien si co phu cap la 1000");
				}
				break;
			} catch (CanBoException e) {
				System.out.print(e);

			}
		}
		
		System.out.print("So tiet day: ");
		int soTiet = Integer.parseInt(myInput.nextLine());
		this.setSoTiet(soTiet);
	}
	public double tinhLuong() {

		double luong = getHeSoLuong() * 750 + getPhuCap() + getSoTiet() * 45;
		return luong;
	}
	
	public void xuatGiangVien() {
<<<<<<< HEAD
		System.out.println("Ma giang vien: " + this.getMaCanBo() + " || Ten: " + this.getHoTen() + " || Khoa: " + this.getKhoa() + " || Trinh do: " + this.getTrinhDo() + " || Phu cap: " + this.getPhuCap() + " || So tiet day: " + this.getSoTiet() + " || He so luong: " + this.getHeSoLuong());
=======
		System.out.println("Ma can bo: " + this.getMaCanBo()+ " Ten: " + this.getHoTen() + " || Khoa: " + this.getKhoa() + " || Trinh do: " + this.getTrinhDo() + " || Phu cap: " + this.getPhuCap() + " || So tiet day: " + this.getSoTiet() + " || He so luong: " + this.getHeSoLuong());
>>>>>>> 45c6cc847d29ca7c683fcf8d24d00a1ee0c5e29f
	}
}
