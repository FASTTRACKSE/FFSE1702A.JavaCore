package QLcanbo;

import java.io.Serializable;

public class GiangVien   extends canboinfo implements Serializable {
    private String khoa, trinhDo;
    private int soTietDay, choose;
     
    public GiangVien() {
        super();
    }
 
    public GiangVien(String khoa, String trinhDo, int soTietDay) {
        super();
        this.khoa = khoa;
        this.trinhDo = trinhDo;
        this.soTietDay = soTietDay;
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
 
    public int getSoTietDay() {
        return soTietDay;
    }
 
    public void setSoTietDay(int soTietDay) {
        this.soTietDay = soTietDay;
    }
 
    @Override
    public void nhap() {
        super.nhap();
        for(;;) {
        System.out.print("Nhập khoa: ");
        khoa = scanner.nextLine();
        try {
			canboinfoexception.chkValue(khoa);
			break;
    	} catch (canboinfoexception e) {
			System.out.println(e);
		}
        }
        do {
            System.out.print("Nhập trình độ (1 - cử nhân, 2 - thạc sĩ, 3 -tiến sĩ): ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    trinhDo = "cử nhân";
                    this.setPhuCap(300);
                    break;
                case 2:
                    trinhDo = "thạc sĩ";
                    this.setPhuCap(500);
                    break;
                case 3:
                    trinhDo = "tiến sĩ";
                    this.setPhuCap(1000);
                default:
                    System.out.println("Chọn không đúng!");
                    break;
            }
        } while (choose < 1 || choose > 4);
        System.out.print("Số tiết dạy: ");
        soTietDay = scanner.nextInt();
    }
 
    @Override
    public long tinhLuong() {
        return (long) (this.gethsl() * 730 + this.getPhuCap() + this.getSoTietDay() * 45);
    }
 
    @Override
    public String toString() {
        return super.toString() + ", khoa: " + this.khoa + ", trình độ: " + this.trinhDo + 
            ", số tiết dạy: " + this.soTietDay;
    }
     
     
}