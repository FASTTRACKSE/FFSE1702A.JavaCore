package Canbo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Scanner;

public class CanBo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String hoTen;
    private int phuCap;
    private double heSoLuong, luong;
    // Scanner scanner;

    public CanBo() {
        super();
    }

    public CanBo(String hoTen, int phuCap, double heSoLuong) {
        super();
        this.hoTen = hoTen;
        this.phuCap = phuCap;
        this.heSoLuong = heSoLuong;
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

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ tên: ");
        do {
            try {
                hoTen = scanner.nextLine();
                MyException.checkHoTen(hoTen);
                break;
            } catch (MyException e) {
                System.err.print(e);
            }
        } while (true);
        System.out.print("Nhập hệ số lương: ");
        heSoLuong = Main.myFunction.loopCheckDouble();
    }

    public static Comparator<CanBo> sortByLuong = new Comparator<CanBo>() {
        public int compare(CanBo cb1, CanBo cb2) {
            if (Double.compare(cb2.luong, cb1.luong) == 0) {
                return cb1.hoTen.compareTo(cb2.hoTen);
            } else {
                return Double.compare(cb2.luong, cb1.luong);
            }
        }
    };
}