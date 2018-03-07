package text;

import java.util.Scanner;

public class BienLai extends KhachHang {
	int chiSoCu;
	int chiSoMoi;
	float soTienPhaiTra = 0;
	private KhachHang khachHang;

	public BienLai() {

	}

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

	public BienLai(String hoTen, String soNha, String maSoCongTo, KhachHang khachHang) {
		super(hoTen, soNha, maSoCongTo);
		this.khachHang = khachHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public void nhapbienlai() {
		super.nhap();

		Scanner congto = new Scanner(System.in);
		System.out.print("Nhập số công tơ mới: ");
		int chiSoMoi = congto.nextInt();
		this.setChiSoMoi(chiSoMoi);

		System.out.print("Nhập số công tơ cũ: ");
		int chiSoCu = congto.nextInt();
		this.setChiSoCu(chiSoCu);

		float soTienPhaiTra = ((chiSoMoi - chiSoCu) * 750);
		this.setSoTienPhaiTra(soTienPhaiTra);
	}

	public void xuatbienlai() {
		super.xuat();
		System.out.print("Số công tơ cũ: " + this.getChiSoCu() + "\n" + "Số công tơ mới: " + this.getChiSoMoi() + "\n" + "Số tiền phải trả: " + this.getSoTienPhaiTra() + "đ");
	}

	public static void main(String[] args) {
		BienLai bl = new BienLai();
		System.out.println("Nhập thông tin biên lai của hộ gia đình: ");
		bl.nhapbienlai();
		System.out.println("Thông tin biên lai của các hộ gia đình: ");
		bl.xuatbienlai();

	}
}
