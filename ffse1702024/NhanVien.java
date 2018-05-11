package java_asm;

public class NhanVien extends CanBo {
    private String phongBan, chucVu;
    private int soNgayCong, choose;
     
    public NhanVien() {
        super();
    }
 
    public NhanVien(String phongBan, String chucVu, int soNgayCong) {
        super();
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.soNgayCong = soNgayCong;
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
 
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("nhap phong ban: ");
        phongBan = scanner.nextLine();
        do {
            System.out.print("nhap chuc vu (1 - truong phong, 2 - pho phong, 3 - nhan vien): ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    chucVu = "truong phong";
                    this.setPhuCap(2000);
                    break;
                case 2:
                    chucVu = "pho phong";
                    this.setPhuCap(1000);
                    break;
                case 3:
                    chucVu = "nhan vien";
                    this.setPhuCap(500);
                    break;
                default:
                    System.out.println("chon khong dung!");
                    break;
            }
        } while (choose < 1 || choose > 3);
        System.out.print("nhap so ngay cong: ");
        soNgayCong = scanner.nextInt();
    }
 
    @Override
    public long tinhLuong() {
        return (long) (this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoNgayCong() * 200);
    }
 
    @Override
    public String toString() {
        return super.toString() + ", phong ban: " + this.phongBan + ", chuc vu : " + this.chucVu + 
            ", so ngay cong: " + this.soNgayCong;
    }
     
}