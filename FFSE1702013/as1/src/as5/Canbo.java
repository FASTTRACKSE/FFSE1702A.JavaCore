package as5;

import java.util.Scanner;

public class Canbo {
	private String hoTen, maCanBo;
    private double heSoLuong;
    private int phuCap;
    protected int choose;
    Scanner scanner = new Scanner(System.in);
    Canbo canBo;
     
    public Canbo() {
        super();
    }
 
    public Canbo(String hoTen, String maCanBo, double heSoLuong, int phuCap) {
        super();
        this.hoTen = hoTen;
        this.maCanBo = maCanBo;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }
 
    public String getHoTen() {
        return hoTen;
    }
 
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
 
    public String getMaCanBo() {
        return maCanBo;
    }
 
    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }
 
    public double getHeSoLuong() {
        return heSoLuong;
    }
 
    public void setHeSoLuong(double heSoLuong) {
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
    		
    		System.out.println("nhap ho ten:");
    		
			String hoTen = scanner.nextLine();
    		try {
    			CanboException.chkHoTen(hoTen);
    			setHoTen(hoTen);
    			break;
    		}
    		catch(CanboException e){
    		    System.out.println(e);
    		    
    		     }
    		
    		}
        System.out.print("Nhập hệ số lương: ");
        heSoLuong = Double.parseDouble(scanner.nextLine());
    }
     
    public long tinhLuong() {
        return 0;
    }
     
    @Override
    public String toString() {
        return "Tên: " + this.hoTen + ", hệ số lương: " + this.heSoLuong + ", phụ cấp: " + 
                phuCap + ", lương: " + this.tinhLuong();
    }

	public int getLuong() {
		// TODO Auto-generated method stub
		return 0;
	}
}