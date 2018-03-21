package Quanlycanbo.com;
import java.util.*;
public class CanBo {
	private String hoTen;
	private float heSoLuong;
	Scanner myInput = new Scanner(System.in);
	
	public CanBo() {
		super();
	}
	
	public CanBo(String hoTen, float heSoLuong) {
		super();
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public float getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	
	public void nhapTen() {
		System.out.print("Nhap ho ten: ");
		String hoTen = myInput.nextLine();
		this.setHoTen(hoTen);
	}
	
	public void nhapHeSoLuong() {
		System.out.print("Nhap he so luong: ");
		float heSoLuong = Float.parseFloat(myInput.nextLine());
		this.setHeSoLuong(heSoLuong);
	}
}
