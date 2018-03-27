package Canbo;
<<<<<<< HEAD

=======
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
import java.util.Scanner;
public class GiangVien extends CanBo {
    private static final long serialVersionUID = 1L;
    private String khoa, trinhDo;
    private int soTiet, choose;

<<<<<<< HEAD
public class GiangVien extends CanBo {
    private static final long serialVersionUID = 1L;
    private String khoa, trinhDo;
    private int soTiet, choose;

=======
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
    public GiangVien() {
        super();
    }

<<<<<<< HEAD
    public GiangVien(String hoTen, String khoa, String trinhDo, int soTiet, double heSoLuong) {
=======
    public GiangVien(String hoTen, String khoa, String trinhDo, int soTiet, double heSoLuong,String maCanBo) {
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
        super();
        this.setHoTen(hoTen);
        this.khoa = khoa;
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
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getTrinhDo() {
        return trinhDo;
<<<<<<< HEAD
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public int getSoTiet() {
        return soTiet;
    }

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
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        super.nhap();
        System.out.print("Nhập khoa: ");
        khoa = scanner.nextLine();
        System.out.print("Chọn trình độ (1 - Cử nhân, 2 - Thạc sĩ, 3 - Tiến sĩ): ");
        do {
            choose = Main.myFunction.loopCheckInt();
            switch (choose) {
            case 1:
                trinhDo = "Cử nhân";
                this.setPhuCap(300);
                break;
            case 2:
                trinhDo = "Thạc sĩ";
                this.setPhuCap(500);
                break;
            case 3:
                trinhDo = "Tiến sĩ";
                this.setPhuCap(1000);
                break;
            default:
                System.err.print(" * Vui lòng nhập số từ 1-3!\n Nhập lại: ");
                break;
            }
        } while (choose > 3);
        System.out.print("Nhập số tiết dạy: ");
        soTiet = Main.myFunction.loopCheckInt();
        this.setLuong(tinhLuong());
    }

    public double tinhLuong() {
        return (double) (this.getHeSoLuong() * 730 + this.getPhuCap() + soTiet * 45);
    }

    @Override
    public String toString() {
        return String.format(
                "| %-20s | Khoa     : %-15s | Trình độ: %-11s | Số tiết     : %2s | Hệ số lương: %3s | Phụ cấp: %4s | Lương: %8s |\n",
                this.getHoTen(), khoa, trinhDo, soTiet, this.getHeSoLuong(), this.getPhuCap(), this.getLuong());
    }
<<<<<<< HEAD
}
=======
}

>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
