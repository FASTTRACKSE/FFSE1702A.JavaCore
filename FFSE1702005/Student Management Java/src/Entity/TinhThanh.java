package Entity;

public class TinhThanh {
    int MaTinh;
    String TenTinh;

    public TinhThanh(int MaTinh, String TenTinh) {
        this.MaTinh = MaTinh;
        this.TenTinh = TenTinh;
    }

    public TinhThanh() {
    }

    public int getMaTinh() {
        return this.MaTinh;
    }

    public void setMaTinh(int MaTinh) {
        this.MaTinh = MaTinh;
    }

    public String getTenTinh() {
        return this.TenTinh;
    }

    public void setTenTinh(String TenTinh) {
        this.TenTinh = TenTinh;
    }
}