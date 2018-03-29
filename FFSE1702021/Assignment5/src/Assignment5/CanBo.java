package Assignment5;
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
import java.util.Scanner;
public class CanBo {
<<<<<<< HEAD
       private String hoTen;
       private int phuCap;
       private float heSoLuong;
       private float luong;
       public CanBo() {
    	   
       }
	public CanBo(String hoTen, int phuCap, float heSoLuong, float luong) {
=======
=======
import java.io.Serializable;
import java.util.Scanner;

public class CanBo implements Serializable {
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
	private String hoTen;
	private int phuCap;
	private float heSoLuong;
	private double luong;
<<<<<<< HEAD
    private String maCanBo;
	public CanBo() {
     
	}

	public CanBo(String hoTen, int phuCap, float heSoLuong, double luong,String maCanBo) {
=======
	private String maCanBo;

	public CanBo() {

	}

	public CanBo(String hoTen, int phuCap, float heSoLuong, double luong, String maCanBo) {
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
		super();
		this.hoTen = hoTen;
		this.phuCap = phuCap;
		this.heSoLuong = heSoLuong;
		this.luong = luong;
<<<<<<< HEAD
=======
<<<<<<< HEAD
		this.maCanBo=maCanBo;
=======
		this.maCanBo = maCanBo;
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
	}

	public String getMaCanBo() {
		return maCanBo;
	}

	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
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
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
<<<<<<< HEAD
       public void nhap() {
    	   Scanner scn= new Scanner(System.in);
    	   System.out.println("nhap ho ten:");
    	   String hoTen= scn.nextLine();
    	   setHoTen(hoTen);
    	   
    	   System.out.println("nhap he so luong:");
    	   float heSoLuong= scn.nextFloat();
    	   setHeSoLuong(heSoLuong);
       
       }
       public void xuat() {
    	   
           System.out.print("Ten:"+ hoTen);
           System.out.print("He So Luong:"+ heSoLuong);
       }
 }
=======
<<<<<<< HEAD
    
	public void nhap() {
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
	
		for(;;) {
		System.out.println("nhap he so luong:");
		float heSoLuong = scn.nextFloat();
		try {
			CanBoException.chkSoThuc(heSoLuong);
			setHeSoLuong(heSoLuong);
			break;
		}
		catch(CanBoException e){
		    System.out.println(e);
		    
		     }
		
		}
		
=======

	public void nhap() {
		Scanner scn = new Scanner(System.in);
		for (;;) {

			System.out.println("nhap ho ten:");
			String hoTen = scn.nextLine();
			try {
				CanBoException.chkHoTen(hoTen);
				setHoTen(hoTen);
				break;
			} catch (CanBoException e) {
				System.out.println(e);

			}

		}

		for (;;) {
			System.out.println("nhap he so luong:");
			float heSoLuong = scn.nextFloat();
			try {
				CanBoException.chkSoThuc(heSoLuong);
				setHeSoLuong(heSoLuong);
				break;
			} catch (CanBoException e) {
				System.out.println(e);

			}

		}

>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
	}

	public double tinhLuong() {
		return 0;
	}

	public void xuat() {

		System.out.print("Ten:" + hoTen);
		System.out.print("He So Luong:" + heSoLuong);
	}

<<<<<<< HEAD
	
=======
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
}
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
