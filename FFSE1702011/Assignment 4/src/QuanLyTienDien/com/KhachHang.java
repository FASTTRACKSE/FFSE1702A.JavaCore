package QuanLyTienDien.com;
import java.util.*;
public class KhachHang {
	String hoTen;
	String soNha;
	int congTo;
	Scanner myInput = new Scanner(System.in);
	
	public KhachHang() {
		
	}
	
	public KhachHang(String hoTen, String soNha, int congTo) {
		super();
		this.hoTen = hoTen;
		this.soNha = soNha;
		this.congTo = congTo;
	}

	public String getName() {
		return hoTen;
	}
	
	public void setName(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String getAddress() {
		return soNha;
	}
	
	public void setAddress(String soNha) {
		this.soNha = soNha;
	}
	
	public int getcongTo() {
		return congTo;
	}
	
	public void setcongTo(int congTo) {
		this.congTo = congTo;
	}
	
	public void nhap() {
		System.out.print("Nhap ten chu ho: ");
		String hoTen = myInput.nextLine();
		this.setName(hoTen);
		System.out.print("Nhap dia chi: ");
		String soNha = myInput.nextLine();
		this.setAddress(soNha);
		System.out.print("Nhap ma so cong to: ");
		int congTo = Integer.parseInt(myInput.nextLine());
		this.setcongTo(congTo);
	}
	
	public void xuat() {
		System.out.print("Ten CH: " + this.getName() + " || Dia chi: " + this.getAddress() + " || Ma CT: " + this.getcongTo());
	}
}
