package QuanLyTienDien.com;

import java.util.ArrayList;
import java.util.Scanner;

public class BienLai extends KhachHang {
	int soCu;
	int soMoi;
	float tienTra;

	public BienLai() {
		super();
	}

	public BienLai(String hoTen, String soNha, int congTo, Scanner myInput, int soCu, int soMoi, float tienTra) {
		super(hoTen, soNha, congTo);
		this.soCu = soCu;
		this.soMoi = soMoi;
		this.tienTra = tienTra;
	}

	public int getSoCu() {
		return soCu;
	}

	public void setSoCu(int soCu) {
		this.soCu = soCu;
	}

	public int getSoMoi() {
		return soMoi;
	}

	public void setSoMoi(int soMoi) {
		this.soMoi = soMoi;
	}

	public float getTienTra() {
		return tienTra;
	}

	public void setTienTra(float tienTra) {
		this.tienTra = tienTra;
	}
	
	public void nhap() {
		super.nhap();
		System.out.print("Nhap so cong to cu: ");
		int soCu = Integer.parseInt(myInput.nextLine());
		this.setSoCu(soCu);
		System.out.print("Nhap so cong to moi: ");
		int soMoi = Integer.parseInt(myInput.nextLine());
		this.setSoMoi(soMoi);
	}
	
	public void tinhTien() {
		float tienDien = (this.getSoMoi() - this.getSoCu()) * 750;
		this.setTienTra(tienDien);
	}
	
	public void xuat() {
		super.xuat();
		System.out.println(" || so Cu: " + this.getSoCu() + " || so Moi: " + this.getSoMoi() + " || so tien tra: " + this.getTienTra());
	}
	
	public static void main(String args[]) {
		Scanner myInput = new Scanner(System.in);
		ArrayList<BienLai> list = new ArrayList<BienLai>();
		for(;;) {
		System.out.println("1. Nhap thong tin");
		System.out.println("2. Xem thong tin");
		System.out.println("3. Tinh so tien");
		System.out.println("0. Thoat");
		System.out.print("Chon chuc nang: ");
		int cn = Integer.parseInt(myInput.nextLine());
			if(cn == 1) {
				BienLai bl = new BienLai();
				bl.nhap();
				list.add(bl);
			} else if (cn == 2) {
				for(int i = 0; i < list.size(); i++) {
					list.get(i).xuat();
				}
			} else if (cn == 3) {
				for(int i = 0; i < list.size(); i++) {
					list.get(i).tinhTien();
				}
			} else if (cn == 0) {
				break;
			}
		}
	}
}
