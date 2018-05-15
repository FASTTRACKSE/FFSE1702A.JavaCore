package Entity;

public class ThiSinh {
    int MaTS;
    String Name;
    int MaTinh;
    String NgaySinh;
    int GioiTinh;
    float DiemToan;
    float DiemHoa;
    float DiemLi;

    public ThiSinh(int MaTS, String Name, int MaTinh, String NgaySinh, int GioiTinh, float DiemToan, float DiemHoa, float DiemLi) {
        this.MaTS = MaTS;
        this.Name = Name;
        this.MaTinh = MaTinh;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiemToan = DiemToan;
        this.DiemHoa = DiemHoa;
        this.DiemLi = DiemLi;
    }

    public ThiSinh() {
    }

    public int getMaTS() {
        return this.MaTS;
    }

    public void setMaTS(int MaTS) {
        this.MaTS = MaTS;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getMaTinh() {
        return this.MaTinh;
    }

    public void setMaTinh(int MaTinh) {
        this.MaTinh = MaTinh;
    }

    public String getNgaySinh() {
        return this.NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGioiTinh() {
        return this.GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public float getDiemToan() {
        return this.DiemToan;
    }

    public void setDiemToan(float DiemToan) {
        this.DiemToan = DiemToan;
    }

    public float getDiemHoa() {
        return this.DiemHoa;
    }

    public void setDiemHoa(float DiemHoa) {
        this.DiemHoa = DiemHoa;
    }

    public float getDiemLi() {
        return this.DiemLi;
    }

    public void setDiemLi(float DiemLi) {
        this.DiemLi = DiemLi;
    }
    
    
}