package Canbo;
<<<<<<< HEAD

<<<<<<< HEAD
import java.util.Comparator;
=======
=======
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
import java.util.Scanner;

import Canbo.Giangvien.myexception;
import student.SinhVien;

public class Nhanvien {
    public static Scanner myinput = new Scanner(System.in);

    private String hoten;

    private String phongban;

    private int songaycong;

    private double phucap;

    private String chucvu;

    private double hesoluong;

    private double luong;

    public Nhanvien() {
        super();
        // TODO Auto-generated constructor stub
    }

<<<<<<< HEAD
    public Nhanvien(String hoten, String phongban, int songaycong,
            double phucap, String chucvu, double hesoluong, double luong) {
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
=======
<<<<<<< HEAD
    public NhanVien(String hoTen, String phongBan, String chucVu, int soNgayCong, double heSoLuong) {
=======
    public NhanVien(String hoTen, String phongBan, String chucVu, int soNgayCong, double heSoLuong,String maCanBo) {
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
        super();
        this.setHoTen(hoTen);
        this.phongBan = phongBan;
        this.chucVu = chucVu;
<<<<<<< HEAD
=======
        this.maCanBo=maCanBo;
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
        this.soNgayCong = soNgayCong;
        this.setHeSoLuong(heSoLuong);
        if (chucVu == "Trưởng phòng") {
            this.setPhuCap(2000);
        } else if (chucVu == "Phó phòng") {
            this.setPhuCap(1000);
        } else if (chucVu == "Nhân viên") {
            this.setPhuCap(500);
        }
        this.setLuong(tinhLuong());
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
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

        hoten = checkHoten();
        System.out.println("Phòng ban cua nhận viên");
        phongban = myinput.nextLine();

        // check sô ngày nghĩ;
        System.out.println("Số ngày công cua nhận viên");
        songaycong = checkSongaycong();

        // check chuc vu cua Nhan vien;
        chucvu = checkChucvu();
        ;

        if (this.chucvu.equals("Trưởng phòng")) {
            phucap = 2000;
            hesoluong = 1.8;
        } else if (this.chucvu.equals("Phó phòng")) {
            phucap = 1000;
            hesoluong = 1.5;
        } else if (this.chucvu.equals("Nhân viên")) {
            phucap = 500;
            hesoluong = 1.3;
        }
    }

    public void xuat() {
        System.out.printf(
                "| %-6s | %-20s | %-3s | %-20s | %-4s | %-4s |%4s |\n", hoten,
                phongban, songaycong, phucap, chucvu, hesoluong,
                this.getLuong());
    }

    public double getLuong() {
        luong = hesoluong * 730 + phucap + songaycong * 30;
        return luong;
    }

    public static Comparator<Nhanvien> sortByluong = new Comparator<Nhanvien>() {
        public int compare(Nhanvien nv1, Nhanvien nv2) {
            return Double.compare(nv1.luong,nv2.luong);}};

    // check ho ten;
    String checkHoten() {
        do {
<<<<<<< HEAD
            Main main = new Main();
            System.out.println("Nhập họ tên nhân viên");
            hoten = myinput.nextLine();
            try {
                int a = hoten.length();
                if (a == 0 || a >= 40) {
                    throw new myexception(a);
                } else if (main.checkexistHoten(hoten)) {
                    System.out.println("* Họ tên đã tồn tại! \\n Nhập lại: ");
                } else
                    return hoten;
            } catch (myexception e) {
                System.out.println(
                        "* Họ tên không hợp lệ! (Họ tên không được rỗng và có độ dài không quá 40 ký tự) \\\\n Nhập lại:");
=======
            choose = Main.myFunction.loopCheckInt();
            switch (choose) {
            case 1:
                chucVu = "Trưởng phòng";
                this.setPhuCap(2000);
                break;
            case 2:
                chucVu = "Phó phòng";
                this.setPhuCap(1000);
                break;
            case 3:
<<<<<<< HEAD
                chucVu = "Nhân viên";
=======
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
                this.setPhuCap(500);
                break;
            default:
                System.err.print(" * Vui lòng nhập số từ 1-3!\n Nhập lại: ");
                break;
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
            }
        } while (true);
    }

    // check chuc vu cua nhan vien;
    String checkChucvu() {
        do {
            System.out.println("Chức vụ của nhân viên");
            try {
                int choose = Integer.parseInt(myinput.nextLine());
                switch (choose) {
                case 1:
                    chucvu = "Trưởng phòng";
                    break;
                case 2:
                    chucvu = "Phó phòng";
                    break;
                case 3:
                    chucvu = "Nhân viên";
                    break;
                }
                System.out.println("Chức vụ :" + chucvu);
                if (choose != 1 && choose != 2 && choose != 3) {
                    int a = choose;
                    throw new myexception(a);
                } else
                    return chucvu;
            } catch (myexception e) {
                System.out.println("Xin mời chọn đúng chức vụ");
            }
        } while (true);
    }
    //check so ngay công:
    int checkSongaycong() {
        do {
            try {
                System.out.println("Số ngày công của nhân viên");
                songaycong = Integer.parseInt(myinput.nextLine());
                int a = songaycong;
                if (a < 0) {
                    throw new myexception(a);
                } else
                    return songaycong;
            } catch (myexception e) {
                System.out.println(
                        "Xin mời nhập lại số tiết (Yêu cầu lớn hơn 0)");
            }
        } while (true);
    }
    // xây dụng class exception:
class myexception extends Exception{
    private int message;
    myexception(int a){
        message = a;
    }
    public String toString() {
        return"Myexception"+ message;
    }
}
}
