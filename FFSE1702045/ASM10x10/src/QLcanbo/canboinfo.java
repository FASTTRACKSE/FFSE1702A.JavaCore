package QLcanbo;
 
import java.io.Serializable;
import java.util.Scanner;
 
public class canboinfo implements Serializable {
    private String hoTen, loai;
    private double hsl;
    private int phuCap;
    protected int choose;
    Scanner scanner = new Scanner(System.in);
    canboinfo canboinfo;
     
    public canboinfo() {
        super();
    }
 
    public canboinfo(String hoTen, String loai, double hsl, int phuCap) {
        super();
        this.hoTen = hoTen;
       
        this.loai = loai;
        this.hsl = hsl;
        this.phuCap = phuCap;
	
    }
 
    public String getHoTen() {
        return hoTen;
    }
 
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
 
    public String getloai() {
        return loai;
    }
 
    public void setloai(String loai) {
        this.loai = loai;
    }
 
    public double gethsl() {
        return hsl;
    }
 
    public void sethsl(double hsl) {
        this.hsl = hsl;
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
				canboinfoexception.chkHoten(hoTen);
				break;
        	} catch (canboinfoexception e) {
				System.out.println(e);
			}
     }
      
        System.out.print("Nhập hệ số lương: ");
        hsl = Double.parseDouble(scanner.nextLine());
        
    }
     
    public long tinhLuong() {
        return 0;
    }
     
    @Override
    public String toString() {
        return "Tên: " + this.hoTen + ", hệ số lương: " + this.hsl + ", phụ cấp: " + 
                phuCap + ", lương: " + this.tinhLuong();
    }
 
}