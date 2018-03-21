package java_asm; 

import java.util.Scanner;

public class CanBo {
	private String maCanBo; 
    public CanBo(String maCanBo) {
		super();
		this.maCanBo = maCanBo;
	}

	public String getMaCanBo() {
		return maCanBo;
	}

	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
	}

	private String hoTen;
    private int heSoLuong;
    private int phuCap;
    protected int choose;
    Scanner scanner = new Scanner(System.in);
    CanBo canBo;
     
    public CanBo() {
        super();
    }
 
    public CanBo(String hoTen, String loaiCanBo, int heSoLuong, int phuCap) {
        super();
        this.hoTen = hoTen;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }
 
    public String getHoTen() {
        return hoTen;
    }
 
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public double getHeSoLuong() {
        return heSoLuong;
    }
 
    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
 
    public int getPhuCap() {
        return phuCap;
    }
 
    public void setPhuCap(int phuCap) {
        this.phuCap = phuCap;
    }
     
    public void nhap() {
    	for(;;) {
		        System.out.print("Nhập họ tên: ");
		        hoTen = scanner.nextLine();
		     try {
		    	 CanBoException.chkHoTen(hoTen);
		    	 break;
		     }
		     catch(CanBoException e){
		    	 System.out.println(e);
		    	 }
		    }
    	
    	for(;;) {
		        System.out.print("Nhập hệ số lương: ");
		        heSoLuong = Integer.parseInt(scanner.nextLine());
		        try {
		        	CanBoException.chkSoNguyen(heSoLuong);
		        	break;
		        }
			catch (CanBoException e) {
				System.out.println(e);

			}
		        this.setHeSoLuong(heSoLuong);
    }}
    
    public long tinhLuong() {
        return 0;
    }
     
    @Override
    public String toString() {
        return "Tên: " + this.hoTen + "| hệ số lương: " + this.heSoLuong + "| phụ cấp: " + 
                phuCap + "| lương: " + this.tinhLuong();
    }
}