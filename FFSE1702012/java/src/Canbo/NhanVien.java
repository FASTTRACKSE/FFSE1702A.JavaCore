package Canbo;
import java.util.Scanner;

public class NhanVien extends CanBo {
    private static final long serialVersionUID = 1L;
    private String phongBan, chucVu;
    private int soNgayCong, choose;

    public NhanVien() {
        super();
    }

    public NhanVien(String hoTen, String phongBan, String chucVu, int soNgayCong, double heSoLuong,String maCanBo) {
        super();
        this.setHoTen(hoTen);
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.maCanBo=maCanBo;
        this.soNgayCong = soNgayCong;
        this.setHeSoLuong(heSoLuong);
        if (chucVu == "TrÆ°á»Ÿng phÃ²ng") {
            this.setPhuCap(2000);
        } else if (chucVu == "PhÃ³ phÃ²ng") {
            this.setPhuCap(1000);
        } else if (chucVu == "NhÃ¢n viÃªn") {
            this.setPhuCap(500);
        }
        this.setLuong(tinhLuong());
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        super.nhap();
        System.out.print("Nháº­p phÃ²ng ban: ");
        phongBan = scanner.nextLine();
        System.out.print("Chá»�n chá»©c vá»¥ (1 - TrÆ°á»Ÿng phÃ²ng, 2 - PhÃ³ phÃ²ng, 3 - NhÃ¢n viÃªn): ");
        do {
            choose = Main.myFunction.loopCheckInt();
            switch (choose) {
            case 1:
                chucVu = "TrÆ°á»Ÿng phÃ²ng";
                this.setPhuCap(2000);
                break;
            case 2:
                chucVu = "PhÃ³ phÃ²ng";
                this.setPhuCap(1000);
                break;
            case 3:
                this.setPhuCap(500);
                break;
            default:
                System.err.print(" * Vui lÃ²ng nháº­p sá»‘ tá»« 1-3!\n Nháº­p láº¡i: ");
                break;
            }
        } while (choose > 3);
        System.out.print("Nháº­p sá»‘ ngÃ y cÃ´ng: ");
        soNgayCong = Main.myFunction.loopCheckInt();
        this.setLuong(tinhLuong());
    }

    public double tinhLuong() {
        return (double) (this.getHeSoLuong() * 730 + this.getPhuCap() + soNgayCong * 30);
    }

    @Override
    public String toString() {
        return String.format(
                "| %-20s | PhÃ²ng ban: %-15s | Chá»©c vá»¥: %-12s | Sá»‘ ngÃ y cÃ´ng: %2s | Há»‡ sá»‘ lÆ°Æ¡ng: %3s | Phá»¥ cáº¥p: %4s | LÆ°Æ¡ng: %8s |\n",
                this.getHoTen(), phongBan, chucVu, soNgayCong, this.getHeSoLuong(), this.getPhuCap(), this.getLuong());
    }
}