package Canbo;

  import java.util.Comparator;
import java.util.Scanner;

import student.SinhVien;
public class Nhanvien {
    public static Scanner myinput = new Scanner(System.in);
    private String hoten;
    private String phongban;
    private int  songaycong;
    private double phucap;
    private String  chucvu;
    private double hesoluong;
    private double luong;
    public Nhanvien() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 
    public Nhanvien(String hoten, String phongban, int songaycong, double phucap,
            String chucvu, double hesoluong, double luong) {
        super();
        this.hoten = hoten;
        this.phongban = phongban;
        this.songaycong = songaycong;
        this.phucap = phucap;
        this.chucvu = chucvu;
        this.hesoluong = hesoluong;
        this.luong = luong;
       }

    public static Scanner getMyinput() {
        return myinput;
    }

    public static void setMyinput(Scanner myinput) {
        Nhanvien.myinput = myinput;
    }


    public String getHoten() {
        return hoten;
    }


    public void setHoten(String hoten) {
        this.hoten = hoten;
    }


    public String getPhongban() {
        return phongban;
    }


    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }


    public int getSongaycong() {
        return songaycong;
    }


    public void setSongaycong(int songaycong) {
        this.songaycong = songaycong;
    }


    public double getPhucap() {
        return phucap;
    }


    public void setPhucap(float phucap) {
        this.phucap = phucap;
    }


    public String getChucvu() {
        return chucvu;
    }


    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }


    public double getHesoluong() {
        return hesoluong;
    }


    public void setHesoluong(float hesoluong) {
        this.hesoluong = hesoluong;
    }


    public void nhap() {
        System.out.println("Nhập họ tên nhân viên");
        hoten = myinput.nextLine();
        System.out.println("Phòng ban cua nhận viên");
        phongban = myinput.nextLine();
        System.out.println("Số ngày công cua nhận viên");
       songaycong = Integer.parseInt(myinput.nextLine());
       System.out.println("Chức vụ của nhân viên");
       chucvu = myinput.nextLine();
       if(this.chucvu.equals("Trưởng phòng")) {
           phucap = 2000;
           hesoluong = 1.8;
       }
       else if(this.chucvu.equals("Phó phòng")){
           phucap =1000;
           hesoluong = 1.5;
       }
       else if(this.chucvu.equals("Nhân viên")) {
           phucap = 500;
           hesoluong = 1.3;
       }
    }
    public void xuat() {
        System.out.printf("| %-6s | %-20s | %-3s | %-20s | %-4s | %-4s |%4s |\n", hoten, phongban, songaycong, phucap, chucvu, hesoluong, this.getLuong());
    }
    public double getLuong() {
       luong =hesoluong*730 + phucap + songaycong*30 ;
        return luong;
    }
    public static Comparator<Nhanvien> sortByluong = new Comparator<Nhanvien>() {
        public int compare(Nhanvien nv1, Nhanvien nv2) {
            return Double.compare(nv1.luong, nv2.luong);
        }
    };
}


