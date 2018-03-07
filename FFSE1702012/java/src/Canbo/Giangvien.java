package Canbo;
    import java.util.Comparator;
import java.util.Scanner;
public class Giangvien {
    public static Scanner myinput = new Scanner(System.in);
    private String hoten;
    private String khoa;
    private String trinhdo;
    private double phucap;
    private int sotiet;
    private double hesoluong;
    private double luong;
    public Giangvien() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Giangvien(String hoten, String khoa, String trinhdo, double phucap,
            int sotiet, double hesoluong, double luong) {
        super();
        this.hoten = hoten;
        this.khoa = khoa;
        this.trinhdo = trinhdo;
        this.phucap = phucap;
        this.sotiet = sotiet;
        this.hesoluong = hesoluong;
        this.luong = luong;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    public double getPhucap() {
        return phucap;
    }

    public void setPhucap(double phucap) {
        this.phucap = phucap;
    }

    public int getSotiet() {
        return sotiet;
    }

    public void setSotiet(int sotiet) {
        this.sotiet = sotiet;
    }

    public double getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(double hesoluong) {
        this.hesoluong = hesoluong;
    }
     
    public void nhap() {
        System.out.println("Nhập họ tên giang viên");
        hoten = myinput.nextLine();
        System.out.println("Khoa giang dạy cua giang viên");
        khoa = myinput.nextLine();
        System.out.println("Trình độ cua giang viên");
       trinhdo = myinput.nextLine();

       if(this.trinhdo.equals("Cử nhân")) {
           phucap = 300;
           hesoluong = 1.8;
       }
       else if(this.trinhdo.equals("Thạc Sí")){
           phucap =500;
           hesoluong = 1.5;
       }
       else if(this.trinhdo.equals("Tiến Sí")) {
           phucap = 1000;
           hesoluong = 1.3;
       }
       System.out.println("Số tiết cua giang viên");
       sotiet = Integer.parseInt(myinput.nextLine());
    }
    public void xuat() {
        System.out.printf("| %-6s | %-20s | %-3s | %-20s | %4s | %4s |%4s |\n", hoten, khoa, trinhdo, phucap, sotiet, hesoluong, this.getLuong());
    }
    public double getLuong() {
      luong =hesoluong*730 + phucap + sotiet*45;
        return luong;
    }
    public static Comparator<Giangvien> sortByluong = new Comparator<Giangvien>() {
        public int compare(Giangvien gv1, Giangvien gv2) {
            return Double.compare(gv1.luong, gv2.luong);
        }
    };
    
}
