package Canbo;
<<<<<<< HEAD

<<<<<<< HEAD
import java.util.Comparator;
=======
=======
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
import java.util.Scanner;
public class GiangVien extends CanBo {
    private static final long serialVersionUID = 1L;
    private String khoa, trinhDo;
    private int soTiet, choose;

<<<<<<< HEAD
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
=======
<<<<<<< HEAD
public class GiangVien extends CanBo {
    private static final long serialVersionUID = 1L;
    private String khoa, trinhDo;
    private int soTiet, choose;

=======
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
    public GiangVien() {
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
        super();
        // TODO Auto-generated constructor stub
    }

<<<<<<< HEAD
    public Giangvien(String hoten, String khoa, String trinhdo, double phucap,
            int sotiet, double hesoluong, double luong) {
=======
<<<<<<< HEAD
    public GiangVien(String hoTen, String khoa, String trinhDo, int soTiet, double heSoLuong) {
=======
    public GiangVien(String hoTen, String khoa, String trinhDo, int soTiet, double heSoLuong,String maCanBo) {
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
        super();
        this.hoten = hoten;
        this.khoa = khoa;
<<<<<<< HEAD
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
=======
        this.trinhDo = trinhDo;
        this.soTiet = soTiet;
        this.setHeSoLuong(heSoLuong);
        if (trinhDo == "Cử nhân") {
            this.setPhuCap(300);
        } else if (trinhDo == "Thạc sĩ") {
            this.setPhuCap(500);
        } else if (trinhDo == "Tiến sĩ") {
            this.setPhuCap(1000);
        }
        this.setLuong(tinhLuong());
<<<<<<< HEAD
=======
        this.maCanBo=maCanBo;
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

<<<<<<< HEAD
    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
=======
    public String getTrinhDo() {
        return trinhDo;
<<<<<<< HEAD
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
    }

    public double getPhucap() {
        return phucap;
    }

    public void setPhucap(double phucap) {
        this.phucap = phucap;
    }

<<<<<<< HEAD
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
=======
=======
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public int getSoTiet() {
        return soTiet;
    }

>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
    }

    public void nhap() {

        hoten = checkHoten();
        System.out.println("Khoa giang dạy cua giang viên");
        khoa = myinput.nextLine();
        // ----------------------------------------------
        System.out.println("Trình độ cua giang viên");
        trinhdo = checkTrinhdo();

        if (this.trinhdo.equals("Cử nhân")) {
            phucap = 300;
            hesoluong = 1.8;
        } else if (this.trinhdo.equals("Thạc Sí")) {
            phucap = 500;
            hesoluong = 1.5;
        } else if (this.trinhdo.equals("Tiến Sí")) {
            phucap = 1000;
            hesoluong = 1.3;
        }

        sotiet = checkSotiet();
    }

    public void xuat() {
        System.out.printf("| %-6s | %-20s | %-3s | %-20s | %4s | %4s |%4s |\n",
                hoten, khoa, trinhdo, phucap, sotiet, hesoluong,
                this.getLuong());
    }

    public double getLuong() {
        luong = hesoluong * 730 + phucap + sotiet * 45;
        return luong;
    }

    public static Comparator<Giangvien> sortByluong = new Comparator<Giangvien>() {
        public int compare(Giangvien gv1, Giangvien gv2) {
            return Double.compare(gv1.luong, gv2.luong);
        }
    };

    String checkHoten() {
        do {
            System.out.println("Nhập họ tên giang viên");
            Main main = new Main();
            try {
                hoten = myinput.nextLine();
                int a = hoten.length();
                if (a == 0 || a >= 40) {
                    throw new myexception(a);
                } else if (main.checkexistHoten(hoten)) {
                    System.out.print(" * Họ tên đã tồn tại! \n Nhập lại: ");
                } else
                    return hoten;
            } catch (myexception e) {
                System.out.println(
                        " * Họ tên không hợp lệ! (Họ tên không được rỗng và có độ dài không quá 40 ký tự) \\n Nhập lại: ");
            }

        } while (true);
    }

    String checkTrinhdo() {
        do {
            try {
                System.out.println("Xin mời bạn chọn trình độ");
                System.out.println("1 : Cử nhân ");
                System.out.println("2 : Thạc sĩ ");
                System.out.println("3 : Tiến sĩ");
                int choose = Integer.parseInt(myinput.nextLine());
                switch (choose) {
                case 1:
                    trinhdo = "Cử nhân";
                    break;
                case 2:
                    trinhdo = "Thạc Sí";
                    break;
                case 3:
                    trinhdo = "Tiến Sí";
                    break;
                }
                System.out.println("Trình độ :" + trinhdo);
                if (choose != 1 && choose != 2 && choose != 3) {
                    int a = choose;
                    throw new myexception(a);
                } else
                    return trinhdo;
            } catch (myexception e) {
                System.out.println("Xin mời chọn đúng trình độ");
            }
        } while (true);
    }
    int checkSotiet() {
        do {
            try {
            System.out.println("Số tiết cua giang viên");
            sotiet = myinput.nextInt();
            int a = sotiet;
            if(a <0) {
                throw new myexception(a);
            }
            else return sotiet;
            }catch(myexception e) {
                System.out.println("Xin mời nhập lại số tiết (Yêu cầu lớn hơn 0)");
            }
        }while(true);
    }

    class myexception extends Exception {
        private int message;

        myexception(int a) {
            message = a;
        }

        public String toString() {
            return "MyException " + message;
        }
    }
<<<<<<< HEAD
}
=======
<<<<<<< HEAD
}
=======
}

>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
