package Quanlycanbo;
<<<<<<< HEAD

import java.util.*;
public class CanBo {
=======
import java.io.Serializable;
import java.util.*;
public class CanBo implements Serializable  {
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
	private String maCanBo;
	public String getMaCanBo() {
		return maCanBo;
	}

	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
	}

	private String hoTen;
	private float heSoLuong;
<<<<<<< HEAD
=======
	private double luong;
	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public Scanner getMyInput() {
		return myInput;
	}

	public void setMyInput(Scanner myInput) {
		this.myInput = myInput;
	}

>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
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
		Scanner scn = new Scanner(System.in);
		for(;;) {
		
		System.out.println("nhap ho ten:");
		String hoTen = scn.nextLine();
		try {
			CanBoException.chkHoTen(hoTen);
			setHoTen(hoTen);
			break;
		}
		catch(CanBoException e){
		    System.out.println(e);
		    
		     }
		
		}
	}
	
	public void nhapHeSoLuong() {
		System.out.print("Nhap he so luong: ");
		float heSoLuong = Float.parseFloat(myInput.nextLine());
		this.setHeSoLuong(heSoLuong);
	}
<<<<<<< HEAD
=======
	public double tinhLuong() {
		return 0;
	}
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
}
