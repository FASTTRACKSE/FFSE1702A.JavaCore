package text;

public class BienLai extends KhachHang {
	int chiSoCu;
	int chiSoMoi;
	float soTienPhaiTra = 0;

	public BienLai(String hoTen, String soNha, String maSoCongTo, int chiSoCu, int chiSoMoi, float soTienPhaiTra) {
		super(hoTen, soNha, maSoCongTo);
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.soTienPhaiTra = soTienPhaiTra;
	}

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public float getSoTienPhaiTra() {
		return soTienPhaiTra;
	}

	public void setSoTienPhaiTra(float soTienPhaiTra) {
		this.soTienPhaiTra = soTienPhaiTra;
	}

}
